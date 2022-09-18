package com.eric.moviego.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 15.
 **/
@Getter
@Setter
public class SingleResult<T> extends CommonResult {
    private T data;
}