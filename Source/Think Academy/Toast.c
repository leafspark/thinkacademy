typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned int    dword;
typedef long long    longlong;
typedef unsigned long    qword;
typedef unsigned char    uchar;
typedef unsigned long    ulong;
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

typedef struct __sFILEX __sFILEX, *P__sFILEX;

struct __sFILEX {
};

typedef struct __sbuf __sbuf, *P__sbuf;

struct __sbuf {
    uchar *_base;
    int _size;
};

typedef struct __sFILE __sFILE, *P__sFILE;

typedef longlong __int64_t;

typedef __int64_t __darwin_off_t;

typedef __darwin_off_t fpos_t;

typedef struct __sFILE FILE;

struct __sFILE {
    uchar *_p;
    int _r;
    int _w;
    short _flags;
    short _file;
    struct __sbuf _bf;
    int _lbfsize;
    void *_cookie;
    int (*_close)(void *);
    int (*_read)(void *, char *, int);
    fpos_t (*_seek)(void *, fpos_t, int);
    int (*_write)(void *, char *, int);
    struct __sbuf _ub;
    struct __sFILEX *_extra;
    int _ur;
    uchar _ubuf[3];
    uchar _nbuf[1];
    struct __sbuf _lb;
    int _blksize;
    fpos_t _offset;
};

typedef ulong __darwin_size_t;

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

typedef struct method_t method_t, *Pmethod_t;

struct method_t {
    string *name;
    string *types;
    void *imp;
};

typedef dword bool;

typedef struct method_list_t_47_ method_list_t_47_, *Pmethod_list_t_47_;

struct method_list_t_47_ {
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
};

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

typedef struct ivar_t ivar_t, *Pivar_t;

struct ivar_t {
    qword *offset;
    string *name;
    string *type;
    dword alignment;
    dword size;
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

typedef qword ID;

typedef struct CGSize CGSize, *PCGSize;

struct CGSize {
    double field0_0x0;
    double field1_0x8;
};

typedef struct objc_property_list_22_ objc_property_list_22_, *Pobjc_property_list_22_;

typedef struct objc_property objc_property, *Pobjc_property;

struct objc_property {
    char *name;
    char *name;
};

struct objc_property_list_22_ {
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

typedef qword SEL;

typedef struct objc_image_info objc_image_info, *Pobjc_image_info;

struct objc_image_info {
    dword version;
    dword flags;
};

typedef struct ivar_list_t_22_ ivar_list_t_22_, *Pivar_list_t_22_;

struct ivar_list_t_22_ {
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
};

typedef __darwin_size_t size_t;

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

typedef void (*dispatch_function_t)(void *);

typedef long dispatch_once_t;




void __UIView_Toast__makeToast__(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined auVar3 [16];
  
  uVar1 = _objc_retain(param_3);
  uVar2 = _objc_msgSend_defaultDuration(&objc::class_t::CSToastManager);
  _objc_msgSend_defaultPosition(&objc::class_t::CSToastManager);
  auVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_makeToast_duration_position_style_(uVar2,param_1,auVar3._8_8_,uVar1,auVar3._0_8_,0);
  _objc_release(uVar1);
  _objc_release(auVar3._0_8_);
  return;
}



void __UIView_Toast__makeToast_duration_position__(void)

{
  _objc_msgSend_makeToast_duration_position_style_();
  return;
}



void __UIView_Toast__makeToast_duration_position_style__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5,undefined8 param_6)

{
  undefined auVar1 [16];
  undefined auVar2 [16];
  
  auVar1 = _objc_retain(param_5);
  _objc_msgSend_toastViewForMessage_title_image_style_(param_2,auVar1._8_8_,param_4,0,0,param_6);
  auVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_showToast_duration_position_completion_
            (param_1,param_2,auVar2._8_8_,auVar2._0_8_,auVar1._0_8_,0);
  _objc_release(auVar1._0_8_);
  _objc_release(auVar2._0_8_);
  return;
}



void __UIView_Toast__makeToast_duration_position_title_image_style_completion__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5,undefined8 param_6,undefined8 param_7,undefined8 param_8,
               undefined8 param_9)

{
  undefined8 uVar1;
  undefined auVar2 [16];
  undefined auVar3 [16];
  
  uVar1 = _objc_retain(param_9);
  auVar2 = _objc_retain(param_5);
  _objc_msgSend_toastViewForMessage_title_image_style_
            (param_2,auVar2._8_8_,param_4,param_6,param_7,param_8);
  auVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_showToast_duration_position_completion_
            (param_1,param_2,auVar3._8_8_,auVar3._0_8_,auVar2._0_8_,uVar1);
  _objc_release(uVar1);
  _objc_release(auVar2._0_8_);
  _objc_release(auVar3._0_8_);
  return;
}



void __UIView_Toast__showToast__(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined auVar3 [16];
  
  uVar1 = _objc_retain(param_3);
  uVar2 = _objc_msgSend_defaultDuration(&objc::class_t::CSToastManager);
  _objc_msgSend_defaultPosition(&objc::class_t::CSToastManager);
  auVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_showToast_duration_position_completion_
            (uVar2,param_1,auVar3._8_8_,uVar1,auVar3._0_8_,0);
  _objc_release(uVar1);
  _objc_release(auVar3._0_8_);
  return;
}



void __UIView_Toast__showToast_duration_position_completion__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5,undefined8 param_6)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  long lVar6;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined auVar7 [16];
  
  lVar2 = _objc_retain(param_4);
  uVar3 = _objc_retain(param_5);
  uVar4 = _objc_retain(param_6);
  if (lVar2 != 0) {
    uVar5 = _objc_retainBlock(uVar4);
    _objc_setAssociatedObject(lVar2,&_CSToastCompletionKey,uVar5,1);
    _objc_release(uVar5);
    iVar1 = _objc_msgSend_isQueueEnabled(&objc::class_t::CSToastManager);
    uVar5 = extraout_x1;
    if (iVar1 != 0) {
      _objc_msgSend_cs_activeToasts(param_2);
      uVar5 = _objc_retainAutoreleasedReturnValue();
      lVar6 = _objc_msgSend_count();
      _objc_release(uVar5);
      uVar5 = extraout_x1_00;
      if (lVar6 != 0) {
        _objc_msgSend_numberWithDouble_(param_1,&_OBJC_CLASS___NSNumber);
        uVar5 = _objc_retainAutoreleasedReturnValue();
        _objc_setAssociatedObject(lVar2,&_CSToastDurationKey,uVar5,1);
        _objc_release(uVar5);
        _objc_setAssociatedObject(lVar2,&_CSToastPositionKey,uVar3,1);
        _objc_msgSend_cs_toastQueue(param_2);
        auVar7 = _objc_retainAutoreleasedReturnValue();
        _objc_msgSend_addObject_(auVar7._0_8_,auVar7._8_8_,lVar2);
        _objc_release(auVar7._0_8_);
        goto LAB_0000750c;
      }
    }
    _objc_msgSend_cs_showToast_duration_position_(param_1,param_2,uVar5,lVar2,uVar3);
  }
LAB_0000750c:
  _objc_release(uVar4);
  _objc_release(uVar3);
  _objc_release(lVar2);
  return;
}



void __UIView_Toast__hideToast_(undefined8 param_1)

{
  undefined8 uVar1;
  undefined auVar2 [16];
  
  _objc_msgSend_cs_activeToasts();
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_firstObject();
  auVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_hideToast_(param_1,auVar2._8_8_,auVar2._0_8_);
  _objc_release(auVar2._0_8_);
  _objc_release(uVar1);
  return;
}



void __UIView_Toast__hideToast__(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  int iVar1;
  long lVar2;
  undefined8 extraout_x1;
  undefined auVar3 [16];
  
  lVar2 = _objc_retain(param_3);
  if (lVar2 != 0) {
    _objc_msgSend_cs_activeToasts(param_1);
    auVar3 = _objc_retainAutoreleasedReturnValue();
    iVar1 = _objc_msgSend_containsObject_(auVar3._0_8_,auVar3._8_8_,lVar2);
    _objc_release(auVar3._0_8_);
    if (iVar1 != 0) {
      _objc_msgSend_cs_hideToast_(param_1,extraout_x1,lVar2);
    }
  }
  _objc_release(lVar2);
  return;
}



void __UIView_Toast__hideAllToasts_(undefined8 param_1,undefined8 param_2)

{
  _objc_msgSend_hideAllToasts_clearQueue_(param_1,param_2,0,1);
  return;
}



void __UIView_Toast__hideAllToasts_clearQueue__
               (undefined8 param_1,undefined8 param_2,int param_3,int param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  long lVar3;
  long lVar4;
  undefined auVar5 [16];
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
  
  local_58 = *(long *)PTR____stack_chk_guard_0000c020;
  if (param_4 != 0) {
    _objc_msgSend_clearToastQueue(param_1);
  }
  uStack_f8 = 0;
  local_100 = 0;
  uStack_e8 = 0;
  uStack_f0 = 0;
  lStack_118 = 0;
  local_120 = 0;
  uStack_108 = 0;
  local_110 = (long *)0x0;
  _objc_msgSend_cs_activeToasts(param_1);
  auVar5 = _objc_retainAutoreleasedReturnValue();
  uVar1 = auVar5._0_8_;
  auVar5 = _objc_msgSend_countByEnumeratingWithState_objects_count_
                     (uVar1,auVar5._8_8_,&local_120,auStack_d8,0x10);
  if (auVar5._0_8_ != 0) {
    lVar3 = *local_110;
    do {
      uVar2 = auVar5._8_8_;
      lVar4 = 0;
      do {
        if (*local_110 != lVar3) {
          _objc_enumerationMutation(uVar1);
          uVar2 = extraout_x1;
        }
        _objc_msgSend_hideToast_(param_1,uVar2,*(undefined8 *)(lStack_118 + lVar4 * 8));
        lVar4 = lVar4 + 1;
        uVar2 = extraout_x1_00;
      } while (auVar5._0_8_ != lVar4);
      auVar5 = _objc_msgSend_countByEnumeratingWithState_objects_count_
                         (uVar1,extraout_x1_00,&local_120,auStack_d8,0x10);
    } while (auVar5._0_8_ != 0);
  }
  _objc_release(uVar1);
  if (param_3 != 0) {
    _objc_msgSend_hideToastActivity(param_1);
  }
  if (*(long *)PTR____stack_chk_guard_0000c020 == local_58) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void __UIView_Toast__clearToastQueue_(void)

{
  undefined8 uVar1;
  
  _objc_msgSend_cs_toastQueue();
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_removeAllObjects();
  _objc_release(uVar1);
  return;
}



void __UIView_Toast__cs_showToast_duration_position__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  undefined *puVar1;
  int iVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined8 extraout_x1_01;
  undefined8 uVar5;
  undefined auVar6 [16];
  undefined *local_c0;
  undefined8 local_b8;
  code *local_b0;
  undefined *puStack_a8;
  undefined8 local_a0;
  undefined8 local_98;
  undefined8 local_90;
  undefined *local_88;
  undefined8 local_80;
  code *local_78;
  undefined *puStack_70;
  undefined8 local_68;
  
  auVar6 = _objc_retain(param_4);
  uVar3 = auVar6._0_8_;
  _objc_msgSend_cs_centerPointForPosition_withToast_(param_2,auVar6._8_8_,param_5,uVar3);
  _objc_msgSend_setCenter_(uVar3);
  _objc_msgSend_setAlpha_(0,uVar3);
  iVar2 = _objc_msgSend_isTapToDismissEnabled(&objc::class_t::CSToastManager);
  if (iVar2 != 0) {
    auVar6 = _objc_alloc(&_OBJC_CLASS___UITapGestureRecognizer);
    auVar6 = _objc_msgSend_initWithTarget_action_
                       (auVar6._0_8_,auVar6._8_8_,param_2,"cs_handleToastTapped:");
    _objc_msgSend_addGestureRecognizer_(uVar3,auVar6._8_8_,auVar6._0_8_);
    _objc_msgSend_setUserInteractionEnabled_(uVar3,extraout_x1,1);
    _objc_msgSend_setExclusiveTouch_(uVar3,extraout_x1_00,1);
    _objc_release(auVar6._0_8_);
  }
  _objc_msgSend_cs_activeToasts(param_2);
  auVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_addObject_(auVar6._0_8_,auVar6._8_8_,uVar3);
  _objc_release(auVar6._0_8_);
  _objc_msgSend_addSubview_(param_2,extraout_x1_01,uVar3);
  _objc_msgSend_sharedStyle(&objc::class_t::CSToastManager);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  uVar5 = _objc_msgSend_fadeDuration();
  puVar1 = PTR___NSConcreteStackBlock_0000c018;
  local_88 = PTR___NSConcreteStackBlock_0000c018;
  local_80 = 0xc2000000;
  local_78 = ___48__UIView_Toast__cs_showToast_duration_position___block_invoke;
  puStack_70 = &___block_descriptor_40_e8_32s_e5_v8__0l;
  local_98 = _objc_retain(uVar3);
  local_c0 = puVar1;
  local_b8 = 0xc2000000;
  local_b0 = ___48__UIView_Toast__cs_showToast_duration_position___block_invoke_23;
  puStack_a8 = &___block_descriptor_56_e8_32s40s_e8_v12__0B8l;
  local_a0 = param_2;
  local_90 = param_1;
  local_68 = local_98;
  auVar6 = _objc_retain();
  _objc_msgSend_animateWithDuration_delay_options_animations_completion_
            (uVar5,0,&_OBJC_CLASS___UIView,auVar6._8_8_,&DAT_00020002,&local_88,&local_c0);
  _objc_release(uVar4);
  _objc_release(local_98);
  _objc_release(local_68);
  _objc_release(auVar6._0_8_);
  return;
}



void ___48__UIView_Toast__cs_showToast_duration_position___block_invoke(long param_1)

{
  _objc_msgSend_setAlpha_(0x3ff0000000000000,*(undefined8 *)(param_1 + 0x20));
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



void ___48__UIView_Toast__cs_showToast_duration_position___block_invoke_23
               (long param_1,undefined8 param_2)

{
  undefined8 uVar1;
  undefined auVar2 [16];
  
  _objc_msgSend_timerWithTimeInterval_target_selector_userInfo_repeats_
            (*(undefined8 *)(param_1 + 0x30),&_OBJC_CLASS___NSTimer,param_2,
             *(undefined8 *)(param_1 + 0x20),"cs_toastTimerDidFinish:",
             *(undefined8 *)(param_1 + 0x28),0);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_mainRunLoop(&_OBJC_CLASS___NSRunLoop);
  auVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_addTimer_forMode_
            (auVar2._0_8_,auVar2._8_8_,uVar1,*(undefined8 *)PTR__NSRunLoopCommonModes_0000c008);
  _objc_release(auVar2._0_8_);
  _objc_setAssociatedObject(*(undefined8 *)(param_1 + 0x28),&_CSToastTimerKey,uVar1,1);
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



void __UIView_Toast__cs_hideToast__(void)

{
  _objc_msgSend_cs_hideToast_fromTap_();
  return;
}



void __UIView_Toast__cs_hideToast_fromTap__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined param_4)

{
  undefined *puVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined auVar6 [16];
  undefined *local_c0;
  undefined8 local_b8;
  code *local_b0;
  undefined *puStack_a8;
  undefined8 local_a0;
  undefined8 uStack_98;
  undefined local_90;
  undefined *local_88;
  undefined8 local_80;
  code *local_78;
  undefined *puStack_70;
  undefined8 local_68;
  
  uVar2 = _objc_retain(param_3);
  _objc_getAssociatedObject(uVar2,&_CSToastTimerKey);
  uVar3 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_invalidate();
  _objc_msgSend_sharedStyle(&objc::class_t::CSToastManager);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  uVar5 = _objc_msgSend_fadeDuration();
  puVar1 = PTR___NSConcreteStackBlock_0000c018;
  local_88 = PTR___NSConcreteStackBlock_0000c018;
  local_80 = 0xc2000000;
  local_78 = ___38__UIView_Toast__cs_hideToast_fromTap___block_invoke;
  puStack_70 = &___block_descriptor_40_e8_32s_e5_v8__0l;
  local_a0 = _objc_retain(uVar2);
  local_c0 = puVar1;
  local_b8 = 0xc2000000;
  local_b0 = ___38__UIView_Toast__cs_hideToast_fromTap___block_invoke_2;
  puStack_a8 = &___block_descriptor_49_e8_32s40s_e8_v12__0B8l;
  uStack_98 = param_1;
  local_90 = param_4;
  local_68 = local_a0;
  auVar6 = _objc_retain();
  _objc_msgSend_animateWithDuration_delay_options_animations_completion_
            (uVar5,0,&_OBJC_CLASS___UIView,auVar6._8_8_,&DAT_00010004,&local_88,&local_c0);
  _objc_release(uVar4);
  _objc_release(local_a0);
  _objc_release(local_68);
  _objc_release(auVar6._0_8_);
  _objc_release(uVar3);
  return;
}



void ___38__UIView_Toast__cs_hideToast_fromTap___block_invoke(long param_1)

{
  _objc_msgSend_setAlpha_(0,*(undefined8 *)(param_1 + 0x20));
  return;
}



void ___38__UIView_Toast__cs_hideToast_fromTap___block_invoke_2(long param_1)

{
  long lVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined auVar6 [16];
  
  _objc_msgSend_removeFromSuperview(*(undefined8 *)(param_1 + 0x20));
  _objc_msgSend_cs_activeToasts(*(undefined8 *)(param_1 + 0x28));
  auVar6 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_removeObject_(auVar6._0_8_,auVar6._8_8_,*(undefined8 *)(param_1 + 0x20));
  _objc_release(auVar6._0_8_);
  _objc_getAssociatedObject(*(undefined8 *)(param_1 + 0x20),&_CSToastCompletionKey);
  lVar1 = _objc_retainAutoreleasedReturnValue();
  if (lVar1 != 0) {
    (**(code **)(lVar1 + 0x10))(lVar1,*(undefined *)(param_1 + 0x30));
  }
  _objc_msgSend_cs_toastQueue(*(undefined8 *)(param_1 + 0x28));
  uVar2 = _objc_retainAutoreleasedReturnValue();
  lVar3 = _objc_msgSend_count();
  _objc_release(uVar2);
  if (lVar3 != 0) {
    _objc_msgSend_cs_toastQueue(*(undefined8 *)(param_1 + 0x28));
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_firstObject();
    uVar4 = _objc_retainAutoreleasedReturnValue();
    _objc_release(uVar2);
    _objc_msgSend_cs_toastQueue(*(undefined8 *)(param_1 + 0x28));
    auVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_removeObjectAtIndex_(auVar6._0_8_,auVar6._8_8_,0);
    _objc_release(auVar6._0_8_);
    _objc_getAssociatedObject(uVar4,&_CSToastDurationKey);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    uVar5 = _objc_msgSend_doubleValue();
    _objc_release(uVar2);
    _objc_getAssociatedObject(uVar4,&_CSToastPositionKey);
    auVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_cs_showToast_duration_position_
              (uVar5,*(undefined8 *)(param_1 + 0x28),auVar6._8_8_,uVar4,auVar6._0_8_);
    _objc_release(auVar6._0_8_);
    _objc_release(uVar4);
  }
  _objc_release(lVar1);
  return;
}



void __UIView_Toast__toastViewForMessage_title_image_style__
               (undefined param_1 [16],double param_2,double param_3,double param_4,
               undefined8 param_5,undefined8 param_6,undefined8 param_7,undefined8 param_8,
               undefined8 param_9,undefined8 param_10)

{
  bool bVar1;
  undefined *puVar2;
  int iVar3;
  long lVar4;
  long lVar5;
  long lVar6;
  long lVar7;
  undefined8 uVar8;
  long lVar9;
  long lVar10;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined8 extraout_x1_01;
  undefined8 extraout_x1_02;
  undefined8 extraout_x1_03;
  undefined8 extraout_x1_04;
  undefined8 extraout_x1_05;
  undefined8 extraout_x1_06;
  undefined8 extraout_x1_07;
  undefined8 uVar11;
  long lVar12;
  undefined8 uVar13;
  double dVar14;
  double dVar15;
  double dVar16;
  double dVar17;
  double dVar18;
  double dVar19;
  double dVar20;
  double dVar21;
  double dVar22;
  double dVar23;
  undefined auVar24 [16];
  double local_b8;
  double local_b0;
  double local_a8;
  
  lVar4 = _objc_retain(param_7);
  lVar5 = _objc_retain(param_8);
  lVar6 = _objc_retain(param_9);
  lVar7 = _objc_retain(param_10);
  if (((lVar4 == 0) && (lVar5 == 0)) && (lVar6 == 0)) {
    uVar11 = 0;
    goto LAB_00008438;
  }
  if (lVar7 == 0) {
    _objc_msgSend_sharedStyle(&objc::class_t::CSToastManager);
    lVar7 = _objc_retainAutoreleasedReturnValue();
    _objc_release(0);
  }
  _objc_alloc(&_OBJC_CLASS___UIView);
  auVar24 = _objc_msgSend_init();
  uVar11 = auVar24._0_8_;
  _objc_msgSend_setAutoresizingMask_(uVar11,auVar24._8_8_,0x2d);
  uVar13 = _objc_msgSend_cornerRadius(lVar7);
  _objc_msgSend_layer(uVar11);
  uVar8 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_setCornerRadius_(uVar13);
  _objc_release(uVar8);
  iVar3 = _objc_msgSend_displayShadow(lVar7);
  if (iVar3 != 0) {
    _objc_msgSend_shadowColor(lVar7);
    _objc_retainAutoreleasedReturnValue();
    uVar8 = _objc_retainAutorelease();
    uVar13 = _objc_msgSend_CGColor();
    _objc_msgSend_layer(uVar11);
    auVar24 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setShadowColor_(auVar24._0_8_,auVar24._8_8_,uVar13);
    _objc_release(auVar24._0_8_);
    _objc_release(uVar8);
    dVar14 = (double)_objc_msgSend_shadowOpacity(lVar7);
    _objc_msgSend_layer(uVar11);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setShadowOpacity_((float)dVar14);
    _objc_release(uVar8);
    uVar13 = _objc_msgSend_shadowRadius(lVar7);
    _objc_msgSend_layer(uVar11);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setShadowRadius_(uVar13);
    _objc_release(uVar8);
    uVar13 = _objc_msgSend_shadowOffset(lVar7);
    _objc_msgSend_layer(uVar11);
    uVar8 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setShadowOffset_(uVar13);
    _objc_release(uVar8);
  }
  _objc_msgSend_backgroundColor(lVar7);
  auVar24 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_setBackgroundColor_(uVar11,auVar24._8_8_,auVar24._0_8_);
  _objc_release(auVar24._0_8_);
  puVar2 = PTR__CGRectZero_0000c000;
  if (lVar6 == 0) {
    lVar12 = 0;
    dVar22 = *(double *)PTR__CGRectZero_0000c000;
    dVar14 = *(double *)(PTR__CGRectZero_0000c000 + 0x10);
    local_a8 = *(double *)(PTR__CGRectZero_0000c000 + 0x18);
    param_2 = param_4;
LAB_00007ffc:
    bVar1 = true;
    dVar15 = dVar14;
    dVar16 = dVar22;
    local_b8 = local_a8;
  }
  else {
    auVar24 = _objc_alloc(&_OBJC_CLASS___UIImageView);
    auVar24 = _objc_msgSend_initWithImage_(auVar24._0_8_,auVar24._8_8_,lVar6);
    lVar12 = auVar24._0_8_;
    _objc_msgSend_setContentMode_(lVar12,auVar24._8_8_,1);
    uVar8 = _objc_msgSend_horizontalPadding(lVar7);
    uVar13 = _objc_msgSend_verticalPadding(lVar7);
    dVar15 = (double)_objc_msgSend_imageSize(lVar7);
    _objc_msgSend_imageSize(lVar7);
    _objc_msgSend_setFrame_(uVar8,uVar13,lVar12);
    dVar22 = *(double *)puVar2;
    dVar14 = *(double *)(puVar2 + 0x10);
    local_a8 = *(double *)(puVar2 + 0x18);
    param_3 = dVar15;
    if (lVar12 == 0) goto LAB_00007ffc;
    dVar16 = (double)_objc_msgSend_horizontalPadding(lVar7);
    _objc_msgSend_verticalPadding(lVar7);
    _objc_msgSend_bounds(lVar12);
    param_3 = dVar15;
    _objc_msgSend_bounds(lVar12);
    bVar1 = false;
    local_b8 = param_2;
  }
  if (lVar5 == 0) {
    lVar9 = 0;
    if (lVar4 != 0) goto LAB_00008158;
LAB_000082a8:
    lVar10 = 0;
  }
  else {
    _objc_alloc(&_OBJC_CLASS___UILabel);
    lVar9 = _objc_msgSend_init();
    auVar24 = _objc_msgSend_titleNumberOfLines(lVar7);
    _objc_msgSend_setNumberOfLines_(lVar9,auVar24._8_8_,auVar24._0_8_);
    _objc_msgSend_titleFont(lVar7);
    auVar24 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setFont_(lVar9,auVar24._8_8_,auVar24._0_8_);
    _objc_release(auVar24._0_8_);
    auVar24 = _objc_msgSend_titleAlignment(lVar7);
    _objc_msgSend_setTextAlignment_(lVar9,auVar24._8_8_,auVar24._0_8_);
    _objc_msgSend_setLineBreakMode_(lVar9,extraout_x1,4);
    _objc_msgSend_titleColor(lVar7);
    auVar24 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setTextColor_(lVar9,auVar24._8_8_,auVar24._0_8_);
    _objc_release(auVar24._0_8_);
    _objc_msgSend_clearColor(&_OBJC_CLASS___UIColor);
    auVar24 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setBackgroundColor_(lVar9,auVar24._8_8_,auVar24._0_8_);
    _objc_release(auVar24._0_8_);
    _objc_msgSend_setAlpha_(0x3ff0000000000000,lVar9);
    _objc_msgSend_setText_(lVar9,extraout_x1_00,lVar5);
    _objc_msgSend_bounds(param_5);
    dVar17 = (double)_objc_msgSend_maxWidthPercentage(lVar7);
    param_3 = dVar17 * param_3 - dVar15;
    _objc_msgSend_bounds(param_5);
    dVar17 = (double)_objc_msgSend_maxHeightPercentage(lVar7);
    param_2 = dVar17 * param_2;
    dVar17 = param_2;
    dVar18 = (double)_objc_msgSend_sizeThatFits_(param_3,lVar9);
    if (dVar18 <= param_3) {
      param_3 = dVar18;
    }
    if (dVar17 <= param_2) {
      param_2 = dVar17;
    }
    _objc_msgSend_setFrame_(0,0,lVar9);
    if (lVar4 == 0) goto LAB_000082a8;
LAB_00008158:
    _objc_alloc(&_OBJC_CLASS___UILabel);
    lVar10 = _objc_msgSend_init();
    auVar24 = _objc_msgSend_messageNumberOfLines(lVar7);
    _objc_msgSend_setNumberOfLines_(lVar10,auVar24._8_8_,auVar24._0_8_);
    _objc_msgSend_messageFont(lVar7);
    auVar24 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setFont_(lVar10,auVar24._8_8_,auVar24._0_8_);
    _objc_release(auVar24._0_8_);
    auVar24 = _objc_msgSend_messageAlignment(lVar7);
    _objc_msgSend_setTextAlignment_(lVar10,auVar24._8_8_,auVar24._0_8_);
    _objc_msgSend_setLineBreakMode_(lVar10,extraout_x1_01,4);
    _objc_msgSend_messageColor(lVar7);
    auVar24 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setTextColor_(lVar10,auVar24._8_8_,auVar24._0_8_);
    _objc_release(auVar24._0_8_);
    _objc_msgSend_clearColor(&_OBJC_CLASS___UIColor);
    auVar24 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setBackgroundColor_(lVar10,auVar24._8_8_,auVar24._0_8_);
    _objc_release(auVar24._0_8_);
    _objc_msgSend_setAlpha_(0x3ff0000000000000,lVar10);
    _objc_msgSend_setText_(lVar10,extraout_x1_02,lVar4);
    _objc_msgSend_bounds(param_5);
    dVar17 = (double)_objc_msgSend_maxWidthPercentage(lVar7);
    param_3 = dVar17 * param_3 - dVar15;
    _objc_msgSend_bounds(param_5);
    dVar17 = (double)_objc_msgSend_maxHeightPercentage(lVar7);
    param_2 = dVar17 * param_2;
    dVar17 = param_2;
    dVar18 = (double)_objc_msgSend_sizeThatFits_(param_3,lVar10);
    if (dVar18 <= param_3) {
      param_3 = dVar18;
    }
    if (dVar17 <= param_2) {
      param_2 = dVar17;
    }
    _objc_msgSend_setFrame_(0,0,lVar10);
  }
  dVar23 = *(double *)(PTR__CGRectZero_0000c000 + 8);
  dVar17 = param_3;
  dVar18 = dVar14;
  dVar21 = local_a8;
  dVar19 = dVar22;
  local_b0 = dVar23;
  if (lVar9 != 0) {
    dVar19 = (double)_objc_msgSend_horizontalPadding(lVar7);
    dVar19 = dVar16 + dVar15 + dVar19;
    local_b0 = (double)_objc_msgSend_verticalPadding(lVar7);
    _objc_msgSend_bounds(lVar9);
    dVar17 = param_3;
    _objc_msgSend_bounds(lVar9);
    dVar18 = param_3;
    dVar21 = param_2;
  }
  if (lVar10 != 0) {
    dVar22 = (double)_objc_msgSend_horizontalPadding(lVar7);
    dVar22 = dVar16 + dVar15 + dVar22;
    dVar23 = (double)_objc_msgSend_verticalPadding(lVar7);
    dVar23 = local_b0 + dVar21 + dVar23;
    _objc_msgSend_bounds(lVar10);
    _objc_msgSend_bounds(lVar10);
    dVar14 = dVar17;
    local_a8 = param_2;
  }
  dVar16 = dVar14;
  if (dVar14 <= dVar18) {
    dVar16 = dVar18;
  }
  dVar17 = dVar22;
  if (dVar22 <= dVar19) {
    dVar17 = dVar19;
  }
  dVar20 = (double)_objc_msgSend_horizontalPadding(lVar7);
  dVar15 = dVar15 + dVar20 + dVar20;
  dVar20 = (double)_objc_msgSend_horizontalPadding(lVar7);
  dVar20 = dVar17 + dVar16 + dVar20;
  if (dVar20 <= dVar15) {
    dVar20 = dVar15;
  }
  dVar15 = (double)_objc_msgSend_verticalPadding(lVar7);
  dVar15 = dVar23 + local_a8 + dVar15;
  dVar16 = (double)_objc_msgSend_verticalPadding(lVar7);
  local_b8 = local_b8 + dVar16 + dVar16;
  if (local_b8 <= dVar15) {
    local_b8 = dVar15;
  }
  _objc_msgSend_setFrame_(0,0,dVar20,local_b8,uVar11);
  uVar8 = extraout_x1_03;
  if (lVar9 != 0) {
    _objc_msgSend_setFrame_(dVar19,local_b0,dVar18,dVar21,lVar9);
    _objc_msgSend_addSubview_(uVar11,extraout_x1_04,lVar9);
    uVar8 = extraout_x1_05;
  }
  if (lVar10 != 0) {
    _objc_msgSend_setFrame_(dVar22,dVar23,dVar14,local_a8,lVar10);
    _objc_msgSend_addSubview_(uVar11,extraout_x1_06,lVar10);
    uVar8 = extraout_x1_07;
  }
  if (!bVar1) {
    _objc_msgSend_addSubview_(uVar11,uVar8,lVar12);
  }
  _objc_release(lVar12);
  _objc_release(lVar9);
  _objc_release(lVar10);
LAB_00008438:
  _objc_release(lVar7);
  _objc_release(lVar6);
  _objc_release(lVar5);
  _objc_release(lVar4);
  _objc_autoreleaseReturnValue(uVar11);
  return;
}



void __UIView_Toast__cs_activeToasts_(undefined8 param_1)

{
  long lVar1;
  
  _objc_getAssociatedObject(param_1,&_CSToastActiveKey);
  lVar1 = _objc_retainAutoreleasedReturnValue();
  if (lVar1 == 0) {
    _objc_alloc(&_OBJC_CLASS___NSMutableArray);
    lVar1 = _objc_msgSend_init();
    _objc_setAssociatedObject(param_1,&_CSToastActiveKey,lVar1,1);
  }
  _objc_autoreleaseReturnValue(lVar1);
  return;
}



void __UIView_Toast__cs_toastQueue_(undefined8 param_1)

{
  long lVar1;
  
  _objc_getAssociatedObject(param_1,&_CSToastQueueKey);
  lVar1 = _objc_retainAutoreleasedReturnValue();
  if (lVar1 == 0) {
    _objc_alloc(&_OBJC_CLASS___NSMutableArray);
    lVar1 = _objc_msgSend_init();
    _objc_setAssociatedObject(param_1,&_CSToastQueueKey,lVar1,1);
  }
  _objc_autoreleaseReturnValue(lVar1);
  return;
}



void __UIView_Toast__cs_toastTimerDidFinish__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  undefined auVar1 [16];
  
  _objc_msgSend_userInfo(param_3);
  auVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_cs_hideToast_(param_1,auVar1._8_8_,auVar1._0_8_);
  _objc_release(auVar1._0_8_);
  return;
}



void __UIView_Toast__cs_handleToastTapped__
               (undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 extraout_x1;
  
  _objc_msgSend_view(param_3);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_getAssociatedObject(uVar1,&_CSToastTimerKey);
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_invalidate();
  _objc_msgSend_cs_hideToast_fromTap_(param_1,extraout_x1,uVar1,1);
  _objc_release(uVar2);
  _objc_release(uVar1);
  return;
}



void __UIView_Toast__makeToastActivity__
               (undefined param_1 [16],double param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined8 extraout_x1_01;
  double dVar7;
  undefined8 uVar8;
  double dVar9;
  undefined8 uVar10;
  undefined auVar11 [16];
  undefined *local_98;
  undefined8 local_90;
  code *local_88;
  undefined *puStack_80;
  undefined8 local_78;
  
  uVar2 = _objc_retain(param_5);
  _objc_getAssociatedObject(param_3,&_CSToastActivityViewKey);
  lVar3 = _objc_retainAutoreleasedReturnValue();
  if (lVar3 == 0) {
    _objc_msgSend_sharedStyle(&objc::class_t::CSToastManager);
    uVar4 = _objc_retainAutoreleasedReturnValue();
    uVar5 = _objc_alloc(&_OBJC_CLASS___UIView);
    dVar7 = (double)_objc_msgSend_activitySize(uVar4);
    _objc_msgSend_activitySize(uVar4);
    uVar10 = 0;
    auVar11 = _objc_msgSend_initWithFrame_(0,0,dVar7,param_2,uVar5);
    uVar5 = auVar11._0_8_;
    _objc_msgSend_cs_centerPointForPosition_withToast_(param_3,auVar11._8_8_,uVar2,uVar5);
    _objc_msgSend_setCenter_(uVar5);
    _objc_msgSend_backgroundColor(uVar4);
    auVar11 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setBackgroundColor_(uVar5,auVar11._8_8_,auVar11._0_8_);
    _objc_release(auVar11._0_8_);
    _objc_msgSend_setAlpha_(0,uVar5);
    _objc_msgSend_setAutoresizingMask_(uVar5,extraout_x1,0x2d);
    uVar8 = _objc_msgSend_cornerRadius(uVar4);
    _objc_msgSend_layer(uVar5);
    uVar6 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setCornerRadius_(uVar8);
    _objc_release(uVar6);
    iVar1 = _objc_msgSend_displayShadow(uVar4);
    if (iVar1 != 0) {
      _objc_msgSend_shadowColor(uVar4);
      _objc_retainAutoreleasedReturnValue();
      uVar6 = _objc_retainAutorelease();
      uVar8 = _objc_msgSend_CGColor();
      _objc_msgSend_layer(uVar5);
      auVar11 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_setShadowColor_(auVar11._0_8_,auVar11._8_8_,uVar8);
      _objc_release(auVar11._0_8_);
      _objc_release(uVar6);
      dVar9 = (double)_objc_msgSend_shadowOpacity(uVar4);
      _objc_msgSend_layer(uVar5);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_setShadowOpacity_((float)dVar9);
      _objc_release(uVar6);
      uVar8 = _objc_msgSend_shadowRadius(uVar4);
      _objc_msgSend_layer(uVar5);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_setShadowRadius_(uVar8);
      _objc_release(uVar6);
      uVar8 = _objc_msgSend_shadowOffset(uVar4);
      _objc_msgSend_layer(uVar5);
      uVar6 = _objc_retainAutoreleasedReturnValue();
      _objc_msgSend_setShadowOffset_(uVar8,uVar10);
      _objc_release(uVar6);
    }
    auVar11 = _objc_alloc(&_OBJC_CLASS___UIActivityIndicatorView);
    uVar6 = _objc_msgSend_initWithActivityIndicatorStyle_(auVar11._0_8_,auVar11._8_8_,0);
    _objc_msgSend_bounds(uVar5);
    _objc_msgSend_bounds(uVar5);
    _objc_msgSend_setCenter_(dVar7 * 0.5,param_2 * 0.5,uVar6);
    _objc_msgSend_addSubview_(uVar5,extraout_x1_00,uVar6);
    _objc_msgSend_startAnimating(uVar6);
    _objc_setAssociatedObject(param_3,&_CSToastActivityViewKey,uVar5,1);
    _objc_msgSend_addSubview_(param_3,extraout_x1_01,uVar5);
    uVar8 = _objc_msgSend_fadeDuration(uVar4);
    local_98 = PTR___NSConcreteStackBlock_0000c018;
    local_90 = 0xc2000000;
    local_88 = ___35__UIView_Toast__makeToastActivity___block_invoke;
    puStack_80 = &___block_descriptor_40_e8_32s_e5_v8__0l;
    local_78 = uVar5;
    auVar11 = _objc_retain(uVar5);
    _objc_msgSend_animateWithDuration_delay_options_animations_completion_
              (uVar8,0,&_OBJC_CLASS___UIView,auVar11._8_8_,0x20000,&local_98,0);
    _objc_release(local_78);
    _objc_release(auVar11._0_8_);
    _objc_release(uVar6);
    _objc_release(uVar4);
  }
  _objc_release(lVar3);
  _objc_release(uVar2);
  return;
}



void ___35__UIView_Toast__makeToastActivity___block_invoke(long param_1)

{
  _objc_msgSend_setAlpha_(0x3ff0000000000000,*(undefined8 *)(param_1 + 0x20));
  return;
}



void __UIView_Toast__hideToastActivity_(undefined8 param_1)

{
  undefined *puVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined auVar5 [16];
  undefined *local_a8;
  undefined8 local_a0;
  code *local_98;
  undefined *puStack_90;
  undefined8 local_88;
  undefined8 uStack_80;
  undefined *local_78;
  undefined8 local_70;
  code *local_68;
  undefined *puStack_60;
  undefined8 local_58;
  
  _objc_getAssociatedObject(param_1,&_CSToastActivityViewKey);
  lVar2 = _objc_retainAutoreleasedReturnValue();
  if (lVar2 != 0) {
    _objc_msgSend_sharedStyle(&objc::class_t::CSToastManager);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_msgSend_fadeDuration();
    puVar1 = PTR___NSConcreteStackBlock_0000c018;
    local_78 = PTR___NSConcreteStackBlock_0000c018;
    local_70 = 0xc2000000;
    local_68 = ___34__UIView_Toast__hideToastActivity__block_invoke;
    puStack_60 = &___block_descriptor_40_e8_32s_e5_v8__0l;
    local_58 = _objc_retain(lVar2);
    local_a8 = puVar1;
    local_a0 = 0xc2000000;
    local_98 = ___34__UIView_Toast__hideToastActivity__block_invoke_2;
    puStack_90 = &___block_descriptor_48_e8_32s40s_e8_v12__0B8l;
    auVar5 = _objc_retain();
    local_88 = auVar5._0_8_;
    uStack_80 = param_1;
    _objc_msgSend_animateWithDuration_delay_options_animations_completion_
              (uVar4,0,&_OBJC_CLASS___UIView,auVar5._8_8_,&DAT_00010004,&local_78,&local_a8);
    _objc_release(uVar3);
    _objc_release(local_88);
    _objc_release(local_58);
  }
  _objc_release(lVar2);
  return;
}



void ___34__UIView_Toast__hideToastActivity__block_invoke(long param_1)

{
  _objc_msgSend_setAlpha_(0,*(undefined8 *)(param_1 + 0x20));
  return;
}



void ___34__UIView_Toast__hideToastActivity__block_invoke_2(long param_1)

{
  _objc_msgSend_removeFromSuperview(*(undefined8 *)(param_1 + 0x20));
  _objc_setAssociatedObject(*(undefined8 *)(param_1 + 0x28),&_CSToastActivityViewKey,0,1);
  return;
}



undefined  [16]
__UIView_Toast__cs_centerPointForPosition_withToast__
          (undefined param_1 [16],undefined param_2 [16],double param_3,double param_4,
          undefined8 param_5,undefined8 param_6,undefined8 param_7,undefined8 param_8)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  undefined8 extraout_x1;
  double dVar6;
  undefined auVar7 [16];
  
  uVar2 = _objc_retain(param_7);
  uVar3 = _objc_retain(param_8);
  _objc_msgSend_sharedStyle(&objc::class_t::CSToastManager);
  uVar4 = _objc_retainAutoreleasedReturnValue();
  iVar1 = ___isPlatformVersionAtLeast(2,0xb,0,0);
  if (iVar1 != 0) {
    _objc_msgSend_safeAreaInsets(param_5);
  }
  _objc_msgSend_verticalPadding(uVar4);
  _objc_msgSend_verticalPadding(uVar4);
  auVar7 = _objc_msgSend_class(&_OBJC_CLASS___NSString);
  iVar1 = _objc_msgSend_isKindOfClass_(uVar2,auVar7._8_8_,auVar7._0_8_);
  if (iVar1 == 0) {
    auVar7 = _objc_msgSend_class(&_OBJC_CLASS___NSValue);
    iVar1 = _objc_msgSend_isKindOfClass_(uVar2,auVar7._8_8_,auVar7._0_8_);
    if (iVar1 != 0) {
      param_4 = (double)_objc_msgSend_CGPointValue(uVar2);
      dVar6 = param_4;
      goto LAB_00008c64;
    }
  }
  else {
    auVar7 = _objc_msgSend_caseInsensitiveCompare_(uVar2,extraout_x1,_CSToastPositionTop);
    if (auVar7._0_8_ == 0) {
      _objc_msgSend_bounds(param_5);
      _objc_msgSend_frame(uVar3);
      param_4 = param_4 * 0.5;
      dVar6 = param_3 * 0.5;
      goto LAB_00008c64;
    }
    lVar5 = _objc_msgSend_caseInsensitiveCompare_(uVar2,auVar7._8_8_,_CSToastPositionCenter);
    if (lVar5 == 0) {
      _objc_msgSend_bounds(param_5);
      param_4 = (double)_objc_msgSend_bounds(param_5);
      dVar6 = param_3 * 0.5;
      goto LAB_00008c64;
    }
  }
  _objc_msgSend_bounds(param_5);
  _objc_msgSend_bounds(param_5);
  dVar6 = param_4;
  _objc_msgSend_frame(uVar3);
  param_4 = param_4 - dVar6 * 0.5;
  dVar6 = param_3 * 0.5;
LAB_00008c64:
  _objc_release(param_4,uVar4);
  _objc_release(uVar3);
  _objc_release(uVar2);
  auVar7._8_8_ = 0;
  auVar7._0_8_ = dVar6;
  return auVar7;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::initWithDefaultStyle(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 uVar2;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined8 extraout_x1_01;
  undefined8 extraout_x1_02;
  undefined8 extraout_x1_03;
  undefined auVar3 [16];
  ID local_50;
  class_t *pcStack_48;
  
  pcStack_48 = &objc::class_t::CSToastStyle;
  local_50 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_50,"init");
  if (IVar1 != 0) {
    _objc_msgSend_blackColor(&_OBJC_CLASS___UIColor);
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_colorWithAlphaComponent_(0x3fe999999999999a);
    auVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setBackgroundColor_(IVar1,auVar3._8_8_,auVar3._0_8_);
    _objc_release(auVar3._0_8_);
    _objc_release(uVar2);
    _objc_msgSend_whiteColor(&_OBJC_CLASS___UIColor);
    auVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setTitleColor_(IVar1,auVar3._8_8_,auVar3._0_8_);
    _objc_release(auVar3._0_8_);
    _objc_msgSend_whiteColor(&_OBJC_CLASS___UIColor);
    auVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setMessageColor_(IVar1,auVar3._8_8_,auVar3._0_8_);
    _objc_release(auVar3._0_8_);
    _objc_msgSend_setMaxWidthPercentage_(0x3fe999999999999a,IVar1);
    _objc_msgSend_setMaxHeightPercentage_(0x3fe999999999999a,IVar1);
    _objc_msgSend_setHorizontalPadding_(0x4024000000000000,IVar1);
    _objc_msgSend_setVerticalPadding_(0x4024000000000000,IVar1);
    _objc_msgSend_setCornerRadius_(0x4024000000000000,IVar1);
    _objc_msgSend_boldSystemFontOfSize_(0x4030000000000000,&_OBJC_CLASS___UIFont);
    auVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setTitleFont_(IVar1,auVar3._8_8_,auVar3._0_8_);
    _objc_release(auVar3._0_8_);
    _objc_msgSend_systemFontOfSize_(0x4030000000000000,&_OBJC_CLASS___UIFont);
    auVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend_setMessageFont_(IVar1,auVar3._8_8_,auVar3._0_8_);
    _objc_release(auVar3._0_8_);
    _objc_msgSend_setTitleAlignment_(IVar1,extraout_x1,0);
    _objc_msgSend_setMessageAlignment_(IVar1,extraout_x1_00,0);
    _objc_msgSend_setTitleNumberOfLines_(IVar1,extraout_x1_01,0);
    _objc_msgSend_setMessageNumberOfLines_(IVar1,extraout_x1_02,0);
    _objc_msgSend_setDisplayShadow_(IVar1,extraout_x1_03,0);
    _objc_msgSend_setShadowOpacity_(0x3fe999999999999a,IVar1);
    _objc_msgSend_setShadowRadius_(0x4018000000000000,IVar1);
    _objc_msgSend_setShadowOffset_(0x4010000000000000,0x4010000000000000,IVar1);
    _objc_msgSend_setImageSize_(0x4054000000000000,0x4054000000000000,IVar1);
    _objc_msgSend_setActivitySize_(0x4059000000000000,0x4059000000000000,IVar1);
    _objc_msgSend_setFadeDuration_(0x3fc999999999999a,IVar1);
  }
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setMaxWidthPercentage_(ID param_1,SEL param_2,double param_3)

{
  double dVar1;
  
  dVar1 = (double)NEON_fminnm(param_3,0x3ff0000000000000);
  if (dVar1 <= 0.0) {
    dVar1 = 0.0;
  }
  *(double *)(param_1 + 0x28) = dVar1;
  return;
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setMaxHeightPercentage_(ID param_1,SEL param_2,double param_3)

{
  double dVar1;
  
  dVar1 = (double)NEON_fminnm(param_3,0x3ff0000000000000);
  if (dVar1 <= 0.0) {
    dVar1 = 0.0;
  }
  *(double *)(param_1 + 0x30) = dVar1;
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::init(ID param_1,SEL param_2)

{
  _objc_release();
  return 0;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::backgroundColor(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setBackgroundColor_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::titleColor(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setTitleColor_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x18,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::messageColor(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x20);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setMessageColor_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x20,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::maxWidthPercentage(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x28);
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::maxHeightPercentage(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x30);
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::horizontalPadding(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x38);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setHorizontalPadding_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x38) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::verticalPadding(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x40);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setVerticalPadding_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x40) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::cornerRadius(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x48);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setCornerRadius_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x48) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::titleFont(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x50);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setTitleFont_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x50,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::messageFont(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x58);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setMessageFont_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x58,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

long_long CSToastStyle::titleAlignment(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x60);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setTitleAlignment_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x60) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

long_long CSToastStyle::messageAlignment(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x68);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setMessageAlignment_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x68) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

long_long CSToastStyle::titleNumberOfLines(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x70);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setTitleNumberOfLines_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x70) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

long_long CSToastStyle::messageNumberOfLines(ID param_1,SEL param_2)

{
  return *(long_long *)(param_1 + 0x78);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setMessageNumberOfLines_(ID param_1,SEL param_2,long_long param_3)

{
  *(long_long *)(param_1 + 0x78) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool CSToastStyle::displayShadow(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void CSToastStyle::setDisplayShadow_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastStyle::shadowColor(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x80);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setShadowColor_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x80,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::shadowOpacity(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x88);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setShadowOpacity_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x88) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::shadowRadius(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x90);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setShadowRadius_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x90) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

CGSize CSToastStyle::shadowOffset(ID param_1,SEL param_2)

{
  CGSize CVar1;
  
  CVar1.field1_0x8 = (double)param_2;
  CVar1.field0_0x0 = (double)param_1;
  return CVar1;
}



// Function Stack Size: 0x20 bytes

void CSToastStyle::setShadowOffset_(ID param_1,SEL param_2,CGSize param_3)

{
  *(double *)(param_1 + 0xa0) = param_3.field0_0x0;
  *(double *)(param_1 + 0xa8) = param_3.field1_0x8;
  return;
}



// Function Stack Size: 0x10 bytes

CGSize CSToastStyle::imageSize(ID param_1,SEL param_2)

{
  CGSize CVar1;
  
  CVar1.field1_0x8 = (double)param_2;
  CVar1.field0_0x0 = (double)param_1;
  return CVar1;
}



// Function Stack Size: 0x20 bytes

void CSToastStyle::setImageSize_(ID param_1,SEL param_2,CGSize param_3)

{
  *(double *)(param_1 + 0xb0) = param_3.field0_0x0;
  *(double *)(param_1 + 0xb8) = param_3.field1_0x8;
  return;
}



// Function Stack Size: 0x10 bytes

CGSize CSToastStyle::activitySize(ID param_1,SEL param_2)

{
  CGSize CVar1;
  
  CVar1.field1_0x8 = (double)param_2;
  CVar1.field0_0x0 = (double)param_1;
  return CVar1;
}



// Function Stack Size: 0x20 bytes

void CSToastStyle::setActivitySize_(ID param_1,SEL param_2,CGSize param_3)

{
  *(double *)(param_1 + 0xc0) = param_3.field0_0x0;
  *(double *)(param_1 + 200) = param_3.field1_0x8;
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastStyle::fadeDuration(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x98);
}



// Function Stack Size: 0x18 bytes

void CSToastStyle::setFadeDuration_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x98) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

void CSToastStyle::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x80,0);
  _objc_storeStrong(param_1 + 0x58,0);
  _objc_storeStrong(param_1 + 0x50,0);
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x18,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastManager::sharedManager(ID param_1,SEL param_2)

{
  ID IVar1;
  SEL extraout_x1;
  undefined *local_38;
  undefined8 local_30;
  code *local_28;
  undefined *puStack_20;
  ID local_18;
  
  local_38 = PTR___NSConcreteStackBlock_0000c018;
  local_30 = 0xc0000000;
  local_28 = ___31__CSToastManager_sharedManager__block_invoke;
  puStack_20 = &___block_descriptor_40_e5_v8__0l;
  local_18 = param_1;
  if (_sharedManager_oncePredicate != -1) {
    _dispatch_once(&_sharedManager_oncePredicate,&local_38);
    param_2 = extraout_x1;
  }
  IVar1 = _objc_retainAutoreleaseReturnValue(_sharedManager__sharedManager,param_2);
  return IVar1;
}



void ___31__CSToastManager_sharedManager__block_invoke(long param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  _objc_alloc(*(undefined8 *)(param_1 + 0x20));
  uVar2 = _objc_msgSend_init();
  uVar1 = _sharedManager__sharedManager;
  _sharedManager__sharedManager = uVar2;
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastManager::init(ID param_1,SEL param_2)

{
  ID IVar1;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined8 extraout_x1_01;
  undefined auVar2 [16];
  ID local_30;
  class_t *pcStack_28;
  
  pcStack_28 = &objc::class_t::CSToastManager;
  local_30 = param_1;
  IVar1 = _objc_msgSendSuper2(&local_30,"init");
  if (IVar1 != 0) {
    _objc_alloc(&objc::class_t::CSToastStyle);
    auVar2 = _objc_msgSend_initWithDefaultStyle();
    _objc_msgSend_setSharedStyle_(IVar1,auVar2._8_8_,auVar2._0_8_);
    _objc_release(auVar2._0_8_);
    _objc_msgSend_setTapToDismissEnabled_(IVar1,extraout_x1,1);
    _objc_msgSend_setQueueEnabled_(IVar1,extraout_x1_00,0);
    _objc_msgSend_setDefaultDuration_(0x4008000000000000,IVar1);
    _objc_msgSend_setDefaultPosition_(IVar1,extraout_x1_01,_CSToastPositionBottom);
  }
  return IVar1;
}



// Function Stack Size: 0x18 bytes

void CSToastManager::setSharedStyle_(ID param_1,SEL param_2,ID param_3)

{
  undefined8 uVar1;
  undefined auVar2 [16];
  
  uVar1 = _objc_retain(param_3);
  _objc_msgSend_sharedManager(param_1);
  auVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_setSharedStyle_(auVar2._0_8_,auVar2._8_8_,uVar1);
  _objc_release(uVar1);
  _objc_release(auVar2._0_8_);
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastManager::sharedStyle(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ID IVar3;
  
  _objc_msgSend_sharedManager();
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_sharedStyle();
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  IVar3 = _objc_autoreleaseReturnValue(uVar2);
  return IVar3;
}



// Function Stack Size: 0x14 bytes

void CSToastManager::setTapToDismissEnabled_(ID param_1,SEL param_2,bool param_3)

{
  undefined auVar1 [16];
  
  _objc_msgSend_sharedManager();
  auVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_setTapToDismissEnabled_(auVar1._0_8_,auVar1._8_8_,param_3);
  _objc_release(auVar1._0_8_);
  return;
}



// Function Stack Size: 0x10 bytes

bool CSToastManager::isTapToDismissEnabled(ID param_1,SEL param_2)

{
  bool bVar1;
  undefined8 uVar2;
  
  _objc_msgSend_sharedManager();
  uVar2 = _objc_retainAutoreleasedReturnValue();
  bVar1 = _objc_msgSend_isTapToDismissEnabled();
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x14 bytes

void CSToastManager::setQueueEnabled_(ID param_1,SEL param_2,bool param_3)

{
  undefined auVar1 [16];
  
  _objc_msgSend_sharedManager();
  auVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_setQueueEnabled_(auVar1._0_8_,auVar1._8_8_,param_3);
  _objc_release(auVar1._0_8_);
  return;
}



// Function Stack Size: 0x10 bytes

bool CSToastManager::isQueueEnabled(ID param_1,SEL param_2)

{
  bool bVar1;
  undefined8 uVar2;
  
  _objc_msgSend_sharedManager();
  uVar2 = _objc_retainAutoreleasedReturnValue();
  bVar1 = _objc_msgSend_isQueueEnabled();
  _objc_release(uVar2);
  return bVar1;
}



// Function Stack Size: 0x18 bytes

void CSToastManager::setDefaultDuration_(ID param_1,SEL param_2,double param_3)

{
  undefined8 uVar1;
  
  _objc_msgSend_sharedManager();
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_setDefaultDuration_(param_3);
  _objc_release(uVar1);
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastManager::defaultDuration(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  double dVar2;
  
  _objc_msgSend_sharedManager();
  uVar1 = _objc_retainAutoreleasedReturnValue();
  dVar2 = (double)_objc_msgSend_defaultDuration();
  _objc_release(uVar1);
  return dVar2;
}



// Function Stack Size: 0x18 bytes

void CSToastManager::setDefaultPosition_(ID param_1,SEL param_2,ID param_3)

{
  int iVar1;
  undefined8 uVar2;
  ulong uVar3;
  undefined auVar4 [16];
  
  uVar2 = _objc_retain(param_3);
  auVar4 = _objc_msgSend_class(&_OBJC_CLASS___NSString);
  uVar3 = _objc_msgSend_isKindOfClass_(uVar2,auVar4._8_8_,auVar4._0_8_);
  if ((uVar3 & 1) == 0) {
    auVar4 = _objc_msgSend_class(&_OBJC_CLASS___NSValue);
    iVar1 = _objc_msgSend_isKindOfClass_(uVar2,auVar4._8_8_,auVar4._0_8_);
    if (iVar1 == 0) goto LAB_00009494;
  }
  _objc_msgSend_sharedManager(param_1);
  auVar4 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_setDefaultPosition_(auVar4._0_8_,auVar4._8_8_,uVar2);
  _objc_release(auVar4._0_8_);
LAB_00009494:
  _objc_release(uVar2);
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastManager::defaultPosition(ID param_1,SEL param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  ID IVar3;
  
  _objc_msgSend_sharedManager();
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend_defaultPosition();
  uVar2 = _objc_retainAutoreleasedReturnValue();
  _objc_release(uVar1);
  IVar3 = _objc_autoreleaseReturnValue(uVar2);
  return IVar3;
}



// Function Stack Size: 0x10 bytes

ID CSToastManager::sharedStyle(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x10);
}



// Function Stack Size: 0x18 bytes

void CSToastManager::setSharedStyle_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x10,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

bool CSToastManager::isTapToDismissEnabled(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 8);
}



// Function Stack Size: 0x14 bytes

void CSToastManager::setTapToDismissEnabled_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 8) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

bool CSToastManager::isQueueEnabled(ID param_1,SEL param_2)

{
  return (bool)*(byte *)(param_1 + 9);
}



// Function Stack Size: 0x14 bytes

void CSToastManager::setQueueEnabled_(ID param_1,SEL param_2,bool param_3)

{
  *(char *)(param_1 + 9) = (char)param_3;
  return;
}



// Function Stack Size: 0x10 bytes

double CSToastManager::defaultDuration(ID param_1,SEL param_2)

{
  return *(double *)(param_1 + 0x18);
}



// Function Stack Size: 0x18 bytes

void CSToastManager::setDefaultDuration_(ID param_1,SEL param_2,double param_3)

{
  *(double *)(param_1 + 0x18) = param_3;
  return;
}



// Function Stack Size: 0x10 bytes

ID CSToastManager::defaultPosition(ID param_1,SEL param_2)

{
  return *(ID *)(param_1 + 0x20);
}



// Function Stack Size: 0x18 bytes

void CSToastManager::setDefaultPosition_(ID param_1,SEL param_2,ID param_3)

{
  _objc_storeStrong(param_1 + 0x20,param_3);
  return;
}



// Function Stack Size: 0x10 bytes

void CSToastManager::_cxx_destruct(ID param_1,SEL param_2)

{
  _objc_storeStrong(param_1 + 0x20,0);
  _objc_storeStrong(param_1 + 0x10,0);
  return;
}



void _compatibilityInitializeAvailabilityCheck(void)

{
  __initializeAvailabilityCheck(1);
  return;
}



void ___isPlatformVersionAtLeast(undefined4 param_1,int param_2,uint param_3,uint param_4)

{
  int iVar1;
  ulong uVar2;
  long lVar3;
  undefined4 local_40;
  uint uStack_3c;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_0000c020;
  if (DAT_0000d988 == -1) {
    if (DAT_0000d990 == (code *)0x0) {
code_r0x00009624:
      if (DAT_0000d980 == -1) {
        iVar1 = __MergedGlobals - param_2;
      }
      else {
        _dispatch_once_f(&DAT_0000d980,(void *)0x0,_compatibilityInitializeAvailabilityCheck);
        iVar1 = __MergedGlobals - param_2;
      }
      if (param_2 < __MergedGlobals) {
LAB_00009654:
        uVar2 = 1;
        if (*(long *)PTR____stack_chk_guard_0000c020 == local_38) {
          return;
        }
      }
      else {
        if (iVar1 < 0 == SBORROW4(__MergedGlobals,param_2)) {
          if ((int)param_3 < DAT_0000d974) goto LAB_00009654;
          if (DAT_0000d974 < (int)param_3) goto LAB_00009678;
          uVar2 = (ulong)((int)param_4 <= DAT_0000d978);
          lVar3 = *(long *)PTR____stack_chk_guard_0000c020;
        }
        else {
LAB_00009678:
          uVar2 = 0;
          lVar3 = *(long *)PTR____stack_chk_guard_0000c020;
        }
        if (lVar3 == local_38) {
          return;
        }
      }
      goto LAB_000096d0;
    }
  }
  else {
    _dispatch_once_f(&DAT_0000d988,(void *)0x0,_initializeAvailabilityCheck);
    if (DAT_0000d990 == (code *)0x0) goto code_r0x00009624;
  }
  uStack_3c = param_2 << 0x10 | (param_3 & 0xff) << 8 | param_4 & 0xff;
  local_40 = param_1;
  uVar2 = (*DAT_0000d990)(1,&local_40);
  if (*(long *)PTR____stack_chk_guard_0000c020 == local_38) {
    return;
  }
LAB_000096d0:
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



void _initializeAvailabilityCheck(void)

{
  __initializeAvailabilityCheck(0);
  return;
}



void __initializeAvailabilityCheck(FILE *param_1)

{
  int iVar1;
  uint uVar2;
  FILE *pFVar3;
  FILE *pFVar4;
  code *pcVar5;
  FILE *pFVar6;
  FILE *pFVar7;
  FILE *pFVar8;
  FILE *pFVar9;
  FILE *pFVar10;
  FILE *pFVar11;
  FILE *pFVar12;
  size_t sVar13;
  void *pvVar14;
  size_t sVar15;
  long lVar16;
  long lVar17;
  long lVar18;
  long lVar19;
  long lVar20;
  uchar *puVar21;
  char acStack_88 [32];
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_0000c020;
  pFVar3 = param_1;
  if ((DAT_0000d990 == (FILE *)0x0 || (int)param_1 != 0) &&
     (((DAT_0000d990 = (FILE *)_dlsym(0xfffffffffffffffe,"_availability_version_check"),
       DAT_0000d990 == (FILE *)0x0 || (pFVar3 = DAT_0000d990, (int)param_1 != 0)) &&
      (pFVar3 = (FILE *)_dlsym(0xfffffffffffffffe,"kCFAllocatorNull"), pFVar3 != (FILE *)0x0)))) {
    puVar21 = pFVar3->_p;
    pFVar4 = (FILE *)_dlsym(0xfffffffffffffffe,"CFDataCreateWithBytesNoCopy");
    pFVar3 = pFVar4;
    if (pFVar4 != (FILE *)0x0) {
      pcVar5 = (code *)_dlsym(0xfffffffffffffffe,"CFPropertyListCreateWithData");
      pFVar6 = (FILE *)_dlsym(0xfffffffffffffffe,"CFPropertyListCreateFromXMLData");
      pFVar3 = pFVar6;
      if (((((((ulong)pcVar5 | (ulong)pFVar6) != 0) &&
            (pFVar7 = (FILE *)_dlsym(0xfffffffffffffffe,"CFStringCreateWithCStringNoCopy"),
            pFVar3 = pFVar7, pFVar7 != (FILE *)0x0)) &&
           ((pFVar8 = (FILE *)_dlsym(0xfffffffffffffffe,"CFDictionaryGetValue"), pFVar3 = pFVar8,
            pFVar8 != (FILE *)0x0 &&
            ((pFVar9 = (FILE *)_dlsym(0xfffffffffffffffe,"CFGetTypeID"), pFVar3 = pFVar9,
             pFVar9 != (FILE *)0x0 &&
             (pFVar10 = (FILE *)_dlsym(0xfffffffffffffffe,"CFStringGetTypeID"), pFVar3 = pFVar10,
             pFVar10 != (FILE *)0x0)))))) &&
          (pFVar11 = (FILE *)_dlsym(0xfffffffffffffffe,"CFStringGetCString"), pFVar3 = pFVar11,
          pFVar11 != (FILE *)0x0)) &&
         ((pFVar12 = (FILE *)_dlsym(0xfffffffffffffffe,"CFRelease"), pFVar3 = pFVar12,
          pFVar12 != (FILE *)0x0 &&
          (pFVar3 = _fopen("/System/Library/CoreServices/SystemVersion.plist","r"),
          pFVar3 != (FILE *)0x0)))) {
        _fseek(pFVar3,0,2);
        sVar13 = _ftell(pFVar3);
        if ((long)sVar13 < 0) {
          pvVar14 = (void *)0x0;
        }
        else {
          _rewind(pFVar3);
          pvVar14 = _malloc(sVar13);
          if (((pvVar14 != (void *)0x0) &&
              (sVar15 = _fread(pvVar14,1,sVar13,pFVar3), sVar15 == sVar13)) &&
             (lVar16 = (*(code *)pFVar4)(0,pvVar14,sVar13,puVar21), lVar16 != 0)) {
            if (pcVar5 == (code *)0x0) {
              lVar17 = (*(code *)pFVar6)(0,lVar16,0,0);
            }
            else {
              lVar17 = (*pcVar5)();
            }
            if (lVar17 != 0) {
              lVar18 = (*(code *)pFVar7)(0,"ProductVersion",0x600,puVar21);
              if (lVar18 != 0) {
                lVar19 = (*(code *)pFVar8)(lVar17,lVar18);
                (*(code *)pFVar12)(lVar18);
                if (lVar19 != 0) {
                  lVar18 = (*(code *)pFVar9)(lVar19);
                  lVar20 = (*(code *)pFVar10)();
                  if ((lVar18 == lVar20) &&
                     (iVar1 = (*(code *)pFVar11)(lVar19,acStack_88,0x20,0x8000100), iVar1 != 0)) {
                    _sscanf(acStack_88,"%d.%d.%d");
                  }
                }
              }
              (*(code *)pFVar12)(lVar17);
            }
            (*(code *)pFVar12)(lVar16);
          }
        }
        _free(pvVar14);
        uVar2 = _fclose(pFVar3);
        pFVar3 = (FILE *)(ulong)uVar2;
      }
    }
  }
  if (*(long *)PTR____stack_chk_guard_0000c020 == local_68) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(pFVar3);
}



void ___stack_chk_fail(void)

{
                    // WARNING: Could not recover jumptable at 0x00009a40. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____stack_chk_fail_0000c038)();
  return;
}



void _dispatch_once(void)

{
                    // WARNING: Could not recover jumptable at 0x00009a4c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dispatch_once_0000c040)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _dispatch_once_f(dispatch_once_t *predicate,void *context,dispatch_function_t function)

{
                    // WARNING: Could not recover jumptable at 0x00009a58. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dispatch_once_f_0000c048)();
  return;
}



void _dlsym(void)

{
                    // WARNING: Could not recover jumptable at 0x00009a64. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dlsym_0000c050)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _fclose(FILE *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00009a70. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__fclose_0000c058)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

FILE * _fopen(char *param_1,char *param_2)

{
  FILE *pFVar1;
  
                    // WARNING: Could not recover jumptable at 0x00009a7c. Too many branches
                    // WARNING: Treating indirect jump as call
  pFVar1 = (FILE *)(*(code *)PTR__fopen_0000c060)();
  return pFVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t _fread(void *param_1,size_t param_2,size_t param_3,FILE *param_4)

{
  size_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x00009a88. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__fread_0000c068)();
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _free(void *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00009a94. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__free_0000c070)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _fseek(FILE *param_1,long param_2,int param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00009aa0. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__fseek_0000c078)((int)param_1,param_2,param_3);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long _ftell(FILE *param_1)

{
  long lVar1;
  
                    // WARNING: Could not recover jumptable at 0x00009aac. Too many branches
                    // WARNING: Treating indirect jump as call
  lVar1 = (*(code *)PTR__ftell_0000c080)();
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _malloc(size_t param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00009ab8. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__malloc_0000c088)();
  return pvVar1;
}



void _objc_alloc(void)

{
                    // WARNING: Could not recover jumptable at 0x00009ac4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_alloc_0000c090)();
  return;
}



void _objc_autoreleaseReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x00009ad0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_autoreleaseReturnValue_0000c098)();
  return;
}



void _objc_enumerationMutation(void)

{
                    // WARNING: Could not recover jumptable at 0x00009adc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_enumerationMutation_0000c0a0)();
  return;
}



void _objc_getAssociatedObject(void)

{
                    // WARNING: Could not recover jumptable at 0x00009ae8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_getAssociatedObject_0000c0a8)();
  return;
}



void _objc_msgSendSuper2(void)

{
                    // WARNING: Could not recover jumptable at 0x00009af4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_msgSendSuper2_0000c0b0)();
  return;
}



void _objc_release(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b00. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_release_0000c0b8)();
  return;
}



void _objc_retain(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b0c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retain_0000c0c0)();
  return;
}



void _objc_retainAutorelease(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b18. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutorelease_0000c0c8)();
  return;
}



void _objc_retainAutoreleaseReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b24. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutoreleaseReturnValue_0000c0d0)();
  return;
}



void _objc_retainAutoreleasedReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b30. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutoreleasedReturnValue_0000c0d8)();
  return;
}



void _objc_retainBlock(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b3c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainBlock_0000c0e0)();
  return;
}



void _objc_setAssociatedObject(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b48. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_setAssociatedObject_0000c0e8)();
  return;
}



void _objc_storeStrong(void)

{
                    // WARNING: Could not recover jumptable at 0x00009b54. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_storeStrong_0000c0f0)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _rewind(FILE *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00009b60. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__rewind_0000c0f8)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sscanf(char *param_1,char *param_2,...)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00009b6c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sscanf_0000c100)((int)param_1);
  return iVar1;
}



void _objc_msgSend_CGColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"CGColor");
  return;
}



void _objc_msgSend_CGPointValue(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"CGPointValue");
  return;
}



void _objc_msgSend_activitySize(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"activitySize");
  return;
}



void _objc_msgSend_addGestureRecognizer_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"addGestureRecognizer:");
  return;
}



void _objc_msgSend_addObject_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"addObject:");
  return;
}



void _objc_msgSend_addSubview_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"addSubview:");
  return;
}



void _objc_msgSend_addTimer_forMode_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"addTimer:forMode:");
  return;
}



void _objc_msgSend_animateWithDuration_delay_options_animations_completion_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)
            (param_1,"animateWithDuration:delay:options:animations:completion:");
  return;
}



void _objc_msgSend_backgroundColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"backgroundColor");
  return;
}



void _objc_msgSend_blackColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"blackColor");
  return;
}



void _objc_msgSend_boldSystemFontOfSize_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"boldSystemFontOfSize:");
  return;
}



void _objc_msgSend_bounds(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"bounds");
  return;
}



void _objc_msgSend_caseInsensitiveCompare_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"caseInsensitiveCompare:");
  return;
}



void _objc_msgSend_class(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"class");
  return;
}



void _objc_msgSend_clearColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"clearColor");
  return;
}



void _objc_msgSend_clearToastQueue(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"clearToastQueue");
  return;
}



void _objc_msgSend_colorWithAlphaComponent_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"colorWithAlphaComponent:");
  return;
}



void _objc_msgSend_containsObject_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"containsObject:");
  return;
}



void _objc_msgSend_cornerRadius(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"cornerRadius");
  return;
}



void _objc_msgSend_count(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"count");
  return;
}



void _objc_msgSend_countByEnumeratingWithState_objects_count_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"countByEnumeratingWithState:objects:count:");
  return;
}



void _objc_msgSend_cs_activeToasts(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"cs_activeToasts");
  return;
}



void _objc_msgSend_cs_centerPointForPosition_withToast_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"cs_centerPointForPosition:withToast:");
  return;
}



void _objc_msgSend_cs_hideToast_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"cs_hideToast:");
  return;
}



void _objc_msgSend_cs_hideToast_fromTap_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"cs_hideToast:fromTap:");
  return;
}



void _objc_msgSend_cs_showToast_duration_position_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"cs_showToast:duration:position:");
  return;
}



void _objc_msgSend_cs_toastQueue(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"cs_toastQueue");
  return;
}



void _objc_msgSend_defaultDuration(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"defaultDuration");
  return;
}



void _objc_msgSend_defaultPosition(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"defaultPosition");
  return;
}



void _objc_msgSend_displayShadow(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"displayShadow");
  return;
}



void _objc_msgSend_doubleValue(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"doubleValue");
  return;
}



void _objc_msgSend_fadeDuration(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"fadeDuration");
  return;
}



void _objc_msgSend_firstObject(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"firstObject");
  return;
}



void _objc_msgSend_frame(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"frame");
  return;
}



void _objc_msgSend_hideAllToasts_clearQueue_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"hideAllToasts:clearQueue:");
  return;
}



void _objc_msgSend_hideToast_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"hideToast:");
  return;
}



void _objc_msgSend_hideToastActivity(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"hideToastActivity");
  return;
}



void _objc_msgSend_horizontalPadding(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"horizontalPadding");
  return;
}



void _objc_msgSend_imageSize(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"imageSize");
  return;
}



void _objc_msgSend_init(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"init");
  return;
}



void _objc_msgSend_initWithActivityIndicatorStyle_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"initWithActivityIndicatorStyle:");
  return;
}



void _objc_msgSend_initWithDefaultStyle(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"initWithDefaultStyle");
  return;
}



void _objc_msgSend_initWithFrame_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"initWithFrame:");
  return;
}



void _objc_msgSend_initWithImage_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"initWithImage:");
  return;
}



void _objc_msgSend_initWithTarget_action_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"initWithTarget:action:");
  return;
}



void _objc_msgSend_invalidate(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"invalidate");
  return;
}



void _objc_msgSend_isKindOfClass_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"isKindOfClass:");
  return;
}



void _objc_msgSend_isQueueEnabled(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"isQueueEnabled");
  return;
}



void _objc_msgSend_isTapToDismissEnabled(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"isTapToDismissEnabled");
  return;
}



void _objc_msgSend_layer(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"layer");
  return;
}



void _objc_msgSend_mainRunLoop(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"mainRunLoop");
  return;
}



void _objc_msgSend_makeToast_duration_position_style_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"makeToast:duration:position:style:");
  return;
}



void _objc_msgSend_maxHeightPercentage(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"maxHeightPercentage");
  return;
}



void _objc_msgSend_maxWidthPercentage(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"maxWidthPercentage");
  return;
}



void _objc_msgSend_messageAlignment(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"messageAlignment");
  return;
}



void _objc_msgSend_messageColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"messageColor");
  return;
}



void _objc_msgSend_messageFont(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"messageFont");
  return;
}



void _objc_msgSend_messageNumberOfLines(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"messageNumberOfLines");
  return;
}



void _objc_msgSend_numberWithDouble_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"numberWithDouble:");
  return;
}



void _objc_msgSend_removeAllObjects(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"removeAllObjects");
  return;
}



void _objc_msgSend_removeFromSuperview(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"removeFromSuperview");
  return;
}



void _objc_msgSend_removeObject_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"removeObject:");
  return;
}



void _objc_msgSend_removeObjectAtIndex_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"removeObjectAtIndex:");
  return;
}



void _objc_msgSend_safeAreaInsets(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"safeAreaInsets");
  return;
}



void _objc_msgSend_setActivitySize_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setActivitySize:");
  return;
}



void _objc_msgSend_setAlpha_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setAlpha:");
  return;
}



void _objc_msgSend_setAutoresizingMask_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setAutoresizingMask:");
  return;
}



void _objc_msgSend_setBackgroundColor_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setBackgroundColor:");
  return;
}



void _objc_msgSend_setCenter_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setCenter:");
  return;
}



void _objc_msgSend_setContentMode_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setContentMode:");
  return;
}



void _objc_msgSend_setCornerRadius_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setCornerRadius:");
  return;
}



void _objc_msgSend_setDefaultDuration_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setDefaultDuration:");
  return;
}



void _objc_msgSend_setDefaultPosition_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setDefaultPosition:");
  return;
}



void _objc_msgSend_setDisplayShadow_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setDisplayShadow:");
  return;
}



void _objc_msgSend_setExclusiveTouch_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setExclusiveTouch:");
  return;
}



void _objc_msgSend_setFadeDuration_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setFadeDuration:");
  return;
}



void _objc_msgSend_setFont_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setFont:");
  return;
}



void _objc_msgSend_setFrame_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setFrame:");
  return;
}



void _objc_msgSend_setHorizontalPadding_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setHorizontalPadding:");
  return;
}



void _objc_msgSend_setImageSize_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setImageSize:");
  return;
}



void _objc_msgSend_setLineBreakMode_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setLineBreakMode:");
  return;
}



void _objc_msgSend_setMaxHeightPercentage_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setMaxHeightPercentage:");
  return;
}



void _objc_msgSend_setMaxWidthPercentage_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setMaxWidthPercentage:");
  return;
}



void _objc_msgSend_setMessageAlignment_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setMessageAlignment:");
  return;
}



void _objc_msgSend_setMessageColor_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setMessageColor:");
  return;
}



void _objc_msgSend_setMessageFont_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setMessageFont:");
  return;
}



void _objc_msgSend_setMessageNumberOfLines_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setMessageNumberOfLines:");
  return;
}



void _objc_msgSend_setNumberOfLines_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setNumberOfLines:");
  return;
}



void _objc_msgSend_setQueueEnabled_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setQueueEnabled:");
  return;
}



void _objc_msgSend_setShadowColor_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setShadowColor:");
  return;
}



void _objc_msgSend_setShadowOffset_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setShadowOffset:");
  return;
}



void _objc_msgSend_setShadowOpacity_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setShadowOpacity:");
  return;
}



void _objc_msgSend_setShadowRadius_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setShadowRadius:");
  return;
}



void _objc_msgSend_setSharedStyle_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setSharedStyle:");
  return;
}



void _objc_msgSend_setTapToDismissEnabled_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setTapToDismissEnabled:");
  return;
}



void _objc_msgSend_setText_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setText:");
  return;
}



void _objc_msgSend_setTextAlignment_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setTextAlignment:");
  return;
}



void _objc_msgSend_setTextColor_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setTextColor:");
  return;
}



void _objc_msgSend_setTitleAlignment_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setTitleAlignment:");
  return;
}



void _objc_msgSend_setTitleColor_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setTitleColor:");
  return;
}



void _objc_msgSend_setTitleFont_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setTitleFont:");
  return;
}



void _objc_msgSend_setTitleNumberOfLines_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setTitleNumberOfLines:");
  return;
}



void _objc_msgSend_setUserInteractionEnabled_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setUserInteractionEnabled:");
  return;
}



void _objc_msgSend_setVerticalPadding_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"setVerticalPadding:");
  return;
}



void _objc_msgSend_shadowColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"shadowColor");
  return;
}



void _objc_msgSend_shadowOffset(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"shadowOffset");
  return;
}



void _objc_msgSend_shadowOpacity(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"shadowOpacity");
  return;
}



void _objc_msgSend_shadowRadius(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"shadowRadius");
  return;
}



void _objc_msgSend_sharedManager(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"sharedManager");
  return;
}



void _objc_msgSend_sharedStyle(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"sharedStyle");
  return;
}



void _objc_msgSend_showToast_duration_position_completion_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"showToast:duration:position:completion:");
  return;
}



void _objc_msgSend_sizeThatFits_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"sizeThatFits:");
  return;
}



void _objc_msgSend_startAnimating(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"startAnimating");
  return;
}



void _objc_msgSend_systemFontOfSize_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"systemFontOfSize:");
  return;
}



void _objc_msgSend_timerWithTimeInterval_target_selector_userInfo_repeats_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)
            (param_1,"timerWithTimeInterval:target:selector:userInfo:repeats:");
  return;
}



void _objc_msgSend_titleAlignment(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"titleAlignment");
  return;
}



void _objc_msgSend_titleColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"titleColor");
  return;
}



void _objc_msgSend_titleFont(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"titleFont");
  return;
}



void _objc_msgSend_titleNumberOfLines(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"titleNumberOfLines");
  return;
}



void _objc_msgSend_toastViewForMessage_title_image_style_(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"toastViewForMessage:title:image:style:");
  return;
}



void _objc_msgSend_userInfo(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"userInfo");
  return;
}



void _objc_msgSend_verticalPadding(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"verticalPadding");
  return;
}



void _objc_msgSend_view(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"view");
  return;
}



void _objc_msgSend_whiteColor(undefined8 param_1)

{
  (*(code *)PTR__objc_msgSend_0000c028)(param_1,"whiteColor");
  return;
}


