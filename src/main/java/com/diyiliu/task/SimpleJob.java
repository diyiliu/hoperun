package com.diyiliu.task;

import com.diyiliu.task.base.BaseJob;

/**
 * Description: SimpleJob
 * Author: DIYILIU
 * Update: 2015-12-28 9:49
 */
public class SimpleJob extends BaseJob {

    @Override
    public void execute() {
        logger.info("SimpleJob execute ...");
    }
}
