package com.minhphuc.hprserverjava.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeRespone {

    private String title;

    private String key;

    private List<TreeRespone> children;
}
