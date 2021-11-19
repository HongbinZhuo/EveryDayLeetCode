package scrm;

public class RecieveExample {
     #region 将POST过来的数据转化成实体对象

    /// <summary>
    /// 将微信POST过来的数据转化成实体对象
    /// </summary>
    /// <param name="token"></param>
    /// <returns></returns>
    public static ReceiveMessageBase ConvertMsgToObject(string msgBody = "")
    {

        if (string.IsNullOrWhiteSpace(msgBody))
        {
            Stream s = System.Web.HttpContext.Current.Request.InputStream;
            byte[] b = new byte[s.Length];
            s.Read(b, 0, (int)s.Length);
            msgBody = Encoding.UTF8.GetString(b);
        }
        string CorpToken = AppIdInfo.GetToken();
        string corpId = AppIdInfo.GetCorpId();
        string encodingAESKey = AppIdInfo.GetEncodingAESKey();
        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(CorpToken, encodingAESKey, corpId);
        string msg_signature = HttpContext.Current.Request.QueryString["msg_signature"];
        string timestamp = HttpContext.Current.Request.QueryString["timestamp"];
        string nonce = HttpContext.Current.Request.QueryString["nonce"];
        string sMsg = "";  // 解析之后的明文
        int flag = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, msgBody, ref sMsg);
        if (flag == 0)
        {
            msgBody = sMsg;
            LogInfo.Info("解密后的消息为" + sMsg);
        }
        else
        {
            LogInfo.Error("解密消息失败！flag=" + flag);
        }
        if (string.IsNullOrWhiteSpace(msgBody))
        {
            return null;
        }
        XmlDocument doc = null;
        MsgType msgType = MsgType.UnKnown;
        EventType eventType = EventType.UnKnown;
        ReceiveMessageBase msg = new ReceiveMessageBase();
        msg.MsgType = msgType;
        msg.MessageBody = msgBody;
        XmlNode node = null;
        XmlNode tmpNode = null;
        try
        {

            doc = new XmlDocument();
            doc.LoadXml(msgBody);//解密后才是需要处理的XML数据，读取XML字符串
            XmlElement rootElement = doc.DocumentElement;
            XmlNode msgTypeNode = rootElement.SelectSingleNode("MsgType");//获取字符串中的消息类型

            node = rootElement.SelectSingleNode("FromUserName");
            if (node != null)
            {
                msg.FromUserName = node.InnerText;
            }
            node = rootElement.SelectSingleNode("AgentID");
            if (node != null)
            {
                msg.AgentID = Convert.ToInt32(node.InnerText);
            }
            node = rootElement.SelectSingleNode("ToUserName");
            if (node != null)
            {
                msg.ToUserName = node.InnerText;
            }
            node = rootElement.SelectSingleNode("CreateTime");
            if (node != null)
            {
                msg.CreateTime = Convert.ToInt64(node.InnerText);
            }

                #region 获取具体的消息对象

            string strMsgType = msgTypeNode.InnerText;
            string msgId = string.Empty;
            string content = string.Empty;

            tmpNode = rootElement.SelectSingleNode("MsgId");
            if (tmpNode != null)
            {
                msgId = tmpNode.InnerText.Trim();
            }
            string strMsgType2 = strMsgType.Trim().ToLower();
            switch (strMsgType2)
            {
                case "text"://接收普通消息 text消息
                    msgType = MsgType.Text;

                    tmpNode = rootElement.SelectSingleNode("Content");
                    if (tmpNode != null)
                    {
                        content = tmpNode.InnerText.Trim();
                    }
                    TextReceiveMessage txtMsg = new TextReceiveMessage(msg)
                    {
                        MsgType = msgType,
                        MsgId = Convert.ToInt64(msgId),
                        Content = content
                    };
                    txtMsg.AfterRead();
                    return txtMsg;
                case "image"://接收普通消息 image消息
                    msgType = MsgType.Image;
                    ImageReceiveMessage imgMsg = new ImageReceiveMessage(msg)
                    {
                        MsgId = Convert.ToInt64(msgId),
                        MsgType = msgType,
                        MediaId = rootElement.SelectSingleNode("MediaId").InnerText,
                        PicUrl = rootElement.SelectSingleNode("PicUrl").InnerText
                    };
                    imgMsg.AfterRead();
                    return imgMsg;
                case "voice"://接收普通消息 voice消息
                    msgType = MsgType.Voice;
                    XmlNode node1 = rootElement.SelectSingleNode("Recognition");
                    if (node1 != null)
                    {
                        msgType = MsgType.VoiceResult;
                    }

                    VoiceReceiveMessage voiceMsg = new VoiceReceiveMessage(msg)
                    {
                        MsgId = Convert.ToInt64(msgId),
                        MsgType = msgType,
                        Recognition = node1 == null ? string.Empty : node1.InnerText.Trim(),
                        Format = rootElement.SelectSingleNode("Format").InnerText,
                        MediaId = rootElement.SelectSingleNode("MediaId").InnerText
                    };
                    voiceMsg.AfterRead();
                    return voiceMsg;

                case "video"://接收普通消息 video消息
                    msgType = MsgType.Video;

                    VideoReceiveMessage videoMsg = new VideoReceiveMessage(msg)
                    {
                        MediaId = rootElement.SelectSingleNode("MediaId").InnerText,
                        MsgId = Convert.ToInt64(msgId),
                        MsgType = msgType,
                        ThumbMediaId = rootElement.SelectSingleNode("ThumbMediaId").InnerText
                    };
                    videoMsg.AfterRead();
                    return videoMsg;
                case "location"://接收普通消息 location消息
                    msgType = MsgType.Location;

                    LocationReceiveMessage locationMsg = new LocationReceiveMessage(msg)
                    {

                        MsgId = Convert.ToInt64(msgId),
                        MsgType = msgType,
                        Label = rootElement.SelectSingleNode("Label").InnerText,
                        Location_X = rootElement.SelectSingleNode("Location_X").InnerText,
                        Location_Y = rootElement.SelectSingleNode("Location_Y ").InnerText,
                        Scale = rootElement.SelectSingleNode("Scale").InnerText
                    };
                    locationMsg.AfterRead();
                    return locationMsg;
                case "event":// 接收事件
                    msgType = MsgType.Event;
                    eventType = EventType.UnKnown;
                    msg.MsgType = msgType;

                    XmlNode eventNode = rootElement.SelectSingleNode("Event");
                    if (eventNode != null)
                    {
                        string eventtype = eventNode.InnerText.Trim().ToLower();
                        switch (eventtype)
                        {
                            case "subscribe": //接收事件 成员关注
                                eventType = EventType.Subscribe;

                                SubscribeEventMessage subEvt = new SubscribeEventMessage(msg)
                                {

                                    EventType = EventType.Subscribe,
                                    MsgType = msgType,
                                };
                                subEvt.AfterRead();
                                return subEvt;
                            case "unsubscribe": //接收事件 取消关注事件
                                eventType = EventType.UnSubscribe;
                                UnSubscribeEventMessage unSubEvt = new UnSubscribeEventMessage(msg)
                                {

                                    EventType = eventType,
                                    MsgType = msgType,
                                };
                                unSubEvt.AfterRead();
                                return unSubEvt;
                            case "location"://接收事件 上报地理位置事件
                                eventType = EventType.Location;
                                UploadLocationEventMessage locationEvt = new UploadLocationEventMessage(msg)
                                {
                                    EventType = eventType,
                                    Latitude = rootElement.SelectSingleNode("Latitude").InnerText,
                                    Longitude = rootElement.SelectSingleNode("Longitude").InnerText,
                                    MsgType = msgType,
                                    Precision = rootElement.SelectSingleNode("Precision").InnerText,

                                };
                                locationEvt.AfterRead();
                                return locationEvt;
                            case "click": //接收事件 上报菜单事件 点击菜单拉取消息的事件推送
                                eventType = EventType.Click;

                                MenuEventMessage menuEvt = new MenuEventMessage(msg)
                                {

                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    EventType = eventType,
                                    MsgType = msgType,

                                };
                                menuEvt.AfterRead();
                                return menuEvt;
                            case "view": //接收事件 上报菜单事件 点击菜单跳转链接的事件推送
                                eventType = EventType.VIEW;

                                MenuEventVIEWEventMessage menuVIEWEvt = new MenuEventVIEWEventMessage(msg)
                                {

                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    EventType = eventType,
                                    MsgType = msgType,
                                };
                                menuVIEWEvt.AfterRead();
                                return menuVIEWEvt;
                            case "scancode_push"://接收事件 上报菜单事件 扫码推事件的事件推送
                                eventType = EventType.scancode_push;

                                ScanCodePushEventMessage scanCodePushEventMessage = new ScanCodePushEventMessage(msg)
                                {
                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    EventType = eventType,
                                    MsgType = msgType,
                                    ScanCodeInfo = new ScanCodeInfo(rootElement.SelectSingleNode("ScanCodeInfo"))
                                };
                                scanCodePushEventMessage.AfterRead();
                                return scanCodePushEventMessage;
                            case "scancode_waitmsg"://接收事件 上报菜单事件 扫码推事件且弹出“消息接收中”提示框的事件推送
                                eventType = EventType.scancode_waitmsg;

                                ScanCodeWaitMsgEventMessage scanCodeWaitMsgEventMessage = new ScanCodeWaitMsgEventMessage(msg)
                                {
                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    EventType = eventType,
                                    MsgType = msgType,
                                    ScanCodeInfo = new ScanCodeInfo(rootElement.SelectSingleNode("ScanCodeInfo"))
                                };
                                scanCodeWaitMsgEventMessage.AfterRead();
                                return scanCodeWaitMsgEventMessage;
                            case "pic_sysphoto"://接收事件 上报菜单事件 弹出系统拍照发图的事件推送
                                eventType = EventType.pic_sysphoto;

                                PicSysPhotoEventMessage picSysPhotoEventMessage = new PicSysPhotoEventMessage(msg)
                                {
                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    MsgType = msgType,
                                    SendPicsInfo = new SendPicsInfo(rootElement.SelectSingleNode("SendPicsInfo"))
                                };

                                picSysPhotoEventMessage.AfterRead();
                                return picSysPhotoEventMessage;
                            case "pic_photo_or_album"://接收事件 上报菜单事件 弹出拍照或者相册发图的事件推送
                                eventType = EventType.pic_photo_or_album;

                                PicPhotoOrAlbumEventMessage picPhotoOrAlbumEventMessage = new PicPhotoOrAlbumEventMessage(msg)
                                {
                                    EventType = eventType,
                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    MsgType = msgType,
                                    SendPicsInfo = new SendPicsInfo(rootElement.SelectSingleNode("SendPicsInfo"))
                                };
                                picPhotoOrAlbumEventMessage.AfterRead();
                                return picPhotoOrAlbumEventMessage;
                            case "pic_weixin"://接收事件 上报菜单事件 弹出微信相册发图器的事件推送
                                eventType = EventType.pic_weixin;

                                PicWeiXinEventMessage picWeiXinEventMessage = new PicWeiXinEventMessage(msg)
                                {
                                    EventType = eventType,
                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    MsgType = msgType,
                                    SendPicsInfo = new SendPicsInfo(rootElement.SelectSingleNode("SendPicsInfo"))
                                };
                                picWeiXinEventMessage.AfterRead();
                                return picWeiXinEventMessage;
                            case "location_select"://接收事件 上报菜单事件 弹出地理位置选择器的事件推送
                                eventType = EventType.location_select;

                                LocationSelectEventMessage locationSelectEventMessage = new LocationSelectEventMessage(msg)
                                {
                                    EventType = eventType,
                                    EventKey = rootElement.SelectSingleNode("EventKey").InnerText,
                                    MsgType = msgType,
                                    SendLocationInfo = new SendLocationInfo(rootElement.SelectSingleNode("SendLocationInfo"))
                                };
                                locationSelectEventMessage.AfterRead();
                                return locationSelectEventMessage;
                            case "enter_agent": //接收事件 成员进入应用的事件推送
                                eventType = EventType.enter_agent;
                                EnterAgentEventMessage EnterAgentEventMessage = new EnterAgentEventMessage(msg)
                                {
                                    MsgType = msgType,
                                };
                                EnterAgentEventMessage.AfterRead();
                                return EnterAgentEventMessage;
                            default:
                                LogInfo.Error("事件类型" + eventtype + "未处理");
                                break;

                        }
                    }

                    break;
                default:
                    LogInfo.Error("消息类型" + strMsgType2 + "未处理");
                    break;
            }
            msg.MsgType = msgType;
                #endregion
        }
        catch (Exception ex)
        {
            LogInfo.Error("处理消息异常:" + msgBody, ex);
        }
        finally
        {
            if (doc != null)
            {
                doc = null;
            }
        }

        msg.MsgType = msgType;
        return msg;
    }
}
