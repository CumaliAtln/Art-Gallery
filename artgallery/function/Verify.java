package artgallery.function;


import artgallery.agSystem.UserVerify;

public class Verify {

    UserVerify s = new UserVerify();

    //ç™»å½•æˆ�åŠŸä¸�å�¦çš„éªŒè¯�
    public void verifyRoot(String a, String b) {
        s.verifyRootWithSQL(a, b);
    }

    //å®¢æˆ·ç™»å½•ä¸�å�¦éªŒè¯�
    public void verifyUser(String a, String b) {
        s.verifyUserWithSQL(a, b);
    }

    //æ˜¯å�¦æ³¨å†Œæˆ�åŠŸ
    public void verifyRegister(String a) {
        s.verifyRegisterWithSQL(a);
    }

}