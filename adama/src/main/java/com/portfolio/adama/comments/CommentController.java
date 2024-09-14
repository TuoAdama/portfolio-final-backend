package com.portfolio.adama.comments;

import com.portfolio.adama.requests.CommentRequest;
import com.portfolio.adama.responses.CommentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @PostMapping
    public @ResponseBody ResponseEntity<CommentResponse> create(@RequestBody CommentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
