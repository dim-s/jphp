package org.develnext.jphp.ext.compress;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.arj.ArjArchiveEntry;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.develnext.jphp.ext.compress.classes.PArchiveEntry;
import org.develnext.jphp.ext.compress.classes.PArchiveInputStream;
import org.develnext.jphp.ext.compress.classes.PArchiveOutputStream;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class CompressExtension extends Extension {
    public static final String NS = "php\\compress";

    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }

    @Override
    public void onRegister(CompileScope scope) {
        registerWrapperClass(scope, ArchiveEntry.class, PArchiveEntry.class);
        registerWrapperClass(scope, ZipArchiveEntry.class, PArchiveEntry.class);
        registerWrapperClass(scope, TarArchiveEntry.class, PArchiveEntry.class);
        registerWrapperClass(scope, JarArchiveEntry.class, PArchiveEntry.class);
        registerWrapperClass(scope, SevenZArchiveEntry.class, PArchiveEntry.class);
        registerWrapperClass(scope, DumpArchiveEntry.class, PArchiveEntry.class);
        registerWrapperClass(scope, ArArchiveEntry.class, PArchiveEntry.class);
        registerWrapperClass(scope, ArjArchiveEntry.class, PArchiveEntry.class);

        registerClass(scope, PArchiveInputStream.class);
        registerClass(scope, PArchiveOutputStream.class);
    }
}
