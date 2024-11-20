package be.pxl.services.services;

import be.pxl.services.domain.Post;
import be.pxl.services.domain.PostStatus;
import be.pxl.services.domain.dto.PostRequest;
import be.pxl.services.domain.dto.PostResponse;
import be.pxl.services.exceptions.InvalidPostException;
import be.pxl.services.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        if (postRequest.getTitle().isEmpty() || postRequest.getContent().isEmpty() || postRequest.getAuthor().isEmpty()) {
            throw new InvalidPostException("All fields must be filled in");
        }

        Post post = convertPostRequestToPost(postRequest);
        postRepository.save(post);
        return convertPostToPostResponse(post);
    }


    //method to go from postRequest to Post
    private Post convertPostRequestToPost(PostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setAuthor(postRequest.getAuthor());
        post.setStatus(PostStatus.DRAFT);
        post.setCreationDate(LocalDateTime.now());
        post.setUpdateDate(LocalDateTime.now());
        return post;

    }

    private PostResponse convertPostToPostResponse(Post post) {
        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .creationDate(post.getCreationDate())
                .updateDate(post.getUpdateDate())
                .status(post.getStatus())
                .build();
    }

}
