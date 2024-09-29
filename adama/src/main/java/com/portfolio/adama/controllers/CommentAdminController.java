package com.portfolio.adama.controllers;

import com.portfolio.adama.responses.CommentResponse;
import com.portfolio.adama.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/comments")
@RestController
@RequiredArgsConstructor
public class CommentAdminController {

    private final CommentService commentService;

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
