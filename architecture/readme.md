## Architecture
![Alt text](https://github.com/pxlit-projects/project-ZidaneBoutaynioutPXL/blob/main/architecture/Archi.drawio.png "a title")

## Communication

# Sync (OpenFeign)
1. PostService en ReviewService
  -  Wanneer een redacteur een post wil laten goedkeuren, stuurt de PostService een verzoek naar de ReviewService
  -  De ReviewService bekijkt de post en stuurt een antwoord terug of de post is goedgekeurd of afgewezen
2.  CommentService en PostService
  -  De postservice moet de comments halen bij de comment service voor een bepaalde post
  -  CommentService checkt bij PostService of de post met het postId bestaat en gepubliceerd is

# Async (RabbitMq)
1.  PostService en ReviewService
  - Wanneer een post wordt goedgekeurd of afgewezen, sturen we via de messaging bus een event door met de status naar de postservice 
