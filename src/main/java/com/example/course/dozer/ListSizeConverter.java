package com.example.course.dozer;

import java.util.Collection;

import org.dozer.DozerConverter;

@SuppressWarnings("all")
public class ListSizeConverter<T> extends DozerConverter<Collection, Integer> {

	public ListSizeConverter() {
		super(Collection.class, Integer.class);
	}

	@Override
	public Integer convertTo(Collection source, Integer destination) {
		if (source != null) {
			return source.size();
		} else {
			return 0;
		}
	}

	@Override
	public Collection convertFrom(Integer source, Collection destination) {
		throw new IllegalStateException("Unknown value!");
	}

}