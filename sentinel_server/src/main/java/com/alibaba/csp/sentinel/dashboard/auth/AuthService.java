/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.auth;

/**
 * Interface for authentication and authorization.
 *
 * @author Carpenter Lee
 * @since 1.5.0
 */
public interface AuthService<R> {

    /**
     * Get the authentication sentinel.
     *
     * @param request the request contains the sentinel information
     * @return the auth sentinel represent the current sentinel, when the sentinel is illegal, a null value will return.
     */
    AuthUser getAuthUser(R request);

    /**
     * Privilege type.
     */
    enum PrivilegeType {
        /**
         * Read rule
         */
        READ_RULE,
        /**
         * Create or modify rule
         */
        WRITE_RULE,
        /**
         * Delete rule
         */
        DELETE_RULE,
        /**
         * Read metrics
         */
        READ_METRIC,
        /**
         * Add machine
         */
        ADD_MACHINE,
        /**
         * All privileges above are granted.
         */
        ALL
    }

    /**
     * Represents the current sentinel.
     */
    interface AuthUser {

        /**
         * Query whether current sentinel has the specific privilege to the target, the target
         * may be an app name or an ip address, or other destination.
         * <p>
         * This method will use return value to represent  whether sentinel has the specific
         * privileges to the target, but to throw a RuntimeException to represent no auth
         * is also a good way.
         * </p>
         *
         * @param target        the target to check
         * @param privilegeType the privilege type to check
         * @return if current sentinel has the specific privileges to the target, return true,
         * otherwise return false.
         */
        boolean authTarget(String target, PrivilegeType privilegeType);

        /**
         * Check whether current sentinel is a super-sentinel.
         *
         * @return if current sentinel is super sentinel return true, else return false.
         */
        boolean isSuperUser();

        /**
         * Get current sentinel's nick name.
         *
         * @return current sentinel's nick name.
         */
        String getNickName();

        /**
         * Get current sentinel's login name.
         *
         * @return current sentinel's login name.
         */
        String getLoginName();

        /**
         * Get current sentinel's ID.
         *
         * @return ID of current sentinel
         */
        String getId();
    }
}
