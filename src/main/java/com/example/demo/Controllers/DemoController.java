package com.example.demo.Controllers;

import com.example.demo.Models.Demodata;
import com.example.demo.Models.DemodataRepository;
import com.example.demo.Models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 标明是controller的bean
@RestController
// 允许跨域访问。前端端口为4200。server端口为1230
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/demo")
public class DemoController {

//  该注释告诉springboot，去帮助实现Repository接口。否则，抛空指针异常。
    @Autowired
    private DemodataRepository demodataRepository;

    //增加数据
    @PostMapping(value = "/newData")
    // Springboot将返回的类，以JSON字符串形式输出。这里使用Message model建立json格式数据
    public Message addNewData(@RequestBody Demodata demodata) {
        Message msg = new Message();
        // save后自动添加id
        demodataRepository.save(demodata);
        msg.setMsg("The info of " + demodata.getName() + " has been added with the ID: " + demodata.getId());;
        return msg;
    }

    // 获取数据
    @GetMapping(value = "/getData")
    // 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
    public Iterable<Demodata> getDemodatas() {
        return demodataRepository.findAll();
    }

    // 删除数据
    @DeleteMapping(value = "/clearData")
    public Message clearDemodatas() {
        demodataRepository.deleteAll();
        Message msg = new Message();
        msg.setMsg("The database has been cleared");
        return msg;
    }
}
