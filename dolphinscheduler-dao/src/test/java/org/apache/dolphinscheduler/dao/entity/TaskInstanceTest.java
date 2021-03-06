/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dolphinscheduler.dao.entity;

import org.apache.dolphinscheduler.common.model.TaskNode;
import org.apache.dolphinscheduler.common.utils.JSONUtils;

import org.junit.Assert;
import org.junit.Test;

public class TaskInstanceTest {

    /**
     * task instance sub process
     */
    @Test
    public void testTaskInstanceIsSubProcess() {
        TaskInstance taskInstance = new TaskInstance();

        //sub process
        taskInstance.setTaskType("SUB_PROCESS");
        Assert.assertTrue(taskInstance.isSubProcess());

        //not sub process
        taskInstance.setTaskType("HTTP");
        Assert.assertFalse(taskInstance.isSubProcess());

        //sub process
        taskInstance.setTaskType("CONDITIONS");
        Assert.assertTrue(taskInstance.isConditionsTask());

        //sub process
        taskInstance.setTaskType("DEPENDENT");
        Assert.assertTrue(taskInstance.isDependTask());
    }

    /**
     * test for TaskInstance.getDependence
     */
    @Test
    public void testTaskInstanceGetDependence() {
        TaskInstance taskInstance;
        TaskNode taskNode;

        taskInstance = new TaskInstance();
        taskInstance.setTaskJson(null);
        Assert.assertNull(taskInstance.getDependency());

        taskInstance = new TaskInstance();
        taskNode = new TaskNode();
        taskNode.setDependence(null);
        taskInstance.setTaskJson(JSONUtils.toJsonString(taskNode));
        Assert.assertNull(taskInstance.getDependency());

        taskInstance = new TaskInstance();
        taskNode = new TaskNode();
        // expect a JSON here, and will be unwrap when toJsonString
        taskNode.setDependence("\"A\"");
        taskInstance.setTaskJson(JSONUtils.toJsonString(taskNode));
        Assert.assertEquals("A", taskInstance.getDependency());

        taskInstance = new TaskInstance();
        taskInstance.setTaskJson(null);
        taskInstance.setDependency("{}");
        Assert.assertEquals("{}", taskInstance.getDependency());
    }
}
