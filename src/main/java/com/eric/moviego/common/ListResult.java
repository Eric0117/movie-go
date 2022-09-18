package com.eric.moviego.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 15.
 **/
@Getter
@Setter
public class ListResult<T> extends CommonResult {
    private List<T> list;
}
