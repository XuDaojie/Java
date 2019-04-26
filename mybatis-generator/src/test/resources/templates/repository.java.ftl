package ${cfg.packageName}.data;

import io.github.xudaojie.templates.generator.BaseRepository;
import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public class ${entity}Repository extends BaseRepository<${table.mapperName}, ${entity}> implements ${entity}DataSource {
}
