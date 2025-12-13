package vegabobo.dsusideloader.installer.root

import android.gsi.GsiProgress
import android.os.IBinder
import android.os.ParcelFileDescriptor
import android.os.image.IDynamicSystemService
import vegabobo.dsusideloader.service.PrivilegedProvider

open class DynamicSystemImpl : IDynamicSystemService {
    override fun asBinder(): IBinder? = null

    override fun getInstallationProgress(): GsiProgress = PrivilegedProvider.getService().installationProgress

    override fun abort(): Boolean = PrivilegedProvider.getService().abort()

    override fun isInUse(): Boolean = PrivilegedProvider.getService().isInUse

    override fun isInstalled(): Boolean = PrivilegedProvider.getService().isInstalled

    override fun isEnabled(): Boolean = PrivilegedProvider.getService().isEnabled

    override fun remove(): Boolean = PrivilegedProvider.getService().remove()

    override fun setEnable(
        enable: Boolean,
        oneShot: Boolean,
    ): Boolean = PrivilegedProvider.getService().setEnable(enable, oneShot)

    override fun finishInstallation(): Boolean = PrivilegedProvider.getService().finishInstallation()

    override fun startInstallation(dsuSlot: String): Boolean = PrivilegedProvider.getService().startInstallation(dsuSlot)

    override fun createPartition(
        name: String,
        size: Long,
        readOnly: Boolean,
    ): Int = PrivilegedProvider.getService().createPartition(name, size, readOnly)

    override fun closePartition(): Boolean = PrivilegedProvider.getService().closePartition()

    override fun setAshmem(
        fd: ParcelFileDescriptor,
        size: Long,
    ): Boolean = PrivilegedProvider.getService().setAshmem(fd, size)

    override fun submitFromAshmem(bytes: Long): Boolean = PrivilegedProvider.getService().submitFromAshmem(bytes)

    override fun suggestScratchSize(): Long = PrivilegedProvider.getService().suggestScratchSize()

    fun forceStopDSU() {
        PrivilegedProvider.getService().forceStopPackage("com.android.dynsystem")
    }
}
