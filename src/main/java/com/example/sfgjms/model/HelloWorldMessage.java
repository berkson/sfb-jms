package com.example.sfgjms.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by berkson
 * Date: 06/12/2021
 * Time: 22:19
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HelloWorldMessage implements Serializable {
    static final long serialVersionUID = -2121261813172287520L;
    private UUID id;
    private String message;
}
