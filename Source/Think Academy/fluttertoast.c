typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned int    dword;
typedef long long    longlong;
typedef unsigned long    qword;
typedef unsigned int    uint;
typedef unsigned long    ulong;
typedef unsigned long long    ulonglong;
typedef unsigned char    undefined1;
typedef unsigned int    undefined4;
typedef unsigned long    undefined8;
typedef unsigned short    word;
typedef qword Implementation;

typedef struct cfstringStruct cfstringStruct, *PcfstringStruct;

struct cfstringStruct {
    qword field0_0x0;
    qword field1_0x8;
    pointer field2_0x10;
    long field3_0x18;
};

typedef qword Cache;

typedef ulonglong uint64_t;

typedef ulong uintptr_t;

typedef struct method_list_t method_list_t, *Pmethod_list_t;

struct method_list_t {
    dword entsizeAndFlags;
    dword count;
};

typedef struct ivar_list_t ivar_list_t, *Pivar_list_t;

struct ivar_list_t {
    dword entsize;
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

typedef struct class_t class_t, *Pclass_t;

typedef struct class_rw_t class_rw_t, *Pclass_rw_t;

typedef struct protocol_list_t protocol_list_t, *Pprotocol_list_t;

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

struct protocol_list_t {
    qword count;
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

typedef struct ivar_t ivar_t, *Pivar_t;

struct ivar_t {
    qword *offset;
    string *name;
    string *type;
    dword alignment;
    dword size;
};

typedef struct method_list_t_1_ method_list_t_1_, *Pmethod_list_t_1_;

struct method_list_t_1_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
};

typedef struct objc_property_list_6_ objc_property_list_6_, *Pobjc_property_list_6_;

typedef struct objc_property objc_property, *Pobjc_property;

struct objc_property {
    char *name;
    char *name;
};

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

typedef struct protocol_list_t_1_ protocol_list_t_1_, *Pprotocol_list_t_1_;

struct protocol_list_t_1_ {
    qword count;
    struct protocol_t *protocol0;
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

typedef struct method_list_t_3_ method_list_t_3_, *Pmethod_list_t_3_;

struct method_list_t_3_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
    struct method_t method2;
};

typedef struct ivar_list_t_3_ ivar_list_t_3_, *Pivar_list_t_3_;

struct ivar_list_t_3_ {
    dword entsize;
    dword count;
    struct ivar_t var0;
    struct ivar_t var1;
    struct ivar_t var2;
};

typedef qword ID;

typedef struct protocol_list_t_2_ protocol_list_t_2_, *Pprotocol_list_t_2_;

struct protocol_list_t_2_ {
    qword count;
    struct protocol_t *protocol0;
    struct protocol_t *protocol1;
};

typedef struct method_list_t_2_ method_list_t_2_, *Pmethod_list_t_2_;

struct method_list_t_2_ {
    dword entsizeAndFlags;
    dword count;
    struct method_t method0;
    struct method_t method1;
};

typedef qword SEL;

typedef struct objc_image_info objc_image_info, *Pobjc_image_info;

struct objc_image_info {
    dword version;
    dword flags;
};

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

typedef uint uint32_t;

struct _Unwind_Exception {
    uint64_t exception_class;
    void (*exception_cleanup)(_Unwind_Reason_Code, struct _Unwind_Exception *);
    uintptr_t private_1;
    uintptr_t private_2;
    uint32_t reserved[3];
};

typedef uint64_t dispatch_time_t;

typedef longlong int64_t;

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




// Function Stack Size: 0x18 bytes

void FluttertoastPlugin::registerWithRegistrar_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 extraout_x1;
  undefined auVar4 [16];
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend_messenger();
  auVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_methodChannelWithName_binaryMessenger_
            (&_OBJC_CLASS___FlutterMethodChannel,auVar4._8_8_,&cf_PonnamKarthik_fluttertoast,
             auVar4._0_8_);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(auVar4._0_8_);
  _objc_alloc(&objc::class_t::FluttertoastPlugin);
  auVar4 = _objc_msgSend_init();
  uVar3 = auVar4._0_8_;
  _objc_msgSend_setChannel_(uVar3,auVar4._8_8_,uVar2);
  _objc_msgSend_addMethodCallDelegate_channel_(uVar1,extraout_x1,uVar3,uVar2);
  _objc_release(uVar1);
  _objc_release(uVar3);
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x10 bytes

ID FluttertoastPlugin::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined auVar2 [16];
  ID local_40;
  class_t *pcStack_38;
  
  pcStack_38 = &objc::class_t::FluttertoastPlugin;
  local_40 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_40,"init");
  if (IVar1 != 0) {
    _objc_msgSend_defaultCenter(&_OBJC_CLASS___NSNotificationCenter);
    auVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_addObserver_selector_name_object_
              (auVar2._0_8_,auVar2._8_8_,IVar1,"keyboardWillShow",
               *(undefined8 *)PTR__UIKeyboardWillShowNotification_00008030,0);
    _objc_release(auVar2._0_8_);
    _objc_msgSend_defaultCenter(&_OBJC_CLASS___NSNotificationCenter);
    auVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_addObserver_selector_name_object_
              (auVar2._0_8_,auVar2._8_8_,IVar1,"keyboardWillHide",
               *(undefined8 *)PTR__UIKeyboardWillHideNotification_00008028,0);
    _objc_release(auVar2._0_8_);
  }
  return IVar1;
}



// Function Stack Size: 0x10 bytes

void FluttertoastPlugin::dealloc(ID param_1,SEL param_2)

{
  undefined auVar1 [16];
  ID local_40;
  class_t *pcStack_38;
  
  _objc_msgSend_defaultCenter(&_OBJC_CLASS___NSNotificationCenter);
  auVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_removeObserver_name_object_
            (auVar1._0_8_,auVar1._8_8_,param_1,
             *(undefined8 *)PTR__UIKeyboardWillShowNotification_00008030,0);
  _objc_release(auVar1._0_8_);
  _objc_msgSend_defaultCenter(&_OBJC_CLASS___NSNotificationCenter);
  auVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_removeObserver_name_object_
            (auVar1._0_8_,auVar1._8_8_,param_1,
             *(undefined8 *)PTR__UIKeyboardWillHideNotification_00008028,0);
  _objc_release(auVar1._0_8_);
  pcStack_38 = &objc::class_t::FluttertoastPlugin;
  local_40 = param_1;
  _objc_msgSendSuper2(&local_40,"dealloc");
  return;
}



// Function Stack Size: 0x10 bytes

void FluttertoastPlugin::keyboardWillShow(ID param_1,SEL param_2)

{
  _objc_msgSend_setIsKeyboardVisible_(param_1,param_2,1);
  return;
}



// Function Stack Size: 0x10 bytes

void FluttertoastPlugin::keyboardWillHide(ID param_1,SEL param_2)

{
  _objc_msgSend_setIsKeyboardVisible_(param_1,param_2,0);
  return;
}



// Function Stack Size: 0x18 bytes

ID FluttertoastPlugin::colorWithHex_(ID param_1,SEL param_2,unsigned_long_long param_3)

{
  ID IVar1;
  double dVar2;
  
  dVar2 = 1.0;
  if (param_3 >> 0x18 != 0) {
    dVar2 = (double)(unkuint9)(param_3 >> 0x18 & 0xff) / 255.0;
  }
  IVar1 = _objc_msgSend_colorWithRed_green_blue_alpha_
                    ((double)(unkuint9)(param_3 >> 0x10 & 0xff) / 255.0,
                     (double)(unkuint9)(param_3 >> 8 & 0xff) / 255.0,
                     (double)(unkuint9)(param_3 & 0xff) / 255.0,dVar2,&_OBJC_CLASS___UIColor);
  return IVar1;
}



// Function Stack Size: 0x20 bytes

void FluttertoastPlugin::handleMethodCall_result_
               (ID param_1,SEL param_2,ID param_3,ID param_4,undefined4 param_5)

{
  int iVar1;
  int iVar2;
  undefined8 uVar3;
  long lVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined8 extraout_x1_01;
  undefined8 extraout_x1_02;
  undefined8 *puVar13;
  double dVar14;
  undefined auVar15 [16];
  undefined auStack_78 [8];
  
  uVar3 = _objc_retain(param_3);
  lVar4 = _objc_retain(param_4);
  _objc_msgSend_method(uVar3);
  auVar15 = _objc_retainAutoreleasedReturnValue();
  iVar1 = _objc_msgSend_isEqualToString_(&cf_cancel,auVar15._8_8_,auVar15._0_8_);
  _objc_release(auVar15._0_8_);
  if (iVar1 == 0) {
    _objc_msgSend_method(uVar3);
    auVar15 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend_isEqualToString_(&cf_showToast,auVar15._8_8_,auVar15._0_8_);
    _objc_release(auVar15._0_8_);
    if (iVar1 == 0) {
      (**(code **)(lVar4 + 0x10))(lVar4,*(undefined8 *)PTR__FlutterMethodNotImplemented_00008018);
    }
    else {
      _objc_msgSend_arguments(uVar3);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_objectForKeyedSubscript_(auVar15._0_8_,auVar15._8_8_,&cf_msg);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_release(auVar15._0_8_);
      _objc_msgSend_arguments(uVar3);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_objectForKeyedSubscript_(auVar15._0_8_,auVar15._8_8_,&cf_gravity);
      uVar7 = _objc_retainAutoreleasedReturnValue();
      _objc_release(auVar15._0_8_);
      _objc_msgSend_arguments(uVar3);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_objectForKeyedSubscript_(auVar15._0_8_,auVar15._8_8_,&cf_time);
      uVar8 = _objc_retainAutoreleasedReturnValue();
      _objc_release(auVar15._0_8_);
      _objc_msgSend_arguments(uVar3);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_objectForKeyedSubscript_(auVar15._0_8_,auVar15._8_8_,&cf_bgcolor);
      uVar9 = _objc_retainAutoreleasedReturnValue();
      _objc_release(auVar15._0_8_);
      _objc_msgSend_arguments(uVar3);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_objectForKeyedSubscript_(auVar15._0_8_,auVar15._8_8_,&cf_textcolor);
      uVar10 = _objc_retainAutoreleasedReturnValue();
      _objc_release(auVar15._0_8_);
      _objc_msgSend_arguments(uVar3);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_objectForKeyedSubscript_(auVar15._0_8_,auVar15._8_8_,&cf_fontSize);
      uVar11 = _objc_retainAutoreleasedReturnValue();
      _objc_release(auVar15._0_8_);
      auVar15 = _objc_msgSend_class(&_OBJC_CLASS___NSNull);
      iVar1 = _objc_msgSend_isKindOfClass_(uVar11,auVar15._8_8_,auVar15._0_8_);
      uVar5 = uVar11;
      if (iVar1 != 0) {
        auVar15 = _objc_alloc(&_OBJC_CLASS___NSNumber);
        uVar5 = _objc_msgSend_initWithInt_(auVar15._0_8_,auVar15._8_8_,0x10);
        _objc_release(uVar11);
      }
      uVar11 = _objc_msgSend_doubleValue(uVar5);
      iVar2 = _objc_msgSend_intValue(uVar8);
      iVar1 = iVar2;
      if (iVar2 < 2) {
        iVar1 = 1;
      }
      dVar14 = 10.0;
      if (iVar2 < 0xb) {
        dVar14 = (double)iVar1;
      }
      _objc_alloc(&_OBJC_CLASS___CSToastStyle);
      uVar12 = _objc_msgSend_initWithDefaultStyle();
      _objc_msgSend_systemFontOfSize_(uVar11,&_OBJC_CLASS___UIFont);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_setMessageFont_(uVar12,auVar15._8_8_,auVar15._0_8_);
      _objc_release(auVar15._0_8_);
      auVar15 = _objc_msgSend_unsignedIntegerValue(uVar9);
      _objc_msgSend_colorWithHex_(param_1,auVar15._8_8_,auVar15._0_8_);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_setBackgroundColor_(uVar12,auVar15._8_8_,auVar15._0_8_);
      _objc_release(auVar15._0_8_);
      auVar15 = _objc_msgSend_unsignedIntegerValue(uVar10);
      _objc_msgSend_colorWithHex_(param_1,auVar15._8_8_,auVar15._0_8_);
      auVar15 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_setMessageColor_(uVar12,auVar15._8_8_,auVar15._0_8_);
      _objc_release(auVar15._0_8_);
      auVar15 = _objc_msgSend_isEqualToString_(uVar7,extraout_x1_00,&cf_top);
      uVar11 = auVar15._8_8_;
      puVar13 = (undefined8 *)PTR__CSToastPositionTop_00008010;
      if (((auVar15 & (undefined  [16])0x1) == (undefined  [16])0x0) &&
         (iVar1 = _objc_msgSend_isEqualToString_(uVar7,uVar11,&cf_center), uVar11 = extraout_x1_01,
         puVar13 = (undefined8 *)PTR__CSToastPositionCenter_00008008, iVar1 == 0)) {
        puVar13 = (undefined8 *)PTR__CSToastPositionBottom_00008000;
      }
      _objc_msgSend_makeToast_duration_position_style_(dVar14,param_1,uVar11,uVar6,*puVar13,uVar12);
      _objc_msgSend_numberWithBool_(&_OBJC_CLASS___NSNumber,extraout_x1_02,1);
      uVar11 = _objc_retainAutoreleasedReturnValue();
      (**(code **)(lVar4 + 0x10))(lVar4,uVar11);
      _objc_release(uVar11);
      _objc_release(uVar12);
      _objc_release(uVar5);
      _objc_release(uVar10);
      _objc_release(uVar9);
      _objc_release(uVar8);
      _objc_release(uVar7);
      _objc_release(uVar6);
    }
  }
  else {
    _objc_initWeak(auStack_78,param_1);
    _objc_retainAutoreleasedReturnValue();
    _objc_msgSend__readKeyWindow(param_1);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_hideAllToasts();
    _objc_release(uVar5);
    _objc_release(param_1);
    _objc_msgSend_numberWithBool_(&_OBJC_CLASS___NSNumber,extraout_x1,1);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    (**(code **)(lVar4 + 0x10))(lVar4,uVar5);
    _objc_release(uVar5);
    _objc_destroyWeak(auStack_78);
  }
  _objc_release(lVar4);
  _objc_release(uVar3);
  return;
}



// Function Stack Size: 0x30 bytes

void FluttertoastPlugin::makeToast_duration_position_style_
               (ID param_1,SEL param_2,ID param_3,double param_4,ID param_5,ID param_6)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  dispatch_time_t dVar4;
  undefined *local_a0;
  undefined8 local_98;
  code *local_90;
  undefined *puStack_88;
  undefined8 local_80;
  undefined8 local_78;
  undefined8 local_70;
  undefined auStack_68 [8];
  double local_60;
  undefined auStack_58 [8];
  
  uVar1 = _objc_retain(param_3);
  uVar2 = _objc_retain(param_5);
  uVar3 = _objc_retain(param_6);
  _objc_initWeak(auStack_58,param_1);
  dVar4 = _dispatch_time(0,100000000);
  local_a0 = PTR___NSConcreteStackBlock_00008038;
  local_98 = 0xc2000000;
  local_90 = ___56__FluttertoastPlugin_makeToast_duration_position_style___block_invoke;
  puStack_88 = &___block_descriptor_72_e8_32s40s48s56w_e5_v8__0l;
  _objc_copyWeak(auStack_68,auStack_58);
  local_80 = uVar1;
  local_78 = uVar2;
  local_70 = uVar3;
  local_60 = param_4;
  uVar3 = _objc_retain(uVar3);
  uVar2 = _objc_retain(uVar2);
  uVar1 = _objc_retain(uVar1);
  _dispatch_after(dVar4,PTR___dispatch_main_q_00008050,&local_a0);
  _objc_release(local_70);
  _objc_release(local_78);
  _objc_release(local_80);
  _objc_release(uVar3);
  _objc_release(uVar2);
  _objc_release(uVar1);
  _objc_destroyWeak(auStack_68);
  _objc_destroyWeak(auStack_58);
  return;
}



void ___56__FluttertoastPlugin_makeToast_duration_position_style___block_invoke(long param_1)

{
  undefined8 uVar1;
  undefined auVar2 [16];
  
  uVar1 = _objc_loadWeakRetained(param_1 + 0x38);
  _objc_msgSend__readKeyWindow();
  auVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_makeToast_duration_position_style_
            (*(undefined8 *)(param_1 + 0x40),auVar2._0_8_,auVar2._8_8_,
             *(undefined8 *)(param_1 + 0x20),*(undefined8 *)(param_1 + 0x28),
             *(undefined8 *)(param_1 + 0x30));
  _objc_release(auVar2._0_8_);
  _objc_release(uVar1);
  return;
}



void ___copy_helper_block_e8_32s40s48s56w(long param_1,long param_2)

{
  _objc_retain(*(undefined8 *)(param_2 + 0x20));
  _objc_retain(*(undefined8 *)(param_2 + 0x28));
  _objc_retain(*(undefined8 *)(param_2 + 0x30));
  _objc_copyWeak(param_1 + 0x38,param_2 + 0x38);
  return;
}



void ___destroy_helper_block_e8_32s40s48s56w(long param_1)

{
  _objc_destroyWeak(param_1 + 0x38);
  _objc_release(*(undefined8 *)(param_1 + 0x30));
  _objc_release(*(undefined8 *)(param_1 + 0x28));
  _objc_release(*(undefined8 *)(param_1 + 0x20));
  return;
}



// Function Stack Size: 0x10 bytes

ID FluttertoastPlugin::_readKeyWindow(ID param_1,SEL param_2)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  ID IVar6;
  long lVar7;
  long lVar8;
  undefined auVar9 [16];
  undefined8 local_120;
  long lStack_118;
  long *local_110;
  undefined8 uStack_108;
  undefined8 local_100;
  undefined8 uStack_f8;
  undefined8 uStack_f0;
  undefined8 uStack_e8;
  undefined auStack_d8 [128];
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00008048;
  _objc_msgSend_sharedApplication(&_OBJC_CLASS___UIApplication);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_windows();
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar2);
  iVar1 = _objc_msgSend_isKeyboardVisible(param_1);
  if (iVar1 == 0) {
    uStack_f8 = 0;
    local_100 = 0;
    uStack_e8 = 0;
    uStack_f0 = 0;
    lStack_118 = 0;
    local_120 = 0;
    uStack_108 = 0;
    local_110 = (long *)0x0;
    auVar9 = _objc_retain(uVar3);
    uVar2 = auVar9._0_8_;
    lVar5 = _objc_msgSend_countByEnumeratingWithState_objects_count_
                      (uVar2,auVar9._8_8_,&local_120,auStack_d8,0x10);
    if (lVar5 != 0) {
      lVar7 = *local_110;
      do {
        lVar8 = 0;
        do {
          if (*local_110 != lVar7) {
            _objc_enumerationMutation(uVar2);
          }
          uVar4 = *(undefined8 *)(lStack_118 + lVar8 * 8);
          auVar9 = _objc_msgSend_isKeyWindow(uVar4);
          if ((auVar9 & (undefined  [16])0x1) != (undefined  [16])0x0) {
            uVar4 = _objc_retain(uVar4);
            _objc_release(uVar2);
            goto LAB_00006900;
          }
          lVar8 = lVar8 + 1;
        } while (lVar5 != lVar8);
        lVar5 = _objc_msgSend_countByEnumeratingWithState_objects_count_
                          (uVar2,auVar9._8_8_,&local_120,auStack_d8,0x10);
      } while (lVar5 != 0);
    }
    _objc_release(uVar2);
    uVar4 = 0;
  }
  else {
    _objc_msgSend_lastObject(uVar3);
    uVar4 = _objc_retainAutoreleasedReturnValue();
  }
LAB_00006900:
  _objc_release(uVar3);
  if (*(long *)PTR____stack_chk_guard_00008048 == local_58) {
    IVar6 = _objc_autoreleaseReturnValue(uVar4);
    return IVar6;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// Function Stack Size: 0x10 bytes

ID FluttertoastPlugin::channel(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void FluttertoastPlugin::setChannel_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

bool FluttertoastPlugin::isKeyboardVisible(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 0x10);
}



// Function Stack Size: 0x14 bytes

void FluttertoastPlugin::setIsKeyboardVisible_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 0x10) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void FluttertoastPlugin::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 8,0);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void __Unwind_Resume(_Unwind_Exception *exception_object)

{
                    // WARNING: Could not recover jumptable at 0x000069a0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___Unwind_Resume_00008068)();
  return;
}



void ___stack_chk_fail(void)

{
                    // WARNING: Could not recover jumptable at 0x000069ac. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____stack_chk_fail_00008070)();
  return;
}



void _dispatch_after(void)

{
                    // WARNING: Could not recover jumptable at 0x000069b8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dispatch_after_00008078)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

dispatch_time_t _dispatch_time(dispatch_time_t when,int64_t delta)

{
  dispatch_time_t dVar1;
  
                    // WARNING: Could not recover jumptable at 0x000069c4. Too many branches
                    // WARNING: Treating indirect jump as call
  dVar1 = (*(code *)PTR__dispatch_time_00008080)();
  return dVar1;
}



void _objc_alloc(void)

{
                    // WARNING: Could not recover jumptable at 0x000069d0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_alloc_00008088)();
  return;
}



void _objc_autoreleaseReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x000069dc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_autoreleaseReturnValue_00008090)();
  return;
}



void _objc_begin_catch(void)

{
                    // WARNING: Could not recover jumptable at 0x000069e8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_begin_catch_00008098)();
  return;
}



void _objc_copyWeak(void)

{
                    // WARNING: Could not recover jumptable at 0x000069f4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_copyWeak_000080a0)();
  return;
}



void _objc_destroyWeak(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a00. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_destroyWeak_000080a8)();
  return;
}



void _objc_end_catch(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a0c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_end_catch_000080b0)();
  return;
}



void _objc_enumerationMutation(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a18. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_enumerationMutation_000080b8)();
  return;
}



void _objc_initWeak(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a24. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_initWeak_000080c0)();
  return;
}



void _objc_loadWeakRetained(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a30. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_loadWeakRetained_000080c8)();
  return;
}



void _objc_msgSendSuper2(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a3c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_msgSendSuper2_000080d0)();
  return;
}



void _objc_release(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a48. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_release_000080d8)();
  return;
}



void _objc_retain(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a54. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retain_000080e0)();
  return;
}



void _objc_retainAutoreleasedReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a60. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutoreleasedReturnValue_000080e8)();
  return;
}



void _objc_storeStrong(void)

{
                    // WARNING: Could not recover jumptable at 0x00006a6c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_storeStrong_000080f0)();
  return;
}



void _objc_msgSend__readKeyWindow(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"_readKeyWindow");
  return;
}



void _objc_msgSend_addMethodCallDelegate_channel_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"addMethodCallDelegate:channel:");
  return;
}



void _objc_msgSend_addObserver_selector_name_object_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"addObserver:selector:name:object:");
  return;
}



void _objc_msgSend_arguments(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"arguments");
  return;
}



void _objc_msgSend_class(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"class");
  return;
}



void _objc_msgSend_colorWithHex_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"colorWithHex:");
  return;
}



void _objc_msgSend_colorWithRed_green_blue_alpha_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"colorWithRed:green:blue:alpha:");
  return;
}



void _objc_msgSend_countByEnumeratingWithState_objects_count_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"countByEnumeratingWithState:objects:count:");
  return;
}



void _objc_msgSend_defaultCenter(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"defaultCenter");
  return;
}



void _objc_msgSend_doubleValue(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"doubleValue");
  return;
}



void _objc_msgSend_hideAllToasts(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"hideAllToasts");
  return;
}



void _objc_msgSend_init(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"init");
  return;
}



void _objc_msgSend_initWithDefaultStyle(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"initWithDefaultStyle");
  return;
}



void _objc_msgSend_initWithInt_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"initWithInt:");
  return;
}



void _objc_msgSend_intValue(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"intValue");
  return;
}



void _objc_msgSend_isEqualToString_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"isEqualToString:");
  return;
}



void _objc_msgSend_isKeyWindow(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"isKeyWindow");
  return;
}



void _objc_msgSend_isKeyboardVisible(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"isKeyboardVisible");
  return;
}



void _objc_msgSend_isKindOfClass_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"isKindOfClass:");
  return;
}



void _objc_msgSend_lastObject(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"lastObject");
  return;
}



void _objc_msgSend_makeToast_duration_position_style_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"makeToast:duration:position:style:");
  return;
}



void _objc_msgSend_messenger(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"messenger");
  return;
}



void _objc_msgSend_method(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"method");
  return;
}



void _objc_msgSend_methodChannelWithName_binaryMessenger_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"methodChannelWithName:binaryMessenger:");
  return;
}



void _objc_msgSend_numberWithBool_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"numberWithBool:");
  return;
}



void _objc_msgSend_objectForKeyedSubscript_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"objectForKeyedSubscript:");
  return;
}



void _objc_msgSend_removeObserver_name_object_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"removeObserver:name:object:");
  return;
}



void _objc_msgSend_setBackgroundColor_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"setBackgroundColor:");
  return;
}



void _objc_msgSend_setChannel_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"setChannel:");
  return;
}



void _objc_msgSend_setIsKeyboardVisible_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"setIsKeyboardVisible:");
  return;
}



void _objc_msgSend_setMessageColor_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"setMessageColor:");
  return;
}



void _objc_msgSend_setMessageFont_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"setMessageFont:");
  return;
}



void _objc_msgSend_sharedApplication(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"sharedApplication");
  return;
}



void _objc_msgSend_systemFontOfSize_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"systemFontOfSize:");
  return;
}



void _objc_msgSend_unsignedIntegerValue(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"unsignedIntegerValue");
  return;
}



void _objc_msgSend_windows(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_00008058)(param_1,"windows");
  return;
}


