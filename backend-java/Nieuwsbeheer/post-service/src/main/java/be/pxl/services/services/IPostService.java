package be.pxl.services.services;

import be.pxl.services.domain.dto.PostRequest;
import be.pxl.services.domain.dto.PostResponse;

public interface IPostService {

    //create post
    PostResponse createPost(PostRequest postRequest);

}
