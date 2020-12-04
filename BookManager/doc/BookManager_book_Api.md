# 1.1图书Api文档

## 1.1管理员

* 查询所有图书

1. 请求路径：/admin/find
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
            "isbn": 987654321,
            "name": "围棋决战",
            "author": "聂卫平",
            "type": "策略",
            "status": true,
            "synopsis": "讲述了聂卫平一生传奇的精彩围棋对决。"
        },
        {
            "id": null,
            "isbn": 789654123,
            "name": "水浒传",
            "author": "施耐庵",
            "type": "小说",
            "status": true,
            "synopsis": "讲述了北宋末年官逼民反的忠义人物故事。"
        }
    ]
}
```



- 录入新图书

1. 请求路径：admin/add
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

​	4.响应数据

```json
{
    "status": 6000,
    "message": "添加图书成功！",
    "data": null
}
```

* 查询某用户的借书信息

1. 请求路径：/admin/findOne/{isbn}
2. 请求方式：post
3. 请求参数

| 参数名 | 参数说明     | 备注     |
| ------ | ------------ | -------- |
| isbn   | 国际图书编号 | 95550001 |

​	4.响应数据

```json
{
    "status": 1000,
    "message": "用户登录成功！",
    "data": [
        {
            "id": 2,
            "isbn": 789654123,
            "name": "水浒传",
            "author": "施耐庵",
            "type": "小说",
            "status": true,
            "synopsis": "讲述了北宋末年官逼民反的忠义人物故事。"
        },
        {
            "id": 3,
            "isbn": 741852963,
            "name": "西游记",
            "author": "吴承恩",
            "type": "小说",
            "status": true,
            "synopsis": "神话小说。"
        },
        {
            "id": 4,
            "isbn": 963852741,
            "name": "三国演义",
            "author": "罗贯中",
            "type": "小说",
            "status": false,
            "synopsis": "三国历史故事改编。"
        },
        {
            "id": 15,
            "isbn": 783641502,
            "name": "人生",
            "author": "路遥",
            "type": "小说",
            "status": true,
            "synopsis": "人生哲理"
        }
    ]
}
```

- 删除图书

1. 请求路径：/admin/delete/{isbn}

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

## 2.1用户

* 查询所有图书

1. 请求路径：/user/find
2. 请求方式：get
3. 请求参数：无
4. 响应数据

```json
{
    "status": 6011,
    "message": "查询成功",
    "data": [
        {
            "id": null,
            "isbn": 987654321,
            "name": "围棋决战",
            "author": "聂卫平",
            "type": "策略",
            "status": true,
            "synopsis": "讲述了聂卫平一生传奇的精彩围棋对决。"
        },
        {
            "id": null,
            "isbn": 789654123,
            "name": "水浒传",
            "author": "施耐庵",
            "type": "小说",
            "status": true,
            "synopsis": "讲述了北宋末年官逼民反的忠义人物故事。"
        }
    ]
}
```

- 查询自己的借书信息

1. 请求路径：/user/findOne/{jobNumber}

2. 请求方式：post

3. 请求参数：

   | 参数名    | 参数说明 | 备注 |
   | --------- | -------- | ---- |
   | jobNumber | 工号     |      |

4. 响应数据

```json
{
    "status": 1000,
    "message": "用户登录成功！",
    "data": [
        {
            "id": 2,
            "isbn": 789654123,
            "name": "水浒传",
            "author": "施耐庵",
            "type": "小说",
            "status": true,
            "synopsis": "讲述了北宋末年官逼民反的忠义人物故事。"
        },
        {
            "id": 3,
            "isbn": 741852963,
            "name": "西游记",
            "author": "吴承恩",
            "type": "小说",
            "status": true,
            "synopsis": "神话小说。"
        },
        {
            "id": 4,
            "isbn": 963852741,
            "name": "三国演义",
            "author": "罗贯中",
            "type": "小说",
            "status": false,
            "synopsis": "三国历史故事改编。"
        },
        {
            "id": 15,
            "isbn": 783641502,
            "name": "人生",
            "author": "路遥",
            "type": "小说",
            "status": true,
            "synopsis": "人生哲理"
        }
    ]
}
```

- 借书功能

1. 请求路径：/user/borrow/{isbn}/{jobNumber}

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

1. 请求路径：/user/return/{}

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



