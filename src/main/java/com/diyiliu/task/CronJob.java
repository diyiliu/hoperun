package com.diyiliu.task;

import com.diyiliu.task.base.BaseJob;

/**
 * Description: CronJob
 * Author: DIYILIU
 * Update: 2015-12-28 10:49
 */
public class CronJob extends BaseJob {

    @Override
    public void execute() {

        logger.info("CronJob execute ...");
    }
}
