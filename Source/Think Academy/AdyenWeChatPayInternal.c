typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned int    dword;
typedef unsigned long    qword;
typedef unsigned char    uchar;
typedef unsigned int    uint;
typedef unsigned long    ulong;
typedef unsigned long long    ulonglong;
typedef unsigned char    undefined1;
typedef unsigned int    undefined4;
typedef unsigned long    undefined8;
typedef unsigned short    ushort;
typedef unsigned short    word;
typedef qword Implementation;

typedef struct cfstringStruct cfstringStruct, *PcfstringStruct;

struct cfstringStruct {
    qword field0_0x0;
    qword field1_0x8;
    pointer field2_0x10;
    long field3_0x18;
};

typedef struct (anonymous_namespace) (anonymous_namespace), *P(anonymous_namespace);

struct (anonymous_namespace) { // PlaceHolder Class Structure
};

typedef struct AppCommunicateData AppCommunicateData, *PAppCommunicateData;

struct AppCommunicateData { // PlaceHolder Class Structure
};

typedef qword Cache;

typedef ulonglong uint64_t;

typedef struct _opaque_pthread_mutexattr_t _opaque_pthread_mutexattr_t, *P_opaque_pthread_mutexattr_t;

struct _opaque_pthread_mutexattr_t {
    long __sig;
    char __opaque[8];
};

typedef struct _opaque_pthread_mutexattr_t __darwin_pthread_mutexattr_t;

typedef ulong __darwin_size_t;

typedef struct _opaque_pthread_mutex_t _opaque_pthread_mutex_t, *P_opaque_pthread_mutex_t;

typedef struct _opaque_pthread_mutex_t __darwin_pthread_mutex_t;

struct _opaque_pthread_mutex_t {
    long __sig;
    char __opaque[56];
};

typedef ulong uintptr_t;

typedef struct mach_header_64 mach_header_64, *Pmach_header_64;

typedef uint uint32_t;

typedef int integer_t;

typedef integer_t cpu_type_t;

typedef integer_t cpu_subtype_t;

struct mach_header_64 {
    uint32_t magic;
    cpu_type_t cputype;
    cpu_subtype_t cpusubtype;
    uint32_t filetype;
    uint32_t ncmds;
    uint32_t sizeofcmds;
    uint32_t flags;
    uint32_t reserved;
};

typedef __darwin_pthread_mutex_t pthread_mutex_t;

typedef struct method_list_t method_list_t, *Pmethod_list_t;

struct method_list_t {
    dword entsizeAndFlags;
    dword count;
};

typedef struct method_list_t_19_ method_list_t_19_, *Pmethod_list_t_19_;

typedef struct method_t method_t, *Pmethod_t;

struct method_t {
    string *name;
    string *types;
    void *imp;
};

struct method_list_t_19_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
};

typedef struct ivar_list_t_29_ ivar_list_t_29_, *Pivar_list_t_29_;

typedef struct ivar_t ivar_t, *Pivar_t;

struct ivar_t {
    qword *offset;
    string *name;
    string *type;
    dword alignment;
    dword size;
};

struct ivar_list_t_29_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
    struct ivar_t var7;
    struct ivar_t var8;
    struct ivar_t var9;
    struct ivar_t var10;
    struct ivar_t var11;
    struct ivar_t var12;
    struct ivar_t var13;
    struct ivar_t var14;
    struct ivar_t var15;
    struct ivar_t var16;
    struct ivar_t var17;
    struct ivar_t var18;
    struct ivar_t var19;
    struct ivar_t var20;
    struct ivar_t var21;
    struct ivar_t var22;
    struct ivar_t var23;
    struct ivar_t var24;
    struct ivar_t var25;
    struct ivar_t var26;
    struct ivar_t var27;
    struct ivar_t var28;
};

typedef struct objc_property_list_29_ objc_property_list_29_, *Pobjc_property_list_29_;

typedef struct objc_property objc_property, *Pobjc_property;

struct objc_property {
    char *name;
    char *name;
};

struct objc_property_list_29_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
    struct objc_property property7;
    struct objc_property property8;
    struct objc_property property9;
    struct objc_property property10;
    struct objc_property property11;
    struct objc_property property12;
    struct objc_property property13;
    struct objc_property property14;
    struct objc_property property15;
    struct objc_property property16;
    struct objc_property property17;
    struct objc_property property18;
    struct objc_property property19;
    struct objc_property property20;
    struct objc_property property21;
    struct objc_property property22;
    struct objc_property property23;
    struct objc_property property24;
    struct objc_property property25;
    struct objc_property property26;
    struct objc_property property27;
    struct objc_property property28;
};

typedef struct protocol_list_t protocol_list_t, *Pprotocol_list_t;

struct protocol_list_t {
    qword count;
};

typedef struct class_t class_t, *Pclass_t;

typedef struct class_rw_t class_rw_t, *Pclass_rw_t;

typedef struct ivar_list_t ivar_list_t, *Pivar_list_t;

typedef struct objc_property_list objc_property_list, *Pobjc_property_list;

struct class_rw_t {
    qword flags;
    qword instanceStart;
    qword instanceSize;
    char *name;
    struct method_list_t *baseMethods;
    struct protocol_list_t *baseProtocols;
    struct ivar_list_t *ivars;
    qword weakIvarLayout;
    struct objc_property_list *baseProperties;
};

struct ivar_list_t {
    dword entsize;
    dword count;
};

struct objc_property_list {
    dword entsize;
    dword count;
};

struct class_t {
    struct class_t *isa;
    struct class_t *superclass;
    Cache cache;
    Implementation vtable;
    struct class_rw_t *data;
};

typedef struct method_list_t_1_ method_list_t_1_, *Pmethod_list_t_1_;

struct method_list_t_1_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
};

typedef struct objc_property_list_6_ objc_property_list_6_, *Pobjc_property_list_6_;

struct objc_property_list_6_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
};

typedef struct objc_property_list_13_ objc_property_list_13_, *Pobjc_property_list_13_;

struct objc_property_list_13_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
    struct objc_property property7;
    struct objc_property property8;
    struct objc_property property9;
    struct objc_property property10;
    struct objc_property property11;
    struct objc_property property12;
};

typedef struct method_list_t_5_ method_list_t_5_, *Pmethod_list_t_5_;

struct method_list_t_5_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
};

typedef struct objc_property_list_2_ objc_property_list_2_, *Pobjc_property_list_2_;

struct objc_property_list_2_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
};

typedef struct method_list_t_43_ method_list_t_43_, *Pmethod_list_t_43_;

struct method_list_t_43_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
    struct method_t method22;
    struct method_t method23;
    struct method_t method24;
    struct method_t method25;
    struct method_t method26;
    struct method_t method27;
    struct method_t method28;
    struct method_t method29;
    struct method_t method30;
    struct method_t method31;
    struct method_t method32;
    struct method_t method33;
    struct method_t method34;
    struct method_t method35;
    struct method_t method36;
    struct method_t method37;
    struct method_t method38;
    struct method_t method39;
    struct method_t method40;
    struct method_t method41;
    struct method_t method42;
};

typedef struct ivar_list_t_13_ ivar_list_t_13_, *Pivar_list_t_13_;

struct ivar_list_t_13_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
    struct ivar_t var7;
    struct ivar_t var8;
    struct ivar_t var9;
    struct ivar_t var10;
    struct ivar_t var11;
    struct ivar_t var12;
};

typedef struct ivar_list_t_3_ ivar_list_t_3_, *Pivar_list_t_3_;

struct ivar_list_t_3_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
};

typedef struct method_list_t_9_ method_list_t_9_, *Pmethod_list_t_9_;

struct method_list_t_9_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
};

typedef struct method_list_t_11_ method_list_t_11_, *Pmethod_list_t_11_;

struct method_list_t_11_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
};

typedef struct method_list_t_23_ method_list_t_23_, *Pmethod_list_t_23_;

struct method_list_t_23_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
    struct method_t method22;
};

typedef qword ID;

typedef struct ivar_list_t_7_ ivar_list_t_7_, *Pivar_list_t_7_;

struct ivar_list_t_7_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
};

typedef struct method_list_t_63_ method_list_t_63_, *Pmethod_list_t_63_;

struct method_list_t_63_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
    struct method_t method22;
    struct method_t method23;
    struct method_t method24;
    struct method_t method25;
    struct method_t method26;
    struct method_t method27;
    struct method_t method28;
    struct method_t method29;
    struct method_t method30;
    struct method_t method31;
    struct method_t method32;
    struct method_t method33;
    struct method_t method34;
    struct method_t method35;
    struct method_t method36;
    struct method_t method37;
    struct method_t method38;
    struct method_t method39;
    struct method_t method40;
    struct method_t method41;
    struct method_t method42;
    struct method_t method43;
    struct method_t method44;
    struct method_t method45;
    struct method_t method46;
    struct method_t method47;
    struct method_t method48;
    struct method_t method49;
    struct method_t method50;
    struct method_t method51;
    struct method_t method52;
    struct method_t method53;
    struct method_t method54;
    struct method_t method55;
    struct method_t method56;
    struct method_t method57;
    struct method_t method58;
    struct method_t method59;
    struct method_t method60;
    struct method_t method61;
    struct method_t method62;
};

typedef struct method_list_t_14_ method_list_t_14_, *Pmethod_list_t_14_;

struct method_list_t_14_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
};

typedef struct method_list_t_26_ method_list_t_26_, *Pmethod_list_t_26_;

struct method_list_t_26_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
    struct method_t method22;
    struct method_t method23;
    struct method_t method24;
    struct method_t method25;
};

typedef struct protocol_t protocol_t, *Pprotocol_t;

struct protocol_t {
    qword isa;
    string *name;
    struct protocol_list_t *protocols;
    struct method_list_t *instanceMethods;
    struct method_list_t *classMethods;
    struct method_list_t *optionalInstanceMethods;
    struct method_list_t *optionalClassMethods;
    struct objc_property_list *instanceProperties;
    qword unknown0;
    qword unknown1;
};

typedef struct objc_property_list_10_ objc_property_list_10_, *Pobjc_property_list_10_;

struct objc_property_list_10_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
    struct objc_property property7;
    struct objc_property property8;
    struct objc_property property9;
};

typedef struct objc_property_list_7_ objc_property_list_7_, *Pobjc_property_list_7_;

struct objc_property_list_7_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
};

typedef struct objc_property_list_3_ objc_property_list_3_, *Pobjc_property_list_3_;

struct objc_property_list_3_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
};

typedef struct method_list_t_2_ method_list_t_2_, *Pmethod_list_t_2_;

struct method_list_t_2_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
};

typedef struct ivar_list_t_4_ ivar_list_t_4_, *Pivar_list_t_4_;

struct ivar_list_t_4_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
};

typedef struct method_list_t_54_ method_list_t_54_, *Pmethod_list_t_54_;

struct method_list_t_54_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
    struct method_t method22;
    struct method_t method23;
    struct method_t method24;
    struct method_t method25;
    struct method_t method26;
    struct method_t method27;
    struct method_t method28;
    struct method_t method29;
    struct method_t method30;
    struct method_t method31;
    struct method_t method32;
    struct method_t method33;
    struct method_t method34;
    struct method_t method35;
    struct method_t method36;
    struct method_t method37;
    struct method_t method38;
    struct method_t method39;
    struct method_t method40;
    struct method_t method41;
    struct method_t method42;
    struct method_t method43;
    struct method_t method44;
    struct method_t method45;
    struct method_t method46;
    struct method_t method47;
    struct method_t method48;
    struct method_t method49;
    struct method_t method50;
    struct method_t method51;
    struct method_t method52;
    struct method_t method53;
};

typedef struct method_list_t_10_ method_list_t_10_, *Pmethod_list_t_10_;

struct method_list_t_10_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
};

typedef struct method_list_t_6_ method_list_t_6_, *Pmethod_list_t_6_;

struct method_list_t_6_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
};

typedef struct ivar_list_t_14_ ivar_list_t_14_, *Pivar_list_t_14_;

struct ivar_list_t_14_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
    struct ivar_t var7;
    struct ivar_t var8;
    struct ivar_t var9;
    struct ivar_t var10;
    struct ivar_t var11;
    struct ivar_t var12;
    struct ivar_t var13;
};

typedef struct method_list_t_22_ method_list_t_22_, *Pmethod_list_t_22_;

struct method_list_t_22_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
};

typedef qword SEL;

typedef struct method_list_t_82_ method_list_t_82_, *Pmethod_list_t_82_;

struct method_list_t_82_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
    struct method_t method22;
    struct method_t method23;
    struct method_t method24;
    struct method_t method25;
    struct method_t method26;
    struct method_t method27;
    struct method_t method28;
    struct method_t method29;
    struct method_t method30;
    struct method_t method31;
    struct method_t method32;
    struct method_t method33;
    struct method_t method34;
    struct method_t method35;
    struct method_t method36;
    struct method_t method37;
    struct method_t method38;
    struct method_t method39;
    struct method_t method40;
    struct method_t method41;
    struct method_t method42;
    struct method_t method43;
    struct method_t method44;
    struct method_t method45;
    struct method_t method46;
    struct method_t method47;
    struct method_t method48;
    struct method_t method49;
    struct method_t method50;
    struct method_t method51;
    struct method_t method52;
    struct method_t method53;
    struct method_t method54;
    struct method_t method55;
    struct method_t method56;
    struct method_t method57;
    struct method_t method58;
    struct method_t method59;
    struct method_t method60;
    struct method_t method61;
    struct method_t method62;
    struct method_t method63;
    struct method_t method64;
    struct method_t method65;
    struct method_t method66;
    struct method_t method67;
    struct method_t method68;
    struct method_t method69;
    struct method_t method70;
    struct method_t method71;
    struct method_t method72;
    struct method_t method73;
    struct method_t method74;
    struct method_t method75;
    struct method_t method76;
    struct method_t method77;
    struct method_t method78;
    struct method_t method79;
    struct method_t method80;
    struct method_t method81;
};

typedef struct objc_image_info objc_image_info, *Pobjc_image_info;

struct objc_image_info {
    dword version;
    dword flags;
};

typedef struct ivar_list_t_10_ ivar_list_t_10_, *Pivar_list_t_10_;

struct ivar_list_t_10_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
    struct ivar_t var7;
    struct ivar_t var8;
    struct ivar_t var9;
};

typedef struct method_list_t_13_ method_list_t_13_, *Pmethod_list_t_13_;

struct method_list_t_13_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
};

typedef dword bool;

typedef struct objc_property_list_11_ objc_property_list_11_, *Pobjc_property_list_11_;

struct objc_property_list_11_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
    struct objc_property property7;
    struct objc_property property8;
    struct objc_property property9;
    struct objc_property property10;
};

typedef struct method_list_t_81_ method_list_t_81_, *Pmethod_list_t_81_;

struct method_list_t_81_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
    struct method_t method20;
    struct method_t method21;
    struct method_t method22;
    struct method_t method23;
    struct method_t method24;
    struct method_t method25;
    struct method_t method26;
    struct method_t method27;
    struct method_t method28;
    struct method_t method29;
    struct method_t method30;
    struct method_t method31;
    struct method_t method32;
    struct method_t method33;
    struct method_t method34;
    struct method_t method35;
    struct method_t method36;
    struct method_t method37;
    struct method_t method38;
    struct method_t method39;
    struct method_t method40;
    struct method_t method41;
    struct method_t method42;
    struct method_t method43;
    struct method_t method44;
    struct method_t method45;
    struct method_t method46;
    struct method_t method47;
    struct method_t method48;
    struct method_t method49;
    struct method_t method50;
    struct method_t method51;
    struct method_t method52;
    struct method_t method53;
    struct method_t method54;
    struct method_t method55;
    struct method_t method56;
    struct method_t method57;
    struct method_t method58;
    struct method_t method59;
    struct method_t method60;
    struct method_t method61;
    struct method_t method62;
    struct method_t method63;
    struct method_t method64;
    struct method_t method65;
    struct method_t method66;
    struct method_t method67;
    struct method_t method68;
    struct method_t method69;
    struct method_t method70;
    struct method_t method71;
    struct method_t method72;
    struct method_t method73;
    struct method_t method74;
    struct method_t method75;
    struct method_t method76;
    struct method_t method77;
    struct method_t method78;
    struct method_t method79;
    struct method_t method80;
};

typedef struct objc_property_list_4_ objc_property_list_4_, *Pobjc_property_list_4_;

struct objc_property_list_4_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
};

typedef struct protocol_list_t_1_ protocol_list_t_1_, *Pprotocol_list_t_1_;

struct protocol_list_t_1_ {
    qword count;
    struct protocol_t *protocol0;
};

typedef struct method_list_t_3_ method_list_t_3_, *Pmethod_list_t_3_;

struct method_list_t_3_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
};

typedef struct ivar_list_t_1_ ivar_list_t_1_, *Pivar_list_t_1_;

struct ivar_list_t_1_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
};

typedef struct ivar_list_t_5_ ivar_list_t_5_, *Pivar_list_t_5_;

struct ivar_list_t_5_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
};

typedef struct method_list_t_7_ method_list_t_7_, *Pmethod_list_t_7_;

struct method_list_t_7_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
};

typedef struct ivar_list_t_9_ ivar_list_t_9_, *Pivar_list_t_9_;

struct ivar_list_t_9_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
    struct ivar_t var7;
    struct ivar_t var8;
};

typedef struct ivar_list_t_11_ ivar_list_t_11_, *Pivar_list_t_11_;

struct ivar_list_t_11_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
    struct ivar_t var7;
    struct ivar_t var8;
    struct ivar_t var9;
    struct ivar_t var10;
};

typedef struct CGSize CGSize, *PCGSize;

struct CGSize {
    double field0_0x0;
    double field1_0x8;
};

typedef struct method_list_t_16_ method_list_t_16_, *Pmethod_list_t_16_;

struct method_list_t_16_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
};


// WARNING! conflicting data type names: /_objc2_/int - /int

typedef struct objc_property_list_9_ objc_property_list_9_, *Pobjc_property_list_9_;

struct objc_property_list_9_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
    struct objc_property property7;
    struct objc_property property8;
};

typedef struct ivar_list_t_40_ ivar_list_t_40_, *Pivar_list_t_40_;

struct ivar_list_t_40_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
    struct ivar_t var6;
    struct ivar_t var7;
    struct ivar_t var8;
    struct ivar_t var9;
    struct ivar_t var10;
    struct ivar_t var11;
    struct ivar_t var12;
    struct ivar_t var13;
    struct ivar_t var14;
    struct ivar_t var15;
    struct ivar_t var16;
    struct ivar_t var17;
    struct ivar_t var18;
    struct ivar_t var19;
    struct ivar_t var20;
    struct ivar_t var21;
    struct ivar_t var22;
    struct ivar_t var23;
    struct ivar_t var24;
    struct ivar_t var25;
    struct ivar_t var26;
    struct ivar_t var27;
    struct ivar_t var28;
    struct ivar_t var29;
    struct ivar_t var30;
    struct ivar_t var31;
    struct ivar_t var32;
    struct ivar_t var33;
    struct ivar_t var34;
    struct ivar_t var35;
    struct ivar_t var36;
    struct ivar_t var37;
    struct ivar_t var38;
    struct ivar_t var39;
};

typedef struct objc_property_list_12_ objc_property_list_12_, *Pobjc_property_list_12_;

struct objc_property_list_12_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
    struct objc_property property7;
    struct objc_property property8;
    struct objc_property property9;
    struct objc_property property10;
    struct objc_property property11;
};

typedef struct objc_property_list_5_ objc_property_list_5_, *Pobjc_property_list_5_;

struct objc_property_list_5_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
};

typedef struct ivar_list_t_2_ ivar_list_t_2_, *Pivar_list_t_2_;

struct ivar_list_t_2_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
};

typedef struct objc_property_list_1_ objc_property_list_1_, *Pobjc_property_list_1_;

struct objc_property_list_1_ {
    dword entsize;
    dword count;
    struct objc_property property0;
};

typedef struct method_list_t_20_ method_list_t_20_, *Pmethod_list_t_20_;

struct method_list_t_20_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
    struct method_t method12;
    struct method_t method13;
    struct method_t method14;
    struct method_t method15;
    struct method_t method16;
    struct method_t method17;
    struct method_t method18;
    struct method_t method19;
};

typedef struct ivar_list_t_6_ ivar_list_t_6_, *Pivar_list_t_6_;

struct ivar_list_t_6_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
    struct ivar_t var3;
    struct ivar_t var4;
    struct ivar_t var5;
};

typedef struct method_list_t_12_ method_list_t_12_, *Pmethod_list_t_12_;

struct method_list_t_12_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
    struct method_t method3;
    struct method_t method4;
    struct method_t method5;
    struct method_t method6;
    struct method_t method7;
    struct method_t method8;
    struct method_t method9;
    struct method_t method10;
    struct method_t method11;
};

typedef struct objc_property_list_40_ objc_property_list_40_, *Pobjc_property_list_40_;

struct objc_property_list_40_ {
    dword entsize;
    dword count;
    struct objc_property property0;
    struct objc_property property1;
    struct objc_property property2;
    struct objc_property property3;
    struct objc_property property4;
    struct objc_property property5;
    struct objc_property property6;
    struct objc_property property7;
    struct objc_property property8;
    struct objc_property property9;
    struct objc_property property10;
    struct objc_property property11;
    struct objc_property property12;
    struct objc_property property13;
    struct objc_property property14;
    struct objc_property property15;
    struct objc_property property16;
    struct objc_property property17;
    struct objc_property property18;
    struct objc_property property19;
    struct objc_property property20;
    struct objc_property property21;
    struct objc_property property22;
    struct objc_property property23;
    struct objc_property property24;
    struct objc_property property25;
    struct objc_property property26;
    struct objc_property property27;
    struct objc_property property28;
    struct objc_property property29;
    struct objc_property property30;
    struct objc_property property31;
    struct objc_property property32;
    struct objc_property property33;
    struct objc_property property34;
    struct objc_property property35;
    struct objc_property property36;
    struct objc_property property37;
    struct objc_property property38;
    struct objc_property property39;
};

typedef __darwin_size_t size_t;

typedef uchar uint8_t;

typedef uint32_t CC_LONG;

typedef void (*dispatch_function_t)(void *);

typedef __darwin_pthread_mutexattr_t pthread_mutexattr_t;

typedef struct _Unwind_Exception _Unwind_Exception, *P_Unwind_Exception;

typedef enum enum_4370 {
    _URC_NO_REASON=0,
    _URC_FOREIGN_EXCEPTION_CAUGHT=1,
    _URC_FATAL_PHASE2_ERROR=2,
    _URC_FATAL_PHASE1_ERROR=3,
    _URC_NORMAL_STOP=4,
    _URC_END_OF_STACK=5,
    _URC_HANDLER_FOUND=6,
    _URC_INSTALL_CONTEXT=7,
    _URC_CONTINUE_UNWIND=8
} enum_4370;

typedef enum enum_4370 _Unwind_Reason_Code;

struct _Unwind_Exception {
    uint64_t exception_class;
    void (*exception_cleanup)(_Unwind_Reason_Code, struct _Unwind_Exception *);
    uintptr_t private_1;
    uintptr_t private_2;
    uint32_t reserved[3];
};

typedef struct objc_class objc_class, *Pobjc_class;

struct objc_class { // PlaceHolder Structure
};

typedef struct swift swift, *Pswift;

struct swift { // PlaceHolder Structure
};

typedef dword StringRef;

typedef struct TargetProtocolDescriptor TargetProtocolDescriptor, *PTargetProtocolDescriptor;

struct TargetProtocolDescriptor { // PlaceHolder Structure
};

typedef struct TargetProtocolConformanceDescriptor TargetProtocolConformanceDescriptor, *PTargetProtocolConformanceDescriptor;

struct TargetProtocolConformanceDescriptor { // PlaceHolder Structure
};

typedef struct TargetContextDescriptor TargetContextDescriptor, *PTargetContextDescriptor;

struct TargetContextDescriptor { // PlaceHolder Structure
};

typedef struct TargetWitnessTable TargetWitnessTable, *PTargetWitnessTable;

struct TargetWitnessTable { // PlaceHolder Structure
};

typedef struct TargetMetadata TargetMetadata, *PTargetMetadata;

struct TargetMetadata { // PlaceHolder Structure
};

typedef struct CS_CodeDirectory CS_CodeDirectory, *PCS_CodeDirectory;

struct CS_CodeDirectory {
    dword magic; // magic number (CSMAGIC_CODEDIRECTORY)
    dword length; // total length of CodeDirectory blob
    dword version; // compatibility version
    dword flags; // setup and mode flags
    dword hashOffset; // offset of hash slot element at index zero
    dword identOffset; // offset of identifier string
    dword nSpecialSlots; // number of special hash slots
    dword nCodeSlots; // number of ordinary (code) hash slots
    dword codeLimit; // limit to main image signature range
    byte hashSize; // size of each hash in bytes
    byte hashType; // type of hash (cdHashType* constants)
    byte platform; // platform identifier; zero if not platform binary
    byte pageSize; // log2(page size in bytes); 0 => infinite
    dword spare2; // unused (must be zero)
    dword scatterOffset; // offset of optional scatter vector
    dword teamOffset; // offset of optional team identifier
    dword spare3; // unused (must be zero)
    qword codeLimit64; // limit to main image signature range, 64 bits
    qword execSegBase; // offset of executable segment
    qword execSegLimit; // limit of executable segment
    qword execSegFlags; // executable segment flags
    dword runtime;
    dword preEncryptOffset;
};

typedef struct uuid_command uuid_command, *Puuid_command;

struct uuid_command {
    dword cmd;
    dword cmdsize;
    byte uuid[16];
};

typedef struct lc_str lc_str, *Plc_str;

struct lc_str {
    dword offset;
};

typedef struct dyld_info_command dyld_info_command, *Pdyld_info_command;

struct dyld_info_command {
    dword cmd;
    dword cmdsize;
    dword rebase_off; // file offset to rebase info
    dword rebase_size; // size of rebase info
    dword bind_off; // file offset to binding info
    dword bind_size; // size of binding info
    dword weak_bind_off; // file offset to weak binding info
    dword weak_bind_size; // size of weak binding info
    dword lazy_bind_off; // file offset to lazy binding info
    dword lazy_bind_size; // size of lazy binding info
    dword export_off; // file offset to lazy binding info
    dword export_size; // size of lazy binding info
};

typedef struct CS_BlobIndex CS_BlobIndex, *PCS_BlobIndex;

struct CS_BlobIndex {
    dword type; // type of entry
    dword offset; // offset of entry
};

typedef struct section section, *Psection;

struct section {
    char sectname[16];
    char segname[16];
    qword addr;
    qword size;
    dword offset;
    dword align;
    dword reloff;
    dword nrelocs;
    dword flags;
    dword reserved1;
    dword reserved2;
    dword reserved3;
};

typedef struct encryption_info_command encryption_info_command, *Pencryption_info_command;

struct encryption_info_command {
    dword cmd;
    dword cmdsize;
    dword cryptoff;
    dword cryptsize;
    dword cryptid;
    dword pad;
};

typedef struct nlist nlist, *Pnlist;

struct nlist {
    dword n_strx;
    byte n_type;
    byte n_sect;
    word n_desc;
    qword n_value;
};

typedef struct mach_header mach_header, *Pmach_header;

struct mach_header {
    dword magic;
    dword cputype;
    dword cpusubtype;
    dword filetype;
    dword ncmds;
    dword sizeofcmds;
    dword flags;
    dword reserved;
};

typedef struct segment_command segment_command, *Psegment_command;

struct segment_command {
    dword cmd;
    dword cmdsize;
    char segname[16];
    qword vmaddr;
    qword vmsize;
    qword fileoff;
    qword filesize;
    dword maxprot;
    dword initprot;
    dword nsects;
    dword flags;
};

typedef struct source_version_command source_version_command, *Psource_version_command;

struct source_version_command {
    dword cmd;
    dword cmdsize;
    qword version;
};

typedef struct rpath_command rpath_command, *Prpath_command;

struct rpath_command {
    dword cmd;
    dword cmdsize;
    struct lc_str path;
};

typedef struct dylib dylib, *Pdylib;

struct dylib {
    struct lc_str name;
    dword timestamp;
    dword current_version;
    dword compatibility_version;
};

typedef enum bind_opcode {
    BIND_OPCODE_DONE=0,
    BIND_OPCODE_SET_DYLIB_ORDINAL_IMM=16,
    BIND_OPCODE_SET_DYLIB_ORDINAL_ULEB=32,
    BIND_OPCODE_SET_DYLIB_SPECIAL_IMM=48,
    BIND_OPCODE_SET_SYMBOL_TRAILING_FLAGS_IMM=64,
    BIND_OPCODE_SET_TYPE_IMM=80,
    BIND_OPCODE_SET_ADDEND_SLEB=96,
    BIND_OPCODE_SET_SEGMENT_AND_OFFSET_ULEB=112,
    BIND_OPCODE_ADD_ADDR_ULEB=128,
    BIND_OPCODE_DO_BIND=144,
    BIND_OPCODE_DO_BIND_ADD_ADDR_ULEB=160,
    BIND_OPCODE_DO_BIND_ADD_ADDR_IMM_SCALED=176,
    BIND_OPCODE_DO_BIND_ULEB_TIMES_SKIPPING_ULEB=192,
    BIND_OPCODE_THREADED=208
} bind_opcode;

typedef struct dysymtab_command dysymtab_command, *Pdysymtab_command;

struct dysymtab_command {
    dword cmd;
    dword cmdsize;
    dword ilocalsym;
    dword nlocalsym;
    dword iextdefsym;
    dword nextdefsym;
    dword iundefsym;
    dword nundefsym;
    dword tocoff;
    dword ntoc;
    dword modtaboff;
    dword nmodtab;
    dword extrefsymoff;
    dword nextrefsyms;
    dword indirectsymoff;
    dword nindirectsyms;
    dword extreloff;
    dword nextrel;
    dword locreloff;
    dword nlocrel;
};

typedef struct CS_SuperBlob CS_SuperBlob, *PCS_SuperBlob;

struct CS_SuperBlob {
    dword magic; // magic number
    dword length; // total length of SuperBlob
    dword count; // number of index entries following
    struct CS_BlobIndex index[5]; // (count) entries
};

typedef struct dylib_command dylib_command, *Pdylib_command;

struct dylib_command {
    dword cmd;
    dword cmdsize;
    struct dylib dylib;
};

typedef struct symtab_command symtab_command, *Psymtab_command;

struct symtab_command {
    dword cmd;
    dword cmdsize;
    dword symoff;
    dword nsyms;
    dword stroff;
    dword strsize;
};

typedef struct version_min_command version_min_command, *Pversion_min_command;

struct version_min_command {
    dword cmd;
    dword cmdsize;
    dword version;
    dword sdk;
};

typedef struct linkedit_data_command linkedit_data_command, *Plinkedit_data_command;

struct linkedit_data_command {
    dword cmd;
    dword cmdsize;
    dword dataoff;
    dword datasize;
};

typedef struct CS_GenericBlob CS_GenericBlob, *PCS_GenericBlob;

struct CS_GenericBlob {
    dword magic; // magic number
    dword length; // total length of blob
};

typedef long dispatch_once_t;




// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 uVar2;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::WechatAuthSDK;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    uVar2 = *(undefined8 *)(IVar1 + 8);
    *(cfstringStruct **)(IVar1 + 8) = &cf_2_0;
    _objc_release(uVar2);
    _objc_msgSend(IVar1,"setStatus:",0);
    _objc_msgSend(IVar1,"setIsAuthing:",0);
    _objc_msgSend(IVar1,"setHttpRetStatusCode:",0);
    _objc_msgSend(IVar1,"setLastState:",0);
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::dealloc(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  ID local_50;
  class_t *pcStack_48;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_dealloc);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  resetAll(param_1,(SEL)"resetAll");
  setRespData_(param_1,(SEL)"setRespData:",0);
  pcStack_48 = &objc::class_t::WechatAuthSDK;
  local_50 = param_1;
  _objc_msgSendSuper2(&local_50,"dealloc");
  return;
}



void ___clang_call_terminate(void)

{
  ID IVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  
  ___cxa_begin_catch();
  IVar1 = std::terminate();
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_resetAll);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar4,0);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  WechatAuthSDK::resetConnection(IVar1,(SEL)"resetConnection");
  WechatAuthSDK::setStatus_(IVar1,(SEL)"setStatus:",0);
  WechatAuthSDK::setUuid_(IVar1,(SEL)"setUuid:",0);
  WechatAuthSDK::setQrCodeData_(IVar1,(SEL)"setQrCodeData:",0);
  WechatAuthSDK::setAuthCode_(IVar1,(SEL)"setAuthCode:",0);
  WechatAuthSDK::setIsAuthing_(IVar1,(SEL)"setIsAuthing:",0);
  WechatAuthSDK::setLastState_(IVar1,(SEL)"setLastState:",0);
  return;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::resetAll(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_resetAll);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  resetConnection(param_1,(SEL)"resetConnection");
  setStatus_(param_1,(SEL)"setStatus:",0);
  setUuid_(param_1,(SEL)"setUuid:",0);
  setQrCodeData_(param_1,(SEL)"setQrCodeData:",0);
  setAuthCode_(param_1,(SEL)"setAuthCode:",0);
  setIsAuthing_(param_1,(SEL)"setIsAuthing:",0);
  setLastState_(param_1,(SEL)"setLastState:",0);
  return;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::resetConnection(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  ID IVar5;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_resetConnection);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  _objc_msgSend(param_1,"connection");
  lVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release();
  if (lVar4 != 0) {
    _objc_msgSend(param_1,"connection");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"cancel");
    _objc_release(uVar1);
    setConnection_(param_1,(SEL)"setConnection:",0);
  }
  stopTimeoutCheck(param_1,(SEL)"stopTimeoutCheck");
  setRetContentLength_(param_1,(SEL)"setRetContentLength:",0);
  _objc_msgSend(&_OBJC_CLASS___NSMutableData,"data");
  IVar5 = _objc_retainAutoreleasedReturnValue();
  setRespData_(param_1,(SEL)"setRespData:",IVar5);
  _objc_release(IVar5);
  setHttpRetStatusCode_(param_1,(SEL)"setHttpRetStatusCode:",0);
  return;
}



// Function Stack Size: 0x40 bytes

bool WechatAuthSDK::Auth_nonceStr_timeStamp_scope_signature_schemeData_
               (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5,ID param_6,ID param_7,
               ID param_8)

{
  bool bVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  ID IVar11;
  
  uVar2 = _objc_retain(param_3);
  uVar3 = _objc_retain(param_4);
  uVar4 = _objc_retain(param_5);
  uVar5 = _objc_retain(param_6);
  uVar6 = _objc_retain(param_7);
  uVar7 = _objc_retain(param_8);
  bVar1 = isAuthing(param_1,(SEL)"isAuthing");
  if ((bVar1 & 1) == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Auth_appId___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"printLog:level:",uVar10,0);
    _objc_release(uVar10);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &
                  cf_https___open_weixin_qq_com_connect_sdk_qrconnect_appid____noncestr____timestamp____scope____signature____scheme_data___
                 );
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"stringByAddingPercentEscapesUsingEncoding:",4);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar8);
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar9);
    IVar11 = _objc_retainAutoreleasedReturnValue();
    bVar1 = sendAuthRequest_(param_1,(SEL)"sendAuthRequest:",IVar11);
    _objc_release(IVar11);
    _objc_release(uVar9);
  }
  else {
    bVar1 = 0;
  }
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x10 bytes

bool WechatAuthSDK::StopAuth(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_StopAuth);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  resetAll(param_1,(SEL)"resetAll");
  return 1;
}



// Function Stack Size: 0x18 bytes

bool WechatAuthSDK::sendAuthRequest_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  ID IVar6;
  long lVar7;
  undefined8 uVar8;
  bool bVar9;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    bVar9 = 0;
    goto LAB_0000680c;
  }
  resetAll(param_1,(SEL)"resetAll");
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_s);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar4,0);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSMutableURLRequest,"alloc");
  lVar5 = _objc_msgSend(uVar2,"initWithURL:",lVar1);
  _objc_msgSend(lVar5,"setCachePolicy:",1);
  if (lVar5 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_requsetisnil);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar8,0);
LAB_000067e0:
    _objc_release(uVar8);
    _objc_release(uVar4);
    _objc_release(uVar3);
    _objc_release(uVar2);
    bVar9 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSURLConnection,"connectionWithRequest:delegate:",lVar5,param_1);
    IVar6 = _objc_retainAutoreleasedReturnValue();
    setConnection_(param_1,(SEL)"setConnection:",IVar6);
    _objc_release(IVar6);
    _objc_msgSend(param_1,"connection");
    lVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar7 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_connectionisnil);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"printLog:level:",uVar8,0);
      goto LAB_000067e0;
    }
    bVar9 = 1;
    setIsAuthing_(param_1,(SEL)"setIsAuthing:",1);
  }
  _objc_release(lVar5);
LAB_0000680c:
  _objc_release(lVar1);
  return bVar9;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::startTimeoutCheck(ID param_1,SEL param_2)

{
  ID IVar1;
  
  _objc_msgSend(0x4000000000000000,&_OBJC_CLASS___NSTimer,
                "scheduledTimerWithTimeInterval:target:selector:userInfo:repeats:",param_1,
                "startPolling",0,0);
  IVar1 = _objc_retainAutoreleasedReturnValue();
  setTimer_(param_1,(SEL)"setTimer:",IVar1);
  _objc_release(IVar1);
  return;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::stopTimeoutCheck(ID param_1,SEL param_2)

{
  long lVar1;
  undefined8 uVar2;
  
  _objc_msgSend(param_1,"timer");
  lVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_release();
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"timer");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"invalidate");
    _objc_release(uVar2);
    setTimer_(param_1,(SEL)"setTimer:",0);
    return;
  }
  return;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::startPolling(ID param_1,SEL param_2)

{
  bool bVar1;
  long lVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  undefined8 uVar9;
  
  resetConnection(param_1,(SEL)"resetConnection");
  _objc_msgSend(param_1,"uuid");
  lVar2 = _objc_retainAutoreleasedReturnValue();
  if (lVar2 == 0) {
    bVar1 = true;
  }
  else {
    _objc_msgSend(param_1,"uuid");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    bVar1 = lVar4 == 0;
    _objc_release(uVar3);
  }
  _objc_release(lVar2);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  if (bVar1) {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_startPollinguuidisnil);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar3);
    handleError_(param_1,(SEL)"handleError:",0xffffffff);
    return;
  }
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_startPolling);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"printLog:level:",uVar6,0);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar3);
  _objc_msgSend(param_1,"uuid");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(param_1,"lastState");
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                &cf_https___long_open_weixin_qq_com_connect_l_qrconnect_uuid____last__ld_f_json);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar5);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar5);
  _objc_release(uVar3);
  uVar3 = _objc_msgSend(&_OBJC_CLASS___NSMutableURLRequest,"alloc");
  uVar3 = _objc_msgSend(uVar3,"initWithURL:",uVar6);
  _objc_msgSend(uVar3,"setCachePolicy:",1);
  _objc_msgSend(0x404e000000000000,uVar3,"setTimeoutInterval:");
  _objc_msgSend(&_OBJC_CLASS___NSURLConnection,"connectionWithRequest:delegate:",uVar3,param_1);
  IVar8 = _objc_retainAutoreleasedReturnValue();
  setConnection_(param_1,(SEL)"setConnection:",IVar8);
  _objc_release(IVar8);
  _objc_msgSend(param_1,"connection");
  lVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release();
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_connectionisnil);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar7);
    _objc_release(uVar5);
  }
  _objc_release(uVar3);
  _objc_release(uVar6);
  return;
}



// Function Stack Size: 0x14 bytes

void WechatAuthSDK::handleError_(ID param_1,SEL param_2,int param_3)

{
  long lVar1;
  int iVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  lVar1 = param_1 + 0x10;
  uVar4 = _objc_loadWeakRetained(lVar1);
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__delegate____errCode__d);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(uVar3);
  lVar8 = _objc_loadWeakRetained(lVar1);
  if (lVar8 != 0) {
    uVar3 = _objc_loadWeakRetained(lVar1);
    iVar2 = _objc_msgSend(uVar3,"respondsToSelector:","onAuthFinish:AuthCode:");
    _objc_release(uVar3);
    _objc_release(lVar8);
    if (iVar2 != 0) {
      uVar3 = _objc_loadWeakRetained(lVar1);
      _objc_msgSend(param_1,"authCode");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar3,"onAuthFinish:AuthCode:",param_3,uVar4);
      _objc_release(uVar4);
      _objc_release(uVar3);
    }
  }
  resetAll(param_1,(SEL)"resetAll");
  return;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::handleGotQrcode(ID param_1,SEL param_2)

{
  long lVar1;
  int iVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  long lVar9;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  lVar1 = param_1 + 0x10;
  uVar4 = _objc_loadWeakRetained(lVar1);
  _objc_msgSend(param_1,"qrCodeData");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__delegate____self_qrCodeData___);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_msgSend(param_1,"qrCodeData");
  lVar8 = _objc_retainAutoreleasedReturnValue();
  if (lVar8 == 0) {
    _objc_release(0);
  }
  else {
    _objc_msgSend(param_1,"qrCodeData");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar9 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    _objc_release(lVar8);
    if (lVar9 != 0) {
      _objc_msgSend(param_1,"qrCodeData");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___UIImage,"imageWithData:",uVar3);
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar3);
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      uVar5 = _objc_loadWeakRetained(lVar1);
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__delegate____qrCodeImg___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar3,"printLog:level:",uVar7,0);
      _objc_release(uVar7);
      _objc_release(uVar6);
      _objc_release(uVar5);
      _objc_release(uVar3);
      lVar8 = _objc_loadWeakRetained(lVar1);
      if (lVar8 != 0) {
        uVar3 = _objc_loadWeakRetained(lVar1);
        iVar2 = _objc_msgSend(uVar3,"respondsToSelector:","onAuthGotQrcode:");
        _objc_release(uVar3);
        _objc_release(lVar8);
        if (iVar2 != 0) {
          uVar3 = _objc_loadWeakRetained(lVar1);
          _objc_msgSend(uVar3,"onAuthGotQrcode:",uVar4);
          _objc_release(uVar3);
        }
      }
      setStatus_(param_1,(SEL)"setStatus:",1);
      startPolling(param_1,(SEL)"startPolling");
      _objc_release(uVar4);
      return;
    }
  }
  handleError_(param_1,(SEL)"handleError:",0xfffffffd);
  return;
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::handleResponse_(ID param_1,SEL param_2,ID param_3)

{
  unsigned_int uVar1;
  int iVar2;
  long lVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  long lVar10;
  long lVar11;
  ID IVar12;
  undefined8 local_68;
  
  lVar3 = _objc_retain(param_3);
  if ((lVar3 == 0) || (lVar4 = _objc_msgSend(lVar3,"length"), lVar4 == 0)) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_respisnil);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar8,0);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    handleError_(param_1,(SEL)"handleError:",0xffffffff);
    goto LAB_00007aa8;
  }
  _objc_msgSend(lVar3,"dataUsingEncoding:",4);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  local_68 = 0;
  _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"JSONObjectWithData:options:error:",uVar5,2,
                &local_68);
  lVar4 = _objc_retainAutoreleasedReturnValue();
  uVar6 = _objc_retain(local_68);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar7 = _objc_retainAutoreleasedReturnValue();
  status(param_1,(SEL)"status");
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_status__d_dictResponse___);
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar7,"printLog:level:",uVar9,0);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar7);
  uVar1 = status(param_1,(SEL)"status");
  if (uVar1 == 0) {
    if (lVar4 == 0) {
      handleError_(param_1,(SEL)"handleError:",0xfffffffd);
    }
    else {
      _objc_msgSend(lVar4,"objectForKey:",&cf_errcode);
      lVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar10 != 0) {
        _objc_msgSend(lVar4,"wxApi_integerForKey:",&cf_errcode);
      }
      _objc_msgSend(lVar4,"objectForKey:",&cf_uuid);
      lVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar10 != 0) {
        _objc_msgSend(lVar4,"wxApi_stringForKey:",&cf_uuid);
        IVar12 = _objc_retainAutoreleasedReturnValue();
        setUuid_(param_1,(SEL)"setUuid:",IVar12);
        _objc_release(IVar12);
      }
      _objc_msgSend(lVar4,"wxApi_dictionaryForKey:",&cf_qrcode);
      lVar10 = _objc_retainAutoreleasedReturnValue();
      if (lVar10 != 0) {
        _objc_msgSend(lVar10,"wxApi_integerForKey:",&cf_qrcodelength);
        _objc_msgSend(lVar10,"wxApi_stringForKey:",&cf_qrcodebase64);
        lVar11 = _objc_retainAutoreleasedReturnValue();
        if (lVar11 != 0) {
          uVar7 = _objc_msgSend(&_OBJC_CLASS___NSData,"alloc");
          IVar12 = _objc_msgSend(uVar7,"initWithBase64EncodedString:options:",lVar11,0);
          setQrCodeData_(param_1,(SEL)"setQrCodeData:",IVar12);
          _objc_release(IVar12);
        }
        _objc_release(lVar11);
      }
      handleGotQrcode(param_1,(SEL)"handleGotQrcode");
      _objc_release(lVar10);
    }
    goto LAB_00007a90;
  }
  if (lVar4 == 0) {
code_r0x00007a80:
    handleError_(param_1,(SEL)"handleError:",0xffffffff);
  }
  else {
    _objc_msgSend(lVar4,"objectForKey:",&cf_wx_errcode);
    lVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar10 == 0) {
      lVar10 = -999999;
    }
    else {
      lVar10 = _objc_msgSend(lVar4,"wxApi_integerForKey:",&cf_wx_errcode);
    }
    _objc_msgSend(lVar4,"objectForKey:",&cf_wx_code);
    lVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar11 != 0) {
      _objc_msgSend(lVar4,"wxApi_stringForKey:",&cf_wx_code);
      IVar12 = _objc_retainAutoreleasedReturnValue();
      setAuthCode_(param_1,(SEL)"setAuthCode:",IVar12);
      _objc_release(IVar12);
    }
    switch(lVar10) {
    case 0x191:
      setLastState_(param_1,(SEL)"setLastState:",0x191);
      startTimeoutCheck(param_1,(SEL)"startTimeoutCheck");
      break;
    case 0x192:
      handleError_(param_1,(SEL)"handleError:",0xfffffffb);
      break;
    case 0x193:
      handleError_(param_1,(SEL)"handleError:",0xfffffffc);
      break;
    case 0x194:
      uVar1 = status(param_1,(SEL)"status");
      if (uVar1 != 2) {
        setStatus_(param_1,(SEL)"setStatus:",2);
        lVar10 = param_1 + 0x10;
        lVar11 = _objc_loadWeakRetained(lVar10);
        if (lVar11 != 0) {
          uVar7 = _objc_loadWeakRetained(lVar10);
          iVar2 = _objc_msgSend(uVar7,"respondsToSelector:","onQrcodeScanned");
          _objc_release(uVar7);
          _objc_release(lVar11);
          if (iVar2 != 0) {
            uVar7 = _objc_loadWeakRetained(lVar10);
            _objc_msgSend(uVar7,"onQrcodeScanned");
            _objc_release(uVar7);
          }
        }
      }
      setLastState_(param_1,(SEL)"setLastState:",0x194);
      startTimeoutCheck(param_1,(SEL)"startTimeoutCheck");
      break;
    case 0x195:
      lVar10 = param_1 + 0x10;
      lVar11 = _objc_loadWeakRetained(lVar10);
      if (lVar11 != 0) {
        uVar7 = _objc_loadWeakRetained(lVar10);
        iVar2 = _objc_msgSend(uVar7,"respondsToSelector:","onAuthFinish:AuthCode:");
        _objc_release(uVar7);
        _objc_release(lVar11);
        if (iVar2 != 0) {
          uVar7 = _objc_loadWeakRetained(lVar10);
          _objc_msgSend(param_1,"authCode");
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"onAuthFinish:AuthCode:",0,uVar8);
          _objc_release(uVar8);
          _objc_release(uVar7);
        }
      }
      resetAll(param_1,(SEL)"resetAll");
      break;
    case 0x196:
      setLastState_(param_1,(SEL)"setLastState:",0x196);
      startTimeoutCheck(param_1,(SEL)"startTimeoutCheck");
      break;
    case 0x197:
      goto code_r0x00007a80;
    case 0x198:
      setLastState_(param_1,(SEL)"setLastState:",0x198);
      startTimeoutCheck(param_1,(SEL)"startTimeoutCheck");
      break;
    default:
      if (lVar10 != 500) goto code_r0x00007a80;
      handleError_(param_1,(SEL)"handleError:",0xffffffff);
    }
  }
LAB_00007a90:
  _objc_release(lVar4);
  _objc_release(uVar6);
  _objc_release(uVar5);
LAB_00007aa8:
  _objc_release(lVar3);
  return;
}



// Function Stack Size: 0x20 bytes

void WechatAuthSDK::connection_didReceiveResponse_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  unsigned_int uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  long_long lVar9;
  
  _objc_retain(param_4);
  uVar2 = _objc_retain();
  _objc_msgSend(uVar2,"allHeaderFields");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_Content_Length);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_didReceiveResponserespdicResp___);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar5,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  lVar8 = _objc_msgSend(uVar2,"expectedContentLength");
  if (lVar8 < 1) {
    uVar1 = _objc_msgSend(uVar4,"longLongValue");
    setRetContentLength_(param_1,(SEL)"setRetContentLength:",uVar1);
  }
  else {
    uVar1 = _objc_msgSend(uVar2,"expectedContentLength");
    setRetContentLength_(param_1,(SEL)"setRetContentLength:",uVar1);
  }
  lVar9 = _objc_msgSend(uVar2,"statusCode");
  setHttpRetStatusCode_(param_1,(SEL)"setHttpRetStatusCode:",lVar9);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x20 bytes

void WechatAuthSDK::connection_didReceiveData_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  
  uVar1 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"length");
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_didReceiveDatadatalength__ld);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar4,0);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_msgSend(param_1,"respData");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"appendData:",uVar1);
  _objc_release(uVar2);
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x20 bytes

void WechatAuthSDK::connection_didFailWithError_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  long lVar1;
  int iVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  
  uVar3 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_connectionfail_error___);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  lVar1 = param_1 + 0x10;
  lVar8 = _objc_loadWeakRetained(lVar1);
  if (lVar8 != 0) {
    uVar4 = _objc_loadWeakRetained(lVar1);
    iVar2 = _objc_msgSend(uVar4,"respondsToSelector:","onAuthFinish:AuthCode:");
    _objc_release(uVar4);
    _objc_release(lVar8);
    if (iVar2 != 0) {
      uVar4 = _objc_loadWeakRetained(lVar1);
      _objc_msgSend(uVar4,"onAuthFinish:AuthCode:",0xfffffffe,0);
      _objc_release(uVar4);
    }
  }
  resetAll(param_1,(SEL)"resetAll");
  _objc_release(uVar3);
  return;
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::connectionDidFinishLoading_(ID param_1,SEL param_2,ID param_3)

{
  unsigned_int uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  ID IVar4;
  long_long lVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ulong uVar8;
  
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSString,"alloc");
  _objc_msgSend(param_1,"respData");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  IVar4 = _objc_msgSend(uVar2,"initWithData:encoding:",uVar3,4);
  _objc_release(uVar3);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar5 = httpRetStatusCode(param_1,(SEL)"httpRetStatusCode");
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInteger:",lVar5);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_connectionDidFinishLoading_code___);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar3);
  _objc_release(uVar2);
  lVar5 = httpRetStatusCode(param_1,(SEL)"httpRetStatusCode");
  if ((lVar5 == 200) || (lVar5 = httpRetStatusCode(param_1,(SEL)"httpRetStatusCode"), lVar5 == 0xce)
     ) {
    _objc_msgSend(param_1,"respData");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_msgSend(uVar2,"length");
    uVar1 = retContentLength(param_1,(SEL)"retContentLength");
    _objc_release(uVar2);
    if (uVar8 < uVar1) {
      handleError_(param_1,(SEL)"handleError:",0xffffffff);
    }
    else {
      resetConnection(param_1,(SEL)"resetConnection");
      handleResponse_(param_1,(SEL)"handleResponse:",IVar4);
    }
  }
  else {
    handleError_(param_1,(SEL)"handleError:",0xfffffffe);
  }
  _objc_release(IVar4);
  return;
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::delegate(ID param_1,SEL param_2)

{
  ID IVar1;
  
  _objc_loadWeakRetained(param_1 + 0x10);
  IVar1 = _objc_autoreleaseReturnValue();
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setDelegate_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeWeak(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::sdkVersion(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 8);
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::connection(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x28);
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setConnection_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x28,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::respData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x30);
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setRespData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x30,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::uuid(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x38,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setUuid_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x38,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::qrCodeData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x40);
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setQrCodeData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x40,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::authCode(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x48,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setAuthCode_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x48,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WechatAuthSDK::timer(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x50);
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setTimer_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x50,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

long_long WechatAuthSDK::lastState(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x58);
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setLastState_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x58) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WechatAuthSDK::retContentLength(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x1c);
}



// Function Stack Size: 0x14 bytes

void WechatAuthSDK::setRetContentLength_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x1c) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WechatAuthSDK::status(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x20);
}



// Function Stack Size: 0x14 bytes

void WechatAuthSDK::setStatus_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x20) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool WechatAuthSDK::isAuthing(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0x18);
}



// Function Stack Size: 0x14 bytes

void WechatAuthSDK::setIsAuthing_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0x18) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

long_long WechatAuthSDK::httpRetStatusCode(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x60);
}



// Function Stack Size: 0x18 bytes

void WechatAuthSDK::setHttpRetStatusCode_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x60) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void WechatAuthSDK::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x50,0);
  _objc_storeStrong(param_1 + 0x48,0);
  _objc_storeStrong(param_1 + 0x40,0);
  _objc_storeStrong(param_1 + 0x38,0);
  _objc_storeStrong(param_1 + 0x30,0);
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_destroyWeak(param_1 + 0x10);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLogUtil::sharedInstance(ID param_1,SEL param_2)

{
  ID IVar1;
  SEL extraout_x1;
  undefined *local_38;
  undefined8 local_30;
  code *local_28;
  undefined *puStack_20;
  ID local_18;
  
  local_38 = PTR___NSConcreteStackBlock_00040028;
  local_30 = 0xc2000000;
  local_28 = ___27__WXLogUtil_sharedInstance__block_invoke;
  puStack_20 = &___block_descriptor_40_e8__e5_v8__0l;
  local_18 = param_1;
  if (_sharedInstance_onceToken != -1) {
    _dispatch_once(&_sharedInstance_onceToken,&local_38);
    param_2 = extraout_x1;
  }
  IVar1 = _objc_retainAutoreleaseReturnValue(_instance,param_2);
  return IVar1;
}



void ___27__WXLogUtil_sharedInstance__block_invoke(long param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar1 = _objc_msgSend(*(undefined8 *)(param_1 + 0x20),"alloc");
  uVar2 = _objc_msgSend(uVar1,"init");
  uVar1 = _instance;
  _instance = uVar2;
  _objc_release(uVar1);
  return;
}



void ___copy_helper_block_e8_(void)

{
  return;
}



void ___destroy_helper_block_e8_(void)

{
  return;
}



// Function Stack Size: 0x20 bytes

void WXLogUtil::configLogBlock_level_
               (ID param_1,SEL param_2,ID param_3,uint param_4,long_long param_5)

{
  int iVar1;
  ID IVar2;
  undefined8 uVar3;
  long_long lVar4;
  long lVar5;
  undefined4 uVar6;
  ulong uVar7;
  
  if (param_3 != 0) {
    uVar7 = (ulong)param_4;
    IVar2 = _objc_retain(param_3);
    uVar6 = (undefined4)uVar7;
    logDelegate(param_1,(SEL)"logDelegate");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar3,"respondsToSelector:","onLog:logLevel:");
    _objc_release(uVar3);
    if (iVar1 != 0) {
      logDelegate(param_1,(SEL)"logDelegate");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      lVar4 = logLevel(param_1,(SEL)"logLevel");
      uVar6 = (undefined4)lVar4;
      _objc_msgSend(uVar3,"onLog:logLevel:",&cf_changeintoprintlogbyblock);
      _objc_release(uVar3);
    }
    logBlock(param_1,(SEL)"logBlock");
    lVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar5 != 0) {
      logBlock(param_1,(SEL)"logBlock");
      lVar5 = _objc_retainAutoreleasedReturnValue();
      (**(code **)(lVar5 + 0x10))(lVar5,&cf_changeintoprintlogbyotherblock);
      _objc_release(lVar5);
    }
    setLogDelegate_(param_1,(SEL)"setLogDelegate:",0);
    setLogLevel_(param_1,(SEL)"setLogLevel:",(ulong)param_4);
    setLogBlock_(param_1,(SEL)"setLogBlock:",IVar2,uVar6);
    _objc_release(IVar2);
    return;
  }
  return;
}



// Function Stack Size: 0x20 bytes

void WXLogUtil::configLogDelegate_level_(ID param_1,SEL param_2,ID param_3,long_long param_4)

{
  int iVar1;
  ID IVar2;
  long lVar3;
  undefined8 uVar4;
  long_long lVar5;
  undefined4 uVar6;
  
  lVar5 = param_4;
  IVar2 = _objc_retain(param_3);
  uVar6 = (undefined4)lVar5;
  logDelegate(param_1,(SEL)"logDelegate");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_release();
  if (lVar3 == 0) {
    logBlock(param_1,(SEL)"logBlock");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar3 != 0) {
      logBlock(param_1,(SEL)"logBlock");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      (**(code **)(lVar3 + 0x10))(lVar3,&cf_changeintoprintlogbydelegate);
      _objc_release(lVar3);
    }
    logDelegate(param_1,(SEL)"logDelegate");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar4,"respondsToSelector:","onLog:logLevel:");
    _objc_release(uVar4);
    if (iVar1 != 0) {
      logDelegate(param_1,(SEL)"logDelegate");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      lVar5 = logLevel(param_1,(SEL)"logLevel");
      uVar6 = (undefined4)lVar5;
      _objc_msgSend(uVar4,"onLog:logLevel:",&cf_changeintoprintlogbyotherblock);
      _objc_release(uVar4);
    }
    setLogBlock_(param_1,(SEL)"setLogBlock:",0,uVar6);
    setLogLevel_(param_1,(SEL)"setLogLevel:",param_4);
    setLogDelegate_(param_1,(SEL)"setLogDelegate:",IVar2);
  }
  _objc_release(IVar2);
  return;
}



// Function Stack Size: 0x20 bytes

void WXLogUtil::printLog_level_(ID param_1,SEL param_2,ID param_3,long_long param_4)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  long_long lVar5;
  
  uVar2 = _objc_retain(param_3);
  if (param_4 == 1) {
    lVar5 = logLevel(param_1,(SEL)"logLevel");
    if (lVar5 != 1) goto LAB_00008d90;
    logDelegate(param_1,(SEL)"logDelegate");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar3,"respondsToSelector:","onLog:logLevel:");
    _objc_release(uVar3);
    if (iVar1 == 0) {
      logBlock(param_1,(SEL)"logBlock");
      lVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar4 == 0) goto LAB_00008d90;
      logBlock(param_1,(SEL)"logBlock");
      goto LAB_00008d74;
    }
    logDelegate(param_1,(SEL)"logDelegate");
    lVar4 = _objc_retainAutoreleasedReturnValue();
    lVar5 = logLevel(param_1,(SEL)"logLevel");
    _objc_msgSend(lVar4,"onLog:logLevel:",uVar2,lVar5);
  }
  else {
    if (param_4 != 0) goto LAB_00008d90;
    logDelegate(param_1,(SEL)"logDelegate");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar3,"respondsToSelector:","onLog:logLevel:");
    _objc_release(uVar3);
    if (iVar1 == 0) {
      logBlock(param_1,(SEL)"logBlock");
      lVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar4 == 0) goto LAB_00008d90;
      logBlock(param_1,(SEL)"logBlock");
LAB_00008d74:
      lVar4 = _objc_retainAutoreleasedReturnValue();
      (**(code **)(lVar4 + 0x10))(lVar4,uVar2);
    }
    else {
      logDelegate(param_1,(SEL)"logDelegate");
      lVar4 = _objc_retainAutoreleasedReturnValue();
      lVar5 = logLevel(param_1,(SEL)"logLevel");
      _objc_msgSend(lVar4,"onLog:logLevel:",uVar2,lVar5);
    }
  }
  _objc_release(lVar4);
LAB_00008d90:
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x10 bytes

void WXLogUtil::removeLog(ID param_1,SEL param_2)

{
  undefined4 in_w3;
  
  setLogBlock_(param_1,(SEL)"setLogBlock:",0,in_w3);
  setLogDelegate_(param_1,(SEL)"setLogDelegate:",0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLogUtil::logBlock(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLogUtil::setLogBlock_(ID param_1,SEL param_2,ID param_3,undefined4 param_4)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

long_long WXLogUtil::logLevel(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXLogUtil::setLogLevel_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x10) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLogUtil::logDelegate(ID param_1,SEL param_2)

{
  ID IVar1;
  
  _objc_loadWeakRetained(param_1 + 0x18);
  IVar1 = _objc_autoreleaseReturnValue();
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLogUtil::setLogDelegate_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeWeak(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXLogUtil::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_destroyWeak(param_1 + 0x18);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleRefreshTokenOpenUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  bool bVar12;
  undefined **ppuVar13;
  undefined8 local_68;
  
  uVar2 = _objc_retain(param_3);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_refreshToken,uVar2);
  if (iVar1 == 0) {
    bVar12 = 0;
    goto LAB_00009384;
  }
  _objc_msgSend(uVar2,"query");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_wechat_auth_token);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar5,"wxApi_stringByUnescapingFromURLArgument");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar5);
  _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_wechat_auth_context_id);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar5,"wxApi_stringByUnescapingFromURLArgument");
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar5);
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  local_68 = 0;
  iVar1 = _objc_msgSend(uVar5,"checkAndRecordTokenToKeychain:contextID:error:",uVar6,uVar7,&local_68
                       );
  lVar8 = _objc_retain(local_68);
  _objc_release(uVar5);
  if (iVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_checkorrecordtokenfail_error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar11,0);
    _objc_release(uVar11);
    _objc_release(uVar10);
    _objc_release(uVar9);
    _objc_release(uVar5);
    _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar9,"contextRequest");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar9);
    uVar9 = _objc_msgSend(&objc::class_t::SendMessageToWXReq,"class");
    uVar9 = _objc_msgSend(uVar10,"isKindOfClass:",uVar9);
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",uVar9);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"wxApi_safeSetObject:forKey:",uVar9,&cf_isShare);
    _objc_release(uVar9);
    if (lVar8 != 0) {
      uVar9 = _objc_msgSend(lVar8,"code");
      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInteger:",uVar9);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar5,"wxApi_safeSetObject:forKey:",uVar9,&cf_errCode);
      _objc_release(uVar9);
      _objc_msgSend(lVar8,"localizedDescription");
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar5,"wxApi_safeSetObject:forKey:",uVar9,&cf_errMsg);
      ppuVar13 = &PTR_s_delayLaunchWXWithRefreshTokenFai_00053228;
      goto LAB_00009310;
    }
    ppuVar13 = &PTR_s_delayLaunchWXWithRefreshTokenFai_00053228;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar9,"contextRequest");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar9);
    _objc_msgSend(uVar5,"wxApi_safeSetObject:forKey:",uVar10,&cf_contextReq);
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",0);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"wxApi_safeSetObject:forKey:",uVar9,&cf_forceScheme);
    _objc_release(uVar9);
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar9,"clearContext");
    ppuVar13 = &PTR_s_delaySendContextReq__000531f8;
LAB_00009310:
    _objc_release(uVar9);
  }
  _objc_msgSend(0x3fb999999999999a,param_1,"performSelector:withObject:afterDelay:",*ppuVar13,uVar5)
  ;
  _objc_release(uVar10);
  _objc_release(uVar5);
  _objc_release(lVar8);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar4);
  _objc_release(uVar3);
  bVar12 = 1;
LAB_00009384:
  _objc_release(uVar2);
  return bVar12;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleResendContextReqBySchemeOpenUrl_delegate_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  bool bVar1;
  int iVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ulong uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  bool bVar12;
  
  uVar3 = _objc_retain(param_3);
  iVar2 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_resendContextReqByScheme,
                        uVar3);
  if (iVar2 == 0) {
    bVar12 = 0;
  }
  else {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_handleresendcontextreqbyscheme);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_msgSend(uVar3,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_wechat_auth_context_id);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"wxApi_stringByUnescapingFromURLArgument");
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar6);
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_msgSend(uVar6,"checkContextID:",uVar7);
    _objc_release(uVar6);
    bVar1 = (uVar8 & 1) == 0;
    if (bVar1) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_cidnotmatch);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar11 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"printLog:level:",uVar11,0);
      _objc_release(uVar11);
      _objc_release(uVar9);
    }
    else {
      _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar9,"contextRequest");
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar9);
      _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar10,&cf_contextReq);
      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",1);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar9,&cf_forceScheme);
      _objc_release(uVar9);
      _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar9,"clearContext");
      _objc_release(uVar9);
      _objc_msgSend(0x3fb999999999999a,param_1,"performSelector:withObject:afterDelay:",
                    "delaySendContextReq:",uVar6);
    }
    bVar12 = (bool)!bVar1;
    _objc_release(uVar10);
    _objc_release(uVar6);
    _objc_release(uVar7);
    _objc_release(uVar5);
    _objc_release(uVar4);
  }
  _objc_release(uVar3);
  return bVar12;
}



// Function Stack Size: 0x18 bytes

void WXApi::checkAndRecordTokenFromOpenUrlParams_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(uVar2,"wxApi_stringForKey:",&cf_wechat_auth_token);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"wxApi_stringByUnescapingFromURLArgument");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar3);
  _objc_msgSend(uVar2,"wxApi_stringForKey:",&cf_wechat_auth_context_id);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  _objc_msgSend(uVar3,"wxApi_stringByUnescapingFromURLArgument");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar3);
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  iVar1 = _objc_msgSend(uVar3,"checkAndRecordTokenToKeychain:contextID:error:",uVar4,uVar2,0);
  _objc_release(uVar3);
  if (iVar1 != 0) {
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"clearContext");
    _objc_release(uVar3);
  }
  _objc_release(uVar2);
  _objc_release(uVar4);
  return;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleAuthOpenUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  ID IVar5;
  long lVar6;
  long lVar7;
  long lVar8;
  long lVar9;
  long lVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  long lVar16;
  undefined8 uVar17;
  undefined8 uVar18;
  bool bVar19;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_oauth,uVar2);
  if (iVar1 == 0) {
    bVar19 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:");
    IVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_code);
    lVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_reason);
    lVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_state);
    lVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_lang);
    lVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_country);
    lVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_tdi_auth_buffer);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar11,"wxApi_stringByUnescapingFromURLArgument");
    uVar12 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar11);
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"DecodeWithBase64:",uVar12);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_tdi_ext_info);
    uVar13 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_tdi_auth_params);
    uVar14 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar14,"wxApi_stringByUnescapingFromURLArgument");
    uVar15 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar14);
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"DecodeWithBase64:",uVar15);
    uVar14 = _objc_retainAutoreleasedReturnValue();
    lVar16 = _objc_msgSend(uVar13,"length");
    if (lVar16 == 0) {
      uVar17 = _objc_msgSend(&objc::class_t::SendAuthResp,"alloc");
      uVar17 = _objc_msgSend(uVar17,"init");
    }
    else {
      uVar17 = _objc_msgSend(&objc::class_t::SendTdiAuthResp,"alloc");
      uVar17 = _objc_msgSend(uVar17,"init");
      _objc_msgSend(uVar17,"setTdiAuthBuffer:",uVar11);
      _objc_msgSend(uVar17,"setTdiExtInfo:",uVar13);
      _objc_msgSend(uVar17,"setTdiAuthParams:",uVar14);
    }
    checkAndRecordTokenFromOpenUrlParams_
              (param_1,(SEL)"checkAndRecordTokenFromOpenUrlParams:",IVar5);
    if (lVar6 == 0) {
      _objc_msgSend(uVar17,"setErrCode:",0xffffffff);
      _objc_msgSend(uVar17,"setCode:",0);
    }
    else {
      iVar1 = _objc_msgSend(lVar6,"isEqualToString:",&cf_authdeny);
      if (iVar1 == 0) {
        _objc_msgSend(uVar17,"setErrCode:",0);
        lVar16 = lVar6;
      }
      else {
        _objc_msgSend(uVar17,"setErrCode:",0xfffffffc);
        lVar16 = 0;
      }
      _objc_msgSend(uVar17,"setCode:",lVar16);
    }
    if (lVar7 != 0) {
      _objc_msgSend(uVar17,"setErrStr:",lVar7);
    }
    if (lVar8 != 0) {
      _objc_msgSend(uVar17,"setState:");
    }
    if (lVar9 != 0) {
      _objc_msgSend(uVar17,"setLang:");
    }
    if (lVar10 != 0) {
      _objc_msgSend(uVar17,"setCountry:",lVar10);
    }
    _objc_msgSend(&objc::class_t::WapAuthHandler,"shareWapAuthHandlerInstance");
    uVar18 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar18,"endWapAuth");
    _objc_release(uVar18);
    if ((lVar3 != 0) && (iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:"), iVar1 != 0))
    {
      _objc_msgSend(lVar3,"onResp:",uVar17);
    }
    _objc_release(uVar17);
    _objc_release(uVar14);
    _objc_release(uVar15);
    _objc_release(uVar13);
    _objc_release(uVar11);
    _objc_release(uVar12);
    _objc_release(lVar10);
    _objc_release(lVar9);
    _objc_release(lVar8);
    _objc_release(lVar7);
    _objc_release(lVar6);
    _objc_release(IVar5);
    _objc_release(uVar4);
    bVar19 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar19;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleLaunchWxaRedirectingPage_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  bool bVar10;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_launchwxaredirectingpage,
                        uVar2);
  if (iVar1 == 0) {
    bVar10 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar4);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_ticket);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    uVar7 = _objc_msgSend(uVar5,"wxApi_integerForKey:",&cf_errcode);
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_errstr);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    uVar9 = _objc_msgSend(&objc::class_t::WXLaunchWxaRedirectingPageResp,"alloc");
    uVar9 = _objc_msgSend(uVar9,"init");
    _objc_msgSend(uVar9,"setTicket:",uVar6);
    _objc_msgSend(uVar9,"setErrCode:",uVar7);
    _objc_msgSend(uVar9,"setErrStr:",uVar8);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar9);
      }
    }
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    bVar10 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar10;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handlePayOpenUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  ID IVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  bool bVar9;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_pay,uVar2);
  if (iVar1 == 0) {
    bVar9 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar4);
    IVar5 = _objc_retainAutoreleasedReturnValue();
    checkAndRecordTokenFromOpenUrlParams_
              (param_1,(SEL)"checkAndRecordTokenFromOpenUrlParams:",IVar5);
    uVar6 = _objc_msgSend(&objc::class_t::PayResp,"alloc");
    uVar6 = _objc_msgSend(uVar6,"init");
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_returnKey);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setReturnKey:",uVar7);
    _objc_release(uVar7);
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_ret);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_msgSend(uVar7,"intValue");
    _objc_msgSend(uVar6,"setErrCode:",uVar8);
    _objc_release(uVar7);
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_notifyStr);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setErrStr:",uVar7);
    _objc_release(uVar7);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar6);
      }
    }
    _objc_release(uVar6);
    _objc_release(IVar5);
    _objc_release(uVar4);
    bVar9 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar9;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleJointPayOpenUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  ID IVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  bool bVar9;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_jointpay,uVar2);
  if (iVar1 == 0) {
    bVar9 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar4);
    IVar5 = _objc_retainAutoreleasedReturnValue();
    checkAndRecordTokenFromOpenUrlParams_
              (param_1,(SEL)"checkAndRecordTokenFromOpenUrlParams:",IVar5);
    uVar6 = _objc_msgSend(&objc::class_t::WXJointPayResp,"alloc");
    uVar6 = _objc_msgSend(uVar6,"init");
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_returnKey);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setReturnKey:",uVar7);
    _objc_release(uVar7);
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_ret);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_msgSend(uVar7,"intValue");
    _objc_msgSend(uVar6,"setErrCode:",uVar8);
    _objc_release(uVar7);
    _objc_msgSend(IVar5,"wxApi_stringForKey:",&cf_notifyStr);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setErrStr:",uVar7);
    _objc_release(uVar7);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar6);
      }
    }
    _objc_release(uVar6);
    _objc_release(IVar5);
    _objc_release(uVar4);
    bVar9 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar9;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOfflinePayUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  bool bVar8;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_offlinepay,uVar2);
  if (iVar1 == 0) {
    bVar8 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar4);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(&objc::class_t::WXOfflinePayResp,"alloc");
    uVar6 = _objc_msgSend(uVar6,"init");
    uVar7 = _objc_msgSend(uVar5,"wxApi_integerForKey:",&cf_ret);
    _objc_msgSend(uVar6,"setErrCode:",uVar7);
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_errStr);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setErrStr:",uVar7);
    _objc_release(uVar7);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar6);
      }
    }
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    bVar8 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar8;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenTypeWebViewWithNontaxpay_delegate_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  bool bVar7;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar2);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
  iVar1 = _objc_msgSend(uVar5,"isKindOfClass:",uVar2);
  if (iVar1 == 0) {
    bVar7 = 0;
  }
  else {
    _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar2,"isEqualToString:",&cf_nontaxpay);
    _objc_release(uVar2);
    _objc_release(uVar5);
    if (iVar1 == 0) {
      bVar7 = 0;
      goto LAB_0000a7a0;
    }
    uVar2 = _objc_msgSend(&objc::class_t::WXNontaxPayResp,"alloc");
    uVar5 = _objc_msgSend(uVar2,"init");
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_ret);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(uVar2,"intValue");
    _objc_msgSend(uVar5,"setErrCode:",uVar6);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_wx_order_id);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setWxOrderId:",uVar2);
    _objc_release(uVar2);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar5);
      }
    }
    bVar7 = 1;
  }
  _objc_release(uVar5);
LAB_0000a7a0:
  _objc_release(uVar4);
  _objc_release(lVar3);
  return bVar7;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenTypeWebViewWithPayInsurance_delegate_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  bool bVar7;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar2);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
  iVar1 = _objc_msgSend(uVar5,"isKindOfClass:",uVar2);
  if (iVar1 == 0) {
    bVar7 = 0;
  }
  else {
    _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar2,"isEqualToString:",&cf_payinsurance);
    _objc_release(uVar2);
    _objc_release(uVar5);
    if (iVar1 == 0) {
      bVar7 = 0;
      goto LAB_0000a9c4;
    }
    uVar2 = _objc_msgSend(&objc::class_t::WXPayInsuranceResp,"alloc");
    uVar5 = _objc_msgSend(uVar2,"init");
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_ret);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(uVar2,"intValue");
    _objc_msgSend(uVar5,"setErrCode:",uVar6);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_wx_order_id);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setWxOrderId:",uVar2);
    _objc_release(uVar2);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar5);
      }
    }
    bVar7 = 1;
  }
  _objc_release(uVar5);
LAB_0000a9c4:
  _objc_release(uVar4);
  _objc_release(lVar3);
  return bVar7;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleAddCardOpenUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  long lVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  ulong uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  undefined8 uVar17;
  bool bVar18;
  ulong uVar19;
  long lVar20;
  undefined8 local_130;
  long lStack_128;
  long *local_120;
  undefined8 uStack_118;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined8 uStack_100;
  undefined8 uStack_f8;
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  uVar3 = _objc_retain(param_3);
  lVar4 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_cardPackage,uVar3);
  if (iVar1 == 0) {
    bVar18 = 0;
  }
  else {
    _objc_msgSend(uVar3,"query");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar5);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"wxApi_stringForKey:",&cf_errCode);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    uVar2 = _objc_msgSend();
    _objc_release(uVar7);
    _objc_msgSend(uVar6,"wxApi_stringForKey:",&cf_addCardInfo);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    lVar9 = _objc_msgSend();
    uVar7 = uVar8;
    if (lVar9 != 0) {
      _objc_msgSend(uVar8,"stringByReplacingPercentEscapesUsingEncoding:",4);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar8);
    }
    _objc_msgSend(uVar7,"dataUsingEncoding:",4);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSMutableArray,"array");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"JSONObjectWithData:options:error:",uVar8,0,0);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    uVar12 = _objc_msgSend(&_OBJC_CLASS___NSArray,"class");
    iVar1 = _objc_msgSend(uVar11,"isKindOfClass:",uVar12);
    if (iVar1 != 0) {
      uVar12 = _objc_retain(uVar11);
      lStack_128 = 0;
      local_130 = 0;
      uStack_118 = 0;
      local_120 = (long *)0x0;
      uStack_108 = 0;
      local_110 = 0;
      uStack_f8 = 0;
      uStack_100 = 0;
      uVar13 = _objc_msgSend(uVar12,"countByEnumeratingWithState:objects:count:",&local_130,
                             auStack_f0,0x10);
      if (uVar13 != 0) {
        lVar9 = *local_120;
        do {
          uVar19 = 0;
          do {
            if (*local_120 != lVar9) {
              _objc_enumerationMutation(uVar12);
            }
            lVar20 = *(long *)(lStack_128 + uVar19 * 8);
            if (lVar20 != 0) {
              uVar14 = _objc_msgSend(&_OBJC_CLASS___NSDictionary,"class");
              iVar1 = _objc_msgSend(lVar20,"isKindOfClass:",uVar14);
              if (iVar1 != 0) {
                uVar14 = _objc_retain(lVar20);
                uVar15 = _objc_msgSend(&objc::class_t::WXCardItem,"alloc");
                uVar15 = _objc_msgSend(uVar15,"init");
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_card_id);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setCardId:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_card_ext);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setExtMsg:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_code);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setEncryptCode:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_is_succ);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                uVar17 = _objc_msgSend(uVar16,"intValue");
                _objc_msgSend(uVar15,"setCardState:",uVar17);
                _objc_release(uVar16);
                _objc_msgSend(uVar15,"cardId");
                uVar16 = _objc_retainAutoreleasedReturnValue();
                lVar20 = _objc_msgSend(uVar16,"length");
                _objc_release(uVar16);
                if (lVar20 != 0) {
                  _objc_msgSend(uVar10,"wxApi_safeAddObject:",uVar15);
                }
                _objc_release(uVar15);
                _objc_release(uVar14);
              }
            }
            uVar19 = uVar19 + 1;
          } while (uVar19 < uVar13);
          uVar13 = _objc_msgSend(uVar12,"countByEnumeratingWithState:objects:count:",&local_130,
                                 auStack_f0,0x10);
        } while (uVar13 != 0);
      }
      _objc_release(uVar12);
    }
    uVar12 = _objc_msgSend(&objc::class_t::AddCardToWXCardPackageResp,"alloc");
    uVar12 = _objc_msgSend(uVar12,"init");
    _objc_msgSend(uVar12,"setErrCode:",uVar2);
    _objc_msgSend(uVar12,"setCardAry:",uVar10);
    if (lVar4 != 0) {
      iVar1 = _objc_msgSend(lVar4,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar4,"onResp:",uVar12);
      }
    }
    _objc_release(uVar12);
    _objc_release(uVar11);
    _objc_release(uVar10);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    bVar18 = 1;
  }
  _objc_release(lVar4);
  _objc_release(uVar3);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_70) {
    return bVar18;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleChooseCard_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  long lVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  ulong uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  bool bVar17;
  long lVar18;
  ulong uVar19;
  undefined8 local_130;
  long lStack_128;
  long *local_120;
  undefined8 uStack_118;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined8 uStack_100;
  undefined8 uStack_f8;
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  uVar3 = _objc_retain(param_3);
  lVar4 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_choosecard,uVar3);
  if (iVar1 == 0) {
    bVar17 = 0;
  }
  else {
    _objc_msgSend(uVar3,"query");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar5);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"wxApi_stringForKey:",&cf_errCode);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    uVar2 = _objc_msgSend(uVar7,"intValue");
    _objc_release(uVar7);
    _objc_msgSend(uVar6,"wxApi_stringForKey:",&cf_chooseCardInfo);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    lVar9 = _objc_msgSend();
    uVar7 = uVar8;
    if (lVar9 != 0) {
      _objc_msgSend(uVar8,"stringByReplacingPercentEscapesUsingEncoding:",4);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar8);
    }
    _objc_msgSend(uVar7,"dataUsingEncoding:",4);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSMutableArray,"array");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"JSONObjectWithData:options:error:",uVar8,0,0);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    uVar12 = _objc_msgSend(&_OBJC_CLASS___NSArray,"class");
    iVar1 = _objc_msgSend(uVar11,"isKindOfClass:",uVar12);
    if (iVar1 != 0) {
      uVar12 = _objc_retain(uVar11);
      lStack_128 = 0;
      local_130 = 0;
      uStack_118 = 0;
      local_120 = (long *)0x0;
      uStack_108 = 0;
      local_110 = 0;
      uStack_f8 = 0;
      uStack_100 = 0;
      uVar13 = _objc_msgSend(uVar12,"countByEnumeratingWithState:objects:count:",&local_130,
                             auStack_f0,0x10);
      if (uVar13 != 0) {
        lVar9 = *local_120;
        do {
          uVar19 = 0;
          do {
            if (*local_120 != lVar9) {
              _objc_enumerationMutation(uVar12);
            }
            lVar18 = *(long *)(lStack_128 + uVar19 * 8);
            if (lVar18 != 0) {
              uVar14 = _objc_msgSend(&_OBJC_CLASS___NSDictionary,"class");
              iVar1 = _objc_msgSend(lVar18,"isKindOfClass:",uVar14);
              if (iVar1 != 0) {
                uVar14 = _objc_retain(lVar18);
                uVar15 = _objc_msgSend(&objc::class_t::WXCardItem,"alloc");
                uVar15 = _objc_msgSend(uVar15,"init");
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_card_id);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setCardId:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_encrypt_code);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setEncryptCode:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_app_id);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setAppID:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar15,"cardId");
                uVar16 = _objc_retainAutoreleasedReturnValue();
                lVar18 = _objc_msgSend(uVar16,"length");
                _objc_release(uVar16);
                if (lVar18 != 0) {
                  _objc_msgSend(uVar10,"wxApi_safeAddObject:",uVar15);
                }
                _objc_release(uVar15);
                _objc_release(uVar14);
              }
            }
            uVar19 = uVar19 + 1;
          } while (uVar19 < uVar13);
          uVar13 = _objc_msgSend(uVar12,"countByEnumeratingWithState:objects:count:",&local_130,
                                 auStack_f0,0x10);
        } while (uVar13 != 0);
      }
      _objc_release(uVar12);
    }
    uVar12 = _objc_msgSend(&objc::class_t::WXChooseCardResp,"alloc");
    uVar12 = _objc_msgSend(uVar12,"init");
    _objc_msgSend(uVar12,"setErrCode:",uVar2);
    _objc_msgSend(uVar12,"setCardAry:",uVar10);
    if (lVar4 != 0) {
      iVar1 = _objc_msgSend(lVar4,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar4,"onResp:",uVar12);
      }
    }
    _objc_release(uVar12);
    _objc_release(uVar11);
    _objc_release(uVar10);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    bVar17 = 1;
  }
  _objc_release(lVar4);
  _objc_release(uVar3);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_70) {
    return bVar17;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleChooseInvoice_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  long lVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  ulong uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  bool bVar17;
  long lVar18;
  ulong uVar19;
  undefined8 local_130;
  long lStack_128;
  long *local_120;
  undefined8 uStack_118;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined8 uStack_100;
  undefined8 uStack_f8;
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  uVar3 = _objc_retain(param_3);
  lVar4 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_chooseinvoice,uVar3);
  if (iVar1 == 0) {
    bVar17 = 0;
  }
  else {
    _objc_msgSend(uVar3,"query");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar5);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"wxApi_stringForKey:",&cf_errCode);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    uVar2 = _objc_msgSend(uVar7,"intValue");
    _objc_release(uVar7);
    _objc_msgSend(uVar6,"wxApi_stringForKey:",&cf_chooseInvoiceInfo);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    lVar9 = _objc_msgSend();
    uVar7 = uVar8;
    if (lVar9 != 0) {
      _objc_msgSend(uVar8,"stringByReplacingPercentEscapesUsingEncoding:",4);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar8);
    }
    _objc_msgSend(uVar7,"dataUsingEncoding:",4);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSMutableArray,"array");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"JSONObjectWithData:options:error:",uVar8,0,0);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    uVar12 = _objc_msgSend(&_OBJC_CLASS___NSArray,"class");
    iVar1 = _objc_msgSend(uVar11,"isKindOfClass:",uVar12);
    if (iVar1 != 0) {
      uVar12 = _objc_retain(uVar11);
      lStack_128 = 0;
      local_130 = 0;
      uStack_118 = 0;
      local_120 = (long *)0x0;
      uStack_108 = 0;
      local_110 = 0;
      uStack_f8 = 0;
      uStack_100 = 0;
      uVar13 = _objc_msgSend(uVar12,"countByEnumeratingWithState:objects:count:",&local_130,
                             auStack_f0,0x10);
      if (uVar13 != 0) {
        lVar9 = *local_120;
        do {
          uVar19 = 0;
          do {
            if (*local_120 != lVar9) {
              _objc_enumerationMutation(uVar12);
            }
            lVar18 = *(long *)(lStack_128 + uVar19 * 8);
            if (lVar18 != 0) {
              uVar14 = _objc_msgSend(&_OBJC_CLASS___NSDictionary,"class");
              iVar1 = _objc_msgSend(lVar18,"isKindOfClass:",uVar14);
              if (iVar1 != 0) {
                uVar14 = _objc_retain(lVar18);
                uVar15 = _objc_msgSend(&objc::class_t::WXInvoiceItem,"alloc");
                uVar15 = _objc_msgSend(uVar15,"init");
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_card_id);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setCardId:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_encrypt_code);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setEncryptCode:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar14,"wxApi_stringForKey:",&cf_app_id);
                uVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar15,"setAppID:",uVar16);
                _objc_release(uVar16);
                _objc_msgSend(uVar15,"cardId");
                uVar16 = _objc_retainAutoreleasedReturnValue();
                lVar18 = _objc_msgSend(uVar16,"length");
                _objc_release(uVar16);
                if (lVar18 != 0) {
                  _objc_msgSend(uVar10,"wxApi_safeAddObject:",uVar15);
                }
                _objc_release(uVar15);
                _objc_release(uVar14);
              }
            }
            uVar19 = uVar19 + 1;
          } while (uVar19 < uVar13);
          uVar13 = _objc_msgSend(uVar12,"countByEnumeratingWithState:objects:count:",&local_130,
                                 auStack_f0,0x10);
        } while (uVar13 != 0);
      }
      _objc_release(uVar12);
    }
    uVar12 = _objc_msgSend(&objc::class_t::WXChooseInvoiceResp,"alloc");
    uVar12 = _objc_msgSend(uVar12,"init");
    _objc_msgSend(uVar12,"setErrCode:",uVar2);
    _objc_msgSend(uVar12,"setCardAry:",uVar10);
    if (lVar4 != 0) {
      iVar1 = _objc_msgSend(lVar4,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar4,"onResp:",uVar12);
      }
    }
    _objc_release(uVar12);
    _objc_release(uVar11);
    _objc_release(uVar10);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    bVar17 = 1;
  }
  _objc_release(lVar4);
  _objc_release(uVar3);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_70) {
    return bVar17;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenWebviewOpenUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  bool bVar9;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_openwebview,uVar2);
  if (iVar1 == 0) {
    bVar9 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar4);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(&objc::class_t::OpenWebviewResp,"alloc");
    uVar6 = _objc_msgSend(uVar6,"init");
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_ret);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_msgSend(uVar7,"intValue");
    _objc_msgSend(uVar6,"setErrCode:",uVar8);
    _objc_release(uVar7);
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_notifyStr);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setErrStr:",uVar7);
    _objc_release(uVar7);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar6);
      }
    }
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    bVar9 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar9;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenBusinessWebviewOpenUrl_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  bool bVar9;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_openbusinesswebview,uVar2);
  if (iVar1 == 0) {
    bVar9 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar4);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(&objc::class_t::WXOpenBusinessWebViewResp,"alloc");
    uVar6 = _objc_msgSend(uVar6,"init");
    uVar7 = _objc_msgSend(uVar5,"wxApi_integerForKey:",&cf_ret);
    _objc_msgSend(uVar6,"setErrCode:",uVar7);
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_errmsg);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setErrStr:",uVar7);
    _objc_release(uVar7);
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_resultInfo);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar7,"wxApi_stringByUnescapingFromURLArgument");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setResult:",uVar8);
    _objc_release(uVar8);
    _objc_release(uVar7);
    uVar7 = _objc_msgSend(uVar5,"wxApi_integerForKey:",&cf_type);
    _objc_msgSend(uVar6,"setBusinessType:",uVar7);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar6);
      }
    }
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    bVar9 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar9;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenRankList_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  bool bVar9;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_openranklist,uVar2);
  if (iVar1 == 0) {
    bVar9 = 0;
  }
  else {
    _objc_msgSend(uVar2,"query");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar4);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(&objc::class_t::OpenRankListResp,"alloc");
    uVar6 = _objc_msgSend(uVar6,"init");
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_ret);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_msgSend(uVar7,"intValue");
    _objc_msgSend(uVar6,"setErrCode:",uVar8);
    _objc_release(uVar7);
    _objc_msgSend(uVar5,"wxApi_stringForKey:",&cf_notifyStr);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"setErrStr:",uVar7);
    _objc_release(uVar7);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar6);
      }
    }
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    bVar9 = 1;
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar9;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenTypeWebView_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  bool bVar2;
  undefined8 uVar3;
  ID IVar4;
  ID IVar5;
  
  uVar3 = _objc_retain(param_3);
  IVar4 = _objc_retain(param_4);
  iVar1 = _objc_msgSend(&objc::class_t::WXApi,"isURLContainApi:url:",&cf_opentypewebview,uVar3);
  if (iVar1 == 0) {
    bVar2 = 0;
  }
  else {
    _objc_msgSend(uVar3,"query");
    IVar5 = _objc_retainAutoreleasedReturnValue();
    bVar2 = handleOpenTypeWebViewWithSubscribeMsg_delegate_
                      (param_1,(SEL)"handleOpenTypeWebViewWithSubscribeMsg:delegate:",IVar5,IVar4);
    if (((((bVar2 & 1) == 0) &&
         (bVar2 = handleOpenTypeWebViewWithInvoiceAuthInsert_delegate_
                            (param_1,(SEL)"handleOpenTypeWebViewWithInvoiceAuthInsert:delegate:",
                             IVar5,IVar4), (bVar2 & 1) == 0)) &&
        (bVar2 = handleOpenTypeWebViewWithNontaxpay_delegate_
                           (param_1,(SEL)"handleOpenTypeWebViewWithNontaxpay:delegate:",IVar5,IVar4)
        , (bVar2 & 1) == 0)) &&
       (bVar2 = handleOpenTypeWebViewWithPayInsurance_delegate_
                          (param_1,(SEL)"handleOpenTypeWebViewWithPayInsurance:delegate:",IVar5,
                           IVar4), (bVar2 & 1) == 0)) {
      bVar2 = handleOpenTypeWebViewWithSubscribeMiniProgramMsg_delegate_
                        (param_1,(SEL)"handleOpenTypeWebViewWithSubscribeMiniProgramMsg:delegate:",
                         IVar5,IVar4);
    }
    else {
      bVar2 = 1;
    }
    _objc_release(IVar5);
  }
  _objc_release(IVar4);
  _objc_release(uVar3);
  return bVar2;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenTypeWebViewWithSubscribeMsg_delegate_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  bool bVar7;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar2);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
  iVar1 = _objc_msgSend(uVar5,"isKindOfClass:",uVar2);
  if (iVar1 == 0) {
    bVar7 = 0;
  }
  else {
    _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar2,"isEqualToString:",&cf_subscribemessage);
    _objc_release(uVar2);
    _objc_release(uVar5);
    if (iVar1 == 0) {
      bVar7 = 0;
      goto LAB_0000c490;
    }
    uVar2 = _objc_msgSend(&objc::class_t::WXSubscribeMsgResp,"alloc");
    uVar5 = _objc_msgSend(uVar2,"init");
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_ret);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(uVar2,"intValue");
    _objc_msgSend(uVar5,"setErrCode:",uVar6);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_errmsg);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setErrStr:",uVar2);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_openid);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setOpenId:",uVar2);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_template_id);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setTemplateId:",uVar2);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_action);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setAction:",uVar2);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_scene);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(uVar2,"integerValue");
    _objc_msgSend(uVar5,"setScene:",uVar6);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_reserved);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setReserved:",uVar2);
    _objc_release(uVar2);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar5);
      }
    }
    bVar7 = 1;
  }
  _objc_release(uVar5);
LAB_0000c490:
  _objc_release(uVar4);
  _objc_release(lVar3);
  return bVar7;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenTypeWebViewWithInvoiceAuthInsert_delegate_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  bool bVar7;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar2);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
  iVar1 = _objc_msgSend(uVar5,"isKindOfClass:",uVar2);
  if (iVar1 == 0) {
    bVar7 = 0;
  }
  else {
    _objc_msgSend(uVar4,"objectForKey:",&cf_wx_internal_resptype);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar2,"isEqualToString:",&cf_invoice_auth_insert);
    _objc_release(uVar2);
    _objc_release(uVar5);
    if (iVar1 == 0) {
      bVar7 = 0;
      goto LAB_0000c6b4;
    }
    uVar2 = _objc_msgSend(&objc::class_t::WXInvoiceAuthInsertResp,"alloc");
    uVar5 = _objc_msgSend(uVar2,"init");
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_ret);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(uVar2,"intValue");
    _objc_msgSend(uVar5,"setErrCode:",uVar6);
    _objc_release(uVar2);
    _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_wx_order_id);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"setWxOrderId:",uVar2);
    _objc_release(uVar2);
    if (lVar3 != 0) {
      iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
      if (iVar1 != 0) {
        _objc_msgSend(lVar3,"onResp:",uVar5);
      }
    }
    bVar7 = 1;
  }
  _objc_release(uVar5);
LAB_0000c6b4:
  _objc_release(uVar4);
  _objc_release(lVar3);
  return bVar7;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenTypeWebViewWithSubscribeMiniProgramMsg_delegate_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  long lVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  bool bVar9;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar2);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_wx_internal_resptype);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar5 = _objc_msgSend(uVar2,"length");
  if ((lVar5 == 0) ||
     (iVar1 = _objc_msgSend(uVar2,"isEqualToString:",&cf_subscribeminiprogrammsg), iVar1 != 0)) {
    lVar5 = _objc_msgSend(uVar2,"length");
    if ((lVar5 != 0) ||
       (lVar5 = _objc_msgSend(uVar4,"wxApi_integerForKey:",&cf_wx_internal_resptype), lVar5 == 5)) {
      uVar6 = _objc_msgSend(&objc::class_t::WXSubscribeMiniProgramMsgResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
      uVar7 = _objc_msgSend(uVar4,"wxApi_integerForKey:",&cf_ret);
      _objc_msgSend(uVar6,"setErrCode:",uVar7);
      _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_openid);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar7,"wxApi_stringByUnescapingFromURLArgument");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"setOpenId:",uVar8);
      _objc_release(uVar8);
      _objc_release(uVar7);
      _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_unionid);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar7,"wxApi_stringByUnescapingFromURLArgument");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"setUnionId:",uVar8);
      _objc_release(uVar8);
      _objc_release(uVar7);
      _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_nickname);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar7,"wxApi_stringByUnescapingFromURLArgument");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"setNickName:",uVar8);
      _objc_release(uVar8);
      _objc_release(uVar7);
      _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_errmsg);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"setErrStr:",uVar7);
      _objc_release(uVar7);
      if (lVar3 != 0) {
        iVar1 = _objc_msgSend(lVar3,"respondsToSelector:","onResp:");
        if (iVar1 != 0) {
          _objc_msgSend(lVar3,"onResp:",uVar6);
        }
      }
      _objc_release(uVar6);
      bVar9 = 1;
      goto LAB_0000c9a8;
    }
  }
  bVar9 = 0;
LAB_0000c9a8:
  _objc_release(uVar2);
  _objc_release(uVar4);
  _objc_release(lVar3);
  return bVar9;
}



// Function Stack Size: 0x18 bytes

bool WXApi::handleOpenUniversalLinkCheck_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ulong uVar7;
  undefined8 uVar8;
  long lVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  ID IVar12;
  undefined4 uVar13;
  long_long lVar14;
  bool bVar15;
  cfstringStruct *pcVar16;
  ID in_x7;
  
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(uVar2,"query");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"parseURLParams:",uVar3);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"wxApi_stringForKey:",&cf_wechat_auth_context_id);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar5,"wxApi_stringByUnescapingFromURLArgument");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar5);
  _objc_msgSend(uVar6,"length");
  uVar7 = _objc_msgSend(uVar6,"isEqualToString:",
                        &cf_TestAutoCheckContextId_e312a10b4bded6115265bad238dd488d3db7f78d);
  if ((uVar7 & 1) == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____contextID___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar11,0);
    _objc_release(uVar11);
    _objc_release(uVar10);
    _objc_release(uVar8);
    bVar15 = 0;
    goto LAB_0000cda8;
  }
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  lVar9 = _objc_msgSend(uVar8,"length");
  if (lVar9 == 0) {
    _objc_release(uVar8);
code_r0x0000cd0c:
    _objc_msgSend(uVar5,"checkCompletion");
    lVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar9 != 0) {
      _objc_msgSend(uVar5,"checkCompletion");
      IVar12 = _objc_retainAutoreleasedReturnValue();
      bVar15 = 0x412d0;
      pcVar16 = &cf_C;
      uVar13 = 5;
      lVar14 = 0;
LAB_0000cd70:
      checkUniversalLinkCallback_step_success_errorInfo_suggestion_
                (param_1,(SEL)"checkUniversalLinkCallback:step:success:errorInfo:suggestion:",IVar12
                 ,uVar13,lVar14,bVar15,(ID)pcVar16,in_x7);
      _objc_release(IVar12);
    }
  }
  else {
    _objc_msgSend(uVar2,"absoluteString");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
    uVar11 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar10,"hasPrefix:",uVar11);
    _objc_release(uVar11);
    _objc_release(uVar10);
    _objc_release(uVar8);
    if (iVar1 == 0) goto code_r0x0000cd0c;
    _objc_msgSend(uVar5,"checkCompletion");
    lVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar9 != 0) {
      _objc_msgSend(uVar5,"checkCompletion");
      IVar12 = _objc_retainAutoreleasedReturnValue();
      checkUniversalLinkCallback_step_success_errorInfo_suggestion_
                (param_1,(SEL)"checkUniversalLinkCallback:step:success:errorInfo:suggestion:",IVar12
                 ,5,1,0x41270,0x412b0,in_x7);
      _objc_release(IVar12);
      _objc_msgSend(uVar5,"checkCompletion");
      IVar12 = _objc_retainAutoreleasedReturnValue();
      bVar15 = 0x41290;
      uVar13 = 6;
      lVar14 = 1;
      pcVar16 = &cf___;
      goto LAB_0000cd70;
    }
  }
  _objc_msgSend(uVar5,"setUniversalLinkCheckEnable:",0);
  _objc_msgSend(uVar5,"setCheckCompletion:",0);
  bVar15 = 1;
LAB_0000cda8:
  _objc_release(uVar5);
  _objc_release(uVar6);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar15;
}



// Function Stack Size: 0x18 bytes

ID WXWebViewController::initWithDelegate_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  ID IVar2;
  ID local_40;
  class_t *pcStack_38;
  
  uVar1 = _objc_retain(param_3);
  pcStack_38 = &objc::class_t::WXWebViewController;
  local_40 = param_1;
  IVar2 = _objc_msgSendSuper2(&local_40,"init");
  if (IVar2 != 0) {
    _objc_storeStrong(IVar2 + (long)_delegate,param_3);
  }
  _objc_release(uVar1);
  return IVar2;
}



// Function Stack Size: 0x10 bytes

void WXWebViewController::viewDidLoad(ID param_1,SEL param_2)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID local_50;
  class_t *pcStack_48;
  
  pcStack_48 = &objc::class_t::WXWebViewController;
  local_50 = param_1;
  _objc_msgSendSuper2(&local_50,"viewDidLoad");
  iVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isiOS13plus");
  if (((iVar1 == 0) || (iVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isiPad"), iVar1 == 0))
     || (lVar2 = _NSClassFromString(&cf_WKWebpagePreferences), lVar2 == 0)) {
    lVar4 = 0;
  }
  else {
    uVar3 = _objc_msgSend(&_OBJC_CLASS___WKWebViewConfiguration,"alloc");
    lVar4 = _objc_msgSend(uVar3,"init");
    uVar3 = _objc_msgSend(lVar2,"alloc");
    uVar3 = _objc_msgSend(uVar3,"init");
    _objc_msgSend(lVar4,"setDefaultWebpagePreferences:",uVar3);
    _objc_release(uVar3);
    _objc_msgSend(lVar4,"defaultWebpagePreferences");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"setPreferredContentMode:",1);
    _objc_release(uVar3);
  }
  uVar3 = _objc_msgSend(&_OBJC_CLASS___WKWebView,"alloc");
  _objc_msgSend(&_OBJC_CLASS___UIScreen,"mainScreen");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar5,"bounds");
  if (lVar4 == 0) {
    uVar3 = _objc_msgSend(uVar3,"initWithFrame:");
  }
  else {
    uVar3 = _objc_msgSend(uVar3,"initWithFrame:configuration:",lVar4);
  }
  lVar2 = (long)_webView;
  uVar6 = *(undefined8 *)(param_1 + lVar2);
  *(undefined8 *)(param_1 + lVar2) = uVar3;
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_msgSend(*(undefined8 *)(param_1 + lVar2),"setAutoresizingMask:",0x12);
  _objc_msgSend(*(undefined8 *)(param_1 + lVar2),"setNavigationDelegate:",param_1);
  _objc_msgSend(*(undefined8 *)(param_1 + lVar2),"setUserInteractionEnabled:",1);
  _objc_msgSend(param_1,"view");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"addSubview:",*(undefined8 *)(param_1 + lVar2));
  _objc_release(uVar3);
  _objc_release(lVar4);
  return;
}



// Function Stack Size: 0x18 bytes

void WXWebViewController::refresh_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  uVar3 = *(undefined8 *)(param_1 + (long)_webView);
  _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSURLRequest,"requestWithURL:",uVar1);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"loadRequest:",uVar2);
  _objc_retainAutoreleasedReturnValue();
  _objc_release();
  _objc_release(uVar2);
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x28 bytes

void WXWebViewController::webView_decidePolicyForNavigationAction_decisionHandler_
               (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5,undefined4 param_6)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  code *pcVar10;
  
  uVar2 = _objc_retain(param_4);
  lVar3 = _objc_retain(param_5);
  _objc_msgSend(uVar2,"request");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"URL");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar5,"absoluteString");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  iVar1 = _objc_msgSend(uVar6,"hasPrefix:",&cf_http);
  if (iVar1 == 0) {
    _objc_msgSend(uVar2,"request");
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar7,"URL");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"absoluteString");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar9,"hasPrefix:",&cf_https);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    if (iVar1 != 0) goto LAB_0000d2a0;
    _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"request");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"URL");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar4,"openURL:",uVar6);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    pcVar10 = *(code **)(lVar3 + 0x10);
    if (iVar1 != 0) {
      uVar4 = 0;
      goto LAB_0000d2ac;
    }
  }
  else {
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
LAB_0000d2a0:
    pcVar10 = *(code **)(lVar3 + 0x10);
  }
  uVar4 = 1;
LAB_0000d2ac:
  (*pcVar10)(lVar3,uVar4);
  _objc_release(lVar3);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x10 bytes

void WXWebViewController::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_delegate,0);
  _objc_storeStrong(param_1 + (long)_webView,0);
  return;
}



// Function Stack Size: 0x10 bytes

void WapAuthHandler::onHiddenLeftBar(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  
  _objc_msgSend(*(undefined8 *)(param_1 + 8),"navigationItem");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"setLeftBarButtonItem:",0);
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x10 bytes

void WapAuthHandler::onShowLeftBar(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar1 = _objc_msgSend(&_OBJC_CLASS___UIBarButtonItem,"alloc");
  uVar1 = _objc_msgSend(uVar1,"initWithTitle:style:target:action:",&cf_Sm,1,param_1,"cancelWapOAuth"
                       );
  _objc_msgSend(*(undefined8 *)(param_1 + 8),"navigationItem");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"setLeftBarButtonItem:",uVar1);
  _objc_release(uVar2);
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x18 bytes

ID WapAuthHandler::parseURLParams_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ulong uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  long lVar8;
  ulong uVar9;
  undefined8 local_130;
  long lStack_128;
  long *local_120;
  undefined8 uStack_118;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined8 uStack_100;
  undefined8 uStack_f8;
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  _objc_msgSend(param_3,"componentsSeparatedByString:",&cf__);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"alloc");
  uVar2 = _objc_msgSend(uVar2,"init");
  lStack_128 = 0;
  local_130 = 0;
  uStack_118 = 0;
  local_120 = (long *)0x0;
  uStack_108 = 0;
  local_110 = 0;
  uStack_f8 = 0;
  uStack_100 = 0;
  uVar1 = _objc_retain(uVar1);
  uVar3 = _objc_msgSend(uVar1,"countByEnumeratingWithState:objects:count:",&local_130,auStack_f0,
                        0x10);
  if (uVar3 != 0) {
    lVar8 = *local_120;
    do {
      uVar9 = 0;
      do {
        if (*local_120 != lVar8) {
          _objc_enumerationMutation(uVar1);
        }
        _objc_msgSend(*(undefined8 *)(lStack_128 + uVar9 * 8),"componentsSeparatedByString:",&cf__);
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar4,"objectAtIndex:",1);
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar4,"objectAtIndex:",0);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar5,uVar6);
        _objc_release(uVar6);
        _objc_release(uVar5);
        _objc_release(uVar4);
        uVar9 = uVar9 + 1;
      } while (uVar9 < uVar3);
      uVar3 = _objc_msgSend(uVar1,"countByEnumeratingWithState:objects:count:",&local_130,auStack_f0
                            ,0x10);
    } while (uVar3 != 0);
  }
  _objc_release(uVar1);
  _objc_release(uVar1);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_70) {
    IVar7 = _objc_autoreleaseReturnValue(uVar2);
    return IVar7;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x10 bytes

ID WapAuthHandler::shareWapAuthHandlerInstance(ID param_1,SEL param_2)

{
  ID IVar1;
  SEL extraout_x1;
  
  if (_shareWapAuthHandlerInstance_onceToken != -1) {
    _dispatch_once(&_shareWapAuthHandlerInstance_onceToken,&___block_literal_global);
    param_2 = extraout_x1;
  }
  IVar1 = _objc_retainAutoreleaseReturnValue(_shareWapAuthHandlerInstance_g_wapAuthHander,param_2);
  return IVar1;
}



void ___45__WapAuthHandler_shareWapAuthHandlerInstance__block_invoke(void)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WapAuthHandler,"alloc");
  uVar2 = _objc_msgSend(uVar1,"init");
  uVar1 = _shareWapAuthHandlerInstance_g_wapAuthHander;
  _shareWapAuthHandlerInstance_g_wapAuthHander = uVar2;
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x30 bytes

bool WapAuthHandler::beginWapAuth_currentVC_appId_delegate_
               (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5,ID param_6)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  undefined8 uVar6;
  undefined *local_70;
  undefined8 local_68;
  code *local_60;
  undefined *puStack_58;
  undefined8 local_50;
  ID IStack_48;
  
  uVar1 = _objc_retain(param_3);
  uVar2 = _objc_retain(param_4);
  uVar3 = _objc_retain(param_5);
  uVar4 = _objc_retain(param_6);
  endWapAuth(param_1,(SEL)"endWapAuth");
  _objc_storeWeak(param_1 + 0x30,uVar4);
  _objc_release(uVar4);
  *(undefined *)(param_1 + 0x28) = 1;
  lVar5 = _random();
  uVar4 = *(undefined8 *)(param_1 + 0x20);
  *(long *)(param_1 + 0x18) = lVar5;
  *(undefined8 *)(param_1 + 0x20) = uVar1;
  uVar1 = _objc_retain(uVar1);
  _objc_release(uVar4);
  uVar4 = *(undefined8 *)(param_1 + 0x10);
  *(undefined8 *)(param_1 + 0x10) = uVar3;
  uVar3 = _objc_retain(uVar3);
  _objc_release(uVar4);
  getWebViewController(param_1,(SEL)"getWebViewController");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  uVar6 = _objc_msgSend(&_OBJC_CLASS___UINavigationController,"alloc");
  uVar6 = _objc_msgSend(uVar6,"initWithRootViewController:",uVar4);
  local_70 = PTR___NSConcreteStackBlock_00040028;
  local_68 = 0xc2000000;
  local_60 = ___56__WapAuthHandler_beginWapAuth_currentVC_appId_delegate___block_invoke;
  puStack_58 = &___block_descriptor_48_e8_32s40s_e5_v8__0l;
  local_50 = uVar4;
  IStack_48 = param_1;
  uVar4 = _objc_retain(uVar4);
  _objc_msgSend(uVar2,"presentViewController:animated:completion:",uVar6,1,&local_70);
  _objc_release(uVar2);
  _objc_release(local_50);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar1);
  _objc_release(uVar6);
  return 1;
}



void ___56__WapAuthHandler_beginWapAuth_currentVC_appId_delegate___block_invoke(long param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar2 = *(undefined8 *)(param_1 + 0x20);
  _objc_msgSend(*(undefined8 *)(param_1 + 0x28),"getMobileCheckUrl");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"refresh:",uVar1);
  _objc_release(uVar1);
  return;
}



void ___copy_helper_block_e8_32s40s(undefined8 param_1,long param_2)

{
  _objc_retain(*(undefined8 *)(param_2 + 0x20));
  _objc_retain(*(undefined8 *)(param_2 + 0x28));
  return;
}



void ___destroy_helper_block_e8_32s40s(long param_1)

{
  _objc_release(*(undefined8 *)(param_1 + 0x28));
  _objc_release(*(undefined8 *)(param_1 + 0x20));
  return;
}



// Function Stack Size: 0x18 bytes

bool WapAuthHandler::handleWapOAuthOpenUrl_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  long lVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  bool bVar10;
  
  uVar2 = _objc_retain(param_3);
  if (*(char *)(param_1 + 0x28) == '\0') {
    bVar10 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______wapoauth_);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"absoluteString");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar4,"hasPrefix:",uVar3);
    _objc_release(uVar4);
    if (iVar1 == 0) {
      bVar10 = 0;
    }
    else {
      _objc_msgSend(uVar2,"absoluteString");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      uVar5 = _objc_msgSend(uVar3,"length");
      _objc_msgSend(uVar4,"substringFromIndex:",uVar5);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar4);
      lVar6 = _objc_msgSend(uVar5,"length");
      if (lVar6 != 0) {
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_____3A__2F__2Foauth);
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(*(undefined8 *)(param_1 + 0x20),"scope");
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(*(undefined8 *)(param_1 + 0x20),"state");
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &
                      cf_https___open_weixin_qq_com_connect_smsauthorize_appid____redirect_uri____response_type_code_scope____state____uid__llu___
                     );
        uVar9 = _objc_retainAutoreleasedReturnValue();
        _objc_release(uVar8);
        _objc_release(uVar7);
        getWebViewController(param_1,(SEL)"getWebViewController");
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar7,"refresh:",uVar9);
        _objc_release(uVar7);
        _objc_release(uVar9);
        _objc_release(uVar4);
      }
      bVar10 = (bool)(lVar6 != 0);
      _objc_release(uVar5);
    }
    _objc_release(uVar3);
  }
  _objc_release(uVar2);
  return bVar10;
}



// Function Stack Size: 0x10 bytes

bool WapAuthHandler::endWapAuth(ID param_1,SEL param_2)

{
  bool bVar1;
  long lVar2;
  SEL extraout_x1;
  
  if (*(char *)(param_1 + 0x28) == '\0') {
    bVar1 = 0;
  }
  else {
    *(undefined *)(param_1 + 0x28) = 0;
    lVar2 = *(long *)(param_1 + 8);
    if (lVar2 != 0) {
      _objc_msgSend(lVar2,"dismissViewControllerAnimated:completion:",1,0);
      lVar2 = *(long *)(param_1 + 8);
      param_2 = extraout_x1;
    }
    *(undefined8 *)(param_1 + 8) = 0;
    _objc_release(lVar2,param_2);
    bVar1 = 1;
  }
  return bVar1;
}



// Function Stack Size: 0x10 bytes

void WapAuthHandler::cancelWapOAuth(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined *local_70;
  undefined8 local_68;
  code *local_60;
  undefined *puStack_58;
  undefined auStack_50 [8];
  undefined auStack_48 [8];
  
  _objc_msgSend(&_OBJC_CLASS___UIAlertController,"alertControllerWithTitle:message:preferredStyle:",
                &cf___,&cf_SmT_,1);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_initWeak(auStack_48,param_1);
  local_70 = PTR___NSConcreteStackBlock_00040028;
  local_68 = 0xc2000000;
  local_60 = ___32__WapAuthHandler_cancelWapOAuth__block_invoke;
  puStack_58 = &___block_descriptor_40_e8_32w_e23_v16__0__UIAlertAction_8l;
  _objc_copyWeak(auStack_50,auStack_48);
  _objc_msgSend(&_OBJC_CLASS___UIAlertAction,"actionWithTitle:style:handler:",&cf___,0,&local_70);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___UIAlertAction,"actionWithTitle:style:handler:",&cf____vU_,1,
                &___block_literal_global_218);
  uVar3 = _objc_retain();
  _objc_msgSend(uVar1,"addAction:",uVar2);
  _objc_msgSend(uVar1,"addAction:",uVar3);
  _objc_msgSend(*(undefined8 *)(param_1 + 8),"presentViewController:animated:completion:",uVar1,1,0)
  ;
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_destroyWeak(auStack_50);
  _objc_destroyWeak(auStack_48);
  _objc_release(uVar1);
  return;
}



void ___32__WapAuthHandler_cancelWapOAuth__block_invoke(long param_1)

{
  int iVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  
  lVar2 = _objc_loadWeakRetained(param_1 + 0x20);
  if (lVar2 != 0) {
    _objc_msgSend(lVar2,"delegate");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    if (lVar3 != 0) {
      _objc_msgSend(lVar2,"delegate");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      iVar1 = _objc_msgSend(uVar4,"respondsToSelector:","onResp:");
      _objc_release(uVar4);
      _objc_release(lVar3);
      if (iVar1 != 0) {
        uVar4 = _objc_msgSend(&objc::class_t::SendAuthResp,"alloc");
        uVar4 = _objc_msgSend(uVar4,"init");
        _objc_msgSend(uVar4,"setErrCode:",0xfffffffe);
        _objc_msgSend(lVar2,"delegate");
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar5,"onResp:",uVar4);
        _objc_release(uVar5);
        _objc_release(uVar4);
      }
    }
    _objc_msgSend(lVar2,"endWapAuth");
    _objc_release(lVar2);
    return;
  }
  return;
}



void ___copy_helper_block_e8_32w(long param_1,long param_2)

{
  _objc_copyWeak(param_1 + 0x20,param_2 + 0x20);
  return;
}



void ___destroy_helper_block_e8_32w(long param_1)

{
  _objc_destroyWeak(param_1 + 0x20);
  return;
}



void ___32__WapAuthHandler_cancelWapOAuth__block_invoke_217(void)

{
  return;
}



// Function Stack Size: 0x10 bytes

ID WapAuthHandler::getMobileCheckUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_https___open_weixin_qq_com_connect_mobilecheck_appid____uid__llu);
  return IVar1;
}



// Function Stack Size: 0x10 bytes

void WapAuthHandler::onCancelOAuthWebView(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  
  *(undefined *)(param_1 + 0x28) = 0;
  _objc_msgSend(*(undefined8 *)(param_1 + 8),"dismissViewControllerAnimated:completion:",1,0);
  uVar1 = *(undefined8 *)(param_1 + 8);
  *(undefined8 *)(param_1 + 8) = 0;
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WapAuthHandler::getWebViewController(ID param_1,SEL param_2)

{
  long lVar1;
  undefined8 uVar2;
  ID IVar3;
  SEL extraout_x1;
  undefined8 uVar4;
  
  lVar1 = *(long *)(param_1 + 8);
  if (lVar1 == 0) {
    uVar2 = _objc_msgSend(&objc::class_t::WXWebViewController,"alloc");
    uVar2 = _objc_msgSend(uVar2,"initWithDelegate:",param_1);
    uVar4 = *(undefined8 *)(param_1 + 8);
    *(undefined8 *)(param_1 + 8) = uVar2;
    _objc_release(uVar4);
    uVar2 = _objc_msgSend(&_OBJC_CLASS___UIBarButtonItem,"alloc");
    uVar2 = _objc_msgSend(uVar2,"initWithTitle:style:target:action:",&cf_Sm,1,param_1,
                          "cancelWapOAuth");
    _objc_msgSend(*(undefined8 *)(param_1 + 8),"navigationItem");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"setLeftBarButtonItem:",uVar2);
    _objc_release(uVar4);
    _objc_msgSend(*(undefined8 *)(param_1 + 8),"setTitle:",&cf__O_vU_);
    _objc_release(uVar2);
    lVar1 = *(long *)(param_1 + 8);
    param_2 = extraout_x1;
  }
  IVar3 = _objc_retainAutoreleaseReturnValue(lVar1,param_2);
  return IVar3;
}



// Function Stack Size: 0x10 bytes

ID WapAuthHandler::delegate(ID param_1,SEL param_2)

{
  ID IVar1;
  
  _objc_loadWeakRetained(param_1 + 0x30);
  IVar1 = _objc_autoreleaseReturnValue();
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WapAuthHandler::setDelegate_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeWeak(param_1 + 0x30,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WapAuthHandler::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_destroyWeak(param_1 + 0x30);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppSettingItem::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 uVar2;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::AppSettingItem;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    uVar2 = *(undefined8 *)(IVar1 + 0x18);
    *(undefined8 *)(IVar1 + 0x18) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x10);
    *(undefined8 *)(IVar1 + 0x10) = 0;
    _objc_release(uVar2);
    *(undefined4 *)(IVar1 + 0xc) = 0;
    *(undefined *)(IVar1 + 8) = 0;
  }
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppSettingItem::encodeWithCoder_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar2 = *(undefined8 *)(param_1 + 0x18);
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"encodeObject:forKey:",uVar2,&cf_appID);
  _objc_msgSend(uVar1,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x10),&cf_openID);
  _objc_msgSend(uVar1,"encodeInt32:forKey:",*(undefined4 *)(param_1 + 0xc),&cf_flag);
  _objc_msgSend(uVar1,"encodeBool:forKey:",*(undefined *)(param_1 + 8),&cf_appAddedByUser);
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x18 bytes

ID AppSettingItem::initWithCoder_(ID param_1,SEL param_2,ID param_3)

{
  unsigned_int uVar1;
  bool bVar2;
  undefined8 uVar3;
  ID IVar4;
  
  uVar3 = _objc_retain(param_3);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appID);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppID_(param_1,(SEL)"setAppID:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_openID);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setOpenID_(param_1,(SEL)"setOpenID:",IVar4);
  _objc_release(IVar4);
  uVar1 = _objc_msgSend(uVar3,"decodeInt32ForKey:",&cf_flag);
  setFlag_(param_1,(SEL)"setFlag:",uVar1);
  bVar2 = _objc_msgSend(uVar3,"decodeBoolForKey:",&cf_appAddedByUser);
  _objc_release(uVar3);
  setAppAddedByUser_(param_1,(SEL)"setAppAddedByUser:",bVar2);
  return param_1;
}



// Function Stack Size: 0x10 bytes

ID AppSettingItem::openID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppSettingItem::setOpenID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppSettingItem::flag(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0xc);
}



// Function Stack Size: 0x14 bytes

void AppSettingItem::setFlag_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0xc) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool AppSettingItem::appAddedByUser(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void AppSettingItem::setAppAddedByUser_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID AppSettingItem::appID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppSettingItem::setAppID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void AppSettingItem::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSceneInternalMessage::stateId(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 8);
}



// Function Stack Size: 0x18 bytes

void WXSceneInternalMessage::setStateId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSceneInternalMessage::stateToken(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXSceneInternalMessage::setStateToken_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSceneInternalMessage::stateUrl(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void WXSceneInternalMessage::setStateUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSceneInternalMessage::stateTitle(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x20);
}



// Function Stack Size: 0x18 bytes

void WXSceneInternalMessage::setStateTitle_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x20,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXSceneInternalMessage::jumpType(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0x28);
}



// Function Stack Size: 0x18 bytes

void WXSceneInternalMessage::setJumpType_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0x28) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void WXSceneInternalMessage::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 uVar2;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::AppRegisterInfo;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    *(undefined2 *)(IVar1 + 8) = 0;
    *(undefined *)(IVar1 + 10) = 0;
    uVar2 = *(undefined8 *)(IVar1 + 0x38);
    *(undefined8 *)(IVar1 + 0x30) = 0;
    *(undefined8 *)(IVar1 + 0x38) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x40);
    *(undefined8 *)(IVar1 + 0x40) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x48);
    *(undefined8 *)(IVar1 + 0x48) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x50);
    *(undefined8 *)(IVar1 + 0x50) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x58);
    *(undefined8 *)(IVar1 + 0x58) = 0;
    _objc_release(uVar2);
    *(undefined *)(IVar1 + 0xb) = 0;
    uVar2 = *(undefined8 *)(IVar1 + 0x60);
    *(undefined8 *)(IVar1 + 0x60) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x70);
    *(undefined8 *)(IVar1 + 0x70) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x68);
    *(undefined8 *)(IVar1 + 0x68) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x78);
    *(undefined8 *)(IVar1 + 0x78) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x80);
    *(undefined8 *)(IVar1 + 0x80) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x88);
    *(undefined8 *)(IVar1 + 0x88) = 0;
    _objc_release(uVar2);
    *(undefined8 *)(IVar1 + 0x10) = 0;
    *(undefined4 *)(IVar1 + 0x18) = 0;
    uVar2 = *(undefined8 *)(IVar1 + 0x90);
    *(undefined8 *)(IVar1 + 0x90) = 0;
    _objc_release(uVar2);
    *(undefined8 *)(IVar1 + 0x1c) = 0;
    *(undefined *)(IVar1 + 0xc) = 0;
    uVar2 = *(undefined8 *)(IVar1 + 0x98);
    *(undefined8 *)(IVar1 + 0x98) = 0;
    _objc_release(uVar2);
    *(undefined *)(IVar1 + 0xd) = 0;
    uVar2 = *(undefined8 *)(IVar1 + 0xa0);
    *(undefined8 *)(IVar1 + 0xa0) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0xa8);
    *(undefined8 *)(IVar1 + 0xa8) = 0;
    _objc_release(uVar2);
    *(undefined4 *)(IVar1 + 0x24) = 0;
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::description(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__name___appid____);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::encodeWithCoder_(ID param_1,SEL param_2,ID param_3)

{
  undefined uVar1;
  undefined8 uVar2;
  
  uVar1 = *(undefined *)(param_1 + 0xb);
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(uVar2,"encodeBool:forKey:",uVar1,&cf_added);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x50),&cf_appID);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x58),&cf_appIdentifier);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x38),&cf_appName);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x40),&cf_appName4ZhTw);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x48),&cf_appName4EnUs);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x60),&cf_description);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x70),&cf_description4EnUs);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x68),&cf_description4ZhTw);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x78),&cf_appurl);
  _objc_msgSend(uVar2,"encodeBool:forKey:",*(undefined *)(param_1 + 8),&cf_needUpdateInfo);
  _objc_msgSend(uVar2,"encodeBool:forKey:",*(undefined *)(param_1 + 9),&cf_needUpdateIcon);
  _objc_msgSend(uVar2,"encodeBool:forKey:",*(undefined *)(param_1 + 10),&cf_needUpdateWaterMark);
  _objc_msgSend(uVar2,"encodeInteger:forKey:",*(undefined8 *)(param_1 + 0x30),&cf_appInfoVer);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x80),&cf_appiconurl);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x88),&cf_appwatermarkurl);
  _objc_msgSend(uVar2,"encodeInteger:forKey:",*(undefined4 *)(param_1 + 0x10),&cf_lastUpdateInfoTime
               );
  _objc_msgSend(uVar2,"encodeInteger:forKey:",*(undefined4 *)(param_1 + 0x14),
                &cf_lastUpdateWatermarkTime);
  _objc_msgSend(uVar2,"encodeInteger:forKey:",*(undefined4 *)(param_1 + 0x18),&cf_lastUpdateIconTime
               );
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x90),&cf_apptypelist);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0x98),&cf_appdevinfo);
  _objc_msgSend(uVar2,"encodeInt32:forKey:",*(undefined4 *)(param_1 + 0x1c),&cf_appinfoflag);
  _objc_msgSend(uVar2,"encodeInt32:forKey:",*(undefined4 *)(param_1 + 0x20),&cf_appupdateversion);
  _objc_msgSend(uVar2,"encodeBool:forKey:",*(undefined *)(param_1 + 0xc),&cf_appcanshownew);
  _objc_msgSend(uVar2,"encodeBool:forKey:",*(undefined *)(param_1 + 0xd),&cf_isnewapp);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0xa0),&cf_appdownloadurl);
  _objc_msgSend(uVar2,"encodeObject:forKey:",*(undefined8 *)(param_1 + 0xa8),&cf_appdownloadurlmd5);
  _objc_msgSend(uVar2,"encodeInt32:forKey:",*(undefined4 *)(param_1 + 0x24),&cf_nextupdateinfotime);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x18 bytes

ID AppRegisterInfo::initWithCoder_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  unsigned_int uVar2;
  undefined8 uVar3;
  ID IVar4;
  unsigned_long_long uVar5;
  
  uVar3 = _objc_retain(param_3);
  bVar1 = _objc_msgSend(uVar3,"decodeBoolForKey:",&cf_added);
  setAppAddedByUser_(param_1,(SEL)"setAppAddedByUser:",bVar1);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appID);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppID_(param_1,(SEL)"setAppID:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appIdentifier);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppIdentifier_(param_1,(SEL)"setAppIdentifier:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appName);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppName_(param_1,(SEL)"setAppName:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appName4ZhTw);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppName4ZhTw_(param_1,(SEL)"setAppName4ZhTw:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appName4EnUs);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppName4EnUs_(param_1,(SEL)"setAppName4EnUs:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_description);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppDescription_(param_1,(SEL)"setAppDescription:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_description4ZhTw);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppDescription4ZhTw_(param_1,(SEL)"setAppDescription4ZhTw:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_description4EnUs);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppDescription4EnUs_(param_1,(SEL)"setAppDescription4EnUs:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appurl);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppInstallUrl_(param_1,(SEL)"setAppInstallUrl:",IVar4);
  _objc_release(IVar4);
  bVar1 = _objc_msgSend(uVar3,"decodeBoolForKey:",&cf_needUpdateInfo);
  setNeedUpdateInfo_(param_1,(SEL)"setNeedUpdateInfo:",bVar1);
  bVar1 = _objc_msgSend(uVar3,"decodeBoolForKey:",&cf_needUpdateIcon);
  setNeedUpdateIcon_(param_1,(SEL)"setNeedUpdateIcon:",bVar1);
  bVar1 = _objc_msgSend(uVar3,"decodeBoolForKey:",&cf_needUpdateWaterMark);
  setNeedUpdateWatermark_(param_1,(SEL)"setNeedUpdateWatermark:",bVar1);
  uVar5 = _objc_msgSend(uVar3,"decodeIntegerForKey:",&cf_appInfoVer);
  setAppInfoVer_(param_1,(SEL)"setAppInfoVer:",uVar5);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appiconurl);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppIconUrl_(param_1,(SEL)"setAppIconUrl:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appwatermarkurl);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppWatermarkUrl_(param_1,(SEL)"setAppWatermarkUrl:",IVar4);
  _objc_release(IVar4);
  uVar2 = _objc_msgSend(uVar3,"decodeIntegerForKey:",&cf_lastUpdateInfoTime);
  setLastUpdateInfoTime_(param_1,(SEL)"setLastUpdateInfoTime:",uVar2);
  uVar2 = _objc_msgSend(uVar3,"decodeIntegerForKey:",&cf_lastUpdateWatermarkTime);
  setLastUpdateWatermarkTime_(param_1,(SEL)"setLastUpdateWatermarkTime:",uVar2);
  uVar2 = _objc_msgSend(uVar3,"decodeIntegerForKey:",&cf_lastUpdateIconTime);
  setLastUpdateIconTime_(param_1,(SEL)"setLastUpdateIconTime:",uVar2);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_apptypelist);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppTypeList_(param_1,(SEL)"setAppTypeList:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appdevinfo);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppDevInfo_(param_1,(SEL)"setAppDevInfo:",IVar4);
  _objc_release(IVar4);
  uVar2 = _objc_msgSend(uVar3,"decodeInt32ForKey:",&cf_appinfoflag);
  setAppInfoFlag_(param_1,(SEL)"setAppInfoFlag:",uVar2);
  uVar2 = _objc_msgSend(uVar3,"decodeInt32ForKey:",&cf_appupdateversion);
  setAppUpdateVersion_(param_1,(SEL)"setAppUpdateVersion:",uVar2);
  bVar1 = _objc_msgSend(uVar3,"decodeBoolForKey:",&cf_appcanshownew);
  setAppCanShowNew_(param_1,(SEL)"setAppCanShowNew:",bVar1);
  bVar1 = _objc_msgSend(uVar3,"decodeBoolForKey:",&cf_isnewapp);
  setIsNewApp_(param_1,(SEL)"setIsNewApp:",bVar1);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appdownloadurl);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppDownloadUrl_(param_1,(SEL)"setAppDownloadUrl:",IVar4);
  _objc_release(IVar4);
  _objc_msgSend(uVar3,"decodeObjectForKey:",&cf_appdownloadurlmd5);
  IVar4 = _objc_retainAutoreleasedReturnValue();
  setAppDownloadUrlMD5_(param_1,(SEL)"setAppDownloadUrlMD5:",IVar4);
  _objc_release(IVar4);
  uVar2 = _objc_msgSend(uVar3,"decodeIntegerForKey:",&cf_nextupdateinfotime);
  _objc_release(uVar3);
  setNextUpdateInfoTime_(param_1,(SEL)"setNextUpdateInfoTime:",uVar2);
  return param_1;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long AppRegisterInfo::appInfoVer(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0x30);
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppInfoVer_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0x30) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool AppRegisterInfo::needUpdateInfo(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setNeedUpdateInfo_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool AppRegisterInfo::needUpdateIcon(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 9);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setNeedUpdateIcon_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 9) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x38,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x38,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appName4ZhTw(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x40,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppName4ZhTw_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x40,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appName4EnUs(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x48,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppName4EnUs_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x48,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x50,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x50,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appIdentifier(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x58,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppIdentifier_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x58,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

bool AppRegisterInfo::needUpdateWatermark(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 10);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setNeedUpdateWatermark_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 10) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool AppRegisterInfo::appAddedByUser(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0xb);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setAppAddedByUser_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0xb) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appDescription(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x60,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppDescription_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x60,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appDescription4ZhTw(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x68,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppDescription4ZhTw_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x68,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appDescription4EnUs(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x70,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppDescription4EnUs_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x70,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appInstallUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x78,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppInstallUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x78,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appIconUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x80,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppIconUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x80,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appWatermarkUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x88,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppWatermarkUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x88,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppRegisterInfo::lastUpdateInfoTime(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x10);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setLastUpdateInfoTime_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x10) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppRegisterInfo::lastUpdateWatermarkTime(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x14);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setLastUpdateWatermarkTime_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x14) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppRegisterInfo::lastUpdateIconTime(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x18);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setLastUpdateIconTime_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x18) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appTypeList(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x90,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppTypeList_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x90,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appDevInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x98,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppDevInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x98,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppRegisterInfo::appInfoFlag(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x1c);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setAppInfoFlag_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x1c) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppRegisterInfo::appUpdateVersion(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x20);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setAppUpdateVersion_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x20) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool AppRegisterInfo::appCanShowNew(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0xc);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setAppCanShowNew_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0xc) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool AppRegisterInfo::isNewApp(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0xd);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setIsNewApp_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0xd) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appDownloadUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xa0,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppDownloadUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xa0,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppRegisterInfo::appDownloadUrlMD5(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xa8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppRegisterInfo::setAppDownloadUrlMD5_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xa8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppRegisterInfo::nextUpdateInfoTime(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x24);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setNextUpdateInfoTime_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x24) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int AppRegisterInfo::rankWeight(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x28);
}



// Function Stack Size: 0x14 bytes

void AppRegisterInfo::setRankWeight_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x28) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void AppRegisterInfo::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0xa8,0);
  _objc_storeStrong(param_1 + 0xa0,0);
  _objc_storeStrong(param_1 + 0x98,0);
  _objc_storeStrong(param_1 + 0x90,0);
  _objc_storeStrong(param_1 + 0x88,0);
  _objc_storeStrong(param_1 + 0x80,0);
  _objc_storeStrong(param_1 + 0x78,0);
  _objc_storeStrong(param_1 + 0x70,0);
  _objc_storeStrong(param_1 + 0x68,0);
  _objc_storeStrong(param_1 + 0x60,0);
  _objc_storeStrong(param_1 + 0x58,0);
  _objc_storeStrong(param_1 + 0x50,0);
  _objc_storeStrong(param_1 + 0x48,0);
  _objc_storeStrong(param_1 + 0x40,0);
  _objc_storeStrong(param_1 + 0x38,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 uVar2;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::WXMediaInternalMessage;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    uVar2 = *(undefined8 *)(IVar1 + 0x18);
    *(undefined8 *)(IVar1 + 0x18) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x20);
    *(undefined8 *)(IVar1 + 0x20) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x28);
    *(undefined8 *)(IVar1 + 0x28) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x30);
    *(undefined8 *)(IVar1 + 0x30) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x78);
    *(undefined8 *)(IVar1 + 0x78) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x80);
    *(undefined8 *)(IVar1 + 0x80) = 0;
    _objc_release(uVar2);
    *(undefined8 *)(IVar1 + 0x38) = 0;
    uVar2 = *(undefined8 *)(IVar1 + 0x58);
    *(undefined8 *)(IVar1 + 0x58) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x60);
    *(undefined8 *)(IVar1 + 0x60) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x68);
    *(undefined8 *)(IVar1 + 0x68) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x70);
    *(undefined8 *)(IVar1 + 0x70) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x40);
    *(undefined8 *)(IVar1 + 0x40) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x48);
    *(undefined8 *)(IVar1 + 0x48) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x50);
    *(undefined8 *)(IVar1 + 0x50) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x88);
    *(undefined8 *)(IVar1 + 0x88) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x90);
    *(undefined8 *)(IVar1 + 0x90) = 0;
    _objc_release(uVar2);
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::message(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXMediaInternalMessage,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::title(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setTitle_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::description(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setDescription_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::thumbData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x28);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setThumbData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x28,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::mediaTagName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x30,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMediaTagName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x30,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXMediaInternalMessage::objectType(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0x38);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setObjectType_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0x38) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::extInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x40,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setExtInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x40,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::fileExt(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x48,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setFileExt_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x48,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::fileData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x50);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setFileData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x50,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::mediaUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x58,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMediaUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x58,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::mediaLowBandUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x60,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMediaLowBandUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x60,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::mediaDataUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x68,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMediaDataUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x68,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::mediaLowBandDataUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x70,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMediaLowBandDataUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x70,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::messageExt(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x78,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMessageExt_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x78,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::messageAction(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x80,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMessageAction_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x80,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::appBrandUserName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x88,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setAppBrandUserName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x88,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::appBrandPath(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x90,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setAppBrandPath_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x90,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

bool WXMediaInternalMessage::appBrandWithShareTikcet(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXMediaInternalMessage::setAppBrandWithShareTikcet_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::hdThumbData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x98);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setHdThumbData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x98,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

CGSize WXMediaInternalMessage::hdThumbImageSize(ID param_1,SEL param_2)

{
  CGSize CVar1;
  
  CVar1.field1_0x8 = (double)param_2;
  CVar1.field0_0x0 = (double)param_1;
  return CVar1;
}



// Function Stack Size: 0x20 bytes

void WXMediaInternalMessage::setHdThumbImageSize_(ID param_1,SEL param_2,CGSize param_3)

{
  *(double *)(param_1 + 0x128) = param_3.field0_0x0;
  *(double *)(param_1 + 0x130) = param_3.field1_0x8;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXMediaInternalMessage::appBrandMiniProgramType(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0xa0);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setAppBrandMiniProgramType_
               (ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0xa0) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::sightCdnVideoUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xa8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setSightCdnVideoUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xa8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::sightCdnThumbUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xb0,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setSightCdnThumbUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xb0,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::sightAppThumbUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xb8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setSightAppThumbUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xb8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::enterpriseCardContent(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xc0,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setEnterpriseCardContent_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xc0,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

long_long WXMediaInternalMessage::enterpriseCardMsgType(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 200);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setEnterpriseCardMsgType_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 200) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

int WXMediaInternalMessage::weworkSubType(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + 0xc);
}



// Function Stack Size: 0x14 bytes

void WXMediaInternalMessage::setWeworkSubType_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + 0xc) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::songAlbumUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xd0,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setSongAlbumUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xd0,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::songLyric(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xd8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setSongLyric_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xd8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

bool WXMediaInternalMessage::isAppBrandUpdatableMessage(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 9);
}



// Function Stack Size: 0x14 bytes

void WXMediaInternalMessage::setIsAppBrandUpdatableMessage_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 9) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool WXMediaInternalMessage::isAppBrandSecretMessage(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 10);
}



// Function Stack Size: 0x14 bytes

void WXMediaInternalMessage::setIsAppBrandSecretMessage_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 10) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::appBrandExtraInfoDic(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0xe0);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setAppBrandExtraInfoDic_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0xe0,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::gameLiveExtraInfoDic(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0xe8);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setGameLiveExtraInfoDic_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0xe8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::musicVideoSingerName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0xf0,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMusicVideoSingerName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0xf0,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::musicVideoHdAlbumThumbData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0xf8);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMusicVideoHdAlbumThumbData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0xf8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::musicVideoAlbumName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x100,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMusicVideoAlbumName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x100,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::musicVideoMusicGenre(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x108,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMusicVideoMusicGenre_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x108,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::musicVideoIdentification(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x110,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMusicVideoIdentification_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x110,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXMediaInternalMessage::musicVideoIssueDate(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0x118);
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMusicVideoIssueDate_
               (ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0x118) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXMediaInternalMessage::musicVideoDuration(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 0x10);
}



// Function Stack Size: 0x14 bytes

void WXMediaInternalMessage::setMusicVideoDuration_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 0x10) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaInternalMessage::musicVideoOperationUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x120,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaInternalMessage::setMusicVideoOperationUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x120,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXMediaInternalMessage::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x120,0);
  _objc_storeStrong(param_1 + 0x110,0);
  _objc_storeStrong(param_1 + 0x108,0);
  _objc_storeStrong(param_1 + 0x100,0);
  _objc_storeStrong(param_1 + 0xf8,0);
  _objc_storeStrong(param_1 + 0xf0,0);
  _objc_storeStrong(param_1 + 0xe8,0);
  _objc_storeStrong(param_1 + 0xe0,0);
  _objc_storeStrong(param_1 + 0xd8,0);
  _objc_storeStrong(param_1 + 0xd0,0);
  _objc_storeStrong(param_1 + 0xc0,0);
  _objc_storeStrong(param_1 + 0xb8,0);
  _objc_storeStrong(param_1 + 0xb0,0);
  _objc_storeStrong(param_1 + 0xa8,0);
  _objc_storeStrong(param_1 + 0x98,0);
  _objc_storeStrong(param_1 + 0x90,0);
  _objc_storeStrong(param_1 + 0x88,0);
  _objc_storeStrong(param_1 + 0x80,0);
  _objc_storeStrong(param_1 + 0x78,0);
  _objc_storeStrong(param_1 + 0x70,0);
  _objc_storeStrong(param_1 + 0x68,0);
  _objc_storeStrong(param_1 + 0x60,0);
  _objc_storeStrong(param_1 + 0x58,0);
  _objc_storeStrong(param_1 + 0x50,0);
  _objc_storeStrong(param_1 + 0x48,0);
  _objc_storeStrong(param_1 + 0x40,0);
  _objc_storeStrong(param_1 + 0x30,0);
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXAuthInternal::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 uVar2;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::WXAuthInternal;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    uVar2 = *(undefined8 *)(IVar1 + 8);
    *(undefined8 *)(IVar1 + 8) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x10);
    *(undefined8 *)(IVar1 + 0x10) = 0;
    _objc_release(uVar2);
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID WXAuthInternal::scope(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXAuthInternal::setScope_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXAuthInternal::state(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXAuthInternal::setState_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXAuthInternal::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 uVar2;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::AppCommunicateData;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    uVar2 = *(undefined8 *)(IVar1 + 0x10);
    *(undefined8 *)(IVar1 + 8) = 0;
    *(undefined8 *)(IVar1 + 0x10) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x18);
    *(undefined8 *)(IVar1 + 0x18) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x30);
    *(undefined8 *)(IVar1 + 0x30) = 0;
    _objc_release(uVar2);
    *(undefined *)(IVar1 + 0x20) = 0;
    *(undefined8 *)(IVar1 + 0x24) = 1;
    uVar2 = *(undefined8 *)(IVar1 + 0x38);
    *(undefined8 *)(IVar1 + 0x38) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x40);
    *(undefined8 *)(IVar1 + 0x40) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x48);
    *(undefined8 *)(IVar1 + 0x48) = 0;
    _objc_release(uVar2);
    uVar2 = *(undefined8 *)(IVar1 + 0x50);
    *(undefined8 *)(IVar1 + 0x50) = 0;
    _objc_release(uVar2);
  }
  return IVar1;
}



// Function Stack Size: 0x18 bytes

ID AppCommunicateData::initWithPropertList_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  ID IVar4;
  long lVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  ID local_70;
  class_t *pcStack_68;
  
  uVar3 = _objc_retain(param_3);
  pcStack_68 = &objc::class_t::AppCommunicateData;
  local_70 = param_1;
  IVar4 = _objc_msgSendSuper2(&local_70,"init");
  if (IVar4 != 0) {
    *(undefined8 *)(IVar4 + 8) = 0;
    _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_command);
    lVar5 = _objc_retainAutoreleasedReturnValue();
    if (lVar5 != 0) {
      iVar1 = _objc_msgSend(lVar5,"intValue");
      *(long *)(IVar4 + 8) = (long)iVar1;
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_account);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar4,"setConversationAccount:",uVar6);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_returnFromApp);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      lVar8 = _objc_msgSend(uVar7,"compare:",&cf_1);
      _objc_msgSend(IVar4,"setReturnFromApp:",lVar8 == 0);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_openID);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar4,"setOpenID:",uVar9);
      _objc_release(uVar9);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_sdkver);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar4,"setSdkVer:",uVar9);
      _objc_release(uVar9);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_language);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar4,"setLang:",uVar9);
      _objc_release(uVar9);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_country);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar4,"setCountry:",uVar9);
      _objc_release(uVar9);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_userOpenID);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar4,"setToUserOpenID:",uVar9);
      _objc_release(uVar9);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_universalLink);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar4,"setUniversalLink:",uVar9);
      _objc_release(uVar9);
      _objc_msgSend(uVar3,"wxApi_numberForKey:",&cf_wechatVersion);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      iVar1 = _objc_msgSend(uVar9,"unsignedIntValue");
      if (iVar1 != 0) {
        _objc_msgSend(&_OBJC_CLASS___NSUserDefaults,"standardUserDefaults");
        uVar10 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar10,"setObject:forKey:",uVar9,&cf_WXWechatVersionNSUserDefaultsKey);
        _objc_release(uVar10);
      }
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_result);
      lVar8 = _objc_retainAutoreleasedReturnValue();
      if (lVar8 != 0) {
        uVar2 = _objc_msgSend(lVar8,"intValue");
        *(undefined4 *)(IVar4 + 0x24) = uVar2;
      }
      _objc_release(lVar8);
      _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_scene);
      lVar8 = _objc_retainAutoreleasedReturnValue();
      if (lVar8 != 0) {
        uVar2 = _objc_msgSend(lVar8,"intValue");
        *(undefined4 *)(IVar4 + 0x28) = uVar2;
      }
      _objc_release(lVar8);
      uVar10 = _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"alloc");
      uVar10 = _objc_msgSend(uVar10,"initWithDictionary:",uVar3);
      uVar11 = *(undefined8 *)(IVar4 + 0x10);
      *(undefined8 *)(IVar4 + 0x10) = uVar10;
      _objc_release(uVar11);
      _objc_release(uVar9);
      _objc_release(uVar7);
      _objc_release(uVar6);
    }
    _objc_release(lVar5);
  }
  _objc_release(uVar3);
  return IVar4;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::propertList(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(*(undefined8 *)(param_1 + 0x10));
  return IVar1;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long AppCommunicateData::command(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 8);
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::openID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(*(undefined8 *)(param_1 + 0x38));
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::sdkVer(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(*(undefined8 *)(param_1 + 0x40));
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::lang(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(*(undefined8 *)(param_1 + 0x48));
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::country(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(*(undefined8 *)(param_1 + 0x50));
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::description(ID param_1,SEL param_2)

{
  int iVar1;
  bool bVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  ID IVar12;
  
  iVar1 = scene(param_1,(SEL)"scene");
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",iVar1);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  openID(param_1,(SEL)"openID");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  sdkVer(param_1,(SEL)"sdkVer");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  lang(param_1,(SEL)"lang");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  country(param_1,(SEL)"country");
  uVar7 = _objc_retainAutoreleasedReturnValue();
  toUserOpenID(param_1,(SEL)"toUserOpenID");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  universalLink(param_1,(SEL)"universalLink");
  uVar9 = _objc_retainAutoreleasedReturnValue();
  bVar2 = isAutoResend(param_1,(SEL)"isAutoResend");
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",bVar2);
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                &
                cf__scene____openID____sdkVer____lang____country____toUserOpenID____universalLink____isAutoResend____
               );
  uVar11 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(uVar3);
  IVar12 = _objc_autoreleaseReturnValue(uVar11);
  return IVar12;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::initCommonField_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  cfstringStruct *pcVar1;
  undefined8 uVar2;
  long lVar3;
  long lVar4;
  undefined8 uVar5;
  
  *(unsigned_long_long *)(param_1 + 8) = param_3;
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"alloc");
  uVar2 = _objc_msgSend(uVar2,"init");
  uVar5 = *(undefined8 *)(param_1 + 0x10);
  *(undefined8 *)(param_1 + 0x10) = uVar2;
  _objc_release(uVar5);
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__lu);
  lVar3 = _objc_retainAutoreleasedReturnValue();
  if (lVar3 != 0) {
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar3,&cf_command);
  }
  pcVar1 = &cf_0;
  if (*(char *)(param_1 + 0x20) != '\0') {
    pcVar1 = &cf_1;
  }
  _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",pcVar1,
                &cf_returnFromApp);
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__d);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",uVar2,&cf_result);
  _objc_release(uVar2);
  if (*(long *)(param_1 + 0x30) != 0) {
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",
                  *(long *)(param_1 + 0x30),&cf_account);
  }
  if (*(long *)(param_1 + 0x40) != 0) {
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",
                  *(long *)(param_1 + 0x40),&cf_sdkver);
  }
  if (*(long *)(param_1 + 0x60) != 0) {
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",
                  *(long *)(param_1 + 0x60),&cf_universalLink);
  }
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",*(undefined *)(param_1 + 0x21));
  lVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release();
  if (lVar4 != 0) {
    uVar5 = *(undefined8 *)(param_1 + 0x10);
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",*(undefined *)(param_1 + 0x21));
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"wxApi_safeSetObject:forKey:",uVar2,&cf_isAutoResend);
    _objc_release(uVar2);
  }
  _objc_release(lVar3);
  return;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeCommand_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  initCommonField_(param_1,(SEL)"initCommonField:",param_3);
  return 1;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::authRequest(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  ulong uVar4;
  ID IVar5;
  SEL extraout_x1;
  
  if ((*(long *)(param_1 + 0x10) == 0) || (*(long *)(param_1 + 8) != 0x406)) {
    uVar1 = 0;
    goto LAB_00010428;
  }
  uVar1 = _objc_msgSend(&objc::class_t::WXAuthInternal,"alloc");
  uVar2 = _objc_msgSend(uVar1,"init");
  _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_scope);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"setScope:",uVar1);
  _objc_release(uVar1);
  _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_state);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"setState:",uVar1);
  _objc_release(uVar1);
  _objc_msgSend(uVar2,"scope");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  if (lVar3 == 0) {
    _objc_release(0);
LAB_00010404:
    uVar1 = 0;
  }
  else {
    _objc_msgSend(uVar2,"scope");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(uVar1,"length");
    _objc_release(uVar1);
    _objc_release(lVar3);
    if (0x400 < uVar4) goto LAB_00010404;
    _objc_msgSend(uVar2,"state");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    if (lVar3 == 0) {
      _objc_release(0);
    }
    else {
      _objc_msgSend(uVar2,"state");
      uVar1 = _objc_retainAutoreleasedReturnValue();
      uVar4 = _objc_msgSend(uVar1,"length");
      _objc_release(uVar1);
      _objc_release(lVar3);
      if (0x400 < uVar4) goto LAB_00010404;
    }
    uVar1 = _objc_retain(uVar2);
  }
  _objc_release(uVar2);
  param_2 = extraout_x1;
LAB_00010428:
  IVar5 = _objc_autoreleaseReturnValue(uVar1,param_2);
  return IVar5;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeAuthRequest_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  ulong uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  bool bVar8;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_authisnil);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_000106f8:
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar3);
    bVar8 = 0;
  }
  else {
    _objc_msgSend(lVar1,"scope");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    if (lVar2 == 0) {
      _objc_release(0);
code_r0x0001066c:
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_scopeisnilortoolarge);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_000106f8;
    }
    _objc_msgSend(lVar1,"scope");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    _objc_release(lVar2);
    if (0x400 < uVar4) goto code_r0x0001066c;
    _objc_msgSend(lVar1,"state");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    if (lVar2 == 0) {
      _objc_release(0);
    }
    else {
      _objc_msgSend(lVar1,"state");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      uVar4 = _objc_msgSend(uVar3,"length");
      _objc_release(uVar3);
      _objc_release(lVar2);
      if (0x400 < uVar4) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_authstateisnilortoolarge);
        uVar3 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        goto LAB_000106f8;
      }
    }
    _objc_msgSend(lVar1,"scope");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      uVar6 = *(undefined8 *)(param_1 + 0x10);
      _objc_msgSend(lVar1,"scope");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar3,&cf_scope);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"state");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 == 0) {
      bVar8 = 1;
      goto LAB_0001073c;
    }
    uVar3 = *(undefined8 *)(param_1 + 0x10);
    _objc_msgSend(lVar1,"state");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"wxApi_safeSetObject:forKey:",uVar5,&cf_state);
    bVar8 = 1;
  }
  _objc_release(uVar5);
LAB_0001073c:
  _objc_release(lVar1);
  return bVar8;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::authResp(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  ulong uVar4;
  ID IVar5;
  SEL extraout_x1;
  
  if ((*(long *)(param_1 + 0x10) == 0) || (*(long *)(param_1 + 8) != 0x406)) {
    uVar1 = 0;
    goto LAB_0001094c;
  }
  uVar1 = _objc_msgSend(&objc::class_t::SendAuthResp,"alloc");
  uVar2 = _objc_msgSend(uVar1,"init");
  _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_state);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"setState:",uVar1);
  _objc_release(uVar1);
  _objc_msgSend(uVar2,"state");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  if (lVar3 == 0) {
    _objc_release(0);
LAB_00010938:
    uVar1 = _objc_retain(uVar2);
  }
  else {
    _objc_msgSend(uVar2,"state");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(uVar1,"length");
    _objc_release(uVar1);
    _objc_release(lVar3);
    if (uVar4 < 0x401) goto LAB_00010938;
    uVar1 = 0;
  }
  _objc_release(uVar2);
  param_2 = extraout_x1;
LAB_0001094c:
  IVar5 = _objc_autoreleaseReturnValue(uVar1,param_2);
  return IVar5;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeAuthResp_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  ulong uVar4;
  bool bVar5;
  undefined8 uVar6;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
LAB_000109ec:
    bVar5 = 0;
  }
  else {
    _objc_msgSend(lVar1,"state");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    if (lVar2 == 0) {
      _objc_release(0);
    }
    else {
      _objc_msgSend(lVar1,"state");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      uVar4 = _objc_msgSend(uVar3,"length");
      _objc_release(uVar3);
      _objc_release(lVar2);
      if (0x400 < uVar4) goto LAB_000109ec;
    }
    _objc_msgSend(lVar1,"state");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      uVar6 = *(undefined8 *)(param_1 + 0x10);
      _objc_msgSend(lVar1,"state");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar3,&cf_state);
      _objc_release(uVar3);
    }
    bVar5 = 1;
  }
  _objc_release(lVar1);
  return bVar5;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::textMessage(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined *puVar2;
  ID IVar3;
  SEL extraout_x1;
  undefined8 uVar4;
  
  if ((*(long *)(param_1 + 0x10) == 0) || (*(long *)(param_1 + 8) != 0x3fc)) {
    uVar4 = 0;
  }
  else {
    _objc_msgSend(*(long *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_title);
    uVar1 = _objc_retainAutoreleasedReturnValue();
    puVar2 = (undefined *)_objc_msgSend(uVar1,"length");
    if (puVar2 < &UNK_00002801) {
      uVar4 = _objc_retain(uVar1);
    }
    else {
      uVar4 = 0;
    }
    _objc_release(uVar1);
    param_2 = extraout_x1;
  }
  IVar3 = _objc_autoreleaseReturnValue(uVar4,param_2);
  return IVar3;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeTextMessage_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  undefined *puVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  bool bVar10;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
code_r0x00010ca4:
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_textisempty_);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar5);
  }
  else {
    lVar2 = _objc_msgSend(lVar1,"length");
    if (lVar2 == 0) goto code_r0x00010ca4;
    puVar3 = (undefined *)_objc_msgSend(lVar1,"length");
    if (puVar3 < &UNK_00002801) {
      _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar1,&cf_title);
      bVar10 = 1;
      goto LAB_00010d98;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    uVar5 = _objc_msgSend(lVar1,"length");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar5);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",&DAT_00002800);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_textlength____overlimit_____);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar5);
  }
  _objc_release(uVar6);
  _objc_release(uVar4);
  bVar10 = 0;
LAB_00010d98:
  _objc_release(lVar1);
  return bVar10;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeTextMessageInState_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined *puVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  bool bVar9;
  
  lVar1 = _objc_retain(param_3);
  puVar2 = (undefined *)_objc_msgSend(lVar1,"length");
  if (puVar2 < &UNK_00002801) {
    if (lVar1 != 0) {
      _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar1,&cf_title);
    }
    bVar9 = 1;
  }
  else {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(lVar1,"length");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar4);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",&DAT_00002800);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_textlength____overlimit_____);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar8,0);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    bVar9 = 0;
  }
  _objc_release(lVar1);
  return bVar9;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::weAppExtDic(ID param_1,SEL param_2)

{
  long lVar1;
  ID IVar2;
  undefined auVar3 [16];
  
  lVar1 = *(long *)(param_1 + 0x10);
  if (lVar1 != 0) {
    if (*(long *)(param_1 + 8) == 0x438) {
      _objc_msgSend(lVar1,"wxApi_dictionaryForKey:",&cf_weAppExtDic);
      auVar3 = _objc_retainAutoreleasedReturnValue();
      param_2 = auVar3._8_8_;
      lVar1 = auVar3._0_8_;
    }
    else {
      lVar1 = 0;
    }
  }
  IVar2 = _objc_autoreleaseReturnValue(lVar1,param_2);
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::mediaMessage(ID param_1,SEL param_2)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  undefined8 uVar17;
  undefined8 uVar18;
  undefined8 uVar19;
  undefined8 uVar20;
  undefined8 uVar21;
  undefined8 uVar22;
  undefined8 uVar23;
  undefined8 uVar24;
  undefined8 uVar25;
  undefined8 uVar26;
  undefined8 uVar27;
  undefined8 uVar28;
  undefined8 uVar29;
  undefined8 uVar30;
  undefined8 uVar31;
  ID IVar32;
  char *pcVar33;
  SEL extraout_x1;
  long lVar34;
  long *plVar35;
  undefined8 uVar36;
  undefined8 local_138;
  
  plVar35 = (long *)(param_1 + 0x10);
  if (*plVar35 == 0) {
    uVar3 = 0;
    goto LAB_00011ab8;
  }
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_objectType);
  lVar2 = _objc_retainAutoreleasedReturnValue();
  if (lVar2 == 0) {
    iVar1 = 0;
  }
  else {
    iVar1 = _objc_msgSend(lVar2,"intValue");
  }
  lVar34 = *(long *)(param_1 + 8);
  if ((iVar1 != 0x4c) && (lVar34 == 0x7f8)) {
    uVar3 = _objc_msgSend(&objc::class_t::WXMediaMessage,"alloc");
    uVar3 = _objc_msgSend(uVar3,"init");
    _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_messageExt);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"setMessageExt:",uVar4);
    _objc_release(uVar4);
    _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_messageAction);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"setMessageAction:",uVar4);
    goto LAB_00011aa8;
  }
  if ((lVar34 != 0x3f2) && (iVar1 != 0x4c || lVar34 != 0x7f8)) {
    uVar3 = 0;
    goto LAB_00011ab0;
  }
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_title);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_description);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_dataForKey:",&cf_thumbData);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_mediaTagName);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_messageExt);
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_messageAction);
  uVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_mediaUrl);
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_mediaLowBandUrl);
  uVar11 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_mediaDataUrl);
  uVar12 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_mediaLowBandDataUrl);
  uVar13 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_extInfo);
  uVar14 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_fileExt);
  uVar15 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_sightCdnVideoUrl);
  uVar16 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_sightCdnThumbUrl);
  uVar17 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_enterpriseCardInfo);
  uVar18 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_numberForKey:",&cf_enterpriseCardMsgType);
  uVar19 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_musicVideoSingetName);
  uVar20 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_dataForKey:",&cf_musicVideoHDThumbData);
  uVar21 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_musicVideoAlbumName);
  uVar22 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_musicVideoIdentification);
  uVar23 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_musicVideoMusicGenre);
  uVar24 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_musicVideoIssueData);
  uVar25 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_musicVideoDuration);
  uVar26 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar35,"wxApi_stringForKey:",&cf_musicVideoOperationUrl);
  uVar27 = _objc_retainAutoreleasedReturnValue();
  lVar34 = _objc_msgSend(uVar25,"length");
  if (lVar34 == 0) {
    local_138 = 0;
  }
  else {
    local_138 = _objc_msgSend(uVar25,"longLongValue");
  }
  lVar34 = _objc_msgSend(uVar26,"length");
  if (lVar34 != 0) {
    uVar28 = _objc_msgSend(uVar26,"intValue");
    if (lVar2 != 0) goto LAB_000114a4;
LAB_000115b0:
    uVar3 = 0;
    goto LAB_000119ec;
  }
  uVar28 = 0;
  if (lVar2 == 0) goto LAB_000115b0;
LAB_000114a4:
  uVar3 = _objc_msgSend(&objc::class_t::WXMediaMessage,"alloc");
  uVar29 = _objc_msgSend(uVar3,"init");
  _objc_msgSend(uVar29,"setTitle:",uVar4);
  _objc_msgSend(uVar29,"setDescription:",uVar5);
  _objc_msgSend(uVar29,"setThumbData:",uVar6);
  _objc_msgSend(uVar29,"setMediaTagName:",uVar7);
  _objc_msgSend(uVar29,"setMessageExt:",uVar8);
  _objc_msgSend(uVar29,"setMessageAction:",uVar9);
  uVar3 = 0;
  if (0x25 < iVar1) {
    if (iVar1 < 0x2d) {
      if (iVar1 == 0x26) {
        uVar30 = _objc_msgSend(&objc::class_t::WXVideoFileObject,"alloc");
        pcVar33 = "setVideoFileData:";
        uVar3 = *(undefined8 *)(param_1 + 0x18);
      }
      else {
        if (iVar1 != 0x27) goto switchD_00011580_caseD_9;
        uVar30 = _objc_msgSend(&objc::class_t::WXGameVideoFileObject,"alloc");
        _objc_msgSend(uVar30,"setVideoFileData:",*(undefined8 *)(param_1 + 0x18));
        _objc_msgSend(uVar30,"setVideoUrl:",uVar16);
        pcVar33 = "setThumbUrl:";
        uVar3 = uVar17;
      }
    }
    else if (iVar1 == 0x2d) {
      _objc_msgSend(&objc::class_t::WXEnterpriseCardObject,"object");
      uVar30 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar30,"setCardInfo:",uVar18);
      uVar3 = _objc_msgSend(uVar19,"integerValue");
      pcVar33 = "setMsgType:";
    }
    else {
      if (iVar1 != 0x4c) goto switchD_00011580_caseD_9;
      _objc_msgSend(&objc::class_t::WXMusicVideoObject,"object");
      uVar30 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar30,"setMusicUrl:",uVar10);
      _objc_msgSend(uVar30,"setMusicDataUrl:",uVar12);
      _objc_msgSend(uVar30,"setSingerName:",uVar20);
      _objc_msgSend(uVar30,"setAlbumName:",uVar22);
      _objc_msgSend(uVar30,"setHdAlbumThumbData:",uVar21);
      _objc_msgSend(uVar30,"setIdentification:",uVar23);
      _objc_msgSend(uVar30,"setIssueDate:",local_138);
      _objc_msgSend(uVar30,"setMusicGenre:",uVar24);
      _objc_msgSend(uVar30,"setDuration:",uVar28);
      pcVar33 = "setMusicOperationUrl:";
      uVar3 = uVar27;
    }
    goto LAB_000119b0;
  }
  switch(iVar1) {
  case 2:
    uVar30 = _objc_msgSend(&objc::class_t::WXImageObject,"alloc");
    uVar3 = *(undefined8 *)(param_1 + 0x18);
    pcVar33 = "setImageData:";
    break;
  case 3:
    uVar30 = _objc_msgSend(&objc::class_t::WXMusicObject,"alloc");
    _objc_msgSend(uVar30,"setMusicUrl:",uVar10);
    _objc_msgSend(uVar30,"setMusicLowBandUrl:",uVar11);
    _objc_msgSend(uVar30,"setMusicDataUrl:",uVar12);
    pcVar33 = "setMusicLowBandDataUrl:";
    uVar3 = uVar13;
    break;
  case 4:
    uVar30 = _objc_msgSend(&objc::class_t::WXVideoObject,"alloc");
    _objc_msgSend(uVar30,"setVideoUrl:",uVar10);
    pcVar33 = "setVideoLowBandUrl:";
    uVar3 = uVar11;
    break;
  case 5:
    uVar30 = _objc_msgSend(&objc::class_t::WXWebpageObject,"alloc");
    pcVar33 = "setWebpageUrl:";
    uVar3 = uVar10;
    break;
  case 6:
    uVar30 = _objc_msgSend(&objc::class_t::WXFileObject,"alloc");
    pcVar33 = "setFileExtension:";
    uVar3 = uVar15;
    goto LAB_00011904;
  case 7:
    uVar30 = _objc_msgSend(&objc::class_t::WXAppExtendObject,"alloc");
    _objc_msgSend(uVar30,"setUrl:",uVar10);
    pcVar33 = "setExtInfo:";
    uVar3 = uVar14;
LAB_00011904:
    _objc_msgSend(uVar30,pcVar33,uVar3);
    uVar3 = *(undefined8 *)(param_1 + 0x18);
    pcVar33 = "setFileData:";
    break;
  case 8:
    uVar30 = _objc_msgSend(&objc::class_t::WXEmoticonObject,"alloc");
    pcVar33 = "setEmoticonData:";
    uVar3 = *(undefined8 *)(param_1 + 0x18);
    break;
  default:
    goto switchD_00011580_caseD_9;
  case 0xe:
    uVar3 = _objc_msgSend(*(undefined8 *)(param_1 + 0x18),"bytes");
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithUTF8String:",uVar3);
    uVar30 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar30,"componentsSeparatedByString:",&cf__);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar34 = _objc_msgSend(uVar3,"count");
    if (lVar34 == 2) {
      _objc_msgSend(uVar3,"objectAtIndexedSubscript:",0);
      uVar28 = _objc_retainAutoreleasedReturnValue();
      uVar36 = _objc_msgSend(uVar28,"doubleValue");
      _objc_release(uVar28);
      _objc_msgSend(uVar3,"objectAtIndexedSubscript:",1);
      uVar31 = _objc_retainAutoreleasedReturnValue();
      uVar28 = _objc_msgSend(uVar31,"doubleValue");
      _objc_release(uVar31);
    }
    else {
      uVar36 = 0xc08f400000000000;
      uVar28 = uVar36;
    }
    uVar31 = _objc_msgSend(&objc::class_t::WXLocationObject,"alloc");
    _objc_msgSend(uVar36,uVar31,"setLng:");
    _objc_msgSend(uVar28,uVar31,"setLat:");
    _objc_msgSend(uVar29,"setMediaObject:",uVar31);
    _objc_release(uVar31);
    _objc_release(uVar3);
    goto LAB_000119c8;
  }
LAB_000119b0:
  _objc_msgSend(uVar30,pcVar33,uVar3);
  _objc_msgSend(uVar29,"setMediaObject:",uVar30);
LAB_000119c8:
  _objc_release(uVar30);
  uVar3 = _objc_retain(uVar29);
switchD_00011580_caseD_9:
  _objc_release(uVar29);
LAB_000119ec:
  _objc_release(uVar27);
  _objc_release(uVar26);
  _objc_release(uVar25);
  _objc_release(uVar24);
  _objc_release(uVar23);
  _objc_release(uVar22);
  _objc_release(uVar21);
  _objc_release(uVar20);
  _objc_release(uVar19);
  _objc_release(uVar18);
  _objc_release(uVar17);
  _objc_release(uVar16);
  _objc_release(uVar15);
  _objc_release(uVar14);
  _objc_release(uVar13);
  _objc_release(uVar12);
  _objc_release(uVar11);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
LAB_00011aa8:
  _objc_release(uVar4);
LAB_00011ab0:
  _objc_release(lVar2);
  param_2 = extraout_x1;
LAB_00011ab8:
  IVar32 = _objc_autoreleaseReturnValue(uVar3,param_2);
  return IVar32;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::makeStateSceneObject_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  long lVar4;
  long lVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  undefined *puVar9;
  undefined8 uVar10;
  long lVar11;
  undefined8 uVar12;
  bool bVar13;
  long lVar14;
  
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(uVar2,"stateId");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"stateTitle");
  lVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"token");
  lVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"stateJumpDataInfo");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  uVar7 = _objc_msgSend(&objc::class_t::WXStateJumpUrlInfo,"class");
  iVar1 = _objc_msgSend(uVar6,"isKindOfClass:",uVar7);
  _objc_release(uVar6);
  if (iVar1 == 0) {
    lVar8 = 0;
  }
  else {
    _objc_msgSend(uVar2,"stateJumpDataInfo");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"url");
    lVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar6);
  }
  if ((lVar3 == 0) || (puVar9 = (undefined *)_objc_msgSend(lVar3,"length"), puVar9 < &UNK_00002801))
  {
    if ((lVar4 == 0) ||
       (puVar9 = (undefined *)_objc_msgSend(lVar4,"length"), puVar9 <= &DAT_00002800)) {
      if ((lVar5 == 0) ||
         (puVar9 = (undefined *)_objc_msgSend(lVar5,"length"), puVar9 <= &DAT_00002800)) {
        if (lVar8 == 0) {
          lVar14 = 0;
        }
        else {
          puVar9 = (undefined *)_objc_msgSend(lVar8,"length");
          lVar14 = lVar8;
          if (&DAT_00002800 < puVar9) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_urltoolarge_largestsizeis_d);
            uVar7 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar10 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            goto LAB_0001205c;
          }
        }
        lVar11 = _objc_msgSend(lVar14,"length");
        if (lVar11 != 0) {
          if (lVar3 != 0) {
            _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar3,
                          &cf_stateId);
          }
          if (lVar4 != 0) {
            _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar4,
                          &cf_stateTitle);
          }
          if (lVar5 != 0) {
            _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar5,
                          &cf_stateToken);
          }
          _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",0);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf___);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_release(uVar6);
          _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",uVar7,
                        &cf_stateJumpType);
          _objc_release(uVar7);
          if (lVar8 != 0) {
            _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar14,
                          &cf_stateUrl);
          }
          bVar13 = 1;
          goto LAB_000120a0;
        }
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_statejumpurlshouldnotbenull_);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar10 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
      else {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_tokentoolarge_largestsizeis_d)
        ;
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar10 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
    }
    else {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_stateTitletoolarge_largestsizeis_d);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
  }
  else {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_stateIdtoolarge_largestsizeis_d);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
LAB_0001205c:
  uVar12 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar6,"printLog:level:",uVar12,0);
  _objc_release(uVar12);
  _objc_release(uVar10);
  _objc_release(uVar7);
  _objc_release(uVar6);
  bVar13 = 0;
LAB_000120a0:
  _objc_release(lVar8);
  _objc_release(lVar5);
  _objc_release(lVar4);
  _objc_release(lVar3);
  _objc_release(uVar2);
  return bVar13;
}



// Function Stack Size: 0x20 bytes

bool AppCommunicateData::MakeSceneDataObject_withText_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  bool bVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  long lVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  
  lVar3 = _objc_retain(param_3);
  uVar4 = _objc_retain(param_4);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    IVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sceneobjectisnil);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar6,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar5);
    bVar2 = 0;
  }
  else {
    uVar5 = _objc_msgSend(&objc::class_t::WXStateSceneDataObject,"class");
    iVar1 = _objc_msgSend(lVar3,"isKindOfClass:",uVar5);
    if (iVar1 == 0) {
      bVar2 = 0;
      goto LAB_0001236c;
    }
    IVar6 = _objc_retain(lVar3);
    _objc_msgSend(IVar6,"stateTitle");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    lVar7 = _objc_msgSend(uVar5,"length");
    if (lVar7 == 0) {
      lVar7 = _objc_msgSend(uVar4,"length");
      _objc_release(uVar5);
      if (lVar7 != 0) {
        _objc_msgSend(IVar6,"setStateTitle:",uVar4);
      }
    }
    else {
      _objc_release(uVar5);
    }
    bVar2 = makeStateSceneObject_(param_1,(SEL)"makeStateSceneObject:",IVar6);
  }
  _objc_release(IVar6);
LAB_0001236c:
  _objc_release(uVar4);
  _objc_release(lVar3);
  return bVar2;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeLinkObject_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  long lVar5;
  undefined8 uVar6;
  long lVar7;
  long lVar8;
  long lVar9;
  long lVar10;
  undefined *puVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  undefined8 uVar14;
  ulong uVar15;
  long lVar16;
  bool bVar17;
  long lVar18;
  uint uVar19;
  long lVar20;
  long lVar21;
  undefined8 *puVar22;
  undefined8 local_148;
  undefined4 local_134;
  undefined4 local_130;
  undefined4 local_12c;
  undefined8 local_128;
  ulong local_120;
  long local_f8;
  long local_f0;
  long local_e8;
  long local_e0;
  long local_d8;
  long local_d0;
  long local_c8;
  long local_c0;
  long local_b8;
  long local_b0;
  long local_a8;
  long local_a0;
  long local_98;
  long local_90;
  long local_88;
  long local_80;
  long local_78;
  long local_70;
  
  lVar5 = _objc_retain(param_3);
  if (lVar5 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    lVar16 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_mediaobjectisnil);
    local_70 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar12 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar16,"printLog:level:",uVar12,0);
    _objc_release(uVar12);
    _objc_release(uVar6);
LAB_00012cf4:
    _objc_release(local_70);
    bVar17 = 0;
    goto LAB_00013e38;
  }
  uVar6 = _objc_msgSend(&objc::class_t::WXImageObject,"class");
  iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
  if (iVar2 != 0) {
    uVar6 = _objc_retain(lVar5);
    lVar7 = _objc_msgSend(uVar6,"imageData");
    lVar18 = 0;
    lVar20 = 0;
    lVar16 = 0;
    uVar19 = 2;
    goto LAB_00012484;
  }
  uVar6 = _objc_msgSend(&objc::class_t::WXMusicObject,"class");
  iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
  if (iVar2 == 0) {
    uVar6 = _objc_msgSend(&objc::class_t::WXMusicVideoObject,"class");
    iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
    if (iVar2 == 0) {
      uVar6 = _objc_msgSend(&objc::class_t::WXVideoObject,"class");
      iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
      if (iVar2 == 0) {
        uVar6 = _objc_msgSend(&objc::class_t::WXWebpageObject,"class");
        iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
        if (iVar2 == 0) {
          uVar6 = _objc_msgSend(&objc::class_t::WXFileObject,"class");
          iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
          if (iVar2 == 0) {
            uVar6 = _objc_msgSend(&objc::class_t::WXVideoFileObject,"class");
            iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
            if (iVar2 == 0) {
              uVar6 = _objc_msgSend(&objc::class_t::WXGameVideoFileObject,"class");
              iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
              if (iVar2 != 0) {
                uVar6 = _objc_retain(lVar5);
                _objc_msgSend(uVar6,"videoFileData");
                lVar7 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar6,"videoUrl");
                local_c8 = _objc_retainAutoreleasedReturnValue();
                local_d0 = _objc_msgSend(uVar6,"thumbUrl");
                local_e0 = 0;
                local_b8 = 0;
                local_b0 = 0;
                local_134 = 0;
                local_130 = 0;
                local_f0 = 0;
                local_78 = 0;
                local_a0 = 0;
                local_98 = 0;
                local_90 = 0;
                local_88 = 0;
                local_128 = 0;
                local_a8 = 0;
                local_12c = 0;
                local_f8 = 0;
                local_120 = 0;
                lVar21 = 0;
                local_148 = 0;
                local_80 = 0;
                local_d8 = 0;
                local_e8 = 0;
                local_c0 = 0;
                lVar18 = 0;
                lVar20 = 0;
                lVar9 = 0;
                local_70 = 0;
                lVar8 = 0;
                lVar16 = 0;
                uVar19 = 0x27;
                goto LAB_00012988;
              }
              uVar6 = _objc_msgSend(&objc::class_t::WXAppExtendObject,"class");
              iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
              if (iVar2 == 0) {
                uVar6 = _objc_msgSend(&objc::class_t::WXEmoticonObject,"class");
                iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
                if (iVar2 == 0) {
                  uVar6 = _objc_msgSend(&objc::class_t::WXMiniProgramObject,"class");
                  iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
                  if (iVar2 == 0) {
                    uVar6 = _objc_msgSend(&objc::class_t::WXEnterpriseCardObject,"class");
                    iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
                    if (iVar2 == 0) {
                      uVar6 = _objc_msgSend(&objc::class_t::WXDynamicVideoMiniProgramObject,"class")
                      ;
                      iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
                      if (iVar2 == 0) {
                        uVar6 = _objc_msgSend(&objc::class_t::WXWeWorkObject,"class");
                        iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
                        if (iVar2 == 0) {
                          uVar6 = _objc_msgSend(&objc::class_t::WXGameLiveObject,"class");
                          iVar2 = _objc_msgSend(lVar5,"isKindOfClass:",uVar6);
                          if (iVar2 == 0) {
                            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                            lVar16 = _objc_retainAutoreleasedReturnValue();
                            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                          &cf_unkowobject);
                            uVar6 = _objc_retainAutoreleasedReturnValue();
                            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                            uVar12 = _objc_retainAutoreleasedReturnValue();
                            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                            uVar13 = _objc_retainAutoreleasedReturnValue();
                            _objc_msgSend(lVar16,"printLog:level:",uVar13,0);
                            _objc_release(uVar13);
                            _objc_release(uVar12);
                            _objc_release(uVar6);
                            bVar17 = 0;
                            goto LAB_00013e38;
                          }
                          uVar6 = _objc_retain(lVar5);
                          local_78 = _objc_msgSend(uVar6,"extraInfoDic");
                          local_e0 = 0;
                          local_b8 = 0;
                          local_b0 = 0;
                          local_134 = 0;
                          local_130 = 0;
                          local_f0 = 0;
                          local_a0 = 0;
                          local_98 = 0;
                          local_90 = 0;
                          local_88 = 0;
                          local_128 = 0;
                          local_a8 = 0;
                          local_12c = 0;
                          local_f8 = 0;
                          local_120 = 0;
                          lVar21 = 0;
                          local_148 = 0;
                          local_80 = 0;
                          local_d8 = 0;
                          local_d0 = 0;
                          local_c8 = 0;
                          local_e8 = 0;
                          local_c0 = 0;
                          lVar7 = 0;
                          lVar18 = 0;
                          lVar20 = 0;
                          lVar9 = 0;
                          local_70 = 0;
                          lVar8 = 0;
                          lVar16 = 0;
                          uVar19 = 0x46;
                        }
                        else {
                          uVar6 = _objc_retain(lVar5);
                          _objc_msgSend(uVar6,"data");
                          lVar7 = _objc_retainAutoreleasedReturnValue();
                          _objc_msgSend(uVar6,"subType");
                          lVar20 = _objc_msgSend(uVar6,"extInfo");
                          local_e0 = 0;
                          local_b8 = 0;
                          local_b0 = 0;
                          local_134 = 0;
                          local_130 = 0;
                          local_f0 = 0;
                          local_78 = 0;
                          local_a0 = 0;
                          local_98 = 0;
                          local_90 = 0;
                          local_88 = 0;
                          local_128 = 0;
                          local_a8 = 0;
                          local_12c = 0;
                          local_f8 = 0;
                          local_120 = 0;
                          lVar21 = 0;
                          local_148 = 0;
                          local_80 = 0;
                          local_d8 = 0;
                          local_d0 = 0;
                          local_c8 = 0;
                          local_e8 = 0;
                          local_c0 = 0;
                          lVar18 = 0;
                          lVar9 = 0;
                          local_70 = 0;
                          lVar8 = 0;
                          lVar16 = 0;
                          uVar19 = 0x31;
                        }
                      }
                      else {
                        uVar6 = _objc_retain(lVar5);
                        _objc_msgSend(uVar6,"webpageUrl");
                        lVar16 = _objc_retainAutoreleasedReturnValue();
                        _objc_msgSend(uVar6,"userName");
                        local_c0 = _objc_retainAutoreleasedReturnValue();
                        _objc_msgSend(uVar6,"path");
                        local_e8 = _objc_retainAutoreleasedReturnValue();
                        _objc_msgSend(uVar6,"hdImageData");
                        local_80 = _objc_retainAutoreleasedReturnValue();
                        uVar3 = _objc_msgSend(uVar6,"withShareTicket");
                        local_120 = _objc_msgSend(uVar6,"miniProgramType");
                        uVar4 = _objc_msgSend(uVar6,"disableForward");
                        local_148 = CONCAT44(uVar4,uVar3);
                        _objc_msgSend(uVar6,"videoSource");
                        local_c8 = _objc_retainAutoreleasedReturnValue();
                        local_d8 = _objc_msgSend(uVar6,"appThumbUrl");
                        local_e0 = 0;
                        local_b8 = 0;
                        local_b0 = 0;
                        local_134 = 0;
                        local_130 = 0;
                        local_f0 = 0;
                        local_78 = 0;
                        local_a0 = 0;
                        local_98 = 0;
                        local_90 = 0;
                        local_88 = 0;
                        local_128 = 0;
                        local_a8 = 0;
                        local_12c = 0;
                        local_f8 = 0;
                        lVar21 = 0;
                        local_d0 = 0;
                        lVar7 = 0;
                        lVar18 = 0;
                        lVar20 = 0;
                        lVar9 = 0;
                        local_70 = 0;
                        lVar8 = 0;
                        uVar19 = 0x2e;
                      }
                    }
                    else {
                      uVar6 = _objc_retain(lVar5);
                      _objc_msgSend(uVar6,"cardInfo");
                      lVar21 = _objc_retainAutoreleasedReturnValue();
                      uVar6 = _objc_msgSend(uVar6,"msgType");
                      local_e0 = _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInteger:",uVar6);
                      local_b8 = 0;
                      local_b0 = 0;
                      local_134 = 0;
                      local_130 = 0;
                      local_f0 = 0;
                      local_78 = 0;
                      local_a0 = 0;
                      local_98 = 0;
                      local_90 = 0;
                      local_88 = 0;
                      local_128 = 0;
                      local_a8 = 0;
                      local_12c = 0;
                      local_f8 = 0;
                      local_120 = 0;
                      local_148 = 0;
                      local_80 = 0;
                      local_d8 = 0;
                      local_d0 = 0;
                      local_c8 = 0;
                      local_e8 = 0;
                      local_c0 = 0;
                      lVar7 = 0;
                      lVar18 = 0;
                      lVar20 = 0;
                      lVar9 = 0;
                      local_70 = 0;
                      lVar8 = 0;
                      lVar16 = 0;
                      uVar19 = 0x2d;
                    }
                  }
                  else {
                    uVar6 = _objc_retain(lVar5);
                    _objc_msgSend(uVar6,"webpageUrl");
                    lVar16 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(uVar6,"userName");
                    local_c0 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(uVar6,"path");
                    local_e8 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(uVar6,"hdImageData");
                    local_80 = _objc_retainAutoreleasedReturnValue();
                    uVar3 = _objc_msgSend(uVar6,"withShareTicket");
                    local_120 = _objc_msgSend(uVar6,"miniProgramType");
                    uVar4 = _objc_msgSend(uVar6,"disableForward");
                    local_148 = CONCAT44(uVar4,uVar3);
                    local_134 = _objc_msgSend(uVar6,"isUpdatableMessage");
                    local_130 = _objc_msgSend(uVar6,"isSecretMessage");
                    local_f0 = _objc_msgSend(uVar6,"extraInfoDic");
                    local_e0 = 0;
                    local_b8 = 0;
                    local_b0 = 0;
                    local_78 = 0;
                    local_a0 = 0;
                    local_98 = 0;
                    local_90 = 0;
                    local_88 = 0;
                    local_128 = 0;
                    local_a8 = 0;
                    local_12c = 0;
                    local_f8 = 0;
                    lVar21 = 0;
                    local_d8 = 0;
                    local_d0 = 0;
                    local_c8 = 0;
                    lVar7 = 0;
                    lVar18 = 0;
                    lVar20 = 0;
                    lVar9 = 0;
                    local_70 = 0;
                    lVar8 = 0;
                    uVar19 = 0x24;
                  }
                  goto LAB_00012988;
                }
                uVar6 = _objc_retain(lVar5);
                lVar7 = _objc_msgSend(uVar6,"emoticonData");
                lVar18 = 0;
                lVar20 = 0;
                lVar16 = 0;
                uVar19 = 8;
              }
              else {
                uVar6 = _objc_retain(lVar5);
                _objc_msgSend(uVar6,"url");
                lVar16 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar6,"extInfo");
                lVar20 = _objc_retainAutoreleasedReturnValue();
                lVar7 = _objc_msgSend(uVar6,"fileData");
                lVar18 = 0;
                uVar19 = 7;
              }
            }
            else {
              uVar6 = _objc_retain(lVar5);
              lVar7 = _objc_msgSend(uVar6,"videoFileData");
              lVar18 = 0;
              lVar20 = 0;
              lVar16 = 0;
              uVar19 = 0x26;
            }
          }
          else {
            uVar6 = _objc_retain(lVar5);
            _objc_msgSend(uVar6,"fileExtension");
            lVar18 = _objc_retainAutoreleasedReturnValue();
            lVar7 = _objc_msgSend(uVar6,"fileData");
            lVar20 = 0;
            lVar16 = 0;
            uVar19 = 6;
          }
LAB_00012484:
          local_70 = 0;
          local_78 = 0;
          local_80 = 0;
          local_88 = 0;
          local_90 = 0;
          local_98 = 0;
          local_a0 = 0;
          local_a8 = 0;
          local_b0 = 0;
          local_b8 = 0;
          local_c0 = 0;
          local_c8 = 0;
          local_d0 = 0;
          local_d8 = 0;
          local_e0 = 0;
          local_e8 = 0;
          local_f0 = 0;
          local_f8 = 0;
          local_120 = 0;
          local_128 = 0;
          local_12c = 0;
          local_130 = 0;
          local_134 = 0;
          local_148 = 0;
          lVar21 = 0;
          lVar8 = 0;
          lVar9 = 0;
        }
        else {
          uVar6 = _objc_retain(lVar5);
          lVar16 = _objc_msgSend(uVar6,"webpageUrl");
          local_e0 = 0;
          local_b8 = 0;
          local_b0 = 0;
          local_134 = 0;
          local_130 = 0;
          local_f0 = 0;
          local_78 = 0;
          local_a0 = 0;
          local_98 = 0;
          local_90 = 0;
          local_88 = 0;
          local_128 = 0;
          local_a8 = 0;
          local_12c = 0;
          local_f8 = 0;
          local_120 = 0;
          lVar21 = 0;
          local_148 = 0;
          local_80 = 0;
          local_d8 = 0;
          local_d0 = 0;
          local_c8 = 0;
          local_e8 = 0;
          local_c0 = 0;
          lVar7 = 0;
          lVar18 = 0;
          lVar20 = 0;
          lVar9 = 0;
          local_70 = 0;
          lVar8 = 0;
          uVar19 = 5;
        }
      }
      else {
        uVar6 = _objc_retain(lVar5);
        _objc_msgSend(uVar6,"videoUrl");
        lVar16 = _objc_retainAutoreleasedReturnValue();
        lVar8 = _objc_msgSend(uVar6,"videoLowBandUrl");
        local_e0 = 0;
        local_b8 = 0;
        local_b0 = 0;
        local_134 = 0;
        local_130 = 0;
        local_f0 = 0;
        local_78 = 0;
        local_a0 = 0;
        local_98 = 0;
        local_90 = 0;
        local_88 = 0;
        local_128 = 0;
        local_a8 = 0;
        local_12c = 0;
        local_f8 = 0;
        local_120 = 0;
        lVar21 = 0;
        local_148 = 0;
        local_80 = 0;
        local_d8 = 0;
        local_d0 = 0;
        local_c8 = 0;
        local_e8 = 0;
        local_c0 = 0;
        lVar7 = 0;
        lVar18 = 0;
        lVar20 = 0;
        lVar9 = 0;
        local_70 = 0;
        uVar19 = 4;
      }
    }
    else {
      uVar6 = _objc_retain(lVar5);
      _objc_msgSend(uVar6,"musicUrl");
      lVar16 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"musicDataUrl");
      local_70 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"singerName");
      local_a0 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"songLyric");
      local_b8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"hdAlbumThumbData");
      local_88 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"albumName");
      local_90 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"musicGenre");
      local_98 = _objc_retainAutoreleasedReturnValue();
      local_128 = _objc_msgSend(uVar6,"issueDate");
      _objc_msgSend(uVar6,"identification");
      local_a8 = _objc_retainAutoreleasedReturnValue();
      local_12c = _objc_msgSend(uVar6,"duration");
      local_f8 = _objc_msgSend(uVar6,"musicOperationUrl");
      local_e0 = 0;
      local_b0 = 0;
      local_134 = 0;
      local_130 = 0;
      local_f0 = 0;
      local_78 = 0;
      local_120 = 0;
      lVar21 = 0;
      local_148 = 0;
      local_80 = 0;
      local_d8 = 0;
      local_d0 = 0;
      local_c8 = 0;
      local_e8 = 0;
      local_c0 = 0;
      lVar7 = 0;
      lVar18 = 0;
      lVar20 = 0;
      lVar9 = 0;
      lVar8 = 0;
      uVar19 = 0x4c;
    }
  }
  else {
    uVar6 = _objc_retain(lVar5);
    _objc_msgSend(uVar6,"musicUrl");
    lVar16 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"musicLowBandUrl");
    lVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"musicDataUrl");
    local_70 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"musicLowBandDataUrl");
    lVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"songAlbumUrl");
    local_b0 = _objc_retainAutoreleasedReturnValue();
    local_b8 = _objc_msgSend(uVar6,"songLyric");
    local_e0 = 0;
    local_134 = 0;
    local_130 = 0;
    local_f0 = 0;
    local_78 = 0;
    local_a0 = 0;
    local_98 = 0;
    local_90 = 0;
    local_88 = 0;
    local_128 = 0;
    local_a8 = 0;
    local_12c = 0;
    local_f8 = 0;
    local_120 = 0;
    lVar21 = 0;
    local_148 = 0;
    local_80 = 0;
    local_d8 = 0;
    local_d0 = 0;
    local_c8 = 0;
    local_e8 = 0;
    local_c0 = 0;
    lVar7 = 0;
    lVar18 = 0;
    lVar20 = 0;
    uVar19 = 3;
  }
LAB_00012988:
  _objc_retainAutoreleasedReturnValue();
  _objc_release(lVar5);
  if ((((lVar21 == 0) && (lVar20 == 0)) && (lVar7 == 0)) && (lVar16 == 0)) {
    lVar10 = _objc_msgSend(local_78,"count");
    if (lVar10 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_objectlosesomeparam);
      uVar12 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar13 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar14 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
      _objc_release(uVar14);
      _objc_release(uVar13);
      _objc_release(uVar12);
      _objc_release(uVar6);
      _objc_release(local_f8);
      _objc_release(local_a8);
      _objc_release(local_98);
      _objc_release(local_90);
      _objc_release(local_88);
      _objc_release(local_a0);
      _objc_release(local_78);
      _objc_release(local_f0);
      _objc_release(local_b8);
      _objc_release(local_b0);
      _objc_release(local_e0);
      _objc_release(local_80);
      _objc_release(local_d8);
      _objc_release(local_d0);
      _objc_release(local_c8);
      _objc_release(local_e8);
      _objc_release(local_c0);
      _objc_release(lVar18);
      _objc_release(lVar9);
      lVar16 = lVar8;
      goto LAB_00012cf4;
    }
    bVar1 = false;
LAB_00012d0c:
    if ((lVar8 == 0) ||
       (puVar11 = (undefined *)_objc_msgSend(lVar8,"length"), puVar11 <= &DAT_00002800)) {
      if ((local_70 == 0) ||
         (puVar11 = (undefined *)_objc_msgSend(local_70,"length"), puVar11 <= &DAT_00002800)) {
        if ((lVar9 != 0) &&
           (puVar11 = (undefined *)_objc_msgSend(lVar9,"length"), &DAT_00002800 < puVar11)) {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_objectlowBandDataUrltoolarge_largestsizeis_d);
          uVar12 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar13 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          uVar14 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
          _objc_release(uVar14);
          _objc_release(uVar13);
          _objc_release(uVar12);
          _objc_release(uVar6);
          _objc_release(local_f8);
          _objc_release(local_a8);
          _objc_release(local_98);
          _objc_release(local_90);
          _objc_release(local_88);
          _objc_release(local_a0);
          _objc_release(local_78);
          _objc_release(local_f0);
          _objc_release(local_b8);
          _objc_release(local_b0);
          _objc_release(local_e0);
          _objc_release(lVar21);
          _objc_release(local_80);
          _objc_release(local_d8);
          _objc_release(local_d0);
          _objc_release(local_c8);
          _objc_release(local_e8);
          _objc_release(local_c0);
          _objc_release(lVar7);
          goto LAB_0001313c;
        }
        if (uVar19 == 0x31) {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(lVar20,"length");
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_objectextInfolength__lu);
          uVar12 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          uVar13 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar6,"printLog:level:",uVar13,0);
          _objc_release(uVar13);
          _objc_release(uVar12);
          _objc_release(uVar6);
LAB_00013308:
          if ((lVar18 != 0) && (uVar15 = _objc_msgSend(lVar18,"length"), 0x40 < uVar15)) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_objectfileExttoolarge_largestsizeis_d);
            uVar12 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            goto LAB_000133c4;
          }
          if ((uVar19 | 1) == 0x27) {
            if ((lVar7 == 0) || (uVar15 = _objc_msgSend(lVar7,"length"), uVar15 < 0x40000001))
            goto LAB_00013a10;
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_objectgamefileDatatoolarge_largestsizeis_d);
            uVar12 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_00013938:
            uVar14 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
            _objc_release(uVar14);
            _objc_release(uVar13);
            _objc_release(uVar12);
            _objc_release(uVar6);
            _objc_release(local_f8);
            _objc_release(local_a8);
            _objc_release(local_98);
            _objc_release(local_90);
            _objc_release(local_88);
            _objc_release(local_a0);
            _objc_release(local_78);
            _objc_release(local_f0);
            _objc_release(local_b8);
            _objc_release(local_b0);
            _objc_release(local_e0);
            _objc_release(lVar21);
            _objc_release(local_80);
            _objc_release(local_d8);
            _objc_release(local_d0);
            _objc_release(local_c8);
            _objc_release(local_e8);
            _objc_release(local_c0);
            goto LAB_00013e00;
          }
          if (uVar19 == 2) {
            if ((lVar7 != 0) && (uVar15 = _objc_msgSend(lVar7,"length"), 0x1900000 < uVar15)) {
              _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
              uVar6 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                            &cf_objectimagedatatoolarge_largestsizeis_d);
              uVar12 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
              uVar13 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
              goto LAB_00013938;
            }
          }
          else if (uVar19 == 0x31) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(lVar7,"length");
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_objectdatalength__lu);
            uVar12 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar6,"printLog:level:",uVar13,0);
            _objc_release(uVar13);
            _objc_release(uVar12);
            _objc_release(uVar6);
          }
          else if ((lVar7 != 0) && (uVar15 = _objc_msgSend(lVar7,"length"), 0x40000000 < uVar15)) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_objectfileDatatoolarge_largestsizeis_d);
            uVar12 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            goto LAB_00013938;
          }
LAB_00013a10:
          if ((local_80 != 0) && (uVar15 = _objc_msgSend(local_80,"length"), 0x20000 < uVar15)) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_objecthdThumbDatatoolarge_largestsizeis_d);
            uVar12 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_00013d2c:
            uVar14 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
            _objc_release(uVar14);
            _objc_release(uVar13);
            _objc_release(uVar12);
            _objc_release(uVar6);
            _objc_release(local_f8);
            _objc_release(local_a8);
            _objc_release(local_98);
            _objc_release(local_90);
            _objc_release(local_88);
            _objc_release(local_a0);
            _objc_release(local_78);
            _objc_release(local_f0);
            _objc_release(local_b8);
            _objc_release(local_b0);
            _objc_release(local_e0);
            _objc_release(lVar21);
            goto LAB_00013dd0;
          }
          if (2 < local_120) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_miniProgramTypeisinvaild);
            uVar12 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            goto LAB_00013d2c;
          }
          if ((local_b0 == 0) ||
             (puVar11 = (undefined *)_objc_msgSend(local_b0,"length"), puVar11 < &UNK_00002801)) {
            if ((local_b8 != 0) && (uVar15 = _objc_msgSend(local_b8,"length"), 0x8000 < uVar15)) {
              _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
              uVar6 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                            &cf_objectsongLyrictoolarge_largestsizeis_d);
              uVar12 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
              uVar13 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_0001447c:
              uVar14 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
              _objc_release(uVar14);
              _objc_release(uVar13);
              _objc_release(uVar12);
              _objc_release(uVar6);
              _objc_release(local_f8);
              _objc_release(local_a8);
              _objc_release(local_98);
              _objc_release(local_90);
              _objc_release(local_88);
              _objc_release(local_a0);
              _objc_release(local_78);
              _objc_release(local_f0);
              _objc_release(local_b8);
              _objc_release(local_b0);
              _objc_release(local_e0);
              _objc_release(lVar21);
              _objc_release(local_80);
              _objc_release(local_d8);
              _objc_release(local_d0);
              _objc_release(local_c8);
              _objc_release(local_e8);
              _objc_release(local_c0);
              _objc_release(lVar7);
              _objc_release(lVar18);
              goto LAB_00013e10;
            }
            if ((local_88 == 0) || (uVar15 = _objc_msgSend(local_88,"length"), uVar15 < 0xa00001)) {
              if ((uVar19 == 0x4c) &&
                 (((lVar10 = _objc_msgSend(lVar16,"length"), lVar10 == 0 ||
                   (lVar10 = _objc_msgSend(local_70,"length"), lVar10 == 0)) ||
                  (lVar10 = _objc_msgSend(local_a0,"length"), lVar10 == 0)))) {
                _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                uVar6 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_m);
                uVar12 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                uVar13 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
              }
              else {
                uVar15 = _objc_msgSend(local_90,"length");
                if (((uVar15 < 0x401) && (uVar15 = _objc_msgSend(local_98,"length"), uVar15 < 0x401)
                    ) && (uVar15 = _objc_msgSend(local_a8,"length"), uVar15 < 0x401)) {
                  puVar11 = (undefined *)_objc_msgSend(local_f8,"length");
                  if (puVar11 <= &DAT_00002800) {
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__u);
                    uVar6 = _objc_retainAutoreleasedReturnValue();
                    puVar22 = (undefined8 *)(param_1 + 0x10);
                    _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",uVar6,&cf_objectType);
                    if (bVar1) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",lVar16,&cf_mediaUrl);
                    }
                    if (lVar8 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",lVar8,&cf_mediaLowBandUrl
                                   );
                    }
                    if (local_70 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_70,&cf_mediaDataUrl
                                   );
                    }
                    if (lVar9 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",lVar9,
                                    &cf_mediaLowBandDataUrl);
                    }
                    if (lVar20 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",lVar20,&cf_extInfo);
                    }
                    if (lVar18 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",lVar18,&cf_fileExt);
                    }
                    if (local_c0 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_c0,
                                    &cf_appBrandUserName);
                    }
                    if (local_e8 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_e8,&cf_appBrandPath
                                   );
                    }
                    if (local_c8 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_c8,
                                    &cf_sightCdnVideoUrl);
                    }
                    if (local_d0 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_d0,
                                    &cf_sightCdnThumbUrl);
                    }
                    if (local_d8 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_d8,
                                    &cf_sightAppThumbUrl);
                    }
                    if (local_80 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_80,&cf_hdThumbData)
                      ;
                    }
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_148 & 0xffffffff);
                    lVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_release();
                    if (lVar10 != 0) {
                      uVar13 = *puVar22;
                      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_148 & 0xffffffff
                                   );
                      uVar12 = _objc_retainAutoreleasedReturnValue();
                      _objc_msgSend(uVar13,"wxApi_safeSetObject:forKey:",uVar12,&cf_withShareTicket)
                      ;
                      _objc_release(uVar12);
                    }
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_148._4_4_);
                    lVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_release();
                    if (lVar10 != 0) {
                      uVar13 = *puVar22;
                      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_148._4_4_);
                      uVar12 = _objc_retainAutoreleasedReturnValue();
                      _objc_msgSend(uVar13,"wxApi_safeSetObject:forKey:",uVar12,&cf_disableForward);
                      _objc_release(uVar12);
                    }
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInteger:",local_120);
                    lVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_release();
                    if (lVar10 != 0) {
                      uVar13 = *puVar22;
                      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInteger:",local_120);
                      uVar12 = _objc_retainAutoreleasedReturnValue();
                      _objc_msgSend(uVar13,"wxApi_safeSetObject:forKey:",uVar12,&cf_miniprogramType)
                      ;
                      _objc_release(uVar12);
                    }
                    if (lVar21 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",lVar21,
                                    &cf_enterpriseCardInfo);
                    }
                    if (local_e0 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_e0,
                                    &cf_enterpriseCardMsgType);
                    }
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__d);
                    uVar12 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",uVar12,
                                  &cf_weworkObjectSubType);
                    _objc_release(uVar12);
                    if (local_b0 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_b0,&cf_songAlbumUrl
                                   );
                    }
                    if (local_b8 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_b8,&cf_songLyric);
                    }
                    if (lVar7 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",lVar7,&cf_fileData);
                    }
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_134);
                    lVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_release();
                    if (lVar10 != 0) {
                      uVar13 = *puVar22;
                      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_134);
                      uVar12 = _objc_retainAutoreleasedReturnValue();
                      _objc_msgSend(uVar13,"wxApi_safeSetObject:forKey:",uVar12,
                                    &cf_appbrandisupdatablemessage);
                      _objc_release(uVar12);
                    }
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_130);
                    lVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_release();
                    if (lVar10 != 0) {
                      uVar13 = *puVar22;
                      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",local_130);
                      uVar12 = _objc_retainAutoreleasedReturnValue();
                      _objc_msgSend(uVar13,"wxApi_safeSetObject:forKey:",uVar12,
                                    &cf_appbrandissecrectmessage);
                      _objc_release(uVar12);
                    }
                    if (local_f0 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_f0,
                                    &cf_appbrandextrainfo);
                    }
                    if (local_78 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_78,
                                    &cf_gameLiveExtraInfo);
                    }
                    if (local_a0 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_a0,
                                    &cf_musicVideoSingetName);
                    }
                    if (local_88 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_88,
                                    &cf_musicVideoHDThumbData);
                    }
                    if (local_90 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_90,
                                    &cf_musicVideoAlbumName);
                    }
                    if (local_a8 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_a8,
                                    &cf_musicVideoIdentification);
                    }
                    if (local_98 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_98,
                                    &cf_musicVideoMusicGenre);
                    }
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",local_12c);
                    uVar12 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf___);
                    uVar13 = _objc_retainAutoreleasedReturnValue();
                    _objc_release(uVar12);
                    _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",uVar13,
                                  &cf_musicVideoDuration);
                    _objc_release(uVar13);
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedLongLong:",local_128);
                    uVar12 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf___);
                    uVar13 = _objc_retainAutoreleasedReturnValue();
                    _objc_release(uVar12);
                    _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",uVar13,
                                  &cf_musicVideoIssueData);
                    _objc_release(uVar13);
                    if (local_f8 != 0) {
                      _objc_msgSend(*puVar22,"wxApi_safeSetObject:forKey:",local_f8,
                                    &cf_musicVideoOperationUrl);
                    }
                    _objc_release(uVar6);
                    _objc_release(local_f8);
                    _objc_release(local_a8);
                    _objc_release(local_98);
                    _objc_release(local_90);
                    _objc_release(local_88);
                    _objc_release(local_a0);
                    _objc_release(local_78);
                    _objc_release(local_f0);
                    _objc_release(local_b8);
                    _objc_release(local_b0);
                    _objc_release(local_e0);
                    _objc_release(lVar21);
                    _objc_release(local_80);
                    _objc_release(local_d8);
                    _objc_release(local_d0);
                    _objc_release(local_c8);
                    _objc_release(local_e8);
                    _objc_release(local_c0);
                    _objc_release(lVar7);
                    _objc_release(lVar18);
                    _objc_release(lVar20);
                    _objc_release(lVar9);
                    _objc_release(local_70);
                    _objc_release(lVar8);
                    bVar17 = 1;
                    goto LAB_00013e38;
                  }
                  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                  uVar6 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                &cf_musicOperationUrlistoolarge);
                  uVar12 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                  uVar13 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  uVar14 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
                  _objc_release(uVar14);
                  _objc_release(uVar13);
                  _objc_release(uVar12);
                  _objc_release(uVar6);
                  _objc_release(local_f8);
                  _objc_release(local_a8);
                  _objc_release(local_98);
                  _objc_release(local_90);
                  _objc_release(local_88);
                  _objc_release(local_a0);
                  _objc_release(local_78);
                  _objc_release(local_f0);
                  _objc_release(local_b8);
                  _objc_release(local_b0);
                  _objc_release(local_e0);
                  _objc_release(lVar21);
                  _objc_release(local_80);
                  _objc_release(local_d8);
                  _objc_release(local_d0);
                  _objc_release(local_c8);
                  _objc_release(local_e8);
                  _objc_release(local_c0);
                  _objc_release(lVar7);
                  _objc_release(lVar18);
                  goto LAB_00013e10;
                }
                _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                uVar6 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_a);
                uVar12 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                uVar13 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
              }
              goto LAB_0001447c;
            }
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(local_88,"length");
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_objecthdAlbumThumbDatatoolarge_sizeis_lu);
            uVar12 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            uVar14 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
            _objc_release(uVar14);
            _objc_release(uVar13);
            _objc_release(uVar12);
            _objc_release(uVar6);
            _objc_release(local_f8);
            _objc_release(local_a8);
            _objc_release(local_98);
            _objc_release(local_90);
            _objc_release(local_88);
            _objc_release(local_a0);
            _objc_release(local_78);
            _objc_release(local_f0);
            _objc_release(local_b8);
            _objc_release(local_b0);
            _objc_release(local_e0);
            _objc_release(lVar21);
            _objc_release(local_80);
            _objc_release(local_d8);
            _objc_release(local_d0);
            _objc_release(local_c8);
            _objc_release(local_e8);
            _objc_release(local_c0);
            _objc_release(lVar7);
            goto LAB_00013e08;
          }
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_objectsongAlbumUrltoolarge_largestsizeis_d);
          uVar12 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar13 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          uVar14 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
          _objc_release(uVar14);
          _objc_release(uVar13);
          _objc_release(uVar12);
          _objc_release(uVar6);
          _objc_release(local_f8);
          _objc_release(local_a8);
          _objc_release(local_98);
          _objc_release(local_90);
          _objc_release(local_88);
          _objc_release(local_a0);
          _objc_release(local_78);
          _objc_release(local_f0);
          _objc_release(local_b8);
          _objc_release(local_b0);
          _objc_release(local_e0);
          _objc_release(lVar21);
          _objc_release(local_80);
          _objc_release(local_d8);
          _objc_release(local_d0);
          _objc_release(local_c8);
          _objc_release(local_e8);
          _objc_release(local_c0);
          _objc_release(lVar7);
          _objc_release(lVar18);
        }
        else {
          if ((lVar20 == 0) || (uVar15 = _objc_msgSend(lVar20,"length"), uVar15 < 0x801))
          goto LAB_00013308;
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_objectextInfotoolarge_largestsizeis_d);
          uVar12 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar13 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_000133c4:
          uVar14 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
          _objc_release(uVar14);
          _objc_release(uVar13);
          _objc_release(uVar12);
          _objc_release(uVar6);
          _objc_release(local_f8);
          _objc_release(local_a8);
          _objc_release(local_98);
          _objc_release(local_90);
          _objc_release(local_88);
          _objc_release(local_a0);
          _objc_release(local_78);
          _objc_release(local_f0);
          _objc_release(local_b8);
          _objc_release(local_b0);
          _objc_release(local_e0);
          _objc_release(lVar21);
LAB_00013dd0:
          _objc_release(local_80);
          _objc_release(local_d8);
          _objc_release(local_d0);
          _objc_release(local_c8);
          _objc_release(local_e8);
          _objc_release(local_c0);
LAB_00013e00:
          _objc_release(lVar7);
LAB_00013e08:
          _objc_release(lVar18);
        }
LAB_00013e10:
        _objc_release(lVar20);
        _objc_release(lVar9);
        _objc_release(local_70);
        _objc_release(lVar8);
        bVar17 = 0;
        goto LAB_00013e38;
      }
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_objectdataUrltoolarge_largestsizeis_d);
      uVar12 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar13 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
    else {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_objectlowBandUrltoolarge_largestsizeis_d);
      uVar12 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar13 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
    uVar14 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
    _objc_release(uVar14);
    _objc_release(uVar13);
    _objc_release(uVar12);
    _objc_release(uVar6);
    _objc_release(local_f8);
    _objc_release(local_a8);
    _objc_release(local_98);
    _objc_release(local_90);
    _objc_release(local_88);
    _objc_release(local_a0);
    _objc_release(local_78);
    _objc_release(local_f0);
    _objc_release(local_b8);
    _objc_release(local_b0);
    _objc_release(local_e0);
    _objc_release(lVar21);
    _objc_release(local_80);
    _objc_release(local_d8);
    _objc_release(local_d0);
    _objc_release(local_c8);
    _objc_release(local_e8);
    _objc_release(local_c0);
    _objc_release(lVar7);
    _objc_release(lVar18);
    _objc_release(lVar20);
  }
  else {
    if (lVar16 == 0) {
      bVar1 = false;
      goto LAB_00012d0c;
    }
    puVar11 = (undefined *)_objc_msgSend(lVar16,"length");
    if (puVar11 < &UNK_00002801) {
      bVar1 = true;
      goto LAB_00012d0c;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_objecturltoolarge_largestsizeis_d)
    ;
    uVar12 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar13 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar14 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"printLog:level:",uVar14,0);
    _objc_release(uVar14);
    _objc_release(uVar13);
    _objc_release(uVar12);
    _objc_release(uVar6);
    _objc_release(local_f8);
    _objc_release(local_a8);
    _objc_release(local_98);
    _objc_release(local_90);
    _objc_release(local_88);
    _objc_release(local_a0);
    _objc_release(local_78);
    _objc_release(local_f0);
    _objc_release(local_b8);
    _objc_release(local_b0);
    _objc_release(local_e0);
    _objc_release(lVar21);
    _objc_release(local_80);
    _objc_release(local_d8);
    _objc_release(local_d0);
    _objc_release(local_c8);
    _objc_release(local_e8);
    _objc_release(local_c0);
    _objc_release(lVar7);
LAB_0001313c:
    _objc_release(lVar18);
    _objc_release(lVar20);
  }
  _objc_release(lVar9);
  _objc_release(local_70);
  _objc_release(lVar8);
  bVar17 = 0;
LAB_00013e38:
  _objc_release(lVar16);
  _objc_release(lVar5);
  return bVar17;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeMediaMessage_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  long lVar9;
  undefined8 uVar10;
  
  lVar2 = _objc_retain(param_3);
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_mediaMessageisnil);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_000161c8:
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar10,0);
    _objc_release(uVar10);
    _objc_release(uVar7);
    _objc_release(uVar6);
  }
  else {
    _objc_msgSend(lVar2,"title");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    if (lVar3 == 0) {
      _objc_release(0);
    }
    else {
      _objc_msgSend(lVar2,"title");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      uVar5 = _objc_msgSend(uVar4,"length");
      _objc_release(uVar4);
      _objc_release(lVar3);
      if (0x200 < uVar5) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &cf_mediaMessagetitletoolarge_largestsizeis_d);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        goto LAB_000161c8;
      }
    }
    _objc_msgSend(lVar2,"description");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    if (lVar3 == 0) {
      _objc_release(0);
    }
    else {
      _objc_msgSend(lVar2,"description");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      uVar5 = _objc_msgSend(uVar4,"length");
      _objc_release(uVar4);
      _objc_release(lVar3);
      if (0x400 < uVar5) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &cf_mediaMessagedescriptiontoolarge_largestsizeis_d);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        goto LAB_000161c8;
      }
    }
    _objc_msgSend(lVar2,"thumbData");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    if (lVar3 == 0) {
      _objc_release(0);
    }
    else {
      _objc_msgSend(lVar2,"thumbData");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      uVar5 = _objc_msgSend(uVar4,"length");
      _objc_release(uVar4);
      _objc_release(lVar3);
      if (0x10000 < uVar5) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &cf_mediaMessagethumbDatatoolarge_largestsizeis_d);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        goto LAB_000161c8;
      }
    }
    _objc_msgSend(lVar2,"thumbData");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar3 == 0) {
code_r0x000159a4:
      _objc_msgSend(lVar2,"mediaTagName");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      if (lVar3 == 0) {
        _objc_release(0);
      }
      else {
        _objc_msgSend(lVar2,"mediaTagName");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        uVar5 = _objc_msgSend(uVar4,"length");
        _objc_release(uVar4);
        _objc_release(lVar3);
        if (0x40 < uVar5) {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar4 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_mediaMessagemediaTagNametoolarge_largestsizeis_d);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          goto LAB_000161c8;
        }
      }
      _objc_msgSend(lVar2,"messageExt");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      if (lVar3 == 0) {
        _objc_release(0);
      }
      else {
        _objc_msgSend(lVar2,"messageExt");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        uVar5 = _objc_msgSend(uVar4,"length");
        _objc_release(uVar4);
        _objc_release(lVar3);
        if (0x800 < uVar5) {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar4 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_mediaMessagemessageExttoolarge_largestsizeis_d);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          goto LAB_000161c8;
        }
      }
      _objc_msgSend(lVar2,"messageAction");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      if (lVar3 == 0) {
        _objc_release(0);
      }
      else {
        _objc_msgSend(lVar2,"messageAction");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        uVar5 = _objc_msgSend(uVar4,"length");
        _objc_release(uVar4);
        _objc_release(lVar3);
        if (0x800 < uVar5) {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar4 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_mediaMessagemessageActiontoolarge_largestsizeis_d);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          goto LAB_000161c8;
        }
      }
      _objc_msgSend(lVar2,"title");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar3 != 0) {
        uVar6 = *(undefined8 *)(param_1 + 0x10);
        _objc_msgSend(lVar2,"title");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_title);
        _objc_release(uVar4);
      }
      _objc_msgSend(lVar2,"description");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar3 != 0) {
        uVar6 = *(undefined8 *)(param_1 + 0x10);
        _objc_msgSend(lVar2,"description");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_description);
        _objc_release(uVar4);
      }
      _objc_msgSend(lVar2,"thumbData");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar3 != 0) {
        uVar6 = *(undefined8 *)(param_1 + 0x10);
        _objc_msgSend(lVar2,"thumbData");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_thumbData);
        _objc_release(uVar4);
      }
      _objc_msgSend(lVar2,"mediaTagName");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar3 != 0) {
        uVar6 = *(undefined8 *)(param_1 + 0x10);
        _objc_msgSend(lVar2,"mediaTagName");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_mediaTagName);
        _objc_release(uVar4);
      }
      _objc_msgSend(lVar2,"messageExt");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar3 != 0) {
        uVar6 = *(undefined8 *)(param_1 + 0x10);
        _objc_msgSend(lVar2,"messageExt");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_messageExt);
        _objc_release(uVar4);
      }
      _objc_msgSend(lVar2,"messageAction");
      lVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar3 != 0) {
        uVar6 = *(undefined8 *)(param_1 + 0x10);
        _objc_msgSend(lVar2,"messageAction");
        uVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_messageAction);
        _objc_release(uVar4);
      }
      _objc_msgSend(lVar2,"mediaObject");
      IVar8 = _objc_retainAutoreleasedReturnValue();
      bVar1 = MakeLinkObject_(param_1,(SEL)"MakeLinkObject:",IVar8);
      _objc_release(IVar8);
      if ((bVar1 & 1) != 0) {
        _objc_msgSend(lVar2,"mediaObject");
        lVar3 = _objc_retainAutoreleasedReturnValue();
        if (lVar3 != 0) {
          _objc_msgSend(lVar2,"mediaObject");
          uVar4 = _objc_retainAutoreleasedReturnValue();
          uVar6 = _objc_msgSend(&objc::class_t::WXMusicVideoObject,"class");
          uVar5 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
          if ((uVar5 & 1) == 0) {
            _objc_release(uVar4);
            _objc_release(lVar3);
          }
          else {
            _objc_msgSend(lVar2,"title");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            lVar9 = _objc_msgSend(uVar6,"length");
            _objc_release(uVar6);
            _objc_release(uVar4);
            _objc_release(lVar3);
            if (lVar9 == 0) {
              _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
              uVar4 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_titleisnill);
              uVar6 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
              uVar7 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
              goto LAB_000161c8;
            }
          }
        }
        bVar1 = 1;
        goto LAB_0001620c;
      }
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_makelinkobjectfail);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_000161c8;
    }
    _objc_msgSend(lVar2,"thumbData");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___UIImage,"imageWithData:",uVar4);
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
    if (lVar3 != 0) {
      _objc_release(lVar3);
      goto code_r0x000159a4;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_mediaMessagethumbDatacannotbetranslateintoUIImage);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar10,0);
    _objc_release(uVar10);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar4);
    uVar4 = 0;
  }
  _objc_release(uVar4);
  bVar1 = 0;
LAB_0001620c:
  _objc_release(lVar2);
  return bVar1;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::sceneMessage(ID param_1,SEL param_2)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  SEL extraout_x1;
  
  if (*(long *)(param_1 + 0x10) == 0) {
    uVar6 = 0;
  }
  else {
    _objc_msgSend(*(long *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_stateId);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_stateTitle);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_stateUrl);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_stateToken);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_numberForKey:",&cf_stateJumpType);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar6,"intValue");
    _objc_release(uVar6);
    uVar6 = _objc_msgSend(&objc::class_t::WXSceneInternalMessage,"alloc");
    uVar6 = _objc_msgSend(uVar6,"init");
    _objc_msgSend(uVar6,"setStateId:",uVar2);
    _objc_msgSend(uVar6,"setStateTitle:",uVar3);
    _objc_msgSend(uVar6,"setStateUrl:",uVar4);
    _objc_msgSend(uVar6,"setStateToken:",uVar5);
    _objc_msgSend(uVar6,"setJumpType:",(long)iVar1);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    _objc_release(uVar2);
    param_2 = extraout_x1;
  }
  IVar7 = _objc_autoreleaseReturnValue(uVar6,param_2);
  return IVar7;
}



// Function Stack Size: 0x10 bytes

ID __thiscall
AppCommunicateData::mediaInternalMessage(AppCommunicateData *this,ID param_1,SEL param_2)

{
  undefined4 uVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  uint uVar5;
  long lVar6;
  long lVar7;
  long lVar8;
  long lVar9;
  long lVar10;
  long lVar11;
  long lVar12;
  long lVar13;
  long lVar14;
  long lVar15;
  long lVar16;
  long lVar17;
  long lVar18;
  undefined8 uVar19;
  undefined8 uVar20;
  undefined8 uVar21;
  long lVar22;
  long lVar23;
  long lVar24;
  long lVar25;
  undefined8 uVar26;
  long lVar27;
  undefined8 uVar28;
  long lVar29;
  long lVar30;
  undefined8 uVar31;
  undefined8 uVar32;
  undefined8 uVar33;
  undefined8 uVar34;
  undefined8 uVar35;
  undefined8 uVar36;
  undefined8 uVar37;
  undefined8 uVar38;
  undefined8 uVar39;
  undefined8 uVar40;
  long lVar41;
  undefined8 uVar42;
  ulong uVar43;
  undefined8 uVar44;
  ulong uVar45;
  undefined *puVar46;
  ulong uVar47;
  ID IVar48;
  ID extraout_x1;
  long *plVar49;
  undefined8 uVar50;
  undefined8 in_d1;
  
  plVar49 = (long *)(this + 0x10);
  if ((*plVar49 == 0) || (*(long *)(this + 8) != 0x3f2)) {
    uVar19 = 0;
    goto LAB_00016fd8;
  }
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_title);
  lVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_description);
  lVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_dataForKey:",&cf_thumbData);
  lVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_mediaTagName);
  lVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_messageExt);
  lVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_messageAction);
  lVar11 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_mediaUrl);
  lVar12 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_mediaLowBandUrl);
  lVar13 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_mediaDataUrl);
  lVar14 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_mediaLowBandDataUrl);
  lVar15 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_extInfo);
  lVar16 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_fileExt);
  lVar17 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_objectType);
  lVar18 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_appBrandUserName);
  uVar19 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar19,"stringByAppendingString:",&cf__app);
  uVar20 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar19);
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_appBrandPath);
  uVar19 = _objc_retainAutoreleasedReturnValue();
  uVar21 = _objc_msgSend(uVar19,"mutableCopy");
  _objc_release(uVar19);
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_sightCdnVideoUrl);
  lVar22 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_sightCdnThumbUrl);
  lVar23 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_sightAppThumbUrl);
  lVar24 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_dataForKey:",&cf_hdThumbData);
  lVar25 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_numberForKey:",&cf_withShareTicket);
  uVar19 = _objc_retainAutoreleasedReturnValue();
  uVar1 = _objc_msgSend(uVar19,"boolValue");
  _objc_release(uVar19);
  _objc_msgSend(*plVar49,"wxApi_numberForKey:",&cf_miniprogramType);
  uVar19 = _objc_retainAutoreleasedReturnValue();
  uVar26 = _objc_msgSend(uVar19,"unsignedIntegerValue");
  _objc_release(uVar19);
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_enterpriseCardInfo);
  lVar27 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_numberForKey:",&cf_enterpriseCardMsgType);
  uVar28 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_numberForKey:",&cf_weworkObjectSubType);
  uVar19 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(uVar19,"intValue");
  _objc_release(uVar19);
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_songAlbumUrl);
  lVar29 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_songLyric);
  lVar30 = _objc_retainAutoreleasedReturnValue();
  uVar3 = _objc_msgSend(*plVar49,"wxApi_boolForKey:",&cf_appbrandisupdatablemessage);
  uVar4 = _objc_msgSend(*plVar49,"wxApi_boolForKey:",&cf_appbrandissecrectmessage);
  _objc_msgSend(*plVar49,"wxApi_dictionaryForKey:",&cf_appbrandextrainfo);
  uVar31 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_dictionaryForKey:",&cf_gameLiveExtraInfo);
  uVar32 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_musicVideoSingetName);
  uVar33 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_dataForKey:",&cf_musicVideoHDThumbData);
  uVar34 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_musicVideoAlbumName);
  uVar35 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_musicVideoMusicGenre);
  uVar36 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_musicVideoIdentification);
  uVar37 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_musicVideoIssueData);
  uVar38 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_musicVideoDuration);
  uVar39 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(*plVar49,"wxApi_stringForKey:",&cf_musicVideoOperationUrl);
  uVar40 = _objc_retainAutoreleasedReturnValue();
  lVar41 = _objc_msgSend(uVar38,"length");
  if (lVar41 == 0) {
    uVar42 = 0;
  }
  else {
    uVar42 = _objc_msgSend(uVar38,"longLongValue");
  }
  uVar43 = _objc_msgSend(uVar39,"length");
  if (uVar43 != 0) {
    uVar43 = _objc_msgSend(uVar39,"intValue");
  }
  uVar44 = uVar20;
  if (lVar18 == 0) goto LAB_00016ecc;
  uVar5 = _objc_msgSend(lVar18,"intValue");
  if ((uVar5 == 0x2e) || (uVar5 == 0x24)) {
    lVar41 = _objc_msgSend(uVar20,"rangeOfString:",&cf__);
    if ((lVar41 == 0x7fffffffffffffff) && (lVar41 = _objc_msgSend(uVar20,"length"), lVar41 != 0)) {
      _objc_msgSend(uVar20,"stringByAppendingString:",&cf__app);
      uVar44 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar20);
      lVar41 = _objc_msgSend(uVar21,"rangeOfString:",&cf__);
      if (lVar41 == 0x7fffffffffffffff) {
        lVar41 = _objc_msgSend(uVar21,"length");
        if (lVar41 != 0) {
          _objc_msgSend(uVar21,"appendString:",&cf__html);
        }
      }
      else {
        _objc_msgSend(uVar21,"insertString:atIndex:",&cf__html,lVar41);
      }
      goto LAB_00016bfc;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar19 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_nsAppBrandUserNameformatisnotright
                 );
    uVar26 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar42 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar44 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar19,"printLog:level:",uVar44,0);
    _objc_release(uVar44);
    _objc_release(uVar42);
    _objc_release(uVar26);
    _objc_release(uVar19);
    uVar19 = 0;
    goto LAB_00016ed0;
  }
LAB_00016bfc:
  if ((lVar6 == 0) || (uVar45 = _objc_msgSend(lVar6,"length"), uVar45 < 0x201)) {
    if ((lVar7 != 0) && (uVar45 = _objc_msgSend(lVar7,"length"), 0x400 < uVar45)) goto LAB_00016ecc;
    uVar20 = uVar44;
    if ((lVar8 == 0) || (uVar45 = _objc_msgSend(lVar8,"length"), uVar45 < 0x10001)) {
      if ((((lVar12 != 0) || (((lVar27 != 0 || (lVar16 != 0)) || (*(long *)(this + 0x18) != 0)))) &&
          ((((lVar9 == 0 || (uVar45 = _objc_msgSend(lVar9,"length"), uVar45 < 0x41)) &&
            ((lVar10 == 0 || (uVar45 = _objc_msgSend(lVar10,"length"), uVar45 < 0x801)))) &&
           ((lVar11 == 0 || (uVar45 = _objc_msgSend(lVar11,"length"), uVar45 < 0x801)))))) &&
         (((lVar12 == 0 ||
           (puVar46 = (undefined *)_objc_msgSend(lVar12,"length"), puVar46 < &UNK_00002801)) &&
          ((((lVar13 == 0 ||
             (puVar46 = (undefined *)_objc_msgSend(lVar13,"length"), puVar46 < &UNK_00002801)) &&
            ((lVar14 == 0 ||
             (puVar46 = (undefined *)_objc_msgSend(lVar14,"length"), puVar46 < &UNK_00002801)))) &&
           ((((lVar15 == 0 ||
              (puVar46 = (undefined *)_objc_msgSend(lVar15,"length"), puVar46 < &UNK_00002801)) &&
             ((lVar16 == 0 ||
              ((uVar5 == 0x31 || (uVar45 = _objc_msgSend(lVar16,"length"), uVar45 < 0x801)))))) &&
            ((lVar17 == 0 || (uVar45 = _objc_msgSend(lVar17,"length"), uVar45 < 0x41)))))))))) {
        uVar45 = 0x1900000;
        if ((uVar5 | 1) == 0x27 || uVar5 != 2) {
          uVar45 = 0x40000000;
        }
        if ((((((uVar5 == 0x31) || (*(long *)(this + 0x18) == 0)) ||
              (uVar47 = _objc_msgSend(*(long *)(this + 0x18),"length"), uVar47 <= uVar45)) &&
             ((lVar22 == 0 ||
              (puVar46 = (undefined *)_objc_msgSend(lVar22,"length"), puVar46 <= &DAT_00002800))))
            && ((((lVar23 == 0 ||
                  (puVar46 = (undefined *)_objc_msgSend(lVar23,"length"), puVar46 < &UNK_00002801))
                 && ((lVar24 == 0 ||
                     (puVar46 = (undefined *)_objc_msgSend(lVar24,"length"), puVar46 < &UNK_00002801
                     )))) &&
                ((lVar25 == 0 || (uVar45 = _objc_msgSend(lVar25,"length"), uVar45 < 0x20001)))))) &&
           (((lVar29 == 0 ||
             (puVar46 = (undefined *)_objc_msgSend(lVar29,"length"), puVar46 < &UNK_00002801)) &&
            ((lVar30 == 0 ||
             (puVar46 = (undefined *)_objc_msgSend(lVar30,"length"), puVar46 < &UNK_00008001)))))) {
          lVar41 = _objc_msgSend(lVar25,"length");
          if (lVar41 == 0) {
            uVar50 = *(undefined8 *)PTR__CGSizeZero_00040000;
            in_d1 = *(undefined8 *)(PTR__CGSizeZero_00040000 + 8);
          }
          else {
            _objc_msgSend(&_OBJC_CLASS___UIImage,"imageWithData:",lVar25);
            uVar19 = _objc_retainAutoreleasedReturnValue();
            uVar50 = _objc_msgSend(uVar19,"size");
            _objc_release(uVar19);
          }
          if ((((lVar13 == 0) && (lVar12 == 0)) && (uVar5 == 3)) ||
             ((uVar5 == 0x2d && (lVar41 = _objc_msgSend(lVar27,"length"), lVar41 == 0)))) {
            uVar19 = 0;
          }
          else {
            uVar19 = _objc_msgSend(&objc::class_t::WXMediaInternalMessage,"alloc");
            uVar19 = _objc_msgSend(uVar19,"init");
            _objc_msgSend(uVar19,"setTitle:",lVar6);
            _objc_msgSend(uVar19,"setDescription:",lVar7);
            _objc_msgSend(uVar19,"setThumbData:",lVar8);
            _objc_msgSend(uVar19,"setMediaTagName:",lVar9);
            _objc_msgSend(uVar19,"setMessageExt:",lVar10);
            _objc_msgSend(uVar19,"setMessageAction:",lVar11);
            _objc_msgSend(uVar19,"setObjectType:",(long)(int)uVar5);
            _objc_msgSend(uVar19,"setMediaUrl:",lVar12);
            _objc_msgSend(uVar19,"setMediaLowBandUrl:",lVar13);
            _objc_msgSend(uVar19,"setMediaDataUrl:",lVar14);
            _objc_msgSend(uVar19,"setMediaLowBandDataUrl:",lVar15);
            _objc_msgSend(uVar19,"setExtInfo:",lVar16);
            _objc_msgSend(uVar19,"setFileExt:",lVar17);
            _objc_msgSend(uVar19,"setFileData:",*(undefined8 *)(this + 0x18));
            _objc_msgSend(uVar19,"setAppBrandUserName:",uVar44);
            _objc_msgSend(uVar19,"setAppBrandPath:",uVar21);
            _objc_msgSend(uVar19,"setSightCdnVideoUrl:",lVar22);
            _objc_msgSend(uVar19,"setSightCdnThumbUrl:",lVar23);
            _objc_msgSend(uVar19,"setSightAppThumbUrl:",lVar24);
            _objc_msgSend(uVar19,"setHdThumbData:",lVar25);
            _objc_msgSend(uVar50,in_d1,uVar19,"setHdThumbImageSize:");
            _objc_msgSend(uVar19,"setAppBrandWithShareTikcet:",uVar1);
            _objc_msgSend(uVar19,"setAppBrandMiniProgramType:",uVar26);
            _objc_msgSend(uVar19,"setEnterpriseCardContent:",lVar27);
            uVar26 = _objc_msgSend(uVar28,"integerValue");
            _objc_msgSend(uVar19,"setEnterpriseCardMsgType:",uVar26);
            _objc_msgSend(uVar19,"setWeworkSubType:",uVar2);
            _objc_msgSend(uVar19,"setSongAlbumUrl:",lVar29);
            _objc_msgSend(uVar19,"setSongLyric:",lVar30);
            _objc_msgSend(uVar19,"setIsAppBrandUpdatableMessage:",uVar3);
            _objc_msgSend(uVar19,"setIsAppBrandSecretMessage:",uVar4);
            _objc_msgSend(uVar19,"setAppBrandExtraInfoDic:",uVar31);
            _objc_msgSend(uVar19,"setGameLiveExtraInfoDic:",uVar32);
            _objc_msgSend(uVar19,"setMusicVideoAlbumName:",uVar35);
            _objc_msgSend(uVar19,"setMusicVideoIdentification:",uVar37);
            _objc_msgSend(uVar19,"setMusicVideoIssueDate:",uVar42);
            _objc_msgSend(uVar19,"setMusicVideoMusicGenre:",uVar36);
            _objc_msgSend(uVar19,"setMusicVideoSingerName:",uVar33);
            _objc_msgSend(uVar19,"setMusicVideoHdAlbumThumbData:",uVar34);
            _objc_msgSend(uVar19,"setMusicVideoDuration:",uVar43 & 0xffffffff);
            _objc_msgSend(uVar19,"setMusicVideoOperationUrl:",uVar40);
          }
          goto LAB_00016ed0;
        }
      }
      goto LAB_00016ecc;
    }
    uVar19 = 0;
  }
  else {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar19 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf___);
    uVar20 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar26 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar42 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar19,"printLog:level:",uVar42,0);
    _objc_release(uVar42);
    _objc_release(uVar26);
    _objc_release(uVar20);
    _objc_release(uVar19);
LAB_00016ecc:
    uVar19 = 0;
    uVar20 = uVar44;
  }
LAB_00016ed0:
  _objc_release(uVar40);
  _objc_release(uVar39);
  _objc_release(uVar38);
  _objc_release(uVar37);
  _objc_release(uVar36);
  _objc_release(uVar35);
  _objc_release(uVar34);
  _objc_release(uVar33);
  _objc_release(uVar32);
  _objc_release(uVar31);
  _objc_release(lVar30);
  _objc_release(lVar29);
  _objc_release(uVar28);
  _objc_release(lVar27);
  _objc_release(lVar25);
  _objc_release(lVar24);
  _objc_release(lVar23);
  _objc_release(lVar22);
  _objc_release(uVar21);
  _objc_release(uVar20);
  _objc_release(lVar18);
  _objc_release(lVar17);
  _objc_release(lVar16);
  _objc_release(lVar15);
  _objc_release(lVar14);
  _objc_release(lVar13);
  _objc_release(lVar12);
  _objc_release(lVar11);
  _objc_release(lVar10);
  _objc_release(lVar9);
  _objc_release(lVar8);
  _objc_release(lVar7);
  _objc_release(lVar6);
  param_1 = extraout_x1;
LAB_00016fd8:
  IVar48 = _objc_autoreleaseReturnValue(uVar19,param_1);
  return IVar48;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::MakeMediaInternalMessage_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  bool bVar5;
  long *plVar6;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    bVar5 = 0;
  }
  else {
    plVar6 = (long *)(param_1 + 0x10);
    if (*plVar6 == 0) {
      initCommonField_(param_1,(SEL)"initCommonField:",0x3f2);
    }
    _objc_msgSend(lVar1,"title");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"title");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_title);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"description");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"description");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_description);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"thumbData");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"thumbData");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_thumbData);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"objectType");
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__lu);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(*plVar6,"wxApi_safeSetObject:forKey:",uVar3,&cf_objectType);
    _objc_msgSend(lVar1,"mediaTagName");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"mediaTagName");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_mediaTagName);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"messageExt");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"messageExt");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_messageExt);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"messageAction");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"messageAction");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_messageAction);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"mediaUrl");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"mediaUrl");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_mediaUrl);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"mediaLowBandUrl");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"mediaLowBandUrl");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_mediaLowBandUrl);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"mediaDataUrl");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"mediaDataUrl");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_mediaDataUrl);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"mediaLowBandDataUrl");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"mediaLowBandDataUrl");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_mediaLowBandDataUrl);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"extInfo");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"extInfo");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_extInfo);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"fileExt");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"fileExt");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_fileExt);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"appBrandUserName");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"appBrandUserName");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_appBrandUserName);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"appBrandPath");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"appBrandPath");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_appBrandPath);
      _objc_release(uVar4);
    }
    _objc_msgSend(lVar1,"fileData");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar2 != 0) {
      lVar2 = *plVar6;
      _objc_msgSend(lVar1,"fileData");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(lVar2,"wxApi_safeSetObject:forKey:",uVar4,&cf_fileData);
      _objc_release(uVar4);
    }
    _objc_release(uVar3);
    bVar5 = 1;
  }
  _objc_release(lVar1);
  return bVar5;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::DataToReq(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ID IVar3;
  SEL extraout_x1;
  SEL extraout_x1_00;
  long lVar4;
  
  lVar4 = *(long *)(param_1 + 8);
  if (lVar4 == 0x7f8) {
    mediaMessage(param_1,(SEL)"mediaMessage");
    lVar4 = _objc_retainAutoreleasedReturnValue();
    uVar1 = _objc_msgSend(&objc::class_t::LaunchFromWXReq,"alloc");
    uVar2 = _objc_msgSend(uVar1,"init");
    openID(param_1,(SEL)"openID");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"setOpenID:",uVar1);
    _objc_release(uVar1);
    lang(param_1,(SEL)"lang");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"setLang:",uVar1);
    _objc_release(uVar1);
    country(param_1,(SEL)"country");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"setCountry:",uVar1);
    _objc_release(uVar1);
    _objc_msgSend(uVar2,"setMessage:",lVar4);
  }
  else {
    if (lVar4 != 2000) {
      if (lVar4 == 0x3f2) {
        mediaMessage(param_1,(SEL)"mediaMessage");
        lVar4 = _objc_retainAutoreleasedReturnValue();
        if (lVar4 != 0) {
          uVar1 = _objc_msgSend(&objc::class_t::ShowMessageFromWXReq,"alloc");
          uVar2 = _objc_msgSend(uVar1,"init");
          openID(param_1,(SEL)"openID");
          uVar1 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar2,"setOpenID:",uVar1);
          _objc_release(uVar1);
          _objc_msgSend(uVar2,"setMessage:",lVar4);
          lang(param_1,(SEL)"lang");
          uVar1 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar2,"setLang:",uVar1);
          _objc_release(uVar1);
          country(param_1,(SEL)"country");
          uVar1 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar2,"setCountry:",uVar1);
          _objc_release(uVar1);
          goto LAB_00017e70;
        }
        _objc_release(0);
        param_2 = extraout_x1_00;
      }
      uVar2 = 0;
      goto LAB_00017e84;
    }
    uVar1 = _objc_msgSend(&objc::class_t::GetMessageFromWXReq,"alloc");
    uVar2 = _objc_msgSend(uVar1,"init");
    openID(param_1,(SEL)"openID");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"setOpenID:",uVar1);
    _objc_release(uVar1);
    lang(param_1,(SEL)"lang");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"setLang:",uVar1);
    _objc_release(uVar1);
    country(param_1,(SEL)"country");
    lVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"setCountry:",lVar4);
  }
LAB_00017e70:
  _objc_release(lVar4);
  param_2 = extraout_x1;
LAB_00017e84:
  IVar3 = _objc_autoreleaseReturnValue(uVar2,param_2);
  return IVar3;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::DataToResp(ID param_1,SEL param_2)

{
  int iVar1;
  undefined8 uVar2;
  ID IVar3;
  char *pcVar4;
  SEL extraout_x1;
  SEL extraout_x1_00;
  long lVar5;
  undefined8 uVar6;
  
  uVar6 = 0;
  lVar5 = *(long *)(param_1 + 8);
  if (lVar5 < 0x820) {
    if (0x801 < lVar5) {
      if (lVar5 == 0x802) {
        uVar6 = _objc_msgSend(&objc::class_t::CreateChatRoomResp,"alloc");
        uVar6 = _objc_msgSend(uVar6,"init");
        iVar1 = result(param_1,(SEL)"result");
        _objc_msgSend(uVar6,"setErrCode:",iVar1);
        _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
      }
      else if (lVar5 == 0x80c) {
        uVar6 = _objc_msgSend(&objc::class_t::JoinChatRoomResp,"alloc");
        uVar6 = _objc_msgSend(uVar6,"init");
        iVar1 = result(param_1,(SEL)"result");
        _objc_msgSend(uVar6,"setErrCode:",iVar1);
        _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
      }
      else {
        if (lVar5 != 0x816) goto LAB_000184a4;
        uVar6 = _objc_msgSend(&objc::class_t::WXLaunchMiniProgramResp,"alloc");
        uVar6 = _objc_msgSend(uVar6,"init");
        iVar1 = result(param_1,(SEL)"result");
        _objc_msgSend(uVar6,"setErrCode:",iVar1);
        _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
      }
      goto LAB_00018480;
    }
    if (lVar5 == 0x7da) {
      uVar6 = _objc_msgSend(&objc::class_t::SendMessageToWXResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
      iVar1 = result(param_1,(SEL)"result");
      _objc_msgSend(uVar6,"setErrCode:",iVar1);
      lang(param_1,(SEL)"lang");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"setLang:",uVar2);
      _objc_release(uVar2);
      country(param_1,(SEL)"country");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      pcVar4 = "setCountry:";
      goto LAB_00018490;
    }
    if (lVar5 == 0x7e4) {
      uVar6 = _objc_msgSend(&objc::class_t::SendMessageToWXResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
      iVar1 = result(param_1,(SEL)"result");
      _objc_msgSend(uVar6,"setErrCode:",iVar1);
      param_2 = extraout_x1;
      goto LAB_000184a4;
    }
    if (lVar5 != 0x7ee) goto LAB_000184a4;
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_tdi_ext_info);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    lVar5 = _objc_msgSend(uVar2,"length");
    if (lVar5 == 0) {
      uVar6 = _objc_msgSend(&objc::class_t::SendAuthResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
    }
    else {
      uVar6 = _objc_msgSend(&objc::class_t::SendTdiAuthResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
      _objc_msgSend(uVar6,"setTdiExtInfo:",uVar2);
    }
    iVar1 = result(param_1,(SEL)"result");
    _objc_msgSend(uVar6,"setErrCode:",iVar1);
  }
  else {
    if (lVar5 < 0x83e) {
      if (lVar5 == 0x820) {
        uVar6 = _objc_msgSend(&objc::class_t::WXOpenBusinessViewResp,"alloc");
        uVar6 = _objc_msgSend(uVar6,"init");
        iVar1 = result(param_1,(SEL)"result");
        _objc_msgSend(uVar6,"setErrCode:",iVar1);
        _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
        uVar2 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"setExtMsg:",uVar2);
        _objc_release(uVar2);
        _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_businessType);
        uVar2 = _objc_retainAutoreleasedReturnValue();
        pcVar4 = "setBusinessType:";
        goto LAB_00018490;
      }
      if (lVar5 == 0x82a) {
        uVar6 = _objc_msgSend(&objc::class_t::WXChannelShareVideoResp,"alloc");
        uVar6 = _objc_msgSend(uVar6,"init");
        iVar1 = result(param_1,(SEL)"result");
        _objc_msgSend(uVar6,"setErrCode:",iVar1);
        _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
      }
      else {
        if (lVar5 != 0x834) goto LAB_000184a4;
        uVar6 = _objc_msgSend(&objc::class_t::WXChannelOpenProfileResp,"alloc");
        uVar6 = _objc_msgSend(uVar6,"init");
        iVar1 = result(param_1,(SEL)"result");
        _objc_msgSend(uVar6,"setErrCode:",iVar1);
        _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
      }
    }
    else if (lVar5 == 0x83e) {
      uVar6 = _objc_msgSend(&objc::class_t::WXChannelOpenLiveResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
      iVar1 = result(param_1,(SEL)"result");
      _objc_msgSend(uVar6,"setErrCode:",iVar1);
      _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
    }
    else if (lVar5 == 0x848) {
      uVar6 = _objc_msgSend(&objc::class_t::WXChannelOpenFeedResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
      iVar1 = result(param_1,(SEL)"result");
      _objc_msgSend(uVar6,"setErrCode:",iVar1);
      _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
    }
    else {
      if (lVar5 != 0x852) goto LAB_000184a4;
      uVar6 = _objc_msgSend(&objc::class_t::WXOpenCustomerServiceResp,"alloc");
      uVar6 = _objc_msgSend(uVar6,"init");
      iVar1 = result(param_1,(SEL)"result");
      _objc_msgSend(uVar6,"setErrCode:",iVar1);
      _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_stringForKey:",&cf_messageExt);
    }
LAB_00018480:
    uVar2 = _objc_retainAutoreleasedReturnValue();
    pcVar4 = "setExtMsg:";
LAB_00018490:
    _objc_msgSend(uVar6,pcVar4,uVar2);
  }
  _objc_release(uVar2);
  param_2 = extraout_x1_00;
LAB_000184a4:
  IVar3 = _objc_autoreleaseReturnValue(uVar6,param_2);
  return IVar3;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::ReqToData_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  
  bVar1 = _objc_msgSend((int)param_1,"ReqToData:withMediaInternalMessage:",param_3,0);
  return bVar1;
}



// Function Stack Size: 0x20 bytes

bool AppCommunicateData::ReqToData_withMediaInternalMessage_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  bool bVar2;
  uint uVar3;
  undefined8 uVar4;
  ID IVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  long lVar8;
  ulong uVar9;
  ID IVar10;
  ID IVar11;
  undefined8 uVar12;
  cfstringStruct *pcVar13;
  undefined8 uVar14;
  
  uVar4 = _objc_retain(param_3);
  IVar5 = _objc_retain(param_4);
  uVar6 = _objc_msgSend(&objc::class_t::SendMessageToWXReq,"class");
  iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
  if (iVar1 == 0) {
    uVar6 = _objc_msgSend(&objc::class_t::WXLaunchMiniProgramReq,"class");
    iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
    if (iVar1 == 0) {
      uVar6 = _objc_msgSend(&objc::class_t::WXLaunchWxaRedirectingPageReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(IVar10,"extDict");
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &cf_LaunchWxaRedirectingPagetodataextDic___);
        uVar14 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        uVar12 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"printLog:level:",uVar12,0);
        _objc_release(uVar12);
        _objc_release(uVar14);
        _objc_release(uVar7);
        _objc_release(uVar6);
        initCommonField_(param_1,(SEL)"initCommonField:",0x442);
        _objc_msgSend(IVar10,"extDict");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"extDict");
          goto LAB_00018890;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::GetMessageFromWXReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",2000);
        _objc_msgSend(IVar10,"openID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"openID");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_openID);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"lang");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"lang");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_language);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"country");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"country");
LAB_0001917c:
          uVar7 = _objc_retainAutoreleasedReturnValue();
          pcVar13 = &cf_country;
          goto LAB_00019194;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::ShowMessageFromWXReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x3f2);
        MakeMediaInternalMessage_(param_1,(SEL)"MakeMediaInternalMessage:",IVar5);
        _objc_msgSend(IVar10,"openID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"openID");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_openID);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"lang");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"lang");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_language);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"country");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"country");
          goto LAB_0001917c;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::LaunchFromWXReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x7f8);
        MakeMediaInternalMessage_(param_1,(SEL)"MakeMediaInternalMessage:",IVar5);
        _objc_msgSend(IVar10,"openID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"openID");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_openID);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"lang");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"lang");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_language);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"country");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"country");
          goto LAB_0001917c;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::WXOpenBusinessViewReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x820);
        MakeMediaInternalMessage_(param_1,(SEL)"MakeMediaInternalMessage:",IVar5);
        _objc_msgSend(IVar10,"openID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"openID");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_openID);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"extData");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"extData");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          pcVar13 = &cf_fileData;
          goto LAB_00019194;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::WXChannelShareVideoReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x82a);
        makeChannelShareVideoToDicData_(param_1,(SEL)"makeChannelShareVideoToDicData:",IVar10);
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::WXChannelOpenProfileReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x834);
        _objc_msgSend(IVar10,"userName");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"userName");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          pcVar13 = &cf_finderUserName;
          goto LAB_00019194;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::WXChannelOpenLiveReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x83e);
        _objc_msgSend(IVar10,"feedID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"feedID");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderFeedID);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"nonceID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"nonceID");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          pcVar13 = &cf_finderNonceID;
          goto LAB_00019194;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::WXChannelOpenFeedReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x848);
        _objc_msgSend(IVar10,"feedID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"feedID");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderFeedID);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"nonceID");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"nonceID");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderNonceID);
          _objc_release(uVar6);
        }
        uVar6 = _objc_msgSend(IVar10,"notGetReleatedList");
        _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",uVar6);
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          uVar7 = _objc_msgSend(IVar10,"notGetReleatedList");
          _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",uVar7);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          pcVar13 = &cf_notGetReleatedList;
          goto LAB_00019194;
        }
        goto LAB_000191ac;
      }
      uVar6 = _objc_msgSend(&objc::class_t::WXOpenCustomerServiceReq,"class");
      iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
      if (iVar1 != 0) {
        IVar10 = _objc_retain(uVar4);
        initCommonField_(param_1,(SEL)"initCommonField:",0x852);
        _objc_msgSend(IVar10,"url");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar7 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"url");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar6,&cf_url);
          _objc_release(uVar6);
        }
        _objc_msgSend(IVar10,"corpid");
        lVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_release();
        if (lVar8 != 0) {
          uVar6 = *(undefined8 *)(param_1 + 0x10);
          _objc_msgSend(IVar10,"corpid");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          pcVar13 = &cf_corpid;
          goto LAB_00019194;
        }
        goto LAB_000191ac;
      }
      iVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isWXSupportUniversalLinkAPI");
      if (iVar1 != 0) {
        MakeCommand_(param_1,(SEL)"MakeCommand:",0);
      }
    }
    else {
      IVar10 = _objc_retain(uVar4);
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(IVar10,"extDic");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_LaunchMiniProgramtodataextDic___
                   );
      uVar14 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar12 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"printLog:level:",uVar12,0);
      _objc_release(uVar12);
      _objc_release(uVar14);
      _objc_release(uVar7);
      _objc_release(uVar6);
      initCommonField_(param_1,(SEL)"initCommonField:",0x438);
      _objc_msgSend(IVar10,"extDic");
      lVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar8 != 0) {
        uVar6 = *(undefined8 *)(param_1 + 0x10);
        _objc_msgSend(IVar10,"extDic");
LAB_00018890:
        uVar7 = _objc_retainAutoreleasedReturnValue();
        pcVar13 = &cf_weAppExtDic;
LAB_00019194:
        _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar7,pcVar13);
        _objc_release(uVar7);
      }
LAB_000191ac:
      _objc_release(IVar10);
    }
  }
  else {
    uVar6 = _objc_retain(uVar4);
    iVar1 = _objc_msgSend(uVar6,"scene");
    if (iVar1 == 4) {
      _objc_msgSend(uVar6,"message");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar7,"mediaObject");
      lVar8 = _objc_retainAutoreleasedReturnValue();
      if (lVar8 == 0) {
        uVar9 = _objc_msgSend(uVar6,"bText");
        _objc_release(uVar7);
        if ((uVar9 & 1) == 0) {
          uVar7 = _objc_msgSend(&objc::class_t::WXTextObject,"alloc");
          uVar7 = _objc_msgSend(uVar7,"init");
          _objc_msgSend(uVar6,"message");
          uVar14 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar14,"setMediaObject:",uVar7);
          _objc_release(uVar14);
          _objc_release(uVar7);
          _objc_msgSend(uVar6,"setBText:",1);
          _objc_msgSend(uVar6,"setText:",&cf___);
        }
      }
      else {
        _objc_release();
        _objc_release(uVar7);
      }
    }
    iVar1 = _objc_msgSend(uVar6,"scene");
    if ((iVar1 == 4) && (iVar1 = _objc_msgSend(uVar6,"bText"), iVar1 != 0)) {
      _objc_msgSend(uVar6,"text");
      lVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_release();
      if (lVar8 == 0) {
        _objc_msgSend(uVar6,"setText:",&cf___);
      }
    }
    iVar1 = _objc_msgSend(uVar6,"bText");
    if (iVar1 == 0) {
      initCommonField_(param_1,(SEL)"initCommonField:",0x3f2);
      _objc_msgSend(uVar6,"message");
      IVar10 = _objc_retainAutoreleasedReturnValue();
      bVar2 = MakeMediaMessage_(param_1,(SEL)"MakeMediaMessage:",IVar10);
      _objc_release(IVar10);
      iVar1 = _objc_msgSend(uVar6,"scene");
      uVar3 = bVar2 & iVar1 != 4;
      if ((iVar1 == 4) && (bVar2 != 0)) {
        _objc_msgSend(uVar6,"sceneDataObject");
        IVar10 = _objc_retainAutoreleasedReturnValue();
        uVar3 = MakeSceneDataObject_withText_(param_1,(SEL)"MakeSceneDataObject:withText:",IVar10,0)
        ;
        goto LAB_00018c98;
      }
    }
    else {
      initCommonField_(param_1,(SEL)"initCommonField:",0x3fc);
      iVar1 = _objc_msgSend(uVar6,"scene");
      _objc_msgSend(uVar6,"text");
      IVar10 = _objc_retainAutoreleasedReturnValue();
      if (iVar1 == 4) {
        bVar2 = MakeTextMessageInState_(param_1,(SEL)"MakeTextMessageInState:",IVar10);
        _objc_release(IVar10);
        if (bVar2 == 0) {
          uVar3 = 0;
          goto LAB_00018ca0;
        }
        _objc_msgSend(uVar6,"sceneDataObject");
        IVar10 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar6,"text");
        IVar11 = _objc_retainAutoreleasedReturnValue();
        uVar3 = MakeSceneDataObject_withText_
                          (param_1,(SEL)"MakeSceneDataObject:withText:",IVar10,IVar11);
        _objc_release(IVar11);
      }
      else {
        uVar3 = MakeTextMessage_(param_1,(SEL)"MakeTextMessage:",IVar10);
      }
LAB_00018c98:
      _objc_release(IVar10);
    }
LAB_00018ca0:
    _objc_msgSend(uVar6,"scene");
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf__d);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",uVar7,&cf_scene);
    _objc_release(uVar7);
    _objc_msgSend(uVar6,"openID");
    lVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar8 != 0) {
      uVar14 = *(undefined8 *)(param_1 + 0x10);
      _objc_msgSend(uVar6,"openID");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar14,"wxApi_safeSetObject:forKey:",uVar7,&cf_openID);
      _objc_release(uVar7);
    }
    _objc_msgSend(uVar6,"toUserOpenId");
    lVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar8 != 0) {
      uVar14 = *(undefined8 *)(param_1 + 0x10);
      _objc_msgSend(uVar6,"toUserOpenId");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar14,"wxApi_safeSetObject:forKey:",uVar7,&cf_userOpenID);
      _objc_release(uVar7);
    }
    _objc_release(uVar6);
    if ((uVar3 & 1) == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_covertreqtodatafail);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar14 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar12 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"printLog:level:",uVar12,0);
      _objc_release(uVar12);
      _objc_release(uVar14);
      _objc_release(uVar7);
      _objc_release(uVar6);
      bVar2 = 0;
      goto LAB_000191b4;
    }
  }
  bVar2 = 1;
LAB_000191b4:
  _objc_release(IVar5);
  _objc_release(uVar4);
  return bVar2;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::makeChannelShareVideoToDicData_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  cfstringStruct *pcVar5;
  undefined8 uVar6;
  
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(uVar2,"localIdentifier");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_release();
  if (lVar3 != 0) {
    uVar6 = *(undefined8 *)(param_1 + 0x10);
    _objc_msgSend(uVar2,"localIdentifier");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_finderLocalIdentifier);
    _objc_release(uVar4);
  }
  _objc_msgSend(uVar2,"extData");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_release();
  if (lVar3 != 0) {
    uVar6 = *(undefined8 *)(param_1 + 0x10);
    _objc_msgSend(uVar2,"extData");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"wxApi_safeSetObject:forKey:",uVar4,&cf_finderExtData);
    _objc_release(uVar4);
  }
  _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"jumpInfo");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"wording");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar3,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderJumpInfoWording);
  _objc_release(uVar6);
  _objc_release(uVar4);
  _objc_msgSend(uVar2,"jumpInfo");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"extData");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar3,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderJumpInfoExtData);
  _objc_release(uVar6);
  _objc_release(uVar4);
  _objc_msgSend(uVar2,"jumpInfo");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  uVar6 = _objc_msgSend(&objc::class_t::WXChannelJumpMiniProgramInfo,"class");
  iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
  _objc_release(uVar4);
  _objc_msgSend(uVar2,"jumpInfo");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  if (iVar1 == 0) {
    uVar6 = _objc_msgSend(&objc::class_t::WXChannelJumpUrlInfo,"class");
    iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar6);
    _objc_release(uVar4);
    if (iVar1 == 0) goto LAB_00019b90;
    _objc_msgSend(uVar2,"jumpInfo");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",2);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar3,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderJumpInfoType);
    _objc_release(uVar6);
    _objc_msgSend(uVar4,"url");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    pcVar5 = &cf_finderJumpInfoH5Url;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",1);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar3,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderJumpInfoType);
    _objc_release(uVar6);
    _objc_msgSend(uVar4,"userName");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar3,"wxApi_safeSetObject:forKey:",uVar6,&cf_finderJumpInfoWeAppUsername);
    _objc_release(uVar6);
    _objc_msgSend(uVar4,"path");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    pcVar5 = &cf_finderJumpInfoWeAppPath;
  }
  _objc_msgSend(lVar3,"wxApi_safeSetObject:forKey:",uVar6,pcVar5);
  _objc_release(uVar6);
  _objc_release(uVar4);
LAB_00019b90:
  if (lVar3 != 0) {
    _objc_msgSend(*(undefined8 *)(param_1 + 0x10),"wxApi_safeSetObject:forKey:",lVar3,
                  &cf_finderJumpInfo);
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x18 bytes

bool AppCommunicateData::RespToData_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  bool bVar2;
  int iVar3;
  ID IVar4;
  undefined8 uVar5;
  ID IVar6;
  long lVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  char *pcVar10;
  undefined8 uVar11;
  
  IVar4 = _objc_retain(param_3);
  uVar5 = _objc_msgSend(&objc::class_t::SendAuthResp,"class");
  iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
  if (iVar1 == 0) {
    uVar5 = _objc_msgSend(&objc::class_t::GetMessageFromWXResp,"class");
    iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
    if (iVar1 == 0) {
      uVar5 = _objc_msgSend(&objc::class_t::ShowMessageFromWXResp,"class");
      iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
      if (iVar1 == 0) {
        uVar5 = _objc_msgSend(&objc::class_t::SendMessageToWXResp,"class");
        iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
        if (iVar1 == 0) {
          uVar5 = _objc_msgSend(&objc::class_t::CreateChatRoomResp,"class");
          iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
          if (iVar1 == 0) {
            uVar5 = _objc_msgSend(&objc::class_t::JoinChatRoomResp,"class");
            iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
            if (iVar1 == 0) {
              uVar5 = _objc_msgSend(&objc::class_t::WXLaunchMiniProgramResp,"class");
              iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
              if (iVar1 == 0) {
                uVar5 = _objc_msgSend(&objc::class_t::WXOpenBusinessViewResp,"class");
                iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
                if (iVar1 == 0) {
                  uVar5 = _objc_msgSend(&objc::class_t::WXChannelShareVideoResp,"class");
                  iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
                  if (iVar1 == 0) {
                    uVar5 = _objc_msgSend(&objc::class_t::WXChannelOpenProfileResp,"class");
                    iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
                    if (iVar1 == 0) {
                      uVar5 = _objc_msgSend(&objc::class_t::WXChannelOpenLiveResp,"class");
                      iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
                      if (iVar1 == 0) {
                        uVar5 = _objc_msgSend(&objc::class_t::WXChannelOpenFeedResp,"class");
                        iVar1 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
                        if (iVar1 == 0) {
                          bVar2 = 0;
                          iVar1 = 0;
                          goto code_r0x0001a4bc;
                        }
                        uVar5 = _objc_retain(IVar4);
                        initCommonField_(param_1,(SEL)"initCommonField:",0x848);
                        _objc_msgSend(uVar5,"extMsg");
                        lVar7 = _objc_retainAutoreleasedReturnValue();
                        _objc_release();
                        if (lVar7 != 0) {
                          uVar11 = *(undefined8 *)(param_1 + 0x10);
                          _objc_msgSend(uVar5,"extMsg");
                          uVar8 = _objc_retainAutoreleasedReturnValue();
                          _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
                          _objc_release(uVar8);
                        }
                        _objc_release(uVar5);
                        iVar1 = 0x848;
                      }
                      else {
                        uVar5 = _objc_retain(IVar4);
                        initCommonField_(param_1,(SEL)"initCommonField:",0x83e);
                        _objc_msgSend(uVar5,"extMsg");
                        lVar7 = _objc_retainAutoreleasedReturnValue();
                        _objc_release();
                        if (lVar7 != 0) {
                          uVar11 = *(undefined8 *)(param_1 + 0x10);
                          _objc_msgSend(uVar5,"extMsg");
                          uVar8 = _objc_retainAutoreleasedReturnValue();
                          _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
                          _objc_release(uVar8);
                        }
                        _objc_release(uVar5);
                        iVar1 = 0x83e;
                      }
                    }
                    else {
                      uVar5 = _objc_retain(IVar4);
                      initCommonField_(param_1,(SEL)"initCommonField:",0x834);
                      _objc_msgSend(uVar5,"extMsg");
                      lVar7 = _objc_retainAutoreleasedReturnValue();
                      _objc_release();
                      if (lVar7 != 0) {
                        uVar11 = *(undefined8 *)(param_1 + 0x10);
                        _objc_msgSend(uVar5,"extMsg");
                        uVar8 = _objc_retainAutoreleasedReturnValue();
                        _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
                        _objc_release(uVar8);
                      }
                      _objc_release(uVar5);
                      iVar1 = 0x834;
                    }
                  }
                  else {
                    uVar5 = _objc_retain(IVar4);
                    initCommonField_(param_1,(SEL)"initCommonField:",0x82a);
                    _objc_msgSend(uVar5,"extMsg");
                    lVar7 = _objc_retainAutoreleasedReturnValue();
                    _objc_release();
                    if (lVar7 != 0) {
                      uVar11 = *(undefined8 *)(param_1 + 0x10);
                      _objc_msgSend(uVar5,"extMsg");
                      uVar8 = _objc_retainAutoreleasedReturnValue();
                      _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
                      _objc_release(uVar8);
                    }
                    _objc_release(uVar5);
                    iVar1 = 0x82a;
                  }
                }
                else {
                  uVar5 = _objc_retain(IVar4);
                  initCommonField_(param_1,(SEL)"initCommonField:",0x820);
                  _objc_msgSend(uVar5,"extMsg");
                  lVar7 = _objc_retainAutoreleasedReturnValue();
                  _objc_release();
                  if (lVar7 != 0) {
                    uVar11 = *(undefined8 *)(param_1 + 0x10);
                    _objc_msgSend(uVar5,"extMsg");
                    uVar8 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
                    _objc_release(uVar8);
                  }
                  _objc_release(uVar5);
                  iVar1 = 0x820;
                }
              }
              else {
                uVar5 = _objc_retain(IVar4);
                initCommonField_(param_1,(SEL)"initCommonField:",0x816);
                _objc_msgSend(uVar5,"extMsg");
                lVar7 = _objc_retainAutoreleasedReturnValue();
                _objc_release();
                if (lVar7 != 0) {
                  uVar11 = *(undefined8 *)(param_1 + 0x10);
                  _objc_msgSend(uVar5,"extMsg");
                  uVar8 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
                  _objc_release(uVar8);
                }
                _objc_release(uVar5);
                iVar1 = 0x816;
              }
            }
            else {
              uVar5 = _objc_retain(IVar4);
              initCommonField_(param_1,(SEL)"initCommonField:",0x80c);
              _objc_msgSend(uVar5,"extMsg");
              lVar7 = _objc_retainAutoreleasedReturnValue();
              _objc_release();
              if (lVar7 != 0) {
                uVar11 = *(undefined8 *)(param_1 + 0x10);
                _objc_msgSend(uVar5,"extMsg");
                uVar8 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
                _objc_release(uVar8);
              }
              _objc_release(uVar5);
              iVar1 = 0x80c;
            }
          }
          else {
            uVar5 = _objc_retain(IVar4);
            initCommonField_(param_1,(SEL)"initCommonField:",0x802);
            _objc_msgSend(uVar5,"extMsg");
            lVar7 = _objc_retainAutoreleasedReturnValue();
            _objc_release();
            if (lVar7 != 0) {
              uVar11 = *(undefined8 *)(param_1 + 0x10);
              _objc_msgSend(uVar5,"extMsg");
              uVar8 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
              _objc_release(uVar8);
            }
            _objc_release(uVar5);
            iVar1 = 0x802;
          }
        }
        else {
          uVar5 = _objc_retain(IVar4);
          initCommonField_(param_1,(SEL)"initCommonField:",0x7e4);
          _objc_msgSend(uVar5,"lang");
          lVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_release();
          if (lVar7 != 0) {
            uVar11 = *(undefined8 *)(param_1 + 0x10);
            _objc_msgSend(uVar5,"lang");
            uVar8 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_language);
            _objc_release(uVar8);
          }
          _objc_msgSend(uVar5,"country");
          lVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_release();
          if (lVar7 != 0) {
            uVar11 = *(undefined8 *)(param_1 + 0x10);
            _objc_msgSend(uVar5,"country");
            uVar8 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_country);
            _objc_release(uVar8);
          }
          _objc_release(uVar5);
          iVar1 = 0x7e4;
        }
        bVar2 = 1;
      }
      else {
        iVar1 = 0x42e;
        initCommonField_(param_1,(SEL)"initCommonField:",0x42e);
        bVar2 = 1;
      }
    }
    else {
      uVar5 = _objc_retain(IVar4);
      iVar1 = _objc_msgSend(uVar5,"bText");
      if (iVar1 == 0) {
        iVar1 = 0x3f2;
        initCommonField_(param_1,(SEL)"initCommonField:",0x3f2);
        _objc_msgSend(uVar5,"message");
        IVar6 = _objc_retainAutoreleasedReturnValue();
        pcVar10 = "MakeMediaMessage:";
      }
      else {
        iVar1 = 0x3fc;
        initCommonField_(param_1,(SEL)"initCommonField:",0x3fc);
        _objc_msgSend(uVar5,"text");
        IVar6 = _objc_retainAutoreleasedReturnValue();
        pcVar10 = "MakeTextMessage:";
      }
      bVar2 = MakeTextMessage_(param_1,(SEL)pcVar10,IVar6);
      _objc_release(IVar6);
      _objc_release(uVar5);
    }
  }
  else {
    iVar1 = 0x7ee;
    initCommonField_(param_1,(SEL)"initCommonField:",0x7ee);
    bVar2 = MakeAuthResp_(param_1,(SEL)"MakeAuthResp:",IVar4);
  }
code_r0x0001a4bc:
  uVar5 = _objc_msgSend(&objc::class_t::WXOpenCustomerServiceResp,"class");
  iVar3 = _objc_msgSend(IVar4,"isKindOfClass:",uVar5);
  if (iVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_unknowresp);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar11);
  }
  else {
    uVar5 = _objc_retain(IVar4);
    iVar1 = 0x852;
    initCommonField_(param_1,(SEL)"initCommonField:",0x852);
    _objc_msgSend(uVar5,"extMsg");
    lVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_release();
    if (lVar7 == 0) {
      bVar2 = 1;
      goto LAB_0001a650;
    }
    uVar11 = *(undefined8 *)(param_1 + 0x10);
    _objc_msgSend(uVar5,"extMsg");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar11,"wxApi_safeSetObject:forKey:",uVar8,&cf_messageExt);
    iVar1 = 0x852;
    bVar2 = 1;
  }
  _objc_release(uVar8);
LAB_0001a650:
  _objc_release(uVar5);
  if ((iVar1 == 0) || (bVar2 == 0)) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_genrespfail);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar11);
    _objc_release(uVar8);
    _objc_release(uVar5);
    bVar2 = 0;
  }
  else {
    bVar2 = 1;
  }
  _objc_release(IVar4);
  return bVar2;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::fileData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setFileData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::conversationAccount(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x30,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setConversationAccount_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x30,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

bool AppCommunicateData::returnFromApp(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0x20);
}



// Function Stack Size: 0x14 bytes

void AppCommunicateData::setReturnFromApp_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0x20) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

int AppCommunicateData::result(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + 0x24);
}



// Function Stack Size: 0x14 bytes

void AppCommunicateData::setResult_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + 0x24) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

int AppCommunicateData::scene(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + 0x28);
}



// Function Stack Size: 0x14 bytes

void AppCommunicateData::setScene_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + 0x28) = param_3;
  return;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setOpenID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x38,param_3,0,1);
  return;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setSdkVer_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x40,param_3,0,1);
  return;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setLang_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x48,param_3,0,1);
  return;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setCountry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x50,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::toUserOpenID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x58,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setToUserOpenID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x58,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicateData::universalLink(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x60,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void AppCommunicateData::setUniversalLink_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x60,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

bool AppCommunicateData::isAutoResend(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0x21);
}



// Function Stack Size: 0x14 bytes

void AppCommunicateData::setIsAutoResend_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0x21) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void AppCommunicateData::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x60,0);
  _objc_storeStrong(param_1 + 0x58,0);
  _objc_storeStrong(param_1 + 0x50,0);
  _objc_storeStrong(param_1 + 0x48,0);
  _objc_storeStrong(param_1 + 0x40,0);
  _objc_storeStrong(param_1 + 0x38,0);
  _objc_storeStrong(param_1 + 0x30,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

bool WeChatApiUtil::isiOS10plus(ID param_1,SEL param_2)

{
  double dVar1;
  
  dVar1 = (double)getiOSVersion();
  return (bool)(9.9 < dVar1);
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// getiOSVersion()

undefined  [16] getiOSVersion(void)

{
  undefined8 uVar1;
  undefined8 uVar2;
  char *pcVar3;
  undefined auVar4 [16];
  
  if (g_iOSVersion < 0.1) {
    _objc_msgSend(&_OBJC_CLASS___UIDevice,"currentDevice");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"systemVersion");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar1);
    uVar1 = _objc_retainAutorelease(uVar2);
    pcVar3 = (char *)_objc_msgSend(uVar1,"UTF8String");
    g_iOSVersion = _atof(pcVar3);
    _objc_release(uVar1);
  }
  auVar4._8_8_ = 0;
  auVar4._0_8_ = g_iOSVersion;
  return auVar4;
}



// Function Stack Size: 0x10 bytes

bool WeChatApiUtil::isiOS12plus(ID param_1,SEL param_2)

{
  double dVar1;
  
  dVar1 = (double)getiOSVersion();
  return (bool)(11.9 < dVar1);
}



// Function Stack Size: 0x10 bytes

bool WeChatApiUtil::isiOS13plus(ID param_1,SEL param_2)

{
  double dVar1;
  
  dVar1 = (double)getiOSVersion();
  return (bool)(12.9 < dVar1);
}



// Function Stack Size: 0x10 bytes

bool WeChatApiUtil::is2xScreen(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ulong uVar2;
  undefined8 uVar3;
  double dVar4;
  
  if (__ZZ27__WeChatApiUtil_is2xScreen_E16is2xScreen_scale == -1) {
    _objc_msgSend(&_OBJC_CLASS___UIScreen,"mainScreen");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    uVar2 = _objc_msgSend(uVar1,"respondsToSelector:","scale");
    if ((uVar2 & 1) == 0) {
      _objc_release(uVar1);
    }
    else {
      _objc_msgSend(&_OBJC_CLASS___UIScreen,"mainScreen");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      dVar4 = (double)_objc_msgSend(uVar3,"scale");
      _objc_release(uVar3);
      _objc_release(uVar1);
      if (dVar4 == 2.0) {
        __ZZ27__WeChatApiUtil_is2xScreen_E16is2xScreen_scale = 2;
        goto LAB_0001aae8;
      }
    }
    __ZZ27__WeChatApiUtil_is2xScreen_E16is2xScreen_scale = 1;
  }
LAB_0001aae8:
  return (bool)(__ZZ27__WeChatApiUtil_is2xScreen_E16is2xScreen_scale == 2);
}



// Function Stack Size: 0x10 bytes

bool WeChatApiUtil::isiPad(ID param_1,SEL param_2)

{
  if (__ZZ23__WeChatApiUtil_isiPad_E9onceToken != -1) {
    _dispatch_once(&__ZZ23__WeChatApiUtil_isiPad_E9onceToken,&___block_literal_global);
  }
  return (bool)__ZZ23__WeChatApiUtil_isiPad_E8s_isiPad;
}



void ___23__WeChatApiUtil_isiPad__block_invoke(void)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  _objc_msgSend(&_OBJC_CLASS___UIDevice,"currentDevice");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"model");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  __ZZ23__WeChatApiUtil_isiPad_E8s_isiPad = _objc_msgSend(uVar2,"hasPrefix:",&cf_iPad);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::propertyListFromData_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  ID IVar9;
  long local_68;
  undefined8 local_60;
  undefined auStack_58 [8];
  
  lVar2 = _objc_retain(param_3);
  if ((lVar2 == 0) || (lVar3 = _objc_msgSend(lVar2,"length"), lVar3 == 0)) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_data____isempty);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    uVar4 = 0;
  }
  else {
    iVar1 = _objc_msgSend(&_OBJC_CLASS___NSPropertyListSerialization,"respondsToSelector:",
                          "propertyListWithData:options:format:error:");
    if (iVar1 == 0) {
      local_68 = 0;
      _objc_msgSend(&_OBJC_CLASS___NSPropertyListSerialization,
                    "propertyListFromData:mutabilityOption:format:errorDescription:",lVar2,0,
                    auStack_58,&local_68);
      uVar4 = _objc_retainAutoreleasedReturnValue();
      lVar3 = local_68;
      if (local_68 != 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_erroroccur___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar5,"printLog:level:",uVar8,0);
        _objc_release(uVar8);
        _objc_release(uVar7);
        _objc_release(uVar6);
        _objc_release(uVar5);
        lVar3 = local_68;
      }
    }
    else {
      local_60 = 0;
      _objc_msgSend(&_OBJC_CLASS___NSPropertyListSerialization,
                    "propertyListWithData:options:format:error:",lVar2,0,auStack_58,&local_60);
      uVar4 = _objc_retainAutoreleasedReturnValue();
      lVar3 = _objc_retain(local_60);
      if (lVar3 != 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_erroroccur___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar5,"printLog:level:",uVar8,0);
        _objc_release(uVar8);
        _objc_release(uVar7);
        _objc_release(uVar6);
        _objc_release(uVar5);
      }
    }
    _objc_release(lVar3);
  }
  _objc_release(lVar2);
  IVar9 = _objc_autoreleaseReturnValue(uVar4);
  return IVar9;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::dataFromPropertyList_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  ID IVar9;
  long local_60;
  undefined8 local_58;
  
  lVar2 = _objc_retain(param_3);
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_propertyListisnil);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar3);
    uVar3 = 0;
  }
  else {
    iVar1 = _objc_msgSend(&_OBJC_CLASS___NSPropertyListSerialization,"respondsToSelector:",
                          "dataWithPropertyList:format:options:error:");
    if (iVar1 == 0) {
      local_60 = 0;
      _objc_msgSend(&_OBJC_CLASS___NSPropertyListSerialization,
                    "dataFromPropertyList:format:errorDescription:",lVar2,200,&local_60);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      lVar4 = local_60;
      if (local_60 != 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_erroroccur___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar5,"printLog:level:",uVar8,0);
        _objc_release(uVar8);
        _objc_release(uVar7);
        _objc_release(uVar6);
        _objc_release(uVar5);
        lVar4 = local_60;
      }
    }
    else {
      local_58 = 0;
      _objc_msgSend(&_OBJC_CLASS___NSPropertyListSerialization,
                    "dataWithPropertyList:format:options:error:",lVar2,200,0,&local_58);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      lVar4 = _objc_retain(local_58);
      if (lVar4 != 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_erroroccur___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar5,"printLog:level:",uVar8,0);
        _objc_release(uVar8);
        _objc_release(uVar7);
        _objc_release(uVar6);
        _objc_release(uVar5);
      }
    }
    _objc_release(lVar4);
  }
  _objc_release(lVar2);
  IVar9 = _objc_autoreleaseReturnValue(uVar3);
  return IVar9;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::getWechatSchemeUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appisnil);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    uVar3 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_weixin___app____);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar2);
    uVar3 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(uVar2);
  _objc_release(lVar1);
  IVar6 = _objc_autoreleaseReturnValue(uVar3);
  return IVar6;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::getWechatUniversalLink_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appisnil);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    uVar3 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_https___help_wechat_com_app____);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar2);
    uVar3 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(uVar2);
  _objc_release(lVar1);
  IVar6 = _objc_autoreleaseReturnValue(uVar3);
  return IVar6;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::getAppUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appisnil);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    uVar3 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar2);
    uVar3 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(uVar2);
  _objc_release(lVar1);
  IVar6 = _objc_autoreleaseReturnValue(uVar3);
  return IVar6;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::genSchemePrefixWithAppId_(ID param_1,SEL param_2,ID param_3)

{
  ID IVar1;
  
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______);
  _objc_retainAutoreleasedReturnValue();
  IVar1 = _objc_autoreleaseReturnValue();
  return IVar1;
}



// Function Stack Size: 0x20 bytes

ID WeChatApiUtil::genUniversalLinkPrefixWithAppId_universalLink_
             (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ID IVar3;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_____);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  IVar3 = _objc_autoreleaseReturnValue(uVar2);
  return IVar3;
}



// Function Stack Size: 0x28 bytes

bool WeChatApiUtil::isAppOpenUrl_appID_universalLink_
               (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5)

{
  bool bVar1;
  undefined8 uVar2;
  ID IVar3;
  ID IVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ulong uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  
  uVar2 = _objc_retain(param_3);
  IVar3 = _objc_retain(param_4);
  IVar4 = _objc_retain(param_5);
  if (IVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appisnil);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    bVar1 = 0;
  }
  else {
    genSchemePrefixWithAppId_(param_1,(SEL)"genSchemePrefixWithAppId:",IVar3);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"absoluteString");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    uVar7 = _objc_msgSend(uVar6,"hasPrefix:",uVar5);
    _objc_release(uVar6);
    if ((uVar7 & 1) != 0) {
      bVar1 = 1;
      goto LAB_0001bd04;
    }
    genUniversalLinkPrefixWithAppId_universalLink_
              (param_1,(SEL)"genUniversalLinkPrefixWithAppId:universalLink:",IVar3,IVar4);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"absoluteString");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    bVar1 = _objc_msgSend(uVar9,"hasPrefix:",uVar8);
  }
  _objc_release(uVar9);
  _objc_release(uVar8);
LAB_0001bd04:
  _objc_release(uVar5);
  _objc_release(IVar4);
  _objc_release(IVar3);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x30 bytes

bool WeChatApiUtil::isOpenUrlApiCall_apiName_appID_universalLink_
               (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5,ID param_6)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  ID IVar4;
  ID IVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  bool bVar10;
  
  uVar2 = _objc_retain(param_3);
  uVar3 = _objc_retain(param_4);
  IVar4 = _objc_retain(param_5);
  IVar5 = _objc_retain(param_6);
  genSchemePrefixWithAppId_(param_1,(SEL)"genSchemePrefixWithAppId:",IVar4);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_____);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar6);
  genUniversalLinkPrefixWithAppId_universalLink_
            (param_1,(SEL)"genUniversalLinkPrefixWithAppId:universalLink:",IVar4,IVar5);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______);
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar6);
  _objc_msgSend(uVar2,"absoluteString");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  iVar1 = _objc_msgSend(uVar6,"hasPrefix:",uVar7);
  if (iVar1 == 0) {
    _objc_msgSend(uVar2,"absoluteString");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend(uVar9,"hasPrefix:",uVar8);
    _objc_release(uVar9);
    _objc_release(uVar6);
    if (iVar1 == 0) {
      bVar10 = 0;
      goto LAB_0001bf6c;
    }
  }
  else {
    _objc_release(uVar6);
  }
  bVar10 = 1;
LAB_0001bf6c:
  _objc_release(uVar8);
  _objc_release(uVar7);
  _objc_release(IVar5);
  _objc_release(IVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar10;
}



// Function Stack Size: 0x18 bytes

bool WeChatApiUtil::isAppInstalledWithCatchException_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  
  lVar2 = _objc_retain(param_3);
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appisnil);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    bVar1 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar3);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    uVar5 = _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
    bVar1 = _objc_msgSend(uVar5,"canOpenURL:",uVar4);
  }
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(lVar2);
  return bVar1;
}



// Function Stack Size: 0x18 bytes

bool WeChatApiUtil::isAppInstalledWithoutCatchException_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  
  lVar2 = _objc_retain(param_3);
  if (lVar2 == 0) {
    bVar1 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar3);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    uVar5 = _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
    bVar1 = _objc_msgSend(uVar5,"canOpenURL:",uVar4);
    _objc_release(uVar4);
    _objc_release(uVar3);
  }
  _objc_release(lVar2);
  return bVar1;
}



// Function Stack Size: 0x18 bytes

bool WeChatApiUtil::launchApp_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  ID IVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  
  IVar2 = _objc_retain(param_3);
  _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  getAppUrl_(param_1,(SEL)"getAppUrl:",IVar2);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  bVar1 = _objc_msgSend(uVar3,"openURL:",uVar4);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(IVar2);
  return bVar1;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::getAppUrlWithPlatformId_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  ID IVar4;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    uVar3 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf________);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar2);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar2);
  }
  _objc_release(lVar1);
  IVar4 = _objc_autoreleaseReturnValue(uVar3);
  return IVar4;
}



// Function Stack Size: 0x20 bytes

ID WeChatApiUtil::getAppUrlWithPlatformId_withOtherArgs_
             (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  ID IVar6;
  
  lVar1 = _objc_retain(param_3);
  lVar2 = _objc_retain(param_4);
  if (lVar1 == 0) {
    uVar5 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSMutableString,"stringWithFormat:",&cf________);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    if ((lVar2 != 0) && (lVar4 = _objc_msgSend(lVar2,"length"), lVar4 != 0)) {
      _objc_msgSend(uVar3,"appendFormat:",&cf____);
    }
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar3);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar3);
  }
  _objc_release(lVar2);
  _objc_release(lVar1);
  IVar6 = _objc_autoreleaseReturnValue(uVar5);
  return IVar6;
}



// Function Stack Size: 0x10 bytes

bool WeChatApiUtil::isWXAppSupportApi(ID param_1,SEL param_2)

{
  bool bVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_weixin___);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar2);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  uVar4 = _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
  bVar1 = _objc_msgSend(uVar4,"canOpenURL:",uVar3);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x10 bytes

bool WeChatApiUtil::isWXSupportUniversalLinkAPI(ID param_1,SEL param_2)

{
  bool bVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",&cf_weixinULAPI___);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  uVar3 = _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
  bVar1 = _objc_msgSend(uVar3,"canOpenURL:",uVar2);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x10 bytes

ID WeChatApiUtil::getSDKVersion(ID param_1,SEL param_2)

{
  return 0x42b70;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::DecodeWithBase64_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  ID IVar4;
  
  lVar1 = _objc_retain(param_3);
  if ((lVar1 == 0) || (lVar2 = _objc_msgSend(lVar1,"length"), lVar2 == 0)) {
    uVar3 = 0;
  }
  else {
    uVar3 = _objc_msgSend(&_OBJC_CLASS___NSData,"alloc");
    uVar3 = _objc_msgSend(uVar3,"initWithBase64EncodedString:options:",lVar1,0);
  }
  _objc_release(lVar1);
  IVar4 = _objc_autoreleaseReturnValue(uVar3);
  return IVar4;
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::parseURLParams_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ulong uVar3;
  undefined8 uVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  long lVar9;
  ulong uVar10;
  undefined8 local_130;
  long lStack_128;
  long *local_120;
  undefined8 uStack_118;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined8 uStack_100;
  undefined8 uStack_f8;
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  _objc_msgSend(param_3,"componentsSeparatedByString:",&cf__);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"alloc");
  uVar2 = _objc_msgSend(uVar2,"init");
  uStack_108 = 0;
  local_110 = 0;
  uStack_f8 = 0;
  uStack_100 = 0;
  lStack_128 = 0;
  local_130 = 0;
  uStack_118 = 0;
  local_120 = (long *)0x0;
  uVar1 = _objc_retain(uVar1);
  uVar3 = _objc_msgSend(uVar1,"countByEnumeratingWithState:objects:count:",&local_130,auStack_f0,
                        0x10);
  if (uVar3 != 0) {
    lVar9 = *local_120;
    do {
      uVar10 = 0;
      do {
        if (*local_120 != lVar9) {
          _objc_enumerationMutation(uVar1);
        }
        _objc_msgSend(*(undefined8 *)(lStack_128 + uVar10 * 8),"componentsSeparatedByString:",&cf__)
        ;
        uVar4 = _objc_retainAutoreleasedReturnValue();
        uVar5 = _objc_msgSend(uVar4,"count");
        if (1 < uVar5) {
          _objc_msgSend(uVar4,"objectAtIndex:",1);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar4,"objectAtIndex:",0);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar6,uVar7);
          _objc_release(uVar7);
          _objc_release(uVar6);
        }
        _objc_release(uVar4);
        uVar10 = uVar10 + 1;
      } while (uVar10 < uVar3);
      uVar3 = _objc_msgSend(uVar1,"countByEnumeratingWithState:objects:count:",&local_130,auStack_f0
                            ,0x10);
    } while (uVar3 != 0);
  }
  _objc_release(uVar1);
  _objc_release(uVar1);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_70) {
    IVar8 = _objc_autoreleaseReturnValue(uVar2);
    return IVar8;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x18 bytes

ID WeChatApiUtil::sha256_(ID param_1,SEL param_2,ID param_3)

{
  CC_LONG len;
  long lVar1;
  undefined8 uVar2;
  void *data;
  cfstringStruct *pcVar3;
  ID IVar4;
  long lVar5;
  uchar local_78 [32];
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00040040;
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    pcVar3 = &cf___;
  }
  else {
    _objc_msgSend(lVar1,"dataUsingEncoding:",4);
    _objc_retainAutoreleasedReturnValue();
    uVar2 = _objc_retainAutorelease();
    data = (void *)_objc_msgSend(uVar2,"bytes");
    len = _objc_msgSend(uVar2,"length");
    _CC_SHA256(data,len,local_78);
    _objc_msgSend(&_OBJC_CLASS___NSMutableString,"stringWithCapacity:",0x40);
    pcVar3 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    lVar5 = 0;
    do {
      _objc_msgSend(pcVar3,"appendFormat:",&cf__02x);
      lVar5 = lVar5 + 1;
    } while (lVar5 != 0x20);
    _objc_release(uVar2);
  }
  _objc_release(lVar1);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_58) {
    IVar4 = _objc_autoreleaseReturnValue(pcVar3);
    return IVar4;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x10 bytes

unsigned_int WeChatApiUtil::genCurrentTime(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  double dVar2;
  
  _objc_msgSend(&_OBJC_CLASS___NSDate,"date");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  dVar2 = (double)_objc_msgSend(uVar1,"timeIntervalSince1970");
  _objc_release(uVar1);
  return (int)dVar2;
}



void __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_stringForKey__(undefined8 param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ulong uVar3;
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
  uVar3 = _objc_msgSend(uVar1,"isKindOfClass:",uVar2);
  if ((uVar3 & 1) == 0) {
    uVar2 = 0;
  }
  else {
    uVar2 = _objc_retain(uVar1);
  }
  _objc_release(uVar1);
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



void __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_numberForKey__(undefined8 param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ulong uVar3;
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSNumber,"class");
  uVar3 = _objc_msgSend(uVar1,"isKindOfClass:",uVar2);
  if ((uVar3 & 1) == 0) {
    uVar2 = 0;
  }
  else {
    uVar2 = _objc_retain(uVar1);
  }
  _objc_release(uVar1);
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



void __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_arrayForKey__(undefined8 param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ulong uVar3;
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSArray,"class");
  uVar3 = _objc_msgSend(uVar1,"isKindOfClass:",uVar2);
  if ((uVar3 & 1) == 0) {
    uVar2 = 0;
  }
  else {
    uVar2 = _objc_retain(uVar1);
  }
  _objc_release(uVar1);
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



void __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_dictionaryForKey__(undefined8 param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ulong uVar3;
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSDictionary,"class");
  uVar3 = _objc_msgSend(uVar1,"isKindOfClass:",uVar2);
  if ((uVar3 & 1) == 0) {
    uVar2 = 0;
  }
  else {
    uVar2 = _objc_retain(uVar1);
  }
  _objc_release(uVar1);
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



void __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_dataForKey__(undefined8 param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ulong uVar3;
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSData,"class");
  uVar3 = _objc_msgSend(uVar1,"isKindOfClass:",uVar2);
  if ((uVar3 & 1) == 0) {
    uVar2 = 0;
  }
  else {
    uVar2 = _objc_retain(uVar1);
  }
  _objc_release(uVar1);
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



undefined8 __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_integerForKey__(undefined8 param_1)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  uVar3 = _objc_msgSend(&_OBJC_CLASS___NSNumber,"class");
  iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
  if (iVar1 == 0) {
    uVar3 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
    iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
    if (iVar1 == 0) {
      uVar3 = 0;
    }
    else {
      uVar3 = _objc_msgSend(uVar2,"integerValue");
    }
  }
  else {
    uVar3 = _objc_msgSend(uVar2,"integerValue");
  }
  _objc_release(uVar2);
  return uVar3;
}



undefined  [16] __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_floatForKey__(undefined8 param_1)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined auVar4 [16];
  undefined auVar5 [16];
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  uVar3 = _objc_msgSend(&_OBJC_CLASS___NSNumber,"class");
  iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
  if (iVar1 == 0) {
    uVar3 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
    iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
    auVar4 = ZEXT816(0);
    if (iVar1 != 0) {
      auVar4 = _objc_msgSend(uVar2,"floatValue");
    }
  }
  else {
    auVar4 = _objc_msgSend(uVar2,"floatValue");
  }
  uVar3 = auVar4._8_8_;
  _objc_release(uVar2);
  auVar5._8_8_ = uVar3;
  auVar5._0_8_ = auVar4._0_8_;
  return auVar5;
}



undefined  [16] __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_doubleForKey__(undefined8 param_1)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined auVar4 [16];
  undefined auVar5 [16];
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  uVar3 = _objc_msgSend(&_OBJC_CLASS___NSNumber,"class");
  iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
  if (iVar1 == 0) {
    uVar3 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
    iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
    auVar4 = ZEXT816(0);
    if (iVar1 != 0) {
      auVar4 = _objc_msgSend(uVar2,"doubleValue");
    }
  }
  else {
    auVar4 = _objc_msgSend(uVar2,"doubleValue");
  }
  uVar3 = auVar4._8_8_;
  _objc_release(uVar2);
  auVar5._8_8_ = uVar3;
  auVar5._0_8_ = auVar4._0_8_;
  return auVar5;
}



undefined8 __NSDictionary_WXApi_NSDictionary_SafeJSON__wxApi_boolForKey__(undefined8 param_1)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(param_1,"objectForKey:");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  uVar3 = _objc_msgSend(&_OBJC_CLASS___NSNumber,"class");
  iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
  if (iVar1 == 0) {
    uVar3 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
    iVar1 = _objc_msgSend(uVar2,"isKindOfClass:",uVar3);
    if (iVar1 == 0) {
      uVar3 = 0;
    }
    else {
      uVar3 = _objc_msgSend(uVar2,"boolValue");
    }
  }
  else {
    uVar3 = _objc_msgSend(uVar2,"boolValue");
  }
  _objc_release(uVar2);
  return uVar3;
}



void __NSMutableDictionary_WXApi_SafeInsert__wxApi_safeSetObject_forKey__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  long lVar1;
  long lVar2;
  
  lVar1 = _objc_retain(param_3);
  lVar2 = _objc_retain(param_4);
  if ((lVar1 != 0) && (lVar2 != 0)) {
    _objc_msgSend(param_1,"setObject:forKey:",lVar1,lVar2);
  }
  _objc_release(lVar2);
  _objc_release(lVar1);
  return;
}



void __NSMutableDictionary_WXApi_SafeInsert__wxApi_safeRemoveObjectForKey__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  long lVar1;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"removeObjectForKey:",lVar1);
  }
  _objc_release(lVar1);
  return;
}



void __NSArray_WXApi_SafeInsert__wxApi_safeObjectAtIndex__
               (undefined8 param_1,undefined8 param_2,ulong param_3)

{
  ulong uVar1;
  undefined8 uVar2;
  
  uVar1 = _objc_msgSend(param_1,"count");
  if (param_3 < uVar1) {
    _objc_msgSend(param_1,"objectAtIndex:",param_3);
    uVar2 = _objc_retainAutoreleasedReturnValue();
  }
  else {
    uVar2 = 0;
  }
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



void __NSArray_WXApi_SafeInsert__wxApi_firstObject_(undefined8 param_1)

{
  long lVar1;
  
  lVar1 = _objc_msgSend(param_1,"count");
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"objectAtIndex:",0);
    _objc_retainAutoreleasedReturnValue();
  }
  _objc_autoreleaseReturnValue();
  return;
}



void __NSMutableArray_WXApi_SafeInsert__wxApi_safeAddObject__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  long lVar1;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"addObject:",lVar1);
  }
  _objc_release(lVar1);
  return;
}



void __NSMutableArray_WXApi_SafeInsert__wxApi_safeRemoveObject__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  long lVar1;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"removeObject:",lVar1);
  }
  _objc_release(lVar1);
  return;
}



void __NSMutableArray_WXApi_SafeInsert__wxApi_safeInsertObject_atIndex__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  long lVar1;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"insertObject:atIndex:",lVar1,param_4);
  }
  _objc_release(lVar1);
  return;
}



void __NSMutableArray_WXApi_SafeInsert__wxApi_safeRemoveObjectAtIndex__
               (undefined8 param_1,undefined8 param_2,ulong param_3)

{
  ulong uVar1;
  
  uVar1 = _objc_msgSend(param_1,"count");
  if (param_3 < uVar1) {
    _objc_msgSend(param_1,"removeObjectAtIndex:",param_3);
    return;
  }
  return;
}



void __NSMutableArray_WXApi_SafeInsert__wxApi_safeReplaceObjectAtIndex_withObject__
               (undefined8 param_1,undefined8 param_2,ulong param_3,undefined8 param_4)

{
  long lVar1;
  ulong uVar2;
  
  lVar1 = _objc_retain(param_4);
  uVar2 = _objc_msgSend(param_1,"count");
  if ((lVar1 != 0) && (param_3 < uVar2)) {
    _objc_msgSend(param_1,"replaceObjectAtIndex:withObject:",param_3,lVar1);
  }
  _objc_release(lVar1);
  return;
}



void __NSMutableArray_WXApi_SafeInsert__wxApi_firstObject_(undefined8 param_1)

{
  long lVar1;
  
  lVar1 = _objc_msgSend(param_1,"count");
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"objectAtIndex:",0);
    _objc_retainAutoreleasedReturnValue();
  }
  _objc_autoreleaseReturnValue();
  return;
}



void __NSMutableArray_WXApi_SafeInsert__wxApi_removeFirstObject_(undefined8 param_1)

{
  long lVar1;
  
  lVar1 = _objc_msgSend(param_1,"count");
  if (lVar1 != 0) {
    _objc_msgSend(param_1,"removeObjectAtIndex:",0);
    return;
  }
  return;
}



undefined8
__NSString_WXApiNSStringURLArgumentsAdditions__wxApi_stringByEscapingForURLArgument_
          (undefined8 param_1)

{
  undefined8 uVar1;
  
  uVar1 = _CFURLCreateStringByAddingPercentEscapes
                    (*(undefined8 *)PTR__kCFAllocatorDefault_00040048,param_1,0,
                     &cf____________________,0x8000100);
  _objc_autoreleaseReturnValue();
  return uVar1;
}



undefined8
__NSString_WXApiNSStringURLArgumentsAdditions__wxApi_stringByEscapingForURLArgumentOnly_
          (undefined8 param_1)

{
  undefined8 uVar1;
  
  uVar1 = _CFURLCreateStringByAddingPercentEscapes
                    (*(undefined8 *)PTR__kCFAllocatorDefault_00040048,param_1,
                     &cf____________________,0,0x8000100);
  _objc_autoreleaseReturnValue();
  return uVar1;
}



void __NSString_WXApiNSStringURLArgumentsAdditions__wxApi_stringByUnescapingFromURLArgument_
               (undefined8 param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  _objc_msgSend(&_OBJC_CLASS___NSMutableString,"stringWithString:",param_1);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(uVar1,"length");
  _objc_msgSend(uVar1,"replaceOccurrencesOfString:withString:options:range:",&cf__,&cf_space_s_,2,0,
                uVar2);
  _objc_msgSend(uVar1,"stringByReplacingPercentEscapesUsingEncoding:",4);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



void __NSString_WXApiNSStringURLArgumentsAdditions__wxApi_stringByEncodeByJsonAndUrlEncode_
               (undefined8 param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  _objc_msgSend(&_OBJC_CLASS___NSMutableString,"stringWithString:",param_1);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_msgSend(uVar1,"length");
  _objc_msgSend(uVar1,"replaceOccurrencesOfString:withString:options:range:",&cf__,&cf_space_s_,2,0,
                uVar2);
  uVar2 = _objc_msgSend(uVar1,"length");
  _objc_msgSend(uVar1,"replaceOccurrencesOfString:withString:options:range:",&cf__X,&cf__,1,0,uVar2)
  ;
  _objc_msgSend(uVar1,"stringByReplacingPercentEscapesUsingEncoding:",4);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  _objc_autoreleaseReturnValue(uVar2);
  return;
}



void __NSString_WXApiNSStringURLArgumentsAdditions__wxApi_stringByEncodeUrl_(undefined8 param_1)

{
  undefined8 uVar1;
  cfstringStruct *pcVar2;
  undefined8 uVar3;
  cfstringStruct *pcVar4;
  
  uVar3 = *(undefined8 *)PTR__kCFAllocatorDefault_00040048;
  uVar1 = _CFStringConvertNSStringEncodingToEncoding(4);
  pcVar2 = (cfstringStruct *)
           _CFURLCreateStringByAddingPercentEscapes
                     (uVar3,param_1,0,&cf____________________<>________,uVar1);
  if (pcVar2 == (cfstringStruct *)0x0) {
    pcVar4 = &cf___;
  }
  else {
    _objc_retain(pcVar2);
    pcVar4 = pcVar2;
  }
  _objc_release(pcVar2);
  _objc_autoreleaseReturnValue(pcVar4);
  return;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicate::getDataPasteboardName(ID param_1,SEL param_2)

{
  return 0x42c90;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicate::getDataPasteboard(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_msgSend(&_OBJC_CLASS___UIPasteboard,"generalPasteboard");
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID AppCommunicate::propertyListForAllApp(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ulong uVar7;
  long lVar8;
  undefined8 uVar9;
  ID IVar10;
  
  getDataPasteboard(param_1,(SEL)"getDataPasteboard");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"dataForPasteboardType:",&cf_content);
  lVar2 = _objc_retainAutoreleasedReturnValue();
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_pasteData____isempty);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar3,"printLog:level:",uVar5,0);
LAB_0001ddd8:
    _objc_release(uVar5);
  }
  else {
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"propertyListFromData:",lVar2);
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    if (lVar3 == 0) {
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_idPasteisnil);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar4,"printLog:level:",uVar9,0);
      _objc_release(uVar9);
      goto LAB_0001ddd8;
    }
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_clearpropertylist);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_msgSend(&_OBJC_CLASS___NSData,"data");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"setData:forPasteboardType:",uVar4,&cf_content);
    _objc_release(uVar4);
    uVar4 = _objc_msgSend(&_OBJC_CLASS___NSDictionary,"class");
    uVar7 = _objc_msgSend(lVar3,"isKindOfClass:",uVar4);
    if ((uVar7 & 1) != 0) {
      _objc_msgSend(lVar3,"wxApi_stringForKey:",&cf_old_text);
      uVar4 = _objc_retainAutoreleasedReturnValue();
      lVar8 = _objc_msgSend(uVar4,"length");
      if (lVar8 != 0) {
        _objc_msgSend(uVar1,"setString:",uVar4);
      }
      lVar3 = _objc_retain(lVar3);
      lVar8 = lVar3;
      goto LAB_0001dea0;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_idPaste____isnotdictionary);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar5);
  }
  _objc_release(uVar6);
  lVar8 = 0;
LAB_0001dea0:
  _objc_release(uVar4);
  _objc_release(lVar3);
  _objc_release(lVar2);
  _objc_release(uVar1);
  IVar10 = _objc_autoreleaseReturnValue(lVar8);
  return IVar10;
}



// Function Stack Size: 0x18 bytes

ID AppCommunicate::propertyListForAppID_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  
  lVar1 = _objc_retain(param_3);
  if ((lVar1 == 0) || (lVar2 = _objc_msgSend(lVar1,"length"), lVar2 == 0)) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appID____invaild);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar3);
  }
  else {
    propertyListForAllApp(param_1,(SEL)"propertyListForAllApp");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    if (lVar2 != 0) {
      _objc_msgSend(lVar2,"objectForKey:",lVar1);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      goto LAB_0001e10c;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_pasteDictionaryisnil);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar3);
  }
  _objc_release(uVar4);
  uVar3 = 0;
LAB_0001e10c:
  _objc_release(lVar2);
  _objc_release(lVar1);
  IVar7 = _objc_autoreleaseReturnValue(uVar3);
  return IVar7;
}



// Function Stack Size: 0x20 bytes

bool AppCommunicate::setPropertyList_forAppID_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  bool bVar10;
  
  lVar1 = _objc_retain(param_3);
  if ((lVar1 == 0) || (param_4 == 0)) {
    uVar4 = _objc_retain(param_4);
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_propertyList____orappId____isnil);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
    _objc_release(lVar1);
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    lVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",lVar1,0);
  }
  else {
    uVar2 = _objc_retain(param_4);
    _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"wxApi_safeSetObject:forKey:",lVar1,uVar2);
    _objc_release(uVar2);
    _objc_release(lVar1);
    getDataPasteboard(param_1,(SEL)"getDataPasteboard");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"string");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    lVar1 = _objc_msgSend(uVar4,"length");
    if (lVar1 != 0) {
      _objc_msgSend(uVar3,"wxApi_safeSetObject:forKey:",uVar4,&cf_old_text);
    }
    _objc_msgSend(&objc::class_t::WeChatApiUtil,"dataFromPropertyList:",uVar3);
    lVar1 = _objc_retainAutoreleasedReturnValue();
    if ((lVar1 != 0) && (lVar5 = _objc_msgSend(lVar1,"length"), lVar5 != 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_setpropertylist);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"printLog:level:",uVar8,0);
      _objc_release(uVar8);
      _objc_release(uVar7);
      _objc_release(uVar6);
      _objc_msgSend(uVar2,"setData:forPasteboardType:",lVar1,&cf_content);
      bVar10 = 1;
      goto LAB_0001e4e4;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_datacovertedisempty);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
  }
  bVar10 = 0;
LAB_0001e4e4:
  _objc_release(lVar1);
  _objc_release(uVar4);
  _objc_release(uVar2);
  _objc_release(uVar3);
  return bVar10;
}



// Function Stack Size: 0x20 bytes

bool AppCommunicate::setAppCommunicateData_forAppID_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  bool bVar1;
  long lVar2;
  ID IVar3;
  long lVar4;
  ID IVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  
  lVar2 = _objc_retain(param_3);
  IVar3 = _objc_retain(param_4);
  if (((IVar3 == 0) || (lVar4 = _objc_msgSend(IVar3,"length"), lVar2 == 0)) || (lVar4 == 0)) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    IVar5 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(IVar3,"length");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar6);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_appId_____appid_length____ordata____invaild);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"printLog:level:",uVar9,0);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    bVar1 = 0;
  }
  else {
    _objc_msgSend(lVar2,"propertList");
    IVar5 = _objc_retainAutoreleasedReturnValue();
    bVar1 = setPropertyList_forAppID_(param_1,(SEL)"setPropertyList:forAppID:",IVar5,IVar3);
  }
  _objc_release(IVar5);
  _objc_release(IVar3);
  _objc_release(lVar2);
  return bVar1;
}



// Function Stack Size: 0x18 bytes

ID AppCommunicate::appCommunicateDataForAppID_(ID param_1,SEL param_2,ID param_3)

{
  ID IVar1;
  long lVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  
  IVar1 = _objc_retain(param_3);
  if ((IVar1 == 0) || (lVar2 = _objc_msgSend(IVar1,"length"), lVar2 == 0)) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appID____invaild);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar2,"printLog:level:",uVar6,0);
LAB_0001e950:
    _objc_release(uVar6);
    _objc_release(uVar5);
    lVar4 = 0;
  }
  else {
    propertyListForAppID_(param_1,(SEL)"propertyListForAppID:",IVar1);
    lVar2 = _objc_retainAutoreleasedReturnValue();
    if (lVar2 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_dictisnil);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar3,"printLog:level:",uVar7,0);
      _objc_release(uVar7);
      goto LAB_0001e950;
    }
    uVar3 = _objc_msgSend(&objc::class_t::AppCommunicateData,"alloc");
    lVar4 = _objc_msgSend(uVar3,"initWithPropertList:",lVar2);
    if (lVar4 == 0) goto LAB_0001e968;
    _objc_msgSend(lVar2,"objectForKey:",&cf_fileData);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar4,"setFileData:",uVar3);
  }
  _objc_release(uVar3);
LAB_0001e968:
  _objc_release(lVar2);
  _objc_release(IVar1);
  IVar1 = _objc_autoreleaseReturnValue(lVar4);
  return IVar1;
}



// Function Stack Size: 0x20 bytes

bool WXApi::registerApp_universalLink_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  bool bVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  ulong uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  
  uVar3 = _objc_retain(param_3);
  uVar4 = _objc_retain(param_4);
  lVar5 = _objc_msgSend(uVar3,"length");
  if (lVar5 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_registerfail_appIdisnil_);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_0001ec80:
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar7,"printLog:level:",uVar10,0);
    _objc_release(uVar10);
    _objc_release(uVar9);
  }
  else {
    lVar5 = _objc_msgSend(uVar4,"length");
    if (lVar5 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_registerfail_universallinkisnil_
                   );
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0001ec80;
    }
    uVar6 = _objc_msgSend(uVar4,"hasPrefix:",&cf_https);
    if ((uVar6 & 1) == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_registerfail_universallinkmustbehttpslink_);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0001ec80;
    }
    iVar1 = _objc_msgSend(uVar4,"containsString:",&cf__);
    if (iVar1 != 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_registerfail_universallinkcannotcontainquery_);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0001ec80;
    }
    bVar2 = isAppRegisterQueryScheme_(param_1,(SEL)"isAppRegisterQueryScheme:",0x42ef0);
    if ((bVar2 & 1) == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &
                    cf_registerfail_WeChatscheme____isnotbeaddedtoLSApplicationQueriesSchemesinplist_
                   );
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
    else {
      bVar2 = isAppRegisterQueryScheme_(param_1,(SEL)"isAppRegisterQueryScheme:",0x42f30);
      if ((bVar2 & 1) == 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &
                      cf_registerfail_WeChatscheme____isnotbeaddedtoLSApplicationQueriesSchemesinplist_
                     );
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar9 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
      else {
        bVar2 = isAppRegisterWechatSecheme_(param_1,(SEL)"isAppRegisterWechatSecheme:",0x42ef0);
        if (bVar2 == 0) {
          bVar2 = isAppRegisterWechatSecheme_(param_1,(SEL)"isAppRegisterWechatSecheme:",0x42f30);
          if (bVar2 == 0) {
            lVar5 = _objc_msgSend(uVar4,"length");
            if (lVar5 == 0) {
              uVar7 = 0;
            }
            else {
              iVar1 = _objc_msgSend(uVar4,"hasSuffix:",&cf__);
              if (iVar1 == 0) {
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____);
                uVar7 = _objc_retainAutoreleasedReturnValue();
              }
              else {
                uVar7 = _objc_retain(uVar4);
              }
            }
            _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID:universalLink:",uVar3
                          ,uVar7);
            bVar2 = 1;
            goto LAB_0001ecbc;
          }
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_registerfail_URLtypesshouldnotregisterWeChatscheme_____);
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar9 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        }
        else {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_registerfail_URLtypesshouldnotregisterWeChatscheme_____);
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar9 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        }
      }
    }
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar7,"printLog:level:",uVar10,0);
    _objc_release(uVar10);
    _objc_release(uVar9);
  }
  _objc_release(uVar8);
  bVar2 = 0;
LAB_0001ecbc:
  _objc_release(uVar7);
  _objc_release(uVar4);
  _objc_release(uVar3);
  return bVar2;
}



// Function Stack Size: 0x18 bytes

bool WXApi::isAppRegisterQueryScheme_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  ulong uVar6;
  undefined8 uVar7;
  ulong uVar8;
  ulong uVar9;
  bool bVar10;
  undefined8 uVar11;
  undefined8 local_130;
  long lStack_128;
  long *local_120;
  undefined8 uStack_118;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined8 uStack_100;
  undefined8 uStack_f8;
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(&_OBJC_CLASS___NSBundle,"mainBundle");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"objectForInfoDictionaryKey:",&cf_LSApplicationQueriesSchemes);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar3);
  uVar3 = _objc_msgSend(&_OBJC_CLASS___NSArray,"class");
  iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar3);
  if ((iVar1 == 0) || (lVar5 = _objc_msgSend(uVar4,"count"), lVar5 == 0)) {
    bVar10 = 0;
  }
  else {
    uStack_108 = 0;
    local_110 = 0;
    uStack_f8 = 0;
    uStack_100 = 0;
    lStack_128 = 0;
    local_130 = 0;
    uStack_118 = 0;
    local_120 = (long *)0x0;
    uVar3 = _objc_retain(uVar4);
    uVar6 = _objc_msgSend(uVar3,"countByEnumeratingWithState:objects:count:",&local_130,auStack_f0,
                          0x10);
    if (uVar6 != 0) {
      lVar5 = *local_120;
      do {
        uVar9 = 0;
        do {
          if (*local_120 != lVar5) {
            _objc_enumerationMutation(uVar3);
          }
          uVar11 = *(undefined8 *)(lStack_128 + uVar9 * 8);
          uVar7 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
          iVar1 = _objc_msgSend(uVar11,"isKindOfClass:",uVar7);
          if ((iVar1 != 0) &&
             (uVar8 = _objc_msgSend(uVar11,"isEqualToString:",uVar2), (uVar8 & 1) != 0)) {
            _objc_release(uVar3);
            bVar10 = 1;
            goto LAB_0001f268;
          }
          uVar9 = uVar9 + 1;
        } while (uVar9 < uVar6);
        uVar6 = _objc_msgSend(uVar3,"countByEnumeratingWithState:objects:count:",&local_130,
                              auStack_f0,0x10);
      } while (uVar6 != 0);
    }
    _objc_release(uVar3);
    bVar10 = 0;
  }
LAB_0001f268:
  _objc_release(uVar4);
  _objc_release(uVar2);
  if (*(long *)PTR____stack_chk_guard_00040040 != local_70) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  return bVar10;
}



// Function Stack Size: 0x18 bytes

bool WXApi::isAppRegisterWechatSecheme_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  ulong uVar6;
  undefined8 uVar7;
  ulong uVar8;
  ulong uVar9;
  ulong uVar10;
  long lVar11;
  bool bVar12;
  undefined8 uVar13;
  ulong uVar14;
  undefined8 uVar15;
  undefined8 local_1f0;
  long lStack_1e8;
  long *local_1e0;
  undefined8 uStack_1d8;
  undefined8 local_1d0;
  undefined8 uStack_1c8;
  undefined8 uStack_1c0;
  undefined8 uStack_1b8;
  undefined8 local_1b0;
  long lStack_1a8;
  long *local_1a0;
  undefined8 uStack_198;
  undefined8 local_190;
  undefined8 uStack_188;
  undefined8 uStack_180;
  undefined8 uStack_178;
  undefined auStack_170 [128];
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(&_OBJC_CLASS___NSBundle,"mainBundle");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"objectForInfoDictionaryKey:",&cf_CFBundleURLTypes);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar3);
  uVar3 = _objc_msgSend(&_OBJC_CLASS___NSArray,"class");
  iVar1 = _objc_msgSend(uVar4,"isKindOfClass:",uVar3);
  if ((iVar1 != 0) && (lVar5 = _objc_msgSend(uVar4,"count"), lVar5 != 0)) {
    uStack_188 = 0;
    local_190 = 0;
    uStack_178 = 0;
    uStack_180 = 0;
    lStack_1a8 = 0;
    local_1b0 = 0;
    uStack_198 = 0;
    local_1a0 = (long *)0x0;
    uVar3 = _objc_retain(uVar4);
    uVar6 = _objc_msgSend(uVar3,"countByEnumeratingWithState:objects:count:",&local_1b0,auStack_f0,
                          0x10);
    if (uVar6 != 0) {
      lVar5 = *local_1a0;
      do {
        uVar10 = 0;
        do {
          if (*local_1a0 != lVar5) {
            _objc_enumerationMutation(uVar3);
          }
          uVar15 = *(undefined8 *)(lStack_1a8 + uVar10 * 8);
          uVar7 = _objc_msgSend(&_OBJC_CLASS___NSDictionary,"class");
          iVar1 = _objc_msgSend(uVar15,"isKindOfClass:",uVar7);
          if (iVar1 != 0) {
            _objc_msgSend(uVar15,"wxApi_arrayForKey:",&cf_CFBundleURLSchemes);
            _objc_retainAutoreleasedReturnValue();
            lStack_1e8 = 0;
            local_1f0 = 0;
            uStack_1d8 = 0;
            local_1e0 = (long *)0x0;
            uStack_1c8 = 0;
            local_1d0 = 0;
            uStack_1b8 = 0;
            uStack_1c0 = 0;
            uVar7 = _objc_retain();
            uVar8 = _objc_msgSend(uVar7,"countByEnumeratingWithState:objects:count:",&local_1f0,
                                  auStack_170,0x10);
            if (uVar8 != 0) {
              lVar11 = *local_1e0;
              do {
                uVar14 = 0;
                do {
                  if (*local_1e0 != lVar11) {
                    _objc_enumerationMutation(uVar7);
                  }
                  uVar13 = *(undefined8 *)(lStack_1e8 + uVar14 * 8);
                  uVar15 = _objc_msgSend(&_OBJC_CLASS___NSString,"class");
                  iVar1 = _objc_msgSend(uVar13,"isKindOfClass:",uVar15);
                  if ((iVar1 != 0) &&
                     (uVar9 = _objc_msgSend(uVar13,"isEqualToString:",uVar2), (uVar9 & 1) != 0)) {
                    _objc_release(uVar7);
                    _objc_release(uVar7);
                    _objc_release(uVar3);
                    bVar12 = 1;
                    goto LAB_0001f574;
                  }
                  uVar14 = uVar14 + 1;
                } while (uVar14 < uVar8);
                uVar8 = _objc_msgSend(uVar7,"countByEnumeratingWithState:objects:count:",&local_1f0,
                                      auStack_170,0x10);
              } while (uVar8 != 0);
            }
            _objc_release(uVar7);
            _objc_release(uVar7);
          }
          uVar10 = uVar10 + 1;
        } while (uVar10 < uVar6);
        uVar6 = _objc_msgSend(uVar3,"countByEnumeratingWithState:objects:count:",&local_1b0,
                              auStack_f0,0x10);
      } while (uVar6 != 0);
    }
    _objc_release(uVar3);
  }
  bVar12 = 0;
LAB_0001f574:
  _objc_release(uVar4);
  _objc_release(uVar2);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_70) {
    return bVar12;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x10 bytes

bool WXApi::isWXAppInstalled(ID param_1,SEL param_2)

{
  bool bVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",&cf_weixin___);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  bVar1 = _objc_msgSend(uVar3,"canOpenURL:",uVar2);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x10 bytes

bool WXApi::isWXAppSupportApi(ID param_1,SEL param_2)

{
  bool bVar1;
  
  bVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isWXAppSupportApi");
  return bVar1;
}



// Function Stack Size: 0x10 bytes

bool WXApi::isWXAppSupportStateAPI(ID param_1,SEL param_2)

{
  bool bVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",&cf_weixinStateAPI___);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  bVar1 = _objc_msgSend(uVar3,"canOpenURL:",uVar2);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x10 bytes

ID WXApi::getWXAppInstallUrl(ID param_1,SEL param_2)

{
  return 0x43030;
}



// Function Stack Size: 0x10 bytes

ID WXApi::getApiVersion(ID param_1,SEL param_2)

{
  return 0x42b70;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXApi::tryGetWechatVersion(ID param_1,SEL param_2)

{
  int iVar1;
  unsigned_int uVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  
  _objc_msgSend(&_OBJC_CLASS___NSUserDefaults,"standardUserDefaults");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"objectForKey:",&cf_WXWechatVersionNSUserDefaultsKey);
  lVar4 = _objc_retainAutoreleasedReturnValue();
  if (lVar4 != 0) {
    uVar5 = _objc_msgSend(&_OBJC_CLASS___NSNumber,"class");
    iVar1 = _objc_msgSend(lVar4,"isKindOfClass:",uVar5);
    if (iVar1 != 0) {
      uVar2 = _objc_msgSend(lVar4,"unsignedIntValue");
      goto LAB_0001f7d0;
    }
  }
  uVar2 = 0;
LAB_0001f7d0:
  _objc_release(lVar4);
  _objc_release(uVar3);
  return uVar2;
}



// Function Stack Size: 0x10 bytes

bool WXApi::openWXApp(ID param_1,SEL param_2)

{
  undefined **ppuVar1;
  bool bVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  bVar2 = isDefaultLaunchByScheme(param_1,(SEL)"isDefaultLaunchByScheme");
  ppuVar1 = &PTR_s_getWechatSchemeUrl__00053e30;
  if (bVar2 == 0) {
    ppuVar1 = &PTR_s_getWechatUniversalLink__00053e38;
  }
  _objc_msgSend(&objc::class_t::WeChatApiUtil,*ppuVar1,uVar3);
  lVar4 = _objc_retainAutoreleasedReturnValue();
  if (lVar4 == 0) {
    bVar2 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    bVar2 = _objc_msgSend(uVar5,"openURL:",lVar4);
    _objc_release(uVar5);
  }
  _objc_release(lVar4);
  _objc_release(uVar3);
  return bVar2;
}



// Function Stack Size: 0x20 bytes

bool WXApi::isURLContainApi_url_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  bool bVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  undefined8 uVar6;
  
  uVar2 = _objc_retain(param_3);
  uVar3 = _objc_retain(param_4);
  _objc_msgSend(uVar3,"absoluteString");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  lVar5 = _objc_msgSend(uVar4,"length");
  _objc_release(uVar4);
  if (lVar5 == 0) {
    bVar1 = 0;
  }
  else {
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    bVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,
                          "isOpenUrlApiCall:apiName:appID:universalLink:",uVar3,uVar2,uVar4,uVar6);
    _objc_release(uVar6);
    _objc_release(uVar4);
  }
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenUniversalLink_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  bool bVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  
  uVar2 = _objc_retain(param_3);
  uVar3 = _objc_retain(param_4);
  _objc_msgSend(uVar2,"activityType");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  uVar5 = _objc_msgSend(uVar4,"isEqualToString:",
                        *(undefined8 *)PTR__NSUserActivityTypeBrowsingWeb_00040010);
  _objc_release(uVar4);
  if ((uVar5 & 1) == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"activityType");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_activitytype____notbehandledbyWeChatSDK);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar8,0);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    bVar1 = 0;
  }
  else {
    _objc_msgSend(uVar2,"webpageURL");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    bVar1 = _objc_msgSend(&objc::class_t::WXApi,"handleOpenURL:delegate:",uVar4,uVar3);
  }
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x20 bytes

bool WXApi::handleOpenURL_delegate_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  bool bVar2;
  ID IVar3;
  ID IVar4;
  undefined8 uVar5;
  long lVar6;
  undefined8 uVar7;
  ulong uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  undefined8 uVar14;
  long lVar15;
  char *pcVar16;
  undefined8 local_88;
  undefined8 local_70;
  
  IVar3 = _objc_retain(param_3);
  IVar4 = _objc_retain(param_4);
  if (IVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_handleopenurlfail_urlisnil);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_0001ff94:
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar10,0);
  }
  else {
    if (IVar4 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_handleopenurlfail_delegateisnil)
      ;
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0001ff94;
    }
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    lVar6 = _objc_msgSend(uVar5,"length");
    if (lVar6 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar12 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_handleopenurlfail_noregisterappID_);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar11 = _objc_retainAutoreleasedReturnValue();
      uVar7 = uVar12;
    }
    else {
      _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      uVar8 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isAppOpenUrl:appID:universalLink:",IVar3,
                            uVar5,uVar7);
      if ((uVar8 & 1) != 0) {
        _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
        uVar9 = _objc_retainAutoreleasedReturnValue();
        iVar1 = _objc_msgSend(uVar9,"universalLinkCheckEnable");
        if ((((((iVar1 == 0) ||
               (bVar2 = handleOpenUniversalLinkCheck_
                                  (param_1,(SEL)"handleOpenUniversalLinkCheck:",IVar3),
               (bVar2 & 1) == 0)) &&
              (bVar2 = handleRefreshTokenOpenUrl_delegate_
                                 (param_1,(SEL)"handleRefreshTokenOpenUrl:delegate:",IVar3,IVar4),
              (bVar2 & 1) == 0)) &&
             ((bVar2 = handleResendContextReqBySchemeOpenUrl_delegate_
                                 (param_1,(SEL)"handleResendContextReqBySchemeOpenUrl:delegate:",
                                  IVar3,IVar4), (bVar2 & 1) == 0 &&
              (bVar2 = handleAuthOpenUrl_delegate_
                                 (param_1,(SEL)"handleAuthOpenUrl:delegate:",IVar3,IVar4),
              (bVar2 & 1) == 0)))) &&
            ((bVar2 = handleLaunchWxaRedirectingPage_delegate_
                                (param_1,(SEL)"handleLaunchWxaRedirectingPage:delegate:",IVar3,IVar4
                                ), (bVar2 & 1) == 0 &&
             ((bVar2 = handlePayOpenUrl_delegate_
                                 (param_1,(SEL)"handlePayOpenUrl:delegate:",IVar3,IVar4),
              (bVar2 & 1) == 0 &&
              (bVar2 = handleJointPayOpenUrl_delegate_
                                 (param_1,(SEL)"handleJointPayOpenUrl:delegate:",IVar3,IVar4),
              (bVar2 & 1) == 0)))))) &&
           (bVar2 = handleOfflinePayUrl_delegate_
                              (param_1,(SEL)"handleOfflinePayUrl:delegate:",IVar3,IVar4),
           (bVar2 & 1) == 0)) {
          _objc_msgSend(&objc::class_t::WapAuthHandler,"shareWapAuthHandlerInstance");
          uVar10 = _objc_retainAutoreleasedReturnValue();
          uVar8 = _objc_msgSend(uVar10,"handleWapOAuthOpenUrl:",IVar3);
          _objc_release(uVar10);
          if (((((uVar8 & 1) == 0) &&
               (bVar2 = handleAddCardOpenUrl_delegate_
                                  (param_1,(SEL)"handleAddCardOpenUrl:delegate:",IVar3,IVar4),
               (bVar2 & 1) == 0)) &&
              (bVar2 = handleChooseCard_delegate_
                                 (param_1,(SEL)"handleChooseCard:delegate:",IVar3,IVar4),
              (bVar2 & 1) == 0)) &&
             (((bVar2 = handleChooseInvoice_delegate_
                                  (param_1,(SEL)"handleChooseInvoice:delegate:",IVar3,IVar4),
               (bVar2 & 1) == 0 &&
               (bVar2 = handleOpenWebviewOpenUrl_delegate_
                                  (param_1,(SEL)"handleOpenWebviewOpenUrl:delegate:",IVar3,IVar4),
               (bVar2 & 1) == 0)) &&
              ((bVar2 = handleOpenBusinessWebviewOpenUrl_delegate_
                                  (param_1,(SEL)"handleOpenBusinessWebviewOpenUrl:delegate:",IVar3,
                                   IVar4), (bVar2 & 1) == 0 &&
               ((bVar2 = handleOpenRankList_delegate_
                                   (param_1,(SEL)"handleOpenRankList:delegate:",IVar3,IVar4),
                (bVar2 & 1) == 0 &&
                (bVar2 = handleOpenTypeWebView_delegate_
                                   (param_1,(SEL)"handleOpenTypeWebView:delegate:",IVar3,IVar4),
                (bVar2 & 1) == 0)))))))) {
            _objc_msgSend(&objc::class_t::AppCommunicate,"appCommunicateDataForAppID:",uVar5);
            lVar6 = _objc_retainAutoreleasedReturnValue();
            if (lVar6 == 0) {
              _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
              lVar15 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appdataisnil_url___);
              local_70 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
              local_88 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(lVar15,"printLog:level:",local_88,0);
LAB_0002138c:
              _objc_release(local_88);
              _objc_release(local_70);
              bVar2 = 0;
LAB_0002139c:
              _objc_release(lVar15);
            }
            else {
              uVar10 = _objc_msgSend(lVar6);
              _objc_msgSend(&objc::class_t::WXLogUtil);
              uVar11 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
              uVar12 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_command___);
              uVar13 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
              uVar14 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(uVar11,"printLog:level:",uVar14,0);
              _objc_release(uVar14);
              _objc_release(uVar13);
              _objc_release(uVar12);
              _objc_release(uVar11);
              lVar15 = _objc_msgSend(lVar6,"command");
              bVar2 = 1;
              if (lVar15 < 0x80c) {
                if (lVar15 < 0x7e4) {
                  if (lVar15 == 0x3f2) {
                    _objc_msgSend(lVar6,"DataToReq");
                    lVar15 = _objc_retainAutoreleasedReturnValue();
                    if (lVar15 != 0) {
                      uVar11 = _objc_msgSend(&objc::class_t::ShowMessageFromWXReq,"class");
                      uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                      if ((uVar8 & 1) != 0) {
code_r0x00020f70:
                        pcVar16 = "onReq:";
                        goto code_r0x00020fd0;
                      }
                    }
                    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                    local_70 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                    local_88 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                  &cf_req____isinvaildforcommand____);
                    uVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                    uVar11 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  }
                  else if (lVar15 == 2000) {
                    _objc_msgSend(lVar6,"DataToReq");
                    lVar15 = _objc_retainAutoreleasedReturnValue();
                    if (lVar15 != 0) {
                      uVar11 = _objc_msgSend(&objc::class_t::GetMessageFromWXReq,"class");
                      uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                      if ((uVar8 & 1) != 0) goto code_r0x00020f70;
                    }
                    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                    local_70 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                    local_88 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                  &cf_req____isinvaildforcommand____);
                    uVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                    uVar11 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  }
                  else {
                    if (lVar15 != 0x7da) goto LAB_000213a4;
                    _objc_msgSend(lVar6,"DataToResp");
                    lVar15 = _objc_retainAutoreleasedReturnValue();
                    if (lVar15 != 0) {
                      uVar11 = _objc_msgSend(&objc::class_t::SendMessageToWXResp,"class");
                      uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                      if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                    }
                    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                    local_70 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                    local_88 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                  &cf_resp____isinvaildforcommand____);
                    uVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                    uVar11 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  }
                }
                else if (lVar15 < 0x7f8) {
                  if (lVar15 == 0x7e4) {
                    _objc_msgSend(lVar6,"DataToResp");
                    lVar15 = _objc_retainAutoreleasedReturnValue();
                    if (lVar15 != 0) {
                      uVar11 = _objc_msgSend(&objc::class_t::SendMessageToWXResp,"class");
                      uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                      if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                    }
                    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                    local_70 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                    local_88 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                  &cf_resp____isinvaildforcommand____);
                    uVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                    uVar11 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  }
                  else {
                    if (lVar15 != 0x7ee) goto LAB_000213a4;
                    _objc_msgSend(lVar6,"DataToResp");
                    lVar15 = _objc_retainAutoreleasedReturnValue();
                    if (lVar15 != 0) {
                      uVar11 = _objc_msgSend(&objc::class_t::SendAuthResp,"class");
                      uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                      if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                    }
                    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                    local_70 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                    local_88 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                  &cf_resp____isinvaildforcommand____);
                    uVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                    uVar11 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  }
                }
                else if (lVar15 == 0x7f8) {
                  _objc_msgSend(lVar6,"DataToReq");
                  lVar15 = _objc_retainAutoreleasedReturnValue();
                  if (lVar15 != 0) {
                    uVar11 = _objc_msgSend(&objc::class_t::LaunchFromWXReq,"class");
                    uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                    if ((uVar8 & 1) != 0) goto code_r0x00020f70;
                  }
                  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                  local_70 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                  local_88 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                &cf_req____isinvaildforcommand____);
                  uVar10 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                  uVar11 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                }
                else {
                  if (lVar15 != 0x802) goto LAB_000213a4;
                  _objc_msgSend(lVar6,"DataToResp");
                  lVar15 = _objc_retainAutoreleasedReturnValue();
                  if (lVar15 != 0) {
                    uVar11 = _objc_msgSend(&objc::class_t::CreateChatRoomResp,"class");
                    uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                    if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                  }
                  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                  local_70 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                  local_88 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                &cf_resp____isinvaildforcommand____);
                  uVar10 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                  uVar11 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                }
                goto LAB_00021354;
              }
              if (0x833 < lVar15) {
                if (lVar15 < 0x848) {
                  if (lVar15 == 0x834) {
LAB_00020a44:
                    _objc_msgSend(lVar6,"DataToResp");
                    lVar15 = _objc_retainAutoreleasedReturnValue();
                    if (lVar15 != 0) {
                      uVar11 = _objc_msgSend(&objc::class_t::WXChannelOpenProfileResp,"class");
                      uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                      if ((uVar8 & 1) != 0) {
                        iVar1 = _objc_msgSend(IVar4,"respondsToSelector:","onResp:");
                        if (iVar1 != 0) {
                          _objc_msgSend(IVar4,"onResp:",lVar15);
                        }
                        _objc_release(lVar15);
                        goto LAB_00020ac4;
                      }
                    }
                    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                    local_70 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                    local_88 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                  &cf_resp____isinvaildforcommand____);
                    uVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                    uVar11 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  }
                  else {
                    if (lVar15 != 0x83e) goto LAB_000213a4;
LAB_00020ac4:
                    _objc_msgSend(lVar6,"DataToResp");
                    lVar15 = _objc_retainAutoreleasedReturnValue();
                    if (lVar15 != 0) {
                      uVar11 = _objc_msgSend(&objc::class_t::WXChannelOpenLiveResp,"class");
                      uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                      if ((uVar8 & 1) != 0) {
                        iVar1 = _objc_msgSend(IVar4,"respondsToSelector:","onResp:");
                        if (iVar1 != 0) {
                          _objc_msgSend(IVar4,"onResp:",lVar15);
                        }
                        _objc_release(lVar15);
                        goto LAB_00020b44;
                      }
                    }
                    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                    local_70 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                    local_88 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                  &cf_resp____isinvaildforcommand____);
                    uVar10 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                    uVar11 = _objc_retainAutoreleasedReturnValue();
                    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  }
                  goto LAB_00021354;
                }
                if (lVar15 == 0x852) {
                  _objc_msgSend(lVar6,"DataToResp");
                  lVar15 = _objc_retainAutoreleasedReturnValue();
                  if (lVar15 != 0) {
                    uVar11 = _objc_msgSend(&objc::class_t::WXOpenCustomerServiceResp,"class");
                    uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                    if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                  }
                  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                  local_70 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                  local_88 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                &cf_resp____isinvaildforcommand____);
                  uVar10 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                  uVar11 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  goto LAB_00021354;
                }
                if (lVar15 != 0x848) goto LAB_000213a4;
LAB_00020b44:
                _objc_msgSend(lVar6,"DataToResp");
                lVar15 = _objc_retainAutoreleasedReturnValue();
                if (lVar15 == 0) {
code_r0x00020b90:
                  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                  local_70 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                  local_88 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                &cf_resp____isinvaildforcommand____);
                  uVar10 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                  uVar11 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                  goto LAB_00021354;
                }
                uVar11 = _objc_msgSend(&objc::class_t::WXChannelOpenFeedResp,"class");
                uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                if ((uVar8 & 1) == 0) goto code_r0x00020b90;
code_r0x00020fc8:
                pcVar16 = "onResp:";
code_r0x00020fd0:
                iVar1 = _objc_msgSend(IVar4,"respondsToSelector:",pcVar16);
                if (iVar1 != 0) {
                  _objc_msgSend(IVar4,pcVar16,lVar15);
                }
                bVar2 = 1;
                goto LAB_0002139c;
              }
              if (0x81f < lVar15) {
                if (lVar15 == 0x820) {
                  _objc_msgSend(lVar6,"DataToResp");
                  lVar15 = _objc_retainAutoreleasedReturnValue();
                  if (lVar15 != 0) {
                    uVar11 = _objc_msgSend(&objc::class_t::WXOpenBusinessViewResp,"class");
                    uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                    if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                  }
                  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                  local_70 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                  local_88 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                &cf_resp____isinvaildforcommand____);
                  uVar10 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                  uVar11 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                }
                else {
                  if (lVar15 != 0x82a) goto LAB_000213a4;
                  _objc_msgSend(lVar6,"DataToResp");
                  lVar15 = _objc_retainAutoreleasedReturnValue();
                  if (lVar15 != 0) {
                    uVar11 = _objc_msgSend(&objc::class_t::WXChannelShareVideoResp,"class");
                    uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                    if ((uVar8 & 1) != 0) {
                      iVar1 = _objc_msgSend(IVar4,"respondsToSelector:","onResp:");
                      if (iVar1 != 0) {
                        _objc_msgSend(IVar4,"onResp:",lVar15);
                      }
                      _objc_release(lVar15);
                      goto LAB_00020a44;
                    }
                  }
                  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                  local_70 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                  local_88 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                                &cf_resp____isinvaildforcommand____);
                  uVar10 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                  uVar11 = _objc_retainAutoreleasedReturnValue();
                  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                }
LAB_00021354:
                uVar12 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(local_70,"printLog:level:",uVar12,0);
                _objc_release(uVar12);
                _objc_release(uVar11);
                _objc_release(uVar10);
                goto LAB_0002138c;
              }
              if (lVar15 == 0x80c) {
                _objc_msgSend(lVar6,"DataToResp");
                lVar15 = _objc_retainAutoreleasedReturnValue();
                if (lVar15 != 0) {
                  uVar11 = _objc_msgSend(&objc::class_t::JoinChatRoomResp,"class");
                  uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                  if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                }
                _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                local_70 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                local_88 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                              &cf_resp____isinvaildforcommand____);
                uVar10 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                uVar11 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                goto LAB_00021354;
              }
              if (lVar15 == 0x816) {
                _objc_msgSend(lVar6,"DataToResp");
                lVar15 = _objc_retainAutoreleasedReturnValue();
                if (lVar15 != 0) {
                  uVar11 = _objc_msgSend(&objc::class_t::WXLaunchMiniProgramResp,"class");
                  uVar8 = _objc_msgSend(lVar15,"isKindOfClass:",uVar11);
                  if ((uVar8 & 1) != 0) goto code_r0x00020fc8;
                }
                _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                local_70 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar10);
                local_88 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                              &cf_resp____isinvaildforcommand____);
                uVar10 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                uVar11 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                goto LAB_00021354;
              }
            }
LAB_000213a4:
            _objc_release(lVar6);
            goto LAB_0002010c;
          }
        }
        bVar2 = 1;
        goto LAB_0002010c;
      }
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar12 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &
                    cf_urlcannotbehandledbyWeChatSDK_registerAppId____registerUniversalLink____url___
                   );
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar11 = _objc_retainAutoreleasedReturnValue();
      uVar9 = uVar12;
    }
    _objc_msgSend(uVar12,"printLog:level:",uVar11,0);
    _objc_release(uVar11);
  }
  _objc_release(uVar10);
  bVar2 = 0;
LAB_0002010c:
  _objc_release(uVar9);
  _objc_release(uVar7);
  _objc_release(uVar5);
  _objc_release(IVar4);
  _objc_release(IVar3);
  return bVar2;
}



// Function Stack Size: 0x20 bytes

bool WXApi::fillAppData_withReq_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  bool bVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  
  lVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_fillappdatafail_reqisnil_);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    if (lVar2 != 0) {
      bVar1 = _objc_msgSend(lVar2,"ReqToData:",lVar3);
      goto LAB_00021574;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_fillappdatafail_appdataisnil_);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  bVar1 = 0;
LAB_00021574:
  _objc_release(lVar3);
  _objc_release(lVar2);
  return bVar1;
}



// Function Stack Size: 0x20 bytes

bool WXApi::fillAppData_withResp_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  bool bVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  
  lVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_fillappdatafail_respisnil_);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    if (lVar2 != 0) {
      bVar1 = _objc_msgSend(lVar2,"RespToData:",lVar3);
      goto LAB_00021768;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_fillappdatafail_appdataisnil_);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  bVar1 = 0;
LAB_00021768:
  _objc_release(lVar3);
  _objc_release(lVar2);
  return bVar1;
}



// Function Stack Size: 0x18 bytes

void WXApi::delaySendContextReq_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  undefined8 uVar2;
  ID IVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined4 in_w6;
  
  uVar2 = _objc_retain(param_3);
  _objc_msgSend(uVar2,"objectForKey:",&cf_contextReq);
  IVar3 = _objc_retainAutoreleasedReturnValue();
  bVar1 = _objc_msgSend(uVar2,"wxApi_boolForKey:",&cf_forceScheme);
  _objc_release(uVar2);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  if (IVar3 == 0) {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_contextreqisnil_);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar2);
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_contextreq___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar2);
    sendReq_isAutoResend_forceScheme_completion_
              (param_1,(SEL)"sendReq:isAutoResend:forceScheme:completion:",IVar3,1,bVar1,0,in_w6);
  }
  _objc_release(IVar3);
  return;
}



// Function Stack Size: 0x18 bytes

void WXApi::delayLaunchWXWithRefreshTokenFail_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  bool bVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  ulong uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  undefined8 uVar17;
  ID IVar18;
  undefined4 uVar19;
  undefined *local_90;
  undefined8 local_88;
  code *local_80;
  undefined *puStack_78;
  undefined8 local_70;
  
  uVar3 = _objc_retain(param_3);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_delaylaunchwxwithrefreshtokenfail);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar4,"printLog:level:",uVar6,0);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_msgSend(uVar3,"wxApi_numberForKey:",&cf_isShare);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"wxApi_numberForKey:",&cf_errCode);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"wxApi_stringForKey:",&cf_errMsg);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar3);
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSBundle,"mainBundle");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar8,"bundleIdentifier");
  uVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar8);
  _objc_msgSend(uVar9,"wxApi_stringByEscapingForURLArgument");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar6,"wxApi_stringByEscapingForURLArgument");
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                &cf_refreshTokenFail_________________________);
  uVar11 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar10);
  _objc_release(uVar8);
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"loadTokenFromKeychain");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  uVar19 = 0;
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,
                "genWeChatUniversalLinkWithExtraUrl:token:contextId:",uVar11,uVar8);
  uVar10 = _objc_retainAutoreleasedReturnValue();
  iVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isWXSupportUniversalLinkAPI");
  if (iVar1 != 0) {
    uVar12 = _objc_msgSend(&objc::class_t::AppCommunicateData,"alloc");
    uVar12 = _objc_msgSend(uVar12,"init");
    _objc_msgSend(uVar12,"setSdkVer:",&cf_1_9_2);
    bVar2 = isDefaultLaunchByScheme(param_1,(SEL)"isDefaultLaunchByScheme");
    if ((bVar2 & 1) == 0) {
      _objc_msgSend(uVar12,"setUniversalLink:",uVar7);
    }
    _objc_msgSend(uVar12,"MakeCommand:",0);
    uVar13 = _objc_msgSend(&objc::class_t::AppCommunicate,"setAppCommunicateData:forAppID:",uVar12,
                           uVar3);
    if ((uVar13 & 1) == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar14 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_refreshtokenfail_setappdatafail)
      ;
      uVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar16 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar17 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar14,"printLog:level:",uVar17,0);
      _objc_release(uVar17);
      _objc_release(uVar16);
      _objc_release(uVar15);
      _objc_release(uVar14);
    }
    _objc_release(uVar12);
  }
  local_90 = PTR___NSConcreteStackBlock_00040028;
  local_88 = 0xc2000000;
  local_80 = ___43__WXApi_delayLaunchWXWithRefreshTokenFail___block_invoke;
  puStack_78 = &___block_descriptor_40_e8_32s_e8_v12__0B8l;
  local_70 = uVar10;
  IVar18 = _objc_retain(uVar10);
  launchApplicationWithUrl_completion_
            (param_1,(SEL)"launchApplicationWithUrl:completion:",IVar18,(ID)&local_90,uVar19);
  _objc_release(local_70);
  _objc_release(IVar18);
  _objc_release(uVar8);
  _objc_release(uVar11);
  _objc_release(uVar9);
  _objc_release(uVar7);
  _objc_release(uVar3);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  return;
}



void ___43__WXApi_delayLaunchWXWithRefreshTokenFail___block_invoke(void)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_openURLsuccess__d_url___);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  return;
}



void ___copy_helper_block_e8_32s(undefined8 param_1,long param_2)

{
  _objc_retain(*(undefined8 *)(param_2 + 0x20));
  return;
}



void ___destroy_helper_block_e8_32s(long param_1)

{
  _objc_release(*(undefined8 *)(param_1 + 0x20));
  return;
}



// Function Stack Size: 0x30 bytes

void WXApi::sendAuthReq_viewController_delegate_completion_
               (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5,ID param_6,
               undefined4 param_7)

{
  ID IVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  ID IVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined4 uVar10;
  code *pcVar11;
  
  IVar4 = param_5;
  IVar1 = _objc_retain(param_3);
  uVar10 = (undefined4)IVar4;
  uVar2 = _objc_retain(param_4);
  uVar3 = _objc_retain(param_5);
  IVar4 = _objc_retain(param_6);
  _objc_msgSend(&_OBJC_CLASS___NSObject,"cancelPreviousPerformRequestsWithTarget:",param_1);
  if (IVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar9,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar9);
    if (IVar4 == 0) goto LAB_000221a8;
    pcVar11 = *(code **)(IVar4 + 0x10);
    uVar9 = 0;
  }
  else {
    uVar5 = _objc_msgSend(&objc::class_t::WXApi,"isWXAppInstalled");
    if ((uVar5 & 1) != 0) {
      sendReq_completion_(param_1,(SEL)"sendReq:completion:",IVar1,IVar4,uVar10);
      goto LAB_000221a8;
    }
    _objc_msgSend(&objc::class_t::WapAuthHandler,"shareWapAuthHandlerInstance");
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    uVar9 = _objc_msgSend(uVar7,"beginWapAuth:currentVC:appId:delegate:",IVar1,uVar2,uVar8,uVar3);
    _objc_release(uVar8);
    _objc_release(uVar7);
    if (IVar4 == 0) goto LAB_000221a8;
    pcVar11 = *(code **)(IVar4 + 0x10);
  }
  (*pcVar11)(IVar4,uVar9);
LAB_000221a8:
  _objc_release(IVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(IVar1);
  return;
}



// Function Stack Size: 0x20 bytes

void WXApi::sendReq_completion_(ID param_1,SEL param_2,ID param_3,ID param_4,undefined4 param_5)

{
  ID IVar1;
  undefined4 in_w6;
  
  IVar1 = _objc_retain(param_3);
  sendReq_isAutoResend_forceScheme_completion_
            (param_1,(SEL)"sendReq:isAutoResend:forceScheme:completion:",IVar1,0,0,param_4,in_w6);
  _objc_release(IVar1);
  return;
}



// Function Stack Size: 0x28 bytes

void WXApi::sendReq_isAutoResend_forceScheme_completion_
               (ID param_1,SEL param_2,ID param_3,bool param_4,bool param_5,ID param_6,
               undefined4 param_7)

{
  bool bVar1;
  ID IVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  long lVar11;
  ulong uVar12;
  undefined8 uVar13;
  ID IVar14;
  ID IVar15;
  undefined *local_a8;
  undefined8 local_a0;
  code *local_98;
  undefined *puStack_90;
  undefined8 local_88;
  ID local_80;
  undefined8 local_78;
  undefined local_70;
  
  IVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_6);
  _objc_msgSend(&_OBJC_CLASS___NSObject,"cancelPreviousPerformRequestsWithTarget:",param_1);
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  uVar6 = _objc_msgSend(&objc::class_t::AppCommunicateData,"alloc");
  IVar7 = _objc_msgSend(uVar6,"init");
  _objc_msgSend(IVar7,"setSdkVer:",&cf_1_9_2);
  _objc_msgSend(IVar7,"setIsAutoResend:",param_4);
  bVar1 = isDefaultLaunchByScheme(param_1,(SEL)"isDefaultLaunchByScheme");
  if (((bVar1 & 1) == 0) && ((param_5 & 1) == 0)) {
    _objc_msgSend(IVar7,"setUniversalLink:",uVar5);
  }
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(IVar7,"sdkVer");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                &cf_sendreq_____appID____universalLink____sdkVersion___);
  uVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar6,"printLog:level:",uVar10,0);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar6);
  if (IVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendreqfail_reqisnil_);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
LAB_000226b8:
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    IVar14 = 0;
  }
  else {
    lVar11 = _objc_msgSend(uVar4,"length");
    if (lVar11 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendreqfail_noregisterappID_);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      goto LAB_000226b8;
    }
    lVar11 = _objc_msgSend(uVar5,"length");
    if (lVar11 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_sendreqfail_noregisteruniversallink_);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      goto LAB_000226b8;
    }
    bVar1 = fillAppData_withReq_(param_1,(SEL)"fillAppData:withReq:",IVar7,IVar2);
    if ((bVar1 & 1) == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendreqfail_fillappdatafail_);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      goto LAB_000226b8;
    }
    uVar12 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isWXSupportUniversalLinkAPI");
    if (((uVar12 & 1) == 0) && (lVar11 = _objc_msgSend(IVar7,"command"), lVar11 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",0);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      uVar9 = _objc_msgSend(IVar7,"command");
      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar9);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_noneedtosetComm_isWXSupportULAPI____command___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar13 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar6,"printLog:level:",uVar13,0);
      _objc_release(uVar13);
      _objc_release(uVar10);
      _objc_release(uVar9);
      _objc_release(uVar8);
      _objc_release(uVar6);
    }
    else {
      uVar12 = _objc_msgSend(&objc::class_t::AppCommunicate,"setAppCommunicateData:forAppID:",IVar7,
                             uVar4);
      if ((uVar12 & 1) == 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendreqfail_setCommret_nil);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        goto LAB_000226b8;
      }
    }
    genExtraUrlByReq_withAppData_(param_1,(SEL)"genExtraUrlByReq:withAppData:",IVar2,IVar7);
    IVar14 = _objc_retainAutoreleasedReturnValue();
    if ((IVar14 != 0) && (lVar11 = _objc_msgSend(IVar14,"length"), lVar11 != 0)) {
      if ((param_4 & 1) == 0) {
        genContextId_(param_1,(SEL)"genContextId:",IVar2);
        IVar15 = _objc_retainAutoreleasedReturnValue();
      }
      else {
        IVar15 = 0;
      }
      local_a8 = PTR___NSConcreteStackBlock_00040028;
      local_a0 = 0xc2000000;
      local_98 = ___53__WXApi_sendReq_isAutoResend_forceScheme_completion___block_invoke;
      puStack_90 = &___block_descriptor_57_e8_32s40s48bs_e11_v16__0B8B12l;
      local_70 = (undefined)param_4;
      local_88 = _objc_retain(IVar2);
      local_80 = IVar15;
      uVar6 = _objc_retain(IVar15);
      local_78 = _objc_retain(lVar3);
      launchWechatWithExtralUrl_forceScheme_contextId_completion_
                (param_1,(SEL)"launchWechatWithExtralUrl:forceScheme:contextId:completion:",IVar14,
                 param_5,IVar15,(ID)&local_a8,param_7);
      _objc_release(local_78);
      _objc_release(local_80);
      _objc_release(local_88);
      _objc_release(uVar6);
      goto LAB_00022734;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendreqfail_extraurlisnil_);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar6,"printLog:level:",uVar10,0);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar6);
  if (lVar3 != 0) {
    (**(code **)(lVar3 + 0x10))(lVar3,0);
  }
LAB_00022734:
  _objc_release(IVar14);
  _objc_release(IVar7);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(lVar3);
  _objc_release(IVar2);
  return;
}



void ___53__WXApi_sendReq_isAutoResend_forceScheme_completion___block_invoke
               (long param_1,undefined8 param_2,int param_3)

{
  undefined8 uVar1;
  long lVar2;
  
  if (((int)param_2 != 0) && (*(char *)(param_1 + 0x38) == '\0' && param_3 != 0)) {
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"setContextReq:contextId:",*(undefined8 *)(param_1 + 0x20),
                  *(undefined8 *)(param_1 + 0x28));
    _objc_release(uVar1);
  }
  lVar2 = *(long *)(param_1 + 0x30);
  if (lVar2 != 0) {
                    // WARNING: Could not recover jumptable at 0x00022a98. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(lVar2 + 0x10))(lVar2,param_2);
    return;
  }
  return;
}



void ___copy_helper_block_e8_32s40s48b(long param_1,long param_2)

{
  _objc_retain(*(undefined8 *)(param_2 + 0x20));
  _objc_retain(*(undefined8 *)(param_2 + 0x28));
  __Block_object_assign((void *)(param_1 + 0x30),*(void **)(param_2 + 0x30),7);
  return;
}



void ___destroy_helper_block_e8_32s40s48s(long param_1)

{
  _objc_release(*(undefined8 *)(param_1 + 0x30));
  _objc_release(*(undefined8 *)(param_1 + 0x28));
  _objc_release(*(undefined8 *)(param_1 + 0x20));
  return;
}



// Function Stack Size: 0x10 bytes

bool WXApi::isDefaultLaunchByScheme(ID param_1,SEL param_2)

{
  int iVar1;
  uint uVar2;
  
  iVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isiOS12plus");
  if (iVar1 == 0) {
    uVar2 = 1;
  }
  else {
    uVar2 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isWXSupportUniversalLinkAPI");
    uVar2 = uVar2 ^ 1;
  }
  return uVar2;
}



// Function Stack Size: 0x2c bytes

void WXApi::launchWechatWithExtralUrl_forceScheme_contextId_completion_
               (ID param_1,SEL param_2,ID param_3,bool param_4,ID param_5,ID param_6,
               undefined4 param_7)

{
  bool bVar1;
  int iVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  ID IVar8;
  undefined8 uVar9;
  undefined4 uVar10;
  undefined *local_b8;
  undefined8 local_b0;
  code *local_a8;
  undefined *puStack_a0;
  undefined8 local_98;
  undefined8 local_90;
  ID IStack_88;
  undefined8 local_80;
  undefined *local_78;
  undefined8 local_70;
  code *local_68;
  undefined *puStack_60;
  undefined8 local_58;
  
  uVar3 = _objc_retain(param_3);
  uVar4 = _objc_retain(param_5);
  uVar5 = _objc_retain(param_6);
  if ((param_4 & 1) == 0) {
    bVar1 = isDefaultLaunchByScheme(param_1,(SEL)"isDefaultLaunchByScheme");
  }
  else {
    bVar1 = 1;
  }
  iVar2 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isiOS13plus");
  if (iVar2 == 0) {
    uVar6 = 0;
  }
  else {
    uVar6 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isWXSupportUniversalLinkAPI");
  }
  if (bVar1 == 0) {
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"loadTokenFromKeychain");
    IVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,
                  "genWeChatUniversalLinkWithExtraUrl:token:contextId:",uVar3,IVar7,uVar4);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    uVar10 = 1;
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,
                  "genWeChatUrlSchemeUrl:appendBundleID:isDegrade:",uVar3,uVar6);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    local_b8 = PTR___NSConcreteStackBlock_00040028;
    local_b0 = 0xc2000000;
    local_a8 = 
    ___68__WXApi_launchWechatWithExtralUrl_forceScheme_contextId_completion___block_invoke_342;
    puStack_a0 = &___block_descriptor_64_e8_32s40s56bs_e8_v12__0B8l;
    local_98 = uVar9;
    IVar8 = _objc_retain(uVar9);
    local_90 = uVar6;
    IStack_88 = param_1;
    uVar6 = _objc_retain(uVar6);
    local_80 = uVar5;
    uVar5 = _objc_retain(uVar5);
    launchApplicationWithUrl_completion_
              (param_1,(SEL)"launchApplicationWithUrl:completion:",IVar8,(ID)&local_b8,uVar10);
    _objc_release(local_80);
    _objc_release(local_90);
    _objc_release(local_98);
    _objc_release(uVar5);
  }
  else {
    uVar10 = 0;
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,
                  "genWeChatUrlSchemeUrl:appendBundleID:isDegrade:",uVar3,uVar6);
    IVar7 = _objc_retainAutoreleasedReturnValue();
    local_78 = PTR___NSConcreteStackBlock_00040028;
    local_70 = 0xc2000000;
    local_68 = 
    ___68__WXApi_launchWechatWithExtralUrl_forceScheme_contextId_completion___block_invoke;
    puStack_60 = &___block_descriptor_40_e8_32bs_e8_v12__0B8l;
    local_58 = uVar5;
    IVar8 = _objc_retain(uVar5);
    launchApplicationWithUrl_completion_
              (param_1,(SEL)"launchApplicationWithUrl:completion:",IVar7,(ID)&local_78,uVar10);
    uVar6 = local_58;
  }
  _objc_release(uVar6);
  _objc_release(IVar8);
  _objc_release(IVar7);
  _objc_release(uVar4);
  _objc_release(uVar3);
  return;
}



void ___68__WXApi_launchWechatWithExtralUrl_forceScheme_contextId_completion___block_invoke
               (long param_1,undefined8 param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",param_2);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_launchappwithschemeurlret___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar4,0);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  lVar5 = *(long *)(param_1 + 0x20);
  if (lVar5 != 0) {
                    // WARNING: Could not recover jumptable at 0x00022f00. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(lVar5 + 0x10))(lVar5,param_2,0);
    return;
  }
  return;
}



void ___copy_helper_block_e8_32b(long param_1,long param_2)

{
  __Block_object_assign((void *)(param_1 + 0x20),*(void **)(param_2 + 0x20),7);
  return;
}



void ___68__WXApi_launchWechatWithExtralUrl_forceScheme_contextId_completion___block_invoke_342
               (long param_1,ulong param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  undefined *local_70;
  undefined8 local_68;
  code *local_60;
  undefined *puStack_58;
  undefined8 local_50;
  undefined8 local_48;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  if ((param_2 & 1) == 0) {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_lauchappfailandneeddegrade_url____schemeURL___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"printLog:level:",uVar4,0);
    _objc_release(uVar4);
    _objc_release(uVar3);
    _objc_release(uVar2);
    _objc_release(uVar1);
    uVar2 = *(undefined8 *)(param_1 + 0x30);
    local_70 = PTR___NSConcreteStackBlock_00040028;
    local_68 = 0xc2000000;
    local_60 = 
    ___68__WXApi_launchWechatWithExtralUrl_forceScheme_contextId_completion___block_invoke_2;
    puStack_58 = &___block_descriptor_48_e8_32s40bs_e8_v12__0B8l;
    uVar1 = _objc_retain(*(undefined8 *)(param_1 + 0x28));
    local_50 = uVar1;
    local_48 = _objc_retain(*(undefined8 *)(param_1 + 0x38));
    _objc_msgSend(uVar2,"launchApplicationWithUrl:completion:",uVar1,&local_70);
    _objc_release(local_48);
    _objc_release(local_50);
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",1);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_launchappwithuniversallink_ret___)
    ;
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"printLog:level:",uVar4,0);
    _objc_release(uVar4);
    _objc_release(uVar3);
    _objc_release(uVar2);
    _objc_release(uVar1);
    lVar5 = *(long *)(param_1 + 0x38);
    if (lVar5 != 0) {
                    // WARNING: Could not recover jumptable at 0x00023050. Too many branches
                    // WARNING: Treating indirect jump as call
      (**(code **)(lVar5 + 0x10))(lVar5,1,1);
      return;
    }
  }
  return;
}



void ___68__WXApi_launchWechatWithExtralUrl_forceScheme_contextId_completion___block_invoke_2
               (long param_1,undefined8 param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",param_2);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_degradelaunchappret____withurl___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar4,0);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  lVar5 = *(long *)(param_1 + 0x28);
  if (lVar5 != 0) {
                    // WARNING: Could not recover jumptable at 0x000232b4. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(lVar5 + 0x10))(lVar5,param_2,0);
    return;
  }
  return;
}



void ___copy_helper_block_e8_32s40b(long param_1,long param_2)

{
  _objc_retain(*(undefined8 *)(param_2 + 0x20));
  __Block_object_assign((void *)(param_1 + 0x28),*(void **)(param_2 + 0x28),7);
  return;
}



void ___copy_helper_block_e8_32s40s56b(long param_1,long param_2)

{
  _objc_retain(*(undefined8 *)(param_2 + 0x20));
  _objc_retain(*(undefined8 *)(param_2 + 0x28));
  __Block_object_assign((void *)(param_1 + 0x38),*(void **)(param_2 + 0x38),7);
  return;
}



void ___destroy_helper_block_e8_32s40s56s(long param_1)

{
  _objc_release(*(undefined8 *)(param_1 + 0x38));
  _objc_release(*(undefined8 *)(param_1 + 0x28));
  _objc_release(*(undefined8 *)(param_1 + 0x20));
  return;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genContextId_(ID param_1,SEL param_2,ID param_3)

{
  unsigned_int uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  uVar2 = _objc_retain(param_3);
  uVar3 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"genCurrentTime");
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",uVar3);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  uVar1 = genAutoIncreaceID(param_1,(SEL)"genAutoIncreaceID");
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",uVar1);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_____p___);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_msgSend(&objc::class_t::WeChatApiUtil,"sha256:",uVar5);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar5);
  IVar6 = _objc_autoreleaseReturnValue(uVar2);
  return IVar6;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXApi::genAutoIncreaceID(ID param_1,SEL param_2)

{
  unsigned_int uVar1;
  undefined8 uVar2;
  
  uVar2 = _objc_retain();
  _objc_sync_enter();
  uVar1 = _genAutoIncreaceID_s_autoIncreaceID + 1;
  _genAutoIncreaceID_s_autoIncreaceID = uVar1;
  _objc_sync_exit(uVar2);
  _objc_release(uVar2);
  return uVar1;
}



// Function Stack Size: 0x20 bytes

void WXApi::sendResp_completion_(ID param_1,SEL param_2,ID param_3,ID param_4,undefined4 param_5)

{
  bool bVar1;
  ID IVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  long lVar11;
  ulong uVar12;
  undefined4 in_w6;
  undefined *local_88;
  undefined8 local_80;
  code *local_78;
  undefined *puStack_70;
  undefined8 local_68;
  
  IVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
  uVar5 = _objc_retainAutoreleasedReturnValue();
  uVar6 = _objc_msgSend(&objc::class_t::AppCommunicateData,"alloc");
  IVar7 = _objc_msgSend(uVar6,"init");
  _objc_msgSend(IVar7,"setSdkVer:",&cf_1_9_2);
  _objc_msgSend(IVar7,"setReturnFromApp:",1);
  uVar6 = _objc_msgSend(IVar2,"errCode");
  _objc_msgSend(IVar7,"setResult:",uVar6);
  bVar1 = isDefaultLaunchByScheme(param_1,(SEL)"isDefaultLaunchByScheme");
  if ((bVar1 & 1) == 0) {
    _objc_msgSend(IVar7,"setUniversalLink:",uVar5);
  }
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(IVar7,"sdkVer");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                &cf_sendresp_____appid____universalLink____sdkVer___);
  uVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar6,"printLog:level:",uVar10,0);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar6);
  if (IVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendrespfail_respisnil_);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    lVar11 = _objc_msgSend(uVar4,"length");
    if (lVar11 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendrespfail_noregisterappID_);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
    else {
      lVar11 = _objc_msgSend(uVar5,"length");
      if (lVar11 == 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &cf_sendrespfail_noregisteruniversallink_);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      }
      else {
        bVar1 = fillAppData_withResp_(param_1,(SEL)"fillAppData:withResp:",IVar7,IVar2);
        if ((bVar1 & 1) == 0) {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_sendrespfail_fillappdatafail_);
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        }
        else {
          uVar12 = _objc_msgSend(&objc::class_t::AppCommunicate,"setAppCommunicateData:forAppID:",
                                 IVar7,uVar4);
          if ((uVar12 & 1) != 0) {
            local_88 = PTR___NSConcreteStackBlock_00040028;
            local_80 = 0xc2000000;
            local_78 = ___29__WXApi_sendResp_completion___block_invoke;
            puStack_70 = &___block_descriptor_40_e8_32bs_e11_v16__0B8B12l;
            local_68 = _objc_retain(lVar3);
            launchWechatWithExtralUrl_forceScheme_contextId_completion_
                      (param_1,(SEL)"launchWechatWithExtralUrl:forceScheme:contextId:completion:",
                       0x43510,0,0,(ID)&local_88,in_w6);
            _objc_release(local_68);
            goto LAB_00023a68;
          }
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendrespfail_setCommret_nil)
          ;
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        }
      }
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
  }
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar6,"printLog:level:",uVar10,0);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar6);
  if (lVar3 != 0) {
    (**(code **)(lVar3 + 0x10))(lVar3,0);
  }
LAB_00023a68:
  _objc_release(IVar7);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(lVar3);
  _objc_release(IVar2);
  return;
}



void ___29__WXApi_sendResp_completion___block_invoke(long param_1)

{
  if (*(long *)(param_1 + 0x20) != 0) {
                    // WARNING: Could not recover jumptable at 0x00023abc. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(*(long *)(param_1 + 0x20) + 0x10))();
    return;
  }
  return;
}



// Function Stack Size: 0x20 bytes

void WXApi::launchApplicationWithUrl_completion_
               (ID param_1,SEL param_2,ID param_3,ID param_4,undefined4 param_5)

{
  int iVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ulong uVar8;
  undefined8 uVar9;
  code *pcVar10;
  undefined *local_a8;
  undefined8 local_a0;
  code *local_98;
  undefined *puStack_90;
  undefined8 local_88;
  undefined8 local_80;
  undefined8 local_78;
  undefined8 local_70;
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00040040;
  lVar2 = _objc_retain(param_3);
  lVar3 = _objc_retain(param_4);
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_launchappfail_urlisnil_);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    if (lVar3 == 0) goto LAB_00023f20;
    pcVar10 = *(code **)(lVar3 + 0x10);
    uVar8 = 0;
  }
  else {
    _objc_msgSend(lVar2,"absoluteString");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    uVar5 = _objc_msgSend(uVar4,"hasPrefix:",&cf_https);
    _objc_release(uVar4);
    if (((int)uVar5 != 0) &&
       (iVar1 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isiOS10plus"), iVar1 != 0)) {
      _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      local_78 = *(undefined8 *)PTR__UIApplicationOpenURLOptionUniversalLinksOnly_00040020;
      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",1);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      local_70 = uVar5;
      _objc_msgSend(&_OBJC_CLASS___NSDictionary,"dictionaryWithObjects:forKeys:count:",&local_70,
                    &local_78,1);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      local_a8 = PTR___NSConcreteStackBlock_00040028;
      local_a0 = 0xc2000000;
      local_98 = ___45__WXApi_launchApplicationWithUrl_completion___block_invoke;
      puStack_90 = &___block_descriptor_48_e8_32s40bs_e8_v12__0B8l;
      uVar7 = _objc_retain(lVar2);
      local_88 = uVar7;
      local_80 = _objc_retain(lVar3);
      _objc_msgSend(uVar4,"openURL:options:completionHandler:",uVar7,uVar6,&local_a8);
      _objc_release(uVar6);
      _objc_release(uVar5);
      _objc_release(uVar4);
      _objc_release(local_80);
      _objc_release(local_88);
      goto LAB_00023f20;
    }
    _objc_msgSend(&_OBJC_CLASS___UIApplication,"sharedApplication");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_msgSend(uVar4,"openURL:",lVar2);
    _objc_release(uVar4);
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    if ((uVar8 & 1) == 0) {
      _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithBool:",uVar5);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_launchappfail_isUlLaunch____url___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar4,"printLog:level:",uVar9,0);
      _objc_release(uVar9);
      _objc_release(uVar7);
    }
    else {
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_launchappwithurlsuccess);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar4,"printLog:level:",uVar6,0);
    }
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    if (lVar3 == 0) goto LAB_00023f20;
    pcVar10 = *(code **)(lVar3 + 0x10);
  }
  (*pcVar10)(lVar3,uVar8);
LAB_00023f20:
  _objc_release(lVar3);
  _objc_release(lVar2);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_68) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void ___45__WXApi_launchApplicationWithUrl_completion___block_invoke(long param_1,ulong param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  if ((param_2 & 1) == 0) {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_launchappwithulonlyfail_url___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"printLog:level:",uVar4,0);
    _objc_release(uVar4);
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_launchappwithulonlysuccess);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
  }
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  lVar5 = *(long *)(param_1 + 0x28);
  if (lVar5 != 0) {
                    // WARNING: Could not recover jumptable at 0x000240fc. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(lVar5 + 0x10))(lVar5,param_2);
    return;
  }
  return;
}



// Function Stack Size: 0x20 bytes

void WXApi::startLogByLevel_logBlock_
               (ID param_1,SEL param_2,long_long param_3,ID param_4,undefined4 param_5)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar1 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"configLogBlock:level:",uVar1,param_3);
  _objc_release(uVar1);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x20 bytes

void WXApi::startLogByLevel_logDelegate_(ID param_1,SEL param_2,long_long param_3,ID param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar1 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"configLogDelegate:level:",uVar1,param_3);
  _objc_release(uVar1);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x10 bytes

void WXApi::stopLog(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"removeLog");
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x18 bytes

void WXApi::checkUniversalLinkReady_(ID param_1,SEL param_2,ID param_3,undefined4 param_4)

{
  bool bVar1;
  ID IVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  long lVar7;
  ID IVar8;
  ID IVar9;
  undefined8 uVar10;
  ulong uVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  undefined4 uVar14;
  cfstringStruct *pcVar15;
  ID in_x7;
  undefined *local_98;
  undefined8 local_90;
  code *local_88;
  undefined *puStack_80;
  undefined8 local_78;
  undefined8 local_70;
  ID IStack_68;
  
  IVar2 = _objc_retain(param_3,param_2,param_3,param_4);
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerAppID");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"registerUniversalLink");
  uVar4 = _objc_retainAutoreleasedReturnValue();
  if (IVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_completionisnil);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar12 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar6,"printLog:level:",uVar12,0);
    _objc_release(uVar12);
    _objc_release(uVar10);
    _objc_release(uVar5);
    goto LAB_000247d4;
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXCheckULStepResult,"alloc");
  uVar6 = _objc_msgSend(uVar5,"initWithCheckResult:errorInfo:suggestion:",1,&cf_checkpassed,&cf___);
  lVar7 = _objc_msgSend(uVar3,"length");
  if ((lVar7 == 0) || (lVar7 = _objc_msgSend(uVar4,"length"), lVar7 == 0)) {
    checkUniversalLinkCallback_step_success_errorInfo_suggestion_
              (param_1,(SEL)"checkUniversalLinkCallback:step:success:errorInfo:suggestion:",IVar2,0,
               0,0x43610,0x43630,in_x7);
    goto LAB_000247d4;
  }
  (**(code **)(IVar2 + 0x10))(IVar2,0,uVar6);
  uVar5 = _objc_msgSend(&objc::class_t::AppCommunicateData,"alloc");
  IVar8 = _objc_msgSend(uVar5,"init");
  _objc_msgSend(IVar8,"setSdkVer:",&cf_1_9_2);
  _objc_msgSend(IVar8,"setUniversalLink:",uVar4);
  uVar5 = _objc_msgSend(&objc::class_t::SendMessageToWXReq,"alloc");
  IVar9 = _objc_msgSend(uVar5,"init");
  uVar5 = _objc_msgSend(&objc::class_t::WXMediaMessage,"alloc");
  uVar5 = _objc_msgSend(uVar5,"init");
  _objc_msgSend(uVar5,"setTitle:",&cf_TestMessageFromWeChatSDKAutoCheckMethod);
  _objc_msgSend(uVar5,"setDescription:",&cf_TestMessageFromWeChatSDKAutoCheckMethod);
  uVar10 = _objc_msgSend(&objc::class_t::WXTextObject,"alloc");
  uVar10 = _objc_msgSend(uVar10,"init");
  _objc_msgSend(uVar10,"setContentText:",&cf_TestMessageFromWeChatSDKAutoCheckMethod);
  _objc_msgSend(uVar5,"setMediaObject:",uVar10);
  _objc_msgSend(IVar9,"setMessage:",uVar5);
  _objc_msgSend(IVar9,"setScene:",0);
  _objc_msgSend(IVar9,"setBText:",1);
  _objc_msgSend(IVar9,"setText:",&cf_TestMessageFromWeChatSDKAutoCheckMethod);
  uVar11 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isiOS12plus");
  if ((uVar11 & 1) == 0) {
    checkUniversalLinkCallback_step_success_errorInfo_suggestion_
              (param_1,(SEL)"checkUniversalLinkCallback:step:success:errorInfo:suggestion:",IVar2,1,
               0,0x43670,0x43690,in_x7);
  }
  else {
    (**(code **)(IVar2 + 0x10))(IVar2,1,uVar6);
    uVar11 = _objc_msgSend(&objc::class_t::WeChatApiUtil,"isWXSupportUniversalLinkAPI");
    if ((uVar11 & 1) == 0) {
      bVar1 = 0x436b0;
      pcVar15 = &cf_PleaseupgradeWeChattothelatestversion_;
      uVar14 = 2;
    }
    else {
      (**(code **)(IVar2 + 0x10))(IVar2,2,uVar6);
      bVar1 = fillAppData_withReq_(param_1,(SEL)"fillAppData:withReq:",IVar8,IVar9);
      if ((bVar1 & 1) != 0) {
        uVar11 = _objc_msgSend(&objc::class_t::AppCommunicate,"setAppCommunicateData:forAppID:",
                               IVar8,uVar3);
        if ((uVar11 & 1) == 0) {
          checkUniversalLinkCallback_step_success_errorInfo_suggestion_
                    (param_1,(SEL)"checkUniversalLinkCallback:step:success:errorInfo:suggestion:",
                     IVar2,3,0,0x436f0,0x43710,in_x7);
        }
        else {
          genExtraUrlByReq_withAppData_(param_1,(SEL)"genExtraUrlByReq:withAppData:",IVar9,IVar8);
          uVar12 = _objc_retainAutoreleasedReturnValue();
          lVar7 = _objc_msgSend(uVar12,"length");
          if (lVar7 == 0) {
            checkUniversalLinkCallback_step_success_errorInfo_suggestion_
                      (param_1,(SEL)"checkUniversalLinkCallback:step:success:errorInfo:suggestion:",
                       IVar2,3,0,0x436f0,0x43710,in_x7);
          }
          else {
            (**(code **)(IVar2 + 0x10))(IVar2,3,uVar6);
            _objc_msgSend(&objc::class_t::WeChatIdentityHandler,
                          "genWeChatUniversalLinkWithExtraUrl:token:contextId:",uVar12,0,
                          &cf_TestAutoCheckContextId_e312a10b4bded6115265bad238dd488d3db7f78d);
            uVar13 = _objc_retainAutoreleasedReturnValue();
            local_98 = PTR___NSConcreteStackBlock_00040028;
            local_90 = 0xc2000000;
            local_88 = ___33__WXApi_checkUniversalLinkReady___block_invoke;
            puStack_80 = &___block_descriptor_56_e8_32bs40s_e8_v12__0B8l;
            local_78 = _objc_retain(IVar2);
            local_70 = _objc_retain(uVar6);
            IStack_68 = param_1;
            _objc_msgSend(&objc::class_t::WXApi,"launchApplicationWithUrl:completion:",uVar13,
                          &local_98);
            _objc_release(local_70);
            _objc_release(local_78);
            _objc_release(uVar13);
          }
          _objc_release(uVar12);
        }
        goto LAB_000247b0;
      }
      bVar1 = 0x436f0;
      pcVar15 = &cf_Unknownerror_pleasetryagain_;
      uVar14 = 3;
    }
    checkUniversalLinkCallback_step_success_errorInfo_suggestion_
              (param_1,(SEL)"checkUniversalLinkCallback:step:success:errorInfo:suggestion:",IVar2,
               uVar14,0,bVar1,(ID)pcVar15,in_x7);
  }
LAB_000247b0:
  _objc_release(uVar10);
  _objc_release(uVar5);
  _objc_release(IVar9);
  _objc_release(IVar8);
LAB_000247d4:
  _objc_release(uVar6);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(IVar2);
  return;
}



void ___33__WXApi_checkUniversalLinkReady___block_invoke(long param_1,int param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  if (param_2 != 0) {
    (**(code **)(*(long *)(param_1 + 0x20) + 0x10))
              (*(long *)(param_1 + 0x20),4,*(undefined8 *)(param_1 + 0x28));
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_SuccessfullystartingWeChatwiththeuniversallink_);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
    _objc_release(uVar3);
    _objc_release(uVar2);
    _objc_release(uVar1);
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"shareInstance");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"setUniversalLinkCheckEnable:",1);
    _objc_msgSend(uVar1,"setCheckCompletion:",*(undefined8 *)(param_1 + 0x20));
    _objc_release(uVar1);
    return;
  }
  _objc_msgSend(*(undefined8 *)(param_1 + 0x30),
                "checkUniversalLinkCallback:step:success:errorInfo:suggestion:",
                *(undefined8 *)(param_1 + 0x20),4,0,&cf_TheuniversallinkforWeChatisnotineffect_,
                &cf_YoucantryuninstallingandreinstallingWeChat_);
  return;
}



void ___copy_helper_block_e8_32b40s(long param_1,long param_2)

{
  __Block_object_assign((void *)(param_1 + 0x20),*(void **)(param_2 + 0x20),7);
  _objc_retain(*(undefined8 *)(param_2 + 0x28));
  return;
}



// Function Stack Size: 0x34 bytes

void WXApi::checkUniversalLinkCallback_step_success_errorInfo_suggestion_
               (ID param_1,SEL param_2,ID param_3,undefined4 param_4,long_long param_5,bool param_6,
               ID param_7,ID param_8)

{
  cfstringStruct *pcVar1;
  cfstringStruct *pcVar2;
  long lVar3;
  cfstringStruct *pcVar4;
  cfstringStruct *pcVar5;
  undefined8 uVar6;
  long lVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  
  lVar3 = _objc_retain(param_3);
  pcVar4 = (cfstringStruct *)_objc_retain(param_6);
  pcVar5 = (cfstringStruct *)_objc_retain(param_7);
  uVar6 = _objc_msgSend(&objc::class_t::WXCheckULStepResult,"alloc");
  lVar7 = _objc_msgSend(pcVar4,"length");
  pcVar1 = &cf___;
  if (lVar7 != 0) {
    pcVar1 = pcVar4;
  }
  lVar7 = _objc_msgSend(pcVar5,"length");
  pcVar2 = &cf___;
  if (lVar7 != 0) {
    pcVar2 = pcVar5;
  }
  uVar6 = _objc_msgSend(uVar6,"initWithCheckResult:errorInfo:suggestion:",param_5,pcVar1,pcVar2);
  _objc_release(pcVar5);
  _objc_release(pcVar4);
  if (lVar3 != 0) {
    (**(code **)(lVar3 + 0x10))(lVar3,param_4,uVar6);
  }
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf___);
  uVar9 = _objc_retainAutoreleasedReturnValue();
  if ((int)param_5 == 0) {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"printLog:level:",uVar11,0);
    _objc_release(uVar11);
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"printLog:level:",uVar10,0);
  }
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar6);
  _objc_release(lVar3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::shareInstance(ID param_1,SEL param_2)

{
  ID IVar1;
  SEL extraout_x1;
  
  if (__ZZ38__WeChatIdentityHandler_shareInstance_E9onceToken != -1) {
    _dispatch_once(&__ZZ38__WeChatIdentityHandler_shareInstance_E9onceToken,&___block_literal_global
                  );
    param_2 = extraout_x1;
  }
  IVar1 = _objc_retainAutoreleaseReturnValue
                    (__ZZ38__WeChatIdentityHandler_shareInstance_E9g_handler,param_2);
  return IVar1;
}



void ___38__WeChatIdentityHandler_shareInstance__block_invoke(void)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"alloc");
  uVar2 = _objc_msgSend(uVar1,"init");
  uVar1 = __ZZ38__WeChatIdentityHandler_shareInstance_E9g_handler;
  __ZZ38__WeChatIdentityHandler_shareInstance_E9g_handler = uVar2;
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x20 bytes

void WeChatIdentityHandler::registerAppID_universalLink_
               (ID param_1,SEL param_2,ID param_3,ID param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  uVar2 = _objc_retain(param_3);
  uVar3 = _objc_retain(param_4);
  uVar1 = _s_registerAppID;
  _s_registerAppID = uVar2;
  uVar2 = _objc_retain(uVar2);
  _objc_release(uVar1);
  uVar1 = _s_registerUniversalLink;
  _s_registerUniversalLink = uVar3;
  _objc_release(uVar1);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::registerAppID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(_s_registerAppID);
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::registerUniversalLink(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(_s_registerUniversalLink);
  return IVar1;
}



// Function Stack Size: 0x20 bytes

void WeChatIdentityHandler::setContextReq_contextId_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  
  uVar1 = _objc_retain(param_3);
  uVar2 = _objc_retain(param_4);
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_req____cid___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar3,"printLog:level:",uVar5,0);
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_storeStrong(param_1 + 0x18,param_3);
  uVar3 = _objc_msgSend(uVar2,"copy");
  uVar4 = *(undefined8 *)(param_1 + 0x20);
  *(undefined8 *)(param_1 + 0x20) = uVar3;
  _objc_release(uVar4);
  _objc_release(uVar2);
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::contextRequest(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_retainAutoreleaseReturnValue(*(undefined8 *)(param_1 + 0x18));
  return IVar1;
}



// Function Stack Size: 0x10 bytes

void WeChatIdentityHandler::clearContext(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_clearcontext);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar3,0);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  uVar1 = *(undefined8 *)(param_1 + 0x20);
  *(undefined8 *)(param_1 + 0x20) = 0;
  _objc_release(uVar1);
  uVar1 = *(undefined8 *)(param_1 + 0x18);
  *(undefined8 *)(param_1 + 0x18) = 0;
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::loadTokenFromKeychain(ID param_1,SEL param_2)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  long lVar7;
  ID IVar8;
  long local_58;
  
  _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"keychainQuery");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",*(undefined8 *)PTR__kCFBooleanTrue_00040050,
                *(undefined8 *)PTR__kSecReturnData_00040098);
  _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",*(undefined8 *)PTR__kSecMatchLimitOne_00040090,
                *(undefined8 *)PTR__kSecMatchLimit_00040088);
  local_58 = 0;
  iVar1 = _SecItemCopyMatching(uVar2,&local_58);
  if (iVar1 == 0 && local_58 != 0) {
    _objc_msgSend(&_OBJC_CLASS___NSKeyedUnarchiver,"unarchiveObjectWithData:");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(&_OBJC_CLASS___NSData,"class");
    iVar1 = _objc_msgSend(uVar3,"isKindOfClass:",uVar4);
    if ((iVar1 == 0) || (lVar7 = _objc_msgSend(uVar3,"length"), lVar7 == 0)) {
      uVar4 = 0;
    }
    else {
      uVar4 = _objc_msgSend(&_OBJC_CLASS___NSString,"alloc");
      uVar4 = _objc_msgSend(uVar4,"initWithData:encoding:",uVar3,4);
    }
    _objc_release(uVar3);
  }
  else {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_failtoloadKeychainstatus__d_keyDatanull__d);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    uVar4 = 0;
  }
  if (local_58 != 0) {
    _CFRelease();
    local_58 = 0;
  }
  lVar7 = _objc_msgSend(uVar4,"length");
  if (lVar7 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_token____isnull);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar3);
    uVar3 = 0;
  }
  else {
    uVar3 = _objc_retain(uVar4);
  }
  _objc_release(uVar2);
  _objc_release(uVar4);
  IVar8 = _objc_autoreleaseReturnValue(uVar3);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

bool WeChatIdentityHandler::checkContextID_(ID param_1,SEL param_2,ID param_3)

{
  bool bVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  
  uVar2 = _objc_retain(param_3);
  lVar3 = _objc_msgSend(uVar2,"length");
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_cidisnil);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
  }
  else {
    if ((*(long *)(param_1 + 0x18) != 0) &&
       (lVar3 = _objc_msgSend(*(undefined8 *)(param_1 + 0x20),"length"), lVar3 != 0)) {
      bVar1 = _objc_msgSend(*(undefined8 *)(param_1 + 0x20),"isEqualToString:",uVar2);
      goto LAB_00025738;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appnocontext_req_____cid____);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
  }
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar4);
  bVar1 = 0;
LAB_00025738:
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x28 bytes

bool WeChatIdentityHandler::checkAndRecordTokenToKeychain_contextID_error_
               (ID param_1,SEL param_2,ID param_3,ID param_4,ID *param_5)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  ID IVar12;
  bool bVar13;
  
  uVar2 = _objc_retain(param_3);
  uVar3 = _objc_retain(param_4);
  if ((*(long *)(param_1 + 0x18) == 0) ||
     (lVar4 = _objc_msgSend(*(undefined8 *)(param_1 + 0x20),"length"), lVar4 == 0)) {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_appnocontext_req_____contextID____
                 );
    uVar8 = _objc_retainAutoreleasedReturnValue();
    lVar4 = 3;
  }
  else {
    lVar4 = _objc_msgSend(uVar2,"length");
    if ((lVar4 == 0) || (lVar4 = _objc_msgSend(uVar3,"length"), lVar4 == 0)) {
      _objc_msgSend(&objc::class_t::WeChatApiUtil,"sha256:",uVar2);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxtoken____orcontextId____isnil_
                   );
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar6);
      lVar4 = 4;
    }
    else {
      uVar5 = _objc_msgSend(uVar3,"isEqualToString:",*(undefined8 *)(param_1 + 0x20));
      if ((uVar5 & 1) == 0) {
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_context_______notmatch);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        lVar4 = 5;
      }
      else {
        _objc_msgSend(uVar2,"dataUsingEncoding:",4);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        lVar4 = _objc_msgSend(uVar6,"length");
        if (lVar4 == 0) {
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_converttokentonsdata____lengthis0);
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_release(uVar6);
          lVar4 = 6;
        }
        else {
          _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"keychainQuery");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          iVar1 = _SecItemDelete();
          if (iVar1 != 0) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar8 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_failtodeleteKeychainbeforeaddstatus__d);
            uVar9 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar10 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            uVar11 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar8,"printLog:level:",uVar11,0);
            _objc_release(uVar11);
            _objc_release(uVar10);
            _objc_release(uVar9);
            _objc_release(uVar8);
          }
          _objc_msgSend(&_OBJC_CLASS___NSKeyedArchiver,"archivedDataWithRootObject:",uVar6);
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"wxApi_safeSetObject:forKey:",uVar8,
                        *(undefined8 *)PTR__kSecValueData_000400a0);
          _objc_release(uVar8);
          iVar1 = _SecItemAdd(uVar7,0);
          if (iVar1 == 0) {
            lVar4 = 0;
            uVar8 = 0;
          }
          else {
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_failtoaddKeychainstatus__d
                         );
            uVar8 = _objc_retainAutoreleasedReturnValue();
            lVar4 = 6;
          }
          _objc_release(uVar7);
          _objc_release(uVar6);
          if (lVar4 == 0) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&objc::class_t::WeChatApiUtil,"sha256:",uVar2);
            uVar7 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_tokensha256___);
            uVar9 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            uVar10 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(uVar6,"printLog:level:",uVar10,0);
            _objc_release(uVar10);
            _objc_release(uVar9);
            _objc_release(uVar7);
            _objc_release(uVar6);
            bVar13 = 1;
            goto LAB_00025c10;
          }
        }
      }
    }
  }
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInteger:",lVar4);
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_settokenfail_errCode____errLog___);
  uVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
  uVar10 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar11 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar6,"printLog:level:",uVar11,0);
  _objc_release(uVar11);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar7);
  _objc_release(uVar6);
  if (param_5 == (ID *)0x0) {
    bVar13 = 0;
  }
  else {
    _objc_msgSend(&objc::class_t::WeChatIdentityHandler,"errorWithCode:description:",lVar4,uVar8);
    _objc_retainAutoreleasedReturnValue();
    IVar12 = _objc_autorelease();
    bVar13 = 0;
    *param_5 = IVar12;
  }
LAB_00025c10:
  _objc_release(uVar8);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return bVar13;
}



// Function Stack Size: 0x28 bytes

ID WeChatIdentityHandler::genWeChatUniversalLinkWithExtraUrl_token_contextId_
             (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5)

{
  long lVar1;
  ID IVar2;
  ID IVar3;
  long lVar4;
  ID IVar5;
  ID IVar6;
  ID IVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  
  lVar1 = _objc_retain(param_3);
  IVar2 = _objc_retain(param_4);
  IVar3 = _objc_retain(param_5);
  lVar4 = _objc_msgSend(_s_registerAppID,"length");
  if (lVar4 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_registerappisnil);
    IVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    lVar4 = 0;
    _objc_msgSend(uVar8,"printLog:level:",uVar10,0);
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_https___help_wechat_com_app____);
    IVar5 = _objc_retainAutoreleasedReturnValue();
    IVar6 = IVar5;
    if ((lVar1 != 0) && (lVar4 = _objc_msgSend(lVar1,"length"), lVar4 != 0)) {
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_____);
      IVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_release(IVar5);
    }
    lVar4 = _objc_msgSend(IVar2,"length");
    IVar5 = IVar6;
    if (lVar4 != 0) {
      appendQueryToUrl_key_value_(param_1,(SEL)"appendQueryToUrl:key:value:",IVar6,0x40a50,IVar2);
      IVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_release(IVar6);
    }
    lVar4 = _objc_msgSend(IVar3,"length");
    IVar7 = IVar5;
    if (lVar4 != 0) {
      appendQueryToUrl_key_value_(param_1,(SEL)"appendQueryToUrl:key:value:",IVar5,0x40a70,IVar3);
      IVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_release(IVar5);
    }
    _objc_msgSend(&_OBJC_CLASS___NSBundle,"mainBundle");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"bundleIdentifier");
    IVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar8);
    appendQueryToUrl_key_value_(param_1,(SEL)"appendQueryToUrl:key:value:",IVar7,0x439f0,IVar6);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_release(IVar7);
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",uVar8);
    lVar4 = _objc_retainAutoreleasedReturnValue();
    if (lVar4 != 0) goto LAB_00026264;
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_urlStr___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar12 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar9,"printLog:level:",uVar12,0);
    _objc_release(uVar12);
    _objc_release(uVar11);
  }
  _objc_release(uVar10);
  _objc_release(uVar9);
LAB_00026264:
  _objc_release(IVar6);
  _objc_release(uVar8);
  _objc_release(IVar3);
  _objc_release(IVar2);
  _objc_release(lVar1);
  IVar2 = _objc_autoreleaseReturnValue(lVar4);
  return IVar2;
}



// Function Stack Size: 0x20 bytes

ID WeChatIdentityHandler::genWeChatUrlSchemeUrl_appendBundleID_isDegrade_
             (ID param_1,SEL param_2,ID param_3,bool param_4,bool param_5)

{
  long lVar1;
  long lVar2;
  ID IVar3;
  ID IVar4;
  undefined8 uVar5;
  ID IVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  
  lVar1 = _objc_retain(param_3);
  lVar2 = _objc_msgSend(_s_registerAppID,"length");
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    IVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_registerappisnil);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar4,"printLog:level:",uVar8,0);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar5);
    lVar2 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_weixin___app____);
    IVar3 = _objc_retainAutoreleasedReturnValue();
    IVar4 = IVar3;
    if ((lVar1 != 0) && (lVar2 = _objc_msgSend(lVar1,"length"), lVar2 != 0)) {
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_____);
      IVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_release(IVar3);
    }
    IVar3 = IVar4;
    if (param_4 != 0) {
      _objc_msgSend(&_OBJC_CLASS___NSBundle,"mainBundle");
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar5,"bundleIdentifier");
      IVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar5);
      appendQueryToUrl_key_value_(param_1,(SEL)"appendQueryToUrl:key:value:",IVar4,0x439f0,IVar6);
      IVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release(IVar4);
      _objc_release(IVar6);
    }
    IVar4 = IVar3;
    if (param_5 != 0) {
      appendQueryToUrl_key_value_(param_1,(SEL)"appendQueryToUrl:key:value:",IVar3,0x43a30,0x41930);
      IVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_release(IVar3);
    }
    _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",IVar4);
    lVar2 = _objc_retainAutoreleasedReturnValue();
    if (lVar2 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_urlStr___);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar5,"printLog:level:",uVar9,0);
      _objc_release(uVar9);
      _objc_release(uVar8);
      _objc_release(uVar7);
      _objc_release(uVar5);
    }
  }
  _objc_release(IVar4);
  _objc_release(lVar1);
  IVar4 = _objc_autoreleaseReturnValue(lVar2);
  return IVar4;
}



// Function Stack Size: 0x28 bytes

ID WeChatIdentityHandler::appendQueryToUrl_key_value_
             (ID param_1,SEL param_2,ID param_3,ID param_4,ID param_5)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  long lVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  
  lVar1 = _objc_retain(param_3);
  uVar2 = _objc_retain(param_4);
  uVar3 = _objc_retain(param_5);
  if (lVar1 == 0) {
code_r0x000268d8:
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_urlisnil);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar9,"printLog:level:",uVar6,0);
  }
  else {
    lVar4 = _objc_msgSend(lVar1,"length");
    if (lVar4 == 0) goto code_r0x000268d8;
    lVar4 = _objc_msgSend(uVar2,"length");
    if ((lVar4 != 0) && (lVar4 = _objc_msgSend(uVar3,"length"), lVar4 != 0)) {
      lVar4 = _objc_msgSend(lVar1,"rangeOfString:",&cf__);
      if (lVar4 == 0x7fffffffffffffff) {
        _objc_msgSend(lVar1,"stringByAppendingString:",&cf__);
        lVar4 = _objc_retainAutoreleasedReturnValue();
        _objc_release(lVar1);
      }
      else {
        _objc_msgSend(&_OBJC_CLASS___NSURL,"URLWithString:",lVar1);
        uVar9 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar9,"query");
        uVar10 = _objc_retainAutoreleasedReturnValue();
        lVar8 = _objc_msgSend(uVar10,"length");
        lVar4 = lVar1;
        if (lVar8 != 0) {
          _objc_msgSend(lVar1,"stringByAppendingString:",&cf__);
          lVar4 = _objc_retainAutoreleasedReturnValue();
          _objc_release(lVar1);
        }
        _objc_release(uVar10);
        _objc_release(uVar9);
      }
      _objc_msgSend(uVar3,"wxApi_stringByEscapingForURLArgument");
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar9);
      _objc_msgSend(lVar4,"stringByAppendingString:",uVar10);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_release(lVar4);
      uVar9 = _objc_retain(uVar9);
      _objc_release(uVar10);
      goto LAB_00026a68;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_key____orvalue____invaild);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar9,"printLog:level:",uVar6,0);
  }
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar10);
  _objc_release(uVar9);
  uVar9 = _objc_retain(lVar1);
LAB_00026a68:
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar9);
  IVar7 = _objc_autoreleaseReturnValue(uVar9);
  return IVar7;
}



// Function Stack Size: 0x20 bytes

ID WeChatIdentityHandler::errorWithCode_description_
             (ID param_1,SEL param_2,long_long param_3,ID param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  ID IVar5;
  
  uVar1 = _objc_retain(param_4);
  uVar2 = _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"alloc");
  uVar2 = _objc_msgSend(uVar2,"init");
  lVar3 = _objc_msgSend(uVar1,"length");
  if (lVar3 != 0) {
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar1,
                  *(undefined8 *)PTR__NSLocalizedDescriptionKey_00040008);
  }
  uVar4 = _objc_msgSend(&_OBJC_CLASS___NSError,"alloc");
  uVar4 = _objc_msgSend(uVar4,"initWithDomain:code:userInfo:",&cf_WXOpenSDKRefreshTokenError,param_3
                        ,uVar2);
  _objc_release(uVar2);
  _objc_release(uVar1);
  IVar5 = _objc_autoreleaseReturnValue(uVar4);
  return IVar5;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::keychainQuery(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  ID IVar4;
  
  _objc_msgSend(&_OBJC_CLASS___NSBundle,"mainBundle");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"bundleIdentifier");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf______);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionaryWithObjectsAndKeys:",
                *(undefined8 *)PTR__kSecClassGenericPassword_00040080);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  _objc_release(uVar2);
  IVar4 = _objc_autoreleaseReturnValue(uVar3);
  return IVar4;
}



// Function Stack Size: 0x10 bytes

bool WeChatIdentityHandler::universalLinkCheckEnable(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WeChatIdentityHandler::setUniversalLinkCheckEnable_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::checkCompletion(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WeChatIdentityHandler::setCheckCompletion_
               (ID param_1,SEL param_2,ID param_3,undefined4 param_4)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::contextReq(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void WeChatIdentityHandler::setContextReq_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WeChatIdentityHandler::contextID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WeChatIdentityHandler::setContextID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WeChatIdentityHandler::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x20 bytes

ID WXApi::genExtraUrlByReq_withAppData_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  ID IVar2;
  ID IVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ulong uVar6;
  
  IVar2 = _objc_retain(param_3);
  IVar3 = _objc_retain(param_4);
  uVar4 = _objc_msgSend(&objc::class_t::SendAuthReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  if (iVar1 == 0) {
    uVar4 = 0;
  }
  else {
    genAuthReqExtraUrl_appData_(param_1,(SEL)"genAuthReqExtraUrl:appData:",IVar2,IVar3);
    uVar4 = _objc_retainAutoreleasedReturnValue();
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXLaunchWxaRedirectingPageReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genLaunchWxaRedirectingPageReq_(param_1,(SEL)"genLaunchWxaRedirectingPageReq:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::PayReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genPayReqExtraUrl_(param_1,(SEL)"genPayReqExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXJointPayReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genJointPayReqExtraUrl_(param_1,(SEL)"genJointPayReqExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXOfflinePayReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genOffileOfflinePayReqExtraUrl_(param_1,(SEL)"genOffileOfflinePayReqExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXNontaxPayReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genNontaxPayReqExtraUrl_(param_1,(SEL)"genNontaxPayReqExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXPayInsuranceReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genPayInsuranceReqExtraUrl_(param_1,(SEL)"genPayInsuranceReqExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::AddCardToWXCardPackageReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genAddCardToWXCardPackageReqExtraUrl_
              (param_1,(SEL)"genAddCardToWXCardPackageReqExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXChooseCardReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genChooseCardReqExtraUrl_(param_1,(SEL)"genChooseCardReqExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXChooseInvoiceReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genChooseInvoiceReqExtraUrl_(param_1,(SEL)"genChooseInvoiceReqExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::OpenWebviewReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genOpenWebviewExtralUrl_(param_1,(SEL)"genOpenWebviewExtralUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXOpenBusinessWebViewReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genOpenBusinessWebviewExtraUrl_(param_1,(SEL)"genOpenBusinessWebviewExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::OpenRankListReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genOpenRankListExtraUrl_(param_1,(SEL)"genOpenRankListExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::CreateChatRoomReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genCreateChatRoomExtraUrl_(param_1,(SEL)"genCreateChatRoomExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::JoinChatRoomReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genJoinChatRoomExtraUrl_(param_1,(SEL)"genJoinChatRoomExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXHandleScanResultReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genHandleScanResultExtraUrl_(param_1,(SEL)"genHandleScanResultExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXSubscribeMsgReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    gensubscribeMsg_(param_1,(SEL)"gensubscribeMsg:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXLaunchMiniProgramReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genLaunchMiniProgramExtraUrl_appData_
              (param_1,(SEL)"genLaunchMiniProgramExtraUrl:appData:",IVar2,IVar3);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXInvoiceAuthInsertReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genInvoiceAuthInsertReqExtraUrl_(param_1,(SEL)"genInvoiceAuthInsertReqExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXSubscribeMiniProgramMsgReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genHandleSubscribeMiniProgramMsgReqExtraUrl_
              (param_1,(SEL)"genHandleSubscribeMiniProgramMsgReqExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXOpenBusinessViewReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genOpenBusinessViewExtraUrl_(param_1,(SEL)"genOpenBusinessViewExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::SendMessageToWXReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genSendMessageToWXReqExtraUrl_appData_
              (param_1,(SEL)"genSendMessageToWXReqExtraUrl:appData:",IVar2,IVar3);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXChannelShareVideoReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genFinderShareVideoExtraUrl_(param_1,(SEL)"genFinderShareVideoExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXChannelOpenProfileReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genFinderOpenProfileExtraUrl_(param_1,(SEL)"genFinderOpenProfileExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXChannelOpenLiveReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if (iVar1 != 0) {
    genFinderOpenLiveExtraUrl_(param_1,(SEL)"genFinderOpenLiveExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  uVar5 = _objc_msgSend(&objc::class_t::WXChannelOpenFeedReq,"class");
  iVar1 = _objc_msgSend(IVar2,"isKindOfClass:",uVar5);
  uVar5 = uVar4;
  if (iVar1 != 0) {
    genFinderOpenFeedExtraUrl_(param_1,(SEL)"genFinderOpenFeedExtraUrl:",IVar2);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  uVar4 = _objc_msgSend(&objc::class_t::WXOpenCustomerServiceReq,"class");
  uVar6 = _objc_msgSend(IVar2,"isKindOfClass:",uVar4);
  uVar4 = uVar5;
  if ((uVar6 & 1) != 0) {
    genOpenCustomerServiceExtraUrl_(param_1,(SEL)"genOpenCustomerServiceExtraUrl:",IVar2);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
  }
  _objc_release(IVar3);
  _objc_release(IVar2);
  IVar2 = _objc_autoreleaseReturnValue(uVar4);
  return IVar2;
}



// Function Stack Size: 0x20 bytes

ID WXApi::genAuthReqExtraUrl_appData_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  long lVar2;
  long lVar3;
  cfstringStruct *pcVar4;
  long lVar5;
  undefined8 uVar6;
  cfstringStruct *pcVar7;
  ID IVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  
  lVar2 = _objc_retain(param_3);
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    pcVar4 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    pcVar7 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar3,"printLog:level:",uVar6,0);
LAB_00027a8c:
    uVar9 = 0;
  }
  else {
    _objc_msgSend(lVar2,"scope");
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar2,"state");
    pcVar4 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    if (lVar3 == 0) {
code_r0x0002791c:
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      pcVar7 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_scopeinvaild);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(pcVar7,"printLog:level:",uVar10,0);
      _objc_release(uVar10);
      _objc_release(uVar9);
      goto LAB_00027a8c;
    }
    lVar5 = _objc_msgSend(lVar3,"length");
    if (lVar5 == 0) goto code_r0x0002791c;
    if (pcVar4 == (cfstringStruct *)0x0) {
      _objc_release(0);
      pcVar4 = &cf___;
    }
    uVar6 = _objc_msgSend(&objc::class_t::SendTdiAuthReq,"class");
    iVar1 = _objc_msgSend(lVar2,"isKindOfClass:",uVar6);
    if (iVar1 == 0) {
      pcVar7 = &cf___;
    }
    else {
      _objc_msgSend(lVar2,"tdiExtInfo");
      pcVar7 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    }
    _objc_msgSend(lVar3,"wxApi_stringByEscapingForURLArgument");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(pcVar4,"wxApi_stringByEscapingForURLArgument");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_auth__scope____state___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar10);
    _objc_release(uVar9);
    lVar5 = _objc_msgSend(pcVar7,"length");
    uVar9 = uVar6;
    if (lVar5 == 0) goto LAB_00027a98;
    _objc_msgSend(uVar6,"stringByAppendingFormat:",&cf__tdi_ext_info___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(uVar6);
LAB_00027a98:
  _objc_release(pcVar7);
  _objc_release(pcVar4);
  _objc_release(lVar3);
  _objc_release(lVar2);
  IVar8 = _objc_autoreleaseReturnValue(uVar9);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genLaunchWxaRedirectingPageReq_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  ID IVar7;
  
  if (param_3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar3);
  }
  else {
    _objc_msgSend(param_3,"ticket");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    lVar2 = _objc_msgSend(uVar1,"length");
    if (lVar2 != 0) {
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_launchwxaredirectingpage__ticket___);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      goto LAB_00027dac;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_ticketinvalid);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar3);
  }
  _objc_release(uVar4);
  uVar3 = 0;
LAB_00027dac:
  _objc_release(uVar1);
  IVar7 = _objc_autoreleaseReturnValue(uVar3);
  return IVar7;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genPayReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  long lVar3;
  long lVar4;
  long lVar5;
  long lVar6;
  long lVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  ID IVar14;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    lVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    lVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar2,"printLog:level:",lVar5,0);
    uVar13 = 0;
    goto LAB_000283c8;
  }
  _objc_msgSend(lVar1,"package");
  lVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"partnerId");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"prepayId");
  lVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"sign");
  lVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"nonceStr");
  lVar6 = _objc_retainAutoreleasedReturnValue();
  if (lVar2 == 0) {
code_r0x00027fe8:
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_packageisnil);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_0002837c:
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"printLog:level:",uVar11,0);
    uVar13 = 0;
  }
  else {
    lVar7 = _objc_msgSend(lVar2,"length");
    if (lVar7 == 0) goto code_r0x00027fe8;
    if ((lVar3 == 0) || (lVar7 = _objc_msgSend(lVar3,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_partnerIdisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0002837c;
    }
    if ((lVar4 == 0) || (lVar7 = _objc_msgSend(lVar4,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_prepayIdisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0002837c;
    }
    if ((lVar5 == 0) || (lVar7 = _objc_msgSend(lVar5,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_signisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0002837c;
    }
    if ((lVar6 == 0) || (lVar7 = _objc_msgSend(lVar6,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_nonceStrisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_0002837c;
    }
    _objc_msgSend(lVar6,"wxApi_stringByEscapingForURLArgument");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar2,"wxApi_stringByEscapingForURLArgument");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar3,"wxApi_stringByEscapingForURLArgument");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar4,"wxApi_stringByEscapingForURLArgument");
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar1,"timeStamp");
    _objc_msgSend(lVar5,"wxApi_stringByEscapingForURLArgument");
    uVar12 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &
                  cf_pay__nonceStr____package____partnerId____prepayId____timeStamp__u_sign____signType___
                 );
    uVar13 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar12);
  }
  _objc_release(uVar11);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(lVar6);
LAB_000283c8:
  _objc_release(lVar5);
  _objc_release(lVar4);
  _objc_release(lVar3);
  _objc_release(lVar2);
  _objc_release(lVar1);
  IVar14 = _objc_autoreleaseReturnValue(uVar13);
  return IVar14;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genJointPayReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  long lVar3;
  long lVar4;
  long lVar5;
  long lVar6;
  long lVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  ID IVar14;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    lVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    lVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    lVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    lVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar2,"printLog:level:",lVar5,0);
    uVar13 = 0;
    goto LAB_00028a0c;
  }
  _objc_msgSend(lVar1,"package");
  lVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"partnerId");
  lVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"prepayId");
  lVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"sign");
  lVar5 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(lVar1,"nonceStr");
  lVar6 = _objc_retainAutoreleasedReturnValue();
  if (lVar2 == 0) {
code_r0x0002862c:
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_packageisnil);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_000289c0:
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar8,"printLog:level:",uVar11,0);
    uVar13 = 0;
  }
  else {
    lVar7 = _objc_msgSend(lVar2,"length");
    if (lVar7 == 0) goto code_r0x0002862c;
    if ((lVar3 == 0) || (lVar7 = _objc_msgSend(lVar3,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_partnerIdisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_000289c0;
    }
    if ((lVar4 == 0) || (lVar7 = _objc_msgSend(lVar4,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_prepayIdisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_000289c0;
    }
    if ((lVar5 == 0) || (lVar7 = _objc_msgSend(lVar5,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_signisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_000289c0;
    }
    if ((lVar6 == 0) || (lVar7 = _objc_msgSend(lVar6,"length"), lVar7 == 0)) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_nonceStrisnil);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      goto LAB_000289c0;
    }
    _objc_msgSend(lVar6,"wxApi_stringByEscapingForURLArgument");
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar2,"wxApi_stringByEscapingForURLArgument");
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar3,"wxApi_stringByEscapingForURLArgument");
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar4,"wxApi_stringByEscapingForURLArgument");
    uVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar1,"timeStamp");
    _objc_msgSend(lVar5,"wxApi_stringByEscapingForURLArgument");
    uVar12 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &
                  cf_jointpay__nonceStr____package____partnerId____prepayId____timeStamp__u_sign____signType___
                 );
    uVar13 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar12);
  }
  _objc_release(uVar11);
  _objc_release(uVar10);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(lVar6);
LAB_00028a0c:
  _objc_release(lVar5);
  _objc_release(lVar4);
  _objc_release(lVar3);
  _objc_release(lVar2);
  _objc_release(lVar1);
  IVar14 = _objc_autoreleaseReturnValue(uVar13);
  return IVar14;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genOffileOfflinePayReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  
  if (param_3 != 0) {
    return 0x43c90;
  }
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar4,0);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  return 0;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genNontaxPayReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"urlString");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_urlstringisnull);
    IVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    uVar4 = 0;
  }
  else {
    _objc_msgSend(uVar1,"urlString");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"wxApi_stringByEncodeUrl");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_url___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
    _objc_release(uVar4);
    uVar4 = _objc_msgSend(&objc::class_t::WXOpenTypeWebViewReq,"alloc");
    IVar6 = _objc_msgSend(uVar4,"init");
    _objc_msgSend(IVar6,"setType:",3);
    _objc_msgSend(uVar2,"wxApi_stringByEncodeUrl");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar6,"setQuery:",uVar4);
    _objc_release(uVar4);
    genOpenTypeWebViewExtraUrl_(param_1,(SEL)"genOpenTypeWebViewExtraUrl:",IVar6);
    uVar4 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(IVar6);
  _objc_release(uVar2);
  _objc_release(uVar1);
  IVar6 = _objc_autoreleaseReturnValue(uVar4);
  return IVar6;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genPayInsuranceReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"urlString");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_urlstringisnull);
    IVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    uVar4 = 0;
  }
  else {
    _objc_msgSend(uVar1,"urlString");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"wxApi_stringByEncodeUrl");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_url___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
    _objc_release(uVar4);
    uVar4 = _objc_msgSend(&objc::class_t::WXOpenTypeWebViewReq,"alloc");
    IVar6 = _objc_msgSend(uVar4,"init");
    _objc_msgSend(IVar6,"setType:",4);
    _objc_msgSend(uVar2,"wxApi_stringByEncodeUrl");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar6,"setQuery:",uVar4);
    _objc_release(uVar4);
    genOpenTypeWebViewExtraUrl_(param_1,(SEL)"genOpenTypeWebViewExtraUrl:",IVar6);
    uVar4 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(IVar6);
  _objc_release(uVar2);
  _objc_release(uVar1);
  IVar6 = _objc_autoreleaseReturnValue(uVar4);
  return IVar6;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genOpenWebviewExtralUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined *puVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar6,0);
  }
  else {
    _objc_msgSend(lVar1,"url");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    puVar3 = (undefined *)_objc_msgSend(uVar2,"length");
    _objc_release(uVar2);
    if (puVar3 < &UNK_00002801) {
      _objc_msgSend(lVar1,"url");
      uVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar4,"wxApi_stringByEncodeUrl");
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_openwebview__url___);
      uVar2 = _objc_retainAutoreleasedReturnValue();
      goto LAB_000292ac;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",&DAT_00002800);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_urllengthoverlimit____);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
  }
  _objc_release(uVar6);
  _objc_release(uVar2);
  uVar2 = 0;
LAB_000292ac:
  _objc_release(uVar5);
  _objc_release(uVar4);
  _objc_release(lVar1);
  IVar8 = _objc_autoreleaseReturnValue(uVar2);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genOpenBusinessWebviewExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar3);
    uVar3 = 0;
    goto LAB_00029574;
  }
  _objc_msgSend(lVar1,"queryInfoDic");
  lVar2 = _objc_retainAutoreleasedReturnValue();
  if (lVar2 == 0) {
    uVar5 = 0;
    uVar3 = 0;
LAB_000294e0:
    _objc_release(uVar3);
  }
  else {
    _objc_msgSend(lVar1,"queryInfoDic");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"count");
    _objc_release(uVar3);
    _objc_release(lVar2);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"queryInfoDic");
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"dataWithJSONObject:options:error:",uVar5,1,0
                   );
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar5);
      uVar5 = _objc_msgSend(&_OBJC_CLASS___NSString,"alloc");
      uVar6 = _objc_msgSend(uVar5,"initWithData:encoding:",uVar3,4);
      _objc_msgSend(uVar6,"wxApi_stringByEncodeUrl");
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar6);
      goto LAB_000294e0;
    }
    uVar5 = 0;
  }
  _objc_msgSend(lVar1,"businessType");
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_openbusinesswebview__type__u);
  uVar6 = _objc_retainAutoreleasedReturnValue();
  lVar2 = _objc_msgSend(uVar5,"length");
  uVar3 = uVar6;
  if (lVar2 != 0) {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____query___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar6);
  }
LAB_00029574:
  _objc_release(uVar5);
  _objc_release(lVar1);
  IVar8 = _objc_autoreleaseReturnValue(uVar3);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genOpenRankListExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  
  if (param_3 != 0) {
    return 0x43d70;
  }
  _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"printLog:level:",uVar4,0);
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  return 0;
}



// Function Stack Size: 0x20 bytes

ID WXApi::genLaunchMiniProgramExtraUrl_appData_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  cfstringStruct *pcVar6;
  cfstringStruct *pcVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  ID IVar11;
  
  lVar1 = _objc_retain(param_3);
  uVar2 = _objc_retain(param_4);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    pcVar6 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    pcVar7 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    _objc_msgSend(lVar1,"userName");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      pcVar6 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_userNameinvaild);
      pcVar7 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
    else {
      lVar4 = _objc_msgSend(lVar1,"miniProgramType");
      if (((lVar4 == 2) || (lVar4 = _objc_msgSend(lVar1,"miniProgramType"), lVar4 == 0)) ||
         (lVar4 = _objc_msgSend(lVar1,"miniProgramType"), lVar4 == 1)) {
        _objc_msgSend(lVar1,"userName");
        uVar3 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_jumpWxa__userName___);
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_release(uVar3);
        _objc_msgSend(lVar1,"path");
        uVar3 = _objc_retainAutoreleasedReturnValue();
        lVar4 = _objc_msgSend(uVar3,"length");
        if (lVar4 == 0) {
          pcVar6 = &cf___;
        }
        else {
          _objc_msgSend(lVar1,"path");
          pcVar6 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
        }
        _objc_release(uVar3);
        _objc_msgSend(lVar1,"extMsg");
        uVar3 = _objc_retainAutoreleasedReturnValue();
        lVar4 = _objc_msgSend(uVar3,"length");
        if (lVar4 == 0) {
          pcVar7 = &cf___;
        }
        else {
          _objc_msgSend(lVar1,"extMsg");
          pcVar7 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
        }
        _objc_release(uVar3);
        _objc_msgSend(pcVar6,"wxApi_stringByEscapingForURLArgument");
        uVar3 = _objc_retainAutoreleasedReturnValue();
        uVar8 = _objc_msgSend(lVar1,"miniProgramType");
        _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar8);
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(pcVar7,"wxApi_stringByEscapingForURLArgument");
        uVar9 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &cf____path____miniProgramType____extMsg___);
        uVar10 = _objc_retainAutoreleasedReturnValue();
        _objc_release(uVar5);
        _objc_release(uVar9);
        goto LAB_00029a74;
      }
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      pcVar6 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_miniProgramTypeinvaild);
      pcVar7 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
  }
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(pcVar6,"printLog:level:",uVar8,0);
  uVar10 = 0;
LAB_00029a74:
  _objc_release(uVar8);
  _objc_release(uVar3);
  _objc_release(pcVar7);
  _objc_release(pcVar6);
  _objc_release(uVar2);
  _objc_release(lVar1);
  IVar11 = _objc_autoreleaseReturnValue(uVar10);
  return IVar11;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genOpenBusinessViewExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  long lVar3;
  cfstringStruct *pcVar4;
  cfstringStruct *pcVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  ID IVar9;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    pcVar4 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    pcVar5 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    _objc_msgSend(lVar1,"businessType");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    lVar3 = _objc_msgSend(uVar2,"length");
    _objc_release(uVar2);
    if (lVar3 != 0) {
      _objc_msgSend(lVar1,"query");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      lVar3 = _objc_msgSend(uVar2,"length");
      if (lVar3 == 0) {
        pcVar4 = &cf___;
      }
      else {
        _objc_msgSend(lVar1,"query");
        pcVar4 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
      }
      _objc_release(uVar2);
      _objc_msgSend(lVar1,"extInfo");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      lVar3 = _objc_msgSend(uVar2,"length");
      if (lVar3 == 0) {
        pcVar5 = &cf___;
      }
      else {
        _objc_msgSend(lVar1,"extInfo");
        pcVar5 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
      }
      _objc_release(uVar2);
      _objc_msgSend(lVar1,"businessType");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(pcVar4,"wxApi_stringByEscapingForURLArgument");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(pcVar5,"wxApi_stringByEscapingForURLArgument");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_jumpFakeNativeWxa__businessType____query____extInfo___);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_release(uVar7);
      goto LAB_00029e50;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    pcVar4 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_businessTypeinvaild);
    pcVar5 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  uVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(pcVar4,"printLog:level:",uVar6,0);
  uVar8 = 0;
LAB_00029e50:
  _objc_release(uVar6);
  _objc_release(uVar2);
  _objc_release(pcVar5);
  _objc_release(pcVar4);
  _objc_release(lVar1);
  IVar9 = _objc_autoreleaseReturnValue(uVar8);
  return IVar9;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genCreateChatRoomExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  ulong uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  ID IVar11;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar2);
LAB_0002a480:
    _objc_release(uVar7);
  }
  else {
    _objc_msgSend(lVar1,"groupId");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar3 = _objc_msgSend(uVar2,"length");
    if (uVar3 < 0x401) {
      _objc_msgSend(lVar1,"groupId");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      lVar4 = _objc_msgSend(uVar6,"length");
      _objc_release(uVar6);
      _objc_release(uVar2);
      if (lVar4 != 0) {
        _objc_msgSend(lVar1,"chatRoomName");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        uVar3 = _objc_msgSend(uVar2,"length");
        _objc_release(uVar2);
        if (uVar3 < 0x201) {
          _objc_msgSend(lVar1,"chatRoomNickName");
          uVar2 = _objc_retainAutoreleasedReturnValue();
          uVar3 = _objc_msgSend(uVar2,"length");
          _objc_release(uVar2);
          if (uVar3 < 0x201) {
            _objc_msgSend(lVar1,"extMsg");
            uVar2 = _objc_retainAutoreleasedReturnValue();
            uVar3 = _objc_msgSend(uVar2,"length");
            _objc_release(uVar2);
            if (uVar3 < 0x801) {
              _objc_msgSend(lVar1,"groupId");
              uVar2 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                            &cf_createchatroom__groupid___);
              uVar6 = _objc_retainAutoreleasedReturnValue();
              _objc_release(uVar2);
              _objc_msgSend(lVar1,"chatRoomName");
              uVar2 = _objc_retainAutoreleasedReturnValue();
              lVar4 = _objc_msgSend(uVar2,"length");
              _objc_release(uVar2);
              uVar2 = uVar6;
              if (lVar4 != 0) {
                _objc_msgSend(lVar1,"chatRoomName");
                uVar7 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar7,"wxApi_stringByEscapingForURLArgument");
                uVar5 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____chatroomname___);
                uVar2 = _objc_retainAutoreleasedReturnValue();
                _objc_release(uVar6);
                _objc_release(uVar5);
                _objc_release(uVar7);
              }
              _objc_msgSend(lVar1,"chatRoomNickName");
              uVar6 = _objc_retainAutoreleasedReturnValue();
              lVar4 = _objc_msgSend(uVar6,"length");
              _objc_release(uVar6);
              if (lVar4 != 0) {
                _objc_msgSend(lVar1,"chatRoomNickName");
                uVar6 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar6,"wxApi_stringByEscapingForURLArgument");
                uVar7 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____chatroomnickname___
                             );
                uVar5 = _objc_retainAutoreleasedReturnValue();
                _objc_release(uVar2);
                _objc_release(uVar7);
                _objc_release(uVar6);
                uVar2 = uVar5;
              }
              _objc_msgSend(lVar1,"extMsg");
              uVar6 = _objc_retainAutoreleasedReturnValue();
              lVar4 = _objc_msgSend(uVar6,"length");
              _objc_release(uVar6);
              uVar6 = uVar2;
              if (lVar4 != 0) {
                _objc_msgSend(lVar1,"extMsg");
                uVar7 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____extmsg___);
                uVar6 = _objc_retainAutoreleasedReturnValue();
                _objc_release(uVar2);
                _objc_release(uVar7);
              }
              goto LAB_0002a490;
            }
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar5 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",0x800);
            uVar7 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_extMsglengthoverlimit____)
            ;
            uVar2 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          }
          else {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar5 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",0x200);
            uVar7 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                          &cf_chatRoomNickNamelengthoverlimit____);
            uVar2 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
          }
        }
        else {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar5 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",0x200);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_chatRoomNamelengthoverlimit____);
          uVar2 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        }
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar5,"printLog:level:",uVar8,0);
        _objc_release(uVar8);
        _objc_release(uVar6);
        _objc_release(uVar2);
        goto LAB_0002a480;
      }
    }
    else {
      _objc_release(uVar2);
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar1,"groupId");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(uVar2,"length");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar6);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",0x400);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_groupId_length____invaild_limitlength____);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar10,0);
    _objc_release(uVar10);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar2);
  }
  _objc_release(uVar5);
  uVar6 = 0;
LAB_0002a490:
  _objc_release(lVar1);
  IVar11 = _objc_autoreleaseReturnValue(uVar6);
  return IVar11;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genJoinChatRoomExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  ulong uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  ID IVar11;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar2);
LAB_0002abe8:
    _objc_release(uVar7);
  }
  else {
    _objc_msgSend(lVar1,"groupId");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar3 = _objc_msgSend(uVar2,"length");
    if (uVar3 < 0x401) {
      _objc_msgSend(lVar1,"groupId");
      uVar6 = _objc_retainAutoreleasedReturnValue();
      lVar4 = _objc_msgSend(uVar6,"length");
      _objc_release(uVar6);
      _objc_release(uVar2);
      if (lVar4 != 0) {
        _objc_msgSend(lVar1,"chatRoomNickName");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        uVar3 = _objc_msgSend(uVar2,"length");
        _objc_release(uVar2);
        if (uVar3 < 0x401) {
          _objc_msgSend(lVar1,"extMsg");
          uVar2 = _objc_retainAutoreleasedReturnValue();
          uVar3 = _objc_msgSend(uVar2,"length");
          _objc_release(uVar2);
          if (uVar3 < 0x801) {
            _objc_msgSend(lVar1,"groupId");
            uVar2 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_joinchatroom__groupid___);
            uVar6 = _objc_retainAutoreleasedReturnValue();
            _objc_release(uVar2);
            _objc_msgSend(lVar1,"chatRoomNickName");
            uVar2 = _objc_retainAutoreleasedReturnValue();
            lVar4 = _objc_msgSend(uVar2,"length");
            _objc_release(uVar2);
            uVar2 = uVar6;
            if (lVar4 != 0) {
              _objc_msgSend(lVar1,"chatRoomNickName");
              uVar7 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(uVar7,"wxApi_stringByEscapingForURLArgument");
              uVar5 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____chatroomnickname___);
              uVar2 = _objc_retainAutoreleasedReturnValue();
              _objc_release(uVar6);
              _objc_release(uVar5);
              _objc_release(uVar7);
            }
            _objc_msgSend(lVar1,"extMsg");
            uVar6 = _objc_retainAutoreleasedReturnValue();
            lVar4 = _objc_msgSend(uVar6,"length");
            _objc_release(uVar6);
            uVar6 = uVar2;
            if (lVar4 != 0) {
              _objc_msgSend(lVar1,"extMsg");
              uVar7 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____extmsg___);
              uVar6 = _objc_retainAutoreleasedReturnValue();
              _objc_release(uVar2);
              _objc_release(uVar7);
            }
            goto LAB_0002abf8;
          }
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar5 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",0x800);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_extMsglengthoverlimit____);
          uVar2 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        }
        else {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar5 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",0x200);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_chatRoomNickNamelengthoverlimit____);
          uVar2 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar6 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
        }
        uVar8 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(uVar5,"printLog:level:",uVar8,0);
        _objc_release(uVar8);
        _objc_release(uVar6);
        _objc_release(uVar2);
        goto LAB_0002abe8;
      }
    }
    else {
      _objc_release(uVar2);
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar1,"groupId");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_msgSend(uVar2,"length");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInteger:",uVar6);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",0x400);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_groupId_length____invaild_limitlength____);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar9 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar10 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"printLog:level:",uVar10,0);
    _objc_release(uVar10);
    _objc_release(uVar9);
    _objc_release(uVar8);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar2);
  }
  _objc_release(uVar5);
  uVar6 = 0;
LAB_0002abf8:
  _objc_release(lVar1);
  IVar11 = _objc_autoreleaseReturnValue(uVar6);
  return IVar11;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genAddCardToWXCardPackageReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  ulong uVar3;
  long lVar4;
  ulong uVar5;
  long lVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  ID IVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  ulong local_160;
  undefined8 local_130;
  long lStack_128;
  long *local_120;
  undefined8 uStack_118;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined8 uStack_100;
  undefined8 uStack_f8;
  undefined auStack_f0 [128];
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00040040;
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    _objc_msgSend(lVar1,"cardAry");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar3 = _objc_msgSend(uVar2,"count");
    if (uVar3 < 0x29) {
      _objc_msgSend(lVar1,"cardAry");
      uVar7 = _objc_retainAutoreleasedReturnValue();
      lVar4 = _objc_msgSend(uVar7,"count");
      _objc_release(uVar7);
      _objc_release(uVar2);
      if (lVar4 != 0) {
        _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        lStack_128 = 0;
        local_130 = 0;
        uStack_118 = 0;
        local_120 = (long *)0x0;
        uStack_108 = 0;
        local_110 = 0;
        uStack_f8 = 0;
        uStack_100 = 0;
        _objc_msgSend(lVar1,"cardAry");
        uVar7 = _objc_retainAutoreleasedReturnValue();
        local_160 = _objc_msgSend(uVar7,"countByEnumeratingWithState:objects:count:",&local_130,
                                  auStack_f0,0x10);
        if (local_160 != 0) {
          lVar4 = *local_120;
          do {
            uVar3 = 0;
            do {
              if (*local_120 != lVar4) {
                _objc_enumerationMutation(uVar7);
              }
              uVar9 = *(undefined8 *)(lStack_128 + uVar3 * 8);
              _objc_msgSend(uVar9,"cardId");
              uVar8 = _objc_retainAutoreleasedReturnValue();
              uVar5 = _objc_msgSend(uVar8,"length");
              if (0x400 < uVar5) {
                _objc_release(uVar8);
code_r0x0002b400:
                _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                uVar8 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_cardidlengthinvaild);
                uVar9 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                uVar12 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_0002b518:
                uVar11 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(uVar8,"printLog:level:",uVar11,0);
                _objc_release(uVar11);
                _objc_release(uVar12);
                uVar12 = 0;
                goto LAB_0002b6ac;
              }
              _objc_msgSend(uVar9,"cardId");
              uVar12 = _objc_retainAutoreleasedReturnValue();
              lVar6 = _objc_msgSend(uVar12,"length");
              _objc_release(uVar12);
              _objc_release(uVar8);
              if (lVar6 == 0) goto code_r0x0002b400;
              _objc_msgSend(uVar9,"extMsg");
              uVar8 = _objc_retainAutoreleasedReturnValue();
              uVar5 = _objc_msgSend(uVar8,"length");
              _objc_release(uVar8);
              if (0x800 < uVar5) {
                _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
                uVar8 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_extMsginvaild);
                uVar9 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
                uVar12 = _objc_retainAutoreleasedReturnValue();
                _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
                goto LAB_0002b518;
              }
              _objc_msgSend(uVar9,"extMsg");
              uVar8 = _objc_retainAutoreleasedReturnValue();
              lVar6 = _objc_msgSend(uVar8,"length");
              _objc_release(uVar8);
              if (lVar6 == 0) {
                _objc_msgSend(uVar9,"setExtMsg:",&cf___);
              }
              _objc_msgSend(uVar9,"cardId");
              uVar8 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_id_d);
              uVar12 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(uVar2,"setValue:forKey:",uVar8,uVar12);
              _objc_release(uVar12);
              _objc_release(uVar8);
              _objc_msgSend(uVar9,"extMsg");
              uVar8 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_ext_d);
              uVar9 = _objc_retainAutoreleasedReturnValue();
              _objc_msgSend(uVar2,"setValue:forKey:",uVar8,uVar9);
              _objc_release(uVar9);
              _objc_release(uVar8);
              uVar3 = uVar3 + 1;
            } while (uVar3 < local_160);
            local_160 = _objc_msgSend(uVar7,"countByEnumeratingWithState:objects:count:",&local_130,
                                      auStack_f0,0x10);
          } while (local_160 != 0);
        }
        _objc_release(uVar7);
        lVar4 = _objc_msgSend(uVar2,"count");
        if (lVar4 == 0) {
          _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
          uVar7 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_dictisempty);
          uVar8 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
          uVar9 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
LAB_0002b680:
          uVar12 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar7,"printLog:level:",uVar12,0);
          _objc_release(uVar12);
          uVar12 = 0;
        }
        else {
          uVar3 = _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"isValidJSONObject:",uVar2);
          if ((uVar3 & 1) == 0) {
            _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
            uVar7 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_jsoninvaild);
            uVar8 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
            uVar9 = _objc_retainAutoreleasedReturnValue();
            _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
            goto LAB_0002b680;
          }
          _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"dataWithJSONObject:options:error:",uVar2
                        ,1,0);
          uVar7 = _objc_retainAutoreleasedReturnValue();
          uVar8 = _objc_msgSend(&_OBJC_CLASS___NSString,"alloc");
          uVar8 = _objc_msgSend(uVar8,"initWithData:encoding:",uVar7,4);
          _objc_msgSend(&_OBJC_CLASS___NSMutableString,"stringWithFormat:",&cf_cardpackage____);
          uVar9 = _objc_retainAutoreleasedReturnValue();
          _objc_msgSend(uVar9,"stringByAddingPercentEscapesUsingEncoding:",4);
          uVar12 = _objc_retainAutoreleasedReturnValue();
        }
LAB_0002b6ac:
        _objc_release(uVar9);
        _objc_release(uVar8);
        _objc_release(uVar7);
        _objc_release(uVar2);
        goto LAB_0002b3b0;
      }
    }
    else {
      _objc_release(uVar2);
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_cardarycountinvaild);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  uVar9 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar9,0);
  _objc_release(uVar9);
  _objc_release(uVar8);
  _objc_release(uVar7);
  _objc_release(uVar2);
  uVar12 = 0;
LAB_0002b3b0:
  _objc_release(lVar1);
  if (*(long *)PTR____stack_chk_guard_00040040 == local_70) {
    IVar10 = _objc_autoreleaseReturnValue(uVar12);
    return IVar10;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x18 bytes

ID WXApi::genChooseCardReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  ID IVar9;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar1,"appID");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"appID");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_appID);
      _objc_release(uVar3);
    }
    uVar3 = _objc_msgSend(lVar1,"shopID");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",uVar3);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_shopID);
    _objc_release(uVar3);
    uVar3 = _objc_msgSend(lVar1,"canMultiSelect");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",uVar3);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_canMultiSelect);
    _objc_release(uVar3);
    _objc_msgSend(lVar1,"cardType");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"cardType");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_cardType);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"cardTpID");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"cardTpID");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_cardTpID);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"signType");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"signType");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_signType);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"cardSign");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"cardSign");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_cardSign);
      _objc_release(uVar3);
    }
    uVar3 = _objc_msgSend(lVar1,"timeStamp");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",uVar3);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_timeStamp);
    _objc_release(uVar3);
    _objc_msgSend(lVar1,"nonceStr");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"nonceStr");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_nonceStr);
      _objc_release(uVar3);
    }
    uVar5 = _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"isValidJSONObject:",uVar2);
    if ((uVar5 & 1) != 0) {
      _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"dataWithJSONObject:options:error:",uVar2,1,0
                   );
      uVar3 = _objc_retainAutoreleasedReturnValue();
      uVar6 = _objc_msgSend(&_OBJC_CLASS___NSString,"alloc");
      uVar6 = _objc_msgSend(uVar6,"initWithData:encoding:",uVar3,4);
      _objc_msgSend(&_OBJC_CLASS___NSMutableString,"stringWithFormat:",&cf_choosecard____);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar7,"stringByAddingPercentEscapesUsingEncoding:",4);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      goto LAB_0002bd08;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_jsoninvaild);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar8,0);
    _objc_release(uVar8);
  }
  uVar8 = 0;
LAB_0002bd08:
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(lVar1);
  IVar9 = _objc_autoreleaseReturnValue(uVar8);
  return IVar9;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genChooseInvoiceReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  ID IVar9;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_reqisnil_);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSMutableDictionary,"dictionary");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(lVar1,"appID");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"appID");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_appID);
      _objc_release(uVar3);
    }
    uVar3 = _objc_msgSend(lVar1,"shopID");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",uVar3);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_shopID);
    _objc_release(uVar3);
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",1);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_canMultiSelect);
    _objc_release(uVar3);
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",&cf_INVOICE,&cf_cardType);
    _objc_msgSend(lVar1,"signType");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"signType");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_signType);
      _objc_release(uVar3);
    }
    _objc_msgSend(lVar1,"cardSign");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"cardSign");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_cardSign);
      _objc_release(uVar3);
    }
    uVar3 = _objc_msgSend(lVar1,"timeStamp");
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithUnsignedInt:",uVar3);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_timeStamp);
    _objc_release(uVar3);
    _objc_msgSend(lVar1,"nonceStr");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 != 0) {
      _objc_msgSend(lVar1,"nonceStr");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar2,"wxApi_safeSetObject:forKey:",uVar3,&cf_nonceStr);
      _objc_release(uVar3);
    }
    uVar5 = _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"isValidJSONObject:",uVar2);
    if ((uVar5 & 1) != 0) {
      _objc_msgSend(&_OBJC_CLASS___NSJSONSerialization,"dataWithJSONObject:options:error:",uVar2,1,0
                   );
      uVar3 = _objc_retainAutoreleasedReturnValue();
      uVar6 = _objc_msgSend(&_OBJC_CLASS___NSString,"alloc");
      uVar6 = _objc_msgSend(uVar6,"initWithData:encoding:",uVar3,4);
      _objc_msgSend(&_OBJC_CLASS___NSMutableString,"stringWithFormat:",&cf_chooseinvoice____);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(uVar7,"stringByAddingPercentEscapesUsingEncoding:",4);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      goto LAB_0002c2b4;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_jsoninvaild);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar8,0);
    _objc_release(uVar8);
  }
  uVar8 = 0;
LAB_0002c2b4:
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(lVar1);
  IVar9 = _objc_autoreleaseReturnValue(uVar8);
  return IVar9;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genHandleScanResultExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  ID IVar5;
  cfstringStruct *pcVar6;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"scanResult");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  pcVar6 = &cf_handlescanresult_;
  if (lVar3 != 0) {
    _objc_msgSend(uVar1,"scanResult");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"wxApi_stringByEscapingForURLArgument");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar2);
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____result___);
    pcVar6 = (cfstringStruct *)_objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
  }
  _objc_release(uVar1);
  IVar5 = _objc_autoreleaseReturnValue(pcVar6);
  return IVar5;
}



// Function Stack Size: 0x18 bytes

ID WXApi::gensubscribeMsg_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined *puVar3;
  ID IVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"templateId");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  puVar3 = (undefined *)_objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (puVar3 < &UNK_00002801) {
    _objc_msgSend(uVar1,"scene");
    _objc_msgSend(uVar1,"templateId");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"reserved");
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_scene__d_template_id____reserved___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar7,"wxApi_stringByEncodeUrl");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    uVar5 = _objc_msgSend(&objc::class_t::WXOpenTypeWebViewReq,"alloc");
    IVar4 = _objc_msgSend(uVar5,"init");
    _objc_msgSend(IVar4,"setType:",1);
    _objc_msgSend(IVar4,"setQuery:",uVar2);
    genOpenTypeWebViewExtraUrl_(param_1,(SEL)"genOpenTypeWebViewExtraUrl:",IVar4);
    uVar5 = _objc_retainAutoreleasedReturnValue();
  }
  else {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSNumber,"numberWithInt:",&DAT_00002800);
    IVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_templateIdlengthoverlimit____);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    uVar5 = 0;
  }
  _objc_release(IVar4);
  _objc_release(uVar2);
  _objc_release(uVar1);
  IVar4 = _objc_autoreleaseReturnValue(uVar5);
  return IVar4;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genInvoiceAuthInsertReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"urlString");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_urlstringisnull);
    IVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    uVar4 = 0;
  }
  else {
    _objc_msgSend(uVar1,"urlString");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar4,"wxApi_stringByEncodeUrl");
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_url___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar5);
    _objc_release(uVar4);
    uVar4 = _objc_msgSend(&objc::class_t::WXOpenTypeWebViewReq,"alloc");
    IVar6 = _objc_msgSend(uVar4,"init");
    _objc_msgSend(IVar6,"setType:",2);
    _objc_msgSend(uVar2,"wxApi_stringByEncodeUrl");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar6,"setQuery:",uVar4);
    _objc_release(uVar4);
    genOpenTypeWebViewExtraUrl_(param_1,(SEL)"genOpenTypeWebViewExtraUrl:",IVar6);
    uVar4 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(IVar6);
  _objc_release(uVar2);
  _objc_release(uVar1);
  IVar6 = _objc_autoreleaseReturnValue(uVar4);
  return IVar6;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genHandleSubscribeMiniProgramMsgReqExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  ID IVar5;
  undefined8 uVar6;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"miniProgramAppid");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_miniprogramappidisnil);
    IVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"printLog:level:",uVar6,0);
    _objc_release(uVar6);
    _objc_release(uVar4);
    uVar4 = 0;
  }
  else {
    _objc_msgSend(uVar1,"miniProgramAppid");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_miniProgramAppid___);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar4);
    uVar4 = _objc_msgSend(&objc::class_t::WXOpenTypeWebViewReq,"alloc");
    IVar5 = _objc_msgSend(uVar4,"init");
    _objc_msgSend(IVar5,"setType:",5);
    _objc_msgSend(uVar2,"wxApi_stringByEncodeUrl");
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(IVar5,"setQuery:",uVar4);
    _objc_release(uVar4);
    genOpenTypeWebViewExtraUrl_(param_1,(SEL)"genOpenTypeWebViewExtraUrl:",IVar5);
    uVar4 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(IVar5);
  _objc_release(uVar2);
  _objc_release(uVar1);
  IVar5 = _objc_autoreleaseReturnValue(uVar4);
  return IVar5;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genOpenTypeWebViewExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ID IVar3;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"type");
  _objc_msgSend(uVar1,"query");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf____type__d_query___);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  IVar3 = _objc_autoreleaseReturnValue(uVar1);
  return IVar3;
}



// Function Stack Size: 0x20 bytes

ID WXApi::genSendMessageToWXReqExtraUrl_appData_(ID param_1,SEL param_2,ID param_3,ID param_4)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  
  _objc_retain(param_3);
  uVar2 = _objc_retain();
  iVar1 = _objc_msgSend(uVar2,"scene");
  if (iVar1 == 3) {
    _objc_msgSend(uVar2,"openID");
    uVar3 = _objc_retainAutoreleasedReturnValue();
    lVar4 = _objc_msgSend(uVar3,"length");
    _objc_release(uVar3);
    if (lVar4 == 0) {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_sendspecifiedSessionbaseReq_openIdcannotbenull);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
    else {
      _objc_msgSend(uVar2,"toUserOpenId");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      lVar4 = _objc_msgSend(uVar3,"length");
      _objc_release(uVar3);
      if (lVar4 != 0) goto code_r0x0002cc98;
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar3 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_sendspecifiedSessiontoUserOpenIdcannotbenull);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
    uVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"printLog:level:",uVar7,0);
    _objc_release(uVar7);
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar3);
    uVar3 = 0;
  }
  else {
code_r0x0002cc98:
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_sendreq__);
    uVar3 = _objc_retainAutoreleasedReturnValue();
  }
  _objc_release(uVar2);
  _objc_release(uVar2);
  IVar8 = _objc_autoreleaseReturnValue(uVar3);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genFinderShareVideoExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  ID IVar6;
  
  _objc_msgSend(param_3,"localIdentifier");
  uVar1 = _objc_retainAutoreleasedReturnValue();
  lVar2 = _objc_msgSend(uVar1,"length");
  _objc_release(uVar1);
  if (lVar2 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                  &cf_ShareVideo_localIdentifier_length_0);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"printLog:level:",uVar5,0);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    _objc_release(uVar1);
    uVar1 = 0;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_finderShareVideo__);
    uVar1 = _objc_retainAutoreleasedReturnValue();
  }
  IVar6 = _objc_autoreleaseReturnValue(uVar1);
  return IVar6;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genFinderOpenProfileExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  ulong uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"userName");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenProfile_userName_length_0);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    _objc_msgSend(uVar1,"userName");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(uVar2,"length");
    _objc_release(uVar2);
    if (uVar4 < 0x401) {
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_finderOpenProfile__);
      uVar2 = _objc_retainAutoreleasedReturnValue();
      goto LAB_0002d1e0;
    }
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenProfile_userName_length>0);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar2);
  uVar2 = 0;
LAB_0002d1e0:
  _objc_release(uVar1);
  IVar8 = _objc_autoreleaseReturnValue(uVar2);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genFinderOpenLiveExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  ulong uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"feedID");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenLive_feedID_length_0);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    _objc_msgSend(uVar1,"feedID");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(uVar2,"length");
    _objc_release(uVar2);
    if (uVar4 < 0x401) {
      _objc_msgSend(uVar1,"nonceID");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      lVar3 = _objc_msgSend(uVar2,"length");
      _objc_release(uVar2);
      if (lVar3 == 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenLive_nonceID_length_0);
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
      else {
        _objc_msgSend(uVar1,"nonceID");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        uVar4 = _objc_msgSend(uVar2,"length");
        _objc_release(uVar2);
        if (uVar4 < 0x401) {
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_finderOpenLive__);
          uVar2 = _objc_retainAutoreleasedReturnValue();
          goto LAB_0002d594;
        }
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenLive_nonceID_lengthtoolong
                     );
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
    }
    else {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenLive_feedID_lengthtoolong);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
  }
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar2);
  uVar2 = 0;
LAB_0002d594:
  _objc_release(uVar1);
  IVar8 = _objc_autoreleaseReturnValue(uVar2);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genFinderOpenFeedExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  ulong uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"feedID");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenFeed_feedID_length_0);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    _objc_msgSend(uVar1,"feedID");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend(uVar2,"length");
    _objc_release(uVar2);
    if (uVar4 < 0x401) {
      _objc_msgSend(uVar1,"nonceID");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      lVar3 = _objc_msgSend(uVar2,"length");
      _objc_release(uVar2);
      if (lVar3 == 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenFeed_nonceID_length_0);
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
      else {
        _objc_msgSend(uVar1,"nonceID");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        uVar4 = _objc_msgSend(uVar2,"length");
        _objc_release(uVar2);
        if (uVar4 < 0x401) {
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_finderOpenFeed__);
          uVar2 = _objc_retainAutoreleasedReturnValue();
          goto LAB_0002d974;
        }
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenFeed_nonceID_lengthtoolong
                     );
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
    }
    else {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenFeed_feedID_lengthtoolong);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
  }
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar2);
  uVar2 = 0;
LAB_0002d974:
  _objc_release(uVar1);
  IVar8 = _objc_autoreleaseReturnValue(uVar2);
  return IVar8;
}



// Function Stack Size: 0x18 bytes

ID WXApi::genOpenCustomerServiceExtraUrl_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined *puVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  ID IVar8;
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend(uVar1,"url");
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend(uVar2,"length");
  _objc_release(uVar2);
  if (lVar3 == 0) {
    _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenCustomerService_url_length_0);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
  }
  else {
    _objc_msgSend(uVar1,"url");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    puVar4 = (undefined *)_objc_msgSend(uVar2,"length");
    _objc_release(uVar2);
    if (puVar4 < &UNK_00002801) {
      _objc_msgSend(uVar1,"corpid");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      lVar3 = _objc_msgSend(uVar2,"length");
      _objc_release(uVar2);
      if (lVar3 == 0) {
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_OpenFeed_corpid_length_0);
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
      else {
        _objc_msgSend(uVar1,"corpid");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        puVar4 = (undefined *)_objc_msgSend(uVar2,"length");
        _objc_release(uVar2);
        if (puVar4 < &UNK_00002801) {
          _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_customerService__);
          uVar2 = _objc_retainAutoreleasedReturnValue();
          goto LAB_0002dd5c;
        }
        _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
        uVar2 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                      &cf_OpenCustomerService_corpid_lengthtoolong);
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
        uVar6 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
      }
    }
    else {
      _objc_msgSend(&objc::class_t::WXLogUtil,"sharedInstance");
      uVar2 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                    &cf_OpenCustomerService_url_lengthtoolong);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_Error___);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",&cf_wxlog___);
    }
  }
  uVar7 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar2,"printLog:level:",uVar7,0);
  _objc_release(uVar7);
  _objc_release(uVar6);
  _objc_release(uVar5);
  _objc_release(uVar2);
  uVar2 = 0;
LAB_0002dd5c:
  _objc_release(uVar1);
  IVar8 = _objc_autoreleaseReturnValue(uVar2);
  return IVar8;
}



// Function Stack Size: 0x24 bytes

ID WXCheckULStepResult::initWithCheckResult_errorInfo_suggestion_
             (ID param_1,SEL param_2,bool param_3,ID param_4,ID param_5)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ID IVar3;
  ID local_50;
  class_t *pcStack_48;
  
  uVar1 = _objc_retain(param_4);
  uVar2 = _objc_retain(param_5);
  pcStack_48 = &objc::class_t::WXCheckULStepResult;
  local_50 = param_1;
  IVar3 = _objc_msgSendSuper2(&local_50,"init");
  if (IVar3 != 0) {
    *(char *)(IVar3 + 8) = (char)param_3;
    _objc_storeStrong(IVar3 + 0x10,param_4);
    _objc_storeStrong(IVar3 + 0x18,param_5);
  }
  _objc_release(uVar2);
  _objc_release(uVar1);
  return IVar3;
}



// Function Stack Size: 0x10 bytes

ID WXCheckULStepResult::description(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_msgSend(&_OBJC_CLASS___NSString,"stringWithFormat:",
                        &cf_WXCheckULStepResult_success__u_errorInfo____suggestion____);
  return IVar1;
}



// Function Stack Size: 0x10 bytes

bool WXCheckULStepResult::success(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXCheckULStepResult::setSuccess_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXCheckULStepResult::errorInfo(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXCheckULStepResult::setErrorInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXCheckULStepResult::suggestion(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void WXCheckULStepResult::setSuggestion_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXCheckULStepResult::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

int BaseReq::type(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void BaseReq::setType_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + 8) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID BaseReq::openID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void BaseReq::setOpenID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void BaseReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

int BaseResp::errCode(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void BaseResp::setErrCode_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + 8) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID BaseResp::errStr(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void BaseResp::setErrStr_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

int BaseResp::type(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + 0xc);
}



// Function Stack Size: 0x14 bytes

void BaseResp::setType_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + 0xc) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void BaseResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendMessageToWXReq::text(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_text,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendMessageToWXReq::setText_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_text,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendMessageToWXReq::message(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_message);
}



// Function Stack Size: 0x18 bytes

void SendMessageToWXReq::setMessage_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_message,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

bool SendMessageToWXReq::bText(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + (long)_bText);
}



// Function Stack Size: 0x14 bytes

void SendMessageToWXReq::setBText_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + (long)_bText) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

int SendMessageToWXReq::scene(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + (long)_scene);
}



// Function Stack Size: 0x14 bytes

void SendMessageToWXReq::setScene_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + (long)_scene) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID SendMessageToWXReq::toUserOpenId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_toUserOpenId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendMessageToWXReq::setToUserOpenId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_toUserOpenId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendMessageToWXReq::sceneDataObject(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_sceneDataObject);
}



// Function Stack Size: 0x18 bytes

void SendMessageToWXReq::setSceneDataObject_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_sceneDataObject,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void SendMessageToWXReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_sceneDataObject,0);
  _objc_storeStrong(param_1 + (long)_toUserOpenId,0);
  _objc_storeStrong(param_1 + (long)_message,0);
  _objc_storeStrong(param_1 + (long)_text,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendMessageToWXResp::lang(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_lang,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendMessageToWXResp::setLang_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_lang,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendMessageToWXResp::country(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_country,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendMessageToWXResp::setCountry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_country,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void SendMessageToWXResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_country,0);
  _objc_storeStrong(param_1 + (long)_lang,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID GetMessageFromWXReq::lang(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_lang);
}



// Function Stack Size: 0x18 bytes

void GetMessageFromWXReq::setLang_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_lang,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID GetMessageFromWXReq::country(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_country);
}



// Function Stack Size: 0x18 bytes

void GetMessageFromWXReq::setCountry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_country,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void GetMessageFromWXReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_country,0);
  _objc_storeStrong(param_1 + (long)_lang,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID GetMessageFromWXResp::text(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_text);
}



// Function Stack Size: 0x18 bytes

void GetMessageFromWXResp::setText_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_text,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID GetMessageFromWXResp::message(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_message);
}



// Function Stack Size: 0x18 bytes

void GetMessageFromWXResp::setMessage_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_message,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

bool GetMessageFromWXResp::bText(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + (long)_bText);
}



// Function Stack Size: 0x14 bytes

void GetMessageFromWXResp::setBText_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + (long)_bText) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void GetMessageFromWXResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_message,0);
  _objc_storeStrong(param_1 + (long)_text,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID ShowMessageFromWXReq::message(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_message);
}



// Function Stack Size: 0x18 bytes

void ShowMessageFromWXReq::setMessage_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_message,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID ShowMessageFromWXReq::lang(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_lang,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void ShowMessageFromWXReq::setLang_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_lang,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID ShowMessageFromWXReq::country(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_country,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void ShowMessageFromWXReq::setCountry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_country,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void ShowMessageFromWXReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_country,0);
  _objc_storeStrong(param_1 + (long)_lang,0);
  _objc_storeStrong(param_1 + (long)_message,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendAuthReq::scope(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_scope,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendAuthReq::setScope_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_scope,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendAuthReq::state(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_state,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendAuthReq::setState_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_state,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void SendAuthReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_state,0);
  _objc_storeStrong(param_1 + (long)_scope,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendAuthResp::code(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_code,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendAuthResp::setCode_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_code,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendAuthResp::state(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_state,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendAuthResp::setState_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_state,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendAuthResp::lang(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_lang,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendAuthResp::setLang_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_lang,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendAuthResp::country(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_country,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendAuthResp::setCountry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_country,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void SendAuthResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_country,0);
  _objc_storeStrong(param_1 + (long)_lang,0);
  _objc_storeStrong(param_1 + (long)_state,0);
  _objc_storeStrong(param_1 + (long)_code,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID PayReq::partnerId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_partnerId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void PayReq::setPartnerId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_partnerId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID PayReq::prepayId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_prepayId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void PayReq::setPrepayId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_prepayId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID PayReq::nonceStr(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_nonceStr,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void PayReq::setNonceStr_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_nonceStr,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int PayReq::timeStamp(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_timeStamp);
}



// Function Stack Size: 0x14 bytes

void PayReq::setTimeStamp_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_timeStamp) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID PayReq::package(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_package,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void PayReq::setPackage_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_package,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID PayReq::sign(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_sign,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void PayReq::setSign_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_sign,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void PayReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_sign,0);
  _objc_storeStrong(param_1 + (long)_package,0);
  _objc_storeStrong(param_1 + (long)_nonceStr,0);
  _objc_storeStrong(param_1 + (long)_prepayId,0);
  _objc_storeStrong(param_1 + (long)_partnerId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID PayResp::returnKey(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_returnKey,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void PayResp::setReturnKey_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_returnKey,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void PayResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_returnKey,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXJointPayReq::partnerId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_partnerId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXJointPayReq::setPartnerId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_partnerId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXJointPayReq::prepayId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_prepayId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXJointPayReq::setPrepayId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_prepayId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXJointPayReq::nonceStr(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_nonceStr,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXJointPayReq::setNonceStr_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_nonceStr,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXJointPayReq::timeStamp(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_timeStamp);
}



// Function Stack Size: 0x14 bytes

void WXJointPayReq::setTimeStamp_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_timeStamp) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXJointPayReq::package(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_package,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXJointPayReq::setPackage_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_package,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXJointPayReq::sign(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_sign,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXJointPayReq::setSign_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_sign,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXJointPayReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_sign,0);
  _objc_storeStrong(param_1 + (long)_package,0);
  _objc_storeStrong(param_1 + (long)_nonceStr,0);
  _objc_storeStrong(param_1 + (long)_prepayId,0);
  _objc_storeStrong(param_1 + (long)_partnerId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXJointPayResp::returnKey(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_returnKey,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXJointPayResp::setReturnKey_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_returnKey,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXJointPayResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_returnKey,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXNontaxPayReq::urlString(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_urlString,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXNontaxPayReq::setUrlString_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_urlString,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXNontaxPayReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_urlString,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXNontaxPayResp::wxOrderId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_wxOrderId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXNontaxPayResp::setWxOrderId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_wxOrderId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXNontaxPayResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_wxOrderId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXPayInsuranceReq::urlString(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_urlString,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXPayInsuranceReq::setUrlString_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_urlString,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXPayInsuranceReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_urlString,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXPayInsuranceResp::wxOrderId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_wxOrderId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXPayInsuranceResp::setWxOrderId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_wxOrderId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXPayInsuranceResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_wxOrderId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID LaunchFromWXReq::message(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_message);
}



// Function Stack Size: 0x18 bytes

void LaunchFromWXReq::setMessage_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_message,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID LaunchFromWXReq::lang(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_lang,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void LaunchFromWXReq::setLang_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_lang,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID LaunchFromWXReq::country(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_country,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void LaunchFromWXReq::setCountry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_country,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void LaunchFromWXReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_country,0);
  _objc_storeStrong(param_1 + (long)_lang,0);
  _objc_storeStrong(param_1 + (long)_message,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID OpenWebviewReq::url(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_url,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void OpenWebviewReq::setUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_url,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void OpenWebviewReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_url,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenTypeWebViewReq::wxInternalResptype(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_wxInternalResptype,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenTypeWebViewReq::setWxInternalResptype_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_wxInternalResptype,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenTypeWebViewReq::query(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_query,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenTypeWebViewReq::setQuery_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_query,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenTypeWebViewReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_query,0);
  _objc_storeStrong(param_1 + (long)_wxInternalResptype,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenTypeWebViewResp::infoDic(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_infoDic);
}



// Function Stack Size: 0x18 bytes

void WXOpenTypeWebViewResp::setInfoDic_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_infoDic,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenTypeWebViewResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_infoDic,0);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXOpenBusinessWebViewReq::businessType(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_businessType);
}



// Function Stack Size: 0x14 bytes

void WXOpenBusinessWebViewReq::setBusinessType_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_businessType) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessWebViewReq::queryInfoDic(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_queryInfoDic);
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessWebViewReq::setQueryInfoDic_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_queryInfoDic,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenBusinessWebViewReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_queryInfoDic,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessWebViewResp::result(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_result,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessWebViewResp::setResult_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_result,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXOpenBusinessWebViewResp::businessType(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_businessType);
}



// Function Stack Size: 0x14 bytes

void WXOpenBusinessWebViewResp::setBusinessType_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_businessType) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenBusinessWebViewResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_result,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXCardItem::cardId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXCardItem::setCardId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXCardItem::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXCardItem::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXCardItem::cardState(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXCardItem::setCardState_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 8) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXCardItem::encryptCode(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXCardItem::setEncryptCode_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXCardItem::appID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x28,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXCardItem::setAppID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x28,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXCardItem::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXInvoiceItem::cardId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXInvoiceItem::setCardId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXInvoiceItem::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXInvoiceItem::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXInvoiceItem::cardState(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXInvoiceItem::setCardState_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 8) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXInvoiceItem::encryptCode(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXInvoiceItem::setEncryptCode_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXInvoiceItem::appID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x28,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXInvoiceItem::setAppID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x28,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXInvoiceItem::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID AddCardToWXCardPackageReq::cardAry(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_cardAry);
}



// Function Stack Size: 0x18 bytes

void AddCardToWXCardPackageReq::setCardAry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_cardAry,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void AddCardToWXCardPackageReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_cardAry,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID AddCardToWXCardPackageResp::cardAry(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_cardAry);
}



// Function Stack Size: 0x18 bytes

void AddCardToWXCardPackageResp::setCardAry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_cardAry,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void AddCardToWXCardPackageResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_cardAry,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseCardReq::appID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_appID,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseCardReq::setAppID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_appID,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXChooseCardReq::shopID(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_shopID);
}



// Function Stack Size: 0x14 bytes

void WXChooseCardReq::setShopID_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_shopID) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXChooseCardReq::canMultiSelect(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_canMultiSelect);
}



// Function Stack Size: 0x14 bytes

void WXChooseCardReq::setCanMultiSelect_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_canMultiSelect) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseCardReq::cardType(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_cardType,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseCardReq::setCardType_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_cardType,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseCardReq::cardTpID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_cardTpID,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseCardReq::setCardTpID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_cardTpID,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseCardReq::signType(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_signType,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseCardReq::setSignType_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_signType,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseCardReq::cardSign(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_cardSign,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseCardReq::setCardSign_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_cardSign,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXChooseCardReq::timeStamp(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_timeStamp);
}



// Function Stack Size: 0x14 bytes

void WXChooseCardReq::setTimeStamp_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_timeStamp) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseCardReq::nonceStr(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_nonceStr,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseCardReq::setNonceStr_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_nonceStr,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChooseCardReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_nonceStr,0);
  _objc_storeStrong(param_1 + (long)_cardSign,0);
  _objc_storeStrong(param_1 + (long)_signType,0);
  _objc_storeStrong(param_1 + (long)_cardTpID,0);
  _objc_storeStrong(param_1 + (long)_cardType,0);
  _objc_storeStrong(param_1 + (long)_appID,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseCardResp::cardAry(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_cardAry);
}



// Function Stack Size: 0x18 bytes

void WXChooseCardResp::setCardAry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_cardAry,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChooseCardResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_cardAry,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXHandleScanResultReq::scanResult(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_scanResult,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXHandleScanResultReq::setScanResult_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_scanResult,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXHandleScanResultReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_scanResult,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseInvoiceReq::appID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_appID,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseInvoiceReq::setAppID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_appID,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXChooseInvoiceReq::shopID(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_shopID);
}



// Function Stack Size: 0x14 bytes

void WXChooseInvoiceReq::setShopID_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_shopID) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseInvoiceReq::signType(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_signType,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseInvoiceReq::setSignType_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_signType,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseInvoiceReq::cardSign(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_cardSign,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseInvoiceReq::setCardSign_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_cardSign,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXChooseInvoiceReq::timeStamp(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_timeStamp);
}



// Function Stack Size: 0x14 bytes

void WXChooseInvoiceReq::setTimeStamp_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_timeStamp) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseInvoiceReq::nonceStr(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_nonceStr,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChooseInvoiceReq::setNonceStr_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_nonceStr,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChooseInvoiceReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_nonceStr,0);
  _objc_storeStrong(param_1 + (long)_cardSign,0);
  _objc_storeStrong(param_1 + (long)_signType,0);
  _objc_storeStrong(param_1 + (long)_appID,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChooseInvoiceResp::cardAry(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_cardAry);
}



// Function Stack Size: 0x18 bytes

void WXChooseInvoiceResp::setCardAry_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_cardAry,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChooseInvoiceResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_cardAry,0);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXSubscribeMsgReq::scene(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_scene);
}



// Function Stack Size: 0x14 bytes

void WXSubscribeMsgReq::setScene_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_scene) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMsgReq::templateId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_templateId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMsgReq::setTemplateId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_templateId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMsgReq::reserved(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_reserved,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMsgReq::setReserved_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_reserved,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXSubscribeMsgReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_reserved,0);
  _objc_storeStrong(param_1 + (long)_templateId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMsgResp::templateId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_templateId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMsgResp::setTemplateId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_templateId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXSubscribeMsgResp::scene(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + (long)_scene);
}



// Function Stack Size: 0x14 bytes

void WXSubscribeMsgResp::setScene_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + (long)_scene) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMsgResp::action(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_action,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMsgResp::setAction_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_action,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMsgResp::reserved(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_reserved,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMsgResp::setReserved_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_reserved,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMsgResp::openId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_openId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMsgResp::setOpenId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_openId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXSubscribeMsgResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_openId,0);
  _objc_storeStrong(param_1 + (long)_reserved,0);
  _objc_storeStrong(param_1 + (long)_action,0);
  _objc_storeStrong(param_1 + (long)_templateId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMiniProgramMsgReq::miniProgramAppid(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_miniProgramAppid,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMiniProgramMsgReq::setMiniProgramAppid_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_miniProgramAppid,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXSubscribeMiniProgramMsgReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_miniProgramAppid,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMiniProgramMsgResp::openId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_openId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMiniProgramMsgResp::setOpenId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_openId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMiniProgramMsgResp::unionId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_unionId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMiniProgramMsgResp::setUnionId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_unionId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXSubscribeMiniProgramMsgResp::nickName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_nickName,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXSubscribeMiniProgramMsgResp::setNickName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_nickName,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXSubscribeMiniProgramMsgResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_nickName,0);
  _objc_storeStrong(param_1 + (long)_unionId,0);
  _objc_storeStrong(param_1 + (long)_openId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXInvoiceAuthInsertReq::urlString(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_urlString,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXInvoiceAuthInsertReq::setUrlString_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_urlString,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXInvoiceAuthInsertReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_urlString,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXInvoiceAuthInsertResp::wxOrderId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_wxOrderId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXInvoiceAuthInsertResp::setWxOrderId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_wxOrderId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXInvoiceAuthInsertResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_wxOrderId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID CreateChatRoomReq::groupId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_groupId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void CreateChatRoomReq::setGroupId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_groupId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID CreateChatRoomReq::chatRoomName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_chatRoomName,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void CreateChatRoomReq::setChatRoomName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_chatRoomName,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID CreateChatRoomReq::chatRoomNickName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_chatRoomNickName,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void CreateChatRoomReq::setChatRoomNickName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_chatRoomNickName,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID CreateChatRoomReq::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void CreateChatRoomReq::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void CreateChatRoomReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  _objc_storeStrong(param_1 + (long)_chatRoomNickName,0);
  _objc_storeStrong(param_1 + (long)_chatRoomName,0);
  _objc_storeStrong(param_1 + (long)_groupId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID CreateChatRoomResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void CreateChatRoomResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void CreateChatRoomResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID JoinChatRoomReq::groupId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_groupId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void JoinChatRoomReq::setGroupId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_groupId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID JoinChatRoomReq::chatRoomNickName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_chatRoomNickName,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void JoinChatRoomReq::setChatRoomNickName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_chatRoomNickName,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID JoinChatRoomReq::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void JoinChatRoomReq::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void JoinChatRoomReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  _objc_storeStrong(param_1 + (long)_chatRoomNickName,0);
  _objc_storeStrong(param_1 + (long)_groupId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID JoinChatRoomResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void JoinChatRoomResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void JoinChatRoomResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXImageObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXImageObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXImageObject::imageData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 8);
}



// Function Stack Size: 0x18 bytes

void WXImageObject::setImageData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXImageObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXMusicObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXMusicObject::musicUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicObject::setMusicUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicObject::musicLowBandUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicObject::setMusicLowBandUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicObject::musicDataUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicObject::setMusicDataUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicObject::musicLowBandDataUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicObject::setMusicLowBandDataUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicObject::songAlbumUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x28,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicObject::setSongAlbumUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x28,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicObject::songLyric(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x30,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicObject::setSongLyric_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x30,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXMusicObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x30,0);
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXMusicVideoObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::musicUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setMusicUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::musicDataUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setMusicDataUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::singerName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setSingerName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_int WXMusicVideoObject::duration(ID param_1,SEL param_2)

{
  return *(unsigned_int *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXMusicVideoObject::setDuration_(ID param_1,SEL param_2,unsigned_int param_3)

{
  *(unsigned_int *)(param_1 + 8) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::songLyric(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x28,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setSongLyric_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x28,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::hdAlbumThumbData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x30);
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setHdAlbumThumbData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x30,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::albumName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x38,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setAlbumName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x38,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::musicGenre(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x40,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setMusicGenre_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x40,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXMusicVideoObject::issueDate(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0x48);
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setIssueDate_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0x48) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::identification(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x50,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setIdentification_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x50,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMusicVideoObject::musicOperationUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x58,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMusicVideoObject::setMusicOperationUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x58,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXMusicVideoObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x58,0);
  _objc_storeStrong(param_1 + 0x50,0);
  _objc_storeStrong(param_1 + 0x40,0);
  _objc_storeStrong(param_1 + 0x38,0);
  _objc_storeStrong(param_1 + 0x30,0);
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXVideoObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXVideoObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXVideoObject::videoUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXVideoObject::setVideoUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXVideoObject::videoLowBandUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXVideoObject::setVideoLowBandUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXVideoObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXWebpageObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXWebpageObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXWebpageObject::webpageUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXWebpageObject::setWebpageUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXWebpageObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXAppExtendObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXAppExtendObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXAppExtendObject::url(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXAppExtendObject::setUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXAppExtendObject::extInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXAppExtendObject::setExtInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXAppExtendObject::fileData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void WXAppExtendObject::setFileData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXAppExtendObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXEmoticonObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXEmoticonObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXEmoticonObject::emoticonData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 8);
}



// Function Stack Size: 0x18 bytes

void WXEmoticonObject::setEmoticonData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXEmoticonObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXFileObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXFileObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXFileObject::fileExtension(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXFileObject::setFileExtension_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXFileObject::fileData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXFileObject::setFileData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXFileObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXVideoFileObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXVideoFileObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXVideoFileObject::videoFileData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 8);
}



// Function Stack Size: 0x18 bytes

void WXVideoFileObject::setVideoFileData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXVideoFileObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXGameVideoFileObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXGameVideoFileObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXGameVideoFileObject::videoFileData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 8);
}



// Function Stack Size: 0x18 bytes

void WXGameVideoFileObject::setVideoFileData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXGameVideoFileObject::videoUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXGameVideoFileObject::setVideoUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXGameVideoFileObject::thumbUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXGameVideoFileObject::setThumbUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXGameVideoFileObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLocationObject::init(ID param_1,SEL param_2)

{
  ID IVar1;
  ID local_20;
  class_t *pcStack_18;
  
  pcStack_18 = &objc::class_t::WXLocationObject;
  local_20 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_20,"init");
  if (IVar1 != 0) {
    *(undefined8 *)(IVar1 + 0x10) = 0xc08f400000000000;
    *(undefined8 *)(IVar1 + 8) = 0xc08f400000000000;
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID WXLocationObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXLocationObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

double WXLocationObject::lng(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 8);
}



// Function Stack Size: 0x18 bytes

void WXLocationObject::setLng_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 8) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

double WXLocationObject::lat(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXLocationObject::setLat_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x10) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXTextObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXTextObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXTextObject::contentText(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXTextObject::setContentText_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXTextObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMiniProgramObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXMiniProgramObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXMiniProgramObject::init(ID param_1,SEL param_2)

{
  ID IVar1;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::WXMiniProgramObject;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    _objc_msgSend(IVar1,"setWithShareTicket:",0);
    _objc_msgSend(IVar1,"setMiniProgramType:",0);
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID WXMiniProgramObject::webpageUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMiniProgramObject::setWebpageUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMiniProgramObject::userName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMiniProgramObject::setUserName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMiniProgramObject::path(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMiniProgramObject::setPath_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMiniProgramObject::hdImageData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x28);
}



// Function Stack Size: 0x18 bytes

void WXMiniProgramObject::setHdImageData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x28,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

bool WXMiniProgramObject::withShareTicket(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXMiniProgramObject::setWithShareTicket_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXMiniProgramObject::miniProgramType(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0x30);
}



// Function Stack Size: 0x18 bytes

void WXMiniProgramObject::setMiniProgramType_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0x30) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool WXMiniProgramObject::disableForward(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 9);
}



// Function Stack Size: 0x14 bytes

void WXMiniProgramObject::setDisableForward_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 9) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool WXMiniProgramObject::isUpdatableMessage(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 10);
}



// Function Stack Size: 0x14 bytes

void WXMiniProgramObject::setIsUpdatableMessage_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 10) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool WXMiniProgramObject::isSecretMessage(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0xb);
}



// Function Stack Size: 0x14 bytes

void WXMiniProgramObject::setIsSecretMessage_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0xb) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMiniProgramObject::extraInfoDic(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x38);
}



// Function Stack Size: 0x18 bytes

void WXMiniProgramObject::setExtraInfoDic_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x38,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXMiniProgramObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x38,0);
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXGameLiveObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXGameLiveObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXGameLiveObject::extraInfoDic(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 8);
}



// Function Stack Size: 0x18 bytes

void WXGameLiveObject::setExtraInfoDic_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 8,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXGameLiveObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchMiniProgramReq::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXLaunchMiniProgramReq,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchMiniProgramReq::userName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_userName,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLaunchMiniProgramReq::setUserName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_userName,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchMiniProgramReq::path(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_path,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLaunchMiniProgramReq::setPath_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_path,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXLaunchMiniProgramReq::miniProgramType(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + (long)_miniProgramType);
}



// Function Stack Size: 0x18 bytes

void WXLaunchMiniProgramReq::setMiniProgramType_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + (long)_miniProgramType) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchMiniProgramReq::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLaunchMiniProgramReq::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchMiniProgramReq::extDic(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extDic,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLaunchMiniProgramReq::setExtDic_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extDic,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXLaunchMiniProgramReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extDic,0);
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  _objc_storeStrong(param_1 + (long)_path,0);
  _objc_storeStrong(param_1 + (long)_userName,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchMiniProgramResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLaunchMiniProgramResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXLaunchMiniProgramResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessViewReq::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXOpenBusinessViewReq,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessViewReq::businessType(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_businessType,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessViewReq::setBusinessType_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_businessType,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessViewReq::query(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_query,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessViewReq::setQuery_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_query,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessViewReq::extInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extInfo,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessViewReq::setExtInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extInfo,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessViewReq::extData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_extData);
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessViewReq::setExtData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_extData,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenBusinessViewReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extData,0);
  _objc_storeStrong(param_1 + (long)_extInfo,0);
  _objc_storeStrong(param_1 + (long)_query,0);
  _objc_storeStrong(param_1 + (long)_businessType,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelBaseJumpInfo::wording(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelBaseJumpInfo::setWording_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelBaseJumpInfo::extData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXChannelBaseJumpInfo::setExtData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelBaseJumpInfo::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelJumpMiniProgramInfo::userName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_userName,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelJumpMiniProgramInfo::setUserName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_userName,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelJumpMiniProgramInfo::path(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_path);
}



// Function Stack Size: 0x18 bytes

void WXChannelJumpMiniProgramInfo::setPath_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_path,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelJumpMiniProgramInfo::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_path,0);
  _objc_storeStrong(param_1 + (long)_userName,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelJumpUrlInfo::url(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_url,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelJumpUrlInfo::setUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_url,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelJumpUrlInfo::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_url,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessViewResp::businessType(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_businessType,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessViewResp::setBusinessType_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_businessType,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenBusinessViewResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenBusinessViewResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenBusinessViewResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  _objc_storeStrong(param_1 + (long)_businessType,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelShareVideoReq::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXChannelShareVideoReq,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXChannelShareVideoReq::localIdentifier(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_localIdentifier,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelShareVideoReq::setLocalIdentifier_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_localIdentifier,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelShareVideoReq::extData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_extData);
}



// Function Stack Size: 0x18 bytes

void WXChannelShareVideoReq::setExtData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_extData,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelShareVideoReq::jumpInfo(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_jumpInfo);
}



// Function Stack Size: 0x18 bytes

void WXChannelShareVideoReq::setJumpInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_jumpInfo,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelShareVideoReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_jumpInfo,0);
  _objc_storeStrong(param_1 + (long)_extData,0);
  _objc_storeStrong(param_1 + (long)_localIdentifier,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelShareVideoResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelShareVideoResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelShareVideoResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenProfileReq::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXChannelOpenProfileReq,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenProfileReq::userName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_userName,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenProfileReq::setUserName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_userName,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelOpenProfileReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_userName,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenProfileResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenProfileResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelOpenProfileResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenLiveReq::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXChannelOpenLiveReq,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenLiveReq::feedID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_feedID,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenLiveReq::setFeedID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_feedID,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenLiveReq::nonceID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_nonceID,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenLiveReq::setNonceID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_nonceID,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelOpenLiveReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_nonceID,0);
  _objc_storeStrong(param_1 + (long)_feedID,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenLiveResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenLiveResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelOpenLiveResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenFeedReq::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXChannelOpenFeedReq,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenFeedReq::feedID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_feedID,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenFeedReq::setFeedID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_feedID,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenFeedReq::nonceID(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_nonceID,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenFeedReq::setNonceID_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_nonceID,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

bool WXChannelOpenFeedReq::notGetReleatedList(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + (long)_notGetReleatedList);
}



// Function Stack Size: 0x14 bytes

void WXChannelOpenFeedReq::setNotGetReleatedList_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + (long)_notGetReleatedList) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelOpenFeedReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_nonceID,0);
  _objc_storeStrong(param_1 + (long)_feedID,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXChannelOpenFeedResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXChannelOpenFeedResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXChannelOpenFeedResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXStateSceneDataObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXStateSceneDataObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXStateSceneDataObject::stateId(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_stateId,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXStateSceneDataObject::setStateId_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_stateId,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXStateSceneDataObject::stateTitle(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_stateTitle,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXStateSceneDataObject::setStateTitle_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_stateTitle,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXStateSceneDataObject::token(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_token,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXStateSceneDataObject::setToken_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_token,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXStateSceneDataObject::stateJumpDataInfo(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_stateJumpDataInfo);
}



// Function Stack Size: 0x18 bytes

void WXStateSceneDataObject::setStateJumpDataInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_stateJumpDataInfo,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXStateSceneDataObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_stateJumpDataInfo,0);
  _objc_storeStrong(param_1 + (long)_token,0);
  _objc_storeStrong(param_1 + (long)_stateTitle,0);
  _objc_storeStrong(param_1 + (long)_stateId,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXStateJumpUrlInfo::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXStateJumpUrlInfo,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXStateJumpUrlInfo::url(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_url,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXStateJumpUrlInfo::setUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_url,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXStateJumpUrlInfo::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_url,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::message(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXMediaMessage,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setThumbImage_(ID param_1,SEL param_2,ID param_3)

{
  long lVar1;
  ID IVar2;
  ulong uVar3;
  ID IVar4;
  double dVar5;
  
  lVar1 = _objc_retain(param_3);
  if (lVar1 != 0) {
    dVar5 = 0.6000000238418579;
    _UIImageJPEGRepresentation(0x3fe3333340000000,lVar1);
    IVar2 = _objc_retainAutoreleasedReturnValue();
    uVar3 = _objc_msgSend(IVar2,"length");
    do {
      IVar4 = IVar2;
      if (uVar3 < 0x8001) break;
      dVar5 = dVar5 + -0.1;
      _UIImageJPEGRepresentation(dVar5,lVar1);
      IVar4 = _objc_retainAutoreleasedReturnValue();
      _objc_release(IVar2);
      uVar3 = _objc_msgSend(IVar4,"length");
      IVar2 = IVar4;
    } while (0.1000000014901161 < dVar5);
    setThumbData_(param_1,(SEL)"setThumbData:",IVar4);
    _objc_release(IVar4);
  }
  _objc_release(lVar1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::description(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setDescription_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::title(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setTitle_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::thumbData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setThumbData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::mediaTagName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setMediaTagName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::messageExt(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x28,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setMessageExt_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x28,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::messageAction(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x30,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setMessageAction_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x30,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXMediaMessage::mediaObject(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x38);
}



// Function Stack Size: 0x18 bytes

void WXMediaMessage::setMediaObject_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x38,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXMediaMessage::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x38,0);
  _objc_storeStrong(param_1 + 0x30,0);
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXEnterpriseCardObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXEnterpriseCardObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXEnterpriseCardObject::cardInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,8,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXEnterpriseCardObject::setCardInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,8,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

long_long WXEnterpriseCardObject::msgType(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXEnterpriseCardObject::setMsgType_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x10) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void WXEnterpriseCardObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXDynamicVideoMiniProgramObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::init(ID param_1,SEL param_2)

{
  ID IVar1;
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::WXDynamicVideoMiniProgramObject;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    _objc_msgSend(IVar1,"setWithShareTicket:",0);
    _objc_msgSend(IVar1,"setMiniProgramType:",0);
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::webpageUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x10,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXDynamicVideoMiniProgramObject::setWebpageUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x10,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::userName(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXDynamicVideoMiniProgramObject::setUserName_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::path(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x20,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXDynamicVideoMiniProgramObject::setPath_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x20,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::hdImageData(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x28);
}



// Function Stack Size: 0x18 bytes

void WXDynamicVideoMiniProgramObject::setHdImageData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x28,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

bool WXDynamicVideoMiniProgramObject::withShareTicket(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXDynamicVideoMiniProgramObject::setWithShareTicket_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool WXDynamicVideoMiniProgramObject::disableForward(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 9);
}



// Function Stack Size: 0x14 bytes

void WXDynamicVideoMiniProgramObject::setDisableForward_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 9) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

unsigned_long_long WXDynamicVideoMiniProgramObject::miniProgramType(ID param_1,SEL param_2)

{
  return *(unsigned_long_long *)(param_1 + 0x30);
}



// Function Stack Size: 0x18 bytes

void WXDynamicVideoMiniProgramObject::setMiniProgramType_
               (ID param_1,SEL param_2,unsigned_long_long param_3)

{
  *(unsigned_long_long *)(param_1 + 0x30) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::videoSource(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x38,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXDynamicVideoMiniProgramObject::setVideoSource_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x38,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXDynamicVideoMiniProgramObject::appThumbUrl(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x40,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXDynamicVideoMiniProgramObject::setAppThumbUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x40,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXDynamicVideoMiniProgramObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x40,0);
  _objc_storeStrong(param_1 + 0x38,0);
  _objc_storeStrong(param_1 + 0x28,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXWeWorkObject::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXWeWorkObject,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXWeWorkObject::data(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void WXWeWorkObject::setData_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

int WXWeWorkObject::subType(ID param_1,SEL param_2)

{
  return *(int *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void WXWeWorkObject::setSubType_(ID param_1,SEL param_2,int param_3)

{
  *(int *)(param_1 + 8) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID WXWeWorkObject::extInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,0x18,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXWeWorkObject::setExtInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,0x18,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXWeWorkObject::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendTdiAuthReq::tdiExtInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_tdiExtInfo,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendTdiAuthReq::setTdiExtInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_tdiExtInfo,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void SendTdiAuthReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_tdiExtInfo,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendTdiAuthResp::tdiExtInfo(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_tdiExtInfo,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void SendTdiAuthResp::setTdiExtInfo_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_tdiExtInfo,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendTdiAuthResp::tdiAuthBuffer(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_tdiAuthBuffer);
}



// Function Stack Size: 0x18 bytes

void SendTdiAuthResp::setTdiAuthBuffer_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_tdiAuthBuffer,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID SendTdiAuthResp::tdiAuthParams(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_tdiAuthParams);
}



// Function Stack Size: 0x18 bytes

void SendTdiAuthResp::setTdiAuthParams_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_tdiAuthParams,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void SendTdiAuthResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_tdiAuthParams,0);
  _objc_storeStrong(param_1 + (long)_tdiAuthBuffer,0);
  _objc_storeStrong(param_1 + (long)_tdiExtInfo,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchWxaRedirectingPageReq::ticket(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_ticket,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLaunchWxaRedirectingPageReq::setTicket_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_ticket,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchWxaRedirectingPageReq::extDict(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + (long)_extDict);
}



// Function Stack Size: 0x18 bytes

void WXLaunchWxaRedirectingPageReq::setExtDict_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + (long)_extDict,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void WXLaunchWxaRedirectingPageReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extDict,0);
  _objc_storeStrong(param_1 + (long)_ticket,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXLaunchWxaRedirectingPageResp::ticket(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_ticket,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXLaunchWxaRedirectingPageResp::setTicket_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_ticket,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXLaunchWxaRedirectingPageResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_ticket,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenCustomerServiceReq::object(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  ID IVar2;
  
  uVar1 = _objc_msgSend(&objc::class_t::WXOpenCustomerServiceReq,"alloc");
  _objc_msgSend(uVar1,"init");
  IVar2 = _objc_autoreleaseReturnValue();
  return IVar2;
}



// Function Stack Size: 0x10 bytes

ID WXOpenCustomerServiceReq::url(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_url,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenCustomerServiceReq::setUrl_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_url,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenCustomerServiceReq::corpid(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_corpid,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenCustomerServiceReq::setCorpid_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_corpid,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenCustomerServiceReq::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_corpid,0);
  _objc_storeStrong(param_1 + (long)_url,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID WXOpenCustomerServiceResp::extMsg(ID param_1,SEL param_2)

{
  ID IVar1;
  
  IVar1 = _objc_getProperty(param_1,param_2,(long)_extMsg,0);
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void WXOpenCustomerServiceResp::setExtMsg_(ID param_1,SEL param_2,ID param_3)

{
  _objc_setProperty(param_1,param_2,(long)_extMsg,param_3,0,1);
  return;
}



// Function Stack Size: 0x10 bytes

void WXOpenCustomerServiceResp::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + (long)_extMsg,0);
  return;
}



char __aarch64_cas1_relax(char param_1,char param_2,char *param_3)

{
  char cVar1;
  bool bVar2;
  char cVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    cVar3 = *param_3;
    if (cVar3 == param_1) {
      *param_3 = param_2;
    }
    return cVar3;
  }
  do {
    cVar3 = *param_3;
    if (*param_3 != param_1) {
      return cVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return cVar3;
}



char __aarch64_cas1_acq(char param_1,char param_2,char *param_3)

{
  char cVar1;
  bool bVar2;
  char cVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    cVar3 = *param_3;
    if (cVar3 == param_1) {
      *param_3 = param_2;
    }
    return cVar3;
  }
  do {
    cVar3 = *param_3;
    if (*param_3 != param_1) {
      return cVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return cVar3;
}



char __aarch64_cas1_rel(char param_1,char param_2,char *param_3)

{
  char cVar1;
  bool bVar2;
  char cVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    cVar3 = *param_3;
    if (cVar3 == param_1) {
      *param_3 = param_2;
    }
    return cVar3;
  }
  do {
    cVar3 = *param_3;
    if (*param_3 != param_1) {
      return cVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return cVar3;
}



char __aarch64_cas1_acq_rel(char param_1,char param_2,char *param_3)

{
  char cVar1;
  bool bVar2;
  char cVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    cVar3 = *param_3;
    if (cVar3 == param_1) {
      *param_3 = param_2;
    }
    return cVar3;
  }
  do {
    cVar3 = *param_3;
    if (*param_3 != param_1) {
      return cVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return cVar3;
}



short __aarch64_cas2_relax(short param_1,short param_2,short *param_3)

{
  char cVar1;
  bool bVar2;
  short sVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    sVar3 = *param_3;
    if (sVar3 == param_1) {
      *param_3 = param_2;
    }
    return sVar3;
  }
  do {
    sVar3 = *param_3;
    if (*param_3 != param_1) {
      return sVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return sVar3;
}



short __aarch64_cas2_acq(short param_1,short param_2,short *param_3)

{
  char cVar1;
  bool bVar2;
  short sVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    sVar3 = *param_3;
    if (sVar3 == param_1) {
      *param_3 = param_2;
    }
    return sVar3;
  }
  do {
    sVar3 = *param_3;
    if (*param_3 != param_1) {
      return sVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return sVar3;
}



short __aarch64_cas2_rel(short param_1,short param_2,short *param_3)

{
  char cVar1;
  bool bVar2;
  short sVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    sVar3 = *param_3;
    if (sVar3 == param_1) {
      *param_3 = param_2;
    }
    return sVar3;
  }
  do {
    sVar3 = *param_3;
    if (*param_3 != param_1) {
      return sVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return sVar3;
}



short __aarch64_cas2_acq_rel(short param_1,short param_2,short *param_3)

{
  char cVar1;
  bool bVar2;
  short sVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    sVar3 = *param_3;
    if (sVar3 == param_1) {
      *param_3 = param_2;
    }
    return sVar3;
  }
  do {
    sVar3 = *param_3;
    if (*param_3 != param_1) {
      return sVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return sVar3;
}



int __aarch64_cas4_relax(int param_1,int param_2,int *param_3)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    iVar3 = *param_3;
    if (iVar3 == param_1) {
      *param_3 = param_2;
    }
    return iVar3;
  }
  do {
    iVar3 = *param_3;
    if (*param_3 != param_1) {
      return iVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return iVar3;
}



int __aarch64_cas4_acq(int param_1,int param_2,int *param_3)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    iVar3 = *param_3;
    if (iVar3 == param_1) {
      *param_3 = param_2;
    }
    return iVar3;
  }
  do {
    iVar3 = *param_3;
    if (*param_3 != param_1) {
      return iVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return iVar3;
}



int __aarch64_cas4_rel(int param_1,int param_2,int *param_3)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    iVar3 = *param_3;
    if (iVar3 == param_1) {
      *param_3 = param_2;
    }
    return iVar3;
  }
  do {
    iVar3 = *param_3;
    if (*param_3 != param_1) {
      return iVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return iVar3;
}



int __aarch64_cas4_acq_rel(int param_1,int param_2,int *param_3)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    iVar3 = *param_3;
    if (iVar3 == param_1) {
      *param_3 = param_2;
    }
    return iVar3;
  }
  do {
    iVar3 = *param_3;
    if (*param_3 != param_1) {
      return iVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return iVar3;
}



long __aarch64_cas8_relax(long param_1,long param_2,long *param_3)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    lVar3 = *param_3;
    if (lVar3 == param_1) {
      *param_3 = param_2;
    }
    return lVar3;
  }
  do {
    lVar3 = *param_3;
    if (lVar3 != param_1) {
      return lVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3;
}



long __aarch64_cas8_acq(long param_1,long param_2,long *param_3)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    lVar3 = *param_3;
    if (lVar3 == param_1) {
      *param_3 = param_2;
    }
    return lVar3;
  }
  do {
    lVar3 = *param_3;
    if (lVar3 != param_1) {
      return lVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3;
}



long __aarch64_cas8_rel(long param_1,long param_2,long *param_3)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    lVar3 = *param_3;
    if (lVar3 == param_1) {
      *param_3 = param_2;
    }
    return lVar3;
  }
  do {
    lVar3 = *param_3;
    if (lVar3 != param_1) {
      return lVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3;
}



long __aarch64_cas8_acq_rel(long param_1,long param_2,long *param_3)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics != '\0') {
    lVar3 = *param_3;
    if (lVar3 == param_1) {
      *param_3 = param_2;
    }
    return lVar3;
  }
  do {
    lVar3 = *param_3;
    if (lVar3 != param_1) {
      return lVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_3,0x10);
    if (bVar2) {
      *param_3 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3;
}



undefined  [16]
__aarch64_cas16_relax
          (long param_1,long param_2,undefined8 param_3,undefined8 param_4,undefined (*param_5) [16]
          )

{
  char cVar1;
  bool bVar2;
  undefined auVar3 [16];
  
  if (___aarch64_have_lse_atomics != '\0') {
    auVar3 = *param_5;
    if ((*(long *)*param_5 == param_2) && (*(long *)(*param_5 + 8) == param_1)) {
      *(undefined8 *)*param_5 = param_4;
      *(undefined8 *)(*param_5 + 8) = param_3;
    }
    return auVar3;
  }
  do {
    auVar3 = *param_5;
    if (*(long *)*param_5 != param_1 || *(long *)(*param_5 + 8) != param_2) {
      return auVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_5,0x10);
    if (bVar2) {
      *(undefined8 *)*param_5 = param_3;
      *(undefined8 *)(*param_5 + 8) = param_4;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return auVar3;
}



undefined  [16]
__aarch64_cas16_acq(long param_1,long param_2,undefined8 param_3,undefined8 param_4,
                   undefined (*param_5) [16])

{
  char cVar1;
  bool bVar2;
  undefined auVar3 [16];
  
  if (___aarch64_have_lse_atomics != '\0') {
    auVar3 = *param_5;
    if ((*(long *)*param_5 == param_2) && (*(long *)(*param_5 + 8) == param_1)) {
      *(undefined8 *)*param_5 = param_4;
      *(undefined8 *)(*param_5 + 8) = param_3;
    }
    return auVar3;
  }
  do {
    auVar3 = *param_5;
    if (*(long *)*param_5 != param_1 || *(long *)(*param_5 + 8) != param_2) {
      return auVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_5,0x10);
    if (bVar2) {
      *(undefined8 *)*param_5 = param_3;
      *(undefined8 *)(*param_5 + 8) = param_4;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return auVar3;
}



undefined  [16]
__aarch64_cas16_rel(long param_1,long param_2,undefined8 param_3,undefined8 param_4,
                   undefined (*param_5) [16])

{
  char cVar1;
  bool bVar2;
  undefined auVar3 [16];
  
  if (___aarch64_have_lse_atomics != '\0') {
    auVar3 = *param_5;
    if ((*(long *)*param_5 == param_2) && (*(long *)(*param_5 + 8) == param_1)) {
      *(undefined8 *)*param_5 = param_4;
      *(undefined8 *)(*param_5 + 8) = param_3;
    }
    return auVar3;
  }
  do {
    auVar3 = *param_5;
    if (*(long *)*param_5 != param_1 || *(long *)(*param_5 + 8) != param_2) {
      return auVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_5,0x10);
    if (bVar2) {
      *(undefined8 *)*param_5 = param_3;
      *(undefined8 *)(*param_5 + 4) = param_4;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return auVar3;
}



undefined  [16]
__aarch64_cas16_acq_rel
          (long param_1,long param_2,undefined8 param_3,undefined8 param_4,undefined (*param_5) [16]
          )

{
  char cVar1;
  bool bVar2;
  undefined auVar3 [16];
  
  if (___aarch64_have_lse_atomics != '\0') {
    auVar3 = *param_5;
    if ((*(long *)*param_5 == param_2) && (*(long *)(*param_5 + 8) == param_1)) {
      *(undefined8 *)*param_5 = param_4;
      *(undefined8 *)(*param_5 + 8) = param_3;
    }
    return auVar3;
  }
  do {
    auVar3 = *param_5;
    if (*(long *)*param_5 != param_1 || *(long *)(*param_5 + 8) != param_2) {
      return auVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_5,0x10);
    if (bVar2) {
      *(undefined8 *)*param_5 = param_3;
      *(undefined8 *)(*param_5 + 4) = param_4;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return auVar3;
}



undefined __aarch64_swp1_relax(undefined param_1,undefined *param_2)

{
  undefined uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = param_1;
  return uVar1;
}



undefined __aarch64_swp1_acq(undefined param_1,undefined *param_2)

{
  undefined uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = param_1;
  return uVar1;
}



undefined __aarch64_swp1_rel(undefined param_1,undefined *param_2)

{
  undefined uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar1;
}



undefined __aarch64_swp1_acq_rel(undefined param_1,undefined *param_2)

{
  undefined uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar1;
}



undefined2 __aarch64_swp2_relax(undefined2 param_1,undefined2 *param_2)

{
  undefined2 uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = param_1;
  return uVar1;
}



undefined2 __aarch64_swp2_acq(undefined2 param_1,undefined2 *param_2)

{
  undefined2 uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = param_1;
  return uVar1;
}



undefined2 __aarch64_swp2_rel(undefined2 param_1,undefined2 *param_2)

{
  undefined2 uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar1;
}



undefined2 __aarch64_swp2_acq_rel(undefined2 param_1,undefined2 *param_2)

{
  undefined2 uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar1;
}



undefined4 __aarch64_swp4_relax(undefined4 param_1,undefined4 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined4 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = param_1;
  return uVar3;
}



undefined4 __aarch64_swp4_acq(undefined4 param_1,undefined4 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined4 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = param_1;
  return uVar3;
}



undefined4 __aarch64_swp4_rel(undefined4 param_1,undefined4 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined4 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar3;
}



undefined4 __aarch64_swp4_acq_rel(undefined4 param_1,undefined4 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined4 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar3;
}



undefined8 __aarch64_swp8_relax(undefined8 param_1,undefined8 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined8 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = param_1;
  return uVar3;
}



undefined8 __aarch64_swp8_acq(undefined8 param_1,undefined8 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined8 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = param_1;
  return uVar3;
}



undefined8 __aarch64_swp8_rel(undefined8 param_1,undefined8 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined8 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar3;
}



undefined8 __aarch64_swp8_acq_rel(undefined8 param_1,undefined8 *param_2)

{
  char cVar1;
  bool bVar2;
  undefined8 uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = param_1;
  LORelease();
  return uVar3;
}



char __aarch64_ldadd1_relax(char param_1,char *param_2)

{
  char cVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      cVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = cVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return cVar1;
  }
  cVar1 = *param_2;
  *param_2 = cVar1 + param_1;
  return cVar1;
}



char __aarch64_ldadd1_acq(char param_1,char *param_2)

{
  char cVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      cVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = cVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return cVar1;
  }
  LOAcquire();
  cVar1 = *param_2;
  *param_2 = cVar1 + param_1;
  return cVar1;
}



char __aarch64_ldadd1_rel(char param_1,char *param_2)

{
  char cVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      cVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = cVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return cVar1;
  }
  cVar1 = *param_2;
  *param_2 = cVar1 + param_1;
  LORelease();
  return cVar1;
}



char __aarch64_ldadd1_acq_rel(char param_1,char *param_2)

{
  char cVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      cVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = cVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return cVar1;
  }
  LOAcquire();
  cVar1 = *param_2;
  *param_2 = cVar1 + param_1;
  LORelease();
  return cVar1;
}



short __aarch64_ldadd2_relax(short param_1,short *param_2)

{
  short sVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      sVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = sVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return sVar1;
  }
  sVar1 = *param_2;
  *param_2 = sVar1 + param_1;
  return sVar1;
}



short __aarch64_ldadd2_acq(short param_1,short *param_2)

{
  short sVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      sVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = sVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return sVar1;
  }
  LOAcquire();
  sVar1 = *param_2;
  *param_2 = sVar1 + param_1;
  return sVar1;
}



short __aarch64_ldadd2_rel(short param_1,short *param_2)

{
  short sVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      sVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = sVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return sVar1;
  }
  sVar1 = *param_2;
  *param_2 = sVar1 + param_1;
  LORelease();
  return sVar1;
}



short __aarch64_ldadd2_acq_rel(short param_1,short *param_2)

{
  short sVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      sVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = sVar1 + param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return sVar1;
  }
  LOAcquire();
  sVar1 = *param_2;
  *param_2 = sVar1 + param_1;
  LORelease();
  return sVar1;
}



int __aarch64_ldadd4_relax(int param_1,int *param_2)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      iVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = iVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return iVar3;
  }
  iVar3 = *param_2;
  *param_2 = iVar3 + param_1;
  return iVar3;
}



int __aarch64_ldadd4_acq(int param_1,int *param_2)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      iVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = iVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return iVar3;
  }
  LOAcquire();
  iVar3 = *param_2;
  *param_2 = iVar3 + param_1;
  return iVar3;
}



int __aarch64_ldadd4_rel(int param_1,int *param_2)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      iVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = iVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return iVar3;
  }
  iVar3 = *param_2;
  *param_2 = iVar3 + param_1;
  LORelease();
  return iVar3;
}



int __aarch64_ldadd4_acq_rel(int param_1,int *param_2)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      iVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = iVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return iVar3;
  }
  LOAcquire();
  iVar3 = *param_2;
  *param_2 = iVar3 + param_1;
  LORelease();
  return iVar3;
}



long __aarch64_ldadd8_relax(long param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      lVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = lVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return lVar3;
  }
  lVar3 = *param_2;
  *param_2 = lVar3 + param_1;
  return lVar3;
}



long __aarch64_ldadd8_acq(long param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      lVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = lVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return lVar3;
  }
  LOAcquire();
  lVar3 = *param_2;
  *param_2 = lVar3 + param_1;
  return lVar3;
}



long __aarch64_ldadd8_rel(long param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      lVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = lVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return lVar3;
  }
  lVar3 = *param_2;
  *param_2 = lVar3 + param_1;
  LORelease();
  return lVar3;
}



long __aarch64_ldadd8_acq_rel(long param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      lVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = lVar3 + param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return lVar3;
  }
  LOAcquire();
  lVar3 = *param_2;
  *param_2 = lVar3 + param_1;
  LORelease();
  return lVar3;
}



byte __aarch64_ldclr1_relax(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 & (param_1 ^ 0xff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  bVar1 = *param_2;
  *param_2 = bVar1 & ~param_1;
  return bVar1;
}



byte __aarch64_ldclr1_acq(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 & (param_1 ^ 0xff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  LOAcquire();
  bVar1 = *param_2;
  *param_2 = bVar1 & ~param_1;
  return bVar1;
}



byte __aarch64_ldclr1_rel(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 & (param_1 ^ 0xff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  bVar1 = *param_2;
  *param_2 = bVar1 & ~param_1;
  LORelease();
  return bVar1;
}



byte __aarch64_ldclr1_acq_rel(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 & (param_1 ^ 0xff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  LOAcquire();
  bVar1 = *param_2;
  *param_2 = bVar1 & ~param_1;
  LORelease();
  return bVar1;
}



ushort __aarch64_ldclr2_relax(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 & (param_1 ^ 0xffff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = uVar1 & ~param_1;
  return uVar1;
}



ushort __aarch64_ldclr2_acq(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 & (param_1 ^ 0xffff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = uVar1 & ~param_1;
  return uVar1;
}



ushort __aarch64_ldclr2_rel(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 & (param_1 ^ 0xffff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = uVar1 & ~param_1;
  LORelease();
  return uVar1;
}



ushort __aarch64_ldclr2_acq_rel(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 & (param_1 ^ 0xffff);
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = uVar1 & ~param_1;
  LORelease();
  return uVar1;
}



uint __aarch64_ldclr4_relax(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  return uVar3;
}



uint __aarch64_ldclr4_acq(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  return uVar3;
}



uint __aarch64_ldclr4_rel(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  LORelease();
  return uVar3;
}



uint __aarch64_ldclr4_acq_rel(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  LORelease();
  return uVar3;
}



ulong __aarch64_ldclr8_relax(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffffffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  return uVar3;
}



ulong __aarch64_ldclr8_acq(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffffffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  return uVar3;
}



ulong __aarch64_ldclr8_rel(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffffffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  LORelease();
  return uVar3;
}



ulong __aarch64_ldclr8_acq_rel(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 & (param_1 ^ 0xffffffffffffffff);
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 & ~param_1;
  LORelease();
  return uVar3;
}



byte __aarch64_ldeor1_relax(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  bVar1 = *param_2;
  *param_2 = bVar1 ^ param_1;
  return bVar1;
}



byte __aarch64_ldeor1_acq(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  LOAcquire();
  bVar1 = *param_2;
  *param_2 = bVar1 ^ param_1;
  return bVar1;
}



byte __aarch64_ldeor1_rel(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  bVar1 = *param_2;
  *param_2 = bVar1 ^ param_1;
  LORelease();
  return bVar1;
}



byte __aarch64_ldeor1_acq_rel(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  LOAcquire();
  bVar1 = *param_2;
  *param_2 = bVar1 ^ param_1;
  LORelease();
  return bVar1;
}



ushort __aarch64_ldeor2_relax(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = uVar1 ^ param_1;
  return uVar1;
}



ushort __aarch64_ldeor2_acq(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = uVar1 ^ param_1;
  return uVar1;
}



ushort __aarch64_ldeor2_rel(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = uVar1 ^ param_1;
  LORelease();
  return uVar1;
}



ushort __aarch64_ldeor2_acq_rel(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 ^ param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = uVar1 ^ param_1;
  LORelease();
  return uVar1;
}



uint __aarch64_ldeor4_relax(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  return uVar3;
}



uint __aarch64_ldeor4_acq(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  return uVar3;
}



uint __aarch64_ldeor4_rel(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  LORelease();
  return uVar3;
}



uint __aarch64_ldeor4_acq_rel(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  LORelease();
  return uVar3;
}



ulong __aarch64_ldeor8_relax(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  return uVar3;
}



ulong __aarch64_ldeor8_acq(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  return uVar3;
}



ulong __aarch64_ldeor8_rel(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  LORelease();
  return uVar3;
}



ulong __aarch64_ldeor8_acq_rel(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 ^ param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 ^ param_1;
  LORelease();
  return uVar3;
}



byte __aarch64_ldset1_relax(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  bVar1 = *param_2;
  *param_2 = bVar1 | param_1;
  return bVar1;
}



byte __aarch64_ldset1_acq(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  LOAcquire();
  bVar1 = *param_2;
  *param_2 = bVar1 | param_1;
  return bVar1;
}



byte __aarch64_ldset1_rel(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  bVar1 = *param_2;
  *param_2 = bVar1 | param_1;
  LORelease();
  return bVar1;
}



byte __aarch64_ldset1_acq_rel(byte param_1,byte *param_2)

{
  byte bVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      bVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = bVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return bVar1;
  }
  LOAcquire();
  bVar1 = *param_2;
  *param_2 = bVar1 | param_1;
  LORelease();
  return bVar1;
}



ushort __aarch64_ldset2_relax(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = uVar1 | param_1;
  return uVar1;
}



ushort __aarch64_ldset2_acq(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = uVar1 | param_1;
  return uVar1;
}



ushort __aarch64_ldset2_rel(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  uVar1 = *param_2;
  *param_2 = uVar1 | param_1;
  LORelease();
  return uVar1;
}



ushort __aarch64_ldset2_acq_rel(ushort param_1,ushort *param_2)

{
  ushort uVar1;
  char cVar2;
  bool bVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar1 = *param_2;
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar3) {
        *param_2 = uVar1 | param_1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    return uVar1;
  }
  LOAcquire();
  uVar1 = *param_2;
  *param_2 = uVar1 | param_1;
  LORelease();
  return uVar1;
}



uint __aarch64_ldset4_relax(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  return uVar3;
}



uint __aarch64_ldset4_acq(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  return uVar3;
}



uint __aarch64_ldset4_rel(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  LORelease();
  return uVar3;
}



uint __aarch64_ldset4_acq_rel(uint param_1,uint *param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  LORelease();
  return uVar3;
}



ulong __aarch64_ldset8_relax(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  return uVar3;
}



ulong __aarch64_ldset8_acq(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  return uVar3;
}



ulong __aarch64_ldset8_rel(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  LORelease();
  return uVar3;
}



ulong __aarch64_ldset8_acq_rel(ulong param_1,ulong *param_2)

{
  char cVar1;
  bool bVar2;
  ulong uVar3;
  
  if (___aarch64_have_lse_atomics == '\0') {
    do {
      uVar3 = *param_2;
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
      if (bVar2) {
        *param_2 = uVar3 | param_1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
    return uVar3;
  }
  LOAcquire();
  uVar3 = *param_2;
  *param_2 = uVar3 | param_1;
  LORelease();
  return uVar3;
}



// swift::swift50override_conformsToProtocol(swift::TargetMetadata<swift::InProcess> const*,
// swift::TargetProtocolDescriptor<swift::InProcess> const*,
// swift::TargetWitnessTable<swift::InProcess> const* (*)(swift::TargetMetadata<swift::InProcess>
// const*, swift::TargetProtocolDescriptor<swift::InProcess> const*))

long __thiscall
swift::swift50override_conformsToProtocol
          (swift *this,TargetMetadata *param_1,TargetProtocolDescriptor *param_2,
          _func_TargetWitnessTable_ptr_TargetMetadata_ptr_TargetProtocolDescriptor_ptr *param_3)

{
  long lVar1;
  
  if (swift50override_conformsToProtocol(swift::TargetMetadata<>const*,swift::TargetProtocolDescriptor<>const*,swift::TargetWitnessTable<>const*(*)(swift::TargetMetadata<>const*,swift::TargetProtocolDescriptor<>const*))
      ::token != -1) {
    _dispatch_once_f(&swift50override_conformsToProtocol(swift::TargetMetadata<>const*,swift::TargetProtocolDescriptor<>const*,swift::TargetWitnessTable<>const*(*)(swift::TargetMetadata<>const*,swift::TargetProtocolDescriptor<>const*))
                      ::token,(void *)0x0,registerAddImageCallback);
  }
  do {
    lVar1 = (*(code *)param_2)(this,param_1);
    if (lVar1 != 0) {
      return lVar1;
    }
    this = (swift *)_swiftoverride_class_getSuperclass((TargetMetadata *)this);
  } while (this != (swift *)0x0);
  return 0;
}



// registerAddImageCallback(void*)

void registerAddImageCallback(void *param_1)

{
  __dyld_register_func_for_add_image(addImageCallback);
  return;
}



// addImageCallback(mach_header const*, long)

void addImageCallback(mach_header *param_1,long param_2)

{
  long *plVar1;
  int iVar2;
  int *piVar3;
  int *piVar4;
  int *piVar5;
  ulong local_18;
  
  piVar4 = (int *)_getsectiondata((mach_header_64 *)param_1,"__TEXT","__swift5_proto",&local_18);
  piVar3 = piVar4;
  if (piVar4 != (int *)0x0) {
    for (; local_18 != 0; local_18 = local_18 - 4) {
      if ((((*(uint *)((long)piVar3 + (long)*piVar4 + 0xc) & 0x38) == 8) &&
          (piVar5 = (int *)((long)piVar3 + (long)*piVar4 + 4), iVar2 = *piVar5,
          plVar1 = (long *)((long)iVar2 + (long)piVar5), iVar2 != 0 && plVar1 != (long *)0x0)) &&
         (*plVar1 == 0)) {
        *plVar1 = (long)&_DummyTargetContextDescriptor;
      }
      piVar4 = piVar4 + 1;
      piVar3 = piVar3 + 1;
    }
  }
  return;
}



// _swiftoverride_class_getSuperclass(swift::TargetMetadata<swift::InProcess> const*)

long _swiftoverride_class_getSuperclass(TargetMetadata *param_1)

{
  long lVar1;
  long lVar2;
  int iVar3;
  ulong uVar4;
  undefined8 uVar5;
  TargetMetadata *pTVar6;
  
  uVar4 = *(ulong *)param_1;
  iVar3 = 0;
  if (uVar4 < 0x800) {
    iVar3 = (int)uVar4;
  }
  if (iVar3 == 0x305) {
    pTVar6 = *(TargetMetadata **)(param_1 + 8);
    if (pTVar6 == (TargetMetadata *)0x0) goto LAB_00032858;
  }
  else if ((iVar3 != 0) || (pTVar6 = param_1, param_1 == (TargetMetadata *)0x0)) goto LAB_00032858;
  lVar2 = *(long *)(pTVar6 + 8);
  if (lVar2 != 0) {
    lVar1 = swift::getRootSuperclass();
    if (lVar2 != lVar1) {
      uVar5 = *(undefined8 *)(pTVar6 + 8);
      if (DAT_00057910 != -1) {
        _dispatch_once_f(&DAT_00057910,
                         &getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1::
                          operator()()::TheLazy,const::{lambda(void*)#1}::__invoke);
      }
                    // WARNING: Could not recover jumptable at 0x00032850. Too many branches
                    // WARNING: Treating indirect jump as call
      lVar2 = (*getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1::operator()()::TheLazy
              )(uVar5);
      return lVar2;
    }
    uVar4 = *(ulong *)param_1;
  }
LAB_00032858:
  if (((0x7ff < uVar4) || ((int)uVar4 != 0x203)) || (lVar2 = *(long *)(param_1 + 0x10), lVar2 == 0))
  {
    lVar2 = 0;
  }
  return lVar2;
}



// WARNING: Removing unreachable block (ram,0x000328c0)
// WARNING: Removing unreachable block (ram,0x000328c8)
// WARNING: Unknown calling convention -- yet parameter storage is locked
// installGetClassHook_untrusted()

void installGetClassHook_untrusted(void)

{
  return;
}



// getObjCClassByMangledName_untrusted(char const*, objc_class**)

undefined8 getObjCClassByMangledName_untrusted(char *param_1,objc_class **param_2)

{
  char cVar1;
  undefined8 uVar2;
  char *pcVar3;
  
  cVar1 = *param_1;
  if (cVar1 != '\0') {
    pcVar3 = param_1 + 1;
    do {
      if ((byte)(cVar1 - 1U) < 0x1f) {
        *param_2 = (objc_class *)0x0;
        return 0;
      }
      cVar1 = *pcVar3;
      pcVar3 = pcVar3 + 1;
    } while (cVar1 != '\0');
  }
  if (OldGetClassHook == (code *)0x0) {
    return 0;
  }
                    // WARNING: Could not recover jumptable at 0x00032914. Too many branches
                    // WARNING: Treating indirect jump as call
  uVar2 = (*OldGetClassHook)();
  return uVar2;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// swift::getRootSuperclass()

undefined8 swift::getRootSuperclass(void)

{
  if (DAT_00057920 != -1) {
    _dispatch_once_f(&DAT_00057920,&getRootSuperclass()::$_0::operator()()::TheLazy,
                     const::{lambda(void*)#1}::__invoke);
  }
  return getRootSuperclass()::$_0::operator()()::TheLazy;
}



// WARNING: Removing unreachable block (ram,0x00032ecc)
// swift::swift51override_conformsToSwiftProtocol(swift::TargetMetadata<swift::InProcess> const*,
// swift::TargetProtocolDescriptor<swift::InProcess> const*, __swift::__runtime::llvm::StringRef,
// swift::TargetProtocolConformanceDescriptor<swift::InProcess> const*
// (*)(swift::TargetMetadata<swift::InProcess> const*,
// swift::TargetProtocolDescriptor<swift::InProcess> const*, __swift::__runtime::llvm::StringRef))

undefined8 __thiscall
swift::swift51override_conformsToSwiftProtocol
          (swift *this,TargetMetadata *param_1,TargetProtocolDescriptor *param_2,StringRef param_3,
          _func_TargetProtocolConformanceDescriptor_ptr_TargetMetadata_ptr_TargetProtocolDescriptor_ptr_StringRef
          *param_4)

{
  uint *puVar1;
  ulong *puVar2;
  code *pcVar3;
  long lVar4;
  uint uVar5;
  char cVar6;
  bool bVar7;
  bool bVar8;
  int iVar9;
  ulong **ppuVar10;
  undefined8 uVar11;
  code *UNRECOVERED_JUMPTABLE;
  TargetMetadata **ppTVar12;
  ulong *puVar13;
  ulong uVar14;
  uint uVar15;
  ulong **ppuVar16;
  ulong **ppuVar17;
  ulong uVar18;
  int *piVar19;
  int *piVar20;
  ulong **ppuVar21;
  ulong **ppuVar22;
  ulong *local_90;
  char local_80;
  undefined8 local_78;
  long local_70;
  ulong **local_68;
  
  UNRECOVERED_JUMPTABLE = (code *)param_2;
  if (DAT_00057900 != -1) {
    UNRECOVERED_JUMPTABLE = Lazy<>::defaultInitCallback;
    _dispatch_once_f(&DAT_00057900,&(anonymous_namespace)::Conformances,Lazy<>::defaultInitCallback)
    ;
  }
  ppuVar10 = (ulong **)
             (anonymous_namespace)::searchInConformanceCache
                       ((_anonymous_namespace_ *)this,param_1,
                        (TargetProtocolDescriptor *)UNRECOVERED_JUMPTABLE);
  if (local_80 != '\0') {
    return local_78;
  }
  do {
    cVar6 = '\x01';
    bVar7 = (bool)ExclusiveMonitorPass(0x57898,0x10);
    if (bVar7) {
      cVar6 = ExclusiveMonitorsStatus();
      DAT_00057898 = DAT_00057898 + 1;
    }
  } while (cVar6 != '\0');
  if (DAT_000578a0 == (ulong *)0x0) {
    local_90 = (ulong *)0x0;
    uVar18 = 0;
    if (local_70 == 0) goto LAB_00032a28;
LAB_000329f8:
    uVar14 = *(ulong *)(local_70 + 0x18);
    bVar7 = uVar18 <= uVar14;
    if (uVar14 != uVar18) {
LAB_00032a34:
      if (!bVar7) {
        do {
          piVar19 = (int *)local_90[uVar14 * 2];
          piVar20 = (int *)(local_90 + uVar14 * 2)[1];
joined_r0x00032a68:
          if (piVar19 != piVar20) {
LAB_00032a88:
            puVar2 = (ulong *)((long)*piVar19 + (long)piVar19);
            uVar5 = *(uint *)puVar2;
            ppuVar16 = DAT_00057888;
            if (uVar5 == 0) {
              if (param_1 != (TargetMetadata *)0x0) goto LAB_00032a7c;
            }
            else {
              ppTVar12 = (TargetMetadata **)
                         ((long)puVar2 + ((long)(int)uVar5 & 0xfffffffffffffffeU));
              if ((uVar5 & 1) != 0) {
                ppTVar12 = (TargetMetadata **)*ppTVar12;
              }
              if (ppTVar12 != (TargetMetadata **)param_1) goto LAB_00032a7c;
            }
            uVar5 = *(uint *)((long)puVar2 + 0xc) >> 3 & 7;
            if (3 < uVar5) goto LAB_00032f40;
            puVar1 = (uint *)((long)puVar2 + 4);
            switch(uVar5) {
            case 0:
              uVar15 = *puVar1;
              if (uVar15 != 0) {
                ppuVar22 = (ulong **)((long)(int)uVar15 + (long)puVar1);
                if (ppuVar22 != (ulong **)0x0) goto LAB_00032b20;
LAB_00032afc:
                if (uVar5 == 0) {
                  if (uVar15 == 0) goto LAB_00032c18;
                  ppuVar16 = (ulong **)((long)puVar1 + (long)(int)uVar15);
                }
                else {
                  if (uVar5 != 1) {
LAB_00032f40:
                    swift_unreachable((char *)ppuVar10);
                    // WARNING: Treating indirect jump as call
                    UNRECOVERED_JUMPTABLE = (code *)UndefinedInstructionException(0x10,0x32f44);
                    uVar11 = (*UNRECOVERED_JUMPTABLE)();
                    return uVar11;
                  }
                  ppuVar16 = *(ulong ***)((long)puVar1 + (long)(int)uVar15);
                }
                if (ppuVar16 == (ulong **)0x0) goto LAB_00032c18;
                uVar5 = *(uint *)ppuVar16;
                ppuVar22 = (ulong **)0x0;
                if ((uVar5 & 0x10) != 0) {
                  ppuVar22 = ppuVar16;
                }
                if ((uVar5 >> 4 & 1) != 0) {
                  if ((-1 < *(char *)ppuVar22) &&
                     (iVar9 = *(int *)((long)ppuVar22 + 0xc),
                     pcVar3 = (code *)((long)iVar9 + (long)(int *)((long)ppuVar22 + 0xc)),
                     iVar9 != 0 && pcVar3 != (code *)0x0)) {
                    ppuVar10 = (ulong **)(*pcVar3)(0xff);
                    goto LAB_00032b88;
                  }
                  goto LAB_00032c18;
                }
                if ((uVar5 & 0x1f) != 3) goto LAB_00032c18;
                uVar5 = *(uint *)ppuVar16;
                local_68 = ppuVar16;
                if (DAT_00057940 != -1) {
                  _dispatch_once_f(&DAT_00057940,
                                   &getExistentialTypeMetadata(swift::ProtocolClassConstraint,swift::TargetMetadata<>const*,unsigned_long,swift::TargetProtocolDescriptorRef<>const*)
                                    ::$_3::operator()()::TheLazy,const::{lambda(void*)#1}::__invoke)
                  ;
                }
                UNRECOVERED_JUMPTABLE = (code *)((long)&mach_header_00000000.magic + 1);
                ppuVar10 = (ulong **)
                           (*getExistentialTypeMetadata(swift::ProtocolClassConstraint,swift::TargetMetadata<>const*,unsigned_long,swift::TargetProtocolDescriptorRef<>const*)
                             ::$_3::operator()()::TheLazy)(uVar5 >> 0x10 & 1,0,1,&local_68);
                goto LAB_00032b88;
              }
              goto LAB_00032c18;
            case 1:
              uVar15 = *puVar1;
              ppuVar22 = *(ulong ***)((long)(int)uVar15 + (long)puVar1);
              if (ppuVar22 == (ulong **)0x0) goto LAB_00032afc;
LAB_00032b20:
              bVar7 = false;
              goto joined_r0x00032b24;
            case 2:
              lVar4 = 0;
              if (*puVar1 != 0) {
                lVar4 = (long)(int)*puVar1 + (long)puVar1;
              }
              ppuVar16 = (ulong **)_objc_lookUpClass(lVar4);
              ppuVar10 = ppuVar16;
              break;
            case 3:
              ppuVar16 = *(ulong ***)((long)(int)*puVar1 + (long)puVar1);
            }
            if (ppuVar16 == (ulong **)0x0) {
LAB_00032c18:
              bVar7 = false;
              ppuVar22 = (ulong **)0x0;
            }
            else {
              if (DAT_00057910 != -1) {
                UNRECOVERED_JUMPTABLE = const::{lambda(void*)#1}::__invoke;
                _dispatch_once_f(&DAT_00057910,
                                 &getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1::
                                  operator()()::TheLazy,const::{lambda(void*)#1}::__invoke);
              }
              ppuVar10 = (ulong **)
                         (*getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1::
                           operator()()::TheLazy)(ppuVar16);
LAB_00032b88:
              bVar7 = ppuVar10 != (ulong **)0x0;
              ppuVar22 = ppuVar10;
            }
joined_r0x00032b24:
            ppuVar17 = (ulong **)this;
            ppuVar16 = DAT_00057888;
            if (this != (swift *)0x0) {
LAB_00032c28:
              if (bVar7) {
                if (ppuVar22 == ppuVar17) goto LAB_00032d84;
LAB_00032c34:
                puVar13 = *ppuVar17;
                iVar9 = 0;
                if (puVar13 < (ulong *)0x800) {
                  iVar9 = (int)puVar13;
                }
                if (iVar9 == 0x305) {
                  ppuVar16 = (ulong **)ppuVar17[1];
                  if (ppuVar16 != (ulong **)0x0) goto LAB_00032c98;
LAB_00032d28:
                  ppuVar16 = DAT_00057888;
                  if (((section_000007e0.segname + 0xf < puVar13) || ((int)puVar13 != 0x203)) ||
                     (ppuVar21 = (ulong **)ppuVar17[2], (ulong **)ppuVar17[2] == (ulong **)0x0))
                  goto LAB_00032a7c;
                }
                else {
                  if ((iVar9 != 0) || (ppuVar16 = ppuVar17, ppuVar17 == (ulong **)0x0))
                  goto LAB_00032d28;
LAB_00032c98:
                  ppuVar21 = (ulong **)ppuVar16[1];
                  if (ppuVar21 == (ulong **)0x0) goto LAB_00032d28;
                  ppuVar10 = (ulong **)getRootSuperclass();
                  if (ppuVar21 == ppuVar10) {
                    puVar13 = *ppuVar17;
                    goto LAB_00032d28;
                  }
                  puVar13 = ppuVar16[1];
                  if (DAT_00057910 != -1) {
                    UNRECOVERED_JUMPTABLE = const::{lambda(void*)#1}::__invoke;
                    _dispatch_once_f(&DAT_00057910,
                                     &getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1
                                      ::operator()()::TheLazy,const::{lambda(void*)#1}::__invoke);
                  }
                  ppuVar10 = (ulong **)
                             (*getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1::
                               operator()()::TheLazy)(puVar13);
                  ppuVar21 = ppuVar10;
                }
                ppuVar17 = ppuVar21;
                ppuVar16 = DAT_00057888;
                if (ppuVar21 == (ulong **)0x0) goto LAB_00032a7c;
                goto LAB_00032c28;
              }
              if (DAT_00057930 != -1) {
                UNRECOVERED_JUMPTABLE = const::{lambda(void*)#1}::__invoke;
                _dispatch_once_f(&DAT_00057930,
                                 &getTypeContextDescriptor(swift::TargetMetadata<>const*)::$_2::
                                  operator()()::TheLazy,const::{lambda(void*)#1}::__invoke);
              }
              ppuVar10 = (ulong **)
                         (*getTypeContextDescriptor(swift::TargetMetadata<>const*)::$_2::
                           operator()()::TheLazy)(ppuVar17);
              if (ppuVar10 == (ulong **)0x0) {
                if (((*ppuVar17 < &section_000007e0.addr) && ((int)*ppuVar17 == 0x303)) &&
                   (*(int *)((long)ppuVar17 + 0xc) == 1)) {
                  if ((((*(uint *)(ppuVar17 + 1) >> 0x1e & 1) == 0) || (ppuVar17[2] == (ulong *)0x0)
                      ) && (puVar13 = (ppuVar17 + 2)[(ulong)(*(uint *)(ppuVar17 + 1) >> 0x1e) & 1],
                           ((ulong)puVar13 & 1) == 0)) {
                    ppuVar10 = (ulong **)((ulong)puVar13 & 0xfffffffffffffffe);
                    if (ppuVar10 != (ulong **)0x0) goto LAB_00032c80;
                    ppuVar10 = (ulong **)0x0;
                  }
                }
                goto LAB_00032c34;
              }
              if (ppuVar10 == (ulong **)0x0) goto LAB_00032c34;
LAB_00032c80:
              ppuVar10 = (ulong **)
                         (anonymous_namespace)::override_equalContexts
                                   ((TargetContextDescriptor *)ppuVar10,
                                    (TargetContextDescriptor *)ppuVar22);
              if (((ulong)ppuVar10 & 1) == 0) goto LAB_00032c34;
              ppuVar22 = (ulong **)0x0;
LAB_00032d84:
              ppuVar17 = (ulong **)this;
              if (ppuVar22 != (ulong **)0x0) {
                ppuVar17 = ppuVar22;
              }
              if (((DAT_00057888 == (ulong **)0x0) || ((ulong **)DAT_00057888[2] != ppuVar17)) ||
                 (ppuVar16 = DAT_00057888, DAT_00057888[3] != (ulong *)param_1)) {
                ppuVar10 = (ulong **)0x0;
                ppuVar22 = (ulong **)&(anonymous_namespace)::Conformances;
LAB_00032dd4:
                ppuVar16 = (ulong **)*ppuVar22;
                if (ppuVar16 == (ulong **)0x0) {
                  if (ppuVar10 == (ulong **)0x0) {
                    UNRECOVERED_JUMPTABLE = (code *)(segment_command_00000020.segname + 8);
                    iVar9 = _posix_memalign(&local_68,8,0x30);
                    if (iVar9 != 0) {
                    // WARNING: Subroutine does not return
                      _abort();
                    }
                    *local_68 = (ulong *)0x0;
                    local_68[1] = (ulong *)0x0;
                    local_68[2] = (ulong *)ppuVar17;
                    local_68[3] = (ulong *)param_1;
                    local_68[4] = puVar2;
                    local_68[5] = (ulong *)0x0;
                    ppuVar10 = local_68;
                  }
                  while (ppuVar16 = (ulong **)*ppuVar22, ppuVar16 == (ulong **)0x0) {
                    cVar6 = '\x01';
                    bVar7 = (bool)ExclusiveMonitorPass(ppuVar22,0x10);
                    if (bVar7) {
                      *ppuVar22 = (ulong *)ppuVar10;
                      cVar6 = ExclusiveMonitorsStatus();
                    }
                    ppuVar16 = ppuVar10;
                    if (cVar6 == '\0') goto LAB_00032a7c;
                  }
                  ClearExclusiveLocal();
                }
                bVar8 = ppuVar17 <= ppuVar16[2];
                bVar7 = (ulong **)ppuVar16[2] == ppuVar17;
                if (bVar7) {
                  bVar8 = param_1 <= ppuVar16[3];
                  bVar7 = ppuVar16[3] == (ulong *)param_1;
                  if (bVar7) goto code_r0x00032e44;
                }
                ppuVar22 = ppuVar16;
                if (!bVar8 || bVar7) {
                  ppuVar22 = ppuVar16 + 1;
                }
                goto LAB_00032dd4;
              }
              goto LAB_00032e58;
            }
            goto LAB_00032a7c;
          }
LAB_00032a40:
          uVar14 = uVar14 + 1;
          if (uVar14 == uVar18) break;
        } while( true );
      }
      (anonymous_namespace)::searchInConformanceCache
                ((_anonymous_namespace_ *)this,param_1,
                 (TargetProtocolDescriptor *)UNRECOVERED_JUMPTABLE);
      (anonymous_namespace)::ConformanceState::cacheFailure
                (this,(TargetProtocolDescriptor *)param_1,uVar18);
      goto LAB_00032ef0;
    }
  }
  else {
    uVar18 = *DAT_000578a0;
    local_90 = DAT_000578a0 + 1;
    if (local_70 != 0) goto LAB_000329f8;
LAB_00032a28:
    uVar14 = 0;
    bVar7 = uVar18 == 0;
    if (uVar18 != 0) goto LAB_00032a34;
  }
  (anonymous_namespace)::ConformanceState::cacheFailure
            (this,(TargetProtocolDescriptor *)param_1,uVar18);
LAB_00032ef0:
  do {
    cVar6 = '\x01';
    bVar7 = (bool)ExclusiveMonitorPass(0x57898,0x10);
    if (bVar7) {
      cVar6 = ExclusiveMonitorsStatus();
      DAT_00057898 = DAT_00057898 + -1;
    }
  } while (cVar6 != '\0');
  return 0;
code_r0x00032e44:
  if (ppuVar10 != (ulong **)0x0) {
    _free(ppuVar10);
  }
LAB_00032e58:
  DAT_00057888 = ppuVar16;
  DAT_00057888[4] = puVar2;
  piVar19 = piVar19 + 1;
  if (piVar19 == piVar20) goto LAB_00032a40;
  goto LAB_00032a88;
LAB_00032a7c:
  DAT_00057888 = ppuVar16;
  piVar19 = piVar19 + 1;
  goto joined_r0x00032a68;
}



// swift::Lazy<(anonymous namespace)::ConformanceState>::defaultInitCallback(void*)

void swift::Lazy<>::defaultInitCallback(void *param_1)

{
  code *UNRECOVERED_JUMPTABLE;
  
  *(undefined8 *)((long)param_1 + 0x68) = 0;
  *(undefined8 *)((long)param_1 + 0x70) = 0;
  *(undefined8 *)((long)param_1 + 0x78) = 0;
  *(undefined8 *)((long)param_1 + 8) = 0;
  *(undefined8 *)param_1 = 0;
  *(undefined8 *)((long)param_1 + 0x18) = 0;
  *(undefined8 *)((long)param_1 + 0x10) = 0;
  *(undefined8 *)((long)param_1 + 0x20) = 0;
  _pthread_mutex_init((pthread_mutex_t *)((long)param_1 + 0x28),(pthread_mutexattr_t *)0x0);
  UNRECOVERED_JUMPTABLE = (code *)_dlsym(0xfffffffffffffffe,"objc_addLoadImageFunc");
  if (UNRECOVERED_JUMPTABLE != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x00032fa4. Too many branches
                    // WARNING: Treating indirect jump as call
    (*UNRECOVERED_JUMPTABLE)((anonymous_namespace)::addImageCallback);
    return;
  }
  __dyld_register_func_for_add_image((anonymous_namespace)::addImageCallback);
  return;
}



// WARNING: Type propagation algorithm not settling
// (anonymous namespace)::searchInConformanceCache(swift::TargetMetadata<swift::InProcess> const*,
// swift::TargetProtocolDescriptor<swift::InProcess> const*)

void __thiscall
(anonymous_namespace)::searchInConformanceCache
          (_anonymous_namespace_ *this,TargetMetadata *param_1,TargetProtocolDescriptor *param_2)

{
  char cVar1;
  long **pplVar2;
  bool bVar3;
  bool bVar4;
  ulong *puVar5;
  int iVar6;
  undefined8 *in_x8;
  ulong uVar7;
  ulong **ppuVar8;
  long **pplVar9;
  ulong *puVar10;
  ulong uVar11;
  ulong *puVar12;
  ulong **ppuVar13;
  ulong **ppuVar14;
  
  if (DAT_00057900 != -1) {
    _dispatch_once_f(&DAT_00057900,&Conformances,swift::Lazy<>::defaultInitCallback);
  }
  puVar12 = (ulong *)this;
  ppuVar13 = (ulong **)0x0;
  do {
    pplVar9 = Conformances;
    if (((DAT_00057888 == (long **)0x0) ||
        (ppuVar8 = (ulong **)(DAT_00057888 + 2), *ppuVar8 != puVar12)) ||
       (pplVar2 = DAT_00057888, DAT_00057888[3] != (long *)param_1)) {
      for (; ppuVar14 = ppuVar13, pplVar9 != (long **)0x0; pplVar9 = (long **)*pplVar9) {
        ppuVar8 = (ulong **)(pplVar9 + 2);
        bVar3 = puVar12 <= *ppuVar8;
        bVar4 = *ppuVar8 == puVar12;
        if (bVar4) {
          bVar3 = param_1 <= (TargetMetadata *)pplVar9[3];
          bVar4 = (TargetMetadata *)pplVar9[3] == param_1;
          pplVar2 = pplVar9;
          if (bVar4) goto LAB_0003307c;
        }
        if (!bVar3 || bVar4) {
          pplVar9 = pplVar9 + 1;
        }
      }
    }
    else {
LAB_0003307c:
      DAT_00057888 = pplVar2;
      if (ppuVar8[2] != (ulong *)0x0) {
        ppuVar8 = ppuVar8 + 2;
        goto LAB_00033248;
      }
      ppuVar14 = ppuVar8;
      if (puVar12 != (ulong *)this) {
        ppuVar14 = ppuVar13;
      }
      do {
        cVar1 = '\x01';
        bVar4 = (bool)ExclusiveMonitorPass(0x57898,0x10);
        if (bVar4) {
          cVar1 = ExclusiveMonitorsStatus();
          DAT_00057898 = DAT_00057898 + 1;
        }
      } while (cVar1 != '\0');
      pplVar9 = DAT_000578a0;
      if (DAT_000578a0 != (long **)0x0) {
        pplVar9 = (long **)*DAT_000578a0;
      }
      do {
        cVar1 = '\x01';
        bVar4 = (bool)ExclusiveMonitorPass(0x57898,0x10);
        if (bVar4) {
          cVar1 = ExclusiveMonitorsStatus();
          DAT_00057898 = DAT_00057898 + -1;
        }
      } while (cVar1 != '\0');
      if ((long **)ppuVar8[3] == pplVar9) {
        *(bool *)in_x8 = puVar12 == (ulong *)this;
        in_x8[1] = 0;
        in_x8[2] = ppuVar14;
        return;
      }
    }
    if (DAT_00057930 != -1) {
      _dispatch_once_f(&DAT_00057930,
                       &getTypeContextDescriptor(swift::TargetMetadata<>const*)::$_2::operator()()::
                        TheLazy,const::{lambda(void*)#1}::__invoke);
    }
    puVar5 = (ulong *)(*getTypeContextDescriptor(swift::TargetMetadata<>const*)::$_2::operator()()::
                        TheLazy)(puVar12);
    puVar10 = puVar12;
    if (puVar5 != (ulong *)0x0) {
      puVar10 = puVar5;
    }
    pplVar9 = Conformances;
    if (((DAT_00057888 == (long **)0x0) || ((ulong *)DAT_00057888[2] != puVar10)) ||
       (pplVar2 = DAT_00057888, DAT_00057888[3] != (long *)param_1)) {
      for (; pplVar9 != (long **)0x0; pplVar9 = (long **)*pplVar9) {
        bVar3 = puVar10 <= pplVar9[2];
        bVar4 = (ulong *)pplVar9[2] == puVar10;
        if (bVar4) {
          bVar3 = param_1 <= pplVar9[3];
          bVar4 = pplVar9[3] == (long *)param_1;
          pplVar2 = pplVar9;
          if (bVar4) goto LAB_00033148;
        }
        if (!bVar3 || bVar4) {
          pplVar9 = pplVar9 + 1;
        }
      }
    }
    else {
LAB_00033148:
      DAT_00057888 = pplVar2;
      if (DAT_00057888[4] != (long *)0x0) {
        ppuVar8 = (ulong **)(DAT_00057888 + 4);
LAB_00033248:
        puVar12 = *ppuVar8;
        *(undefined *)in_x8 = 1;
        in_x8[1] = puVar12;
        in_x8[2] = 0;
        return;
      }
    }
    uVar7 = *puVar12;
    iVar6 = 0;
    if (uVar7 < 0x800) {
      iVar6 = (int)uVar7;
    }
    if (iVar6 == 0x305) {
      puVar10 = (ulong *)puVar12[1];
      if (puVar10 != (ulong *)0x0) goto LAB_0003317c;
LAB_000331c0:
      if (((0x7ff < uVar7) || ((int)uVar7 != 0x203)) ||
         (puVar12 = (ulong *)puVar12[2], puVar12 == (ulong *)0x0)) break;
    }
    else {
      if ((iVar6 != 0) || (puVar10 = puVar12, puVar12 == (ulong *)0x0)) goto LAB_000331c0;
LAB_0003317c:
      uVar11 = puVar10[1];
      if (uVar11 == 0) goto LAB_000331c0;
      uVar7 = swift::getRootSuperclass();
      if (uVar11 == uVar7) {
        uVar7 = *puVar12;
        goto LAB_000331c0;
      }
      uVar7 = puVar10[1];
      if (DAT_00057910 != -1) {
        _dispatch_once_f(&DAT_00057910,
                         &getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1::
                          operator()()::TheLazy,const::{lambda(void*)#1}::__invoke);
      }
      puVar12 = (ulong *)(*getObjCClassMetadata(swift::TargetClassMetadata<>const*)::$_1::
                           operator()()::TheLazy)(uVar7);
    }
    ppuVar13 = ppuVar14;
  } while (puVar12 != (ulong *)0x0);
  if (ppuVar14 == (ulong **)0x0) {
    *in_x8 = 0;
    in_x8[1] = 0;
    in_x8[2] = 0;
  }
  else {
    *(undefined *)in_x8 = 0;
    in_x8[1] = 0;
    in_x8[2] = ppuVar14;
  }
  return;
}



// (anonymous namespace)::ConformanceState::cacheFailure(void const*,
// swift::TargetProtocolDescriptor<swift::InProcess> const*, unsigned long)

void (anonymous_namespace)::ConformanceState::cacheFailure
               (void *param_1,TargetProtocolDescriptor *param_2,ulong param_3)

{
  char cVar1;
  bool bVar2;
  bool bVar3;
  int iVar4;
  undefined8 *puVar5;
  undefined8 *puVar6;
  undefined8 *puVar7;
  undefined8 *local_48;
  
  if (((DAT_00057888 == (undefined8 *)0x0) || ((void *)DAT_00057888[2] != param_1)) ||
     (puVar6 = DAT_00057888, (TargetProtocolDescriptor *)DAT_00057888[3] != param_2)) {
    puVar5 = (undefined8 *)0x0;
    puVar7 = &Conformances;
LAB_00033318:
    puVar6 = (undefined8 *)*puVar7;
    if (puVar6 == (undefined8 *)0x0) {
      if (puVar5 == (undefined8 *)0x0) {
        iVar4 = _posix_memalign(&local_48,8,0x30);
        if (iVar4 != 0) {
                    // WARNING: Subroutine does not return
          _abort();
        }
        *local_48 = 0;
        local_48[1] = 0;
        local_48[2] = param_1;
        local_48[3] = param_2;
        local_48[4] = 0;
        local_48[5] = param_3;
        puVar5 = local_48;
      }
      while (puVar6 = (undefined8 *)*puVar7, puVar6 == (undefined8 *)0x0) {
        cVar1 = '\x01';
        bVar3 = (bool)ExclusiveMonitorPass(puVar7,0x10);
        if (bVar3) {
          *puVar7 = puVar5;
          cVar1 = ExclusiveMonitorsStatus();
        }
        if (cVar1 == '\0') {
          DAT_00057888 = puVar5;
          return;
        }
      }
      ClearExclusiveLocal();
    }
    bVar2 = param_1 <= (void *)puVar6[2];
    bVar3 = (void *)puVar6[2] == param_1;
    if (bVar3) {
      bVar2 = param_2 <= (TargetProtocolDescriptor *)puVar6[3];
      bVar3 = (TargetProtocolDescriptor *)puVar6[3] == param_2;
      if (bVar3) goto code_r0x00033388;
    }
    puVar7 = puVar6;
    if (!bVar2 || bVar3) {
      puVar7 = puVar6 + 1;
    }
    goto LAB_00033318;
  }
LAB_00033394:
  DAT_00057888 = puVar6;
  DAT_00057888[5] = param_3;
  return;
code_r0x00033388:
  if (puVar5 != (undefined8 *)0x0) {
    _free(puVar5);
  }
  goto LAB_00033394;
}



// __invoke(void*)

void const::{lambda(void*)#1}::__invoke(void *param_1)

{
  undefined8 uVar1;
  
  uVar1 = _dlsym(0xfffffffffffffffe,"swift_getObjCClassMetadata");
  *(undefined8 *)param_1 = uVar1;
  return;
}



// __invoke(void*)

void const::{lambda(void*)#1}::__invoke(void *param_1)

{
  undefined8 uVar1;
  
  uVar1 = _objc_getClass("_TtCs12_SwiftObject");
  *(undefined8 *)param_1 = uVar1;
  return;
}



// __invoke(void*)

void const::{lambda(void*)#1}::__invoke(void *param_1)

{
  undefined8 uVar1;
  
  uVar1 = _dlsym(0xfffffffffffffffe,"swift_getTypeContextDescriptor");
  *(undefined8 *)param_1 = uVar1;
  return;
}



// swift_unreachable(char const*)

void swift_unreachable(char *param_1)

{
                    // WARNING: Subroutine does not return
  _abort();
}



// __invoke(void*)

void const::{lambda(void*)#1}::__invoke(void *param_1)

{
  undefined8 uVar1;
  
  uVar1 = _dlsym(0xfffffffffffffffe,"swift_getExistentialTypeMetadata");
  *(undefined8 *)param_1 = uVar1;
  return;
}



// (anonymous namespace)::override_equalContexts(swift::TargetContextDescriptor<swift::InProcess>
// const*, swift::TargetContextDescriptor<swift::InProcess> const*)

ulong (anonymous_namespace)::override_equalContexts
                (TargetContextDescriptor *param_1,TargetContextDescriptor *param_2)

{
  char *pcVar1;
  char *pcVar2;
  uint uVar3;
  uint uVar4;
  char cVar5;
  uint uVar6;
  char *pcVar7;
  int iVar8;
  undefined8 *puVar9;
  ulong uVar10;
  size_t sVar11;
  size_t sVar12;
  undefined8 *puVar13;
  char *pcVar14;
  char *pcVar15;
  char *pcVar16;
  char *pcVar17;
  char *pcVar18;
  
  if (param_1 == param_2) {
    return 1;
  }
  if (param_1 == (TargetContextDescriptor *)0x0) {
    return 0;
  }
  if (param_2 == (TargetContextDescriptor *)0x0) {
    return 0;
  }
  uVar3 = *(uint *)param_1;
  if ((((uVar3 >> 6 & 1) == 0) && (uVar4 = *(uint *)param_2, (uVar4 >> 6 & 1) == 0)) &&
     (((uVar4 ^ uVar3) & 0x1f) == 0)) {
    uVar6 = *(uint *)(param_1 + 4);
    if (uVar6 == 0) {
      puVar9 = (undefined8 *)0x0;
    }
    else {
      puVar9 = (undefined8 *)(((long)(int)uVar6 & 0xfffffffffffffffeU) + (long)(param_1 + 4));
      if ((uVar6 & 1) != 0) {
        puVar9 = (undefined8 *)*puVar9;
      }
    }
    uVar6 = *(uint *)(param_2 + 4);
    if (uVar6 == 0) {
      puVar13 = (undefined8 *)0x0;
    }
    else {
      puVar13 = (undefined8 *)(((long)(int)uVar6 & 0xfffffffffffffffeU) + (long)(param_2 + 4));
      if ((uVar6 & 1) != 0) {
        puVar13 = (undefined8 *)*puVar13;
      }
    }
    uVar10 = override_equalContexts
                       ((TargetContextDescriptor *)puVar9,(TargetContextDescriptor *)puVar13);
    if ((int)uVar10 == 0) {
      return uVar10;
    }
    if (1 < (uVar3 & 0x1f) - 1) {
      if ((uVar3 & 0x1f) == 0) {
        iVar8 = _strcmp((char *)((long)*(int *)(param_1 + 8) + (long)(param_1 + 8)),
                        (char *)((long)*(int *)(param_2 + 8) + (long)(param_2 + 8)));
LAB_00033550:
        return (ulong)(iVar8 == 0);
      }
      if ((uVar3 >> 4 & 1) != 0) {
        pcVar15 = (char *)((long)*(int *)(param_1 + 8) + (long)(param_1 + 8));
        if (pcVar15 == (char *)0x0) {
          sVar11 = 0;
        }
        else {
          sVar11 = _strlen(pcVar15);
        }
        if ((uVar3 >> 0x12 & 1) != 0) {
          pcVar18 = pcVar15 + sVar11;
          pcVar14 = pcVar15 + sVar11;
          while( true ) {
            pcVar16 = pcVar14 + 1;
            sVar11 = _strlen(pcVar16);
            if (sVar11 == 0) break;
            cVar5 = *pcVar16;
            pcVar16 = pcVar16 + sVar11;
            pcVar17 = pcVar15;
            if (cVar5 == 'N') {
              pcVar17 = pcVar14 + 2;
              pcVar18 = pcVar16;
            }
            pcVar2 = pcVar16;
            pcVar1 = pcVar15;
            if (cVar5 != 'R') {
              pcVar2 = pcVar18;
              pcVar1 = pcVar17;
            }
            pcVar18 = pcVar16;
            pcVar14 = pcVar16;
            if (cVar5 != 'S') {
              pcVar15 = pcVar1;
              pcVar18 = pcVar2;
            }
          }
          sVar11 = (long)pcVar18 - (long)pcVar15;
        }
        pcVar14 = (char *)((long)*(int *)(param_2 + 8) + (long)(param_2 + 8));
        if (pcVar14 == (char *)0x0) {
          sVar12 = 0;
        }
        else {
          sVar12 = _strlen(pcVar14);
        }
        if ((uVar4 >> 0x12 & 1) != 0) {
          pcVar16 = pcVar14 + sVar12;
          pcVar18 = pcVar14 + sVar12;
          while( true ) {
            pcVar17 = pcVar18 + 1;
            sVar12 = _strlen(pcVar17);
            if (sVar12 == 0) break;
            cVar5 = *pcVar17;
            pcVar17 = pcVar17 + sVar12;
            pcVar2 = pcVar14;
            if (cVar5 == 'N') {
              pcVar2 = pcVar18 + 2;
              pcVar16 = pcVar17;
            }
            pcVar1 = pcVar17;
            pcVar7 = pcVar14;
            if (cVar5 != 'R') {
              pcVar1 = pcVar16;
              pcVar7 = pcVar2;
            }
            pcVar16 = pcVar17;
            pcVar18 = pcVar17;
            if (cVar5 != 'S') {
              pcVar14 = pcVar7;
              pcVar16 = pcVar1;
            }
          }
          sVar12 = (long)pcVar16 - (long)pcVar14;
        }
        if (sVar11 == sVar12) {
          if (sVar11 == 0) {
            return 1;
          }
          iVar8 = _memcmp(pcVar15,pcVar14,sVar11);
          goto LAB_00033550;
        }
      }
    }
  }
  return 0;
}



// (anonymous namespace)::addImageCallback(mach_header const*)

uint8_t * (anonymous_namespace)::addImageCallback(mach_header *param_1)

{
  ulong **ppuVar1;
  ulong *puVar2;
  bool bVar3;
  uint uVar4;
  uint8_t *puVar5;
  ulong *puVar6;
  ulong uVar7;
  ulong uVar8;
  ulong **ppuVar9;
  ulong uVar10;
  ulong local_58;
  
  puVar5 = _getsectiondata((mach_header_64 *)param_1,"__TEXT","__swift5_proto",&local_58);
  if (puVar5 != (uint8_t *)0x0) {
    _pthread_mutex_lock((pthread_mutex_t *)&DAT_000578a8);
    puVar2 = DAT_000578a0;
    if (DAT_000578a0 == (ulong *)0x0) {
      uVar10 = 0;
    }
    else {
      uVar10 = *DAT_000578a0;
    }
    uVar7 = DAT_00057890;
    puVar6 = DAT_000578a0;
    if (DAT_00057890 <= uVar10) {
      uVar7 = uVar10 * 2;
      if (uVar7 < 0x11) {
        uVar7 = 0x10;
      }
      puVar6 = (ulong *)_malloc((uVar7 >> 1) << 5 | 8);
      if (puVar6 == (ulong *)0x0) {
LAB_00033848:
                    // WARNING: Subroutine does not return
        _abort();
      }
      *puVar6 = 0;
      if (puVar2 != (ulong *)0x0) {
        if (uVar10 != 0) {
          _memmove(puVar6 + 1,puVar2 + 1,uVar10 << 4);
        }
        *puVar6 = uVar10;
        if (DAT_000578f8 <= DAT_000578f0) {
          uVar8 = DAT_000578f8 << 1;
          bVar3 = DAT_000578f8 != 0;
          DAT_000578f8 = 8;
          if (bVar3) {
            DAT_000578f8 = uVar8;
          }
          DAT_000578e8 = (ulong **)_realloc(DAT_000578e8,DAT_000578f8 << 3);
          if (DAT_000578e8 == (ulong **)0x0) goto LAB_00033848;
        }
        ppuVar9 = DAT_000578e8 + DAT_000578f0;
        DAT_000578f0 = DAT_000578f0 + 1;
        *ppuVar9 = puVar2;
      }
    }
    DAT_000578a0 = puVar6;
    DAT_00057890 = uVar7;
    puVar2 = DAT_000578a0;
    DAT_000578a0[uVar10 * 2 + 1] = (ulong)puVar5;
    puVar2[uVar10 * 2 + 2] = (ulong)(puVar5 + local_58);
    *puVar2 = uVar10 + 1;
    if (DAT_00057898 == 0) {
      if (DAT_000578f0 != 0) {
        ppuVar1 = DAT_000578e8 + DAT_000578f0;
        ppuVar9 = DAT_000578e8;
        do {
          uVar10 = 0xffffffffffffffff;
          do {
            uVar10 = uVar10 + 1;
          } while (uVar10 < **ppuVar9);
          _free(*ppuVar9);
          ppuVar9 = ppuVar9 + 1;
        } while (ppuVar9 != ppuVar1);
      }
      _free(DAT_000578e8);
      DAT_000578e8 = (ulong **)0x0;
      DAT_000578f0 = 0;
      DAT_000578f8 = 0;
    }
    uVar4 = _pthread_mutex_unlock((pthread_mutex_t *)&DAT_000578a8);
    puVar5 = (uint8_t *)(ulong)uVar4;
  }
  return puVar5;
}



// (anonymous namespace)::addImageCallback(mach_header const*, long)

void (anonymous_namespace)::addImageCallback(mach_header *param_1,long param_2)

{
  addImageCallback(param_1);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

uchar * _CC_SHA256(void *data,CC_LONG len,uchar *md)

{
  uchar *puVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033858. Too many branches
                    // WARNING: Treating indirect jump as call
  puVar1 = (uchar *)(*(code *)PTR__CC_SHA256_000400b8)(data,len);
  return puVar1;
}



void _CFRelease(void)

{
                    // WARNING: Could not recover jumptable at 0x00033864. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFRelease_000400c0)();
  return;
}



void _CFStringConvertNSStringEncodingToEncoding(void)

{
                    // WARNING: Could not recover jumptable at 0x00033870. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFStringConvertNSStringEncodingToEncoding_000400c8)();
  return;
}



void _CFURLCreateStringByAddingPercentEscapes(void)

{
                    // WARNING: Could not recover jumptable at 0x0003387c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFURLCreateStringByAddingPercentEscapes_000400d0)();
  return;
}



void _NSClassFromString(void)

{
                    // WARNING: Could not recover jumptable at 0x00033888. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__NSClassFromString_000400d8)();
  return;
}



void _SecItemAdd(void)

{
                    // WARNING: Could not recover jumptable at 0x00033894. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__SecItemAdd_000400e0)();
  return;
}



void _SecItemCopyMatching(void)

{
                    // WARNING: Could not recover jumptable at 0x000338a0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__SecItemCopyMatching_000400e8)();
  return;
}



void _SecItemDelete(void)

{
                    // WARNING: Could not recover jumptable at 0x000338ac. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__SecItemDelete_000400f0)();
  return;
}



void _UIImageJPEGRepresentation(void)

{
                    // WARNING: Could not recover jumptable at 0x000338b8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__UIImageJPEGRepresentation_000400f8)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void __Block_object_assign(void *param_1,void *param_2,int param_3)

{
                    // WARNING: Could not recover jumptable at 0x000338c4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___Block_object_assign_00040100)(param_1,param_2,param_3);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void __Unwind_Resume(_Unwind_Exception *exception_object)

{
                    // WARNING: Could not recover jumptable at 0x000338d0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___Unwind_Resume_00040108)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::terminate()

void std::terminate(void)

{
                    // WARNING: Could not recover jumptable at 0x000338dc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_terminate_00040110)();
  return;
}



void ___cxa_begin_catch(void)

{
                    // WARNING: Could not recover jumptable at 0x000338e8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____cxa_begin_catch_00040118)();
  return;
}



void ___stack_chk_fail(void)

{
                    // WARNING: Could not recover jumptable at 0x000338f4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____stack_chk_fail_00040120)();
  return;
}



void __dyld_register_func_for_add_image(void)

{
                    // WARNING: Could not recover jumptable at 0x00033900. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___dyld_register_func_for_add_image_00040128)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _abort(void)

{
                    // WARNING: Could not recover jumptable at 0x0003390c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__abort_00040130)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double _atof(char *param_1)

{
  double dVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033918. Too many branches
                    // WARNING: Treating indirect jump as call
  dVar1 = (double)(*(code *)PTR__atof_00040138)();
  return dVar1;
}



void _dispatch_once(void)

{
                    // WARNING: Could not recover jumptable at 0x00033924. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dispatch_once_00040140)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _dispatch_once_f(dispatch_once_t *predicate,void *context,dispatch_function_t function)

{
                    // WARNING: Could not recover jumptable at 0x00033930. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dispatch_once_f_00040148)();
  return;
}



void _dlsym(void)

{
                    // WARNING: Could not recover jumptable at 0x0003393c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dlsym_00040150)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _free(void *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00033948. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__free_00040158)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

uint8_t * _getsectiondata(mach_header_64 *mhp,char *segname,char *sectname,ulong *size)

{
  uint8_t *puVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033954. Too many branches
                    // WARNING: Treating indirect jump as call
  puVar1 = (uint8_t *)(*(code *)PTR__getsectiondata_00040160)();
  return puVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _malloc(size_t param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033960. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__malloc_00040168)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _memcmp(void *param_1,void *param_2,size_t param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0003396c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__memcmp_00040170)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _memmove(void *param_1,void *param_2,size_t param_3)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033978. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__memmove_00040178)();
  return pvVar1;
}



void _objc_autorelease(void)

{
                    // WARNING: Could not recover jumptable at 0x00033984. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_autorelease_00040180)();
  return;
}



void _objc_autoreleaseReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x00033990. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_autoreleaseReturnValue_00040188)();
  return;
}



void _objc_begin_catch(void)

{
                    // WARNING: Could not recover jumptable at 0x0003399c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_begin_catch_00040190)();
  return;
}



void _objc_copyWeak(void)

{
                    // WARNING: Could not recover jumptable at 0x000339a8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_copyWeak_00040198)();
  return;
}



void _objc_destroyWeak(void)

{
                    // WARNING: Could not recover jumptable at 0x000339b4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_destroyWeak_000401a0)();
  return;
}



void _objc_end_catch(void)

{
                    // WARNING: Could not recover jumptable at 0x000339c0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_end_catch_000401a8)();
  return;
}



void _objc_enumerationMutation(void)

{
                    // WARNING: Could not recover jumptable at 0x000339cc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_enumerationMutation_000401b0)();
  return;
}



void _objc_getClass(void)

{
                    // WARNING: Could not recover jumptable at 0x000339d8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_getClass_000401b8)();
  return;
}



void _objc_getProperty(void)

{
                    // WARNING: Could not recover jumptable at 0x000339e4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_getProperty_000401c0)();
  return;
}



void _objc_initWeak(void)

{
                    // WARNING: Could not recover jumptable at 0x000339f0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_initWeak_000401c8)();
  return;
}



void _objc_loadWeakRetained(void)

{
                    // WARNING: Could not recover jumptable at 0x000339fc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_loadWeakRetained_000401d0)();
  return;
}



void _objc_lookUpClass(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a08. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_lookUpClass_000401d8)();
  return;
}



void _objc_msgSend(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a14. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_msgSend_000401e0)();
  return;
}



void _objc_msgSendSuper2(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a20. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_msgSendSuper2_000401e8)();
  return;
}



void _objc_release(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a2c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_release_000401f0)();
  return;
}



void _objc_retain(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a38. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retain_000401f8)();
  return;
}



void _objc_retainAutorelease(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a44. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutorelease_00040200)();
  return;
}



void _objc_retainAutoreleaseReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a50. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutoreleaseReturnValue_00040208)();
  return;
}



void _objc_retainAutoreleasedReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a5c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutoreleasedReturnValue_00040210)();
  return;
}



void _objc_setHook_getClass(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a68. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_setHook_getClass_00040218)();
  return;
}



void _objc_setProperty(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a74. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_setProperty_00040220)();
  return;
}



void _objc_storeStrong(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a80. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_storeStrong_00040228)();
  return;
}



void _objc_storeWeak(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a8c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_storeWeak_00040230)();
  return;
}



void _objc_sync_enter(void)

{
                    // WARNING: Could not recover jumptable at 0x00033a98. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_sync_enter_00040238)();
  return;
}



void _objc_sync_exit(void)

{
                    // WARNING: Could not recover jumptable at 0x00033aa4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_sync_exit_00040240)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _posix_memalign(void **param_1,size_t param_2,size_t param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033ab0. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__posix_memalign_00040248)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_init(pthread_mutex_t *param_1,pthread_mutexattr_t *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033abc. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_init_00040250)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_lock(pthread_mutex_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033ac8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_lock_00040258)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_unlock(pthread_mutex_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033ad4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_unlock_00040260)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long _random(void)

{
  long lVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033ae0. Too many branches
                    // WARNING: Treating indirect jump as call
  lVar1 = (*(code *)PTR__random_00040268)();
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _realloc(void *param_1,size_t param_2)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033aec. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__realloc_00040270)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _strcmp(char *param_1,char *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033af8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__strcmp_00040278)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t _strlen(char *param_1)

{
  size_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x00033b04. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__strlen_00040280)();
  return sVar1;
}


