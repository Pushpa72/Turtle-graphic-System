public class FirmVacationpp4 {
    public interface Encryptable {
        void encrypt();
        String decrypt();
    }
    class Secret implements Encryptable {
        private String message;
        private String encrypted = "";
        Secret(String message) {
            this.message = message;
        }
        @Override
        public void encrypt() {
            StringBuilder sb = new StringBuilder();
            for (char ch : message.toCharArray()) {
                sb.append((char) (ch + 3)); // Caesar shift
            }
            encrypted = sb.toString();
            System.out.println("Encrypted (Caesar): " + encrypted);
        }
        @Override
        public String decrypt() {
            StringBuilder sb = new StringBuilder();
            for (char ch : encrypted.toCharArray()) {
                sb.append((char) (ch - 3));
            }
            return sb.toString();
        }
    }


    class Password implements Encryptable {
        private String message;
        private String encrypted = "";
        Password(String message) {
            this.message = message;
        }
        @Override
        public void encrypt() {
            encrypted = new StringBuilder(message).reverse().toString();
            System.out.println("Encrypted (Reverse): " + encrypted);
        }
        @Override
        public String decrypt() {
            return new StringBuilder(encrypted).reverse().toString();
        }
    }


    public static void main(String[] args) {
        FirmVacationpp4 obj = new FirmVacationpp4();

        Encryptable secret = obj.new Secret("PushpaTheGoat");
        secret.encrypt();
        System.out.println("Decrypted (Caesar): " + secret.decrypt());

        Encryptable password = obj.new Password("PushpaTheGoat");
        password.encrypt();
        System.out.println("Decrypted (Reverse): " + password.decrypt());
    }
}
