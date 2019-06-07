package com.airmart.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/comments", produces="application/json" )
public class CommentRestController {
}
