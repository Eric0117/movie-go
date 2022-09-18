package com.eric.moviego.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 15.
 **/
@Getter
@Setter
public class PageResult<T> extends CommonResult {
    private Page<T> list;
}