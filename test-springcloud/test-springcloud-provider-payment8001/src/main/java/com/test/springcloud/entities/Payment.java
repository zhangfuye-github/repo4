package com.test.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@Data //作用相当于@getter @setter @tostring 和有参构造，@equalsandhashcode
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
