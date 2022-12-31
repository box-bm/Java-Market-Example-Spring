package com.reactivesoftware.market.persistance.mapper;

import com.reactivesoftware.market.persistance.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-31T11:41:52-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public com.reactivesoftware.market.domain.Category toCategory(Category category) {
        if ( category == null ) {
            return null;
        }

        com.reactivesoftware.market.domain.Category category1 = new com.reactivesoftware.market.domain.Category();

        if ( category.getIdCategory() != null ) {
            category1.setCategoryId( category.getIdCategory() );
        }
        category1.setCategory( category.getDescription() );
        if ( category.getStatus() != null ) {
            category1.setActive( category.getStatus() );
        }

        return category1;
    }

    @Override
    public Category toCategory(com.reactivesoftware.market.domain.Category category) {
        if ( category == null ) {
            return null;
        }

        Category category1 = new Category();

        category1.setIdCategory( category.getCategoryId() );
        category1.setDescription( category.getCategory() );
        category1.setStatus( category.isActive() );

        return category1;
    }
}
