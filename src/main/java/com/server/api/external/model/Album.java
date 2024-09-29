package com.server.api.external.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private int userId;
    private int id;
    private String title;
}
