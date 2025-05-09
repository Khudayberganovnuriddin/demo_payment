package uz.demo.task_hayot.enums;

/**
 * @author Khudayberganov Nuriddin
 * @since : 06/05/25 / 11:27
 */
public enum UserStatus {

  ACTIVE,
  INACTIVE,
  ARCHIVED,
  DISABLED;

  public static UserStatus getStatus(String value) {
    for (UserStatus commonStatus : values()) {
      if (commonStatus.name().equals(value)) {
        return commonStatus;
      }
    }
    return null;
  }

  public boolean isActive() {
    return this.equals(ACTIVE);
  }

}
