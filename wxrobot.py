# coding=utf-8

import pymongo
import itchat

print "------开始-------"
db = pymongo.MongoClient(host="127.0.0.1", port=27017).test

@itchat.msg_register(itchat.content.TEXT)
def save_msg(msg):
    fromu = itchat.search_friends(userName = msg.get("FromUserName", ""))
    if fromu is not None:
        print(fromu["NickName"])
        print fromu["RemarkName"]
    print(msg["Text"])
    db.Message.save(msg)

def get_frinds():
    print "get friends"
    list = itchat.get_friends(True)
    for fd in list:
        db.Frients.save(fd)

print "开始"
itchat.auto_login()
get_frinds()
itchat.run()
print "开启完成"
