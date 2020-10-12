/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.start.site.extension.dependency.springsession;

import io.spring.initializr.generator.buildsystem.Build;
import io.spring.initializr.generator.buildsystem.DependencyContainer;
import io.spring.initializr.generator.buildsystem.DependencyScope;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.spring.build.BuildCustomizer;
import io.spring.initializr.generator.version.VersionParser;
import io.spring.initializr.generator.version.VersionRange;

/**
 * {@link BuildCustomizer} for Spring Session that provides explicit handling for the
 * modules introduced in Spring Session 2.
 *
 * @author Stephane Nicoll
 * @author Madhura Bhave
 */
public class SpringSessionBuildCustomizer implements BuildCustomizer<Build> {

	private static final VersionRange SPRING_BOOT_2_0_0_M3_OR_LATER = VersionParser.DEFAULT.parseRange("2.0.0.M3");

	private final ProjectDescription description;

	public SpringSessionBuildCustomizer(ProjectDescription description) {
		this.description = description;
	}

	@Override
	public void customize(Build build) {
		DependencyContainer dependencies = build.dependencies();
		if (SPRING_BOOT_2_0_0_M3_OR_LATER.match(this.description.getPlatformVersion())) {
			if (dependencies.has("data-redis") || dependencies.has("data-redis-reactive")) {
				dependencies.add("session-data-redis", "org.springframework.session", "spring-session-data-redis",
						DependencyScope.COMPILE);
				dependencies.remove("session");
			}
			if (dependencies.has("jdbc")) {
				dependencies.add("session-jdbc", "org.springframework.session", "spring-session-jdbc",
						DependencyScope.COMPILE);
				dependencies.remove("session");
			}
		}
	}

}
