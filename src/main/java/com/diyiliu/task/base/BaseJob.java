package com.diyiliu.task.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: BaseJob
 * Author: DIYILIU
 * Update: 2015-12-28 9:51
 */
public abstract class BaseJob {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract void execute();
}
