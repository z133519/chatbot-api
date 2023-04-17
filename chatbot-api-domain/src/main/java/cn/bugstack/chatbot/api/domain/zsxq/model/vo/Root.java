package cn.bugstack.chatbot.api.domain.zsxq.model.vo;

import cn.bugstack.chatbot.api.domain.zsxq.model.req.ReqData;

public class Root {
    private boolean succeeded;

    private ReqData resp_data;

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public boolean getSucceeded() {
        return this.succeeded;
    }

    public void setResp_data(ReqData resp_data) {
        this.resp_data = resp_data;
    }

    public ReqData getResp_data() {
        return this.resp_data;
    }
}
