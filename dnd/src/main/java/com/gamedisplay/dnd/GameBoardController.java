package com.gamedisplay.dnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameBoardController {

    @GetMapping("/")
    public String index() {
        return "gameBoard";
    }
}
