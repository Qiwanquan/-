import java.util.HashMap;
import java.util.ArrayList;

class PropertyManagementSystem {
    private HashMap<String, Integer> billingInfo;
    private ArrayList<String[]> maintenanceRequests;
    private ArrayList<String[]> announcements;

    public PropertyManagementSystem() {
        this.billingInfo = new HashMap<>();
        this.maintenanceRequests = new ArrayList<>();
        this.announcements = new ArrayList<>();
    }

    public void updateBillingInfo(String userId, int amount) {
        // 更新账单信息
        if (billingInfo.containsKey(userId)) {
            billingInfo.put(userId, billingInfo.get(userId) + amount);
        } else {
            billingInfo.put(userId, amount);
        }
    }

    public String notifyArrears(String userId) {
        // 通知欠款信息
        if (billingInfo.containsKey(userId) && billingInfo.get(userId) > 0) {
            return "Dear resident, you have an outstanding balance of " + billingInfo.get(userId) + ".";
        }
        return null;
    }

    public void submitMaintenanceRequest(String userId, String request) {
        // 提交保修信息
        maintenanceRequests.add(new String[]{userId, request});
    }

    public void processMaintenanceRequest(int requestId, String handlerId) {
        // 处理保修信息
        if (handlerId.equals("property_manager")) {
            // 处理逻辑
        }
    }

    public void submitAnnouncement(String userId, String announcement) {
        // 提交公告申请
        announcements.add(new String[]{userId, announcement});
    }

    public void reviewAnnouncement(int announcementId, boolean isApproved, String rejectionReason) {
        // 审核公告申请
        if (isApproved) {
            // 发布公告逻辑
        } else {
            // 告知发布者不予发布原因
            System.out.println("Announcement rejected. Reason: " + rejectionReason);
        }
    }
}

public class PropertyManagementSystemTest {
    public static void main(String[] args) {
        testPropertyManagementSystem();
    }

    public static void testPropertyManagementSystem() {
        PropertyManagementSystem system = new PropertyManagementSystem();

        // 测试更新账单信息
        system.updateBillingInfo("resident1", 100);
        assert system.getBillingInfo().get("resident1") == 100;

        // 测试通知欠款信息
        String notification = system.notifyArrears("resident1");
        assert notification != null && notification.contains("outstanding balance");

        // 测试提交保修信息
        system.submitMaintenanceRequest("resident1", "Leaky faucet");
        assert system.getMaintenanceRequests().size() == 1;

        // 测试处理保修信息
        system.processMaintenanceRequest(1, "property_manager");
        // 添加额外的处理逻辑检查

        // 测试提交公告申请
        system.submitAnnouncement("resident1", "Community event");
        assert system.getAnnouncements().size() == 1;

        // 测试审核公告申请
        system.reviewAnnouncement(1, true, null);
        // 添加额外的发布公告逻辑检查

        // 测试审核不通过的情况
        system.reviewAnnouncement(2, false, "Inappropriate content");
        // 添加额外的不予发布原因检查
    }
}
