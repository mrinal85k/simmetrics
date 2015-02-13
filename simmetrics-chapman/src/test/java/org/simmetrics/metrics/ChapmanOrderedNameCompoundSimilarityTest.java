/*
 * SimMetrics - SimMetrics is a java library of Similarity or Distance Metrics,
 * e.g. Levenshtein Distance, that provide float based similarity measures
 * between String Data. All metrics return consistent measures rather than
 * unbounded similarity scores.
 * 
 * Copyright (C) 2014 SimMetrics authors
 * 
 * This file is part of SimMetrics. This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * SimMetrics. If not, see <http://www.gnu.org/licenses/>.
 */
package org.simmetrics.metrics;

import org.simmetrics.StringMetric;
import org.simmetrics.StringMetricBuilder;
import org.simmetrics.metrics.ChapmanOrderedNameCompoundSimilarity;
import org.simmetrics.tokenizers.WhitespaceTokenizer;

public class ChapmanOrderedNameCompoundSimilarityTest extends StringMetricTest {

	@Override
	protected StringMetric getMetric() {
		return new StringMetricBuilder()
				.with(new ChapmanOrderedNameCompoundSimilarity())
				.tokenize(new WhitespaceTokenizer()).build();
	}

	@Override
	protected T[] getTests() {
		return new T[] { new T(0.9220f, "test string1", "test string2"),
				new T(0.7604f, "aaa bbb ccc ddd", "aaa bbb ccc eee"),
				new T(0.7604f, "a b c d", "a b c e"),
				new T(0.7833f, "Healed", "Sealed"),
				new T(0.4833f, "Healed", "Healthy"),
				new T(0.6800f, "Healed", "Heard"),
				new T(0.2167f, "Healed", "Herded"),
				new T(0.7058f, "Healed", "Help"),
				new T(0.5542f, "Healed", "Sold"),
				new T(0.7058f, "Healed", "Help"),
				new T(0.7463f, "Sam J Chapman", "Samuel John Chapman"),
				new T(0.8104f, "Sam Chapman", "S Chapman"),
				new T(0.4250f, "John Smith", "Samuel John Chapman"),
				new T(0.2000f, "John Smith", "Sam Chapman"),
				new T(0.2688f, "John Smith", "Sam J Chapman"),
				new T(0.0625f, "John Smith", "S Chapman"),

		};
	}
}
