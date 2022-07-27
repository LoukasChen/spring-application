package com.csp.application.consts;

/**
 * Created by fh36575 on 2018/1/12.
 */
public interface Constants {


    interface CharSets {
        String UTF_8 = "UTF-8";
    }

    interface Base {
        String functionCode = "functionCode";
        String signature = "signature";
        String memberId = "memberId";
        String userId = "userId";
    }

    interface ProxyController {
        String param = "param";
        String signVerified = "signVerified";
    }

    interface Cache {
        String lastClick = "jf:data:last:click:productId:%s";
        String lastClick_channelKey = "jf:data:last:click:channelKey:%s";
    }
}
