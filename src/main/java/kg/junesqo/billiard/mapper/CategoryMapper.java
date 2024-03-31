package kg.junesqo.billiard.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import kg.junesqo.billiard.domain.Category;
import kg.junesqo.billiard.dto.CategoryDTO;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
