package com.example.note.entity;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note_User {
    private Note note;
    private User user;
}
