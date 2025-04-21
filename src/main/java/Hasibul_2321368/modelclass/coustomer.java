package Hasibul_2321368.modelclass;

public class coustomer extends user {
    private String customerId;
    private String membershipLevel;
    private boolean isPremiumMember;

    public coustomer() {
        super();
    }

    public coustomer(String customerId, String membershipLevel, boolean isPremiumMember) {
        this.customerId = customerId;
        this.membershipLevel = membershipLevel;
        this.isPremiumMember = isPremiumMember;
    }

    public coustomer(String userId, String name, String email, String password, String phoneNumber, String address, String customerId, String membershipLevel, boolean isPremiumMember) {
        super(userId, name, email, password, phoneNumber, address);
        this.customerId = customerId;
        this.membershipLevel = membershipLevel;
        this.isPremiumMember = isPremiumMember;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        isPremiumMember = premiumMember;
    }

    @Override
    public String toString() {
        return "coustomer{" +
                "customerId='" + customerId + '\'' +
                ", membershipLevel='" + membershipLevel + '\'' +
                ", isPremiumMember=" + isPremiumMember +
                '}';
    }
}
