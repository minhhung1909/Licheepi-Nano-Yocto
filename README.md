# 🐧 LicheePi Nano Embedded Linux Project (Yocto Based)

Dự án này thực hiện xây dựng một bản phân phối Linux tùy chỉnh cho board **LicheePi Nano (Allwinner F1C100s)** sử dụng công cụ **Yocto Project**.

## Hệ điều hành build
- Ubuntu 20.04 WSL2 (host windows 10)

## Kiến trúc hệ thống
Hệ thống được xây dựng dựa trên 3 thành phần cốt lõi:
1.  **U-Boot:** Khởi tạo DRAM và nạp Kernel từ SD Card.
2.  **Linux Kernel:** Được tùy chỉnh (customized) để hỗ trợ các module GSM/SIM  (chưa test được nhưng đã build thành công).
3.  **RootFS:** Bản build `core-image-minimal`.

## Key

### 1. Tùy chỉnh Kernel cho Module SIM
Trong dự án này, đã thực hiện porting driver cho module SIM thông qua giao thức USB Serial và PPP.

### 2. Yocto Pipeline
* Sử dụng **Layers** để quản lý cấu hình board-specific.
* Sửa đổi **Recipes** bằng cách sử dụng `.bbappend` để không can thiệp vào mã nguồn gốc.

## Build và Flash
1.  **Thiết lập môi trường:** Từ thư mục gốc của project (yocto), chạy lệnh:
    ```bash
    source poky/oe-init-build-env
    ```
2.  **Build Image:** 
    ```bash
    bitbake core-image-minimal
    ```
3.  **Flash thẻ nhớ:**
    ```bash
    sudo dd if=tmp/deploy/images/licheepinano-sdcard/core-image-minimal-licheepinano-sdcard.sunxi-sdimg of=/dev/sdX bs=1M
    ```
hoặc sử dụng phần mềm balenaEtcher để flash file ```core-image-minimal-licheepinano-sdcard.sunxi-sdimg```

## Thông tin đăng nhập mặc định
* **User:** `root`
* **User:** `sheldon`
* **Password:** Không có

Nguồn tham khảo:

[1] https://fanning.vn/study_licheepinano/nano_buildsystem.html

[2] https://github.com/voloviq/meta-licheepinano/tree/kirkstone