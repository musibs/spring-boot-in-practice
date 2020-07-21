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

package io.spring.start.site.extension.dependency.springcloud;

import io.spring.initializr.generator.buildsystem.BillOfMaterials;
import io.spring.initializr.generator.buildsystem.Build;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.spring.build.BuildCustomizer;
import io.spring.initializr.generator.version.VersionParser;
import io.spring.initializr.generator.version.VersionRange;
import io.spring.initializr.generator.version.VersionReference;

/**
 * Add the Spring Cloud GCP BOM for older releases now that the project has joined the
 * official release train.
 *
 * @author Stephane Nicoll
 * @author Madhura Bhave
 */
class SpringCloudGcpBomBuildCustomizer implements BuildCustomizer<Build> {

	private static final VersionRange SPRING_BOOT_2_1_OR_LATER = VersionParser.DEFAULT.parseRange("2.1.0.M1");

	private final ProjectDescription description;

	SpringCloudGcpBomBuildCustomizer(ProjectDescription description) {
		this.description = description;
	}

	@Override
	public void customize(Build build) {
		if (!SPRING_BOOT_2_1_OR_LATER.match(this.description.getPlatformVersion())
				&& build.dependencies().ids().anyMatch((id) -> id.startsWith("cloud-gcp"))) {
			build.boms().add("spring-cloud-gcp",
					BillOfMaterials.withCoordinates("org.springframework.cloud", "spring-cloud-gcp-dependencies")
							.version(VersionReference.ofValue("1.0.0.RELEASE")));
		}
	}

}
