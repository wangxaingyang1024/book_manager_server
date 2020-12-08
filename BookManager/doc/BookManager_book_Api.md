# 1.1图书Api文档

## 1.1管理员

* 查询所有图书

1. 请求路径：/api/admin/find
2. 请求参数：无
3. 请求方式：get
4. 响应参数

| 参数名   | 参数说明                 | 备注 |
| -------- | ------------------------ | ---- |
| isbn     | 国际标准书号             |      |
| name     | 图书名称                 |      |
| author   | 作者                     |      |
| type     | 类型                     |      |
| status   | 当前书的状态'0'，'1'归还 |      |
| synopsis | 图书的简介               |      |

​	5.响应数据

```json
{
    "status": 6011,
    "message": "查询成功",
    "data": [
        {
            "id": null,
            "isbn": 741852963,
            "name": "西游记",
            "author": "吴承恩",
            "type": 100,
            "status": true,
            "synopsis": "神话小说。"
        },
        {
            "id": null,
            "isbn": 963852741,
            "name": "三国演义",
            "author": "罗贯中",
            "type": 100,
            "status": false,
            "synopsis": "三国历史故事改编。"
        },
        {
            "id": null,
            "isbn": 513426078,
            "name": "童话故事",
            "author": "安徒生",
            "type": 300,
            "status": true,
            "synopsis": "儿童故事。"
        },
        {
            "id": null,
            "isbn": 783641502,
            "name": "人生",
            "author": "路遥",
            "type": 100,
            "status": true,
            "synopsis": "人生哲理"
        },
        {
            "id": null,
            "isbn": 463012875,
            "name": "明朝那些事",
            "author": "陈塘",
            "type": 100,
            "status": true,
            "synopsis": "介绍了明朝发生的事"
        },
        {
            "id": null,
            "isbn": 105643287,
            "name": "白杨",
            "author": "张天天",
            "type": 100,
            "status": true,
            "synopsis": "白杨·礼赞"
        },
        {
            "id": null,
            "isbn": 501274386,
            "name": "三国演义",
            "author": "罗贯中",
            "type": 100,
            "status": true,
            "synopsis": null
        },
        {
            "id": null,
            "isbn": 340152678,
            "name": "三国演义",
            "author": "罗贯中",
            "type": 100,
            "status": true,
            "synopsis": null
        },
        {
            "id": null,
            "isbn": 841237605,
            "name": "三国演义",
            "author": "罗贯中",
            "type": 100,
            "status": true,
            "synopsis": null
        },
        {
            "id": null,
            "isbn": 263418507,
            "name": "java基础",
            "author": "xxx",
            "type": 200,
            "status": true,
            "synopsis": "学java"
        },
        {
            "id": null,
            "isbn": 301745826,
            "name": "围城11",
            "author": "钱钟书",
            "type": 100,
            "status": true,
            "synopsis": "新儒林外史"
        },
        {
            "id": null,
            "isbn": 185230467,
            "name": "围城11",
            "author": "钱钟书",
            "type": 100,
            "status": true,
            "synopsis": "新儒林外史"
        },
        {
            "id": null,
            "isbn": 718035426,
            "name": "白鹿原",
            "author": "陈忠实",
            "type": 100,
            "status": true,
            "synopsis": "null"
        }
    ]
}	
```



- 录入新图书

1. 请求路径：/api/admin/add
2. 请求方法：post
3. 请求参数

| 参数名   | 参数说明                 | 备注         |
| -------- | ------------------------ | ------------ |
| isbn     | 国际标准书号             | 后台自动生成 |
| name     | 图书名称                 |              |
| author   | 作者                     |              |
| type     | 类型                     |              |
| status   | 当前书的状态'0'，'1'归还 |              |
| synopsis | 图书的简介               |              |

​	4.响应参数

| 参数名 | 参数说明     | 备注                        |
| ------ | ------------ | --------------------------- |
| data   | 成功添加图书 | 成功返回 ‘1’，失败返回 ‘-1’ |

​	5.响应数据

```json
{
    "status": 6000,
    "message": "添加图书成功！",
    "data": 1
}
```

* 查询某用户的借书信息

1. 请求路径：/api/admin/findOne/{isbn}
2. 请求方式：get
3. 请求参数

| 参数名 | 参数说明     | 备注 |
| ------ | ------------ | ---- |
| isbn   | 国际图书编号 |      |

​	4.响应数据

```json
{
    "status": 200,
    "message": "ok",
    "data": [
        {
            "id": 4,
            "isbn": 963852741,
            "name": "三国演义",
            "author": "罗贯中",
            "type": 100,
            "status": false,
            "synopsis": "三国历史故事改编。"
        }
    ]
}
```

- 删除图书

1. 请求路径：/api/admin/delete/{isbn}

2. 请求方式：post

3. 请求参数

   | 参数名 | 参数说明     | 备注 |
   | ------ | ------------ | ---- |
   | isbn   | 国际标准书号 |      |

4. 相应数据

```json
{
    "status": 6002,
    "message": "删除图书成功！",
    "data": null
}
```

- 查看图书类型

1. 请求路径：/api/admin/type

2. 请求方式：get

3. 请求参数：无

4. 响应数据

   ```json
   {
       "status": 200,
       "message": "ok",
       "data": [
           {
               "mid": 10,
               "pid": 1,
               "name": "名著小说",
               "level": 2,
               "children": []
           },
           {
               "mid": 20,
               "pid": 2,
               "name": "国外军事",
               "level": 2,
               "children": []
           },
           {
               "mid": 30,
               "pid": 3,
               "name": "童话小说",
               "level": 2,
               "children": []
           }
       ]
   }
   ```

- 更新图书

1. 请求路径：/api/admin/delete/{isbn}

2. 请求方式：post

3. 请求参数：

   | 参数名 | 参数说明     | 备注 |
   | ------ | ------------ | ---- |
   | isbn   | 国际标准书号 |      |

   ---

   | 参数名   | 参数说明     | 备注 |
   | -------- | ------------ | ---- |
   | isbn     | 国际标准书号 |      |
   | name     | 书名         |      |
   | author   | 作者         |      |
   | type     | 图书类型     |      |
   | status   | 图书借还状态 |      |
   | synopsis | 图书说明     |      |

4. 响应参数

   ```json
   
   ```

   

## 2.1用户

* 用户根据书名查询图书

1. 请求路径：/api/book/find

2. 请求方式：post

3. 请求参数：

   | 参数名 | 参数说明 | 备注 |
   | ------ | -------- | ---- |
   | name   | 书名     |      |

4. 响应数据

```json
{
    "status": 200,
    "message": "ok",
    "data": [
        {
            "id": 3,
            "isbn": 741852963,
            "name": "西游记",
            "author": "吴承恩",
            "type": 100,
            "status": true,
            "synopsis": "神话小说。"
        }
    ]
}
```

- 查询自己的借书信息

1. 请求路径：/api/book/findOne/{jobNumber}

2. 请求方式：get

3. 请求参数：

   | 参数名    | 参数说明 | 备注 |
   | --------- | -------- | ---- |
   | jobNumber | 工号     |      |

4. 响应数据

```json
{
    "status": 200,
    "message": "ok",
    "data": [
        {
            "id": 4,
            "isbn": 963852741,
            "name": "三国演义",
            "author": "罗贯中",
            "type": 1006,
            "status": false,
            "synopsis": "三国历史故事改编。"
        }
    ]
}
```

- 借书功能

1. 请求路径：/api/book/borrow

2. 请求方式：post

3. 请求参数

   | 参数名    | 参数说明     | 备注 |
   | --------- | ------------ | ---- |
   | jobNumber | 工号         |      |
   | isbn      | 国际标准书号 |      |

4. 响应数据

```json
{
    "status": 6006,
    "message": "阅读愉快，请尽快还书哦！",
    "data": null
}
```

- 还书功能

1. 请求路径：/api/book/return

2. 请求方式：post

3. 请求参数

   | 参数名    | 参数说明     | 备注 |
   | --------- | ------------ | ---- |
   | jobNumber | 工号         |      |
   | isbn      | 国际标准书号 |      |

4. 响应数据

```json
{
    "status": 6008,
    "message": "已归还，欢迎下次再来！",
    "data": null
}
```



