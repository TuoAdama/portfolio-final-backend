package com.portfolio.adama.comments;

import com.portfolio.adama.requests.CommentRequest;
import com.portfolio.adama.responses.CommentResponse;
import com.portfolio.adama.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<CommentResponse> create(@RequestBody CommentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.commentService.create(request)
        );
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<CommentResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.commentService.getAll()
        );
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<CommentResponse> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.commentService.getById(id)
        );
    }

}
