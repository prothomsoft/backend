package pl.foto99.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.foto99.backend.model.Comment;
import pl.foto99.backend.model.Post;
import pl.foto99.backend.repository.CommentRepository;
import pl.foto99.backend.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPosts(int page, Sort.Direction sort) {
        return postRepository.findAllPosts(
                PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
    }

    public Post getSinglePost(Long id) {
        return postRepository.findById(id).orElse(null);
    }


    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
        ));
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post editPost(Post post) {
        Post postEdited = postRepository.findById(post.getId()).orElse(new Post());
        postEdited.setTitle(post.getTitle());
        postEdited.setContent(post.getContent());
        return postEdited;
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}

