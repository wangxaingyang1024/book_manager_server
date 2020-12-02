# 1.1登录(普通用户登录没有role字段)

## 1.1.1登录验证接口

- 普通用户请求路径：/api/login
- 管理员请求登录：/api/admin/login
- 请求方法：post
- 请求参数：

| 参数名     | 参数说明 | 备注     |
| ---------- | -------- | -------- |
| `username` | 用户名   | not null |
| `password` | 密码     | not null |

- 响应参数（管理员登录事例）

| 参数名    | 参数说明     | 备注 |
| --------- | ------------ | ---- |
| id        | 用户ID       |      |
| jobNumber | 用户工号     |      |
| username  | 用户名称     |      |
| password  | 用户密码     |      |
| nickName  | 用户昵称     |      |
| gender    | 用户性别     |      |
| phone     | 用户电话     |      |
| age       | 用户年龄     |      |
| role      | 用户角色权限 |      |

- 响应数据

```json
{
    "status": 1000,
    "message": "用户登录成功！",
    "data": {
        "id": 3,
        "jobNumber": 95550003,
        "username": "xiaoyang",
        "password": "6CEE329B44E7A37755C6CEB2C74C0501199E18F0E4D3B1C9B5D8964E",
        "nickName": "张三",
        "gender": 0,
        "phone": "13227739853",
        "age": 22,
        "role": 1
    }
}
```

# 1.2用户注册

## 1.2.1注册验证接口

- 请求路径：/api/signUp
- 请求方法：post
- 请求参数：

| 参数名   | 参数说明 | 备注 |
| -------- | -------- | ---- |
| username | 用户名称 | *    |
| password | 用户密码 | *    |
| nickname | 用户昵称 | *    |
| gender   | 用户性别 | *    |
| phone    | 用户电话 | *    |
| age      | 用户年龄 | *    |

- 响应参数

| 参数名 | 参数说明       | 备注                        |
| ------ | -------------- | --------------------------- |
| data   | 成功注册的数量 | 成功返回 ‘1’，失败返回 ‘-1’ |



- 相应数据

```json
{
    "status": 3024,
    "message": "恭喜你获得新账号，开启你的读书之旅吧∽（^∪^）∽...",
    "data": 1
}
```

# 1.3用户操作

## 1.3.1所有用户列表（管理员）

- 请求路径：/api/admin/emps
- 请求方法：get
- 响应数据

```json
{
    "status": 900,
    "message": "ok",
    "data": [
        {
            "jobNumber": 95550001,
            "username": "wxy",
            "nickName": "王向阳",
            "gender": 1,
            "phone": "13227730803",
            "age": 25,
            "role": 2
        },
        {
            "jobNumber": 15645613,
            "username": "xiaohei",
            "nickName": "小黑",
            "gender": 1,
            "phone": "15689854587",
            "age": 20,
            "role": 1
        }
    ]
}
```

## 1.3.2删除指定用户（管理员）

- 请求路径：/api/admin/remove/{jobNumber}
- 请求方法：post
- 响应数据

```json
#删除成功信息
{
    "status": 3033,
    "message": "删除成功！",
    "data": 95550003
}
#删除失败信息
{
    "status": 3031,
    "message": "用户不存在！",
    "data": -1
}
```

## 1.3.3修改密码（所有用户(包括管理员)）

- 请求路径：/api/changePsw
- 请求方法：post
- 请求参数

| 参数名   | 参数说明     | 备注 |
| -------- | ------------ | ---- |
| username | 用户名       | *    |
| oldPsw   | 原使用户密码 | *    |
| newPsw   | 新用户密码   | *    |



- 响应数据

```json
#当修改的用户名不存在时
{
    "status": 3022,
    "message": "原始密码或用户名错误，请重新输入...",
    "data": null
}
#修改成功
{
    "status": 1002,
    "message": "密码修改成功！",
    "data": null
}
```

# 1.4日志功能

## 1.4.1最新日志信息

- 请求路径：/api/log/newLogs
- 请求方法：get
- 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
|        |          |      |
|        |          |      |



- 响应数据(最多20条)

```json
{
    "status": 900,
    "message": "ok",
    "data": [
        {
            "nickName": "王向阳",
            "jobNumber": 95550001,
            "lendTime": "2020-12-01 08:13:07",
            "bookName": "水浒传",
            "isbn": 789654123,
            "returnTime": "2020-12-02 08:13:15"
        },
        {
            "nickName": "王向阳",
            "jobNumber": 95550001,
            "lendTime": "2020-11-26 02:32:12",
            "bookName": "围棋决战",
            "isbn": 987654321,
            "returnTime": "2020-11-27 02:32:57"
        }
    ]
}
```

## 1.4.2根据时间段查询

- 请求路径：/api/log/admin/logT
- 请求方法：post
- 请求参数

| 参数名称  | 参数说明 | 描述                   |
| --------- | -------- | ---------------------- |
| jobNumber | 用户工号 | **普通用户使用此字段** |
| startTime | 开始时间 |                        |
| endTime   | 截止时间 |                        |





























