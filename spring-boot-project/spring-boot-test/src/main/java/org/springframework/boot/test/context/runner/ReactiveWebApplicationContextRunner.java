/*
 * Copyright 2012-present the original author or authors.
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

package org.springframework.boot.test.context.runner;

import java.util.function.Supplier;

import org.springframework.boot.test.context.assertj.AssertableReactiveWebApplicationContext;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebApplicationContext;

/**
 * An {@link AbstractApplicationContextRunner ApplicationContext runner} for a
 * {@link ConfigurableReactiveWebApplicationContext}.
 * <p>
 * See {@link AbstractApplicationContextRunner} for details.
 *
 * @author Andy Wilkinson
 * @author Stephane Nicoll
 * @author Phillip Webb
 * @since 2.0.0
 */
public final class ReactiveWebApplicationContextRunner extends
		AbstractApplicationContextRunner<ReactiveWebApplicationContextRunner, ConfigurableReactiveWebApplicationContext, AssertableReactiveWebApplicationContext> {

	/**
	 * Create a new {@link ReactiveWebApplicationContextRunner} instance using a
	 * {@link AnnotationConfigReactiveWebApplicationContext} as the underlying source.
	 */
	public ReactiveWebApplicationContextRunner() {
		this(AnnotationConfigReactiveWebApplicationContext::new);
	}

	/**
	 * Create a new {@link ApplicationContextRunner} instance using the specified
	 * {@code contextFactory} as the underlying source.
	 * @param contextFactory a supplier that returns a new instance on each call be added
	 * to the application context proxy
	 * @since 3.4.0
	 */
	public ReactiveWebApplicationContextRunner(Supplier<ConfigurableReactiveWebApplicationContext> contextFactory) {
		super(ReactiveWebApplicationContextRunner::new, contextFactory);
	}

	/**
	 * Create a new {@link ApplicationContextRunner} instance using the specified
	 * {@code contextFactory} as the underlying source.
	 * @param contextFactory a supplier that returns a new instance on each call
	 * @param additionalContextInterfaces any additional application context interfaces to
	 * be added to the application context proxy
	 * @since 3.4.0
	 */
	public ReactiveWebApplicationContextRunner(Supplier<ConfigurableReactiveWebApplicationContext> contextFactory,
			Class<?>... additionalContextInterfaces) {
		super(ReactiveWebApplicationContextRunner::new, contextFactory, additionalContextInterfaces);
	}

	private ReactiveWebApplicationContextRunner(
			RunnerConfiguration<ConfigurableReactiveWebApplicationContext> configuration) {
		super(configuration, ReactiveWebApplicationContextRunner::new);
	}

}
