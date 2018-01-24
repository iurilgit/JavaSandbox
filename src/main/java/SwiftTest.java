import org.apache.commons.io.IOUtils;
import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class SwiftTest {
    public static void main(String[] args) throws IOException {

        System.out.println("debug");
//        // _SD_RESEARCH PROD
//        Account account = new AccountFactory()
//                .setUsername("513cc187c9694d4a9a462318dd27a7c6")
//                .setPassword("4IosG5go30AuzSHGaOkxFXzibeJBN64uYsiFZLt3kql86LavtsGoDk2fjFRHNcjs")
//                .setAuthUrl("https://os-identity.vip.ebayc3.com:5443/v2.0/tokens")       // this would be similar to the following: https://os-identity.vip.ebayc3.com:5443/v2.0/tokens
//                .setTenantId("451317ed501147b7bfa20da2bf1416b1")
//                .setAuthenticationMethod(AuthenticationMethod.KEYSTONE)
//                .setPreferredRegion("lvs01")
//                .createAccount();

//        API Key ID 	ba5f1055a0e24c0396916b3c7656f97f
//        API Key Secret  I1CikPjaJ0c0oQcYCQlP4zlRrS1pGbDiaHbvZ5HNEGE6L4XMlHKenN2NrYRtCs7G
//        Volume	https://os-volume.vip.lvs01.ebayc3.com/v1/6da7ea35684f4016aba1225fe232afec
//        // _SDO_DE PROD
//        Account account = new AccountFactory()
//                .setUsername("ba5f1055a0e24c0396916b3c7656f97f")
//                .setPassword("I1CikPjaJ0c0oQcYCQlP4zlRrS1pGbDiaHbvZ5HNEGE6L4XMlHKenN2NrYRtCs7G")
//                .setAuthUrl("https://os-identity.vip.ebayc3.com:5443/v2.0/tokens")       // this would be similar to the following: https://os-identity.vip.ebayc3.com:5443/v2.0/tokens
//                .setTenantId("6da7ea35684f4016aba1225fe232afec")
//                .setAuthenticationMethod(AuthenticationMethod.KEYSTONE)
//                .setPreferredRegion("lvs01")
//                .createAccount();

//         ruili1
//        Account account = new AccountFactory()
//                .setUsername("cbfa3da92aa94824ab6cfe6fd2e28c77")
//                .setPassword("3f6LzHom40HF3KjFStblkeADVSK8bgzldWY31Ilw8MvuRV2oxki29Zw9MHWMs6cT")
//                .setAuthUrl("https://os-identity.vip.ebayc3.com:5443/v2.0/tokens")       // this would be similar to the following: https://os-identity.vip.ebayc3.com:5443/v2.0/tokens
//                .setTenantId("451972f8e0bc4ce08f4f9b2ed4fcfd85")
//                .setAuthenticationMethod(AuthenticationMethod.KEYSTONE)
//                .setPreferredRegion("lvs01")
//                .createAccount();

        Account account = new AccountFactory()
                .setUsername("SDO_DE")
                .setPassword("password")
                .setAuthUrl("http://os-identity.vip.stratus.phx.qa.ebay.com:5000/v2.0/tokens")       // this would be similar to the following: https://os-identity.vip.ebayc3.com:5443/v2.0/tokens
                .setTenantId("fbcd71a68b684c31bd9481de8317da30")
                .setAuthenticationMethod(AuthenticationMethod.KEYSTONE)
                .setPreferredRegion("RegionNonSSL")
                .createAccount();

//        Account account = new AccountFactory()
//                .setUsername("SD_RESEARCH")
//                .setPassword("password")
//                .setAuthUrl("http://os-identity.vip.stratus.phx.qa.ebay.com:5000/v2.0/tokens")       // this would be similar to the following: https://os-identity.vip.ebayc3.com:5443/v2.0/tokens
//                .setTenantId("b1fb0e6f4574491b973afca720d68c3e")
//                .setAuthenticationMethod(AuthenticationMethod.KEYSTONE)
//                .setPreferredRegion("RegionNonSSL")
//                .createAccount();


        System.out.println("account created");

        Container container = account.getContainer("GlobalAspectValue_test");
        if(container == null || !container.exists()) {
            container.create();
        }
        System.out.println(container);
        container.makePublic();
        container.listDirectory();


/*        for (Container c : account.list()) {
            System.out.println(c.getName());
        }*/

/*        StoredObject object = container.getObject("testFile");
        object.uploadObject(new File("c:\\Temp\\testSwift.txt"));*/

//        Collection<StoredObject> objects = container.list();
//        for (StoredObject currentObject : objects) {
//            System.out.println(currentObject.getBareName());
//
////            System.out.println(currentObject.getPublicURL());
////            System.out.println(currentObject.getPrivateURL());
//        }

//        Collection<DirectoryOrObject> directories = container.listDirectory();
//        for (DirectoryOrObject directory : directories) {
//            System.out.println(directory.getName());
//
////            System.out.println(currentObject.getPublicURL());
////            System.out.println(currentObject.getPrivateURL());
//        }

/*        StoredObject downloadObject = container.getObject("testFile");
        byte[] bytes = downloadObject.downloadObject();
        System.out.println(IOUtils.toString(bytes, "utf-8"));*/
    }
}
