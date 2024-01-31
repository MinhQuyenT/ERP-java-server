package com.minhphuc.hprserverjava.service.pmp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.minhphuc.hprserverjava.domain.pmp.Generation;
import com.minhphuc.hprserverjava.mapper.pmp.GenerationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GenerationService {

    private final GenerationMapper generationMapper;

    public void GenerationCode(String name, String title) {
        Generation generation = new Generation();
        generation.setName(name);
        List<Generation> generationList = generationMapper.selectList(new QueryWrapper<>(generation));
        List<String> names = Arrays.asList(name.split("_"));
        String resultName = "";
        for (String item : names) {
            resultName = resultName + item.substring(0, 1).toUpperCase() + item.substring(1);
        }
        System.out.println(resultName);
        // gen enity
        String header = "package com.minhphuc.hprserverjava.domain." + names.get(0) + ";\n" +
                "\n" +
                "import com.baomidou.mybatisplus.annotation.TableField;\n" +
                "import com.baomidou.mybatisplus.annotation.TableId;\n" +
                "import com.baomidou.mybatisplus.annotation.TableName;\n" +
                "import io.swagger.annotations.ApiModel;\n" +
                "import io.swagger.annotations.ApiModelProperty;\n" +
                "import lombok.Data;\n" +
                "import lombok.RequiredArgsConstructor;\n" +
                "\n" +
                "import java.util.Date;\n" +
                "\n" +
                " /**\n" +
                " * Automatically generate code by Minh Phúc\n" +
                " * @author Minh Phúc\n" +
                " * @date " + new Date() + "\n" +
                " */\n" +
                "@Data\n" +
                "@ApiModel(description=\"\")\n" +
                "@TableName(\"" + name + "\")\n" +
                "@RequiredArgsConstructor\n" +
                "public class " + resultName + " {\n" +
                "";
        String body = "";
        for (Generation item : generationList) {

            List<String> namesColumn = Arrays.asList(item.getColumnName().split("_"));
            String resultNames = "";

            for (String items : namesColumn) {
                resultNames = resultNames + items.substring(0, 1).toUpperCase() + items.substring(1);
            }
            resultNames = resultNames.substring(0, 1).toLowerCase() + resultNames.substring(1);
            String type = "";
            switch (item.getTypeName()) {
                case "varchar":
                    type = "String";
                    break;
                case "nvarchar":
                    type = "String";
                    break;
                case "int":
                    type = "Integer";
                    break;
                case "datetime":
                    type = "Date";
                    break;
                case "date":
                    type = "Date";
                    break;
                default:
                    type = "String";
                    break;
            }
            if(namesColumn.get(namesColumn.size()-1).equals("id")){
                body = body + "\n" +
                        "    @TableId(value = \"" + item.getColumnName() + "\")\n" +
                        "    @ApiModelProperty(value = \"" + item.getComment().trim() + "\")\n" +
                        "    private " + type + " " + resultNames + ";\n";
            }else{
                body = body + "\n" +
                        "    @TableField(value = \"" + item.getColumnName() + "\")\n" +
                        "    @ApiModelProperty(value = \"" + item.getComment().trim() + "\")\n" +
                        "    private " + type + " " + resultNames + ";\n";
            }
        }

        body = body + "\n }";

        // gen mapper

        String mapper = "package com.minhphuc.hprserverjava.mapper." + names.get(0) + ";\n" +
                "\n" +
                "import com.baomidou.mybatisplus.core.mapper.BaseMapper;\n" +
                "import com.minhphuc.hprserverjava.domain." + names.get(0) + "." + resultName + ";\n" +
                "import org.springframework.stereotype.Repository;\n" +
                "\n" +
                " /**\n" +
                " * Automatically generate code by Minh Phúc\n" +
                " * @author Minh Phúc\n" +
                " * @date " + new Date() + "\n" +
                " */\n" +
                "@Repository\n" +
                "public interface " + resultName + "Mapper extends BaseMapper<" + resultName + "> {\n" +
                "}";

        String callName = resultName.substring(0, 1).toLowerCase() + resultName.substring(1);
        String service = "package com.minhphuc.hprserverjava.service." + names.get(0) + ";\n" +
                "\n" +
                "import com.baomidou.mybatisplus.extension.plugins.pagination.Page;\n"+
                "import com.minhphuc.hprserverjava.domain." + names.get(0) + "." + resultName + ";\n" +
                "import com.minhphuc.hprserverjava.mapper." + names.get(0) + "." + resultName + "Mapper;\n" +
                "import com.minhphuc.hprserverjava.util.MessageResult;\n" +
                "import com.minhphuc.hprserverjava.util.PageUtil;\n" +
                "import com.minhphuc.hprserverjava.util.ObjectUtil;\n" +
                "import com.minhphuc.hprserverjava.util.StringUtil;\n" +
                "import lombok.RequiredArgsConstructor;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "\n" +
                " /**\n" +
                " * Automatically generate code by Minh Phúc\n" +
                " * @author Minh Phúc\n" +
                " * @date " + new Date() + "\n" +
                " */\n" +
                "@Service\n" +
                "@RequiredArgsConstructor\n" +
                "public class " + resultName + "Service{\n" +
                "\n" +
                "    private final " + resultName + "Mapper " + callName + "Mapper;\n" +
                "\n" +
                "    public MessageResult getEntity(" + resultName + " " + callName + "){\n" +
                "        return MessageResult.success(" + callName + "Mapper.selectList(ObjectUtil.LikeWrapper(" + callName + ",null)));\n" +
                "    }\n" +
                "\n" +
                "    public MessageResult getEntityPage(PageUtil pageUtil," + resultName + " " + callName + "){\n" +
                "         return MessageResult.success(" + callName + "Mapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(" + callName + ",null)));\n" +
                "    }\n" +
                "    " +
                "    public MessageResult insertEntity(" + resultName + " " + callName + "){\n" +
                "        String id = StringUtil.newID();\n" +
                "        " + callName + "Mapper.insert(" + callName + ");\n" +
                "        return MessageResult.success(id);\n" +
                "    }\n" +
                "\n" +
                "    public MessageResult updateEntity(" + resultName + " " + callName + "){\n" +
                "        return MessageResult.success(" + callName + "Mapper.updateById(" + callName + "));\n" +
                "    }\n" +
                "\n" +
                "    public MessageResult deleteEntity(String id){\n" +
                "        return MessageResult.success(" + callName + "Mapper.deleteById(id));\n" +
                "    }\n" +
                "}\n";


        String controller = "package com.minhphuc.hprserverjava.controller." + names.get(0) + ";\n" +
                "\n" +
                "import com.minhphuc.hprserverjava.domain." + names.get(0) + "." + resultName + ";\n" +
                "import com.minhphuc.hprserverjava.service." + names.get(0) + "." + resultName + "Service;\n" +
                "import com.minhphuc.hprserverjava.util.MessageResult;\n" +
                "import com.minhphuc.hprserverjava.util.PageUtil;\n" +
                "import io.swagger.annotations.Api;\n" +
                "import io.swagger.annotations.ApiOperation;\n" +
                "import lombok.RequiredArgsConstructor;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "\n" +
                " /**\n" +
                " * Automatically generate code by Minh Phúc\n" +
                " * @author Minh Phúc\n" +
                " * @date " + new Date() + "\n" +
                " */\n" +
                "\n" +
                "@Api(tags = \"" + CountFile(names.get(0)).toString() + ". API quản lý " + title + "\")\n" +
                "@RestController\n" +
                "@RequestMapping(\"/api/v1/" + callName + "\")\n" +
                "@RequiredArgsConstructor\n" +
                "public class " + resultName + "Controller {\n" +
                "\n" +
                "    private final " + resultName + "Service " + callName + "Service;\n" +
                "\n" +
                "    @GetMapping(\"\")\n" +
                "    @ApiOperation(\"API trả danh sách " + title + "\")\n" +
                "    private MessageResult get"+resultName+"(" + resultName + " " + callName + "){\n" +
                "        return " + callName + "Service.getEntity(" + callName + ");\n" +
                "    }\n" +
                "\n" +
                "    @GetMapping(\"/page\")" +
                "    @ApiOperation(\"API trả danh sách theo trang " + title + "\")\n" +
                "    private MessageResult get"+resultName+"Page(PageUtil pageUtil," + resultName + " " + callName + "){\n" +
                "        return " + callName + "Service.getEntityPage(pageUtil," + callName + ");\n" +
                "    }\n" +
                "\n" +
                "    @PostMapping(\"\")\n" +
                "    @ApiOperation(\"API thêm " + title + " mới, trả về id\")\n" +
                "    private MessageResult insert"+resultName+"(@RequestBody " + resultName + " " + callName + "){\n" +
                "        return " + callName + "Service.insertEntity(" + callName + ");\n" +
                "    }\n" +
                "\n" +
                "    @PutMapping(\"\")\n" +
                "    @ApiOperation(\"API cập nhật thông tin " + title + "\")\n" +
                "    private MessageResult update"+resultName+"(@RequestBody " + resultName + " " + callName + "){\n" +
                "        return " + callName + "Service.updateEntity(" + callName + ");\n" +
                "    }\n" +
                "\n" +
                "    @DeleteMapping(\"\")\n" +
                "    @ApiOperation(\"API xoá " + title + ", trả về id\")\n" +
                "    private MessageResult delete"+resultName+"(String id){\n" +
                "        return " + callName + "Service.deleteEntity(id);\n" +
                "    }\n" +
                "\n" +
                "}\n";

        createFile(resultName, header + body, "domain/" + names.get(0));
        createFile(resultName + "Mapper", mapper, "mapper/" + names.get(0));
        createFile(resultName + "Service", service, "service/" + names.get(0));
        createFile(resultName + "Controller", controller, "controller/" + names.get(0));
    }

    private void createFile(String fileName, String javaCode, String type) {
        String path = "src/main/java/com/minhphuc/hprserverjava/" + type + "/";
        try {
            FileWriter fileWriter = new FileWriter(path + fileName + ".java");
            fileWriter.write(javaCode);
            fileWriter.close();
            System.out.println("Java file '" + fileName + "' created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer CountFile(String type) {
        String path = "src/main/java/com/minhphuc/hprserverjava/controller/" + type;

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {

            FilenameFilter javaFileFilter = (dir, name) -> name.endsWith(".java");

            String[] javaFiles = directory.list(javaFileFilter);

            int fileCount = javaFiles != null ? javaFiles.length : 0;

            return fileCount + 1;

        } else {
            return 0;
        }
    }
}
