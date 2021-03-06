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
package org.apache.dolphinscheduler.api.service;

import org.apache.dolphinscheduler.api.utils.Result;

/**
 * log service
 */
public interface LoggerService {

    /**
     * view log
     *
     * @param taskInstId task instance id
     * @param skipLineNum skip line number
     * @param limit limit
     * @return log string data
     */
    Result<String> queryLog(int taskInstId, int skipLineNum, int limit);


    /**
     * get log size
     *
     * @param taskInstId task instance id
     * @return log byte array
     */
    byte[] getLogBytes(int taskInstId);

}
