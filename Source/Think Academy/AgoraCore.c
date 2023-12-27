typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned int    dword;
typedef long long    longlong;
typedef unsigned long    qword;
typedef unsigned char    uchar;
typedef unsigned int    uint;
typedef unsigned long    ulong;
typedef unsigned long long    ulonglong;
typedef unsigned char    undefined1;
typedef unsigned short    undefined2;
typedef unsigned int    undefined4;
typedef unsigned long    undefined8;
typedef unsigned short    ushort;
typedef unsigned short    word;
typedef struct cfstringStruct cfstringStruct, *PcfstringStruct;

struct cfstringStruct {
    qword field0_0x0;
    qword field1_0x8;
    pointer field2_0x10;
    long field3_0x18;
};

typedef int __int32_t;

typedef __int32_t __darwin_dev_t;

typedef __darwin_dev_t dev_t;

typedef struct _opaque_pthread_cond_t _opaque_pthread_cond_t, *P_opaque_pthread_cond_t;

typedef struct _opaque_pthread_cond_t __darwin_pthread_cond_t;

typedef __darwin_pthread_cond_t pthread_cond_t;

struct _opaque_pthread_cond_t {
    long __sig;
    char __opaque[40];
};

typedef struct stat stat, *Pstat;

typedef ushort __uint16_t;

typedef __uint16_t __darwin_mode_t;

typedef __darwin_mode_t mode_t;

typedef __uint16_t nlink_t;

typedef ulonglong __uint64_t;

typedef __uint64_t __darwin_ino64_t;

typedef uint __uint32_t;

typedef __uint32_t __darwin_uid_t;

typedef __darwin_uid_t uid_t;

typedef __uint32_t __darwin_gid_t;

typedef __darwin_gid_t gid_t;

typedef struct timespec timespec, *Ptimespec;

typedef longlong __int64_t;

typedef __int64_t __darwin_off_t;

typedef __darwin_off_t off_t;

typedef __int64_t __darwin_blkcnt_t;

typedef __darwin_blkcnt_t blkcnt_t;

typedef __int32_t __darwin_blksize_t;

typedef __darwin_blksize_t blksize_t;

typedef long __darwin_time_t;

struct timespec {
    __darwin_time_t tv_sec;
    long tv_nsec;
};

struct stat {
    dev_t st_dev;
    mode_t st_mode;
    nlink_t st_nlink;
    __darwin_ino64_t st_ino;
    uid_t st_uid;
    gid_t st_gid;
    dev_t st_rdev;
    struct timespec st_atimespec;
    struct timespec st_mtimespec;
    struct timespec st_ctimespec;
    struct timespec st_birthtimespec;
    off_t st_size;
    blkcnt_t st_blocks;
    blksize_t st_blksize;
    __uint32_t st_flags;
    __uint32_t st_gen;
    __int32_t st_lspare;
    __int64_t st_qspare[2];
};

typedef struct utsname utsname, *Putsname;

struct utsname {
    char sysname[256];
    char nodename[256];
    char release[256];
    char version[256];
    char machine[256];
};

typedef struct timeval timeval, *Ptimeval;

typedef __int32_t __darwin_suseconds_t;

struct timeval {
    __darwin_time_t tv_sec;
    __darwin_suseconds_t tv_usec;
};

typedef uint __darwin_natural_t;

typedef __darwin_natural_t natural_t;

typedef natural_t task_flavor_t;

typedef int integer_t;

typedef integer_t *task_info_t;

typedef __uint32_t __darwin_socklen_t;

typedef __darwin_socklen_t socklen_t;

typedef longlong int64_t;

typedef struct mach_timebase_info mach_timebase_info, *Pmach_timebase_info;

typedef uint uint32_t;

struct mach_timebase_info {
    uint32_t numer;
    uint32_t denom;
};

typedef struct mach_timebase_info *mach_timebase_info_t;

typedef uint boolean_t;

typedef struct _opaque_pthread_mutexattr_t _opaque_pthread_mutexattr_t, *P_opaque_pthread_mutexattr_t;

typedef struct _opaque_pthread_mutexattr_t __darwin_pthread_mutexattr_t;

typedef __darwin_pthread_mutexattr_t pthread_mutexattr_t;

struct _opaque_pthread_mutexattr_t {
    long __sig;
    char __opaque[8];
};

typedef uint u_int;

typedef ushort uint16_t;

typedef struct _opaque_pthread_condattr_t _opaque_pthread_condattr_t, *P_opaque_pthread_condattr_t;

typedef struct _opaque_pthread_condattr_t __darwin_pthread_condattr_t;

typedef __darwin_pthread_condattr_t pthread_condattr_t;

struct _opaque_pthread_condattr_t {
    long __sig;
    char __opaque[8];
};

typedef int *vm_region_recurse_info_t;

typedef struct _opaque_pthread_rwlock_t _opaque_pthread_rwlock_t, *P_opaque_pthread_rwlock_t;

typedef struct _opaque_pthread_rwlock_t __darwin_pthread_rwlock_t;

typedef __darwin_pthread_rwlock_t pthread_rwlock_t;

struct _opaque_pthread_rwlock_t {
    long __sig;
    char __opaque[192];
};

typedef ulong uintptr_t;

typedef uintptr_t vm_offset_t;

typedef vm_offset_t vm_address_t;

typedef __darwin_natural_t __darwin_mach_port_name_t;

typedef __darwin_mach_port_name_t __darwin_mach_port_t;

typedef __darwin_mach_port_t mach_port_t;

typedef mach_port_t vm_map_t;

typedef uintptr_t vm_size_t;

typedef ulonglong uint64_t;

typedef struct _opaque_pthread_mutex_t _opaque_pthread_mutex_t, *P_opaque_pthread_mutex_t;

typedef struct _opaque_pthread_mutex_t __darwin_pthread_mutex_t;

typedef __darwin_pthread_mutex_t pthread_mutex_t;

struct _opaque_pthread_mutex_t {
    long __sig;
    char __opaque[56];
};

typedef struct objc_image_info objc_image_info, *Pobjc_image_info;

struct objc_image_info {
    dword version;
    dword flags;
};

typedef struct NXArchInfo NXArchInfo, *PNXArchInfo;

typedef integer_t cpu_type_t;

typedef integer_t cpu_subtype_t;

typedef enum NXByteOrder {
    NX_UnknownByteOrder=0,
    NX_LittleEndian=1,
    NX_BigEndian=2
} NXByteOrder;

struct NXArchInfo {
    char *name;
    cpu_type_t cputype;
    cpu_subtype_t cpusubtype;
    enum NXByteOrder byteorder;
    char *description;
};

typedef short int16_t;

typedef ulong __darwin_pthread_key_t;

typedef __darwin_pthread_key_t pthread_key_t;

typedef struct _opaque_pthread_attr_t _opaque_pthread_attr_t, *P_opaque_pthread_attr_t;

typedef struct _opaque_pthread_attr_t __darwin_pthread_attr_t;

typedef __darwin_pthread_attr_t pthread_attr_t;

struct _opaque_pthread_attr_t {
    long __sig;
    char __opaque[56];
};

typedef struct _opaque_pthread_t _opaque_pthread_t, *P_opaque_pthread_t;

typedef struct _opaque_pthread_t *__darwin_pthread_t;

typedef __darwin_pthread_t pthread_t;

typedef struct __darwin_pthread_handler_rec __darwin_pthread_handler_rec, *P__darwin_pthread_handler_rec;

struct _opaque_pthread_t {
    long __sig;
    struct __darwin_pthread_handler_rec *__cleanup_stack;
    char __opaque[1168];
};

struct __darwin_pthread_handler_rec {
    void (*__routine)(void *);
    void *__arg;
    struct __darwin_pthread_handler_rec *__next;
};

typedef struct sched_param sched_param, *Psched_param;

struct sched_param {
    int sched_priority;
    char __opaque[4];
};

typedef struct __siginfo __siginfo, *P__siginfo;

typedef __int32_t __darwin_pid_t;

typedef __darwin_pid_t pid_t;

typedef union sigval sigval, *Psigval;

union sigval {
    int sival_int;
    void *sival_ptr;
};

struct __siginfo {
    int si_signo;
    int si_errno;
    int si_code;
    pid_t si_pid;
    uid_t si_uid;
    int si_status;
    void *si_addr;
    union sigval si_value;
    long si_band;
    ulong __pad[7];
};

typedef union __sigaction_u __sigaction_u, *P__sigaction_u;

union __sigaction_u {
    void (*__sa_handler)(int);
    void (*__sa_sigaction)(int, struct __siginfo *, void *);
};

typedef struct sigaction sigaction, *Psigaction;

typedef __uint32_t __darwin_sigset_t;

typedef __darwin_sigset_t sigset_t;

struct sigaction {
    union __sigaction_u __sigaction_u;
    sigset_t sa_mask;
    int sa_flags;
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

struct _Unwind_Exception {
    uint64_t exception_class;
    void (*exception_cleanup)(_Unwind_Reason_Code, struct _Unwind_Exception *);
    uintptr_t private_1;
    uintptr_t private_2;
    uint32_t reserved[3];
};

typedef struct logic_error logic_error, *Plogic_error;

struct logic_error { // PlaceHolder Structure
};

typedef struct length_error length_error, *Plength_error;

struct length_error { // PlaceHolder Structure
};

typedef struct basic_string basic_string, *Pbasic_string;

struct basic_string { // PlaceHolder Structure
};

typedef struct basic_string<char,std::__1::char_traits<char>,std::__1::allocator<char>> basic_string<char,std::__1::char_traits<char>,std::__1::allocator<char>>, *Pbasic_string<char,std::__1::char_traits<char>,std::__1::allocator<char>>;

struct basic_string<char,std::__1::char_traits<char>,std::__1::allocator<char>> { // PlaceHolder Structure
};

typedef struct allocator allocator, *Pallocator;

struct allocator { // PlaceHolder Structure
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

typedef struct _opaque_pthread_rwlockattr_t _opaque_pthread_rwlockattr_t, *P_opaque_pthread_rwlockattr_t;

struct _opaque_pthread_rwlockattr_t {
    long __sig;
    char __opaque[16];
};

typedef __uint32_t __darwin_useconds_t;

typedef struct _opaque_pthread_rwlockattr_t __darwin_pthread_rwlockattr_t;

typedef ulong __darwin_size_t;

typedef uchar __uint8_t;

typedef long __darwin_ssize_t;

typedef struct rusage rusage, *Prusage;

struct rusage {
    struct timeval ru_utime;
    struct timeval ru_stime;
    long ru_maxrss;
    long ru_ixrss;
    long ru_idrss;
    long ru_isrss;
    long ru_minflt;
    long ru_majflt;
    long ru_nswap;
    long ru_inblock;
    long ru_oublock;
    long ru_msgsnd;
    long ru_msgrcv;
    long ru_nsignals;
    long ru_nvcsw;
    long ru_nivcsw;
};

typedef __darwin_time_t time_t;

typedef int thread_state_flavor_t;

typedef natural_t *thread_state_t;

typedef __darwin_useconds_t useconds_t;

typedef natural_t mach_port_name_t;

typedef struct addrinfo addrinfo, *Paddrinfo;

typedef struct sockaddr sockaddr, *Psockaddr;

typedef __uint8_t sa_family_t;

struct addrinfo {
    int ai_flags;
    int ai_family;
    int ai_socktype;
    int ai_protocol;
    socklen_t ai_addrlen;
    char *ai_canonname;
    struct sockaddr *ai_addr;
    struct addrinfo *ai_next;
};

struct sockaddr {
    __uint8_t sa_len;
    sa_family_t sa_family;
    char sa_data[14];
};

typedef mach_port_t task_t;

typedef mach_port_t task_name_t;

typedef mach_port_t thread_act_t;

typedef thread_act_t *thread_act_array_t;

typedef __darwin_ssize_t ssize_t;

typedef int vm_prot_t;

typedef struct kevent64_s kevent64_s, *Pkevent64_s;

struct kevent64_s {
    uint64_t ident;
    int16_t filter;
    uint16_t flags;
    uint32_t fflags;
    int64_t data;
    uint64_t udata;
    uint64_t ext[2];
};

typedef struct __darwin_sigaltstack __darwin_sigaltstack, *P__darwin_sigaltstack;

typedef struct __darwin_sigaltstack stack_t;

struct __darwin_sigaltstack {
    void *ss_sp;
    __darwin_size_t ss_size;
    int ss_flags;
};

typedef natural_t thread_flavor_t;

typedef integer_t *thread_info_t;

typedef __darwin_pthread_rwlockattr_t pthread_rwlockattr_t;

typedef __darwin_size_t size_t;

typedef int kern_return_t;

typedef natural_t mach_msg_type_number_t;




void FUN_00004084(uint param_1,long param_2)

{
  ulong *puVar1;
  char cVar2;
  bool bVar3;
  
  puVar1 = (ulong *)(param_2 + (ulong)((param_1 ^ param_1 & 0x3f) >> 3));
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(puVar1,0x10);
    if (bVar3) {
      *puVar1 = *puVar1 ^ 1L << (param_1 & 0x3f);
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_000040ac(uint param_1,long param_2)

{
  ulong *puVar1;
  char cVar2;
  bool bVar3;
  
  puVar1 = (ulong *)(param_2 + (ulong)((param_1 ^ param_1 & 0x3f) >> 3));
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(puVar1,0x10);
    if (bVar3) {
      *puVar1 = *puVar1 & (1L << (param_1 & 0x3f) ^ 0xffffffffffffffffU);
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_000040d4(uint param_1,long param_2)

{
  ulong *puVar1;
  char cVar2;
  bool bVar3;
  
  puVar1 = (ulong *)(param_2 + (ulong)((param_1 ^ param_1 & 0x3f) >> 3));
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(puVar1,0x10);
    if (bVar3) {
      *puVar1 = *puVar1 | 1L << (param_1 & 0x3f);
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



ulong FUN_000040fc(uint param_1,long param_2)

{
  ulong *puVar1;
  uint uVar2;
  char cVar3;
  bool bVar4;
  ulong uVar5;
  
  uVar2 = param_1 & 0x3f;
  puVar1 = (ulong *)(param_2 + (ulong)((param_1 ^ uVar2) >> 3));
  do {
    uVar5 = *puVar1;
    cVar3 = '\x01';
    bVar4 = (bool)ExclusiveMonitorPass(puVar1,0x10);
    if (bVar4) {
      *puVar1 = uVar5 ^ 1L << uVar2;
      cVar3 = ExclusiveMonitorsStatus();
    }
  } while (cVar3 != '\0');
  return uVar5 >> uVar2 & 1;
}



ulong FUN_0000412c(uint param_1,long param_2)

{
  ulong *puVar1;
  uint uVar2;
  char cVar3;
  bool bVar4;
  ulong uVar5;
  
  uVar2 = param_1 & 0x3f;
  puVar1 = (ulong *)(param_2 + (ulong)((param_1 ^ uVar2) >> 3));
  do {
    uVar5 = *puVar1;
    cVar3 = '\x01';
    bVar4 = (bool)ExclusiveMonitorPass(puVar1,0x10);
    if (bVar4) {
      *puVar1 = uVar5 & (1L << uVar2 ^ 0xffffffffffffffffU);
      cVar3 = ExclusiveMonitorsStatus();
    }
  } while (cVar3 != '\0');
  return uVar5 >> uVar2 & 1;
}



ulong FUN_0000415c(uint param_1,long param_2)

{
  ulong *puVar1;
  uint uVar2;
  char cVar3;
  bool bVar4;
  ulong uVar5;
  
  uVar2 = param_1 & 0x3f;
  puVar1 = (ulong *)(param_2 + (ulong)((param_1 ^ uVar2) >> 3));
  do {
    uVar5 = *puVar1;
    cVar3 = '\x01';
    bVar4 = (bool)ExclusiveMonitorPass(puVar1,0x10);
    if (bVar4) {
      *puVar1 = uVar5 | 1L << uVar2;
      cVar3 = ExclusiveMonitorsStatus();
    }
  } while (cVar3 != '\0');
  return uVar5 >> uVar2 & 1;
}



int _ahpl_os_open(char *param_1,int param_2)

{
  int iVar1;
  
  iVar1 = _open(param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_os_mkdir(char *param_1,mode_t param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002464c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__mkdir_00028350)((int)param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_os_rmdir(char *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248f8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__rmdir_00028518)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_os_unlink(char *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a48. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__unlink_000285f8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_os_fstat(int param_1,stat *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024514. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__fstat_00028280)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_os_stat(char *param_1,stat *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024970. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__stat_00028568)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_os_rename(char *param_1,char *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248ec. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__rename_00028510)((int)param_1);
  return iVar1;
}



undefined8 FUN_000041d4(long param_1)

{
  int iVar1;
  
  iVar1 = _kqueue();
  *(int *)(param_1 + 0x30) = iVar1;
  iVar1 = _ioctl(iVar1,0x20006601);
  if (iVar1 < 0) {
    _close(*(int *)(param_1 + 0x30));
    *(undefined4 *)(param_1 + 0x30) = 0xffffffff;
  }
  else if (-1 < *(int *)(param_1 + 0x30)) {
    return 0;
  }
  *(undefined4 *)(param_1 + 0x30) = 0xffffffff;
  return 0xffffffff;
}



void FUN_0000423c(long param_1)

{
  FUN_0000719c(*(undefined4 *)(param_1 + 0x30));
  return;
}



void FUN_00004244(long param_1)

{
  long local_50;
  undefined8 uStack_48;
  undefined8 local_40;
  long lStack_38;
  undefined8 local_30;
  undefined8 uStack_28;
  
  FUN_0000dd28();
  local_50 = (long)*(int *)(param_1 + 0x28);
  uStack_48 = 0x1ffff;
  local_40 = 0;
  local_30 = 0;
  uStack_28 = 0;
  lStack_38 = local_50;
  FUN_000047dc(*(undefined4 *)(param_1 + 0x30),&local_50,1);
  return;
}



void FUN_00004290(long param_1)

{
  long local_40;
  undefined *puStack_38;
  undefined8 local_30;
  long lStack_28;
  undefined8 local_20;
  undefined8 uStack_18;
  
  local_40 = (long)*(int *)(param_1 + 0x28);
  puStack_38 = &DAT_0002ffff;
  local_30 = 0;
  local_20 = 0;
  uStack_18 = 0;
  lStack_28 = local_40;
  FUN_000047dc(*(undefined4 *)(param_1 + 0x30),&local_40,1);
  return;
}



void FUN_000042cc(long param_1,int *param_2)

{
  int iVar1;
  ulong uVar2;
  int *piVar3;
  undefined auStack_a8 [96];
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  iVar1 = _fcntl(*param_2,0x49);
  if (*(long *)(param_2 + 0x20) != 0) {
    FUN_00004820((long)*param_2,iVar1);
  }
  if (*(long *)(param_2 + 0x22) != 0) {
    FUN_00004848();
    FUN_00004860();
  }
  uVar2 = FUN_000047dc(*(undefined4 *)(param_1 + 0x30),auStack_a8);
  if ((int)uVar2 < 0) {
    piVar3 = ___error();
    uVar2 = (ulong)(uint)-*piVar3;
    if (0 < *piVar3) {
      iVar1 = FUN_00004810();
      if (iVar1 == -1) {
        ___error();
      }
      iVar1 = FUN_000047f0();
      if (iVar1 == -1) {
        ___error();
        FUN_00004838();
      }
      _ahpl_log(2,"ahpl: iomp add fd failed with errno=%d, efd=%d(valid: %d), fd=%d(valid: %d)");
      FUN_00004884();
    }
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_48) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  FUN_000047fc(uVar2);
  return;
}



void FUN_000043f4(long param_1,int *param_2)

{
  int iVar1;
  ulong uVar2;
  int *piVar3;
  undefined auStack_a8 [96];
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  if (*(long *)(param_2 + 0x20) != 0) {
    FUN_00004820((long)*param_2);
  }
  if (*(long *)(param_2 + 0x22) != 0) {
    FUN_00004848();
    FUN_00004860();
  }
  uVar2 = FUN_000047dc(*(undefined4 *)(param_1 + 0x30),auStack_a8);
  if ((int)uVar2 < 0) {
    piVar3 = ___error();
    uVar2 = (ulong)(uint)-*piVar3;
    if (0 < *piVar3) {
      iVar1 = FUN_00004810();
      if (iVar1 == -1) {
        ___error();
      }
      iVar1 = FUN_000047f0();
      if (iVar1 == -1) {
        ___error();
        FUN_00004838();
      }
      _ahpl_log(2,"ahpl: iomp del fd failed with errno=%d, efd=%d(valid: %d), fd=%d(valid: %d)");
      FUN_00004884();
    }
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_48) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  FUN_000047fc(uVar2);
  return;
}



int FUN_00004508(long param_1,kevent64_s *param_2,int param_3,ulong param_4)

{
  int iVar1;
  int iVar2;
  long lVar3;
  long lVar4;
  int *piVar5;
  timespec *timeout;
  timespec local_70;
  
  if ((long)param_4 < 1) {
    lVar3 = 0;
  }
  else {
    lVar3 = _ahpl_tick_now();
  }
  do {
    if ((long)param_4 < 1) {
      if (-1 < (long)param_4) {
        param_4 = 0;
        goto LAB_00004584;
      }
      timeout = (timespec *)0x0;
    }
    else {
      lVar4 = _ahpl_tick_now();
      param_4 = (lVar3 - lVar4) + param_4;
      param_4 = param_4 & ((long)param_4 >> 0x3f ^ 0xffffffffffffffffU);
      lVar3 = lVar4;
LAB_00004584:
      local_70.tv_sec = param_4 / 1000;
      local_70.tv_nsec = (param_4 % 1000) * 1000000;
      timeout = &local_70;
    }
    iVar1 = _kevent64(*(int *)(param_1 + 0x30),(kevent64_s *)0x0,0,param_2,param_3,0,timeout);
    if (-1 < iVar1) {
      return iVar1;
    }
    piVar5 = ___error();
    if (*piVar5 != 4) {
      iVar2 = FUN_000047f0();
      if (iVar2 == -1) {
        ___error();
        FUN_00004838();
      }
      _ahpl_log(0,"ahpl: low level iomp failed with errno=%d, efd=%d(valid: %d/%d)");
      _usleep(500);
      return iVar1;
    }
  } while( true );
}



void FUN_00004640(long param_1,long param_2,int param_3)

{
  bool bVar1;
  bool bVar2;
  bool bVar3;
  bool bVar4;
  int iVar5;
  int iVar6;
  int *piVar7;
  long lVar8;
  ulong *puVar9;
  ulong uVar10;
  socklen_t local_68;
  int local_64;
  
  if (0 < param_3) {
    lVar8 = (long)param_3;
    puVar9 = (ulong *)(param_2 + 0x10);
    do {
      iVar5 = *(int *)(puVar9 + -2);
      if (*(int *)(param_1 + 0x28) == iVar5) {
        FUN_00008d10(param_1);
      }
      else {
        if (((uint)(int)*(short *)((long)puVar9 + -6) >> 0xe & 1) == 0) {
          bVar4 = *(short *)(puVar9 + -1) == -1;
          bVar2 = *(short *)(puVar9 + -1) == -2;
          bVar3 = *(short *)((long)puVar9 + -6) < 0;
          bVar1 = false;
        }
        else {
          uVar10 = *puVar9;
          if (uVar10 < 0x21) {
            if ((1L << (uVar10 & 0x3f) & 0x400204U) == 0) {
              if ((1L << (uVar10 & 0x3f) & 0x100000002U) != 0) {
                bVar3 = false;
                bVar4 = true;
                bVar2 = false;
                bVar1 = false;
                goto LAB_00004714;
              }
              goto LAB_00004708;
            }
          }
          else {
LAB_00004708:
            piVar7 = ___error();
            *piVar7 = (int)uVar10;
          }
          bVar3 = false;
          bVar4 = false;
          bVar2 = false;
          bVar1 = true;
        }
LAB_00004714:
        uVar10 = puVar9[1];
        piVar7 = (int *)FUN_00006254(iVar5);
        if (piVar7 != (int *)0x0) {
          if (piVar7[3] == (int)uVar10) {
            if (bVar1) {
              local_68 = 4;
              iVar6 = _getsockopt(*piVar7,0xffff,0x1007,&local_64,&local_68);
              iVar5 = -20000;
              if (local_64 != 0 && -1 < iVar6) {
                iVar5 = -local_64;
              }
              local_64 = iVar5;
              FUN_00004878();
            }
            else {
              if (bVar2) {
                FUN_00004878();
                iVar5 = FUN_00006674();
                if (iVar5 < 0) goto LAB_000047a8;
              }
              if (bVar4) {
                FUN_00004878();
                iVar5 = FUN_000063a4();
                if (iVar5 < 0) goto LAB_000047a8;
              }
              if (!bVar3) goto LAB_000047a8;
              FUN_00004878();
            }
            FUN_00006610();
          }
LAB_000047a8:
          FUN_000062d4(piVar7);
        }
      }
      puVar9 = puVar9 + 6;
      lVar8 = lVar8 + -1;
    } while (lVar8 != 0);
  }
  return;
}



int FUN_000047dc(int param_1,kevent64_s *param_2,int param_3)

{
  int iVar1;
  
  iVar1 = _kevent64(param_1,param_2,param_3,(kevent64_s *)0x0,0,0,(timespec *)0x0);
  return iVar1;
}



int FUN_000047f0(void)

{
  int iVar1;
  int unaff_w19;
  
  iVar1 = _fcntl(unaff_w19,3);
  return iVar1;
}



void FUN_000047fc(void)

{
  return;
}



int FUN_00004810(void)

{
  int iVar1;
  long unaff_x21;
  
  iVar1 = _fcntl(*(int *)(unaff_x21 + 0x30),3);
  return iVar1;
}



void FUN_00004820(void)

{
  return;
}



void FUN_00004838(void)

{
  return;
}



void FUN_00004848(void)

{
  return;
}



void FUN_00004860(undefined8 param_1)

{
  uint uVar1;
  undefined8 *in_x9;
  undefined8 in_x10;
  long unaff_x19;
  
  *in_x9 = param_1;
  in_x9[1] = in_x10;
  uVar1 = *(uint *)(unaff_x19 + 0xc);
  in_x9[4] = 0;
  in_x9[5] = 0;
  in_x9[2] = 0;
  in_x9[3] = (ulong)uVar1;
  return;
}



void FUN_00004878(void)

{
  return;
}



int FUN_00004884(void)

{
  int iVar1;
  
  iVar1 = _usleep(1000000);
  return iVar1;
}



int FUN_00004890(int param_1)

{
  int iVar1;
  bool bVar2;
  int iVar3;
  int iVar4;
  pthread_t p_Var5;
  sched_param local_28;
  
  iVar3 = _sched_get_priority_min(2);
  iVar4 = _sched_get_priority_max(2);
  bVar2 = true;
  if (iVar3 != 0x16 && iVar4 != 0x16) {
    bVar2 = (iVar4 - iVar3) + -3 < 0;
  }
  if (bVar2 != ((iVar3 != 0x16 && iVar4 != 0x16) && SBORROW4(iVar4 - iVar3,3))) {
    return iVar4;
  }
  if (4 < param_1 - 1U) {
    return iVar4;
  }
  iVar1 = iVar3 + 1;
  local_28.sched_priority = iVar1;
  switch(param_1) {
  case 2:
    local_28.sched_priority = (iVar4 + iVar3 + -1) / 2;
    break;
  case 3:
    local_28.sched_priority = iVar4 + -3;
    goto LAB_00004914;
  case 4:
    local_28.sched_priority = iVar4 + -2;
LAB_00004914:
    if (local_28.sched_priority <= iVar1) {
      local_28.sched_priority = iVar1;
    }
    break;
  case 5:
    local_28.sched_priority = iVar4 + -1;
  }
  p_Var5 = _pthread_self();
  iVar3 = _pthread_setschedparam(p_Var5,2,&local_28);
  return iVar3;
}



int FUN_00004948(pthread_t *param_1,void **param_2,void *param_3)

{
  int iVar1;
  pthread_attr_t pStack_78;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  _pthread_attr_init(&pStack_78);
  _pthread_attr_setdetachstate(&pStack_78,2);
  iVar1 = _pthread_create(param_1,&pStack_78,param_2,param_3);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return -iVar1;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

pthread_t _pthread_self(void)

{
  pthread_t p_Var1;
  
                    // WARNING: Could not recover jumptable at 0x00024880. Too many branches
                    // WARNING: Treating indirect jump as call
  p_Var1 = (pthread_t)(*(code *)PTR__pthread_self_000284c8)();
  return p_Var1;
}



mach_port_t FUN_000049d8(void)

{
  mach_port_t mVar1;
  pthread_t p_Var2;
  
  p_Var2 = _pthread_self();
  mVar1 = _pthread_mach_thread_np(p_Var2);
  return mVar1;
}



int FUN_000049ec(pthread_key_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_key_create(param_1,(void *)0x0);
  return -iVar1;
}



int FUN_00004a08(pthread_key_t param_1,void *param_2)

{
  int iVar1;
  
  iVar1 = _pthread_setspecific(param_1,param_2);
  return -iVar1;
}



int FUN_00004a20(pthread_key_t param_1)

{
  int iVar1;
  
  iVar1 = _pthread_key_delete(param_1);
  return -iVar1;
}



void FUN_00004a38(void)

{
  int iVar1;
  long local_28;
  
  FUN_00004d40(*(undefined8 *)PTR____stack_chk_guard_00028030);
  iVar1 = FUN_00004d28();
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    _abort();
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    FUN_00004d1c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00004a8c(void)

{
  int iVar1;
  pthread_mutexattr_t pStack_38;
  long local_28;
  
  FUN_00004d40(*(undefined8 *)PTR____stack_chk_guard_00028030);
  iVar1 = _pthread_mutexattr_settype(&pStack_38,2);
  iVar1 = FUN_00004d28(iVar1);
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    _abort();
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    FUN_00004d1c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00004aec(pthread_mutex_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_mutex_lock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004b08(pthread_mutex_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_mutex_trylock(param_1);
  FUN_00004d34(iVar1);
  return;
}



void FUN_00004b20(pthread_mutex_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_mutex_unlock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004b3c(pthread_mutex_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_mutex_destroy(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004b58(pthread_rwlock_t *param_1)

{
  int iVar1;
  pthread_rwlockattr_t pStack_40;
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  _pthread_rwlockattr_init(&pStack_40);
  iVar1 = _pthread_rwlock_init(param_1,&pStack_40);
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    _abort();
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    FUN_00004d1c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00004bbc(pthread_rwlock_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_rwlock_rdlock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004bd8(pthread_rwlock_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_rwlock_tryrdlock(param_1);
  FUN_00004d34(iVar1);
  return;
}



void FUN_00004bf0(pthread_rwlock_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_rwlock_wrlock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004c0c(pthread_rwlock_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_rwlock_trywrlock(param_1);
  FUN_00004d34(iVar1);
  return;
}



void FUN_00004c24(pthread_rwlock_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_rwlock_unlock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004c40(pthread_rwlock_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_rwlock_unlock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004c5c(pthread_rwlock_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_rwlock_destroy(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004c78(pthread_cond_t *param_1)

{
  int iVar1;
  pthread_condattr_t pStack_38;
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  _pthread_condattr_init(&pStack_38);
  _pthread_cond_init(param_1,&pStack_38);
  iVar1 = _pthread_condattr_destroy(&pStack_38);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    FUN_00004d1c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(iVar1);
}



void FUN_00004cdc(pthread_cond_t *param_1,pthread_mutex_t *param_2,long param_3)

{
  int iVar1;
  timespec local_20;
  
  local_20.tv_sec = param_3 / 1000;
  local_20.tv_nsec = (param_3 % 1000) * 1000000;
  iVar1 = _pthread_cond_timedwait_relative_np(param_1,param_2,&local_20);
  FUN_00004d34(iVar1);
  return;
}



void FUN_00004d1c(void)

{
  return;
}



int FUN_00004d28(void)

{
  int iVar1;
  pthread_mutex_t *unaff_x19;
  
  iVar1 = _pthread_mutex_init(unaff_x19,(pthread_mutexattr_t *)&stack0x00000008);
  return iVar1;
}



bool FUN_00004d34(int param_1)

{
  return param_1 == 0;
}



int FUN_00004d40(undefined8 param_1)

{
  int iVar1;
  undefined8 param_11;
  
  param_11 = param_1;
  iVar1 = _pthread_mutexattr_init((pthread_mutexattr_t *)&stack0x00000008);
  return iVar1;
}



long FUN_00004d4c(void)

{
  long lVar1;
  int iVar2;
  timeval local_20;
  
  iVar2 = _gettimeofday(&local_20,(void *)0x0);
  lVar1 = 0;
  if (-1 < iVar2) {
    lVar1 = (long)local_20.tv_usec + local_20.tv_sec * 1000000;
  }
  return lVar1;
}



void _ahpl_ns_from_ts(void)

{
  FUN_00004ddc(1000000000);
  return;
}



void _ahpl_us_from_ts(void)

{
  FUN_00004ddc(1000000);
  return;
}



void _ahpl_ms_from_ts(void)

{
  FUN_00004ddc(1000);
  return;
}



int _ahpl_msleep(int param_1)

{
  int iVar1;
  
  iVar1 = _usleep(param_1 * 1000);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_usleep(useconds_t param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a54. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__usleep_00028600)(param_1);
  return iVar1;
}



long FUN_00004ddc(long param_1)

{
  long in_x9;
  long in_x10;
  
  return in_x10 + in_x9 * param_1;
}



undefined8 FUN_00004de4(thread_act_t param_1)

{
  kern_return_t kVar1;
  int iVar2;
  mach_msg_type_number_t local_146c;
  natural_t anStack_1468 [64];
  undefined8 local_1368;
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  local_146c = 0x510;
  _pthread_mutex_lock((pthread_mutex_t *)&DAT_00028b78);
  kVar1 = _thread_get_state(param_1,6,anStack_1468,&local_146c);
  if (kVar1 != 0) {
    local_1368 = 0;
  }
  iVar2 = _pthread_mutex_unlock((pthread_mutex_t *)&DAT_00028b78);
  if (*(long *)PTR____stack_chk_guard_00028030 != local_28) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(iVar2);
  }
  return local_1368;
}



ulong FUN_00004e88(void)

{
  ulong uVar1;
  ulong uVar2;
  uint64_t uVar3;
  ulong uVar4;
  ulong uVar5;
  
  uVar3 = _mach_absolute_time();
  uVar4 = uVar3 * DAT_00028e18;
  uVar5 = (ulong)DAT_00028e1c;
  uVar1 = 0;
  if (uVar5 != 0) {
    uVar1 = uVar3 / uVar5;
  }
  uVar2 = 0;
  if (uVar5 != 0) {
    uVar2 = uVar4 / uVar5;
  }
  if (uVar4 < uVar3) {
    uVar2 = uVar1 * DAT_00028e18;
  }
  return uVar2;
}



void FUN_00004ec4(void)

{
  kern_return_t kVar1;
  mach_timebase_info local_18;
  
  kVar1 = _mach_timebase_info(&local_18);
  if (kVar1 == 0) {
    DAT_00028e18 = local_18.numer;
    DAT_00028e1c = local_18.denom;
    if ((local_18.numer != 0) && (local_18.denom != 0)) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00004f08(thread_act_t param_1,uint *param_2,long *param_3,long *param_4)

{
  kern_return_t kVar1;
  undefined8 uVar2;
  mach_msg_type_number_t local_bc;
  long local_b8;
  long local_b0;
  long lStack_a8;
  int local_a0;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  local_bc = 0x20;
  kVar1 = _thread_info(param_1,3,(thread_info_t)&local_b8,&local_bc);
  if (kVar1 == 0) {
    if (param_2 != (uint *)0x0) {
      *param_2 = (uint)(local_a0 == 1);
    }
    if (param_3 != (long *)0x0) {
      *param_3 = lStack_a8 + local_b0 * 1000000;
    }
    uVar2 = 0;
    if (param_4 != (long *)0x0) {
      *param_4 = local_b0 + local_b8 * 1000000;
    }
  }
  else {
    uVar2 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



void FUN_00004fcc(uint *param_1)

{
  ushort uVar1;
  byte *pbVar2;
  int iVar3;
  ushort *puVar4;
  long lVar5;
  uint uVar6;
  int iVar7;
  uint *puVar8;
  ushort *local_c8;
  long local_c0;
  byte *local_b8;
  char *local_b0;
  undefined8 local_80;
  undefined8 uStack_78;
  undefined8 local_70;
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  *param_1 = 0xffffffff;
  *(undefined *)((long)param_1 + 0x51) = 0;
  param_1[0x34] = 0xffffffff;
  *(undefined *)((long)param_1 + 0x121) = 0;
  uStack_78 = 0;
  local_80 = 0x1100000004;
  local_70 = 7;
  iVar3 = FUN_00005680(&local_80,6,0,&local_c8);
  if (-1 < iVar3) {
    puVar4 = local_c8;
    if ((local_c8 == (ushort *)0x0) || (puVar4 = (ushort *)_ahpl_malloc(), puVar4 == (ushort *)0x0))
    goto LAB_00005244;
    iVar3 = FUN_00005680(&local_80,6,puVar4,&local_c8);
    if (-1 < iVar3) {
      if ((long)local_c8 < 0x5c) {
        iVar3 = 0;
        iVar7 = 0;
      }
      else {
        iVar7 = 0;
        iVar3 = 0;
        do {
          if ((((*(char *)(puVar4 + 1) == '\x05') && ((*(uint *)(puVar4 + 4) >> 0x18 & 1) == 0)) &&
              (((*(uint *)(puVar4 + 4) >> 0x11 & 1) == 0 || ((*(byte *)(puVar4 + 0xb) & 1) == 0))))
             && (((FUN_00005280(*(undefined4 *)(puVar4 + 6),puVar4 + 0x2e,(ulong)*puVar4 - 0x5c,
                                &local_c0), pbVar2 = local_b8, local_c0 != 0 &&
                  (local_b0 != (char *)0x0)) && (local_b8 != (byte *)0x0)))) {
            if (*(char *)(local_c0 + 1) == '\x1e') {
              if (((((*(int *)(local_c0 + 8) == 0) && (*(int *)(local_c0 + 0xc) == 0)) &&
                   ((*(int *)(local_c0 + 0x10) == 0 && (*(int *)(local_c0 + 0x14) == 0)))) &&
                  ((*local_b0 == '\0' ||
                   (((*(int *)(local_b0 + 8) == 0 && (*(int *)(local_b0 + 0xc) == 0)) &&
                    ((*(int *)(local_b0 + 0x10) == 0 && (*(int *)(local_b0 + 0x14) == 0)))))))) &&
                 ((iVar3 == 0 && (local_b8[1] == 0x1e)))) {
                iVar3 = 1;
                puVar8 = param_1 + 0x34;
                goto LAB_00005128;
              }
            }
            else if ((((*(char *)(local_c0 + 1) == '\x02') && (*(int *)(local_c0 + 4) == 0)) &&
                     ((*local_b0 == '\0' || (*(int *)(local_b0 + 4) == 0)))) &&
                    ((local_b8[1] == 2 && (iVar7 == 0)))) {
              iVar7 = 1;
              puVar8 = param_1;
LAB_00005128:
              uVar1 = puVar4[2];
              lVar5 = FUN_000172e0(uVar1);
              *puVar8 = (uint)uVar1;
              if (lVar5 == 0) {
                puVar8[1] = 0xffffffff;
                ___sprintf_chk(puVar8 + 2,0,0x40,"%d");
                uVar6 = 1;
              }
              else {
                puVar8[1] = *(uint *)(lVar5 + 4);
                ___strcpy_chk(puVar8 + 2,lVar5 + 8,0x40);
                uVar6 = (uint)(puVar8[1] == 0xff);
              }
              puVar8[0x12] = uVar6;
              _memcpy(puVar8 + 0x14,pbVar2,(ulong)*pbVar2);
            }
          }
          uVar1 = *puVar4;
          puVar4 = (ushort *)((long)puVar4 + (ulong)uVar1);
          local_c8 = (ushort *)((long)local_c8 - (ulong)uVar1);
        } while (0x5b < (long)local_c8);
      }
      FUN_0000568c();
      puVar4 = (ushort *)(ulong)(uint)(iVar7 + iVar3);
      goto LAB_00005244;
    }
    FUN_0000568c();
  }
  puVar4 = (ushort *)0x0;
LAB_00005244:
  if (*(long *)PTR____stack_chk_guard_00028030 != local_68) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(puVar4);
  }
  return;
}



void FUN_00005280(uint param_1,byte *param_2,long param_3,undefined8 *param_4)

{
  bool bVar1;
  bool bVar2;
  ulong uVar3;
  ulong uVar4;
  
  param_4[5] = 0;
  param_4[4] = 0;
  param_4[7] = 0;
  param_4[6] = 0;
  param_4[1] = 0;
  *param_4 = 0;
  param_4[3] = 0;
  param_4[2] = 0;
  if ((0 < param_3) && (uVar4 = (ulong)*param_2, (long)uVar4 <= param_3)) {
    uVar3 = 0;
    do {
      if ((param_1 >> (ulong)((uint)uVar3 & 0x1f) & 1) != 0) {
        param_4[uVar3] = param_2;
        uVar4 = (ulong)((int)uVar4 + 3) & 0x1fc;
        param_3 = param_3 - uVar4;
        if (param_3 < 1) {
          return;
        }
        param_2 = param_2 + uVar4;
      }
      uVar4 = (ulong)*param_2;
      bVar1 = uVar3 < 7;
      bVar2 = true;
      if (bVar1) {
        bVar2 = (long)(param_3 - uVar4) < 0;
      }
      uVar3 = uVar3 + 1;
    } while (bVar2 == (bVar1 && SBORROW8(param_3,uVar4)));
  }
  return;
}



undefined8 FUN_000052e0(void)

{
  ushort uVar1;
  int iVar2;
  undefined8 uVar3;
  ushort *puVar4;
  long local_58;
  undefined8 local_50;
  undefined8 uStack_48;
  undefined8 local_40;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  uVar3 = FUN_000053ec();
  if (-1 < (int)uVar3) {
    uStack_48 = 0;
    local_50 = 0x1100000004;
    local_40 = 3;
    iVar2 = FUN_00005680(&local_50,6,0,&local_58);
    if ((-1 < iVar2) && (puVar4 = (ushort *)_ahpl_malloc(local_58), puVar4 != (ushort *)0x0)) {
      iVar2 = FUN_00005680(&local_50,6,puVar4,&local_58);
      if (-1 < iVar2) {
        for (; 0x6f < local_58; local_58 = local_58 - (ulong)uVar1) {
          if ((*(char *)(puVar4 + 1) == '\x05') && (*(char *)((long)puVar4 + 3) == '\x0e')) {
            FUN_00005574(puVar4);
          }
          uVar1 = *puVar4;
          puVar4 = (ushort *)((long)puVar4 + (ulong)uVar1);
        }
      }
      FUN_0000568c();
    }
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_38) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  return uVar3;
}



undefined8 FUN_000053ec(void)

{
  int iVar1;
  int iVar2;
  int *piVar3;
  
  iVar1 = _socket(0x11,3,0);
  if (-1 < iVar1) {
    iVar2 = _ahpl_mpq_add_dgram_socket(iVar1,0x2000,FUN_000054b4,FUN_00005544,2);
    if (-1 < iVar2) {
      DAT_00028bb8 = iVar1;
      return 0;
    }
    piVar3 = ___error();
    iVar2 = *piVar3;
    _close(iVar1);
    piVar3 = ___error();
    *piVar3 = iVar2;
  }
  return 0xffffffff;
}



void FUN_00005484(void)

{
  if (-1 < DAT_00028bb8) {
    _ahpl_close();
    DAT_00028bb8 = -1;
  }
  return;
}



void FUN_000054b4(ushort *param_1,ulong param_2,undefined8 param_3,undefined8 *param_4)

{
  ushort uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  if ((0x5b < param_2) && (0 < (long)param_2)) {
    uVar2 = *param_4;
    uVar3 = param_4[1];
    do {
      if (*(char *)(param_1 + 1) == '\x05') {
        if (*(byte *)((long)param_1 + 3) - 1 < 3) {
          FUN_000175d4(uVar2,uVar3);
        }
        else if (*(byte *)((long)param_1 + 3) - 0xc < 3) {
          FUN_00005574(param_1);
        }
      }
      uVar1 = *param_1;
      param_1 = (ushort *)((long)param_1 + (ulong)uVar1);
      param_2 = param_2 - uVar1;
    } while (0 < (long)param_2);
  }
  return;
}



void FUN_00005544(undefined8 param_1,int param_2,undefined8 param_3,undefined8 *param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  
  if (-1 < param_2) {
    return;
  }
  uVar1 = *param_4;
  uVar2 = param_4[1];
  _ahpl_close();
  FUN_000053ec(uVar1,uVar2);
  return;
}



void FUN_0000554c(void)

{
  undefined8 *in_x3;
  undefined8 uVar1;
  undefined8 uVar2;
  
  uVar1 = *in_x3;
  uVar2 = in_x3[1];
  _ahpl_close();
  FUN_000053ec(uVar1,uVar2);
  return;
}



void FUN_00005574(ushort *param_1)

{
  char cVar1;
  byte bVar2;
  ushort uVar3;
  uint uVar4;
  long lVar5;
  long lVar6;
  undefined auStack_98 [32];
  undefined auStack_78 [32];
  long local_58;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  cVar1 = *(char *)((long)param_1 + 3);
  if ((cVar1 == '\f') || (cVar1 == '\r')) {
    uVar4 = *(uint *)(param_1 + 2);
    if ((uVar4 >> 4 & 1) == 0) goto LAB_00005650;
    lVar6 = 0;
    lVar5 = -0x14;
  }
  else {
    if ((cVar1 != '\x0e') || (uVar4 = *(uint *)(param_1 + 2), (uVar4 >> 4 & 1) == 0))
    goto LAB_00005650;
    lVar5 = -0x70;
    lVar6 = 1;
  }
  uVar3 = param_1[6];
  FUN_00005280(uVar4,param_1 + lVar6 * 0x2e + 10,lVar5 + (ulong)*param_1,auStack_78);
  if (local_58 != 0) {
    bVar2 = *(byte *)(local_58 + 5);
    if (bVar2 != 0) {
      uVar4 = (uint)bVar2;
      if (0x1e < bVar2) {
        uVar4 = 0x1f;
      }
      ___strncpy_chk(auStack_98,local_58 + 8,(ulong)uVar4,0x20);
      auStack_98[uVar4] = 0;
    }
    FUN_00017330(0,uVar3);
  }
LAB_00005650:
  if (*(long *)PTR____stack_chk_guard_00028030 != local_38) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  return;
}



int FUN_00005680(int *param_1,u_int param_2,void *param_3,size_t *param_4)

{
  int iVar1;
  
  iVar1 = _sysctl(param_1,param_2,param_3,param_4,(void *)0x0,0);
  return iVar1;
}



void FUN_0000568c(void)

{
  void *unaff_x20;
  
  _free(unaff_x20);
  return;
}



undefined8 _ahpl_get_uuid(char *param_1,ulong param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  char *pcVar4;
  int *piVar5;
  
  if (param_2 < 0x21) {
    piVar5 = ___error();
    *piVar5 = 0x16;
    uVar1 = 0xffffffff;
  }
  else {
    _objc_msgSend(&_OBJC_CLASS___NSUUID,"UUID");
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"UUIDString");
    uVar2 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar2,"stringByReplacingOccurrencesOfString:withString:",&cf__,&cf___);
    _objc_retainAutoreleasedReturnValue();
    uVar3 = _objc_retainAutorelease();
    pcVar4 = (char *)_objc_msgSend(uVar3,"UTF8String");
    _objc_release(uVar3);
    _objc_release(uVar2);
    _strncpy(param_1,pcVar4,param_2 - 1);
    param_1[param_2 - 1] = '\0';
    _objc_release(uVar1);
    uVar1 = 0;
  }
  return uVar1;
}



void _ahpl_os_version(char *param_1,ulong param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  int *piVar7;
  utsname uStack_570;
  long local_70;
  
  local_70 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_2 < 0x40) {
    piVar7 = ___error();
    *piVar7 = 0x16;
    uVar1 = 0xffffffff;
  }
  else {
    _uname(&uStack_570);
    FUN_00005dc4(&_OBJC_CLASS___UIDevice);
    uVar1 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar1,"model");
    _objc_retainAutoreleasedReturnValue();
    uVar2 = _objc_retainAutorelease();
    FUN_00005dbc();
    FUN_00005dc4(&_OBJC_CLASS___UIDevice);
    uVar3 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar3,"systemName");
    _objc_retainAutoreleasedReturnValue();
    uVar4 = _objc_retainAutorelease();
    FUN_00005dbc();
    FUN_00005dc4(&_OBJC_CLASS___UIDevice);
    uVar5 = _objc_retainAutoreleasedReturnValue();
    _objc_msgSend(uVar5,"systemVersion");
    _objc_retainAutoreleasedReturnValue();
    uVar6 = _objc_retainAutorelease();
    FUN_00005dbc();
    _snprintf(param_1,param_2,"%s/%s/%s/%s");
    _objc_release(uVar6);
    _objc_release(uVar5);
    _objc_release(uVar4);
    _objc_release(uVar3);
    _objc_release(uVar2);
    _objc_release(uVar1);
    uVar1 = 0;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_70) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar1);
}



void _ahpl_get_data_path(void)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  
  _NSSearchPathForDirectoriesInDomains(9,1,1);
  uVar1 = _objc_retainAutoreleasedReturnValue();
  _objc_msgSend(uVar1,"firstObject");
  _objc_retainAutoreleasedReturnValue();
  uVar2 = _objc_retainAutorelease();
  uVar3 = _objc_msgSend(uVar2,"UTF8String");
  _objc_release(uVar2);
  _objc_release(uVar1);
  _ahpl_strdup(uVar3);
  return;
}



long _ahpl_platform_obj_get(long param_1)

{
  if (param_1 != 0) {
    _objc_retain(param_1);
  }
  return param_1;
}



void _ahpl_platform_obj_put(long param_1)

{
  undefined *local_68;
  undefined8 local_60;
  code *local_58;
  undefined *puStack_50;
  undefined8 *local_48;
  undefined8 local_40;
  undefined8 *puStack_38;
  undefined8 local_30;
  code *local_28;
  code *pcStack_20;
  long local_18;
  
  if (param_1 != 0) {
    local_48 = &local_40;
    local_40 = 0;
    local_30 = 0x3032000000;
    local_28 = FUN_00005a48;
    pcStack_20 = FUN_00005a58;
    local_68 = PTR___NSConcreteStackBlock_00028000;
    local_60 = 0xc2000000;
    local_58 = FUN_00005a60;
    puStack_50 = &DAT_00028650;
    puStack_38 = local_48;
    local_18 = param_1;
    _dispatch_async(PTR___dispatch_main_q_00028038,&local_68);
    __Block_object_dispose(&local_40,8);
    _objc_release(local_18);
  }
  return;
}



void FUN_00005a48(long param_1,long param_2)

{
  *(undefined8 *)(param_1 + 0x28) = *(undefined8 *)(param_2 + 0x28);
  *(undefined8 *)(param_2 + 0x28) = 0;
  return;
}



void FUN_00005a58(long param_1)

{
  _objc_release(*(undefined8 *)(param_1 + 0x28));
  return;
}



void FUN_00005a60(long param_1)

{
  undefined8 uVar1;
  long lVar2;
  
  lVar2 = *(long *)(*(long *)(param_1 + 0x20) + 8);
  uVar1 = *(undefined8 *)(lVar2 + 0x28);
  *(undefined8 *)(lVar2 + 0x28) = 0;
  _objc_release(uVar1);
  return;
}



void FUN_00005a74(long param_1,long param_2)

{
  __Block_object_assign((void *)(param_1 + 0x20),*(void **)(param_2 + 0x20),8);
  return;
}



void FUN_00005a84(long param_1)

{
  __Block_object_dispose(*(void **)(param_1 + 0x20),8);
  return;
}



void FUN_00005a90(void)

{
  FUN_000154dc(&DAT_00028e20);
  DAT_00028f30 = 0;
  DAT_00028f38 = FUN_00005ad8;
  DAT_00028f40 = 0;
  __dyld_register_func_for_add_image(FUN_00005b24);
  __dyld_register_func_for_remove_image(FUN_00005c24);
  return;
}



int FUN_00005ad8(long param_1,long param_2,ulong *param_3)

{
  int iVar1;
  ulong uVar2;
  
  if (param_2 == 0) {
    uVar2 = *param_3;
  }
  else {
    uVar2 = *(ulong *)(param_2 + 0x28);
  }
  if (uVar2 < *(ulong *)(param_1 + 0x28)) {
    iVar1 = 1;
  }
  else {
    iVar1 = -(uint)(*(ulong *)(param_1 + 0x30) <= uVar2);
  }
  return iVar1;
}



void FUN_00005b24(long param_1,long param_2)

{
  int iVar1;
  int iVar2;
  long lVar3;
  long lVar4;
  long lVar5;
  int *piVar6;
  char *local_60 [4];
  
  FUN_00015504(&DAT_00028e20);
  lVar3 = _ahpl_find_rb_node(&DAT_00028f30,0);
  if ((lVar3 == 0) && (lVar3 = _ahpl_malloc(0x38), lVar3 != 0)) {
    iVar1 = _dladdr(param_1,local_60);
    if (iVar1 == 0) {
      local_60[0] = "<N/A>";
    }
    *(char **)(lVar3 + 0x18) = local_60[0];
    *(long *)(lVar3 + 0x20) = param_2;
    iVar1 = *(int *)(param_1 + 0x10);
    if (iVar1 != 0) {
      piVar6 = (int *)(param_1 + 0x20);
      do {
        if ((*piVar6 == 0x19) && (iVar2 = _strcmp((char *)(piVar6 + 2),"__TEXT"), iVar2 == 0)) {
          lVar4 = *(long *)(piVar6 + 6);
          lVar5 = *(long *)(piVar6 + 8);
          *(long *)(lVar3 + 0x28) = lVar4 + param_2;
          *(long *)(lVar3 + 0x30) = lVar4 + param_2 + lVar5;
          if (local_60[0] != (char *)0x0) break;
        }
        piVar6 = (int *)((long)piVar6 + (ulong)(uint)piVar6[1]);
        iVar1 = iVar1 + -1;
      } while (iVar1 != 0);
    }
    _ahpl_rb_insert_node(&DAT_00028f30,lVar3);
  }
  FUN_00015548(&DAT_00028e20);
  return;
}



void FUN_00005c24(void)

{
  void *pvVar1;
  
  FUN_00015504(&DAT_00028e20);
  pvVar1 = (void *)_ahpl_rb_remove(&DAT_00028f30,0);
  FUN_00015548(&DAT_00028e20);
  _free(pvVar1);
  return;
}



undefined4 FUN_00005c7c(undefined8 param_1,undefined8 param_2)

{
  undefined8 local_38;
  undefined8 uStack_30;
  undefined4 local_28;
  
  local_28 = 0xffffffff;
  local_38 = param_1;
  uStack_30 = param_2;
  FUN_00004bbc(&DAT_00028e68);
  _ahpl_rb_traverse_ldr(&DAT_00028f30,FUN_00005cdc,&local_38);
  FUN_00004c24(&DAT_00028e68);
  return local_28;
}



bool FUN_00005cdc(long param_1,code **param_2)

{
  int iVar1;
  
  iVar1 = (**param_2)(*(undefined8 *)(param_1 + 0x18),*(undefined8 *)(param_1 + 0x28),
                      *(undefined8 *)(param_1 + 0x30),param_2[1]);
  *(int *)(param_2 + 2) = iVar1;
  return iVar1 == 1;
}



void FUN_00005d18(void)

{
  uint uVar1;
  int iVar2;
  size_t local_2c8;
  undefined auStack_2c0 [32];
  uint local_2a0;
  undefined8 local_38;
  undefined4 local_30;
  pid_t local_2c;
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  local_38 = 0xe00000001;
  local_30 = 1;
  local_2c = _getpid();
  local_2c8 = 0x288;
  iVar2 = _sysctl((int *)&local_38,4,auStack_2c0,&local_2c8,(void *)0x0,0);
  uVar1 = 0;
  if (-1 < iVar2) {
    uVar1 = local_2a0 >> 0xb & 1;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar1);
}



void _objc_retainAutoreleasedReturnValue(void)

{
  _objc_retainAutoreleasedReturnValue();
  return;
}



void FUN_00005dbc(void)

{
  _objc_msgSend();
  return;
}



void FUN_00005dc4(void)

{
  _objc_msgSend();
  return;
}



ulong FUN_00005dcc(long param_1)

{
  int iVar1;
  ulong uVar2;
  
  if (param_1 != 0) {
    iVar1 = FUN_00005c7c(FUN_00005dfc,param_1);
    return (ulong)(iVar1 == 1);
  }
  uVar2 = FUN_00006058();
  return uVar2;
}



undefined8 FUN_00005dfc(char *param_1,undefined8 param_2,undefined8 param_3,char *param_4)

{
  char *pcVar1;
  undefined8 uVar2;
  
  if (param_1 != (char *)0x0) {
    pcVar1 = _strstr(param_1,param_4);
    if (pcVar1 != (char *)0x0) {
      uVar2 = FUN_00006058();
      return uVar2;
    }
  }
  return 0;
}



undefined8 FUN_00005e00(char *param_1,undefined8 param_2,undefined8 param_3,char *param_4)

{
  char *pcVar1;
  undefined8 uVar2;
  
  pcVar1 = _strstr(param_1,param_4);
  if (pcVar1 != (char *)0x0) {
    uVar2 = FUN_00006058();
    return uVar2;
  }
  return 0;
}



void FUN_00005e24(void)

{
  int iVar1;
  undefined8 local_20;
  undefined8 uStack_18;
  
  FUN_000154dc(&DAT_00028f48);
  iVar1 = FUN_00005e78(FUN_00005e24,&uStack_18,&local_20);
  if (iVar1 == 1) {
    DAT_00028bd0 = uStack_18;
    DAT_00028bd8 = local_20;
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00005e78(undefined8 param_1,undefined8 *param_2,undefined8 *param_3)

{
  int iVar1;
  undefined8 local_38;
  undefined8 local_30;
  undefined8 local_28;
  
  local_38 = param_1;
  iVar1 = FUN_00005c7c(FUN_00006038,&local_38);
  if (iVar1 == 1) {
    if (param_2 != (undefined8 *)0x0) {
      *param_2 = local_30;
    }
    if (param_3 != (undefined8 *)0x0) {
      *param_3 = local_28;
    }
  }
  return;
}



undefined8 FUN_00005ed4(undefined8 param_1)

{
  undefined8 uVar1;
  
  FUN_00004bbc(&DAT_00028f90);
  uVar1 = FUN_00005f18(param_1);
  FUN_00004c24(&DAT_00028f90);
  return uVar1;
}



void FUN_00005f18(ulong param_1)

{
  long lVar1;
  
  lVar1 = DAT_00028be0;
  if (DAT_00028be0 != 0) {
    do {
      if ((*(ulong *)(lVar1 + 0x10) <= param_1) && (param_1 < *(ulong *)(lVar1 + 0x18))) {
        return;
      }
      lVar1 = *(long *)(lVar1 + 8);
    } while (lVar1 != 0);
  }
  return;
}



undefined8 _ahpl_so_register(undefined8 param_1,undefined8 param_2)

{
  undefined8 *puVar1;
  int iVar2;
  undefined8 *puVar3;
  long lVar4;
  int *piVar5;
  undefined8 local_30;
  undefined8 local_28;
  
  iVar2 = FUN_00005e78(param_2,&local_28,&local_30);
  if (iVar2 != 1) {
                    // WARNING: Subroutine does not return
    _abort();
  }
  puVar3 = (undefined8 *)_ahpl_malloc(0x20);
  if (puVar3 == (undefined8 *)0x0) {
    iVar2 = 0xc;
  }
  else {
    *puVar3 = param_1;
    puVar3[2] = local_28;
    puVar3[3] = local_30;
    FUN_00015504(&DAT_00028f48);
    lVar4 = FUN_00005f18(local_28);
    if (lVar4 == 0) {
      puVar3[1] = 0;
      puVar1 = &DAT_00028be0;
      if (DAT_00028be8 != (undefined8 *)0x0) {
        puVar1 = (undefined8 *)((long)DAT_00028be8 + 8);
      }
      *puVar1 = puVar3;
      DAT_00028bf0 = DAT_00028bf0 + 1;
      DAT_00028be8 = puVar3;
      FUN_00015548(&DAT_00028f48);
      return 0;
    }
    FUN_00015548(&DAT_00028f48);
    _free(puVar3);
    iVar2 = 0x11;
  }
  piVar5 = ___error();
  *piVar5 = iVar2;
  return 0xffffffff;
}



undefined8 FUN_00006038(undefined8 param_1,ulong param_2,ulong param_3,ulong *param_4)

{
  undefined8 uVar1;
  
  if (*param_4 < param_2 || param_3 <= *param_4) {
    return 0;
  }
  param_4[1] = param_2;
  param_4[2] = param_3;
  uVar1 = FUN_00006058();
  return uVar1;
}



undefined8 FUN_00006058(void)

{
  return 1;
}



undefined8 FUN_00006060(uint param_1,long param_2)

{
  int iVar1;
  void *pvVar2;
  undefined8 uVar3;
  
  if ((int)param_1 < 0) {
    return 0xfffffff7;
  }
  FUN_00015504(&DAT_00029058);
  if (DAT_00028bf8 < (int)param_1) {
    iVar1 = ((param_1 - DAT_00028bf8) + 0xf & 0xfffffff0) + DAT_00028bf8;
    pvVar2 = (void *)_ahpl_malloc(-(ulong)(iVar1 + 1U >> 0x1f) & 0xfffffff800000000 |
                                  (ulong)(iVar1 + 1U) << 3);
    if (pvVar2 == (void *)0x0) {
      uVar3 = 0xfffffff4;
      goto LAB_00006180;
    }
    if (-1 < (int)DAT_00028bfc) {
      _memcpy(pvVar2,DAT_00029168,
              -(ulong)(DAT_00028bfc + 1 >> 0x1f) & 0xfffffff800000000 |
              (ulong)(DAT_00028bfc + 1) << 3);
    }
    _free(DAT_00029168);
    _bzero((void *)((long)pvVar2 + (long)(int)(DAT_00028bfc + 1) * 8),
           -(ulong)(iVar1 - DAT_00028bfc >> 0x1f) & 0xfffffff800000000 |
           (ulong)(iVar1 - DAT_00028bfc) << 3);
    DAT_00028bf8 = iVar1;
    DAT_00029168 = pvVar2;
  }
  pvVar2 = DAT_00029168;
  if (*(long *)((long)DAT_00029168 + (ulong)param_1 * 8) == 0) {
    iVar1 = DAT_00029170 + 1;
    *(int *)(param_2 + 0xc) = DAT_00029170;
    DAT_00029170 = iVar1;
    *(long *)((long)pvVar2 + (ulong)param_1 * 8) = param_2;
    if ((int)DAT_00028bfc < (int)param_1) {
      DAT_00028bfc = param_1;
    }
    uVar3 = 0;
    DAT_00029178 = DAT_00029178 + 1;
  }
  else {
    uVar3 = 0xfffffff0;
  }
LAB_00006180:
  FUN_00015548(&DAT_00029058);
  return uVar3;
}



undefined8 FUN_000061a8(uint *param_1)

{
  uint uVar1;
  uint uVar2;
  long lVar3;
  undefined8 uVar4;
  int iVar5;
  ulong uVar6;
  
  uVar1 = *param_1;
  uVar6 = (ulong)uVar1;
  FUN_00015504(&DAT_00029058);
  lVar3 = DAT_00029168;
  uVar2 = DAT_00028bfc;
  uVar4 = 0xfffffffe;
  if ((-1 < (int)uVar1) && ((int)uVar1 <= (int)DAT_00028bfc)) {
    if (*(uint **)(DAT_00029168 + uVar6 * 8) == param_1) {
      *(undefined8 *)(DAT_00029168 + uVar6 * 8) = 0;
      if (uVar2 == uVar1) {
        do {
          iVar5 = (int)uVar6;
          DAT_00028bfc = iVar5 - 1;
          uVar6 = (ulong)DAT_00028bfc;
          if (iVar5 < 1) break;
        } while (*(long *)(lVar3 + uVar6 * 8) == 0);
      }
      uVar4 = 0;
      DAT_00029178 = DAT_00029178 + -1;
    }
    else {
      uVar4 = 0xfffffffe;
    }
  }
  FUN_00015548(&DAT_00029058);
  return uVar4;
}



long FUN_00006254(uint param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long lVar4;
  
  if ((int)param_1 < 0) {
    lVar4 = 0;
  }
  else {
    FUN_00004bbc(&DAT_000290a0);
    if (DAT_00028bfc < (int)param_1) {
      lVar4 = 0;
    }
    else {
      lVar4 = *(long *)(DAT_00029168 + (ulong)param_1 * 8);
      if (lVar4 != 0) {
        piVar1 = (int *)(lVar4 + 4);
        do {
          cVar2 = '\x01';
          bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
          if (bVar3) {
            *piVar1 = *piVar1 + 1;
            cVar2 = ExclusiveMonitorsStatus();
          }
        } while (cVar2 != '\0');
      }
    }
    FUN_00004c24(&DAT_000290a0);
  }
  return lVar4;
}



void FUN_000062d4(void *param_1)

{
  int *piVar1;
  int iVar2;
  char cVar3;
  bool bVar4;
  
  piVar1 = (int *)((long)param_1 + 4);
  do {
    iVar2 = *piVar1;
    cVar3 = '\x01';
    bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar4) {
      *piVar1 = iVar2 + -1;
      cVar3 = ExclusiveMonitorsStatus();
    }
  } while (cVar3 != '\0');
  if (iVar2 + -1 != 0) {
    return;
  }
  if (*(code **)((long)param_1 + 0x10) != (code *)0x0) {
    (**(code **)((long)param_1 + 0x10))(param_1);
  }
  _free(param_1);
  return;
}



void FUN_00006328(void)

{
  FUN_000154dc(&DAT_00029058);
  return;
}



int FUN_00006334(int param_1)

{
  int iVar1;
  int *piVar2;
  
  iVar1 = _ioctl(param_1,0x8004667e);
  if ((-1 < iVar1) && (iVar1 = _ioctl(param_1,0x20006601), -1 < iVar1)) {
    return 0;
  }
  piVar2 = ___error();
  return -*piVar2;
}



void FUN_000063a4(long param_1,int *param_2)

{
  size_t sVar1;
  bool bVar2;
  undefined4 uVar3;
  long lVar4;
  long lVar5;
  undefined8 uVar6;
  void *pvVar7;
  ulong uVar8;
  long lVar9;
  long lVar10;
  uint uVar11;
  long lVar12;
  long lVar13;
  undefined auVar14 [16];
  
  lVar13 = *(long *)(param_2 + 0xe) << (*(long *)(param_2 + 0x24) != 0);
  if (*(long *)(param_2 + 0x16) == 0) {
    lVar10 = 0;
  }
  else {
    lVar10 = *(long *)(param_2 + 0x10) + lVar13;
  }
LAB_000063fc:
  uVar3 = _ahpl_tick_now();
  *(undefined4 *)(param_1 + 0x1d8) = uVar3;
  pvVar7 = *(void **)(param_2 + 0x12);
  lVar12 = *(long *)(param_2 + 0x14) - (long)pvVar7;
  bVar2 = true;
  if (*(long *)(param_2 + 0x24) != 0) {
    bVar2 = lVar12 + -1 < 0;
  }
  if (bVar2 != (*(long *)(param_2 + 0x24) != 0 && SBORROW8(lVar12,1))) {
LAB_00006440:
    if ((0 < lVar12) || (uVar11 = param_2[10], (uVar11 >> 2 & 1) != 0)) {
      lVar4 = lVar12;
      if ((*(long *)(param_2 + 0x26) != 0) && (lVar4 = FUN_000076a4(), *param_2 < 0))
      goto LAB_000065d0;
      if (-1 < lVar4) {
        lVar5 = _objc_autoreleasePoolPush();
        (**(code **)(param_2 + 0x2a))
                  (*(undefined8 *)(param_2 + 0x12),lVar4,*(undefined8 *)(param_2 + 0x2e),
                   param_2 + 0x30,lVar10);
        if (lVar5 != 0) {
          _objc_autoreleasePoolPop(lVar5);
        }
        lVar4 = *(long *)(param_1 + 0x1a0);
        uVar6 = *(undefined8 *)(lVar4 + 8);
        *(undefined8 *)(lVar4 + 8) = 0;
        FUN_0000f048(uVar6,0);
        *(undefined8 *)(lVar4 + 0x10) = 0;
        *(undefined4 *)(lVar4 + 0x18) = 0;
        if (*(long *)(lVar4 + 0x20) != 0) {
          FUN_0000f214(*(long *)(lVar4 + 0x20),0);
          *(undefined8 *)(lVar4 + 0x20) = 0;
        }
        *(undefined8 *)(lVar4 + 0x28) = 0;
        if (*param_2 < 0) goto LAB_000065d0;
      }
      pvVar7 = (void *)(*(long *)(param_2 + 0x12) + lVar12);
      *(void **)(param_2 + 0x12) = pvVar7;
      uVar11 = param_2[10];
    }
    if ((uVar11 >> 2 & 1) == 0) goto code_r0x000064f0;
    if (*(long *)(param_2 + 0x24) == 0) {
      param_2[10] = uVar11 & 0xfffffffb;
      goto LAB_00006554;
    }
    goto LAB_000065d0;
  }
  auVar14 = FUN_000076a4();
  lVar12 = auVar14._0_8_;
  if (*param_2 < 0) goto LAB_000065d0;
  lVar4 = lVar12;
  if (-1 < lVar12) {
    pvVar7 = *(void **)(param_2 + 0x12);
    if (lVar12 <= *(long *)(param_2 + 0x14) - (long)pvVar7) goto LAB_00006440;
    lVar4 = 0xffffffea;
  }
  FUN_000076c8(lVar12,auVar14._8_8_,lVar4);
  FUN_00006610();
  uVar11 = 0xffffffea;
  if (lVar12 < 1) {
    uVar11 = auVar14._0_4_;
  }
  uVar8 = (ulong)uVar11;
  goto LAB_00006604;
code_r0x000064f0:
  if (lVar12 != 0) goto LAB_000063fc;
  if (*(long *)(param_2 + 0x24) != 0) {
    uVar8 = *(ulong *)(param_2 + 0xe);
    lVar4 = *(long *)(param_2 + 0x10);
    lVar12 = *(long *)(param_2 + 0x14);
    if (0x3ff < (uVar8 * 2 - lVar12) + lVar4) {
      lVar5 = (long)pvVar7 - lVar4;
      lVar9 = lVar12 - (long)pvVar7;
      if ((lVar5 <= (long)uVar8) || (0x3ff < lVar9)) {
        bVar2 = true;
        if (lVar9 < 0x61) {
          bVar2 = (long)(lVar5 - (uVar8 >> 1)) < 0;
        }
        if (bVar2 != (lVar9 < 0x61 && SBORROW8(lVar5,uVar8 >> 1))) goto LAB_0000657c;
      }
    }
  }
LAB_00006554:
  sVar1 = *(long *)(param_2 + 0x14) - (long)pvVar7;
  if (sVar1 != 0) {
    _memmove(*(void **)(param_2 + 0x10),pvVar7,sVar1);
  }
  lVar4 = *(long *)(param_2 + 0x10);
  lVar12 = lVar4 + sVar1;
  *(long *)(param_2 + 0x12) = lVar4;
  *(long *)(param_2 + 0x14) = lVar12;
LAB_0000657c:
  uVar8 = (**(code **)(param_2 + 0x20))
                    (*param_2,lVar12,(lVar4 + lVar13) - lVar12,*(undefined8 *)(param_2 + 0x16),
                     *(undefined8 *)(param_2 + 0x2e),param_2 + 0x30);
  if ((long)uVar8 < 0) {
    if (uVar8 == 0xffffffffffffffdd) {
LAB_000065d0:
      uVar8 = 0;
    }
    else {
      auVar14 = FUN_000076c8();
      FUN_00006610(auVar14._0_8_,auVar14._8_8_,uVar8);
    }
LAB_00006604:
    FUN_0000768c(uVar8);
    return;
  }
  if (uVar8 == 0) {
    param_2[10] = param_2[10] | 4;
  }
  else {
    *(ulong *)(param_2 + 0x14) = *(long *)(param_2 + 0x14) + uVar8;
  }
  goto LAB_000063fc;
}



void FUN_00006610(undefined8 param_1,int *param_2,ulong param_3)

{
  if (-1 < *param_2) {
    param_2[0xb] = (int)param_3;
    if (*(code **)(param_2 + 0x2c) != (code *)0x0) {
      (**(code **)(param_2 + 0x2c))(*param_2,param_3,*(undefined8 *)(param_2 + 0x2e),param_2 + 0x30)
      ;
      if (*param_2 < 0) goto LAB_0000666c;
      param_3 = (ulong)(uint)param_2[0xb];
    }
    if ((int)param_3 != 0) {
      FUN_000076c8();
      FUN_00006fe8();
      return;
    }
  }
LAB_0000666c:
  FUN_000076b8();
  return;
}



long FUN_00006674(long param_1,undefined4 *param_2)

{
  ulong uVar1;
  undefined4 uVar2;
  long lVar3;
  undefined8 uVar4;
  long *plVar5;
  void *pvVar6;
  
  if (((param_2[10] & 1) != 0) &&
     (param_2[10] = param_2[10] & 0xfffffffe, ((uint)param_2[0xd] >> 0xf & 1) == 0)) {
    _ahpl_mpq_kill_timer();
    param_2[0xd] = 0xffffffff;
  }
  while( true ) {
    pvVar6 = *(void **)(param_2 + 0x18);
    if (pvVar6 == (void *)0x0) {
      if (*(long *)(param_2 + 0x2c) != 0) {
        lVar3 = _objc_autoreleasePoolPush();
        (**(code **)(param_2 + 0x2c))(*param_2,1,*(undefined8 *)(param_2 + 0x2e),param_2 + 0x30);
        if (lVar3 != 0) {
          _objc_autoreleasePoolPop(lVar3);
        }
        lVar3 = *(long *)(param_1 + 0x1a0);
        uVar4 = *(undefined8 *)(lVar3 + 8);
        *(undefined8 *)(lVar3 + 8) = 0;
        FUN_0000f048(uVar4,0);
        *(undefined8 *)(lVar3 + 0x10) = 0;
        *(undefined4 *)(lVar3 + 0x18) = 0;
        if (*(long *)(lVar3 + 0x20) != 0) {
          FUN_0000f214(*(long *)(lVar3 + 0x20),0);
          *(undefined8 *)(lVar3 + 0x20) = 0;
        }
        *(undefined8 *)(lVar3 + 0x28) = 0;
      }
      return 0;
    }
    uVar2 = _ahpl_tick_now();
    *(undefined4 *)(param_1 + 0x1d8) = uVar2;
    lVar3 = (**(code **)(param_2 + 0x22))
                      (*param_2,*(long *)((long)pvVar6 + 8),
                       *(long *)((long)pvVar6 + 0x10) - *(long *)((long)pvVar6 + 8),
                       *(undefined8 *)((long)pvVar6 + 0x18),*(undefined8 *)(param_2 + 0x2e),
                       param_2 + 0x30);
    if (lVar3 < 0) break;
    uVar1 = *(long *)((long)pvVar6 + 8) + lVar3;
    *(ulong *)((long)pvVar6 + 8) = uVar1;
    if (uVar1 < *(ulong *)((long)pvVar6 + 0x10)) {
      return 0;
    }
    plVar5 = *(long **)(param_2 + 0x18);
    if (plVar5 != (long *)0x0) {
      lVar3 = *plVar5;
      *(long *)(param_2 + 0x18) = lVar3;
      if (lVar3 == 0) {
        *(undefined8 *)(param_2 + 0x1a) = 0;
      }
      *(long *)(param_2 + 0x1c) = *(long *)(param_2 + 0x1c) + -1;
      *(long *)(param_2 + 0x1e) = (long)plVar5 + (*(long *)(param_2 + 0x1e) - plVar5[2]) + 0x20;
      *plVar5 = 0;
    }
    _free(pvVar6);
  }
  if (lVar3 == -0x23) {
    return 0;
  }
  FUN_00006610(param_1,param_2,lVar3);
  return lVar3;
}



undefined8
FUN_000067f0(long param_1,ulong param_2,uint param_3,ulong param_4,ulong param_5,undefined4 param_6,
            code *param_7,code *param_8,long param_9,undefined8 param_10,long param_11,
            undefined8 param_12,long param_13,undefined8 *param_14,code *param_15)

{
  undefined8 *puVar1;
  code *pcVar2;
  code *pcVar3;
  uint uVar4;
  undefined4 uVar5;
  long lVar6;
  undefined4 *puVar7;
  undefined8 uVar8;
  int *piVar9;
  undefined8 *puVar10;
  ulong uVar11;
  undefined8 *puVar12;
  uint local_64;
  
  uVar4 = (uint)param_2;
  if ((*(byte *)(param_1 + 0xac) >> 2 & 1) == 0) {
    return 0xffffffea;
  }
  if (param_11 == 0) {
    return 0xffffffea;
  }
  if (0xfff < param_5) {
    return 0xffffffea;
  }
  if (0x400000 < param_4) {
    return 0xffffffea;
  }
  if (param_4 < 0x400 && param_9 != 0) {
    return 0xffffffea;
  }
  local_64 = uVar4;
  if ((uVar4 != 0xffffffff) && (lVar6 = FUN_00006254(param_2), lVar6 != 0)) {
    FUN_000062d4();
    uVar4 = _fcntl(uVar4,3);
    piVar9 = (int *)(ulong)uVar4;
    if (uVar4 == 0xffffffff) {
      piVar9 = ___error();
    }
    FUN_000076d4(piVar9,"ahpl: fd(%d, valid: %d) already exists!");
    FUN_000076fc();
    return 0xffffffef;
  }
  uVar11 = param_4 + 7 & 0xfffffffffffffff8;
  puVar7 = (undefined4 *)_ahpl_malloc(param_5 + (uVar11 << (param_9 != 0)) + param_13 * 8 + 0xc0);
  if (puVar7 == (undefined4 *)0x0) {
    return 0xfffffff4;
  }
  puVar12 = (undefined8 *)(puVar7 + 6);
  *puVar12 = 0x100101;
  puVar7[1] = 1;
  pcVar2 = FUN_00006b38;
  if (param_7 != (code *)0x1) {
    pcVar2 = param_7;
  }
  puVar7[2] = 1;
  *(code **)(puVar7 + 4) = FUN_00006b80;
  *(undefined8 *)(puVar7 + 8) = 0x200203;
  pcVar3 = FUN_00006b5c;
  if (param_8 != (code *)0x1) {
    pcVar3 = param_8;
  }
  puVar7[10] = param_6;
  puVar7[0xb] = 0;
  puVar7[0xc] = *(undefined4 *)(param_1 + 0x14);
  puVar10 = (undefined8 *)(puVar7 + 0x30);
  puVar1 = puVar10 + param_13;
  *(ulong *)(puVar7 + 0xe) = uVar11;
  *(undefined8 **)(puVar7 + 0x10) = puVar1;
  *(undefined8 **)(puVar7 + 0x12) = puVar1;
  *(undefined8 **)(puVar7 + 0x14) = puVar1;
  *(ulong *)(puVar7 + 0x16) = param_5;
  *(undefined8 *)(puVar7 + 0x1a) = 0;
  *(undefined8 *)(puVar7 + 0x18) = 0;
  *(undefined8 *)(puVar7 + 0x1e) = 0;
  *(undefined8 *)(puVar7 + 0x1c) = 0;
  *(code **)(puVar7 + 0x20) = pcVar2;
  *(code **)(puVar7 + 0x22) = pcVar3;
  *(long *)(puVar7 + 0x24) = param_9;
  *(undefined8 *)(puVar7 + 0x26) = param_10;
  *(undefined8 *)(puVar7 + 0x28) = 0;
  *(long *)(puVar7 + 0x2a) = param_11;
  *(undefined8 *)(puVar7 + 0x2c) = param_12;
  *(long *)(puVar7 + 0x2e) = param_13;
  if (param_13 != 0) {
    do {
      *puVar10 = *param_14;
      param_13 = param_13 + -1;
      puVar10 = puVar10 + 1;
      param_14 = param_14 + 1;
    } while (param_13 != 0);
  }
  puVar7[0xd] = 0xffffffff;
  if (uVar4 == 0xffffffff) {
    *(undefined8 *)(puVar7 + 0x28) = *(undefined8 *)((ulong)&param_15 | 8);
    uVar8 = (*param_15)(&local_64,puVar7);
    if (((int)uVar8 < 0) || (param_2 = (ulong)local_64, local_64 == 0xffffffff)) goto LAB_00006b04;
  }
  *puVar7 = (int)param_2;
  FUN_00006334(local_64);
  uVar8 = FUN_00006060(local_64,puVar7);
  if ((int)uVar8 < 0) {
    _free(puVar7);
    uVar4 = _fcntl(local_64,3);
    piVar9 = (int *)(ulong)uVar4;
    if (uVar4 == 0xffffffff) {
      piVar9 = ___error();
    }
    FUN_000076d4(piVar9,"ahpl: install fd(%d, valid: %d) failed!");
    FUN_000076fc();
    return uVar8;
  }
  uVar8 = FUN_000042cc(param_1,puVar7);
  if (-1 < (int)uVar8) {
    puVar10 = *(undefined8 **)(param_1 + 0x40);
    *(undefined8 **)(param_1 + 0x40) = puVar12;
    *(long *)(puVar7 + 6) = param_1 + 0x38;
    *(undefined8 **)(puVar7 + 8) = puVar10;
    *puVar10 = puVar12;
    *(long *)(param_1 + 0x48) = *(long *)(param_1 + 0x48) + 1;
    if ((int)param_3 < 0) {
      return 0;
    }
    if ((puVar7[10] & 1) == 0) {
      return 0;
    }
    lVar6 = _ahpl_tick_now();
    uVar5 = _ahpl_mpq_set_oneshot_timer(lVar6 + (ulong)param_3,FUN_00006bdc,0,1);
    puVar7[0xd] = uVar5;
    return 0;
  }
  FUN_000061a8(puVar7);
LAB_00006b04:
  _free(puVar7);
  return uVar8;
}



ssize_t FUN_00006b38(int param_1,void *param_2,size_t param_3)

{
  ssize_t sVar1;
  int *piVar2;
  
  sVar1 = _read(param_1,param_2,param_3);
  if (sVar1 < 0) {
    piVar2 = ___error();
    sVar1 = -(long)*piVar2;
  }
  return sVar1;
}



ssize_t FUN_00006b5c(int param_1,void *param_2,size_t param_3)

{
  ssize_t sVar1;
  int *piVar2;
  
  sVar1 = _write(param_1,param_2,param_3);
  if (sVar1 < 0) {
    piVar2 = ___error();
    sVar1 = -(long)*piVar2;
  }
  return sVar1;
}



void FUN_00006b80(long param_1)

{
  long *plVar1;
  long lVar2;
  
  plVar1 = *(long **)(param_1 + 0x60);
  while (plVar1 != (long *)0x0) {
    lVar2 = *plVar1;
    *(long *)(param_1 + 0x60) = lVar2;
    if (lVar2 == 0) {
      *(undefined8 *)(param_1 + 0x68) = 0;
    }
    *(long *)(param_1 + 0x70) = *(long *)(param_1 + 0x70) + -1;
    *(long *)(param_1 + 0x78) = (long)plVar1 + (*(long *)(param_1 + 0x78) - plVar1[2]) + 0x20;
    _free(plVar1);
    plVar1 = *(long **)(param_1 + 0x60);
  }
  FUN_000076b8();
  return;
}



void FUN_00006bdc(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  undefined8 uVar4;
  long *in_x3;
  long lVar5;
  
  lVar5 = *in_x3;
  piVar1 = (int *)(lVar5 + 4);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + 1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  if ((*(byte *)(lVar5 + 0x28) & 1) != 0) {
    uVar4 = FUN_000090e4();
    FUN_00006610(uVar4,lVar5,0xffffffc4);
  }
  if ((*(uint *)(lVar5 + 0x34) >> 0xf & 1) == 0) {
    _ahpl_mpq_kill_timer();
    *(undefined4 *)(lVar5 + 0x34) = 0xffffffff;
  }
  FUN_000062d4(lVar5);
  return;
}



void _ahpl_mpq_add_fd(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                     undefined8 param_5,undefined8 param_6,undefined8 param_7,ulong param_8)

{
  long lVar1;
  int *piVar2;
  long lVar3;
  undefined4 *puVar4;
  undefined8 uVar5;
  int iVar6;
  undefined8 *puVar7;
  ulong uVar8;
  ulong auStack_90 [6];
  undefined8 *puVar9;
  undefined8 *puVar10;
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_8 < 0x41) {
    lVar3 = FUN_0000a4a4();
    if (lVar3 == 0) {
      piVar2 = ___error();
      iVar6 = 1;
      goto LAB_00006d3c;
    }
    lVar1 = -(param_8 * 8 + 0xf & 0xfffffffffffffff0);
    puVar7 = (undefined8 *)(&stack0xffffffffffffffa0 + lVar1);
    uVar8 = param_8;
    puVar9 = (undefined8 *)register0x00000008;
    if (param_8 != 0) {
      do {
        puVar10 = puVar9 + 1;
        *puVar7 = *puVar9;
        uVar8 = uVar8 - 1;
        puVar7 = puVar7 + 1;
        puVar9 = puVar10;
      } while (uVar8 != 0);
    }
    *(ulong *)((long)auStack_90 + lVar1 + 0x20) = param_8;
    *(undefined **)((long)auStack_90 + lVar1 + 0x28) = &stack0xffffffffffffffa0 + lVar1;
    *(undefined8 *)((long)auStack_90 + lVar1 + 0x10) = param_6;
    *(undefined8 *)((long)auStack_90 + lVar1 + 0x18) = param_7;
    *(undefined8 *)((long)auStack_90 + lVar1) = param_5;
    *(undefined8 *)((long)auStack_90 + lVar1 + 8) = 0;
    uVar5 = FUN_000067f0(lVar3,param_1,0xffffffff,param_2,0,0,param_3,param_4);
    if ((uint)uVar5 < 0xfffff001) goto LAB_00006d44;
    puVar4 = (undefined4 *)FUN_000076c0();
    *puVar4 = (int)param_4;
  }
  else {
    piVar2 = ___error();
    iVar6 = 7;
LAB_00006d3c:
    *piVar2 = iVar6;
  }
  uVar5 = 0xffffffff;
LAB_00006d44:
  if (*(long *)PTR____stack_chk_guard_00028030 != local_58) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar5);
  }
  return;
}



void _ahpl_mpq_add_fd_on_q
               (undefined8 param_1,int param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5,undefined8 param_6,undefined8 param_7,undefined8 param_8,
               ulong param_9)

{
  undefined8 *puVar1;
  long lVar2;
  int iVar3;
  uint uVar4;
  int *piVar5;
  long lVar6;
  undefined4 *puVar7;
  undefined8 *puVar8;
  long lStack_80;
  uint local_74;
  undefined8 *local_70;
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_9 < 0x41) {
    lVar6 = FUN_00009a98();
    if (lVar6 == 0) {
      piVar5 = ___error();
      iVar3 = 0x16;
      goto LAB_00006ea4;
    }
    lVar2 = -((param_9 + 8) * 8 + 0xf & 0xfffffffffffffff0);
    *(undefined **)((long)&lStack_80 + lVar2) = &stack0xffffffffffffff88 + 4;
    *(long *)(&stack0xffffffffffffff88 + lVar2) = (long)param_2;
    *(undefined8 *)((long)&local_70 + lVar2) = param_3;
    *(undefined8 *)((long)&local_68 + lVar2) = param_4;
    *(undefined8 *)(&stack0xffffffffffffffa0 + lVar2) = param_5;
    *(undefined8 *)(&stack0xffffffffffffffa8 + lVar2) = param_6;
    *(undefined8 *)(&stack0xffffffffffffffb0 + lVar2) = param_7;
    *(undefined8 *)(&stack0xffffffffffffffb8 + lVar2) = param_8;
    local_70 = (undefined8 *)&stack0x00000008;
    if (param_9 != 0) {
      puVar8 = (undefined8 *)(&stack0xffffffffffffffc0 + lVar2);
      do {
        puVar1 = local_70 + 1;
        *puVar8 = *local_70;
        param_9 = param_9 - 1;
        puVar8 = puVar8 + 1;
        local_70 = puVar1;
      } while (param_9 != 0);
    }
    iVar3 = FUN_0000aed4(lVar6,0xffffffff,"____target_q_add_fd",FUN_00006ed4);
    if (iVar3 < 0) {
      piVar5 = ___error();
      local_74 = -*piVar5;
    }
    FUN_00009b28(lVar6);
    uVar4 = local_74;
    if (local_74 < 0xfffff001) goto LAB_00006eac;
    puVar7 = (undefined4 *)FUN_000076c0();
    *puVar7 = (int)lVar6;
  }
  else {
    piVar5 = ___error();
    iVar3 = 7;
LAB_00006ea4:
    *piVar5 = iVar3;
  }
  uVar4 = 0xffffffff;
LAB_00006eac:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
    FUN_0000768c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar4);
}



void FUN_00006ed4(undefined8 param_1,undefined8 param_2,long param_3,undefined8 *param_4)

{
  undefined4 uVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined4 *puVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  
  puVar6 = (undefined4 *)*param_4;
  uVar2 = *(undefined4 *)(param_4 + 1);
  uVar3 = param_4[2];
  uVar4 = param_4[3];
  uVar5 = param_4[4];
  uVar7 = param_4[5];
  uVar8 = param_4[6];
  uVar9 = param_4[7];
  uVar1 = FUN_000090e4();
  uVar2 = FUN_000067f0(uVar1,uVar2,0xffffffff,uVar3,0,0,uVar4,uVar5,uVar7,0,uVar8,uVar9,param_3 + -8
                       ,param_4 + 8);
  *puVar6 = uVar2;
  return;
}



undefined8 _ahpl_fd_clear_err(void)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  
  lVar1 = FUN_00006254();
  if (lVar1 == 0) {
    piVar3 = ___error();
    *piVar3 = 9;
    uVar2 = 0xffffffff;
  }
  else {
    *(undefined4 *)(lVar1 + 0x2c) = 0;
    FUN_000062d4();
    uVar2 = 0;
  }
  return uVar2;
}



void FUN_00006fa4(undefined8 param_1,undefined8 param_2)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_00006254(param_2);
  if (lVar1 == 0) {
    uVar2 = 0xfffffffe;
  }
  else {
    FUN_000076c8();
    uVar2 = FUN_00006fe8();
    FUN_00007684();
  }
  FUN_000076e8(uVar2);
  return;
}



undefined8 FUN_00006fe8(long param_1,long param_2)

{
  undefined8 uVar1;
  undefined8 uVar2;
  long lVar3;
  long *plVar4;
  
  if (*(int *)(param_2 + 0x30) == *(int *)(param_1 + 0x14)) {
    if ((*(uint *)(param_2 + 0x34) >> 0xf & 1) == 0) {
      _ahpl_mpq_kill_timer();
      *(undefined4 *)(param_2 + 0x34) = 0xffffffff;
    }
    FUN_000076c8();
    uVar1 = FUN_000043f4();
    if ((int)uVar1 < 0) {
      FUN_000076d4(uVar1,"ahpl: del event fd %d failed with errno=%d");
    }
    else {
      uVar1 = 0;
    }
    uVar2 = FUN_000061a8(param_2);
    if ((int)uVar2 < 0) {
      FUN_000076d4(uVar2,"ahpl: remove fd %d failed with errno=%d");
      uVar1 = uVar2;
    }
    lVar3 = *(long *)(param_2 + 0x18);
    if (lVar3 != 0x100101) {
      plVar4 = *(long **)(param_2 + 0x20);
      *(long **)(lVar3 + 8) = plVar4;
      *plVar4 = lVar3;
      *(undefined8 *)(param_2 + 0x18) = 0x100101;
      *(undefined8 *)(param_2 + 0x20) = 0x200203;
      *(long *)(param_1 + 0x48) = *(long *)(param_1 + 0x48) + -1;
      FUN_00007684();
    }
  }
  else {
    uVar1 = 0xffffffff;
  }
  return uVar1;
}



void FUN_000070e0(long param_1)

{
  undefined8 *puVar1;
  
  puVar1 = *(undefined8 **)(undefined8 *)(param_1 + 0x38);
  while (puVar1 != (undefined8 *)(param_1 + 0x38) && puVar1 != (undefined8 *)0x0) {
    FUN_00007124(param_1,puVar1 + -3);
    puVar1 = *(undefined8 **)(param_1 + 0x38);
  }
  *(undefined8 *)(param_1 + 0x48) = 0;
  FUN_000076b8();
  return;
}



undefined8 FUN_00007124(undefined8 param_1,undefined4 *param_2)

{
  undefined4 uVar1;
  char cVar2;
  bool bVar3;
  undefined8 uVar4;
  int *piVar5;
  
  piVar5 = param_2 + 1;
  uVar1 = *param_2;
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar5,0x10);
    if (bVar3) {
      *piVar5 = *piVar5 + 1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  uVar4 = FUN_00006fe8();
  if (-1 < (int)uVar4) {
    if (*(code **)(param_2 + 0x28) == (code *)0x0) {
      uVar4 = FUN_0000719c(uVar1);
    }
    else {
      uVar4 = (**(code **)(param_2 + 0x28))(uVar1,param_2);
    }
  }
  *param_2 = 0xffffffff;
  FUN_00007684();
  return uVar4;
}



int FUN_0000719c(int param_1)

{
  int iVar1;
  int *piVar2;
  
  iVar1 = _close(param_1);
  if (iVar1 < 0) {
    piVar2 = ___error();
    iVar1 = -*piVar2;
  }
  return iVar1;
}



void FUN_000071c0(undefined8 param_1)

{
  int iVar1;
  long lVar2;
  long lVar3;
  int *piVar4;
  ulong uVar5;
  undefined8 in_x4;
  long lVar6;
  undefined auVar7 [16];
  uint local_4c;
  uint *local_48;
  long lStack_40;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  lVar2 = FUN_00006254();
  if (lVar2 == 0) {
    uVar5 = FUN_0000719c(param_1);
  }
  else {
    auVar7 = FUN_000090e4();
    lVar3 = auVar7._0_8_;
    if (((lVar3 == 0) || (*(int *)(lVar2 + 0x30) != *(int *)(lVar3 + 0x14))) &&
       (auVar7 = FUN_00009b40(), auVar7._0_8_ == 0)) {
      local_4c = 0xffffffea;
    }
    else {
      lVar6 = auVar7._0_8_;
      local_48 = &local_4c;
      lStack_40 = lVar2;
      iVar1 = FUN_000076f0(lVar6,auVar7._8_8_,"____target_q_close",FUN_000072b8,in_x4,&local_48);
      if (iVar1 < 0) {
        piVar4 = ___error();
        local_4c = -*piVar4;
      }
      if (lVar6 != lVar3) {
        FUN_00009ba0(lVar6);
      }
    }
    FUN_00007684();
    uVar5 = (ulong)local_4c;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar5);
}



void FUN_000072b8(void)

{
  undefined4 uVar1;
  undefined8 *in_x3;
  undefined8 uVar2;
  undefined4 *puVar3;
  
  puVar3 = (undefined4 *)*in_x3;
  uVar2 = in_x3[1];
  uVar1 = FUN_000090e4();
  uVar1 = FUN_00007124(uVar1,uVar2);
  *puVar3 = uVar1;
  FUN_000076b8();
  return;
}



void _ahpl_close(void)

{
  undefined8 uVar1;
  undefined4 *puVar2;
  undefined4 unaff_w19;
  
  uVar1 = FUN_000071c0();
  if (0xfffff000 < (uint)uVar1) {
    puVar2 = (undefined4 *)FUN_000076c0();
    *puVar2 = unaff_w19;
    uVar1 = 0xffffffff;
  }
  FUN_000076e8(uVar1);
  return;
}



void _ahpl_mpq_del_fd(void)

{
  int iVar1;
  uint uVar2;
  long lVar3;
  int *piVar4;
  undefined4 *puVar5;
  undefined8 in_x4;
  long lVar6;
  undefined4 unaff_w19;
  undefined auVar7 [16];
  uint local_3c;
  uint *local_38;
  
  lVar6 = *(long *)PTR____stack_chk_guard_00028030;
  lVar3 = FUN_00006254();
  if (lVar3 == 0) {
    uVar2 = 0xfffffff7;
  }
  else {
    auVar7 = FUN_000076dc();
    lVar3 = auVar7._0_8_;
    if (lVar3 == 0) {
      local_3c = 0xffffffea;
    }
    else {
      local_38 = &local_3c;
      iVar1 = FUN_000076f0(lVar3,auVar7._8_8_,"____target_q_del_fd",FUN_0000765c,in_x4,&local_38);
      if (iVar1 < 0) {
        piVar4 = ___error();
        local_3c = -*piVar4;
      }
      FUN_00009ba0(lVar3);
    }
    FUN_00007684();
    uVar2 = local_3c;
    if (local_3c < 0xfffff001) goto LAB_000073b0;
  }
  puVar5 = (undefined4 *)FUN_000076c0(uVar2);
  *puVar5 = unaff_w19;
  uVar2 = 0xffffffff;
LAB_000073b0:
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar6) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



ulong _ahpl_write(void)

{
  int iVar1;
  long lVar2;
  int *piVar3;
  long lVar4;
  ulong uVar5;
  ulong local_60;
  ulong *local_58;
  
  lVar4 = *(long *)PTR____stack_chk_guard_00028030;
  local_60 = 0xfffffffffffffff7;
  lVar2 = FUN_00006254();
  uVar5 = 0xfffffffffffffff7;
  if (lVar2 != 0) {
    lVar2 = FUN_000076dc();
    if (lVar2 != 0) {
      local_58 = &local_60;
      iVar1 = FUN_0000aed4(lVar2,0xffffffff,"____target_q_write",FUN_000074c0,4,&local_58);
      if (iVar1 < 0) {
        piVar3 = ___error();
        local_60 = -(long)*piVar3;
      }
      FUN_00009ba0(lVar2);
    }
    FUN_00007684();
    uVar5 = local_60;
    if (local_60 < 0xfffffffffffff001) goto LAB_0000748c;
  }
  piVar3 = ___error();
  *piVar3 = -(int)uVar5;
  uVar5 = 0xffffffffffffffff;
LAB_0000748c:
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar4) {
    return uVar5;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_000074c0(void)

{
  undefined8 *puVar1;
  ulong uVar2;
  undefined8 *puVar3;
  int *piVar4;
  ulong **in_x3;
  ulong *puVar5;
  ulong *puVar6;
  size_t sVar7;
  ulong **ppuVar8;
  ulong *puVar9;
  
  ppuVar8 = (ulong **)*in_x3;
  puVar5 = in_x3[3];
  if (puVar5 < (ulong *)0x8000001) {
    puVar9 = in_x3[1];
    uVar2 = 0;
    if (puVar9[0xf] < 0x8000001) {
      uVar2 = 0x8000000 - puVar9[0xf];
    }
    if (uVar2 < puVar5) {
      puVar5 = (ulong *)0xffffffffffffffdd;
    }
    else {
      puVar6 = in_x3[2];
      if ((puVar9[0xc] == 0) && ((*(byte *)(puVar9 + 5) & 1) == 0)) {
        uVar2 = _write(*(int *)puVar9,puVar6,(size_t)puVar5);
        if ((long)uVar2 < 1) {
          piVar4 = ___error();
          puVar5 = (ulong *)-(long)*piVar4;
          goto LAB_000075c4;
        }
        if (puVar5 <= uVar2) goto LAB_000075c4;
      }
      else {
        uVar2 = 0;
      }
      sVar7 = (long)puVar5 - uVar2;
      puVar3 = (undefined8 *)_ahpl_malloc(sVar7 + 0x27 & 0xfffffffffffffff8);
      if (puVar3 == (undefined8 *)0x0) {
        puVar5 = (ulong *)0xfffffffffffffff4;
      }
      else {
        puVar1 = puVar3 + 4;
        _memcpy(puVar1,(void *)((long)puVar6 + uVar2),sVar7);
        *puVar3 = 0;
        puVar3[1] = puVar1;
        puVar3[2] = (long)puVar1 + sVar7;
        puVar3[3] = 0;
        puVar6 = puVar9 + 0xc;
        if ((ulong *)puVar9[0xd] != (ulong *)0x0) {
          puVar6 = (ulong *)puVar9[0xd];
        }
        *puVar6 = (ulong)puVar3;
        puVar9[0xd] = (ulong)puVar3;
        puVar9[0xe] = puVar9[0xe] + 1;
        puVar9[0xf] = puVar9[0xf] + sVar7;
      }
    }
  }
  else {
    puVar5 = (ulong *)0xffffffffffffffd8;
  }
LAB_000075c4:
  *ppuVar8 = puVar5;
  return;
}



void _ahpl_mpq_fd_arg(undefined8 param_1,ulong param_2,undefined8 *param_3)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  int iVar4;
  
  lVar1 = FUN_00006254();
  if (lVar1 == 0) {
    iVar4 = 9;
  }
  else {
    if (param_2 < *(ulong *)(lVar1 + 0xb8)) {
      if (param_3 != (undefined8 *)0x0) {
        *param_3 = *(undefined8 *)(lVar1 + param_2 * 8 + 0xc0);
      }
      FUN_000062d4();
      uVar2 = 0;
      goto LAB_00007654;
    }
    FUN_000062d4();
    iVar4 = 2;
  }
  piVar3 = ___error();
  *piVar3 = iVar4;
  uVar2 = 0xffffffff;
LAB_00007654:
  FUN_000076e8(uVar2);
  return;
}



void FUN_0000765c(void)

{
  undefined4 uVar1;
  undefined8 *in_x3;
  undefined8 uVar2;
  undefined4 *puVar3;
  
  puVar3 = (undefined4 *)*in_x3;
  uVar2 = in_x3[1];
  uVar1 = FUN_000090e4();
  uVar1 = FUN_00006fe8(uVar1,uVar2);
  *puVar3 = uVar1;
  FUN_000076b8();
  return;
}



void FUN_00007684(void)

{
  FUN_000062d4();
  return;
}



void FUN_0000768c(void)

{
  return;
}



void FUN_000076a4(undefined8 param_1)

{
  code *UNRECOVERED_JUMPTABLE;
  
                    // WARNING: Could not recover jumptable at 0x000076b4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)(param_1);
  return;
}



void FUN_000076b8(void)

{
  return;
}



void FUN_000076c0(void)

{
  ___error();
  return;
}



void FUN_000076c8(void)

{
  return;
}



void FUN_000076d4(void)

{
  _ahpl_log(2);
  return;
}



void FUN_000076dc(long param_1)

{
  FUN_00009b40(*(undefined4 *)(param_1 + 0x30));
  return;
}



void FUN_000076e8(void)

{
  return;
}



void FUN_000076f0(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  FUN_0000aed4(param_1,0xffffffff,param_3,param_4,2);
  return;
}



int FUN_000076fc(void)

{
  int iVar1;
  
  iVar1 = _usleep(1000000);
  return iVar1;
}



void FUN_00007708(void)

{
  _bzero(&DAT_00029180,0x400);
  FUN_000154dc(&DAT_00029580);
  return;
}



void FUN_00007730(void *param_1)

{
  short sVar1;
  
  sVar1 = *(short *)((long)param_1 + 0x38);
  if (*(code **)((long)param_1 + 0x60) != (code *)0x0) {
    (**(code **)((long)param_1 + 0x60))(*(undefined8 *)((long)param_1 + 0x68),(long)param_1 + 0x70);
  }
  if (((uint)(DAT_00028c00 <= sVar1) | (uint)(int)sVar1 >> 0x1f) == 0) {
    FUN_00015504(&DAT_00029580);
    FUN_000040ac((long)sVar1,DAT_00028c10);
    FUN_00015548(&DAT_00029580);
    _free(param_1);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_00008ccc("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/timer.c"
               ,0x74);
}



long FUN_000077c8(uint param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long lVar4;
  
  if ((short)param_1 < 0) {
    return 0;
  }
  FUN_00004bbc(&DAT_000295c8);
  if ((int)(param_1 & 0xffff) < DAT_00028c00) {
    lVar4 = *(long *)(DAT_00028c08 + (ulong)(param_1 & 0xffff) * 8);
    if (lVar4 == 0) goto LAB_00007838;
    if (*(uint *)(lVar4 + 0x38) == param_1) {
      piVar1 = (int *)(lVar4 + 0x3c);
      do {
        cVar2 = '\x01';
        bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
        if (bVar3) {
          *piVar1 = *piVar1 + 1;
          cVar2 = ExclusiveMonitorsStatus();
        }
      } while (cVar2 != '\0');
      goto LAB_00007838;
    }
  }
  lVar4 = 0;
LAB_00007838:
  FUN_00004c24(&DAT_000295c8);
  return lVar4;
}



void FUN_0000785c(long param_1)

{
  int *piVar1;
  int iVar2;
  char cVar3;
  bool bVar4;
  
  piVar1 = (int *)(param_1 + 0x3c);
  do {
    iVar2 = *piVar1;
    cVar3 = '\x01';
    bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar4) {
      *piVar1 = iVar2 + -1;
      cVar3 = ExclusiveMonitorsStatus();
    }
  } while (cVar3 != '\0');
  if (iVar2 + -1 != 0) {
    return;
  }
  FUN_00007730();
  return;
}



void FUN_0000787c(long param_1)

{
  long lVar1;
  
  lVar1 = *(long *)(param_1 + 0x200);
  while (lVar1 != param_1 + 0x200 && lVar1 != 0) {
    FUN_000078bc(param_1);
    lVar1 = *(long *)(param_1 + 0x200);
  }
  *(undefined8 *)(param_1 + 0x210) = 0;
  FUN_00008cb8();
  return;
}



void FUN_000078bc(long param_1,long *param_2)

{
  int *piVar1;
  int iVar2;
  char cVar3;
  bool bVar4;
  uint uVar5;
  undefined8 uVar6;
  long lVar7;
  long lVar8;
  long *plVar9;
  
  if ((*(uint *)(param_2 + 7) >> 0xf & 1) == 0) {
    uVar5 = (uint)(short)*(uint *)(param_2 + 7);
    if ((int)uVar5 < DAT_00028c00) {
      FUN_00015504(&DAT_00029580);
      if (*(long **)(DAT_00028c08 + (ulong)uVar5 * 8) == param_2) {
        *(undefined8 *)(DAT_00028c08 + (ulong)uVar5 * 8) = 0;
        FUN_00015548(&DAT_00029580);
        lVar7 = param_2[6];
        if (lVar7 != 0x100101) {
          if (*(long **)(param_1 + 0x230) == param_2) {
            if (lVar7 == 0) {
              *(undefined8 *)(param_1 + 0x230) = 0;
            }
            else {
              *(undefined8 *)(lVar7 + 0x28) = 0;
              *(long *)(param_1 + 0x230) = lVar7;
            }
          }
          else {
            lVar8 = param_2[5];
            *(long *)(lVar8 + 0x30) = lVar7;
            if (lVar7 != 0) {
              *(long *)(lVar7 + 0x28) = lVar8;
            }
          }
          param_2[5] = 0x200203;
          param_2[6] = 0x100101;
          FUN_00015e64(param_2 + 2,param_1 + 0x218);
        }
        lVar7 = *param_2;
        plVar9 = (long *)param_2[1];
        *(long **)(lVar7 + 8) = plVar9;
        *plVar9 = lVar7;
        *param_2 = 0x100101;
        param_2[1] = 0x200203;
        *(long *)(param_1 + 0x210) = *(long *)(param_1 + 0x210) + -1;
        piVar1 = (int *)((long)param_2 + 0x3c);
        do {
          iVar2 = *piVar1;
          cVar3 = '\x01';
          bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
          if (bVar4) {
            *piVar1 = iVar2 + -1;
            cVar3 = ExclusiveMonitorsStatus();
          }
        } while (cVar3 != '\0');
        if (iVar2 + -1 == 0) {
          FUN_00007730(param_2);
        }
        uVar6 = 0;
      }
      else {
        FUN_00015548(&DAT_00029580);
        uVar6 = 0xffffffea;
      }
      FUN_00008be4(uVar6);
      return;
    }
    uVar6 = 0xa8;
  }
  else {
    uVar6 = 0xa6;
  }
                    // WARNING: Subroutine does not return
  FUN_00008ccc("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/timer.c"
               ,uVar6);
}



int FUN_00007a04(long param_1)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  long lVar4;
  int iVar5;
  long lVar6;
  long *plVar7;
  long local_58;
  
  local_58 = _ahpl_tick_now();
  lVar6 = *(long *)(param_1 + 0x230);
  if ((lVar6 == 0) || (plVar7 = (long *)(lVar6 + 0x50), local_58 - *plVar7 < 0)) {
    iVar5 = 0;
  }
  else {
    iVar1 = 1;
    do {
      iVar5 = iVar1;
      lVar4 = *(long *)(lVar6 + 0x30);
      if (lVar4 != 0) {
        *(undefined8 *)(lVar4 + 0x28) = 0;
      }
      *(long *)(param_1 + 0x230) = lVar4;
      *(undefined8 *)(lVar6 + 0x28) = 0x200203;
      *(undefined8 *)(lVar6 + 0x30) = 0x100101;
      FUN_00015e64(lVar6 + 0x10,param_1 + 0x218);
      if (*(long *)(lVar6 + 0x48) != -1) {
        lVar4 = _ahpl_tick_now();
        *plVar7 = *(long *)(lVar6 + 0x48) + lVar4;
        FUN_00007b5c(param_1 + 0x218,lVar6 + 0x10);
      }
      uVar2 = _ahpl_tick_now();
      *(undefined4 *)(param_1 + 0x1d8) = uVar2;
      lVar4 = _objc_autoreleasePoolPush();
      (**(code **)(lVar6 + 0x58))
                (*(undefined4 *)(lVar6 + 0x38),&local_58,*(undefined8 *)(lVar6 + 0x68),lVar6 + 0x70)
      ;
      if (lVar4 != 0) {
        _objc_autoreleasePoolPop(lVar4);
      }
      lVar6 = *(long *)(param_1 + 0x1a0);
      uVar3 = *(undefined8 *)(lVar6 + 8);
      *(undefined8 *)(lVar6 + 8) = 0;
      FUN_0000f048(uVar3,0);
      *(undefined8 *)(lVar6 + 0x10) = 0;
      *(undefined4 *)(lVar6 + 0x18) = 0;
      if (*(long *)(lVar6 + 0x20) != 0) {
        FUN_0000f214(*(long *)(lVar6 + 0x20),0);
        *(undefined8 *)(lVar6 + 0x20) = 0;
      }
      *(undefined8 *)(lVar6 + 0x28) = 0;
      lVar6 = *(long *)(param_1 + 0x230);
      if (lVar6 == 0) {
        return iVar5;
      }
      plVar7 = (long *)(lVar6 + 0x50);
      iVar1 = iVar5 + 1;
    } while (-1 < local_58 - *plVar7);
  }
  return iVar5;
}



void FUN_00007b5c(long **param_1,long **param_2)

{
  long lVar1;
  long *plVar2;
  long **pplVar3;
  long *plVar4;
  long **pplVar5;
  long *plVar6;
  long **pplVar7;
  
  pplVar3 = param_2 + -2;
  if (*param_1 == (long *)0x0) {
    plVar4 = (long *)0x0;
    param_2[3] = (long *)0x0;
    param_2[4] = (long *)0x0;
    pplVar5 = param_1;
  }
  else {
    plVar6 = (long *)0x0;
    plVar2 = *param_1;
    do {
      plVar4 = plVar2;
      if ((long *)plVar4[8] <= param_2[8]) {
        plVar6 = plVar4;
      }
      lVar1 = 0x10;
      pplVar5 = (long **)(plVar4 + 2);
      if ((long *)plVar4[8] <= param_2[8]) {
        lVar1 = 8;
        pplVar5 = (long **)(plVar4 + 1);
      }
      plVar2 = *(long **)((long)plVar4 + lVar1);
    } while (*(long **)((long)plVar4 + lVar1) != (long *)0x0);
    if (plVar6 != (long *)0x0) {
      param_2[3] = plVar6 + -2;
      pplVar7 = (long **)(plVar6 + 4);
      plVar6 = *pplVar7;
      param_2[4] = plVar6;
      if (plVar6 != (long *)0x0) {
        plVar6[5] = (long)pplVar3;
      }
      goto LAB_00007be4;
    }
    param_2[3] = (long *)0x0;
    param_2[4] = plVar4 + -2;
    plVar4[3] = (long)pplVar3;
  }
  pplVar7 = param_1 + 3;
LAB_00007be4:
  *pplVar7 = (long *)pplVar3;
  *param_2 = plVar4;
  param_2[1] = (long *)0x0;
  param_2[2] = (long *)0x0;
  *pplVar5 = (long *)param_2;
  FUN_00015ccc(param_2,param_1);
  return;
}



void _ahpl_mpq_create_timer(void)

{
  undefined uVar1;
  undefined4 uVar2;
  int *piVar3;
  long lVar4;
  ulong uVar5;
  undefined4 *puVar6;
  ulong in_x3;
  int iVar7;
  long unaff_x29;
  undefined auVar8 [16];
  
  auVar8 = FUN_00008d04();
  *(undefined8 *)(unaff_x29 + -0x28) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  if ((auVar8._0_8_ < 0) || (auVar8._8_8_ == 0)) {
LAB_00007c7c:
    piVar3 = ___error();
    iVar7 = 0x16;
LAB_00007c84:
    *piVar3 = iVar7;
  }
  else {
    uVar1 = in_x3 == 0x41;
    if (0x40 < in_x3) {
      piVar3 = ___error();
      iVar7 = 7;
      goto LAB_00007c84;
    }
    lVar4 = FUN_00008cc0();
    if (lVar4 == 0) goto LAB_00007c7c;
    FUN_00008bc0();
    if (in_x3 != 0) {
      do {
        FUN_00008b80();
      } while (!(bool)uVar1);
    }
    uVar5 = FUN_00008c90();
    if (uVar5 < 0xfffffffffffff001) {
      uVar2 = *(undefined4 *)(uVar5 + 0x38);
      goto LAB_00007c8c;
    }
    puVar6 = (undefined4 *)FUN_00008ca8();
    *puVar6 = (int)in_x3;
  }
  uVar2 = 0xffffffff;
LAB_00007c8c:
  if (*(long *)PTR____stack_chk_guard_00028030 != *(long *)(unaff_x29 + -0x28)) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  FUN_00008bf4();
  return;
}



long * FUN_00007cbc(long param_1,long param_2,long param_3,long param_4,long param_5,long *param_6)

{
  ushort uVar1;
  long *plVar2;
  ulong uVar3;
  undefined *puVar4;
  void *pvVar5;
  undefined8 uVar6;
  long *plVar7;
  long **pplVar8;
  int iVar9;
  long lVar10;
  undefined8 unaff_x30;
  
  plVar2 = (long *)_ahpl_malloc(param_5 * 8 + 0x70);
  if (plVar2 == (long *)0x0) {
    return (long *)0xfffffffffffffff4;
  }
  FUN_00015504(&DAT_00029580);
  puVar4 = DAT_00028c10;
  iVar9 = DAT_00028c00;
  lVar10 = (long)DAT_00028c00;
  uVar3 = FUN_00008c70();
  if ((int)uVar3 < iVar9) {
LAB_00007d3c:
    FUN_000040d4(uVar3,puVar4);
    FUN_00015548(&DAT_00029580);
    iVar9 = (int)uVar3;
    if (-1 < iVar9) {
      plVar2[5] = 0x200203;
      plVar2[6] = 0x100101;
      *(undefined4 *)(plVar2 + 7) = 0xffffffff;
      *(undefined4 *)((long)plVar2 + 0x3c) = 1;
      *(undefined4 *)(plVar2 + 8) = *(undefined4 *)(param_1 + 0x14);
      plVar2[9] = param_2;
      plVar2[10] = -1;
      plVar2[0xb] = param_3;
      plVar2[0xc] = param_4;
      plVar2[0xd] = param_5;
      if (param_5 != 0) {
        plVar7 = plVar2 + 0xe;
        do {
          *plVar7 = *param_6;
          param_5 = param_5 + -1;
          plVar7 = plVar7 + 1;
          param_6 = param_6 + 1;
        } while (param_5 != 0);
      }
      pplVar8 = *(long ***)(param_1 + 0x208);
      *(long **)(param_1 + 0x208) = plVar2;
      *plVar2 = param_1 + 0x200;
      plVar2[1] = (long)pplVar8;
      *pplVar8 = plVar2;
      *(long *)(param_1 + 0x210) = *(long *)(param_1 + 0x210) + 1;
      if (iVar9 < DAT_00028c00) {
        FUN_00015504(&DAT_00029580);
        uVar1 = DAT_00028c18;
        if (iVar9 < DAT_00028c00) {
          if (*(long *)((long)DAT_00028c08 + (uVar3 & 0xffffffff) * 8) != 0) {
                    // WARNING: Subroutine does not return
            _abort();
          }
          *(long **)((long)DAT_00028c08 + (uVar3 & 0xffffffff) * 8) = plVar2;
          *(uint *)(plVar2 + 7) = (int)(short)uVar3 | (uint)DAT_00028c18 << 0x10;
          uVar1 = 1;
          if ((DAT_00028c18 + 1 & 0x10000) == 0) {
            uVar1 = DAT_00028c18 + 1;
          }
        }
        DAT_00028c18 = uVar1;
        FUN_00015548(&DAT_00029580);
        return plVar2;
      }
      uVar6 = 0x8c;
LAB_00007fac:
                    // WARNING: Subroutine does not return
      FUN_00008ccc("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/timer.c"
                   ,uVar6,unaff_x30);
    }
  }
  else {
    if (0x4fff < iVar9) {
      FUN_00015548(&DAT_00029580);
      uVar3 = 0xffffffac;
      goto LAB_00007f70;
    }
    lVar10 = lVar10 + 0x40;
    puVar4 = (undefined *)FUN_00015c6c(lVar10);
    if (puVar4 == (undefined *)0x0) {
      FUN_00015548(&DAT_00029580);
    }
    else {
      pvVar5 = (void *)_ahpl_malloc(lVar10 * 8);
      if (pvVar5 != (void *)0x0) {
        _memcpy(puVar4,DAT_00028c10,
                (long)DAT_00028c00 * 0x20000000 + 0x7e0000000 >> 0x20 & 0xfffffffffffffff8);
        _memcpy(pvVar5,DAT_00028c08,(long)DAT_00028c00 << 3);
        iVar9 = (int)lVar10;
        _bzero((void *)((long)pvVar5 + (long)DAT_00028c00 * 8),
               -(ulong)((uint)(iVar9 - DAT_00028c00) >> 0x1f) & 0xfffffff800000000 |
               (ulong)(uint)(iVar9 - DAT_00028c00) << 3);
        if (DAT_00028c10 != &DAT_0002e760) {
          _free(DAT_00028c10);
          _free(DAT_00028c08);
        }
        DAT_00028c00 = iVar9;
        DAT_00028c08 = pvVar5;
        DAT_00028c10 = puVar4;
        uVar3 = FUN_00008c70();
        if (iVar9 <= (int)uVar3) {
          uVar6 = 0x69;
          goto LAB_00007fac;
        }
        goto LAB_00007d3c;
      }
      FUN_00015548(&DAT_00029580);
      _free(puVar4);
    }
    uVar3 = 0xfffffff4;
  }
LAB_00007f70:
  _free(plVar2);
  return (long *)(long)(int)uVar3;
}



void _ahpl_mpq_create_timer_on_q(undefined8 param_1,long param_2)

{
  if (param_2 < 0) {
    ___error();
    FUN_00008c3c(0x16);
  }
  else {
    FUN_00007ff0();
  }
  FUN_00008ca0();
  return;
}



void FUN_00007ff0(undefined8 param_1,undefined8 param_2,long param_3,undefined8 param_4,
                 ulong param_5,undefined8 *param_6)

{
  undefined uVar1;
  int iVar2;
  undefined4 uVar3;
  int *piVar4;
  long lVar5;
  long lVar6;
  undefined8 extraout_x8;
  undefined auVar7 [16];
  ulong local_58;
  
  lVar6 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 == 0) {
LAB_000080b8:
    piVar4 = ___error();
    iVar2 = 0x16;
LAB_000080c0:
    *piVar4 = iVar2;
  }
  else {
    uVar1 = param_5 == 0x41;
    if (0x40 < param_5) {
      piVar4 = ___error();
      iVar2 = 7;
      goto LAB_000080c0;
    }
    lVar5 = FUN_00009b40();
    if (lVar5 == 0) goto LAB_000080b8;
    auVar7 = FUN_00008c00();
    *param_6 = extraout_x8;
    param_6[1] = param_2;
    param_6[2] = param_3;
    param_6[3] = param_4;
    if (param_5 != 0) {
      do {
        auVar7 = FUN_00008c20();
      } while (!(bool)uVar1);
    }
    iVar2 = FUN_00008cd4(auVar7._0_8_,auVar7._8_8_,"____target_q_set_timer",FUN_00008918);
    if (iVar2 < 0) {
      piVar4 = ___error();
      local_58 = -(long)*piVar4;
    }
    FUN_00008ce0();
    if (local_58 < 0xfffffffffffff001) {
      uVar3 = *(undefined4 *)(local_58 + 0x38);
      goto LAB_000080c8;
    }
    piVar4 = ___error();
    *piVar4 = -(int)local_58;
  }
  uVar3 = 0xffffffff;
LAB_000080c8:
  if (*(long *)PTR____stack_chk_guard_00028030 != lVar6) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar3);
  }
  FUN_00008be4();
  return;
}



void _ahpl_mpq_create_oneshot_timer(undefined8 param_1,undefined8 param_2,ulong param_3)

{
  undefined uVar1;
  undefined4 uVar2;
  long lVar3;
  int *piVar4;
  undefined8 uVar5;
  ulong uVar6;
  undefined4 *puVar7;
  int iVar8;
  long unaff_x29;
  
  lVar3 = FUN_00008d04();
  *(undefined8 *)(unaff_x29 + -0x28) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  if (lVar3 == 0) {
LAB_00008178:
    piVar4 = ___error();
    iVar8 = 0x16;
LAB_00008180:
    *piVar4 = iVar8;
  }
  else {
    uVar1 = param_3 == 0x41;
    if (0x40 < param_3) {
      piVar4 = ___error();
      iVar8 = 7;
      goto LAB_00008180;
    }
    lVar3 = FUN_0000a4a4();
    if (lVar3 == 0) goto LAB_00008178;
    uVar5 = FUN_00008bc0();
    if (param_3 != 0) {
      do {
        uVar5 = FUN_00008b80();
      } while (!(bool)uVar1);
    }
    uVar6 = FUN_00008c90(uVar5,0xffffffffffffffff);
    if (uVar6 < 0xfffffffffffff001) {
      uVar2 = *(undefined4 *)(uVar6 + 0x38);
      goto LAB_00008188;
    }
    puVar7 = (undefined4 *)FUN_00008ca8();
    *puVar7 = (int)param_3;
  }
  uVar2 = 0xffffffff;
LAB_00008188:
  if (*(long *)PTR____stack_chk_guard_00028030 != *(long *)(unaff_x29 + -0x28)) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  FUN_00008bf4();
  return;
}



void _ahpl_mpq_create_oneshot_timer_on_q
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  FUN_00007ff0(param_1,0xffffffffffffffff,param_2,param_3,param_4,&stack0x00000000);
  FUN_00008ca0();
  return;
}



void _ahpl_mpq_set_timer(void)

{
  undefined uVar1;
  undefined4 uVar2;
  int *piVar3;
  long lVar4;
  ulong uVar5;
  undefined4 *puVar6;
  ulong in_x3;
  int iVar7;
  long unaff_x29;
  undefined auVar8 [16];
  
  auVar8 = FUN_00008d04();
  *(undefined8 *)(unaff_x29 + -0x28) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  if ((auVar8._0_8_ < 0) || (auVar8._8_8_ == 0)) {
LAB_00008270:
    piVar3 = ___error();
    iVar7 = 0x16;
LAB_00008278:
    *piVar3 = iVar7;
  }
  else {
    uVar1 = in_x3 == 0x41;
    if (0x40 < in_x3) {
      piVar3 = ___error();
      iVar7 = 7;
      goto LAB_00008278;
    }
    lVar4 = FUN_00008cc0();
    if (lVar4 == 0) goto LAB_00008270;
    FUN_00008b9c();
    if (in_x3 != 0) {
      do {
        FUN_00008b80();
      } while (!(bool)uVar1);
    }
    uVar5 = FUN_00008c58();
    if (uVar5 < 0xfffffffffffff001) {
      uVar2 = *(undefined4 *)(uVar5 + 0x38);
      goto LAB_00008280;
    }
    puVar6 = (undefined4 *)FUN_00008ca8();
    *puVar6 = (int)in_x3;
  }
  uVar2 = 0xffffffff;
LAB_00008280:
  if (*(long *)PTR____stack_chk_guard_00028030 != *(long *)(unaff_x29 + -0x28)) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  FUN_00008bf4();
  return;
}



ulong FUN_000082b0(long param_1,undefined8 param_2,long param_3,undefined8 param_4,
                  undefined8 param_5,undefined8 param_6,undefined8 param_7)

{
  bool bVar1;
  ulong uVar2;
  
  uVar2 = FUN_00007cbc(param_1,param_2,param_4,param_5,param_6,param_7);
  if (uVar2 < 0xfffffffffffff001) {
    bVar1 = *(long *)(uVar2 + 0x48) == -1;
    if (param_3 == 0) {
      if (bVar1) {
        param_3 = -1;
      }
      else {
        param_3 = _ahpl_tick_now();
        param_3 = *(long *)(uVar2 + 0x48) + param_3;
      }
    }
    else if (!bVar1) {
      *(undefined8 *)(uVar2 + 0x48) = 0xffffffffffffffff;
    }
    *(long *)(uVar2 + 0x50) = param_3;
    FUN_00007b5c(param_1 + 0x218,uVar2 + 0x10);
  }
  return uVar2;
}



void _ahpl_mpq_set_timer_on_q(undefined8 param_1,long param_2)

{
  undefined auVar1 [16];
  
  if (param_2 < 0) {
    ___error();
    FUN_00008c3c(0x16);
  }
  else {
    auVar1 = FUN_00008cf0();
    FUN_0000837c(auVar1._0_8_,auVar1._8_8_,0);
  }
  FUN_00008ca0();
  return;
}



void FUN_0000837c(undefined8 param_1,undefined8 param_2,undefined8 param_3,long param_4,
                 undefined8 param_5,undefined8 *param_6)

{
  undefined uVar1;
  int iVar2;
  undefined4 uVar3;
  int *piVar4;
  long lVar5;
  undefined8 *puVar6;
  long lVar7;
  undefined8 extraout_x8;
  undefined auVar8 [16];
  ulong local_58;
  
  lVar7 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_4 == 0) {
LAB_0000844c:
    piVar4 = ___error();
    iVar2 = 0x16;
LAB_00008454:
    *piVar4 = iVar2;
  }
  else {
    uVar1 = param_6 == (undefined8 *)((long)&segment_command_00000020.vmsize + 1);
    if (&segment_command_00000020.vmsize < param_6) {
      piVar4 = ___error();
      iVar2 = 7;
      goto LAB_00008454;
    }
    puVar6 = param_6;
    lVar5 = FUN_00009b40();
    if (lVar5 == 0) goto LAB_0000844c;
    auVar8 = FUN_00008c00();
    *puVar6 = extraout_x8;
    puVar6[1] = param_2;
    puVar6[2] = param_3;
    puVar6[3] = param_4;
    puVar6[4] = param_5;
    if (param_6 != (undefined8 *)0x0) {
      do {
        auVar8 = FUN_00008c20();
      } while (!(bool)uVar1);
    }
    iVar2 = FUN_00008cd4(auVar8._0_8_,auVar8._8_8_,"____target_q_set_timer",FUN_00008970);
    if (iVar2 < 0) {
      piVar4 = ___error();
      local_58 = -(long)*piVar4;
    }
    FUN_00008ce0();
    if (local_58 < 0xfffffffffffff001) {
      uVar3 = *(undefined4 *)(local_58 + 0x38);
      goto LAB_0000845c;
    }
    piVar4 = ___error();
    *piVar4 = -(int)local_58;
  }
  uVar3 = 0xffffffff;
LAB_0000845c:
  if (*(long *)PTR____stack_chk_guard_00028030 != lVar7) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar3);
  }
  FUN_00008be4();
  return;
}



void _ahpl_mpq_set_oneshot_timer(void)

{
  undefined uVar1;
  undefined4 uVar2;
  int *piVar3;
  long lVar4;
  undefined8 uVar5;
  ulong uVar6;
  undefined4 *puVar7;
  ulong in_x3;
  int iVar8;
  long unaff_x29;
  undefined auVar9 [16];
  
  auVar9 = FUN_00008d04();
  *(undefined8 *)(unaff_x29 + -0x28) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  if (auVar9._8_8_ == 0) {
LAB_00008518:
    piVar3 = ___error();
    iVar8 = 0x16;
LAB_00008520:
    *piVar3 = iVar8;
  }
  else {
    uVar1 = in_x3 == 0x41;
    if (0x40 < in_x3) {
      piVar3 = ___error();
      iVar8 = 7;
      goto LAB_00008520;
    }
    if ((auVar9._0_8_ == 0) || (lVar4 = FUN_0000a4a4(), lVar4 == 0)) goto LAB_00008518;
    uVar5 = FUN_00008b9c();
    if (in_x3 != 0) {
      do {
        uVar5 = FUN_00008b80();
      } while (!(bool)uVar1);
    }
    uVar6 = FUN_00008c58(uVar5,0xffffffffffffffff,auVar9._0_8_);
    if (uVar6 < 0xfffffffffffff001) {
      uVar2 = *(undefined4 *)(uVar6 + 0x38);
      goto LAB_00008528;
    }
    puVar7 = (undefined4 *)FUN_00008ca8();
    *puVar7 = (int)in_x3;
  }
  uVar2 = 0xffffffff;
LAB_00008528:
  if (*(long *)PTR____stack_chk_guard_00028030 != *(long *)(unaff_x29 + -0x28)) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  FUN_00008bf4();
  return;
}



void _ahpl_mpq_set_oneshot_timer_on_q(void)

{
  undefined auVar1 [16];
  undefined8 uStack_18;
  
  auVar1 = FUN_00008cf0();
  uStack_18 = auVar1._8_8_;
  FUN_0000837c(auVar1._0_8_,0xffffffffffffffff,&uStack_18);
  FUN_00008ca0();
  return;
}



void _ahpl_mpq_timer_interval(undefined8 param_1,undefined8 *param_2)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_000077c8();
  if (lVar1 == 0) {
    ___error();
    uVar2 = FUN_00008c3c(2);
  }
  else {
    if (param_2 != (undefined8 *)0x0) {
      *param_2 = *(undefined8 *)(lVar1 + 0x48);
    }
    FUN_0000785c();
    uVar2 = 0;
  }
  FUN_00008c68(uVar2);
  return;
}



void _ahpl_mpq_timer_active(undefined8 param_1,uint *param_2)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_000077c8();
  if (lVar1 == 0) {
    ___error();
    uVar2 = FUN_00008c3c(2);
  }
  else {
    if (param_2 != (uint *)0x0) {
      *param_2 = (uint)(*(long *)(lVar1 + 0x30) != 0x100101);
    }
    FUN_0000785c();
    uVar2 = 0;
  }
  FUN_00008c68(uVar2);
  return;
}



void _ahpl_mpq_resched_timer(undefined8 param_1,long param_2)

{
  long lVar1;
  int *piVar2;
  
  lVar1 = FUN_000077c8();
  if (lVar1 == 0) {
    ___error();
    FUN_00008c80();
  }
  else {
    if ((param_2 < 0) && (param_2 = *(long *)(lVar1 + 0x48), param_2 < 0)) {
      piVar2 = ___error();
      *piVar2 = 0x16;
      param_2 = 0xffffffff;
    }
    else {
      param_2 = FUN_00008688(lVar1,param_2,0);
    }
    FUN_00008ce8();
  }
  FUN_00008c68(param_2);
  return;
}



void FUN_00008688(void)

{
  int iVar1;
  long lVar2;
  ulong uVar3;
  
  lVar2 = FUN_00008cb0();
  if (lVar2 == 0) {
    ___error();
    uVar3 = FUN_00008c3c(0x16);
  }
  else {
    iVar1 = FUN_0000ace8(lVar2,0xffffffff,"____target_q_resched_timer",FUN_000089e4,3);
    FUN_00008ce0();
    uVar3 = (ulong)(uint)(iVar1 >> 0x1f);
  }
  FUN_00008c48(uVar3);
  return;
}



undefined8 _ahpl_mpq_resched_oneshot_timer(undefined8 param_1,long param_2)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  int iVar4;
  long local_28;
  
  local_28 = param_2;
  if (param_2 == 0) {
    piVar3 = ___error();
    iVar4 = 0x16;
  }
  else {
    lVar1 = FUN_000077c8();
    if (lVar1 != 0) {
      uVar2 = FUN_00008688(lVar1,0xffffffffffffffff,&local_28);
      FUN_0000785c(lVar1);
      return uVar2;
    }
    piVar3 = ___error();
    iVar4 = 2;
  }
  *piVar3 = iVar4;
  return 0xffffffff;
}



ulong _ahpl_mpq_cancel_timer(void)

{
  int iVar1;
  long lVar2;
  int *piVar3;
  ulong unaff_x20;
  
  lVar2 = FUN_000077c8();
  if (lVar2 == 0) {
    ___error();
    FUN_00008c80();
  }
  else {
    lVar2 = FUN_00008cb0();
    if (lVar2 == 0) {
      piVar3 = ___error();
      *piVar3 = 0x16;
      unaff_x20 = 0xffffffff;
    }
    else {
      iVar1 = FUN_0000ace8(lVar2,0xffffffff,"____target_q_cancel_timer",FUN_00008ad0,1);
      FUN_00009ba0(lVar2);
      unaff_x20 = (ulong)(uint)(iVar1 >> 0x1f);
    }
    FUN_00008ce8();
  }
  return unaff_x20;
}



void _ahpl_mpq_kill_timer(void)

{
  int iVar1;
  long lVar2;
  int *piVar3;
  ulong unaff_x20;
  uint local_34;
  
  lVar2 = FUN_000077c8();
  if (lVar2 == 0) {
    ___error();
    FUN_00008c80();
    goto LAB_000088a4;
  }
  lVar2 = FUN_00008cb0();
  if (lVar2 == 0) {
    piVar3 = ___error();
    *piVar3 = 0x16;
LAB_0000889c:
    unaff_x20 = 0xffffffff;
  }
  else {
    unaff_x20 = 0xffffffff;
    iVar1 = FUN_0000ace8(lVar2,0xffffffff,"____target_q_kill_timer",FUN_00008b58,2);
    FUN_00009ba0(lVar2);
    if (-1 < iVar1) {
      unaff_x20 = (ulong)local_34;
      if (0xfffff000 < local_34) {
        piVar3 = ___error();
        *piVar3 = -local_34;
        goto LAB_0000889c;
      }
    }
  }
  FUN_00008ce8();
LAB_000088a4:
  FUN_00008c48(unaff_x20);
  return;
}



void _ahpl_mpq_timer_arg(undefined8 param_1,ulong param_2,undefined8 *param_3)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_000077c8();
  if (lVar1 == 0) {
    ___error();
    uVar2 = 2;
  }
  else {
    if (param_2 < *(ulong *)(lVar1 + 0x68)) {
      if (param_3 != (undefined8 *)0x0) {
        *param_3 = *(undefined8 *)(lVar1 + param_2 * 8 + 0x70);
      }
      FUN_0000785c();
      uVar2 = 0;
      goto LAB_00008910;
    }
    FUN_0000785c();
    ___error();
    uVar2 = 0x16;
  }
  uVar2 = FUN_00008c3c(uVar2);
LAB_00008910:
  FUN_00008c68(uVar2);
  return;
}



void FUN_00008918(undefined8 param_1,undefined8 param_2,long param_3,undefined8 *param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 *puVar5;
  
  puVar5 = (undefined8 *)*param_4;
  uVar2 = param_4[1];
  uVar3 = param_4[2];
  uVar4 = param_4[3];
  uVar1 = FUN_000090e4();
  uVar1 = FUN_00007cbc(uVar1,uVar2,uVar3,uVar4,param_3 + -4,param_4 + 4);
  *puVar5 = uVar1;
  return;
}



void FUN_00008970(undefined8 param_1,undefined8 param_2,long param_3,undefined8 *param_4)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 *puVar6;
  undefined8 *puVar7;
  
  puVar6 = (undefined8 *)*param_4;
  uVar3 = param_4[1];
  puVar7 = (undefined8 *)param_4[2];
  uVar4 = param_4[3];
  uVar5 = param_4[4];
  uVar1 = FUN_000090e4();
  if (puVar7 == (undefined8 *)0x0) {
    uVar2 = 0;
  }
  else {
    uVar2 = *puVar7;
  }
  uVar1 = FUN_000082b0(uVar1,uVar3,uVar2,uVar4,uVar5,param_3 + -5,param_4 + 5);
  *puVar6 = uVar1;
  return;
}



void FUN_000089e4(void)

{
  long lVar1;
  long *in_x3;
  long lVar2;
  long lVar3;
  long lVar4;
  undefined8 *puVar5;
  long lVar6;
  
  lVar4 = *in_x3;
  lVar6 = in_x3[1];
  puVar5 = (undefined8 *)in_x3[2];
  lVar1 = FUN_000090e4();
  if (puVar5 != (undefined8 *)0x0) {
    puVar5 = (undefined8 *)*puVar5;
  }
  lVar2 = *(long *)(lVar4 + 0x30);
  if (lVar2 != 0x100101) {
    if (*(long *)(lVar1 + 0x230) == lVar4) {
      if (lVar2 == 0) {
        *(undefined8 *)(lVar1 + 0x230) = 0;
      }
      else {
        *(undefined8 *)(lVar2 + 0x28) = 0;
        *(long *)(lVar1 + 0x230) = lVar2;
      }
    }
    else {
      lVar3 = *(long *)(lVar4 + 0x28);
      *(long *)(lVar3 + 0x30) = lVar2;
      if (lVar2 != 0) {
        *(long *)(lVar2 + 0x28) = lVar3;
      }
    }
    *(undefined8 *)(lVar4 + 0x28) = 0x200203;
    *(undefined8 *)(lVar4 + 0x30) = 0x100101;
    FUN_00015e64(lVar4 + 0x10,lVar1 + 0x218);
  }
  if (lVar6 == -1 || puVar5 != (undefined8 *)0x0) {
    lVar6 = *(long *)(lVar4 + 0x48);
  }
  else {
    *(long *)(lVar4 + 0x48) = lVar6;
  }
  if (puVar5 == (undefined8 *)0x0) {
    if (lVar6 == -1) {
      puVar5 = (undefined8 *)0xffffffffffffffff;
    }
    else {
      lVar6 = _ahpl_tick_now();
      puVar5 = (undefined8 *)(*(long *)(lVar4 + 0x48) + lVar6);
    }
  }
  else if (lVar6 != -1) {
    *(undefined8 *)(lVar4 + 0x48) = 0xffffffffffffffff;
  }
  *(undefined8 **)(lVar4 + 0x50) = puVar5;
  FUN_00007b5c(lVar1 + 0x218,lVar4 + 0x10);
  return;
}



void FUN_00008ad0(void)

{
  long lVar1;
  long *in_x3;
  long lVar2;
  long lVar3;
  long lVar4;
  
  lVar4 = *in_x3;
  lVar1 = FUN_000090e4();
  lVar2 = *(long *)(lVar4 + 0x30);
  if (lVar2 != 0x100101) {
    if (*(long *)(lVar1 + 0x230) == lVar4) {
      if (lVar2 == 0) {
        *(undefined8 *)(lVar1 + 0x230) = 0;
      }
      else {
        *(undefined8 *)(lVar2 + 0x28) = 0;
        *(long *)(lVar1 + 0x230) = lVar2;
      }
    }
    else {
      lVar3 = *(long *)(lVar4 + 0x28);
      *(long *)(lVar3 + 0x30) = lVar2;
      if (lVar2 != 0) {
        *(long *)(lVar2 + 0x28) = lVar3;
      }
    }
    *(undefined8 *)(lVar4 + 0x28) = 0x200203;
    *(undefined8 *)(lVar4 + 0x30) = 0x100101;
    FUN_00015e64(lVar4 + 0x10,lVar1 + 0x218);
    return;
  }
  FUN_00008cb8();
  return;
}



void FUN_00008b58(void)

{
  undefined4 uVar1;
  undefined8 *in_x3;
  undefined4 *puVar2;
  
  uVar1 = FUN_000090e4();
  puVar2 = (undefined4 *)in_x3[1];
  uVar1 = FUN_000078bc(uVar1,*in_x3);
  *puVar2 = uVar1;
  FUN_00008cb8();
  return;
}



void FUN_00008b80(undefined8 *param_1)

{
  undefined8 *puVar1;
  long unaff_x29;
  
  puVar1 = *(undefined8 **)(unaff_x29 + -0x30);
  *(undefined8 **)(unaff_x29 + -0x30) = puVar1 + 1;
  *param_1 = *puVar1;
  return;
}



void FUN_00008b9c(void)

{
  long unaff_x29;
  
  *(long *)(unaff_x29 + -0x30) = unaff_x29 + 0x10;
  return;
}



void FUN_00008bc0(void)

{
  long unaff_x29;
  
  *(long *)(unaff_x29 + -0x30) = unaff_x29 + 0x10;
  return;
}



void FUN_00008be4(void)

{
  return;
}



void FUN_00008bf4(void)

{
  return;
}



void FUN_00008c00(void)

{
  return;
}



void FUN_00008c20(undefined8 *param_1)

{
  undefined8 *puVar1;
  long unaff_x29;
  
  puVar1 = *(undefined8 **)(unaff_x29 + -0x40);
  *(undefined8 **)(unaff_x29 + -0x40) = puVar1 + 1;
  *param_1 = *puVar1;
  return;
}



undefined8 FUN_00008c3c(undefined4 *param_1)

{
  undefined4 in_w8;
  
  *param_1 = in_w8;
  return 0xffffffff;
}



void FUN_00008c48(void)

{
  return;
}



void FUN_00008c58(void)

{
  FUN_000082b0();
  return;
}



void FUN_00008c68(void)

{
  return;
}



void FUN_00008c70(void)

{
  FUN_000168b0();
  return;
}



void FUN_00008c80(undefined4 *param_1)

{
  *param_1 = 2;
  return;
}



void FUN_00008c90(void)

{
  FUN_00007cbc();
  return;
}



void FUN_00008ca0(void)

{
  return;
}



void FUN_00008ca8(void)

{
  ___error();
  return;
}



void FUN_00008cb0(long param_1)

{
  FUN_00009b40(*(undefined4 *)(param_1 + 0x40));
  return;
}



void FUN_00008cb8(void)

{
  return;
}



void FUN_00008cc0(void)

{
  FUN_0000a4a4();
  return;
}



void FUN_00008ccc(void)

{
                    // WARNING: Subroutine does not return
  FUN_000132b8();
}



void FUN_00008cd4(void)

{
  FUN_0000aed4();
  return;
}



void FUN_00008ce0(void)

{
  FUN_00009ba0();
  return;
}



void FUN_00008ce8(void)

{
  FUN_0000785c();
  return;
}



void FUN_00008cf0(void)

{
  return;
}



void FUN_00008d04(void)

{
  return;
}



void FUN_00008d10(long param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  ssize_t sVar4;
  undefined auStack_428 [1024];
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  do {
    sVar4 = _read(*(int *)(param_1 + 0x28),auStack_428,0x400);
    if (sVar4 < 1) break;
    piVar1 = (int *)(param_1 + 0x34);
    do {
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar3) {
        *piVar1 = *piVar1 - (int)sVar4;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
  } while (0x3ff < sVar4);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



ulong FUN_00008d94(long param_1)

{
  int iVar1;
  ulong uVar2;
  int *piVar3;
  int local_28;
  int iStack_24;
  
  iVar1 = _pipe((int)&local_28);
  if (iVar1 < 0) {
    piVar3 = ___error();
    uVar2 = (ulong)(uint)-*piVar3;
  }
  else {
    uVar2 = FUN_00006334(local_28);
    if ((-1 < (int)uVar2) && (uVar2 = FUN_00006334(iStack_24), -1 < (int)uVar2)) {
      *(ulong *)(param_1 + 0x28) = CONCAT44(iStack_24,local_28);
      iVar1 = FUN_000041d4(param_1);
      if (iVar1 < 0) {
        piVar3 = ___error();
        uVar2 = (ulong)(uint)-*piVar3;
      }
      else {
        iVar1 = FUN_00004244(param_1);
        if (-1 < iVar1) {
          *(long *)(param_1 + 0x38) = param_1 + 0x38;
          *(long *)(param_1 + 0x40) = param_1 + 0x38;
          *(undefined8 *)(param_1 + 0x48) = 0;
          *(undefined8 *)(param_1 + 0x50) = 0;
          *(undefined4 *)(param_1 + 0x34) = 0;
          return 0;
        }
        piVar3 = ___error();
        uVar2 = (ulong)(uint)-*piVar3;
        FUN_0000423c(param_1);
      }
    }
    _close(local_28);
    _close(iStack_24);
  }
  return uVar2;
}



void FUN_00008e64(long param_1)

{
  FUN_00004290();
  _close(*(int *)(param_1 + 0x28));
  _close(*(int *)(param_1 + 0x2c));
  FUN_000070e0(param_1);
  FUN_0000423c(param_1);
  return;
}



ulong FUN_00008ea0(long param_1,ulong param_2)

{
  ulong uVar1;
  undefined auStack_c38 [3072];
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  if ((*(int *)(param_1 + 0xa4) == 0) &&
     ((0 < *(int *)(param_1 + 0x34) || ((*(ulong *)(param_1 + 0x48) | param_2) != 0)))) {
    *(undefined4 *)(param_1 + 0xa0) = 1;
    DataMemoryBarrier(2,3);
    if (*(int *)(param_1 + 0xa4) == 0) {
      if (0 < *(int *)(param_1 + 0x148)) {
        *(undefined4 *)(param_1 + 0xa0) = 0;
        if ((*(int *)(param_1 + 0x34) == 0) && (*(long *)(param_1 + 0x48) == 0)) goto LAB_00008ecc;
        param_2 = 0;
      }
      _ahpl_tick_us();
      FUN_000090d0();
      uVar1 = FUN_00004508(param_1,auStack_c38,0x40,param_2);
      _ahpl_tick_us();
      FUN_000090bc();
      *(undefined4 *)(param_1 + 0xa0) = 0;
      FUN_00004640(param_1,auStack_c38,uVar1);
      if (0 < (int)uVar1) {
        *(ulong *)(param_1 + 0x50) = *(long *)(param_1 + 0x50) + (uVar1 & 0xffffffff);
      }
      goto LAB_00008f7c;
    }
  }
LAB_00008ecc:
  uVar1 = 0;
LAB_00008f7c:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return uVar1;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00008fb0(void *param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  ssize_t sVar4;
  
  DataMemoryBarrier(2,3);
  if (*(int *)((long)param_1 + 0xa0) != 0) {
    piVar1 = (int *)((long)param_1 + 0x34);
    do {
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar3) {
        *piVar1 = *piVar1 + 1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    sVar4 = _write(*(int *)((long)param_1 + 0x2c),param_1,1);
    if (sVar4 != 1) {
      do {
        cVar2 = '\x01';
        bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
        if (bVar3) {
          *piVar1 = *piVar1 + -1;
          cVar2 = ExclusiveMonitorsStatus();
        }
      } while (cVar2 != '\0');
    }
  }
  return;
}



undefined8 FUN_00009010(long param_1)

{
  FUN_00015854(param_1 + 0x28);
  return 0;
}



void FUN_0000902c(long param_1)

{
  FUN_00015930(param_1 + 0x28);
  return;
}



undefined8 FUN_00009034(long param_1,long param_2)

{
  if ((param_2 != 0) && (*(int *)(param_1 + 0xa4) == 0)) {
    *(undefined4 *)(param_1 + 0xa0) = 1;
    DataMemoryBarrier(2,3);
    if (*(int *)(param_1 + 0xa4) == 0) {
      if (*(int *)(param_1 + 0x148) < 1) {
        _ahpl_tick_us();
        FUN_000090d0();
        FUN_000158c0(param_1 + 0x28,param_2);
        _ahpl_tick_us();
        FUN_000090bc();
      }
      *(undefined4 *)(param_1 + 0xa0) = 0;
    }
  }
  return 0;
}



void FUN_000090a4(long param_1)

{
  DataMemoryBarrier(2,3);
  if (*(int *)(param_1 + 0xa0) != 0) {
    FUN_00015880(param_1 + 0x28);
    return;
  }
  return;
}



void FUN_000090bc(long param_1)

{
  long unaff_x19;
  
  *(long *)(unaff_x19 + 0x1d0) = param_1 - *(long *)(unaff_x19 + 0x1b8);
  *(long *)(unaff_x19 + 0x1c0) = param_1;
  return;
}



void FUN_000090d0(long param_1)

{
  long unaff_x19;
  
  *(long *)(unaff_x19 + 0x1c8) = param_1 - *(long *)(unaff_x19 + 0x1c0);
  *(long *)(unaff_x19 + 0x1b8) = param_1;
  return;
}



void FUN_000090e4(void)

{
  _pthread_getspecific(DAT_00028c60);
  return;
}



void FUN_000090f0(undefined8 param_1)

{
  undefined8 *puVar1;
  undefined8 *puVar2;
  undefined8 uVar3;
  
  puVar2 = (undefined8 *)_ahpl_malloc(0x18);
  if (puVar2 == (undefined8 *)0x0) {
    uVar3 = 0xfffffff4;
  }
  else {
    puVar2[2] = param_1;
    FUN_00015504(&DAT_00029690);
    puVar1 = DAT_00028c70;
    DAT_00028c70 = puVar2;
    *puVar2 = &DAT_00028c68;
    puVar2[1] = puVar1;
    *puVar1 = puVar2;
    FUN_00015548(&DAT_00029690);
    uVar3 = 0;
  }
  FUN_0000c3e0(uVar3);
  return;
}



void FUN_00009158(long param_1)

{
  undefined8 *puVar1;
  undefined4 uVar2;
  undefined8 *puVar3;
  int iVar4;
  undefined8 *puVar5;
  
  FUN_00015504(&DAT_00029690);
  if ((undefined8 **)DAT_00028c68 == &DAT_00028c68) {
    FUN_00015548(&DAT_00029690);
    uVar2 = 0xfffffffe;
  }
  else {
    iVar4 = 0;
    puVar1 = DAT_00028c68;
    do {
      puVar5 = (undefined8 *)*puVar1;
      if (puVar1[2] == param_1) {
        puVar3 = (undefined8 *)puVar1[1];
        puVar5[1] = puVar3;
        *puVar3 = puVar5;
        _free(puVar1);
        iVar4 = iVar4 + 1;
      }
      puVar1 = puVar5;
    } while ((undefined8 **)puVar5 != &DAT_00028c68);
    FUN_00015548(&DAT_00029690);
    uVar2 = 0;
    if (iVar4 < 1) {
      uVar2 = 0xfffffffe;
    }
  }
  FUN_0000c490(uVar2);
  return;
}



void _ahpl_get_times(long *param_1,long *param_2)

{
  long lVar1;
  int iVar2;
  ulong uVar3;
  long lVar4;
  long lVar5;
  long lVar6;
  ulong uVar7;
  long local_70;
  long local_68;
  
  FUN_00004bbc(&DAT_000297e8);
  uVar7 = DAT_00028c80;
  uVar3 = FUN_0000c580(DAT_00028c78,DAT_00028c80);
  lVar5 = 0;
  lVar6 = 0;
  if (uVar3 < uVar7) {
    lVar6 = 0;
    lVar5 = 0;
    do {
      lVar4 = *(long *)(DAT_00028c88 + uVar3 * 8);
      if (((lVar4 != 0) && ((*(byte *)(lVar4 + 0xac) >> 3 & 1) == 0)) &&
         (iVar2 = FUN_0000c4bc(*(undefined4 *)(lVar4 + 0x20)), -1 < iVar2)) {
        lVar6 = local_68 + lVar6;
        lVar5 = local_70 + lVar5;
      }
      uVar7 = DAT_00028c80;
      uVar3 = FUN_000167ec(DAT_00028c78,DAT_00028c80,uVar3 + 1);
    } while (uVar3 < uVar7);
  }
  if (DAT_000298b0 != 0) {
    lVar4 = 0;
    uVar7 = 0;
    do {
      iVar2 = FUN_0000c4bc(*(undefined4 *)(DAT_000298b8 + lVar4));
      lVar1 = local_70;
      if (iVar2 < 0) {
        lVar1 = 0;
      }
      lVar5 = lVar1 + lVar5;
      lVar1 = local_68;
      if (iVar2 < 0) {
        lVar1 = 0;
      }
      lVar6 = lVar1 + lVar6;
      uVar7 = uVar7 + 1;
      lVar4 = lVar4 + 0x28;
    } while (uVar7 < DAT_000298b0);
  }
  FUN_00004c24(&DAT_000297e8);
  if (param_1 != (long *)0x0) {
    *param_1 = lVar6;
  }
  if (param_2 != (long *)0x0) {
    *param_2 = lVar5;
  }
  return;
}



void _ahpl_thrd_getname(ulong param_1,char *param_2,long param_3)

{
  ulong uVar1;
  long lVar2;
  undefined8 uVar3;
  ulong uVar4;
  char **ppcVar5;
  
  FUN_00004bbc(&DAT_000297e8);
  uVar1 = DAT_00028c80;
  uVar3 = DAT_00028c78;
  if ((DAT_000298c0 == (char **)0x0) ||
     (ppcVar5 = DAT_000298c0, *(uint *)(DAT_000298c0 + 4) != param_1)) {
    uVar4 = FUN_0000c580(DAT_00028c78,DAT_00028c80);
    lVar2 = DAT_00028c88;
    for (; uVar4 < uVar1; uVar4 = FUN_000167ec(uVar3,uVar1,uVar4 + 1)) {
      ppcVar5 = *(char ***)(lVar2 + uVar4 * 8);
      if ((ppcVar5 != (char **)0x0) && (*(uint *)(ppcVar5 + 4) == param_1)) goto LAB_00009380;
    }
    FUN_00004c24(&DAT_000297e8);
    ___error();
    uVar3 = FUN_0000c4b0(3);
  }
  else {
LAB_00009380:
    if (param_3 != 0) {
      if (*ppcVar5 != (char *)0x0) {
        _strncpy(param_2,*ppcVar5,param_3 - 1U);
        param_2 = param_2 + (param_3 - 1U);
      }
      *param_2 = '\0';
    }
    FUN_00004c24(&DAT_000297e8);
    uVar3 = 0;
  }
  FUN_0000c5f0(uVar3);
  return;
}



int FUN_00009430(void)

{
  int iVar1;
  
  if (-1 < DAT_00028c90._1_1_) {
    return -0x10;
  }
  iVar1 = -3;
  if (DAT_000298c8 - DAT_000298d0 < 0) {
    iVar1 = (int)DAT_000298d0 - (int)DAT_000298c8;
  }
  return iVar1;
}



void FUN_00009468(int param_1,long param_2)

{
  uint uVar1;
  bool bVar2;
  int iVar3;
  long lVar4;
  undefined8 uVar5;
  ulong uVar6;
  long lVar7;
  undefined8 uVar8;
  int *piVar9;
  
  if (param_2 == 0) {
    uVar8 = 0xffffffea;
  }
  else {
    lVar4 = FUN_000090e4();
    if (lVar4 == 0) {
      iVar3 = FUN_000049d8();
      FUN_00015504(&DAT_000297a0);
      uVar6 = (ulong)DAT_000298b0;
      lVar4 = 0;
      do {
        lVar7 = lVar4;
        if (uVar6 * 0x28 + 0x28 == lVar7 + 0x28) {
          if (DAT_000298d8 < DAT_000298b0 + 1) {
            DAT_000298d8 = DAT_000298d8 + 0x10;
            DAT_000298b8 = _realloc(DAT_000298b8,(ulong)DAT_000298d8 * 0x28);
            if (DAT_000298b8 == (void *)0x0) {
                    // WARNING: Subroutine does not return
              _abort();
            }
            uVar6 = (ulong)DAT_000298b0;
          }
          piVar9 = (int *)((long)DAT_000298b8 + uVar6 * 0x28);
          *piVar9 = iVar3;
          piVar9[1] = (uint)(param_1 != 0);
          uVar5 = _ahpl_strdup(param_2);
          uVar8 = 0;
          *(undefined8 *)(piVar9 + 2) = uVar5;
          piVar9[4] = 0;
          uVar1 = DAT_000298b0 + 1;
          bVar2 = DAT_000298b0 == 0;
          DAT_000298b0 = uVar1;
          if ((bVar2) && (DAT_000298c0 == 0)) {
            FUN_000095a4();
            uVar8 = 0;
          }
          goto LAB_00009588;
        }
        lVar4 = lVar7 + 0x28;
      } while (*(int *)((long)DAT_000298b8 + lVar7) != iVar3);
      *(uint *)((long)DAT_000298b8 + lVar7 + 4) = (uint)(param_1 != 0);
      uVar8 = 0xffffffef;
LAB_00009588:
      FUN_00015548(&DAT_000297a0);
    }
    else {
      uVar8 = 0xffffffef;
    }
  }
  FUN_0000c5f0(uVar8);
  return;
}



void FUN_000095a4(void)

{
  if (DAT_000298c0 == 0) {
    DAT_000298c0 = FUN_0000a11c(0x40000000,3,&DAT_00002710,"ahpl_angel",0,FUN_0000bc14,0);
    if (DAT_000298c0 == 0) {
                    // WARNING: Subroutine does not return
      _abort();
    }
    DAT_000298e8 = DAT_000298e8 + 1;
  }
  FUN_0000c4cc();
  return;
}



void FUN_00009608(void)

{
  ulong uVar1;
  long lVar2;
  
  FUN_00015504(&DAT_000297a0);
  if (DAT_000298b0 != 0) {
    uVar1 = 0;
    lVar2 = 8;
    do {
      _free(*(void **)(DAT_000298b8 + lVar2));
      uVar1 = uVar1 + 1;
      lVar2 = lVar2 + 0x28;
    } while (uVar1 < DAT_000298b0);
  }
  DAT_000298b0 = 0;
  if (DAT_000298dc == 0) {
    FUN_00009688();
  }
  FUN_00015548(&DAT_000297a0);
  return;
}



void FUN_00009688(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long lVar4;
  undefined auStack_c0 [136];
  long local_38;
  
  lVar4 = DAT_000298c0;
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  if (((DAT_000298b0 | DAT_000298dc) == 0) && (DAT_000298c0 != 0)) {
    FUN_0000c624();
    piVar1 = (int *)(lVar4 + 0x10);
    do {
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar3) {
        *piVar1 = *piVar1 + 1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    FUN_0000c614();
    do {
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar3) {
        *piVar1 = *piVar1 + -1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
    FUN_0000b894(auStack_c0);
    DAT_000298c0 = 0;
    DAT_000298e8 = DAT_000298e8 + -1;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00009748(int param_1)

{
  long local_30;
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  FUN_00004bbc(&DAT_000297e8);
  if (DAT_000298c0 != 0) {
    local_30 = (long)param_1;
    FUN_000097e0(DAT_000298c0,0xffffffff,0xffffffff,"start_profile",FUN_00009814,1,&local_30);
  }
  FUN_00004c24(&DAT_000297e8);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    FUN_0000c684();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_000097e0(void)

{
  FUN_0000c6a4();
  FUN_0000c698();
  FUN_00009bc4();
  FUN_0000c45c(0);
  return;
}



void FUN_00009814(void)

{
  undefined8 *in_x3;
  int iVar1;
  
  if ((DAT_00028c90._1_1_ < '\0') && (iVar1 = (int)*in_x3, iVar1 != 0)) {
    DAT_00028c90 = FUN_0000c64c(1,FUN_0000bc64);
    if ((DAT_00028c90 >> 0xf & 1) != 0) {
                    // WARNING: Subroutine does not return
      _abort();
    }
    DAT_000298c8 = _ahpl_tick_now();
    DAT_000298d0 = DAT_000298c8;
    if (0 < iVar1) {
      DAT_000298d0 = DAT_000298c8 + iVar1;
    }
  }
  FUN_0000c4cc();
  return;
}



void FUN_00009888(void)

{
  FUN_00004bbc(&DAT_000297e8);
  if (DAT_000298c0 != 0) {
    FUN_0000c49c();
  }
  FUN_00004c24(&DAT_000297e8);
  return;
}



void FUN_000098cc(void)

{
  undefined8 uVar1;
  
  if (-1 < DAT_00028c90._1_1_) {
    uVar1 = _ahpl_tick_now();
    _ahpl_mpq_kill_timer(DAT_00028c90);
    DAT_00028c90 = 0xffffffff;
    DAT_000298d0 = uVar1;
    FUN_00009928(FUN_0000be78,0);
    return;
  }
  FUN_0000c4cc();
  return;
}



void FUN_00009928(code *param_1,undefined8 param_2)

{
  undefined4 *puVar1;
  ulong uVar2;
  undefined8 *puVar3;
  undefined8 uVar4;
  long lVar5;
  ulong uVar6;
  
  FUN_00004bbc(&DAT_000297e8);
  uVar6 = DAT_00028c80;
  uVar4 = DAT_00028c78;
  uVar2 = FUN_0000c580(DAT_00028c78,DAT_00028c80);
  if (uVar2 < uVar6) {
    do {
      puVar3 = *(undefined8 **)(DAT_00028c88 + uVar2 * 8);
      if (puVar3 != (undefined8 *)0x0) {
        (*param_1)(*(undefined4 *)(puVar3 + 4),*puVar3,1,puVar3 + 0x3d,param_2);
        uVar6 = DAT_00028c80;
        uVar4 = DAT_00028c78;
      }
      uVar2 = FUN_000167ec(uVar4,uVar6,uVar2 + 1);
    } while (uVar2 < uVar6);
  }
  if (DAT_000298b0 != 0) {
    lVar5 = 0;
    uVar6 = 0;
    do {
      puVar1 = (undefined4 *)(DAT_000298b8 + lVar5);
      (*param_1)(*puVar1,*(undefined8 *)(puVar1 + 2),puVar1[1],puVar1 + 4,param_2);
      uVar6 = uVar6 + 1;
      lVar5 = lVar5 + 0x28;
    } while (uVar6 < DAT_000298b0);
  }
  FUN_00004c24(&DAT_000297e8);
  return;
}



void _ahpl_perf_set_callback(undefined8 param_1)

{
  undefined8 uVar1;
  
  FUN_00004bbc(&DAT_000297e8);
  if (DAT_000298e8 == 0) {
    DataMemoryBarrier(2,2);
    DAT_000298e0 = param_1;
    FUN_00004c24(&DAT_000297e8);
    uVar1 = 0;
  }
  else {
    FUN_00004c24(&DAT_000297e8);
    ___error();
    uVar1 = FUN_0000c4b0(1);
  }
  FUN_0000c3e0(uVar1);
  return;
}



void FUN_00009a98(uint param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long lVar4;
  
  if ((short)param_1 < 0) {
    lVar4 = 0;
    goto LAB_00009b1c;
  }
  FUN_00004bbc(&DAT_000297e8);
  if ((int)(param_1 & 0xffff) < (int)DAT_00028c80) {
    lVar4 = *(long *)(DAT_00028c88 + (ulong)(param_1 & 0xffff) * 8);
    if (lVar4 != 0) {
      if (*(uint *)(lVar4 + 0x14) != param_1) goto LAB_00009b04;
      piVar1 = (int *)(lVar4 + 0x10);
      do {
        cVar2 = '\x01';
        bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
        if (bVar3) {
          *piVar1 = *piVar1 + 1;
          cVar2 = ExclusiveMonitorsStatus();
        }
      } while (cVar2 != '\0');
    }
  }
  else {
LAB_00009b04:
    lVar4 = 0;
  }
  FUN_00004c24(&DAT_000297e8);
LAB_00009b1c:
  FUN_0000c5e8(lVar4);
  return;
}



void FUN_00009b28(long param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  
  piVar1 = (int *)(param_1 + 0x10);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_00009b40(undefined8 param_1)

{
  uint uVar1;
  long lVar2;
  uint uVar3;
  
  uVar1 = (uint)param_1;
  if (uVar1 != 0xfffffffe) {
    if ((uVar1 >> 0xf & 1) != 0) {
      FUN_0000c5e8(0);
      return;
    }
    lVar2 = FUN_000090e4();
    if (lVar2 == 0) {
      uVar3 = 0xffffffff;
    }
    else {
      uVar3 = *(uint *)(lVar2 + 0x14);
    }
    if (uVar3 != uVar1) {
      FUN_00009a98(param_1);
      return;
    }
  }
  FUN_000090e4();
  return;
}



void FUN_00009ba0(void)

{
  long lVar1;
  long unaff_x19;
  
  lVar1 = FUN_0000c600();
  if (lVar1 != unaff_x19) {
    FUN_0000c34c();
  }
  FUN_0000c4cc();
  return;
}



undefined8
FUN_00009bc4(long param_1,int param_2,int param_3,int param_4,undefined4 param_5,int param_6,
            undefined8 param_7,undefined8 param_8,ulong param_9,void *param_10)

{
  int *piVar1;
  long lVar2;
  undefined8 *puVar3;
  char cVar4;
  bool bVar5;
  uint uVar6;
  long lVar7;
  undefined8 *puVar8;
  ulong uVar9;
  undefined8 uVar10;
  pthread_mutex_t *ppVar11;
  pthread_mutex_t pStack_e0;
  pthread_cond_t pStack_a0;
  long local_70;
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  lVar7 = FUN_000090e4();
  if (((lVar7 == 0) || (*(int *)(lVar7 + 0xa8) == 0)) || (*(int *)(lVar7 + 0x14) != param_4)) {
    lVar2 = 0x40;
    if (param_3 == 0) {
      lVar2 = param_9 + 0x40;
    }
    puVar8 = (undefined8 *)_ahpl_malloc(lVar2);
    if (puVar8 == (undefined8 *)0x0) {
                    // WARNING: Subroutine does not return
      _abort();
    }
    *(int *)(puVar8 + 3) = param_4;
    *(undefined4 *)((long)puVar8 + 0x1c) = param_5;
    uVar10 = _ahpl_strdup(param_7);
    puVar8[4] = uVar10;
    puVar8[5] = param_8;
    uVar9 = param_9 | 0x80000000;
    if (param_6 != 0) {
      uVar9 = param_9 >> 3;
    }
    puVar8[6] = uVar9;
    if (param_3 == 0) {
      puVar8[7] = puVar8 + 8;
      if (param_9 != 0) {
        _memcpy(puVar8 + 8,param_10,param_9);
      }
      ppVar11 = (pthread_mutex_t *)0x0;
    }
    else {
      puVar8[7] = param_10;
      ppVar11 = &pStack_e0;
      FUN_00004a38(&pStack_e0);
      FUN_00004c78(&pStack_a0);
      local_70 = 0;
    }
    puVar8[2] = ppVar11;
    uVar9 = FUN_00004aec((pthread_mutex_t *)(param_1 + 0xc0));
    if ((param_2 == 0) && (*(int *)(param_1 + 0xb0) <= *(int *)(param_1 + 0x148))) {
      do {
        if ((*(byte *)(param_1 + 0xac) & 1) != 0) {
          uVar10 = 0xffffffdd;
LAB_00009e20:
          FUN_0000c658(uVar9);
          _free((void *)puVar8[4]);
          _free(puVar8);
          goto LAB_00009dd8;
        }
        if ((lVar7 != 0) && (*(int *)(lVar7 + 0xa4) != 0)) {
          uVar10 = 0xfffffffc;
          goto LAB_00009e20;
        }
        *(int *)(param_1 + 0x130) = *(int *)(param_1 + 0x130) + 1;
        uVar6 = _pthread_cond_wait((pthread_cond_t *)(param_1 + 0x100),
                                   (pthread_mutex_t *)(param_1 + 0xc0));
        uVar9 = (ulong)uVar6;
        *(int *)(param_1 + 0x130) = *(int *)(param_1 + 0x130) + -1;
      } while (*(int *)(param_1 + 0xb0) <= *(int *)(param_1 + 0x148));
    }
    *puVar8 = 0;
    puVar3 = (undefined8 *)(param_1 + 0x138);
    if (*(undefined8 **)(param_1 + 0x140) != (undefined8 *)0x0) {
      puVar3 = *(undefined8 **)(param_1 + 0x140);
    }
    *puVar3 = puVar8;
    *(undefined8 **)(param_1 + 0x140) = puVar8;
    uVar10 = _ahpl_tick_now();
    puVar8[1] = uVar10;
    piVar1 = (int *)(param_1 + 0x148);
    do {
      cVar4 = '\x01';
      bVar5 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar5) {
        *piVar1 = *piVar1 + 1;
        cVar4 = ExclusiveMonitorsStatus();
      }
    } while (cVar4 != '\0');
    FUN_0000c658();
    if (lVar7 != param_1) {
      FUN_0000c5c0();
    }
    if (param_3 != 0) {
      FUN_00004aec(&pStack_e0);
      while (local_70 != 0x99) {
        _pthread_cond_wait(&pStack_a0,&pStack_e0);
      }
      FUN_00004b20(&pStack_e0);
      FUN_0000c61c();
      FUN_00004b3c(&pStack_e0);
    }
    uVar10 = 0;
  }
  else {
    uVar10 = 0xffffffff;
  }
LAB_00009dd8:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
    return uVar10;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00009e40(void)

{
  FUN_0000c6a4();
  FUN_0000c698();
  FUN_00009bc4();
  FUN_0000c45c(0);
  return;
}



undefined8 FUN_00009e70(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long lVar4;
  undefined8 uVar5;
  
  lVar4 = FUN_00009a98();
  if (lVar4 == 0) {
    ___error();
    uVar5 = FUN_0000c4b0(3);
  }
  else {
    FUN_0000c698();
    FUN_00009bc4();
    uVar5 = 0;
    piVar1 = (int *)(lVar4 + 0x10);
    do {
      cVar2 = '\x01';
      bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar3) {
        *piVar1 = *piVar1 + -1;
        cVar2 = ExclusiveMonitorsStatus();
      }
    } while (cVar2 != '\0');
  }
  return uVar5;
}



void FUN_00009f18(void)

{
  long lVar1;
  long *plVar2;
  long unaff_x19;
  long **pplVar3;
  
  lVar1 = FUN_0000c600();
  if (lVar1 != 0) {
    pplVar3 = (long **)(lVar1 + 0x150);
    do {
      plVar2 = *pplVar3;
      if (plVar2 == (long *)0x0) {
        lVar1 = 0;
        goto LAB_00009f50;
      }
      pplVar3 = (long **)(plVar2 + 1);
    } while (*plVar2 != unaff_x19);
    lVar1 = 1;
  }
LAB_00009f50:
  FUN_0000c3e0(lVar1);
  return;
}



void FUN_00009f58(long param_1,undefined4 param_2,long param_3,undefined8 param_4,code *param_5,
                 int *param_6,ulong param_7,undefined8 param_8)

{
  undefined4 uVar1;
  int iVar2;
  code *pcVar3;
  int iVar4;
  int iVar5;
  long lVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  long local_70;
  undefined8 uStack_68;
  
  uVar1 = *(undefined4 *)(param_1 + 0x14c);
  uVar7 = *(undefined8 *)(param_1 + 0x150);
  uVar9 = *(undefined8 *)(param_1 + 0x160);
  uVar8 = *(undefined8 *)(param_1 + 0x158);
  *(undefined4 *)(param_1 + 0x14c) = param_2;
  *(long **)(param_1 + 0x150) = &local_70;
  *(ulong *)(param_1 + 0x158) = param_7;
  *(undefined8 *)(param_1 + 0x160) = param_8;
  local_70 = param_3;
  uStack_68 = uVar7;
  if (DAT_000298e0 == (code *)0x0) {
    iVar4 = 0;
  }
  else {
    iVar4 = _ahpl_tick_us();
  }
  lVar6 = _objc_autoreleasePoolPush();
  (*param_5)(param_6,param_3,param_7 & 0x7fffffff,param_8);
  if (lVar6 != 0) {
    _objc_autoreleasePoolPop(lVar6);
  }
  pcVar3 = DAT_000298e0;
  if (DAT_000298e0 != (code *)0x0) {
    iVar2 = *param_6;
    iVar5 = _ahpl_tick_us();
    (*pcVar3)(param_4,param_3 == 1,iVar4 + iVar2 * -1000,iVar5 - iVar4);
  }
  *(undefined4 *)(param_1 + 0x14c) = uVar1;
  *(undefined8 *)(param_1 + 0x150) = uVar7;
  *(undefined8 *)(param_1 + 0x160) = uVar9;
  *(undefined8 *)(param_1 + 0x158) = uVar8;
  return;
}



void FUN_0000a070(uint param_1,undefined4 *param_2)

{
  long lVar1;
  uint uVar2;
  
  if ((param_1 >> 0xf & 1) == 0) {
    lVar1 = FUN_0000e114();
    if (lVar1 != 0) {
      uVar2 = *(uint *)(lVar1 + 0x130);
      if ((uVar2 >> 0x1e & 1) == 0) {
        FUN_00004bbc(lVar1 + 0x68);
        uVar2 = *(uint *)(lVar1 + 0x130);
      }
      if (-1 < (int)uVar2) {
        if ((uVar2 >> 0x1e & 1) == 0) {
          *param_2 = 1;
        }
        goto LAB_0000a0d8;
      }
      if ((uVar2 >> 0x1e & 1) == 0) {
        FUN_00004c24(lVar1 + 0x68);
      }
      FUN_0000e1e0(lVar1);
    }
    lVar1 = 1;
  }
  else {
    lVar1 = 0;
  }
LAB_0000a0d8:
  FUN_0000c5e8(lVar1);
  return;
}



void FUN_0000a0e4(ulong param_1,int param_2)

{
  if (param_1 < 2) {
    return;
  }
  if (param_2 != 0) {
    FUN_00004c24(param_1 + 0x68);
  }
  FUN_0000e1e0(param_1);
  return;
}



void FUN_0000a11c(undefined4 param_1,undefined8 param_2,int param_3,undefined8 param_4,
                 undefined8 param_5,undefined8 param_6,undefined8 param_7)

{
  int iVar1;
  long lVar2;
  int *piVar3;
  undefined8 local_100;
  undefined8 uStack_f8;
  undefined8 local_f0;
  undefined8 uStack_e8;
  undefined4 local_e0;
  int iStack_dc;
  pthread_mutex_t *local_d8;
  int local_d0;
  undefined auStack_c8 [8];
  pthread_mutex_t pStack_c0;
  pthread_cond_t pStack_80;
  long local_50;
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 - 1U < 1000000) {
    local_100 = param_4;
    uStack_f8 = param_5;
    local_f0 = param_6;
    uStack_e8 = param_7;
    local_e0 = param_1;
    iStack_dc = param_3;
    FUN_00004a38(&pStack_c0);
    FUN_00004c78(&pStack_80);
    local_50 = 0x7b;
    local_d8 = &pStack_c0;
    iVar1 = FUN_0001531c(auStack_c8,param_4,param_2,FUN_0000a27c,&local_100);
    if (iVar1 == 0) {
      FUN_00004aec(&pStack_c0);
      while (local_50 == 0x7b) {
        _pthread_cond_wait(&pStack_80,&pStack_c0);
      }
      FUN_00004b20(&pStack_c0);
      FUN_00004b3c(&pStack_c0);
      FUN_0000c61c();
      lVar2 = local_50;
      if (local_50 == 0) {
        piVar3 = ___error();
        *piVar3 = local_d0;
        lVar2 = local_50;
      }
    }
    else {
      FUN_00004b3c(&pStack_c0);
      FUN_0000c61c();
      _ahpl_log(2,"ahpl: Create thread <%s> failed: error=%d!");
      piVar3 = ___error();
      *piVar3 = -iVar1;
      lVar2 = 0;
    }
  }
  else {
    ___error();
    lVar2 = FUN_0000c638();
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_48) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(lVar2);
}



void FUN_0000a27c(undefined8 *param_1)

{
  int iVar1;
  long lVar2;
  int *piVar3;
  code *pcVar4;
  undefined8 uVar5;
  int iVar6;
  long local_48;
  
  pcVar4 = (code *)param_1[2];
  uVar5 = param_1[3];
  lVar2 = FUN_0000a4ec(*param_1,*(undefined4 *)(param_1 + 4),*(undefined4 *)((long)param_1 + 0x24));
  local_48 = lVar2;
  piVar3 = ___error();
  iVar6 = *piVar3;
  if (lVar2 == 0) {
    if (pcVar4 != (code *)0x0) {
      (*pcVar4)(uVar5);
    }
  }
  else {
    *(undefined8 *)(lVar2 + 0x168) = uVar5;
    FUN_00004a08(DAT_00028c60,lVar2);
    *(long **)(lVar2 + 0x170) = &local_48;
    if (((code *)param_1[1] != (code *)0x0) && (iVar1 = (*(code *)param_1[1])(uVar5), iVar1 < 0)) {
      piVar3 = ___error();
      iVar6 = *piVar3;
      *(undefined8 *)(local_48 + 0xa4) = 0x100000001;
      FUN_0000c660();
      local_48 = 0;
    }
  }
  FUN_00004aec(param_1[5]);
  lVar2 = param_1[5];
  *(long *)(lVar2 + 0x70) = local_48;
  *(int *)(param_1 + 6) = iVar6;
  _pthread_cond_signal((pthread_cond_t *)(lVar2 + 0x40));
  FUN_00004b20(param_1[5]);
  if (local_48 != 0) {
    FUN_0000c6b8();
    FUN_0000c660(local_48);
  }
  return;
}



void _ahpl_mpq_create(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                     undefined8 param_5,undefined8 param_6)

{
  FUN_0000a38c(0,param_1,param_2,param_3,param_4,param_5,param_6);
  return;
}



undefined4 FUN_0000a38c(uint param_1)

{
  int *piVar1;
  long lVar2;
  
  if (param_1 < 0x10000) {
    lVar2 = FUN_0000a11c();
    if (lVar2 != 0) {
      return *(undefined4 *)(lVar2 + 0x14);
    }
  }
  else {
    piVar1 = ___error();
    *piVar1 = 0x16;
  }
  return 0xffffffff;
}



undefined4 _ahpl_mpq_create_flags(uint param_1)

{
  int *piVar1;
  long lVar2;
  
  if (param_1 < 0x10000) {
    lVar2 = FUN_0000a11c();
    if (lVar2 != 0) {
      return *(undefined4 *)(lVar2 + 0x14);
    }
  }
  else {
    piVar1 = ___error();
    *piVar1 = 0x16;
  }
  return 0xffffffff;
}



void _ahpl_mpq_change_flags(undefined8 param_1,int param_2,uint param_3)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_00009b40();
  if (lVar1 == 0) {
    ___error();
    uVar2 = FUN_0000c4b0(0x16);
    goto LAB_0000a450;
  }
  FUN_0000c5b0();
  if (param_2 == 2) {
    param_3 = *(uint *)(lVar1 + 0xac) ^ param_3;
LAB_0000a43c:
    *(uint *)(lVar1 + 0xac) = param_3;
  }
  else {
    if (param_2 == 1) {
      param_3 = *(uint *)(lVar1 + 0xac) & param_3;
      goto LAB_0000a43c;
    }
    if (param_2 == 0) {
      param_3 = *(uint *)(lVar1 + 0xac) | param_3;
      goto LAB_0000a43c;
    }
  }
  FUN_0000c5e0();
  FUN_00009ba0(lVar1);
  uVar2 = 0;
LAB_0000a450:
  FUN_0000c490(uVar2);
  return;
}



void _ahpl_mpq_get_flags(void)

{
  long lVar1;
  ulong unaff_x20;
  
  lVar1 = FUN_00009b40();
  if (lVar1 == 0) {
    ___error();
    FUN_0000c520();
  }
  else {
    FUN_0000c5b0();
    unaff_x20 = (ulong)*(uint *)(lVar1 + 0xac);
    FUN_0000c5e0();
    FUN_00009ba0(lVar1);
  }
  FUN_0000c490(unaff_x20);
  return;
}



void FUN_0000a4a4(void)

{
  long lVar1;
  
  lVar1 = FUN_000090e4();
  if ((lVar1 == 0) && (lVar1 = FUN_0000a4ec(0,4,&DAT_00002710), lVar1 != 0)) {
    FUN_00004a08(DAT_00028c60,lVar1);
  }
  FUN_0000c5e8(lVar1);
  return;
}



void ** FUN_0000a4ec(undefined8 param_1,uint param_2,undefined4 param_3)

{
  ulong uVar1;
  bool bVar2;
  code **ppcVar3;
  uint uVar4;
  ushort uVar5;
  int iVar6;
  undefined4 uVar7;
  int iVar8;
  void **ppvVar9;
  void *pvVar10;
  pthread_t p_Var11;
  ulong uVar12;
  code *pcVar13;
  int *piVar14;
  undefined8 uVar15;
  
  ppvVar9 = (void **)_ahpl_malloc(0x248);
  if (ppvVar9 == (void **)0x0) {
    return (void **)0x0;
  }
  pvVar10 = (void *)_ahpl_strdup(param_1);
  ppcVar3 = (code **)0x28c40;
  if ((param_2 & 4) != 0) {
    ppcVar3 = (code **)&DAT_00028c20;
  }
  *ppvVar9 = pvVar10;
  ppvVar9[1] = ppcVar3;
  iVar6 = (**ppcVar3)(ppvVar9);
  if (iVar6 < 0) goto LAB_0000a8cc;
  *(undefined4 *)((long)ppvVar9 + 0x14) = 0xfffffffe;
  *(undefined4 *)(ppvVar9 + 0x14) = 0;
  *(uint *)((long)ppvVar9 + 0xac) = param_2;
  *(undefined4 *)(ppvVar9 + 0x16) = param_3;
  ppvVar9[0x17] = (void *)0x0;
  ppvVar9[0x44] = (void *)0x0;
  ppvVar9[0x43] = (void *)0x0;
  ppvVar9[0x46] = (void *)0x0;
  ppvVar9[0x45] = (void *)0x0;
  ppvVar9[0x40] = ppvVar9 + 0x40;
  ppvVar9[0x41] = ppvVar9 + 0x40;
  ppvVar9[0x42] = (void *)0x0;
  p_Var11 = _pthread_self();
  ppvVar9[3] = p_Var11;
  uVar7 = FUN_000049d8();
  *(undefined4 *)(ppvVar9 + 4) = uVar7;
  *(undefined8 *)((long)ppvVar9 + 0xa4) = 0;
  FUN_00004a38(ppvVar9 + 0x18);
  FUN_00004c78((pthread_cond_t *)(ppvVar9 + 0x20));
  *(undefined4 *)(ppvVar9 + 0x26) = 0;
  ppvVar9[0x28] = (void *)0x0;
  ppvVar9[0x27] = (void *)0x0;
  *(undefined4 *)(ppvVar9 + 0x29) = 0;
  *(undefined4 *)((long)ppvVar9 + 0x14c) = 0xffffffff;
  ppvVar9[0x33] = (void *)0x0;
  ppvVar9[0x32] = (void *)0x0;
  ppvVar9[0x2b] = (void *)0x0;
  ppvVar9[0x2a] = (void *)0x0;
  ppvVar9[0x2d] = (void *)0x0;
  ppvVar9[0x2c] = (void *)0x0;
  ppvVar9[0x2f] = (void *)0x0;
  ppvVar9[0x2e] = (void *)0x0;
  *(undefined8 *)((long)ppvVar9 + 0x184) = 0;
  *(undefined8 *)((long)ppvVar9 + 0x17c) = 0;
  ppvVar9[0x34] = ppvVar9 + 0x2e;
  ppvVar9[0x36] = (void *)0x0;
  ppvVar9[0x35] = (void *)0x0;
  pvVar10 = (void *)_ahpl_tick_us();
  ppvVar9[0x37] = pvVar10;
  ppvVar9[0x38] = pvVar10;
  ppvVar9[0x3a] = (void *)0x0;
  ppvVar9[0x39] = (void *)0x0;
  uVar7 = _ahpl_tick_now();
  *(undefined4 *)(ppvVar9 + 0x3b) = uVar7;
  *(undefined8 *)((long)ppvVar9 + 0x1dc) = 0;
  *(undefined4 *)(ppvVar9 + 0x3d) = 0;
  *(undefined4 *)(ppvVar9 + 2) = 1;
  ppvVar9[0x48] = (void *)0x0;
  ppvVar9[0x47] = (void *)0x0;
  uVar4 = *(uint *)((long)ppvVar9 + 0xac);
  if ((uVar4 >> 0x1e & 1) != 0) {
    return ppvVar9;
  }
  FUN_00015504(&DAT_000297a0);
  uVar1 = DAT_00028c80;
  pcVar13 = DAT_00028c78;
  uVar12 = FUN_000168b0(DAT_00028c78,DAT_00028c80,0);
  if ((int)uVar12 < (int)uVar1) {
LAB_0000a680:
    FUN_000040d4(uVar12,pcVar13);
    DAT_000298e8 = DAT_000298e8 + 1;
    iVar6 = DAT_000298dc + 1;
    bVar2 = DAT_000298dc == 0;
    DAT_000298dc = iVar6;
    if ((bVar2) && (DAT_000298c0 == 0)) {
      FUN_000095a4();
    }
    if (((uVar4 >> 1 & 1) == 0) &&
       (iVar6 = DAT_0002eb78 + 1, bVar2 = DAT_0002eb78 == 0, DAT_0002eb78 = iVar6, bVar2)) {
      FUN_0000c49c(DAT_000298c0);
    }
    FUN_00015548(&DAT_000297a0);
    iVar6 = (int)uVar12;
    if (-1 < iVar6) {
      if (iVar6 < (int)DAT_00028c80) {
        FUN_00015504(&DAT_000297a0);
        uVar5 = DAT_00028c9c;
        if ((int)DAT_00028c80 <= iVar6) {
LAB_0000a764:
          DAT_00028c9c = uVar5;
          FUN_00015548(&DAT_000297a0);
          return ppvVar9;
        }
        if (*(long *)((long)DAT_00028c88 + (uVar12 & 0xffffffff) * 8) == 0) {
          *(void ***)((long)DAT_00028c88 + (uVar12 & 0xffffffff) * 8) = ppvVar9;
          *(uint *)((long)ppvVar9 + 0x14) = (int)(short)uVar12 | (uint)DAT_00028c9c << 0x10;
          uVar5 = 1;
          if ((DAT_00028c9c + 1 & 0x10000) == 0) {
            uVar5 = DAT_00028c9c + 1;
          }
          goto LAB_0000a764;
        }
        goto LAB_0000a91c;
      }
      uVar15 = 0x31b;
LAB_0000a918:
      FUN_0000c608("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/mpq.c"
                   ,uVar15);
LAB_0000a91c:
                    // WARNING: Subroutine does not return
      _abort();
    }
  }
  else if (uVar1 < 0x800) {
    uVar1 = (uVar1 << 0x20) + 0x4000000000;
    uVar12 = (long)uVar1 >> 0x20;
    pcVar13 = (code *)FUN_00015c6c(uVar12);
    if (pcVar13 == (code *)0x0) {
      FUN_00015548(&DAT_000297a0);
    }
    else {
      pvVar10 = (void *)_ahpl_malloc(uVar1 >> 0x1d);
      if (pvVar10 != (void *)0x0) {
        _memcpy(pcVar13,DAT_00028c78,
                ((long)(DAT_00028c80 << 0x20) >> 3) + 0x7e0000000 >> 0x20 & 0xfffffffffffffff8);
        _memcpy(pvVar10,DAT_00028c88,DAT_00028c80 << 3);
        _bzero((void *)((long)pvVar10 + DAT_00028c80 * 8),(uVar12 - DAT_00028c80) * 8);
        if (DAT_00028c78 != FUN_0002eb80) {
          _free(DAT_00028c78);
          _free(DAT_00028c88);
        }
        DAT_00028c78 = pcVar13;
        DAT_00028c80 = uVar12;
        DAT_00028c88 = pvVar10;
        uVar12 = FUN_000168b0(pcVar13,uVar12,0);
        if ((int)uVar12 < (int)(uVar1 >> 0x20)) goto LAB_0000a680;
        uVar15 = 0x2d4;
        goto LAB_0000a918;
      }
      FUN_00015548(&DAT_000297a0);
      _free(pcVar13);
    }
    uVar12 = 0xfffffff4;
  }
  else {
    FUN_00015548(&DAT_000297a0);
    uVar12 = 0xffffffac;
  }
  iVar6 = (int)uVar12;
  FUN_00004b3c(ppvVar9 + 0x18);
  iVar8 = _pthread_cond_destroy((pthread_cond_t *)(ppvVar9 + 0x20));
  FUN_0000c5d0(iVar8);
LAB_0000a8cc:
  _free(*ppvVar9);
  _free(ppvVar9);
  piVar14 = ___error();
  *piVar14 = -iVar6;
  return (void **)0x0;
}



undefined4 _ahpl_mpq_this(void)

{
  undefined4 uVar1;
  long lVar2;
  
  lVar2 = FUN_000090e4();
  if (lVar2 == 0) {
    uVar1 = 0xffffffff;
  }
  else {
    uVar1 = *(undefined4 *)(lVar2 + 0x14);
  }
  return uVar1;
}



undefined4 _ahpl_mpq_current(void)

{
  undefined4 uVar1;
  long lVar2;
  
  lVar2 = FUN_0000a4a4();
  if (lVar2 == 0) {
    uVar1 = 0xffffffff;
  }
  else {
    uVar1 = *(undefined4 *)(lVar2 + 0x14);
  }
  return uVar1;
}



void _ahpl_mpq_run_func_arg(void)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 *unaff_x19;
  ulong unaff_x20;
  
  lVar1 = FUN_0000c5a4();
  if (lVar1 == 0) {
LAB_0000a9a8:
    ___error();
    uVar2 = 0x16;
  }
  else if (*(long *)(lVar1 + 0x160) == 0) {
    ___error();
    uVar2 = 1;
  }
  else {
    if ((int)*(ulong *)(lVar1 + 0x158) < 0) goto LAB_0000a9a8;
    if (unaff_x20 < *(ulong *)(lVar1 + 0x158)) {
      uVar2 = 0;
      if (unaff_x19 != (undefined8 *)0x0) {
        *unaff_x19 = *(undefined8 *)(*(long *)(lVar1 + 0x160) + unaff_x20 * 8);
      }
      goto LAB_0000a9cc;
    }
    ___error();
    uVar2 = 2;
  }
  uVar2 = FUN_0000c4b0(uVar2);
LAB_0000a9cc:
  FUN_0000c3e0(uVar2);
  return;
}



void _ahpl_mpq_run_func_data(void)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  long *unaff_x19;
  ulong *unaff_x20;
  
  lVar1 = FUN_0000c5a4();
  if (lVar1 == 0) {
LAB_0000a9f8:
    ___error();
    uVar3 = 0x16;
  }
  else {
    lVar2 = *(long *)(lVar1 + 0x160);
    if (lVar2 != 0) {
      if ((int)*(ulong *)(lVar1 + 0x158) < 0) {
        if (unaff_x20 != (ulong *)0x0) {
          *unaff_x20 = *(ulong *)(lVar1 + 0x158) & 0x7fffffff;
        }
        uVar3 = 0;
        if (unaff_x19 != (long *)0x0) {
          *unaff_x19 = lVar2;
        }
        goto LAB_0000aa10;
      }
      goto LAB_0000a9f8;
    }
    ___error();
    uVar3 = 1;
  }
  uVar3 = FUN_0000c4b0(uVar3);
LAB_0000aa10:
  FUN_0000c3e0(uVar3);
  return;
}



ulong _ahpl_mpq_run_func_done_qid(void)

{
  long lVar1;
  ulong uVar2;
  
  lVar1 = FUN_000090e4();
  if (lVar1 == 0) {
    ___error();
    uVar2 = FUN_0000c4b0(0x16);
  }
  else {
    uVar2 = (ulong)*(uint *)(lVar1 + 0x14c);
  }
  return uVar2;
}



undefined8 _ahpl_mpq_running_refobj(ulong param_1)

{
  undefined8 uVar1;
  
  if (param_1 < 2) {
    return 0;
  }
  uVar1 = FUN_00009f18();
  return uVar1;
}



undefined8 _ahpl_mpq_get_q_arg(void)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_000090e4();
  if (lVar1 == 0) {
    ___error();
    uVar2 = FUN_0000c638();
  }
  else {
    uVar2 = *(undefined8 *)(lVar1 + 0x168);
  }
  return uVar2;
}



void _ahpl_mpq_set_q_arg(void)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 unaff_x19;
  
  lVar1 = FUN_0000c600();
  if (lVar1 == 0) {
    ___error();
    uVar2 = FUN_0000c4b0(0x16);
  }
  else {
    uVar2 = 0;
    *(undefined8 *)(lVar1 + 0x168) = unaff_x19;
  }
  FUN_0000c3e0(uVar2);
  return;
}



void FUN_0000aad4(void)

{
  FUN_0000c500();
  FUN_0000aae4();
  return;
}



void FUN_0000aae4(void)

{
  undefined8 **ppuVar1;
  int *piVar2;
  undefined8 uVar3;
  undefined4 *puVar4;
  ulong in_x6;
  undefined8 *in_x7;
  undefined8 *puVar5;
  undefined8 *puVar6;
  undefined4 unaff_w19;
  undefined8 *local_30;
  long local_28;
  
  ppuVar1 = &local_30;
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  local_30 = in_x7;
  if (in_x6 < 0x41) {
    if (in_x6 == 0) {
      puVar5 = (undefined8 *)0x0;
    }
    else {
      ppuVar1 = (undefined8 **)((long)&local_30 - (in_x6 * 8 + 0xf & 0xfffffffffffffff0));
      puVar6 = ppuVar1;
      do {
        uVar3 = *local_30;
        local_30 = local_30 + 1;
        *puVar6 = uVar3;
        in_x6 = in_x6 - 1;
        puVar5 = ppuVar1;
        puVar6 = puVar6 + 1;
      } while (in_x6 != 0);
    }
    ppuVar1[-2] = puVar5;
    uVar3 = FUN_0000c188();
    if ((uint)uVar3 < 0xfffff001) goto LAB_0000ab8c;
    puVar4 = (undefined4 *)FUN_0000c548();
    *puVar4 = unaff_w19;
  }
  else {
    piVar2 = ___error();
    *piVar2 = 7;
  }
  uVar3 = 0xffffffff;
LAB_0000ab8c:
  if (*(long *)PTR____stack_chk_guard_00028030 != local_28) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar3);
  }
  FUN_0000c3e0();
  return;
}



void _ahpl_mpq_queue_args(void)

{
  FUN_0000c390();
  FUN_0000abdc();
  FUN_0000c45c();
  return;
}



void FUN_0000abdc(void)

{
  long lVar1;
  int extraout_w1;
  int unaff_w19;
  undefined8 unaff_x20;
  
  FUN_0000c43c();
  if (extraout_w1 == 0) {
    lVar1 = FUN_00009a98();
  }
  else {
    lVar1 = FUN_00009b40();
  }
  if (lVar1 == 0) {
    ___error();
    FUN_0000c520();
  }
  else {
    FUN_0000c3e8();
    unaff_x20 = FUN_0000aae4();
    if (unaff_w19 == 0) {
      FUN_0000c464();
    }
    else {
      FUN_0000c690();
    }
  }
  FUN_0000c47c(unaff_x20);
  return;
}



void FUN_0000ac44(void)

{
  FUN_0000c4e0();
  FUN_0000aae4();
  return;
}



void _ahpl_mpq_call_args(void)

{
  FUN_0000c3b8();
  FUN_0000abdc();
  FUN_0000c45c();
  return;
}



void _ahpl_mpq_run_args(void)

{
  long lVar1;
  undefined4 uVar2;
  
  lVar1 = FUN_0000c420();
  if (lVar1 == 0) {
    uVar2 = 0xffffffff;
  }
  else {
    uVar2 = *(undefined4 *)(lVar1 + 0x14);
  }
  FUN_0000c364(uVar2);
  FUN_0000abdc();
  FUN_0000c40c();
  return;
}



void _ahpl_mpq_queue(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                    undefined8 param_5,undefined8 param_6)

{
  FUN_0000abdc(param_1,0,0,param_2,param_3,param_4,param_5,param_6,&stack0x00000000,&stack0x00000000
              );
  FUN_0000c45c();
  return;
}



void FUN_0000ace8(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 param_5)

{
  FUN_0000aae4(param_1,1,0xffffffff,param_2,param_3,param_4,param_5,&stack0x00000000);
  FUN_0000c45c();
  return;
}



void _ahpl_mpq_call(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                   undefined8 param_5)

{
  FUN_0000abdc(param_1,1,1,0xffffffff,param_2,param_3,param_4,param_5,&stack0x00000000,
               &stack0x00000000);
  FUN_0000c45c();
  return;
}



void _ahpl_mpq_run(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                  undefined8 param_5)

{
  long lVar1;
  int iVar2;
  
  lVar1 = FUN_000090e4();
  if (lVar1 == 0) {
    iVar2 = -1;
  }
  else {
    iVar2 = *(int *)(lVar1 + 0x14);
  }
  FUN_0000abdc(param_1,1,iVar2 == (int)param_1,0xffffffff,param_2,param_3,param_4,param_5,
               &stack0x00000000);
  FUN_0000c40c();
  return;
}



void FUN_0000ade0(void)

{
  FUN_0000c500();
  FUN_0000adf0();
  return;
}



void FUN_0000adf0(void)

{
  uint uVar1;
  ulong in_x6;
  
  if ((0x40 < in_x6) || (uVar1 = FUN_0000c188(), 0xfffff000 < uVar1)) {
    ___error();
    FUN_0000c4d4();
  }
  FUN_0000c678();
  return;
}



void _ahpl_mpq_queue_argv(void)

{
  FUN_0000c390();
  FUN_0000ae6c();
  FUN_0000c45c();
  return;
}



void FUN_0000ae6c(void)

{
  long lVar1;
  int extraout_w1;
  int unaff_w19;
  undefined8 unaff_x20;
  
  FUN_0000c43c();
  if (extraout_w1 == 0) {
    lVar1 = FUN_00009a98();
  }
  else {
    lVar1 = FUN_00009b40();
  }
  if (lVar1 == 0) {
    ___error();
    FUN_0000c520();
  }
  else {
    FUN_0000c3e8();
    unaff_x20 = FUN_0000adf0();
    if (unaff_w19 == 0) {
      FUN_0000c464();
    }
    else {
      FUN_0000c690();
    }
  }
  FUN_0000c47c(unaff_x20);
  return;
}



void FUN_0000aed4(void)

{
  FUN_0000c4e0();
  FUN_0000adf0();
  return;
}



void _ahpl_mpq_call_argv(void)

{
  FUN_0000c3b8();
  FUN_0000ae6c();
  FUN_0000c45c();
  return;
}



void _ahpl_mpq_run_argv(void)

{
  long lVar1;
  undefined4 uVar2;
  
  lVar1 = FUN_0000c420();
  if (lVar1 == 0) {
    uVar2 = 0xffffffff;
  }
  else {
    uVar2 = *(undefined4 *)(lVar1 + 0x14);
  }
  FUN_0000c364(uVar2);
  FUN_0000ae6c();
  FUN_0000c40c();
  return;
}



void FUN_0000af3c(void)

{
  FUN_0000c500();
  FUN_0000af4c();
  return;
}



void FUN_0000af4c(void)

{
  uint uVar1;
  undefined *in_x6;
  
  if ((&UNK_00002001 <= in_x6) || (uVar1 = FUN_0000c188(), 0xfffff000 < uVar1)) {
    ___error();
    FUN_0000c4d4();
  }
  FUN_0000c678();
  return;
}



void _ahpl_mpq_queue_data(void)

{
  FUN_0000c390();
  FUN_0000afc4();
  FUN_0000c45c();
  return;
}



void FUN_0000afc4(void)

{
  long lVar1;
  int extraout_w1;
  int unaff_w19;
  undefined8 unaff_x20;
  
  FUN_0000c43c();
  if (extraout_w1 == 0) {
    lVar1 = FUN_00009a98();
  }
  else {
    lVar1 = FUN_00009b40();
  }
  if (lVar1 == 0) {
    ___error();
    FUN_0000c520();
  }
  else {
    FUN_0000c3e8();
    unaff_x20 = FUN_0000af4c();
    if (unaff_w19 == 0) {
      FUN_0000c464();
    }
    else {
      FUN_0000c690();
    }
  }
  FUN_0000c47c(unaff_x20);
  return;
}



void FUN_0000b02c(void)

{
  FUN_0000c4e0();
  FUN_0000af4c();
  return;
}



void _ahpl_mpq_call_data(void)

{
  FUN_0000c3b8();
  FUN_0000afc4();
  FUN_0000c45c();
  return;
}



void _ahpl_mpq_run_data(void)

{
  long lVar1;
  undefined4 uVar2;
  
  lVar1 = FUN_0000c420();
  if (lVar1 == 0) {
    uVar2 = 0xffffffff;
  }
  else {
    uVar2 = *(undefined4 *)(lVar1 + 0x14);
  }
  FUN_0000c364(uVar2);
  FUN_0000afc4();
  FUN_0000c40c();
  return;
}



void _ahpl_mpq_queued_count(void)

{
  long lVar1;
  int *piVar2;
  undefined4 uVar3;
  
  lVar1 = FUN_00009b40();
  if (lVar1 == 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar3 = 0xffffffff;
  }
  else {
    uVar3 = *(undefined4 *)(lVar1 + 0x148);
    FUN_00009ba0();
  }
  FUN_0000c3e0(uVar3);
  return;
}



void _ahpl_mpq_last_costs(void)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 *unaff_x19;
  undefined8 *unaff_x20;
  
  lVar1 = FUN_0000c5a4();
  if (lVar1 == 0) {
    ___error();
    uVar2 = FUN_0000c4b0(0x16);
  }
  else {
    if (unaff_x20 != (undefined8 *)0x0) {
      *unaff_x20 = *(undefined8 *)(lVar1 + 0x1c8);
    }
    uVar2 = 0;
    if (unaff_x19 != (undefined8 *)0x0) {
      *unaff_x19 = *(undefined8 *)(lVar1 + 0x1d0);
    }
  }
  FUN_0000c3e0(uVar2);
  return;
}



void _ahpl_mpq_exec_counters(undefined8 *param_1,undefined8 *param_2,undefined8 *param_3)

{
  long lVar1;
  int *piVar2;
  undefined8 uVar3;
  
  lVar1 = FUN_000090e4();
  if (lVar1 == 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar3 = 0xffffffff;
  }
  else {
    if (param_1 != (undefined8 *)0x0) {
      *param_1 = *(undefined8 *)(lVar1 + 0x1a8);
    }
    if (param_2 != (undefined8 *)0x0) {
      *param_2 = *(undefined8 *)(lVar1 + 0x1b0);
    }
    if (param_3 == (undefined8 *)0x0) {
      uVar3 = 0;
    }
    else if ((*(byte *)(lVar1 + 0xac) >> 2 & 1) == 0) {
      uVar3 = 0;
      *param_3 = 0;
    }
    else {
      uVar3 = 0;
      *param_3 = *(undefined8 *)(lVar1 + 0x50);
    }
  }
  FUN_0000c490(uVar3);
  return;
}



void _ahpl_mpq_loop(void)

{
  long lVar1;
  
  lVar1 = FUN_000090e4();
  if (lVar1 != 0) {
    FUN_0000c6b8();
    FUN_0000b278(lVar1,0,0);
  }
  return;
}



void FUN_0000b1dc(long param_1)

{
  uint uVar1;
  int iVar2;
  long lVar3;
  ulong uVar4;
  long lVar5;
  
  while( true ) {
    uVar1 = FUN_0000c5b8();
    if (0 < (int)uVar1) {
      *(ulong *)(param_1 + 0x1a8) = *(long *)(param_1 + 0x1a8) + (ulong)uVar1;
    }
    uVar1 = FUN_00007a04(param_1);
    if (0 < (int)uVar1) {
      *(ulong *)(param_1 + 0x1b0) = *(long *)(param_1 + 0x1b0) + (ulong)uVar1;
    }
    if (*(int *)(param_1 + 0xa4) != 0) break;
    if (*(long *)(param_1 + 0x230) == 0) {
      uVar4 = 0xffffffffffffffff;
    }
    else {
      lVar5 = *(long *)(*(long *)(param_1 + 0x230) + 0x50);
      lVar3 = _ahpl_tick_now();
      uVar4 = lVar5 - lVar3;
      uVar4 = uVar4 & ((long)uVar4 >> 0x3f ^ 0xffffffffffffffffU);
    }
    iVar2 = (**(code **)(*(long *)(param_1 + 8) + 0x10))(param_1,uVar4);
    if (iVar2 < 0) {
      _ahpl_msleep(0x5dc);
                    // WARNING: Subroutine does not return
      _abort();
    }
  }
  *(undefined4 *)(param_1 + 0xa8) = 1;
  FUN_0000c4cc();
  return;
}



void FUN_0000b278(void **param_1,code *param_2,undefined8 param_3)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  undefined8 uVar4;
  long lVar5;
  long *plVar6;
  
  uVar3 = *(uint *)((long)param_1 + 0x14);
  if ((uVar3 >> 0xf & 1) == 0) {
    if ((uVar3 >> 0xf & 1) != 0) {
      uVar4 = 0x335;
      goto LAB_0000b4b8;
    }
    uVar3 = (uint)(short)uVar3;
    if ((int)DAT_00028c80 <= (int)uVar3) {
      uVar4 = 0x337;
      goto LAB_0000b4b8;
    }
    FUN_00015504(&DAT_000297a0);
    if (*(void ***)(DAT_00028c88 + (ulong)uVar3 * 8) == param_1) {
      *(undefined8 *)(DAT_00028c88 + (ulong)uVar3 * 8) = 0;
    }
    FUN_00015548(&DAT_000297a0);
  }
  iVar2 = *(int *)(param_1 + 2);
  while (1 < iVar2) {
    iVar2 = FUN_0000c5b8();
    if (iVar2 == 0) {
      FUN_0000c630();
    }
    iVar2 = *(int *)(param_1 + 2);
  }
  do {
    iVar2 = FUN_0000c5b8();
  } while (iVar2 != 0);
  if (param_2 != (code *)0x0) {
    (*param_2)(param_3);
  }
  FUN_00004a08(DAT_00028c60,0);
  plVar6 = (long *)param_1[0x47];
  FUN_0000c5d0();
  FUN_0000787c(param_1);
  FUN_00004b3c(param_1 + 0x18);
  _pthread_cond_destroy((pthread_cond_t *)(param_1 + 0x20));
  _free(param_1[0x17]);
  uVar3 = *(uint *)((long)param_1 + 0x14);
  if ((uVar3 >> 0xf & 1) == 0) {
    if (((uint)((int)DAT_00028c80 <= (short)uVar3) | (uVar3 << 0x10) >> 0x1f) != 0) {
      uVar4 = 0x2ea;
LAB_0000b4b8:
      FUN_0000c608("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/mpq.c"
                   ,uVar4);
      lVar5 = FUN_000090e4();
      if ((lVar5 == 0) || (*(int *)(lVar5 + 0xa4) != 0)) {
        ___error();
        FUN_0000c4d4();
      }
      else {
        uVar3 = FUN_0000c5b8();
        if (0 < (int)uVar3) {
          *(ulong *)(lVar5 + 0x1a8) = *(long *)(lVar5 + 0x1a8) + (ulong)uVar3;
        }
      }
      FUN_0000c3e0();
      return;
    }
    uVar1 = *(uint *)((long)param_1 + 0xac);
    FUN_00015504(&DAT_000297a0);
    FUN_000040ac((int)(short)uVar3,DAT_00028c78);
    if (((uVar1 >> 1 & 1) == 0) && (DAT_0002eb78 = DAT_0002eb78 + -1, DAT_0002eb78 == 0)) {
      FUN_0000c49c(DAT_000298c0);
    }
    DAT_000298e8 = DAT_000298e8 + -1;
    DAT_000298dc = DAT_000298dc - 1;
    if ((DAT_000298b0 | DAT_000298dc) == 0) {
      FUN_00009688();
    }
    FUN_00015548(&DAT_000297a0);
    if (*(int *)((long)param_1 + 0x14) == DAT_00028c94) {
      DAT_00028c94 = -1;
      FUN_0000d044();
    }
  }
  _free(*param_1);
  _free(param_1);
  while (plVar6 != (long *)0x0) {
    lVar5 = *plVar6;
    FUN_00004aec(plVar6 + 2);
    plVar6[0x10] = (long)&section_000001a8.addr;
    _pthread_cond_broadcast((pthread_cond_t *)(plVar6 + 10));
    FUN_00004b20(plVar6 + 2);
    plVar6 = (long *)lVar5;
  }
  return;
}



void _ahpl_mpq_itc_ack(void)

{
  uint uVar1;
  long lVar2;
  
  lVar2 = FUN_000090e4();
  if ((lVar2 == 0) || (*(int *)(lVar2 + 0xa4) != 0)) {
    ___error();
    FUN_0000c4d4();
  }
  else {
    uVar1 = FUN_0000c5b8();
    if (0 < (int)uVar1) {
      *(ulong *)(lVar2 + 0x1a8) = *(long *)(lVar2 + 0x1a8) + (ulong)uVar1;
    }
  }
  FUN_0000c3e0();
  return;
}



int FUN_0000b514(long param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  undefined4 uVar4;
  int iVar5;
  uint uVar6;
  long lVar7;
  undefined8 uVar8;
  long *plVar9;
  int iVar10;
  ulong uVar11;
  long *plVar12;
  long lVar13;
  undefined4 local_64;
  
  uVar4 = _ahpl_tick_now();
  *(undefined4 *)(param_1 + 0x1d8) = uVar4;
  if (*(long *)(param_1 + 0x138) != 0) {
    FUN_0000c5b0();
    plVar12 = *(long **)(param_1 + 0x138);
    *(undefined8 *)(param_1 + 0x138) = 0;
    *(undefined8 *)(param_1 + 0x140) = 0;
    FUN_0000c5e0();
    if (plVar12 != (long *)0x0) {
      iVar10 = 0;
      do {
        plVar9 = (long *)*plVar12;
        lVar13 = plVar12[2];
        uVar6 = *(uint *)(plVar12 + 3);
        uVar11 = plVar12[6];
        local_64 = 0;
        lVar7 = FUN_0000a070(*(undefined4 *)((long)plVar12 + 0x1c),&local_64);
        FUN_0000c530(param_1,uVar6,lVar7);
        FUN_0000a0e4(lVar7,local_64);
        if (((uVar6 >> 0xf & 1) == 0) && (lVar7 != 1)) {
          lVar7 = FUN_00009a98(uVar6);
          if (lVar7 == 0) {
            FUN_0000c530(param_1,0xffffffff,1);
          }
          else {
            if ((int)uVar11 < 0) {
              FUN_0000c588(uVar11 & 0x7fffffff);
            }
            else {
              FUN_0000c588(uVar11 << 3);
            }
            FUN_00009bc4();
            piVar1 = (int *)(lVar7 + 0x10);
            do {
              cVar2 = '\x01';
              bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
              if (bVar3) {
                *piVar1 = *piVar1 + -1;
                cVar2 = ExclusiveMonitorsStatus();
              }
            } while (cVar2 != '\0');
          }
        }
        lVar7 = *(long *)(param_1 + 0x1a0);
        uVar8 = *(undefined8 *)(lVar7 + 8);
        *(undefined8 *)(lVar7 + 8) = 0;
        FUN_0000f048(uVar8,0);
        *(undefined8 *)(lVar7 + 0x10) = 0;
        *(undefined4 *)(lVar7 + 0x18) = 0;
        if (*(long *)(lVar7 + 0x20) != 0) {
          FUN_0000f214(*(long *)(lVar7 + 0x20),0);
          *(undefined8 *)(lVar7 + 0x20) = 0;
        }
        *(undefined8 *)(lVar7 + 0x28) = 0;
        _free((void *)plVar12[4]);
        _free(plVar12);
        piVar1 = (int *)(param_1 + 0x148);
        do {
          cVar2 = '\x01';
          bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
          if (bVar3) {
            *piVar1 = *piVar1 + -1;
            cVar2 = ExclusiveMonitorsStatus();
          }
        } while (cVar2 != '\0');
        if (lVar13 != 0) {
          FUN_00004aec(lVar13);
          *(undefined8 *)(lVar13 + 0x70) = 0x99;
          iVar5 = _pthread_cond_signal((pthread_cond_t *)(lVar13 + 0x40));
          FUN_0000c658(iVar5);
        }
        iVar10 = iVar10 + 1;
        uVar4 = _ahpl_tick_now();
        *(undefined4 *)(param_1 + 0x1d8) = uVar4;
        uVar11 = FUN_0000c5b0();
        if (0 < *(int *)(param_1 + 0x130)) {
          uVar6 = _pthread_cond_signal((pthread_cond_t *)(param_1 + 0x100));
          uVar11 = (ulong)uVar6;
        }
        FUN_0000c5e0(uVar11);
        plVar12 = plVar9;
      } while (plVar9 != (long *)0x0);
      return iVar10;
    }
  }
  return 0;
}



bool _ahpl_mpq_is_main(void)

{
  bool bVar1;
  long lVar2;
  
  lVar2 = FUN_000090e4();
  bVar1 = false;
  if ((lVar2 != 0) && ((DAT_00028c94 >> 0xf & 1) == 0)) {
    bVar1 = *(uint *)(lVar2 + 0x14) == DAT_00028c94;
  }
  return bVar1;
}



void FUN_0000b750(long param_1)

{
  long lVar1;
  
  lVar1 = FUN_000090e4();
  *(undefined4 *)(param_1 + 0xa4) = 1;
  if (lVar1 != param_1) {
    FUN_0000c5c0();
  }
  if (lVar1 != 0) {
    FUN_00004aec(lVar1 + 0xc0);
    if (0 < *(int *)(lVar1 + 0x130)) {
      if (*(int *)(lVar1 + 0x130) == 1) {
        _pthread_cond_signal((pthread_cond_t *)(lVar1 + 0x100));
      }
      else {
        _pthread_cond_broadcast((pthread_cond_t *)(lVar1 + 0x100));
      }
    }
    FUN_00004b20(lVar1 + 0xc0);
    return;
  }
  FUN_0000c4cc();
  return;
}



void _ahpl_mpq_destroy(undefined8 param_1)

{
  FUN_0000b7cc(param_1,1);
  return;
}



void FUN_0000b7cc(undefined8 param_1,int param_2)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_00009a98();
  if (lVar1 == 0) {
    ___error();
    uVar2 = 0x16;
  }
  else {
    if ((param_2 == 0) || (-1 < *(int *)(lVar1 + 0xac))) {
      FUN_0000c614();
      FUN_0000c34c(0);
      goto LAB_0000b820;
    }
    FUN_0000c34c();
    ___error();
    uVar2 = 1;
  }
  FUN_0000c4b0(uVar2);
LAB_0000b820:
  FUN_0000c3e0();
  return;
}



void FUN_0000b828(long param_1,undefined8 *param_2)

{
  undefined8 *puVar1;
  
  FUN_00004a38(param_2 + 2);
  FUN_00004c78(param_2 + 10);
  param_2[0x10] = 0;
  *param_2 = 0;
  param_2[1] = *(undefined8 *)(param_1 + 0x18);
  FUN_0000c5b0();
  puVar1 = (undefined8 *)(param_1 + 0x238);
  if (*(undefined8 **)(param_1 + 0x240) != (undefined8 *)0x0) {
    puVar1 = *(undefined8 **)(param_1 + 0x240);
  }
  *puVar1 = param_2;
  *(undefined8 **)(param_1 + 0x240) = param_2;
  FUN_00004b20(param_1 + 0xc0);
  return;
}



void FUN_0000b894(long param_1)

{
  pthread_mutex_t *ppVar1;
  
  ppVar1 = (pthread_mutex_t *)(param_1 + 0x10);
  FUN_00004aec(ppVar1);
  while (*(long *)(param_1 + 0x80) != 0x1c8) {
    _pthread_cond_wait((pthread_cond_t *)(param_1 + 0x50),ppVar1);
  }
  FUN_00004b20(ppVar1);
  _pthread_cond_destroy((pthread_cond_t *)(param_1 + 0x50));
  FUN_00004b3c(ppVar1);
  FUN_0000c490(0);
  return;
}



void _ahpl_mpq_destroy_wait(undefined4 param_1)

{
  uint uVar1;
  
  uVar1 = FUN_0000b92c(param_1,1,1);
  if (0xfffff000 < uVar1) {
    FUN_0000c548();
    FUN_0000c4d4();
  }
  FUN_0000c3e0();
  return;
}



void FUN_0000b92c(undefined8 param_1,int param_2,int param_3)

{
  long lVar1;
  undefined8 uVar2;
  long unaff_x19;
  undefined auStack_c0 [136];
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  lVar1 = FUN_00009a98();
  if (lVar1 == 0) {
    uVar2 = 0xffffffea;
  }
  else {
    lVar1 = FUN_0000c600();
    if (unaff_x19 == lVar1) {
      FUN_0000c34c();
      uVar2 = 0xfffffff0;
    }
    else if (((param_2 == 0) || (param_3 == 0)) || (-1 < *(int *)(unaff_x19 + 0xac))) {
      FUN_0000c624();
      if (param_2 != 0) {
        FUN_0000c614();
      }
      FUN_0000c34c();
      FUN_0000b894(auStack_c0);
      uVar2 = 0;
    }
    else {
      FUN_0000c34c();
      uVar2 = 0xffffffff;
    }
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



void _ahpl_mpq_wait(undefined4 param_1)

{
  uint uVar1;
  
  uVar1 = FUN_0000b92c(param_1,0,1);
  if (0xfffff000 < uVar1) {
    FUN_0000c548();
    FUN_0000c4d4();
  }
  FUN_0000c3e0();
  return;
}



undefined8
_ahpl_main_start(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  int *piVar4;
  long lVar5;
  
  do {
    iVar3 = DAT_00028c94;
    if (DAT_00028c94 != -1) break;
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(0x28c94,0x10);
    if (bVar2) {
      DAT_00028c94 = 0;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  if (iVar3 == -1) {
    lVar5 = FUN_0000a11c(0x80000005,param_1,100000,"ahpl_main",param_2,param_3,param_4);
    if (lVar5 != 0) {
      DAT_00028c94 = *(undefined4 *)(lVar5 + 0x14);
      do {
        iVar3 = DAT_0002e770;
        if (DAT_0002e770 != 0) break;
        cVar1 = '\x01';
        bVar2 = (bool)ExclusiveMonitorPass(0x2e770,0x10);
        if (bVar2) {
          DAT_0002e770 = 1;
          cVar1 = ExclusiveMonitorsStatus();
        }
      } while (cVar1 != '\0');
      if (iVar3 == 0) {
        _atexit(_ahpl_main_exit_wait);
      }
      return 0;
    }
  }
  else {
    piVar4 = ___error();
    *piVar4 = 0x11;
  }
  return 0xffffffff;
}



void _ahpl_main_exit_wait(void)

{
  uint uVar1;
  
  FUN_0000c698(DAT_00028c94);
  uVar1 = FUN_0000b92c();
  if (0xfffff000 < uVar1) {
    FUN_0000c548();
    FUN_0000c4d4();
  }
  FUN_0000c3e0();
  return;
}



undefined4 _ahpl_mpq_main(void)

{
  undefined4 uVar1;
  
  uVar1 = DAT_00028c94;
  if ((short)DAT_00028c94 < 0) {
    uVar1 = 0xffffffff;
  }
  return uVar1;
}



void _ahpl_main_exit(void)

{
  FUN_0000b7cc(DAT_00028c94,0);
  return;
}



void _ahpl_main_exit_wait(void)

{
  uint uVar1;
  
  FUN_0000c698(DAT_00028c94);
  uVar1 = FUN_0000b92c();
  if (0xfffff000 < uVar1) {
    FUN_0000c548();
    FUN_0000c4d4();
  }
  FUN_0000c3e0();
  return;
}



void _ahpl_main_wait(void)

{
  uint uVar1;
  
  uVar1 = FUN_0000b92c(DAT_00028c94,0,0);
  if (0xfffff000 < uVar1) {
    FUN_0000c548();
    FUN_0000c4d4();
  }
  FUN_0000c3e0();
  return;
}



void _ahpl_shrink_resources(void)

{
  FUN_0000dba4(DAT_000298f8);
  FUN_0000dba4(DAT_00029900);
  FUN_0000dba4(DAT_000298f0);
  FUN_0000d084(DAT_00029908,0);
  return;
}



void FUN_0000bb80(void)

{
  long lVar1;
  
  lVar1 = FUN_000090e4();
  if (lVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_0000bb9c(void)

{
  int iVar1;
  
  FUN_00005a90();
  FUN_000171e8();
  FUN_0000dd64();
  FUN_0000dce0();
  FUN_00007708();
  FUN_0000dd28();
  FUN_00006328();
  _bzero(&DAT_0002e778,0x400);
  FUN_000154dc(&DAT_000297a0);
  FUN_000154dc(&DAT_00029690);
  iVar1 = FUN_000049ec(&DAT_00028c60);
  if (iVar1 == 0) {
    FUN_0000ca48();
    FUN_00017e60();
    FUN_00013380();
    FUN_00014af4();
    FUN_00005e24();
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_0000bc14(void)

{
  FUN_0000bc38(0,0,0,0);
  FUN_000098cc();
  return;
}



void FUN_0000bc38(void)

{
  if ((DAT_00028c98 >> 0xf & 1) == 0) {
    _ahpl_mpq_kill_timer();
    DAT_00028c98 = 0xffffffff;
  }
  FUN_0000c4cc();
  return;
}



void FUN_0000bc64(undefined8 param_1,long *param_2)

{
  undefined4 *puVar1;
  int iVar2;
  long lVar3;
  ulong uVar4;
  undefined8 uVar5;
  ulong uVar6;
  
  lVar3 = FUN_000090e4();
  iVar2 = FUN_00004bd8(&DAT_000297e8);
  uVar5 = DAT_00028c78;
  uVar6 = DAT_00028c80;
  while (DAT_00028c78 = uVar5, DAT_00028c80 = uVar6, iVar2 == 0) {
    if (*(int *)(lVar3 + 0xa4) != 0) goto LAB_0000bd54;
    FUN_0000c630();
    iVar2 = FUN_00004bd8(&DAT_000297e8);
    uVar5 = DAT_00028c78;
    uVar6 = DAT_00028c80;
  }
  uVar4 = FUN_0000c580(uVar5,uVar6);
  if (uVar4 < uVar6) {
    do {
      lVar3 = *(long *)(DAT_00028c88 + uVar4 * 8);
      if (lVar3 != 0) {
        FUN_0000bdf8(*(undefined4 *)(lVar3 + 0x20),lVar3,lVar3 + 0x1e8,1);
        uVar6 = DAT_00028c80;
        uVar5 = DAT_00028c78;
      }
      uVar4 = FUN_000167ec(uVar5,uVar6,uVar4 + 1);
    } while (uVar4 < uVar6);
  }
  if (DAT_000298b0 != 0) {
    lVar3 = 0;
    uVar6 = 0;
    do {
      puVar1 = (undefined4 *)(DAT_000298b8 + lVar3);
      FUN_0000bdf8(*puVar1,0,puVar1 + 4,puVar1[1]);
      uVar6 = uVar6 + 1;
      lVar3 = lVar3 + 0x28;
    } while (uVar6 < DAT_000298b0);
  }
  FUN_00004c24(&DAT_000297e8);
LAB_0000bd54:
  if ((0 < DAT_000298d0 - DAT_000298c8) && (-1 < *param_2 - DAT_000298d0)) {
    _ahpl_mpq_kill_timer(DAT_00028c90);
    DAT_00028c90 = 0xffffffff;
    DAT_000298d0 = *param_2;
    FUN_00009928(FUN_0000be78,0);
    return;
  }
  return;
}



void FUN_0000bdf8(undefined8 param_1,long param_2,int *param_3,undefined8 param_4)

{
  long lVar1;
  
  if (*param_3 == 0) {
    FUN_00004f08(param_1,0,param_3 + 2,param_3 + 4);
    *param_3 = 1;
  }
  if (((param_2 == 0) || (*(int *)(param_2 + 0xa0) == 0)) &&
     (lVar1 = FUN_00004de4(param_1), lVar1 != 0)) {
    FUN_00014214(lVar1,param_4);
    return;
  }
  return;
}



void FUN_0000be78(void)

{
  int *in_x3;
  long local_30;
  long local_28;
  
  if (*in_x3 == 1) {
    FUN_0000c4bc();
    *(long *)(in_x3 + 2) = local_28 - *(long *)(in_x3 + 2);
    *(long *)(in_x3 + 4) = local_30 - *(long *)(in_x3 + 4);
    *in_x3 = 2;
  }
  else {
    *in_x3 = 0;
  }
  FUN_0000c684();
  return;
}



void FUN_0000bed0(void)

{
  if (DAT_00028c98._1_1_ < '\0') {
    DAT_00028c98 = FUN_0000c64c(1000,thunk_FUN_0000bf10);
    if ((DAT_00028c98 >> 0xf & 1) != 0) {
                    // WARNING: Subroutine does not return
      _abort();
    }
  }
  return;
}



void thunk_FUN_0000bf10(void)

{
  uint uVar1;
  size_t sVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  long lVar6;
  ulong uVar7;
  ulong uVar8;
  char *pcVar9;
  uint uVar10;
  undefined *puVar11;
  char **ppcVar12;
  undefined8 *puVar13;
  char **ppcVar14;
  char *pcStack_70;
  long lStack_68;
  
  ppcVar12 = &pcStack_70;
  lStack_68 = *(long *)PTR____stack_chk_guard_00028030;
  iVar5 = FUN_00005d18();
  if (iVar5 == 0) {
    lVar6 = FUN_000090e4();
    iVar5 = FUN_00004bd8(&DAT_000297e8);
    while (iVar5 == 0) {
      if (*(int *)(lVar6 + 0xa4) != 0) goto LAB_0000c128;
      FUN_0000c630();
      iVar5 = FUN_00004bd8(&DAT_000297e8);
    }
    iVar5 = _ahpl_tick_now();
    uVar8 = DAT_00028c80;
    uVar7 = FUN_0000c580(DAT_00028c78,DAT_00028c80);
    if (uVar7 < uVar8) {
      uVar10 = 0;
      puVar11 = (undefined *)0x0;
      lVar6 = 0;
      do {
        ppcVar14 = *(char ***)(DAT_00028c88 + uVar7 * 8);
        if ((ppcVar14 != (char **)0x0) && ((*(byte *)((long)ppcVar14 + 0xac) >> 1 & 1) == 0)) {
          DataMemoryBarrier(2,1);
          iVar3 = *(int *)(ppcVar14 + 0x3b);
          if ((*(int *)(ppcVar14 + 0x14) == 0) && (iVar3 == *(int *)((long)ppcVar14 + 0x1dc))) {
            uVar1 = *(int *)(ppcVar14 + 0x3c) + 1;
            *(uint *)(ppcVar14 + 0x3c) = uVar1;
            uVar4 = iVar5 - iVar3;
            if (8999 < (int)uVar4 && 8 < uVar1) {
              pcVar9 = *ppcVar14;
              *(ulong *)((long)ppcVar12 + -0x18) = (ulong)uVar1;
              *(char **)((long)ppcVar12 + -0x10) = (char *)(ulong)uVar4;
              *(char **)((long)ppcVar12 + -0x20) = pcVar9;
              pcStack_70 = (char *)(ulong)uVar4;
              _ahpl_log(2,
                        "ahpl: System stalling detected: thread<%s> stalled for %d calc cycles, at least %dms!"
                       );
              *(undefined4 *)(ppcVar14 + 0x3c) = 0;
              uVar1 = (uint)pcStack_70 / 1000;
              if (uVar1 <= uVar10) {
                uVar1 = uVar10;
              }
              if (puVar11 == (undefined *)0x0) {
                ppcVar12 = (char **)((long)ppcVar12 + -0x400);
                *(undefined *)ppcVar12 = 0;
                puVar11 = (undefined *)ppcVar12;
              }
              uVar10 = uVar1;
              if (((int)lVar6 < 0x3fe) && (pcVar9 = *ppcVar14, pcVar9 != (char *)0x0)) {
                pcStack_70 = pcVar9;
                uVar8 = _strlen(pcVar9);
                if (0x1f < uVar8) {
                  uVar8 = 0x20;
                }
                sVar2 = 0x3feU - lVar6;
                if (uVar8 <= 0x3feU - lVar6) {
                  sVar2 = uVar8;
                }
                if (sVar2 != 0) {
                  _strncpy(puVar11 + lVar6,pcStack_70,sVar2);
                  *(undefined2 *)(puVar11 + sVar2 + lVar6) = 0x3b;
                  lVar6 = sVar2 + lVar6 + 1;
                }
              }
            }
          }
          else {
            *(int *)((long)ppcVar14 + 0x1dc) = iVar3;
            *(undefined4 *)(ppcVar14 + 0x3c) = 0;
          }
        }
        uVar8 = DAT_00028c80;
        uVar7 = FUN_000167ec(DAT_00028c78,DAT_00028c80,uVar7 + 1);
      } while (uVar7 < uVar8);
      FUN_00004c24(&DAT_000297e8);
      if (puVar11 == (undefined *)0x0) goto LAB_0000c128;
      FUN_00004bbc(&DAT_000296d8);
      for (puVar13 = DAT_00028c68; (undefined8 **)puVar13 != &DAT_00028c68;
          puVar13 = (undefined8 *)*puVar13) {
        (*(code *)puVar13[2])(uVar10,puVar11);
      }
      puVar11 = &DAT_000296d8;
    }
    else {
      puVar11 = &DAT_000297e8;
    }
    FUN_00004c24(puVar11);
  }
LAB_0000c128:
  if (*(long *)PTR____stack_chk_guard_00028030 == lStack_68) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_0000bf10(void)

{
  uint uVar1;
  size_t sVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  long lVar6;
  ulong uVar7;
  ulong uVar8;
  char *pcVar9;
  uint uVar10;
  undefined *puVar11;
  char **ppcVar12;
  undefined8 *puVar13;
  char **ppcVar14;
  char *local_70;
  long local_68;
  
  ppcVar12 = &local_70;
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  iVar5 = FUN_00005d18();
  if (iVar5 == 0) {
    lVar6 = FUN_000090e4();
    iVar5 = FUN_00004bd8(&DAT_000297e8);
    while (iVar5 == 0) {
      if (*(int *)(lVar6 + 0xa4) != 0) goto LAB_0000c128;
      FUN_0000c630();
      iVar5 = FUN_00004bd8(&DAT_000297e8);
    }
    iVar5 = _ahpl_tick_now();
    uVar8 = DAT_00028c80;
    uVar7 = FUN_0000c580(DAT_00028c78,DAT_00028c80);
    if (uVar7 < uVar8) {
      uVar10 = 0;
      puVar11 = (undefined *)0x0;
      lVar6 = 0;
      do {
        ppcVar14 = *(char ***)(DAT_00028c88 + uVar7 * 8);
        if ((ppcVar14 != (char **)0x0) && ((*(byte *)((long)ppcVar14 + 0xac) >> 1 & 1) == 0)) {
          DataMemoryBarrier(2,1);
          iVar3 = *(int *)(ppcVar14 + 0x3b);
          if ((*(int *)(ppcVar14 + 0x14) == 0) && (iVar3 == *(int *)((long)ppcVar14 + 0x1dc))) {
            uVar1 = *(int *)(ppcVar14 + 0x3c) + 1;
            *(uint *)(ppcVar14 + 0x3c) = uVar1;
            uVar4 = iVar5 - iVar3;
            if (8999 < (int)uVar4 && 8 < uVar1) {
              pcVar9 = *ppcVar14;
              *(ulong *)((long)ppcVar12 + -0x18) = (ulong)uVar1;
              *(char **)((long)ppcVar12 + -0x10) = (char *)(ulong)uVar4;
              *(char **)((long)ppcVar12 + -0x20) = pcVar9;
              local_70 = (char *)(ulong)uVar4;
              _ahpl_log(2,
                        "ahpl: System stalling detected: thread<%s> stalled for %d calc cycles, at least %dms!"
                       );
              *(undefined4 *)(ppcVar14 + 0x3c) = 0;
              uVar1 = (uint)local_70 / 1000;
              if (uVar1 <= uVar10) {
                uVar1 = uVar10;
              }
              if (puVar11 == (undefined *)0x0) {
                ppcVar12 = (char **)((long)ppcVar12 + -0x400);
                *(undefined *)ppcVar12 = 0;
                puVar11 = (undefined *)ppcVar12;
              }
              uVar10 = uVar1;
              if (((int)lVar6 < 0x3fe) && (pcVar9 = *ppcVar14, pcVar9 != (char *)0x0)) {
                local_70 = pcVar9;
                uVar8 = _strlen(pcVar9);
                if (0x1f < uVar8) {
                  uVar8 = 0x20;
                }
                sVar2 = 0x3feU - lVar6;
                if (uVar8 <= 0x3feU - lVar6) {
                  sVar2 = uVar8;
                }
                if (sVar2 != 0) {
                  _strncpy(puVar11 + lVar6,local_70,sVar2);
                  *(undefined2 *)(puVar11 + sVar2 + lVar6) = 0x3b;
                  lVar6 = sVar2 + lVar6 + 1;
                }
              }
            }
          }
          else {
            *(int *)((long)ppcVar14 + 0x1dc) = iVar3;
            *(undefined4 *)(ppcVar14 + 0x3c) = 0;
          }
        }
        uVar8 = DAT_00028c80;
        uVar7 = FUN_000167ec(DAT_00028c78,DAT_00028c80,uVar7 + 1);
      } while (uVar7 < uVar8);
      FUN_00004c24(&DAT_000297e8);
      if (puVar11 == (undefined *)0x0) goto LAB_0000c128;
      FUN_00004bbc(&DAT_000296d8);
      for (puVar13 = DAT_00028c68; (undefined8 **)puVar13 != &DAT_00028c68;
          puVar13 = (undefined8 *)*puVar13) {
        (*(code *)puVar13[2])(uVar10,puVar11);
      }
      puVar11 = &DAT_000296d8;
    }
    else {
      puVar11 = &DAT_000297e8;
    }
    FUN_00004c24(puVar11);
  }
LAB_0000c128:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



undefined8
FUN_0000c188(long param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
            undefined8 param_5,undefined8 param_6,undefined8 param_7,ulong param_8)

{
  int *piVar1;
  ulong uVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  undefined8 uVar6;
  undefined8 *puVar7;
  undefined8 local_a0;
  undefined8 local_98;
  undefined8 local_90;
  undefined4 local_88;
  long local_80;
  undefined8 uStack_78;
  undefined8 local_70;
  undefined4 local_64;
  
  if (((int)param_2 != 0) && (((uint)param_3 >> 0xf & 1) == 0)) {
                    // WARNING: Subroutine does not return
    _abort();
  }
  if ((int)param_2 == 0) {
    param_2 = 0;
  }
  else {
    lVar5 = FUN_000090e4();
    if (lVar5 == param_1) {
      local_70 = _ahpl_tick_now();
      puVar7 = *(undefined8 **)(param_1 + 0x1a0);
      local_a0 = *puVar7;
      local_98 = 0;
      local_90 = 0;
      local_88 = 0;
      local_80 = 0;
      uStack_78 = 0;
      *(undefined8 **)(param_1 + 0x1a0) = &local_a0;
      uVar2 = param_8 | 0x80000000;
      if ((int)param_5 != 0) {
        uVar2 = param_8 >> 3;
      }
      local_64 = 0;
      lVar5 = FUN_0000a070(param_4,&local_64);
      FUN_0000c56c(param_1,param_3,lVar5);
      FUN_0000a0e4(lVar5,local_64);
      if ((((uint)param_3 >> 0xf & 1) == 0) && (lVar5 != 1)) {
        lVar5 = FUN_00009a98(param_3);
        if (lVar5 == 0) {
          FUN_0000c56c(param_1,0xffffffff,1);
        }
        else {
          if ((int)uVar2 < 0) {
            FUN_0000c550(uVar2 & 0x7fffffff);
          }
          else {
            FUN_0000c550(uVar2 << 3);
          }
          FUN_0000c66c();
          piVar1 = (int *)(lVar5 + 0x10);
          do {
            cVar3 = '\x01';
            bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
            if (bVar4) {
              *piVar1 = *piVar1 + -1;
              cVar3 = ExclusiveMonitorsStatus();
            }
          } while (cVar3 != '\0');
        }
      }
      uVar6 = local_98;
      local_98 = 0;
      FUN_0000f048(uVar6,0);
      local_90 = 0;
      local_88 = 0;
      if (local_80 != 0) {
        FUN_0000f214(local_80,0);
      }
      *(undefined8 **)(param_1 + 0x1a0) = puVar7;
      return 0;
    }
  }
  uVar6 = FUN_0000c66c(param_1,0,param_2,param_3,param_4,param_5);
  return uVar6;
}



void FUN_0000c34c(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long unaff_x19;
  
  piVar1 = (int *)(unaff_x19 + 0x10);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_0000c364(void)

{
  return;
}



void FUN_0000c390(void)

{
  return;
}



void FUN_0000c3b8(void)

{
  return;
}



void FUN_0000c3e0(void)

{
  return;
}



void FUN_0000c3e8(void)

{
  return;
}



void FUN_0000c40c(void)

{
  return;
}



void FUN_0000c420(void)

{
  FUN_000090e4();
  return;
}



void FUN_0000c43c(void)

{
  return;
}



void FUN_0000c45c(void)

{
  return;
}



void FUN_0000c464(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long unaff_x25;
  
  piVar1 = (int *)(unaff_x25 + 0x10);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_0000c47c(void)

{
  return;
}



void FUN_0000c490(void)

{
  return;
}



void FUN_0000c49c(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 param_5)

{
  FUN_000097e0(param_1,0xffffffff,0xffffffff,param_4,param_5,0,0);
  return;
}



undefined8 FUN_0000c4b0(undefined4 *param_1)

{
  undefined4 in_w8;
  
  *param_1 = in_w8;
  return 0xffffffff;
}



void FUN_0000c4bc(undefined8 param_1)

{
  FUN_00004f08(param_1,0,&stack0x00000008);
  return;
}



void FUN_0000c4cc(void)

{
  return;
}



undefined8 FUN_0000c4d4(undefined4 *param_1)

{
  undefined4 unaff_w19;
  
  *param_1 = unaff_w19;
  return 0xffffffff;
}



void FUN_0000c4e0(void)

{
  return;
}



void FUN_0000c500(void)

{
  return;
}



void FUN_0000c520(undefined4 *param_1)

{
  *param_1 = 0x16;
  return;
}



void FUN_0000c530(void)

{
  FUN_00009f58();
  return;
}



void FUN_0000c548(void)

{
  ___error();
  return;
}



void FUN_0000c550(void)

{
  return;
}



void FUN_0000c56c(void)

{
  FUN_00009f58();
  return;
}



void FUN_0000c580(undefined8 param_1,undefined8 param_2)

{
  FUN_000167ec(param_1,param_2,0);
  return;
}



void FUN_0000c588(void)

{
  return;
}



void FUN_0000c5a4(void)

{
  FUN_000090e4();
  return;
}



void FUN_0000c5b0(void)

{
  FUN_00004aec();
  return;
}



void FUN_0000c5b8(void)

{
  FUN_0000b514();
  return;
}



void FUN_0000c5c0(void)

{
  long unaff_x20;
  
                    // WARNING: Could not recover jumptable at 0x0000c5cc. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(*(long *)(unaff_x20 + 8) + 0x18))();
  return;
}



void FUN_0000c5d0(void)

{
  long unaff_x19;
  
                    // WARNING: Could not recover jumptable at 0x0000c5dc. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(*(long *)(unaff_x19 + 8) + 8))();
  return;
}



void FUN_0000c5e0(void)

{
  FUN_00004b20();
  return;
}



void FUN_0000c5e8(void)

{
  return;
}



void FUN_0000c5f0(void)

{
  return;
}



void FUN_0000c600(void)

{
  FUN_000090e4();
  return;
}



void FUN_0000c608(void)

{
                    // WARNING: Subroutine does not return
  FUN_000132b8();
}



void FUN_0000c614(void)

{
  FUN_0000b750();
  return;
}



int FUN_0000c61c(void)

{
  int iVar1;
  pthread_cond_t *unaff_x19;
  
  iVar1 = _pthread_cond_destroy(unaff_x19);
  return iVar1;
}



void FUN_0000c624(void)

{
  FUN_0000b828();
  return;
}



int FUN_0000c630(void)

{
  int iVar1;
  
  iVar1 = _usleep(1000);
  return iVar1;
}



undefined8 FUN_0000c638(undefined4 *param_1)

{
  *param_1 = 0x16;
  return 0;
}



void FUN_0000c64c(undefined8 param_1,undefined8 param_2)

{
  _ahpl_mpq_set_timer(param_1,param_2,0,0);
  return;
}



void FUN_0000c658(void)

{
  FUN_00004b20();
  return;
}



void FUN_0000c660(void)

{
  FUN_0000b278();
  return;
}



void FUN_0000c66c(void)

{
  FUN_00009bc4();
  return;
}



void FUN_0000c678(void)

{
  return;
}



void FUN_0000c684(void)

{
  return;
}



void FUN_0000c690(void)

{
  FUN_00009ba0();
  return;
}



void FUN_0000c698(void)

{
  return;
}



void FUN_0000c6a4(void)

{
  return;
}



void FUN_0000c6b8(long param_1)

{
  *(undefined **)(param_1 + 0x170) = &stack0x00000008;
  FUN_0000b1dc();
  return;
}



void FUN_0000c6c4(void)

{
  ___cxa_atexit(FUN_0000bb80,0,0);
  return;
}



undefined4 FUN_0000c6dc(void)

{
  undefined4 uVar1;
  ulong uVar2;
  
  uVar2 = FUN_0000c710(DAT_000298f0);
  uVar1 = 0xffffffff;
  if ((uVar2 != 0) && (uVar2 < 0xfffffffffffff001)) {
    uVar1 = *(undefined4 *)(uVar2 + 0x14);
  }
  return uVar1;
}



ulong FUN_0000c710(int *param_1)

{
  int *piVar1;
  int iVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  ulong *puVar6;
  ulong uVar7;
  
  FUN_0000db24();
  iVar2 = param_1[0x14];
  lVar5 = (long)iVar2;
  if (iVar2 < 1) {
    uVar7 = 0;
LAB_0000c790:
    bVar4 = true;
  }
  else {
    uVar7 = 0;
    puVar6 = *(ulong **)(param_1 + 0x12);
    do {
      if ((uVar7 == 0) || (*(int *)(*puVar6 + 0x148) < *(int *)(uVar7 + 0x148))) {
        uVar7 = *puVar6;
      }
      puVar6 = puVar6 + 2;
      lVar5 = lVar5 + -1;
    } while (lVar5 != 0);
    if (uVar7 == 0) goto LAB_0000c790;
    puVar6 = (ulong *)uVar7;
    if ((*(int *)(uVar7 + 0x148) < 1) || (*param_1 <= iVar2)) goto joined_r0x0000c7bc;
    bVar4 = false;
  }
  puVar6 = (ulong *)FUN_0000d518(param_1);
  if ((puVar6 == (ulong *)0x0) || ((ulong *)0xfffffffffffff000 < puVar6)) {
    if (!bVar4) {
      puVar6 = (ulong *)uVar7;
    }
  }
  else {
    puVar6 = (ulong *)*puVar6;
  }
joined_r0x0000c7bc:
  if ((puVar6 != (ulong *)0x0) && (puVar6 < 0xfffffffffffff001)) {
    piVar1 = (int *)(puVar6 + 2);
    do {
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar4) {
        *piVar1 = *piVar1 + 1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
    piVar1 = (int *)(puVar6 + 0x29);
    do {
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar4) {
        *piVar1 = *piVar1 + 1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
  }
  FUN_0000dad4();
  return (ulong)puVar6;
}



undefined8 FUN_0000c808(void)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_00009a98();
  if (lVar1 == 0) {
    uVar2 = 0xffffffff;
  }
  else {
    FUN_0000c844();
    FUN_00009b28(lVar1);
    uVar2 = 0;
  }
  return uVar2;
}



void FUN_0000c844(long param_1)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  
  piVar1 = (int *)(param_1 + 0x148);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  piVar1 = (int *)(param_1 + 0x10);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_0000c870(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 ulong param_5)

{
  if (param_5 < 0x41) {
    FUN_0000db78(param_4,DAT_000298f0,FUN_000097e0,param_1,param_2,param_3);
  }
  else {
    ___error();
    FUN_0000da70();
  }
  FUN_0000dab4();
  return;
}



undefined8 _ahpl_mpqp_create(undefined8 param_1,uint param_2)

{
  int *piVar1;
  undefined8 uVar2;
  
  if (0xffff < param_2) {
    piVar1 = ___error();
    *piVar1 = 0x16;
    return 0;
  }
  uVar2 = FUN_0000c8fc();
  return uVar2;
}



uint * FUN_0000c8fc(uint param_1,uint param_2,uint param_3,uint param_4,uint param_5,long param_6,
                   undefined8 param_7,undefined8 param_8,undefined8 param_9)

{
  uint *puVar1;
  long lVar2;
  int *piVar3;
  undefined8 extraout_x1;
  int iVar4;
  undefined4 *puVar5;
  ulong uVar6;
  
  if ((((int)param_5 < 0x2aaaaaab && param_5 != 0) && param_1 - 1 >> 0x10 == 0) &&
      param_4 - 1 < 1000000) {
    puVar1 = (uint *)_ahpl_malloc(0xc0);
    if (puVar1 == (uint *)0x0) {
      piVar3 = ___error();
    }
    else {
      uVar6 = (ulong)param_1;
      lVar2 = _ahpl_malloc(uVar6 << 4);
      *(long *)(puVar1 + 0x12) = lVar2;
      if (lVar2 != 0) {
        puVar5 = (undefined4 *)(lVar2 + 8);
        do {
          *(undefined8 *)(puVar5 + -2) = 0;
          *puVar5 = 0;
          uVar6 = uVar6 - 1;
          puVar5 = puVar5 + 4;
        } while (uVar6 != 0);
        *puVar1 = param_1;
        FUN_00004a38(puVar1 + 2);
        puVar1[0x14] = 0;
        puVar1[0x15] = param_2;
        puVar1[0x16] = param_3;
        puVar1[0x17] = param_4;
        puVar1[0x18] = param_5;
        if (param_6 == 0) {
          *(undefined *)(puVar1 + 0x19) = 0;
        }
        else {
          FUN_0000dbb4(puVar1 + 0x19,extraout_x1,"%s");
        }
        *(undefined8 *)(puVar1 + 0x2a) = param_7;
        *(undefined8 *)(puVar1 + 0x2c) = param_8;
        *(undefined8 *)(puVar1 + 0x2e) = param_9;
        return puVar1;
      }
      _free(puVar1);
      piVar3 = ___error();
    }
    iVar4 = 0xc;
  }
  else {
    piVar3 = ___error();
    iVar4 = 0x16;
  }
  *piVar3 = iVar4;
  return (uint *)0x0;
}



void FUN_0000ca48(void)

{
  int iVar1;
  int iVar2;
  
  FUN_000169a8();
  FUN_0000db48();
  DAT_000298f8 = FUN_0000da80();
  if (DAT_000298f8 != 0) {
    FUN_000169a8();
    FUN_0000db48();
    DAT_00029900 = FUN_0000da80();
    if (DAT_00029900 != 0) {
      iVar2 = FUN_000169a8();
      iVar1 = 2;
      if (iVar2 - 1U >> 0x10 == 0) {
        iVar1 = iVar2 << 1;
      }
      DAT_000298f0 = FUN_0000da80(iVar1);
      if (DAT_000298f0 != 0) {
        DAT_00029908 = FUN_0000c8fc(0x40,0,0,&DAT_00002710,3,"LTWP",0,0,0);
        if (DAT_00029908 != 0) {
          return;
        }
      }
    }
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void _ahpl_mpqp_queue(void)

{
  ulong in_x5;
  
  if (in_x5 < 0x41) {
    FUN_0000cb4c();
  }
  else {
    ___error();
    FUN_0000da70();
  }
  FUN_0000dab4();
  return;
}



void FUN_0000cb4c(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 param_5)

{
  FUN_0000db78(param_5,param_1,FUN_0000aad4,param_2,param_3,param_4);
  FUN_0000dbbc();
  return;
}



void _ahpl_mpqp_call(void)

{
  ulong in_x4;
  
  if (in_x4 < 0x41) {
    FUN_0000cbc4();
  }
  else {
    ___error();
    FUN_0000da70();
  }
  FUN_0000dab4();
  return;
}



void FUN_0000cbc4(void)

{
  undefined8 uVar1;
  
  uVar1 = FUN_0000db80();
  FUN_0000dbac(uVar1,FUN_0000ac44);
  FUN_0000dbbc();
  return;
}



void _ahpl_mpqp_queue_args(void)

{
  ulong in_x5;
  
  if (0x40 < in_x5) {
    ___error();
    FUN_0000da70();
    return;
  }
  FUN_0000cb4c();
  return;
}



void _ahpl_mpqp_call_args(void)

{
  ulong in_x4;
  
  if (0x40 < in_x4) {
    ___error();
    FUN_0000da70();
    return;
  }
  FUN_0000cbc4();
  return;
}



void _ahpl_mpqp_queue_argv(void)

{
  undefined8 uVar1;
  ulong in_x5;
  
  if (in_x5 < 0x41) {
    uVar1 = FUN_0000db30();
    FUN_0000db78(uVar1,FUN_0000ade0);
  }
  else {
    ___error();
    FUN_0000da70();
  }
  FUN_0000dab4();
  return;
}



void _ahpl_mpqp_call_argv(void)

{
  undefined8 uVar1;
  ulong in_x4;
  
  if (in_x4 < 0x41) {
    uVar1 = FUN_0000db80();
    FUN_0000dbac(uVar1,FUN_0000aed4);
  }
  else {
    ___error();
    FUN_0000da70();
  }
  FUN_0000dab4();
  return;
}



void _ahpl_mpqp_queue_data(void)

{
  undefined8 uVar1;
  
  uVar1 = FUN_0000db30();
  FUN_0000db78(uVar1,FUN_0000af3c);
  FUN_0000dab4();
  return;
}



void _ahpl_mpqp_call_data(void)

{
  undefined8 uVar1;
  
  uVar1 = FUN_0000db80();
  FUN_0000dbac(uVar1,FUN_0000b02c);
  FUN_0000dab4();
  return;
}



void _ahpl_mpqp_pool_tail_queue(void)

{
  ulong in_x5;
  
  if (in_x5 < 0x41) {
    FUN_0000cd38();
  }
  else {
    ___error();
    FUN_0000da70();
  }
  FUN_0000dab4();
  return;
}



void FUN_0000cd38(void)

{
  long in_x5;
  undefined8 *in_x6;
  long lVar1;
  undefined8 uVar2;
  undefined8 *local_20;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  local_20 = in_x6;
  if (in_x5 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
      FUN_0000cdf8();
      return;
    }
  }
  else {
    lVar1 = 0;
    do {
      uVar2 = *local_20;
      local_20 = local_20 + 1;
      *(undefined8 *)((long)&local_20 + (lVar1 * 8 - (in_x5 * 8 + 0xfU & 0xfffffffffffffff0))) =
           uVar2;
      lVar1 = lVar1 + 1;
    } while (in_x5 != lVar1);
    FUN_0000cdf8();
    if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_mpqp_pool_tail_queue_args(void)

{
  long in_x5;
  undefined8 *in_x6;
  long lVar1;
  undefined8 uVar2;
  undefined8 *puStack_20;
  long lStack_18;
  
  lStack_18 = *(long *)PTR____stack_chk_guard_00028030;
  puStack_20 = in_x6;
  if (in_x5 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == lStack_18) {
      FUN_0000cdf8();
      return;
    }
  }
  else {
    lVar1 = 0;
    do {
      uVar2 = *puStack_20;
      puStack_20 = puStack_20 + 1;
      *(undefined8 *)((long)&puStack_20 + (lVar1 * 8 - (in_x5 * 8 + 0xfU & 0xfffffffffffffff0))) =
           uVar2;
      lVar1 = lVar1 + 1;
    } while (in_x5 != lVar1);
    FUN_0000cdf8();
    if (*(long *)PTR____stack_chk_guard_00028030 == lStack_18) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_mpqp_pool_tail_queue_argv(void)

{
  FUN_0000cdf8();
  return;
}



void FUN_0000cdf8(long param_1,int param_2,undefined8 param_3,undefined8 param_4,undefined8 param_5,
                 long param_6,void *param_7)

{
  long *plVar1;
  uint uVar2;
  int *piVar3;
  long lVar4;
  undefined8 uVar5;
  int *piVar6;
  undefined8 extraout_x1;
  int iVar7;
  long lVar8;
  int **ppiVar9;
  int *local_b0;
  long alStack_a8 [3];
  undefined auStack_90 [40];
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  piVar3 = (int *)_ahpl_malloc(4);
  if (piVar3 == (int *)0x0) {
LAB_0000cff0:
    uVar5 = 0xffffffff;
    goto LAB_0000cff4;
  }
  lVar8 = param_1 + 8;
  FUN_00004aec(lVar8);
  iVar7 = *(int *)(param_1 + 0x50);
  if (iVar7 == 0) {
    FUN_0000dbb4(alStack_a8,extraout_x1,"%s.%d");
    uVar2 = 0x80000002;
    if (DAT_00029908 != param_1) {
      uVar2 = 0x80000000;
    }
    lVar4 = FUN_0000a11c(uVar2 | *(uint *)(param_1 + 0x54),*(undefined4 *)(param_1 + 0x58),
                         *(undefined4 *)(param_1 + 0x5c),alStack_a8,FUN_0000d62c,FUN_0000d6c4,
                         param_1);
    if (lVar4 != 0) {
      iVar7 = *(int *)(param_1 + 0x50);
      plVar1 = (long *)(*(long *)(param_1 + 0x48) + (long)iVar7 * 0x10);
      if ((*plVar1 != 0) || (*(int *)(plVar1 + 1) != 0)) {
                    // WARNING: Subroutine does not return
        FUN_0000db90("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/mpqp.c"
                     ,0x32d);
      }
      *plVar1 = lVar4;
      *(int *)(plVar1 + 1) = 1;
      iVar7 = iVar7 + 1;
      *(int *)(param_1 + 0x50) = iVar7;
      goto LAB_0000cf04;
    }
    piVar6 = ___error();
    iVar7 = *piVar6;
    _free(piVar3);
    FUN_00004b20(lVar8);
    if (0 < iVar7) {
      piVar3 = ___error();
      *piVar3 = iVar7;
      goto LAB_0000cff0;
    }
  }
  else {
LAB_0000cf04:
    *piVar3 = iVar7;
    lVar4 = -((param_6 + 4) * 8 + 0xfU & 0xfffffffffffffff0);
    ppiVar9 = (int **)((long)alStack_a8 + lVar4 + -8);
    local_b0 = (int *)lVar8;
    *ppiVar9 = piVar3;
    *(long *)((long)alStack_a8 + lVar4) = (long)param_2;
    uVar5 = _ahpl_strdup(param_4);
    *(undefined8 *)((long)alStack_a8 + lVar4 + 8) = uVar5;
    *(undefined8 *)((long)alStack_a8 + lVar4 + 0x10) = param_5;
    if (0 < (int)param_6) {
      lVar8 = (long)(int)param_6;
      if (lVar8 < 2) {
        lVar8 = 1;
      }
      _memcpy(auStack_90 + lVar4,param_7,lVar8 << 3);
    }
    if (0 < *(int *)(param_1 + 0x50)) {
      lVar4 = 0;
      lVar8 = 0;
      do {
        FUN_000097e0(*(undefined8 *)(*(long *)(param_1 + 0x48) + lVar4),0xffffffff,param_3,0,
                     FUN_0000d970,param_6 + 4,ppiVar9);
        lVar8 = lVar8 + 1;
        lVar4 = lVar4 + 0x10;
      } while (lVar8 < *(int *)(param_1 + 0x50));
    }
    FUN_00004b20(local_b0);
  }
  uVar5 = 0;
LAB_0000cff4:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar5);
}



void FUN_0000d044(void)

{
  FUN_0000dba4(DAT_000298f8);
  FUN_0000dba4(DAT_00029900);
  FUN_0000dba4(DAT_000298f0);
  FUN_0000d084(DAT_00029908,0);
  return;
}



void FUN_0000d084(long param_1,int param_2)

{
  int *piVar1;
  long *plVar2;
  uint uVar3;
  char cVar4;
  bool bVar5;
  undefined *puVar6;
  undefined *puVar7;
  long lVar8;
  ulong uVar9;
  long lVar10;
  ulong uVar11;
  undefined auStack_70 [8];
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  FUN_0000db24();
  uVar3 = *(uint *)(param_1 + 0x50);
  uVar9 = (ulong)uVar3;
  if ((int)uVar3 < 1) {
    if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
      FUN_00004b20();
      return;
    }
  }
  else {
    if (param_2 == 0) {
      puVar6 = (undefined *)0x0;
    }
    else {
      puVar6 = auStack_70 + -(uVar9 * 8 + 0xf & 0xffffffff0);
    }
    lVar10 = 0;
    puVar7 = puVar6;
    uVar11 = uVar9;
    do {
      plVar2 = (long *)(*(long *)(param_1 + 0x48) + lVar10);
      lVar8 = *plVar2;
      *plVar2 = 0;
      *(undefined4 *)(plVar2 + 1) = 0;
      if (lVar8 != 0) {
        if (param_2 != 0) {
          FUN_0000b828(lVar8,puVar7);
        }
        piVar1 = (int *)(lVar8 + 0x10);
        do {
          cVar4 = '\x01';
          bVar5 = (bool)ExclusiveMonitorPass(piVar1,0x10);
          if (bVar5) {
            *piVar1 = *piVar1 + 1;
            cVar4 = ExclusiveMonitorsStatus();
          }
        } while (cVar4 != '\0');
        FUN_0000b750(lVar8);
        do {
          cVar4 = '\x01';
          bVar5 = (bool)ExclusiveMonitorPass(piVar1,0x10);
          if (bVar5) {
            *piVar1 = *piVar1 + -1;
            cVar4 = ExclusiveMonitorsStatus();
          }
        } while (cVar4 != '\0');
      }
      puVar7 = puVar7 + 0x88;
      lVar10 = lVar10 + 0x10;
      uVar11 = uVar11 - 1;
    } while (uVar11 != 0);
    *(undefined4 *)(param_1 + 0x50) = 0;
    FUN_0000dad4();
    if ((puVar6 != (undefined *)0x0) && (uVar3 != 0)) {
      do {
        FUN_0000b894(puVar6);
        puVar6 = puVar6 + 0x88;
        uVar9 = uVar9 - 1;
      } while (uVar9 != 0);
    }
    if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
      FUN_0000dadc();
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_mpqp_shrink(long param_1)

{
  int iVar1;
  char cVar2;
  bool bVar3;
  int iVar4;
  undefined8 uVar5;
  long lVar6;
  int *piVar7;
  long lVar8;
  
  FUN_0000db24();
  if (*(int *)(param_1 + 0x50) < 2) {
LAB_0000d22c:
    FUN_0000dad4();
  }
  else {
    lVar6 = *(long *)(param_1 + 0x48);
    iVar4 = *(int *)(param_1 + 0x50) + -1;
    piVar7 = (int *)(lVar6 + (long)iVar4 * 0x10 + 8);
    iVar1 = *piVar7;
    if (iVar1 != 1) {
      if (iVar1 == 0) {
                    // WARNING: Subroutine does not return
        FUN_0000db90("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/mpqp.c"
                     ,0x391);
      }
      goto LAB_0000d22c;
    }
    lVar8 = *(long *)(lVar6 + (long)iVar4 * 0x10);
    *(undefined8 *)(lVar6 + (long)iVar4 * 0x10) = 0;
    *piVar7 = 0;
    *(int *)(param_1 + 0x50) = iVar4;
    FUN_0000dad4();
    if (lVar8 != 0) {
      piVar7 = (int *)(lVar8 + 0x10);
      do {
        cVar2 = '\x01';
        bVar3 = (bool)ExclusiveMonitorPass(piVar7,0x10);
        if (bVar3) {
          *piVar7 = *piVar7 + 1;
          cVar2 = ExclusiveMonitorsStatus();
        }
      } while (cVar2 != '\0');
      FUN_0000b750(lVar8);
      uVar5 = 0;
      do {
        cVar2 = '\x01';
        bVar3 = (bool)ExclusiveMonitorPass(piVar7,0x10);
        if (bVar3) {
          *piVar7 = *piVar7 + -1;
          cVar2 = ExclusiveMonitorsStatus();
        }
      } while (cVar2 != '\0');
      goto LAB_0000d240;
    }
  }
  piVar7 = ___error();
  *piVar7 = 1;
  uVar5 = 0xffffffff;
LAB_0000d240:
  FUN_0000db98(uVar5);
  return;
}



void _ahpl_mpqp_shrink_all(void)

{
  FUN_0000d084();
  return;
}



undefined8 _ahpl_cpup(void)

{
  return DAT_000298f8;
}



undefined8 _ahpl_gpup(void)

{
  return DAT_00029900;
}



undefined8 _ahpl_genp(void)

{
  return DAT_000298f0;
}



undefined8 _ahpl_ltwp(void)

{
  return DAT_00029908;
}



void _ahpl_mpq_alloc(void)

{
  int iVar1;
  byte bVar2;
  undefined4 uVar3;
  long *plVar4;
  int *piVar5;
  long lVar6;
  long *plVar7;
  long *plVar8;
  
  piVar5 = DAT_000298f0;
  FUN_00004aec(DAT_000298f0 + 2);
  iVar1 = piVar5[0x14];
  lVar6 = (long)iVar1;
  if (iVar1 < 1) {
    bVar2 = 0;
    plVar8 = (long *)0x0;
  }
  else {
    plVar8 = (long *)0x0;
    plVar7 = *(long **)(piVar5 + 0x12);
    do {
      if ((plVar8 == (long *)0x0) || (*(uint *)(plVar7 + 1) < *(uint *)(plVar8 + 1))) {
        plVar8 = plVar7;
      }
      plVar7 = plVar7 + 2;
      lVar6 = lVar6 + -1;
    } while (lVar6 != 0);
    if (plVar8 == (long *)0x0) {
      bVar2 = 0;
    }
    else {
      if ((*(uint *)(plVar8 + 1) < 2) || (*piVar5 <= iVar1)) goto LAB_0000d3a8;
      bVar2 = 1;
    }
  }
  plVar4 = (long *)FUN_0000d518(piVar5);
  plVar7 = plVar4;
  if (plVar4 == (long *)0x0 || plVar4 >= (long *)0xfffffffffffff001) {
    plVar7 = plVar8;
  }
  plVar8 = plVar7;
  if (!(bool)((plVar4 != (long *)0x0 && plVar4 < (long *)0xfffffffffffff001) | bVar2)) {
    plVar8 = plVar4;
  }
LAB_0000d3a8:
  if ((plVar8 == (long *)0x0) || ((long *)0xfffffffffffff000 < plVar8)) {
    FUN_0000dad4();
    piVar5 = ___error();
    *piVar5 = -(int)plVar8;
    uVar3 = 0xffffffff;
  }
  else {
    *(int *)(plVar8 + 1) = *(int *)(plVar8 + 1) + 1;
    FUN_0000dad4();
    uVar3 = *(undefined4 *)(*plVar8 + 0x14);
  }
  FUN_0000db98(uVar3);
  return;
}



undefined8 _ahpl_mpq_free(int param_1)

{
  long *plVar1;
  long lVar2;
  int iVar3;
  long lVar4;
  int *piVar5;
  long lVar6;
  long lVar7;
  long lVar8;
  ulong uVar9;
  
  FUN_00004aec(DAT_000298f0 + 8);
  lVar4 = DAT_000298f0;
  lVar7 = -1;
  lVar6 = 0;
  do {
    lVar7 = lVar7 + 1;
    if (*(int *)(DAT_000298f0 + 0x50) <= lVar7) goto LAB_0000d478;
    lVar2 = lVar6 + 0x10;
    lVar8 = *(long *)(DAT_000298f0 + 0x48);
    plVar1 = (long *)(lVar8 + lVar6);
    lVar6 = lVar2;
  } while (*(int *)(*plVar1 + 0x14) != param_1);
  if (lVar8 == 0) {
LAB_0000d478:
    uVar9 = 0xffffffffffffffea;
  }
  else {
    lVar8 = lVar8 + lVar2;
    iVar3 = *(int *)(lVar8 + -8) + -1;
    if (*(int *)(lVar8 + -8) != 0 && iVar3 != 0) {
      uVar9 = lVar8 - 0x10;
      *(int *)(lVar8 + -8) = iVar3;
      FUN_00004b20(lVar4 + 8);
      if (uVar9 < 0xfffffffffffff001) {
        return 0;
      }
      goto LAB_0000d484;
    }
    uVar9 = 0xffffffffffffffff;
  }
  FUN_00004b20(DAT_000298f0 + 8);
LAB_0000d484:
  piVar5 = ___error();
  *piVar5 = (int)uVar9;
  return 0xffffffff;
}



void _ahpl_mpqp_destroy(void *param_1)

{
  if (((DAT_000298f8 == param_1 || DAT_00029900 == param_1) || DAT_000298f0 == param_1) ||
      DAT_00029908 == param_1) {
    return;
  }
  FUN_0000d084();
  _free(*(void **)((long)param_1 + 0x48));
  FUN_00004b3c((long)param_1 + 8);
  _free(param_1);
  return;
}



void FUN_0000d518(long param_1,undefined8 param_2)

{
  int iVar1;
  uint uVar2;
  long lVar3;
  int *piVar4;
  long *plVar5;
  undefined8 in_x7;
  ulong uVar6;
  undefined auStack_68 [64];
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  lVar3 = param_1 + 100;
  uVar6 = (ulong)*(uint *)(param_1 + 0x50);
  FUN_0000dbb4(auStack_68,param_2,"%s.%d");
  uVar2 = 0x80000002;
  if (DAT_00029908 != param_1) {
    uVar2 = 0x80000000;
  }
  lVar3 = FUN_0000a11c(uVar2 | *(uint *)(param_1 + 0x54),*(undefined4 *)(param_1 + 0x58),
                       *(undefined4 *)(param_1 + 0x5c),auStack_68,FUN_0000d62c,FUN_0000d6c4,param_1,
                       in_x7,lVar3,uVar6);
  if (lVar3 == 0) {
    piVar4 = ___error();
    plVar5 = (long *)-(long)*piVar4;
  }
  else {
    iVar1 = *(int *)(param_1 + 0x50);
    plVar5 = (long *)(*(long *)(param_1 + 0x48) + (long)iVar1 * 0x10);
    if ((*plVar5 != 0) || (*(int *)(plVar5 + 1) != 0)) {
                    // WARNING: Subroutine does not return
      FUN_0000db90("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/mpqp.c"
                   ,0xcf);
    }
    *plVar5 = lVar3;
    *(int *)(plVar5 + 1) = 1;
    *(int *)(param_1 + 0x50) = iVar1 + 1;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(plVar5);
}



void FUN_0000d62c(long param_1)

{
  uint uVar1;
  undefined4 *puVar2;
  undefined8 uVar3;
  
  if (*(int *)(param_1 + 0x60) < 1) {
LAB_0000d688:
    if (*(code **)(param_1 + 0xa8) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x0000d6a0. Too many branches
                    // WARNING: Treating indirect jump as call
      (**(code **)(param_1 + 0xa8))(*(undefined8 *)(param_1 + 0xb8));
      return;
    }
    uVar3 = 0;
  }
  else {
    puVar2 = (undefined4 *)_ahpl_malloc(0x10);
    if (puVar2 != (undefined4 *)0x0) {
      *puVar2 = 0;
      *(undefined8 *)(puVar2 + 2) = 0;
      uVar1 = _ahpl_mpq_set_timer(1000,FUN_0000d6d8,FUN_0000d76c,2);
      if ((uVar1 >> 0xf & 1) == 0) goto LAB_0000d688;
      _free(puVar2);
    }
    uVar3 = 0xffffffff;
  }
  FUN_0000dbbc(uVar3);
  return;
}



void FUN_0000d6c4(long param_1)

{
  if (*(code **)(param_1 + 0xb0) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x0000d6d0. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 0xb0))(*(undefined8 *)(param_1 + 0xb8));
    return;
  }
  return;
}



void FUN_0000d6d8(void)

{
  int iVar1;
  long lVar2;
  int **in_x3;
  long lVar3;
  int iVar4;
  int *piVar5;
  int *piVar6;
  
  piVar6 = *in_x3;
  piVar5 = in_x3[1];
  lVar2 = FUN_000090e4();
  iVar1 = piVar5[0x18];
  if (iVar1 < 0) {
                    // WARNING: Subroutine does not return
    _abort();
  }
  lVar3 = *(long *)(lVar2 + 0x1a8);
  if ((lVar3 == *(long *)(piVar6 + 2)) && (*(int *)(lVar2 + 0x148) == 0)) {
    iVar4 = *piVar6 + 1;
    *piVar6 = iVar4;
  }
  else {
    iVar4 = 0;
    *piVar6 = 0;
  }
  *(long *)(piVar6 + 2) = lVar3;
  if (iVar4 + iVar1 * -2 < 0 != SBORROW4(iVar4,iVar1 * 2)) {
    if (iVar4 < iVar1) {
      return;
    }
    _ahpl_mpqp_shrink(piVar5);
    return;
  }
  FUN_0000d084(piVar5,0);
  return;
}



void FUN_0000d76c(undefined8 param_1,void **param_2)

{
  _free(*param_2);
  return;
}



void FUN_0000d774(undefined8 param_1,code *param_2)

{
  ulong uVar1;
  ulong uVar2;
  int *piVar3;
  
  uVar1 = FUN_0000c710();
  if ((uVar1 == 0) || (0xfffffffffffff000 < uVar1)) {
    piVar3 = ___error();
    *piVar3 = -(int)uVar1;
    uVar2 = 0xffffffff;
    goto LAB_0000d868;
  }
  if (param_2 == FUN_0000aad4) {
    FUN_0000db08();
    FUN_0000db60();
    uVar2 = FUN_0000aad4();
LAB_0000d840:
    if (-1 < (int)uVar2) {
      uVar2 = (ulong)*(uint *)(uVar1 + 0x14);
    }
  }
  else {
    if ((param_2 == FUN_0000ade0 || param_2 == FUN_000097e0) ||
       (param_2 == FUN_0000af3c || param_2 == FUN_00009e40)) {
      FUN_0000db08();
      FUN_0000db60();
      uVar2 = (*param_2)();
      goto LAB_0000d840;
    }
    piVar3 = ___error();
    *piVar3 = 0x16;
    uVar2 = 0xffffffff;
  }
  FUN_0000c844(uVar1);
LAB_0000d868:
  FUN_0000daf4(uVar2);
  return;
}



void FUN_0000d874(undefined8 param_1,code *param_2)

{
  ulong uVar1;
  ulong uVar2;
  int *piVar3;
  undefined8 param_10;
  
  uVar1 = FUN_0000c710();
  if ((uVar1 == 0) || (0xfffffffffffff000 < uVar1)) {
    piVar3 = ___error();
    *piVar3 = -(int)uVar1;
    uVar2 = 0xffffffff;
  }
  else {
    if (param_2 == FUN_0000ac44) {
      FUN_0000da9c(param_10);
      uVar2 = FUN_0000ac44();
    }
    else if (param_2 == FUN_0000aed4) {
      FUN_0000da9c();
      uVar2 = FUN_0000aed4();
    }
    else {
      FUN_0000da9c();
      uVar2 = (*param_2)();
    }
    if (-1 < (int)uVar2) {
      uVar2 = (ulong)*(uint *)(uVar1 + 0x14);
    }
    FUN_0000c844(uVar1);
  }
  FUN_0000daf4(uVar2);
  return;
}



void FUN_0000d970(undefined8 param_1,long param_2,long param_3,int **param_4)

{
  int iVar1;
  char cVar2;
  bool bVar3;
  undefined8 uVar4;
  long lVar5;
  undefined4 uVar6;
  int *piVar7;
  int *piVar8;
  int *piVar9;
  int *piVar10;
  
  piVar10 = *param_4;
  do {
    iVar1 = *piVar10;
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar10,0x10);
    if (bVar3) {
      *piVar10 = iVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  if (iVar1 + -1 != 0) {
    FUN_0000dadc();
    return;
  }
  piVar9 = param_4[1];
  piVar7 = param_4[2];
  piVar8 = param_4[3];
  uVar4 = FUN_000090e4();
  _free(piVar10);
  FUN_0000dabc(uVar4,piVar9,param_2);
  if ((param_2 != 1) && (((uint)piVar9 >> 0xf & 1) == 0)) {
    lVar5 = FUN_00009a98(piVar9);
    if (lVar5 == 0) {
      FUN_0000dabc(uVar4,0xffffffff,1);
    }
    else {
      if (param_2 == 0) {
        uVar6 = 0xffffffff;
      }
      else {
        uVar6 = *(undefined4 *)(param_2 + 0x18);
      }
      FUN_000097e0(lVar5,0xffffffff,uVar6,piVar7,piVar8,param_3 + -4,param_4 + 4);
      FUN_00009b28(lVar5);
    }
  }
  _free(piVar7);
  return;
}



undefined8 FUN_0000da70(undefined4 *param_1)

{
  *param_1 = 7;
  return 0xffffffff;
}



void FUN_0000da80(undefined8 param_1)

{
  undefined8 in_x5;
  
  FUN_0000c8fc(param_1,0,3,&DAT_00002710,0xffffffff,in_x5,0,0);
  return;
}



void FUN_0000da9c(void)

{
  return;
}



void FUN_0000dab4(void)

{
  return;
}



void FUN_0000dabc(void)

{
  FUN_00009f58();
  return;
}



void FUN_0000dad4(void)

{
  FUN_00004b20();
  return;
}



void FUN_0000dadc(void)

{
  return;
}



void FUN_0000daf4(void)

{
  return;
}



void FUN_0000db08(void)

{
  return;
}



void FUN_0000db24(long param_1)

{
  FUN_00004aec(param_1 + 8);
  return;
}



void FUN_0000db30(void)

{
  return;
}



int FUN_0000db48(int param_1)

{
  if (param_1 - 1U >> 0x10 != 0) {
    param_1 = 1;
  }
  return param_1;
}



void FUN_0000db60(void)

{
  return;
}



void FUN_0000db78(void)

{
  FUN_0000d774();
  return;
}



void FUN_0000db80(void)

{
  return;
}



void FUN_0000db90(void)

{
                    // WARNING: Subroutine does not return
  FUN_000132b8();
}



void FUN_0000db98(void)

{
  return;
}



void FUN_0000dba4(undefined8 param_1)

{
  FUN_0000d084(param_1,0);
  return;
}



void FUN_0000dbac(void)

{
  FUN_0000d874();
  return;
}



int FUN_0000dbb4(char *param_1,undefined8 param_2,char *param_3)

{
  int iVar1;
  
  iVar1 = _snprintf(param_1,0x40,param_3);
  return iVar1;
}



void FUN_0000dbbc(void)

{
  return;
}



ulong _ahpl_tick_now(void)

{
  ulong uVar1;
  
  uVar1 = FUN_00004e88();
  return uVar1 / 1000000;
}



ulong _ahpl_tick_us(void)

{
  ulong uVar1;
  
  uVar1 = FUN_00004e88();
  return uVar1 / 1000;
}



ulong _ahpl_tick_ns(void)

{
  ulong uVar1;
  ulong uVar2;
  uint64_t uVar3;
  ulong uVar4;
  ulong uVar5;
  
  uVar3 = _mach_absolute_time();
  uVar4 = uVar3 * DAT_00028e18;
  uVar5 = (ulong)DAT_00028e1c;
  uVar1 = 0;
  if (uVar5 != 0) {
    uVar1 = uVar3 / uVar5;
  }
  uVar2 = 0;
  if (uVar5 != 0) {
    uVar2 = uVar4 / uVar5;
  }
  if (uVar4 < uVar3) {
    uVar2 = uVar1 * DAT_00028e18;
  }
  return uVar2;
}



ulong _ahpl_time_sec(void)

{
  ulong uVar1;
  
  uVar1 = FUN_00004d4c();
  return uVar1 / 1000000;
}



ulong _ahpl_time_ms(void)

{
  ulong uVar1;
  
  uVar1 = FUN_00004d4c();
  return uVar1 / 1000;
}



long _ahpl_time_us(void)

{
  long lVar1;
  int iVar2;
  timeval tStack_20;
  
  iVar2 = _gettimeofday(&tStack_20,(void *)0x0);
  lVar1 = 0;
  if (-1 < iVar2) {
    lVar1 = (long)tStack_20.tv_usec + tStack_20.tv_sec * 1000000;
  }
  return lVar1;
}



undefined8 _ahpl_start_tick_ns(void)

{
  return DAT_00029910;
}



void _ahpl_start_tick_us(void)

{
  FUN_0000dd1c(DAT_00029910);
  return;
}



void _ahpl_start_tick_ms(void)

{
  FUN_0000dd0c(DAT_00029910);
  return;
}



undefined8 _ahpl_start_time_us(void)

{
  return DAT_00029918;
}



void _ahpl_start_time_ms(void)

{
  FUN_0000dd1c(DAT_00029918);
  return;
}



void _ahpl_start_time_sec(void)

{
  FUN_0000dd0c(DAT_00029918);
  return;
}



long _ahpl_ns_from_tv(long *param_1)

{
  return *param_1 * 1000000000 + (long)*(int *)(param_1 + 1) * 1000;
}



long _ahpl_us_from_tv(long *param_1)

{
  return (long)*(int *)(param_1 + 1) + *param_1 * 1000000;
}



long _ahpl_ms_from_tv(long *param_1)

{
  return *param_1 * 1000 + (long)(*(int *)(param_1 + 1) / 1000);
}



void FUN_0000dce0(void)

{
  FUN_00004ec4();
  DAT_00029910 = FUN_00004e88();
  DAT_00029918 = FUN_00004d4c();
  return;
}



ulong FUN_0000dd0c(ulong param_1)

{
  return param_1 / 1000000;
}



ulong FUN_0000dd1c(ulong param_1)

{
  return param_1 / 1000;
}



int FUN_0000dd28(void)

{
  int iVar1;
  sigaction local_20;
  
  local_20.__sigaction_u = (__sigaction_u)0x1;
  local_20.sa_mask = 0;
  local_20.sa_flags = 0x40;
  iVar1 = _sigaction(0xd,&local_20,(sigaction *)0x0);
  return iVar1;
}



void FUN_0000dd64(void)

{
  _bzero(&DAT_00029920,0x400);
  FUN_000154dc(&DAT_00029d20);
  return;
}



void FUN_0000dd8c(long param_1,undefined8 param_2,undefined8 param_3,int param_4,int param_5,
                 int param_6)

{
  uint uVar1;
  
  *(undefined8 *)(param_1 + 8) = param_2;
  *(undefined8 *)(param_1 + 0x10) = param_3;
  *(undefined4 *)(param_1 + 0x1c) = 1;
  FUN_000154dc(param_1 + 0x20);
  uVar1 = (uint)(param_4 != 0) << 0x1e;
  if (param_5 != 0) {
    uVar1 = (uint)(param_4 != 0) << 0x1e | 0x20000000;
  }
  if (param_6 != 0) {
    uVar1 = uVar1 | 0x10000000;
  }
  *(uint *)(param_1 + 0x130) = uVar1;
  FUN_000154dc(param_1 + 0x138);
  *(undefined8 *)(param_1 + 0x248) = 0;
  *(code **)(param_1 + 0x250) = FUN_0000ed7c;
  *(undefined8 *)(param_1 + 600) = 0;
  FUN_0000f020(0);
  return;
}



void FUN_0000de10(long param_1)

{
  int iVar1;
  long lVar2;
  
  FUN_000155f8(param_1 + 0x20);
  FUN_000155f8(param_1 + 0x138);
  lVar2 = *(long *)(param_1 + 0x248);
  if (lVar2 != 0) {
    do {
      FUN_00015e64(lVar2,(long *)(param_1 + 0x248));
      iVar1 = *(int *)(lVar2 + 0x20) + -1;
      *(int *)(lVar2 + 0x20) = iVar1;
      if (iVar1 == 0) {
        FUN_0000f004();
      }
      lVar2 = *(long *)(param_1 + 0x248);
    } while (lVar2 != 0);
  }
  return;
}



ulong ** FUN_0000de70(ulong *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                     undefined8 param_5,undefined8 param_6)

{
  ushort uVar1;
  int iVar2;
  ulong **ppuVar3;
  ulong uVar4;
  undefined *puVar5;
  void *pvVar6;
  undefined8 uVar7;
  long lVar8;
  
  if (*param_1 < 0x260) {
    return (ulong **)0xffffffffffffffea;
  }
  ppuVar3 = (ulong **)_ahpl_malloc();
  if (ppuVar3 == (ulong **)0x0) {
    iVar2 = -0xc;
    goto LAB_0000e0d0;
  }
  *ppuVar3 = param_1;
  iVar2 = (*(code *)param_1[1])(ppuVar3,param_2,param_3,param_4,param_5,param_6,&stack0x00000000);
  if (-1 < iVar2) {
    FUN_00015504(&DAT_00029d20);
    iVar2 = DAT_00028cc0;
    puVar5 = DAT_00028cb8;
    lVar8 = (long)DAT_00028cc0;
    uVar4 = FUN_0000ef84();
    if ((int)uVar4 < iVar2) {
LAB_0000df2c:
      FUN_000040d4(uVar4,puVar5);
      FUN_00015548(&DAT_00029d20);
      iVar2 = (int)uVar4;
      if (-1 < iVar2) {
        if (iVar2 < DAT_00028cc0) {
          FUN_00015504(&DAT_00029d20);
          uVar1 = DAT_00028cd0;
          if (iVar2 < DAT_00028cc0) {
            if (*(long *)((long)DAT_00028cc8 + (uVar4 & 0xffffffff) * 8) != 0) {
                    // WARNING: Subroutine does not return
              _abort();
            }
            *(ulong ***)((long)DAT_00028cc8 + (uVar4 & 0xffffffff) * 8) = ppuVar3;
            *(uint *)(ppuVar3 + 3) = (int)(short)uVar4 | (uint)DAT_00028cd0 << 0x10;
            uVar1 = 1;
            if ((DAT_00028cd0 + 1 & 0x10000) == 0) {
              uVar1 = DAT_00028cd0 + 1;
            }
          }
          DAT_00028cd0 = uVar1;
          FUN_00015548(&DAT_00029d20);
          return ppuVar3;
        }
        uVar7 = 0x8c;
LAB_0000e104:
                    // WARNING: Subroutine does not return
        FUN_000132b8("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/refobj.c"
                     ,uVar7);
      }
    }
    else if (iVar2 < 0x5000) {
      lVar8 = lVar8 + 0x40;
      puVar5 = (undefined *)FUN_00015c6c(lVar8);
      if (puVar5 == (undefined *)0x0) {
        FUN_00015548(&DAT_00029d20);
      }
      else {
        pvVar6 = (void *)_ahpl_malloc(lVar8 * 8);
        if (pvVar6 != (void *)0x0) {
          _memcpy(puVar5,DAT_00028cb8,
                  (long)DAT_00028cc0 * 0x20000000 + 0x7e0000000 >> 0x20 & 0xfffffffffffffff8);
          _memcpy(pvVar6,DAT_00028cc8,(long)DAT_00028cc0 << 3);
          iVar2 = (int)lVar8;
          _bzero((void *)((long)pvVar6 + (long)DAT_00028cc0 * 8),
                 -(ulong)((uint)(iVar2 - DAT_00028cc0) >> 0x1f) & 0xfffffff800000000 |
                 (ulong)(uint)(iVar2 - DAT_00028cc0) << 3);
          if (DAT_00028cb8 != &DAT_0002eb90) {
            _free(DAT_00028cb8);
            _free(DAT_00028cc8);
          }
          DAT_00028cb8 = puVar5;
          DAT_00028cc0 = iVar2;
          DAT_00028cc8 = pvVar6;
          uVar4 = FUN_0000ef84();
          if (iVar2 <= (int)uVar4) {
            uVar7 = 0x69;
            goto LAB_0000e104;
          }
          goto LAB_0000df2c;
        }
        FUN_00015548(&DAT_00029d20);
        _free(puVar5);
      }
      uVar4 = 0xfffffff4;
    }
    else {
      FUN_00015548(&DAT_00029d20);
      uVar4 = 0xffffffac;
    }
    iVar2 = (int)uVar4;
    FUN_0000f02c(param_1[2]);
  }
  FUN_0000f040();
LAB_0000e0d0:
  return (ulong **)(long)iVar2;
}



void FUN_0000e114(undefined8 param_1)

{
  FUN_0000e11c(param_1,1);
  return;
}



long FUN_0000e11c(uint param_1,int param_2)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long lVar4;
  long lVar5;
  
  if ((short)param_1 < 0) {
    return 0;
  }
  FUN_00004bbc(&DAT_00029d68);
  if ((int)(param_1 & 0xffff) < DAT_00028cc0) {
    lVar5 = *(long *)(DAT_00028cc8 + (ulong)(param_1 & 0xffff) * 8);
    if (lVar5 == 0) goto LAB_0000e194;
    if (*(uint *)(lVar5 + 0x18) == param_1) {
      piVar1 = (int *)(lVar5 + 0x1c);
      do {
        cVar2 = '\x01';
        bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
        if (bVar3) {
          *piVar1 = *piVar1 + 1;
          cVar2 = ExclusiveMonitorsStatus();
        }
      } while (cVar2 != '\0');
      goto LAB_0000e194;
    }
  }
  lVar5 = 0;
LAB_0000e194:
  FUN_00004c24(&DAT_00029d68);
  if (((param_2 != 0) && (lVar5 != 0)) && ((*(byte *)(lVar5 + 0x133) >> 4 & 1) != 0)) {
    lVar4 = FUN_0000ef78();
    *(int *)(lVar4 + 0x24) = *(int *)(lVar4 + 0x24) + 1;
    FUN_0000e380();
  }
  return lVar5;
}



void FUN_0000e1e0(long *param_1)

{
  long lVar1;
  undefined8 uVar2;
  int extraout_w8;
  int extraout_w9;
  
  if ((*(byte *)((long)param_1 + 0x133) >> 4 & 1) != 0) {
    lVar1 = FUN_0000ef70(param_1);
    if (lVar1 == 0) {
                    // WARNING: Subroutine does not return
      _abort();
    }
    *(int *)(lVar1 + 0x24) = *(int *)(lVar1 + 0x24) + -1;
    FUN_0000e380();
  }
  FUN_0000ef50();
  if (extraout_w9 != 0) {
    FUN_0000f014();
    return;
  }
  if ((code *)param_1[2] != (code *)0x0) {
    (*(code *)param_1[2])(param_1[1]);
  }
  if (*(long *)(*param_1 + 0x10) != 0) {
    FUN_0000f02c();
  }
  FUN_0000ef94(DAT_00028cc0);
  if (extraout_w8 == 0) {
    uVar2 = FUN_00015504(&DAT_00029d20);
    FUN_0000effc(uVar2,DAT_00028cb8);
    FUN_00015548(&DAT_00029d20);
    _free(param_1);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0000efa4(
              "/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/refobj.c"
              );
}



long FUN_0000e2a8(long param_1,int param_2)

{
  pthread_t p_Var1;
  long lVar2;
  undefined8 uVar3;
  
  p_Var1 = _pthread_self();
  FUN_00004bbc(param_1 + 0x180);
  lVar2 = _ahpl_find_rb_node(param_1 + 0x248,0);
  if (lVar2 != 0) {
    *(int *)(lVar2 + 0x20) = *(int *)(lVar2 + 0x20) + 1;
  }
  FUN_00004c24(param_1 + 0x180);
  if ((param_2 == 0) || (lVar2 != 0)) {
    if (lVar2 == 0) {
      return 0;
    }
  }
  else {
    lVar2 = _ahpl_malloc(0x38);
    if (lVar2 == 0) {
                    // WARNING: Subroutine does not return
      _abort();
    }
    *(pthread_t *)(lVar2 + 0x18) = p_Var1;
    *(undefined4 *)(lVar2 + 0x28) = 0;
    *(undefined8 *)(lVar2 + 0x20) = 2;
    FUN_0000efc4();
    _ahpl_rb_insert_node(param_1 + 0x248,lVar2);
    FUN_0000efcc();
  }
  uVar3 = _ahpl_tick_now();
  *(undefined8 *)(lVar2 + 0x30) = uVar3;
  return lVar2;
}



void FUN_0000e380(void *param_1)

{
  int iVar1;
  
  iVar1 = *(int *)((long)param_1 + 0x20) + -1;
  *(int *)((long)param_1 + 0x20) = iVar1;
  if (iVar1 != 0) {
    return;
  }
  _free(param_1);
  return;
}



void FUN_0000e398(void)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  long unaff_x19;
  
  iVar1 = FUN_0000f00c();
  if ((iVar1 == 0) || ((*(byte *)(unaff_x19 + 0x133) >> 6 & 1) != 0)) {
    lVar2 = FUN_0000ef78();
    iVar1 = *(int *)(lVar2 + 0x28);
    if ((iVar1 < 0) || ((iVar1 != 0 && ((*(uint *)(unaff_x19 + 0x130) >> 0x1d & 1) == 0)))) {
                    // WARNING: Subroutine does not return
      _abort();
    }
    *(int *)(lVar2 + 0x28) = iVar1 + 1;
    FUN_0000e380();
    if (iVar1 == 0) {
      FUN_00004bbc(unaff_x19 + 0x68);
    }
    if (*(int *)(unaff_x19 + 0x130) < 0) {
      FUN_0000e40c();
      uVar3 = 0xffffffff;
      goto LAB_0000e400;
    }
  }
  uVar3 = 0;
LAB_0000e400:
  FUN_0000eee8(uVar3);
  return;
}



void FUN_0000e40c(long param_1)

{
  uint uVar1;
  long lVar2;
  
  lVar2 = FUN_0000ef70();
  if (lVar2 != 0) {
    uVar1 = *(int *)(lVar2 + 0x28) - 1;
    *(uint *)(lVar2 + 0x28) = uVar1;
    FUN_0000e380();
    if ((uVar1 & 0x7fffffff) == 0) {
      FUN_00004c24(param_1 + 0x68);
    }
    FUN_0000ef68(param_1);
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_0000e454(void)

{
  int iVar1;
  long unaff_x19;
  
  iVar1 = FUN_0000f00c();
  if ((iVar1 != 0) && ((*(byte *)(unaff_x19 + 0x133) >> 6 & 1) == 0)) {
    return;
  }
  FUN_0000e40c();
  return;
}



void _ahpl_ref_create(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                     undefined8 param_5)

{
  ulong uVar1;
  
  uVar1 = FUN_0000de70(&DAT_00028ca0,param_1,param_2,param_3,param_4,param_5);
  if ((uVar1 == 0) || (0xfffffffffffff000 < uVar1)) {
    ___error();
    uVar1 = FUN_0000eed4();
  }
  else {
    uVar1 = (ulong)*(uint *)(uVar1 + 0x18);
  }
  FUN_0000eee8(uVar1);
  return;
}



void _ahpl_ref_hold(void)

{
  undefined4 uVar1;
  uint uVar2;
  
  uVar1 = FUN_0000eef0();
  uVar2 = FUN_0000e518(uVar1,0);
  if (0xfffff000 < uVar2) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000ef18();
  return;
}



void FUN_0000e518(void)

{
  long in_x3;
  undefined8 *in_x4;
  long lVar1;
  undefined8 uVar2;
  undefined8 *local_20;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  local_20 = in_x4;
  if (in_x3 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
      FUN_0000e630();
      return;
    }
  }
  else {
    lVar1 = 0;
    do {
      uVar2 = *local_20;
      local_20 = local_20 + 1;
      *(undefined8 *)((long)&local_20 + (lVar1 * 8 - (in_x3 * 8 + 0xfU & 0xfffffffffffffff0))) =
           uVar2;
      lVar1 = lVar1 + 1;
    } while (in_x3 != lVar1);
    FUN_0000e630();
    if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_ref_hold_args(void)

{
  uint uVar1;
  
  FUN_0000efd4();
  uVar1 = FUN_0000e518();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000eee8();
  return;
}



void _ahpl_ref_hold_argv(void)

{
  uint uVar1;
  
  FUN_0000efd4();
  uVar1 = FUN_0000e630();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000eee8();
  return;
}



void FUN_0000e630(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 param_5)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    uVar2 = 0xffffffea;
  }
  else {
    uVar2 = FUN_0000e948(lVar1,param_2,param_3,param_4,param_5);
    FUN_0000e1e0(lVar1);
  }
  FUN_0000efb4(uVar2);
  return;
}



void _ahpl_ref_read(void)

{
  undefined4 uVar1;
  uint uVar2;
  
  uVar1 = FUN_0000eef0();
  uVar2 = FUN_0000e518(uVar1,1);
  if (0xfffff000 < uVar2) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000ef18();
  return;
}



void _ahpl_ref_read_args(void)

{
  uint uVar1;
  
  FUN_0000ef24();
  uVar1 = FUN_0000e518();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000eee8();
  return;
}



void _ahpl_ref_read_argv(void)

{
  uint uVar1;
  
  FUN_0000ef24();
  uVar1 = FUN_0000e630();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000eee8();
  return;
}



void _ahpl_ref_write(void)

{
  undefined4 uVar1;
  uint uVar2;
  
  uVar1 = FUN_0000eef0();
  uVar2 = FUN_0000e518(uVar1,2);
  if (0xfffff000 < uVar2) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000ef18();
  return;
}



void _ahpl_ref_write_args(void)

{
  uint uVar1;
  
  FUN_0000efe8();
  uVar1 = FUN_0000e518();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000eee8();
  return;
}



void _ahpl_ref_write_argv(void)

{
  uint uVar1;
  
  FUN_0000efe8();
  uVar1 = FUN_0000e630();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000eee8();
  return;
}



void _ahpl_refobj_read(void)

{
  uint uVar1;
  
  uVar1 = FUN_0000e800();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000ef18();
  return;
}



void FUN_0000e800(long param_1,undefined8 param_2,long param_3,undefined8 *param_4)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 *local_20;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  local_20 = param_4;
  if (param_1 == 1) {
    param_1 = 0xffffffea;
  }
  else {
    if (param_3 == 0) {
      if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
        FUN_0000e948(param_1,1,param_2,0,0);
        return;
      }
      goto LAB_0000e8d8;
    }
    lVar1 = 0;
    do {
      uVar2 = *local_20;
      local_20 = local_20 + 1;
      *(undefined8 *)((long)&local_20 + (lVar1 * 8 - (param_3 * 8 + 0xfU & 0xfffffffffffffff0))) =
           uVar2;
      lVar1 = lVar1 + 1;
    } while (param_3 != lVar1);
    param_1 = FUN_0000e948(param_1,1,param_2,param_3);
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
    return;
  }
LAB_0000e8d8:
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(param_1);
}



void _ahpl_refobj_read_args(void)

{
  uint uVar1;
  
  uVar1 = FUN_0000e800();
  if (0xfffff000 < uVar1) {
    FUN_0000eee0();
    FUN_0000eed4();
  }
  FUN_0000eee8();
  return;
}



void _ahpl_refobj_read_argv(long param_1)

{
  uint uVar1;
  
  if (param_1 != 1) {
    FUN_0000ef24();
    uVar1 = FUN_0000e948();
    if (uVar1 < 0xfffff001) goto LAB_0000e940;
  }
  ___error();
  FUN_0000eed4();
LAB_0000e940:
  FUN_0000eee8();
  return;
}



void FUN_0000e948(long param_1,int param_2)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  uint uVar4;
  
  if (param_2 == 1) {
    uVar3 = FUN_0000e398(param_1);
    if ((int)uVar3 < 0) goto LAB_0000ea00;
    FUN_0000ef08();
    FUN_0000e454(param_1);
  }
  else if (param_2 == 2) {
    iVar1 = FUN_00009f18(param_1);
    if (iVar1 == 0) {
      uVar4 = 0;
    }
    else {
      uVar4 = (*(uint *)(param_1 + 0x130) >> 0x1e ^ 0xffffffff) & 1;
    }
    lVar2 = FUN_0000ef78();
    if (*(int *)(lVar2 + 0x28) != 0) {
LAB_0000ea18:
                    // WARNING: Subroutine does not return
      _abort();
    }
    *(undefined4 *)(lVar2 + 0x28) = 0x80000000;
    FUN_0000e380();
    if (uVar4 == 0) {
      FUN_00015504(param_1 + 0x20);
    }
    else {
      FUN_0001556c();
    }
    if (*(int *)(param_1 + 0x130) < 0) {
      FUN_0000f034();
      if (uVar4 == 0) {
        uVar3 = 0xffffffff;
        goto LAB_0000ea00;
      }
      goto LAB_0000ea18;
    }
    FUN_0000ef08();
    FUN_0000f034();
  }
  else {
    FUN_0000ef08();
  }
  uVar3 = 0;
LAB_0000ea00:
  FUN_0000efb4(uVar3);
  return;
}



undefined8 _ahpl_refobj_arg(long param_1)

{
  return *(undefined8 *)(param_1 + 8);
}



undefined4 _ahpl_refobj_id(long param_1)

{
  return *(undefined4 *)(param_1 + 0x18);
}



void _ahpl_ref_locked(undefined8 param_1)

{
  short sVar1;
  bool bVar2;
  int iVar3;
  long lVar4;
  int extraout_w9;
  long *unaff_x19;
  
  lVar4 = FUN_0000e11c(param_1,0);
  if (lVar4 == 0) {
    bVar2 = false;
  }
  else {
    iVar3 = FUN_0000f00c();
    if ((iVar3 == 0) || ((*(byte *)((long)unaff_x19 + 0x133) >> 6 & 1) != 0)) {
      lVar4 = FUN_0000ef70();
      if (lVar4 == 0) {
        bVar2 = false;
      }
      else {
        bVar2 = (*(uint *)(lVar4 + 0x28) & 0x7fffffff) != 0;
        FUN_0000e380();
      }
    }
    else {
      bVar2 = true;
    }
    FUN_0000ef50();
    if (extraout_w9 == 0) {
      sVar1 = *(short *)(unaff_x19 + 3);
      if ((code *)unaff_x19[2] != (code *)0x0) {
        (*(code *)unaff_x19[2])(unaff_x19[1]);
      }
      if (*(long *)(*unaff_x19 + 0x10) != 0) {
        FUN_0000f02c();
      }
      if (((uint)(DAT_00028cc0 <= sVar1) | (uint)(int)sVar1 >> 0x1f) != 0) {
                    // WARNING: Subroutine does not return
        FUN_0000efa4(
                    "/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/refobj.c"
                    );
      }
      FUN_00015504(&DAT_00029d20);
      FUN_000040ac((long)sVar1,DAT_00028cb8);
      FUN_00015548(&DAT_00029d20);
      FUN_0000f040();
    }
  }
  FUN_0000f020(bVar2);
  return;
}



undefined8 _ahpl_ref_destroy(undefined8 param_1,int param_2)

{
  int iVar1;
  uint uVar2;
  long *plVar3;
  long lVar4;
  ulong uVar5;
  undefined8 uVar6;
  int extraout_w8;
  int extraout_w8_00;
  int extraout_w9;
  int extraout_w9_00;
  
  plVar3 = (long *)FUN_0000e11c(param_1,0);
  if (plVar3 == (long *)0x0) goto LAB_0000eb84;
  iVar1 = FUN_00009f18();
  if ((iVar1 != 0) && ((*(byte *)((long)plVar3 + 0x133) >> 6 & 1) == 0)) {
LAB_0000ed40:
                    // WARNING: Subroutine does not return
    _abort();
  }
  lVar4 = FUN_0000ef70(plVar3);
  if (lVar4 == 0) {
    iVar1 = 1;
    uVar5 = 0;
  }
  else {
    iVar1 = *(int *)(lVar4 + 0x24);
    uVar2 = *(uint *)(lVar4 + 0x28);
    uVar5 = FUN_0000e380();
    if ((uVar2 & 0x7fffffff) != 0) goto LAB_0000ed40;
    iVar1 = iVar1 + 1;
  }
  if (param_2 != 0) {
    if (((uint)param_1 >> 0xf & 1) != 0) {
      uVar6 = 0xa6;
      goto LAB_0000ed70;
    }
    uVar2 = (uint)(short)param_1;
    if (DAT_00028cc0 <= (int)uVar2) {
      uVar6 = 0xa8;
      goto LAB_0000ed70;
    }
    FUN_00015504(&DAT_00029d20);
    if (*(long **)(DAT_00028cc8 + (ulong)uVar2 * 8) == plVar3) {
      *(undefined8 *)(DAT_00028cc8 + (ulong)uVar2 * 8) = 0;
      uVar5 = FUN_00015548(&DAT_00029d20);
      goto LAB_0000ebfc;
    }
    uVar5 = FUN_00015548(&DAT_00029d20);
    uVar2 = 0xffffffea;
LAB_0000ecbc:
    FUN_0000ef38(uVar5);
    if (extraout_w9_00 == 0) {
      if ((code *)plVar3[2] != (code *)0x0) {
        (*(code *)plVar3[2])(plVar3[1]);
      }
      if (*(code **)(*plVar3 + 0x10) != (code *)0x0) {
        (**(code **)(*plVar3 + 0x10))(plVar3);
      }
      FUN_0000ef94(DAT_00028cc0);
      if (extraout_w8_00 != 0) goto LAB_0000ed64;
      uVar6 = FUN_00015504(&DAT_00029d20);
      FUN_0000effc(uVar6,DAT_00028cb8);
      FUN_00015548(&DAT_00029d20);
      FUN_0000f004();
    }
    if (uVar2 < 0xfffff001) {
      return 0;
    }
LAB_0000eb84:
    ___error();
    uVar6 = FUN_0000eed4();
    return uVar6;
  }
LAB_0000ebfc:
  if (*(int *)(plVar3 + 0x26) < 0) {
    uVar2 = 0xffffffff;
    if (param_2 != 0) goto LAB_0000ec30;
    goto LAB_0000ecbc;
  }
  FUN_0000efc4();
  uVar2 = (int)*(uint *)(plVar3 + 0x26) >> 0x1f;
  *(uint *)(plVar3 + 0x26) = *(uint *)(plVar3 + 0x26) | 0x80000000;
  uVar5 = FUN_0000efcc();
  if (param_2 == 0) goto LAB_0000ecbc;
LAB_0000ec30:
  uVar5 = FUN_0000ef38();
  if (extraout_w9 != 0) {
LAB_0000ec88:
    if ((*(uint *)(plVar3 + 0x26) & 0x50000000) == 0x10000000) {
      while (iVar1 < *(int *)((long)plVar3 + 0x1c)) {
        uVar2 = _usleep(1000);
        uVar5 = (ulong)uVar2;
      }
    }
    uVar2 = 0;
    goto LAB_0000ecbc;
  }
  if ((code *)plVar3[2] != (code *)0x0) {
    (*(code *)plVar3[2])(plVar3[1]);
  }
  if (*(code **)(*plVar3 + 0x10) != (code *)0x0) {
    (**(code **)(*plVar3 + 0x10))(plVar3);
  }
  FUN_0000ef94(DAT_00028cc0);
  if (extraout_w8 == 0) {
    uVar6 = FUN_0000efc4();
    FUN_0000effc(uVar6,DAT_00028cb8);
    FUN_0000efcc();
    uVar5 = FUN_0000f004();
    goto LAB_0000ec88;
  }
LAB_0000ed64:
  uVar6 = 0x74;
LAB_0000ed70:
                    // WARNING: Subroutine does not return
  FUN_000132b8("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/refobj.c"
               ,uVar6);
}



int FUN_0000ed7c(long param_1,long param_2,ulong *param_3)

{
  int iVar1;
  ulong uVar2;
  
  if (param_2 == 0) {
    uVar2 = *param_3;
  }
  else {
    uVar2 = *(ulong *)(param_2 + 0x18);
  }
  iVar1 = -(uint)(*(ulong *)(param_1 + 0x18) < uVar2);
  if (uVar2 < *(ulong *)(param_1 + 0x18)) {
    iVar1 = 1;
  }
  return iVar1;
}



void FUN_0000edb8(long param_1)

{
  if (0x40 < *(ulong *)(param_1 + 600)) {
    FUN_00015504(param_1 + 0x138);
    _ahpl_rb_traverse_lrd(param_1 + 0x248,FUN_0000ee18,param_1);
    FUN_00015548(param_1 + 0x138);
    return;
  }
  FUN_0000f014();
  return;
}



void FUN_0000ee18(long param_1,long param_2)

{
  int iVar1;
  
  iVar1 = _ahpl_tick_now();
  if ((((*(int *)(param_1 + 0x20) == 1) && (*(int *)(param_1 + 0x24) == 0)) &&
      (*(int *)(param_1 + 0x28) == 0)) && (59999 < iVar1 - *(int *)(param_1 + 0x30))) {
    FUN_00015e64(param_1,param_2 + 0x248);
    iVar1 = *(int *)(param_1 + 0x20) + -1;
    *(int *)(param_1 + 0x20) = iVar1;
    if (iVar1 == 0) {
      FUN_0000f040();
    }
  }
  FUN_0000eee8(0);
  return;
}



void FUN_0000ee8c(long param_1,int param_2)

{
  long lVar1;
  
  lVar1 = FUN_0000ef70();
  if (lVar1 != 0) {
    *(undefined4 *)(lVar1 + 0x28) = 0;
    FUN_0000e380();
    if (param_2 == 0) {
      FUN_00015548(param_1 + 0x20);
    }
    else {
      FUN_000155c4();
    }
    FUN_0000ef68(param_1);
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



undefined8 FUN_0000eed4(undefined4 *param_1)

{
  undefined4 unaff_w19;
  
  *param_1 = unaff_w19;
  return 0xffffffff;
}



void FUN_0000eee0(void)

{
  ___error();
  return;
}



void FUN_0000eee8(void)

{
  return;
}



void FUN_0000eef0(void)

{
  return;
}



void FUN_0000ef08(void)

{
  long unaff_x19;
  code *UNRECOVERED_JUMPTABLE;
  
                    // WARNING: Could not recover jumptable at 0x0000ef14. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)(*(undefined8 *)(unaff_x19 + 8));
  return;
}



void FUN_0000ef18(void)

{
  return;
}



void FUN_0000ef24(void)

{
  return;
}



void FUN_0000ef38(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long unaff_x20;
  
  piVar1 = (int *)(unaff_x20 + 0x1c);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_0000ef50(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long unaff_x19;
  
  piVar1 = (int *)(unaff_x19 + 0x1c);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_0000ef68(void)

{
  FUN_0000edb8();
  return;
}



void FUN_0000ef70(undefined8 param_1)

{
  FUN_0000e2a8(param_1,0);
  return;
}



void FUN_0000ef78(void)

{
  FUN_0000e2a8();
  return;
}



void FUN_0000ef84(void)

{
  FUN_000168b0();
  return;
}



void FUN_0000ef94(void)

{
  return;
}



void FUN_0000efa4(undefined8 param_1)

{
                    // WARNING: Subroutine does not return
  FUN_000132b8(param_1,0x74);
}



void FUN_0000efb4(void)

{
  return;
}



void FUN_0000efc4(void)

{
  FUN_00015504();
  return;
}



void FUN_0000efcc(void)

{
  FUN_00015548();
  return;
}



void FUN_0000efd4(void)

{
  return;
}



void FUN_0000efe8(void)

{
  return;
}



void FUN_0000effc(void)

{
  FUN_000040ac();
  return;
}



void FUN_0000f004(void)

{
  void *unaff_x20;
  
  _free(unaff_x20);
  return;
}



void FUN_0000f00c(void)

{
  FUN_00009f18();
  return;
}



void FUN_0000f014(void)

{
  return;
}



void FUN_0000f020(void)

{
  return;
}



void FUN_0000f02c(code *UNRECOVERED_JUMPTABLE)

{
                    // WARNING: Could not recover jumptable at 0x0000f030. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_0000f034(void)

{
  FUN_0000ee8c();
  return;
}



void FUN_0000f040(void)

{
  void *unaff_x19;
  
  _free(unaff_x19);
  return;
}



void FUN_0000f048(void *param_1,undefined8 param_2)

{
  if (param_1 != (void *)0x0) {
    FUN_0000f078(param_1,param_2,1);
    _free(param_1);
    return;
  }
  return;
}



long FUN_0000f078(undefined8 param_1,long param_2,undefined8 param_3)

{
  code *pcVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  long lVar5;
  void *pvVar6;
  long lVar7;
  int extraout_w8;
  int extraout_w9;
  undefined8 uVar8;
  long local_a0;
  int local_94;
  undefined8 local_90;
  undefined8 local_88;
  undefined8 local_80;
  undefined4 local_78;
  long local_70;
  undefined8 local_68;
  
  lVar5 = FUN_000090e4();
  if (DAT_000298e0 == (code *)0x0) {
    local_94 = 0;
    iVar2 = 0;
  }
  else {
    iVar2 = _ahpl_tick_us();
    if (param_2 == 0) {
      local_94 = 0;
    }
    else {
      FUN_00011e28();
      local_94 = iVar2 + extraout_w8 * extraout_w9;
    }
  }
  pvVar6 = (void *)FUN_00010570(param_1);
  if (pvVar6 == (void *)0x0) {
    local_a0 = 0;
  }
  else {
    local_a0 = 0;
    do {
      local_90 = *(undefined8 *)((long)pvVar6 + 0x10);
      local_88 = 0;
      local_80 = 0;
      local_78 = 0;
      local_70 = 0;
      local_68 = 0;
      if (DAT_000298e0 != (code *)0x0) {
        iVar2 = _ahpl_tick_us();
      }
      uVar8 = *(undefined8 *)(lVar5 + 0x1a0);
      *(undefined8 **)(lVar5 + 0x1a0) = &local_90;
      lVar7 = _objc_autoreleasePoolPush();
      iVar3 = (**(code **)((long)pvVar6 + 0x20))
                        (param_3,*(undefined8 *)((long)pvVar6 + 0x28),(long)pvVar6 + 0x30);
      if (lVar7 != 0) {
        FUN_00011b40();
      }
      *(undefined8 *)(lVar5 + 0x1a0) = uVar8;
      pcVar1 = DAT_000298e0;
      if (DAT_000298e0 != (code *)0x0) {
        uVar8 = *(undefined8 *)((long)pvVar6 + 0x18);
        iVar4 = _ahpl_tick_us();
        (*pcVar1)(uVar8,param_3,local_94,iVar4 - iVar2);
      }
      uVar8 = local_88;
      local_88 = 0;
      FUN_00011c10(uVar8);
      local_80 = 0;
      local_78 = 0;
      if (local_70 != 0) {
        FUN_00011bdc();
        local_70 = 0;
      }
      local_68 = 0;
      if (iVar3 < 0) {
        if (local_a0 == 0) {
          local_a0 = *(long *)((long)pvVar6 + 0x10);
        }
        param_3 = 1;
      }
      _free(*(void **)((long)pvVar6 + 0x18));
      _free(pvVar6);
      pvVar6 = (void *)FUN_00010570(param_1);
    } while (pvVar6 != (void *)0x0);
  }
  return local_a0;
}



void FUN_0000f214(int *param_1,int *param_2)

{
  int iVar1;
  char cVar2;
  code *pcVar3;
  bool bVar4;
  int iVar5;
  int iVar6;
  long lVar7;
  void *pvVar8;
  long lVar9;
  ulong uVar10;
  int *piVar11;
  int **ppiVar12;
  long *plVar13;
  long lVar14;
  undefined8 uVar15;
  int local_98;
  undefined8 local_90;
  undefined8 local_88;
  undefined8 local_80;
  undefined4 local_78;
  ulong local_70;
  undefined8 local_68;
  
  do {
    iVar1 = *param_1;
    cVar2 = '\x01';
    bVar4 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar4) {
      *param_1 = iVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  if (iVar1 + -1 == 0) {
    ppiVar12 = (int **)(param_1 + 2);
    iVar1 = param_1[1];
    lVar7 = FUN_000090e4();
    if (DAT_000298e0 == (code *)0x0) {
      local_98 = 0;
      iVar5 = 0;
    }
    else {
      iVar5 = _ahpl_tick_us();
      if (param_2 == (int *)0x0) {
        local_98 = 0;
      }
      else {
        local_98 = iVar5 + *param_2 * -1000;
      }
    }
    pvVar8 = (void *)FUN_00010570(ppiVar12);
    while (pvVar8 != (void *)0x0) {
      local_90 = *(undefined8 *)((long)pvVar8 + 0x10);
      local_88 = 0;
      local_80 = 0;
      local_78 = 0;
      local_70 = 0;
      local_68 = 0;
      lVar14 = *(long *)(lVar7 + 0x1a0);
      if (DAT_000298e0 != (code *)0x0) {
        iVar5 = _ahpl_tick_us();
      }
      if (iVar1 == 0) {
        uVar10 = *(ulong *)(lVar14 + 0x10);
        if (*(int *)(lVar14 + 0x18) < 0) {
          if (uVar10 != 0) goto LAB_0000f318;
          goto LAB_0000f2f4;
        }
        if (uVar10 == 0) {
          bVar4 = false;
        }
        else {
LAB_0000f318:
          bVar4 = uVar10 <= *(ulong *)((long)pvVar8 + 0x10);
        }
      }
      else {
LAB_0000f2f4:
        bVar4 = true;
      }
      *(undefined8 **)(lVar7 + 0x1a0) = &local_90;
      lVar9 = _objc_autoreleasePoolPush();
      (**(code **)((long)pvVar8 + 0x20))
                (bVar4,*(undefined8 *)((long)pvVar8 + 0x28),(long)pvVar8 + 0x30);
      if (lVar9 != 0) {
        FUN_00011b40();
      }
      *(long *)(lVar7 + 0x1a0) = lVar14;
      pcVar3 = DAT_000298e0;
      if (DAT_000298e0 != (code *)0x0) {
        uVar15 = *(undefined8 *)((long)pvVar8 + 0x18);
        iVar6 = _ahpl_tick_us();
        (*pcVar3)(uVar15,iVar1 != 0,local_98,iVar6 - iVar5);
      }
      _free(*(void **)((long)pvVar8 + 0x18));
      _free(pvVar8);
      uVar10 = local_70;
      uVar15 = local_88;
      local_88 = 0;
      FUN_00011c10(uVar15);
      local_80 = 0;
      local_78 = 0;
      if (local_70 != 0) {
        FUN_00011bdc();
        local_70 = 0;
      }
      local_68 = 0;
      if ((uVar10 != 0) && (uVar10 < 0xfffffffffffff001)) {
        piVar11 = *ppiVar12;
        if ((int **)piVar11 != ppiVar12) {
          ppiVar12 = *(int ***)(uVar10 + 0x10);
          plVar13 = *(long **)(param_1 + 4);
          *(int ***)(piVar11 + 2) = ppiVar12;
          *ppiVar12 = piVar11;
          *plVar13 = uVar10 + 8;
          *(long **)(uVar10 + 0x10) = plVar13;
        }
        break;
      }
      pvVar8 = (void *)FUN_00010570(ppiVar12);
    }
    _free(param_1);
  }
  return;
}



undefined4
_ahpl_task_create(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 param_5,undefined8 param_6,long param_7,undefined8 param_8)

{
  ulong uVar1;
  int *piVar2;
  uint uVar3;
  undefined8 uVar4;
  
  uVar3 = (uint)param_3;
  if (uVar3 < 4) {
    if (param_7 != 0) {
LAB_0000f49c:
      ___error();
      FUN_00011dcc();
      return 0xffffffff;
    }
    if (uVar3 == 3) {
      uVar4 = 1;
      goto LAB_0000f460;
    }
  }
  else if (uVar3 != 4) goto LAB_0000f49c;
  uVar4 = 0;
LAB_0000f460:
  uVar1 = FUN_0000de70(&DAT_00028cd8,param_1,param_2,uVar4,1,1,param_7,param_8,param_3,param_4,
                       param_5,param_6,param_7);
  if ((uVar1 != 0) && (uVar1 < 0xfffffffffffff001)) {
    return *(undefined4 *)(uVar1 + 0x18);
  }
  piVar2 = ___error();
  *piVar2 = -(int)uVar1;
  return 0xffffffff;
}



void _ahpl_task_get_type(void)

{
  long lVar1;
  int *piVar2;
  ulong uVar3;
  
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar3 = 0xffffffff;
  }
  else {
    uVar3 = (ulong)*(ushort *)(lVar1 + 0x260);
    FUN_0000e1e0();
  }
  FUN_00011b48(uVar3);
  return;
}



void _ahpl_task_exec(void)

{
  FUN_00011d28();
  FUN_0000f524();
  return;
}



void FUN_0000f524(void)

{
  undefined in_ZR;
  long in_x3;
  undefined8 in_x4;
  long unaff_x29;
  
  FUN_00011d8c();
  *(undefined8 *)(unaff_x29 + -8) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  *(undefined8 *)(unaff_x29 + -0x10) = in_x4;
  if (in_x3 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      FUN_00011d00();
      FUN_0000f5b8();
      return;
    }
  }
  else {
    FUN_00011d18(in_x3 << 3);
    do {
      FUN_00011b10();
    } while (!(bool)in_ZR);
    FUN_0000f5b8();
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_task_exec_args(void)

{
  undefined in_ZR;
  long in_x3;
  undefined8 in_x4;
  long unaff_x29;
  
  FUN_00011d8c();
  *(undefined8 *)(unaff_x29 + -8) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  *(undefined8 *)(unaff_x29 + -0x10) = in_x4;
  if (in_x3 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      FUN_00011d00();
      FUN_0000f5b8();
      return;
    }
  }
  else {
    FUN_00011d18(in_x3 << 3);
    do {
      FUN_00011b10();
    } while (!(bool)in_ZR);
    FUN_0000f5b8();
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_task_exec_argv
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,long param_4,
               undefined8 *param_5)

{
  ulong uVar1;
  char cVar2;
  bool bVar3;
  undefined in_ZR;
  bool bVar4;
  uint uVar5;
  long lVar6;
  undefined8 uVar7;
  undefined8 *puVar8;
  undefined8 uVar9;
  undefined8 extraout_x1;
  undefined4 uVar10;
  long lVar11;
  undefined8 *puVar12;
  int iVar13;
  int *piVar14;
  long lVar15;
  
  FUN_00011b88();
  lVar6 = FUN_0000e114();
  if (lVar6 == 0) {
    iVar13 = 0x16;
  }
  else {
    if ((*(byte *)(lVar6 + 0x263) >> 6 & 1) == 0) {
      uVar7 = FUN_00011ccc();
      if (-1 < (int)uVar7) {
        lVar15 = 0;
LAB_0000f5fc:
        piVar14 = (int *)0x0;
        goto LAB_0000f600;
      }
LAB_0000f82c:
      FUN_00011b30();
      if ((uint)uVar7 < 0xfffff001) goto LAB_0000f838;
    }
    else {
      lVar15 = FUN_000090e4();
      if ((lVar15 != 0) && (*(int *)(lVar15 + 0xa8) == 0)) {
        lVar15 = *(long *)(lVar15 + 0x1a0);
        if ((*(int *)(lVar15 + 0x28) != 0) && (*(int *)(lVar15 + 0x2c) != 0)) goto LAB_0000f894;
        uVar5 = *(uint *)(lVar6 + 0x260);
        if ((uVar5 >> 0x1e & 1) != 0) {
          lVar11 = FUN_000090e4();
          if (lVar11 == 0) {
            uVar10 = 0xffffffff;
          }
          else {
            uVar10 = *(undefined4 *)(lVar11 + 0x14);
          }
          FUN_00011c7c(uVar10);
          if (!(bool)in_ZR) goto LAB_0000f894;
          uVar5 = *(uint *)(lVar6 + 0x260);
        }
        if ((uVar5 >> 0x1d & 1) == 0) goto LAB_0000f5fc;
        piVar14 = *(int **)(lVar15 + 0x20);
        if (piVar14 == (int *)0x0) {
          piVar14 = (int *)_ahpl_malloc(0x18);
          if (piVar14 != (int *)0x0) {
            *piVar14 = 1;
            piVar14[1] = 0;
            *(int **)(piVar14 + 2) = piVar14 + 2;
            *(int **)(piVar14 + 4) = piVar14 + 2;
            *(int **)(lVar15 + 0x20) = piVar14;
            goto LAB_0000f600;
          }
          uVar7 = 0xfffffff4;
        }
        else {
LAB_0000f600:
          FUN_00011acc();
          lVar11 = *(long *)(lVar6 + 0x2d8);
          uVar5 = *(uint *)(lVar6 + 0x260);
          bVar4 = false;
          if (((lVar11 == 0) && ((int)uVar5 < 0)) && ((uVar5 & 0xffff) != 4)) {
            bVar4 = *(long *)(lVar6 + 0x310) != 0;
          }
          if ((~uVar5 & 0x60000000) == 0) {
            uVar7 = *(undefined8 *)(lVar15 + 8);
            *(undefined8 *)(lVar15 + 8) = 0;
            do {
              cVar2 = '\x01';
              bVar3 = (bool)ExclusiveMonitorPass(piVar14,0x10);
              if (bVar3) {
                *piVar14 = *piVar14 + 1;
                cVar2 = ExclusiveMonitorsStatus();
              }
            } while (cVar2 != '\0');
            piVar14[1] = piVar14[1] + 1;
            lVar11 = *(long *)(lVar6 + 0x2d8);
          }
          else {
            uVar7 = 0;
          }
          if ((bool)(bVar4 | lVar11 != 0)) {
            puVar8 = (undefined8 *)_ahpl_malloc(param_4 * 8 + 0x38);
            if (puVar8 == (undefined8 *)0x0) goto LAB_0000f894;
            uVar9 = _ahpl_strdup(extraout_x1);
            puVar8[1] = uVar9;
            puVar8[2] = uVar7;
            puVar8[3] = piVar14;
            uVar7 = _ahpl_tick_now();
            puVar8[4] = uVar7;
            puVar8[5] = param_3;
            puVar8[6] = param_4;
            if (param_4 != 0) {
              puVar12 = puVar8 + 7;
              do {
                *puVar12 = *param_5;
                param_4 = param_4 + -1;
                puVar12 = puVar12 + 1;
                param_5 = param_5 + 1;
              } while (param_4 != 0);
            }
            *puVar8 = 0;
            puVar12 = (undefined8 *)(lVar6 + 0x2b0);
            if (*(undefined8 **)(lVar6 + 0x2b8) != (undefined8 *)0x0) {
              puVar12 = *(undefined8 **)(lVar6 + 0x2b8);
            }
            *puVar12 = puVar8;
            *(undefined8 **)(lVar6 + 0x2b8) = puVar8;
            uVar1 = *(long *)(lVar6 + 0x2c0) + 1;
            *(ulong *)(lVar6 + 0x2c0) = uVar1;
            if ((3 < uVar1 && (*(uint *)(lVar6 + 0x260) & 0xffff) == 4) &&
               (*(char *)(lVar6 + 0x33d) < '\0')) {
              if ((*(uint *)(lVar6 + 0x260) >> 0x1e & 1) == 0) {
                uVar5 = DAT_00028c94;
                if ((short)DAT_00028c94 < 0) {
                  uVar5 = 0xffffffff;
                }
              }
              else {
                uVar5 = *(uint *)(lVar6 + 0x264);
              }
              if ((uVar5 >> 0xf & 1) != 0) {
LAB_0000f894:
                    // WARNING: Subroutine does not return
                _abort();
              }
              uVar5 = _ahpl_mpq_set_timer_on_q(uVar5,600,FUN_000109c8,0,1);
              *(uint *)(lVar6 + 0x33c) = uVar5;
              if ((uVar5 >> 0xf & 1) != 0) goto LAB_0000f894;
            }
            uVar7 = 0;
          }
          else {
            uVar7 = FUN_000107cc(lVar6,extraout_x1,param_3,param_4,param_5,uVar7,piVar14,0);
          }
          FUN_00011ad4();
          if ((~*(uint *)(lVar6 + 0x260) & 0x60000000) == 0) {
            *(int *)(lVar15 + 0x18) = (int)uVar7;
            if ((int)uVar7 < 0) {
              FUN_00011bdc(piVar14);
            }
            else {
              *(int *)(lVar15 + 0x2c) = *(int *)(lVar15 + 0x2c) + 1;
            }
          }
        }
        if ((*(byte *)(lVar6 + 0x263) >> 6 & 1) == 0) {
          FUN_00011be4();
        }
        goto LAB_0000f82c;
      }
      FUN_00011b30();
      uVar7 = 0xffffffff;
    }
    iVar13 = -(int)uVar7;
  }
  piVar14 = ___error();
  *piVar14 = iVar13;
  uVar7 = 0xffffffff;
LAB_0000f838:
  FUN_00011ba4(uVar7);
  return;
}



void FUN_0000f5b8(undefined8 param_1,undefined8 param_2,undefined8 param_3,long param_4,
                 undefined8 *param_5)

{
  ulong uVar1;
  char cVar2;
  bool bVar3;
  undefined in_ZR;
  bool bVar4;
  uint uVar5;
  long lVar6;
  undefined8 uVar7;
  undefined8 *puVar8;
  undefined8 uVar9;
  undefined8 extraout_x1;
  undefined4 uVar10;
  long lVar11;
  undefined8 *puVar12;
  int iVar13;
  int *piVar14;
  long lVar15;
  
  FUN_00011b88();
  lVar6 = FUN_0000e114();
  if (lVar6 == 0) {
    iVar13 = 0x16;
  }
  else {
    if ((*(byte *)(lVar6 + 0x263) >> 6 & 1) == 0) {
      uVar7 = FUN_00011ccc();
      if (-1 < (int)uVar7) {
        lVar15 = 0;
LAB_0000f5fc:
        piVar14 = (int *)0x0;
        goto LAB_0000f600;
      }
LAB_0000f82c:
      FUN_00011b30();
      if ((uint)uVar7 < 0xfffff001) goto LAB_0000f838;
    }
    else {
      lVar15 = FUN_000090e4();
      if ((lVar15 != 0) && (*(int *)(lVar15 + 0xa8) == 0)) {
        lVar15 = *(long *)(lVar15 + 0x1a0);
        if ((*(int *)(lVar15 + 0x28) != 0) && (*(int *)(lVar15 + 0x2c) != 0)) goto LAB_0000f894;
        uVar5 = *(uint *)(lVar6 + 0x260);
        if ((uVar5 >> 0x1e & 1) != 0) {
          lVar11 = FUN_000090e4();
          if (lVar11 == 0) {
            uVar10 = 0xffffffff;
          }
          else {
            uVar10 = *(undefined4 *)(lVar11 + 0x14);
          }
          FUN_00011c7c(uVar10);
          if (!(bool)in_ZR) goto LAB_0000f894;
          uVar5 = *(uint *)(lVar6 + 0x260);
        }
        if ((uVar5 >> 0x1d & 1) == 0) goto LAB_0000f5fc;
        piVar14 = *(int **)(lVar15 + 0x20);
        if (piVar14 == (int *)0x0) {
          piVar14 = (int *)_ahpl_malloc(0x18);
          if (piVar14 != (int *)0x0) {
            *piVar14 = 1;
            piVar14[1] = 0;
            *(int **)(piVar14 + 2) = piVar14 + 2;
            *(int **)(piVar14 + 4) = piVar14 + 2;
            *(int **)(lVar15 + 0x20) = piVar14;
            goto LAB_0000f600;
          }
          uVar7 = 0xfffffff4;
        }
        else {
LAB_0000f600:
          FUN_00011acc();
          lVar11 = *(long *)(lVar6 + 0x2d8);
          uVar5 = *(uint *)(lVar6 + 0x260);
          bVar4 = false;
          if (((lVar11 == 0) && ((int)uVar5 < 0)) && ((uVar5 & 0xffff) != 4)) {
            bVar4 = *(long *)(lVar6 + 0x310) != 0;
          }
          if ((~uVar5 & 0x60000000) == 0) {
            uVar7 = *(undefined8 *)(lVar15 + 8);
            *(undefined8 *)(lVar15 + 8) = 0;
            do {
              cVar2 = '\x01';
              bVar3 = (bool)ExclusiveMonitorPass(piVar14,0x10);
              if (bVar3) {
                *piVar14 = *piVar14 + 1;
                cVar2 = ExclusiveMonitorsStatus();
              }
            } while (cVar2 != '\0');
            piVar14[1] = piVar14[1] + 1;
            lVar11 = *(long *)(lVar6 + 0x2d8);
          }
          else {
            uVar7 = 0;
          }
          if ((bool)(bVar4 | lVar11 != 0)) {
            puVar8 = (undefined8 *)_ahpl_malloc(param_4 * 8 + 0x38);
            if (puVar8 == (undefined8 *)0x0) goto LAB_0000f894;
            uVar9 = _ahpl_strdup(extraout_x1);
            puVar8[1] = uVar9;
            puVar8[2] = uVar7;
            puVar8[3] = piVar14;
            uVar7 = _ahpl_tick_now();
            puVar8[4] = uVar7;
            puVar8[5] = param_3;
            puVar8[6] = param_4;
            if (param_4 != 0) {
              puVar12 = puVar8 + 7;
              do {
                *puVar12 = *param_5;
                param_4 = param_4 + -1;
                puVar12 = puVar12 + 1;
                param_5 = param_5 + 1;
              } while (param_4 != 0);
            }
            *puVar8 = 0;
            puVar12 = (undefined8 *)(lVar6 + 0x2b0);
            if (*(undefined8 **)(lVar6 + 0x2b8) != (undefined8 *)0x0) {
              puVar12 = *(undefined8 **)(lVar6 + 0x2b8);
            }
            *puVar12 = puVar8;
            *(undefined8 **)(lVar6 + 0x2b8) = puVar8;
            uVar1 = *(long *)(lVar6 + 0x2c0) + 1;
            *(ulong *)(lVar6 + 0x2c0) = uVar1;
            if ((3 < uVar1 && (*(uint *)(lVar6 + 0x260) & 0xffff) == 4) &&
               (*(char *)(lVar6 + 0x33d) < '\0')) {
              if ((*(uint *)(lVar6 + 0x260) >> 0x1e & 1) == 0) {
                uVar5 = DAT_00028c94;
                if ((short)DAT_00028c94 < 0) {
                  uVar5 = 0xffffffff;
                }
              }
              else {
                uVar5 = *(uint *)(lVar6 + 0x264);
              }
              if ((uVar5 >> 0xf & 1) != 0) {
LAB_0000f894:
                    // WARNING: Subroutine does not return
                _abort();
              }
              uVar5 = _ahpl_mpq_set_timer_on_q(uVar5,600,FUN_000109c8,0,1);
              *(uint *)(lVar6 + 0x33c) = uVar5;
              if ((uVar5 >> 0xf & 1) != 0) goto LAB_0000f894;
            }
            uVar7 = 0;
          }
          else {
            uVar7 = FUN_000107cc(lVar6,extraout_x1,param_3,param_4,param_5,uVar7,piVar14,0);
          }
          FUN_00011ad4();
          if ((~*(uint *)(lVar6 + 0x260) & 0x60000000) == 0) {
            *(int *)(lVar15 + 0x18) = (int)uVar7;
            if ((int)uVar7 < 0) {
              FUN_00011bdc(piVar14);
            }
            else {
              *(int *)(lVar15 + 0x2c) = *(int *)(lVar15 + 0x2c) + 1;
            }
          }
        }
        if ((*(byte *)(lVar6 + 0x263) >> 6 & 1) == 0) {
          FUN_00011be4();
        }
        goto LAB_0000f82c;
      }
      FUN_00011b30();
      uVar7 = 0xffffffff;
    }
    iVar13 = -(int)uVar7;
  }
  piVar14 = ___error();
  *piVar14 = iVar13;
  uVar7 = 0xffffffff;
LAB_0000f838:
  FUN_00011ba4(uVar7);
  return;
}



void _ahpl_task_async_done(undefined8 param_1)

{
  FUN_0000f8a0(param_1,0);
  return;
}



void FUN_0000f8a0(undefined8 param_1,undefined8 param_2)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  undefined8 local_28;
  
  local_28 = param_2;
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    ___error();
    FUN_00011dcc();
  }
  else {
    if (*(short *)(lVar1 + 0x260) == 4) {
      uVar2 = FUN_00011ccc();
      if (-1 < (int)uVar2) {
        FUN_00011acc();
        uVar2 = FUN_000110ec(lVar1,"__task_async_op_done",FUN_0001176c,1,&local_28);
        FUN_00011ad4();
        FUN_00011be4();
      }
      FUN_00011b30();
      if ((uint)uVar2 < 0xfffff001) goto LAB_0000f940;
    }
    else {
      FUN_00011b30();
      uVar2 = 0xffffffea;
    }
    piVar3 = ___error();
    *piVar3 = -(int)uVar2;
  }
  uVar2 = 0xffffffff;
LAB_0000f940:
  FUN_00011c70(uVar2);
  return;
}



void _ahpl_task_async_done_opaque(undefined8 param_1,undefined8 param_2)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  undefined8 uStack_28;
  
  uStack_28 = param_2;
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    ___error();
    FUN_00011dcc();
  }
  else {
    if (*(short *)(lVar1 + 0x260) == 4) {
      uVar2 = FUN_00011ccc();
      if (-1 < (int)uVar2) {
        FUN_00011acc();
        uVar2 = FUN_000110ec(lVar1,"__task_async_op_done",FUN_0001176c,1,&uStack_28);
        FUN_00011ad4();
        FUN_00011be4();
      }
      FUN_00011b30();
      if ((uint)uVar2 < 0xfffff001) goto LAB_0000f940;
    }
    else {
      FUN_00011b30();
      uVar2 = 0xffffffea;
    }
    piVar3 = ___error();
    *piVar3 = -(int)uVar2;
  }
  uVar2 = 0xffffffff;
LAB_0000f940:
  FUN_00011c70(uVar2);
  return;
}



void _ahpl_task_exclusive_exec(void)

{
  FUN_0000f978();
  return;
}



void FUN_0000f978(undefined8 param_1,undefined8 param_2,long param_3,undefined8 param_4)

{
  long extraout_x8;
  long lVar1;
  long extraout_x9;
  undefined8 *puVar2;
  long unaff_x29;
  undefined auVar3 [16];
  
  auVar3 = FUN_00011d8c();
  *(undefined8 *)(unaff_x29 + -8) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  *(undefined8 *)(unaff_x29 + -0x10) = param_4;
  if (param_3 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      FUN_0000fa2c(auVar3._0_8_,auVar3._8_8_,0,0);
      return;
    }
  }
  else {
    FUN_00011d18(param_3 << 3);
    lVar1 = 0;
    do {
      puVar2 = *(undefined8 **)(unaff_x29 + -0x10);
      *(undefined8 **)(unaff_x29 + -0x10) = puVar2 + 1;
      *(undefined8 *)((extraout_x9 - extraout_x8) + lVar1 * 8) = *puVar2;
      lVar1 = lVar1 + 1;
    } while (param_3 != lVar1);
    FUN_0000fa2c();
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_task_exclusive_exec_args
               (undefined8 param_1,undefined8 param_2,long param_3,undefined8 param_4)

{
  long extraout_x8;
  long lVar1;
  long extraout_x9;
  undefined8 *puVar2;
  long unaff_x29;
  undefined auVar3 [16];
  
  auVar3 = FUN_00011d8c();
  *(undefined8 *)(unaff_x29 + -8) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  *(undefined8 *)(unaff_x29 + -0x10) = param_4;
  if (param_3 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      FUN_0000fa2c(auVar3._0_8_,auVar3._8_8_,0,0);
      return;
    }
  }
  else {
    FUN_00011d18(param_3 << 3);
    lVar1 = 0;
    do {
      puVar2 = *(undefined8 **)(unaff_x29 + -0x10);
      *(undefined8 **)(unaff_x29 + -0x10) = puVar2 + 1;
      *(undefined8 *)((extraout_x9 - extraout_x8) + lVar1 * 8) = *puVar2;
      lVar1 = lVar1 + 1;
    } while (param_3 != lVar1);
    FUN_0000fa2c();
    if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



undefined8
_ahpl_task_exclusive_exec_argv(undefined8 param_1,code *param_2,long param_3,undefined8 *param_4)

{
  long *plVar1;
  undefined in_ZR;
  uint uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 *puVar5;
  int *piVar6;
  uint extraout_w8;
  undefined4 uVar7;
  undefined8 *puVar8;
  long unaff_x19;
  
  lVar3 = FUN_0000e114();
  if (lVar3 == 0) {
    ___error();
    FUN_00011dcc();
    return 0xffffffff;
  }
  FUN_00011e58();
  uVar2 = extraout_w8;
  if ((extraout_w8 >> 0x1e & 1) != 0) {
    lVar3 = FUN_000090e4();
    if (lVar3 == 0) {
      uVar7 = 0xffffffff;
    }
    else {
      uVar7 = *(undefined4 *)(lVar3 + 0x14);
    }
    FUN_00011c7c(uVar7);
    if (!(bool)in_ZR) goto LAB_0000fbac;
    uVar2 = *(uint *)(unaff_x19 + 0x260);
  }
  if ((uVar2 >> 0x1e & 1) == 0) {
    uVar4 = FUN_00011ccc();
    uVar2 = (uint)uVar4;
    if ((int)uVar2 < 0) {
      FUN_00011b30();
      if (0xfffff000 < uVar2) {
        piVar6 = ___error();
        *piVar6 = -uVar2;
        return 0xffffffff;
      }
      return uVar4;
    }
  }
  FUN_00011acc();
  if (*(long *)(unaff_x19 + 0x2d8) == 0) {
    plVar1 = (long *)(unaff_x19 + 0x328);
    if (*(short *)(unaff_x19 + 0x260) != 4) {
      plVar1 = (long *)(unaff_x19 + 0x310);
    }
    if (*plVar1 == 0) {
      FUN_00011ad4();
      (*param_2)();
      FUN_00011acc();
      goto LAB_0000fb38;
    }
    puVar5 = (undefined8 *)FUN_00011e4c();
    if (puVar5 == (undefined8 *)0x0) goto LAB_0000fbac;
    puVar5[1] = param_2;
    puVar5[2] = param_3;
    if (param_3 != 0) {
      puVar8 = puVar5 + 3;
      do {
        *puVar8 = *param_4;
        param_3 = param_3 + -1;
        puVar8 = puVar8 + 1;
        param_4 = param_4 + 1;
      } while (param_3 != 0);
    }
  }
  else {
    puVar5 = (undefined8 *)FUN_00011e4c();
    if (puVar5 == (undefined8 *)0x0) {
LAB_0000fbac:
                    // WARNING: Subroutine does not return
      _abort();
    }
    puVar5[1] = param_2;
    puVar5[2] = param_3;
    if (param_3 != 0) {
      puVar8 = puVar5 + 3;
      do {
        *puVar8 = *param_4;
        param_3 = param_3 + -1;
        puVar8 = puVar8 + 1;
        param_4 = param_4 + 1;
      } while (param_3 != 0);
    }
  }
  *puVar5 = 0;
  puVar8 = (undefined8 *)(unaff_x19 + 0x2c8);
  if (*(undefined8 **)(unaff_x19 + 0x2d0) != (undefined8 *)0x0) {
    puVar8 = *(undefined8 **)(unaff_x19 + 0x2d0);
  }
  *puVar8 = puVar5;
  *(undefined8 **)(unaff_x19 + 0x2d0) = puVar5;
  *(long *)(unaff_x19 + 0x2d8) = *(long *)(unaff_x19 + 0x2d8) + 1;
LAB_0000fb38:
  FUN_00011ad4();
  if ((*(byte *)(unaff_x19 + 0x263) >> 6 & 1) == 0) {
    FUN_00011be4();
  }
  FUN_00011b30();
  return 0;
}



undefined8 FUN_0000fa2c(undefined8 param_1,code *param_2,long param_3,undefined8 *param_4)

{
  long *plVar1;
  undefined in_ZR;
  uint uVar2;
  long lVar3;
  undefined8 uVar4;
  undefined8 *puVar5;
  int *piVar6;
  uint extraout_w8;
  undefined4 uVar7;
  undefined8 *puVar8;
  long unaff_x19;
  
  lVar3 = FUN_0000e114();
  if (lVar3 == 0) {
    ___error();
    FUN_00011dcc();
    return 0xffffffff;
  }
  FUN_00011e58();
  uVar2 = extraout_w8;
  if ((extraout_w8 >> 0x1e & 1) != 0) {
    lVar3 = FUN_000090e4();
    if (lVar3 == 0) {
      uVar7 = 0xffffffff;
    }
    else {
      uVar7 = *(undefined4 *)(lVar3 + 0x14);
    }
    FUN_00011c7c(uVar7);
    if (!(bool)in_ZR) goto LAB_0000fbac;
    uVar2 = *(uint *)(unaff_x19 + 0x260);
  }
  if ((uVar2 >> 0x1e & 1) == 0) {
    uVar4 = FUN_00011ccc();
    uVar2 = (uint)uVar4;
    if ((int)uVar2 < 0) {
      FUN_00011b30();
      if (0xfffff000 < uVar2) {
        piVar6 = ___error();
        *piVar6 = -uVar2;
        return 0xffffffff;
      }
      return uVar4;
    }
  }
  FUN_00011acc();
  if (*(long *)(unaff_x19 + 0x2d8) == 0) {
    plVar1 = (long *)(unaff_x19 + 0x328);
    if (*(short *)(unaff_x19 + 0x260) != 4) {
      plVar1 = (long *)(unaff_x19 + 0x310);
    }
    if (*plVar1 == 0) {
      FUN_00011ad4();
      (*param_2)();
      FUN_00011acc();
      goto LAB_0000fb38;
    }
    puVar5 = (undefined8 *)FUN_00011e4c();
    if (puVar5 == (undefined8 *)0x0) goto LAB_0000fbac;
    puVar5[1] = param_2;
    puVar5[2] = param_3;
    if (param_3 != 0) {
      puVar8 = puVar5 + 3;
      do {
        *puVar8 = *param_4;
        param_3 = param_3 + -1;
        puVar8 = puVar8 + 1;
        param_4 = param_4 + 1;
      } while (param_3 != 0);
    }
  }
  else {
    puVar5 = (undefined8 *)FUN_00011e4c();
    if (puVar5 == (undefined8 *)0x0) {
LAB_0000fbac:
                    // WARNING: Subroutine does not return
      _abort();
    }
    puVar5[1] = param_2;
    puVar5[2] = param_3;
    if (param_3 != 0) {
      puVar8 = puVar5 + 3;
      do {
        *puVar8 = *param_4;
        param_3 = param_3 + -1;
        puVar8 = puVar8 + 1;
        param_4 = param_4 + 1;
      } while (param_3 != 0);
    }
  }
  *puVar5 = 0;
  puVar8 = (undefined8 *)(unaff_x19 + 0x2c8);
  if (*(undefined8 **)(unaff_x19 + 0x2d0) != (undefined8 *)0x0) {
    puVar8 = *(undefined8 **)(unaff_x19 + 0x2d0);
  }
  *puVar8 = puVar5;
  *(undefined8 **)(unaff_x19 + 0x2d0) = puVar5;
  *(long *)(unaff_x19 + 0x2d8) = *(long *)(unaff_x19 + 0x2d8) + 1;
LAB_0000fb38:
  FUN_00011ad4();
  if ((*(byte *)(unaff_x19 + 0x263) >> 6 & 1) == 0) {
    FUN_00011be4();
  }
  FUN_00011b30();
  return 0;
}



void _ahpl_task_waiting_ops_count(void)

{
  long lVar1;
  int *piVar2;
  undefined4 uVar3;
  
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar3 = 0xffffffff;
  }
  else {
    uVar3 = *(undefined4 *)(lVar1 + 0x2c0);
    FUN_0000e1e0();
  }
  FUN_00011b48(uVar3);
  return;
}



void _ahpl_task_remove_waiting_ops_head(void)

{
  undefined in_ZR;
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  long lVar4;
  uint extraout_w8;
  undefined4 uVar5;
  uint uVar6;
  long extraout_x8;
  long unaff_x19;
  code *pcVar7;
  
  FUN_00011b88();
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    ___error();
    FUN_00011dcc();
  }
  else {
    FUN_00011e58();
    uVar6 = extraout_w8;
    if ((extraout_w8 >> 0x1e & 1) != 0) {
      lVar1 = FUN_000090e4();
      if (lVar1 == 0) {
        uVar5 = 0xffffffff;
      }
      else {
        uVar5 = *(undefined4 *)(lVar1 + 0x14);
      }
      FUN_00011c7c(uVar5);
      if (!(bool)in_ZR) {
                    // WARNING: Subroutine does not return
        _abort();
      }
      uVar6 = *(uint *)(unaff_x19 + 0x260);
    }
    if ((uVar6 >> 0x1e & 1) == 0) {
      uVar2 = FUN_00011ccc();
      if (-1 < (int)uVar2) goto LAB_0000fc58;
    }
    else {
      uVar2 = 0xfffffffe;
LAB_0000fc58:
      FUN_00011acc();
      lVar1 = *(long *)(unaff_x19 + 0x2b0);
      if (lVar1 != 0) {
        FUN_00011e40();
        if (extraout_x8 == 0) {
          *(undefined8 *)(unaff_x19 + 0x2b8) = 0;
        }
        FUN_00011e14();
      }
      FUN_00011ad4();
      if ((*(byte *)(unaff_x19 + 0x263) >> 6 & 1) == 0) {
        FUN_00011be4();
      }
      if (lVar1 != 0) {
        uVar2 = *(undefined8 *)(lVar1 + 8);
        pcVar7 = *(code **)(lVar1 + 0x28);
        if (DAT_000298e0 == (code *)0x0) {
          FUN_00011e34();
        }
        else {
          _ahpl_tick_us();
          FUN_00011da4();
        }
        lVar4 = _objc_autoreleasePoolPush();
        (*pcVar7)();
        if (lVar4 != 0) {
          FUN_00011b40();
        }
        pcVar7 = DAT_000298e0;
        if (DAT_000298e0 != (code *)0x0) {
          _ahpl_tick_us();
          (*pcVar7)(uVar2,1);
        }
        FUN_00011d84();
        if (*(long *)(lVar1 + 0x10) != 0) {
          FUN_00011d10();
        }
        if (*(long *)(lVar1 + 0x18) != 0) {
          FUN_00011c88();
        }
        FUN_00011b38();
        FUN_00011b30();
        uVar2 = 0;
        goto LAB_0000fd44;
      }
    }
    FUN_00011b30();
    if ((uint)uVar2 < 0xfffff001) goto LAB_0000fd44;
    piVar3 = ___error();
    *piVar3 = -(uint)uVar2;
  }
  uVar2 = 0xffffffff;
LAB_0000fd44:
  FUN_00011ba4(uVar2);
  return;
}



void FUN_0000fd54(void)

{
  undefined in_ZR;
  long lVar1;
  long unaff_x19;
  
  FUN_00011cd4();
  if ((!(bool)in_ZR) &&
     ((((lVar1 = FUN_000090e4(), lVar1 != 0 && ((*(uint *)(lVar1 + 0x14) >> 0xf & 1) == 0)) &&
       (FUN_00011c7c(), (bool)in_ZR)) || (*(int *)(unaff_x19 + 0x260) < 0)))) {
    return;
  }
  FUN_00004aec(unaff_x19 + 0x270);
  return;
}



void FUN_0000fda4(void)

{
  undefined in_ZR;
  long lVar1;
  long unaff_x19;
  
  FUN_00011cd4();
  if ((!(bool)in_ZR) &&
     ((((lVar1 = FUN_000090e4(), lVar1 != 0 && ((*(uint *)(lVar1 + 0x14) >> 0xf & 1) == 0)) &&
       (FUN_00011c7c(), (bool)in_ZR)) || (*(int *)(unaff_x19 + 0x260) < 0)))) {
    return;
  }
  FUN_00004b20(unaff_x19 + 0x270);
  return;
}



void _ahpl_task_clear(void)

{
  undefined in_ZR;
  uint uVar1;
  long lVar2;
  undefined8 uVar3;
  int *piVar4;
  uint extraout_w8;
  undefined4 uVar5;
  long unaff_x19;
  
  lVar2 = FUN_0000e114();
  if (lVar2 == 0) {
    piVar4 = ___error();
    *piVar4 = 2;
LAB_0000fe2c:
    uVar3 = 0xffffffff;
  }
  else {
    FUN_00011e58();
    uVar1 = extraout_w8;
    if ((extraout_w8 >> 0x1e & 1) != 0) {
      lVar2 = FUN_000090e4();
      if (lVar2 == 0) {
        uVar5 = 0xffffffff;
      }
      else {
        uVar5 = *(undefined4 *)(lVar2 + 0x14);
      }
      FUN_00011c7c(uVar5);
      if (!(bool)in_ZR) {
                    // WARNING: Subroutine does not return
        _abort();
      }
      uVar1 = *(uint *)(unaff_x19 + 0x260);
    }
    if ((uVar1 >> 0x1e & 1) == 0) {
      uVar3 = FUN_00011ccc();
      uVar1 = (uint)uVar3;
      if ((int)uVar1 < 0) {
        FUN_00011b30();
        if (uVar1 < 0xfffff001) goto LAB_0000fe94;
        piVar4 = ___error();
        *piVar4 = -uVar1;
        goto LAB_0000fe2c;
      }
    }
    else {
      uVar3 = 0;
    }
    FUN_00011acc();
    FUN_0000fea4();
    FUN_00011ad4();
    if ((*(byte *)(unaff_x19 + 0x263) >> 6 & 1) == 0) {
      FUN_00011be4();
    }
    FUN_00011b30();
  }
LAB_0000fe94:
  FUN_00011b48(uVar3);
  return;
}



void FUN_0000fea4(void)

{
  code *pcVar1;
  int iVar2;
  long lVar3;
  long lVar4;
  long lVar5;
  long extraout_x8;
  long extraout_x8_00;
  long extraout_x8_01;
  long *plVar6;
  undefined8 uVar7;
  
  lVar3 = FUN_00011b88();
  plVar6 = *(long **)(lVar3 + 0x2c8);
  while (plVar6 != (long *)0x0) {
    lVar5 = *plVar6;
    *(long *)(lVar3 + 0x2c8) = lVar5;
    if (lVar5 == 0) {
      *(undefined8 *)(lVar3 + 0x2d0) = 0;
    }
    *(long *)(lVar3 + 0x2d8) = *(long *)(lVar3 + 0x2d8) + -1;
    *plVar6 = 0;
    FUN_00011ad4();
    FUN_00011d38(plVar6[1],1,2);
    FUN_00011b38();
    FUN_00011acc();
    plVar6 = *(long **)(lVar3 + 0x2c8);
  }
  lVar5 = *(long *)(lVar3 + 0x2b0);
  while (lVar5 != 0) {
    FUN_00011e40();
    if (extraout_x8 == 0) {
      *(undefined8 *)(lVar3 + 0x2b8) = 0;
    }
    FUN_00011e14();
    FUN_00011ad4();
    uVar7 = *(undefined8 *)(lVar5 + 8);
    if (DAT_000298e0 == (code *)0x0) {
      FUN_00011e34();
    }
    else {
      _ahpl_tick_us();
      FUN_00011da4();
    }
    lVar4 = _objc_autoreleasePoolPush();
    FUN_00011d98(1,2,0);
    if (lVar4 != 0) {
      FUN_00011b40();
    }
    pcVar1 = DAT_000298e0;
    if (DAT_000298e0 != (code *)0x0) {
      _ahpl_tick_us();
      (*pcVar1)(uVar7,1);
    }
    FUN_00011d84();
    if (*(long *)(lVar5 + 0x10) != 0) {
      FUN_00011d10();
    }
    if (*(long *)(lVar5 + 0x18) != 0) {
      FUN_00011c88();
    }
    FUN_00011b38();
    FUN_00011acc();
    lVar5 = *(long *)(lVar3 + 0x2b0);
  }
  if (*(short *)(lVar3 + 0x260) == 4) {
    lVar5 = *(long *)(lVar3 + 0x318);
    while (lVar5 != 0) {
      FUN_00011d64();
      FUN_00011ad4();
      FUN_00011d40();
      if (extraout_x8_00 == 0) {
        FUN_00011e34();
      }
      else {
        _ahpl_tick_us();
        FUN_00011db8();
      }
      _objc_autoreleasePoolPush();
      FUN_00011b6c();
      _objc_autoreleasePoolPop(&DAT_00029000);
      if (DAT_000298e0 != (code *)0x0) {
        _ahpl_tick_us();
        FUN_00011c90();
      }
      _free(*(void **)(lVar5 + 0x20));
      if (*(long *)(lVar5 + 0x28) != 0) {
        FUN_00011cf0();
      }
      FUN_00011c08();
      FUN_00011acc();
      lVar5 = *(long *)(lVar3 + 0x318);
    }
    if ((*(uint *)(lVar3 + 0x338) >> 0xf & 1) == 0) {
      _ahpl_mpq_destroy_wait();
    }
    if ((*(uint *)(lVar3 + 0x33c) >> 0xf & 1) == 0) {
      _ahpl_mpq_kill_timer();
    }
  }
  do {
    iVar2 = FUN_00011d5c();
  } while (-1 < iVar2);
  lVar5 = *(long *)(lVar3 + 0x2e8);
  while (lVar5 != 0) {
    FUN_00011d64();
    FUN_00011ad4();
    FUN_00011d40();
    if (extraout_x8_01 == 0) {
      FUN_00011e34();
    }
    else {
      _ahpl_tick_us();
      FUN_00011db8();
    }
    _objc_autoreleasePoolPush();
    FUN_00011b6c();
    _objc_autoreleasePoolPop(&DAT_00029000);
    if (DAT_000298e0 != (code *)0x0) {
      _ahpl_tick_us();
      FUN_00011c90();
    }
    _free(*(void **)(lVar5 + 0x20));
    if (*(long *)(lVar5 + 0x28) != 0) {
      FUN_00011cf0();
    }
    FUN_00011c08();
    FUN_00011acc();
    lVar5 = *(long *)(lVar3 + 0x2e8);
  }
  FUN_00011bc0();
  return;
}



void _ahpl_task_prepare(void)

{
  uint uVar1;
  
  FUN_00011d28();
  uVar1 = FUN_00010130();
  if (0xfffff000 < uVar1) {
    FUN_00011c68();
    FUN_00011cc0();
  }
  FUN_00011c70();
  return;
}



void FUN_00010130(void)

{
  undefined uVar1;
  undefined8 uVar2;
  ulong in_x3;
  undefined8 in_x4;
  long unaff_x29;
  
  uVar2 = FUN_00011d8c();
  *(undefined8 *)(unaff_x29 + -8) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  *(undefined8 *)(unaff_x29 + -0x10) = in_x4;
  uVar1 = in_x3 == 0x40;
  if (in_x3 < 0x41) {
    if (in_x3 == 0) {
      if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
        FUN_00011d00();
        FUN_00010214();
        return;
      }
      goto LAB_000101b8;
    }
    FUN_00011c48();
    do {
      FUN_00011b10();
    } while (!(bool)uVar1);
    uVar2 = FUN_00010214();
  }
  else {
    uVar2 = 0xfffffff9;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
    return;
  }
LAB_000101b8:
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



void _ahpl_task_prepare_args(void)

{
  uint uVar1;
  
  uVar1 = FUN_00010130();
  if (0xfffff000 < uVar1) {
    FUN_00011c68();
    FUN_00011cc0();
  }
  FUN_00011b48();
  return;
}



void _ahpl_task_prepare_argv(void)

{
  uint uVar1;
  
  uVar1 = FUN_00010214();
  if (0xfffff000 < uVar1) {
    FUN_00011c68();
    FUN_00011cc0();
  }
  FUN_00011b48();
  return;
}



undefined8 FUN_00010214(void)

{
  long lVar1;
  long lVar2;
  long *plVar3;
  long *plVar4;
  long **pplVar5;
  long *unaff_x19;
  long unaff_x20;
  long unaff_x21;
  long unaff_x24;
  long *plVar6;
  
  lVar1 = FUN_00011c30();
  if (lVar1 == 0) {
    return 0xffffffff;
  }
  plVar6 = *(long **)(lVar1 + 0x1a0);
  if (plVar6[1] == 0) {
    lVar2 = FUN_00011e0c();
    if (lVar2 == 0) {
      return 0xfffffff4;
    }
    *(long *)lVar2 = lVar2;
    *(long *)(lVar2 + 8) = lVar2;
    plVar6[1] = lVar2;
  }
  plVar3 = (long *)FUN_00011dec();
  if (plVar3 == (long *)0x0) {
    return 0xfffffff4;
  }
  plVar3[2] = (*(long *)(lVar1 + 0x170) - unaff_x24) + *plVar6;
  lVar1 = _ahpl_strdup();
  plVar3[3] = lVar1;
  plVar3[4] = unaff_x21;
  plVar3[5] = unaff_x20;
  if (unaff_x20 != 0) {
    plVar4 = plVar3 + 6;
    do {
      *plVar4 = *unaff_x19;
      unaff_x20 = unaff_x20 + -1;
      plVar4 = plVar4 + 1;
      unaff_x19 = unaff_x19 + 1;
    } while (unaff_x20 != 0);
  }
  lVar1 = plVar6[1];
  pplVar5 = *(long ***)(lVar1 + 8);
  *(long **)(lVar1 + 8) = plVar3;
  *plVar3 = lVar1;
  plVar3[1] = (long)pplVar5;
  *pplVar5 = plVar3;
  *(int *)(plVar6 + 5) = *(int *)(plVar6 + 5) + 1;
  return 0;
}



void _ahpl_task_resume(void)

{
  uint uVar1;
  
  FUN_00011d28();
  uVar1 = FUN_0001031c();
  if (0xfffff000 < uVar1) {
    FUN_00011c68();
    FUN_00011cc0();
  }
  FUN_00011c70();
  return;
}



void FUN_0001031c(void)

{
  undefined uVar1;
  undefined8 uVar2;
  ulong in_x3;
  undefined8 in_x4;
  long unaff_x29;
  
  uVar2 = FUN_00011d8c();
  *(undefined8 *)(unaff_x29 + -8) = *(undefined8 *)PTR____stack_chk_guard_00028030;
  *(undefined8 *)(unaff_x29 + -0x10) = in_x4;
  uVar1 = in_x3 == 0x40;
  if (in_x3 < 0x41) {
    if (in_x3 == 0) {
      if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
        FUN_00011d00();
        FUN_00010400();
        return;
      }
      goto LAB_000103a4;
    }
    FUN_00011c48();
    do {
      FUN_00011b10();
    } while (!(bool)uVar1);
    uVar2 = FUN_00010400();
  }
  else {
    uVar2 = 0xfffffff9;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == *(long *)(unaff_x29 + -8)) {
    return;
  }
LAB_000103a4:
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



void _ahpl_task_resume_args(void)

{
  uint uVar1;
  
  uVar1 = FUN_0001031c();
  if (0xfffff000 < uVar1) {
    FUN_00011c68();
    FUN_00011cc0();
  }
  FUN_00011b48();
  return;
}



void _ahpl_task_resume_argv(void)

{
  uint uVar1;
  
  uVar1 = FUN_00010400();
  if (0xfffff000 < uVar1) {
    FUN_00011c68();
    FUN_00011cc0();
  }
  FUN_00011b48();
  return;
}



undefined8 FUN_00010400(void)

{
  ulong uVar1;
  bool bVar2;
  long lVar3;
  long *plVar4;
  undefined8 uVar5;
  long lVar6;
  long *plVar7;
  ulong uVar8;
  long **pplVar9;
  long *unaff_x19;
  long unaff_x20;
  code *unaff_x21;
  long unaff_x24;
  long *plVar10;
  ulong local_80;
  undefined8 local_78;
  undefined8 local_70;
  undefined4 local_68;
  long local_60;
  undefined8 local_58;
  
  lVar3 = FUN_00011c30();
  if (lVar3 == 0) {
    uVar5 = 0xffffffff;
  }
  else {
    plVar10 = *(long **)(lVar3 + 0x1a0);
    uVar1 = (*(long *)(lVar3 + 0x170) - unaff_x24) + *plVar10;
    if ((plVar10[4] == 0) || (0xfffffffffffff000 < (ulong)plVar10[4])) {
      lVar6 = plVar10[1];
      if (lVar6 != 0) {
        plVar10[1] = 0;
        FUN_00010ae4(lVar6,0);
      }
      uVar8 = plVar10[2];
      local_78 = 0;
      local_70 = 0;
      bVar2 = uVar8 <= uVar1;
      if ((*(uint *)(plVar10 + 3) & 0x80000000) == 0) {
        bVar2 = uVar8 != 0 && uVar8 <= uVar1;
      }
      local_68 = 0;
      local_60 = 0;
      local_58 = 0;
      *(ulong **)(lVar3 + 0x1a0) = &local_80;
      local_80 = uVar1;
      lVar6 = _objc_autoreleasePoolPush();
      (*unaff_x21)(bVar2);
      if (lVar6 != 0) {
        _objc_autoreleasePoolPop(lVar6);
      }
      uVar5 = local_78;
      *(long **)(lVar3 + 0x1a0) = plVar10;
      local_78 = 0;
      FUN_00011c10(uVar5);
      local_70 = 0;
      local_68 = 0;
      if (local_60 != 0) {
        FUN_00011bdc();
      }
      uVar5 = 0;
    }
    else {
      plVar4 = (long *)FUN_00011dec();
      if (plVar4 == (long *)0x0) {
                    // WARNING: Subroutine does not return
        _abort();
      }
      plVar4[2] = uVar1;
      lVar3 = _ahpl_strdup();
      plVar4[3] = lVar3;
      plVar4[4] = (long)unaff_x21;
      plVar4[5] = unaff_x20;
      if (unaff_x20 != 0) {
        plVar7 = plVar4 + 6;
        do {
          *plVar7 = *unaff_x19;
          unaff_x20 = unaff_x20 + -1;
          plVar7 = plVar7 + 1;
          unaff_x19 = unaff_x19 + 1;
        } while (unaff_x20 != 0);
      }
      uVar5 = 0;
      lVar3 = plVar10[4];
      pplVar9 = *(long ***)(lVar3 + 0x10);
      *(long **)(lVar3 + 0x10) = plVar4;
      *plVar4 = lVar3 + 8;
      plVar4[1] = (long)pplVar9;
      *pplVar9 = plVar4;
    }
  }
  return uVar5;
}



long ** FUN_00010570(long **param_1)

{
  long **pplVar1;
  long lVar2;
  long *plVar3;
  
  pplVar1 = (long **)*param_1;
  if (pplVar1 != param_1) {
    lVar2 = (long)*pplVar1;
    plVar3 = pplVar1[1];
    *(long **)(lVar2 + 8) = plVar3;
    *plVar3 = lVar2;
    *pplVar1 = (long *)0x100101;
    pplVar1[1] = (long *)0x200203;
    return pplVar1;
  }
  return (long **)0x0;
}



void FUN_000105ac(long param_1)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  ulong uVar5;
  int *piVar6;
  uint *in_x6;
  uint uVar7;
  long lVar8;
  
  uVar4 = *in_x6;
  uVar7 = in_x6[2];
  uVar1 = in_x6[4];
  uVar2 = in_x6[6];
  lVar8 = *(long *)(in_x6 + 8);
  uVar5 = (*DAT_00028ca8)();
  if ((int)uVar5 < 0) goto LAB_00010738;
  uVar3 = uVar4;
  if (uVar7 != 0) {
    uVar3 = uVar4 | 0x80000000;
  }
  if ((uVar1 >> 0xf & 1) == 0) {
    *(uint *)(param_1 + 0x264) = uVar1;
    uVar7 = 0x40000000;
    if (uVar2 != 0) {
      uVar7 = 0x60000000;
    }
    uVar3 = uVar7 | uVar3;
LAB_00010668:
    *(uint *)(param_1 + 0x260) = uVar3;
    FUN_00004a38(param_1 + 0x270);
    *(undefined8 *)(param_1 + 0x2c8) = 0;
    *(undefined8 *)(param_1 + 0x2c0) = 0;
    *(undefined8 *)(param_1 + 0x2d8) = 0;
    *(undefined8 *)(param_1 + 0x2d0) = 0;
    *(undefined8 *)(param_1 + 0x2b8) = 0;
    *(undefined8 *)(param_1 + 0x2b0) = 0;
    *(undefined8 *)(param_1 + 0x2e0) = 1;
    *(undefined8 *)(param_1 + 0x2e8) = 0;
    *(code **)(param_1 + 0x2f0) = FUN_00010784;
    *(undefined8 *)(param_1 + 0x300) = 0;
    *(undefined8 *)(param_1 + 0x2f8) = 0;
    *(undefined8 *)(param_1 + 0x310) = 0;
    *(undefined8 *)(param_1 + 0x308) = 0;
    if (uVar4 != 4) {
      uVar5 = 0;
      goto LAB_00010738;
    }
    *(undefined8 *)(param_1 + 0x318) = 0;
    *(code **)(param_1 + 800) = FUN_00010784;
    *(undefined8 *)(param_1 + 0x328) = 0;
    *(long *)(param_1 + 0x330) = lVar8;
    *(undefined4 *)(param_1 + 0x338) = 0xffffffff;
    *(undefined8 *)(param_1 + 0x340) = 0xffffffff;
    if (lVar8 != 0) {
      uVar4 = FUN_0000a38c(1,2,&DAT_00002710,"AsyncObjectWait",0,0,0);
      if ((uVar4 >> 0xf & 1) != 0) {
        piVar6 = ___error();
        uVar4 = 0xffffffea;
        if (*piVar6 != 0) {
          uVar4 = -*piVar6;
        }
        uVar5 = (ulong)uVar4;
        goto code_r0x0001072c;
      }
      *(uint *)(param_1 + 0x338) = uVar4;
    }
    uVar5 = 0;
    *(undefined4 *)(param_1 + 0x33c) = 0xffffffff;
  }
  else {
    if (uVar2 == 0) {
      *(undefined8 *)(param_1 + 0x264) = 0xffffffff;
      goto LAB_00010668;
    }
    uVar5 = 0xffffffea;
code_r0x0001072c:
    (*DAT_00028cb0)(param_1);
  }
LAB_00010738:
  FUN_00011c18(uVar5);
  return;
}



void FUN_00010744(long param_1)

{
  FUN_0000fd54();
  FUN_0000fea4(param_1);
  FUN_00011ad4();
  FUN_00004b3c(param_1 + 0x270);
  (*DAT_00028cb0)(param_1);
  return;
}



int FUN_00010784(long param_1,long param_2,long *param_3)

{
  int iVar1;
  long lVar2;
  
  if (param_2 == 0) {
    lVar2 = *param_3;
  }
  else {
    lVar2 = *(long *)(param_2 + 0x18);
  }
  iVar1 = -(uint)(0 < lVar2 - *(long *)(param_1 + 0x18));
  if (0 < *(long *)(param_1 + 0x18) - lVar2) {
    iVar1 = 1;
  }
  return iVar1;
}



void FUN_000107cc(undefined8 param_1,undefined8 param_2,undefined8 param_3,long param_4,
                 undefined8 *param_5,long param_6,undefined8 param_7,undefined8 param_8)

{
  undefined8 *puVar1;
  undefined4 uVar2;
  int iVar3;
  bool bVar4;
  long lVar5;
  undefined8 uVar6;
  undefined8 *puVar7;
  int *piVar8;
  uint extraout_w8;
  uint uVar9;
  long unaff_x19;
  ulong uVar10;
  ulong uVar11;
  
  FUN_00011e58();
  uVar9 = extraout_w8;
  if ((param_6 != 0) && ((extraout_w8 >> 0x1d & 1) != 0)) {
    lVar5 = FUN_00010ae4(param_6,param_8);
    if (lVar5 != 0) {
      uVar10 = 0xffffffcb;
      goto LAB_000109b8;
    }
    uVar9 = (uint)*(ushort *)(unaff_x19 + 0x260);
  }
  if ((uVar9 & 0xffff) != 4) {
    FUN_00010b30();
    return;
  }
  uVar2 = *(undefined4 *)(unaff_x19 + 0x18);
  lVar5 = _ahpl_malloc(param_4 * 8 + 0x48);
  if (lVar5 != 0) {
    *(undefined8 *)(lVar5 + 0x18) = *(undefined8 *)(unaff_x19 + 0x2e0);
    uVar6 = _ahpl_strdup(param_2);
    *(undefined8 *)(lVar5 + 0x20) = uVar6;
    *(undefined8 *)(lVar5 + 0x28) = param_7;
    uVar6 = _ahpl_tick_now();
    *(undefined8 *)(lVar5 + 0x30) = uVar6;
    *(undefined8 *)(lVar5 + 0x38) = param_3;
    *(long *)(lVar5 + 0x40) = param_4;
    if (param_4 != 0) {
      puVar7 = (undefined8 *)(lVar5 + 0x48);
      do {
        *puVar7 = *param_5;
        param_4 = param_4 + -1;
        puVar7 = puVar7 + 1;
        param_5 = param_5 + 1;
      } while (param_4 != 0);
    }
    uVar11 = (ulong)*(uint *)(unaff_x19 + 0x340);
    if ((*(uint *)(unaff_x19 + 0x340) >> 0xf & 1) == 0) {
      bVar4 = false;
    }
    else {
      uVar11 = FUN_0000c6dc();
      if (((uint)uVar11 >> 0xf & 1) != 0) goto LAB_000109c4;
      *(uint *)(unaff_x19 + 0x340) = (uint)uVar11;
      bVar4 = true;
    }
    *(int *)(unaff_x19 + 0x344) = *(int *)(unaff_x19 + 0x344) + 1;
    uVar10 = _ahpl_mpq_queue(uVar11,0xffffffff,uVar2,"__task_async_op_do",FUN_0001158c,1);
    if (bVar4) {
      FUN_0000c808(uVar11);
    }
    if ((int)uVar10 < 0) {
      piVar8 = ___error();
      uVar9 = 0xffffffea;
      if (*piVar8 != 0) {
        uVar9 = -*piVar8;
      }
      uVar10 = (ulong)uVar9;
      iVar3 = *(int *)(unaff_x19 + 0x344) + -1;
      *(int *)(unaff_x19 + 0x344) = iVar3;
      if (iVar3 == 0) {
        *(undefined4 *)(unaff_x19 + 0x340) = 0xffffffff;
      }
      _free(*(void **)(lVar5 + 0x20));
      if (*(long *)(lVar5 + 0x28) != 0) {
        FUN_00011c88();
      }
      FUN_00011b38();
    }
    else {
      _ahpl_rb_insert_node(unaff_x19 + 0x318,lVar5);
      if (*(int *)(unaff_x19 + 0x260) < 0) {
        uVar6 = *(undefined8 *)(lVar5 + 0x18);
        puVar7 = (undefined8 *)FUN_00011e0c();
        if (puVar7 == (undefined8 *)0x0) goto LAB_000109c4;
        *puVar7 = 0;
        puVar7[1] = uVar6;
        puVar1 = (undefined8 *)(unaff_x19 + 0x300);
        if (*(undefined8 **)(unaff_x19 + 0x308) != (undefined8 *)0x0) {
          puVar1 = *(undefined8 **)(unaff_x19 + 0x308);
        }
        *puVar1 = puVar7;
        *(undefined8 **)(unaff_x19 + 0x308) = puVar7;
        *(long *)(unaff_x19 + 0x310) = *(long *)(unaff_x19 + 0x310) + 1;
      }
      FUN_00011d70();
    }
LAB_000109b8:
    FUN_00011c18(uVar10);
    return;
  }
LAB_000109c4:
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_000109c8(void)

{
  int iVar1;
  long lVar2;
  undefined4 *in_x3;
  long extraout_x8;
  undefined8 uVar3;
  long lVar4;
  code *pcVar5;
  undefined8 unaff_x24;
  int unaff_w25;
  long unaff_x27;
  
  FUN_00011b88();
  lVar2 = FUN_0000e114(*in_x3);
  if (lVar2 != 0) {
    iVar1 = FUN_0000e398();
    if (-1 < iVar1) {
      FUN_00011acc();
      lVar4 = *(long *)(lVar2 + 0x2b0);
      if (lVar4 != 0) {
        FUN_00011e40();
        if (extraout_x8 == 0) {
          *(undefined8 *)(lVar2 + 0x2b8) = 0;
        }
        iVar1 = FUN_00011adc();
        if (iVar1 < 0) {
          FUN_00011ad4();
          uVar3 = *(undefined8 *)(lVar4 + 8);
          pcVar5 = *(code **)(lVar4 + 0x28);
          if (DAT_000298e0 == (code *)0x0) {
            unaff_x24 = 0;
            unaff_w25 = 0;
          }
          else {
            _ahpl_tick_us();
            FUN_00011dd8();
          }
          _objc_autoreleasePoolPush();
          FUN_00011ca4();
          (*pcVar5)();
          if (unaff_x27 != 0) {
            FUN_00011b40();
          }
          pcVar5 = DAT_000298e0;
          if (DAT_000298e0 != (code *)0x0) {
            iVar1 = _ahpl_tick_us();
            (*pcVar5)(uVar3,1,unaff_x24,iVar1 - unaff_w25);
          }
          FUN_00011acc();
        }
        else {
          *(undefined8 *)(lVar4 + 0x18) = 0;
        }
        *(undefined8 *)(lVar4 + 0x10) = 0;
        if (*(void **)(lVar4 + 8) != (void *)0x0) {
          _free(*(void **)(lVar4 + 8));
          if (*(long *)(lVar4 + 0x10) != 0) {
            FUN_00011d10();
          }
        }
        if (*(long *)(lVar4 + 0x18) != 0) {
          FUN_00011c88();
        }
        FUN_00011b38();
      }
      FUN_00011ad4();
      FUN_00011be4();
    }
    FUN_0000e1e0(lVar2);
    return;
  }
  FUN_00011bc0();
  return;
}



long FUN_00010ae4(long param_1,undefined8 param_2)

{
  long lVar1;
  long lVar2;
  
  if (param_1 == 0) {
    lVar1 = 0;
  }
  else {
    lVar1 = FUN_0000f078(param_1,param_2,0);
    FUN_00011b38();
    if (lVar1 != 0) {
      lVar2 = FUN_000090e4();
      *(long *)(*(long *)(lVar2 + 0x1a0) + 0x10) = lVar1;
    }
  }
  return lVar1;
}



void FUN_00010b30(long param_1,undefined8 param_2,undefined8 param_3,long param_4,void *param_5,
                 undefined8 param_6)

{
  undefined4 uVar1;
  uint uVar2;
  void *pvVar3;
  undefined4 uVar4;
  undefined8 extraout_x1;
  long lVar5;
  long extraout_x8;
  long extraout_x9;
  undefined8 *puVar6;
  undefined8 *puVar7;
  undefined8 uVar8;
  
  lVar5 = *(long *)PTR____stack_chk_guard_00028030;
  uVar1 = *(undefined4 *)(param_1 + 0x18);
  FUN_00011d18((param_4 + 5) * 8);
  puVar7 = (undefined8 *)(extraout_x9 - extraout_x8);
  *puVar7 = 0;
  pvVar3 = (void *)_ahpl_strdup(extraout_x1);
  puVar7[1] = pvVar3;
  puVar7[2] = param_3;
  puVar7[3] = *(undefined8 *)(param_1 + 0x2e0);
  puVar7[4] = param_6;
  if (param_4 != 0) {
    _memcpy(puVar7 + 5,param_5,param_4 << 3);
  }
  uVar2 = *(uint *)(param_1 + 0x260);
  if ((uVar2 >> 0x1e & 1) == 0) {
    uVar4 = 0xffffffff;
  }
  else {
    uVar4 = *(undefined4 *)(param_1 + 0x264);
  }
  if ((uVar2 & 0xffff) < 4) {
    puVar6 = &DAT_000298f8;
    switch(uVar2 & 0xffff) {
    case 1:
      puVar6 = &DAT_00029900;
      break;
    case 2:
      puVar6 = &DAT_000298f0;
      break;
    case 3:
      puVar6 = &DAT_00029908;
    }
    uVar2 = _ahpl_mpqp_queue_argv
                      (*puVar6,uVar4,uVar1,"__task_sync_op_do_or_done",FUN_00010cdc,param_4 + 5,
                       puVar7);
    if ((uVar2 >> 0xf & 1) == 0) {
      uVar8 = *(undefined8 *)(param_1 + 0x2e0);
      puVar7 = (undefined8 *)FUN_00011e0c();
      if (puVar7 == (undefined8 *)0x0) goto LAB_00010cd8;
      *puVar7 = 0;
      puVar7[1] = uVar8;
      puVar6 = (undefined8 *)(param_1 + 0x300);
      if (*(undefined8 **)(param_1 + 0x308) != (undefined8 *)0x0) {
        puVar6 = *(undefined8 **)(param_1 + 0x308);
      }
      *puVar6 = puVar7;
      *(undefined8 **)(param_1 + 0x308) = puVar7;
      *(long *)(param_1 + 0x310) = *(long *)(param_1 + 0x310) + 1;
      uVar8 = FUN_00011d70(0);
    }
    else {
      FUN_00011d84();
      uVar8 = 0xffffffff;
    }
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar5) {
      return;
    }
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar8);
  }
  _ahpl_free(pvVar3);
LAB_00010cd8:
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00010cdc(undefined8 param_1,long param_2,long param_3,long *param_4)

{
  long *plVar1;
  code *pcVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  long lVar6;
  int extraout_w8;
  int extraout_w8_00;
  int extraout_w9;
  int extraout_w9_00;
  long lVar7;
  long *plVar8;
  long lVar9;
  void *pvVar10;
  code *pcVar11;
  undefined8 unaff_x30;
  void *pvVar12;
  int local_74;
  
  pvVar10 = (void *)param_4[1];
  pcVar11 = (code *)param_4[2];
  lVar7 = param_4[3];
  lVar9 = param_4[4];
  if (param_2 != 1) {
    if (*param_4 == 0) {
      if (DAT_000298e0 == (code *)0x0) {
        local_74 = 0;
        iVar3 = 0;
      }
      else {
        iVar3 = _ahpl_tick_us();
        FUN_00011e28();
        local_74 = iVar3 + extraout_w8_00 * extraout_w9_00;
      }
      lVar6 = _objc_autoreleasePoolPush();
      (*pcVar11)(param_2,0,lVar7,param_3 + -5,param_4 + 5);
      if (lVar6 != 0) {
        _objc_autoreleasePoolPop(lVar6);
      }
      pcVar2 = DAT_000298e0;
      if (DAT_000298e0 != (code *)0x0) {
        iVar4 = _ahpl_tick_us();
        (*pcVar2)(pvVar10,0,local_74,iVar4 - iVar3);
      }
      *param_4 = 1;
      if ((*(uint *)(param_2 + 0x260) >> 0x1e & 1) != 0) goto LAB_00010f08;
      if ((*(uint *)(param_2 + 0x260) & 0xffff) != 2) {
        FUN_00011cf8();
        FUN_000110ec(param_2,"__task_sync_op_do_or_done",FUN_00010cdc,param_3,param_4);
        FUN_00011b50(param_2,unaff_x30);
        FUN_0000fda4();
        return;
      }
    }
    if (((*(byte *)(param_2 + 0x133) >> 6 & 1) == 0) || (iVar3 = FUN_0000e398(param_2), -1 < iVar3))
    {
      FUN_00011cf8();
      param_3 = param_3 + -5;
      param_4 = param_4 + 5;
      pvVar12 = pvVar10;
      FUN_00011190(param_2,lVar7,0);
      if ((*(byte *)(param_2 + 0x263) >> 6 & 1) == 0) {
        iVar3 = *(int *)(param_2 + 0x264);
        lVar7 = FUN_000090e4();
        if (lVar7 == 0) {
          iVar4 = -1;
        }
        else {
          iVar4 = *(int *)(lVar7 + 0x14);
        }
        if ((iVar3 == iVar4) &&
           (iVar3 = *(int *)(param_2 + 0x268) + -1, *(int *)(param_2 + 0x268) = iVar3, iVar3 == 0))
        {
          *(undefined4 *)(param_2 + 0x264) = 0xffffffff;
        }
      }
      if (*(long *)(param_2 + 0x310) == 0) {
        while (plVar8 = *(long **)(param_2 + 0x2c8), plVar8 != (long *)0x0) {
          lVar7 = *plVar8;
          *(long *)(param_2 + 0x2c8) = lVar7;
          if (lVar7 == 0) {
            *(undefined8 *)(param_2 + 0x2d0) = 0;
          }
          *(long *)(param_2 + 0x2d8) = *(long *)(param_2 + 0x2d8) + -1;
          *plVar8 = 0;
          FUN_00011d54();
          FUN_00011d38(plVar8[1],param_2,1);
          FUN_00011c08();
          FUN_00011cf8();
        }
      }
      if ((*(long *)(param_2 + 0x2d8) == 0) &&
         (plVar8 = *(long **)(param_2 + 0x2b0), plVar8 != (long *)0x0)) {
        lVar7 = *plVar8;
        *(long *)(param_2 + 0x2b0) = lVar7;
        if (lVar7 == 0) {
          *(undefined8 *)(param_2 + 0x2b8) = 0;
        }
        *(long *)(param_2 + 0x2c0) = *(long *)(param_2 + 0x2c0) + -1;
        *plVar8 = 0;
        plVar1 = plVar8 + 4;
        iVar3 = FUN_000107cc(param_2,plVar8[1],plVar8[5],plVar8[6],plVar8 + 7,plVar8[2],plVar8[3],
                             plVar1,pvVar12,param_1,pcVar11,param_3,param_4,lVar9);
        if (iVar3 < 0) {
          FUN_00011d54();
          lVar7 = plVar8[1];
          pcVar11 = (code *)plVar8[5];
          lVar9 = plVar8[6];
          if (DAT_000298e0 == (code *)0x0) {
            iVar3 = 0;
            iVar4 = 0;
          }
          else {
            iVar4 = _ahpl_tick_us();
            iVar3 = iVar4 + *(int *)plVar1 * -1000;
          }
          lVar6 = _objc_autoreleasePoolPush();
          (*pcVar11)(param_2,2,0,lVar9,plVar8 + 7);
          if (lVar6 != 0) {
            FUN_00011b40();
          }
          pcVar11 = DAT_000298e0;
          if (DAT_000298e0 != (code *)0x0) {
            iVar5 = _ahpl_tick_us();
            (*pcVar11)(lVar7,1,iVar3,iVar5 - iVar4);
          }
          FUN_00011cf8();
        }
        else {
          plVar8[3] = 0;
        }
        plVar8[2] = 0;
        if ((void *)plVar8[1] != (void *)0x0) {
          _free((void *)plVar8[1]);
          if (plVar8[2] != 0) {
            FUN_0000f048(plVar8[2],plVar1);
          }
        }
        if (plVar8[3] != 0) {
          FUN_0000f214(plVar8[3],plVar1);
        }
        FUN_00011c08();
      }
      FUN_00011d54();
      if ((*(byte *)(param_2 + 0x133) >> 6 & 1) != 0) {
        FUN_0000e454(param_2);
      }
      pvVar10 = (void *)FUN_00011b50(pvVar10,unaff_x30);
      _free(pvVar10);
      return;
    }
  }
  if (DAT_000298e0 == (code *)0x0) {
    iVar3 = 0;
    iVar4 = 0;
  }
  else {
    iVar4 = _ahpl_tick_us();
    FUN_00011e28();
    iVar3 = iVar4 + extraout_w8 * extraout_w9;
  }
  lVar6 = _objc_autoreleasePoolPush();
  FUN_00011d98(1,2,lVar7);
  if (lVar6 != 0) {
    _objc_autoreleasePoolPop(lVar6);
  }
  pcVar11 = DAT_000298e0;
  if (DAT_000298e0 != (code *)0x0) {
    iVar5 = _ahpl_tick_us();
    (*pcVar11)(pvVar10,1,iVar3,iVar5 - iVar4);
  }
  _free(pvVar10);
  if (lVar9 != 0) {
    FUN_00011b50(lVar9,0,unaff_x30);
    FUN_0000f214();
    return;
  }
LAB_00010f08:
  FUN_00011b50(unaff_x30);
  return;
}



void FUN_000110ec(long param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 param_5)

{
  uint uVar1;
  ulong uVar2;
  int *piVar3;
  
  if ((*(uint *)(param_1 + 0x264) >> 0xf & 1) == 0) {
    uVar2 = FUN_00009e70(*(uint *)(param_1 + 0x264),0xffffffff,*(undefined4 *)(param_1 + 0x18));
    if ((int)uVar2 < 0) {
LAB_00011174:
      piVar3 = ___error();
      uVar2 = (ulong)(uint)-*piVar3;
      goto LAB_00011188;
    }
    if ((*(byte *)(param_1 + 0x263) >> 6 & 1) != 0) goto LAB_00011188;
  }
  else {
    if ((*(byte *)(param_1 + 0x263) >> 6 & 1) != 0) {
      uVar2 = 0xffffffea;
      goto LAB_00011188;
    }
    uVar1 = FUN_0000c870(0xffffffff,*(undefined4 *)(param_1 + 0x18),param_2,param_3,param_4,param_5)
    ;
    if ((uVar1 >> 0xf & 1) != 0) goto LAB_00011174;
    uVar2 = 0;
    *(uint *)(param_1 + 0x264) = uVar1;
  }
  *(int *)(param_1 + 0x268) = *(int *)(param_1 + 0x268) + 1;
LAB_00011188:
  FUN_00011b48(uVar2);
  return;
}



void FUN_00011190(long param_1,long param_2,long param_3)

{
  int *piVar1;
  int iVar2;
  int iVar3;
  undefined4 uVar4;
  undefined8 uVar5;
  long lVar6;
  long lVar7;
  void *pvVar8;
  int extraout_w8;
  long lVar9;
  undefined8 *puVar10;
  long *plVar11;
  long lVar12;
  int extraout_w9;
  undefined8 *puVar13;
  code *pcVar14;
  undefined8 *puVar15;
  undefined8 uVar16;
  long lVar17;
  undefined8 uVar18;
  long lVar19;
  int iVar20;
  undefined8 param_9;
  undefined8 local_80;
  
  if ((*(long *)(param_1 + 0x300) != 0) &&
     (lVar9 = *(long *)(*(long *)(param_1 + 0x300) + 8), lVar9 - param_2 < 1)) {
    if (param_2 - lVar9 < 1) {
      if (param_3 == 0) {
        plVar11 = (long *)((ulong)&stack0x00000000 | 8);
        lVar9 = *plVar11;
        pcVar14 = (code *)plVar11[1];
        lVar19 = plVar11[2];
        local_80 = param_9;
        lVar12 = plVar11[3];
        lVar17 = plVar11[4];
      }
      else {
        local_80 = *(undefined8 *)(param_3 + 0x20);
        lVar17 = *(long *)(param_3 + 0x28);
        lVar9 = param_3 + 0x30;
        lVar12 = param_3 + 0x48;
        pcVar14 = *(code **)(param_3 + 0x38);
        lVar19 = *(long *)(param_3 + 0x40);
      }
      FUN_0000fda4(param_1);
      lVar6 = FUN_000090e4();
      if (DAT_000298e0 == (code *)0x0) {
        iVar20 = 0;
        iVar2 = 0;
      }
      else {
        iVar2 = _ahpl_tick_us();
        FUN_00011e28();
        iVar20 = iVar2 + extraout_w8 * extraout_w9;
      }
      lVar7 = _objc_autoreleasePoolPush();
      (*pcVar14)(param_1,1,param_2,lVar19,lVar12);
      if (lVar7 != 0) {
        _objc_autoreleasePoolPop(lVar7);
      }
      pcVar14 = DAT_000298e0;
      if (DAT_000298e0 != (code *)0x0) {
        iVar3 = _ahpl_tick_us();
        (*pcVar14)(local_80,0,iVar20,iVar3 - iVar2);
      }
      if (lVar17 != 0) {
        uVar16 = FUN_00011df8();
        FUN_0000f214(uVar16,lVar9);
      }
      lVar9 = *(long *)(lVar6 + 0x1a0);
      uVar16 = *(undefined8 *)(lVar9 + 8);
      *(undefined8 *)(lVar9 + 8) = 0;
      FUN_00011c10(uVar16);
      *(undefined8 *)(lVar9 + 0x10) = 0;
      *(undefined4 *)(lVar9 + 0x18) = 0;
      if (*(long *)(lVar9 + 0x20) != 0) {
        FUN_00011bdc();
        *(undefined8 *)(lVar9 + 0x20) = 0;
      }
      *(undefined8 *)(lVar9 + 0x28) = 0;
      if (param_3 != 0) {
        *(undefined8 *)(param_3 + 0x28) = 0;
        if ((*(void **)(param_3 + 0x20) != (void *)0x0) &&
           (_free(*(void **)(param_3 + 0x20)), *(long *)(param_3 + 0x28) != 0)) {
          FUN_00011cf0();
        }
        FUN_00011c08();
      }
      FUN_00011acc();
      FUN_00011d5c();
      lVar9 = param_1 + 0x2e8;
      pvVar8 = (void *)FUN_0001610c(lVar9);
      while (pvVar8 != (void *)0x0) {
        if (*(long *)(param_1 + 0x300) == 0) goto LAB_00011540;
        lVar12 = *(long *)(*(long *)(param_1 + 0x300) + 8);
        if (0 < lVar12 - *(long *)((long)pvVar8 + 0x18)) goto LAB_00011540;
        if (0 < *(long *)((long)pvVar8 + 0x18) - lVar12) break;
        FUN_00015e64(pvVar8,lVar9);
        FUN_0000fda4(param_1);
        uVar4 = _ahpl_tick_now();
        *(undefined4 *)(lVar6 + 0x1d8) = uVar4;
        uVar5 = *(undefined8 *)((long)pvVar8 + 0x18);
        uVar16 = *(undefined8 *)((long)pvVar8 + 0x20);
        piVar1 = (int *)((long)pvVar8 + 0x30);
        pcVar14 = *(code **)((long)pvVar8 + 0x38);
        uVar18 = *(undefined8 *)((long)pvVar8 + 0x40);
        lVar12 = *(long *)((long)pvVar8 + 0x28);
        if (DAT_000298e0 == (code *)0x0) {
          iVar20 = 0;
          iVar2 = 0;
        }
        else {
          iVar2 = _ahpl_tick_us();
          iVar20 = iVar2 + *piVar1 * -1000;
        }
        lVar17 = _objc_autoreleasePoolPush();
        (*pcVar14)(param_1,1,uVar5,uVar18,(long)pvVar8 + 0x48);
        if (lVar17 != 0) {
          _objc_autoreleasePoolPop(lVar17);
        }
        pcVar14 = DAT_000298e0;
        if (DAT_000298e0 != (code *)0x0) {
          iVar3 = _ahpl_tick_us();
          (*pcVar14)(uVar16,0,iVar20,iVar3 - iVar2);
        }
        if (lVar12 != 0) {
          *(int *)(lVar12 + 4) = *(int *)(lVar12 + 4) + -1;
          FUN_0000f214(lVar12,piVar1);
        }
        lVar12 = *(long *)(lVar6 + 0x1a0);
        uVar16 = *(undefined8 *)(lVar12 + 8);
        *(undefined8 *)(lVar12 + 8) = 0;
        FUN_00011c10(uVar16);
        *(undefined8 *)(lVar12 + 0x10) = 0;
        *(undefined4 *)(lVar12 + 0x18) = 0;
        if (*(long *)(lVar12 + 0x20) != 0) {
          FUN_00011bdc();
          *(undefined8 *)(lVar12 + 0x20) = 0;
        }
        *(undefined8 *)(lVar12 + 0x28) = 0;
        *(undefined8 *)((long)pvVar8 + 0x28) = 0;
        if (*(void **)((long)pvVar8 + 0x20) != (void *)0x0) {
          _free(*(void **)((long)pvVar8 + 0x20));
          if (*(long *)((long)pvVar8 + 0x28) != 0) {
            FUN_0000f214(*(long *)((long)pvVar8 + 0x28),piVar1);
          }
        }
        _free(pvVar8);
        FUN_0000fd54(param_1);
        FUN_00011d5c();
        pvVar8 = (void *)FUN_0001610c(lVar9);
      }
    }
    else {
      if (param_3 == 0) {
        puVar10 = (undefined8 *)((ulong)&stack0x00000000 | 8);
        puVar15 = (undefined8 *)*puVar10;
        uVar16 = puVar10[1];
        lVar9 = puVar10[2];
        puVar13 = (undefined8 *)puVar10[3];
        uVar18 = puVar10[4];
        param_3 = _ahpl_malloc(lVar9 * 8 + 0x48);
        if (param_3 == 0) goto LAB_00011540;
        *(long *)(param_3 + 0x18) = param_2;
        uVar5 = _ahpl_strdup(param_9);
        *(undefined8 *)(param_3 + 0x20) = uVar5;
        *(undefined8 *)(param_3 + 0x28) = uVar18;
        *(undefined8 *)(param_3 + 0x30) = *puVar15;
        *(undefined8 *)(param_3 + 0x38) = uVar16;
        *(long *)(param_3 + 0x40) = lVar9;
        if (lVar9 != 0) {
          puVar10 = (undefined8 *)(param_3 + 0x48);
          do {
            *puVar10 = *puVar13;
            lVar9 = lVar9 + -1;
            puVar10 = puVar10 + 1;
            puVar13 = puVar13 + 1;
          } while (lVar9 != 0);
        }
      }
      _ahpl_rb_insert_node(param_1 + 0x2e8,param_3);
    }
    FUN_00011bec();
    return;
  }
LAB_00011540:
                    // WARNING: Subroutine does not return
  _abort();
}



undefined8 FUN_00011544(void **param_1)

{
  void **ppvVar1;
  undefined8 uVar2;
  void *pvVar3;
  
  ppvVar1 = (void **)*param_1;
  if (ppvVar1 == (void **)0x0) {
    uVar2 = 0xffffffff;
  }
  else {
    pvVar3 = *ppvVar1;
    *param_1 = pvVar3;
    if (pvVar3 == (void *)0x0) {
      param_1[1] = (void *)0x0;
    }
    param_1[2] = (void *)((long)param_1[2] + -1);
    _free(ppvVar1);
    uVar2 = 0;
  }
  return uVar2;
}



void FUN_0001158c(int *param_1,long param_2,long param_3,long *param_4)

{
  int iVar1;
  int iVar2;
  int iVar3;
  long lVar4;
  ulong uVar5;
  code *pcVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  long lVar9;
  long local_70 [2];
  
  local_70[1] = *(long *)PTR____stack_chk_guard_00028030;
  if (param_2 != 1) {
    lVar9 = *param_4;
    iVar1 = FUN_0000e398(param_2);
    if (-1 < iVar1) {
      uVar7 = *(undefined8 *)(lVar9 + 0x18);
      local_70[0] = *(long *)(lVar9 + 0x20);
      pcVar6 = *(code **)(lVar9 + 0x38);
      uVar8 = *(undefined8 *)(lVar9 + 0x40);
      if (DAT_000298e0 == (code *)0x0) {
        iVar1 = 0;
        iVar2 = 0;
      }
      else {
        iVar2 = _ahpl_tick_us();
        iVar1 = iVar2 + *param_1 * -1000;
      }
      lVar4 = _objc_autoreleasePoolPush();
      (*pcVar6)(param_2,0,uVar7,uVar8,lVar9 + 0x48);
      if (lVar4 != 0) {
        FUN_00011b40();
      }
      pcVar6 = DAT_000298e0;
      if (DAT_000298e0 != (code *)0x0) {
        iVar3 = _ahpl_tick_us();
        (*pcVar6)(local_70[0],0,iVar1,iVar3 - iVar2);
      }
      if (*(long *)(param_2 + 0x330) != 0) {
        lVar4 = -(param_3 * 8 + 0x1fU & 0xfffffffffffffff0);
        *(long *)((long)local_70 + lVar4) = *(long *)(param_2 + 0x330);
        *(undefined8 *)((long)local_70 + lVar4 + 8) = *(undefined8 *)(lVar9 + 0x18);
        if (*(long *)(lVar9 + 0x40) == 0) {
          lVar9 = 2;
        }
        else {
          uVar5 = 0;
          do {
            *(undefined8 *)(&stack0xffffffffffffffa0 + uVar5 * 8 + lVar4) =
                 *(undefined8 *)(lVar9 + 0x48 + uVar5 * 8);
            uVar5 = uVar5 + 1;
          } while (uVar5 < *(ulong *)(lVar9 + 0x40));
          lVar9 = *(ulong *)(lVar9 + 0x40) + 2;
        }
        _ahpl_mpq_queue_argv
                  (*(undefined4 *)(param_2 + 0x338),0xffffffff,*(undefined4 *)(param_2 + 0x18),
                   "____task_async_op_wait_f",FUN_0001174c,lVar9);
      }
      FUN_00011acc();
      iVar1 = *(int *)(param_2 + 0x344) + -1;
      *(int *)(param_2 + 0x344) = iVar1;
      if (iVar1 == 0) {
        *(undefined4 *)(param_2 + 0x340) = 0xffffffff;
      }
      FUN_00011ad4();
      FUN_00011be4();
    }
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_70[1]) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_0001174c(undefined8 param_1,long param_2,long param_3,code **param_4)

{
  if (param_2 != 1) {
                    // WARNING: Could not recover jumptable at 0x00011764. Too many branches
                    // WARNING: Treating indirect jump as call
    (**param_4)(param_2,param_4[1],param_3 + -2,param_4 + 2);
    return;
  }
  return;
}



void FUN_0001176c(undefined8 *param_1,long param_2,undefined8 param_3,long *param_4)

{
  int iVar1;
  int iVar2;
  long lVar3;
  long lVar4;
  int iVar5;
  undefined8 uVar6;
  long extraout_x8;
  long lVar7;
  code *pcVar8;
  long *plVar9;
  undefined8 uVar10;
  long unaff_x25;
  long unaff_x27;
  undefined8 uVar11;
  long unaff_x30;
  long lVar12;
  int local_74;
  
  if (param_2 != 1) {
    lVar7 = *param_4;
    iVar1 = FUN_0000e398(param_2);
    if (-1 < iVar1) {
      FUN_00011acc();
      lVar3 = param_2 + 0x318;
      if (lVar7 == 0) {
        lVar7 = FUN_0001610c(lVar3);
      }
      else {
        lVar7 = _ahpl_find_rb_node(lVar3,0);
      }
      if (lVar7 != 0) {
        lVar12 = unaff_x30;
        FUN_00015e64(lVar7,lVar3);
        if (*(int *)(param_2 + 0x260) < 0) {
          *(undefined8 *)(lVar7 + 0x30) = *param_1;
          FUN_00011190(param_2,*(undefined8 *)(lVar7 + 0x18),lVar7);
        }
        else {
          lVar3 = FUN_000090e4();
          FUN_00011ad4();
          uVar11 = *(undefined8 *)(lVar7 + 0x18);
          uVar6 = *(undefined8 *)(lVar7 + 0x20);
          pcVar8 = *(code **)(lVar7 + 0x38);
          uVar10 = *(undefined8 *)(lVar7 + 0x40);
          unaff_x25 = lVar7 + 0x48;
          unaff_x30 = *(long *)(lVar7 + 0x28);
          if (DAT_000298e0 == (code *)0x0) {
            local_74 = 0;
            unaff_x27 = 0;
          }
          else {
            unaff_x27 = _ahpl_tick_us();
            local_74 = (int)unaff_x27 + *(int *)param_1 * -1000;
          }
          lVar4 = _objc_autoreleasePoolPush();
          (*pcVar8)(param_2,1,uVar11,uVar10,unaff_x25);
          if (lVar4 != 0) {
            _objc_autoreleasePoolPop(lVar4);
          }
          pcVar8 = DAT_000298e0;
          if (DAT_000298e0 != (code *)0x0) {
            iVar1 = _ahpl_tick_us();
            (*pcVar8)(uVar6,0,local_74,iVar1 - (int)unaff_x27);
          }
          if (unaff_x30 != 0) {
            uVar6 = FUN_00011df8();
            FUN_0000f214(uVar6,param_1);
          }
          lVar3 = *(long *)(lVar3 + 0x1a0);
          uVar6 = *(undefined8 *)(lVar3 + 8);
          *(undefined8 *)(lVar3 + 8) = 0;
          FUN_00011c10(uVar6);
          *(undefined8 *)(lVar3 + 0x10) = 0;
          *(undefined4 *)(lVar3 + 0x18) = 0;
          if (*(long *)(lVar3 + 0x20) != 0) {
            FUN_00011bdc();
            *(undefined8 *)(lVar3 + 0x20) = 0;
          }
          *(undefined8 *)(lVar3 + 0x28) = 0;
          *(undefined8 *)(lVar7 + 0x28) = 0;
          if (*(void **)(lVar7 + 0x20) != (void *)0x0) {
            _free(*(void **)(lVar7 + 0x20));
            if (*(long *)(lVar7 + 0x28) != 0) {
              FUN_00011cf0();
            }
          }
          FUN_00011c08();
          FUN_00011acc();
        }
        iVar1 = (int)unaff_x25;
        if ((*(byte *)(param_2 + 0x263) >> 6 & 1) == 0) {
          iVar2 = *(int *)(param_2 + 0x264);
          lVar7 = FUN_000090e4();
          if (lVar7 == 0) {
            iVar5 = -1;
          }
          else {
            iVar5 = *(int *)(lVar7 + 0x14);
          }
          if (iVar2 != iVar5) {
                    // WARNING: Subroutine does not return
            FUN_000132b8("/Users/jenkins/jenkins_slave/workspace/Kbuild/iOS_Bitbucket2/media_sdk3/../ahpl/kernel/task.c"
                         ,0x64d,lVar12,0);
          }
          iVar2 = *(int *)(param_2 + 0x268) + -1;
          *(int *)(param_2 + 0x268) = iVar2;
          if (iVar2 == 0) {
            *(undefined4 *)(param_2 + 0x264) = 0xffffffff;
          }
        }
        if (*(long *)(param_2 + 0x328) == 0) {
          if ((*(uint *)(param_2 + 0x33c) >> 0xf & 1) == 0) {
            _ahpl_mpq_kill_timer();
            *(undefined4 *)(param_2 + 0x33c) = 0xffffffff;
          }
          while (plVar9 = *(long **)(param_2 + 0x2c8), plVar9 != (long *)0x0) {
            lVar7 = *plVar9;
            *(long *)(param_2 + 0x2c8) = lVar7;
            if (lVar7 == 0) {
              *(undefined8 *)(param_2 + 0x2d0) = 0;
            }
            *(long *)(param_2 + 0x2d8) = *(long *)(param_2 + 0x2d8) + -1;
            *plVar9 = 0;
            FUN_00011ad4();
            FUN_00011d38(plVar9[1],param_2,1);
            FUN_00011b38();
            FUN_00011acc();
          }
        }
        if ((*(long *)(param_2 + 0x2d8) == 0) && (lVar7 = *(long *)(param_2 + 0x2b0), lVar7 != 0)) {
          FUN_00011e40();
          if (extraout_x8 == 0) {
            *(undefined8 *)(param_2 + 0x2b8) = 0;
          }
          iVar2 = FUN_00011adc();
          if (iVar2 < 0) {
            FUN_00011ad4();
            uVar6 = *(undefined8 *)(lVar7 + 8);
            pcVar8 = *(code **)(lVar7 + 0x28);
            if (DAT_000298e0 == (code *)0x0) {
              unaff_x30 = 0;
              iVar1 = 0;
            }
            else {
              _ahpl_tick_us();
              FUN_00011dd8();
            }
            _objc_autoreleasePoolPush();
            FUN_00011ca4();
            (*pcVar8)();
            if (unaff_x27 != 0) {
              FUN_00011b40();
            }
            pcVar8 = DAT_000298e0;
            if (DAT_000298e0 != (code *)0x0) {
              iVar2 = _ahpl_tick_us();
              (*pcVar8)(uVar6,1,unaff_x30,iVar2 - iVar1);
            }
            FUN_00011acc();
          }
          else {
            *(undefined8 *)(lVar7 + 0x18) = 0;
          }
          *(undefined8 *)(lVar7 + 0x10) = 0;
          if (*(void **)(lVar7 + 8) != (void *)0x0) {
            _free(*(void **)(lVar7 + 8));
            if (*(long *)(lVar7 + 0x10) != 0) {
              FUN_00011d10();
            }
          }
          if (*(long *)(lVar7 + 0x18) != 0) {
            FUN_00011c88();
          }
          FUN_00011b38();
        }
      }
      FUN_00011ad4();
      FUN_0000e454(param_2);
      return;
    }
  }
  FUN_00011bec();
  return;
}



void FUN_00011acc(void)

{
  FUN_0000fd54();
  return;
}



void FUN_00011ad4(void)

{
  FUN_0000fda4();
  return;
}



void FUN_00011adc(void)

{
  long unaff_x19;
  undefined8 *unaff_x20;
  
  *(long *)(unaff_x19 + 0x2c0) = *(long *)(unaff_x19 + 0x2c0) + -1;
  *unaff_x20 = 0;
  FUN_000107cc();
  return;
}



void FUN_00011b10(long param_1)

{
  long in_x4;
  undefined8 *puVar1;
  long unaff_x29;
  
  puVar1 = *(undefined8 **)(unaff_x29 + -0x10);
  *(undefined8 **)(unaff_x29 + -0x10) = puVar1 + 1;
  *(undefined8 *)(in_x4 + param_1 * 8) = *puVar1;
  return;
}



void FUN_00011b30(void)

{
  FUN_0000e1e0();
  return;
}



void FUN_00011b38(void)

{
  void *unaff_x20;
  
  _free(unaff_x20);
  return;
}



void FUN_00011b40(void)

{
  _objc_autoreleasePoolPop();
  return;
}



void FUN_00011b48(void)

{
  return;
}



void FUN_00011b50(void)

{
  return;
}



void FUN_00011b6c(void)

{
  code *UNRECOVERED_JUMPTABLE;
  
                    // WARNING: Could not recover jumptable at 0x00011b84. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)(1,2);
  return;
}



void FUN_00011b88(void)

{
  return;
}



void FUN_00011ba4(void)

{
  return;
}



void FUN_00011bc0(void)

{
  return;
}



void FUN_00011bdc(undefined8 param_1)

{
  FUN_0000f214(param_1,0);
  return;
}



void FUN_00011be4(void)

{
  FUN_0000e454();
  return;
}



void FUN_00011bec(void)

{
  return;
}



void FUN_00011c08(void)

{
  void *unaff_x21;
  
  _free(unaff_x21);
  return;
}



void FUN_00011c10(undefined8 param_1)

{
  FUN_0000f048(param_1,0);
  return;
}



void FUN_00011c18(void)

{
  return;
}



void FUN_00011c30(void)

{
  FUN_000090e4();
  return;
}



void FUN_00011c48(void)

{
  return;
}



void FUN_00011c68(void)

{
  ___error();
  return;
}



void FUN_00011c70(void)

{
  return;
}



void FUN_00011c7c(void)

{
  return;
}



void FUN_00011c88(void)

{
  FUN_0000f214();
  return;
}



void FUN_00011c90(void)

{
  code *UNRECOVERED_JUMPTABLE;
  
                    // WARNING: Could not recover jumptable at 0x00011ca0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_00011ca4(void)

{
  return;
}



undefined8 FUN_00011cc0(undefined4 *param_1)

{
  undefined4 unaff_w19;
  
  *param_1 = unaff_w19;
  return 0xffffffff;
}



void FUN_00011ccc(void)

{
  FUN_0000e398();
  return;
}



void FUN_00011cd4(void)

{
  return;
}



void FUN_00011cf0(undefined8 param_1)

{
  long unaff_x21;
  
  FUN_0000f214(param_1,unaff_x21 + 0x30);
  return;
}



void FUN_00011cf8(void)

{
  FUN_0000fd54();
  return;
}



void FUN_00011d00(void)

{
  return;
}



void FUN_00011d10(void)

{
  FUN_0000f048();
  return;
}



void FUN_00011d18(void)

{
  return;
}



void FUN_00011d28(void)

{
  return;
}



void FUN_00011d38(code *UNRECOVERED_JUMPTABLE,undefined8 param_2,undefined8 param_3)

{
                    // WARNING: Could not recover jumptable at 0x00011d3c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)(param_2,param_3,0);
  return;
}



void FUN_00011d40(void)

{
  return;
}



void FUN_00011d54(void)

{
  FUN_0000fda4();
  return;
}



void FUN_00011d5c(void)

{
  FUN_00011544();
  return;
}



void FUN_00011d64(void)

{
  FUN_00015e64();
  return;
}



void FUN_00011d70(void)

{
  long lVar1;
  long unaff_x19;
  
  lVar1 = *(long *)(unaff_x19 + 0x2e0) + 1;
  if (*(long *)(unaff_x19 + 0x2e0) == -1) {
    lVar1 = 1;
  }
  *(long *)(unaff_x19 + 0x2e0) = lVar1;
  return;
}



void FUN_00011d84(void)

{
  long unaff_x20;
  
  _free(*(void **)(unaff_x20 + 8));
  return;
}



void FUN_00011d8c(void)

{
  return;
}



void FUN_00011d98(void)

{
  code *UNRECOVERED_JUMPTABLE;
  
                    // WARNING: Could not recover jumptable at 0x00011da0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_00011da4(void)

{
  return;
}



void FUN_00011db8(void)

{
  return;
}



void FUN_00011dcc(undefined4 *param_1)

{
  *param_1 = 0x16;
  return;
}



void FUN_00011dd8(void)

{
  return;
}



void FUN_00011dec(void)

{
  long unaff_x20;
  
  _ahpl_malloc(unaff_x20 * 8 + 0x30);
  return;
}



void FUN_00011df8(void)

{
  long unaff_x24;
  
  *(int *)(unaff_x24 + 4) = *(int *)(unaff_x24 + 4) + -1;
  return;
}



void FUN_00011e0c(void)

{
  _ahpl_malloc(0x10);
  return;
}



void FUN_00011e14(void)

{
  long unaff_x19;
  undefined8 *unaff_x20;
  
  *(long *)(unaff_x19 + 0x2c0) = *(long *)(unaff_x19 + 0x2c0) + -1;
  *unaff_x20 = 0;
  return;
}



void FUN_00011e28(void)

{
  return;
}



void FUN_00011e34(void)

{
  return;
}



void FUN_00011e40(void)

{
  long unaff_x19;
  undefined8 *unaff_x20;
  
  *(undefined8 *)(unaff_x19 + 0x2b0) = *unaff_x20;
  return;
}



void FUN_00011e4c(void)

{
  long unaff_x21;
  
  _ahpl_malloc(unaff_x21 * 8 + 0x18);
  return;
}



void FUN_00011e58(void)

{
  return;
}



undefined4
_ahpl_input_create(undefined8 param_1,undefined8 param_2,long param_3,undefined8 param_4,
                  undefined8 param_5,undefined8 param_6,undefined8 param_7,undefined8 param_8)

{
  undefined *puVar1;
  undefined4 uVar2;
  ulong uVar3;
  int *piVar4;
  
  puVar1 = (undefined *)0x28d08;
  if (param_3 != 0) {
    puVar1 = &DAT_00028cf0;
  }
  uVar3 = FUN_0000de70(puVar1,param_1,param_2,0,1,1,param_7,param_8,param_3,param_4);
  if ((uVar3 == 0) || (0xfffffffffffff000 < uVar3)) {
    piVar4 = ___error();
    *piVar4 = -(int)uVar3;
    uVar2 = 0xffffffff;
  }
  else {
    uVar2 = *(undefined4 *)(uVar3 + 0x18);
  }
  return uVar2;
}



void _ahpl_input_exec(void)

{
  FUN_00011f04();
  return;
}



void FUN_00011f04(undefined8 param_1,undefined8 param_2,undefined8 param_3,ulong param_4,
                 undefined8 *param_5)

{
  int *piVar1;
  ulong uVar2;
  undefined8 uVar3;
  undefined8 *local_20;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  local_20 = param_5;
  if (param_4 < 0x41) {
    if (param_4 == 0) {
      if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
        FUN_00011fe0();
        return;
      }
      goto LAB_00011fd4;
    }
    uVar2 = 0;
    do {
      uVar3 = *local_20;
      local_20 = local_20 + 1;
      *(undefined8 *)((long)&local_20 + (uVar2 * 8 - (param_4 * 8 + 0xf & 0xfffffffffffffff0))) =
           uVar3;
      uVar2 = uVar2 + 1;
    } while (param_4 != uVar2);
    param_1 = FUN_00011fe0();
  }
  else {
    piVar1 = ___error();
    *piVar1 = 7;
    param_1 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
    return;
  }
LAB_00011fd4:
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(param_1);
}



void _ahpl_input_exec_args
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,ulong param_4,
               undefined8 *param_5)

{
  int *piVar1;
  ulong uVar2;
  undefined8 uVar3;
  undefined8 *puStack_20;
  long lStack_18;
  
  lStack_18 = *(long *)PTR____stack_chk_guard_00028030;
  puStack_20 = param_5;
  if (param_4 < 0x41) {
    if (param_4 == 0) {
      if (*(long *)PTR____stack_chk_guard_00028030 == lStack_18) {
        FUN_00011fe0();
        return;
      }
      goto LAB_00011fd4;
    }
    uVar2 = 0;
    do {
      uVar3 = *puStack_20;
      puStack_20 = puStack_20 + 1;
      *(undefined8 *)((long)&puStack_20 + (uVar2 * 8 - (param_4 * 8 + 0xf & 0xfffffffffffffff0))) =
           uVar3;
      uVar2 = uVar2 + 1;
    } while (param_4 != uVar2);
    param_1 = FUN_00011fe0();
  }
  else {
    piVar1 = ___error();
    *piVar1 = 7;
    param_1 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lStack_18) {
    return;
  }
LAB_00011fd4:
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(param_1);
}



ulong _ahpl_input_exec_argv
                (undefined8 param_1,undefined8 param_2,undefined8 param_3,long param_4,
                undefined8 *param_5)

{
  int iVar1;
  uint uVar2;
  long lVar3;
  ulong uVar4;
  int *piVar5;
  undefined8 *puVar6;
  undefined8 *puVar7;
  
  lVar3 = FUN_0000e114();
  if (lVar3 == 0) {
    iVar1 = 0x16;
    goto LAB_00012090;
  }
  iVar1 = FUN_0000e398();
  if (iVar1 < 0) {
    FUN_00012610();
    uVar4 = 0xffffffea;
  }
  else {
    if (*(int *)(lVar3 + 0x260) < 0) {
      uVar4 = FUN_000123fc(lVar3,param_2,param_3,param_4,param_5);
    }
    else {
      FUN_00012648();
      if (*(ulong *)(lVar3 + 0x2c8) < *(ulong *)(lVar3 + 0x2b0)) {
        uVar2 = *(uint *)(lVar3 + 0x268);
        if (((*(uint *)(lVar3 + 0x260) >> 0x1e & 1) != 0) && ((uVar2 >> 0xf & 1) != 0))
        goto LAB_000121ac;
        if ((uVar2 >> 0xf & 1) == 0) {
          uVar4 = _ahpl_mpq_queue(uVar2,0xffffffff,*(undefined4 *)(lVar3 + 0x18),param_2,
                                  FUN_00012508,0);
          if ((int)uVar4 < 0) {
LAB_0001210c:
            piVar5 = ___error();
            iVar1 = *piVar5;
            if (iVar1 == 0) goto LAB_0001217c;
            uVar4 = (ulong)(uint)-iVar1;
            if (0 < iVar1) goto LAB_00012180;
          }
          else if ((*(byte *)(lVar3 + 0x263) >> 6 & 1) == 0) {
LAB_000120fc:
            *(int *)(lVar3 + 0x26c) = *(int *)(lVar3 + 0x26c) + 1;
          }
          puVar6 = (undefined8 *)_ahpl_malloc(param_4 * 8 + 0x18);
          if (puVar6 == (undefined8 *)0x0) {
LAB_000121ac:
                    // WARNING: Subroutine does not return
            _abort();
          }
          puVar6[1] = param_3;
          puVar6[2] = param_4;
          if (param_4 != 0) {
            puVar7 = puVar6 + 3;
            do {
              *puVar7 = *param_5;
              param_4 = param_4 + -1;
              puVar7 = puVar7 + 1;
              param_5 = param_5 + 1;
            } while (param_4 != 0);
          }
          *puVar6 = 0;
          puVar7 = (undefined8 *)(lVar3 + 0x2b8);
          if (*(undefined8 **)(lVar3 + 0x2c0) != (undefined8 *)0x0) {
            puVar7 = *(undefined8 **)(lVar3 + 0x2c0);
          }
          *puVar7 = puVar6;
          *(undefined8 **)(lVar3 + 0x2c0) = puVar6;
          *(long *)(lVar3 + 0x2c8) = *(long *)(lVar3 + 0x2c8) + 1;
        }
        else {
          if ((*(uint *)(lVar3 + 0x260) >> 0x1e & 1) == 0) {
            uVar2 = _ahpl_mpqp_queue(DAT_000298f0,0xffffffff,*(undefined4 *)(lVar3 + 0x18),param_2,
                                     FUN_00012508,0);
            if ((uVar2 >> 0xf & 1) == 0) {
              uVar4 = 0;
              *(uint *)(lVar3 + 0x268) = uVar2;
              goto LAB_000120fc;
            }
            goto LAB_0001210c;
          }
LAB_0001217c:
          uVar4 = 0xffffffea;
        }
      }
      else {
        uVar4 = 0xfffffff0;
      }
LAB_00012180:
      FUN_00012640();
    }
    FUN_00012638();
    FUN_00012610();
    if ((uint)uVar4 < 0xfffff001) {
      return uVar4;
    }
  }
  iVar1 = -(int)uVar4;
LAB_00012090:
  piVar5 = ___error();
  *piVar5 = iVar1;
  return 0xffffffff;
}



ulong FUN_00011fe0(undefined8 param_1,undefined8 param_2,undefined8 param_3,long param_4,
                  undefined8 *param_5)

{
  int iVar1;
  uint uVar2;
  long lVar3;
  ulong uVar4;
  int *piVar5;
  undefined8 *puVar6;
  undefined8 *puVar7;
  
  lVar3 = FUN_0000e114();
  if (lVar3 == 0) {
    iVar1 = 0x16;
    goto LAB_00012090;
  }
  iVar1 = FUN_0000e398();
  if (iVar1 < 0) {
    FUN_00012610();
    uVar4 = 0xffffffea;
  }
  else {
    if (*(int *)(lVar3 + 0x260) < 0) {
      uVar4 = FUN_000123fc(lVar3,param_2,param_3,param_4,param_5);
    }
    else {
      FUN_00012648();
      if (*(ulong *)(lVar3 + 0x2c8) < *(ulong *)(lVar3 + 0x2b0)) {
        uVar2 = *(uint *)(lVar3 + 0x268);
        if (((*(uint *)(lVar3 + 0x260) >> 0x1e & 1) != 0) && ((uVar2 >> 0xf & 1) != 0))
        goto LAB_000121ac;
        if ((uVar2 >> 0xf & 1) == 0) {
          uVar4 = _ahpl_mpq_queue(uVar2,0xffffffff,*(undefined4 *)(lVar3 + 0x18),param_2,
                                  FUN_00012508,0);
          if ((int)uVar4 < 0) {
LAB_0001210c:
            piVar5 = ___error();
            iVar1 = *piVar5;
            if (iVar1 == 0) goto LAB_0001217c;
            uVar4 = (ulong)(uint)-iVar1;
            if (0 < iVar1) goto LAB_00012180;
          }
          else if ((*(byte *)(lVar3 + 0x263) >> 6 & 1) == 0) {
LAB_000120fc:
            *(int *)(lVar3 + 0x26c) = *(int *)(lVar3 + 0x26c) + 1;
          }
          puVar6 = (undefined8 *)_ahpl_malloc(param_4 * 8 + 0x18);
          if (puVar6 == (undefined8 *)0x0) {
LAB_000121ac:
                    // WARNING: Subroutine does not return
            _abort();
          }
          puVar6[1] = param_3;
          puVar6[2] = param_4;
          if (param_4 != 0) {
            puVar7 = puVar6 + 3;
            do {
              *puVar7 = *param_5;
              param_4 = param_4 + -1;
              puVar7 = puVar7 + 1;
              param_5 = param_5 + 1;
            } while (param_4 != 0);
          }
          *puVar6 = 0;
          puVar7 = (undefined8 *)(lVar3 + 0x2b8);
          if (*(undefined8 **)(lVar3 + 0x2c0) != (undefined8 *)0x0) {
            puVar7 = *(undefined8 **)(lVar3 + 0x2c0);
          }
          *puVar7 = puVar6;
          *(undefined8 **)(lVar3 + 0x2c0) = puVar6;
          *(long *)(lVar3 + 0x2c8) = *(long *)(lVar3 + 0x2c8) + 1;
        }
        else {
          if ((*(uint *)(lVar3 + 0x260) >> 0x1e & 1) == 0) {
            uVar2 = _ahpl_mpqp_queue(DAT_000298f0,0xffffffff,*(undefined4 *)(lVar3 + 0x18),param_2,
                                     FUN_00012508,0);
            if ((uVar2 >> 0xf & 1) == 0) {
              uVar4 = 0;
              *(uint *)(lVar3 + 0x268) = uVar2;
              goto LAB_000120fc;
            }
            goto LAB_0001210c;
          }
LAB_0001217c:
          uVar4 = 0xffffffea;
        }
      }
      else {
        uVar4 = 0xfffffff0;
      }
LAB_00012180:
      FUN_00012640();
    }
    FUN_00012638();
    FUN_00012610();
    if ((uint)uVar4 < 0xfffff001) {
      return uVar4;
    }
  }
  iVar1 = -(int)uVar4;
LAB_00012090:
  piVar5 = ___error();
  *piVar5 = iVar1;
  return 0xffffffff;
}



undefined4 _ahpl_input_waitings_count(void)

{
  long lVar1;
  int *piVar2;
  undefined4 uVar3;
  
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar3 = 0xffffffff;
  }
  else {
    if (*(int *)(lVar1 + 0x260) < 0) {
      piVar2 = ___error();
      *piVar2 = 0x16;
      uVar3 = 0xffffffff;
    }
    else {
      uVar3 = *(undefined4 *)(lVar1 + 0x2c8);
    }
    FUN_00012610();
  }
  return uVar3;
}



void _ahpl_input_remove_waitings_head(void)

{
  long lVar1;
  int iVar2;
  long lVar3;
  undefined8 uVar4;
  int *piVar5;
  long lVar6;
  long *plVar7;
  
  lVar3 = FUN_0000e114();
  if (lVar3 == 0) {
    piVar5 = ___error();
    *piVar5 = 0x16;
  }
  else {
    if ((*(int *)(lVar3 + 0x260) < 0) || (iVar2 = FUN_0000e398(lVar3), iVar2 < 0)) {
      iVar2 = 0x16;
    }
    else {
      lVar1 = lVar3 + 0x270;
      FUN_00004aec(lVar1);
      plVar7 = *(long **)(lVar3 + 0x2b8);
      if (plVar7 != (long *)0x0) {
        lVar6 = *plVar7;
        *(long *)(lVar3 + 0x2b8) = lVar6;
        if (lVar6 == 0) {
          *(undefined8 *)(lVar3 + 0x2c0) = 0;
        }
        FUN_00012624();
        FUN_00004b20(lVar1);
        FUN_00012638();
        (*(code *)plVar7[1])(lVar3,1,plVar7[2],plVar7 + 3);
        _free(plVar7);
        FUN_00012610();
        uVar4 = 0;
        goto LAB_000122c0;
      }
      FUN_00004b20(lVar1);
      FUN_00012638();
      iVar2 = 2;
    }
    FUN_00012610();
    piVar5 = ___error();
    *piVar5 = iVar2;
  }
  uVar4 = 0xffffffff;
LAB_000122c0:
  FUN_00012618(uVar4);
  return;
}



undefined8 FUN_000122dc(long param_1)

{
  uint uVar1;
  uint uVar2;
  undefined8 uVar3;
  long *in_x6;
  long lVar4;
  
  lVar4 = *in_x6;
  uVar1 = *(uint *)(in_x6 + 1);
  uVar3 = (*DAT_00028ca8)();
  if (-1 < (int)uVar3) {
    uVar2 = (uint)(lVar4 == 0) << 0x1f;
    *(uint *)(param_1 + 0x260) = uVar2;
    if ((uVar1 >> 0xf & 1) == 0) {
      *(uint *)(param_1 + 0x260) = uVar2 | 0x40000000;
      *(uint *)(param_1 + 0x268) = uVar1;
    }
    if (lVar4 == 0) {
      uVar3 = 0;
    }
    else {
      if ((uVar1 >> 0xf & 1) != 0) {
        *(undefined8 *)(param_1 + 0x268) = 0xffffffff;
      }
      FUN_00004a38(param_1 + 0x270);
      uVar3 = 0;
      *(long *)(param_1 + 0x2b0) = lVar4;
      *(undefined8 *)(param_1 + 0x2b8) = 0;
      *(undefined8 *)(param_1 + 0x2c8) = 0;
      *(undefined8 *)(param_1 + 0x2c0) = 0;
    }
  }
  return uVar3;
}



void FUN_00012388(long param_1)

{
  long lVar1;
  long *plVar2;
  
  if (-1 < *(int *)(param_1 + 0x260)) {
    while (plVar2 = *(long **)(param_1 + 0x2b8), plVar2 != (long *)0x0) {
      lVar1 = *plVar2;
      *(long *)(param_1 + 0x2b8) = lVar1;
      if (lVar1 == 0) {
        *(undefined8 *)(param_1 + 0x2c0) = 0;
      }
      FUN_00012624();
      (*(code *)plVar2[1])(1,1,plVar2[2],plVar2 + 3);
      _free(plVar2);
    }
    FUN_00004b3c(param_1 + 0x270);
  }
  (*DAT_00028cb0)(param_1);
  return;
}



void FUN_000123fc(long param_1,undefined8 param_2,undefined8 param_3,long param_4,void *param_5)

{
  long lVar1;
  long lVar2;
  uint uVar3;
  ulong uVar4;
  int *piVar5;
  undefined8 *puVar6;
  undefined8 uStack_40;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  lVar1 = param_4 + 1;
  lVar2 = -(lVar1 * 8 + 0xfU & 0xfffffffffffffff0);
  puVar6 = (undefined8 *)((long)&uStack_40 + lVar2);
  *puVar6 = param_3;
  if (param_4 != 0) {
    _memcpy((void *)((long)&local_38 + lVar2),param_5,param_4 << 3);
  }
  if ((*(byte *)(param_1 + 0x263) >> 6 & 1) == 0) {
    uVar3 = _ahpl_mpqp_call_argv
                      (DAT_000298f0,*(undefined4 *)(param_1 + 0x18),param_2,FUN_000124f4,lVar1,
                       puVar6);
    if ((uVar3 >> 0xf & 1) == 0) {
      uVar4 = 0;
      goto LAB_000124cc;
    }
  }
  else {
    uVar4 = _ahpl_mpq_call_argv(*(undefined4 *)(param_1 + 0x268),*(undefined4 *)(param_1 + 0x18),
                                param_2,FUN_000124f4,lVar1,puVar6);
    if (-1 < (int)uVar4) goto LAB_000124cc;
  }
  piVar5 = ___error();
  uVar3 = 0xffffffea;
  if (*piVar5 != 0) {
    uVar3 = -*piVar5;
  }
  uVar4 = (ulong)uVar3;
LAB_000124cc:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    FUN_00012618();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar4);
}



void FUN_000124f4(undefined8 param_1,undefined8 param_2,long param_3,code **param_4)

{
                    // WARNING: Could not recover jumptable at 0x00012504. Too many branches
                    // WARNING: Treating indirect jump as call
  (**param_4)(param_2,0,param_3 + -1,param_4 + 1);
  return;
}



void FUN_00012508(undefined8 param_1,long param_2)

{
  int iVar1;
  undefined8 uVar2;
  long lVar3;
  long *plVar4;
  
  if (param_2 != 1) {
    FUN_00012648();
    plVar4 = *(long **)(param_2 + 0x2b8);
    if (plVar4 == (long *)0x0) {
      FUN_00012640();
    }
    else {
      lVar3 = *plVar4;
      *(long *)(param_2 + 0x2b8) = lVar3;
      if (lVar3 == 0) {
        *(undefined8 *)(param_2 + 0x2c0) = 0;
      }
      *(long *)(param_2 + 0x2c8) = *(long *)(param_2 + 0x2c8) + -1;
      *plVar4 = 0;
      FUN_00012640();
      lVar3 = _objc_autoreleasePoolPush();
      (*(code *)plVar4[1])(param_2,0,plVar4[2],plVar4 + 3);
      if (lVar3 != 0) {
        _objc_autoreleasePoolPop(lVar3);
      }
      lVar3 = FUN_000090e4();
      lVar3 = *(long *)(lVar3 + 0x1a0);
      uVar2 = *(undefined8 *)(lVar3 + 8);
      *(undefined8 *)(lVar3 + 8) = 0;
      FUN_0000f048(uVar2,0);
      *(undefined8 *)(lVar3 + 0x10) = 0;
      *(undefined4 *)(lVar3 + 0x18) = 0;
      if (*(long *)(lVar3 + 0x20) != 0) {
        FUN_0000f214(*(long *)(lVar3 + 0x20),0);
        *(undefined8 *)(lVar3 + 0x20) = 0;
      }
      *(undefined8 *)(lVar3 + 0x28) = 0;
      _free(plVar4);
    }
    if ((*(byte *)(param_2 + 0x263) >> 6 & 1) == 0) {
      FUN_00012648();
      iVar1 = *(int *)(param_2 + 0x26c) + -1;
      *(int *)(param_2 + 0x26c) = iVar1;
      if (iVar1 == 0) {
        *(undefined4 *)(param_2 + 0x268) = 0xffffffff;
      }
      FUN_00004b20(param_2 + 0x270);
      return;
    }
  }
  return;
}



void FUN_00012610(void)

{
  FUN_0000e1e0();
  return;
}



void FUN_00012618(void)

{
  return;
}



void FUN_00012624(void)

{
  long unaff_x19;
  undefined8 *unaff_x20;
  
  *(long *)(unaff_x19 + 0x2c8) = *(long *)(unaff_x19 + 0x2c8) + -1;
  *unaff_x20 = 0;
  return;
}



void FUN_00012638(void)

{
  FUN_0000e454();
  return;
}



void FUN_00012640(void)

{
  FUN_00004b20();
  return;
}



void FUN_00012648(void)

{
  FUN_00004aec();
  return;
}



void _ahpl_queue_create(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  undefined4 uVar1;
  ulong uVar2;
  int *piVar3;
  undefined8 in_x6;
  undefined8 in_x7;
  
  uVar2 = FUN_0000de70(&DAT_00028d20,param_1,param_2,0,1,1,in_x6,in_x7,param_3);
  if ((uVar2 == 0) || (0xfffffffffffff000 < uVar2)) {
    piVar3 = ___error();
    *piVar3 = -(int)uVar2;
    uVar1 = 0xffffffff;
  }
  else {
    uVar1 = *(undefined4 *)(uVar2 + 0x18);
  }
  FUN_000131cc(uVar1);
  return;
}



void _ahpl_queue_add(void)

{
  undefined8 uVar1;
  
  uVar1 = FUN_00013160();
  FUN_000126d4(uVar1,0);
  FUN_000131e4();
  return;
}



void FUN_000126d4(undefined8 param_1)

{
  int *piVar1;
  ulong in_x4;
  undefined8 *in_x5;
  ulong uVar2;
  undefined8 uVar3;
  undefined8 *local_20;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  local_20 = in_x5;
  if (in_x4 < 0x41) {
    if (in_x4 == 0) {
      if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
        FUN_000127d8();
        return;
      }
      goto LAB_000127a4;
    }
    uVar2 = 0;
    do {
      uVar3 = *local_20;
      local_20 = local_20 + 1;
      *(undefined8 *)((long)&local_20 + (uVar2 * 8 - (in_x4 * 8 + 0xf & 0xfffffffffffffff0))) =
           uVar3;
      uVar2 = uVar2 + 1;
    } while (in_x4 != uVar2);
    param_1 = FUN_000127d8();
  }
  else {
    piVar1 = ___error();
    *piVar1 = 7;
    param_1 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
    return;
  }
LAB_000127a4:
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(param_1);
}



void _ahpl_queue_add_args
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  FUN_000126d4(param_1,0,param_2,param_3,param_4,param_5);
  return;
}



void _ahpl_queue_add_argv
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  FUN_000127d8(param_1,0,param_2,param_3,param_4,param_5);
  return;
}



ulong FUN_000127d8(undefined8 param_1,int param_2,undefined8 param_3,long *param_4,long *param_5,
                  long **param_6)

{
  char cVar1;
  bool bVar2;
  int iVar3;
  long lVar4;
  long **pplVar5;
  long *plVar6;
  long lVar7;
  ulong uVar8;
  int *piVar9;
  undefined4 uVar10;
  long **pplVar11;
  uint uVar12;
  int extraout_w9;
  int extraout_w9_00;
  long **pplVar13;
  ulong uVar14;
  
  lVar4 = FUN_0000e114();
  if (lVar4 != 0) {
    iVar3 = FUN_0000e398();
    if (-1 < iVar3) {
      pplVar5 = (long **)_ahpl_malloc((long)param_5 * 8 + 0x40);
      if (pplVar5 == (long **)0x0) {
LAB_00012ae8:
                    // WARNING: Subroutine does not return
        _abort();
      }
      *pplVar5 = (long *)pplVar5;
      pplVar5[1] = (long *)pplVar5;
      *(undefined4 *)(pplVar5 + 5) = 1;
      plVar6 = (long *)_ahpl_strdup(param_3);
      pplVar5[2] = plVar6;
      pplVar5[3] = param_4;
      pplVar5[7] = param_5;
      if (param_5 != (long *)0x0) {
        pplVar11 = pplVar5 + 8;
        do {
          *pplVar11 = *param_6;
          param_5 = (long *)((long)param_5 + -1);
          pplVar11 = pplVar11 + 1;
          param_6 = param_6 + 1;
        } while (param_5 != (long *)0x0);
      }
      FUN_00013184();
      if (*(uint *)(lVar4 + 0x2c8) < *(uint *)(lVar4 + 0x2b0)) {
        pplVar11 = pplVar5 + 5;
        do {
          cVar1 = '\x01';
          bVar2 = (bool)ExclusiveMonitorPass(pplVar11,0x10);
          if (bVar2) {
            *(int *)pplVar11 = *(int *)pplVar11 + 1;
            cVar1 = ExclusiveMonitorsStatus();
          }
        } while (cVar1 != '\0');
        plVar6 = *(long **)(lVar4 + 0x2c0);
        *(long ***)(lVar4 + 0x2c0) = pplVar5;
        *pplVar5 = (long *)(lVar4 + 0x2b8);
        pplVar5[1] = plVar6;
        *plVar6 = (long)pplVar5;
        *(long *)(lVar4 + 0x2c8) = *(long *)(lVar4 + 0x2c8) + 1;
        plVar6 = (long *)_ahpl_tick_now();
        pplVar5[4] = plVar6;
        plVar6 = *(long **)(lVar4 + 0x2d0);
        pplVar5[6] = plVar6;
        *(long *)(lVar4 + 0x2d0) = (long)plVar6 + 1;
        FUN_0001317c();
        if (*(int *)(lVar4 + 0x260) < 0) {
          uVar14 = (ulong)*(uint *)(lVar4 + 0x264);
          if ((*(uint *)(lVar4 + 0x264) >> 0xf & 1) != 0) goto LAB_00012ae8;
          bVar2 = false;
        }
        else {
          FUN_00013184();
          uVar14 = (ulong)*(uint *)(lVar4 + 0x264);
          if ((*(uint *)(lVar4 + 0x264) >> 0xf & 1) == 0) {
            bVar2 = false;
          }
          else {
            uVar14 = FUN_0000c6dc();
            if (((uint)uVar14 >> 0xf & 1) != 0) goto LAB_00012ae8;
            *(uint *)(lVar4 + 0x264) = (uint)uVar14;
            bVar2 = true;
          }
          *(int *)(lVar4 + 0x268) = *(int *)(lVar4 + 0x268) + 1;
          FUN_0001317c();
        }
        if (param_2 == 1) {
          uVar10 = *(undefined4 *)(lVar4 + 0x18);
LAB_00012980:
          uVar8 = _ahpl_mpq_call(uVar14,uVar10,"__queue_process",FUN_00012ff0,1);
        }
        else {
          if (param_2 == 0) {
            uVar10 = *(undefined4 *)(lVar4 + 0x18);
          }
          else {
            lVar7 = FUN_000090e4();
            if (lVar7 == 0) {
              iVar3 = -1;
            }
            else {
              iVar3 = *(int *)(lVar7 + 0x14);
            }
            uVar10 = *(undefined4 *)(lVar4 + 0x18);
            if (iVar3 == (int)uVar14) goto LAB_00012980;
          }
          uVar8 = _ahpl_mpq_queue(uVar14,0xffffffff,uVar10,"__queue_process",FUN_00012ff0,0);
        }
        if (bVar2) {
          FUN_0000c808(uVar14);
        }
        if ((int)uVar8 < 0) {
          piVar9 = ___error();
          uVar12 = 0xffffffea;
          if (*piVar9 != 0) {
            uVar12 = -*piVar9;
          }
          uVar8 = (ulong)uVar12;
          if (-1 < *(int *)(lVar4 + 0x260)) {
            FUN_00013184();
            iVar3 = *(int *)(lVar4 + 0x268) + -1;
            *(int *)(lVar4 + 0x268) = iVar3;
            if (iVar3 == 0) {
              *(undefined4 *)(lVar4 + 0x264) = 0xffffffff;
            }
            FUN_0001317c();
          }
          if ((int)uVar12 < 0) {
            FUN_00013184();
            pplVar11 = (long **)*pplVar5;
            if (pplVar11 == pplVar5) {
              FUN_0001317c();
              uVar8 = 0;
            }
            else {
              pplVar13 = (long **)pplVar5[1];
              pplVar11[1] = (long *)pplVar13;
              *pplVar13 = (long *)pplVar11;
              *pplVar5 = (long *)pplVar5;
              pplVar5[1] = (long *)pplVar5;
              *(long *)(lVar4 + 0x2c8) = *(long *)(lVar4 + 0x2c8) + -1;
              FUN_0001317c();
              FUN_000131a4();
              if (extraout_w9_00 == 0) {
                _free(pplVar5[2]);
                _free(pplVar5);
              }
            }
          }
        }
      }
      else {
        FUN_0001317c();
        uVar8 = 0xffffffdd;
      }
      FUN_000131a4();
      if (extraout_w9 == 0) {
        _free(pplVar5[2]);
        _free(pplVar5);
      }
      if (0xfffff000 < (uint)uVar8) {
        piVar9 = ___error();
        *piVar9 = -(uint)uVar8;
        uVar8 = 0xffffffff;
      }
      FUN_0000e454(lVar4);
      FUN_000131bc();
      if ((uint)uVar8 < 0xfffff001) {
        return uVar8;
      }
      iVar3 = 1;
      goto LAB_000128f4;
    }
    FUN_000131bc();
  }
  iVar3 = 0x16;
LAB_000128f4:
  piVar9 = ___error();
  *piVar9 = iVar3;
  return 0xffffffff;
}



void _ahpl_queue_call(void)

{
  undefined8 uVar1;
  
  uVar1 = FUN_00013160();
  FUN_000126d4(uVar1,1);
  FUN_000131e4();
  return;
}



void _ahpl_queue_call_args
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  FUN_000126d4(param_1,1,param_2,param_3,param_4,param_5);
  return;
}



void _ahpl_queue_call_argv
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  FUN_000127d8(param_1,1,param_2,param_3,param_4,param_5);
  return;
}



void _ahpl_queue_run(void)

{
  undefined8 uVar1;
  
  uVar1 = FUN_00013160();
  FUN_000126d4(uVar1,2);
  FUN_000131e4();
  return;
}



void _ahpl_queue_run_args
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  FUN_000126d4(param_1,2,param_2,param_3,param_4,param_5);
  return;
}



void _ahpl_queue_run_argv
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  FUN_000127d8(param_1,2,param_2,param_3,param_4,param_5);
  return;
}



void _ahpl_queue_set_max(undefined8 param_1,int param_2)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  
  if ((param_2 == 0) || (lVar1 = FUN_0000e114(), lVar1 == 0)) {
    piVar3 = ___error();
    *piVar3 = 0x16;
    uVar2 = 0xffffffff;
  }
  else {
    FUN_00013184();
    *(int *)(lVar1 + 0x2b0) = param_2;
    FUN_0001317c();
    FUN_0000e1e0(lVar1);
    uVar2 = 0;
  }
  FUN_000131d8(uVar2);
  return;
}



undefined4 _ahpl_queue_count(void)

{
  long lVar1;
  int *piVar2;
  undefined4 uVar3;
  
  lVar1 = FUN_0000e114();
  if (lVar1 == 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar3 = 0xffffffff;
  }
  else {
    uVar3 = *(undefined4 *)(lVar1 + 0x2c8);
    FUN_0000e1e0();
  }
  return uVar3;
}



undefined8 _ahpl_queue_clear(void)

{
  long lVar1;
  int iVar2;
  long lVar3;
  void *pvVar4;
  int *piVar5;
  int extraout_w9;
  long lVar6;
  long *plVar7;
  undefined8 uVar8;
  undefined **local_40;
  undefined **local_38;
  
  local_38 = (undefined **)&local_40;
  local_40 = (undefined **)&local_40;
  lVar3 = FUN_0000e114();
  if (lVar3 == 0) {
    iVar2 = 0x16;
  }
  else {
    iVar2 = FUN_0000e398();
    if (iVar2 < 0) {
      FUN_000131bc();
      uVar8 = 0xffffffea;
    }
    else {
      FUN_00013184();
      lVar1 = lVar3 + 0x2b8;
      lVar6 = *(long *)(lVar3 + 0x2b8);
      if (lVar6 != lVar1) {
        plVar7 = *(long **)(lVar3 + 0x2c0);
        *(undefined ***)(lVar6 + 8) = local_38;
        *local_38 = (undefined *)lVar6;
        *plVar7 = (long)&local_40;
        *(long *)(lVar3 + 0x2b8) = lVar1;
        *(long *)(lVar3 + 0x2c0) = lVar1;
        local_38 = (undefined **)plVar7;
      }
      uVar8 = *(undefined8 *)(lVar3 + 0x2c8);
      *(undefined8 *)(lVar3 + 0x2c8) = 0;
      FUN_0001317c();
      FUN_0000e454(lVar3);
      pvVar4 = (void *)FUN_00012d3c(&local_40);
      while (pvVar4 != (void *)0x0) {
        FUN_00012d68(lVar3,pvVar4,lVar3,1);
        FUN_0001318c();
        if (extraout_w9 == 0) {
          _free(*(void **)((long)pvVar4 + 0x10));
          _free(pvVar4);
        }
        pvVar4 = (void *)FUN_00012d3c(&local_40);
      }
      FUN_000131bc();
      if ((uint)uVar8 < 0xfffff001) {
        return uVar8;
      }
    }
    iVar2 = -(int)uVar8;
  }
  piVar5 = ___error();
  *piVar5 = iVar2;
  return 0xffffffff;
}



long * FUN_00012d3c(long *param_1)

{
  long *plVar1;
  long lVar2;
  long *plVar3;
  
  plVar1 = (long *)*param_1;
  if (plVar1 != param_1) {
    lVar2 = *plVar1;
    plVar3 = (long *)plVar1[1];
    *(long **)(lVar2 + 8) = plVar3;
    *plVar3 = lVar2;
    *plVar1 = (long)plVar1;
    plVar1[1] = (long)plVar1;
    return plVar1;
  }
  return (long *)0x0;
}



void FUN_00012d68(long param_1,long param_2,undefined8 param_3,undefined8 param_4)

{
  int iVar1;
  code *pcVar2;
  int iVar3;
  int iVar4;
  long lVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  
  uVar7 = *(undefined8 *)(param_1 + 0x2d8);
  *(long *)(param_1 + 0x2d8) = param_2;
  if (DAT_000298e0 == (code *)0x0) {
    iVar3 = 0;
  }
  else {
    iVar3 = _ahpl_tick_us();
  }
  lVar5 = _objc_autoreleasePoolPush();
  (**(code **)(param_2 + 0x18))
            (param_3,param_4,param_2 + 0x20,*(undefined8 *)(param_2 + 0x38),param_2 + 0x40);
  if (lVar5 != 0) {
    _objc_autoreleasePoolPop(lVar5);
  }
  pcVar2 = DAT_000298e0;
  if (DAT_000298e0 != (code *)0x0) {
    uVar6 = *(undefined8 *)(param_2 + 0x10);
    iVar1 = *(int *)(param_2 + 0x20);
    iVar4 = _ahpl_tick_us();
    (*pcVar2)(uVar6,param_4,iVar3 + iVar1 * -1000,iVar4 - iVar3);
  }
  *(undefined8 *)(param_1 + 0x2d8) = uVar7;
  return;
}



void _ahpl_queue_run_func_arg(undefined8 param_1,ulong param_2,undefined8 *param_3)

{
  uint uVar1;
  long lVar2;
  undefined8 uVar3;
  int *piVar4;
  int iVar5;
  
  lVar2 = FUN_000090e4();
  if (((lVar2 == 0) || (uVar1 = *(uint *)(lVar2 + 0x14), (uVar1 >> 0xf & 1) != 0)) ||
     (lVar2 = FUN_0000e114(param_1), lVar2 == 0)) {
    iVar5 = -0x16;
  }
  else {
    if ((uVar1 == *(uint *)(lVar2 + 0x264)) && (lVar2 = *(long *)(lVar2 + 0x2d8), lVar2 != 0)) {
      if (param_2 < *(ulong *)(lVar2 + 0x38)) {
        if (param_3 != (undefined8 *)0x0) {
          *param_3 = *(undefined8 *)(lVar2 + param_2 * 8 + 0x40);
        }
        FUN_0000e1e0();
        uVar3 = 0;
        goto LAB_00012eb8;
      }
      iVar5 = -2;
    }
    else {
      iVar5 = -1;
    }
    FUN_0000e1e0();
  }
  piVar4 = ___error();
  *piVar4 = -iVar5;
  uVar3 = 0xffffffff;
LAB_00012eb8:
  FUN_000131d8(uVar3);
  return;
}



void FUN_00012ed4(long param_1)

{
  undefined8 uVar1;
  uint *in_x6;
  uint uVar2;
  
  uVar2 = *in_x6;
  uVar1 = (*DAT_00028ca8)();
  if (-1 < (int)uVar1) {
    *(undefined4 *)(param_1 + 0x260) = 0;
    if ((uVar2 >> 0xf & 1) == 0) {
      *(undefined4 *)(param_1 + 0x260) = 0x80000000;
    }
    else {
      *(undefined4 *)(param_1 + 0x268) = 0;
      uVar2 = 0xffffffff;
    }
    *(uint *)(param_1 + 0x264) = uVar2;
    FUN_00004a38(param_1 + 0x270);
    uVar1 = 0;
    *(undefined4 *)(param_1 + 0x2b0) = 0xffffffff;
    *(long *)(param_1 + 0x2b8) = param_1 + 0x2b8;
    *(long *)(param_1 + 0x2c0) = param_1 + 0x2b8;
    *(undefined8 *)(param_1 + 0x2c8) = 0;
    *(undefined8 *)(param_1 + 0x2d8) = 0;
    *(undefined8 *)(param_1 + 0x2d0) = 0;
  }
  FUN_000131cc(uVar1);
  return;
}



void FUN_00012f5c(long param_1)

{
  void *pvVar1;
  int extraout_w9;
  
  pvVar1 = (void *)FUN_00012d3c(param_1 + 0x2b8);
  while (pvVar1 != (void *)0x0) {
    *(long *)(param_1 + 0x2c8) = *(long *)(param_1 + 0x2c8) + -1;
    FUN_00012d68(param_1,pvVar1,1,1);
    FUN_0001318c();
    if (extraout_w9 == 0) {
      _free(*(void **)((long)pvVar1 + 0x10));
      _free(pvVar1);
    }
    pvVar1 = (void *)FUN_00012d3c(param_1 + 0x2b8);
  }
  FUN_00004b3c(param_1 + 0x270);
  (*DAT_00028cb0)(param_1);
  return;
}



void FUN_00012ff0(undefined8 param_1,long param_2,long param_3,long *param_4)

{
  long lVar1;
  int *piVar2;
  int iVar3;
  char cVar4;
  bool bVar5;
  undefined4 uVar6;
  void *pvVar7;
  long lVar8;
  undefined8 uVar9;
  long lVar10;
  
  if (param_2 != 1) {
    lVar1 = param_2 + 0x270;
    FUN_000131c4();
    pvVar7 = (void *)FUN_00012d3c(param_2 + 0x2b8);
    while( true ) {
      if (pvVar7 == (void *)0x0) {
        FUN_00004b20(lVar1);
        return;
      }
      *(long *)(param_2 + 0x2c8) = *(long *)(param_2 + 0x2c8) + -1;
      FUN_00004b20(lVar1);
      lVar8 = FUN_000090e4();
      FUN_00012d68(param_2,pvVar7,param_2,0);
      lVar10 = *(long *)(lVar8 + 0x1a0);
      uVar9 = *(undefined8 *)(lVar10 + 8);
      *(undefined8 *)(lVar10 + 8) = 0;
      FUN_0000f048(uVar9,0);
      *(undefined8 *)(lVar10 + 0x10) = 0;
      *(undefined4 *)(lVar10 + 0x18) = 0;
      if (*(long *)(lVar10 + 0x20) != 0) {
        FUN_0000f214(*(long *)(lVar10 + 0x20),0);
        *(undefined8 *)(lVar10 + 0x20) = 0;
      }
      *(undefined8 *)(lVar10 + 0x28) = 0;
      lVar10 = *(long *)((long)pvVar7 + 0x30);
      piVar2 = (int *)((long)pvVar7 + 0x28);
      do {
        iVar3 = *piVar2;
        cVar4 = '\x01';
        bVar5 = (bool)ExclusiveMonitorPass(piVar2,0x10);
        if (bVar5) {
          *piVar2 = iVar3 + -1;
          cVar4 = ExclusiveMonitorsStatus();
        }
      } while (cVar4 != '\0');
      if (iVar3 + -1 == 0) {
        _free(*(void **)((long)pvVar7 + 0x10));
        _free(pvVar7);
      }
      uVar6 = _ahpl_tick_now();
      *(undefined4 *)(lVar8 + 0x1d8) = uVar6;
      if (-1 < *(int *)(param_2 + 0x260)) {
        FUN_000131c4();
        iVar3 = *(int *)(param_2 + 0x268) + -1;
        *(int *)(param_2 + 0x268) = iVar3;
        if (iVar3 == 0) {
          *(undefined4 *)(param_2 + 0x264) = 0xffffffff;
        }
        FUN_00004b20(lVar1);
      }
      if ((param_3 != 0) && (-1 < lVar10 - *param_4)) break;
      FUN_000131c4();
      pvVar7 = (void *)FUN_00012d3c(param_2 + 0x2b8);
    }
  }
  return;
}



void FUN_00013160(void)

{
  return;
}



void FUN_0001317c(void)

{
  FUN_00004b20();
  return;
}



void FUN_00013184(void)

{
  FUN_00004aec();
  return;
}



void FUN_0001318c(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long unaff_x21;
  
  piVar1 = (int *)(unaff_x21 + 0x28);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_000131a4(void)

{
  int *piVar1;
  char cVar2;
  bool bVar3;
  long unaff_x20;
  
  piVar1 = (int *)(unaff_x20 + 0x28);
  do {
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar3) {
      *piVar1 = *piVar1 + -1;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return;
}



void FUN_000131bc(void)

{
  FUN_0000e1e0();
  return;
}



void FUN_000131c4(void)

{
  FUN_00004aec();
  return;
}



void FUN_000131cc(void)

{
  return;
}



void FUN_000131d8(void)

{
  return;
}



void FUN_000131e4(void)

{
  return;
}



void _ahpl_set_vlog_func(undefined *param_1)

{
  PTR__vsyslog_00028d38 = PTR__vsyslog_00028050;
  if (param_1 != (undefined *)0x0) {
    PTR__vsyslog_00028d38 = param_1;
  }
  return;
}



undefined4 _ahpl_get_log_level(void)

{
  return DAT_00028d40;
}



void _ahpl_set_log_level(uint param_1)

{
  if (param_1 < 8) {
    DAT_00028d40 = param_1;
  }
  return;
}



void _ahpl_log(undefined8 param_1,undefined8 param_2)

{
  FUN_00013250(param_1,param_2,&stack0x00000000);
  return;
}



void FUN_00013250(int param_1)

{
  bool bVar1;
  
  bVar1 = true;
  if (PTR__vsyslog_00028d38 != (undefined *)0x0) {
    bVar1 = DAT_00028d40 - param_1 < 0;
  }
  if (bVar1 != (PTR__vsyslog_00028d38 != (undefined *)0x0 && SBORROW4(DAT_00028d40,param_1))) {
    return;
  }
  (*(code *)PTR__vsyslog_00028d38)();
  return;
}



void _ahpl_vlog(int param_1)

{
  bool bVar1;
  
  bVar1 = true;
  if (PTR__vsyslog_00028d38 != (undefined *)0x0) {
    bVar1 = DAT_00028d40 - param_1 < 0;
  }
  if (bVar1 != (PTR__vsyslog_00028d38 != (undefined *)0x0 && SBORROW4(DAT_00028d40,param_1))) {
    return;
  }
  (*(code *)PTR__vsyslog_00028d38)();
  return;
}



void _ahpl_printf(undefined8 param_1)

{
  FUN_00013250(0,param_1,&stack0x00000000);
  return;
}



void _ahpl_vprintf(undefined8 param_1,undefined8 param_2)

{
  FUN_00013250(0,param_1,param_2);
  return;
}



void FUN_000132b8(void)

{
  pthread_t p_Var1;
  undefined8 in_x3;
  char acStack_80 [64];
  
  p_Var1 = _pthread_self();
  _pthread_getname_np(p_Var1,acStack_80,0x40);
  _ahpl_log(0,"------------[ cut here ]------------\n");
  _ahpl_log(0,"BUG(thread-%s/%p): %s:%d, caller=%p\n");
  _ahpl_vlog(0,in_x3,&stack0x00000000);
                    // WARNING: Subroutine does not return
  _abort();
}



void _ahpl_panic(undefined8 param_1)

{
  _ahpl_vlog(0,param_1,&stack0x00000000);
                    // WARNING: Subroutine does not return
  _abort();
}



char * _ahpl_get_git_branch(void)

{
  return "customer/xueersi";
}



char * _ahpl_get_git_commit(void)

{
  return "895e0436";
}



void FUN_00013380(void)

{
  FUN_000154dc(&DAT_00029e30);
  DAT_00029f40 = 0;
  DAT_00029f48 = FUN_000133b4;
  DAT_00029f50 = 0;
  return;
}



int FUN_000133b4(long param_1,long param_2,byte **param_3)

{
  byte bVar1;
  byte bVar2;
  int iVar3;
  byte *pbVar4;
  
  if (param_2 == 0) {
    pbVar4 = *param_3;
  }
  else {
    pbVar4 = *(byte **)(param_2 + 0x18);
  }
  bVar1 = **(byte **)(param_1 + 0x18);
  bVar2 = *pbVar4;
  if (bVar2 <= bVar1 && bVar1 != bVar2) {
    iVar3 = 1;
  }
  else if (bVar2 <= bVar1) {
    iVar3 = _strcmp((char *)*(byte **)(param_1 + 0x18),(char *)pbVar4);
  }
  else {
    iVar3 = -1;
  }
  return iVar3;
}



void _ahpl_module_register(char *param_1,long param_2)

{
  long lVar1;
  int *piVar2;
  undefined8 uVar3;
  int iVar4;
  
  if (((param_1 == (char *)0x0) || (param_2 == 0)) || (*param_1 == '\0')) {
    piVar2 = ___error();
    *piVar2 = 0x16;
  }
  else {
    FUN_00015504(&DAT_00029e30);
    lVar1 = _ahpl_find_rb_node(&DAT_00029f40,0);
    if (lVar1 == 0) {
      lVar1 = _ahpl_malloc(0x30);
      if (lVar1 != 0) {
        *(char **)(lVar1 + 0x18) = param_1;
        *(long *)(lVar1 + 0x28) = param_2;
        *(undefined4 *)(lVar1 + 0x20) = 1;
        _ahpl_rb_insert_node(&DAT_00029f40,lVar1);
        FUN_00015548(&DAT_00029e30);
        uVar3 = 0;
        goto LAB_00013490;
      }
      iVar4 = 0xc;
    }
    else {
      iVar4 = 0x11;
    }
    FUN_00015548(&DAT_00029e30);
    piVar2 = ___error();
    *piVar2 = iVar4;
  }
  uVar3 = 0xffffffff;
LAB_00013490:
  FUN_0001373c(uVar3);
  return;
}



long _ahpl_module_get(char *param_1)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  int *piVar4;
  
  if ((param_1 == (char *)0x0) || (*param_1 == '\0')) {
    piVar4 = ___error();
    lVar3 = 0;
    *piVar4 = 0x16;
  }
  else {
    FUN_00004bbc(&DAT_00029e78);
    lVar3 = _ahpl_find_rb_node(&DAT_00029f40,0);
    if (lVar3 != 0) {
      piVar4 = (int *)(lVar3 + 0x20);
      do {
        cVar1 = '\x01';
        bVar2 = (bool)ExclusiveMonitorPass(piVar4,0x10);
        if (bVar2) {
          *piVar4 = *piVar4 + 1;
          cVar1 = ExclusiveMonitorsStatus();
        }
      } while (cVar1 != '\0');
    }
    FUN_00004c24(&DAT_00029e78);
  }
  return lVar3;
}



void _ahpl_module_call(undefined8 param_1,undefined8 param_2)

{
  FUN_00013598(param_1,param_2,&stack0x00000000);
  return;
}



void FUN_00013598(long param_1,ulong param_2,undefined8 *param_3)

{
  int *piVar1;
  undefined8 uVar2;
  long lVar3;
  ulong uVar4;
  undefined8 *local_20;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  local_20 = param_3;
  if (param_2 < 0x41) {
    if (param_2 == 0) {
      lVar3 = 0;
    }
    else {
      lVar3 = (long)&local_20 - (param_2 * 8 + 0xf & 0xfffffffffffffff0);
      uVar4 = 0;
      do {
        uVar2 = *local_20;
        local_20 = local_20 + 1;
        *(undefined8 *)(lVar3 + uVar4 * 8) = uVar2;
        uVar4 = uVar4 + 1;
      } while (param_2 != uVar4);
    }
    uVar2 = (**(code **)(param_1 + 0x28))(param_2,lVar3);
  }
  else {
    piVar1 = ___error();
    *piVar1 = 7;
    uVar2 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_18) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  return;
}



void _ahpl_module_call_args(long param_1,ulong param_2,undefined8 *param_3)

{
  int *piVar1;
  undefined8 uVar2;
  long lVar3;
  ulong uVar4;
  undefined8 *puStack_20;
  long lStack_18;
  
  lStack_18 = *(long *)PTR____stack_chk_guard_00028030;
  puStack_20 = param_3;
  if (param_2 < 0x41) {
    if (param_2 == 0) {
      lVar3 = 0;
    }
    else {
      lVar3 = (long)&puStack_20 - (param_2 * 8 + 0xf & 0xfffffffffffffff0);
      uVar4 = 0;
      do {
        uVar2 = *puStack_20;
        puStack_20 = puStack_20 + 1;
        *(undefined8 *)(lVar3 + uVar4 * 8) = uVar2;
        uVar4 = uVar4 + 1;
      } while (param_2 != uVar4);
    }
    uVar2 = (**(code **)(param_1 + 0x28))(param_2,lVar3);
  }
  else {
    piVar1 = ___error();
    *piVar1 = 7;
    uVar2 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != lStack_18) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  return;
}



void _ahpl_module_call_argv(long param_1,undefined8 param_2,undefined8 param_3)

{
                    // WARNING: Could not recover jumptable at 0x00013664. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(param_1 + 0x28))(param_2,param_3);
  return;
}



void _ahpl_module_put(long param_1)

{
  int *piVar1;
  int iVar2;
  char cVar3;
  bool bVar4;
  
  piVar1 = (int *)(param_1 + 0x20);
  do {
    iVar2 = *piVar1;
    cVar3 = '\x01';
    bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
    if (bVar4) {
      *piVar1 = iVar2 + -1;
      cVar3 = ExclusiveMonitorsStatus();
    }
  } while (cVar3 != '\0');
  if (iVar2 + -1 != 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void _ahpl_module_unregister(char *param_1)

{
  void *pvVar1;
  undefined8 uVar2;
  int *piVar3;
  int iVar4;
  
  if ((param_1 == (char *)0x0) || (*param_1 == '\0')) {
    piVar3 = ___error();
    iVar4 = 0x16;
  }
  else {
    FUN_00015504(&DAT_00029e30);
    pvVar1 = (void *)_ahpl_rb_remove(&DAT_00029f40,0);
    FUN_00015548(&DAT_00029e30);
    if (pvVar1 != (void *)0x0) {
      iVar4 = *(int *)((long)pvVar1 + 0x20);
      while (1 < iVar4) {
        _usleep(1000);
        iVar4 = *(int *)((long)pvVar1 + 0x20);
      }
      _free(pvVar1);
      uVar2 = 0;
      goto LAB_00013734;
    }
    piVar3 = ___error();
    iVar4 = 2;
  }
  *piVar3 = iVar4;
  uVar2 = 0xffffffff;
LAB_00013734:
  FUN_0001373c(uVar2);
  return;
}



void FUN_0001373c(void)

{
  return;
}



undefined4 * FUN_00013748(undefined8 param_1,int param_2)

{
  char cVar1;
  bool bVar2;
  uint uVar3;
  int iVar4;
  undefined4 *puVar5;
  int *piVar6;
  
  while( true ) {
    puVar5 = (undefined4 *)FUN_00006254(param_1);
    if (puVar5 != (undefined4 *)0x0) goto LAB_0001387c;
    if (param_2 == 0) {
      piVar6 = ___error();
      iVar4 = 9;
      goto LAB_00013894;
    }
    puVar5 = (undefined4 *)_ahpl_malloc(0x20);
    if (puVar5 == (undefined4 *)0x0) {
      piVar6 = ___error();
      iVar4 = 0xc;
      goto LAB_00013894;
    }
    uVar3 = _ahpl_task_create(0,0,3,1,0xffffffff,0,0);
    puVar5[6] = uVar3;
    if ((uVar3 >> 0xf & 1) != 0) {
      piVar6 = ___error();
      iVar4 = *piVar6;
      _free(puVar5);
      if ((undefined4 *)0xfffffffffffff000 < (undefined4 *)-(long)iVar4) {
        piVar6 = ___error();
        *piVar6 = iVar4;
        return (undefined4 *)0x0;
      }
      if (iVar4 != 0) {
        return (undefined4 *)-(long)iVar4;
      }
      piVar6 = ___error();
      *piVar6 = 0;
      return (undefined4 *)0x0;
    }
    *puVar5 = (int)param_1;
    puVar5[1] = 1;
    puVar5[2] = 0;
    *(undefined8 *)(puVar5 + 4) = 0;
    iVar4 = FUN_00006060(param_1,puVar5);
    if (-1 < iVar4) break;
    _ahpl_ref_destroy(puVar5[6],1);
    _free(puVar5);
    if (iVar4 != -0x10) {
      if ((undefined4 *)(long)iVar4 < (undefined4 *)0xfffffffffffff001) {
        return (undefined4 *)(long)iVar4;
      }
      piVar6 = ___error();
      *piVar6 = -iVar4;
      return (undefined4 *)0x0;
    }
  }
  piVar6 = puVar5 + 1;
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(piVar6,0x10);
    if (bVar2) {
      *piVar6 = *piVar6 + 1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
LAB_0001387c:
  if (puVar5[2] == 0) {
    return puVar5;
  }
  FUN_000141fc();
  piVar6 = ___error();
  iVar4 = 0x16;
LAB_00013894:
  *piVar6 = iVar4;
  return (undefined4 *)0x0;
}



void _ahpl_file_open(char *param_1,int param_2)

{
  int iVar1;
  
  iVar1 = _open(param_1,param_2);
  FUN_000141f4(iVar1);
  return;
}



off_t _ahpl_file_size(int param_1)

{
  int iVar1;
  stat sStack_a0;
  
  iVar1 = _fstat(param_1,&sStack_a0);
  if (iVar1 < 0) {
    sStack_a0.st_size = -1;
  }
  return sStack_a0.st_size;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _ahpl_file_read(int param_1,void *param_2,size_t param_3)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248bc. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__read_000284f0)(param_1);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _ahpl_file_write(int param_1,void *param_2,size_t param_3)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a90. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__write_00028628)(param_1);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

off_t _ahpl_file_lseek(int param_1,off_t param_2,int param_3)

{
  off_t oVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245d4. Too many branches
                    // WARNING: Treating indirect jump as call
  oVar1 = (*(code *)PTR__lseek_00028300)(param_1,param_2,param_3);
  return oVar1;
}



void _ahpl_file_aread(void)

{
  FUN_00013950();
  FUN_000141f4();
  return;
}



void FUN_00013950(void)

{
  long in_x3;
  undefined8 *in_x4;
  long lVar1;
  undefined8 uVar2;
  undefined8 *local_20;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  local_20 = in_x4;
  if (in_x3 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
      FUN_00013a10();
      return;
    }
  }
  else {
    lVar1 = 0;
    do {
      uVar2 = *local_20;
      local_20 = local_20 + 1;
      *(undefined8 *)((long)&local_20 + (lVar1 * 8 - (in_x3 * 8 + 0xfU & 0xfffffffffffffff0))) =
           uVar2;
      lVar1 = lVar1 + 1;
    } while (in_x3 != lVar1);
    FUN_00013a10();
    if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_aread_args(void)

{
  long in_x3;
  undefined8 *in_x4;
  long lVar1;
  undefined8 uVar2;
  undefined8 *puStack_20;
  long lStack_18;
  
  lStack_18 = *(long *)PTR____stack_chk_guard_00028030;
  puStack_20 = in_x4;
  if (in_x3 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == lStack_18) {
      FUN_00013a10();
      return;
    }
  }
  else {
    lVar1 = 0;
    do {
      uVar2 = *puStack_20;
      puStack_20 = puStack_20 + 1;
      *(undefined8 *)((long)&puStack_20 + (lVar1 * 8 - (in_x3 * 8 + 0xfU & 0xfffffffffffffff0))) =
           uVar2;
      lVar1 = lVar1 + 1;
    } while (in_x3 != lVar1);
    FUN_00013a10();
    if (*(long *)PTR____stack_chk_guard_00028030 == lStack_18) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_aread_argv(void)

{
  FUN_00013a10();
  return;
}



ulong FUN_00013a10(int param_1,long param_2,long param_3,long param_4)

{
  ulong uVar1;
  int *piVar2;
  undefined4 *puVar3;
  long lVar4;
  long *unaff_x26;
  
  lVar4 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 == 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
  }
  else {
    uVar1 = FUN_00014204();
    if ((uVar1 != 0) && (uVar1 < 0xfffffffffffff001)) {
      FUN_000141cc((param_4 + 4) * 8);
      *unaff_x26 = (long)param_1;
      unaff_x26[1] = 0;
      unaff_x26[2] = param_2;
      unaff_x26[3] = param_3;
      if (param_4 != 0) {
        FUN_000141e4();
      }
      uVar1 = FUN_0000f5b8(*(undefined4 *)(uVar1 + 0x18),"file_async_read",FUN_00013f98,param_4 + 4)
      ;
      FUN_000141fc();
      goto LAB_00013ad4;
    }
    if (uVar1 < 0xfffffffffffff001) goto LAB_00013ad4;
    puVar3 = (undefined4 *)FUN_0001420c();
    *puVar3 = (int)uVar1;
  }
  uVar1 = 0xffffffff;
LAB_00013ad4:
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar4) {
    return uVar1;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_awrite(void)

{
  FUN_00013b40();
  FUN_000141f4();
  return;
}



void FUN_00013b40(void)

{
  undefined in_ZR;
  long in_x4;
  long lVar1;
  
  lVar1 = *(long *)PTR____stack_chk_guard_00028030;
  if (in_x4 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      FUN_00013bd0();
      return;
    }
  }
  else {
    FUN_0001418c();
    do {
      FUN_000141ac();
    } while (!(bool)in_ZR);
    FUN_00013bd0();
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_awrite_args(void)

{
  undefined in_ZR;
  long in_x4;
  long lVar1;
  
  lVar1 = *(long *)PTR____stack_chk_guard_00028030;
  if (in_x4 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      FUN_00013bd0();
      return;
    }
  }
  else {
    FUN_0001418c();
    do {
      FUN_000141ac();
    } while (!(bool)in_ZR);
    FUN_00013bd0();
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_awrite_argv(void)

{
  FUN_00013bd0();
  return;
}



void FUN_00013bd0(undefined8 param_1,void *param_2,size_t param_3,undefined8 param_4,long param_5,
                 void *param_6)

{
  long lVar1;
  int *piVar2;
  void *pvVar3;
  undefined4 *puVar4;
  ulong uVar5;
  long lStack_70;
  void *local_68;
  
  local_68 = *(void **)PTR____stack_chk_guard_00028030;
  if ((param_2 == (void *)0x0) && (param_3 != 0)) {
    piVar2 = ___error();
    *piVar2 = 0x16;
  }
  else {
    uVar5 = FUN_00014204(param_1);
    if ((uVar5 != 0) && (uVar5 < 0xfffffffffffff001)) {
      if (param_3 == 0) {
        pvVar3 = (void *)0x0;
LAB_00013c88:
        lVar1 = -((param_5 + 4) * 8 + 0xfU & 0xfffffffffffffff0);
        *(long *)((long)&lStack_70 + lVar1) = (long)(int)param_1;
        *(void **)((long)&local_68 + lVar1) = pvVar3;
        *(size_t *)(&stack0xffffffffffffffa0 + lVar1) = param_3;
        *(undefined8 *)(&stack0xffffffffffffffa8 + lVar1) = param_4;
        if (param_5 != 0) {
          _memcpy(&stack0xffffffffffffffb0 + lVar1,param_6,param_5 << 3);
        }
        uVar5 = FUN_0000f5b8(*(undefined4 *)(uVar5 + 0x18),"file_async_write",FUN_00014040,
                             param_5 + 4,(long *)((long)&lStack_70 + lVar1));
        if ((param_3 != 0) && ((int)uVar5 < 0)) {
          _free(pvVar3);
        }
      }
      else {
        pvVar3 = (void *)_ahpl_malloc(param_3);
        if (pvVar3 != (void *)0x0) {
          _memcpy(pvVar3,param_2,param_3);
          goto LAB_00013c88;
        }
        uVar5 = 0xffffffff;
      }
      FUN_000141fc();
      goto LAB_00013d08;
    }
    if (uVar5 < 0xfffffffffffff001) goto LAB_00013d08;
    puVar4 = (undefined4 *)FUN_0001420c();
    *puVar4 = (int)uVar5;
  }
  uVar5 = 0xffffffff;
LAB_00013d08:
  if (*(void **)PTR____stack_chk_guard_00028030 == local_68) {
    FUN_00014174(uVar5);
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_alseek(void)

{
  FUN_00013d58();
  FUN_000141f4();
  return;
}



void FUN_00013d58(void)

{
  undefined in_ZR;
  long in_x4;
  long lVar1;
  
  lVar1 = *(long *)PTR____stack_chk_guard_00028030;
  if (in_x4 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      FUN_00013de8();
      return;
    }
  }
  else {
    FUN_0001418c();
    do {
      FUN_000141ac();
    } while (!(bool)in_ZR);
    FUN_00013de8();
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_alseek_args(void)

{
  undefined in_ZR;
  long in_x4;
  long lVar1;
  
  lVar1 = *(long *)PTR____stack_chk_guard_00028030;
  if (in_x4 == 0) {
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      FUN_00013de8();
      return;
    }
  }
  else {
    FUN_0001418c();
    do {
      FUN_000141ac();
    } while (!(bool)in_ZR);
    FUN_00013de8();
    if (*(long *)PTR____stack_chk_guard_00028030 == lVar1) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_file_alseek_argv(void)

{
  FUN_00013de8();
  return;
}



void FUN_00013de8(int param_1,long param_2,int param_3,long param_4,long param_5)

{
  ulong uVar1;
  undefined4 *puVar2;
  long lVar3;
  long *unaff_x26;
  
  lVar3 = *(long *)PTR____stack_chk_guard_00028030;
  uVar1 = FUN_00014204();
  if ((uVar1 == 0) || (0xfffffffffffff000 < uVar1)) {
    if (0xfffffffffffff000 < uVar1) {
      puVar2 = (undefined4 *)FUN_0001420c();
      *puVar2 = (int)uVar1;
      uVar1 = 0xffffffff;
    }
  }
  else {
    FUN_000141cc((param_5 + 4) * 8);
    *unaff_x26 = (long)param_1;
    unaff_x26[1] = param_2;
    unaff_x26[2] = (long)param_3;
    unaff_x26[3] = param_4;
    if (param_5 != 0) {
      FUN_000141e4();
    }
    uVar1 = FUN_0000f5b8(*(undefined4 *)(uVar1 + 0x18),"file_async_lseek",FUN_000140f4,param_5 + 4);
    FUN_000141fc();
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar3) {
    FUN_00014174(uVar1);
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



int _ahpl_file_close(undefined8 param_1)

{
  int iVar1;
  ulong uVar2;
  undefined8 in_x6;
  undefined8 in_x7;
  
  uVar2 = FUN_00013748(param_1,0);
  if ((uVar2 != 0) && (uVar2 < 0xfffffffffffff001)) {
    iVar1 = FUN_000061a8(uVar2);
    if (iVar1 == 0) {
      iVar1 = _ahpl_ref_locked(*(undefined4 *)(uVar2 + 0x18));
      if (iVar1 == 0) {
        _ahpl_ref_destroy(*(undefined4 *)(uVar2 + 0x18),1);
      }
      else {
        _ahpl_mpqp_queue(DAT_000298f0,0xffffffff,0xffffffff,"afile_task_destroy",FUN_00013f8c,1,
                         in_x6,in_x7,*(undefined4 *)(uVar2 + 0x18));
      }
      *(undefined4 *)(uVar2 + 0x18) = 0xffffffff;
      FUN_000062d4(uVar2);
    }
    FUN_000062d4(uVar2);
  }
  iVar1 = _close((int)param_1);
  return iVar1;
}



void FUN_00013f8c(void)

{
  undefined4 *in_x3;
  
  _ahpl_ref_destroy(*in_x3,1);
  return;
}



void FUN_00013f98(undefined8 param_1,int param_2,undefined8 param_3,long param_4,int *param_5)

{
  int iVar1;
  void *pvVar2;
  ssize_t sVar3;
  int *piVar4;
  size_t sVar5;
  
  iVar1 = *param_5;
  sVar5 = *(size_t *)(param_5 + 4);
  if (param_2 != 0) {
    (**(code **)(param_5 + 6))
              (param_2 != 1,iVar1,sVar5,*(undefined8 *)(param_5 + 2),param_4 + -4,param_5 + 8);
    _free(*(void **)(param_5 + 2));
    return;
  }
  pvVar2 = (void *)_ahpl_malloc(sVar5);
  *(void **)(param_5 + 2) = pvVar2;
  if (pvVar2 == (void *)0x0) {
    sVar3 = -0xc;
  }
  else {
    sVar3 = _read(iVar1,pvVar2,sVar5);
    if (sVar3 < 0) {
      piVar4 = ___error();
      sVar3 = -(long)*piVar4;
    }
  }
  *(ssize_t *)(param_5 + 4) = sVar3;
  return;
}



void FUN_00014040(undefined8 param_1,int param_2,undefined8 param_3,long param_4,int *param_5)

{
  int iVar1;
  ssize_t sVar2;
  int *piVar3;
  void *pvVar4;
  size_t sVar5;
  
  iVar1 = *param_5;
  pvVar4 = *(void **)(param_5 + 2);
  if (param_2 == 0) {
    sVar5 = *(size_t *)(param_5 + 4);
    sVar2 = _write(iVar1,pvVar4,sVar5);
    if (sVar2 < 0) {
      piVar3 = ___error();
      sVar2 = -(long)*piVar3;
    }
    *(ssize_t *)(param_5 + 4) = sVar2;
    if (sVar5 != 0) {
      _free(pvVar4);
      *(undefined8 *)(param_5 + 2) = 0;
    }
  }
  else {
    _free(pvVar4);
    if (*(code **)(param_5 + 6) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x000140a4. Too many branches
                    // WARNING: Treating indirect jump as call
      (**(code **)(param_5 + 6))
                (param_2 != 1,iVar1,*(undefined8 *)(param_5 + 4),param_4 + -4,param_5 + 8);
      return;
    }
  }
  return;
}



void FUN_000140f4(undefined8 param_1,int param_2,undefined8 param_3,long param_4,int *param_5)

{
  off_t oVar1;
  int *piVar2;
  
  if (param_2 == 0) {
    oVar1 = _lseek(*param_5,*(off_t *)(param_5 + 2),param_5[4]);
    *(off_t *)(param_5 + 2) = oVar1;
    if (oVar1 == -1) {
      piVar2 = ___error();
      *(long *)(param_5 + 2) = -(long)*piVar2;
    }
  }
  else if (*(code **)(param_5 + 6) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x00014134. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_5 + 6))
              (param_2 != 1,*param_5,*(off_t *)(param_5 + 2),param_4 + -4,param_5 + 8);
    return;
  }
  return;
}



void FUN_00014174(void)

{
  return;
}



void FUN_0001418c(void)

{
  return;
}



void FUN_000141ac(long param_1)

{
  long in_x5;
  undefined8 *puVar1;
  long unaff_x29;
  
  puVar1 = *(undefined8 **)(unaff_x29 + -0x10);
  *(undefined8 **)(unaff_x29 + -0x10) = puVar1 + 1;
  *(undefined8 *)(in_x5 + param_1 * 8) = *puVar1;
  return;
}



void FUN_000141cc(void)

{
  return;
}



void FUN_000141e4(void)

{
  void *unaff_x20;
  long unaff_x21;
  long unaff_x26;
  
  _memcpy((void *)(unaff_x26 + 0x20),unaff_x20,unaff_x21 << 3);
  return;
}



void FUN_000141f4(void)

{
  return;
}



void FUN_000141fc(void)

{
  FUN_000062d4();
  return;
}



void FUN_00014204(undefined8 param_1)

{
  FUN_00013748(param_1,1);
  return;
}



void FUN_0001420c(void)

{
  ___error();
  return;
}



void FUN_00014214(ulong param_1,int param_2)

{
  int *piVar1;
  int iVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  uint uVar6;
  long unaff_x22;
  long *plVar7;
  int local_44;
  
  FUN_00004bbc(&DAT_00029fa0);
  FUN_000152fc();
  FUN_000152f0();
  if (unaff_x22 == 0) {
    local_44 = 0;
    FUN_00014370(&local_44);
    if (local_44 != 0) {
      FUN_00004bbc(&DAT_00029fa0);
      FUN_000152fc();
      FUN_000152f0();
    }
  }
  else {
    if ((param_1 < *(ulong *)(unaff_x22 + 0x20)) || (*(ulong *)(unaff_x22 + 0x28) <= param_1)) {
LAB_00014344:
                    // WARNING: Subroutine does not return
      _abort();
    }
    FUN_00015504(unaff_x22 + 0x30);
    plVar7 = (long *)(unaff_x22 + 0x140);
    iVar2 = *(int *)(unaff_x22 + 0x20);
    uVar6 = 0x1c;
    do {
      lVar5 = *plVar7;
      if (lVar5 == 0) {
        lVar5 = _ahpl_calloc(8,0x10);
        *plVar7 = lVar5;
        if (lVar5 == 0) goto LAB_00014344;
      }
      plVar7 = (long *)(lVar5 + (ulong)((uint)((int)param_1 - iVar2) >> (ulong)(uVar6 & 0x1f) & 0xf)
                                * 8);
      uVar6 = uVar6 - 4;
    } while (uVar6 != 0xfffffffc);
    lVar5 = *plVar7;
    if (lVar5 == 0) {
      lVar5 = _ahpl_calloc(4,2);
      *plVar7 = lVar5;
      if (lVar5 == 0) goto LAB_00014344;
    }
    piVar1 = (int *)(lVar5 + (ulong)(param_2 == 0) * 4);
    do {
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(piVar1,0x10);
      if (bVar4) {
        *piVar1 = *piVar1 + 1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
    FUN_00015548(unaff_x22 + 0x30);
  }
  return;
}



void FUN_00014348(void)

{
  FUN_000152c8(&DAT_0002a068);
  return;
}



void FUN_00014370(undefined8 param_1)

{
  FUN_00005c7c(FUN_00014b74,param_1);
  return;
}



void _ahpl_profile_data(code *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  FUN_00004bbc(&DAT_00029fa0);
  FUN_00015304(&DAT_0002a068,FUN_00014c2c);
  if (param_1 != (code *)0x0) {
    (*param_1)(0,0,0,param_2,0,param_4);
  }
  FUN_00004c24(&DAT_00029fa0);
  return;
}



void FUN_00014384(code *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  FUN_00004bbc(&DAT_00029fa0);
  FUN_00015304(&DAT_0002a068,FUN_00014c2c);
  if (param_1 != (code *)0x0) {
    (*param_1)(0,0,0,param_2,0,param_4);
  }
  FUN_00004c24(&DAT_00029fa0);
  return;
}



void _ahpl_profile_dump(long param_1,undefined8 param_2,undefined8 param_3)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  byte **ppbVar4;
  byte *pbVar5;
  int iVar6;
  short sVar7;
  byte **ppbVar8;
  byte *pbVar9;
  long lVar10;
  byte *pbVar11;
  byte *pbVar12;
  void **ppvVar13;
  byte *pbVar14;
  byte **local_108;
  undefined4 local_100;
  undefined4 local_fc;
  undefined8 local_f8;
  int local_f0;
  undefined8 local_e8;
  undefined4 local_e0;
  undefined2 local_dc;
  undefined4 local_da;
  undefined2 local_d6;
  undefined4 local_d4;
  undefined4 local_cc;
  undefined4 local_c4;
  undefined8 local_c0;
  code *pcStack_b8;
  undefined8 local_b0;
  undefined8 uStack_a8;
  code *local_a0;
  undefined8 local_98;
  undefined8 local_90;
  code *pcStack_88;
  undefined8 local_80;
  undefined8 uStack_78;
  code *local_70;
  undefined8 local_68;
  
  if (param_1 != 0) {
    uVar3 = _ahpl_file_open(param_1,0x601);
    iVar1 = (int)uVar3;
    if (-1 < iVar1) {
      ppbVar4 = (byte **)FUN_00016a10(0x1000);
      if (ppbVar4 != (byte **)0x0) {
        local_c0 = 0;
        pcStack_b8 = FUN_00014e18;
        local_b0 = 0;
        uStack_a8 = 0;
        local_a0 = FUN_00014e4c;
        local_98 = 0;
        local_90 = 0;
        pcStack_88 = FUN_00014ec0;
        local_80 = 0;
        uStack_78 = 0;
        local_70 = FUN_00014f68;
        local_68 = 0;
        FUN_00014384(FUN_000147d8,param_2,param_3,&local_c0);
        FUN_00009928(FUN_00014910,&local_c0);
        FUN_00014994();
        pbVar14 = (byte *)0x0;
        if ((byte *)((long)&segment_command_00000020.cmdsize + 3) < ppbVar4[4]) {
          pbVar14 = ppbVar4[3];
        }
        local_e8 = 0x4d504c504841;
        local_e0 = 0x4110101;
        local_dc = FUN_000169a8();
        local_da = 0x5000c;
        local_d6 = 4;
        local_d4 = 0x28;
        local_cc = FUN_00009430();
        local_c4 = 0;
        FUN_00016ab4(ppbVar4,&local_e8,0x28);
        local_f8 = CONCAT44((int)local_68 * 0x18,0x180001);
        local_f0 = 100;
        FUN_00015254();
        iVar6 = (int)local_68 * 0x18 + 100;
        local_f8 = CONCAT44((int)local_b0 * 0xc,0xc0002);
        local_f0 = iVar6;
        FUN_00015254();
        iVar6 = iVar6 + (int)local_b0 * 0xc;
        local_f8 = CONCAT44((int)local_98 << 3,0x80003);
        local_f0 = iVar6;
        FUN_00015254();
        iVar6 = iVar6 + (int)local_98 * 8;
        local_f8 = CONCAT44((int)local_80 << 4,0x100004);
        local_f0 = iVar6;
        FUN_00015254();
        local_f0 = iVar6 + (int)local_80 * 0x10;
        local_f8 = 0x10005;
        FUN_00015254();
        local_100 = 0;
        local_108 = ppbVar4;
        _ahpl_rb_traverse_rdl(&uStack_78,FUN_00014fbc,&local_108);
        local_fc = 0;
        _ahpl_rb_traverse_ldr(&local_c0,FUN_00015048,&local_108);
        local_fc = 0;
        _ahpl_rb_traverse_ldr(&uStack_a8,FUN_00015098,&local_108);
        FUN_00016b6c(ppbVar4,0x5c,&local_100,4);
        local_fc = 0;
        _ahpl_rb_traverse_rdl(&local_90,FUN_000150e4,&local_108);
        *(undefined4 *)(pbVar14 + 0x20) = local_fc;
        _ahpl_rb_traverse_rdl(&uStack_78,FUN_00015164,ppbVar4);
        _ahpl_rb_traverse_ldr(&local_c0,FUN_00015190,ppbVar4);
        _ahpl_rb_traverse_ldr(&uStack_a8,FUN_000151b8,ppbVar4);
        FUN_00015288(&local_c0,FUN_000151e0);
        FUN_00015288(&uStack_a8,FUN_000151f8);
        FUN_00015288(&local_90,FUN_00015210);
        FUN_00015288(&uStack_78,FUN_00015228);
        uVar2 = FUN_00016d64(ppbVar4);
        iVar6 = 0;
        *(undefined4 *)(pbVar14 + 0x18) = uVar2;
        pbVar12 = pbVar14 + 0x28;
        pbVar5 = *ppbVar4;
        ppbVar8 = ppbVar4;
        pbVar11 = pbVar5;
        while( true ) {
          if (pbVar12 < pbVar11 + *(uint *)(ppbVar8 + 1)) {
            do {
              pbVar9 = pbVar12 + 1;
              iVar6 = iVar6 + (uint)*pbVar12;
              pbVar12 = pbVar9;
            } while (pbVar11 + *(uint *)(ppbVar8 + 1) != pbVar9);
          }
          ppbVar8 = (byte **)ppbVar8[2];
          if (ppbVar8 == (byte **)0x0) break;
          pbVar12 = *ppbVar8;
          pbVar11 = pbVar12;
        }
        lVar10 = 0;
        *(int *)(pbVar14 + 0x24) = iVar6;
        sVar7 = 0;
        do {
          sVar7 = sVar7 + (ushort)pbVar14[lVar10];
          lVar10 = lVar10 + 1;
        } while (lVar10 != 0x28);
        *(short *)(pbVar14 + 6) = sVar7;
        _write(iVar1,pbVar5,(ulong)*(uint *)(ppbVar4 + 1));
        for (ppvVar13 = (void **)ppbVar4[2]; ppvVar13 != (void **)0x0;
            ppvVar13 = (void **)ppvVar13[2]) {
          _write(iVar1,*ppvVar13,(ulong)*(uint *)(ppvVar13 + 1));
        }
        FUN_000170ac(ppbVar4);
      }
      _ahpl_file_close(uVar3);
    }
  }
  return;
}



void FUN_000147d8(undefined8 param_1,long param_2,uint param_3,undefined4 param_4,int param_5,
                 long param_6)

{
  long lVar1;
  long lVar2;
  long lVar3;
  long lVar4;
  int local_68;
  undefined4 uStack_64;
  
  if (param_5 != 0) {
    lVar1 = FUN_000152c8(param_6);
    if (lVar1 == 0) {
      lVar1 = _ahpl_malloc(0x30);
      if (lVar1 == 0) goto LAB_0001490c;
      *(undefined8 *)(lVar1 + 0x18) = param_1;
      *(long *)(lVar1 + 0x20) = param_2;
      *(undefined4 *)(lVar1 + 0x28) = 0;
      _ahpl_rb_insert_node(param_6,lVar1);
    }
    lVar2 = _ahpl_malloc(0x38);
    if (lVar2 == 0) {
LAB_0001490c:
                    // WARNING: Subroutine does not return
      _abort();
    }
    lVar3 = FUN_000169c4(param_2 + (ulong)param_3,&local_68);
    if ((lVar3 == 0) || (CONCAT44(uStack_64,local_68) == 0)) {
      *(undefined8 *)(lVar2 + 0x28) = 0;
    }
    else {
      lVar4 = FUN_000152c8(param_6 + 0x18);
      if (lVar4 == 0) {
        lVar4 = _ahpl_malloc(0x30);
        if (lVar4 == 0) goto LAB_0001490c;
        *(long *)(lVar4 + 0x18) = lVar1;
        *(long *)(lVar4 + 0x20) = lVar3;
        *(int *)(lVar4 + 0x28) = local_68 - (int)param_2;
        *(undefined4 *)(lVar4 + 0x2c) = 0;
        _ahpl_rb_insert_node(param_6 + 0x18,lVar4);
      }
      *(long *)(lVar2 + 0x28) = lVar4;
    }
    *(int *)(lVar2 + 0x18) = param_5;
    *(undefined4 *)(lVar2 + 0x1c) = param_4;
    *(long *)(lVar2 + 0x20) = lVar1;
    *(uint *)(lVar2 + 0x30) = param_3;
    _ahpl_rb_insert_node(param_6 + 0x30,lVar2);
  }
  return;
}



void FUN_00014910(ulong param_1,undefined8 param_2,int param_3,long param_4,long param_5)

{
  long lVar1;
  undefined8 uVar2;
  
  lVar1 = _ahpl_malloc(0x38);
  if (lVar1 != 0) {
    *(ulong *)(lVar1 + 0x18) = param_1 & 0xffffffff;
    uVar2 = _ahpl_strdup(param_2);
    *(undefined8 *)(lVar1 + 0x20) = uVar2;
    *(uint *)(lVar1 + 0x28) = (uint)(param_3 != 0);
    *(ulong *)(lVar1 + 0x2c) =
         CONCAT44((int)*(undefined8 *)(param_4 + 0x10),(int)*(undefined8 *)(param_4 + 8));
    _ahpl_rb_insert_node(param_5 + 0x48,lVar1);
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_00014994(void)

{
  FUN_00004bbc(&DAT_00029fa0);
  FUN_00015304(&DAT_0002a068,FUN_00014c2c);
  FUN_00004c24(&DAT_00029fa0);
  FUN_00009928(FUN_00014fb4,0);
  FUN_000152e4();
  return;
}



void _ahpl_profile_start(undefined8 param_1)

{
  FUN_00014994();
  FUN_00009748(param_1);
  return;
}



void _ahpl_profile_reset(void)

{
  FUN_00004bbc(&DAT_00029fa0);
  FUN_00015304(&DAT_0002a068,FUN_00014c2c);
  FUN_00004c24(&DAT_00029fa0);
  FUN_00009928(FUN_00014fb4,0);
  FUN_000152e4();
  return;
}



void _ahpl_profile_stop(void)

{
  FUN_00004bbc(&DAT_000297e8);
  if (DAT_000298c0 != 0) {
    FUN_0000c49c();
  }
  FUN_00004c24(&DAT_000297e8);
  return;
}



void _ahpl_profile_period(void)

{
  undefined8 uVar1;
  int *piVar2;
  
  uVar1 = FUN_00009430();
  if (0xfffff000 < (uint)uVar1) {
    piVar2 = ___error();
    *piVar2 = -(uint)uVar1;
    uVar1 = 0xffffffff;
  }
  FUN_00015280(uVar1);
  return;
}



void _ahpl_profile_free(void)

{
  FUN_00004bbc(&DAT_00029fa0);
  FUN_00015304(&DAT_0002a068,FUN_00014c2c);
  FUN_00004c24(&DAT_00029fa0);
  FUN_000152e4();
  return;
}



void _ahpl_profile_register_this(undefined8 param_1)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  
  lVar1 = FUN_00005ed4();
  uVar2 = FUN_00009468(lVar1 != 0,param_1);
  if (0xfffff000 < (uint)uVar2) {
    piVar3 = ___error();
    *piVar3 = -(uint)uVar2;
    uVar2 = 0xffffffff;
  }
  FUN_00015280(uVar2);
  return;
}



void _ahpl_profile_clear_registered(void)

{
  ulong uVar1;
  long lVar2;
  
  FUN_00015504(&DAT_000297a0);
  if (DAT_000298b0 != 0) {
    uVar1 = 0;
    lVar2 = 8;
    do {
      _free(*(void **)(DAT_000298b8 + lVar2));
      uVar1 = uVar1 + 1;
      lVar2 = lVar2 + 0x28;
    } while (uVar1 < DAT_000298b0);
  }
  DAT_000298b0 = 0;
  if (DAT_000298dc == 0) {
    FUN_00009688();
  }
  FUN_00015548(&DAT_000297a0);
  return;
}



void FUN_00014af4(void)

{
  FUN_000154dc(&DAT_00029f58);
  DAT_0002a068 = 0;
  DAT_0002a070 = FUN_00014b2c;
  DAT_0002a078 = 0;
  FUN_00014370(0);
  return;
}



void FUN_00014b2c(long param_1,long param_2,ulong *param_3)

{
  int iVar1;
  ulong uVar2;
  
  if (param_2 == 0) {
    uVar2 = *param_3;
  }
  else {
    uVar2 = *(ulong *)(param_2 + 0x20);
  }
  if (uVar2 < *(ulong *)(param_1 + 0x20)) {
    iVar1 = 1;
  }
  else {
    iVar1 = -(uint)(*(ulong *)(param_1 + 0x28) <= uVar2);
  }
  FUN_00015314(iVar1);
  return;
}



undefined8 FUN_00014b74(undefined8 param_1,ulong param_2,ulong param_3,int *param_4)

{
  long lVar1;
  undefined8 uVar2;
  
  if ((param_2 <= param_3 && param_3 - param_2 != 0) && (param_3 - param_2 >> 0x20 == 0)) {
    FUN_00015504(&DAT_00029f58);
    lVar1 = FUN_000152fc();
    if ((lVar1 == 0) && (lVar1 = _ahpl_malloc(0x148), lVar1 != 0)) {
      uVar2 = _ahpl_strdup(param_1);
      *(undefined8 *)(lVar1 + 0x18) = uVar2;
      *(ulong *)(lVar1 + 0x20) = param_2;
      *(ulong *)(lVar1 + 0x28) = param_3;
      FUN_000154dc(lVar1 + 0x30);
      *(undefined8 *)(lVar1 + 0x140) = 0;
      _ahpl_rb_insert_node(&DAT_0002a068,lVar1);
      if (param_4 != (int *)0x0) {
        *param_4 = *param_4 + 1;
      }
    }
    FUN_00015548(&DAT_00029f58);
  }
  return 0;
}



undefined8 FUN_00014c2c(long param_1,long *param_2)

{
  if (*param_2 == 2) {
    FUN_00015504(param_1 + 0x30);
  }
  else {
    FUN_00004bbc(param_1 + 0x78);
  }
  FUN_000152c0(param_1,param_1 + 0x140,0,0);
  if (*param_2 == 2) {
    FUN_00015548(param_1 + 0x30);
  }
  else {
    FUN_00004c24(param_1 + 0x78);
  }
  return 0;
}



void FUN_00014cb0(long param_1,uint **param_2,undefined8 param_3,uint param_4,code **param_5)

{
  uint uVar1;
  uint uVar2;
  uint *puVar3;
  code *UNRECOVERED_JUMPTABLE;
  uint uVar4;
  int iVar5;
  long lVar6;
  
  puVar3 = *param_2;
  if (puVar3 == (uint *)0x0) {
    return;
  }
  if (param_4 < 8) {
    FUN_000152c0(param_1,puVar3,param_3,param_4 + 1);
    iVar5 = 1;
    lVar6 = 8;
    do {
      FUN_000152c0(param_1,(long)*param_2 + lVar6,
                   (iVar5 << (ulong)(param_4 * -4 + 0x1c & 0x1f)) + (int)param_3,param_4 + 1);
      lVar6 = lVar6 + 8;
      iVar5 = iVar5 + 1;
    } while (lVar6 != 0x80);
    if (*param_5 != (code *)((long)&mach_header_00000000.magic + 2)) {
      return;
    }
    puVar3 = *param_2;
  }
  else {
    UNRECOVERED_JUMPTABLE = *param_5;
    if (UNRECOVERED_JUMPTABLE == (code *)0x0) {
      return;
    }
    if (UNRECOVERED_JUMPTABLE != (code *)((long)&mach_header_00000000.magic + 2)) {
      if (UNRECOVERED_JUMPTABLE == (code *)((long)&mach_header_00000000.magic + 1)) {
        *puVar3 = 0;
        puVar3[1] = 0;
        return;
      }
      uVar4 = *(uint *)(param_5 + 1);
      uVar1 = *(uint *)((long)param_5 + 0xc);
      if (((uVar4 & 1) != 0) && (uVar2 = *puVar3, uVar2 != 0 && uVar1 <= uVar2)) {
        (*UNRECOVERED_JUMPTABLE)
                  (*(undefined8 *)(param_1 + 0x18),*(undefined8 *)(param_1 + 0x20),param_3,1,uVar2,
                   param_5[2]);
        uVar4 = *(uint *)(param_5 + 1);
      }
      if ((uVar4 >> 1 & 1) == 0) {
        return;
      }
      uVar4 = (*param_2)[1];
      if (uVar4 == 0) {
        return;
      }
      if (uVar4 < uVar1) {
        return;
      }
                    // WARNING: Could not recover jumptable at 0x00014e14. Too many branches
                    // WARNING: Treating indirect jump as call
      (*UNRECOVERED_JUMPTABLE)
                (*(undefined8 *)(param_1 + 0x18),*(undefined8 *)(param_1 + 0x20),param_3,0,uVar4,
                 param_5[2]);
      return;
    }
  }
  _free(puVar3);
  *param_2 = (uint *)0x0;
  return;
}



int FUN_00014e18(long param_1,long param_2)

{
  int iVar1;
  char *pcVar2;
  undefined auVar3 [16];
  
  if (param_2 == 0) {
    auVar3 = FUN_000152d0();
    pcVar2 = auVar3._8_8_;
    param_1 = auVar3._0_8_;
  }
  else {
    pcVar2 = *(char **)(param_2 + 0x18);
  }
  iVar1 = _strcmp(*(char **)(param_1 + 0x18),pcVar2);
  return iVar1;
}



void FUN_00014e4c(long param_1,long param_2,ulong *param_3)

{
  int iVar1;
  char *pcVar2;
  char *extraout_x1;
  ulong uVar3;
  ulong uVar4;
  
  if (param_2 == 0) {
    FUN_000152d0();
    pcVar2 = extraout_x1;
  }
  else {
    pcVar2 = *(char **)(param_2 + 0x20);
  }
  iVar1 = _strcmp(*(char **)(param_1 + 0x20),pcVar2);
  if (iVar1 == 0) {
    if (param_2 == 0) {
      uVar3 = *param_3;
    }
    else {
      uVar3 = *(ulong *)(*(long *)(param_2 + 0x18) + 0x20);
    }
    uVar4 = *(ulong *)(*(long *)(param_1 + 0x18) + 0x20);
    iVar1 = -(uint)(uVar4 < uVar3);
    if (uVar3 < uVar4) {
      iVar1 = 1;
    }
  }
  FUN_00015274(iVar1);
  return;
}



void FUN_00014ec0(long param_1,long param_2,ulong *param_3)

{
  uint uVar1;
  int iVar2;
  ulong uVar3;
  ulong uVar4;
  ulong *local_8;
  
  if (param_2 == 0) {
    local_8 = param_3 + 1;
    uVar1 = *(uint *)param_3;
  }
  else {
    uVar1 = *(uint *)(param_2 + 0x18);
    local_8 = param_3;
  }
  if (*(uint *)(param_1 + 0x18) <= uVar1) {
    if (*(uint *)(param_1 + 0x18) < uVar1) {
LAB_00014efc:
      iVar2 = -1;
      goto LAB_00014f00;
    }
    if (param_2 == 0) {
      uVar3 = *local_8;
      local_8 = local_8 + 1;
    }
    else {
      uVar3 = *(ulong *)(*(long *)(param_2 + 0x20) + 0x20);
    }
    uVar4 = *(ulong *)(*(long *)(param_1 + 0x20) + 0x20);
    if (uVar4 <= uVar3) {
      if (uVar4 < uVar3) goto LAB_00014efc;
      if (param_2 == 0) {
        uVar1 = *(uint *)local_8;
      }
      else {
        uVar1 = *(uint *)(param_2 + 0x30);
      }
      if (*(uint *)(param_1 + 0x30) <= uVar1) {
        iVar2 = -(uint)(*(uint *)(param_1 + 0x30) < uVar1);
        goto LAB_00014f00;
      }
    }
  }
  iVar2 = 1;
LAB_00014f00:
  FUN_00015314(iVar2);
  return;
}



void FUN_00014f68(long param_1,long param_2,int *param_3)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  
  if (param_2 == 0) {
    iVar3 = *param_3;
    iVar4 = param_3[2];
  }
  else {
    iVar3 = *(int *)(param_2 + 0x2c);
    iVar4 = *(int *)(param_2 + 0x30);
  }
  uVar1 = *(int *)(param_1 + 0x30) + *(int *)(param_1 + 0x2c);
  iVar2 = -(uint)(uVar1 < (uint)(iVar3 + iVar4));
  if ((uint)(iVar3 + iVar4) < uVar1) {
    iVar2 = 1;
  }
  FUN_00015314(iVar2);
  return;
}



void FUN_00014fb4(void)

{
  undefined4 *in_x3;
  
  *in_x3 = 0;
  return;
}



undefined8 FUN_00014fbc(long param_1,undefined8 *param_2)

{
  size_t sVar1;
  int iVar2;
  undefined4 local_48;
  undefined4 uStack_44;
  int local_40;
  undefined2 local_3c;
  undefined2 local_3a;
  undefined8 local_38;
  
  local_48 = (undefined4)*(undefined8 *)(param_1 + 0x18);
  uStack_44 = (undefined4)((ulong)*(undefined8 *)(param_1 + 0x18) >> 0x20);
  local_3c = (undefined2)*(undefined4 *)(param_1 + 0x28);
  if (*(char **)(param_1 + 0x20) == (char *)0x0) {
    iVar2 = -1;
  }
  else {
    iVar2 = *(int *)(param_2 + 1);
    sVar1 = _strlen(*(char **)(param_1 + 0x20));
    *(int *)(param_2 + 1) = iVar2 + (int)sVar1 + 1;
  }
  local_3a = 0;
  local_38 = *(undefined8 *)(param_1 + 0x2c);
  local_40 = iVar2;
  FUN_00016ab4(*param_2,&local_48,0x18);
  return 0;
}



void FUN_00015048(void)

{
  undefined4 extraout_w8;
  undefined8 uVar1;
  long unaff_x20;
  undefined auVar2 [16];
  undefined4 local_30;
  undefined4 uStack_2c;
  undefined4 local_28;
  
  auVar2 = FUN_00015290();
  *(undefined4 *)(auVar2._0_8_ + 0x28) = extraout_w8;
  uVar1 = *(undefined8 *)(auVar2._0_8_ + 0x20);
  local_30 = (undefined4)uVar1;
  uStack_2c = (undefined4)((ulong)uVar1 >> 0x20);
  local_28 = *(undefined4 *)(auVar2._8_8_ + 1);
  FUN_00016ab4(*auVar2._8_8_,&local_30,0xc);
  _strlen(*(char **)(unaff_x20 + 0x18));
  FUN_000152a8();
  FUN_00015274();
  return;
}



void FUN_00015098(void)

{
  undefined4 extraout_w8;
  long unaff_x20;
  undefined auVar1 [16];
  undefined4 local_28;
  undefined4 local_24;
  
  auVar1 = FUN_00015290();
  *(undefined4 *)(auVar1._0_8_ + 0x2c) = extraout_w8;
  local_28 = *(undefined4 *)(auVar1._0_8_ + 0x28);
  local_24 = *(undefined4 *)(auVar1._8_8_ + 1);
  FUN_00016ab4(*auVar1._8_8_,&local_28,8);
  _strlen(*(char **)(unaff_x20 + 0x20));
  FUN_000152a8();
  FUN_00015274();
  return;
}



void FUN_000150e4(long param_1,undefined8 *param_2)

{
  undefined2 local_30;
  undefined2 local_2e;
  undefined4 local_2c;
  undefined4 local_28;
  undefined4 local_24;
  
  local_30 = (undefined2)*(undefined4 *)(param_1 + 0x1c);
  local_2e = (undefined2)*(undefined4 *)(*(long *)(param_1 + 0x20) + 0x28);
  local_2c = *(undefined4 *)(param_1 + 0x30);
  if (*(long *)(param_1 + 0x28) == 0) {
    local_28 = 0xffffffff;
  }
  else {
    local_28 = *(undefined4 *)(*(long *)(param_1 + 0x28) + 0x2c);
  }
  local_24 = *(undefined4 *)(param_1 + 0x18);
  FUN_00016ab4(*param_2,&local_30,0x10);
  *(int *)((long)param_2 + 0xc) = *(int *)((long)param_2 + 0xc) + *(int *)(param_1 + 0x18);
  FUN_00015274(0);
  return;
}



void FUN_00015164(long param_1)

{
  if (*(long *)(param_1 + 0x20) != 0) {
    FUN_0001530c();
    FUN_00015264();
  }
  FUN_00015280(0);
  return;
}



void FUN_00015190(void)

{
  FUN_0001530c();
  FUN_00015264();
  FUN_00015280(0);
  return;
}



void FUN_000151b8(void)

{
  FUN_0001530c();
  FUN_00015264();
  FUN_00015280(0);
  return;
}



undefined8 FUN_000151e0(void *param_1)

{
  _free(param_1);
  return 0;
}



undefined8 FUN_000151f8(void *param_1)

{
  _free(param_1);
  return 0;
}



undefined8 FUN_00015210(void *param_1)

{
  _free(param_1);
  return 0;
}



void FUN_00015228(void *param_1)

{
  _free(*(void **)((long)param_1 + 0x20));
  _free(param_1);
  FUN_00015280(0);
  return;
}



void FUN_00015254(void)

{
  FUN_00016ab4();
  return;
}



void FUN_00015264(void)

{
  FUN_00016ab4();
  return;
}



void FUN_00015274(void)

{
  return;
}



void FUN_00015280(void)

{
  return;
}



void FUN_00015288(undefined8 param_1,undefined8 param_2)

{
  _ahpl_rb_traverse_lrd(param_1,param_2,0);
  return;
}



void FUN_00015290(undefined8 param_1,long param_2)

{
  *(int *)(param_2 + 0xc) = *(int *)(param_2 + 0xc) + 1;
  return;
}



undefined8 FUN_000152a8(int param_1)

{
  long unaff_x19;
  
  *(int *)(unaff_x19 + 8) = param_1 + *(int *)(unaff_x19 + 8) + 1;
  return 0;
}



void FUN_000152c0(void)

{
  FUN_00014cb0();
  return;
}



void FUN_000152c8(undefined8 param_1)

{
  _ahpl_find_rb_node(param_1,0);
  return;
}



void FUN_000152d0(void)

{
  return;
}



void FUN_000152e4(void)

{
  return;
}



void FUN_000152f0(void)

{
  FUN_00004c24();
  return;
}



void FUN_000152fc(void)

{
  FUN_00014348();
  return;
}



void FUN_00015304(undefined8 param_1,undefined8 param_2)

{
  _ahpl_rb_traverse_dlr(param_1,param_2,&stack0x00000008);
  return;
}



void FUN_0001530c(void)

{
  char *unaff_x20;
  
  _strlen(unaff_x20);
  return;
}



void FUN_00015314(void)

{
  return;
}



undefined8
FUN_0001531c(ulong param_1,undefined8 param_2,uint param_3,undefined8 param_4,undefined8 param_5)

{
  uint uVar1;
  undefined8 uVar2;
  undefined8 local_d8;
  undefined8 uStack_d0;
  undefined8 local_c8;
  uint local_c0;
  int local_bc;
  pthread_mutex_t *local_b8;
  pthread_cond_t *ppStack_b0;
  pthread_cond_t pStack_a8;
  pthread_mutex_t pStack_78;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 < 6) {
    local_bc = 0;
    local_d8 = param_2;
    uStack_d0 = param_4;
    local_c8 = param_5;
    local_c0 = param_3;
    FUN_00004a38(&pStack_78);
    FUN_00004c78(&pStack_a8);
    local_b8 = &pStack_78;
    ppStack_b0 = &pStack_a8;
    uVar2 = FUN_00004948(param_1,FUN_00015404,&local_d8);
    if ((int)uVar2 == 0) {
      FUN_00004aec(&pStack_78);
      while (local_bc == 0) {
        _pthread_cond_wait(&pStack_a8,&pStack_78);
      }
      FUN_00004b20(&pStack_78);
    }
    FUN_00004b3c(&pStack_78);
    uVar1 = _pthread_cond_destroy(&pStack_a8);
    param_1 = (ulong)uVar1;
  }
  else {
    uVar2 = 0xffffffea;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return uVar2;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(param_1);
}



undefined8 FUN_00015404(char **param_1)

{
  size_t sVar1;
  char *pcVar2;
  code *pcVar3;
  char acStack_78 [64];
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  pcVar2 = *param_1;
  if (pcVar2 != (char *)0x0) {
    sVar1 = _strlen(pcVar2);
    if (0x3f < sVar1) {
      _snprintf(acStack_78,0x40,"%s");
      pcVar2 = acStack_78;
    }
    _pthread_setname_np(pcVar2);
  }
  if (*(int *)(param_1 + 3) - 1U < 5) {
    FUN_00004890();
  }
  pcVar3 = (code *)param_1[1];
  pcVar2 = param_1[2];
  FUN_00004aec(param_1[4]);
  *(undefined4 *)((long)param_1 + 0x1c) = 1;
  _pthread_cond_signal((pthread_cond_t *)param_1[5]);
  FUN_00004b20(param_1[4]);
  (*pcVar3)(pcVar2);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return 0;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_000154dc(long param_1)

{
  FUN_00004a38();
  *(undefined4 *)(param_1 + 0x40) = 0;
  FUN_00004b58(param_1 + 0x48);
  return;
}



void FUN_00015504(long param_1)

{
  int iVar1;
  
  while( true ) {
    FUN_00004aec(param_1);
    iVar1 = FUN_00004c0c(param_1 + 0x48);
    if (iVar1 != 0) break;
    FUN_00015ac4();
    _usleep(10);
  }
  return;
}



void FUN_00015548(long param_1)

{
  FUN_00004c40(param_1 + 0x48);
  FUN_00015a54(param_1);
  return;
}



void FUN_0001556c(long param_1)

{
  int iVar1;
  
  while( true ) {
    iVar1 = FUN_00004b08(param_1);
    if (iVar1 != 0) {
      *(undefined4 *)(param_1 + 0x40) = 1;
      FUN_00004c24(param_1 + 0x48);
      FUN_00004bf0(param_1 + 0x48);
      return;
    }
    if (*(int *)(param_1 + 0x40) != 0) break;
    _usleep(10);
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void FUN_000155c4(long param_1)

{
  FUN_00004c40(param_1 + 0x48);
  FUN_00004bbc(param_1 + 0x48);
  *(undefined4 *)(param_1 + 0x40) = 0;
  FUN_00015a54(param_1);
  return;
}



void FUN_000155f8(void)

{
  long unaff_x19;
  
  FUN_00015ab4();
  FUN_00004c5c(unaff_x19 + 0x48);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

pthread_t _ahpl_thread_self(void)

{
  pthread_t p_Var1;
  
                    // WARNING: Could not recover jumptable at 0x00024880. Too many branches
                    // WARNING: Treating indirect jump as call
  p_Var1 = (pthread_t)(*(code *)PTR__pthread_self_000284c8)();
  return p_Var1;
}



undefined4 _ahpl_thread_self_id(void)

{
  undefined4 uVar1;
  
  uVar1 = FUN_000049d8();
  return uVar1;
}



undefined8 _ahpl_tls_key_create(undefined8 *param_1)

{
  undefined8 uVar1;
  undefined4 *puVar2;
  undefined8 local_28;
  
  uVar1 = FUN_000049ec(&local_28);
  if ((int)(uint)uVar1 < 0) {
    if (0xfffff000 < (uint)uVar1) {
      puVar2 = (undefined4 *)FUN_00015abc();
      *puVar2 = (int)param_1;
      uVar1 = 0xffffffff;
    }
  }
  else {
    uVar1 = 0;
    *param_1 = local_28;
  }
  return uVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _ahpl_tls_key_get(pthread_key_t param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002479c. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__pthread_getspecific_00028430)();
  return pvVar1;
}



void _ahpl_tls_key_set(void)

{
  undefined8 uVar1;
  undefined4 *puVar2;
  undefined4 unaff_w19;
  
  uVar1 = FUN_00004a08();
  if (0xfffff000 < (uint)uVar1) {
    puVar2 = (undefined4 *)FUN_00015abc();
    *puVar2 = unaff_w19;
    uVar1 = 0xffffffff;
  }
  FUN_00015a9c(uVar1);
  return;
}



void _ahpl_tls_key_delete(void)

{
  undefined8 uVar1;
  undefined4 *puVar2;
  undefined4 unaff_w19;
  
  uVar1 = FUN_00004a20();
  if (0xfffff000 < (uint)uVar1) {
    puVar2 = (undefined4 *)FUN_00015abc();
    *puVar2 = unaff_w19;
    uVar1 = 0xffffffff;
  }
  FUN_00015a9c(uVar1);
  return;
}



void _ahpl_lock_create(int param_1)

{
  long lVar1;
  
  lVar1 = _ahpl_malloc(0x40);
  if (lVar1 != 0) {
    if (param_1 == 0) {
      FUN_00004a38();
    }
    else {
      FUN_00004a8c(lVar1);
    }
  }
  FUN_00015aa4(lVar1);
  return;
}



void _ahpl_lock_lock(pthread_mutex_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_mutex_lock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void _ahpl_lock_trylock(pthread_mutex_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_mutex_trylock(param_1);
  FUN_00004d34(iVar1);
  return;
}



void _ahpl_lock_unlock(pthread_mutex_t *param_1)

{
  int iVar1;
  
  iVar1 = _pthread_mutex_unlock(param_1);
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void _ahpl_lock_destroy(void)

{
  FUN_00015ab4();
  FUN_00015a5c();
  return;
}



void _ahpl_rwlock_create(void)

{
  long lVar1;
  
  lVar1 = _ahpl_malloc(0x110);
  if (lVar1 != 0) {
    FUN_000154dc(lVar1);
  }
  FUN_00015aa4(lVar1);
  return;
}



void _ahpl_rwlock_rdlock(long param_1)

{
  FUN_00004bbc(param_1 + 0x48);
  return;
}



void _ahpl_rwlock_tryrdlock(long param_1)

{
  FUN_00004bd8(param_1 + 0x48);
  return;
}



void _ahpl_rwlock_wrlock(long param_1)

{
  int iVar1;
  
  while( true ) {
    FUN_00004aec(param_1);
    iVar1 = FUN_00004c0c(param_1 + 0x48);
    if (iVar1 != 0) break;
    FUN_00015ac4();
    _usleep(10);
  }
  return;
}



void _ahpl_rwlock_trywrlock(void)

{
  undefined8 uVar1;
  long unaff_x19;
  
  FUN_00015aac();
  uVar1 = FUN_00004c0c(unaff_x19 + 0x48);
  if ((int)uVar1 == 0) {
    FUN_00015ac4();
  }
  FUN_00015a9c(uVar1);
  return;
}



void _ahpl_rwlock_rdunlock(long param_1)

{
  FUN_00004c24(param_1 + 0x48);
  return;
}



void _ahpl_rwlock_wrunlock(long param_1)

{
  FUN_00004c40(param_1 + 0x48);
  FUN_00015a54(param_1);
  return;
}



void _ahpl_rwlock_rd2wrlock(long param_1)

{
  int iVar1;
  
  while( true ) {
    iVar1 = FUN_00004b08(param_1);
    if (iVar1 != 0) {
      *(undefined4 *)(param_1 + 0x40) = 1;
      FUN_00004c24(param_1 + 0x48);
      FUN_00004bf0(param_1 + 0x48);
      return;
    }
    if (*(int *)(param_1 + 0x40) != 0) break;
    _usleep(10);
  }
                    // WARNING: Subroutine does not return
  _abort();
}



void _ahpl_rwlock_wr2rdlock(long param_1)

{
  FUN_00004c40(param_1 + 0x48);
  FUN_00004bbc(param_1 + 0x48);
  *(undefined4 *)(param_1 + 0x40) = 0;
  FUN_00015a54(param_1);
  return;
}



void _ahpl_rwlock_destroy(undefined8 param_1)

{
  FUN_000155f8();
  FUN_00015a5c(param_1);
  return;
}



void _ahpl_cond_create(void)

{
  long lVar1;
  
  lVar1 = _ahpl_malloc(0x30);
  if (lVar1 != 0) {
    FUN_00004c78(lVar1);
  }
  FUN_00015aa4(lVar1);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_cond_signal(pthread_cond_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024730. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_signal_000283e8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_cond_broadcast(pthread_cond_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002470c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_broadcast_000283d0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_cond_wait(pthread_cond_t *param_1,pthread_mutex_t *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024748. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_wait_000283f8)((int)param_1);
  return iVar1;
}



void _ahpl_cond_timedwait(pthread_cond_t *param_1,pthread_mutex_t *param_2,long param_3)

{
  int iVar1;
  timespec tStack_20;
  
  tStack_20.tv_sec = param_3 / 1000;
  tStack_20.tv_nsec = (param_3 % 1000) * 1000000;
  iVar1 = _pthread_cond_timedwait_relative_np(param_1,param_2,&tStack_20);
  FUN_00004d34(iVar1);
  return;
}



void _ahpl_cond_destroy(pthread_cond_t *param_1)

{
  _pthread_cond_destroy(param_1);
  FUN_00015a5c(param_1);
  return;
}



void FUN_00015854(long param_1)

{
  FUN_00004a38();
  FUN_00004c78(param_1 + 0x40);
  *(undefined8 *)(param_1 + 0x70) = 0;
  return;
}



void FUN_00015880(long param_1)

{
  FUN_00004aec();
  if (*(long *)(param_1 + 0x70) != 0x50554c53) {
    *(undefined8 *)(param_1 + 0x70) = 0x50554c53;
    _pthread_cond_signal((pthread_cond_t *)(param_1 + 0x40));
  }
  FUN_00015a54(param_1);
  return;
}



void FUN_000158c0(undefined8 param_1,long param_2)

{
  undefined in_ZR;
  uint uVar1;
  ulong uVar2;
  long extraout_x8;
  long lVar3;
  pthread_mutex_t *unaff_x19;
  ulong uVar4;
  
  FUN_00015aac();
  uVar2 = FUN_00015a64();
  if ((bool)in_ZR) {
    uVar4 = 1;
    lVar3 = extraout_x8;
  }
  else {
    if (param_2 < 0) {
      uVar1 = _pthread_cond_wait((pthread_cond_t *)(unaff_x19 + 1),unaff_x19);
      uVar2 = (ulong)uVar1;
      uVar4 = 1;
    }
    else {
      uVar2 = FUN_00004cdc();
      uVar4 = uVar2;
    }
    lVar3 = *(long *)(unaff_x19[1].__opaque + 0x28);
  }
  if (lVar3 == 0x50554c53) {
    *(undefined8 *)(unaff_x19[1].__opaque + 0x28) = 0;
  }
  FUN_00015ac4(uVar2);
  FUN_00015a9c(uVar4);
  return;
}



int FUN_00015930(void)

{
  int iVar1;
  long unaff_x19;
  
  FUN_00015ab4();
  iVar1 = _pthread_cond_destroy((pthread_cond_t *)(unaff_x19 + 0x40));
  return iVar1;
}



void _ahpl_event_create(void)

{
  long lVar1;
  
  lVar1 = _ahpl_malloc(0x78);
  if (lVar1 != 0) {
    FUN_00015854(lVar1);
  }
  FUN_00015aa4(lVar1);
  return;
}



void _ahpl_event_set(long param_1)

{
  FUN_00004aec();
  if (*(long *)(param_1 + 0x70) != 0x5f534554) {
    *(undefined8 *)(param_1 + 0x70) = 0x5f534554;
    _pthread_cond_broadcast((pthread_cond_t *)(param_1 + 0x40));
  }
  FUN_00015a54(param_1);
  return;
}



void _ahpl_event_pulse(long param_1)

{
  FUN_00004aec();
  if (*(long *)(param_1 + 0x70) != 0x50554c53) {
    *(undefined8 *)(param_1 + 0x70) = 0x50554c53;
    _pthread_cond_signal((pthread_cond_t *)(param_1 + 0x40));
  }
  FUN_00015a54(param_1);
  return;
}



void _ahpl_event_wait(void)

{
  undefined in_ZR;
  long extraout_x8;
  long lVar1;
  pthread_mutex_t *unaff_x19;
  
  FUN_00015aac();
  FUN_00015a64();
  lVar1 = extraout_x8;
  if (!(bool)in_ZR) {
    _pthread_cond_wait((pthread_cond_t *)(unaff_x19 + 1),unaff_x19);
    lVar1 = *(long *)(unaff_x19[1].__opaque + 0x28);
  }
  if (lVar1 == 0x50554c53) {
    *(undefined8 *)(unaff_x19[1].__opaque + 0x28) = 0;
  }
  FUN_00015a54();
  return;
}



void _ahpl_event_timedwait(undefined8 param_1,long param_2)

{
  undefined in_ZR;
  uint uVar1;
  ulong uVar2;
  long extraout_x8;
  long lVar3;
  pthread_mutex_t *unaff_x19;
  ulong uVar4;
  
  FUN_00015aac();
  uVar2 = FUN_00015a64();
  if ((bool)in_ZR) {
    uVar4 = 1;
    lVar3 = extraout_x8;
  }
  else {
    if (param_2 < 0) {
      uVar1 = _pthread_cond_wait((pthread_cond_t *)(unaff_x19 + 1),unaff_x19);
      uVar2 = (ulong)uVar1;
      uVar4 = 1;
    }
    else {
      uVar2 = FUN_00004cdc();
      uVar4 = uVar2;
    }
    lVar3 = *(long *)(unaff_x19[1].__opaque + 0x28);
  }
  if (lVar3 == 0x50554c53) {
    *(undefined8 *)(unaff_x19[1].__opaque + 0x28) = 0;
  }
  FUN_00015ac4(uVar2);
  FUN_00015a9c(uVar4);
  return;
}



void _ahpl_event_reset(void)

{
  long unaff_x19;
  
  FUN_00015aac();
  *(undefined8 *)(unaff_x19 + 0x70) = 0;
  FUN_00015a54();
  return;
}



void _ahpl_event_destroy(undefined8 param_1)

{
  FUN_00015930();
  FUN_00015a5c(param_1);
  return;
}



void _ahpl_get_thread_times(thread_act_t param_1,uint *param_2,long *param_3,long *param_4)

{
  kern_return_t kVar1;
  undefined8 uVar2;
  mach_msg_type_number_t mStack_bc;
  long lStack_b8;
  long lStack_b0;
  long lStack_a8;
  int iStack_a0;
  long lStack_38;
  
  lStack_38 = *(long *)PTR____stack_chk_guard_00028030;
  mStack_bc = 0x20;
  kVar1 = _thread_info(param_1,3,(thread_info_t)&lStack_b8,&mStack_bc);
  if (kVar1 == 0) {
    if (param_2 != (uint *)0x0) {
      *param_2 = (uint)(iStack_a0 == 1);
    }
    if (param_3 != (long *)0x0) {
      *param_3 = lStack_a8 + lStack_b0 * 1000000;
    }
    uVar2 = 0;
    if (param_4 != (long *)0x0) {
      *param_4 = lStack_b0 + lStack_b8 * 1000000;
    }
  }
  else {
    uVar2 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lStack_38) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



void FUN_00015a54(void)

{
  FUN_00004b20();
  return;
}



void FUN_00015a5c(void *param_1)

{
  _free(param_1);
  return;
}



void FUN_00015a64(void)

{
  return;
}



void FUN_00015a84(long param_1)

{
  FUN_00004c24(param_1 + 0x48);
  return;
}



void FUN_00015a8c(long param_1)

{
  FUN_00004bbc(param_1 + 0x48);
  return;
}



void FUN_00015a94(long param_1)

{
  FUN_00004bd8(param_1 + 0x48);
  return;
}



void FUN_00015a9c(void)

{
  return;
}



void FUN_00015aa4(void)

{
  return;
}



void FUN_00015aac(void)

{
  FUN_00004aec();
  return;
}



void FUN_00015ab4(void)

{
  FUN_00004b3c();
  return;
}



void FUN_00015abc(void)

{
  ___error();
  return;
}



void FUN_00015ac4(void)

{
  FUN_00004b20();
  return;
}



undefined4 _ahpl_atomic_read(undefined4 *param_1)

{
  return *param_1;
}



void _ahpl_atomic_set(undefined4 *param_1,undefined4 param_2)

{
  *param_1 = param_2;
  return;
}



void _ahpl_atomic_inc(int *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + 1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return;
}



void _ahpl_atomic_dec(int *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + -1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return;
}



void _ahpl_atomic_add_return(int param_1,int *param_2)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
    if (bVar2) {
      *param_2 = *param_2 + param_1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  FUN_00015c64();
  return;
}



void _ahpl_atomic_sub_return(int param_1,int *param_2)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
    if (bVar2) {
      *param_2 = *param_2 - param_1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  FUN_00015c64();
  return;
}



void _ahpl_atomic_inc_and_test(int *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + 1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  FUN_00015c58();
  return;
}



void _ahpl_atomic_dec_and_test(int *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + -1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  FUN_00015c58();
  return;
}



void _ahpl_atomic_cmpxchg(int *param_1,int param_2,int param_3)

{
  char cVar1;
  bool bVar2;
  
  do {
    if (*param_1 != param_2) break;
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = param_3;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  FUN_00015c64();
  return;
}



undefined4 _ahpl_atomic_xchg(undefined4 *param_1,undefined4 param_2)

{
  undefined4 uVar1;
  char cVar2;
  bool bVar3;
  
  do {
    uVar1 = *param_1;
    cVar2 = '\x01';
    bVar3 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar3) {
      *param_1 = param_2;
      cVar2 = ExclusiveMonitorsStatus();
    }
  } while (cVar2 != '\0');
  return uVar1;
}



undefined8 _ahpl_atomic_intptr_read(undefined8 *param_1)

{
  return *param_1;
}



void _ahpl_atomic_intptr_set(undefined8 *param_1,undefined8 param_2)

{
  *param_1 = param_2;
  return;
}



void _ahpl_atomic_intptr_inc(long *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + 1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return;
}



void _ahpl_atomic_intptr_dec(long *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + -1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return;
}



long _ahpl_atomic_intptr_add_return(long param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  do {
    lVar3 = *param_2;
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
    if (bVar2) {
      *param_2 = lVar3 + param_1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3 + param_1;
}



long _ahpl_atomic_intptr_sub_return(long param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  do {
    lVar3 = *param_2;
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
    if (bVar2) {
      *param_2 = lVar3 + param_1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3 + param_1;
}



void _ahpl_atomic_intptr_inc_and_test(long *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + 1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  FUN_00015c4c();
  return;
}



void _ahpl_atomic_intptr_dec_and_test(long *param_1)

{
  char cVar1;
  bool bVar2;
  
  do {
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = *param_1 + -1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  FUN_00015c4c();
  return;
}



long _ahpl_atomic_intptr_cmpxchg(long *param_1,long param_2,long param_3)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  do {
    lVar3 = *param_1;
    if (lVar3 != param_2) {
      return lVar3;
    }
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = param_3;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3;
}



undefined8 _ahpl_atomic_intptr_xchg(undefined8 *param_1,undefined8 param_2)

{
  char cVar1;
  bool bVar2;
  undefined8 uVar3;
  
  do {
    uVar3 = *param_1;
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_1,0x10);
    if (bVar2) {
      *param_1 = param_2;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return uVar3;
}



void _ahpl_mb(void)

{
  DataMemoryBarrier(2,3);
  return;
}



void _ahpl_rmb(void)

{
  DataMemoryBarrier(2,1);
  return;
}



void _ahpl_wmb(void)

{
  DataMemoryBarrier(2,2);
  return;
}



long FUN_00015c34(long param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  long lVar3;
  
  do {
    lVar3 = *param_2;
    cVar1 = '\x01';
    bVar2 = (bool)ExclusiveMonitorPass(param_2,0x10);
    if (bVar2) {
      *param_2 = lVar3 + param_1;
      cVar1 = ExclusiveMonitorsStatus();
    }
  } while (cVar1 != '\0');
  return lVar3 + param_1;
}



bool FUN_00015c4c(long param_1)

{
  return param_1 == 0;
}



bool FUN_00015c58(void)

{
  int in_w8;
  
  return in_w8 == 0;
}



undefined8 FUN_00015c64(undefined8 param_1)

{
  return param_1;
}



void * FUN_00015c6c(long param_1)

{
  void *pvVar1;
  
  pvVar1 = (void *)_ahpl_malloc(param_1 + 0x3fU >> 3 & 0x1ffffffffffffff8);
  if (pvVar1 != (void *)0x0) {
    _bzero(pvVar1,((param_1 << 0x20) >> 3) + 0x7e0000000 >> 0x20 & 0xfffffffffffffff8);
  }
  return pvVar1;
}



void _ahpl_rb_root_init(undefined8 *param_1,undefined8 param_2)

{
  *param_1 = 0;
  param_1[1] = param_2;
  param_1[2] = 0;
  return;
}



void FUN_00015ccc(ulong *param_1,undefined8 *param_2)

{
  ulong *puVar1;
  ulong uVar2;
  ulong *puVar3;
  ulong uVar4;
  ulong *puVar5;
  
  uVar2 = *param_1;
  do {
    puVar1 = (ulong *)(uVar2 & 0xfffffffffffffffc);
    if ((puVar1 == (ulong *)0x0) || (uVar2 = *puVar1, (uVar2 & 1) != 0)) {
      FUN_000167c4(*param_2);
      param_2[2] = param_2[2] + 1;
      FUN_000166a4();
      return;
    }
    puVar5 = (ulong *)(uVar2 & 0xfffffffffffffffc);
    puVar3 = (ulong *)puVar5[2];
    if (puVar3 == puVar1) {
      puVar3 = (ulong *)puVar5[1];
      if ((puVar3 != (ulong *)0x0) && (uVar4 = *puVar3, (uVar4 & 1) == 0)) goto LAB_00015d50;
      puVar3 = puVar1;
      puVar5 = param_1;
      if ((ulong *)puVar1[1] == param_1) {
        FUN_00016760();
        uVar2 = *param_1;
        puVar3 = param_1;
        puVar5 = puVar1;
      }
      FUN_000166ec(uVar2,puVar3);
      FUN_00015e14();
    }
    else if ((puVar3 == (ulong *)0x0) || (uVar4 = *puVar3, (uVar4 & 1) != 0)) {
      puVar3 = puVar1;
      puVar5 = param_1;
      if ((ulong *)puVar1[2] == param_1) {
        FUN_00016758();
        uVar2 = *param_1;
        puVar3 = param_1;
        puVar5 = puVar1;
      }
      FUN_000166ec(uVar2,puVar3);
      FUN_00015dc4();
    }
    else {
LAB_00015d50:
      *puVar3 = uVar4 | 1;
      *puVar1 = *puVar1 | 1;
      *puVar5 = *puVar5 & 0xfffffffffffffffe;
    }
    uVar2 = *puVar5;
    param_1 = puVar5;
  } while( true );
}



void FUN_00015dc4(ulong *param_1,ulong **param_2)

{
  ulong *puVar1;
  ulong uVar2;
  ulong *puVar3;
  
  puVar1 = (ulong *)param_1[1];
  uVar2 = *param_1 & 0xfffffffffffffffc;
  puVar3 = (ulong *)puVar1[2];
  param_1[1] = (ulong)puVar3;
  if (puVar3 != (ulong *)0x0) {
    *puVar3 = *puVar3 & 3 | (ulong)param_1;
  }
  puVar1[2] = (ulong)param_1;
  *puVar1 = *puVar1 & 3 | uVar2;
  if (uVar2 != 0) {
    param_2 = (ulong **)(uVar2 + 0x10);
    if (*(ulong **)(uVar2 + 0x10) != param_1) {
      param_2 = (ulong **)(uVar2 + 8);
    }
  }
  FUN_0001672c(param_1,param_2);
  return;
}



void FUN_00015e14(ulong *param_1,ulong **param_2)

{
  ulong *puVar1;
  ulong uVar2;
  ulong *puVar3;
  
  puVar1 = (ulong *)param_1[2];
  uVar2 = *param_1 & 0xfffffffffffffffc;
  puVar3 = (ulong *)puVar1[1];
  param_1[2] = (ulong)puVar3;
  if (puVar3 != (ulong *)0x0) {
    *puVar3 = *puVar3 & 3 | (ulong)param_1;
  }
  *puVar1 = *puVar1 & 3 | uVar2;
  puVar1[1] = (ulong)param_1;
  if (uVar2 != 0) {
    param_2 = (ulong **)(uVar2 + 8);
    if (*(ulong **)(uVar2 + 8) != param_1) {
      param_2 = (ulong **)(uVar2 + 0x10);
    }
  }
  FUN_0001672c(param_1,param_2);
  return;
}



void FUN_00015e64(ulong *param_1,ulong **param_2)

{
  ulong uVar1;
  ulong *puVar2;
  ulong *puVar3;
  byte *pbVar4;
  long extraout_x8;
  long extraout_x8_00;
  ulong uVar5;
  ulong *puVar6;
  ulong **ppuVar7;
  ulong *puVar8;
  ulong *puVar9;
  
  puVar8 = (ulong *)param_1[1];
  puVar6 = (ulong *)param_1[2];
  puVar9 = puVar8;
  if ((puVar6 == (ulong *)0x0) || (puVar3 = puVar8, puVar9 = puVar6, puVar8 == (ulong *)0x0)) {
    uVar5 = *param_1;
    puVar3 = (ulong *)(uVar5 & 0xfffffffffffffffc);
    if (puVar9 != (ulong *)0x0) {
      *puVar9 = *puVar9 & 3 | (ulong)puVar3;
    }
    if (puVar3 == (ulong *)0x0) {
      *param_2 = puVar9;
    }
    else if ((ulong *)puVar3[2] == param_1) {
      puVar3[2] = (ulong)puVar9;
    }
    else {
      puVar3[1] = (ulong)puVar9;
    }
  }
  else {
    do {
      puVar2 = puVar3;
      puVar3 = (ulong *)puVar2[2];
    } while ((ulong *)puVar2[2] != (ulong *)0x0);
    uVar5 = *puVar2;
    puVar9 = (ulong *)puVar2[1];
    puVar3 = (ulong *)(uVar5 & 0xfffffffffffffffc);
    if (puVar9 != (ulong *)0x0) {
      *puVar9 = *puVar9 & 3 | (ulong)puVar3;
    }
    if (puVar3 == param_1) {
      param_1[1] = (ulong)puVar9;
      puVar3 = puVar2;
      puVar8 = puVar9;
    }
    else {
      puVar3[2] = (ulong)puVar9;
      puVar6 = (ulong *)param_1[2];
    }
    *puVar2 = *param_1;
    puVar2[1] = (ulong)puVar8;
    puVar2[2] = (ulong)puVar6;
    uVar1 = *param_1 & 0xfffffffffffffffc;
    ppuVar7 = param_2;
    if (uVar1 != 0) {
      ppuVar7 = (ulong **)(uVar1 + 0x10);
      if (*(ulong **)(uVar1 + 0x10) != param_1) {
        ppuVar7 = (ulong **)(uVar1 + 8);
      }
    }
    *ppuVar7 = puVar2;
    *(ulong *)param_1[2] = *(ulong *)param_1[2] & 3 | (ulong)puVar2;
    puVar8 = (ulong *)param_1[1];
    if (puVar8 != (ulong *)0x0) {
      *puVar8 = *puVar8 & 3 | (ulong)puVar2;
    }
  }
  if ((uVar5 & 1) != 0) {
    while( true ) {
      puVar8 = puVar3;
      if ((puVar9 != (ulong *)0x0) && (uVar5 = *puVar9, (uVar5 & 1) == 0)) goto LAB_000160dc;
      if (puVar9 == *param_2) goto LAB_000160d4;
      puVar6 = (ulong *)puVar8[2];
      if (puVar6 == puVar9) {
        puVar6 = (ulong *)puVar8[1];
        if ((*puVar6 & 1) == 0) {
          FUN_000166cc();
          FUN_00015dc4();
          puVar6 = (ulong *)puVar8[1];
        }
        puVar9 = (ulong *)puVar6[2];
        if ((puVar9 == (ulong *)0x0) || ((*puVar9 & 1) != 0)) {
          pbVar4 = (byte *)puVar6[1];
          if ((pbVar4 == (byte *)0x0) || ((*pbVar4 & 1) != 0)) goto LAB_00016024;
        }
        else {
          pbVar4 = (byte *)puVar6[1];
          if ((pbVar4 == (byte *)0x0) || ((*pbVar4 & 1) != 0)) {
            *puVar9 = *puVar9 | 1;
            *puVar6 = *puVar6 & 0xfffffffffffffffe;
            FUN_00016758();
            pbVar4 = *(byte **)(puVar8[1] + 8);
          }
        }
        FUN_0001670c(pbVar4);
        if (extraout_x8_00 != 0) {
          FUN_000167c4();
        }
        FUN_00016760(puVar8);
        goto LAB_000160d0;
      }
      if ((*puVar6 & 1) == 0) {
        FUN_000166cc();
        FUN_00015e14();
        puVar6 = (ulong *)puVar8[2];
      }
      pbVar4 = (byte *)puVar6[2];
      if ((pbVar4 != (byte *)0x0) && ((*pbVar4 & 1) == 0)) goto LAB_00016074;
      puVar9 = (ulong *)puVar6[1];
      if ((puVar9 != (ulong *)0x0) && ((*puVar9 & 1) == 0)) break;
LAB_00016024:
      *puVar6 = *puVar6 & 0xfffffffffffffffe;
      puVar3 = (ulong *)(*puVar8 & 0xfffffffffffffffc);
      puVar9 = puVar8;
    }
    if ((pbVar4 == (byte *)0x0) || ((*pbVar4 & 1) != 0)) {
      *puVar9 = *puVar9 | 1;
      *puVar6 = *puVar6 & 0xfffffffffffffffe;
      FUN_00016760();
      pbVar4 = *(byte **)(puVar8[2] + 0x10);
    }
LAB_00016074:
    FUN_0001670c(pbVar4);
    if (extraout_x8 != 0) {
      FUN_000167c4();
    }
    FUN_00016758(puVar8);
LAB_000160d0:
    puVar9 = *param_2;
LAB_000160d4:
    if (puVar9 != (ulong *)0x0) {
      uVar5 = *puVar9;
LAB_000160dc:
      *puVar9 = uVar5 | 1;
    }
  }
  param_2[2] = (ulong *)((long)param_2[2] - 1);
  return;
}



void _ahpl_rb_erase(undefined8 param_1,undefined8 param_2)

{
  FUN_00015e64(param_2,param_1);
  return;
}



long FUN_0001610c(long *param_1)

{
  long lVar1;
  long lVar2;
  
  lVar2 = *param_1;
  if (lVar2 != 0) {
    do {
      lVar1 = lVar2;
      lVar2 = *(long *)(lVar2 + 0x10);
    } while (lVar2 != 0);
    return lVar1;
  }
  return 0;
}



void _ahpl_vfind_rb_links(long *param_1,long *param_2,undefined8 *param_3,undefined8 *param_4)

{
  long lVar1;
  long *plVar2;
  long lVar3;
  char in_NG;
  undefined in_ZR;
  char in_OV;
  long *extraout_x8;
  long *extraout_x9;
  long lVar4;
  
  lVar3 = *param_1;
  if (*param_1 == 0) {
    lVar4 = 0;
    plVar2 = param_1;
  }
  else {
    do {
      lVar4 = lVar3;
      FUN_000167d4(param_1[1]);
      FUN_0001677c();
      lVar1 = 0x10;
      if ((bool)in_ZR || in_NG != in_OV) {
        lVar1 = 8;
      }
      plVar2 = extraout_x8;
      if ((bool)in_ZR || in_NG != in_OV) {
        plVar2 = extraout_x9;
      }
      lVar3 = *(long *)(lVar4 + lVar1);
    } while (*(long *)(lVar4 + lVar1) != 0);
  }
  if (param_2 != (long *)0x0) {
    *param_2 = lVar4;
  }
  if (param_3 != (undefined8 *)0x0) {
    *param_3 = 0;
  }
  if (param_4 != (undefined8 *)0x0) {
    *param_4 = 0;
  }
  FUN_000166b0(plVar2);
  return;
}



void _ahpl_find_rb_links(long *param_1,long *param_2,undefined8 *param_3,undefined8 *param_4)

{
  long lVar1;
  long *plVar2;
  long lVar3;
  char in_NG;
  undefined in_ZR;
  char in_OV;
  long *extraout_x8;
  long *extraout_x9;
  long lVar4;
  undefined auVar5 [16];
  
  auVar5._8_8_ = param_2;
  auVar5._0_8_ = param_1;
  lVar3 = *param_1;
  if (*param_1 == 0) {
    lVar4 = 0;
    plVar2 = param_1;
  }
  else {
    do {
      lVar4 = lVar3;
      FUN_000167d4(param_1[1],auVar5._0_8_,auVar5._8_8_,&stack0x00000000);
      auVar5 = FUN_0001677c();
      lVar1 = 0x10;
      if ((bool)in_ZR || in_NG != in_OV) {
        lVar1 = 8;
      }
      plVar2 = extraout_x8;
      if ((bool)in_ZR || in_NG != in_OV) {
        plVar2 = extraout_x9;
      }
      lVar3 = *(long *)(lVar4 + lVar1);
    } while (*(long *)(lVar4 + lVar1) != 0);
  }
  if (param_2 != (long *)0x0) {
    *param_2 = lVar4;
  }
  if (param_3 != (undefined8 *)0x0) {
    *param_3 = 0;
  }
  if (param_4 != (undefined8 *)0x0) {
    *param_4 = 0;
  }
  FUN_000166b0(plVar2);
  return;
}



void _ahpl_vfind_rb_node(long *param_1)

{
  long lVar1;
  int iVar2;
  long lVar3;
  
  lVar3 = *param_1;
  while ((lVar3 != 0 && (iVar2 = FUN_000167e0(param_1[1]), iVar2 != 0))) {
    lVar1 = 0x10;
    if (iVar2 < 1) {
      lVar1 = 8;
    }
    lVar3 = *(long *)(lVar3 + lVar1);
  }
  FUN_00016768(lVar3);
  return;
}



void _ahpl_find_rb_node(long *param_1,undefined8 param_2)

{
  long lVar1;
  long lVar2;
  undefined auVar3 [16];
  
  auVar3._8_8_ = param_2;
  auVar3._0_8_ = param_1;
  for (lVar2 = *param_1; lVar2 != 0; lVar2 = *(long *)(lVar2 + lVar1)) {
    auVar3 = FUN_000167e0(param_1[1],auVar3._0_8_,auVar3._8_8_,&stack0x00000000);
    if (auVar3._0_4_ == 0) break;
    lVar1 = 0x10;
    if (auVar3._0_4_ < 1) {
      lVar1 = 8;
    }
  }
  FUN_00016768(lVar2);
  return;
}



void _ahpl_rb_insert_node(undefined8 param_1,undefined8 *param_2)

{
  long *plVar1;
  undefined8 local_30;
  
  plVar1 = (long *)_ahpl_vfind_rb_links(param_1,&local_30,0,0,param_2,&stack0x00000000);
  *param_2 = local_30;
  param_2[1] = 0;
  param_2[2] = 0;
  *plVar1 = (long)param_2;
  FUN_00015ccc(param_2,param_1);
  return;
}



long _ahpl_rb_remove(undefined8 param_1,undefined8 param_2)

{
  long lVar1;
  
  lVar1 = _ahpl_vfind_rb_node(param_1,param_2,&stack0x00000000);
  if (lVar1 != 0) {
    FUN_00015e64(lVar1,param_1);
  }
  return lVar1;
}



void _ahpl_rb_traverse_dlr(void)

{
  FUN_00016680();
  FUN_0001642c();
  FUN_000167bc();
  return;
}



void FUN_0001642c(long param_1)

{
  int iVar1;
  int *unaff_x21;
  long unaff_x22;
  
  if (param_1 != 0) {
    FUN_00016744();
    do {
      if (unaff_x21 == (int *)0x0) {
        FUN_00016698();
        FUN_00016794(*(undefined8 *)(unaff_x22 + 0x10));
        FUN_0001642c();
      }
      else {
        if (*unaff_x21 != 0) break;
        iVar1 = FUN_00016698();
        *unaff_x21 = iVar1;
        if (iVar1 != 0) break;
        FUN_000167ac(*(undefined8 *)(unaff_x22 + 0x10));
        FUN_0001642c();
        if (*unaff_x21 != 0) break;
      }
      unaff_x22 = *(long *)(unaff_x22 + 8);
    } while (unaff_x22 != 0);
  }
  FUN_000166a4();
  return;
}



void _ahpl_rb_traverse_ldr(void)

{
  FUN_00016680();
  FUN_000164b0();
  FUN_000167bc();
  return;
}



void FUN_000164b0(long param_1)

{
  int iVar1;
  int *unaff_x21;
  long unaff_x22;
  
  if (param_1 != 0) {
    FUN_00016744();
    do {
      if (unaff_x21 == (int *)0x0) {
        FUN_00016794(*(undefined8 *)(unaff_x22 + 0x10));
        FUN_000164b0();
        FUN_00016698();
      }
      else {
        if (*unaff_x21 != 0) break;
        FUN_000167ac(*(undefined8 *)(unaff_x22 + 0x10));
        FUN_000164b0();
        if (*unaff_x21 != 0) break;
        iVar1 = FUN_00016698();
        *unaff_x21 = iVar1;
        if (iVar1 != 0) break;
      }
      unaff_x22 = *(long *)(unaff_x22 + 8);
    } while (unaff_x22 != 0);
  }
  FUN_000166a4();
  return;
}



void _ahpl_rb_traverse_lrd(void)

{
  FUN_00016680();
  FUN_00016534();
  FUN_000167bc();
  return;
}



void FUN_00016534(long param_1,int *param_2,code *UNRECOVERED_JUMPTABLE,undefined8 param_4)

{
  int iVar1;
  
  if (param_1 != 0) {
    if (param_2 == (int *)0x0) {
      FUN_000167a4(*(undefined8 *)(param_1 + 0x10),0);
      FUN_000167a4(*(undefined8 *)(param_1 + 8),0,UNRECOVERED_JUMPTABLE);
                    // WARNING: Could not recover jumptable at 0x000165f8. Too many branches
                    // WARNING: Treating indirect jump as call
      (*UNRECOVERED_JUMPTABLE)(param_1,param_4);
      return;
    }
    if (*param_2 == 0) {
      FUN_000167a4(*(undefined8 *)(param_1 + 0x10),param_2);
      if (*param_2 == 0) {
        FUN_000167a4(*(undefined8 *)(param_1 + 8),param_2,UNRECOVERED_JUMPTABLE);
        if (*param_2 == 0) {
          iVar1 = (*UNRECOVERED_JUMPTABLE)(param_1,param_4);
          *param_2 = iVar1;
        }
      }
    }
  }
  return;
}



void _ahpl_rb_traverse_rdl(void)

{
  FUN_00016680();
  FUN_00016618();
  FUN_000167bc();
  return;
}



void FUN_00016618(long param_1)

{
  int iVar1;
  int *unaff_x21;
  long unaff_x22;
  
  if (param_1 != 0) {
    FUN_00016744();
    do {
      if (unaff_x21 == (int *)0x0) {
        FUN_00016794(*(undefined8 *)(unaff_x22 + 8));
        FUN_00016618();
        FUN_00016698();
      }
      else {
        if (*unaff_x21 != 0) break;
        FUN_000167ac(*(undefined8 *)(unaff_x22 + 8));
        FUN_00016618();
        if (*unaff_x21 != 0) break;
        iVar1 = FUN_00016698();
        *unaff_x21 = iVar1;
        if (iVar1 != 0) break;
      }
      unaff_x22 = *(long *)(unaff_x22 + 0x10);
    } while (unaff_x22 != 0);
  }
  FUN_000166a4();
  return;
}



undefined  [16] FUN_00016680(undefined8 *param_1)

{
  long unaff_x29;
  undefined auVar1 [16];
  
  *(undefined4 *)(unaff_x29 + -4) = 0;
  auVar1._0_8_ = *param_1;
  auVar1._8_8_ = unaff_x29 + -4;
  return auVar1;
}



void FUN_00016698(void)

{
  code *UNRECOVERED_JUMPTABLE;
  
                    // WARNING: Could not recover jumptable at 0x000166a0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_000166a4(void)

{
  return;
}



void FUN_000166b0(void)

{
  return;
}



void FUN_000166cc(ulong param_1,ulong *param_2)

{
  ulong *unaff_x20;
  
  *param_2 = param_1 | 1;
  *unaff_x20 = *unaff_x20 & 0xfffffffffffffffe;
  return;
}



void FUN_000166ec(ulong param_1,ulong *param_2)

{
  ulong *unaff_x21;
  
  *param_2 = param_1 | 1;
  *unaff_x21 = *unaff_x21 & 0xfffffffffffffffe;
  return;
}



void FUN_0001670c(ulong *param_1)

{
  ulong *unaff_x20;
  
  *param_1 = *param_1 & 0xfffffffffffffffe | *unaff_x20 & 1;
  *unaff_x20 = *unaff_x20 | 1;
  return;
}



void FUN_0001672c(ulong param_1,ulong *param_2,ulong *param_3)

{
  *param_3 = param_1;
  *param_2 = *param_2 & 3 | param_1;
  return;
}



void FUN_00016744(void)

{
  return;
}



void FUN_00016758(void)

{
  FUN_00015e14();
  return;
}



void FUN_00016760(void)

{
  FUN_00015dc4();
  return;
}



void FUN_00016768(void)

{
  return;
}



void FUN_0001677c(void)

{
  return;
}



void FUN_00016794(void)

{
  return;
}



void FUN_000167a4(void)

{
  FUN_00016534();
  return;
}



void FUN_000167ac(void)

{
  return;
}



void FUN_000167bc(void)

{
  return;
}



void FUN_000167c4(ulong *param_1)

{
  *param_1 = *param_1 | 1;
  return;
}



void FUN_000167d4(code *UNRECOVERED_JUMPTABLE)

{
                    // WARNING: Could not recover jumptable at 0x000167dc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_000167e0(code *UNRECOVERED_JUMPTABLE)

{
                    // WARNING: Could not recover jumptable at 0x000167e8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



ulong FUN_000167ec(long param_1,ulong param_2,ulong param_3)

{
  ulong uVar1;
  ulong extraout_x8;
  ulong uVar2;
  ulong extraout_x9;
  ulong uVar3;
  ulong uVar4;
  ulong *extraout_x10;
  ulong *puVar5;
  ulong *puVar6;
  ulong uVar7;
  ulong *extraout_x12;
  ulong extraout_x13;
  ulong extraout_x14;
  
  if (param_2 <= param_3) {
    return param_2;
  }
  puVar5 = (ulong *)(param_1 + (param_3 >> 3 & 0x1ffffffffffffff8));
  uVar1 = param_3 & 0xffffffffffffffc0;
  param_2 = param_2 - uVar1;
  uVar2 = uVar1;
  uVar4 = param_2;
  puVar6 = puVar5;
  if ((param_3 & 0x3f) == 0) {
LAB_00016834:
    if (0x3f < uVar4) {
      FUN_00016984();
      uVar1 = extraout_x8;
      uVar3 = extraout_x9;
      puVar5 = extraout_x10;
      do {
        uVar7 = *puVar5;
        if (uVar7 != 0) goto LAB_0001688c;
        puVar5 = puVar5 + 1;
        uVar1 = uVar1 + 0x40;
        uVar3 = uVar3 - 0x40;
        uVar2 = extraout_x13;
        uVar4 = extraout_x14;
        puVar6 = extraout_x12;
      } while (0x3f < uVar3);
    }
    if (uVar4 == 0) {
      return uVar2;
    }
    uVar7 = *puVar6;
    uVar1 = uVar2;
    param_2 = uVar4;
  }
  else {
    puVar6 = puVar5 + 1;
    uVar7 = *puVar5 & -1L << (param_3 & 0x3f);
    uVar4 = param_2 - 0x40;
    if (0x3f < param_2) {
      if (uVar7 != 0) goto LAB_0001688c;
      uVar2 = uVar1 + 0x40;
      goto LAB_00016834;
    }
  }
  uVar7 = uVar7 & 0xffffffffffffffffU >> (-param_2 & 0x3f);
  if (uVar7 == 0) {
    return uVar1 + param_2;
  }
LAB_0001688c:
  uVar2 = (uVar7 & 0xaaaaaaaaaaaaaaaa) >> 1 | (uVar7 & 0x5555555555555555) << 1;
  uVar2 = (uVar2 & 0xcccccccccccccccc) >> 2 | (uVar2 & 0x3333333333333333) << 2;
  uVar2 = (uVar2 & 0xf0f0f0f0f0f0f0f0) >> 4 | (uVar2 & 0xf0f0f0f0f0f0f0f) << 4;
  uVar2 = (uVar2 & 0xff00ff00ff00ff00) >> 8 | (uVar2 & 0xff00ff00ff00ff) << 8;
  uVar2 = (uVar2 & 0xffff0000ffff0000) >> 0x10 | (uVar2 & 0xffff0000ffff) << 0x10;
  return LZCOUNT(uVar2 >> 0x20 | uVar2 << 0x20) + uVar1;
}



ulong FUN_000168b0(long param_1,ulong param_2,ulong param_3)

{
  ulong uVar1;
  ulong extraout_x8;
  ulong uVar2;
  ulong extraout_x9;
  ulong uVar3;
  ulong uVar4;
  ulong *extraout_x10;
  ulong *puVar5;
  ulong *puVar6;
  ulong uVar7;
  ulong *extraout_x12;
  ulong extraout_x13;
  ulong extraout_x14;
  
  if (param_2 <= param_3) {
    return param_2;
  }
  puVar5 = (ulong *)(param_1 + (param_3 >> 3 & 0x1ffffffffffffff8));
  uVar1 = param_3 & 0xffffffffffffffc0;
  param_2 = param_2 - uVar1;
  uVar2 = uVar1;
  uVar4 = param_2;
  puVar6 = puVar5;
  if ((param_3 & 0x3f) == 0) {
LAB_00016900:
    if (0x3f < uVar4) {
      FUN_00016984();
      uVar1 = extraout_x8;
      uVar3 = extraout_x9;
      puVar5 = extraout_x10;
      do {
        uVar7 = *puVar5;
        if (uVar7 != 0xffffffffffffffff) goto LAB_0001695c;
        puVar5 = puVar5 + 1;
        uVar1 = uVar1 + 0x40;
        uVar3 = uVar3 - 0x40;
        uVar2 = extraout_x13;
        uVar4 = extraout_x14;
        puVar6 = extraout_x12;
      } while (0x3f < uVar3);
    }
    if (uVar4 == 0) {
      return uVar2;
    }
    uVar7 = *puVar6;
    uVar1 = uVar2;
    param_2 = uVar4;
  }
  else {
    puVar6 = puVar5 + 1;
    uVar7 = *puVar5 | 0xffffffffffffffffU >> (-(param_3 & 0x3f) & 0x3f);
    uVar4 = param_2 - 0x40;
    if (0x3f < param_2) {
      if (uVar7 != 0xffffffffffffffff) goto LAB_0001695c;
      uVar2 = uVar1 + 0x40;
      goto LAB_00016900;
    }
  }
  uVar7 = uVar7 | -1L << (param_2 & 0x3f);
  if (uVar7 == 0xffffffffffffffff) {
    return uVar1 + param_2;
  }
LAB_0001695c:
  uVar2 = (~uVar7 & 0xaaaaaaaaaaaaaaaa) >> 1 | (~uVar7 & 0x5555555555555555) << 1;
  uVar2 = (uVar2 & 0xcccccccccccccccc) >> 2 | (uVar2 & 0x3333333333333333) << 2;
  uVar2 = (uVar2 & 0xf0f0f0f0f0f0f0f0) >> 4 | (uVar2 & 0xf0f0f0f0f0f0f0f) << 4;
  uVar2 = (uVar2 & 0xff00ff00ff00ff00) >> 8 | (uVar2 & 0xff00ff00ff00ff) << 8;
  uVar2 = (uVar2 & 0xffff0000ffff0000) >> 0x10 | (uVar2 & 0xffff0000ffff) << 0x10;
  return LZCOUNT(uVar2 >> 0x20 | uVar2 << 0x20) + uVar1;
}



void FUN_00016984(void)

{
  return;
}



void FUN_000169a8(void)

{
  _sysconf(0x3a);
  return;
}



void _ahpl_processors_count(void)

{
  _sysconf(0x3a);
  return;
}



undefined8 FUN_000169c4(undefined8 param_1,undefined8 *param_2)

{
  int iVar1;
  undefined auStack_40 [16];
  undefined8 local_30;
  undefined8 local_28;
  
  iVar1 = _dladdr(param_1,auStack_40);
  if (iVar1 == 0) {
    local_30 = 0;
  }
  else if (param_2 != (undefined8 *)0x0) {
    *param_2 = local_28;
  }
  return local_30;
}



undefined8 _ahpl_addr_syminfo(undefined8 param_1,undefined8 *param_2)

{
  int iVar1;
  undefined auStack_40 [16];
  undefined8 uStack_30;
  undefined8 uStack_28;
  
  iVar1 = _dladdr(param_1,auStack_40);
  if (iVar1 == 0) {
    uStack_30 = 0;
  }
  else if (param_2 != (undefined8 *)0x0) {
    *param_2 = uStack_28;
  }
  return uStack_30;
}



void FUN_00016a10(ulong param_1)

{
  long lVar1;
  long *plVar2;
  long unaff_x20;
  
  if (0x10000000 < param_1) {
    plVar2 = (long *)0xfffffffffffffff9;
    goto LAB_00016a78;
  }
  plVar2 = (long *)FUN_0001710c();
  if (plVar2 == (long *)0x0) {
LAB_00016a58:
    plVar2 = (long *)0xfffffffffffffff4;
  }
  else {
    if (unaff_x20 == 0) {
      lVar1 = 0;
      plVar2[3] = 0;
    }
    else {
      lVar1 = _ahpl_malloc();
      plVar2[3] = lVar1;
      if (lVar1 == 0) {
        _free(plVar2);
        goto LAB_00016a58;
      }
    }
    plVar2[4] = unaff_x20;
    *(undefined4 *)(plVar2 + 5) = 0;
    plVar2[1] = 0;
    plVar2[2] = 0;
    *plVar2 = lVar1;
  }
LAB_00016a78:
  FUN_000170ec(plVar2);
  return;
}



void FUN_00016a84(void *param_1)

{
  if (-1 < *(char *)((long)param_1 + 0x2a)) {
    _free(*(void **)((long)param_1 + 0x18));
  }
  _free(param_1);
  return;
}



void FUN_00016ab4(long *param_1,void *param_2,ulong param_3)

{
  size_t sVar1;
  long *plVar2;
  void *pvVar3;
  long lVar4;
  ulong uVar5;
  ulong uVar6;
  
  uVar6 = param_3;
  if (param_3 == 0) {
    uVar6 = 0;
  }
  else {
    while( true ) {
      plVar2 = param_1;
      lVar4 = plVar2[1];
      uVar5 = (ulong)(uint)((((int)plVar2[4] - (int)lVar4) - (int)*plVar2) + (int)plVar2[3]);
      sVar1 = uVar6;
      if (uVar5 <= uVar6) {
        sVar1 = uVar5;
      }
      pvVar3 = (void *)(*plVar2 + lVar4);
      if ((ulong)(plVar2[3] + plVar2[4]) < (long)pvVar3 + sVar1) {
        pvVar3 = (void *)0xffffffffffffffe4;
      }
      else {
        plVar2[1] = sVar1 + lVar4;
      }
      _memcpy(pvVar3,param_2,sVar1);
      uVar6 = uVar6 - sVar1;
      if (uVar6 == 0) break;
      param_2 = (void *)((long)param_2 + sVar1);
      param_1 = (long *)plVar2[2];
      if ((long *)plVar2[2] == (long *)0x0) {
        param_1 = (long *)FUN_00016a10(0x1000);
        if ((long *)0xfffffffffffff000 < param_1) goto LAB_00016b5c;
        plVar2[2] = (long)param_1;
      }
    }
  }
  param_1 = (long *)0x0;
LAB_00016b5c:
  plVar2 = (long *)(param_3 - uVar6);
  if (param_3 < uVar6 || (long *)(param_3 - uVar6) == (long *)0x0) {
    plVar2 = param_1;
  }
  FUN_000170fc(plVar2);
  return;
}



bool FUN_00016b6c(long param_1,ulong param_2,void *param_3,ulong param_4)

{
  size_t sVar1;
  ulong uVar2;
  ulong uVar3;
  
  if ((param_1 == 0) || (param_4 == 0)) {
LAB_00016be8:
    return param_4 == 0;
  }
  do {
    uVar3 = *(ulong *)(param_1 + 0x20);
    uVar2 = param_2 - uVar3;
    if (param_2 < uVar3) {
      sVar1 = param_4;
      if (uVar3 - param_2 <= param_4) {
        sVar1 = uVar3 - param_2;
      }
      _memcpy((void *)(*(long *)(param_1 + 0x18) + param_2),param_3,sVar1);
      uVar2 = 0;
      param_4 = param_4 - sVar1;
      if (param_4 == 0) {
        param_4 = 0;
        goto LAB_00016be8;
      }
      param_3 = (void *)((long)param_3 + sVar1);
    }
    param_1 = *(long *)(param_1 + 0x10);
    if ((param_1 == 0) || (param_2 = uVar2, param_4 == 0)) goto LAB_00016be8;
  } while( true );
}



void _ahpl_alloc_user_psb(undefined8 param_1,long param_2)

{
  undefined8 uVar1;
  undefined8 *puVar2;
  undefined8 unaff_x20;
  
  puVar2 = (undefined8 *)FUN_0001710c();
  if (puVar2 == (undefined8 *)0x0) {
    puVar2 = (undefined8 *)0xfffffffffffffff4;
  }
  else {
    uVar1 = 0;
    if (param_2 != 0) {
      uVar1 = unaff_x20;
    }
    puVar2[2] = 0;
    puVar2[3] = uVar1;
    puVar2[4] = param_2;
    *(undefined4 *)(puVar2 + 5) = 0x800000;
    *puVar2 = uVar1;
    puVar2[1] = 0;
    if (puVar2 < (undefined8 *)0xfffffffffffff001) goto LAB_00016c4c;
  }
  FUN_000170f4(puVar2);
  FUN_000170dc();
LAB_00016c4c:
  FUN_000170ec();
  return;
}



void _ahpl_alloc_psb(void)

{
  ulong uVar1;
  int *piVar2;
  
  uVar1 = FUN_00016a10();
  if (uVar1 < 0xfffffffffffff001) {
    if (uVar1 == 0) {
      piVar2 = ___error();
      uVar1 = 0;
      *piVar2 = 0;
    }
  }
  else {
    FUN_000170f4();
    uVar1 = FUN_000170dc();
  }
  FUN_000170ec(uVar1);
  return;
}



void _ahpl_psb_attach_buf(undefined8 *param_1,undefined8 param_2,long param_3)

{
  undefined8 uVar1;
  
  if ((param_1[4] != 0) && (-1 < *(char *)((long)param_1 + 0x2a))) {
    _free((void *)param_1[3]);
  }
  uVar1 = 0;
  if (param_3 != 0) {
    uVar1 = param_2;
  }
  param_1[3] = uVar1;
  param_1[4] = param_3;
  *param_1 = uVar1;
  param_1[1] = 0;
  return;
}



void _ahpl_psb_detach_buf(undefined8 *param_1)

{
  if (param_1[4] != 0) {
    if (-1 < *(char *)((long)param_1 + 0x2a)) {
      _free((void *)param_1[3]);
    }
    *param_1 = 0;
    param_1[1] = 0;
    param_1[3] = 0;
    param_1[4] = 0;
  }
  return;
}



int _ahpl_psb_headroom(int *param_1)

{
  return *param_1 - param_1[6];
}



int _ahpl_psb_tailroom(int *param_1)

{
  return ((param_1[8] - param_1[2]) - *param_1) + param_1[6];
}



undefined8 _ahpl_psb_data(undefined8 *param_1)

{
  return *param_1;
}



undefined8 _ahpl_psb_len(long param_1)

{
  return *(undefined8 *)(param_1 + 8);
}



long FUN_00016d64(long param_1)

{
  long *plVar1;
  long lVar2;
  
  lVar2 = 0;
  if (param_1 != 0) {
    do {
      plVar1 = (long *)(param_1 + 8);
      param_1 = *(long *)(param_1 + 0x10);
      lVar2 = *plVar1 + lVar2;
    } while (param_1 != 0);
  }
  return lVar2;
}



long _ahpl_psb_total_len(long param_1)

{
  long *plVar1;
  long lVar2;
  
  lVar2 = 0;
  if (param_1 != 0) {
    do {
      plVar1 = (long *)(param_1 + 8);
      param_1 = *(long *)(param_1 + 0x10);
      lVar2 = *plVar1 + lVar2;
    } while (param_1 != 0);
  }
  return lVar2;
}



undefined8 _ahpl_psb_reserve(long *param_1,uint param_2)

{
  int *piVar1;
  int iVar2;
  
  if (param_1[1] == 0) {
    if ((ulong)param_2 <= (ulong)((param_1[4] - *param_1) + param_1[3])) {
      *param_1 = *param_1 + (ulong)param_2;
      return 0;
    }
    iVar2 = 0x1c;
  }
  else {
    iVar2 = 1;
  }
  piVar1 = ___error();
  *piVar1 = iVar2;
  return 0xffffffff;
}



void _ahpl_psb_put(long *param_1,uint param_2)

{
  ulong uVar1;
  
  uVar1 = *param_1 + param_1[1];
  if ((((ulong)(param_1[3] + param_1[4]) < uVar1 + param_2) ||
      (param_1[1] = param_1[1] + (ulong)param_2, 0xfffffffffffff000 < uVar1)) || (*param_1 == 0)) {
    ___error();
    FUN_000170dc();
  }
  FUN_000170ec();
  return;
}



void _ahpl_psb_get(ulong *param_1,uint param_2)

{
  ulong uVar1;
  
  if ((ulong)param_2 <= param_1[1]) {
    uVar1 = *param_1;
    *param_1 = uVar1 + param_2;
    param_1[1] = param_1[1] - (ulong)param_2;
    if ((uVar1 < 0xfffffffffffff001) && (uVar1 != 0)) goto LAB_00016e98;
  }
  ___error();
  FUN_000170dc();
LAB_00016e98:
  FUN_000170ec();
  return;
}



void _ahpl_psb_peek(ulong *param_1,uint param_2)

{
  if (((param_1[1] < (ulong)param_2) || (0xfffffffffffff000 < *param_1)) || (*param_1 == 0)) {
    ___error();
    FUN_000170dc();
  }
  FUN_000170ec();
  return;
}



void _ahpl_psb_push(ulong *param_1,uint param_2)

{
  ulong uVar1;
  
  uVar1 = *param_1;
  if ((long)(int)param_2 <= (long)(uVar1 - param_1[3])) {
    param_1[1] = param_1[1] + (ulong)param_2;
    *param_1 = uVar1 - param_2;
    if ((uVar1 - param_2 < 0xfffffffffffff001) && (uVar1 != 0)) goto LAB_00016f44;
  }
  ___error();
  FUN_000170dc();
LAB_00016f44:
  FUN_000170ec();
  return;
}



void _ahpl_psb_pull(ulong *param_1,uint param_2)

{
  ulong uVar1;
  ulong uVar2;
  
  if ((ulong)param_2 <= param_1[1]) {
    param_1[1] = param_1[1] - (ulong)param_2;
    uVar2 = *param_1;
    uVar1 = uVar2 + param_2;
    *param_1 = uVar1;
    if ((uVar1 < 0xfffffffffffff001) && (uVar2 != 0)) goto LAB_00016fa4;
  }
  ___error();
  FUN_000170dc();
LAB_00016fa4:
  FUN_000170ec();
  return;
}



void _ahpl_psb_write(void)

{
  ulong uVar1;
  undefined4 *puVar2;
  undefined4 unaff_w19;
  
  uVar1 = FUN_00016ab4();
  if (0xfffffffffffff000 < uVar1) {
    puVar2 = (undefined4 *)FUN_000170f4();
    *puVar2 = unaff_w19;
    uVar1 = 0xffffffffffffffff;
  }
  FUN_000170ec(uVar1);
  return;
}



bool _ahpl_psb_modify(long param_1,ulong param_2,void *param_3,ulong param_4)

{
  size_t sVar1;
  ulong uVar2;
  ulong uVar3;
  
  if ((param_1 == 0) || (param_4 == 0)) {
LAB_00016be8:
    return param_4 == 0;
  }
  do {
    uVar3 = *(ulong *)(param_1 + 0x20);
    uVar2 = param_2 - uVar3;
    if (param_2 < uVar3) {
      sVar1 = param_4;
      if (uVar3 - param_2 <= param_4) {
        sVar1 = uVar3 - param_2;
      }
      _memcpy((void *)(*(long *)(param_1 + 0x18) + param_2),param_3,sVar1);
      uVar2 = 0;
      param_4 = param_4 - sVar1;
      if (param_4 == 0) {
        param_4 = 0;
        goto LAB_00016be8;
      }
      param_3 = (void *)((long)param_3 + sVar1);
    }
    param_1 = *(long *)(param_1 + 0x10);
    if ((param_1 == 0) || (param_2 = uVar2, param_4 == 0)) goto LAB_00016be8;
  } while( true );
}



void _ahpl_psb_read(void **param_1,void *param_2,void *param_3)

{
  void *pvVar1;
  ulong uVar2;
  undefined4 *puVar3;
  void *pvVar4;
  void *pvVar5;
  void *pvVar6;
  
  pvVar6 = param_3;
  do {
    pvVar5 = param_1[1];
    pvVar1 = pvVar6;
    if ((void *)((ulong)pvVar5 & 0xffffffff) <= pvVar6) {
      pvVar1 = (void *)((ulong)pvVar5 & 0xffffffff);
    }
    if (pvVar5 < pvVar1) {
      pvVar4 = (void *)0xffffffffffffffe4;
    }
    else {
      pvVar4 = *param_1;
      *param_1 = (void *)((long)pvVar4 + (long)pvVar1);
      param_1[1] = (void *)((long)pvVar5 - (long)pvVar1);
    }
    _memcpy(param_2,pvVar4,(size_t)pvVar1);
    pvVar6 = (void *)((long)pvVar6 - (long)pvVar1);
    if (pvVar6 == (void *)0x0) break;
    param_2 = (void *)((long)param_2 + (long)pvVar1);
    param_1 = (void **)param_1[2];
  } while (param_1 != (void **)0x0);
  uVar2 = (long)param_3 - (long)pvVar6;
  if (0xfffffffffffff000 < uVar2) {
    puVar3 = (undefined4 *)FUN_000170f4();
    *puVar3 = (int)param_3;
    uVar2 = 0xffffffffffffffff;
  }
  FUN_000170fc(uVar2);
  return;
}



bool _ahpl_psb_single(long param_1)

{
  return *(long *)(param_1 + 0x10) == 0;
}



void _ahpl_psb_reset(undefined8 *param_1)

{
  if (param_1 != (undefined8 *)0x0) {
    do {
      *param_1 = param_1[3];
      param_1[1] = 0;
      param_1 = (undefined8 *)param_1[2];
    } while (param_1 != (undefined8 *)0x0);
  }
  return;
}



void FUN_000170ac(long param_1)

{
  if (param_1 != 0) {
    do {
      param_1 = *(long *)(param_1 + 0x10);
      FUN_00016a84();
    } while (param_1 != 0);
  }
  return;
}



void _ahpl_free_psb_list(long param_1)

{
  if (param_1 != 0) {
    do {
      param_1 = *(long *)(param_1 + 0x10);
      FUN_00016a84();
    } while (param_1 != 0);
  }
  return;
}



undefined8 FUN_000170dc(undefined4 *param_1)

{
  undefined4 unaff_w19;
  
  *param_1 = unaff_w19;
  return 0;
}



void FUN_000170ec(void)

{
  return;
}



void FUN_000170f4(void)

{
  ___error();
  return;
}



void FUN_000170fc(void)

{
  return;
}



void FUN_0001710c(void)

{
  _ahpl_malloc(0x30);
  return;
}



int _ahpl_uri_encode(byte *param_1,byte *param_2,long param_3)

{
  byte bVar1;
  int iVar2;
  byte *pbVar3;
  byte *pbVar4;
  byte *pbVar5;
  
  iVar2 = -1;
  if ((param_1 != (byte *)0x0) && (param_3 != 0)) {
    if (param_2 == (byte *)0x0) {
      *param_1 = 0;
      iVar2 = 0;
    }
    else {
      pbVar5 = param_1 + param_3 + -1;
      pbVar4 = param_1;
      if ((param_1 < pbVar5) && (bVar1 = *param_2, bVar1 != 0)) {
        do {
          if ((&DAT_0002683c)[bVar1] == '\0') {
            pbVar3 = pbVar4 + 2;
            if (pbVar5 <= pbVar3) break;
            *pbVar4 = 0x25;
            pbVar4[1] = "0123456789ABCDEF"[*param_2 >> 4];
            pbVar4[2] = "0123456789ABCDEF"[(ulong)*param_2 & 0xf];
          }
          else {
            *pbVar4 = bVar1;
            pbVar3 = pbVar4;
          }
          pbVar4 = pbVar3 + 1;
          param_2 = param_2 + 1;
          bVar1 = *param_2;
          if ((pbVar5 <= pbVar4) || (bVar1 == 0)) break;
        } while( true );
      }
      *pbVar4 = 0;
      iVar2 = -1;
      if (*param_2 == 0) {
        iVar2 = (int)pbVar4 - (int)param_1;
      }
    }
  }
  return iVar2;
}



void FUN_000171e8(void)

{
  long lVar1;
  
  lVar1 = _sysconf(0x1d);
  if (lVar1 != -1) {
    DAT_00028d48 = lVar1;
  }
  return;
}



undefined4 _ahpl_page_size(void)

{
  return (undefined4)DAT_00028d48;
}



void _ahpl_malloc(size_t param_1)

{
  void *pvVar1;
  
  pvVar1 = _malloc(param_1);
  if (((ulong)pvVar1 & 7) == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  _abort();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _ahpl_free(void *param_1)

{
                    // WARNING: Could not recover jumptable at 0x000244fc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__free_00028270)();
  return;
}



void * _ahpl_calloc(long param_1,long param_2)

{
  void *pvVar1;
  
  pvVar1 = (void *)_ahpl_malloc(param_2 * param_1);
  if (pvVar1 != (void *)0x0) {
    _bzero(pvVar1,param_2 * param_1);
  }
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _ahpl_realloc(void *param_1,size_t param_2)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248c8. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__realloc_000284f8)();
  return pvVar1;
}



void * _ahpl_strdup(char *param_1)

{
  size_t sVar1;
  void *pvVar2;
  
  if (param_1 == (char *)0x0) {
    pvVar2 = (void *)0x0;
  }
  else {
    sVar1 = _strlen(param_1);
    pvVar2 = (void *)_ahpl_malloc(sVar1 + 1);
    if (pvVar2 != (void *)0x0) {
      _memcpy(pvVar2,param_1,sVar1);
      *(undefined *)((long)pvVar2 + sVar1) = 0;
    }
  }
  return pvVar2;
}



undefined8 * FUN_000172e0(uint param_1)

{
  undefined8 *puVar1;
  undefined8 *puVar2;
  
  if ((int)param_1 < 0) {
    return (undefined8 *)0x0;
  }
  for (puVar2 = (undefined8 *)(&DAT_0002a080)[(ulong)(param_1 & 0x3ff) * 2];
      puVar2 != &DAT_0002a080 + (ulong)(param_1 & 0x3ff) * 2; puVar2 = (undefined8 *)*puVar2) {
    if (*(uint *)(puVar2 + 2) == param_1) goto LAB_00017320;
  }
  puVar2 = (undefined8 *)0x0;
LAB_00017320:
  puVar1 = (undefined8 *)0x0;
  if (puVar2 != (undefined8 *)0x0) {
    puVar1 = puVar2 + 2;
  }
  return puVar1;
}



undefined4 FUN_00017330(int param_1,uint param_2)

{
  long **pplVar1;
  undefined4 uVar2;
  char *pcVar3;
  int iVar4;
  long **pplVar5;
  long **pplVar6;
  long lVar7;
  long *plVar8;
  ulong uVar9;
  char *param_9;
  
  pcVar3 = param_9;
  pplVar5 = DAT_00028d50;
  if ((int)param_2 < 0) {
    return 0xffffffea;
  }
  uVar9 = (ulong)(param_2 & 0x3ff);
  pplVar1 = (long **)(&DAT_0002a080 + uVar9 * 2);
  for (pplVar6 = (long **)*pplVar1; pplVar6 != pplVar1; pplVar6 = (long **)*pplVar6) {
    if (*(uint *)(pplVar6 + 2) == param_2) goto LAB_00017388;
  }
  pplVar6 = (long **)0x0;
LAB_00017388:
  if (param_1 != 0) {
    if (pplVar6 != (long **)0x0) {
      lVar7 = (long)*pplVar6;
      plVar8 = (long *)((long *)pplVar6)[1];
      *(long **)(lVar7 + 8) = plVar8;
      *plVar8 = lVar7;
      ((long *)pplVar6)[1] = 0x200203;
      pplVar5 = DAT_00028d58;
      DAT_00028d58 = pplVar6;
      *pplVar6 = (long *)&DAT_00028d50;
      ((long *)pplVar6)[1] = (long)pplVar5;
      *pplVar5 = (long *)pplVar6;
      return 0;
    }
    return 0xfffffffe;
  }
  uVar2 = *(undefined4 *)((ulong)&stack0x00000000 | 8);
  if (pplVar6 != (long **)0x0) {
    *(undefined4 *)((long)pplVar6 + 0x14) = uVar2;
    plVar8 = (long *)pplVar6 + 3;
    if (param_9 == (char *)0x0) {
      *(undefined *)plVar8 = 0;
      return 0;
    }
    iVar4 = _strcmp((char *)plVar8,param_9);
    if (iVar4 == 0) {
      return 0;
    }
    _snprintf((char *)plVar8,0x40,"%s");
    return 0;
  }
  if ((long ***)DAT_00028d50 != &DAT_00028d50) {
    plVar8 = *DAT_00028d50;
    pplVar6 = (long **)DAT_00028d50[1];
    plVar8[1] = (long)pplVar6;
    *pplVar6 = plVar8;
    *pplVar5 = (long *)0x100101;
    pplVar5[1] = (long *)0x200203;
    if (pplVar5 != (long **)0x0) goto LAB_00017474;
  }
  pplVar5 = (long **)_ahpl_malloc(0x58);
  if (pplVar5 == (long **)0x0) {
    return 0xfffffff4;
  }
LAB_00017474:
  *(uint *)(pplVar5 + 2) = param_2;
  *(undefined4 *)((long)pplVar5 + 0x14) = uVar2;
  if (pcVar3 == (char *)0x0) {
    *(undefined *)(pplVar5 + 3) = 0;
  }
  else {
    _snprintf((char *)(pplVar5 + 3),0x40,"%s");
  }
  pplVar6 = (long **)(&DAT_0002a088)[uVar9 * 2];
  (&DAT_0002a088)[uVar9 * 2] = pplVar5;
  *pplVar5 = (long *)pplVar1;
  pplVar5[1] = (long *)pplVar6;
  *pplVar6 = (long *)pplVar5;
  return 0;
}



void FUN_000174e4(void)

{
  long lVar1;
  long lVar2;
  long lVar3;
  
  lVar1 = 0;
  lVar3 = 1;
  lVar2 = 0;
  do {
    *(undefined8 **)((long)&DAT_0002a080 + lVar1) = &DAT_0002a080 + lVar2 * 2;
    *(undefined8 **)((long)&DAT_0002a088 + lVar1) = &DAT_0002a080 + lVar2 * 2;
    *(undefined8 **)((long)&DAT_0002a090 + lVar1) = &DAT_0002a080 + lVar3 * 2;
    *(undefined8 **)((long)&DAT_0002a098 + lVar1) = &DAT_0002a080 + lVar3 * 2;
    lVar2 = lVar2 + 2;
    lVar3 = lVar3 + 2;
    lVar1 = lVar1 + 0x20;
  } while (lVar1 != 0x4000);
  return;
}



void FUN_0001752c(void)

{
  void *pvVar1;
  long lVar2;
  
  lVar2 = 0;
  do {
    while (((undefined8 *)(&DAT_0002a080)[lVar2 * 2] != &DAT_0002a080 + lVar2 * 2 &&
           (pvVar1 = (void *)FUN_000175c0(), pvVar1 != (void *)0x0))) {
      _free(pvVar1);
    }
    lVar2 = lVar2 + 1;
  } while (lVar2 != 0x400);
  while (((undefined8 **)DAT_00028d50 != &DAT_00028d50 &&
         (pvVar1 = (void *)FUN_000175c0(), pvVar1 != (void *)0x0))) {
    _free(pvVar1);
  }
  return;
}



void FUN_000175c0(long *param_1)

{
  long lVar1;
  long *plVar2;
  long unaff_x19;
  long unaff_x20;
  
  lVar1 = *param_1;
  plVar2 = (long *)param_1[1];
  *(long **)(lVar1 + 8) = plVar2;
  *plVar2 = lVar1;
  *param_1 = unaff_x20;
  param_1[1] = unaff_x19;
  return;
}



void FUN_000175d4(code *param_1,undefined8 param_2)

{
  int iVar1;
  int iVar2;
  undefined *puVar3;
  undefined uVar4;
  undefined *puVar5;
  undefined4 local_398 [20];
  undefined local_347;
  undefined4 local_2c8;
  undefined local_277;
  undefined4 local_1f8 [20];
  undefined local_1a7;
  undefined4 local_128;
  undefined local_d7;
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  local_1f8[0] = 0xffffffff;
  local_1a7 = 0;
  local_128 = 0xffffffff;
  local_d7 = 0;
  local_398[0] = 0xffffffff;
  local_347 = 0;
  local_2c8 = 0xffffffff;
  local_277 = 0;
  FUN_00015504(&DAT_0002e080);
  puVar5 = &DAT_0002e330 + (long)(int)DAT_0002e670 * 0x1a0;
  puVar3 = &DAT_0002e330 + (ulong)((long)(int)DAT_0002e670 == 0) * 0x1a0;
  iVar1 = FUN_000177bc(puVar5);
  iVar2 = FUN_00004fcc(puVar3);
  if (iVar2 < 1) {
    uVar4 = param_1 != (code *)0x0 && iVar1 != 0;
    if (param_1 == (code *)0x0 || iVar1 == 0) {
      param_1 = (code *)0x0;
    }
    goto LAB_0001774c;
  }
  if (param_1 == (code *)0x0) {
LAB_000176a4:
    uVar4 = 0;
  }
  else if (iVar1 == 0) {
    iVar1 = FUN_000177bc(&DAT_0002e190);
    if ((iVar1 == 0) || (iVar1 = FUN_000177f4(puVar3,&DAT_0002e190), iVar1 != 0)) {
      FUN_00017e80(local_1f8);
      uVar4 = 2;
    }
    else {
      _memcpy(local_1f8,&DAT_0002e190,0x1a0);
      FUN_00017e80(local_398);
      uVar4 = 3;
    }
  }
  else {
    iVar1 = FUN_000177f4(puVar3,puVar5);
    if (iVar1 != 0) {
      param_1 = (code *)0x0;
      goto LAB_000176a4;
    }
    _memcpy(local_1f8,puVar5,0x1a0);
    FUN_00017e80(local_398);
    uVar4 = 4;
  }
  FUN_00017e80(&DAT_0002e190);
LAB_0001774c:
  DAT_0002e670 = (uint)(DAT_0002e670 == 0);
  FUN_00015548(&DAT_0002e080);
  if (param_1 != (code *)0x0) {
    (*param_1)(uVar4,param_2);
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_58) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  return;
}



void FUN_000177bc(long param_1)

{
  bool bVar1;
  int iVar2;
  
  iVar2 = FUN_00017898();
  if (iVar2 == 0) {
    iVar2 = FUN_00017898(param_1 + 0xd0);
    bVar1 = iVar2 != 0;
  }
  else {
    bVar1 = true;
  }
  FUN_00017ea4(bVar1);
  return;
}



void FUN_000177f4(long param_1,long param_2)

{
  int iVar1;
  ulong uVar2;
  
  uVar2 = FUN_0001791c();
  if ((int)uVar2 != 0) {
    iVar1 = FUN_0001791c(param_1 + 0xd0,param_2 + 0xd0);
    uVar2 = (ulong)(iVar1 != 0);
  }
  FUN_00017ea4(uVar2);
  return;
}



void _ahpl_init_def_rt(undefined8 *param_1)

{
  *param_1 = 0xffffffffffffffff;
  *(undefined *)(param_1 + 1) = 0;
  *(undefined4 *)(param_1 + 9) = 0;
  param_1[0xb] = 0;
  param_1[10] = 0;
  param_1[0xd] = 0;
  param_1[0xc] = 0;
  param_1[0xf] = 0;
  param_1[0xe] = 0;
  param_1[0x11] = 0;
  param_1[0x10] = 0;
  param_1[0x13] = 0;
  param_1[0x12] = 0;
  param_1[0x15] = 0;
  param_1[0x14] = 0;
  param_1[0x17] = 0;
  param_1[0x16] = 0;
  param_1[0x19] = 0;
  param_1[0x18] = 0;
  *(undefined *)((long)param_1 + 0x51) = 0;
  param_1[0x1a] = 0xffffffffffffffff;
  *(undefined *)(param_1 + 0x1b) = 0;
  *(undefined4 *)(param_1 + 0x23) = 0;
  param_1[0x25] = 0;
  param_1[0x24] = 0;
  param_1[0x27] = 0;
  param_1[0x26] = 0;
  param_1[0x29] = 0;
  param_1[0x28] = 0;
  param_1[0x2b] = 0;
  param_1[0x2a] = 0;
  param_1[0x2d] = 0;
  param_1[0x2c] = 0;
  param_1[0x2f] = 0;
  param_1[0x2e] = 0;
  param_1[0x31] = 0;
  param_1[0x30] = 0;
  param_1[0x33] = 0;
  param_1[0x32] = 0;
  *(undefined *)((long)param_1 + 0x121) = 0;
  return;
}



void _ahpl_get_default_rt(uint *param_1)

{
  ushort uVar1;
  byte *pbVar2;
  int iVar3;
  ushort *puVar4;
  long lVar5;
  uint uVar6;
  int iVar7;
  uint *puVar8;
  ushort *puStack_c8;
  long lStack_c0;
  byte *pbStack_b8;
  char *pcStack_b0;
  undefined8 uStack_80;
  undefined8 uStack_78;
  undefined8 uStack_70;
  long lStack_68;
  
  lStack_68 = *(long *)PTR____stack_chk_guard_00028030;
  *param_1 = 0xffffffff;
  *(undefined *)((long)param_1 + 0x51) = 0;
  param_1[0x34] = 0xffffffff;
  *(undefined *)((long)param_1 + 0x121) = 0;
  uStack_78 = 0;
  uStack_80 = 0x1100000004;
  uStack_70 = 7;
  iVar3 = FUN_00005680(&uStack_80,6,0,&puStack_c8);
  if (-1 < iVar3) {
    puVar4 = puStack_c8;
    if ((puStack_c8 == (ushort *)0x0) ||
       (puVar4 = (ushort *)_ahpl_malloc(), puVar4 == (ushort *)0x0)) goto LAB_00005244;
    iVar3 = FUN_00005680(&uStack_80,6,puVar4,&puStack_c8);
    if (-1 < iVar3) {
      if ((long)puStack_c8 < 0x5c) {
        iVar3 = 0;
        iVar7 = 0;
      }
      else {
        iVar7 = 0;
        iVar3 = 0;
        do {
          if ((((*(char *)(puVar4 + 1) == '\x05') && ((*(uint *)(puVar4 + 4) >> 0x18 & 1) == 0)) &&
              (((*(uint *)(puVar4 + 4) >> 0x11 & 1) == 0 || ((*(byte *)(puVar4 + 0xb) & 1) == 0))))
             && (((FUN_00005280(*(undefined4 *)(puVar4 + 6),puVar4 + 0x2e,(ulong)*puVar4 - 0x5c,
                                &lStack_c0), pbVar2 = pbStack_b8, lStack_c0 != 0 &&
                  (pcStack_b0 != (char *)0x0)) && (pbStack_b8 != (byte *)0x0)))) {
            if (*(char *)(lStack_c0 + 1) == '\x1e') {
              if (((((*(int *)(lStack_c0 + 8) == 0) && (*(int *)(lStack_c0 + 0xc) == 0)) &&
                   ((*(int *)(lStack_c0 + 0x10) == 0 && (*(int *)(lStack_c0 + 0x14) == 0)))) &&
                  ((*pcStack_b0 == '\0' ||
                   (((*(int *)(pcStack_b0 + 8) == 0 && (*(int *)(pcStack_b0 + 0xc) == 0)) &&
                    ((*(int *)(pcStack_b0 + 0x10) == 0 && (*(int *)(pcStack_b0 + 0x14) == 0))))))))
                 && ((iVar3 == 0 && (pbStack_b8[1] == 0x1e)))) {
                iVar3 = 1;
                puVar8 = param_1 + 0x34;
                goto LAB_00005128;
              }
            }
            else if ((((*(char *)(lStack_c0 + 1) == '\x02') && (*(int *)(lStack_c0 + 4) == 0)) &&
                     ((*pcStack_b0 == '\0' || (*(int *)(pcStack_b0 + 4) == 0)))) &&
                    ((pbStack_b8[1] == 2 && (iVar7 == 0)))) {
              iVar7 = 1;
              puVar8 = param_1;
LAB_00005128:
              uVar1 = puVar4[2];
              lVar5 = FUN_000172e0(uVar1);
              *puVar8 = (uint)uVar1;
              if (lVar5 == 0) {
                puVar8[1] = 0xffffffff;
                ___sprintf_chk(puVar8 + 2,0,0x40,"%d");
                uVar6 = 1;
              }
              else {
                puVar8[1] = *(uint *)(lVar5 + 4);
                ___strcpy_chk(puVar8 + 2,lVar5 + 8,0x40);
                uVar6 = (uint)(puVar8[1] == 0xff);
              }
              puVar8[0x12] = uVar6;
              _memcpy(puVar8 + 0x14,pbVar2,(ulong)*pbVar2);
            }
          }
          uVar1 = *puVar4;
          puVar4 = (ushort *)((long)puVar4 + (ulong)uVar1);
          puStack_c8 = (ushort *)((long)puStack_c8 - (ulong)uVar1);
        } while (0x5b < (long)puStack_c8);
      }
      FUN_0000568c();
      puVar4 = (ushort *)(ulong)(uint)(iVar7 + iVar3);
      goto LAB_00005244;
    }
    FUN_0000568c();
  }
  puVar4 = (ushort *)0x0;
LAB_00005244:
  if (*(long *)PTR____stack_chk_guard_00028030 != lStack_68) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(puVar4);
  }
  return;
}



void _ahpl_invalidate_rt(undefined4 *param_1)

{
  *param_1 = 0xffffffff;
  *(undefined *)((long)param_1 + 0x51) = 0;
  return;
}



void _ahpl_invalidate_def_rt(undefined4 *param_1)

{
  *param_1 = 0xffffffff;
  *(undefined *)((long)param_1 + 0x51) = 0;
  param_1[0x34] = 0xffffffff;
  *(undefined *)((long)param_1 + 0x121) = 0;
  return;
}



bool _ahpl_rt_valid(int *param_1)

{
  if (-1 < *param_1) {
    return *(char *)((long)param_1 + 0x51) == '\x02' || *(char *)((long)param_1 + 0x51) == '\x1e';
  }
  return false;
}



bool FUN_00017898(int *param_1)

{
  if (-1 < *param_1) {
    return *(char *)((long)param_1 + 0x51) == '\x02' || *(char *)((long)param_1 + 0x51) == '\x1e';
  }
  return false;
}



void _ahpl_def_rt_valid(long param_1)

{
  bool bVar1;
  int iVar2;
  
  iVar2 = FUN_00017898();
  if (iVar2 == 0) {
    iVar2 = FUN_00017898(param_1 + 0xd0);
    bVar1 = iVar2 != 0;
  }
  else {
    bVar1 = true;
  }
  FUN_00017ea4(bVar1);
  return;
}



void _ahpl_network_is_down(void)

{
  int iVar1;
  
  FUN_00004bbc(&DAT_0002e0c8);
  iVar1 = FUN_000177bc(&DAT_0002e330 + (long)DAT_0002e670 * 0x1a0);
  FUN_00004c24(&DAT_0002e0c8);
  FUN_00017ea4(iVar1 == 0);
  return;
}



undefined8 _ahpl_same_rt(uint *param_1,uint *param_2)

{
  undefined8 uVar1;
  
  if ((int)(*param_2 & *param_1) < 0) {
    return 1;
  }
  if ((*param_1 == *param_2) && (param_1[1] == param_2[1])) {
    uVar1 = _ahpl_sk_addr_ip_equal(param_1 + 0x14,param_2 + 0x14);
    return uVar1;
  }
  return 0;
}



undefined8 FUN_0001791c(uint *param_1,uint *param_2)

{
  undefined8 uVar1;
  
  if ((int)(*param_2 & *param_1) < 0) {
    return 1;
  }
  if ((*param_1 == *param_2) && (param_1[1] == param_2[1])) {
    uVar1 = _ahpl_sk_addr_ip_equal(param_1 + 0x14,param_2 + 0x14);
    return uVar1;
  }
  return 0;
}



void _ahpl_same_def_rt(long param_1,long param_2)

{
  int iVar1;
  ulong uVar2;
  
  uVar2 = FUN_0001791c();
  if ((int)uVar2 != 0) {
    iVar1 = FUN_0001791c(param_1 + 0xd0,param_2 + 0xd0);
    uVar2 = (ulong)(iVar1 != 0);
  }
  FUN_00017ea4(uVar2);
  return;
}



char * _ahpl_rt_str(long param_1,char *param_2)

{
  int iVar1;
  undefined auVar2 [16];
  undefined auStack_88 [64];
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  iVar1 = FUN_00017898();
  if (iVar1 == 0) {
    param_2 = "<EMPTY RT>";
  }
  else {
    auVar2 = _ahpl_ip_sk_addr_str(param_1 + 0x50,auStack_88,0x40);
    FUN_00017ed4(auVar2._0_8_,auVar2._8_8_,"%s: [(%d,%s,%d,cellnet:%d)->%s]");
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_48) {
    return param_2;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_def_rt_str(long param_1,char *param_2,long param_3)

{
  int iVar1;
  int iVar2;
  long lVar3;
  long lVar4;
  undefined auVar5 [16];
  
  lVar4 = *(long *)PTR____stack_chk_guard_00028030;
  *param_2 = '\0';
  iVar1 = FUN_00017898();
  if (iVar1 == 0) {
    iVar1 = 0;
  }
  else {
    auVar5 = FUN_00017ebc(param_1 + 0x50);
    FUN_00017ed4(auVar5._0_8_,auVar5._8_8_,"IPv4: [(%d,%s,%d,cellnet:%d)->%s]");
    iVar1 = FUN_00017ee0();
  }
  iVar2 = FUN_00017898(param_1 + 0xd0);
  if (iVar2 != 0) {
    if (0 < iVar1) {
      lVar3 = FUN_00017ee0();
      *(undefined2 *)(param_2 + lVar3) = 0x203b;
      *(undefined *)((long)(param_2 + lVar3) + 2) = 0;
      iVar1 = iVar1 + 2;
    }
    FUN_00017ebc(param_1 + 0x120);
    iVar2 = _snprintf(param_2 + iVar1,param_3 - iVar1,"IPv6: [(%d,%s,%d,cellnet:%d)->%s]");
    iVar2 = FUN_00017ee0(iVar2);
    iVar1 = iVar1 + iVar2;
  }
  if (iVar1 < 1) {
    param_2 = "<EMPTY DEF_RT>";
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar4) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(param_2);
}



void _ahpl_is_mobile_net(int param_1)

{
  int *piVar1;
  undefined *puVar2;
  undefined4 uVar3;
  
  FUN_00004bbc(&DAT_0002e0c8);
  if (param_1 == 0x1e) {
    puVar2 = (undefined *)((long)DAT_0002e670 * 0x1a0 + 0x2e400);
LAB_00017bc4:
    if (puVar2[0x51] != '\0') {
      uVar3 = *(undefined4 *)(puVar2 + 0x48);
      FUN_00004c24(&DAT_0002e0c8);
      goto LAB_00017bfc;
    }
  }
  else if (param_1 == 2) {
    puVar2 = &DAT_0002e330 + (long)DAT_0002e670 * 0x1a0;
    goto LAB_00017bc4;
  }
  FUN_00004c24(&DAT_0002e0c8);
  piVar1 = ___error();
  *piVar1 = 0x16;
  uVar3 = 0xffffffff;
LAB_00017bfc:
  FUN_00017ea4(uVar3);
  return;
}



void _ahpl_ip_sk_create(undefined8 *param_1)

{
  int iVar1;
  int iVar2;
  long lVar3;
  
  FUN_00004bbc(&DAT_0002e0c8);
  lVar3 = (long)DAT_0002e670;
  iVar1 = FUN_00017898(&DAT_0002e330 + lVar3 * 0x1a0);
  iVar2 = FUN_00017898(lVar3 * 0x1a0 + 0x2e400);
  FUN_00004c24(&DAT_0002e0c8);
  *param_1 = 0xffffffffffffffff;
  if ((iVar1 == 0) || (iVar1 = FUN_00017ec8(2), iVar1 < 0)) {
    iVar1 = 0;
  }
  else {
    *(int *)param_1 = iVar1;
    iVar1 = 1;
  }
  if ((iVar2 != 0) && (iVar2 = FUN_00017ec8(0x1e), -1 < iVar2)) {
    *(int *)((long)param_1 + 4) = iVar2;
    iVar1 = iVar1 + 1;
  }
  if (iVar1 == 0) {
    iVar1 = -1;
  }
  FUN_00017eac(iVar1);
  return;
}



void FUN_00017cc4(void)

{
  _ahpl_init_def_rt(&DAT_0002e330);
  _ahpl_init_def_rt(&DAT_0002e4d0);
  _ahpl_init_def_rt(&DAT_0002e190);
  return;
}



void _ahpl_subscribe_net_events(long param_1,undefined8 param_2)

{
  uint uVar1;
  int *piVar2;
  int iVar3;
  undefined8 uVar4;
  
  uVar1 = _ahpl_mpq_this();
  if ((uVar1 >> 0xf & 1) != 0) {
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar4 = 0xffffffff;
    goto LAB_00017dec;
  }
  FUN_00015504(&DAT_0002e080);
  if (param_1 == 0) {
    if (DAT_00028d60 != uVar1) {
      piVar2 = ___error();
      iVar3 = 1;
      goto LAB_00017dd8;
    }
    FUN_00005484();
    FUN_00017cc4();
    FUN_0001752c();
    uVar4 = 0;
    DAT_00028d60 = 0xffffffff;
    DAT_0002eba0 = 0;
    DAT_0002eba8 = 0;
  }
  else if ((DAT_00028d60 >> 0xf & 1) == 0) {
    piVar2 = ___error();
    iVar3 = 0x11;
LAB_00017dd8:
    *piVar2 = iVar3;
    uVar4 = 0xffffffff;
  }
  else {
    uVar4 = FUN_000052e0(param_1,param_2);
    if (-1 < (int)uVar4) {
      DAT_00028d60 = uVar1;
      DAT_0002eba0 = param_1;
      DAT_0002eba8 = param_2;
      FUN_00015548(&DAT_0002e080);
      FUN_000175d4(param_1,param_2);
      goto LAB_00017dec;
    }
  }
  FUN_00015548(&DAT_0002e080);
LAB_00017dec:
  FUN_00017eac(uVar4);
  return;
}



void _ahpl_net_route_changed(int param_1,undefined8 param_2)

{
  undefined8 in_x6;
  undefined8 in_x7;
  
  _ahpl_mpq_queue(DAT_00028d60,0xffffffff,0xffffffff,"__route_changed",FUN_00017e44,2,in_x6,in_x7,
                  (long)param_1,param_2);
  return;
}



void FUN_00017e44(undefined8 param_1,long param_2)

{
  if (param_2 != 1) {
    FUN_000175d4(DAT_0002eba0,DAT_0002eba8);
    return;
  }
  return;
}



void FUN_00017e60(void)

{
  FUN_000154dc(&DAT_0002e080);
  FUN_00017cc4();
  FUN_000174e4();
  return;
}



void FUN_00017e80(void *param_1)

{
  void *unaff_x21;
  
  _memcpy(param_1,unaff_x21,0x1a0);
  return;
}



void FUN_00017e8c(undefined4 *param_1)

{
  *param_1 = 0xffffffff;
  *(undefined *)((long)param_1 + 0x51) = 0;
  param_1[0x34] = 0xffffffff;
  *(undefined *)((long)param_1 + 0x121) = 0;
  return;
}



void FUN_00017ea4(void)

{
  return;
}



void FUN_00017eac(void)

{
  return;
}



void FUN_00017ebc(undefined8 param_1)

{
  _ahpl_ip_sk_addr_str(param_1,&stack0x00000028,0x40);
  return;
}



int FUN_00017ec8(int param_1)

{
  int iVar1;
  int unaff_w20;
  int unaff_w21;
  
  iVar1 = _socket(param_1,unaff_w21,unaff_w20);
  return iVar1;
}



int FUN_00017ed4(undefined8 param_1,undefined8 param_2,char *param_3)

{
  int iVar1;
  char *unaff_x19;
  size_t unaff_x20;
  
  iVar1 = _snprintf(unaff_x19,unaff_x20,param_3);
  return iVar1;
}



void FUN_00017ee0(void)

{
  char *unaff_x19;
  
  _strlen(unaff_x19);
  return;
}



void _ahpl_tcp_resolve_host_async(void)

{
  undefined8 in_x4;
  undefined8 in_x5;
  ulong in_x6;
  undefined8 extraout_x8;
  undefined auVar1 [16];
  
  if (in_x6 < 0x41) {
    auVar1 = FUN_000183a4();
    FUN_00017f28(auVar1._0_8_,auVar1._8_8_,1,6,in_x4,in_x5,extraout_x8);
  }
  else {
    ___error();
    FUN_00018394();
  }
  return;
}



void FUN_00017f28(undefined8 param_1,undefined8 param_2,int param_3,int param_4,undefined8 param_5,
                 undefined8 param_6,int param_7,undefined8 param_8,ulong param_9,
                 undefined8 *param_10)

{
  undefined8 *puVar1;
  long lVar2;
  uint uVar3;
  ulong uVar4;
  undefined8 *puVar5;
  long alStack_20 [2];
  
  uVar4 = param_9;
  alStack_20[1] = *(long *)PTR____stack_chk_guard_00028030;
  if (param_9 < 0x41) {
    lVar2 = -((param_9 + 9) * 8 + 0xf & 0xfffffffffffffff0);
    *(undefined8 *)((long)alStack_20 + lVar2) = param_1;
    *(undefined8 *)((long)alStack_20 + lVar2 + 8) = param_2;
    *(long *)(&stack0xfffffffffffffff0 + lVar2) = (long)param_3;
    *(long *)(&stack0xfffffffffffffff8 + lVar2) = (long)param_4;
    *(undefined8 *)((long)&param_9 + lVar2) = param_5;
    *(undefined8 *)((long)&param_10 + lVar2) = param_6;
    *(long *)(&stack0x00000010 + lVar2) = (long)param_7;
    *(undefined8 *)(&stack0x00000018 + lVar2) = param_8;
    *(ulong *)(&stack0x00000020 + lVar2) = uVar4;
    if (uVar4 != 0) {
      puVar5 = (undefined8 *)(&stack0x00000028 + lVar2);
      do {
        puVar1 = param_10 + 1;
        *puVar5 = *param_10;
        uVar4 = uVar4 - 1;
        puVar5 = puVar5 + 1;
        param_10 = puVar1;
      } while (uVar4 != 0);
    }
    uVar3 = _ahpl_mpqp_queue_argv
                      (DAT_00029908,0xffffffff,0xffffffff,"____dns_resolve_host",FUN_000180cc);
    uVar4 = (ulong)-(uVar3 >> 0xf & 1);
  }
  else {
    ___error();
    uVar4 = FUN_00018394();
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == alStack_20[1]) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar4);
}



void _ahpl_tcp_resolve_host_asyncv(void)

{
  ulong in_x6;
  undefined auVar1 [16];
  
  if (in_x6 < 0x41) {
    auVar1 = FUN_000183c4();
    FUN_000183dc(auVar1._0_8_,auVar1._8_8_,1,6);
  }
  else {
    ___error();
    FUN_00018394();
  }
  return;
}



void _ahpl_udp_resolve_host_async(void)

{
  undefined8 in_x4;
  undefined8 in_x5;
  ulong in_x6;
  undefined8 extraout_x8;
  undefined auVar1 [16];
  
  if (in_x6 < 0x41) {
    auVar1 = FUN_000183a4();
    FUN_00017f28(auVar1._0_8_,auVar1._8_8_,2,0x11,in_x4,in_x5,extraout_x8);
  }
  else {
    ___error();
    FUN_00018394();
  }
  return;
}



void _ahpl_udp_resolve_host_asyncv(void)

{
  ulong in_x6;
  undefined auVar1 [16];
  
  if (in_x6 < 0x41) {
    auVar1 = FUN_000183c4();
    FUN_000183dc(auVar1._0_8_,auVar1._8_8_,2,0x11);
  }
  else {
    ___error();
    FUN_00018394();
  }
  return;
}



void FUN_000180cc(void)

{
  undefined4 uVar1;
  undefined8 uVar2;
  undefined8 *in_x3;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  
  uVar3 = *in_x3;
  uVar4 = in_x3[4];
  uVar1 = *(undefined4 *)(in_x3 + 6);
  uVar5 = in_x3[7];
  uVar6 = in_x3[8];
  uVar2 = FUN_00018144(uVar3,*(undefined2 *)(in_x3 + 1),*(undefined4 *)(in_x3 + 2),
                       *(undefined4 *)(in_x3 + 3));
  FUN_000182c0(uVar1,uVar5,uVar6,in_x3 + 9,uVar3,uVar2,uVar4);
  return;
}



ulong FUN_00018144(char *param_1,undefined8 param_2,int param_3,int param_4)

{
  uint uVar1;
  int iVar2;
  int *piVar3;
  sockaddr *psVar4;
  undefined8 uVar5;
  ulong uVar6;
  addrinfo *paVar7;
  undefined *puVar8;
  addrinfo *local_a0;
  addrinfo local_98;
  long *plVar9;
  char acStack_58 [16];
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  local_98.ai_next = (addrinfo *)0x0;
  local_98.ai_flags = 0x400;
  local_98.ai_family = 0;
  local_98.ai_addrlen = 0;
  local_98.ai_canonname = (char *)0x0;
  local_98.ai_addr = (sockaddr *)0x0;
  local_98.ai_socktype = param_3;
  local_98.ai_protocol = param_4;
  plVar9 = (long *)register0x00000008;
  ___sprintf_chk(acStack_58,0,0x10,"%u");
  iVar2 = _getaddrinfo(param_1,acStack_58,&local_98,&local_a0);
  if ((iVar2 == 0) && (local_a0 != (addrinfo *)0x0)) {
    uVar6 = 0;
    paVar7 = local_a0;
    do {
      if (paVar7->ai_family == 0x1e || paVar7->ai_family == 2) {
        uVar5 = *(undefined8 *)&paVar7->ai_socktype;
        psVar4 = paVar7->ai_addr;
        uVar1 = paVar7->ai_addrlen;
        if (*(uint *)(plVar9 + 1) <= (uint)uVar6) {
          piVar3 = ___error();
          *piVar3 = 0x37;
          piVar3 = ___error();
          iVar2 = *piVar3;
          goto LAB_000182ac;
        }
        puVar8 = (undefined *)(*plVar9 + (uVar6 & 0xffffffff) * 0x98);
        *puVar8 = (char)paVar7->ai_family;
        *(undefined8 *)(puVar8 + 4) = uVar5;
        _memcpy(puVar8 + 0x10,psVar4,(ulong)uVar1);
        *(uint *)(puVar8 + 0x90) = uVar1;
        uVar6 = uVar6 + 1;
      }
      paVar7 = paVar7->ai_next;
    } while (paVar7 != (addrinfo *)0x0);
    iVar2 = 0;
LAB_000182ac:
    if (local_a0 != (addrinfo *)0x0) {
      _freeaddrinfo(local_a0);
    }
  }
  else {
    iVar2 = 0;
    uVar6 = 0;
  }
  piVar3 = ___error();
  *piVar3 = iVar2;
  if (*(long *)PTR____stack_chk_guard_00028030 == local_48) {
    return uVar6;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_000182c0(undefined8 param_1,code *param_2,long param_3,void *param_4,undefined8 param_5,
                 undefined8 param_6,undefined8 param_7)

{
  long lVar1;
  long lVar2;
  int iVar3;
  undefined8 *puVar4;
  long local_40 [2];
  
  local_40[1] = *(long *)PTR____stack_chk_guard_00028030;
  lVar1 = param_3 + 3;
  lVar2 = -(lVar1 * 8 + 0xfU & 0xfffffffffffffff0);
  puVar4 = (undefined8 *)((long)local_40 + lVar2);
  *puVar4 = param_5;
  *(undefined8 *)((long)local_40 + lVar2 + 8) = param_6;
  *(undefined8 *)(&stack0xffffffffffffffd0 + lVar2) = param_7;
  if (param_3 != 0) {
    _memcpy(&stack0xffffffffffffffd8 + lVar2,param_4,param_3 << 3);
  }
  iVar3 = _ahpl_mpq_queue_argv(param_1,0xffffffff,0xffffffff,0,param_2,lVar1,puVar4);
  if (iVar3 < 0) {
    local_40[0] = _ahpl_tick_now();
    (*param_2)(local_40,1,lVar1,puVar4);
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_40[1]) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



undefined8 FUN_00018394(undefined4 *param_1)

{
  *param_1 = 1;
  return 0xffffffff;
}



void FUN_000183a4(void)

{
  long unaff_x29;
  
  *(long *)(unaff_x29 + -8) = unaff_x29 + 0x10;
  return;
}



void FUN_000183c4(void)

{
  return;
}



void FUN_000183dc(void)

{
  FUN_00017f28();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_socket(int param_1,int param_2,int param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024964. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__socket_00028560)(param_1,param_2,param_3);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_bind(int param_1,sockaddr *param_2,socklen_t param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002449c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__bind_00028230)(param_1,param_2,param_3);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_getsockname(int param_1,sockaddr *param_2,socklen_t *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024568. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getsockname_000282b8)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_getpeername(int param_1,sockaddr *param_2,socklen_t *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024544. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getpeername_000282a0)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_getsockopt(int param_1,int param_2,int param_3,void *param_4,socklen_t *param_5)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024574. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getsockopt_000282c0)(param_1,param_2,param_3);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ahpl_setsockopt(int param_1,int param_2,int param_3,void *param_4,socklen_t param_5)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024934. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__setsockopt_00028540)(param_1,param_2,param_3,param_4,param_5);
  return iVar1;
}



void _ahpl_mpq_connect(void)

{
  uint uVar1;
  
  uVar1 = FUN_00018440();
  if (0xfffff000 < uVar1) {
    FUN_00019e38();
    FUN_00019e7c();
  }
  FUN_00019fe0();
  return;
}



void FUN_00018440(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  undefined8 uVar1;
  long lVar2;
  undefined8 *extraout_x8;
  undefined8 *puVar3;
  undefined auVar4 [16];
  ulong param_9;
  undefined8 *param_10;
  undefined auStack_70 [8];
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_9 < 0x41) {
    auVar4 = FUN_00019f3c();
    lVar2 = FUN_0000a4a4();
    if (lVar2 == 0) {
      uVar1 = 0xffffffff;
    }
    else {
      uVar1 = FUN_00019e68(auStack_70);
      puVar3 = extraout_x8;
      if (param_9 != 0) {
        do {
          *puVar3 = *param_10;
          param_9 = param_9 - 1;
          puVar3 = puVar3 + 1;
          param_10 = param_10 + 1;
        } while (param_9 != 0);
      }
      FUN_00019f78(uVar1,auVar4._0_8_,auVar4._8_8_,param_3);
      uVar1 = FUN_00019a98();
    }
  }
  else {
    uVar1 = 0xfffffff9;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_68) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar1);
  }
  FUN_00019ea0();
  return;
}



void _ahpl_mpq_connect_on_q(void)

{
  uint uVar1;
  
  uVar1 = FUN_00018568();
  if (0xfffff000 < uVar1) {
    FUN_00019e38();
    FUN_00019e7c();
  }
  FUN_00019fe0();
  return;
}



void FUN_00018568(undefined8 param_1,int param_2,undefined8 param_3,ulong param_4,int param_5,
                 undefined8 param_6,undefined8 param_7,undefined8 param_8,undefined8 param_9,
                 ulong param_10,undefined8 *param_11)

{
  long lVar1;
  int iVar2;
  int *piVar3;
  undefined8 *puVar4;
  undefined auVar5 [16];
  undefined8 uStack_70;
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_10 < 0x41) {
    auVar5 = FUN_00009a98();
    if (auVar5._0_8_ == 0) {
      iVar2 = -0x16;
    }
    else {
      lVar1 = -((param_10 + 9) * 8 + 0xf & 0xfffffffffffffff0);
      *(long *)((long)&uStack_70 + lVar1) = (long)&uStack_70 + 4;
      *(long *)((long)&local_68 + lVar1) = (long)param_2;
      *(undefined8 *)(&stack0xffffffffffffffa0 + lVar1) = param_3;
      *(ulong *)(&stack0xffffffffffffffa8 + lVar1) = param_4 & 0xffffffff;
      *(long *)(&stack0xffffffffffffffb0 + lVar1) = (long)param_5;
      *(undefined8 *)(&stack0xffffffffffffffb8 + lVar1) = param_6;
      *(undefined8 *)(&stack0xffffffffffffffc0 + lVar1) = param_7;
      *(undefined8 *)(&stack0xffffffffffffffc8 + lVar1) = param_8;
      *(undefined8 *)(&stack0xffffffffffffffd0 + lVar1) = param_9;
      if (param_10 != 0) {
        puVar4 = (undefined8 *)(&stack0xffffffffffffffd8 + lVar1);
        do {
          *puVar4 = *param_11;
          param_10 = param_10 - 1;
          puVar4 = puVar4 + 1;
          param_11 = param_11 + 1;
        } while (param_10 != 0);
      }
      iVar2 = FUN_00019e40(auVar5._0_8_,auVar5._8_8_,"____target_q_connect",FUN_00019be4);
      if (iVar2 < 0) {
        piVar3 = ___error();
        uStack_70._4_4_ = -*piVar3;
      }
      FUN_00019f1c();
      iVar2 = uStack_70._4_4_;
    }
  }
  else {
    iVar2 = -7;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
    FUN_00019ea0();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(iVar2);
}



void _ahpl_mpq_listen(void)

{
  uint uVar1;
  
  uVar1 = FUN_000186d8();
  if (0xfffff000 < uVar1) {
    FUN_00019e38();
    FUN_00019e7c();
  }
  FUN_00019ef4();
  return;
}



void FUN_000186d8(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 ulong param_5,undefined8 *param_6)

{
  undefined8 uVar1;
  long lVar2;
  undefined8 *puVar3;
  ulong uVar4;
  undefined8 *local_50;
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  local_50 = param_6;
  if (param_5 < 0x41) {
    lVar2 = FUN_0000a4a4();
    if (lVar2 == 0) {
      uVar1 = 0xffffffff;
    }
    else {
      puVar3 = (undefined8 *)((long)&local_50 - (param_5 * 8 + 0xf & 0xfffffffffffffff0));
      uVar4 = param_5;
      if (param_5 != 0) {
        do {
          uVar1 = *local_50;
          local_50 = local_50 + 1;
          *puVar3 = uVar1;
          uVar4 = uVar4 - 1;
          puVar3 = puVar3 + 1;
        } while (uVar4 != 0);
      }
      uVar1 = FUN_00019c70(lVar2,param_1,param_2,param_3,param_4,param_5);
    }
  }
  else {
    uVar1 = 0xfffffff9;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_48) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar1);
  }
  FUN_00019df8();
  return;
}



void _ahpl_mpq_listen_on_q
               (undefined8 param_1,undefined8 param_2,int param_3,undefined8 param_4,
               undefined8 param_5,ulong param_6)

{
  undefined uVar1;
  int iVar2;
  int *piVar3;
  long lVar4;
  undefined4 *puVar5;
  long lVar6;
  undefined4 unaff_w19;
  long unaff_x20;
  undefined8 unaff_x21;
  undefined8 unaff_x22;
  undefined auVar7 [16];
  uint local_54;
  
  lVar6 = *(long *)PTR____stack_chk_guard_00028030;
  uVar1 = param_6 == 0x41;
  if (param_6 < 0x41) {
    FUN_00019f2c();
    lVar4 = FUN_00009a98();
    if (lVar4 == 0) {
      piVar3 = ___error();
      iVar2 = 0x16;
      goto LAB_0001887c;
    }
    auVar7 = FUN_00019e08();
    *(long *)(param_6 + 0x10) = (long)param_3;
    *(undefined8 *)(param_6 + 0x18) = unaff_x22;
    *(undefined8 *)(param_6 + 0x20) = unaff_x21;
    if (unaff_x20 != 0) {
      do {
        auVar7 = FUN_00019f00();
      } while (!(bool)uVar1);
    }
    iVar2 = FUN_00019e40(auVar7._0_8_,auVar7._8_8_,"____target_q_listen",FUN_000188ac);
    if (iVar2 < 0) {
      piVar3 = ___error();
      local_54 = -*piVar3;
    }
    FUN_00019f1c();
    if (local_54 < 0xfffff001) goto LAB_00018884;
    puVar5 = (undefined4 *)FUN_00019e38();
    *puVar5 = unaff_w19;
  }
  else {
    piVar3 = ___error();
    iVar2 = 7;
LAB_0001887c:
    *piVar3 = iVar2;
  }
  local_54 = 0xffffffff;
LAB_00018884:
  if (*(long *)PTR____stack_chk_guard_00028030 != lVar6) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(local_54);
  }
  FUN_00019df8();
  return;
}



void FUN_000188ac(undefined8 param_1,undefined8 param_2,long param_3,undefined8 *param_4)

{
  undefined4 uVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined4 *puVar6;
  
  puVar6 = (undefined4 *)*param_4;
  uVar3 = *(undefined4 *)(param_4 + 1);
  uVar1 = *(undefined4 *)(param_4 + 2);
  uVar4 = param_4[3];
  uVar5 = param_4[4];
  uVar2 = FUN_000090e4();
  uVar3 = FUN_00019c70(uVar2,uVar3,uVar1,uVar4,uVar5,param_3 + -5,param_4 + 5);
  *puVar6 = uVar3;
  return;
}



void _ahpl_mpq_add_dgram_socket(void)

{
  uint uVar1;
  
  uVar1 = FUN_00018954();
  if (0xfffff000 < uVar1) {
    FUN_00019e38();
    FUN_00019e7c();
  }
  FUN_00019ef4();
  return;
}



void FUN_00018954(void)

{
  undefined uVar1;
  undefined8 uVar2;
  long lVar3;
  ulong in_x4;
  undefined8 in_x5;
  undefined8 local_50;
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  uVar1 = in_x4 == 0x40;
  local_50 = in_x5;
  if (in_x4 < 0x41) {
    lVar3 = FUN_00019f9c();
    if (lVar3 == 0) {
      uVar2 = 0xffffffff;
    }
    else {
      FUN_00019e68(&local_50);
      if (in_x4 != 0) {
        do {
          FUN_00019eb8();
        } while (!(bool)uVar1);
      }
      uVar2 = FUN_00019f24();
    }
  }
  else {
    uVar2 = 0xfffffff9;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_48) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  FUN_00019df8();
  return;
}



void _ahpl_mpq_add_dgram_socket_on_q
               (undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5,ulong param_6)

{
  undefined uVar1;
  int iVar2;
  int *piVar3;
  long lVar4;
  undefined4 *puVar5;
  long lVar6;
  undefined4 unaff_w19;
  long unaff_x20;
  undefined8 unaff_x21;
  undefined8 unaff_x22;
  undefined auVar7 [16];
  uint local_54;
  
  lVar6 = *(long *)PTR____stack_chk_guard_00028030;
  uVar1 = param_6 == 0x41;
  if (param_6 < 0x41) {
    FUN_00019f2c();
    lVar4 = FUN_00009a98();
    if (lVar4 == 0) {
      piVar3 = ___error();
      iVar2 = 0x16;
      goto LAB_00018ae8;
    }
    auVar7 = FUN_00019e08();
    *(undefined8 *)(param_6 + 0x10) = param_3;
    *(undefined8 *)(param_6 + 0x18) = unaff_x22;
    *(undefined8 *)(param_6 + 0x20) = unaff_x21;
    if (unaff_x20 != 0) {
      do {
        auVar7 = FUN_00019f00();
      } while (!(bool)uVar1);
    }
    iVar2 = FUN_00019e40(auVar7._0_8_,auVar7._8_8_,"____target_q_add_dgram_sk",FUN_00018b18);
    if (iVar2 < 0) {
      piVar3 = ___error();
      local_54 = -*piVar3;
    }
    FUN_00019f1c();
    if (local_54 < 0xfffff001) goto LAB_00018af0;
    puVar5 = (undefined4 *)FUN_00019e38();
    *puVar5 = unaff_w19;
  }
  else {
    piVar3 = ___error();
    iVar2 = 7;
LAB_00018ae8:
    *piVar3 = iVar2;
  }
  local_54 = 0xffffffff;
LAB_00018af0:
  if (*(long *)PTR____stack_chk_guard_00028030 != lVar6) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(local_54);
  }
  FUN_00019df8();
  return;
}



void FUN_00018b18(void)

{
  undefined4 uVar1;
  undefined4 *unaff_x23;
  
  FUN_00019f54();
  FUN_000090e4();
  uVar1 = FUN_00019f24();
  *unaff_x23 = uVar1;
  FUN_00019e88();
  return;
}



void _ahpl_mpq_add_stream_socket(void)

{
  uint uVar1;
  
  uVar1 = FUN_00018bc0();
  if (0xfffff000 < uVar1) {
    FUN_00019e38();
    FUN_00019e7c();
  }
  FUN_00019ef4();
  return;
}



void FUN_00018bc0(void)

{
  undefined uVar1;
  undefined8 uVar2;
  long lVar3;
  ulong in_x5;
  undefined8 in_x6;
  undefined8 local_50;
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  uVar1 = in_x5 == 0x40;
  local_50 = in_x6;
  if (in_x5 < 0x41) {
    lVar3 = FUN_00019f9c();
    if (lVar3 == 0) {
      uVar2 = 0xffffffff;
    }
    else {
      FUN_00019e68(&local_50);
      if (in_x5 != 0) {
        do {
          FUN_00019eb8();
        } while (!(bool)uVar1);
      }
      uVar2 = FUN_00019f24();
    }
  }
  else {
    uVar2 = 0xfffffff9;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_48) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  FUN_00019df8();
  return;
}



void _ahpl_mpq_add_stream_socket_on_q
               (undefined8 param_1,int param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5,undefined8 param_6,ulong param_7)

{
  long lVar1;
  int iVar2;
  uint uVar3;
  int *piVar4;
  undefined4 *puVar5;
  undefined8 *puVar6;
  undefined auVar7 [16];
  long lStack_70;
  uint local_64;
  undefined8 *puVar8;
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_7 < 0x41) {
    auVar7 = FUN_00009a98();
    if (auVar7._0_8_ == 0) {
      piVar4 = ___error();
      iVar2 = 0x16;
      goto LAB_00018da8;
    }
    lVar1 = -((param_7 + 6) * 8 + 0xf & 0xfffffffffffffff0);
    *(undefined **)((long)&lStack_70 + lVar1) = &stack0xffffffffffffff98 + 4;
    *(long *)(&stack0xffffffffffffff98 + lVar1) = (long)param_2;
    *(undefined8 *)(&stack0xffffffffffffffa0 + lVar1) = param_3;
    *(undefined8 *)((long)&local_58 + lVar1) = param_4;
    *(undefined8 *)(&stack0xffffffffffffffb0 + lVar1) = param_5;
    *(undefined8 *)(&stack0xffffffffffffffb8 + lVar1) = param_6;
    if (param_7 != 0) {
      puVar6 = (undefined8 *)(&stack0xffffffffffffffc0 + lVar1);
      puVar8 = (undefined8 *)register0x00000008;
      do {
        *puVar6 = *puVar8;
        param_7 = param_7 - 1;
        puVar6 = puVar6 + 1;
        puVar8 = puVar8 + 1;
      } while (param_7 != 0);
    }
    iVar2 = FUN_00019e40(auVar7._0_8_,auVar7._8_8_,"____target_q_add_stream_sk",FUN_00018de8);
    if (iVar2 < 0) {
      piVar4 = ___error();
      local_64 = -*piVar4;
    }
    FUN_00019f1c();
    uVar3 = local_64;
    if (local_64 < 0xfffff001) goto LAB_00018db0;
    puVar5 = (undefined4 *)FUN_00019e38();
    *puVar5 = auVar7._0_4_;
  }
  else {
    piVar4 = ___error();
    iVar2 = 7;
LAB_00018da8:
    *piVar4 = iVar2;
  }
  uVar3 = 0xffffffff;
LAB_00018db0:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_58) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar3);
}



void FUN_00018de8(void)

{
  undefined4 uVar1;
  undefined4 *unaff_x23;
  
  FUN_00019f54();
  FUN_000090e4();
  uVar1 = FUN_00019f24();
  *unaff_x23 = uVar1;
  FUN_00019e88();
  return;
}



ulong _ahpl_send(void)

{
  int iVar1;
  long lVar2;
  int *piVar3;
  long lVar4;
  ulong unaff_x20;
  ulong uVar5;
  ulong local_78;
  ulong *local_70;
  
  lVar4 = *(long *)PTR____stack_chk_guard_00028030;
  lVar2 = FUN_00019fec();
  if (lVar2 != 0) {
    lVar2 = FUN_00019fbc();
    if (lVar2 != 0) {
      local_70 = &local_78;
      iVar1 = FUN_0000aed4(lVar2,0xffffffff,"____target_q_send",FUN_00018f44,5,&local_70);
      if (iVar1 < 0) {
        piVar3 = ___error();
        local_78 = -(long)*piVar3;
      }
      FUN_00009ba0(lVar2);
    }
    FUN_00019f88();
    unaff_x20 = local_78;
    uVar5 = local_78;
    if (local_78 < 0xfffffffffffff001) goto LAB_00018f0c;
  }
  piVar3 = ___error();
  *piVar3 = -(int)unaff_x20;
  uVar5 = 0xffffffffffffffff;
LAB_00018f0c:
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar4) {
    return uVar5;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00018f44(void)

{
  undefined8 *puVar1;
  int iVar2;
  bool bVar3;
  ulong uVar4;
  undefined8 *puVar5;
  int *piVar6;
  ulong **in_x3;
  ulong *puVar7;
  ulong *puVar8;
  size_t sVar9;
  ulong **ppuVar10;
  ulong *puVar11;
  
  ppuVar10 = (ulong **)*in_x3;
  puVar7 = in_x3[3];
  bVar3 = 0x7ffffff < puVar7;
  if (puVar7 < (ulong *)0x8000001) {
    puVar11 = in_x3[1];
    FUN_00019fa8(puVar11[0xf]);
    if (bVar3) {
      puVar8 = in_x3[2];
      iVar2 = *(int *)(in_x3 + 4);
      if ((puVar11[0xc] == 0) && ((*(byte *)(puVar11 + 5) & 1) == 0)) {
        uVar4 = _send(*(int *)puVar11,puVar8,(size_t)puVar7,iVar2);
        if ((long)uVar4 < 1) {
          piVar6 = ___error();
          puVar7 = (ulong *)-(long)*piVar6;
          goto LAB_0001905c;
        }
        if (puVar7 <= uVar4) goto LAB_0001905c;
      }
      else {
        uVar4 = 0;
      }
      sVar9 = (long)puVar7 - uVar4;
      puVar5 = (undefined8 *)_ahpl_malloc(sVar9 + 0x27 & 0xfffffffffffffff8 | 4);
      if (puVar5 == (undefined8 *)0x0) {
        puVar7 = (ulong *)0xfffffffffffffff4;
      }
      else {
        puVar1 = puVar5 + 4;
        _memcpy(puVar1,(void *)((long)puVar8 + uVar4),sVar9);
        puVar5[1] = puVar1;
        puVar5[2] = (long)puVar1 + sVar9;
        puVar5[3] = 4;
        *(int *)((long)puVar1 + sVar9 + 7 & 0xfffffffffffffff8) = iVar2;
        *puVar5 = 0;
        puVar8 = puVar11 + 0xc;
        if ((ulong *)puVar11[0xd] != (ulong *)0x0) {
          puVar8 = (ulong *)puVar11[0xd];
        }
        *puVar8 = (ulong)puVar5;
        puVar11[0xd] = (ulong)puVar5;
        puVar11[0xe] = puVar11[0xe] + 1;
        puVar11[0xf] = puVar11[0xf] + sVar9;
      }
    }
    else {
      puVar7 = (ulong *)0xffffffffffffffdd;
    }
  }
  else {
    puVar7 = (ulong *)0xffffffffffffffd8;
  }
LAB_0001905c:
  *ppuVar10 = puVar7;
  return;
}



ulong _ahpl_sendto(void)

{
  int iVar1;
  long lVar2;
  int *piVar3;
  long lVar4;
  ulong unaff_x20;
  ulong uVar5;
  ulong local_98;
  ulong *local_90;
  
  lVar4 = *(long *)PTR____stack_chk_guard_00028030;
  lVar2 = FUN_00019fec();
  if (lVar2 != 0) {
    lVar2 = FUN_00019fbc();
    if (lVar2 != 0) {
      local_90 = &local_98;
      iVar1 = FUN_0000aed4(lVar2,0xffffffff,"____target_q_sendto",FUN_00019194,7,&local_90);
      if (iVar1 < 0) {
        piVar3 = ___error();
        local_98 = -(long)*piVar3;
      }
      FUN_00009ba0(lVar2);
    }
    FUN_00019f88();
    unaff_x20 = local_98;
    uVar5 = local_98;
    if (local_98 < 0xfffffffffffff001) goto LAB_00019158;
  }
  piVar3 = ___error();
  *piVar3 = -(int)unaff_x20;
  uVar5 = 0xffffffffffffffff;
LAB_00019158:
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar4) {
    return uVar5;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00019194(void)

{
  undefined8 *puVar1;
  int iVar2;
  bool bVar3;
  ulong uVar4;
  undefined8 *puVar5;
  ulong **in_x3;
  ulong *puVar6;
  socklen_t sVar7;
  ulong *puVar8;
  ulong **ppuVar9;
  ulong *puVar10;
  int *piVar11;
  size_t sVar12;
  ulong *puVar13;
  sockaddr *psVar14;
  
  ppuVar9 = (ulong **)*in_x3;
  puVar6 = in_x3[3];
  bVar3 = 0x7ffffff < puVar6;
  if (puVar6 < (ulong *)0x8000001) {
    puVar10 = in_x3[1];
    FUN_00019fa8(puVar10[0xf]);
    if (bVar3) {
      puVar13 = in_x3[2];
      iVar2 = *(int *)(in_x3 + 4);
      psVar14 = (sockaddr *)in_x3[5];
      puVar8 = in_x3[6];
      sVar7 = (socklen_t)puVar8;
      if ((puVar10[0xc] == 0) && ((*(byte *)(puVar10 + 5) & 1) == 0)) {
        uVar4 = _sendto(*(int *)puVar10,puVar13,(size_t)puVar6,iVar2,psVar14,sVar7);
        if ((long)uVar4 < 1) {
          piVar11 = ___error();
          puVar6 = (ulong *)-(long)*piVar11;
          goto LAB_000192e0;
        }
        if (puVar6 <= uVar4) goto LAB_000192e0;
      }
      else {
        uVar4 = 0;
      }
      sVar12 = (long)puVar6 - uVar4;
      puVar5 = (undefined8 *)_ahpl_malloc(sVar12 + 0xb7 & 0xfffffffffffffff8);
      if (puVar5 == (undefined8 *)0x0) {
        puVar6 = (ulong *)0xfffffffffffffff4;
      }
      else {
        puVar1 = puVar5 + 4;
        _memcpy(puVar1,(void *)((long)puVar13 + uVar4),sVar12);
        puVar5[1] = puVar1;
        puVar5[2] = (long)puVar1 + sVar12;
        puVar5[3] = 0x90;
        piVar11 = (int *)((long)puVar1 + sVar12 + 7 & 0xfffffffffffffff8);
        *piVar11 = iVar2;
        _memcpy(piVar11 + 2,psVar14,(ulong)puVar8 & 0xffffffff);
        piVar11[0x22] = sVar7;
        *puVar5 = 0;
        puVar8 = puVar10 + 0xc;
        if ((ulong *)puVar10[0xd] != (ulong *)0x0) {
          puVar8 = (ulong *)puVar10[0xd];
        }
        *puVar8 = (ulong)puVar5;
        puVar10[0xd] = (ulong)puVar5;
        puVar10[0xe] = puVar10[0xe] + 1;
        puVar10[0xf] = (puVar5[2] - (long)puVar1) + puVar10[0xf];
      }
    }
    else {
      puVar6 = (ulong *)0xffffffffffffffdd;
    }
  }
  else {
    puVar6 = (ulong *)0xffffffffffffffd8;
  }
LAB_000192e0:
  *ppuVar9 = puVar6;
  FUN_00019e4c();
  return;
}



undefined8 _ahpl_ip_sk_addr_init_with_port(undefined8 *param_1,int param_2,uint param_3)

{
  int *piVar1;
  
  if (param_2 == 0x1e) {
    *param_1 = 0;
    param_1[1] = 0;
    *(undefined4 *)(param_1 + 3) = 0;
    param_1[2] = 0;
  }
  else {
    if (param_2 != 2) {
      piVar1 = ___error();
      *piVar1 = 0x16;
      return 0xffffffff;
    }
    *param_1 = 0;
    param_1[1] = 0;
  }
  *(ushort *)((long)param_1 + 2) =
       (ushort)(param_3 >> 8) & 0xff | (ushort)((param_3 & 0xff00ff) << 8);
  *(char *)((long)param_1 + 1) = (char)param_2;
  return 0;
}



void _ahpl_ip_sk_bind_port_only(int param_1,int param_2,uint param_3)

{
  int iVar1;
  int *piVar2;
  socklen_t sVar3;
  sockaddr local_98;
  undefined8 local_88;
  undefined4 local_80;
  long local_18;
  
  local_18 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_2 == 0x1e) {
    local_98.sa_len = '\0';
    local_98.sa_data[6] = '\0';
    local_98.sa_data[7] = '\0';
    local_98.sa_data[8] = '\0';
    local_98.sa_data[9] = '\0';
    local_98.sa_data[10] = '\0';
    local_98.sa_data[11] = '\0';
    local_98.sa_data[12] = '\0';
    local_98.sa_data[13] = '\0';
    local_80 = 0;
    sVar3 = 0x1c;
    local_88 = 0;
  }
  else {
    if (param_2 != 2) {
      piVar2 = ___error();
      *piVar2 = 0x16;
      iVar1 = -1;
      goto LAB_000193cc;
    }
    sVar3 = 0x10;
  }
  local_98._0_2_ = CONCAT11((sa_family_t)param_2,local_98.sa_len);
  local_98._0_8_ =
       ZEXT48(CONCAT22((ushort)(param_3 >> 8) & 0xff | (ushort)((param_3 & 0xff00ff) << 8),
                       local_98._0_2_));
  iVar1 = _bind(param_1,&local_98,sVar3);
LAB_000193cc:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_18) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(iVar1);
}



void _ahpl_ip_addr_init(long param_1)

{
  *(undefined *)(param_1 + 1) = 0;
  *(undefined *)(param_1 + 0x11) = 0;
  return;
}



void _ahpl_ip_sk_bind(int *param_1,sockaddr *param_2)

{
  int iVar1;
  uint uVar2;
  
  if ((*param_1 < 0) || (param_2->sa_family == '\0')) {
    uVar2 = 0;
  }
  else {
    iVar1 = _bind(*param_1,param_2,0x10);
    uVar2 = (uint)(iVar1 == 0);
  }
  if (((-1 < param_1[1]) && (param_2[1].sa_family != '\0')) &&
     (iVar1 = _bind(param_1[1],param_2 + 1,0x1c), iVar1 == 0)) {
    uVar2 = uVar2 + 1;
  }
  if (uVar2 == 0) {
    uVar2 = 0xffffffff;
  }
  FUN_00019ee8(uVar2);
  return;
}



void _ahpl_mpq_ip_sk_connect(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  char cVar1;
  int iVar2;
  uint uVar3;
  undefined4 uVar4;
  int *piVar5;
  undefined auVar6 [16];
  undefined auStack_d8 [128];
  long local_58;
  
  auVar6 = FUN_00019f2c();
  piVar5 = auVar6._0_8_;
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  cVar1 = *(char *)(auVar6._8_8_ + 1);
  if (cVar1 == '\x1e') {
    auVar6._8_8_ = auVar6._8_8_;
    auVar6._0_8_ = piVar5 + 1;
    if (piVar5[1] < 0) {
      if ((*piVar5 < 0) || (iVar2 = FUN_0001a10c(auStack_d8), iVar2 < 0)) goto LAB_00019560;
LAB_00019514:
      auVar6._8_8_ = auStack_d8;
      auVar6._0_8_ = piVar5;
    }
LAB_00019518:
    uVar4 = 0x1c;
    if (*(char *)(auVar6._8_8_ + 1) != '\x1e') {
      uVar4 = 0x10;
    }
    FUN_00019f78(*auVar6._0_8_,auVar6._8_8_,uVar4,param_3);
    uVar3 = FUN_00018440();
    if (uVar3 < 0xfffff001) goto LAB_00019568;
  }
  else if (cVar1 == '\x02') {
    if (-1 < *piVar5) goto LAB_00019518;
    piVar5 = piVar5 + 1;
    if ((-1 < *piVar5) && (iVar2 = FUN_0001a028(auStack_d8), -1 < iVar2)) goto LAB_00019514;
  }
LAB_00019560:
  ___error();
  FUN_00019e7c();
LAB_00019568:
  if (*(long *)PTR____stack_chk_guard_00028030 != local_58) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  return;
}



void _ahpl_mpq_ip_sk_connect_on_q(undefined8 param_1,undefined8 param_2,long param_3)

{
  int iVar1;
  uint uVar2;
  int *piVar3;
  int *piVar4;
  undefined auVar5 [16];
  undefined auStack_d8 [128];
  long local_58;
  
  auVar5 = FUN_00019f3c();
  piVar3 = auVar5._8_8_;
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  if (*(char *)(param_3 + 1) == '\x1e') {
    piVar4 = piVar3 + 1;
    if (*piVar4 < 0) {
      if (-1 < *piVar3) {
        iVar1 = FUN_0001a10c(auStack_d8,param_3);
        piVar4 = piVar3;
joined_r0x00019638:
        if (-1 < iVar1) goto LAB_00019640;
      }
    }
    else {
LAB_00019640:
      FUN_00019f78(auVar5._0_8_,*piVar4);
      uVar2 = FUN_00018568();
      if (uVar2 < 0xfffff001) goto LAB_00019698;
    }
  }
  else if (*(char *)(param_3 + 1) == '\x02') {
    piVar4 = piVar3;
    if (-1 < *piVar3) goto LAB_00019640;
    piVar4 = piVar3 + 1;
    if (-1 < *piVar4) {
      iVar1 = FUN_0001a028(auStack_d8,param_3);
      goto joined_r0x00019638;
    }
  }
  ___error();
  FUN_00019e7c();
LAB_00019698:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_58) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void _ahpl_ipv6_sk_addr_from_ipv4(undefined8 param_1,long param_2)

{
  long lVar1;
  undefined8 *puVar2;
  undefined8 *puVar3;
  undefined8 uVar4;
  undefined8 *unaff_x19;
  
  lVar1 = FUN_0001a32c();
  if (lVar1 == 0) {
    puVar2 = (undefined8 *)0x0;
  }
  else {
    puVar2 = *(undefined8 **)(lVar1 + 0xb8);
  }
  unaff_x19[2] = 0;
  *(undefined4 *)(unaff_x19 + 3) = 0;
  *unaff_x19 = &DAT_00001e1c;
  puVar3 = unaff_x19 + 1;
  *puVar3 = 0;
  *(undefined2 *)((long)unaff_x19 + 2) = *(undefined2 *)(param_2 + 2);
  if (puVar2 == (undefined8 *)0x0) {
    *puVar3 = 0;
    unaff_x19[2] = 0;
    *(undefined2 *)((long)unaff_x19 + 9) = 0xff64;
    *(undefined *)((long)unaff_x19 + 0xb) = 0x9b;
  }
  else {
    uVar4 = *puVar2;
    *(undefined4 *)(unaff_x19 + 2) = *(undefined4 *)(puVar2 + 1);
    *puVar3 = uVar4;
  }
  *(undefined4 *)((long)unaff_x19 + 0x14) = *(undefined4 *)(param_2 + 4);
  FUN_0001a324(0);
  return;
}



void _ahpl_ipv6_sk_addr_to_ipv4(undefined8 *param_1,long param_2)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  int extraout_w8;
  
  if (*(char *)(param_2 + 1) == '\x02') {
LAB_0001a17c:
    uVar3 = 0;
    *param_1 = 0x210;
    param_1[1] = 0;
    *(undefined2 *)((long)param_1 + 2) = *(undefined2 *)(param_2 + 2);
    *(undefined4 *)((long)param_1 + 4) = *(undefined4 *)(param_2 + 0x14);
  }
  else {
    if (*(char *)(param_2 + 1) == '\x1e') {
      lVar2 = FUN_000090e4();
      if ((lVar2 != 0) && (*(void **)(lVar2 + 0xb8) != (void *)0x0)) {
        iVar1 = _memcmp((void *)(param_2 + 8),*(void **)(lVar2 + 0xb8),0xc);
        if (iVar1 == 0) goto LAB_0001a17c;
      }
      if (((*(uint *)(param_2 + 0xc) | *(uint *)(param_2 + 8) |
           *(uint *)(param_2 + 0x10) ^ 0xffff0000) == 0) || (FUN_0001a2fc(), extraout_w8 == 0))
      goto LAB_0001a17c;
    }
    uVar3 = 0xffffffff;
  }
  FUN_0001a324(uVar3);
  return;
}



void _ahpl_ip_sk_sendto(int *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                       undefined *param_5)

{
  int iVar1;
  int *piVar2;
  undefined8 uVar3;
  undefined4 uVar4;
  undefined auStack_b8 [128];
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_5[1] == '\x1e') {
    piVar2 = param_1 + 1;
    if (*piVar2 < 0) {
      if ((*param_1 < 0) || (iVar1 = FUN_0001a10c(auStack_b8,param_5), iVar1 < 0))
      goto LAB_000197a0;
LAB_00019770:
      param_5 = auStack_b8;
      piVar2 = param_1;
    }
LAB_00019774:
    uVar4 = 0x1c;
    if (param_5[1] != '\x1e') {
      uVar4 = 0x10;
    }
    uVar3 = _ahpl_sendto(*piVar2,param_2,param_3,param_4,param_5,uVar4);
  }
  else {
    if (param_5[1] == '\x02') {
      piVar2 = param_1;
      if (-1 < *param_1) goto LAB_00019774;
      param_1 = param_1 + 1;
      if ((-1 < *param_1) && (iVar1 = FUN_0001a028(auStack_b8,param_5), -1 < iVar1))
      goto LAB_00019770;
    }
LAB_000197a0:
    piVar2 = ___error();
    *piVar2 = 0x16;
    uVar3 = 0xffffffffffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 != local_38) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar3);
  }
  return;
}



void _ahpl_ip_sk_close(int *param_1)

{
  if (-1 < *param_1) {
    FUN_000071c0();
    *param_1 = -1;
  }
  if (-1 < param_1[1]) {
    FUN_000071c0();
    param_1[1] = -1;
  }
  return;
}



void _ahpl_inet_addr_str(undefined8 param_1,void *param_2,char *param_3,socklen_t param_4)

{
  int iVar1;
  
  iVar1 = (int)param_1;
  if ((iVar1 == 0x1e) || (iVar1 == 2)) {
    _inet_ntop(iVar1,param_2,param_3,param_4);
  }
  else {
    FUN_00019f90(param_1,param_2,"<Unknown af %d>");
  }
  FUN_00019fd4(param_3);
  return;
}



void _ahpl_ip_sk_addr_str(long param_1,char *param_2,socklen_t param_3)

{
  int iVar1;
  void *pvVar2;
  
  if (*(char *)(param_1 + 1) == '\x1e') {
    pvVar2 = (void *)(param_1 + 8);
    iVar1 = 0x1e;
  }
  else {
    if (*(char *)(param_1 + 1) != '\x02') {
      FUN_00019f90(param_1,param_2,"<Unknown af %d>");
      goto LAB_000198cc;
    }
    pvVar2 = (void *)(param_1 + 4);
    iVar1 = 2;
  }
  _inet_ntop(iVar1,pvVar2,param_2,param_3);
LAB_000198cc:
  FUN_00019fd4(param_2);
  return;
}



uint _ahpl_ip_sk_addr_port(long param_1)

{
  if (*(char *)(param_1 + 1) == '\x1e' || *(char *)(param_1 + 1) == '\x02') {
    return (uint)(*(ushort *)(param_1 + 2) >> 8) | (*(ushort *)(param_1 + 2) & 0xff00ff) << 8;
  }
  return 0;
}



bool _ahpl_sk_addr_ip_equal(long param_1,long param_2)

{
  char cVar1;
  int iVar2;
  
  cVar1 = *(char *)(param_1 + 1);
  if (cVar1 == *(char *)(param_2 + 1)) {
    if (cVar1 == '\0') {
      return true;
    }
    if (cVar1 == '\x1e') {
      iVar2 = _memcmp((void *)(param_1 + 8),(void *)(param_2 + 8),0x10);
      return iVar2 == 0;
    }
    if (cVar1 == '\x02') {
      return *(int *)(param_1 + 4) == *(int *)(param_2 + 4);
    }
  }
  return false;
}



undefined4 _ahpl_sk_addr_len(long param_1)

{
  undefined4 uVar1;
  char cVar2;
  undefined4 uVar3;
  
  cVar2 = *(char *)(param_1 + 1);
  uVar3 = 0;
  if (cVar2 == '\x1e') {
    uVar3 = 0x1c;
  }
  uVar1 = 0x10;
  if (cVar2 != '\x02') {
    uVar1 = uVar3;
  }
  uVar3 = 0x6a;
  if (cVar2 != '\x01') {
    uVar3 = uVar1;
  }
  return uVar3;
}



void _ahpl_inet_addr_from_string(void *param_1,char *param_2)

{
  int iVar1;
  long lVar2;
  undefined4 uVar3;
  
  lVar2 = FUN_00019fc8();
  iVar1 = 2;
  if (lVar2 != 0) {
    iVar1 = 0x1e;
  }
  uVar3 = 4;
  if (lVar2 != 0) {
    uVar3 = 0x10;
  }
  iVar1 = _inet_pton(iVar1,param_2,param_1);
  if (iVar1 != 1) {
    uVar3 = 0;
  }
  FUN_00019ee8(uVar3);
  return;
}



void _ahpl_ip_sk_addr_from_string(undefined8 *param_1,char *param_2,uint param_3)

{
  ushort uVar1;
  int iVar2;
  long lVar3;
  undefined8 uVar4;
  
  lVar3 = FUN_00019fc8();
  uVar1 = (ushort)(param_3 >> 8);
  if (lVar3 == 0) {
    *param_1 = 0;
    param_1[1] = 0;
    iVar2 = _inet_pton(2,param_2,(void *)((long)param_1 + 4));
    if (iVar2 == 1) {
      *(undefined2 *)param_1 = 0x210;
      *(ushort *)((long)param_1 + 2) = uVar1 & 0xff | (ushort)((param_3 & 0xff00ff) << 8);
      uVar4 = 0x10;
    }
    else {
      uVar4 = 0;
    }
  }
  else {
    *param_1 = 0;
    *(undefined4 *)(param_1 + 3) = 0;
    param_1[2] = 0;
    param_1[1] = 0;
    iVar2 = _inet_pton(0x1e,param_2,param_1 + 1);
    uVar4 = 0;
    if (iVar2 == 1) {
      *(undefined2 *)param_1 = 0x1e1c;
      *(ushort *)((long)param_1 + 2) = uVar1 & 0xff | (ushort)((param_3 & 0xff00ff) << 8);
      uVar4 = 0x1c;
    }
  }
  FUN_00019ee8(uVar4);
  return;
}



void FUN_00019a98(undefined8 param_1,undefined8 param_2,sockaddr *param_3,socklen_t param_4,
                 undefined8 param_5,undefined8 param_6,undefined8 param_7,undefined8 param_8,
                 undefined8 param_9,undefined8 param_10_00,undefined8 param_10)

{
  uint uVar1;
  int iVar2;
  ulong uVar3;
  long lVar4;
  undefined8 uVar5;
  uint *puVar6;
  
  uVar3 = FUN_000067f0(param_1,param_2,param_5,param_6,0,1,FUN_00019b7c,FUN_00019ba0,param_7,0,
                       param_8,param_9,param_10_00,param_10);
  if (-1 < (int)uVar3) {
    iVar2 = _connect((int)param_2,param_3,param_4);
    if (iVar2 < 0) {
      puVar6 = (uint *)___error();
      uVar3 = 0;
      uVar1 = *puVar6;
      if ((uVar1 != 0x24 && uVar1 != 0) && uVar1 < 0x80000000) {
        uVar3 = (ulong)-uVar1;
        FUN_00006fa4(param_1,param_2);
      }
    }
    else {
      lVar4 = FUN_00006254(param_2);
      if (lVar4 != 0) {
        uVar5 = FUN_000090e4();
        FUN_00006674(uVar5,lVar4);
        FUN_00019f88();
      }
      uVar3 = 0;
    }
  }
  FUN_00019ed4(uVar3);
  return;
}



void FUN_00019b7c(int param_1,void *param_2,size_t param_3)

{
  ssize_t sVar1;
  
  sVar1 = _recv(param_1,param_2,param_3,0x80);
  if (sVar1 < 0) {
    ___error();
    FUN_00019f6c();
  }
  return;
}



void FUN_00019ba0(int param_1,void *param_2,size_t param_3,ulong param_4)

{
  ssize_t sVar1;
  uint uVar2;
  
  if (param_4 < 4) {
    uVar2 = 0x80;
  }
  else {
    uVar2 = *(uint *)((long)param_2 + param_3 + 7 & 0xfffffffffffffff8) | 0x80;
  }
  sVar1 = _send(param_1,param_2,param_3,uVar2);
  if (sVar1 < 0) {
    ___error();
    FUN_00019f6c();
  }
  return;
}



void FUN_00019be4(undefined8 param_1,undefined8 param_2,long param_3,undefined8 *param_4)

{
  undefined4 uVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 *puVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  
  puVar5 = (undefined4 *)*param_4;
  uVar4 = *(undefined4 *)(param_4 + 1);
  uVar6 = param_4[2];
  uVar1 = *(undefined4 *)(param_4 + 3);
  uVar2 = *(undefined4 *)(param_4 + 4);
  uVar7 = param_4[5];
  uVar8 = param_4[6];
  uVar9 = param_4[7];
  uVar10 = param_4[8];
  uVar3 = FUN_000090e4();
  uVar4 = FUN_00019a98(uVar3,uVar4,uVar6,uVar1,uVar2,uVar7,uVar8,uVar9,uVar10,param_3 + -9,
                       param_4 + 9);
  *puVar5 = uVar4;
  FUN_00019e4c();
  return;
}



void FUN_00019c70(undefined8 param_1,undefined8 param_2,int param_3,undefined8 param_4,
                 undefined8 param_5,undefined8 param_6,undefined8 param_7)

{
  int iVar1;
  ulong uVar2;
  int *piVar3;
  
  iVar1 = _listen((int)param_2,param_3);
  if (iVar1 < 0) {
    piVar3 = ___error();
    uVar2 = (ulong)(uint)-*piVar3;
  }
  else {
    uVar2 = FUN_000067f0(param_1,param_2,0xffffffff,0x90,0,2,FUN_00019cfc,0,0,0,param_4,param_5,
                         param_6,param_7);
  }
  FUN_00019ed4(uVar2);
  return;
}



undefined8 FUN_00019cfc(int param_1,int *param_2)

{
  int iVar1;
  undefined8 uVar2;
  
  param_2[0x22] = 0x80;
  iVar1 = _accept(param_1,(sockaddr *)(param_2 + 2),(socklen_t *)(param_2 + 0x22));
  *param_2 = iVar1;
  if (iVar1 < 0) {
    ___error();
    uVar2 = FUN_00019f6c();
  }
  else {
    uVar2 = 0x90;
  }
  return uVar2;
}



void FUN_00019d44(int param_1,void *param_2,size_t param_3,ulong param_4)

{
  long lVar1;
  sockaddr *psVar2;
  sockaddr *psVar3;
  
  if (param_4 < 0x88) {
    lVar1 = _recv(param_1,param_2,param_3,0x80);
  }
  else {
    psVar2 = (sockaddr *)((long)param_2 + param_3 + 7 & 0xfffffffffffffff8);
    psVar3 = psVar2 + 8;
    psVar3->sa_len = 0x80;
    psVar3->sa_family = '\0';
    psVar3->sa_data[0] = '\0';
    psVar3->sa_data[1] = '\0';
    lVar1 = _recvfrom(param_1,param_2,param_3,0x80,psVar2,(socklen_t *)psVar3);
  }
  if (lVar1 < 0) {
    ___error();
    FUN_00019f6c();
  }
  return;
}



void FUN_00019d98(int param_1,void *param_2,size_t param_3,ulong param_4)

{
  long lVar1;
  uint uVar2;
  uint *puVar3;
  
  if (param_4 < 4) {
    uVar2 = 0x80;
  }
  else {
    puVar3 = (uint *)((long)param_2 + param_3 + 7 & 0xfffffffffffffff8);
    uVar2 = *puVar3 | 0x80;
    if (0x8f < param_4) {
      lVar1 = _sendto(param_1,param_2,param_3,uVar2,(sockaddr *)(puVar3 + 2),puVar3[0x22]);
      goto joined_r0x00019de4;
    }
  }
  lVar1 = _send(param_1,param_2,param_3,uVar2);
joined_r0x00019de4:
  if (lVar1 < 0) {
    ___error();
    FUN_00019f6c();
  }
  return;
}



void FUN_00019df8(void)

{
  return;
}



void FUN_00019e08(void)

{
  long unaff_x20;
  int unaff_w24;
  long unaff_x29;
  
  *(long *)(&stack0x00000000 + -((unaff_x20 + 5) * 8 + 0xfU & 0xfffffffffffffff0)) =
       unaff_x29 + -0x44;
  *(long *)((long)(&stack0x00000000 + -((unaff_x20 + 5) * 8 + 0xfU & 0xfffffffffffffff0)) + 8) =
       (long)unaff_w24;
  return;
}



void FUN_00019e38(void)

{
  ___error();
  return;
}



void FUN_00019e40(void)

{
  FUN_0000aed4();
  return;
}



void FUN_00019e4c(void)

{
  return;
}



void FUN_00019e68(void)

{
  return;
}



undefined8 FUN_00019e7c(undefined4 *param_1)

{
  undefined4 unaff_w19;
  
  *param_1 = unaff_w19;
  return 0xffffffff;
}



void FUN_00019e88(void)

{
  return;
}



void FUN_00019ea0(void)

{
  return;
}



void FUN_00019eb8(void)

{
  undefined8 *in_x9;
  undefined8 *puVar1;
  long unaff_x29;
  
  puVar1 = *(undefined8 **)(unaff_x29 + -0x40);
  *(undefined8 **)(unaff_x29 + -0x40) = puVar1 + 1;
  *in_x9 = *puVar1;
  return;
}



void FUN_00019ed4(void)

{
  return;
}



void FUN_00019ee8(void)

{
  return;
}



void FUN_00019ef4(void)

{
  return;
}



void FUN_00019f00(undefined8 *param_1)

{
  undefined8 *puVar1;
  long unaff_x29;
  
  puVar1 = *(undefined8 **)(unaff_x29 + -0x40);
  *(undefined8 **)(unaff_x29 + -0x40) = puVar1 + 1;
  *param_1 = *puVar1;
  return;
}



void FUN_00019f1c(void)

{
  FUN_00009b28();
  return;
}



void FUN_00019f24(void)

{
  FUN_000067f0();
  return;
}



void FUN_00019f2c(void)

{
  return;
}



void FUN_00019f3c(void)

{
  return;
}



void FUN_00019f54(void)

{
  return;
}



long FUN_00019f6c(int *param_1)

{
  return -(long)*param_1;
}



void FUN_00019f78(void)

{
  return;
}



void FUN_00019f88(void)

{
  FUN_000062d4();
  return;
}



int FUN_00019f90(undefined8 param_1,undefined8 param_2,char *param_3,size_t param_4)

{
  int iVar1;
  char *unaff_x19;
  
  iVar1 = _snprintf(unaff_x19,param_4,param_3);
  return iVar1;
}



void FUN_00019f9c(void)

{
  FUN_0000a4a4();
  return;
}



void FUN_00019fa8(void)

{
  return;
}



void FUN_00019fbc(long param_1)

{
  FUN_00009b40(*(undefined4 *)(param_1 + 0x30));
  return;
}



void FUN_00019fc8(undefined8 param_1,char *param_2)

{
  _strchr(param_2,0x3a);
  return;
}



void FUN_00019fd4(void)

{
  return;
}



void FUN_00019fe0(void)

{
  return;
}



void FUN_00019fec(void)

{
  undefined8 param_10;
  
  param_10 = 0xfffffffffffffff7;
  FUN_00006254();
  return;
}



void _ahpl_ipv6_addr_v4_mapped(uint *param_1)

{
  FUN_0001a314(param_1[1] | *param_1);
  return;
}



void _ahpl_ipv6_addr_nat64(uint *param_1)

{
  FUN_0001a314(*param_1 ^ 0x9bff6400 | param_1[1]);
  return;
}



void FUN_0001a028(undefined8 param_1,long param_2)

{
  long lVar1;
  undefined8 *puVar2;
  undefined8 *puVar3;
  undefined8 uVar4;
  undefined8 *unaff_x19;
  
  lVar1 = FUN_0001a32c();
  if (lVar1 == 0) {
    puVar2 = (undefined8 *)0x0;
  }
  else {
    puVar2 = *(undefined8 **)(lVar1 + 0xb8);
  }
  unaff_x19[2] = 0;
  *(undefined4 *)(unaff_x19 + 3) = 0;
  *unaff_x19 = &DAT_00001e1c;
  puVar3 = unaff_x19 + 1;
  *puVar3 = 0;
  *(undefined2 *)((long)unaff_x19 + 2) = *(undefined2 *)(param_2 + 2);
  if (puVar2 == (undefined8 *)0x0) {
    *puVar3 = 0;
    unaff_x19[2] = 0;
    *(undefined2 *)((long)unaff_x19 + 9) = 0xff64;
    *(undefined *)((long)unaff_x19 + 0xb) = 0x9b;
  }
  else {
    uVar4 = *puVar2;
    *(undefined4 *)(unaff_x19 + 2) = *(undefined4 *)(puVar2 + 1);
    *puVar3 = uVar4;
  }
  *(undefined4 *)((long)unaff_x19 + 0x14) = *(undefined4 *)(param_2 + 4);
  FUN_0001a324(0);
  return;
}



void _ahpl_ipv6_addr_v4_compatible(void)

{
  bool bVar1;
  int iVar2;
  long lVar3;
  int extraout_w8;
  uint *unaff_x19;
  
  lVar3 = FUN_0001a32c();
  if ((lVar3 == 0) || (*(void **)(lVar3 + 0xb8) == (void *)0x0)) {
LAB_0001a0d8:
    if ((unaff_x19[1] | *unaff_x19 | unaff_x19[2] ^ 0xffff0000) != 0) {
      FUN_0001a2fc();
      bVar1 = extraout_w8 == 0;
      goto LAB_0001a104;
    }
  }
  else {
    iVar2 = _memcmp(unaff_x19,*(void **)(lVar3 + 0xb8),0xc);
    if (iVar2 != 0) goto LAB_0001a0d8;
  }
  bVar1 = true;
LAB_0001a104:
  FUN_0001a324(bVar1);
  return;
}



void FUN_0001a10c(undefined8 *param_1,long param_2)

{
  int iVar1;
  long lVar2;
  undefined8 uVar3;
  int extraout_w8;
  
  if (*(char *)(param_2 + 1) == '\x02') {
LAB_0001a17c:
    uVar3 = 0;
    *param_1 = 0x210;
    param_1[1] = 0;
    *(undefined2 *)((long)param_1 + 2) = *(undefined2 *)(param_2 + 2);
    *(undefined4 *)((long)param_1 + 4) = *(undefined4 *)(param_2 + 0x14);
  }
  else {
    if (*(char *)(param_2 + 1) == '\x1e') {
      lVar2 = FUN_000090e4();
      if ((lVar2 != 0) && (*(void **)(lVar2 + 0xb8) != (void *)0x0)) {
        iVar1 = _memcmp((void *)(param_2 + 8),*(void **)(lVar2 + 0xb8),0xc);
        if (iVar1 == 0) goto LAB_0001a17c;
      }
      if (((*(uint *)(param_2 + 0xc) | *(uint *)(param_2 + 8) |
           *(uint *)(param_2 + 0x10) ^ 0xffff0000) == 0) || (FUN_0001a2fc(), extraout_w8 == 0))
      goto LAB_0001a17c;
    }
    uVar3 = 0xffffffff;
  }
  FUN_0001a324(uVar3);
  return;
}



undefined8 _ahpl_mpq_set_ipv6_prefix_on_q(void)

{
  long lVar1;
  undefined8 uVar2;
  int *piVar3;
  long unaff_x19;
  
  lVar1 = FUN_00009a98();
  if (lVar1 == 0) {
    piVar3 = ___error();
    *piVar3 = 0x16;
    uVar2 = 0xffffffff;
  }
  else {
    lVar1 = FUN_0001a32c();
    if (unaff_x19 == lVar1) {
      FUN_0001a260();
      FUN_00009b28();
      uVar2 = 0;
    }
    else {
      uVar2 = FUN_0000aed4();
      FUN_00009b28();
    }
  }
  return uVar2;
}



void FUN_0001a23c(void)

{
  undefined8 uVar1;
  undefined8 *in_x3;
  undefined8 uVar2;
  
  uVar2 = *in_x3;
  uVar1 = FUN_000090e4();
  FUN_0001a260(uVar1,uVar2);
  return;
}



void FUN_0001a260(long param_1,undefined8 *param_2)

{
  undefined8 *puVar1;
  int extraout_w8;
  undefined8 uVar2;
  
  if (param_2 == (undefined8 *)0x0) {
    if (*(void **)(param_1 + 0xb8) != (void *)0x0) {
      _free(*(void **)(param_1 + 0xb8));
      *(undefined8 *)(param_1 + 0xb8) = 0;
    }
  }
  else if (((*(uint *)((long)param_2 + 4) | *(uint *)param_2 | *(uint *)(param_2 + 1) ^ 0xffff0000)
            != 0) && (FUN_0001a2fc(), extraout_w8 != 0)) {
    puVar1 = *(undefined8 **)(param_1 + 0xb8);
    if (puVar1 == (undefined8 *)0x0) {
      puVar1 = (undefined8 *)_ahpl_malloc(0xc);
      *(undefined8 **)(param_1 + 0xb8) = puVar1;
      if (puVar1 == (undefined8 *)0x0) {
        return;
      }
    }
    uVar2 = *param_2;
    *(uint *)(puVar1 + 1) = *(uint *)(param_2 + 1);
    *puVar1 = uVar2;
  }
  return;
}



long _ahpl_mpq_get_ipv6_prefix(void)

{
  long lVar1;
  
  lVar1 = FUN_000090e4();
  if (lVar1 != 0) {
    lVar1 = *(long *)(lVar1 + 0xb8);
  }
  return lVar1;
}



void FUN_0001a2fc(void)

{
  return;
}



bool FUN_0001a314(void)

{
  uint in_w8;
  uint in_w9;
  
  return (in_w8 | in_w9) == 0;
}



void FUN_0001a324(void)

{
  return;
}



void FUN_0001a32c(void)

{
  FUN_000090e4();
  return;
}



// WARNING: Type propagation algorithm not settling

long FUN_0001a334(uint *param_1,long *param_2,byte *param_3,long param_4)

{
  byte *pbVar1;
  byte bVar2;
  char cVar3;
  byte bVar4;
  short sVar5;
  bool bVar6;
  undefined uVar7;
  bool bVar8;
  undefined uVar9;
  undefined4 uVar10;
  uint uVar11;
  uint uVar12;
  int iVar13;
  undefined8 uVar14;
  int extraout_w1;
  int extraout_w1_00;
  long extraout_x1;
  long extraout_x1_00;
  long extraout_x1_01;
  uint *puVar15;
  uint *puVar16;
  ushort *puVar17;
  long *plVar18;
  byte *pbVar19;
  uint uVar20;
  ulong uVar21;
  ulong uVar22;
  ulong uVar23;
  uint extraout_w8;
  uint extraout_w8_00;
  uint extraout_w8_01;
  int extraout_w8_02;
  uint extraout_w8_03;
  int extraout_w8_04;
  int extraout_w8_05;
  int extraout_w8_06;
  uint extraout_w8_07;
  uint extraout_w8_08;
  uint extraout_w8_09;
  uint extraout_w8_10;
  uint extraout_w8_11;
  uint extraout_w8_12;
  uint extraout_w8_13;
  uint extraout_w8_14;
  uint extraout_w8_15;
  uint extraout_w8_16;
  uint extraout_w8_17;
  uint extraout_w8_18;
  uint extraout_w8_19;
  uint extraout_w8_20;
  uint extraout_w8_21;
  uint extraout_w8_22;
  uint uVar24;
  uint extraout_w8_23;
  uint extraout_w8_24;
  uint extraout_w8_25;
  uint extraout_w8_26;
  uint extraout_w8_27;
  uint extraout_w8_28;
  ulong uVar25;
  undefined *puVar26;
  undefined *extraout_x8;
  undefined *extraout_x8_00;
  undefined *extraout_x8_01;
  undefined *extraout_x8_02;
  long extraout_x8_03;
  undefined *extraout_x8_04;
  undefined *extraout_x8_05;
  undefined *extraout_x8_06;
  undefined *extraout_x8_07;
  undefined *extraout_x8_08;
  undefined *extraout_x8_09;
  long extraout_x8_10;
  ulong extraout_x8_11;
  code *extraout_x8_12;
  ulong extraout_x8_13;
  ulong extraout_x8_14;
  long lVar27;
  ulong extraout_x8_15;
  int extraout_w9;
  long extraout_x9;
  long extraout_x9_00;
  byte *extraout_x9_01;
  byte *extraout_x9_02;
  byte *extraout_x9_03;
  long extraout_x9_04;
  long extraout_x9_05;
  undefined4 *extraout_x9_06;
  long extraout_x9_07;
  uint *extraout_x9_08;
  uint *extraout_x9_09;
  uint *extraout_x9_10;
  uint *extraout_x9_11;
  uint *extraout_x9_12;
  undefined4 *extraout_x9_13;
  uint extraout_w10;
  uint extraout_w10_00;
  uint extraout_w10_01;
  uint extraout_w10_02;
  uint extraout_w10_03;
  uint extraout_w10_04;
  int extraout_w10_05;
  ulong extraout_x10;
  ulong extraout_x10_00;
  ulong extraout_x10_01;
  ulong extraout_x10_02;
  uint *extraout_x10_03;
  uint *extraout_x10_04;
  uint *extraout_x10_05;
  long extraout_x10_06;
  uint *extraout_x10_07;
  uint *extraout_x10_08;
  uint *extraout_x10_09;
  uint *extraout_x10_10;
  uint *extraout_x10_11;
  uint *extraout_x10_12;
  uint *extraout_x10_13;
  uint *extraout_x10_14;
  uint *extraout_x10_15;
  uint *extraout_x10_16;
  uint *extraout_x10_17;
  uint *extraout_x10_18;
  uint *extraout_x10_19;
  uint *extraout_x10_20;
  uint *extraout_x10_21;
  uint *extraout_x10_22;
  uint *extraout_x10_23;
  uint *extraout_x10_24;
  uint *extraout_x10_25;
  uint *extraout_x10_26;
  uint *extraout_x10_27;
  uint *extraout_x10_28;
  uint *extraout_x10_29;
  uint *extraout_x10_30;
  uint *extraout_x10_31;
  uint *extraout_x10_32;
  uint *extraout_x10_33;
  uint *extraout_x10_34;
  uint *puVar28;
  uint *extraout_x10_35;
  uint *extraout_x10_36;
  uint *extraout_x10_37;
  uint *extraout_x10_38;
  uint *extraout_x10_39;
  uint *extraout_x10_40;
  uint *extraout_x10_41;
  uint *extraout_x10_42;
  uint *extraout_x10_43;
  uint *extraout_x10_44;
  uint *extraout_x10_45;
  uint *extraout_x10_46;
  uint *extraout_x10_47;
  uint *extraout_x10_48;
  uint *extraout_x10_49;
  uint *extraout_x10_50;
  char extraout_w11;
  char extraout_w11_00;
  char extraout_w11_01;
  char extraout_w11_02;
  uint uVar29;
  uint extraout_w11_03;
  uint extraout_w11_04;
  uint extraout_w11_05;
  uint extraout_w11_06;
  uint extraout_w11_07;
  int extraout_w11_08;
  uint extraout_w11_09;
  int extraout_w11_10;
  byte *pbVar30;
  uint uVar31;
  uint extraout_w12;
  uint extraout_w12_00;
  long extraout_x12;
  long extraout_x12_00;
  long extraout_x12_01;
  long extraout_x12_02;
  byte *pbVar32;
  long extraout_x12_03;
  long extraout_x12_04;
  long extraout_x12_05;
  long extraout_x12_06;
  uint uVar33;
  byte *pbVar34;
  byte *pbVar35;
  byte *pbVar36;
  ulong uVar37;
  byte *pbVar38;
  byte *pbVar39;
  undefined auVar40 [16];
  uint local_a4;
  byte *local_90;
  byte *local_78;
  
  uVar24 = *param_1;
  puVar28 = param_1 + 1;
  uVar12 = *puVar28;
  puVar15 = param_1 + 5;
  uVar21 = (ulong)*puVar15;
  if ((*puVar15 & 0x7f000000) == 0) {
    uVar11 = uVar24 >> 10 & 0x7f;
    uVar25 = (ulong)uVar11;
    if (param_4 != 0) {
      pbVar19 = (byte *)0x0;
      local_90 = param_3;
      if (uVar11 != 0x2d) {
        local_90 = (byte *)0x0;
      }
      pbVar39 = param_3;
      if (uVar11 != 0x32) {
        pbVar39 = (byte *)0x0;
      }
      pbVar38 = param_3;
      if (uVar11 != 0x10) {
        pbVar38 = (byte *)0x0;
      }
      pbVar35 = param_3;
      local_78 = (byte *)0x0;
      if (10 < uVar11 - 0x15) {
        pbVar35 = (byte *)0x0;
        local_78 = pbVar38;
      }
      pbVar1 = param_3 + param_4;
      pbVar36 = pbVar1 + -1;
      puVar17 = &switchD_0001a444::switchdataD_00026958;
      puVar16 = puVar15;
      plVar18 = param_2;
      uVar23 = uVar21;
      pbVar38 = param_3;
LAB_0001a3e8:
      uVar37 = (ulong)*pbVar38;
      if ((0x3a < (uint)uVar25) || (uVar12 = uVar12 + 1, uVar12 < 0x14001)) {
switchD_0001abac_caseD_4:
        local_a4 = (uint)uVar23;
        uVar20 = (uint)uVar21;
        uVar11 = (int)uVar25 - 1;
        bVar6 = 0x3e < uVar11;
        uVar9 = uVar11 == 0x3f;
        if (0x3f < uVar11) {
          FUN_0001cfac();
          uVar21 = uVar23;
          uVar25 = FUN_0001cfa0(0x1d);
          puVar28 = extraout_x10_08;
          goto LAB_0001c000;
        }
        puVar26 = &DAT_00026acc;
        bVar4 = (byte)uVar37;
        uVar29 = (uint)(char)bVar4;
        uVar25 = (ulong)uVar29;
        uVar31 = (uint)uVar37;
        sVar5 = (short)uVar37;
        pbVar34 = pbVar38;
        switch((ulong)puVar17[uVar11] * 4 + 0x1a448) {
        case 0x1a448:
          FUN_0001ce14();
          if (bVar6) {
            uVar25 = 0xf;
            if (extraout_w1 == 10 || extraout_w1 == 0xd) goto switchD_0001abac_caseD_4;
            if (extraout_w1 == 0x20) goto switchD_0001b3b8_caseD_c;
          }
          else {
            uVar11 = extraout_w1 + (uint)uVar23 * 10 + 0xffd0;
            uVar20 = (uint)uVar23 & 0xffff0000 | uVar11 & 0xffff;
            *puVar16 = uVar20;
            if ((uVar11 & 0xffff) < 1000) goto LAB_0001acac;
          }
          FUN_0001cfe0();
          uVar25 = 0xe;
          puVar28 = extraout_x10_05;
          goto LAB_0001c000;
        case 0x1a468:
          uVar25 = 0x2e;
          if ((uVar31 == 9) || (uVar31 == 0x20)) goto switchD_0001b3b8_caseD_c;
          uVar11 = *param_1;
          uVar20 = uVar11 >> 0x11 & 0x7f;
          if (uVar20 - 0x17 < 4) {
            uVar29 = 8;
            switch(uVar20) {
            case 0x17:
              uVar29 = 4;
              break;
            case 0x19:
              uVar29 = 0x10;
              break;
            case 0x1a:
              uVar29 = 0x20;
            }
            uVar11 = uVar11 | uVar29;
            *param_1 = uVar11;
          }
          else if (uVar20 == 10) {
            *puVar28 = uVar12;
            FUN_0001cf7c(0x19);
            uVar25 = 0x30;
            puVar28 = extraout_x10_04;
            goto LAB_0001c000;
          }
          uVar9 = pbVar39 == (byte *)0x0;
          if (!(bool)uVar9) {
            pbVar34 = pbVar39;
          }
          uVar25 = 0x2c;
          pbVar39 = (byte *)0x0;
          if (pbVar34 != (byte *)0x0) {
            pbVar39 = (byte *)0x0;
            uVar25 = 0x2c;
            if (plVar18[4] != 0) {
              *param_1 = uVar11 & 0xfffe0000 | uVar11 & 0x3ff | 0xb000;
              puVar16 = (uint *)(pbVar38 + -(long)pbVar34);
              iVar13 = FUN_0001cf00(plVar18[4]);
              if (iVar13 == 0) {
                FUN_0001cdac();
              }
              else {
                FUN_0001cd94();
                uVar23 = (ulong)(extraout_w8_00 | 0x4000000);
                *puVar16 = extraout_w8_00 | 0x4000000;
              }
              FUN_0001ce98();
LAB_0001aa60:
              uVar25 = FUN_0001cde8();
              pbVar39 = extraout_x9_02;
              goto LAB_0001aa68;
            }
          }
          goto switchD_0001abac_caseD_4;
        case 0x1a4b8:
          uVar11 = *param_1;
          uVar25 = (ulong)uVar11;
          uVar20 = uVar11 >> 0x11 & 0x7f;
          pbVar30 = pbVar1;
          do {
            uVar9 = pbVar34 == pbVar1;
            if ((bool)uVar9) {
              uVar7 = pbVar1 <= pbVar34;
              uVar11 = uVar11 & 0xff000000 | uVar11 & 0x1ffff | uVar20 << 0x11;
              uVar29 = 0x32;
              pbVar34 = pbVar36;
              pbVar38 = pbVar30;
LAB_0001acc4:
              *param_1 = uVar11;
              uVar25 = FUN_0001ce54((int)pbVar34 - (int)pbVar38,uVar29);
              pbVar38 = pbVar34;
              if (!(bool)uVar7 || (bool)uVar9) goto switchD_0001b3b8_caseD_c;
              uVar25 = FUN_0001ce68();
              puVar28 = extraout_x10_10;
              goto LAB_0001c000;
            }
            bVar4 = *pbVar34;
            uVar29 = (uint)uVar25;
            uVar11 = uVar29 & 0xff000000 | uVar29 & 0x1ffff | uVar20 << 0x11;
            bVar6 = 9 < bVar4;
            uVar9 = bVar4 == 10;
            if ((bool)uVar9) goto LAB_0001aa78;
            uVar31 = (uint)bVar4;
            uVar7 = 0xc < uVar31;
            uVar9 = uVar31 == 0xd;
            if ((bool)uVar9) {
              *param_1 = uVar11;
              if (pbVar39 == (byte *)0x0) {
                uVar29 = 0x34;
              }
              else if (plVar18[4] == 0) {
                uVar29 = 0x34;
                puVar17 = &switchD_0001a444::switchdataD_00026958;
                puVar16 = puVar15;
              }
              else {
                iVar13 = FUN_0001cee8(0x34);
                if (iVar13 == 0) {
                  FUN_0001cdac();
                  uVar21 = uVar23;
                }
                else {
                  *puVar28 = uVar12;
                  FUN_0001ce80();
                  uVar21 = uVar23;
                }
                puVar17 = &switchD_0001a444::switchdataD_00026958;
                FUN_0001cde8();
                if (!(bool)uVar9) goto LAB_0001c454;
                uVar11 = *param_1;
                uVar29 = uVar11 >> 10 & 0x7f;
                uVar23 = uVar21;
              }
              pbVar39 = (byte *)0x0;
              uVar11 = uVar11 & 0xff01ffff | uVar20 << 0x11;
              goto LAB_0001acc4;
            }
            if (((-1 < (int)uVar24) && (uVar31 != 9)) && ((uVar31 < 0x20 || (uVar31 == 0x7f)))) {
LAB_0001bff4:
              FUN_0001cff8();
              uVar25 = 0x32;
              puVar28 = extraout_x10_03;
              pbVar38 = pbVar34;
              goto LAB_0001c000;
            }
            bVar8 = 0x19 < uVar20;
            bVar6 = uVar20 == 0x1a;
            uVar37 = (ulong)bVar4 | 0x20;
            iVar13 = (int)uVar37;
            switch(uVar20) {
            case 0:
              uVar37 = (long)pbVar1 - (long)pbVar34;
              if (0x13fff < (ulong)((long)pbVar1 - (long)pbVar34)) {
                uVar37 = 0x14000;
              }
              pbVar30 = pbVar34 + uVar37;
              if (uVar37 != 0) {
                while (uVar37 = uVar37 - 1, uVar31 != 0xd && uVar31 != 10) {
                  if (((-1 < (int)uVar24) && (uVar31 != 9)) && ((uVar31 < 0x20 || (uVar31 == 0x7f)))
                     ) goto LAB_0001bff4;
                  if (uVar37 == 0) goto LAB_0001a780;
                  pbVar34 = pbVar34 + 1;
                  uVar31 = (uint)*pbVar34;
                }
                pbVar30 = pbVar34 + -1;
              }
LAB_0001a780:
              uVar20 = 0;
              pbVar34 = pbVar30 + -1;
              if (pbVar30 != pbVar1) {
                pbVar34 = pbVar30;
              }
              break;
            default:
              uVar20 = 0;
              break;
            case 9:
            case 0xd:
              break;
            case 10:
              if (uVar31 == 0x20) {
                uVar20 = 10;
              }
              else {
LAB_0001a5e8:
                if ((9 < uVar31 - 0x30) || (0x1999999999999998 < *(ulong *)(param_1 + 2))) {
                  *param_1 = uVar29 & 0xff000000 | uVar29 & 0x1ffff | 0x160000;
                  goto LAB_0001c0e4;
                }
                *(ulong *)(param_1 + 2) = (long)(char)bVar4 + *(ulong *)(param_1 + 2) * 10 + -0x30;
                uVar20 = 0xb;
              }
              break;
            case 0xb:
              if (uVar31 != 0x20) goto LAB_0001a5e8;
LAB_0001a628:
              uVar20 = 0xc;
              break;
            case 0xc:
              if (uVar31 == 0x20) goto LAB_0001a628;
              *param_1 = uVar29 & 0xff01ffff | 0x180000;
LAB_0001c0e4:
              param_1[1] = uVar12;
              uVar24 = (uint)uVar21 & 0x80000000 | (uint)uVar21 & 0xffffff | 0x19000000;
              uVar21 = (ulong)uVar24;
              param_1[5] = uVar24;
              uVar25 = 0x32;
              pbVar38 = pbVar34;
              goto LAB_0001c000;
            case 0xf:
              if (iVar13 == 0x20) goto LAB_0001a680;
              if (iVar13 == 99) {
                uVar20 = 0x10;
              }
              else {
                cVar3 = puVar26[uVar37];
                uVar11 = 0x11;
LAB_0001a7b0:
                uVar20 = 0;
                if (cVar3 != '\0') {
                  uVar20 = uVar11;
                }
              }
              break;
            case 0x10:
              FUN_0001cdf4();
              puVar26 = extraout_x8;
              uVar25 = extraout_x10;
              if (!bVar8 || bVar6) {
                uVar33 = (uint)(byte)"chunked"[extraout_x12];
                uVar20 = 0x11;
                bVar6 = (int)extraout_x12 == 6;
                uVar31 = 0x10;
                uVar11 = 0x17;
                uVar29 = extraout_w11_03;
                goto LAB_0001a720;
              }
LAB_0001a764:
              uVar20 = 0x11;
              break;
            case 0x11:
              if (uVar31 != 0x2c) goto LAB_0001a764;
              uVar25 = (ulong)(uVar29 & 0xe0ffffff);
              *param_1 = uVar29 & 0xe0ffffff;
LAB_0001a680:
              uVar20 = 0xf;
              break;
            case 0x12:
              if (iVar13 == 0x20) goto LAB_0001a740;
              if (iVar13 == 0x75) {
                uVar20 = 0x15;
              }
              else if (iVar13 == 0x6b) {
                uVar20 = 0x13;
              }
              else {
                if (iVar13 != 99) {
                  cVar3 = puVar26[uVar37];
                  uVar11 = 0x16;
                  goto LAB_0001a7b0;
                }
                uVar20 = 0x14;
              }
              break;
            case 0x13:
              FUN_0001cf08();
              puVar26 = extraout_x8_00;
              uVar25 = extraout_x10_00;
              if (!bVar8 || bVar6) {
                uVar33 = (uint)(byte)"keep-alive"[extraout_x12_00];
                uVar20 = 0x16;
                bVar6 = (int)extraout_x12_00 == 9;
                uVar31 = 0x13;
                uVar11 = 0x18;
                uVar29 = extraout_w11_04;
                goto LAB_0001a720;
              }
LAB_0001a748:
              uVar20 = 0x16;
              break;
            case 0x14:
              FUN_0001ce38();
              puVar26 = extraout_x8_01;
              uVar25 = extraout_x10_01;
              if (5 < (uint)extraout_x12_01) goto LAB_0001a748;
              uVar33 = (uint)(byte)"close"[extraout_x12_01];
              uVar20 = 0x16;
              bVar6 = (uint)extraout_x12_01 == 4;
              uVar31 = 0x14;
              uVar11 = 0x19;
              uVar29 = extraout_w11_05;
              goto LAB_0001a720;
            case 0x15:
              FUN_0001cdf4();
              puVar26 = extraout_x8_02;
              uVar25 = extraout_x10_02;
              if (bVar8 && !bVar6) goto LAB_0001a748;
              uVar33 = (uint)*(byte *)(extraout_x9 + extraout_x12_02);
              uVar20 = 0x16;
              bVar6 = (int)extraout_x12_02 == 6;
              uVar31 = 0x15;
              uVar11 = 0x1a;
              uVar29 = extraout_w11_06;
LAB_0001a720:
              if (!bVar6) {
                uVar11 = uVar31;
              }
              if (uVar29 == uVar33) {
                uVar20 = uVar11;
              }
              break;
            case 0x16:
              if (uVar31 != 0x2c) goto LAB_0001a748;
LAB_0001a738:
              uVar25 = (ulong)(uVar29 & 0xe0ffffff);
              *param_1 = uVar29 & 0xe0ffffff;
LAB_0001a740:
              uVar20 = 0x12;
              break;
            case 0x17:
              uVar20 = 0x17;
              if (uVar31 != 0x20) {
                uVar20 = 0x11;
              }
              break;
            case 0x18:
            case 0x19:
            case 0x1a:
              if (uVar31 != 0x20) {
                if (uVar31 == 0x2c) {
                  if (uVar20 - 0x18 < 3) {
                    uVar29 = uVar29 | *(uint *)(&DAT_00026ccc + (long)(int)(uVar20 - 0x18) * 4);
                    *param_1 = uVar29;
                  }
                  goto LAB_0001a738;
                }
                goto LAB_0001a748;
              }
            }
            uVar11 = (uint)uVar25;
            pbVar34 = pbVar34 + 1;
            pbVar30 = pbVar38;
          } while( true );
        case 0x1a7c4:
          if (uVar31 == 0x20 || uVar31 == 9) {
            uVar25 = 0x31;
            if ((*param_1 & 0xfe0000) == 0x160000) {
              *param_1 = *param_1 & 0xff01ffff | 0x180000;
              uVar25 = 0x31;
            }
            goto switchD_0001abac_caseD_4;
          }
          uVar11 = *param_1;
          uVar25 = 0x2c;
          switch(uVar11 >> 0x11 & 0x7f) {
          case 0x17:
            uVar11 = uVar11 | 4;
            break;
          case 0x18:
            uVar11 = uVar11 | 8;
            break;
          case 0x19:
            uVar11 = uVar11 | 0x10;
            break;
          case 0x1a:
            uVar11 = uVar11 | 0x20;
            break;
          default:
            goto switchD_0001abac_caseD_4;
          }
          *param_1 = uVar11;
          uVar25 = 0x2c;
          goto switchD_0001abac_caseD_4;
        case 0x1a7f0:
          FUN_0001d040();
          if (!(bool)uVar9) {
            pbVar34 = pbVar19;
          }
          pbVar38 = pbVar38 + extraout_x9_00 + -1;
          *(long *)(param_1 + 2) = extraout_x8_03 - extraout_x9_00;
          if (extraout_x8_03 - extraout_x9_00 != 0) {
            uVar25 = 0x3e;
            pbVar19 = pbVar34;
            goto switchD_0001b3b8_caseD_c;
          }
          pbVar19 = (byte *)0x0;
          uVar25 = 0x40;
          if (pbVar34 != (byte *)0x0) {
            pbVar19 = (byte *)0x0;
            uVar25 = 0x40;
            if (plVar18[6] != 0) {
              FUN_0001d034();
              *param_1 = extraout_w8 | 0x10000;
              puVar16 = (uint *)(pbVar38 + (1 - extraout_x1));
              iVar13 = FUN_0001cf00(plVar18[6]);
              if (iVar13 == 0) {
                FUN_0001cdac();
              }
              else {
                FUN_0001cea8();
              }
              pbVar19 = (byte *)0x0;
              FUN_0001ce98();
              uVar25 = FUN_0001cde8();
              pbVar39 = extraout_x9_01;
LAB_0001aa68:
              puVar17 = &switchD_0001a444::switchdataD_00026958;
              if (!(bool)uVar9) {
LAB_0001c240:
                return (long)pbVar38 - (long)param_3;
              }
            }
          }
          goto switchD_0001abac_caseD_4;
        case 0x1a868:
          if (local_78 != (byte *)0x0) {
            pbVar34 = local_78;
          }
          *param_1 = *param_1 & 0xe0ffffff;
          uVar25 = 0x10;
          local_78 = pbVar34;
          if (uVar31 != 10 && uVar31 != 0xd) goto switchD_0001b3b8_caseD_c;
          goto switchD_0001abac_caseD_4;
        case 0x1a8a0:
          goto switchD_0001a444_caseD_1a8a0;
        case 0x1ab48:
          uVar9 = uVar31 == 10 || uVar31 == 0xd;
          if ((bool)uVar9) {
            uVar25 = 2;
            goto switchD_0001b3b8_caseD_c;
          }
          FUN_0001d07c(*param_1);
          if ((bool)uVar9) {
            if (*plVar18 != 0) {
              *param_1 = extraout_w8_01 & 0x9ffe0003 | 0xc00;
              iVar13 = FUN_0001ce30(*plVar18);
              if (iVar13 == 0) {
                FUN_0001cdac();
                uVar21 = uVar23;
              }
              else {
                FUN_0001cec8();
                uVar21 = uVar23;
              }
              puVar17 = &switchD_0001a444::switchdataD_00026958;
              FUN_0001cde8();
              if (!(bool)uVar9) goto LAB_0001c410;
              goto LAB_0001bc98;
            }
            uVar25 = 3;
            goto LAB_0001be18;
          }
          *param_1 = extraout_w8_01 & extraout_w11_08 - 3U;
          uVar25 = 0x12;
          goto switchD_0001abac_caseD_4;
        case 0x1ac4c:
          FUN_0001ce24();
          uVar20 = (uint)uVar21;
          if ((bool)uVar9 || extraout_w1_00 == 0xd) {
            param_1[4] = 0x90000;
            uVar9 = extraout_w8_02 == 0xd;
            uVar11 = 0x2b;
            if (!(bool)uVar9) {
              uVar11 = 0x2c;
            }
            uVar25 = (ulong)uVar11;
            if (pbVar35 == (byte *)0x0) goto switchD_0001b3b8_caseD_c;
            if (plVar18[1] == 0) {
              pbVar35 = (byte *)0x0;
              goto LAB_0001be18;
            }
            iVar13 = FUN_0001d034();
            uVar11 = extraout_w8_03 | iVar13 << 10;
          }
          else {
            uVar9 = extraout_w1_00 == 0x20;
            if (!(bool)uVar9) goto LAB_0001adec;
            if (pbVar35 == (byte *)0x0) {
              uVar25 = 0x20;
              goto switchD_0001b3b8_caseD_c;
            }
            if (plVar18[1] == 0) {
              pbVar35 = (byte *)0x0;
              uVar25 = 0x20;
              goto LAB_0001be18;
            }
            FUN_0001d034();
            uVar11 = extraout_w8_07 | 0x8000;
          }
          *param_1 = uVar11;
          puVar16 = (uint *)(pbVar38 + -(long)pbVar35);
          iVar13 = (*(code *)plVar18[1])(param_1,pbVar35);
          if (iVar13 == 0) {
            FUN_0001cdac();
            uVar21 = uVar23;
          }
          else {
            FUN_0001cd94();
            uVar21 = (ulong)(extraout_w8_16 | 0x2000000);
            *puVar16 = extraout_w8_16 | 0x2000000;
          }
          puVar17 = &switchD_0001a444::switchdataD_00026958;
          FUN_0001cde8();
          if (!(bool)uVar9) goto LAB_0001c410;
          pbVar35 = (byte *)0x0;
          goto LAB_0001bc98;
        case 0x1adb4:
          if ((uVar29 < 0x21) && ((1L << (uVar25 & 0x3f) & 0x100002400U) != 0)) {
            uVar25 = FUN_0001cfb8();
            uVar21 = (ulong)(uVar20 & 0x80000000 |
                            uVar20 & 0xffffff | (extraout_w8_20 & 0x7f) << 0x18);
            puVar28 = extraout_x10_09;
            goto LAB_0001c2a0;
          }
LAB_0001adec:
          uVar25 = FUN_0001c698();
          if ((int)uVar25 != 1) {
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            uVar21 = (ulong)uVar20;
            puVar16 = puVar15;
            plVar18 = param_2;
            goto switchD_0001b3b8_caseD_c;
          }
          uVar25 = FUN_0001cfb8();
          puVar28 = extraout_x10_37;
          uVar24 = extraout_w8_22;
LAB_0001c510:
          uVar21 = (ulong)(uVar20 & 0x80000000 | uVar20 & 0xffffff | (uVar24 & 0x7f) << 0x18);
          puVar16 = puVar15;
          goto LAB_0001c2a0;
        case 0x1ae30:
          FUN_0001ce24();
          if (!(bool)uVar9 && extraout_w8_04 != 0xd) {
            FUN_0001cfac();
            uVar21 = uVar23;
            FUN_0001cfa0(0xd);
            uVar25 = 1;
            puVar28 = extraout_x10_11;
            goto LAB_0001c000;
          }
          uVar25 = 1;
          goto switchD_0001b3b8_caseD_c;
        case 0x1ae44:
          FUN_0001d010();
          if ((bool)uVar9) {
            *param_1 = *param_1 & 0xfffffffc | 1;
            goto LAB_0001ae80;
          }
          if (extraout_w8_05 == 0x45) {
            uVar11 = (uint)uVar23 & 0xff00ffff | 0x20000;
            uVar21 = (ulong)uVar11;
            param_1[5] = uVar11;
            *param_1 = *param_1 & 0xe0fffffc | 0x2000000;
            uVar25 = 0x13;
            uVar23 = uVar21;
            goto switchD_0001b3b8_caseD_c;
          }
          FUN_0001cfc8();
          uVar25 = 3;
          puVar28 = extraout_x10_50;
          goto LAB_0001c000;
        case 0x1ae60:
          uVar9 = uVar31 == 10 || uVar31 == 0xd;
          if (uVar31 == 10 || uVar31 == 0xd) {
            uVar25 = 4;
            goto switchD_0001b3b8_caseD_c;
          }
          FUN_0001d07c(*param_1);
          if (!(bool)uVar9) {
            FUN_0001cfc8();
            uVar25 = 4;
            puVar28 = extraout_x10_31;
            goto LAB_0001c000;
          }
          if (*plVar18 != 0) {
            uVar11 = extraout_w8_15 & 0x9ffe0003;
            uVar20 = 0x1400;
            goto LAB_0001bc6c;
          }
          uVar25 = 5;
          goto LAB_0001be18;
        case 0x1ae78:
          FUN_0001d010();
          if (!(bool)uVar9) {
            FUN_0001cd64();
            uVar25 = 5;
            puVar28 = extraout_x10_12;
            goto LAB_0001c000;
          }
LAB_0001ae80:
          uVar25 = 6;
          goto switchD_0001b3b8_caseD_c;
        case 0x1ae88:
          FUN_0001d010();
          if (!(bool)uVar9) {
            FUN_0001cd64();
            uVar25 = 6;
            puVar28 = extraout_x10_13;
            goto LAB_0001c000;
          }
          uVar25 = 7;
          goto switchD_0001b3b8_caseD_c;
        case 0x1ae98:
          if (uVar31 != 0x50) {
            FUN_0001cd64();
            uVar25 = 7;
            puVar28 = extraout_x10_14;
            goto LAB_0001c000;
          }
          uVar25 = 8;
          goto switchD_0001b3b8_caseD_c;
        case 0x1aeac:
          if (uVar31 != 0x2f) {
            FUN_0001cd64();
            uVar25 = 8;
            puVar28 = extraout_x10_15;
            goto LAB_0001c000;
          }
          uVar25 = 9;
          goto switchD_0001b3b8_caseD_c;
        case 0x1aec0:
          FUN_0001ce14();
          if (bVar6) {
            FUN_0001cdb8();
            uVar25 = 9;
            puVar28 = extraout_x10_38;
            goto LAB_0001c000;
          }
          *(short *)(param_1 + 4) = sVar5 + -0x30;
          uVar25 = 10;
          goto switchD_0001b3b8_caseD_c;
        case 0x1aedc:
          if (uVar31 != 0x2e) {
            FUN_0001cdb8();
            uVar25 = 10;
            puVar28 = extraout_x10_39;
            goto LAB_0001c000;
          }
          uVar25 = 0xb;
          goto switchD_0001b3b8_caseD_c;
        case 0x1aef0:
          FUN_0001ce14();
          if (bVar6) {
            FUN_0001cdb8();
            uVar25 = 0xb;
            puVar28 = extraout_x10_40;
            goto LAB_0001c000;
          }
          *(short *)((long)param_1 + 0x12) = sVar5 + -0x30;
          uVar25 = 0xc;
          goto switchD_0001b3b8_caseD_c;
        case 0x1af0c:
          if (uVar31 == 0x20) goto LAB_0001b5c8;
          FUN_0001cdb8();
          uVar25 = 0xc;
          puVar28 = extraout_x10_41;
          goto LAB_0001c000;
        case 0x1af1c:
          FUN_0001ce14();
          if (bVar6) {
            if (uVar31 == 0x20) {
LAB_0001b5c8:
              uVar25 = 0xd;
              goto switchD_0001b3b8_caseD_c;
            }
            FUN_0001cfe0();
            uVar25 = 0xd;
            puVar28 = extraout_x10_30;
            goto LAB_0001c000;
          }
          uVar20 = (uint)uVar23 & 0xffff0000 | bVar4 + 0xffd0 & 0xffff;
          *puVar16 = uVar20;
LAB_0001acac:
          uVar21 = (ulong)uVar20;
          uVar25 = 0xe;
          uVar23 = uVar21;
          goto switchD_0001b3b8_caseD_c;
        case 0x1af38:
          FUN_0001ce24();
          if ((bool)uVar9) {
            if (local_78 == (byte *)0x0) {
              local_78 = (byte *)0x0;
              goto LAB_0001b114;
            }
            lVar27 = plVar18[2];
            uVar25 = 0x2c;
          }
          else {
            uVar9 = extraout_w8_06 == 0xd;
            if (!(bool)uVar9) {
              uVar25 = 0x10;
              goto switchD_0001b3b8_caseD_c;
            }
            if (local_78 == (byte *)0x0) {
              local_78 = (byte *)0x0;
              uVar25 = 0x11;
              goto switchD_0001b3b8_caseD_c;
            }
            lVar27 = plVar18[2];
            uVar25 = 0x11;
          }
          if (lVar27 != 0) {
            FUN_0001d0bc();
            puVar16 = (uint *)(pbVar38 + -extraout_x1_01);
            iVar13 = FUN_0001cf00();
            if (iVar13 == 0) {
              FUN_0001cdac();
              uVar21 = uVar23;
            }
            else {
              FUN_0001cd94();
              uVar21 = (ulong)(extraout_w8_18 | 0x8000000);
              *puVar16 = extraout_w8_18 | 0x8000000;
            }
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            FUN_0001cde8();
            if (!(bool)uVar9) goto LAB_0001c410;
            local_78 = (byte *)0x0;
            goto LAB_0001bc98;
          }
          local_78 = (byte *)0x0;
          goto LAB_0001be18;
        case 0x1af5c:
          FUN_0001ce24();
          if ((bool)uVar9) goto LAB_0001b114;
          FUN_0001cd64();
          uVar25 = 0x11;
          puVar28 = extraout_x10_16;
          goto LAB_0001c000;
        case 0x1af68:
          if (uVar31 == 10 || uVar31 == 0xd) {
            uVar25 = 0x12;
            goto switchD_0001b3b8_caseD_c;
          }
          uVar11 = *param_1;
          *param_1 = uVar11 & 0x9ffffc03;
          *(undefined8 *)(param_1 + 2) = 0xffffffffffffffff;
          if (0x19 < ((uVar31 | 0x20) - 0x61 & 0xff)) {
            *puVar28 = uVar12;
            local_a4 = local_a4 & 0x80ffffff;
LAB_0001c474:
            uVar21 = (ulong)(local_a4 | 0x10000000);
            *puVar16 = local_a4 | 0x10000000;
            uVar25 = 0x12;
            goto LAB_0001c000;
          }
          uVar20 = local_a4 & 0xff00ffff;
          uVar21 = (ulong)uVar20;
          param_1[5] = uVar20;
          *param_1 = uVar11 & 0x80fffc03 | 0x1000000;
          uVar9 = uVar29 - 0x41 == 0x14;
          switch(uVar29 - 0x41) {
          case 0:
            uVar29 = 0x130000;
            goto LAB_0001bc48;
          case 1:
            uVar21 = (ulong)(uVar20 | 0x100000);
            break;
          case 2:
            uVar29 = 0x50000;
            goto LAB_0001bc48;
          case 3:
            break;
          default:
            FUN_0001cfac();
            local_a4 = local_a4 & 0x8000ffff;
            puVar28 = extraout_x10_32;
            goto LAB_0001c474;
          case 6:
            uVar21 = (ulong)(uVar20 | 0x10000);
            break;
          case 7:
            uVar21 = (ulong)(uVar20 | 0x20000);
            break;
          case 0xb:
            uVar29 = 0x90000;
            goto LAB_0001bc48;
          case 0xc:
            uVar29 = 0xa0000;
            goto LAB_0001bc48;
          case 0xd:
            uVar29 = 0x190000;
            goto LAB_0001bc48;
          case 0xe:
            uVar21 = (ulong)(uVar20 | 0x60000);
            break;
          case 0xf:
            uVar21 = (ulong)(uVar20 | 0x30000);
            break;
          case 0x11:
            uVar29 = 0x140000;
            goto LAB_0001bc48;
          case 0x12:
            uVar29 = 0x1a0000;
LAB_0001bc48:
            uVar21 = (ulong)(uVar20 | uVar29);
            break;
          case 0x13:
            uVar21 = (ulong)(uVar20 | 0x70000);
            break;
          case 0x14:
            uVar21 = (ulong)(uVar20 | 0xf0000);
          }
          *puVar16 = (uint)uVar21;
          if (*plVar18 == 0) {
            uVar25 = 0x13;
            uVar23 = uVar21;
            goto LAB_0001be18;
          }
          uVar11 = uVar11 & 0x80fe0003 | 0x1000000;
          uVar20 = 0x4c00;
LAB_0001bc6c:
          *param_1 = uVar11 | uVar20;
          iVar13 = FUN_0001ce30(*plVar18);
          if (iVar13 == 0) {
            FUN_0001cdac();
            uVar21 = uVar23;
          }
          else {
            FUN_0001cec8();
            uVar21 = uVar23;
          }
          puVar17 = &switchD_0001a444::switchdataD_00026958;
          FUN_0001cde8();
          if ((bool)uVar9) {
LAB_0001bc98:
            uVar25 = FUN_0001cf88();
            uVar23 = uVar21;
            goto switchD_0001b3b8_caseD_c;
          }
LAB_0001c410:
          lVar27 = (long)pbVar38 - (long)param_3;
          goto LAB_0001c418;
        case 0x1af80:
          if (uVar37 == 0) {
LAB_0001c484:
            FUN_0001d068();
            puVar28 = extraout_x10_33;
LAB_0001c49c:
            *puVar16 = (uint)uVar21;
            uVar25 = 0x13;
            goto LAB_0001c000;
          }
          uVar11 = *param_1;
          bVar2 = *(byte *)(*(long *)(&DAT_00028680 + (ulong)(local_a4 >> 0x10 & 0xff) * 8) +
                           ((ulong)(uVar11 >> 0x18) & 0x1f));
          if ((uVar31 == 0x20) && (bVar2 == 0)) {
            uVar25 = 0x14;
            uVar21 = uVar23;
          }
          else {
            if (bVar2 != bVar4) {
              uVar20 = uVar31 - 0x41 & 0xff;
              if ((uVar31 != 0x2d && 0x18 < uVar20) && (uVar31 == 0x2d || uVar20 != 0x19))
              goto LAB_0001c484;
              uVar20 = local_a4 & 0xff0000 | uVar29 | uVar11 >> 0x10 & 0x1f00;
              if (uVar20 == 0x30141) {
                uVar23 = (ulong)(local_a4 & 0xff00ffff | 0x1c0000);
              }
              else if (uVar20 == 0x30152) {
                uVar23 = (ulong)(local_a4 & 0xff00ffff | 0xc0000);
              }
              else {
                if (uVar20 == 0x1a014f) {
                  iVar13 = 0x21;
                }
                else if (uVar20 == 0x40252) {
                  iVar13 = 0x1d;
                }
                else {
                  if (uVar20 != 0x50148) {
                    if (uVar20 == 0x50250) {
                      uVar23 = (ulong)(local_a4 & 0xff00ffff | 0x80000);
                    }
                    else {
                      bVar6 = uVar20 == 0x90149;
                      if (bVar6) {
                        uVar23 = (ulong)(local_a4 & 0xff00ffff | 0x1f0000);
                      }
                      else {
                        FUN_0001cf94();
                        if (!bVar6) {
                          FUN_0001cf94();
                          if (bVar6) {
                            iVar13 = 0x17;
                            uVar11 = extraout_w8_09;
                          }
                          else {
                            FUN_0001cf94();
                            if (bVar6) {
                              iVar13 = 0xb;
                              uVar11 = extraout_w8_10;
                            }
                            else {
                              FUN_0001cf94();
                              if (bVar6) {
                                iVar13 = 0x15;
                                uVar11 = extraout_w8_11;
                              }
                              else {
                                FUN_0001cf94();
                                uVar11 = extraout_w8_12;
                                if (bVar6) {
                                  uVar23 = (ulong)(local_a4 & 0xff00ffff | 0x1e0000);
                                  goto LAB_0001bdac;
                                }
                                if (extraout_w9 == 0xc0450) {
                                  iVar13 = 0xd;
                                }
                                else if (extraout_w9 == 0xf0242) {
                                  iVar13 = 0x12;
                                }
                                else {
                                  if (extraout_w9 != 0xf0253) {
                                    if (extraout_w9 == 0xf0349) {
                                      uVar23 = (ulong)(local_a4 & 0xff00ffff | 0x200000);
                                    }
                                    else {
                                      if (extraout_w9 == 0x140242) {
                                        iVar13 = 0x11;
                                        goto LAB_0001bda8;
                                      }
                                      if (extraout_w9 != 0x1a0145) {
                                        if (extraout_w9 == 0x30155) {
                                          uVar20 = local_a4 & 0xff00ffff | 0x40000;
                                          uVar21 = (ulong)uVar20;
                                          *puVar15 = uVar20;
                                          uVar25 = 0x13;
                                          puVar17 = &switchD_0001a444::switchdataD_00026958;
                                          puVar16 = puVar15;
                                          plVar18 = param_2;
                                          goto LAB_0001bdb4;
                                        }
                                        FUN_0001d068();
                                        puVar16 = puVar15;
                                        puVar28 = extraout_x10_34;
                                        goto LAB_0001c49c;
                                      }
                                      uVar23 = (ulong)(local_a4 & 0xff00ffff | 0xe0000);
                                    }
                                    goto LAB_0001bdac;
                                  }
                                  iVar13 = 0x1b;
                                }
                              }
                            }
                          }
                          goto LAB_0001bda8;
                        }
                        uVar23 = (ulong)(local_a4 & 0xff00ffff | 0x180000);
                        uVar11 = extraout_w8_08;
                      }
                    }
                    goto LAB_0001bdac;
                  }
                  iVar13 = 0x16;
                }
LAB_0001bda8:
                uVar23 = (ulong)(local_a4 & 0xff000000 | local_a4 & 0xffff | iVar13 << 0x10);
              }
LAB_0001bdac:
              *puVar16 = (uint)uVar23;
            }
            uVar21 = uVar23;
            uVar25 = 0x13;
          }
LAB_0001bdb4:
          *param_1 = uVar11 & 0xe0000000 |
                     uVar11 & 0xffffff | (uVar11 + 0x1000000 >> 0x18 & 0x1f) << 0x18;
          uVar23 = uVar21;
          goto switchD_0001b3b8_caseD_c;
        case 0x1afbc:
          uVar25 = 0x14;
          if (uVar31 != 0x20) {
            if (pbVar35 != (byte *)0x0) {
              pbVar34 = pbVar35;
            }
            uVar10 = 0x18;
            if ((uVar20 & 0xff0000) != 0x50000) {
              uVar10 = 0x14;
            }
            uVar25 = FUN_0001c698(uVar10);
            if ((int)uVar25 == 1) {
              uVar25 = FUN_0001cfb8();
              puVar28 = extraout_x10_49;
              uVar24 = extraout_w8_28;
              goto LAB_0001c510;
            }
LAB_0001b004:
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            puVar16 = puVar15;
            plVar18 = param_2;
            uVar23 = (ulong)local_a4;
            pbVar35 = pbVar34;
          }
          goto switchD_0001b3b8_caseD_c;
        case 0x1b018:
          if (uVar31 == 0x20) goto switchD_0001b3b8_caseD_c;
          if (uVar29 == 0x49) {
            if ((uVar20 & 0xff0000) == 0x210000) {
              uVar25 = 0x25;
              goto switchD_0001b3b8_caseD_c;
            }
          }
          else if (uVar29 == 0x48) {
            uVar25 = 0x21;
            goto switchD_0001b3b8_caseD_c;
          }
          *puVar28 = uVar12;
          uVar24 = uVar20 & 0x80ffffff | 0x1c000000;
          uVar21 = (ulong)uVar24;
          *puVar16 = uVar24;
          uVar25 = 0x20;
          goto LAB_0001c000;
        case 0x1b03c:
          FUN_0001d010();
          if (!(bool)uVar9) {
            FUN_0001cd4c();
            uVar25 = 0x21;
            puVar28 = extraout_x10_17;
            goto LAB_0001c000;
          }
          uVar25 = 0x22;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b04c:
          FUN_0001d010();
          if (!(bool)uVar9) {
            FUN_0001cd4c();
            uVar25 = 0x22;
            puVar28 = extraout_x10_18;
            goto LAB_0001c000;
          }
          uVar25 = 0x23;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b05c:
          if (uVar31 == 0x50) goto LAB_0001b0a0;
          FUN_0001cd4c();
          uVar25 = 0x23;
          puVar28 = extraout_x10_19;
          goto LAB_0001c000;
        case 0x1b06c:
          if (uVar31 != 0x2f) {
            FUN_0001cd4c();
            uVar25 = 0x24;
            puVar28 = extraout_x10_20;
            goto LAB_0001c000;
          }
          uVar25 = 0x27;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b080:
          if (uVar31 != 0x43) {
            FUN_0001cd4c();
            uVar25 = 0x25;
            puVar28 = extraout_x10_21;
            goto LAB_0001c000;
          }
          uVar25 = 0x26;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b094:
          if (uVar31 != 0x45) {
            FUN_0001cd4c();
            uVar25 = 0x26;
            puVar28 = extraout_x10_22;
            goto LAB_0001c000;
          }
LAB_0001b0a0:
          uVar25 = 0x24;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b0a8:
          FUN_0001ce14();
          if (bVar6) {
            FUN_0001cdd0();
            uVar25 = 0x27;
            puVar28 = extraout_x10_42;
            goto LAB_0001c000;
          }
          *(short *)(param_1 + 4) = sVar5 + -0x30;
          uVar25 = 0x28;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b0c4:
          if (uVar31 != 0x2e) {
            FUN_0001cdd0();
            uVar25 = 0x28;
            puVar28 = extraout_x10_43;
            goto LAB_0001c000;
          }
          uVar25 = 0x29;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b0d8:
          FUN_0001ce14();
          if (bVar6) {
            FUN_0001cdd0();
            uVar25 = 0x29;
            puVar28 = extraout_x10_44;
            goto LAB_0001c000;
          }
          *(short *)((long)param_1 + 0x12) = sVar5 + -0x30;
          uVar25 = 0x2a;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b0f4:
          if (uVar31 == 0xd) {
            uVar25 = 0x2b;
            goto switchD_0001b3b8_caseD_c;
          }
          if (uVar31 == 10) goto LAB_0001b114;
          FUN_0001cdd0();
          uVar25 = 0x2a;
          puVar28 = extraout_x10_23;
          goto LAB_0001c000;
        case 0x1b10c:
          FUN_0001ce24();
          if (!(bool)uVar9) {
            *puVar28 = uVar12;
            FUN_0001cf7c(0x17);
            uVar25 = 0x2b;
            puVar28 = extraout_x10_45;
            goto LAB_0001c000;
          }
LAB_0001b114:
          uVar25 = 0x2c;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b11c:
          pbVar30 = pbVar1;
          goto joined_r0x0001b124;
        case 0x1b348:
          uVar25 = 0x2e;
          if (uVar31 != 9) {
            if (uVar31 == 10) goto LAB_0001b3e0;
            if (uVar31 != 0x20) {
              if (uVar31 != 0xd) goto switchD_0001a444_caseD_1b378;
              uVar25 = 0x2f;
            }
          }
          goto switchD_0001b3b8_caseD_c;
        case 0x1b378:
switchD_0001a444_caseD_1b378:
          if (pbVar39 != (byte *)0x0) {
            pbVar34 = pbVar39;
          }
          uVar11 = *param_1;
          *param_1 = uVar11 & 0xe0ffffff;
          uVar20 = uVar31 | 0x20;
          uVar25 = 0x32;
          pbVar39 = pbVar34;
          switch(uVar11 >> 0x11 & 0x7f) {
          case 9:
            if (uVar20 == 99) {
              iVar13 = 0x14;
            }
            else {
              if (uVar20 != 0x6b) {
                uVar11 = uVar11 & 0xe001ffff;
                if (uVar20 == 0x75) {
                  uVar20 = 0x2a0000;
                }
                else {
                  uVar20 = 0x2c0000;
                }
                goto LAB_0001bbe4;
              }
              iVar13 = 0x13;
            }
            uVar11 = uVar11 & 0xe0000000 | uVar11 & 0x1ffff | iVar13 << 0x11;
            break;
          case 10:
            if ((uVar31 - 0x30 & 0xff) < 10) {
              if ((uVar11 >> 9 & 1) == 0) {
                *(long *)(param_1 + 2) = (long)(char)bVar4 + -0x30;
                uVar11 = uVar11 & 0xe007ffff;
                uVar20 = 0x160200;
                goto LAB_0001bbe4;
              }
              *puVar28 = uVar12;
              uVar14 = 0x1a;
            }
            else {
              *puVar28 = uVar12;
              uVar14 = 0x19;
            }
            FUN_0001cf7c(uVar14);
            uVar25 = 0x32;
            puVar28 = extraout_x10_36;
            goto LAB_0001c000;
          default:
            uVar11 = uVar11 & 0xe001ffff;
            break;
          case 0xc:
          case 0xf:
          case 0x12:
            goto switchD_0001b3b8_caseD_c;
          case 0xd:
            uVar11 = uVar11 & 0xe001ffff;
            if (uVar20 == 99) {
              uVar11 = uVar11 | 0x200000;
            }
            else {
              uVar20 = 0x220000;
LAB_0001bbe4:
              uVar11 = uVar11 | uVar20;
            }
            break;
          case 0xe:
            uVar11 = uVar11 & 0xe001ff7f | 0x80;
          }
          *param_1 = uVar11;
          uVar25 = 0x32;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b3d8:
          FUN_0001ce24();
          if (!(bool)uVar9) {
            FUN_0001cd4c();
            uVar25 = 0x2f;
            puVar28 = extraout_x10_24;
            goto LAB_0001c000;
          }
LAB_0001b3e0:
          uVar25 = 0x30;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b3e8:
          FUN_0001ce24();
          if (!(bool)uVar9) {
            *puVar28 = uVar12;
            FUN_0001cf7c(0x17);
            uVar25 = 0x34;
            puVar28 = extraout_x10_46;
            goto LAB_0001c000;
          }
          uVar25 = 0x33;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b3f8:
          lVar27 = (long)(char)(&DAT_00026bcc)[uVar37];
          if (lVar27 == -1) {
            FUN_0001cfac();
            FUN_0001cf7c(0x1b);
            uVar25 = 0x35;
            puVar28 = extraout_x10_47;
            goto LAB_0001c000;
          }
LAB_0001b5f4:
          *(long *)(param_1 + 2) = lVar27;
          uVar25 = 0x36;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b40c:
          if (uVar31 == 0xd) {
            uVar25 = 0x38;
            goto switchD_0001b3b8_caseD_c;
          }
          if ((long)(char)(&DAT_00026bcc)[uVar37] == -1) {
            uVar25 = 0x37;
            if ((uVar31 == 0x20) || (uVar31 == 0x3b)) goto switchD_0001b3b8_caseD_c;
            uVar14 = 0x1b000000;
          }
          else {
            if (*(ulong *)(param_1 + 2) < 0xfffffffffffffff) {
              lVar27 = (long)(char)(&DAT_00026bcc)[uVar37] + *(ulong *)(param_1 + 2) * 0x10;
              goto LAB_0001b5f4;
            }
            uVar14 = 0x19000000;
          }
          FUN_0001cfac(uVar14);
          uVar24 = uVar20 & 0x80ffffff | extraout_w8_21;
          uVar21 = (ulong)uVar24;
          *puVar15 = uVar24;
          uVar25 = 0x36;
          puVar16 = puVar15;
          puVar28 = extraout_x10_35;
          goto LAB_0001c000;
        case 0x1b420:
          FUN_0001ce24();
          if (!(bool)uVar9) {
            FUN_0001cd4c();
            uVar25 = 0x38;
            puVar28 = extraout_x10_25;
            goto LAB_0001c000;
          }
          param_1[1] = 0;
          if (*(long *)(param_1 + 2) == 0) {
            *param_1 = *param_1 | 0x40;
            uVar25 = 0x2c;
          }
          else {
            uVar25 = 0x3b;
          }
          if (plVar18[8] != 0) {
            uVar12 = FUN_0001d034();
            *param_1 = extraout_w8_14 & 0xffff0000 | extraout_w8_14 & 0x3ff | (uVar12 & 0x3f) << 10;
            iVar13 = FUN_0001ce30(plVar18[8]);
            if (iVar13 == 0) {
              FUN_0001cdac();
            }
            else {
              *puVar28 = 0;
              FUN_0001cdac();
              FUN_0001cfa0(9);
            }
            goto LAB_0001b8b8;
          }
          uVar12 = 0;
          goto LAB_0001be18;
        case 0x1b43c:
          FUN_0001ce24();
          if (!(bool)uVar9) {
            FUN_0001cd4c();
            uVar25 = 0x3a;
            puVar28 = extraout_x10_26;
            goto LAB_0001c000;
          }
          param_1[1] = 0;
          uVar11 = *param_1;
          if ((uVar11 >> 2 & 1) == 0) {
            uVar9 = *(long *)(param_1 + 2) + 1U == 1;
            bVar6 = 1 < *(long *)(param_1 + 2) + 1U;
          }
          else {
            bVar6 = true;
          }
          uVar20 = (uint)uVar21;
          local_a4 = (uint)uVar23;
          if (-1 < (int)uVar20) {
            if ((uVar11 >> 8 & 1) == 0) goto LAB_0001b8ec;
LAB_0001b784:
            uVar37 = uVar23;
            FUN_0001d01c();
            uVar25 = FUN_0001cf60();
            if (param_2[7] != 0) {
              *param_1 = uVar11 & 0xfffe0000 | uVar11 & 0x3ff | ((uint)uVar25 & 0x1f) << 10;
              plVar18 = param_2;
              iVar13 = FUN_0001ce30(param_2[7]);
              if (iVar13 == 0) {
                FUN_0001cdac();
                uVar23 = uVar37;
              }
              else {
                *puVar28 = 0;
                uVar12 = *puVar15 & 0x80ffffff | 0x7000000;
                uVar23 = (ulong)uVar12;
                *puVar15 = uVar12;
                puVar16 = puVar15;
              }
LAB_0001b8b8:
              puVar17 = &switchD_0001a444::switchdataD_00026958;
              FUN_0001cde8();
              uVar21 = uVar23;
joined_r0x0001b4dc:
              if ((bool)uVar9) {
                uVar12 = 0;
                goto LAB_0001bc98;
              }
              goto LAB_0001c410;
            }
            uVar12 = 0;
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            uVar21 = uVar21 & 0xffffffff;
            puVar16 = puVar15;
            plVar18 = param_2;
            uVar23 = uVar23 & 0xffffffff;
            goto switchD_0001b3b8_caseD_c;
          }
          if (((uVar20 & 0xff0000) == 0x50000) || (!(bool)((uVar11 & 0x100) == 0 & bVar6))) {
            iVar13 = FUN_0001d01c();
            uVar12 = 0x12;
            if ((uVar11 & 3) != 0) {
              uVar12 = 4;
            }
            if (iVar13 == 0) {
              uVar12 = 1;
            }
            if (param_2[7] != 0) {
              *param_1 = uVar11 & 0xfffe0000 | uVar11 & 0x3ff | uVar12 << 10;
              iVar13 = FUN_0001ce30(param_2[7]);
              if (iVar13 == 0) {
                FUN_0001cf38();
                uVar21 = extraout_x8_14;
              }
              else {
                FUN_0001cf44();
                *extraout_x9_13 = (int)extraout_x8_15;
                uVar21 = extraout_x8_15;
              }
              if ((uVar21 & 0x7f000000) != 0) goto LAB_0001c410;
              uVar11 = *param_1;
              uVar12 = uVar11 >> 10 & 0x7f;
            }
            *param_1 = uVar11 & 0xfffe0000 | uVar11 & 0x3ff | uVar12 << 10;
            param_1[1] = 0;
            goto LAB_0001c410;
          }
LAB_0001b8ec:
          if ((uVar11 >> 2 & 1) == 0) {
            if ((uVar11 >> 0x1d & 1) == 0) {
              uVar9 = *(long *)(param_1 + 2) == -1;
              if ((bool)uVar9) {
                uVar37 = uVar21;
                iVar13 = FUN_0001c904(param_1);
                if (iVar13 == 0) {
                  FUN_0001d01c();
                  uVar25 = FUN_0001cf60();
                  if (param_2[7] != 0) {
                    *param_1 = uVar11 & 0xfffe0000 | uVar11 & 0x3ff | ((uint)uVar25 & 0x1f) << 10;
                    iVar13 = FUN_0001ce30(param_2[7]);
                    if (iVar13 == 0) {
                      uVar23 = (ulong)*puVar15;
                      uVar21 = uVar37;
                    }
                    else {
                      FUN_0001cf44();
                      *extraout_x9_06 = (int)extraout_x8_11;
                      uVar21 = uVar37;
                      uVar23 = extraout_x8_11;
                    }
                    if ((uVar23 & 0x7f000000) != 0) goto LAB_0001c410;
                    uVar12 = 0;
                    uVar25 = FUN_0001ce98();
                    plVar18 = param_2;
                    goto LAB_0001be18;
                  }
                }
                else {
                  uVar25 = 0x3f;
                }
                uVar12 = 0;
                pbVar34 = pbVar35;
                goto LAB_0001b004;
              }
              if (*(long *)(param_1 + 2) == 0) goto LAB_0001b784;
              uVar25 = 0x3e;
            }
            else {
              uVar12 = 0;
              uVar25 = 0x3f;
              if (-1 < (int)uVar24) {
                plVar18 = param_2;
                if ((uVar11 & 3) == 0) {
                  param_1[5] = uVar20 & 0x80000000 | uVar20 & 0xffffff | 0x21000000;
                  *param_1 = uVar11 & 0xfffe0000 | uVar11 & 0x3ff | 0xe800;
                  param_1[1] = 0;
                  goto LAB_0001c240;
                }
                goto switchD_0001b3b8_caseD_c;
              }
            }
          }
          else {
            uVar25 = 0x35;
          }
          uVar12 = 0;
          plVar18 = param_2;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b464:
          FUN_0001d040();
          if (!(bool)uVar9) {
            pbVar34 = pbVar19;
          }
          bVar6 = extraout_x8_10 - extraout_x9_05 == 0;
          *(long *)(param_1 + 2) = extraout_x8_10 - extraout_x9_05;
          pbVar38 = pbVar38 + extraout_x9_05 + -1;
          uVar11 = 0x3b;
          pbVar19 = pbVar34;
LAB_0001b530:
          if (bVar6) {
            uVar11 = uVar11 + 1;
          }
          uVar25 = (ulong)uVar11;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b484:
          uVar9 = uVar31 == 0xd;
          if (!(bool)uVar9) {
            FUN_0001cd4c();
            uVar25 = 0x3c;
            puVar28 = extraout_x10_27;
            goto LAB_0001c000;
          }
          if (pbVar19 == (byte *)0x0) {
            uVar25 = 0x3d;
            goto switchD_0001b3b8_caseD_c;
          }
          if (plVar18[6] != 0) {
            FUN_0001d058(0x3d);
            puVar16 = (uint *)(pbVar38 + -(long)pbVar19);
            iVar13 = FUN_0001d090(plVar18[6]);
            if (iVar13 == 0) {
              FUN_0001cdac();
              uVar21 = uVar23;
            }
            else {
              FUN_0001cea8();
              uVar21 = uVar23;
            }
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            FUN_0001cde8();
            if (!(bool)uVar9) goto LAB_0001c410;
            pbVar19 = (byte *)0x0;
            goto LAB_0001bc98;
          }
          pbVar19 = (byte *)0x0;
          uVar25 = 0x3d;
          goto LAB_0001be18;
        case 0x1b49c:
          FUN_0001ce24();
          if (!(bool)uVar9) {
            FUN_0001cd4c();
            uVar25 = 0x3d;
            puVar28 = extraout_x10_28;
            goto LAB_0001c000;
          }
          *puVar28 = 0;
          if (plVar18[9] != 0) {
            FUN_0001d058(0x35);
            iVar13 = FUN_0001ce30(plVar18[9]);
            if (iVar13 == 0) {
              FUN_0001cdac();
            }
            else {
              *puVar28 = 0;
              uVar23 = (ulong)*puVar15;
              puVar16 = puVar15;
              FUN_0001cfa0(10);
            }
            FUN_0001cde8();
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            uVar21 = uVar23;
            goto joined_r0x0001b4dc;
          }
          uVar12 = 0;
          uVar25 = 0x35;
          goto LAB_0001be18;
        case 0x1b4e8:
          if (pbVar19 != (byte *)0x0) {
            pbVar38 = pbVar19;
          }
          uVar25 = 0x3f;
          pbVar19 = pbVar38;
          pbVar38 = pbVar36;
          goto switchD_0001b3b8_caseD_c;
        case 0x1b4f8:
          uVar22 = uVar21;
          uVar37 = uVar23;
          iVar13 = FUN_0001d01c();
          if (iVar13 == 0) {
            uVar25 = 1;
          }
          else {
            uVar9 = (*(byte *)param_1 & 3) == 0;
            uVar11 = 0x12;
            if (!(bool)uVar9) {
              uVar11 = 4;
            }
            uVar25 = (ulong)uVar11;
          }
          if (param_2[7] == 0) {
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            uVar37 = uVar23 & 0xffffffff;
            puVar16 = puVar15;
            plVar18 = param_2;
          }
          else {
            plVar18 = param_2;
            uVar11 = FUN_0001d034();
            *param_1 = extraout_w8_13 & 0xffff8000 | extraout_w8_13 & 0x3ff | (uVar11 & 0x1f) << 10;
            iVar13 = FUN_0001ce30(plVar18[7]);
            if (iVar13 == 0) {
              FUN_0001cdac();
            }
            else {
              FUN_0001cd94();
              uVar37 = (ulong)(extraout_w8_17 | 0x7000000);
              *puVar16 = extraout_w8_17 | 0x7000000;
            }
            puVar17 = &switchD_0001a444::switchdataD_00026958;
            FUN_0001cde8();
            if (!(bool)uVar9) goto LAB_0001c410;
            uVar25 = FUN_0001ce98();
            uVar20 = (uint)uVar22;
            uVar21 = uVar22;
          }
          uVar23 = uVar37;
          if ((int)uVar20 < 0) {
            FUN_0001d024();
            goto LAB_0001c410;
          }
          goto switchD_0001b3b8_caseD_c;
        case 0x1b524:
          bVar6 = uVar31 == 0xd;
          uVar11 = 0x37;
          goto LAB_0001b530;
        }
        FUN_0001ce24();
        uVar11 = (uint)uVar21;
        if (!(bool)uVar9) {
          *puVar28 = uVar12;
          uVar24 = uVar11 & 0x80ffffff | 0x1e000000;
LAB_0001c0b4:
          uVar21 = (ulong)uVar24;
          *puVar16 = uVar24;
          uVar25 = 0x39;
          goto LAB_0001c000;
        }
        uVar20 = *param_1;
        if ((uVar20 >> 6 & 1) != 0) {
          uVar37 = 10;
          uVar25 = 0x40;
          if (plVar18[9] != 0) {
            *param_1 = uVar20 & 0xfffe03ff | 0x10000;
            iVar13 = FUN_0001ce30(plVar18[9]);
            if (iVar13 == 0) {
              FUN_0001cdac();
            }
            else {
              *puVar28 = uVar12;
              uVar23 = (ulong)*puVar15;
              puVar16 = puVar15;
              FUN_0001cfa0(10);
            }
            FUN_0001d0d0();
            goto LAB_0001aa60;
          }
          goto switchD_0001abac_caseD_4;
        }
        if ((((uVar20 ^ 0xffffffff) & 0x20000200) == 0) &&
           ((-1 < (int)uVar24 || ((uVar20 >> 2 & 1) != 0)))) {
          *puVar28 = uVar12;
          uVar24 = uVar11 & 0x80000000 | uVar11 & 0xffffff | 0x1a000000;
          goto LAB_0001c0b4;
        }
        bVar6 = (uVar11 & 0xff0000) == 0x50000;
        if (((uVar20 ^ 0xffffffff) & 0xa0) == 0) {
          bVar6 = (uVar11 & 0xffff) == 0x65 || (uVar20 & 3) == 0;
        }
        uVar20 = 0x80000000;
        if (!bVar6) {
          uVar20 = 0;
        }
        *puVar16 = uVar20 | uVar11 & 0x7fffffff;
        if ((code *)plVar18[5] == (code *)0x0) {
LAB_0001a974:
          uVar37 = 10;
          uVar21 = (ulong)*puVar16;
          uVar25 = 0x3a;
          uVar23 = uVar21;
          if ((*puVar16 & 0x7f000000) == 0) goto switchD_0001abac_caseD_4;
          param_1[1] = uVar12;
          uVar12 = *param_1 & 0xfffe0000 | *param_1 & 0x3ff | 0xe800;
        }
        else {
          iVar13 = (*(code *)plVar18[5])(param_1);
          puVar17 = &switchD_0001a444::switchdataD_00026958;
          puVar16 = puVar15;
          plVar18 = param_2;
          if (iVar13 == 0) goto LAB_0001a974;
          if (iVar13 == 1) {
LAB_0001a968:
            *param_1 = *param_1 | 0x100;
            goto LAB_0001a974;
          }
          if (iVar13 == 2) {
            *puVar15 = *puVar15 | 0x80000000;
            goto LAB_0001a968;
          }
          param_1[5] = param_1[5] & 0x80000000 | param_1[5] & 0xffffff | 0x5000000;
          param_1[1] = uVar12;
          uVar12 = *param_1 & 0xfffe0000 | *param_1 & 0x3ff | 0xe800;
        }
        *param_1 = uVar12;
        goto LAB_0001c240;
      }
      *puVar28 = uVar12;
      uVar21 = (ulong)((uint)uVar23 & 0x80ffffff | 0xc000000);
LAB_0001c2a0:
      *puVar16 = (uint)uVar21;
      goto LAB_0001c000;
    }
    if (0x3f < uVar11) {
LAB_0001c048:
      FUN_0001cf7c(0xb);
      return 1;
    }
    if ((1L << (uVar25 & 0x3f) & 0x40016U) == 0) {
      if (uVar25 != 0x3f) goto LAB_0001c048;
      if (param_2[7] != 0) {
        *param_1 = uVar24 & 0xfffe03ff | 0xfc00;
        iVar13 = FUN_0001ce30(param_2[7]);
        if (iVar13 != 0) {
          *puVar28 = uVar12;
          *puVar15 = *puVar15 & 0x80ffffff | 0x7000000;
          return 0;
        }
      }
    }
  }
  return 0;
LAB_0001aa78:
  FUN_0001ce54((int)pbVar34 - (int)pbVar38);
  if (bVar6 && !(bool)uVar9) {
    FUN_0001ce68();
    uVar25 = 0x34;
    puVar28 = extraout_x10_29;
    pbVar38 = pbVar34;
    goto LAB_0001c000;
  }
  *param_1 = extraout_w11_07;
  uVar37 = 10;
  uVar25 = 0x34;
  bVar6 = pbVar39 != (byte *)0x0;
  pbVar39 = (byte *)0x0;
  pbVar38 = pbVar34;
  if (bVar6) {
    uVar37 = 10;
    uVar25 = 0x34;
    pbVar39 = (byte *)0x0;
    if (plVar18[4] != 0) {
      iVar13 = FUN_0001cee8();
      if (iVar13 == 0) {
        FUN_0001cdac();
      }
      else {
        *puVar28 = uVar12;
        FUN_0001ce80();
      }
      FUN_0001d0d0();
      uVar25 = FUN_0001cde8();
      puVar17 = &switchD_0001a444::switchdataD_00026958;
      pbVar39 = extraout_x9_03;
      if (!(bool)uVar9) {
        return (long)pbVar34 - (long)param_3;
      }
    }
  }
  goto switchD_0001abac_caseD_4;
joined_r0x0001b124:
  bVar6 = pbVar34 == pbVar1;
  if (bVar6) goto LAB_0001b818;
  uVar25 = (ulong)*pbVar34;
  bVar8 = 0x1f < uVar25;
  bVar6 = uVar25 == 0x20;
  if ((bVar6) || (cVar3 = puVar26[uVar25], cVar3 == '\0')) {
    FUN_0001ce54((int)pbVar34 - (int)pbVar38);
    pbVar38 = pbVar34;
    if (bVar8 && !bVar6) {
      *puVar28 = uVar12;
      uVar24 = (uint)uVar21 & 0x80ffffff | 0xc000000;
    }
    else {
      uVar9 = extraout_w10_05 == 0x3a;
      if ((bool)uVar9) {
        if (local_90 == (byte *)0x0) {
          local_90 = (byte *)0x0;
          uVar25 = 0x2e;
        }
        else if (plVar18[3] == 0) {
          local_90 = (byte *)0x0;
          uVar25 = 0x2e;
LAB_0001be18:
          puVar17 = &switchD_0001a444::switchdataD_00026958;
          puVar16 = puVar15;
        }
        else {
          FUN_0001d058(0x2e);
          puVar16 = (uint *)(pbVar34 + -extraout_x1_00);
          iVar13 = FUN_0001cf00(plVar18[3]);
          if (iVar13 == 0) {
            FUN_0001cdac();
          }
          else {
            FUN_0001cd94();
            uVar23 = (ulong)(extraout_w8_19 | 0x3000000);
            *puVar16 = extraout_w8_19 | 0x3000000;
          }
          puVar17 = &switchD_0001a444::switchdataD_00026958;
          FUN_0001cde8();
          if (!(bool)uVar9) {
LAB_0001c454:
            lVar27 = (long)pbVar34 - (long)param_3;
LAB_0001c418:
            return lVar27 + 1;
          }
          local_90 = (byte *)0x0;
          uVar25 = FUN_0001ce98();
        }
        goto switchD_0001b3b8_caseD_c;
      }
      *puVar28 = uVar12;
      uVar24 = (uint)uVar21 & 0x80ffffff | 0x18000000;
    }
    uVar21 = (ulong)uVar24;
    *puVar16 = uVar24;
    uVar25 = 0x2d;
    goto LAB_0001c000;
  }
  uVar20 = *param_1;
  uVar29 = uVar20 >> 0x11 & 0x7f;
  bVar8 = 0xd < uVar29;
  bVar6 = uVar29 == 0xe;
  uVar11 = uVar20;
  switch(uVar29) {
  case 0:
    uVar25 = (long)pbVar1 - (long)pbVar34;
    if (0x13fff < (ulong)((long)pbVar1 - (long)pbVar34)) {
      uVar25 = 0x14000;
    }
    pbVar30 = pbVar34 + uVar25;
    pbVar32 = pbVar34;
    do {
      pbVar34 = pbVar32;
      pbVar32 = pbVar34 + 1;
      if ((pbVar30 <= pbVar32) || ((ulong)*pbVar32 == 0x20)) break;
    } while (puVar26[*pbVar32] != '\0');
    break;
  case 1:
    FUN_0001d0a8();
    uVar11 = extraout_w10 & 0xfff80000 | extraout_w10 & 0x3ffff | (extraout_w11_09 & 1) << 0x12;
    puVar26 = extraout_x8_04;
    uVar20 = extraout_w12;
    goto LAB_0001b1dc;
  case 2:
    FUN_0001d0a8();
    uVar11 = 0x60000;
    if (extraout_w11_10 != 0x6e) {
      uVar11 = 0;
    }
    uVar11 = extraout_w10_00 | uVar11;
    puVar26 = extraout_x8_05;
    uVar20 = extraout_w12_00;
LAB_0001b1dc:
    uVar11 = uVar11 | uVar20;
    goto LAB_0001b334;
  case 3:
    uVar29 = (uVar20 + 0x1000000 >> 0x18 & 0x1f) << 0x18;
    uVar31 = uVar20 & 0xe0000000;
    uVar11 = uVar31 | uVar20 & 0xffffff | uVar29;
    *param_1 = uVar11;
    if (cVar3 == 't') {
      uVar11 = uVar31 | uVar20 & 0x1ffff | uVar29 | 0xc0000;
    }
    else {
      if (cVar3 != 'n') goto switchD_0001b160_caseD_9;
      uVar11 = uVar31 | uVar20 & 0x1ffff | uVar29 | 0x80000;
    }
    goto LAB_0001b334;
  case 4:
    FUN_0001cf08();
    puVar26 = extraout_x8_06;
    uVar11 = extraout_w10_01;
    if ((bVar8 && !bVar6) || ("connection"[extraout_x12_03] != extraout_w11))
    goto switchD_0001b160_caseD_9;
    if ((int)extraout_x12_03 == 9) {
LAB_0001b264:
      iVar13 = 9;
LAB_0001b298:
      uVar11 = uVar11 & 0xff000000 | uVar11 & 0x1ffff | iVar13 << 0x11;
      goto LAB_0001b334;
    }
    break;
  case 5:
    FUN_0001ce38();
    puVar26 = extraout_x8_07;
    uVar11 = extraout_w10_02;
    if ((0x10 < (uint)extraout_x12_04) || ("proxy-connection"[extraout_x12_04] != extraout_w11_00))
    goto switchD_0001b160_caseD_9;
    if ((uint)extraout_x12_04 == 0xf) goto LAB_0001b264;
    break;
  case 6:
    FUN_0001ce38();
    puVar26 = extraout_x8_08;
    uVar11 = extraout_w10_03;
    if ((0xe < (uint)extraout_x12_05) || ("content-length"[extraout_x12_05] != extraout_w11_01))
    goto switchD_0001b160_caseD_9;
    if ((uint)extraout_x12_05 == 0xd) {
      iVar13 = 10;
      goto LAB_0001b298;
    }
    break;
  case 7:
    uVar11 = (uVar20 + 0x1000000 >> 0x18 & 0x1f) << 0x18;
    uVar29 = uVar20 & 0xe0000000 | uVar20 & 0xffffff | uVar11;
    *param_1 = uVar29;
    uVar25 = (ulong)(uVar20 + 0x1000000 >> 0x18) & 0x1f;
    uVar31 = (uint)uVar25;
    if ((uVar31 < 0x12) && ("transfer-encoding"[uVar25] == cVar3)) {
      if (uVar31 != 0x10) break;
      uVar11 = uVar20 & 0x40000000 | uVar29 & 0x9f01ffff | 0x201a0000;
    }
    else {
      uVar11 = uVar20 & 0xe0000000 | uVar20 & 0x1ffff | uVar11;
    }
    goto LAB_0001b334;
  case 8:
    FUN_0001cdf4();
    puVar26 = extraout_x8_09;
    uVar11 = extraout_w10_04;
    if ((bVar8 && !bVar6) || (*(char *)(extraout_x9_04 + extraout_x12_06) != extraout_w11_02))
    goto switchD_0001b160_caseD_9;
    if ((int)extraout_x12_06 == 6) {
      uVar11 = extraout_w10_04 & 0xff01ffff | 0x1c0000;
      goto LAB_0001b334;
    }
    break;
  case 9:
  case 10:
  case 0xd:
  case 0xe:
switchD_0001b160_caseD_9:
    uVar11 = uVar11 & 0xff01ffff;
LAB_0001b334:
    *param_1 = uVar11;
  }
  pbVar34 = pbVar34 + 1;
  pbVar30 = pbVar38;
  goto joined_r0x0001b124;
LAB_0001b818:
  bVar8 = pbVar1 <= pbVar34;
  FUN_0001ce54((int)pbVar36 - (int)pbVar30);
  if (bVar8 && !bVar6) {
    FUN_0001ce68();
    uVar25 = 0x2d;
    puVar28 = extraout_x10_48;
    pbVar38 = pbVar36;
LAB_0001c000:
    if ((uVar21 & 0x7f000000) == 0) {
      *puVar28 = uVar12;
      *puVar16 = (uint)uVar21 & 0x80ffffff | 0x20000000;
    }
    FUN_0001d024(uVar25);
    return (long)pbVar38 - extraout_x9_07;
  }
  uVar25 = 0x2d;
  pbVar38 = pbVar36;
  goto switchD_0001b3b8_caseD_c;
switchD_0001a444_caseD_1a8a0:
  uVar25 = 0x39;
  if (uVar31 != 10) goto LAB_0001acf4;
  goto switchD_0001abac_caseD_4;
LAB_0001acf4:
  if (uVar31 != 0xd) {
    if ((uVar31 == 0x20) || (cVar3 = (&DAT_00026acc)[uVar37], cVar3 == '\0')) {
      FUN_0001cff8();
      uVar25 = 0x2c;
      puVar28 = extraout_x10_07;
      goto LAB_0001c000;
    }
    if (local_90 != (byte *)0x0) {
      pbVar34 = local_90;
    }
    uVar11 = *param_1;
    *param_1 = uVar11 & 0xe0ffffff;
    if (cVar3 == 'u') {
      uVar11 = uVar11 & 0xe001ffff | 0x100000;
    }
    else if (cVar3 == 'p') {
      uVar11 = uVar11 & 0xe0000000 | uVar11 & 0x1ffff | 0xa0000;
    }
    else {
      uVar11 = uVar11 & 0xe001ffff;
      if (cVar3 == 't') {
        uVar11 = uVar11 | 0xe0000;
      }
      else if (cVar3 == 'c') {
        uVar11 = uVar11 | 0x20000;
      }
    }
    *param_1 = uVar11;
    uVar25 = 0x2d;
    local_90 = pbVar34;
  }
switchD_0001b3b8_caseD_c:
  pbVar38 = pbVar38 + 1;
  uVar9 = pbVar38 == pbVar1;
  if ((bool)uVar9) {
    pbVar38 = pbVar19;
    if ((local_90 != (byte *)0x0) && (plVar18[3] != 0)) {
      auVar40 = FUN_0001cf28();
      iVar13 = FUN_0001cf00(plVar18[3],auVar40._0_8_,auVar40._8_8_,(long)pbVar1 - auVar40._8_8_);
      if (iVar13 == 0) {
        FUN_0001cf38();
      }
      else {
        FUN_0001cd7c();
        *extraout_x9_08 = extraout_w8_23 | 0x3000000;
      }
      FUN_0001d09c();
      if (!(bool)uVar9) {
        return param_4;
      }
      FUN_0001cf88();
    }
    if ((pbVar39 != (byte *)0x0) && (pbVar38 = pbVar19, plVar18[4] != 0)) {
      FUN_0001cf28();
      iVar13 = (*(code *)plVar18[4])(param_1,pbVar39,(long)pbVar1 - (long)pbVar39);
      if (iVar13 == 0) {
        FUN_0001cf38();
      }
      else {
        FUN_0001cd7c();
        *extraout_x9_09 = extraout_w8_24 | 0x4000000;
      }
      FUN_0001d09c();
      if (!(bool)uVar9) {
        return param_4;
      }
      FUN_0001cf88();
    }
    if ((pbVar35 != (byte *)0x0) && (pbVar38 = pbVar19, plVar18[1] != 0)) {
      uVar14 = FUN_0001cf28();
      iVar13 = FUN_0001cf00(plVar18[1],uVar14,pbVar35,(long)pbVar1 - (long)pbVar35);
      if (iVar13 == 0) {
        FUN_0001cf38();
      }
      else {
        FUN_0001cd7c();
        *extraout_x9_10 = extraout_w8_25 | 0x2000000;
      }
      FUN_0001d09c();
      if (!(bool)uVar9) {
        return param_4;
      }
      FUN_0001cf88();
      pbVar38 = pbVar19;
    }
    if ((pbVar38 != (byte *)0x0) && (plVar18[6] != 0)) {
      auVar40 = FUN_0001cf28();
      iVar13 = FUN_0001d090(plVar18[6],auVar40._0_8_,auVar40._8_8_,(long)pbVar1 - (long)pbVar38);
      if (iVar13 == 0) {
        FUN_0001cf38();
      }
      else {
        FUN_0001cd7c();
        *extraout_x9_11 = extraout_w8_26 | 0x6000000;
      }
      FUN_0001d09c();
      if (!(bool)uVar9) {
        return param_4;
      }
      FUN_0001cf88();
    }
    if ((local_78 != (byte *)0x0) && (plVar18[2] != 0)) {
      FUN_0001d0bc();
      iVar13 = (*extraout_x8_12)(param_1,local_78,(long)pbVar1 - (long)local_78);
      if (iVar13 == 0) {
        FUN_0001cf38();
        uVar21 = extraout_x8_13;
      }
      else {
        FUN_0001cd7c();
        uVar21 = (ulong)(extraout_w8_27 | 0x8000000);
        *extraout_x9_12 = extraout_w8_27 | 0x8000000;
      }
      if ((uVar21 & 0x7f000000) != 0) {
        return param_4;
      }
      FUN_0001cf88();
    }
    FUN_0001d024();
    return extraout_x10_06;
  }
  goto LAB_0001a3e8;
}



undefined4 FUN_0001c698(undefined4 param_1,uint param_2)

{
  byte bVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  
  if ((param_2 < 0x21) && ((1L << ((ulong)param_2 & 0x3f) & 0x100003600U) != 0)) {
    return 1;
  }
  switch(param_1) {
  case 0x14:
    if (param_2 == 0x2a) {
      return 0x1b;
    }
    if (param_2 == 0x2f) {
      return 0x1b;
    }
    if (((param_2 | 0x20) - 0x61 & 0xff) < 0x1a) {
      return 0x15;
    }
    break;
  case 0x15:
    if (((param_2 | 0x20) - 0x61 & 0xff) < 0x1a) {
      return 0x15;
    }
    if (param_2 == 0x3a) {
      return 0x16;
    }
    break;
  case 0x16:
    if (param_2 == 0x2f) {
      return 0x17;
    }
    break;
  case 0x17:
    if (param_2 == 0x2f) {
      return 0x18;
    }
    break;
  case 0x18:
  case 0x19:
    if (param_2 == 0x40) {
      return 0x1a;
    }
    if (param_2 == 0x3f) {
      return 0x1c;
    }
    if (param_2 == 0x2f) {
      return 0x1b;
    }
    goto LAB_0001c79c;
  case 0x1a:
    if (param_2 == 0x2f) {
      return 0x1b;
    }
    if (param_2 == 0x3f) {
      return 0x1c;
    }
    if (param_2 == 0x40) {
      return 1;
    }
LAB_0001c79c:
    if (param_2 - 0x30 < 10 || ((param_2 | 0x20) - 0x61 & 0xff) < 0x1a) {
      return 0x19;
    }
    if ((param_2 - 0x21 < 0x3f) &&
       ((1L << ((ulong)(param_2 - 0x21) & 0x3f) & 0x5400000016003ff9U) != 0)) {
      return 0x19;
    }
    if (param_2 == 0x7e) {
      return 0x19;
    }
    break;
  case 0x1b:
    uVar4 = 0x1b;
    bVar1 = (byte)(&DAT_00026aac)[((ulong)param_2 & 0xf8) >> 3] >> (ulong)(param_2 & 7);
    uVar2 = 0x1e;
    if (param_2 != 0x23) {
      uVar2 = 1;
    }
    uVar3 = 0x1c;
    if (param_2 != 0x3f) {
      uVar3 = uVar2;
    }
    goto LAB_0001c858;
  case 0x1c:
  case 0x1d:
    bVar1 = (&DAT_00026aac)[((ulong)param_2 & 0xf8) >> 3];
    uVar4 = 0x1d;
    goto LAB_0001c840;
  case 0x1e:
    bVar1 = (&DAT_00026aac)[((ulong)param_2 & 0xf8) >> 3];
    uVar4 = 0x1f;
LAB_0001c840:
    bVar1 = bVar1 >> (ulong)(param_2 & 7);
    uVar2 = 0x1e;
    if (param_2 != 0x23) {
      uVar2 = 1;
    }
    uVar3 = uVar4;
    if (param_2 != 0x3f) {
      uVar3 = uVar2;
    }
LAB_0001c858:
    if ((bVar1 & 1) == 0) {
      uVar4 = uVar3;
    }
    return uVar4;
  case 0x1f:
    if (((byte)(&DAT_00026aac)[((ulong)param_2 & 0xf8) >> 3] >> (ulong)(param_2 & 7) & 1) != 0) {
      return 0x1f;
    }
    if (param_2 == 0x23) {
      return 0x1f;
    }
    if (param_2 == 0x3f) {
      return 0x1f;
    }
  }
  return 1;
}



bool FUN_0001c8c0(byte *param_1)

{
  int iVar1;
  
  if ((*(short *)(param_1 + 0x10) == 0) || (*(short *)(param_1 + 0x12) == 0)) {
    if ((*param_1 >> 3 & 1) != 0) goto LAB_0001c8f0;
  }
  else if ((*param_1 >> 4 & 1) == 0) {
LAB_0001c8f0:
    iVar1 = FUN_0001c904();
    return iVar1 == 0;
  }
  return false;
}



bool FUN_0001c904(uint *param_1)

{
  uint uVar1;
  ushort uVar2;
  bool bVar3;
  
  uVar1 = *param_1;
  if ((uVar1 & 3) != 0) {
    bVar3 = false;
    if ((uVar1 >> 8 & 1) == 0) {
      uVar2 = *(ushort *)(param_1 + 5);
      if ((((uVar2 != 0x130) && (uVar2 != 0xcc)) && (99 < uVar2 - 100)) &&
         ((bVar3 = (uVar1 & 0x20000004) == 0x20000000, !bVar3 && ((uVar1 >> 2 & 1) == 0)))) {
        bVar3 = *(long *)(param_1 + 2) == -1;
      }
    }
    return bVar3;
  }
  return false;
}



char * FUN_0001c974(int param_1)

{
  switch(param_1) {
  case 400:
    return "Bad Request";
  case 0x191:
    return "Unauthorized";
  case 0x192:
    return "Payment Required";
  case 0x193:
    return "Forbidden";
  case 0x194:
    return "Not Found";
  case 0x195:
    return "Method Not Allowed";
  case 0x196:
    return "Not Acceptable";
  case 0x197:
    return "Proxy Authentication Required";
  case 0x198:
    return "Request Timeout";
  case 0x199:
    return "Conflict";
  case 0x19a:
    return "Gone";
  case 0x19b:
    return "Length Required";
  case 0x19c:
    return "Precondition Failed";
  case 0x19d:
    return "Payload Too Large";
  case 0x19e:
    return "URI Too Long";
  case 0x19f:
    return "Unsupported Media Type";
  case 0x1a0:
    return "Range Not Satisfiable";
  case 0x1a1:
    return "Expectation Failed";
  case 0x1a2:
  case 0x1a3:
  case 0x1a4:
  case 0x1a9:
  case 0x1ab:
  case 0x1ae:
  case 0x1b0:
  case 0x1b1:
  case 0x1b2:
  case 0x1b3:
  case 0x1b4:
  case 0x1b5:
  case 0x1b6:
  case 0x1b7:
  case 0x1b8:
  case 0x1b9:
  case 0x1ba:
  case 0x1bb:
  case 0x1bc:
  case 0x1bd:
  case 0x1be:
  case 0x1bf:
  case 0x1c0:
  case 0x1c1:
  case 0x1c2:
    goto switchD_0001c9b8_caseD_132;
  case 0x1a5:
    return "Misdirected Request";
  case 0x1a6:
    return "Unprocessable Entity";
  case 0x1a7:
    return "Locked";
  case 0x1a8:
    return "Failed Dependency";
  case 0x1aa:
    return "Upgrade Required";
  case 0x1ac:
    return "Precondition Required";
  case 0x1ad:
    return "Too Many Requests";
  case 0x1af:
    return "Request Header Fields Too Large";
  case 0x1c3:
    return "Unavailable For Legal Reasons";
  default:
    switch(param_1) {
    case 500:
      return "Internal Server Error";
    case 0x1f5:
      return "Not Implemented";
    case 0x1f6:
      return "Bad Gateway";
    case 0x1f7:
      return "Service Unavailable";
    case 0x1f8:
      return "Gateway Timeout";
    case 0x1f9:
      return "HTTP Version Not Supported";
    case 0x1fa:
      return "Variant Also Negotiates";
    case 0x1fb:
      return "Insufficient Storage";
    case 0x1fc:
      return "Loop Detected";
    case 0x1fd:
      break;
    case 0x1fe:
      return "Not Extended";
    case 0x1ff:
      return "Network Authentication Required";
    default:
      switch(param_1) {
      case 200:
        return "OK";
      case 0xc9:
        return "Created";
      case 0xca:
        return "Accepted";
      case 0xcb:
        return "Non-Authoritative Information";
      case 0xcc:
        return "No Content";
      case 0xcd:
        return "Reset Content";
      case 0xce:
        return "Partial Content";
      case 0xcf:
        return "Multi-Status";
      case 0xd0:
        return "Already Reported";
      }
      switch(param_1) {
      case 300:
        return "Multiple Choices";
      case 0x12d:
        return "Moved Permanently";
      case 0x12e:
        return "Found";
      case 0x12f:
        return "See Other";
      case 0x130:
        return "Not Modified";
      case 0x131:
        return "Use Proxy";
      case 0x132:
        break;
      case 0x133:
        return "Temporary Redirect";
      case 0x134:
        return "Permanent Redirect";
      default:
        if (param_1 == 100) {
          return "Continue";
        }
        if (param_1 == 0xe2) {
          return "IM Used";
        }
        if (param_1 == 0x66) {
          return "Processing";
        }
        if (param_1 == 0x65) {
          return "Switching Protocols";
        }
      }
    }
switchD_0001c9b8_caseD_132:
    return "<unknown>";
  }
}



void FUN_0001ccf4(undefined8 *param_1,uint param_2)

{
  uint uVar1;
  undefined8 uVar2;
  uint uVar3;
  
  uVar2 = param_1[3];
  param_1[1] = 0;
  *param_1 = 0;
  param_1[3] = 0;
  param_1[2] = 0;
  param_1[3] = uVar2;
  uVar3 = 0x1000;
  if (param_2 != 1) {
    uVar3 = 0x800;
  }
  uVar1 = 0x4800;
  if (param_2 != 0) {
    uVar1 = uVar3;
  }
  *(uint *)param_1 = uVar1 | param_2 & 3 | *(uint *)param_1 & 0xfffe03fc;
  *(uint *)((long)param_1 + 0x14) = *(uint *)((long)param_1 + 0x14) & 0x80ffffff;
  return;
}



void FUN_0001cd4c(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w6;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w6 & 0x80ffffff | 0x1e000000;
  return;
}



void FUN_0001cd64(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w7;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w7 & 0x80ffffff | 0x1e000000;
  return;
}



void FUN_0001cd7c(void)

{
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  return;
}



void FUN_0001cd94(void)

{
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  return;
}



void FUN_0001cdac(void)

{
  return;
}



void FUN_0001cdb8(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w7;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w7 & 0x80ffffff | 0xe000000;
  return;
}



void FUN_0001cdd0(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w6;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w6 & 0x80ffffff | 0xe000000;
  return;
}



void FUN_0001cde8(void)

{
  return;
}



void FUN_0001cdf4(void)

{
  uint in_w10;
  uint *unaff_x19;
  
  *unaff_x19 = in_w10 & 0xe0000000 | in_w10 & 0xffffff | (in_w10 + 0x1000000 >> 0x18 & 0x1f) << 0x18
  ;
  return;
}



void FUN_0001ce14(void)

{
  return;
}



void FUN_0001ce24(void)

{
  return;
}



void FUN_0001ce30(code *UNRECOVERED_JUMPTABLE)

{
                    // WARNING: Could not recover jumptable at 0x0001ce34. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_0001ce38(void)

{
  uint in_w10;
  uint *unaff_x19;
  
  *unaff_x19 = in_w10 & 0xe0000000 | in_w10 & 0xffffff | (in_w10 + 0x1000000 >> 0x18 & 0x1f) << 0x18
  ;
  return;
}



void FUN_0001ce54(void)

{
  return;
}



void FUN_0001ce68(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w6;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w6 & 0x80ffffff | 0xc000000;
  return;
}



void FUN_0001ce80(void)

{
  uint *param_11;
  
  *param_11 = *param_11 & 0x80ffffff | 0x4000000;
  return;
}



uint FUN_0001ce98(void)

{
  uint *unaff_x19;
  
  return *unaff_x19 >> 10 & 0x7f;
}



void FUN_0001cea8(void)

{
  undefined4 unaff_w25;
  undefined4 *param_11;
  uint *param_12;
  
  *param_11 = unaff_w25;
  *param_12 = *param_12 & 0x80ffffff | 0x6000000;
  return;
}



void FUN_0001cec8(void)

{
  undefined4 unaff_w25;
  undefined4 *param_11;
  uint *param_12;
  
  *param_11 = unaff_w25;
  *param_12 = *param_12 & 0x80ffffff | 0x1000000;
  return;
}



void FUN_0001cee8(void)

{
  long in_x4;
  undefined4 in_w11;
  undefined4 *unaff_x19;
  
  *unaff_x19 = in_w11;
                    // WARNING: Could not recover jumptable at 0x0001cefc. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(in_x4 + 0x20))();
  return;
}



void FUN_0001cf00(code *UNRECOVERED_JUMPTABLE)

{
                    // WARNING: Could not recover jumptable at 0x0001cf04. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_0001cf08(void)

{
  uint in_w10;
  uint *unaff_x19;
  
  *unaff_x19 = in_w10 & 0xe0000000 | in_w10 & 0xffffff | (in_w10 + 0x1000000 >> 0x18 & 0x1f) << 0x18
  ;
  return;
}



void FUN_0001cf28(uint param_1)

{
  uint *unaff_x19;
  
  *unaff_x19 = *unaff_x19 & 0xfffe0000 | *unaff_x19 & 0x3ff | (param_1 & 0x7f) << 10;
  return;
}



void FUN_0001cf38(void)

{
  return;
}



void FUN_0001cf44(void)

{
  undefined4 *param_11;
  
  *param_11 = 0;
  return;
}



undefined4 FUN_0001cf60(int param_1)

{
  undefined4 uVar1;
  uint unaff_w20;
  
  uVar1 = 0x12;
  if ((unaff_w20 & 3) != 0) {
    uVar1 = 4;
  }
  if (param_1 == 0) {
    uVar1 = 1;
  }
  return uVar1;
}



void FUN_0001cf7c(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w6;
  uint in_w8;
  
  *param_3 = in_w6 & 0x80000000 | in_w6 & 0xffffff | (in_w8 & 0x7f) << 0x18;
  return;
}



uint FUN_0001cf88(void)

{
  uint *unaff_x19;
  
  return *unaff_x19 >> 10 & 0x7f;
}



void FUN_0001cf94(void)

{
  return;
}



void FUN_0001cfa0(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w7;
  uint in_w8;
  
  *param_3 = in_w7 & 0x80000000 | in_w7 & 0xffffff | (in_w8 & 0x7f) << 0x18;
  return;
}



void FUN_0001cfac(void)

{
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  return;
}



void FUN_0001cfb8(void)

{
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  return;
}



void FUN_0001cfc8(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w7;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w7 & 0x80ffffff | 0x1c000000;
  return;
}



void FUN_0001cfe0(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w7;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w7 & 0x80ffffff | 0xf000000;
  return;
}



void FUN_0001cff8(undefined8 param_1,undefined8 param_2,uint *param_3)

{
  uint in_w6;
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  *param_3 = in_w6 & 0x80ffffff | 0x18000000;
  return;
}



void FUN_0001d010(void)

{
  return;
}



void FUN_0001d01c(void)

{
  FUN_0001c8c0();
  return;
}



void FUN_0001d024(uint param_1)

{
  uint *unaff_x19;
  uint unaff_w25;
  
  *unaff_x19 = *unaff_x19 & 0xfffe0000 | *unaff_x19 & 0x3ff | (param_1 & 0x7f) << 10;
  unaff_x19[1] = unaff_w25;
  return;
}



void FUN_0001d034(void)

{
  return;
}



void FUN_0001d040(void)

{
  return;
}



void FUN_0001d058(void)

{
  uint in_w8;
  uint *unaff_x19;
  
  *unaff_x19 = *unaff_x19 & 0xfffe0000 | *unaff_x19 & 0x3ff | (in_w8 & 0x7f) << 10;
  return;
}



void FUN_0001d068(void)

{
  undefined4 unaff_w25;
  undefined4 *param_11;
  
  *param_11 = unaff_w25;
  return;
}



void FUN_0001d07c(void)

{
  undefined4 in_w10;
  undefined4 *unaff_x19;
  
  *unaff_x19 = in_w10;
  *(undefined8 *)(unaff_x19 + 2) = 0xffffffffffffffff;
  return;
}



void FUN_0001d090(code *UNRECOVERED_JUMPTABLE)

{
                    // WARNING: Could not recover jumptable at 0x0001d098. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}



void FUN_0001d09c(void)

{
  return;
}



void FUN_0001d0a8(void)

{
  return;
}



void FUN_0001d0bc(uint param_1)

{
  uint *unaff_x19;
  
  *unaff_x19 = *unaff_x19 & 0xfffe0000 | *unaff_x19 & 0x3ff | (param_1 & 0x7f) << 10;
  return;
}



uint FUN_0001d0d0(void)

{
  uint *unaff_x19;
  
  return *unaff_x19 >> 10 & 0x7f;
}



long _ahpl_http_parser_create(undefined8 param_1,undefined8 param_2)

{
  long lVar1;
  
  lVar1 = _ahpl_malloc(0x30);
  if (lVar1 != 0) {
    FUN_0001ccf4(lVar1,2);
    *(undefined8 *)(lVar1 + 0x18) = param_2;
    *(undefined8 *)(lVar1 + 0x20) = param_1;
    *(undefined4 *)(lVar1 + 0x28) = 0;
  }
  return lVar1;
}



undefined8 _ahpl_http_parser_arg(long param_1)

{
  return *(undefined8 *)(param_1 + 0x18);
}



void _ahpl_http_parser_reset(long param_1)

{
  FUN_0001ccf4(param_1,2);
  *(undefined4 *)(param_1 + 0x28) = 0;
  return;
}



undefined8 _ahpl_http_parser_execute(long param_1,undefined8 param_2,undefined8 param_3)

{
  undefined8 uVar1;
  
  uVar1 = FUN_0001a334(param_1,&DAT_00028d68,param_2,param_3);
  if ((*(byte *)(param_1 + 0x17) & 0x7f) != 0) {
    if (*(code **)(param_1 + 0x20) != (code *)0x0) {
      (**(code **)(param_1 + 0x20))(param_1,*(byte *)(param_1 + 0x17) & 0x7f);
    }
    _ahpl_http_parser_reset(param_1);
    uVar1 = 0xffffffffffffffff;
  }
  return uVar1;
}



ulong _ahpl_http_parser_major(long param_1)

{
  ulong uVar1;
  
  if ((*(byte *)(param_1 + 0x28) & 1) == 0) {
    uVar1 = FUN_0001d558();
    return uVar1;
  }
  return (ulong)*(ushort *)(param_1 + 0x10);
}



ulong _ahpl_http_parser_minor(long param_1)

{
  ulong uVar1;
  
  if ((*(byte *)(param_1 + 0x28) & 1) == 0) {
    uVar1 = FUN_0001d558();
    return uVar1;
  }
  return (ulong)*(ushort *)(param_1 + 0x12);
}



byte _ahpl_http_parser_errno(long param_1)

{
  return *(byte *)(param_1 + 0x17) & 0x7f;
}



undefined8 _ahpl_http_parser_errno_name(ulong param_1)

{
  return *(undefined8 *)(&DAT_00028790 + (param_1 & 0xffffffff) * 0x10);
}



undefined8 _ahpl_http_parser_errno_descr(ulong param_1)

{
  return *(undefined8 *)(&DAT_00028798 + (param_1 & 0xffffffff) * 0x10);
}



ulong _ahpl_http_parser_status(long param_1)

{
  ulong uVar1;
  
  if ((*(byte *)(param_1 + 0x28) & 1) == 0) {
    uVar1 = FUN_0001d558();
    return uVar1;
  }
  return (ulong)*(ushort *)(param_1 + 0x14);
}



char * _ahpl_http_parser_status_str(int param_1)

{
  switch(param_1) {
  case 400:
    return "Bad Request";
  case 0x191:
    return "Unauthorized";
  case 0x192:
    return "Payment Required";
  case 0x193:
    return "Forbidden";
  case 0x194:
    return "Not Found";
  case 0x195:
    return "Method Not Allowed";
  case 0x196:
    return "Not Acceptable";
  case 0x197:
    return "Proxy Authentication Required";
  case 0x198:
    return "Request Timeout";
  case 0x199:
    return "Conflict";
  case 0x19a:
    return "Gone";
  case 0x19b:
    return "Length Required";
  case 0x19c:
    return "Precondition Failed";
  case 0x19d:
    return "Payload Too Large";
  case 0x19e:
    return "URI Too Long";
  case 0x19f:
    return "Unsupported Media Type";
  case 0x1a0:
    return "Range Not Satisfiable";
  case 0x1a1:
    return "Expectation Failed";
  case 0x1a2:
  case 0x1a3:
  case 0x1a4:
  case 0x1a9:
  case 0x1ab:
  case 0x1ae:
  case 0x1b0:
  case 0x1b1:
  case 0x1b2:
  case 0x1b3:
  case 0x1b4:
  case 0x1b5:
  case 0x1b6:
  case 0x1b7:
  case 0x1b8:
  case 0x1b9:
  case 0x1ba:
  case 0x1bb:
  case 0x1bc:
  case 0x1bd:
  case 0x1be:
  case 0x1bf:
  case 0x1c0:
  case 0x1c1:
  case 0x1c2:
    goto switchD_0001c9b8_caseD_132;
  case 0x1a5:
    return "Misdirected Request";
  case 0x1a6:
    return "Unprocessable Entity";
  case 0x1a7:
    return "Locked";
  case 0x1a8:
    return "Failed Dependency";
  case 0x1aa:
    return "Upgrade Required";
  case 0x1ac:
    return "Precondition Required";
  case 0x1ad:
    return "Too Many Requests";
  case 0x1af:
    return "Request Header Fields Too Large";
  case 0x1c3:
    return "Unavailable For Legal Reasons";
  default:
    switch(param_1) {
    case 500:
      return "Internal Server Error";
    case 0x1f5:
      return "Not Implemented";
    case 0x1f6:
      return "Bad Gateway";
    case 0x1f7:
      return "Service Unavailable";
    case 0x1f8:
      return "Gateway Timeout";
    case 0x1f9:
      return "HTTP Version Not Supported";
    case 0x1fa:
      return "Variant Also Negotiates";
    case 0x1fb:
      return "Insufficient Storage";
    case 0x1fc:
      return "Loop Detected";
    case 0x1fd:
      break;
    case 0x1fe:
      return "Not Extended";
    case 0x1ff:
      return "Network Authentication Required";
    default:
      switch(param_1) {
      case 200:
        return "OK";
      case 0xc9:
        return "Created";
      case 0xca:
        return "Accepted";
      case 0xcb:
        return "Non-Authoritative Information";
      case 0xcc:
        return "No Content";
      case 0xcd:
        return "Reset Content";
      case 0xce:
        return "Partial Content";
      case 0xcf:
        return "Multi-Status";
      case 0xd0:
        return "Already Reported";
      }
      switch(param_1) {
      case 300:
        return "Multiple Choices";
      case 0x12d:
        return "Moved Permanently";
      case 0x12e:
        return "Found";
      case 0x12f:
        return "See Other";
      case 0x130:
        return "Not Modified";
      case 0x131:
        return "Use Proxy";
      case 0x132:
        break;
      case 0x133:
        return "Temporary Redirect";
      case 0x134:
        return "Permanent Redirect";
      default:
        if (param_1 == 100) {
          return "Continue";
        }
        if (param_1 == 0xe2) {
          return "IM Used";
        }
        if (param_1 == 0x66) {
          return "Processing";
        }
        if (param_1 == 0x65) {
          return "Switching Protocols";
        }
      }
    }
switchD_0001c9b8_caseD_132:
    return "<unknown>";
  }
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _ahpl_http_parser_destroy(void *param_1)

{
                    // WARNING: Could not recover jumptable at 0x000244fc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__free_00028270)();
  return;
}



undefined8 FUN_0001d238(long param_1)

{
  if (*(code **)(param_1 + 0x20) != (code *)0x0) {
    (**(code **)(param_1 + 0x20))(param_1,&DAT_00001001);
  }
  return 0;
}



void FUN_0001d25c(undefined8 param_1,undefined8 param_2,ulong param_3)

{
  undefined8 uVar1;
  long lVar2;
  long extraout_x8;
  code *extraout_x8_00;
  
  lVar2 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 < 0x800) {
    FUN_0001d560();
    ___memcpy_chk();
    FUN_0001d580();
    if (extraout_x8 != 0) {
      uVar1 = FUN_0001d574();
      (*extraout_x8_00)(uVar1,&DAT_00001002);
    }
    uVar1 = 0;
  }
  else {
    uVar1 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar2) {
    FUN_0001d54c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar1);
}



void FUN_0001d2dc(undefined8 param_1,undefined8 param_2,ulong param_3)

{
  undefined8 uVar1;
  long lVar2;
  long extraout_x8;
  code *extraout_x8_00;
  
  lVar2 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 < 0x40) {
    FUN_0001d524();
    FUN_0001d580();
    if (extraout_x8 != 0) {
      uVar1 = FUN_0001d574();
      (*extraout_x8_00)(uVar1,&DAT_00001003);
    }
    uVar1 = 0;
  }
  else {
    uVar1 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar2) {
    FUN_0001d53c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar1);
}



void FUN_0001d350(undefined8 param_1,undefined8 param_2,ulong param_3)

{
  undefined8 uVar1;
  long lVar2;
  long extraout_x8;
  code *extraout_x8_00;
  
  lVar2 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 < 0x40) {
    FUN_0001d524();
    FUN_0001d580();
    if (extraout_x8 != 0) {
      uVar1 = FUN_0001d574();
      (*extraout_x8_00)(uVar1,&DAT_00001004);
    }
    uVar1 = 0;
  }
  else {
    uVar1 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar2) {
    FUN_0001d53c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar1);
}



void FUN_0001d3c4(undefined8 param_1,undefined8 param_2,ulong param_3)

{
  undefined8 uVar1;
  long lVar2;
  long extraout_x8;
  code *extraout_x8_00;
  
  lVar2 = *(long *)PTR____stack_chk_guard_00028030;
  if (param_3 < 0x200) {
    FUN_0001d560();
    ___memcpy_chk();
    FUN_0001d580();
    if (extraout_x8 != 0) {
      uVar1 = FUN_0001d574();
      (*extraout_x8_00)(uVar1,&DAT_00001005);
    }
    uVar1 = 0;
  }
  else {
    uVar1 = 0xffffffff;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == lVar2) {
    FUN_0001d54c();
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar1);
}



undefined8 FUN_0001d444(long param_1)

{
  if ((*(uint *)(param_1 + 0x28) & 1) == 0) {
    *(uint *)(param_1 + 0x28) = *(uint *)(param_1 + 0x28) | 1;
    if (*(code **)(param_1 + 0x20) != (code *)0x0) {
      (**(code **)(param_1 + 0x20))(param_1,&DAT_00001006);
    }
  }
  return 0;
}



undefined8 FUN_0001d478(long param_1)

{
  if (*(code **)(param_1 + 0x20) != (code *)0x0) {
    (**(code **)(param_1 + 0x20))(param_1,&DAT_00001007);
  }
  return 0;
}



undefined8 FUN_0001d4a8(long param_1)

{
  if ((*(uint *)(param_1 + 0x28) >> 1 & 1) == 0) {
    *(uint *)(param_1 + 0x28) = *(uint *)(param_1 + 0x28) | 2;
    if (*(code **)(param_1 + 0x20) != (code *)0x0) {
      (**(code **)(param_1 + 0x20))(param_1,&DAT_00001008);
    }
  }
  return 0;
}



undefined8 FUN_0001d4dc(long param_1)

{
  if (*(code **)(param_1 + 0x20) != (code *)0x0) {
    (**(code **)(param_1 + 0x20))(param_1,&DAT_00001009);
  }
  return 0;
}



undefined8 FUN_0001d500(long param_1)

{
  if (*(code **)(param_1 + 0x20) != (code *)0x0) {
    (**(code **)(param_1 + 0x20))(param_1,&DAT_0000100a);
  }
  return 0;
}



void FUN_0001d524(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  ___memcpy_chk(&stack0x00000008,param_2,param_3,0x40);
  return;
}



void FUN_0001d53c(void)

{
  return;
}



void FUN_0001d54c(void)

{
  return;
}



undefined8 FUN_0001d558(void)

{
  return 0xffffffff;
}



undefined * FUN_0001d560(void)

{
  return &stack0x00000008;
}



void FUN_0001d574(void)

{
  return;
}



void FUN_0001d580(void)

{
  long unaff_x20;
  long unaff_x21;
  
  *(undefined *)(unaff_x21 + unaff_x20) = 0;
  return;
}



undefined8 _ahpl_xdump_attach(char *param_1,code *param_2)

{
  char *pcVar1;
  code *pcVar2;
  int iVar3;
  undefined8 uVar4;
  basic_string<> abStack_38 [24];
  
  iVar3 = FUN_00005dcc("libclang_rt.asan");
  if (((iVar3 == 0) && (iVar3 = FUN_00005dcc("libclang_rt.tsan"), iVar3 == 0)) &&
     (iVar3 = FUN_00005dcc("libclang_rt.ubsan"), iVar3 == 0)) {
    pcVar1 = "";
    if (param_1 != (char *)0x0) {
      pcVar1 = param_1;
    }
    _strlen(pcVar1);
    std::__1::basic_string<>::__init((char *)abStack_38,(ulong)pcVar1);
    pcVar2 = FUN_0001d668;
    if (param_2 != (code *)0x0) {
      pcVar2 = param_2;
    }
    uVar4 = FUN_0001dac8(abStack_38,pcVar2);
    if ((int)uVar4 == 0) {
      FUN_000090f0(FUN_0001d66c);
    }
    std::__1::basic_string<>::~basic_string(abStack_38);
  }
  else {
    uVar4 = 0xffffffff;
  }
  return uVar4;
}



void _ahpl_xdump_detach(void)

{
  FUN_00009158(FUN_0001d66c);
  FUN_0001dca4();
  return;
}



void FUN_0001d668(void)

{
  return;
}



void FUN_0001d66c(int param_1)

{
  if (param_1 * 1000 - 9000U >> 3 < 0x465) {
    FUN_0001da74(1);
    return;
  }
  return;
}



undefined8 FUN_0001d690(long param_1)

{
  pthread_t p_Var1;
  void **ppvVar2;
  size_t sVar3;
  long lVar4;
  void **ppvVar5;
  void **ppvVar6;
  
  p_Var1 = _pthread_self();
  ppvVar2 = (void **)_pthread_get_stackaddr_np(p_Var1);
  sVar3 = _pthread_get_stacksize_np(p_Var1);
  ppvVar5 = *(void ***)(*(long *)(param_1 + 0x30) + 0xf8);
  DAT_0002e690 = *(undefined8 *)(*(long *)(param_1 + 0x30) + 0x110);
  lVar4 = FUN_00005ed4();
  if (lVar4 == 0) {
    do {
      if (ppvVar5 < (void **)((long)ppvVar2 - sVar3) || ppvVar2 <= ppvVar5) {
        return 1;
      }
      ppvVar6 = (void **)*ppvVar5;
      lVar4 = FUN_00005ed4(ppvVar5[1]);
      ppvVar5 = ppvVar6;
    } while (lVar4 == 0);
  }
  DAT_0002e698 = lVar4;
  return 0;
}



bool FUN_0001d720(undefined8 param_1,long *param_2)

{
  bool bVar1;
  int iVar2;
  
  if (DAT_0002e6a0 == 0) {
    iVar2 = FUN_0001d9e0();
    DAT_0002e6a0 = *param_2;
    bVar1 = iVar2 == 0;
  }
  else {
    bVar1 = false;
  }
  return bVar1;
}



void FUN_0001d77c(void)

{
  if (DAT_0002e6a0 != 0) {
    FUN_0001d9e0();
    DAT_0002e6a0 = 0;
  }
  return;
}



undefined8 FUN_0001d7c0(basic_string *param_1,undefined8 param_2)

{
  std::__1::basic_string<>::operator=((basic_string<> *)&DAT_0002e678,param_1);
  DAT_0002e6a8 = param_2;
  return 1;
}



undefined8
FUN_0001d7f8(long param_1,undefined8 param_2,undefined8 param_3,int *param_4,undefined8 param_5)

{
  int iVar1;
  ulong uVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  undefined4 uVar6;
  undefined8 ****local_118 [2];
  char local_101;
  undefined8 local_100;
  undefined8 uStack_f8;
  undefined8 local_f0;
  undefined auStack_e8 [32];
  undefined4 local_c8;
  int iStack_c4;
  undefined4 local_c0;
  mach_port_t mStack_bc;
  undefined8 local_a8;
  
  if (*(char *)(param_1 + 0x17) < '\0') {
    if (*(long *)(param_1 + 8) == 0) goto LAB_0001d874;
  }
  else if (*(char *)(param_1 + 0x17) == '\0') {
LAB_0001d874:
    FUN_0001d984(0,param_2);
    return 1;
  }
  iVar5 = 0x10002;
  if (param_4 != (int *)0x0) {
    iVar3 = *param_4;
    if (iVar3 - 10U < 2) {
      iVar4 = param_4[2];
      iVar1 = iVar4;
      if (iVar4 == 0) {
        iVar1 = iVar3;
      }
      iVar5 = 1;
      if (1 < iVar4 - 1U) {
        iVar5 = iVar1;
      }
      uVar6 = 1;
      goto LAB_0001d8bc;
    }
    if (iVar3 == 4) {
      uVar6 = 2;
      iVar5 = 1;
      goto LAB_0001d8bc;
    }
    if (iVar3 == 8) {
      iVar5 = 8;
      if (param_4[2] != 0) {
        iVar5 = param_4[2];
      }
      uVar6 = 3;
      goto LAB_0001d8bc;
    }
  }
  uVar6 = 5;
LAB_0001d8bc:
  mStack_bc = _mach_thread_self();
  uVar2 = DAT_0002e680;
  if (-1 < (char)DAT_0002e688._7_1_) {
    uVar2 = (ulong)DAT_0002e688._7_1_;
  }
  if (uVar2 != 0) {
    FUN_00021b6c(auStack_e8,*(undefined4 *)PTR__mach_task_self__00028040,0);
    local_c0 = 0;
    local_100 = 0;
    uStack_f8 = 0;
    local_f0 = 0;
    local_c8 = uVar6;
    iStack_c4 = iVar5;
    local_a8 = param_5;
    FUN_00021f84(local_118,&DAT_0002e678,&local_100);
    if (-1 < local_101) {
      local_118[0] = local_118;
    }
    FUN_000220b0(auStack_e8,local_118[0]);
    FUN_0001d984(local_118[0],param_2);
    std::__1::basic_string<>::~basic_string((basic_string<> *)local_118);
    std::__1::basic_string<>::~basic_string((basic_string<> *)&local_100);
    FUN_00021eac(auStack_e8);
  }
  return 1;
}



void FUN_0001d984(undefined8 param_1,undefined4 param_2)

{
  undefined8 local_38;
  undefined4 local_30;
  undefined8 local_28;
  undefined8 local_20;
  undefined8 uStack_18;
  
  if (DAT_0002e6a8 != (code *)0x0) {
    local_28 = DAT_0002e690;
    if (DAT_0002e698 == 0) {
      local_20 = 0;
      uStack_18 = 0;
    }
    else {
      uStack_18 = *(undefined8 *)(DAT_0002e698 + 0x18);
      local_20 = *(undefined8 *)(DAT_0002e698 + 0x10);
    }
    local_38 = param_1;
    local_30 = param_2;
    (*DAT_0002e6a8)(&local_38);
  }
  return;
}



void FUN_0001d9e0(void)

{
  FUN_00023f44(&stack0x00000008,1);
  return;
}



void FUN_0001d9ec(void)

{
  DAT_0002e678 = 0;
  DAT_0002e680 = 0;
  DAT_0002e688 = 0;
  ___cxa_atexit(PTR__basic_string_00028010,&DAT_0002e678,0);
  return;
}



char * FUN_0001da10(char *param_1,char *param_2)

{
  _strlen(param_2);
  std::__1::basic_string<>::__init(param_1,(ulong)param_2);
  return param_1;
}



long FUN_0001da4c(long param_1)

{
  std::__1::basic_string<>::~basic_string((basic_string<> *)(param_1 + 0x28));
  return param_1;
}



void FUN_0001da74(undefined8 param_1)

{
  basic_string abStack_38 [24];
  
  std::__1::basic_string<>::basic_string(abStack_38);
  FUN_0001d7f8(abStack_38,param_1,0,0,0);
  std::__1::basic_string<>::~basic_string((basic_string<> *)abStack_38);
  return;
}



// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_0001dac8(basic_string *param_1,undefined8 param_2)

{
  uint uVar1;
  ulong uVar2;
  int *piVar3;
  
  if (DAT_0002e6d0 == '\0') {
    uVar2 = 1;
    DAT_0002e6b8 = _calloc(1,0x40000);
    if (DAT_0002e6b8 != (void *)0x0) {
      DAT_0002e6c0 = 0x40000;
      DAT_0002e6c8._0_4_ = 0;
      uVar1 = _sigaltstack((stack_t *)&DAT_0002e6b8,(stack_t *)0x0);
      if ((int)uVar1 < 0) {
        uVar2 = (ulong)(uVar1 >> 0x1d & 4);
      }
      else {
        FUN_0001d7c0(param_1,param_2);
        uRam000000000002e700 = 0;
        _DAT_0002e6f8 = 0;
        uRam000000000002e710 = 0;
        _DAT_0002e708 = 0;
        uRam000000000002e720 = 0;
        _DAT_0002e718 = 0;
        uRam000000000002e730 = 0;
        _DAT_0002e728 = 0;
        uRam000000000002e740 = 0;
        _DAT_0002e738 = 0;
        uRam000000000002e750 = 0;
        _DAT_0002e748 = 0;
        FUN_0001d720(FUN_0001dbd4,&DAT_0002e6f0);
        DAT_0002e6d0 = '\x01';
        piVar3 = DAT_0002e6b0;
        do {
          if (*piVar3 < 1) {
            uVar2 = 0;
            goto LAB_0001dbc0;
          }
          uVar2 = FUN_0001ddac(piVar3,0,0);
          piVar3 = piVar3 + 4;
        } while ((int)uVar2 == 0);
        FUN_0001dcf8();
LAB_0001dbc0:
        std::__1::basic_string<>::operator=((basic_string<> *)&DAT_0002e6d8,param_1);
      }
    }
  }
  else {
    uVar2 = 5;
  }
  FUN_0001dfec(uVar2);
  return;
}



void FUN_0001dbd4(undefined8 param_1,long param_2,undefined8 *param_3)

{
  long lVar1;
  code *UNRECOVERED_JUMPTABLE;
  undefined8 uVar2;
  
  if (DAT_0002e6d0 != '\0') {
    lVar1 = FUN_0001dd74(param_1);
    if (param_2 == 0) {
      if (lVar1 != 0) {
        if (param_3 != (undefined8 *)0x0) {
          uVar2 = **(undefined8 **)(lVar1 + 8);
          param_3[1] = (*(undefined8 **)(lVar1 + 8))[1];
          *param_3 = uVar2;
        }
        FUN_0001dfec(0);
        return;
      }
      UNRECOVERED_JUMPTABLE = (code *)PTR__sigaction_00028048;
      if (DAT_0002e6f0 != (code *)0x0) {
        UNRECOVERED_JUMPTABLE = DAT_0002e6f0;
      }
      param_2 = 0;
      goto LAB_0001dc4c;
    }
    if ((lVar1 != 0) && (*(char *)(lVar1 + 5) != '\0')) {
      FUN_0001ddac(lVar1,param_2,param_3);
      return;
    }
  }
  UNRECOVERED_JUMPTABLE = (code *)PTR__sigaction_00028048;
  if (DAT_0002e6f0 != (code *)0x0) {
    UNRECOVERED_JUMPTABLE = DAT_0002e6f0;
  }
LAB_0001dc4c:
                    // WARNING: Could not recover jumptable at 0x0001dc5c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)(param_1,param_2,param_3);
  return;
}



void * FUN_0001dca4(void)

{
  void *pvVar1;
  
  if (DAT_0002e6d0 == '\0') {
    pvVar1 = (void *)((long)&mach_header_00000000.cputype + 1);
  }
  else {
    FUN_0001dcf8();
    FUN_0001d77c();
    DAT_0002e6d0 = '\0';
    DAT_0002e6f0 = 0;
    pvVar1 = DAT_0002e6b8;
    if (DAT_0002e6b8 != (void *)0x0) {
      _free(DAT_0002e6b8);
      pvVar1 = (void *)0x0;
      DAT_0002e6b8 = (void *)0x0;
    }
  }
  return pvVar1;
}



void FUN_0001dcf8(void)

{
  code *pcVar1;
  undefined *puVar2;
  int iVar3;
  undefined8 *puVar4;
  
  puVar2 = PTR__sigaction_00028048;
  iVar3 = *DAT_0002e6b0;
  if (0 < iVar3) {
    puVar4 = (undefined8 *)(DAT_0002e6b0 + 2);
    do {
      if (*(char *)((long)puVar4 + -3) != '\0') {
        pcVar1 = (code *)puVar2;
        if (DAT_0002e6f0 != (code *)0x0) {
          pcVar1 = DAT_0002e6f0;
        }
        iVar3 = (*pcVar1)(iVar3,*puVar4,0);
        if (iVar3 == 0) {
          *(undefined *)((long)puVar4 + -3) = 0;
        }
      }
      iVar3 = *(int *)(puVar4 + 1);
      puVar4 = puVar4 + 2;
    } while (0 < iVar3);
  }
  return;
}



long FUN_0001dd74(int param_1)

{
  int *piVar1;
  long lVar2;
  
  if (param_1 != 0) {
    lVar2 = 0x28da8;
    while (piVar1 = (int *)(lVar2 + 0x10), 0 < *piVar1) {
      lVar2 = lVar2 + 0x10;
      if (*piVar1 == param_1) {
        return lVar2;
      }
    }
  }
  return 0;
}



undefined8 FUN_0001ddac(undefined4 *param_1,undefined8 *param_2,undefined8 *param_3)

{
  code *pcVar1;
  int iVar2;
  undefined8 *puVar3;
  undefined8 uVar4;
  undefined8 local_50;
  undefined8 uStack_48;
  code *local_40;
  undefined8 local_38;
  
  if (*(char *)((long)param_1 + 5) == '\0') {
    local_50 = 0;
    uStack_48 = 0;
    local_40 = FUN_0001de7c;
    local_38 = 0x4100000000;
    pcVar1 = (code *)PTR__sigaction_00028048;
    if (DAT_0002e6f0 != (code *)0x0) {
      pcVar1 = DAT_0002e6f0;
    }
    iVar2 = (*pcVar1)(*param_1,&local_40,&local_50);
    if (iVar2 != 0) {
      return 4;
    }
    puVar3 = *(undefined8 **)(param_1 + 2);
    puVar3[1] = uStack_48;
    *puVar3 = local_50;
    *(undefined *)((long)param_1 + 5) = 1;
    if (param_3 == (undefined8 *)0x0) goto LAB_0001dde4;
  }
  else {
    if (param_3 == (undefined8 *)0x0) goto LAB_0001dde4;
    uStack_48 = (*(undefined8 **)(param_1 + 2))[1];
    local_50 = **(undefined8 **)(param_1 + 2);
  }
  param_3[1] = uStack_48;
  *param_3 = local_50;
LAB_0001dde4:
  if (param_2 != (undefined8 *)0x0) {
    puVar3 = *(undefined8 **)(param_1 + 2);
    uVar4 = *param_2;
    puVar3[1] = param_2[1];
    *puVar3 = uVar4;
  }
  return 0;
}



void FUN_0001de7c(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  int iVar1;
  uint uVar2;
  long lVar3;
  basic_string abStack_48 [24];
  
  lVar3 = FUN_0001dd74();
  if (lVar3 != 0) {
    if (*(char *)(lVar3 + 5) == '\0') {
      FUN_0001dff8();
      FUN_0001df2c();
      return;
    }
    FUN_0001dcf8();
    iVar1 = FUN_0001d690(param_3);
    if ((iVar1 == 0) || (uVar2 = _ahpl_mpq_this(), (uVar2 >> 0xf & 1) == 0)) {
      std::__1::basic_string<>::basic_string(abStack_48);
      FUN_0001d7f8(abStack_48,0,param_1,param_2,param_3);
      std::__1::basic_string<>::~basic_string((basic_string<> *)abStack_48);
    }
    FUN_0001dff8();
    FUN_0001df2c();
  }
  return;
}



code ** FUN_0001df2c(code **param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  uint uVar1;
  code **ppcVar2;
  code *UNRECOVERED_JUMPTABLE;
  undefined8 local_30;
  undefined8 uStack_28;
  
  if (param_1 == (code **)0x0) {
    uVar1 = _raise((int)param_2);
    return (code **)(ulong)uVar1;
  }
  if ((*(byte *)((long)param_1 + 0xc) >> 6 & 1) == 0) {
    UNRECOVERED_JUMPTABLE = *param_1;
    if (UNRECOVERED_JUMPTABLE != (code *)((long)&mach_header_00000000.magic + 1)) {
      if (UNRECOVERED_JUMPTABLE != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x0001dfe8. Too many branches
                    // WARNING: Treating indirect jump as call
        ppcVar2 = (code **)(*UNRECOVERED_JUMPTABLE)(param_2);
        return ppcVar2;
      }
      local_30 = 0;
      uStack_28 = 0x200000000;
      UNRECOVERED_JUMPTABLE = (code *)PTR__sigaction_00028048;
      if (DAT_0002e6f0 != (code *)0x0) {
        UNRECOVERED_JUMPTABLE = DAT_0002e6f0;
      }
      (*UNRECOVERED_JUMPTABLE)(param_2,&local_30,0);
      uVar1 = _raise((int)param_2);
      param_1 = (code **)(ulong)uVar1;
    }
    return param_1;
  }
                    // WARNING: Could not recover jumptable at 0x0001dfd4. Too many branches
                    // WARNING: Treating indirect jump as call
  ppcVar2 = (code **)(**param_1)(param_2,param_3,param_4);
  return ppcVar2;
}



void FUN_0001dfec(void)

{
  return;
}



undefined8 FUN_0001dff8(void)

{
  long unaff_x22;
  
  return *(undefined8 *)(unaff_x22 + 8);
}



void FUN_0001e00c(void)

{
  long lVar1;
  
  lVar1 = 0x78;
  do {
    std::__1::basic_string<>::~basic_string((basic_string<> *)(&DAT_0002ebb0 + lVar1));
    lVar1 = lVar1 + -0x18;
  } while (lVar1 != -0x18);
  return;
}



// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_0001e044(void)

{
  FUN_0001da10(&DAT_0002ebb0,"SIGILL");
  FUN_0001da10(&DAT_0002ebc8,"SIGABRT");
  FUN_0001da10(&DAT_0002ebe0,"SIGFPE");
  FUN_0001da10(&DAT_0002ebf8,"SIGSEGV");
  FUN_0001da10(&DAT_0002ec10,"SIGBUS");
  FUN_0001da10(&DAT_0002ec28,"NIL");
  ___cxa_atexit(FUN_0001e00c,0,0);
  DAT_0002e6b0 = &DAT_00028db8;
  DAT_0002e6b8 = 0;
  DAT_0002e6c0 = 0;
  DAT_0002e6c8 = 0;
  DAT_0002e6d0 = 0;
  uRam000000000002e6e0 = 0;
  _DAT_0002e6d8 = 0;
  DAT_0002e6f0 = 0;
  _DAT_0002e6e8 = 0;
  ___cxa_atexit(FUN_0001da4c,&DAT_0002e6b0,0);
  return;
}



long FUN_0001e114(byte **param_1,byte *param_2,short **param_3,short *param_4,int param_5)

{
  short *psVar1;
  byte bVar2;
  byte bVar3;
  uint uVar4;
  ulong uVar5;
  byte *pbVar6;
  long lVar7;
  byte *pbVar8;
  ulong uVar9;
  
  pbVar8 = *param_1;
  psVar1 = *param_3;
joined_r0x0001e124:
  if (param_2 <= pbVar8) {
    lVar7 = 0;
LAB_0001e328:
    *param_1 = pbVar8;
    *param_3 = psVar1;
    return lVar7;
  }
  bVar2 = *pbVar8;
  uVar5 = (ulong)bVar2;
  if (param_2 <= pbVar8 + (ushort)(short)(char)(&DAT_00026cf3)[uVar5]) {
    lVar7 = 1;
    goto LAB_0001e328;
  }
  uVar9 = (long)(char)(&DAT_00026cf3)[uVar5] & 0xffff;
  if ((uint)uVar9 < 4) {
    lVar7 = uVar9 + 1;
    pbVar6 = pbVar8 + lVar7;
    switch(uVar9) {
    case 0:
      goto switchD_0001e184_caseD_0;
    case 1:
      goto switchD_0001e184_caseD_1;
    case 3:
      bVar3 = pbVar8[(ushort)(short)(char)(&DAT_00026cf3)[uVar5]];
      lVar7 = 3;
      if ((-1 < (char)bVar3) || (0xbf < bVar3)) goto LAB_0001e328;
    }
    pbVar6 = pbVar8 + lVar7 + -1;
    lVar7 = 3;
    if ((-1 < (char)*pbVar6) || (0xbf < *pbVar6)) goto LAB_0001e328;
switchD_0001e184_caseD_1:
    bVar3 = pbVar6[-1];
    if (0xbf < bVar3) goto LAB_0001e324;
    if (bVar2 == 0xf4) {
      if (bVar3 < 0x90) goto LAB_0001e248;
      goto LAB_0001e324;
    }
    if (bVar2 == 0xed) {
joined_r0x0001e204:
      if (0x9f < bVar3) goto LAB_0001e324;
LAB_0001e248:
      lVar7 = 0;
      switch(uVar9) {
      case 3:
        lVar7 = uVar5 << 6;
        pbVar8 = pbVar8 + 1;
        uVar5 = (ulong)*pbVar8;
      case 2:
        lVar7 = lVar7 + uVar5;
        pbVar8 = pbVar8 + 1;
        uVar5 = (ulong)*pbVar8;
        lVar7 = lVar7 * 0x40;
      case 1:
        lVar7 = lVar7 + uVar5;
        pbVar8 = pbVar8 + 1;
        uVar5 = (ulong)*pbVar8;
        lVar7 = lVar7 * 0x40;
      case 0:
        pbVar8 = pbVar8 + 1;
        lVar7 = lVar7 + uVar5;
      }
      if (param_4 <= psVar1) {
LAB_0001e304:
        pbVar8 = pbVar8 + ~uVar9;
        lVar7 = 2;
        goto LAB_0001e328;
      }
      uVar5 = lVar7 - *(long *)(&DAT_00026df8 + uVar9 * 8);
      if (uVar5 >> 0x10 == 0) {
        if (uVar5 >> 0xb == 0x1b) {
LAB_0001e2c0:
          if (param_5 == 0) {
            pbVar8 = pbVar8 + ~uVar9;
            goto LAB_0001e324;
          }
          *psVar1 = -3;
          psVar1 = psVar1 + 1;
        }
        else {
          *psVar1 = (short)uVar5;
          psVar1 = psVar1 + 1;
        }
      }
      else {
        if (0x10ffff < uVar5) goto LAB_0001e2c0;
        if (param_4 <= psVar1 + 1) goto LAB_0001e304;
        uVar4 = (int)uVar5 - 0x10000;
        *psVar1 = (short)(uVar4 >> 10) + -0x2800;
        psVar1[1] = (ushort)uVar4 & 0x3ff | 0xdc00;
        psVar1 = psVar1 + 2;
      }
      goto joined_r0x0001e124;
    }
    if (bVar2 == 0xf0) {
      if (0x8f < bVar3) goto LAB_0001e248;
      goto LAB_0001e324;
    }
    if (bVar2 == 0xe0) goto joined_r0x0001e204;
    if ((char)bVar3 < '\0') {
switchD_0001e184_caseD_0:
      lVar7 = 3;
      if ((bVar2 < 0xf5) && (-0x3f < (char)bVar2)) goto LAB_0001e248;
      goto LAB_0001e328;
    }
  }
LAB_0001e324:
  lVar7 = 3;
  goto LAB_0001e328;
}



void FUN_0001e33c(long param_1,undefined8 *param_2,ulong param_3)

{
  uint uVar1;
  uint uVar2;
  undefined8 *puVar3;
  int iVar4;
  ulong uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  
  uVar2 = *(uint *)(param_1 + 0x10);
  iVar4 = *(int *)(param_1 + 0x14);
  uVar1 = (int)param_3 * 8;
  *(uint *)(param_1 + 0x10) = uVar2 + uVar1;
  if (CARRY4(uVar2,uVar1)) {
    iVar4 = iVar4 + 1;
    *(int *)(param_1 + 0x14) = iVar4;
  }
  *(int *)(param_1 + 0x14) = iVar4 + (int)(param_3 >> 0x1d);
  uVar5 = (ulong)(uVar2 >> 3) & 0x3f;
  iVar4 = (int)uVar5;
  if (iVar4 != 0) {
    puVar3 = (undefined8 *)(param_1 + uVar5 + 0x18);
    uVar5 = (ulong)(0x40 - iVar4);
    if (param_3 < uVar5) goto LAB_0001e408;
    _memcpy(puVar3,param_2,uVar5);
    FUN_0001e424(param_1,param_1 + 0x18);
    param_2 = (undefined8 *)((long)param_2 + uVar5);
    param_3 = param_3 - uVar5;
  }
  puVar3 = (undefined8 *)(param_1 + 0x18);
  uVar5 = param_3;
  if (0x3f < param_3) {
    do {
      uVar7 = param_2[1];
      uVar6 = *param_2;
      uVar9 = param_2[3];
      uVar8 = param_2[2];
      uVar10 = param_2[4];
      uVar12 = param_2[7];
      uVar11 = param_2[6];
      *(undefined8 *)(param_1 + 0x40) = param_2[5];
      *(undefined8 *)(param_1 + 0x38) = uVar10;
      *(undefined8 *)(param_1 + 0x50) = uVar12;
      *(undefined8 *)(param_1 + 0x48) = uVar11;
      *(undefined8 *)(param_1 + 0x20) = uVar7;
      *puVar3 = uVar6;
      *(undefined8 *)(param_1 + 0x30) = uVar9;
      *(undefined8 *)(param_1 + 0x28) = uVar8;
      FUN_0001e424(param_1,puVar3);
      param_2 = param_2 + 8;
      uVar5 = uVar5 - 0x40;
    } while (0x3f < uVar5);
    param_3 = param_3 & 0x3f;
  }
LAB_0001e408:
  _memcpy(puVar3,param_2,param_3);
  return;
}



void FUN_0001e424(int *param_1,int *param_2)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  int iVar9;
  int iVar10;
  int iVar11;
  int iVar12;
  int iVar13;
  uint uVar14;
  uint uVar15;
  int iVar16;
  int iVar17;
  int iVar18;
  int iVar19;
  int iVar20;
  int iVar21;
  int iVar22;
  int iVar23;
  
  uVar14 = param_1[1];
  uVar5 = param_1[2];
  uVar15 = param_1[3];
  iVar6 = *param_2;
  iVar16 = param_2[1];
  uVar1 = *param_1 + iVar6 + (uVar5 & uVar14 | uVar15 & (uVar14 ^ 0xffffffff)) + 0xd76aa478;
  uVar1 = (uVar1 >> 0x19 | uVar1 * 0x80) + uVar14;
  uVar2 = uVar15 + iVar16 + (uVar14 & uVar1 | uVar5 & (uVar1 ^ 0xffffffff)) + 0xe8c7b756;
  uVar2 = (uVar2 >> 0x14 | uVar2 * 0x1000) + uVar1;
  iVar7 = param_2[2];
  iVar17 = param_2[3];
  uVar3 = uVar5 + iVar7 + (uVar1 & uVar2 | uVar14 & (uVar2 ^ 0xffffffff)) + 0x242070db;
  uVar3 = (uVar3 >> 0xf | uVar3 * 0x20000) + uVar2;
  uVar4 = uVar14 + iVar17 + (uVar2 & uVar3 | uVar1 & (uVar3 ^ 0xffffffff)) + 0xc1bdceee;
  uVar4 = (uVar4 >> 10 | uVar4 * 0x400000) + uVar3;
  iVar8 = param_2[4];
  iVar18 = param_2[5];
  uVar1 = iVar8 + uVar1 + (uVar3 & uVar4 | uVar2 & (uVar4 ^ 0xffffffff)) + 0xf57c0faf;
  uVar1 = (uVar1 >> 0x19 | uVar1 * 0x80) + uVar4;
  uVar2 = iVar18 + uVar2 + (uVar4 & uVar1 | uVar3 & (uVar1 ^ 0xffffffff)) + 0x4787c62a;
  uVar2 = (uVar2 >> 0x14 | uVar2 * 0x1000) + uVar1;
  iVar9 = param_2[6];
  iVar19 = param_2[7];
  uVar3 = iVar9 + uVar3 + (uVar1 & uVar2 | uVar4 & (uVar2 ^ 0xffffffff)) + 0xa8304613;
  uVar3 = (uVar3 >> 0xf | uVar3 * 0x20000) + uVar2;
  uVar4 = iVar19 + uVar4 + (uVar2 & uVar3 | uVar1 & (uVar3 ^ 0xffffffff)) + 0xfd469501;
  uVar4 = (uVar4 >> 10 | uVar4 * 0x400000) + uVar3;
  iVar10 = param_2[8];
  iVar20 = param_2[9];
  uVar1 = iVar10 + uVar1 + (uVar3 & uVar4 | uVar2 & (uVar4 ^ 0xffffffff)) + 0x698098d8;
  uVar1 = (uVar1 >> 0x19 | uVar1 * 0x80) + uVar4;
  uVar2 = iVar20 + uVar2 + (uVar4 & uVar1 | uVar3 & (uVar1 ^ 0xffffffff)) + 0x8b44f7af;
  uVar2 = (uVar2 >> 0x14 | uVar2 * 0x1000) + uVar1;
  iVar11 = param_2[10];
  iVar21 = param_2[0xb];
  uVar3 = (iVar11 + uVar3 + (uVar1 & uVar2 | uVar4 & (uVar2 ^ 0xffffffff))) - 0xa44f;
  uVar3 = (uVar3 >> 0xf | uVar3 * 0x20000) + uVar2;
  uVar4 = iVar21 + uVar4 + (uVar2 & uVar3 | uVar1 & (uVar3 ^ 0xffffffff)) + 0x895cd7be;
  uVar4 = (uVar4 >> 10 | uVar4 * 0x400000) + uVar3;
  iVar12 = param_2[0xc];
  iVar22 = param_2[0xd];
  uVar1 = iVar12 + uVar1 + (uVar3 & uVar4 | uVar2 & (uVar4 ^ 0xffffffff)) + 0x6b901122;
  uVar1 = (uVar1 >> 0x19 | uVar1 * 0x80) + uVar4;
  uVar2 = iVar22 + uVar2 + (uVar4 & uVar1 | uVar3 & (uVar1 ^ 0xffffffff)) + 0xfd987193;
  uVar2 = (uVar2 >> 0x14 | uVar2 * 0x1000) + uVar1;
  iVar13 = param_2[0xe];
  iVar23 = param_2[0xf];
  uVar3 = iVar13 + uVar3 + (uVar1 & uVar2 | uVar4 & (uVar2 ^ 0xffffffff)) + 0xa679438e;
  uVar3 = (uVar3 >> 0xf | uVar3 * 0x20000) + uVar2;
  uVar4 = iVar23 + uVar4 + (uVar2 & uVar3 | uVar1 & (uVar3 ^ 0xffffffff)) + 0x49b40821;
  uVar4 = (uVar4 >> 10 | uVar4 * 0x400000) + uVar3;
  uVar1 = iVar16 + uVar1 + (uVar4 & uVar2 | uVar3 & (uVar2 ^ 0xffffffff)) + 0xf61e2562;
  uVar1 = (uVar1 >> 0x1b | uVar1 * 0x20) + uVar4;
  uVar2 = iVar9 + uVar2 + (uVar1 & uVar3 | uVar4 & (uVar3 ^ 0xffffffff)) + 0xc040b340;
  uVar2 = (uVar2 >> 0x17 | uVar2 * 0x200) + uVar1;
  uVar3 = iVar21 + uVar3 + (uVar2 & uVar4 | uVar1 & (uVar4 ^ 0xffffffff)) + 0x265e5a51;
  uVar3 = (uVar3 >> 0x12 | uVar3 * 0x4000) + uVar2;
  uVar4 = iVar6 + uVar4 + (uVar3 & uVar1 | uVar2 & (uVar1 ^ 0xffffffff)) + 0xe9b6c7aa;
  uVar4 = (uVar4 >> 0xc | uVar4 * 0x100000) + uVar3;
  uVar1 = iVar18 + uVar1 + (uVar4 & uVar2 | uVar3 & (uVar2 ^ 0xffffffff)) + 0xd62f105d;
  uVar1 = (uVar1 >> 0x1b | uVar1 * 0x20) + uVar4;
  uVar2 = iVar11 + uVar2 + (uVar1 & uVar3 | uVar4 & (uVar3 ^ 0xffffffff)) + 0x2441453;
  uVar2 = (uVar2 >> 0x17 | uVar2 * 0x200) + uVar1;
  uVar3 = iVar23 + uVar3 + (uVar2 & uVar4 | uVar1 & (uVar4 ^ 0xffffffff)) + 0xd8a1e681;
  uVar3 = (uVar3 >> 0x12 | uVar3 * 0x4000) + uVar2;
  uVar4 = iVar8 + uVar4 + (uVar3 & uVar1 | uVar2 & (uVar1 ^ 0xffffffff)) + 0xe7d3fbc8;
  uVar4 = (uVar4 >> 0xc | uVar4 * 0x100000) + uVar3;
  uVar1 = iVar20 + uVar1 + (uVar4 & uVar2 | uVar3 & (uVar2 ^ 0xffffffff)) + 0x21e1cde6;
  uVar1 = (uVar1 >> 0x1b | uVar1 * 0x20) + uVar4;
  uVar2 = iVar13 + uVar2 + (uVar1 & uVar3 | uVar4 & (uVar3 ^ 0xffffffff)) + 0xc33707d6;
  uVar2 = (uVar2 >> 0x17 | uVar2 * 0x200) + uVar1;
  uVar3 = iVar17 + uVar3 + (uVar2 & uVar4 | uVar1 & (uVar4 ^ 0xffffffff)) + 0xf4d50d87;
  uVar3 = (uVar3 >> 0x12 | uVar3 * 0x4000) + uVar2;
  uVar4 = iVar10 + uVar4 + (uVar3 & uVar1 | uVar2 & (uVar1 ^ 0xffffffff)) + 0x455a14ed;
  uVar4 = (uVar4 >> 0xc | uVar4 * 0x100000) + uVar3;
  uVar1 = iVar22 + uVar1 + (uVar4 & uVar2 | uVar3 & (uVar2 ^ 0xffffffff)) + 0xa9e3e905;
  uVar1 = (uVar1 >> 0x1b | uVar1 * 0x20) + uVar4;
  uVar2 = iVar7 + uVar2 + (uVar1 & uVar3 | uVar4 & (uVar3 ^ 0xffffffff)) + 0xfcefa3f8;
  uVar2 = (uVar2 >> 0x17 | uVar2 * 0x200) + uVar1;
  uVar3 = iVar19 + uVar3 + (uVar2 & uVar4 | uVar1 & (uVar4 ^ 0xffffffff)) + 0x676f02d9;
  uVar3 = (uVar3 >> 0x12 | uVar3 * 0x4000) + uVar2;
  uVar4 = iVar12 + uVar4 + ((uVar3 ^ uVar2) & uVar1 ^ uVar2) + 0x8d2a4c8a;
  uVar4 = (uVar4 >> 0xc | uVar4 * 0x100000) + uVar3;
  uVar1 = (iVar18 + uVar1 + (uVar4 ^ uVar3 ^ uVar2)) - 0x5c6be;
  uVar1 = (uVar1 >> 0x1c | uVar1 * 0x10) + uVar4;
  uVar2 = iVar10 + uVar2 + (uVar1 ^ uVar4 ^ uVar3) + 0x8771f681;
  uVar2 = (uVar2 >> 0x15 | uVar2 * 0x800) + uVar1;
  uVar3 = iVar21 + uVar3 + (uVar1 ^ uVar4 ^ uVar2) + 0x6d9d6122;
  uVar3 = (uVar3 >> 0x10 | uVar3 * 0x10000) + uVar2;
  uVar4 = iVar13 + uVar4 + (uVar2 ^ uVar1 ^ uVar3) + 0xfde5380c;
  uVar4 = (uVar4 >> 9 | uVar4 * 0x800000) + uVar3;
  uVar1 = iVar16 + uVar1 + (uVar3 ^ uVar2 ^ uVar4) + 0xa4beea44;
  uVar1 = (uVar1 >> 0x1c | uVar1 * 0x10) + uVar4;
  uVar2 = iVar8 + uVar2 + (uVar4 ^ uVar3 ^ uVar1) + 0x4bdecfa9;
  uVar2 = (uVar2 >> 0x15 | uVar2 * 0x800) + uVar1;
  uVar3 = iVar19 + uVar3 + (uVar1 ^ uVar4 ^ uVar2) + 0xf6bb4b60;
  uVar3 = (uVar3 >> 0x10 | uVar3 * 0x10000) + uVar2;
  uVar4 = iVar11 + uVar4 + (uVar2 ^ uVar1 ^ uVar3) + 0xbebfbc70;
  uVar4 = (uVar4 >> 9 | uVar4 * 0x800000) + uVar3;
  uVar1 = iVar22 + uVar1 + (uVar3 ^ uVar2 ^ uVar4) + 0x289b7ec6;
  uVar1 = (uVar1 >> 0x1c | uVar1 * 0x10) + uVar4;
  uVar2 = iVar6 + uVar2 + (uVar4 ^ uVar3 ^ uVar1) + 0xeaa127fa;
  uVar2 = (uVar2 >> 0x15 | uVar2 * 0x800) + uVar1;
  uVar3 = iVar17 + uVar3 + (uVar1 ^ uVar4 ^ uVar2) + 0xd4ef3085;
  uVar3 = (uVar3 >> 0x10 | uVar3 * 0x10000) + uVar2;
  uVar4 = iVar9 + uVar4 + (uVar2 ^ uVar1 ^ uVar3) + 0x4881d05;
  uVar4 = (uVar4 >> 9 | uVar4 * 0x800000) + uVar3;
  uVar1 = iVar20 + uVar1 + (uVar3 ^ uVar2 ^ uVar4) + 0xd9d4d039;
  uVar1 = (uVar1 >> 0x1c | uVar1 * 0x10) + uVar4;
  uVar2 = iVar12 + uVar2 + (uVar4 ^ uVar3 ^ uVar1) + 0xe6db99e5;
  uVar2 = (uVar2 >> 0x15 | uVar2 * 0x800) + uVar1;
  uVar3 = iVar23 + uVar3 + (uVar1 ^ uVar4 ^ uVar2) + 0x1fa27cf8;
  uVar3 = (uVar3 >> 0x10 | uVar3 * 0x10000) + uVar2;
  uVar4 = iVar7 + uVar4 + (uVar2 ^ uVar1 ^ uVar3) + 0xc4ac5665;
  uVar4 = (uVar4 >> 9 | uVar4 * 0x800000) + uVar3;
  uVar1 = iVar6 + uVar1 + ((uVar4 | uVar2 ^ 0xffffffff) ^ uVar3) + 0xf4292244;
  uVar1 = (uVar1 >> 0x1a | uVar1 * 0x40) + uVar4;
  uVar2 = iVar19 + uVar2 + ((uVar1 | uVar3 ^ 0xffffffff) ^ uVar4) + 0x432aff97;
  uVar2 = (uVar2 >> 0x16 | uVar2 * 0x400) + uVar1;
  uVar3 = iVar13 + uVar3 + ((uVar2 | uVar4 ^ 0xffffffff) ^ uVar1) + 0xab9423a7;
  uVar3 = (uVar3 >> 0x11 | uVar3 * 0x8000) + uVar2;
  uVar4 = iVar18 + uVar4 + ((uVar3 | uVar1 ^ 0xffffffff) ^ uVar2) + 0xfc93a039;
  uVar4 = (uVar4 >> 0xb | uVar4 * 0x200000) + uVar3;
  uVar1 = iVar12 + uVar1 + ((uVar4 | uVar2 ^ 0xffffffff) ^ uVar3) + 0x655b59c3;
  uVar1 = (uVar1 >> 0x1a | uVar1 * 0x40) + uVar4;
  uVar2 = iVar17 + uVar2 + ((uVar1 | uVar3 ^ 0xffffffff) ^ uVar4) + 0x8f0ccc92;
  uVar2 = (uVar2 >> 0x16 | uVar2 * 0x400) + uVar1;
  uVar3 = (iVar11 + uVar3 + ((uVar2 | uVar4 ^ 0xffffffff) ^ uVar1)) - 0x100b83;
  uVar3 = (uVar3 >> 0x11 | uVar3 * 0x8000) + uVar2;
  uVar4 = iVar16 + uVar4 + ((uVar3 | uVar1 ^ 0xffffffff) ^ uVar2) + 0x85845dd1;
  uVar4 = (uVar4 >> 0xb | uVar4 * 0x200000) + uVar3;
  uVar1 = iVar10 + uVar1 + ((uVar4 | uVar2 ^ 0xffffffff) ^ uVar3) + 0x6fa87e4f;
  uVar1 = (uVar1 >> 0x1a | uVar1 * 0x40) + uVar4;
  uVar2 = iVar23 + uVar2 + ((uVar1 | uVar3 ^ 0xffffffff) ^ uVar4) + 0xfe2ce6e0;
  uVar2 = (uVar2 >> 0x16 | uVar2 * 0x400) + uVar1;
  uVar3 = iVar9 + uVar3 + ((uVar2 | uVar4 ^ 0xffffffff) ^ uVar1) + 0xa3014314;
  uVar3 = (uVar3 >> 0x11 | uVar3 * 0x8000) + uVar2;
  uVar4 = iVar22 + uVar4 + ((uVar3 | uVar1 ^ 0xffffffff) ^ uVar2) + 0x4e0811a1;
  uVar4 = (uVar4 >> 0xb | uVar4 * 0x200000) + uVar3;
  uVar1 = iVar8 + uVar1 + ((uVar4 | uVar2 ^ 0xffffffff) ^ uVar3) + 0xf7537e82;
  uVar1 = (uVar1 >> 0x1a | uVar1 * 0x40) + uVar4;
  uVar2 = iVar21 + uVar2 + ((uVar1 | uVar3 ^ 0xffffffff) ^ uVar4) + 0xbd3af235;
  uVar2 = (uVar2 >> 0x16 | uVar2 * 0x400) + uVar1;
  uVar3 = iVar7 + uVar3 + ((uVar2 | uVar4 ^ 0xffffffff) ^ uVar1) + 0x2ad7d2bb;
  uVar3 = (uVar3 >> 0x11 | uVar3 * 0x8000) + uVar2;
  uVar4 = iVar20 + uVar4 + ((uVar3 | uVar1 ^ 0xffffffff) ^ uVar2) + 0xeb86d391;
  *param_1 = uVar1 + *param_1;
  param_1[1] = uVar3 + uVar14 + (uVar4 >> 0xb | uVar4 * 0x200000);
  param_1[2] = uVar3 + uVar5;
  param_1[3] = uVar2 + uVar15;
  return;
}



void FUN_0001ee04(undefined8 *param_1,undefined8 *param_2)

{
  undefined *puVar1;
  uint uVar2;
  undefined *puVar3;
  ulong uVar4;
  uint uVar5;
  undefined8 uVar6;
  
  uVar5 = *(uint *)(param_2 + 2);
  uVar4 = (ulong)(uVar5 >> 3) & 0x3f;
  puVar1 = (undefined *)((long)(param_2 + 3) + uVar4);
  puVar3 = puVar1 + 1;
  *puVar1 = 0x80;
  uVar2 = (uint)uVar4 ^ 0x3f;
  if (uVar2 < 8) {
    _bzero(puVar3,(ulong)uVar2);
    FUN_0001eea4();
    param_2[9] = 0;
    param_2[6] = 0;
    param_2[5] = 0;
    param_2[8] = 0;
    param_2[7] = 0;
    param_2[4] = 0;
    param_2[3] = 0;
    uVar5 = *(uint *)(param_2 + 2);
  }
  else {
    _bzero(puVar3,(ulong)(uVar2 - 8));
  }
  *(uint *)((long)param_2 + 0x26) = uVar5;
  *(undefined4 *)((long)param_2 + 0x27) = *(undefined4 *)((long)param_2 + 0x14);
  FUN_0001eea4();
  uVar6 = *param_2;
  param_1[1] = param_2[1];
  *param_1 = uVar6;
  param_2[1] = 0;
  *param_2 = 0;
  param_2[3] = 0;
  param_2[2] = 0;
  param_2[5] = 0;
  param_2[4] = 0;
  param_2[7] = 0;
  param_2[6] = 0;
  param_2[9] = 0;
  param_2[8] = 0;
  param_2[10] = 0;
  return;
}



void FUN_0001eea4(void)

{
  FUN_0001e424();
  return;
}



int FUN_0001eeb0(long param_1,int param_2,undefined4 *param_3)

{
  int iVar1;
  ulong uVar2;
  undefined4 *local_40;
  long local_38;
  
  uVar2 = param_1 + 1;
  *param_3 = 0;
  local_40 = param_3;
  do {
    local_38 = param_1;
    iVar1 = FUN_0001e114(&local_38,uVar2,&local_40,param_3 + 1,0);
    if (iVar1 == 0) {
      return (int)local_38 - (int)param_1;
    }
    uVar2 = uVar2 + 1;
  } while (uVar2 <= (ulong)(param_1 + param_2));
  return 0;
}



char * FUN_0001ef2c(void)

{
  char *pcVar1;
  
  ___cxa_begin_catch();
  pcVar1 = (char *)std::terminate();
  _snprintf(pcVar1,0x400,"%s");
  return pcVar1;
}



char * FUN_0001ef38(char *param_1)

{
  _snprintf(param_1,0x400,"%s");
  return param_1;
}



void FUN_0001ef74(undefined8 param_1)

{
  ulong uVar1;
  undefined8 uVar2;
  undefined auStack_4b8 [1152];
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  FUN_0001f018(auStack_4b8,param_1);
  FUN_0001f004();
  uVar1 = FUN_0001f1d0();
  if ((uVar1 & 1) == 0) {
    FUN_0001f004();
    uVar2 = FUN_0001f520();
  }
  else {
    uVar2 = 1;
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar2);
}



undefined * FUN_0001f004(void)

{
  return &stack0x00000008;
}



void FUN_0001f018(char *param_1)

{
  *(undefined8 *)(param_1 + 0x458) = 0;
  *(undefined8 *)(param_1 + 0x450) = 0;
  *(undefined8 *)(param_1 + 0x448) = 0;
  *(undefined8 *)(param_1 + 0x440) = 0;
  *(undefined8 *)(param_1 + 0x438) = 0;
  *(undefined8 *)(param_1 + 0x430) = 0;
  *(undefined8 *)(param_1 + 0x428) = 0;
  *(undefined8 *)(param_1 + 0x420) = 0;
  *(undefined8 *)(param_1 + 0x418) = 0;
  *(undefined8 *)(param_1 + 0x410) = 0;
  *(undefined8 *)(param_1 + 0x408) = 0;
  *(undefined8 *)(param_1 + 0x400) = 0;
  *(undefined8 *)(param_1 + 0x464) = 0;
  *(undefined8 *)(param_1 + 0x45c) = 0;
  *(undefined8 *)(param_1 + 0x478) = 0;
  *(undefined8 *)(param_1 + 0x470) = 0;
  _snprintf(param_1,0x400,"%s");
  FUN_0001f5bc(param_1);
  return;
}



void FUN_0001f074(char *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  *(undefined8 *)(param_1 + 0x400) = param_3;
  *(undefined8 *)(param_1 + 0x408) = param_4;
  *(undefined8 *)(param_1 + 0x418) = 0;
  *(undefined8 *)(param_1 + 0x410) = 0;
  *(undefined8 *)(param_1 + 0x428) = 0;
  *(undefined8 *)(param_1 + 0x420) = 0;
  *(undefined8 *)(param_1 + 0x438) = 0;
  *(undefined8 *)(param_1 + 0x430) = 0;
  *(undefined8 *)(param_1 + 0x448) = 0;
  *(undefined8 *)(param_1 + 0x440) = 0;
  *(undefined8 *)(param_1 + 0x458) = 0;
  *(undefined8 *)(param_1 + 0x450) = 0;
  *(undefined8 *)(param_1 + 0x464) = 0;
  *(undefined8 *)(param_1 + 0x45c) = 0;
  *(undefined8 *)(param_1 + 0x478) = 0;
  *(undefined8 *)(param_1 + 0x470) = 0;
  _snprintf(param_1,0x400,"%s");
  FUN_0001f5bc(param_1);
  return;
}



void FUN_0001f0d4(long param_1,undefined8 param_2,undefined4 param_3)

{
  FUN_0001e33c(param_1 + 0x414,param_2,param_3);
  return;
}



void FUN_0001f0e0(long param_1,undefined8 param_2,long param_3,ulong param_4)

{
  bool bVar1;
  long *plVar2;
  ulong uVar3;
  ulong uVar4;
  int iVar5;
  code *pcVar6;
  undefined auStack_1058 [4096];
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  if ((param_4 != 0) && ((*(ulong *)(param_1 + 0x478) & 1 | *(ulong *)(param_1 + 0x470)) != 0)) {
    do {
      uVar3 = param_4;
      uVar4 = 0;
      if (0xfff < param_4) {
        uVar3 = 0x1000;
        uVar4 = param_4 - 0x1000;
      }
      iVar5 = FUN_0001fc04(param_2,auStack_1058,uVar3,param_3);
      if (iVar5 == 0) break;
      pcVar6 = *(code **)(param_1 + 0x470);
      plVar2 = (long *)(param_1 + ((long)*(ulong *)(param_1 + 0x478) >> 1));
      if ((*(ulong *)(param_1 + 0x478) & 1) != 0) {
        pcVar6 = *(code **)(*plVar2 + ((ulong)pcVar6 & 0xffffffff));
      }
      (*pcVar6)(plVar2,auStack_1058,uVar3);
      param_3 = uVar3 + param_3;
      bVar1 = 0x1000 < param_4;
      param_4 = uVar4;
    } while (bVar1);
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_58) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



// WARNING: Removing unreachable block (ram,0x0001f220)

void FUN_0001f1d0(void)

{
  long lVar1;
  
  lVar1 = *(long *)PTR____stack_chk_guard_00028030;
  FUN_0001f258();
  if (*(long *)PTR____stack_chk_guard_00028030 != lVar1) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(0);
  }
  return;
}



undefined8 FUN_0001f258(char *param_1)

{
  undefined8 uVar1;
  
  if (*(long *)(param_1 + 0x400) == 0) {
    _open(param_1,0);
    uVar1 = FUN_0001f5a4();
  }
  else {
    uVar1 = FUN_0001f5a4();
  }
  FUN_0001f5b4();
  return uVar1;
}



undefined8
FUN_0001f2fc(undefined8 param_1,int *param_2,undefined8 param_3,int param_4,uint *param_5)

{
  uint uVar1;
  int iVar2;
  undefined8 uVar3;
  
  if (*param_2 == 0x1b) {
    iVar2 = FUN_0001fc04(param_1,param_5,0x18,param_3);
    uVar3 = 0;
    if ((iVar2 != 0) && (param_4 != 0)) {
      uVar3 = 0;
      uVar1 = (*param_5 & 0xff00ff00) >> 8 | (*param_5 & 0xff00ff) << 8;
      *param_5 = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (param_5[1] & 0xff00ff00) >> 8 | (param_5[1] & 0xff00ff) << 8;
      param_5[1] = uVar1 >> 0x10 | uVar1 << 0x10;
    }
  }
  else {
    uVar3 = 1;
  }
  return uVar3;
}



void FUN_0001f368(long param_1,int *param_2,undefined8 param_3,int param_4)

{
  ulong uVar1;
  undefined8 uVar2;
  long lVar3;
  undefined auVar4 [16];
  undefined auStack_e0 [36];
  undefined4 local_bc;
  uint local_b8;
  undefined4 uStack_b4;
  uint local_b0;
  char local_a8;
  char local_a0;
  undefined auStack_90 [48];
  uint local_60;
  uint local_50;
  long local_48;
  
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  if (*param_2 == 0x19) {
    uVar1 = FUN_0001f59c(param_1,auStack_90,0x48);
    if ((uVar1 & 1) != 0) {
      if (param_4 != 0) {
        FUN_0001f63c(auStack_90);
      }
      if (*(long *)(param_1 + 0x28) != 0) {
        if (local_50 != 0) {
          uVar1 = 0;
          lVar3 = *(long *)(param_1 + 0x38);
          do {
            auVar4 = FUN_0001f59c(param_1,auStack_e0,0x50);
            uVar2 = auVar4._0_8_;
            if (auVar4._0_4_ == 0) goto LAB_0001f4ec;
            if (param_4 != 0) {
              auVar4 = FUN_0001f754(auStack_e0,1);
            }
            if ((local_a0 != '\x01') && (local_b0 != 0)) {
              FUN_0001f5c8(auVar4._0_8_,auVar4._8_8_,lVar3 + (ulong)local_b0,
                           CONCAT44(uStack_b4,local_b8));
            }
            uVar1 = uVar1 + 1;
          } while (uVar1 < local_50);
        }
        goto LAB_0001f4e0;
      }
    }
  }
  else {
    if (*param_2 != 1) {
LAB_0001f4e0:
      uVar2 = 1;
      goto LAB_0001f4ec;
    }
    uVar1 = FUN_0001f59c(param_1,auStack_90,0x38);
    if ((uVar1 & 1) != 0) {
      if (param_4 != 0) {
        FUN_0001f5d4(auStack_90);
      }
      if (*(long *)(param_1 + 0x28) != 0) {
        if (local_60 != 0) {
          uVar1 = 0;
          lVar3 = *(long *)(param_1 + 0x38);
          do {
            auVar4 = FUN_0001f59c(param_1,auStack_e0,0x44);
            uVar2 = auVar4._0_8_;
            if (auVar4._0_4_ == 0) goto LAB_0001f4ec;
            if (param_4 != 0) {
              auVar4 = FUN_0001f718(auStack_e0,1);
            }
            if ((local_a8 != '\x01') && (local_b8 != 0)) {
              FUN_0001f5c8(auVar4._0_8_,auVar4._8_8_,lVar3 + (ulong)local_b8,local_bc);
            }
            uVar1 = uVar1 + 1;
          } while (uVar1 < local_60);
        }
        goto LAB_0001f4e0;
      }
    }
  }
  uVar2 = 0;
LAB_0001f4ec:
  if (*(long *)PTR____stack_chk_guard_00028030 != local_48) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail(uVar2);
  }
  return;
}



bool FUN_0001f520(long param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  int iVar1;
  
  *(code **)(param_1 + 0x470) = FUN_0001f0d4;
  *(undefined8 *)(param_1 + 0x478) = 0;
  *(undefined8 *)(param_1 + 0x414) = 0xefcdab8967452301;
  *(undefined8 *)(param_1 + 0x41c) = 0x1032547698badcfe;
  *(undefined4 *)(param_1 + 0x428) = 0;
  *(undefined4 *)(param_1 + 0x424) = 0;
  iVar1 = FUN_0001f258();
  if (iVar1 != 0) {
    FUN_0001ee04(param_4,(undefined8 *)(param_1 + 0x414));
  }
  return iVar1 != 0;
}



void FUN_0001f59c(void)

{
  FUN_0001fc04();
  return;
}



void FUN_0001f5a4(void)

{
  FUN_0001f848();
  return;
}



void FUN_0001f5b4(void)

{
  FUN_0001f818();
  return;
}



void FUN_0001f5bc(void)

{
  return;
}



void FUN_0001f5c8(void)

{
  FUN_0001f0e0();
  return;
}



void FUN_0001f5d4(uint *param_1)

{
  uint uVar1;
  
  uVar1 = (*param_1 & 0xff00ff00) >> 8 | (*param_1 & 0xff00ff) << 8;
  *param_1 = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[1] & 0xff00ff00) >> 8 | (param_1[1] & 0xff00ff) << 8;
  param_1[1] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[6] & 0xff00ff00) >> 8 | (param_1[6] & 0xff00ff) << 8;
  param_1[6] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[7] & 0xff00ff00) >> 8 | (param_1[7] & 0xff00ff) << 8;
  param_1[7] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[8] & 0xff00ff00) >> 8 | (param_1[8] & 0xff00ff) << 8;
  param_1[8] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[9] & 0xff00ff00) >> 8 | (param_1[9] & 0xff00ff) << 8;
  param_1[9] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[10] & 0xff00ff00) >> 8 | (param_1[10] & 0xff00ff) << 8;
  param_1[10] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[0xb] & 0xff00ff00) >> 8 | (param_1[0xb] & 0xff00ff) << 8;
  param_1[0xb] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[0xc] & 0xff00ff00) >> 8 | (param_1[0xc] & 0xff00ff) << 8;
  param_1[0xc] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[0xd] & 0xff00ff00) >> 8 | (param_1[0xd] & 0xff00ff) << 8;
  param_1[0xd] = uVar1 >> 0x10 | uVar1 << 0x10;
  return;
}



void FUN_0001f63c(uint *param_1)

{
  uint uVar1;
  ulong uVar2;
  
  uVar1 = (*param_1 & 0xff00ff00) >> 8 | (*param_1 & 0xff00ff) << 8;
  *param_1 = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[1] & 0xff00ff00) >> 8 | (param_1[1] & 0xff00ff) << 8;
  param_1[1] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar2 = (*(ulong *)(param_1 + 6) & 0xff00ff00ff00ff00) >> 8 |
          (*(ulong *)(param_1 + 6) & 0xff00ff00ff00ff) << 8;
  uVar2 = (uVar2 & 0xffff0000ffff0000) >> 0x10 | (uVar2 & 0xffff0000ffff) << 0x10;
  *(ulong *)(param_1 + 6) = uVar2 >> 0x20 | uVar2 << 0x20;
  uVar2 = (*(ulong *)(param_1 + 8) & 0xff00ff00ff00ff00) >> 8 |
          (*(ulong *)(param_1 + 8) & 0xff00ff00ff00ff) << 8;
  uVar2 = (uVar2 & 0xffff0000ffff0000) >> 0x10 | (uVar2 & 0xffff0000ffff) << 0x10;
  *(ulong *)(param_1 + 8) = uVar2 >> 0x20 | uVar2 << 0x20;
  uVar2 = (*(ulong *)(param_1 + 10) & 0xff00ff00ff00ff00) >> 8 |
          (*(ulong *)(param_1 + 10) & 0xff00ff00ff00ff) << 8;
  uVar2 = (uVar2 & 0xffff0000ffff0000) >> 0x10 | (uVar2 & 0xffff0000ffff) << 0x10;
  *(ulong *)(param_1 + 10) = uVar2 >> 0x20 | uVar2 << 0x20;
  uVar2 = (*(ulong *)(param_1 + 0xc) & 0xff00ff00ff00ff00) >> 8 |
          (*(ulong *)(param_1 + 0xc) & 0xff00ff00ff00ff) << 8;
  uVar2 = (uVar2 & 0xffff0000ffff0000) >> 0x10 | (uVar2 & 0xffff0000ffff) << 0x10;
  *(ulong *)(param_1 + 0xc) = uVar2 >> 0x20 | uVar2 << 0x20;
  uVar1 = (param_1[0xe] & 0xff00ff00) >> 8 | (param_1[0xe] & 0xff00ff) << 8;
  param_1[0xe] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[0xf] & 0xff00ff00) >> 8 | (param_1[0xf] & 0xff00ff) << 8;
  param_1[0xf] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[0x10] & 0xff00ff00) >> 8 | (param_1[0x10] & 0xff00ff) << 8;
  param_1[0x10] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[0x11] & 0xff00ff00) >> 8 | (param_1[0x11] & 0xff00ff) << 8;
  param_1[0x11] = uVar1 >> 0x10 | uVar1 << 0x10;
  return;
}



void FUN_0001f6a4(long param_1,uint param_2)

{
  uint uVar1;
  ulong uVar2;
  uint *puVar3;
  
  if (param_2 != 0) {
    uVar2 = (ulong)param_2;
    puVar3 = (uint *)(param_1 + 8);
    do {
      uVar1 = (puVar3[-2] & 0xff00ff00) >> 8 | (puVar3[-2] & 0xff00ff) << 8;
      puVar3[-2] = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (puVar3[-1] & 0xff00ff00) >> 8 | (puVar3[-1] & 0xff00ff) << 8;
      puVar3[-1] = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (*puVar3 & 0xff00ff00) >> 8 | (*puVar3 & 0xff00ff) << 8;
      *puVar3 = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (puVar3[1] & 0xff00ff00) >> 8 | (puVar3[1] & 0xff00ff) << 8;
      puVar3[1] = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (puVar3[2] & 0xff00ff00) >> 8 | (puVar3[2] & 0xff00ff) << 8;
      puVar3[2] = uVar1 >> 0x10 | uVar1 << 0x10;
      puVar3 = puVar3 + 5;
      uVar2 = uVar2 - 1;
    } while (uVar2 != 0);
  }
  return;
}



void FUN_0001f6f4(void)

{
  uint uVar1;
  long lVar2;
  
  lVar2 = FUN_0001f790();
  uVar1 = (*(uint *)(lVar2 + 0x18) & 0xff00ff00) >> 8 | (*(uint *)(lVar2 + 0x18) & 0xff00ff) << 8;
  *(uint *)(lVar2 + 0x18) = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (*(uint *)(lVar2 + 0x1c) & 0xff00ff00) >> 8 | (*(uint *)(lVar2 + 0x1c) & 0xff00ff) << 8;
  *(uint *)(lVar2 + 0x1c) = uVar1 >> 0x10 | uVar1 << 0x10;
  return;
}



void FUN_0001f718(long param_1,uint param_2)

{
  uint uVar1;
  ulong uVar2;
  long extraout_x8;
  undefined4 *puVar3;
  undefined4 *extraout_x9;
  undefined4 extraout_w10;
  undefined8 unaff_x30;
  
  if (param_2 != 0) {
    uVar2 = (ulong)param_2;
    puVar3 = (undefined4 *)(param_1 + 0x40);
    do {
      uVar1 = (puVar3[-8] & 0xff00ff00) >> 8 | (puVar3[-8] & 0xff00ff) << 8;
      puVar3[-8] = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (puVar3[-7] & 0xff00ff00) >> 8 | (puVar3[-7] & 0xff00ff) << 8;
      puVar3[-7] = uVar1 >> 0x10 | uVar1 << 0x10;
      unaff_x30 = FUN_0001f7d0(uVar2,unaff_x30);
      puVar3 = extraout_x9 + 0x11;
      *extraout_x9 = extraout_w10;
      uVar2 = extraout_x8 - 1;
    } while (uVar2 != 0);
  }
  return;
}



void FUN_0001f754(long param_1,uint param_2)

{
  ulong uVar1;
  ulong uVar2;
  long extraout_x8;
  undefined4 *puVar3;
  undefined4 *extraout_x9;
  undefined4 extraout_w10;
  undefined8 unaff_x30;
  
  if (param_2 != 0) {
    uVar2 = (ulong)param_2;
    puVar3 = (undefined4 *)(param_1 + 0x48);
    do {
      uVar1 = (*(ulong *)(puVar3 + -10) & 0xff00ff00ff00ff00) >> 8 |
              (*(ulong *)(puVar3 + -10) & 0xff00ff00ff00ff) << 8;
      uVar1 = (uVar1 & 0xffff0000ffff0000) >> 0x10 | (uVar1 & 0xffff0000ffff) << 0x10;
      *(ulong *)(puVar3 + -10) = uVar1 >> 0x20 | uVar1 << 0x20;
      uVar1 = (*(ulong *)(puVar3 + -8) & 0xff00ff00ff00ff00) >> 8 |
              (*(ulong *)(puVar3 + -8) & 0xff00ff00ff00ff) << 8;
      uVar1 = (uVar1 & 0xffff0000ffff0000) >> 0x10 | (uVar1 & 0xffff0000ffff) << 0x10;
      *(ulong *)(puVar3 + -8) = uVar1 >> 0x20 | uVar1 << 0x20;
      unaff_x30 = FUN_0001f7d0(uVar2,unaff_x30);
      puVar3 = extraout_x9 + 0x14;
      *extraout_x9 = extraout_w10;
      uVar2 = extraout_x8 - 1;
    } while (uVar2 != 0);
  }
  return;
}



void FUN_0001f790(uint *param_1)

{
  uint uVar1;
  
  uVar1 = (*param_1 & 0xff00ff00) >> 8 | (*param_1 & 0xff00ff) << 8;
  *param_1 = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[1] & 0xff00ff00) >> 8 | (param_1[1] & 0xff00ff) << 8;
  param_1[1] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[2] & 0xff00ff00) >> 8 | (param_1[2] & 0xff00ff) << 8;
  param_1[2] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[3] & 0xff00ff00) >> 8 | (param_1[3] & 0xff00ff) << 8;
  param_1[3] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[4] & 0xff00ff00) >> 8 | (param_1[4] & 0xff00ff) << 8;
  param_1[4] = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (param_1[5] & 0xff00ff00) >> 8 | (param_1[5] & 0xff00ff) << 8;
  param_1[5] = uVar1 >> 0x10 | uVar1 << 0x10;
  return;
}



void FUN_0001f7d0(void)

{
  uint uVar1;
  long in_x9;
  
  uVar1 = (*(uint *)(in_x9 + -0x18) & 0xff00ff00) >> 8 | (*(uint *)(in_x9 + -0x18) & 0xff00ff) << 8;
  *(uint *)(in_x9 + -0x18) = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (*(uint *)(in_x9 + -0x14) & 0xff00ff00) >> 8 | (*(uint *)(in_x9 + -0x14) & 0xff00ff) << 8;
  *(uint *)(in_x9 + -0x14) = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (*(uint *)(in_x9 + -0x10) & 0xff00ff00) >> 8 | (*(uint *)(in_x9 + -0x10) & 0xff00ff) << 8;
  *(uint *)(in_x9 + -0x10) = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (*(uint *)(in_x9 + -0xc) & 0xff00ff00) >> 8 | (*(uint *)(in_x9 + -0xc) & 0xff00ff) << 8;
  *(uint *)(in_x9 + -0xc) = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (*(uint *)(in_x9 + -8) & 0xff00ff00) >> 8 | (*(uint *)(in_x9 + -8) & 0xff00ff) << 8;
  *(uint *)(in_x9 + -8) = uVar1 >> 0x10 | uVar1 << 0x10;
  uVar1 = (*(uint *)(in_x9 + -4) & 0xff00ff00) >> 8 | (*(uint *)(in_x9 + -4) & 0xff00ff) << 8;
  *(uint *)(in_x9 + -4) = uVar1 >> 0x10 | uVar1 << 0x10;
  return;
}



int * FUN_0001f818(int *param_1)

{
  if (*param_1 != -1) {
    _close(*param_1);
  }
  return param_1;
}



void FUN_0001f848(undefined8 param_1,ulong param_2,undefined8 param_3)

{
  int iVar1;
  NXArchInfo *pNVar2;
  uint uVar3;
  undefined8 local_28;
  
  uVar3 = (uint)param_2;
  if (uVar3 == 0) {
    pNVar2 = _NXGetLocalArchInfo();
    param_2 = (ulong)(uint)pNVar2->cputype;
    param_3 = 0xffffffff;
  }
  iVar1 = FUN_0001f8a8(param_1,param_2,param_3,&local_28);
  if (iVar1 != 0) {
    if ((uVar3 >> 0x18 & 1) == 0) {
      FUN_0001fb20();
    }
    else {
      FUN_0001fa90(param_1,local_28);
    }
  }
  return;
}



undefined8 FUN_0001f8a8(undefined8 param_1,uint param_2,uint param_3,ulong *param_4)

{
  undefined8 uVar1;
  ulong uVar2;
  int extraout_w9;
  uint uVar3;
  undefined auStack_68 [4];
  uint local_64;
  uint local_60;
  uint local_5c;
  uint local_58;
  uint local_44;
  
  uVar1 = FUN_0001fd34(param_1,&local_44,4);
  if ((int)uVar1 == 0) {
    return uVar1;
  }
  *param_4 = 4;
  if (1 < local_44 + 0x1120532) {
    if (local_44 == 0xbebafeca || local_44 == 0xcafebabe) {
      *param_4 = 0;
      uVar2 = FUN_0001fd34(param_1,auStack_68,8);
      if ((uVar2 & 1) == 0) {
        return 0;
      }
      FUN_0001fd1c();
      *param_4 = *param_4 + 8;
      if (extraout_w9 == 0) {
        return 0;
      }
      uVar3 = 0;
      while( true ) {
        uVar1 = FUN_0001fc04(param_1,&local_60,0x14);
        if ((int)uVar1 == 0) {
          return uVar1;
        }
        FUN_0001f6a4(&local_60,1);
        if ((local_60 == param_2) && (param_3 == 0xffffffff || local_5c == param_3)) break;
        *param_4 = *param_4 + 0x14;
        uVar3 = uVar3 + 1;
        if (local_64 <= uVar3) {
          return 0;
        }
      }
      *param_4 = (ulong)local_58;
      return 1;
    }
    if (local_44 != 0xcffaedfe && local_44 != 0xcefaedfe) {
      return 0;
    }
  }
  uVar1 = FUN_0001fd34(param_1,&local_60,0x1c);
  if ((int)uVar1 == 0) {
    return uVar1;
  }
  if ((local_44 | 0x1000000) == 0xcffaedfe) {
    uVar3 = (local_58 & 0xff00ff00) >> 8 | (local_58 & 0xff00ff) << 8;
    local_58 = uVar3 >> 0x10 | uVar3 << 0x10;
    uVar3 = (local_5c & 0xff00ff00) >> 8 | (local_5c & 0xff00ff) << 8;
    local_5c = uVar3 >> 0x10 | uVar3 << 0x10;
  }
  if ((local_5c == param_2) && ((param_3 == 0xffffffff || (local_58 == param_3)))) {
    *param_4 = 0;
    return 1;
  }
  return 0;
}



void FUN_0001fa90(long param_1,long param_2)

{
  int iVar1;
  int local_50 [4];
  undefined4 local_40;
  
  iVar1 = FUN_0001fc04(param_1,local_50,0x20,param_2);
  if (iVar1 != 0) {
    if (local_50[0] == -0x30051202) {
      FUN_0001f6f4(local_50);
    }
    *(int **)(param_1 + 0x28) = local_50;
    *(undefined8 *)(param_1 + 0x30) = 0x20;
    *(long *)(param_1 + 0x38) = param_2;
    FUN_0001fc88(param_1,param_2 + 0x20,local_40,local_50[0] == -0x30051202);
    *(undefined8 *)(param_1 + 0x30) = 0;
    *(undefined8 *)(param_1 + 0x38) = 0;
    *(undefined8 *)(param_1 + 0x28) = 0;
  }
  return;
}



void FUN_0001fb20(long param_1,long param_2)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  undefined8 local_60;
  uint uStack_58;
  uint uStack_54;
  uint uStack_50;
  undefined8 uStack_4c;
  undefined4 local_44;
  int local_40;
  uint uStack_3c;
  uint uStack_38;
  uint uStack_34;
  uint local_30;
  uint local_2c;
  uint local_28;
  
  iVar3 = FUN_0001fc04(param_1,&local_40,0x1c,param_2);
  iVar2 = local_40;
  if (iVar3 != 0) {
    if (local_40 == -0x31051202) {
      local_40 = -0x1120532;
      uVar1 = (uStack_3c & 0xff00ff00) >> 8 | (uStack_3c & 0xff00ff) << 8;
      uStack_3c = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (uStack_38 & 0xff00ff00) >> 8 | (uStack_38 & 0xff00ff) << 8;
      uStack_38 = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (uStack_34 & 0xff00ff00) >> 8 | (uStack_34 & 0xff00ff) << 8;
      uStack_34 = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (local_2c & 0xff00ff00) >> 8 | (local_2c & 0xff00ff) << 8;
      local_2c = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (local_30 & 0xff00ff00) >> 8 | (local_30 & 0xff00ff) << 8;
      local_30 = uVar1 >> 0x10 | uVar1 << 0x10;
      uVar1 = (local_28 & 0xff00ff00) >> 8 | (local_28 & 0xff00ff) << 8;
      local_28 = uVar1 >> 0x10 | uVar1 << 0x10;
    }
    local_60 = CONCAT44(uStack_3c,local_40);
    uStack_58 = uStack_38;
    uStack_4c = CONCAT44(local_28,local_2c);
    uStack_54 = uStack_34;
    uStack_50 = local_30;
    local_44 = 0;
    *(undefined8 **)(param_1 + 0x28) = &local_60;
    *(undefined8 *)(param_1 + 0x30) = 0x1c;
    *(long *)(param_1 + 0x38) = param_2;
    FUN_0001fc88(param_1,param_2 + 0x1c,local_30,iVar2 == -0x31051202);
    *(undefined8 *)(param_1 + 0x30) = 0;
    *(undefined8 *)(param_1 + 0x38) = 0;
    *(undefined8 *)(param_1 + 0x28) = 0;
  }
  return;
}



bool FUN_0001fc04(int *param_1,void *param_2,size_t param_3,ulong param_4)

{
  size_t sVar1;
  ulong uVar2;
  bool bVar3;
  
  if (*(long *)(param_1 + 2) == 0) {
    sVar1 = _pread(*param_1,param_2,param_3,param_4);
    return sVar1 == param_3;
  }
  if ((long)param_4 < 0) {
LAB_0001fc58:
    bVar3 = false;
  }
  else {
    uVar2 = *(ulong *)(param_1 + 4);
    if (uVar2 < param_4 + param_3) {
      param_3 = uVar2 - param_4;
      if (uVar2 < param_4 || param_3 == 0) goto LAB_0001fc58;
      bVar3 = false;
    }
    else {
      bVar3 = true;
    }
    _memcpy(param_2,(void *)(*(long *)(param_1 + 2) + param_4),param_3);
  }
  return bVar3;
}



undefined8 FUN_0001fc88(long param_1,long param_2,int param_3,undefined8 param_4)

{
  undefined8 uVar1;
  ulong uVar2;
  undefined auStack_38 [4];
  uint local_34;
  
  if (param_3 != 0) {
    do {
      uVar1 = FUN_0001fc04(param_1,auStack_38,8,param_2);
      if ((int)uVar1 == 0) {
        return uVar1;
      }
      if ((int)param_4 != 0) {
        FUN_0001fd1c();
      }
      if ((*(code **)(param_1 + 0x18) != (code *)0x0) &&
         (uVar2 = (**(code **)(param_1 + 0x18))
                            (param_1,auStack_38,param_2,param_4,*(undefined8 *)(param_1 + 0x20)),
         (uVar2 & 1) == 0)) {
        return 1;
      }
      param_2 = param_2 + (ulong)local_34;
      param_3 = param_3 + -1;
    } while (param_3 != 0);
  }
  return 1;
}



void FUN_0001fd1c(void)

{
  return;
}



void FUN_0001fd34(void)

{
  FUN_0001fc04();
  return;
}



void FUN_0001fd3c(undefined8 *param_1,undefined8 param_2)

{
  ulong uVar1;
  long lVar2;
  long lVar3;
  void *pvVar4;
  long local_48;
  
  lVar2 = _CFStringGetLength();
  param_1[1] = 0;
  param_1[2] = 0;
  *param_1 = 0;
  if (lVar2 != 0) {
    lVar3 = _CFStringGetMaximumSizeForEncoding(lVar2,0x8000100);
    uVar1 = 0xffffffffffffffff;
    if (lVar3 + 1 < 0 == SCARRY8(lVar3,1)) {
      uVar1 = lVar3 + 1;
    }
    pvVar4 = operator_new__(uVar1);
    _CFStringGetBytes(param_2,0,lVar2,0x8000100,0,0,pvVar4,lVar3,&local_48);
    *(undefined *)((long)pvVar4 + local_48) = 0;
    std::__1::basic_string<>::assign((char *)param_1);
    operator_delete__(pvVar4);
  }
  return;
}



int FUN_0001fe24(long **param_1,ulong param_2)

{
  long *plVar1;
  size_t sVar2;
  undefined8 ****ppppuVar3;
  ulong uVar4;
  char cVar5;
  long **pplVar6;
  void *pvVar7;
  ulong uVar8;
  char *pcVar9;
  ulong uVar10;
  undefined8 ****ppppuVar11;
  long *plVar12;
  long *plVar13;
  ulong uVar14;
  long *plVar15;
  int local_b4;
  basic_string abStack_a8 [24];
  undefined8 ****local_90;
  undefined8 uStack_88;
  long local_80;
  undefined8 ****local_78;
  undefined2 local_70;
  undefined local_6e;
  undefined5 uStack_6d;
  byte local_61;
  
  plVar15 = (long *)0x0;
  uVar14 = 0;
  local_b4 = 0;
  uVar8 = 10;
  local_61 = 10;
  local_70 = 0x3938;
  local_80 = 0;
  local_78 = (undefined8 ****)0x3736353433323130;
  local_6e = 0;
  local_90 = (undefined8 ****)0x0;
  uStack_88 = 0;
  while (uVar14 != (param_2 & 0xffffffff) + 1) {
    plVar1 = param_1[1];
    pplVar6 = (long **)*param_1;
    if (-1 < (char)*(byte *)((long)param_1 + 0x17)) {
      plVar1 = (long *)(ulong)*(byte *)((long)param_1 + 0x17);
      pplVar6 = param_1;
    }
    sVar2 = CONCAT53(uStack_6d,CONCAT12(local_6e,local_70));
    ppppuVar3 = local_78;
    if (-1 < (char)uVar8) {
      sVar2 = uVar8 & 0xff;
      ppppuVar3 = &local_78;
    }
    plVar12 = plVar15;
    if (plVar15 < plVar1) {
      do {
        plVar13 = plVar15;
        if ((sVar2 == 0) ||
           (pvVar7 = _memchr(ppppuVar3,(uint)*(byte *)((long)pplVar6 + (long)plVar12),sVar2),
           plVar13 = plVar12, pvVar7 == (void *)0x0)) {
          if (plVar13 != (long *)0xffffffffffffffff) goto LAB_0001ff14;
          break;
        }
        plVar12 = (long *)((long)plVar12 + 1);
      } while (plVar1 != plVar12);
    }
    plVar13 = plVar1;
LAB_0001ff14:
    std::__1::basic_string<>::basic_string
              (abStack_a8,(ulong)param_1,(ulong)plVar15,(allocator *)((long)plVar13 - (long)plVar15)
              );
    std::__1::basic_string<>::operator=((basic_string<> *)&local_90,abStack_a8);
    std::__1::basic_string<>::~basic_string((basic_string<> *)abStack_a8);
    if (uVar14 == (param_2 & 0xffffffff)) {
      ppppuVar3 = local_90;
      if (-1 < local_80) {
        ppppuVar3 = &local_90;
      }
      local_b4 = _atoi((char *)ppppuVar3);
    }
    plVar15 = param_1[1];
    pplVar6 = (long **)*param_1;
    if (-1 < (char)*(byte *)((long)param_1 + 0x17)) {
      plVar15 = (long *)(ulong)*(byte *)((long)param_1 + 0x17);
      pplVar6 = param_1;
    }
    uVar8 = (ulong)(uint)(int)(char)local_61;
    uVar4 = CONCAT53(uStack_6d,CONCAT12(local_6e,local_70));
    ppppuVar3 = local_78;
    if (-1 < (char)local_61) {
      uVar4 = (ulong)local_61;
      ppppuVar3 = &local_78;
    }
    if ((plVar15 <= (long *)((long)plVar13 + 1U)) || (uVar4 == 0)) break;
    pcVar9 = (char *)((long)pplVar6 + (long)(long *)((long)plVar13 + 1U));
    uVar10 = uVar4;
    ppppuVar11 = ppppuVar3;
    do {
      while (uVar10 == 0) {
        pcVar9 = pcVar9 + 1;
        uVar10 = uVar4;
        ppppuVar11 = ppppuVar3;
        if (pcVar9 == (char *)((long)pplVar6 + (long)plVar15)) goto LAB_0001fff4;
      }
      cVar5 = *(char *)ppppuVar11;
      uVar10 = uVar10 - 1;
      ppppuVar11 = (undefined8 ****)((long)ppppuVar11 + 1);
    } while (*pcVar9 != cVar5);
    plVar15 = (long *)(pcVar9 + -(long)pplVar6);
    uVar14 = uVar14 + 1;
    if (plVar15 == (long *)0xffffffffffffffff) break;
  }
LAB_0001fff4:
  std::__1::basic_string<>::~basic_string((basic_string<> *)&local_90);
  std::__1::basic_string<>::~basic_string((basic_string<> *)&local_78);
  return local_b4;
}



long FUN_00020058(long param_1)

{
  if (*(char *)(param_1 + 4) != '\0') {
    FUN_00020088(param_1);
  }
  return param_1;
}



bool FUN_00020088(int *param_1)

{
  bool bVar1;
  int iVar2;
  
  if (*param_1 == -1) {
    bVar1 = true;
  }
  else {
    iVar2 = _ftruncate(*param_1,(ulong)(uint)param_1[2]);
    if (iVar2 == 0) {
      iVar2 = _close(*param_1);
      bVar1 = iVar2 == 0;
      *param_1 = -1;
    }
    else {
      bVar1 = false;
    }
  }
  return bVar1;
}



bool FUN_000200e4(int *param_1,char *param_2)

{
  int iVar1;
  
  iVar1 = _open(param_2,0xa01);
  *param_1 = iVar1;
  return iVar1 != -1;
}



void FUN_00020128(undefined8 param_1,int param_2,int param_3,undefined8 param_4,undefined8 param_5)

{
  FUN_00020368(param_1,param_2 + (int)param_5 * param_3 + 4,param_4,param_5);
  return;
}



undefined8 FUN_0002013c(long param_1,long param_2,uint param_3,undefined8 *param_4)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  undefined8 uVar4;
  int iVar5;
  ulong uVar6;
  ulong uVar7;
  int iVar8;
  long local_80;
  undefined4 local_78;
  undefined8 local_70;
  undefined8 local_68;
  undefined4 local_60;
  undefined2 local_54;
  short local_52;
  
  uVar6 = 0;
  uVar1 = 0x7fffffff;
  if (param_3 != 0) {
    uVar1 = param_3;
  }
  do {
    uVar7 = uVar6;
    if (*(char *)(param_2 + uVar6) == '\0') break;
    uVar6 = uVar6 + 1;
    uVar7 = (ulong)uVar1;
  } while (uVar1 != uVar6);
  local_78 = *(undefined4 *)(param_1 + 8);
  local_70 = 0;
  local_68 = 0;
  iVar5 = (int)uVar7;
  local_60 = 3;
  local_80 = param_1;
  uVar6 = FUN_000202b0(&local_80,(ulong)(iVar5 + 1) * 2 + 4);
  if ((uVar6 & 1) == 0) {
LAB_00020260:
    uVar4 = 0;
  }
  else {
    local_68 = CONCAT44(local_68._4_4_,iVar5 << 1);
    if (iVar5 != 0) {
      iVar5 = 0;
      uVar6 = uVar7;
      do {
        iVar2 = FUN_0001eeb0(param_2,uVar6,&local_54);
        if (iVar2 == 0) goto LAB_00020260;
        iVar8 = 1;
        if (local_52 != 0) {
          iVar8 = 2;
        }
        uVar3 = FUN_00020128(local_80,local_78,iVar5,&local_54,iVar8 << 1);
        uVar1 = (int)uVar6 - iVar2;
        uVar6 = (ulong)uVar1;
        param_2 = param_2 + iVar2;
        iVar5 = iVar8 + iVar5;
      } while ((uVar1 != 0 & uVar3) != 0);
      if (uVar3 == 0) goto LAB_00020260;
    }
    local_54 = 0;
    uVar4 = FUN_00020128(local_80,local_78,uVar7,&local_54,2);
    if ((int)uVar4 != 0) {
      *param_4 = CONCAT44(local_78,(undefined4)local_70);
    }
  }
  FUN_000203e4(&local_80);
  return uVar4;
}



bool FUN_000202b0(undefined8 *param_1,undefined8 param_2)

{
  int iVar1;
  
  param_1[2] = param_2;
  iVar1 = FUN_000202f4(*param_1);
  *(int *)(param_1 + 1) = iVar1;
  return iVar1 != -1;
}



void FUN_000202e4(long param_1,undefined8 param_2,undefined8 param_3)

{
  FUN_000203dc(param_1,*(undefined4 *)(param_1 + 8),param_2,param_3);
  return;
}



void FUN_000202f4(int *param_1,long param_2)

{
  long lVar1;
  int iVar2;
  ulong uVar3;
  ulong uVar4;
  ulong uVar5;
  
  uVar5 = param_2 + 7U & 0xfffffffffffffff8;
  uVar3 = (ulong)(uint)param_1[2];
  uVar4 = *(ulong *)(param_1 + 4);
  if (uVar4 < uVar5 + uVar3) {
    iVar2 = _getpagesize();
    uVar3 = (long)iVar2;
    if ((ulong)(long)iVar2 <= uVar5) {
      uVar3 = uVar5;
    }
    lVar1 = uVar3 + uVar4;
    iVar2 = _ftruncate(*param_1,lVar1);
    if (iVar2 != 0) {
      uVar3 = 0xffffffff;
      goto LAB_00020360;
    }
    *(long *)(param_1 + 4) = lVar1;
    uVar3 = (ulong)(uint)param_1[2];
  }
  param_1[2] = (int)uVar3 + (int)uVar5;
LAB_00020360:
  FUN_00020424(uVar3);
  return;
}



void FUN_00020368(int *param_1,ulong param_2,void *param_3,size_t param_4)

{
  ulong uVar1;
  size_t sVar2;
  undefined8 uVar3;
  
  if (((*(ulong *)(param_1 + 4) < param_4 + (param_2 & 0xffffffff)) ||
      (uVar1 = _lseek(*param_1,param_2 & 0xffffffff,0), uVar1 != (param_2 & 0xffffffff))) ||
     (sVar2 = _write(*param_1,param_3,param_4), sVar2 != param_4)) {
    uVar3 = 0;
  }
  else {
    uVar3 = 1;
  }
  FUN_00020424(uVar3);
  return;
}



void FUN_000203dc(undefined8 *param_1)

{
  FUN_00020368(*param_1);
  return;
}



undefined8 * FUN_000203e4(undefined8 *param_1)

{
  if (*(int *)(param_1 + 4) != 2) {
    FUN_00020368(*param_1,*(undefined4 *)(param_1 + 1),param_1 + 3,4);
  }
  return param_1;
}



void FUN_00020424(void)

{
  return;
}



kern_return_t FUN_00020430(vm_map_t param_1,ulong param_2,size_t param_3,void **param_4)

{
  int iVar1;
  kern_return_t kVar2;
  ulong address;
  uint local_4c;
  vm_address_t local_48;
  
  iVar1 = _getpagesize();
  address = (long)-iVar1 & param_2;
  kVar2 = _vm_read(param_1,address,(param_3 + param_2 + (long)(iVar1 + -1) & (long)-iVar1) - address
                   ,&local_48,&local_4c);
  if (kVar2 == 0) {
    FUN_000204f0(param_4,param_3);
    _memcpy(*param_4,(void *)(local_48 + (param_2 - address)),param_3);
    _vm_deallocate(*(vm_map_t *)PTR__mach_task_self__00028040,local_48,(ulong)local_4c);
  }
  return kVar2;
}



void FUN_000204f0(long *param_1,ulong param_2)

{
  ulong uVar1;
  
  uVar1 = param_1[1] - *param_1;
  if (uVar1 < param_2) {
    FUN_00020ab8(param_1,param_2 - uVar1);
    return;
  }
  if (param_2 < uVar1) {
    param_1[1] = *param_1 + param_2;
  }
  return;
}



void FUN_00020518(undefined4 *param_1,undefined8 param_2)

{
  undefined4 uVar1;
  
  *param_1 = (int)param_2;
  uVar1 = FUN_00020570(param_2);
  param_1[1] = uVar1;
  *(undefined8 *)(param_1 + 2) = 0;
  *(undefined8 *)(param_1 + 4) = 0;
  *(undefined8 *)(param_1 + 6) = 0;
  FUN_0002064c(param_1);
  FUN_00021ac0(param_1);
  return;
}



undefined4 FUN_00020570(ulong param_1)

{
  mach_port_name_t t;
  uint uVar1;
  undefined4 uVar2;
  size_t local_80;
  undefined4 local_74;
  size_t local_70;
  int aiStack_68 [12];
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  t = (mach_port_name_t)param_1;
  uVar2 = 0x100000c;
  if (*(mach_port_name_t *)PTR__mach_task_self__00028040 != t) {
    local_70 = 0xc;
    uVar1 = _sysctlnametomib("sysctl.proc_cputype",aiStack_68,&local_70);
    param_1 = (ulong)uVar1;
    if (uVar1 == 0) {
      _pid_for_task(t,aiStack_68 + local_70);
      local_70 = local_70 + 1;
      local_80 = 4;
      uVar1 = _sysctl(aiStack_68,(u_int)local_70,&local_74,&local_80,(void *)0x0,0);
      param_1 = (ulong)uVar1;
      uVar2 = local_74;
    }
  }
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return uVar2;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(param_1);
}



void FUN_0002064c(long param_1)

{
  long lVar1;
  
  lVar1 = FUN_0002069c();
  if (lVar1 == 0) {
    return;
  }
  if ((*(byte *)(param_1 + 7) & 1) == 0) {
    FUN_00020894(param_1);
    return;
  }
  FUN_000206dc(param_1,lVar1);
  return;
}



undefined8 FUN_0002069c(task_name_t *param_1)

{
  kern_return_t kVar1;
  mach_msg_type_number_t local_2c;
  undefined8 local_28 [3];
  
  local_2c = 5;
  kVar1 = _task_info(*param_1,0x11,(task_info_t)local_28,&local_2c);
  if (kVar1 != 0) {
    local_28[0] = 0;
  }
  return local_28[0];
}



void FUN_000206dc(void)

{
  int iVar1;
  undefined8 uVar2;
  void *pvVar3;
  long extraout_x8;
  undefined4 *unaff_x19;
  long unaff_x20;
  undefined8 *puVar4;
  undefined auVar5 [16];
  void *local_c8 [3];
  undefined8 local_b0;
  undefined8 uStack_a8;
  undefined8 local_a0;
  long local_98;
  undefined8 uStack_90;
  undefined8 local_88;
  undefined8 *local_80 [3];
  undefined auStack_68 [24];
  
  auVar5 = FUN_00021adc();
  iVar1 = FUN_00020430(auVar5._0_8_,auVar5._8_8_,0x20,auStack_68);
  if (iVar1 == 0) {
    uVar2 = FUN_00021a98();
    iVar1 = FUN_00020430(uVar2,*(undefined8 *)(extraout_x8 + 8),unaff_x20 * 0x18,local_80);
    if (iVar1 == 0) {
      FUN_00021b34();
      puVar4 = local_80[0];
      if (0 < (int)unaff_x20) {
        do {
          local_98 = 0;
          uStack_90 = 0;
          local_88 = 0;
          iVar1 = FUN_00020430(*unaff_x19,*puVar4,0x20,&local_98);
          if ((iVar1 == 0) &&
             (iVar1 = FUN_00021b08(*(undefined4 *)(local_98 + 0x14),*unaff_x19,*puVar4), iVar1 == 0)
             ) {
            local_b0 = 0;
            uStack_a8 = 0;
            local_a0 = 0;
            if (puVar4[1] != 0) {
              FUN_00020c8c(local_c8,*unaff_x19);
              FUN_00021af0();
              FUN_00021a80();
            }
            pvVar3 = operator_new(0x70);
            FUN_00021ad0();
            FUN_00021a20();
            FUN_00021a60();
            if (*(long *)((long)pvVar3 + 0x30) == 0) {
              FUN_00021284(pvVar3);
              FUN_00021ab8();
            }
            else {
              local_c8[0] = pvVar3;
              FUN_00021b40();
            }
            FUN_00021a78();
          }
          FUN_00021ab0();
          puVar4 = puVar4 + 3;
          unaff_x20 = unaff_x20 + -1;
        } while (unaff_x20 != 0);
      }
      FUN_000212ac(*(undefined8 *)(unaff_x19 + 2),*(undefined8 *)(unaff_x19 + 4));
      FUN_00021960(*(undefined8 *)(unaff_x19 + 2),*(undefined8 *)(unaff_x19 + 4));
      FUN_00021a68();
    }
    FUN_00021a90();
  }
  FUN_00021a88();
  FUN_000219f0();
  return;
}



void FUN_00020894(void)

{
  int iVar1;
  undefined8 uVar2;
  void *pvVar3;
  long extraout_x8;
  undefined4 *unaff_x19;
  long unaff_x20;
  undefined4 *puVar4;
  undefined auVar5 [16];
  void *local_c8 [3];
  undefined8 local_b0;
  undefined8 uStack_a8;
  undefined8 local_a0;
  long local_98;
  undefined8 uStack_90;
  undefined8 local_88;
  undefined4 *local_80 [3];
  undefined auStack_68 [24];
  
  auVar5 = FUN_00021adc();
  iVar1 = FUN_00020430(auVar5._0_8_,auVar5._8_8_,0x14,auStack_68);
  if (iVar1 == 0) {
    uVar2 = FUN_00021a98();
    iVar1 = FUN_00020430(uVar2,*(undefined4 *)(extraout_x8 + 8),unaff_x20 * 0xc,local_80);
    if (iVar1 == 0) {
      FUN_00021b34();
      puVar4 = local_80[0];
      if (0 < (int)unaff_x20) {
        do {
          local_98 = 0;
          uStack_90 = 0;
          local_88 = 0;
          iVar1 = FUN_00020430(*unaff_x19,*puVar4,0x1c,&local_98);
          if ((iVar1 == 0) &&
             (iVar1 = FUN_00021b08(*(undefined4 *)(local_98 + 0x14),*unaff_x19,*puVar4), iVar1 == 0)
             ) {
            local_b0 = 0;
            uStack_a8 = 0;
            local_a0 = 0;
            if (puVar4[1] != 0) {
              FUN_00020c8c(local_c8,*unaff_x19);
              FUN_00021af0();
              FUN_00021a80();
            }
            pvVar3 = operator_new(0x70);
            FUN_00021ad0();
            FUN_00021a20();
            FUN_00021a60();
            if (*(long *)((long)pvVar3 + 0x30) == 0) {
              FUN_00021284(pvVar3);
              FUN_00021ab8();
            }
            else {
              local_c8[0] = pvVar3;
              FUN_00021b40();
            }
            FUN_00021a78();
          }
          FUN_00021ab0();
          puVar4 = puVar4 + 3;
          unaff_x20 = unaff_x20 + -1;
        } while (unaff_x20 != 0);
      }
      FUN_000212ac(*(undefined8 *)(unaff_x19 + 2),*(undefined8 *)(unaff_x19 + 4));
      FUN_00021960(*(undefined8 *)(unaff_x19 + 2),*(undefined8 *)(unaff_x19 + 4));
      FUN_00021a68();
    }
    FUN_00021a90();
  }
  FUN_00021a88();
  FUN_000219f0();
  return;
}



int FUN_00020a4c(long param_1)

{
  long lVar1;
  long lVar2;
  
  lVar2 = 0;
  do {
    if ((*(long *)(param_1 + 0x10) - *(long *)(param_1 + 8)) * 0x20000000 >> 0x20 <= lVar2) {
      return -1;
    }
    lVar1 = lVar2 * 8;
    lVar2 = lVar2 + 1;
  } while (*(int *)(**(long **)(*(long *)(param_1 + 8) + lVar1) + 0xc) != 2);
  return (int)lVar2 + -1;
}



void FUN_00020a8c(void **param_1)

{
  void *pvVar1;
  
  pvVar1 = *param_1;
  if (pvVar1 != (void *)0x0) {
    param_1[1] = pvVar1;
    operator_delete(pvVar1);
  }
  FUN_00021ac0(param_1);
  return;
}



void FUN_00020ab8(void **param_1,ulong param_2)

{
  ulong uVar1;
  void *pvVar2;
  ulong uVar3;
  ulong uVar4;
  void *pvVar5;
  size_t sVar6;
  
  pvVar2 = param_1[1];
  if (param_2 <= (ulong)((long)param_1[2] - (long)pvVar2)) {
    pvVar5 = pvVar2;
    if (param_2 != 0) {
      pvVar5 = (void *)((long)pvVar2 + param_2);
      _bzero(pvVar2,param_2);
    }
    param_1[1] = pvVar5;
    return;
  }
  pvVar5 = *param_1;
  sVar6 = (long)pvVar2 - (long)pvVar5;
  uVar1 = sVar6 + param_2;
  if (-1 < (long)uVar1) {
    uVar3 = (long)param_1[2] - (long)pvVar5;
    uVar4 = uVar3 * 2;
    if (uVar1 <= uVar4) {
      uVar1 = uVar4;
    }
    if (0x3ffffffffffffffe < uVar3) {
      uVar1 = 0x7fffffffffffffff;
    }
    if (uVar1 == 0) {
      pvVar2 = (void *)0x0;
    }
    else {
      pvVar2 = operator_new(uVar1);
    }
    _bzero((void *)((long)pvVar2 + sVar6),param_2);
    if (0 < (long)sVar6) {
      _memcpy(pvVar2,pvVar5,sVar6);
    }
    *param_1 = pvVar2;
    param_1[1] = (void *)((long)(void *)((long)pvVar2 + sVar6) + param_2);
    param_1[2] = (void *)((long)pvVar2 + uVar1);
    operator_delete(pvVar5);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_00021b64();
}



void FUN_00020bb8(void)

{
  undefined8 uVar1;
  
  uVar1 = ___cxa_allocate_exception(0x10);
  FUN_00020c04();
                    // WARNING: Subroutine does not return
  ___cxa_throw(uVar1,PTR_typeinfo_00028018,PTR__length_error_00028008);
}



void FUN_00020c04(logic_error *param_1)

{
  long *plVar1;
  
  plVar1 = (long *)std::logic_error::logic_error
                             (param_1,
                              "allocator<T>::allocate(size_t n) \'n\' exceeds maximum supported size"
                             );
  *plVar1 = (long)(PTR_vtable_00028020 + 0x10);
  return;
}



void FUN_00020c30(long *param_1,ulong param_2)

{
  undefined auStack_48 [40];
  
  if ((ulong)(param_1[2] - *param_1 >> 3) < param_2) {
    FUN_00020f2c(auStack_48,param_2,param_1[1] - *param_1 >> 3,param_1 + 2);
    FUN_00020ec0(param_1,auStack_48);
    FUN_00020f8c(auStack_48);
  }
  FUN_00021b14();
  return;
}



void FUN_00020c8c(undefined8 *param_1,undefined8 param_2,long param_3)

{
  ulong uVar1;
  char *pcVar2;
  int iVar3;
  undefined8 uVar4;
  long local_a8;
  long local_a0;
  undefined4 local_94;
  char *local_90;
  undefined8 uStack_88;
  undefined8 local_80;
  undefined4 local_44;
  long local_40;
  long local_38;
  
  local_44 = 0;
  local_94 = 0x13;
  local_38 = param_3;
  uVar4 = FUN_00021a4c(param_1,&local_38,&local_40);
  if ((int)uVar4 == 0) {
    if ((((ulong)((local_40 + local_38) - param_3) < 0x1000) &&
        (local_a0 = local_40 + local_38, iVar3 = FUN_00021a4c(uVar4,&local_a0,&local_a8), iVar3 == 0
        )) && (local_a0 == local_40 + local_38)) {
      local_40 = local_a8 + local_40;
    }
    uVar1 = (local_40 - param_3) + local_38;
    if (uVar1 != 0) {
      if (0x1fff < uVar1) {
        uVar1 = 0x2000;
      }
      local_90 = (char *)0x0;
      uStack_88 = 0;
      local_80 = 0;
      iVar3 = FUN_00020430(param_2,param_3,uVar1,&local_90);
      pcVar2 = local_90;
      if (iVar3 == 0) {
        _strlen(local_90);
        std::__1::basic_string<>::__init((char *)param_1,(ulong)pcVar2);
      }
      else {
        *param_1 = 0;
        param_1[1] = 0;
        param_1[2] = 0;
      }
      FUN_00021258(&local_90);
      return;
    }
  }
  *param_1 = 0;
  param_1[1] = 0;
  param_1[2] = 0;
  return;
}



void FUN_00020dc4(void)

{
  ulong uVar1;
  long lVar2;
  long lVar3;
  undefined8 *puVar4;
  ulong uVar5;
  long *unaff_x19;
  undefined8 *unaff_x20;
  undefined auStack_48 [16];
  undefined8 *local_38;
  
  lVar2 = FUN_00021b58();
  puVar4 = *(undefined8 **)(lVar2 + 8);
  if (puVar4 == *(undefined8 **)(lVar2 + 0x10)) {
    lVar3 = (long)puVar4 - *unaff_x19 >> 3;
    uVar1 = lVar3 + 1;
    if (uVar1 >> 0x3d != 0) {
                    // WARNING: Subroutine does not return
      FUN_00021b64();
    }
    lVar2 = (long)*(undefined8 **)(lVar2 + 0x10) - *unaff_x19;
    uVar5 = lVar2 >> 2;
    if (uVar1 <= uVar5) {
      uVar1 = uVar5;
    }
    if (0xffffffffffffffe < (ulong)(lVar2 >> 3)) {
      uVar1 = 0x1fffffffffffffff;
    }
    FUN_00020f2c(auStack_48,uVar1,lVar3,unaff_x19 + 2);
    *local_38 = *unaff_x20;
    local_38 = local_38 + 1;
    FUN_00020ec0();
    FUN_00020f8c(auStack_48);
  }
  else {
    *puVar4 = *unaff_x20;
    unaff_x19[1] = (long)(puVar4 + 1);
  }
  FUN_00021b14();
  return;
}



void FUN_00020e68(long param_1,void *param_2,void *param_3)

{
  size_t sVar1;
  
  if (param_2 != param_3) {
    sVar1 = *(long *)(param_1 + 8) - (long)param_3;
    if (sVar1 != 0) {
      _memmove(param_2,param_3,sVar1);
    }
    *(void **)(param_1 + 8) = (void *)((long)param_2 + ((long)sVar1 >> 3) * 8);
  }
  return;
}



void FUN_00020ec0(long *param_1,undefined8 *param_2)

{
  undefined8 *puVar1;
  long lVar2;
  undefined8 *puVar3;
  
  puVar1 = (undefined8 *)*param_1;
  puVar3 = (undefined8 *)param_1[1];
  if (puVar3 == puVar1) {
    lVar2 = param_2[1];
  }
  else {
    lVar2 = param_2[1];
    do {
      puVar3 = puVar3 + -1;
      *(undefined8 *)(lVar2 + -8) = *puVar3;
      lVar2 = param_2[1] + -8;
      param_2[1] = lVar2;
    } while (puVar1 != puVar3);
    puVar1 = (undefined8 *)*param_1;
  }
  *param_1 = lVar2;
  param_2[1] = puVar1;
  lVar2 = param_1[1];
  param_1[1] = param_2[2];
  param_2[2] = lVar2;
  lVar2 = param_1[2];
  param_1[2] = param_2[3];
  param_2[3] = lVar2;
  *param_2 = param_2[1];
  return;
}



void FUN_00020f2c(undefined8 param_1,undefined8 param_2,long param_3,undefined8 param_4)

{
  void *pvVar1;
  void *pvVar2;
  void **unaff_x19;
  ulong unaff_x20;
  undefined auVar3 [16];
  
  auVar3 = FUN_00021b58();
  *(undefined8 *)(auVar3._0_8_ + 0x18) = 0;
  *(undefined8 *)(auVar3._0_8_ + 0x20) = param_4;
  if (auVar3._8_8_ == 0) {
    pvVar2 = (void *)0x0;
  }
  else {
    if (unaff_x20 >> 0x3d != 0) {
                    // WARNING: Subroutine does not return
      FUN_00020bb8();
    }
    pvVar2 = operator_new(unaff_x20 << 3);
  }
  pvVar1 = (void *)((long)pvVar2 + param_3 * 8);
  *unaff_x19 = pvVar2;
  unaff_x19[1] = pvVar1;
  unaff_x19[2] = pvVar1;
  unaff_x19[3] = (void *)((long)pvVar2 + unaff_x20 * 8);
  return;
}



void FUN_00020f8c(void **param_1)

{
  long lVar1;
  
  lVar1 = (long)param_1[2] - (long)param_1[1];
  if (lVar1 != 0) {
    param_1[2] = (void *)((long)param_1[2] + (lVar1 - 8U >> 3 ^ 0xffffffffffffffff) * 8);
  }
  operator_delete(*param_1);
  FUN_00021ac0(param_1);
  return;
}



void FUN_00020fd0(int **param_1,void *param_2,int *param_3,int *param_4,undefined8 param_5,
                 int *param_6,undefined4 param_7,uint param_8)

{
  bool bVar1;
  int iVar2;
  int *piVar3;
  bool bVar4;
  int iVar5;
  int *piVar6;
  undefined8 unaff_x30;
  int *piVar7;
  
  *param_1 = (int *)0x0;
  param_1[1] = (int *)0x0;
  param_1[2] = (int *)0x0;
  if (param_3 != (int *)0x0) {
    if ((long)param_3 < 0) {
                    // WARNING: Subroutine does not return
      FUN_00021b64();
    }
    piVar3 = (int *)operator_new((ulong)param_3);
    *param_1 = piVar3;
    param_1[1] = piVar3;
    param_1[2] = (int *)((long)piVar3 + (long)param_3);
    _memcpy(piVar3,param_2,(size_t)param_3);
    param_1[1] = (int *)((long)piVar3 + (long)param_3);
  }
  param_1[5] = (int *)0x0;
  param_1[3] = param_3;
  param_1[4] = param_4;
  param_1[6] = (int *)0x0;
  param_1[7] = (int *)0x0;
  *(undefined4 *)(param_1 + 8) = 0;
  std::__1::basic_string<>::basic_string((basic_string *)(param_1 + 9));
  param_1[0xc] = param_6;
  *(undefined4 *)(param_1 + 0xd) = param_7;
  *(uint *)((long)param_1 + 0x6c) = param_8;
  param_1[5] = (int *)0x0;
  param_1[6] = (int *)0x0;
  *(undefined4 *)(param_1 + 8) = 0;
  param_1[7] = (int *)0x0;
  piVar3 = *param_1;
  if ((param_8 >> 0x18 & 1) == 0) {
    if ((*piVar3 == -0x1120532) && (iVar5 = piVar3[4], iVar5 != 0)) {
      bVar1 = false;
      bVar4 = false;
      piVar6 = param_1[4];
      piVar3 = piVar3 + 7;
      do {
        if (bVar4) {
LAB_000210b4:
          bVar4 = true;
          if (!bVar1) goto LAB_000210e0;
LAB_000210bc:
          if (bVar4) break;
LAB_000210f8:
          bVar1 = true;
        }
        else {
          if ((*piVar3 == 1) && (iVar2 = FUN_00021afc(), iVar2 == 0)) {
            piVar7 = (int *)(*(ulong *)(piVar3 + 6) & 0xffffffff);
            param_1[6] = (int *)(*(ulong *)(piVar3 + 6) >> 0x20);
            param_1[5] = piVar7;
            param_1[7] = (int *)0x0;
            if ((piVar3[8] == 0) && (piVar3[9] != 0)) {
              param_1[7] = (int *)((long)piVar6 - (long)piVar7);
            }
            goto LAB_000210b4;
          }
          bVar4 = false;
          if (bVar1) goto LAB_000210bc;
LAB_000210e0:
          if (*piVar3 == 0xd) {
            *(int *)(param_1 + 8) = piVar3[4];
            if (!bVar4) goto LAB_000210f8;
            break;
          }
          bVar1 = false;
        }
        piVar3 = (int *)((long)piVar3 + (ulong)(uint)piVar3[1]);
        iVar5 = iVar5 + -1;
      } while (iVar5 != 0);
    }
  }
  else if ((*piVar3 == -0x1120531) && (iVar5 = piVar3[4], iVar5 != 0)) {
    bVar1 = false;
    bVar4 = false;
    piVar6 = param_1[4];
    piVar3 = piVar3 + 8;
    do {
      if (bVar4) {
LAB_00021178:
        bVar4 = true;
        if (!bVar1) goto LAB_000211a4;
LAB_00021180:
        if (bVar4) break;
LAB_000211bc:
        bVar1 = true;
      }
      else {
        if ((*piVar3 == 0x19) && (iVar2 = FUN_00021afc(), iVar2 == 0)) {
          piVar7 = *(int **)(piVar3 + 6);
          param_1[6] = *(int **)(piVar3 + 8);
          param_1[5] = piVar7;
          param_1[7] = (int *)0x0;
          if ((*(long *)(piVar3 + 10) == 0) && (*(long *)(piVar3 + 0xc) != 0)) {
            param_1[7] = (int *)((long)piVar6 - (long)piVar7);
          }
          goto LAB_00021178;
        }
        bVar4 = false;
        if (bVar1) goto LAB_00021180;
LAB_000211a4:
        if (*piVar3 == 0xd) {
          *(int *)(param_1 + 8) = piVar3[4];
          if (!bVar4) goto LAB_000211bc;
          break;
        }
        bVar1 = false;
      }
      piVar3 = (int *)((long)piVar3 + (ulong)(uint)piVar3[1]);
      iVar5 = iVar5 + -1;
    } while (iVar5 != 0);
  }
  FUN_00021a08(param_1,unaff_x30);
  return;
}



void FUN_00021258(void **param_1)

{
  void *pvVar1;
  
  pvVar1 = *param_1;
  if (pvVar1 != (void *)0x0) {
    param_1[1] = pvVar1;
    operator_delete(pvVar1);
  }
  FUN_00021ac0(param_1);
  return;
}



void FUN_00021284(long param_1)

{
  std::__1::basic_string<>::~basic_string((basic_string<> *)(param_1 + 0x48));
  FUN_00021258(param_1);
  return;
}



void FUN_000212ac(void)

{
  long lVar1;
  long *plVar2;
  bool bVar3;
  int iVar4;
  ulong uVar5;
  long extraout_x8;
  long *plVar6;
  long extraout_x8_00;
  long lVar7;
  long extraout_x9;
  long *plVar8;
  long extraout_x9_00;
  long lVar9;
  long *plVar10;
  long lVar11;
  long *unaff_x19;
  long *unaff_x20;
  long *plVar12;
  long *plVar13;
  undefined8 unaff_x30;
  
  FUN_00021b58();
LAB_000212d8:
  plVar10 = unaff_x20 + -1;
  plVar12 = unaff_x19;
LAB_000212e4:
  unaff_x19 = plVar12;
  lVar7 = (long)unaff_x20 - (long)unaff_x19;
  uVar5 = lVar7 >> 3;
  bVar3 = 4 < uVar5;
  switch(uVar5) {
  case 0:
  case 1:
    goto switchD_00021524_caseD_0;
  case 2:
    FUN_000219e0(*plVar10);
    if (!bVar3) {
      *unaff_x19 = extraout_x8_00;
      *plVar10 = extraout_x9_00;
    }
    goto switchD_00021524_caseD_0;
  case 3:
    FUN_00021a08(unaff_x19,unaff_x19 + 1,plVar10,unaff_x30);
    FUN_00021644();
    return;
  case 4:
    FUN_00021a08(unaff_x19,unaff_x19 + 1,unaff_x19 + 2,plVar10,unaff_x30);
    FUN_000216e4();
    return;
  case 5:
    FUN_00021a08(unaff_x19,unaff_x19 + 1,unaff_x19 + 2,unaff_x19 + 3,plVar10,unaff_x30);
    FUN_00021760();
    return;
  }
  if (lVar7 < 0x38) {
    FUN_00021a38();
    if (unaff_x19 + 3 == unaff_x20) goto switchD_00021524_caseD_0;
    lVar7 = 0;
    plVar12 = unaff_x19 + 3;
    goto LAB_00021558;
  }
  plVar12 = unaff_x19 + (long)uVar5 / 2;
  if (lVar7 < 0x1f39) {
    iVar4 = FUN_00021644(unaff_x19,plVar12,plVar10);
  }
  else {
    iVar4 = FUN_00021760(unaff_x19,unaff_x19 + (long)uVar5 / 4,plVar12,plVar12 + (long)uVar5 / 4,
                         plVar10);
  }
  lVar7 = *unaff_x19;
  uVar5 = *(ulong *)(lVar7 + 0x20);
  plVar6 = plVar10;
  plVar8 = unaff_x20 + -2;
  if (*(ulong *)(*plVar12 + 0x20) <= uVar5) {
    do {
      plVar6 = plVar8;
      if (unaff_x19 == plVar6) {
        plVar6 = unaff_x19 + 1;
        if (uVar5 < *(ulong *)(*plVar10 + 0x20)) goto LAB_000214a4;
        if (plVar6 == plVar10) goto switchD_00021524_caseD_0;
        plVar6 = unaff_x19 + 2;
        goto LAB_0002147c;
      }
      plVar8 = plVar6 + -1;
    } while (*(ulong *)(*plVar12 + 0x20) <= *(ulong *)(*plVar6 + 0x20));
    *unaff_x19 = *plVar6;
    *plVar6 = lVar7;
    iVar4 = iVar4 + 1;
  }
  plVar8 = unaff_x19 + 1;
  plVar2 = plVar12;
  plVar13 = plVar8;
  if (plVar8 < plVar6) {
    while( true ) {
      plVar12 = plVar2;
      plVar8 = plVar13 + -1;
      do {
        plVar13 = plVar8;
        plVar8 = plVar13 + 1;
        lVar7 = *plVar8;
      } while (*(ulong *)(lVar7 + 0x20) < *(ulong *)(*plVar12 + 0x20));
      plVar13 = plVar13 + 2;
      do {
        plVar6 = plVar6 + -1;
      } while (*(ulong *)(*plVar12 + 0x20) <= *(ulong *)(*plVar6 + 0x20));
      if (plVar6 < plVar8) break;
      *plVar8 = *plVar6;
      *plVar6 = lVar7;
      iVar4 = iVar4 + 1;
      plVar2 = plVar6;
      if (plVar12 != plVar8) {
        plVar2 = plVar12;
      }
    }
  }
  bVar3 = plVar12 <= plVar8;
  if ((plVar8 != plVar12) && (iVar4 = FUN_000219e0(*plVar12), !bVar3)) {
    *plVar8 = extraout_x8;
    *plVar12 = extraout_x9;
    iVar4 = iVar4 + 1;
  }
  if (iVar4 == 0) {
    uVar5 = FUN_00021810(unaff_x19,plVar8);
    iVar4 = FUN_00021810(plVar8 + 1,unaff_x20);
    if (iVar4 != 0) goto LAB_00021504;
    plVar12 = plVar8 + 1;
    if ((uVar5 & 1) != 0) goto LAB_000212e4;
  }
  if ((long)unaff_x20 - (long)plVar8 <= (long)plVar8 - (long)unaff_x19) {
    FUN_000212ac(plVar8 + 1,unaff_x20);
    unaff_x20 = plVar8;
    goto LAB_000212d8;
  }
  FUN_000212ac(unaff_x19,plVar8);
  plVar12 = plVar8 + 1;
  goto LAB_000212e4;
LAB_0002147c:
  lVar7 = plVar6[-1];
  if (uVar5 < *(ulong *)(lVar7 + 0x20)) goto LAB_0002149c;
  plVar6 = plVar6 + 1;
  if (unaff_x20 == plVar6) goto switchD_00021524_caseD_0;
  goto LAB_0002147c;
LAB_0002149c:
  plVar6[-1] = *plVar10;
  *plVar10 = lVar7;
LAB_000214a4:
  plVar8 = plVar10;
  if (plVar6 == plVar10) goto switchD_00021524_caseD_0;
  while( true ) {
    do {
      plVar12 = plVar6;
      plVar6 = plVar12 + 1;
      lVar7 = *plVar12;
    } while (*(ulong *)(lVar7 + 0x20) <= *(ulong *)(*unaff_x19 + 0x20));
    do {
      plVar8 = plVar8 + -1;
    } while (*(ulong *)(*unaff_x19 + 0x20) < *(ulong *)(*plVar8 + 0x20));
    if (plVar8 <= plVar12) break;
    *plVar12 = *plVar8;
    *plVar8 = lVar7;
  }
  goto LAB_000212e4;
LAB_00021504:
  unaff_x20 = plVar8;
  if ((uVar5 & 1) != 0) goto switchD_00021524_caseD_0;
  goto LAB_000212d8;
LAB_00021558:
  do {
    plVar6 = plVar12;
    lVar9 = *plVar6;
    uVar5 = *(ulong *)(lVar9 + 0x20);
    lVar1 = lVar7;
    if (uVar5 < *(ulong *)(*plVar10 + 0x20)) {
      do {
        lVar11 = lVar1;
        *(undefined8 *)((long)unaff_x19 + lVar11 + 0x18) =
             *(undefined8 *)((long)unaff_x19 + lVar11 + 0x10);
        plVar10 = unaff_x19;
        if (lVar11 == -0x10) goto LAB_000215b0;
        lVar1 = lVar11 + -8;
      } while (uVar5 < *(ulong *)(*(long *)((long)unaff_x19 + lVar11 + 8) + 0x20));
      plVar10 = (long *)((long)unaff_x19 + lVar11 + 0x10);
LAB_000215b0:
      *plVar10 = lVar9;
    }
    lVar7 = lVar7 + 8;
    plVar12 = plVar6 + 1;
    plVar10 = plVar6;
  } while (plVar6 + 1 != unaff_x20);
switchD_00021524_caseD_0:
  FUN_00021a08(unaff_x30);
  return;
}



undefined8 FUN_00021644(long *param_1,long *param_2,long *param_3)

{
  bool bVar1;
  long lVar2;
  undefined8 extraout_x8;
  long lVar3;
  undefined8 extraout_x9;
  ulong uVar4;
  long lVar5;
  ulong uVar6;
  undefined auVar7 [16];
  
  lVar3 = *param_2;
  lVar2 = *param_1;
  uVar6 = *(ulong *)(lVar3 + 0x20);
  uVar4 = *(ulong *)(lVar2 + 0x20);
  lVar5 = *param_3;
  if (uVar6 < uVar4) {
    if (*(ulong *)(lVar5 + 0x20) < uVar6) {
      *param_1 = lVar5;
      *param_3 = lVar2;
    }
    else {
      *param_1 = lVar3;
      *param_2 = lVar2;
      if (*(ulong *)(*param_3 + 0x20) < uVar4) {
        *param_2 = *param_3;
        *param_3 = lVar2;
        return 2;
      }
    }
  }
  else {
    bVar1 = uVar6 <= *(ulong *)(lVar5 + 0x20);
    if (bVar1) {
      return 0;
    }
    *param_2 = lVar5;
    *param_3 = lVar3;
    auVar7 = FUN_000219e0(*param_2);
    if (!bVar1) {
      *auVar7._0_8_ = extraout_x8;
      *auVar7._8_8_ = extraout_x9;
      return 2;
    }
  }
  return 1;
}



void FUN_000216e4(void)

{
  undefined in_CY;
  int iVar1;
  ulong uVar2;
  undefined8 extraout_x8;
  undefined8 extraout_x8_00;
  undefined8 extraout_x8_01;
  undefined8 extraout_x9;
  undefined8 extraout_x9_00;
  undefined8 extraout_x9_01;
  undefined8 *unaff_x19;
  undefined8 *unaff_x20;
  undefined8 *unaff_x21;
  undefined8 *unaff_x22;
  
  FUN_00021b20();
  FUN_00021644();
  uVar2 = FUN_000219e0(*unaff_x22);
  if (!(bool)in_CY) {
    *unaff_x21 = extraout_x8;
    *unaff_x22 = extraout_x9;
    iVar1 = FUN_000219e0(*unaff_x21);
    if ((bool)in_CY) {
      uVar2 = (ulong)(iVar1 + 1);
    }
    else {
      *unaff_x19 = extraout_x8_00;
      *unaff_x21 = extraout_x9_00;
      iVar1 = FUN_000219e0(*unaff_x19);
      if ((bool)in_CY) {
        uVar2 = (ulong)(iVar1 + 2);
      }
      else {
        *unaff_x20 = extraout_x8_01;
        *unaff_x19 = extraout_x9_01;
        uVar2 = (ulong)(iVar1 + 3);
      }
    }
  }
  FUN_00021b4c(uVar2);
  return;
}



ulong FUN_00021760(void)

{
  undefined in_CY;
  int iVar1;
  ulong uVar2;
  undefined8 *in_x4;
  undefined8 extraout_x8;
  undefined8 extraout_x8_00;
  undefined8 extraout_x8_01;
  undefined8 extraout_x8_02;
  undefined8 extraout_x9;
  undefined8 extraout_x9_00;
  undefined8 extraout_x9_01;
  undefined8 extraout_x9_02;
  undefined8 *unaff_x19;
  undefined8 *unaff_x20;
  undefined8 *unaff_x21;
  undefined8 *unaff_x22;
  
  FUN_00021b20();
  FUN_000216e4();
  uVar2 = FUN_000219e0(*in_x4);
  if (!(bool)in_CY) {
    *unaff_x22 = extraout_x8;
    *in_x4 = extraout_x9;
    iVar1 = FUN_000219e0(*unaff_x22);
    if ((bool)in_CY) {
      uVar2 = (ulong)(iVar1 + 1);
    }
    else {
      *unaff_x21 = extraout_x8_00;
      *unaff_x22 = extraout_x9_00;
      iVar1 = FUN_000219e0(*unaff_x21);
      if ((bool)in_CY) {
        uVar2 = (ulong)(iVar1 + 2);
      }
      else {
        *unaff_x19 = extraout_x8_01;
        *unaff_x21 = extraout_x9_01;
        iVar1 = FUN_000219e0(*unaff_x19);
        if ((bool)in_CY) {
          uVar2 = (ulong)(iVar1 + 3);
        }
        else {
          *unaff_x20 = extraout_x8_02;
          *unaff_x19 = extraout_x9_02;
          uVar2 = (ulong)(iVar1 + 4);
        }
      }
    }
  }
  return uVar2;
}



void FUN_00021810(void)

{
  long lVar1;
  bool bVar2;
  bool bVar3;
  ulong uVar4;
  long extraout_x8;
  long lVar5;
  int iVar6;
  long extraout_x9;
  long *plVar7;
  long lVar8;
  long *plVar9;
  long lVar10;
  long *unaff_x19;
  long *unaff_x20;
  long *unaff_x21;
  undefined auVar11 [16];
  
  auVar11 = FUN_00021b58();
  uVar4 = auVar11._8_8_ - auVar11._0_8_ >> 3;
  bVar2 = 4 < uVar4;
  if (uVar4 < 6) {
    bVar3 = true;
    switch(uVar4) {
    default:
      goto switchD_0002184c_caseD_0;
    case 2:
      FUN_000219e0(unaff_x20[-1],1);
      if (!bVar2) {
        *unaff_x19 = extraout_x8;
        unaff_x20[-1] = extraout_x9;
      }
      break;
    case 3:
      FUN_00021644();
      break;
    case 4:
      FUN_000216e4();
      break;
    case 5:
      FUN_00021760();
    }
  }
  else {
    FUN_00021a38();
    if (unaff_x19 + 3 != unaff_x20) {
      lVar5 = 0;
      iVar6 = 0;
      plVar9 = unaff_x19 + 3;
      do {
        plVar7 = plVar9;
        lVar8 = *plVar7;
        uVar4 = *(ulong *)(lVar8 + 0x20);
        lVar1 = lVar5;
        if (uVar4 < *(ulong *)(*unaff_x21 + 0x20)) {
          do {
            lVar10 = lVar1;
            *(undefined8 *)((long)unaff_x19 + lVar10 + 0x18) =
                 *(undefined8 *)((long)unaff_x19 + lVar10 + 0x10);
            plVar9 = unaff_x19;
            if (lVar10 == -0x10) goto LAB_000218dc;
            lVar1 = lVar10 + -8;
          } while (uVar4 < *(ulong *)(*(long *)((long)unaff_x19 + lVar10 + 8) + 0x20));
          plVar9 = (long *)((long)unaff_x19 + lVar10 + 0x10);
LAB_000218dc:
          *plVar9 = lVar8;
          iVar6 = iVar6 + 1;
          if (iVar6 == 8) {
            bVar3 = plVar7 + 1 == unaff_x20;
            goto switchD_0002184c_caseD_0;
          }
        }
        lVar5 = lVar5 + 8;
        plVar9 = plVar7 + 1;
        unaff_x21 = plVar7;
      } while (plVar7 + 1 != unaff_x20);
    }
  }
  bVar3 = true;
switchD_0002184c_caseD_0:
  FUN_00021b4c(bVar3);
  return;
}



long * FUN_00021960(long *param_1,long *param_2)

{
  long *plVar1;
  
  plVar1 = param_1;
  if (param_1 != param_2) {
    do {
      param_1 = plVar1;
      if (param_1 + 1 == param_2) {
        return param_2;
      }
      plVar1 = param_1 + 1;
    } while (*(long *)(*param_1 + 0x20) != *(long *)(param_1[1] + 0x20));
  }
  if (param_1 != param_2) {
    for (plVar1 = param_1 + 2; plVar1 != param_2; plVar1 = plVar1 + 1) {
      if (*(long *)(*param_1 + 0x20) != *(long *)(*plVar1 + 0x20)) {
        param_1 = param_1 + 1;
        *param_1 = *plVar1;
      }
    }
    param_1 = param_1 + 1;
  }
  return param_1;
}



void FUN_000219e0(void)

{
  return;
}



void FUN_000219f0(void)

{
  return;
}



void FUN_00021a08(void)

{
  return;
}



void FUN_00021a20(void)

{
  FUN_00020fd0();
  return;
}



void FUN_00021a38(void)

{
  FUN_00021644();
  return;
}



kern_return_t FUN_00021a4c(undefined8 param_1,vm_address_t *param_2,vm_size_t *param_3)

{
  kern_return_t kVar1;
  vm_map_t unaff_w21;
  long unaff_x29;
  
  kVar1 = _vm_region_recurse_64
                    (unaff_w21,param_2,param_3,(natural_t *)(unaff_x29 + -0x34),
                     (vm_region_recurse_info_t)&stack0x00000020,
                     (mach_msg_type_number_t *)&stack0x0000001c);
  return kVar1;
}



void FUN_00021a60(void)

{
  std::__1::basic_string<>::~basic_string((basic_string<> *)&stack0x00000000);
  return;
}



void FUN_00021a68(void)

{
  FUN_00020e68();
  return;
}



void FUN_00021a78(void)

{
  std::__1::basic_string<>::~basic_string((basic_string<> *)&stack0x00000030);
  return;
}



void FUN_00021a80(void)

{
  std::__1::basic_string<>::~basic_string((basic_string<> *)&stack0x00000018);
  return;
}



void FUN_00021a88(void)

{
  long unaff_x29;
  
  FUN_00021258(unaff_x29 + -0x58);
  return;
}



void FUN_00021a90(void)

{
  FUN_00021258(&stack0x00000060);
  return;
}



undefined4 FUN_00021a98(void)

{
  undefined4 *unaff_x19;
  
  return *unaff_x19;
}



void FUN_00021ab0(void)

{
  FUN_00021258(&stack0x00000048);
  return;
}



void FUN_00021ab8(void)

{
  void *unaff_x23;
  
  operator_delete(unaff_x23);
  return;
}



void FUN_00021ac0(void)

{
  return;
}



void FUN_00021ac8(void)

{
  _Unwind_Exception *unaff_x19;
  
  __Unwind_Resume(unaff_x19);
  return;
}



void FUN_00021ad0(void)

{
  std::__1::basic_string<>::basic_string((basic_string *)&stack0x00000000);
  return;
}



undefined4 FUN_00021adc(undefined4 *param_1)

{
  long unaff_x29;
  
  *(undefined8 *)(unaff_x29 + -0x58) = 0;
  *(undefined8 *)(unaff_x29 + -0x50) = 0;
  *(undefined8 *)(unaff_x29 + -0x48) = 0;
  return *param_1;
}



void FUN_00021af0(void)

{
  std::__1::basic_string<>::operator=
            ((basic_string<> *)&stack0x00000030,(basic_string *)&stack0x00000018);
  return;
}



int FUN_00021afc(void)

{
  int iVar1;
  char *unaff_x20;
  long unaff_x23;
  
  iVar1 = _strcmp((char *)(unaff_x23 + 8),unaff_x20);
  return iVar1;
}



void FUN_00021b08(void)

{
  FUN_00020430();
  return;
}



void FUN_00021b14(void)

{
  return;
}



void FUN_00021b20(void)

{
  return;
}



void FUN_00021b34(void)

{
  FUN_00020c30();
  return;
}



void FUN_00021b40(void)

{
  FUN_00020dc4();
  return;
}



void FUN_00021b4c(void)

{
  return;
}



void FUN_00021b58(void)

{
  return;
}



void FUN_00021b64(void)

{
                    // WARNING: Subroutine does not return
  std::__1::__vector_base_common<true>::__throw_length_error();
}



undefined8 * FUN_00021b6c(undefined8 *param_1,int param_2,undefined4 param_3)

{
  int iVar1;
  void *pvVar2;
  undefined8 uVar3;
  long lVar4;
  long lVar5;
  undefined8 uVar6;
  long extraout_x8;
  undefined4 uVar7;
  long lVar8;
  undefined auStack_480 [24];
  undefined8 ***local_468;
  long local_460;
  long local_458;
  long local_68;
  
  local_68 = *(long *)PTR____stack_chk_guard_00028030;
  *param_1 = &DAT_000289c0;
  *(undefined4 *)(param_1 + 1) = 0xffffffff;
  *(undefined *)((long)param_1 + 0xc) = 1;
  *(undefined4 *)(param_1 + 2) = 0;
  uVar7 = 0x100000c;
  param_1[4] = 0;
  param_1[5] = 0;
  param_1[3] = 0;
  *(int *)(param_1 + 6) = param_2;
  *(undefined4 *)((long)param_1 + 0x34) = param_3;
  *(undefined4 *)(param_1 + 7) = 0x100000c;
  param_1[8] = 0;
  param_1[9] = 0;
  iVar1 = _getpagesize();
  param_1[10] = (long)iVar1;
  param_1[0x10] = 0;
  param_1[0xf] = 0;
  param_1[0xc] = 0;
  param_1[0xb] = 0;
  param_1[0xe] = 0;
  param_1[0xd] = 0;
  param_1[0x11] = 0;
  param_1[0x12] = param_1 + 10;
  param_1[0x13] = 0;
  param_1[0x14] = 0;
  FUN_000238c4(&local_468,0x10,0,param_1 + 0x12);
  FUN_00023850(param_1 + 0xf,&local_468);
  if (local_458 != local_460) {
    FUN_00023cdc();
    local_458 = extraout_x8;
  }
  if (*(int *)PTR__mach_task_self__00028040 == param_2) {
    param_1[9] = 0;
  }
  else {
    pvVar2 = operator_new(0x20);
    FUN_00020518(pvVar2,*(undefined4 *)(param_1 + 6));
    param_1[9] = pvVar2;
    uVar7 = *(undefined4 *)((long)pvVar2 + 4);
  }
  *(undefined4 *)(param_1 + 7) = uVar7;
  if ((int)DAT_0002ec40 != 0) goto LAB_00021c8c;
  uVar3 = _CFURLCreateWithFileSystemPath(0,&cf__System_Library_CoreServices_SystemVersion_plist,0,0)
  ;
  lVar4 = _CFReadStreamCreateWithFile(0,uVar3);
  FUN_00023d04();
  if (lVar4 == 0) goto LAB_00021c8c;
  iVar1 = _CFReadStreamOpen(lVar4);
  if (iVar1 == 0) {
    FUN_00023cc4();
    goto LAB_00021c8c;
  }
  lVar5 = FUN_00023cb4();
  if (lVar5 < 0) {
LAB_00021d54:
    lVar8 = 0;
  }
  else {
    lVar8 = 0;
    do {
      if (lVar5 == 0) goto LAB_00021d58;
      if (lVar8 == 0) {
        lVar8 = _CFDataCreateMutable(0,0);
      }
      _CFDataAppendBytes(lVar8,&local_468,lVar5);
      lVar5 = FUN_00023cb4();
    } while (-1 < lVar5);
    if (lVar8 != 0) {
      FUN_00023d04();
      goto LAB_00021d54;
    }
  }
LAB_00021d58:
  _CFReadStreamClose(lVar4);
  FUN_00023cc4();
  if (lVar8 != 0) {
    lVar4 = _CFPropertyListCreateWithData(0,lVar8,0,0,0);
    FUN_00023d04();
    if (lVar4 != 0) {
      uVar3 = _CFDictionaryGetValue(lVar4,&cf_ProductBuildVersion);
      uVar6 = _CFDictionaryGetValue(lVar4,&cf_ProductVersion);
      FUN_0001fd3c(&local_468,uVar3);
      FUN_0001fd3c(auStack_480,uVar6);
      FUN_00023cc4();
      if (-1 < local_458) {
        local_468 = &local_468;
      }
      _strlcpy(&DAT_0002ec4c,(char *)local_468,0x10);
      DAT_0002ec40._0_4_ = FUN_0001fe24(auStack_480,0);
      DAT_0002ec40._4_4_ = FUN_0001fe24(auStack_480,1);
      DAT_0002ec48 = FUN_0001fe24(auStack_480,2);
      FUN_00023c68();
      std::__1::basic_string<>::~basic_string((basic_string<> *)&local_468);
    }
  }
LAB_00021c8c:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_68) {
    return param_1;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00021eac(undefined8 *param_1)

{
  void *pvVar1;
  
  *param_1 = &DAT_000289c0;
  pvVar1 = (void *)param_1[9];
  if (pvVar1 != (void *)0x0) {
    FUN_000237b0(pvVar1);
    operator_delete(pvVar1);
  }
  if (param_1[0xf] != 0) {
    param_1[0x10] = param_1[0xf];
  }
  FUN_00023774(param_1 + 10);
  FUN_00020058(param_1 + 1);
  FUN_00023c00(param_1);
  return;
}



void thunk_FUN_00021eac(void)

{
  FUN_00021eac();
  return;
}



void FUN_00021f4c(void *param_1)

{
  FUN_00021eac();
  operator_delete(param_1);
  return;
}



void FUN_00021f84(basic_string *param_1,ulong param_2,basic_string<> *param_3)

{
  ulong uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  char *pcVar4;
  undefined8 ***local_58 [2];
  char local_41;
  
  uVar2 = _CFUUIDCreate(0);
  uVar3 = _CFUUIDCreateString(0,uVar2);
  _CFRelease(uVar2);
  FUN_0001fd3c(local_58,uVar3);
  FUN_00023cc4();
  std::__1::basic_string<>::basic_string(param_1);
  uVar1 = *(ulong *)(param_2 + 8);
  if (-1 < (char)*(byte *)(param_2 + 0x17)) {
    uVar1 = (ulong)*(byte *)(param_2 + 0x17);
  }
  if ((uVar1 != 0) && (pcVar4 = (char *)std::__1::basic_string<>::at(param_2), *pcVar4 != '/')) {
    std::__1::basic_string<>::append((ulong)param_1,'\x01');
  }
  if (-1 < local_41) {
    local_58[0] = local_58;
  }
  std::__1::basic_string<>::append((char *)param_1,(ulong)local_58[0]);
  std::__1::basic_string<>::append((char *)param_1);
  if (param_3 != (basic_string<> *)0x0) {
    std::__1::basic_string<>::operator=(param_3,(basic_string *)local_58);
  }
  std::__1::basic_string<>::~basic_string((basic_string<> *)local_58);
  return;
}



ulong FUN_000220b0(long param_1)

{
  long lVar1;
  long *plVar2;
  bool bVar3;
  uint uVar4;
  ulong uVar5;
  uint uVar6;
  code *pcVar7;
  int iVar8;
  long *plVar9;
  undefined auStack_b8 [16];
  long local_a8;
  int local_a0;
  undefined8 local_98;
  undefined8 uStack_90;
  undefined8 local_88;
  long lStack_80;
  int local_78;
  undefined8 local_70;
  undefined8 uStack_68;
  undefined8 local_60;
  undefined auStack_58 [8];
  undefined8 local_50;
  undefined4 local_48;
  
  lVar1 = param_1 + 8;
  uVar5 = FUN_000200e4(lVar1);
  if ((int)uVar5 == 0) {
    return uVar5;
  }
  local_88 = 0;
  local_a0 = *(int *)(param_1 + 0x10);
  uStack_68 = 0;
  local_70 = 0;
  auStack_58 = (undefined  [8])0x0;
  local_60 = 0;
  local_50 = 0;
  local_98 = 0;
  uStack_90 = 0;
  local_48 = 1;
  local_a8 = lVar1;
  lStack_80 = lVar1;
  local_78 = local_a0;
  uVar5 = FUN_000202b0(&lStack_80,0x20);
  if ((uVar5 & 1) != 0) {
    if (*(int *)(param_1 + 0x2c) == 0) {
      uVar6 = 6;
      if (*(int *)(param_1 + 0x20) != 0) {
        uVar6 = 7;
      }
    }
    else {
      uVar6 = 7;
    }
    local_88 = CONCAT44(2,(undefined4)local_88);
    uVar5 = FUN_000202b0(&local_a8,((ulong)uVar6 * 2 + (ulong)uVar6) * 4);
    if ((uVar5 & 1) != 0) {
      uStack_68 = 0xa794504d444d;
      _time((time_t *)(auStack_58 + 4));
      iVar8 = 0;
      local_60 = CONCAT44(local_a0,uVar6);
      plVar9 = &DAT_000289e8;
      uVar5 = 1;
      do {
        pcVar7 = (code *)plVar9[-1];
        plVar2 = (long *)(param_1 + (*plVar9 >> 1));
        if (uVar5 == 7) {
          pcVar7 = *(code **)(*plVar2 + ((ulong)pcVar7 & 0xffffffff));
        }
        uVar4 = (*pcVar7)(plVar2,auStack_b8);
        if (uVar4 == 0) break;
        FUN_00020368(local_a8,iVar8 + local_a0,auStack_b8,0xc);
        bVar3 = uVar5 < uVar6;
        uVar5 = uVar5 + 1;
        iVar8 = iVar8 + 0xc;
        plVar9 = plVar9 + 2;
      } while ((bVar3 & uVar4) != 0);
      bVar3 = false;
      goto LAB_000221f8;
    }
  }
  uVar4 = 0;
  bVar3 = true;
LAB_000221f8:
  FUN_00023a20(&local_a8);
  FUN_000239ec(&lStack_80);
  uVar5 = (ulong)(uVar4 != 0);
  if (bVar3) {
    uVar5 = 0;
  }
  return uVar5;
}



undefined8 FUN_00022264(void)

{
  kern_return_t kVar1;
  int iVar2;
  long lVar3;
  ulong uVar4;
  uint uVar5;
  long *unaff_x19;
  undefined8 uVar6;
  int iVar7;
  undefined4 *unaff_x20;
  ulong uVar8;
  uint local_124;
  thread_act_array_t local_120;
  long local_118;
  int local_110;
  undefined8 local_108;
  undefined8 uStack_100;
  undefined8 local_f8;
  undefined8 uStack_f0;
  undefined8 local_e8;
  undefined8 uStack_e0;
  undefined8 local_d8;
  undefined8 uStack_d0;
  undefined8 local_c8;
  undefined8 uStack_c0;
  undefined8 local_b8;
  undefined8 uStack_b0;
  undefined4 local_a8;
  undefined8 local_a0;
  undefined8 uStack_98;
  undefined8 local_90;
  undefined8 uStack_88;
  undefined8 uStack_80;
  undefined8 uStack_78;
  undefined8 local_70;
  undefined8 uStack_68;
  undefined8 uStack_60;
  undefined8 uStack_58;
  long local_48;
  
  lVar3 = FUN_00023c70();
  local_48 = *(long *)PTR____stack_chk_guard_00028030;
  local_118 = lVar3 + 8;
  local_110 = *(int *)(lVar3 + 0x10);
  uStack_100 = 0;
  local_108 = 0;
  uStack_f0 = 0;
  local_f8 = 0;
  uStack_e0 = 0;
  local_e8 = 0;
  uStack_d0 = 0;
  local_d8 = 0;
  uStack_c0 = 0;
  local_c8 = 0;
  uStack_b0 = 0;
  local_b8 = 0;
  local_a8 = 0;
  kVar1 = _task_threads(*(task_t *)(lVar3 + 0x30),&local_120,&local_124);
  if (kVar1 == 0) {
    iVar7 = local_124 - (*(int *)((long)unaff_x19 + 0x34) != 0);
    local_a8 = 3;
    iVar2 = FUN_000202b0(&local_118,(long)iVar7 * 0x50 | 8);
    if (iVar2 != 0) {
      *unaff_x20 = 3;
      *(ulong *)(unaff_x20 + 1) = CONCAT44(local_110,(undefined4)local_108);
      uStack_100 = CONCAT44(uStack_100._4_4_,iVar7);
      if (local_124 != 0) {
        iVar7 = 0;
        uVar8 = 0;
        uVar5 = local_124;
        do {
          uStack_68 = 0;
          local_70 = 0;
          uStack_58 = 0;
          uStack_60 = 0;
          uStack_88 = 0;
          local_90 = 0;
          uStack_78 = 0;
          uStack_80 = 0;
          uStack_98 = 0;
          local_a0 = 0;
          if (local_120[uVar8] != *(thread_act_t *)((long)unaff_x19 + 0x34)) {
            uVar4 = (**(code **)(*unaff_x19 + 0x18))();
            if ((uVar4 & 1) == 0) goto LAB_000223b8;
            FUN_00020368(local_118,local_110 + (iVar7 * 0x50 | 8U),&local_a0,0x50);
            iVar7 = iVar7 + 1;
            uVar5 = local_124;
          }
          uVar8 = uVar8 + 1;
        } while (uVar8 < uVar5);
      }
      uVar6 = 1;
      goto LAB_000223bc;
    }
  }
LAB_000223b8:
  uVar6 = 0;
LAB_000223bc:
  FUN_00023a80(&local_118);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_48) {
    return uVar6;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_00022418(void)

{
  long lVar1;
  bool bVar2;
  undefined in_ZR;
  int iVar3;
  kern_return_t kVar4;
  long lVar5;
  ulong uVar6;
  ulong uVar7;
  long unaff_x19;
  undefined8 uVar8;
  undefined4 *unaff_x20;
  ulong uVar9;
  mach_msg_type_number_t local_154c;
  undefined8 local_1548;
  undefined8 uStack_1540;
  undefined8 local_1538;
  natural_t local_14fc;
  vm_size_t local_14f8;
  ulong local_14f0;
  undefined4 local_14e4;
  ulong local_14e0;
  undefined8 local_14d8;
  long local_14d0;
  undefined4 local_14c8;
  undefined8 local_14c0;
  undefined8 uStack_14b8;
  undefined8 uStack_14b0;
  undefined8 uStack_14a8;
  undefined4 local_14a0;
  long local_1498;
  undefined4 local_1490;
  undefined8 local_1488;
  ulong local_1398;
  long local_58;
  
  lVar5 = FUN_00023c70();
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  lVar1 = lVar5 + 8;
  local_14c8 = *(undefined4 *)(lVar5 + 0x10);
  local_14a0 = 0;
  uStack_14b8 = 0;
  local_14c0 = 0;
  uStack_14a8 = 0;
  uStack_14b0 = 0;
  local_14d0 = lVar1;
  if ((*(int *)(lVar5 + 0x2c) == 0) || (*(int *)(unaff_x19 + 0x20) == 0)) {
LAB_00022534:
    bVar2 = false;
  }
  else {
    local_14e4 = 0x1440;
    iVar3 = FUN_00022d68();
    if (iVar3 == 0) goto LAB_00022534;
    FUN_00023c34(*(undefined4 *)(unaff_x19 + 0x38));
    if (!(bool)in_ZR) {
      local_1398 = 0;
    }
    local_14fc = 0;
    local_154c = 0x13;
    local_14f0 = local_1398;
    kVar4 = _vm_region_recurse_64
                      (*(vm_map_t *)(unaff_x19 + 0x30),&local_14f0,&local_14f8,&local_14fc,
                       (vm_region_recurse_info_t)&local_1548,&local_154c);
    if (((kVar4 != 0) || (local_1398 < local_14f0)) ||
       (uVar6 = local_14f8 + local_14f0, uVar6 <= local_1398)) goto LAB_00022534;
    local_14e0 = local_1398 - 0x80;
    if (local_1398 - 0x80 <= local_14f0) {
      local_14e0 = local_14f0;
    }
    iVar3 = (int)uVar6;
    if (local_1398 + 0x80 <= uVar6) {
      iVar3 = (int)(local_1398 + 0x80);
    }
    local_14d8 = CONCAT44(local_14d8._4_4_,iVar3 - (int)local_14e0);
    FUN_000230c0(unaff_x19 + 0x78,&local_14e0);
    bVar2 = true;
  }
  uVar9 = *(long *)(unaff_x19 + 0x80) - *(long *)(unaff_x19 + 0x78);
  local_14a0 = 3;
  uVar6 = FUN_000202b0(&local_14d0,uVar9 | 8);
  if ((uVar6 & 1) == 0) {
LAB_00022640:
    uVar8 = 0;
  }
  else {
    *unaff_x20 = 5;
    *(ulong *)(unaff_x20 + 1) = CONCAT44(local_14c8,(undefined4)local_14c0);
    uStack_14b8 = CONCAT44(uStack_14b8._4_4_,(int)(uVar9 >> 4));
    if (uVar9 == 0) {
      uVar6 = 0xffffffff;
    }
    else {
      uVar7 = 0;
      do {
        uVar6 = uVar7;
        FUN_00023188(local_14d0,local_14c8,uVar6,*(long *)(unaff_x19 + 0x78) + uVar6 * 0x10);
        uVar7 = (ulong)((int)uVar6 + 1);
      } while (uVar7 < (ulong)((long)uVar9 >> 4));
    }
    if (bVar2) {
      local_1490 = *(undefined4 *)(unaff_x19 + 0x10);
      local_1488 = 0;
      uVar7 = local_14d8 & 0xffffffff;
      local_1498 = lVar1;
      uVar9 = FUN_000202b0(&local_1498,uVar7);
      if ((uVar9 & 1) == 0) goto LAB_00022640;
      if (*(long *)(unaff_x19 + 0x48) == 0) {
        FUN_000202e4(&local_1498,local_14e0,uVar7);
      }
      else {
        local_1548 = 0;
        uStack_1540 = 0;
        local_1538 = 0;
        iVar3 = FUN_00020430(*(undefined4 *)(unaff_x19 + 0x30),local_14e0,uVar7,&local_1548);
        if (iVar3 == 0) {
          FUN_000202e4(&local_1498,local_1548,local_14d8 & 0xffffffff);
        }
        FUN_00021258(&local_1548);
        if (iVar3 != 0) goto LAB_00022640;
      }
      local_14d8 = CONCAT44(local_1490,(undefined4)local_1488);
      FUN_00023188(local_14d0,local_14c8,uVar6,&local_14e0);
    }
    uVar8 = 1;
  }
  FUN_00023aac(&local_14d0);
  if (*(long *)PTR____stack_chk_guard_00028030 != local_58) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  FUN_00023c7c(uVar8);
  return;
}



undefined8 FUN_000226e8(long param_1,undefined4 *param_2,undefined8 param_3)

{
  undefined8 uVar1;
  undefined in_ZR;
  ulong uVar2;
  undefined2 uVar3;
  undefined8 uVar4;
  undefined auStack_a8 [4];
  undefined4 local_a4;
  undefined8 local_a0;
  undefined local_94 [4];
  long local_90;
  undefined4 local_88;
  undefined8 local_80;
  undefined8 uStack_78;
  undefined8 local_70;
  undefined4 local_68;
  undefined4 local_64;
  undefined8 local_60;
  undefined8 uStack_58;
  undefined8 uStack_50;
  undefined8 uStack_48;
  undefined4 local_40;
  long local_38;
  
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  local_88 = *(undefined4 *)(param_1 + 0x10);
  uStack_78 = 0;
  local_80 = 0;
  local_68 = 0;
  local_64 = 0;
  local_70 = 0;
  uStack_58 = 0;
  local_60 = 0;
  uStack_48 = 0;
  uStack_50 = 0;
  local_40 = 1;
  local_90 = param_1 + 8;
  uVar2 = FUN_000202b0(&local_90,0x38);
  if ((uVar2 & 1) != 0) {
    *param_2 = 7;
    *(ulong *)(param_2 + 1) = CONCAT44(local_88,(undefined4)local_80);
    local_a0 = 4;
    FUN_00023c44("hw.ncpu",local_94);
    FUN_00023c34(*(undefined4 *)(param_1 + 0x38));
    uVar4 = uStack_78;
    uVar3 = 0x8003;
    if (!(bool)in_ZR) {
      uVar3 = 0xffff;
    }
    uStack_78 = CONCAT62(uStack_78._2_6_,uVar3);
    uVar1 = uStack_78;
    local_64 = 0x8102;
    uVar2 = FUN_00023cd4(param_1 + 8,&DAT_0002ec4c,param_3,auStack_a8);
    if ((uVar2 & 1) != 0) {
      local_68 = DAT_0002ec48;
      local_60 = CONCAT44(local_60._4_4_,local_a4);
      local_70 = DAT_0002ec40;
      uVar4 = 1;
      goto LAB_000227e0;
    }
  }
  uVar4 = 0;
LAB_000227e0:
  FUN_00023b0c(&local_90);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_38) {
    return uVar4;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



undefined8 FUN_0002283c(long param_1,undefined4 *param_2)

{
  ulong uVar1;
  undefined8 uVar2;
  long lVar3;
  int iVar4;
  ulong uVar5;
  int iVar6;
  int iVar7;
  undefined auStack_148 [112];
  long local_d8;
  undefined4 local_d0;
  undefined4 local_c8 [2];
  int local_c0;
  undefined4 local_48;
  
  local_d8 = param_1 + 8;
  local_d0 = *(undefined4 *)(param_1 + 0x10);
  _memset(local_c8,0,0x84);
  lVar3 = *(long *)(param_1 + 0x48);
  if (lVar3 == 0) {
    uVar5 = __dyld_image_count();
  }
  else {
    uVar5 = (ulong)(*(long *)(lVar3 + 0x10) - *(long *)(lVar3 + 8)) >> 3;
  }
  local_48 = 3;
  uVar1 = FUN_000202b0(&local_d8,(uVar5 & 0xffffffff) * 0x6c + 8);
  if ((uVar1 & 1) != 0) {
    *param_2 = 4;
    *(ulong *)(param_2 + 1) = CONCAT44(local_d0,local_c8[0]);
    iVar4 = (int)uVar5;
    local_c0 = iVar4;
    uVar2 = FUN_00023544(*(undefined8 *)(param_1 + 0x48));
    uVar5 = FUN_000232ec(param_1,uVar2,auStack_148);
    if ((uVar5 & 1) != 0) {
      FUN_0002375c(local_d8,local_d0,0,auStack_148);
      if (iVar4 != 0) {
        iVar6 = 0;
        iVar7 = 1;
        do {
          if ((int)uVar2 != iVar6) {
            uVar5 = FUN_000232ec(param_1,iVar6,auStack_148);
            if ((uVar5 & 1) == 0) goto LAB_00022964;
            FUN_0002375c(local_d8,local_d0,iVar7,auStack_148);
            iVar7 = iVar7 + 1;
          }
          iVar6 = iVar6 + 1;
        } while (iVar4 != iVar6);
      }
      uVar2 = 1;
      goto LAB_00022968;
    }
  }
LAB_00022964:
  uVar2 = 0;
LAB_00022968:
  FUN_00023b74(&local_d8);
  return uVar2;
}



bool FUN_000229ac(long param_1,undefined4 *param_2)

{
  bool bVar1;
  ulong uVar2;
  ulong local_8d8;
  size_t local_8d0;
  rusage local_8c8;
  long local_838;
  undefined4 local_830;
  undefined4 local_828 [2];
  undefined8 local_820;
  pid_t local_818;
  undefined4 local_808;
  undefined4 local_804;
  undefined4 local_800;
  undefined4 local_2c8;
  undefined local_2c0 [648];
  undefined8 local_38;
  undefined4 local_30;
  pid_t pStack_2c;
  long local_28;
  
  local_28 = *(long *)PTR____stack_chk_guard_00028030;
  local_838 = param_1 + 8;
  local_830 = *(undefined4 *)(param_1 + 0x10);
  _bzero(local_828,0x560);
  local_2c8 = 1;
  uVar2 = FUN_000202b0(&local_838,0x558);
  bVar1 = (uVar2 & 1) != 0;
  if (bVar1) {
    *param_2 = 0xf;
    *(ulong *)(param_2 + 1) = CONCAT44(local_830,local_828[0]);
    local_820 = 0x700000558;
    local_818 = _getpid();
    _getrusage(0,&local_8c8);
    local_38 = 0xe00000001;
    local_30 = 1;
    pStack_2c = local_818;
    local_8d0 = 0x288;
    _sysctl((int *)&local_38,4,local_2c0,&local_8d0,(void *)0x0,0);
    local_8d0 = 8;
    FUN_00023c44("hw.cpufrequency_max",&local_8d8);
    local_808 = (undefined4)(local_8d8 / 1000000);
    local_8d0 = 8;
    local_800 = local_808;
    FUN_00023c44("hw.cpufrequency",&local_8d8);
    local_804 = (undefined4)(local_8d8 / 1000000);
  }
  FUN_00023ba0(&local_838);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_28) {
    return bVar1;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



undefined8 FUN_00022b5c(void)

{
  ulong uVar1;
  int iVar2;
  undefined4 uVar3;
  long unaff_x19;
  undefined8 uVar4;
  undefined4 *unaff_x20;
  undefined auStack_48 [8];
  undefined4 local_40;
  undefined8 local_38;
  undefined8 local_30;
  undefined8 local_28;
  
  FUN_00023c70();
  FUN_00023cf0();
  local_38 = 0;
  local_30 = 0;
  local_28 = 0x100000000;
  uVar1 = FUN_000202b0(auStack_48,0xc);
  if ((uVar1 & 1) == 0) {
    uVar4 = 0;
  }
  else {
    *unaff_x20 = 0x47670001;
    *(ulong *)(unaff_x20 + 1) = CONCAT44(local_40,(undefined4)local_38);
    iVar2 = *(int *)(unaff_x19 + 0x2c);
    if ((iVar2 == 0) || (*(int *)(unaff_x19 + 0x20) == 0)) {
      iVar2 = 0;
      uVar3 = 1;
    }
    else {
      uVar3 = 3;
    }
    local_30 = CONCAT44(*(undefined4 *)(unaff_x19 + 0x34),uVar3);
    local_28 = CONCAT44(local_28._4_4_,iVar2);
    uVar4 = 1;
  }
  FUN_00023bd4(auStack_48);
  return uVar4;
}



bool FUN_00022c18(long param_1,undefined8 param_2,undefined8 *param_3)

{
  undefined in_ZR;
  ulong uVar1;
  undefined8 *extraout_x1;
  bool bVar2;
  undefined auStack_368 [8];
  undefined4 local_360;
  undefined4 local_358 [2];
  undefined8 local_350;
  undefined8 local_348;
  undefined8 uStack_340;
  undefined8 local_338;
  undefined8 uStack_330;
  undefined8 local_328;
  undefined8 uStack_320;
  undefined8 local_318;
  undefined8 uStack_310;
  undefined8 local_308;
  undefined8 uStack_300;
  undefined8 local_2f8;
  undefined8 uStack_2f0;
  undefined8 local_2e8;
  undefined8 uStack_2e0;
  undefined8 local_2d8;
  undefined8 uStack_2d0;
  undefined8 local_2c8;
  undefined8 uStack_2c0;
  undefined8 local_2b8;
  undefined8 uStack_2b0;
  undefined8 local_2a8;
  undefined8 uStack_2a0;
  undefined8 local_298;
  undefined8 uStack_290;
  undefined8 local_288;
  undefined8 uStack_280;
  undefined8 local_278;
  undefined8 uStack_270;
  undefined8 local_268;
  undefined8 local_260;
  undefined8 uStack_258;
  undefined8 local_250;
  undefined8 uStack_248;
  undefined4 local_240;
  undefined4 local_34;
  
  FUN_00023c34(*(undefined4 *)(param_1 + 0x38));
  if ((bool)in_ZR) {
    FUN_00023cf0();
    _bzero(local_358,0x328);
    local_34 = 1;
    uVar1 = FUN_000202b0(auStack_368,0x31c);
    bVar2 = (uVar1 & 1) != 0;
    if (bVar2) {
      *param_3 = CONCAT44(local_360,local_358[0]);
      local_350 = 0x80000006;
      uStack_258 = extraout_x1[0x1e];
      local_260 = extraout_x1[0x1d];
      uStack_248 = extraout_x1[0x20];
      local_250 = extraout_x1[0x1f];
      local_240 = *(undefined4 *)(extraout_x1 + 0x21);
      uStack_340 = extraout_x1[1];
      local_348 = *extraout_x1;
      uStack_330 = extraout_x1[3];
      local_338 = extraout_x1[2];
      uStack_320 = extraout_x1[5];
      local_328 = extraout_x1[4];
      uStack_310 = extraout_x1[7];
      local_318 = extraout_x1[6];
      uStack_300 = extraout_x1[9];
      local_308 = extraout_x1[8];
      uStack_2f0 = extraout_x1[0xb];
      local_2f8 = extraout_x1[10];
      uStack_2e0 = extraout_x1[0xd];
      local_2e8 = extraout_x1[0xc];
      uStack_2d0 = extraout_x1[0xf];
      local_2d8 = extraout_x1[0xe];
      uStack_2c0 = extraout_x1[0x11];
      local_2c8 = extraout_x1[0x10];
      uStack_2b0 = extraout_x1[0x13];
      local_2b8 = extraout_x1[0x12];
      uStack_2a0 = extraout_x1[0x15];
      local_2a8 = extraout_x1[0x14];
      uStack_290 = extraout_x1[0x17];
      local_298 = extraout_x1[0x16];
      uStack_280 = extraout_x1[0x19];
      local_288 = extraout_x1[0x18];
      uStack_270 = extraout_x1[0x1b];
      local_278 = extraout_x1[0x1a];
      local_268 = extraout_x1[0x1c];
    }
    FUN_00023a4c(auStack_368);
  }
  else {
    bVar2 = false;
  }
  return bVar2;
}



bool FUN_00022d68(long param_1,thread_act_t param_2,thread_state_t param_3,
                 mach_msg_type_number_t *param_4)

{
  bool bVar1;
  mach_port_t mVar2;
  kern_return_t kVar3;
  size_t sVar4;
  
  if (((*(long *)(param_1 + 0x40) == 0) || (mVar2 = _mach_thread_self(), mVar2 != param_2)) ||
     (*(int *)(param_1 + 0x38) != 0x100000c)) {
    if (*(int *)(param_1 + 0x38) == 0x100000c) {
      kVar3 = _thread_get_state(param_2,6,param_3,param_4);
      bVar1 = kVar3 == 0;
    }
    else {
      bVar1 = false;
    }
  }
  else {
    sVar4 = (size_t)*param_4;
    if (0x10f < *param_4) {
      sVar4 = 0x110;
    }
    _memcpy(param_3,(void *)(*(long *)(*(long *)(param_1 + 0x40) + 0x30) + 0x10),sVar4);
    *param_4 = (mach_msg_type_number_t)sVar4;
    bVar1 = true;
  }
  return bVar1;
}



void FUN_00022e2c(long param_1,ulong param_2,undefined4 *param_3)

{
  undefined in_ZR;
  int iVar1;
  int iVar2;
  undefined8 uVar3;
  ulong *puVar4;
  long lVar5;
  undefined4 local_1534;
  long local_1530;
  undefined4 local_1528;
  undefined8 local_1520;
  long local_1518;
  long local_1510;
  undefined4 local_1504;
  ulong local_1500;
  undefined8 uStack_14f8;
  undefined8 local_14f0;
  undefined4 local_14ac;
  long local_14a8;
  ulong *local_14a0;
  undefined auStack_1498 [248];
  ulong *local_13a0;
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  local_1534 = 0x1440;
  uVar3 = FUN_00022d68(param_1,param_2,auStack_1498,&local_1534);
  if ((int)uVar3 == 0) goto LAB_0002306c;
  FUN_00023c34(*(undefined4 *)(param_1 + 0x38));
  if ((bool)in_ZR) {
    local_1530 = param_1 + 8;
    local_1528 = *(undefined4 *)(param_1 + 0x10);
    local_1520 = 0;
    local_14a0 = local_13a0;
    local_14ac = 0;
    local_1504 = 0x13;
    if (local_13a0 == (ulong *)0x0) {
      lVar5 = 0;
    }
    else {
      iVar1 = FUN_00023ca4(*(undefined4 *)(param_1 + 0x30),&local_14a0,&local_14a8);
      lVar5 = 0;
      if ((iVar1 == 0) && (local_14a0 <= local_13a0)) {
        if (local_14f0._4_4_ == 0x1e) {
          while( true ) {
            lVar5 = (long)local_14a0 + local_14a8;
            local_14ac = 0;
            local_1504 = 0x13;
            local_1510 = lVar5;
            iVar1 = FUN_00023ca4(*(undefined4 *)(param_1 + 0x30),&local_1510,&local_1518);
            if (((iVar1 != 0 || local_1510 != lVar5) || local_14f0._4_4_ != 0x1e) ||
               ((local_1500 & 1) == 0)) break;
            local_14a8 = local_14a8 + local_1518;
          }
        }
        lVar5 = (long)local_14a0 + (local_14a8 - (long)local_13a0);
      }
    }
    if (lVar5 == 0) {
      iVar1 = FUN_000202b0(&local_1530,0x10);
      if (iVar1 != 0) {
        uStack_14f8 = 0xdeadbeef;
        local_1500 = 0xdeadbeef;
        local_13a0 = &local_1500;
        lVar5 = 0x10;
        puVar4 = (ulong *)0xdeadbeef;
LAB_00022fe0:
        iVar1 = FUN_000202e4(&local_1530,local_13a0,lVar5);
LAB_00023010:
        *(ulong **)(param_3 + 6) = puVar4;
        *(ulong *)(param_3 + 8) = CONCAT44(local_1528,(undefined4)local_1520);
        if (iVar1 != 0) {
          FUN_000230c0(param_1 + 0x78,param_3 + 6);
          uVar3 = FUN_00022c18(param_1,auStack_1498,param_3 + 10);
          if ((int)uVar3 != 0) {
            *param_3 = (int)param_2;
            iVar1 = _ahpl_thrd_getname(param_2 & 0xffffffff,param_3 + 0xc,0x20);
            if (iVar1 < 0) {
              *(undefined *)(param_3 + 0xc) = 0;
            }
            uVar3 = 1;
          }
          goto LAB_0002306c;
        }
      }
    }
    else {
      iVar1 = FUN_000202b0(&local_1530,lVar5);
      if (iVar1 != 0) {
        puVar4 = local_13a0;
        if (*(long *)(param_1 + 0x48) == 0) goto LAB_00022fe0;
        local_1500 = 0;
        uStack_14f8 = 0;
        local_14f0 = 0;
        iVar2 = FUN_00020430(*(undefined4 *)(param_1 + 0x30),local_13a0,lVar5,&local_1500);
        if (iVar2 == 0) {
          iVar1 = FUN_000202e4(&local_1530,local_1500,lVar5);
        }
        else {
          iVar1 = 0;
        }
        FUN_00021258(&local_1500);
        if (iVar2 == 0) goto LAB_00023010;
      }
    }
  }
  uVar3 = 0;
LAB_0002306c:
  if (*(long *)PTR____stack_chk_guard_00028030 == local_58) {
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail(uVar3);
}



void FUN_000230c0(void)

{
  ulong uVar1;
  long lVar2;
  long lVar3;
  undefined8 *puVar4;
  ulong uVar5;
  long *unaff_x19;
  undefined8 *unaff_x20;
  undefined8 uVar6;
  undefined auStack_48 [8];
  undefined8 *local_40;
  undefined8 *local_38;
  
  lVar2 = FUN_00023c70();
  puVar4 = *(undefined8 **)(lVar2 + 8);
  if (puVar4 == *(undefined8 **)(lVar2 + 0x10)) {
    lVar3 = (long)puVar4 - *unaff_x19 >> 4;
    uVar1 = lVar3 + 1;
    if (uVar1 >> 0x3c != 0) {
                    // WARNING: Subroutine does not return
      std::__1::__vector_base_common<true>::__throw_length_error();
    }
    lVar2 = (long)*(undefined8 **)(lVar2 + 0x10) - *unaff_x19;
    uVar5 = lVar2 >> 3;
    if (uVar1 <= uVar5) {
      uVar1 = uVar5;
    }
    if (0x7fffffffffffffe < (ulong)(lVar2 >> 4)) {
      uVar1 = 0xfffffffffffffff;
    }
    FUN_000238c4(auStack_48,uVar1,lVar3,unaff_x19 + 3);
    uVar6 = *unaff_x20;
    local_38[1] = unaff_x20[1];
    *local_38 = uVar6;
    local_38 = local_38 + 2;
    FUN_00023850();
    if (local_38 != local_40) {
      FUN_00023cdc();
    }
  }
  else {
    uVar6 = *unaff_x20;
    puVar4[1] = unaff_x20[1];
    *puVar4 = uVar6;
    unaff_x19[1] = (long)(puVar4 + 2);
  }
  return;
}



void FUN_00023188(undefined8 param_1,int param_2,int param_3,undefined8 param_4)

{
  FUN_00020368(param_1,(param_3 << 4 | 8U) + param_2,param_4,0x10);
  return;
}



undefined8 FUN_000231a0(void)

{
  undefined in_ZR;
  int iVar1;
  long lVar2;
  ulong uVar3;
  long unaff_x19;
  undefined8 uVar4;
  undefined4 *unaff_x20;
  long local_1540;
  undefined4 local_1538;
  undefined4 local_1530 [2];
  undefined4 local_1528;
  undefined8 local_1520;
  undefined8 local_1510;
  undefined4 local_1480;
  undefined8 local_1378;
  long local_38;
  
  lVar2 = FUN_00023c70();
  local_38 = *(long *)PTR____stack_chk_guard_00028030;
  local_1540 = lVar2 + 8;
  local_1538 = *(undefined4 *)(lVar2 + 0x10);
  _memset(local_1530,0,0xb0);
  local_1480 = 1;
  uVar3 = FUN_000202b0(&local_1540,0xa8);
  if ((uVar3 & 1) != 0) {
    *unaff_x20 = 6;
    *(ulong *)(unaff_x20 + 1) = CONCAT44(local_1538,local_1530[0]);
    local_1528 = *(undefined4 *)(unaff_x19 + 0x2c);
    local_1520 = *(undefined8 *)(unaff_x19 + 0x20);
    uVar3 = FUN_00022d68();
    if (((uVar3 & 1) != 0) && (iVar1 = FUN_00022c18(), iVar1 != 0)) {
      FUN_00023c34(*(undefined4 *)(unaff_x19 + 0x38));
      if (!(bool)in_ZR) {
        local_1378 = 0;
      }
      uVar4 = 1;
      local_1510 = local_1378;
      goto LAB_00023280;
    }
  }
  uVar4 = 0;
LAB_00023280:
  FUN_00023ad8(&local_1540);
  if (*(long *)PTR____stack_chk_guard_00028030 != local_38) {
                    // WARNING: Subroutine does not return
    ___stack_chk_fail();
  }
  return uVar4;
}



undefined * FUN_000232ec(long param_1,undefined8 param_2,long *param_3)

{
  undefined4 *puVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  ulong uVar5;
  int *piVar6;
  undefined8 uVar7;
  undefined *puVar8;
  long lVar9;
  int iVar10;
  undefined4 local_70;
  undefined4 uStack_6c;
  char local_59;
  undefined4 local_54;
  
  lVar9 = *(long *)(param_1 + 0x48);
  if (lVar9 == 0) {
    piVar6 = (int *)__dyld_get_image_header(param_2);
    if (piVar6 == (int *)0x0) {
      return (undefined *)0x0;
    }
    if (*piVar6 == -0x1120531) {
      iVar10 = piVar6[1];
      lVar9 = __dyld_get_image_vmaddr_slide(param_2);
      uVar7 = __dyld_get_image_name(param_2);
      param_3[1] = 0;
      *param_3 = 0;
      param_3[3] = 0;
      param_3[2] = 0;
      param_3[5] = 0;
      param_3[4] = 0;
      param_3[7] = 0;
      param_3[6] = 0;
      param_3[9] = 0;
      param_3[8] = 0;
      param_3[0xb] = 0;
      param_3[10] = 0;
      param_3[0xd] = 0;
      param_3[0xc] = 0;
      iVar3 = piVar6[4];
      if (iVar3 != 0) {
        piVar6 = piVar6 + 8;
        do {
          if ((*piVar6 == 0x19) && (iVar4 = _strcmp((char *)(piVar6 + 2),"__TEXT"), iVar4 == 0)) {
            iVar3 = FUN_00023cd4(param_1 + 8,uVar7);
            if (iVar3 == 0) {
              return (undefined *)0x0;
            }
            *param_3 = *(long *)(piVar6 + 6) + lVar9;
            *(int *)(param_3 + 1) = (int)*(undefined8 *)(piVar6 + 8);
            *(undefined4 *)((long)param_3 + 0x14) = uStack_6c;
            puVar8 = (undefined *)FUN_000235ac(param_1,param_3,iVar10,uVar7,1);
            return puVar8;
          }
          piVar6 = (int *)((long)piVar6 + (ulong)(uint)piVar6[1]);
          iVar3 = iVar3 + -1;
        } while (iVar3 != 0);
      }
LAB_000234b4:
      return (undefined *)((long)&mach_header_00000000.magic + 1);
    }
  }
  else {
    iVar10 = (int)param_2;
    if ((iVar10 < (int)((ulong)(*(long *)(lVar9 + 0x10) - *(long *)(lVar9 + 8)) >> 3)) &&
       (lVar9 = *(long *)(*(long *)(lVar9 + 8) + (long)iVar10 * 8), lVar9 != 0)) {
      param_3[0xb] = 0;
      param_3[10] = 0;
      param_3[0xd] = 0;
      param_3[0xc] = 0;
      param_3[7] = 0;
      param_3[6] = 0;
      param_3[9] = 0;
      param_3[8] = 0;
      param_3[3] = 0;
      param_3[2] = 0;
      param_3[5] = 0;
      param_3[4] = 0;
      param_3[1] = 0;
      *param_3 = 0;
      std::__1::basic_string<>::basic_string((basic_string *)&local_70);
      puVar1 = (undefined4 *)CONCAT44(uStack_6c,local_70);
      if (-1 < local_59) {
        puVar1 = &local_70;
      }
      iVar3 = FUN_00023cd4(param_1 + 8,puVar1);
      if (iVar3 == 0) {
        FUN_00023c68();
      }
      else {
        *param_3 = *(long *)(lVar9 + 0x38) + *(long *)(lVar9 + 0x28);
        *(int *)(param_3 + 1) = (int)*(undefined8 *)(lVar9 + 0x30);
        *(undefined4 *)((long)param_3 + 0x14) = local_54;
        iVar3 = FUN_00023544(*(undefined8 *)(param_1 + 0x48));
        if (iVar3 != iVar10) {
          *(undefined4 *)(param_3 + 3) = 0xfeef04bd;
          *(uint *)((long)param_3 + 0x1c) = *(uint *)((long)param_3 + 0x1c) | 0x10000;
          uVar2 = *(uint *)(lVar9 + 0x40);
          *(uint *)(param_3 + 4) = uVar2 >> 0x10;
          *(uint *)((long)param_3 + 0x24) =
               uVar2 & 0xff | (uVar2 >> 8 & 0xff) << 0x10 | *(uint *)((long)param_3 + 0x24);
        }
        puVar1 = (undefined4 *)CONCAT44(uStack_6c,local_70);
        if (-1 < local_59) {
          puVar1 = &local_70;
        }
        uVar5 = FUN_000235ac(param_1,param_3,*(undefined4 *)(lVar9 + 0x6c),puVar1,0);
        FUN_00023c68();
        if ((uVar5 & 1) != 0) goto LAB_000234b4;
      }
    }
  }
  return (undefined *)0x0;
}



ulong FUN_00023544(long param_1)

{
  uint uVar1;
  uint uVar2;
  ulong uVar3;
  long lVar4;
  
  if (param_1 == 0) {
    uVar2 = __dyld_image_count();
    if (0 < (int)uVar2) {
      uVar3 = 0;
      do {
        lVar4 = __dyld_get_image_header(uVar3);
        if (*(int *)(lVar4 + 0xc) == 2) {
          return uVar3;
        }
        uVar1 = (int)uVar3 + 1;
        uVar3 = (ulong)uVar1;
      } while (uVar2 != uVar1);
    }
  }
  else {
    uVar3 = FUN_00020a4c();
    if (-1 < (int)uVar3) {
      return uVar3;
    }
  }
  return 0;
}



void FUN_000235ac(long param_1,undefined8 *param_2,undefined8 param_3,char *param_4,int param_5)

{
  char *pcVar1;
  uint uVar2;
  int iVar3;
  char *pcVar4;
  size_t sVar5;
  ulong uVar6;
  undefined8 uVar7;
  undefined auStack_520 [1152];
  uint local_a0;
  ushort local_9c;
  ushort local_9a;
  undefined4 local_98;
  undefined4 uStack_94;
  long local_90;
  int local_88;
  undefined8 local_80;
  undefined8 uStack_78;
  undefined8 local_70;
  undefined8 uStack_68;
  undefined8 local_60;
  long local_58;
  
  local_58 = *(long *)PTR____stack_chk_guard_00028030;
  local_90 = param_1 + 8;
  local_88 = *(int *)(param_1 + 0x10);
  uStack_78 = 0;
  local_80 = 0;
  uStack_68 = 0;
  local_70 = 0;
  local_60 = 0;
  pcVar4 = _strrchr(param_4,0x2f);
  pcVar1 = "<Unknown>";
  if (pcVar4 != (char *)0x0) {
    pcVar1 = pcVar4 + 1;
  }
  sVar5 = _strlen(pcVar1);
  local_60 = CONCAT44(3,(undefined4)local_60);
  uVar6 = FUN_000202b0(&local_90,sVar5 + 0x19);
  if (((uVar6 & 1) == 0) ||
     (iVar3 = FUN_00020368(local_90,local_88 + 0x18,pcVar1,sVar5), iVar3 == 0)) {
    uVar7 = 0;
    goto LAB_00023708;
  }
  *(ulong *)((long)param_2 + 0x4c) = CONCAT44(local_88,(undefined4)local_80);
  uStack_78 = CONCAT44(uStack_78._4_4_,0x53445352);
  uStack_68 = uStack_68 & 0xffffffff;
  if (param_5 == 0) {
LAB_000236b0:
    FUN_0001ef38(auStack_520,param_4);
    FUN_00023c54();
    uVar6 = FUN_0001ef74();
    if ((uVar6 & 1) != 0) goto LAB_000236c8;
  }
  else {
    FUN_0001f074(auStack_520,param_4,*param_2,*(undefined4 *)(param_2 + 1));
    FUN_00023c54();
    uVar6 = FUN_0001f1d0();
    if ((uVar6 & 1) == 0) {
      FUN_00023c54();
      uVar6 = FUN_0001f520();
      if ((uVar6 & 1) == 0) goto LAB_000236b0;
    }
LAB_000236c8:
    uVar2 = (local_a0 & 0xff00ff00) >> 8 | (local_a0 & 0xff00ff) << 8;
    uStack_78 = CONCAT44(uVar2 >> 0x10 | uVar2 << 0x10,(undefined4)uStack_78);
    local_70 = CONCAT44(local_98,CONCAT22(local_9a >> 8 | (ushort)((local_9a & 0xff00ff) << 8),
                                          local_9c >> 8 | (ushort)((local_9c & 0xff00ff) << 8)));
    uStack_68 = CONCAT44(uStack_68._4_4_,uStack_94);
  }
  uVar7 = 1;
LAB_00023708:
  FUN_00023b40(&local_90);
  if (*(long *)PTR____stack_chk_guard_00028030 == local_58) {
    FUN_00023c7c(uVar7);
    return;
  }
                    // WARNING: Subroutine does not return
  ___stack_chk_fail();
}



void FUN_0002375c(undefined8 param_1,int param_2,int param_3,undefined8 param_4)

{
  FUN_00020368(param_1,param_2 + param_3 * 0x6c + 8,param_4,0x6c);
  return;
}



void FUN_00023774(long *param_1)

{
  long *plVar1;
  long lVar2;
  
  plVar1 = (long *)param_1[1];
  while (plVar1 != (long *)0x0) {
    lVar2 = *plVar1;
    _munmap(plVar1,*param_1 * plVar1[1]);
    plVar1 = (long *)lVar2;
  }
  return;
}



long FUN_000237b0(long param_1)

{
  long lVar1;
  long lVar2;
  void *pvVar3;
  long lVar4;
  
  lVar1 = *(long *)(param_1 + 8);
  lVar2 = *(long *)(param_1 + 0x10);
  lVar4 = (lVar2 - lVar1) * 0x20000000;
  if (lVar4 == 0x100000000 ||
      (lVar2 - lVar1) * -0x20000000 + 0x100000000 < 0 != SBORROW8(0x100000000,lVar4)) {
    lVar4 = 0;
    do {
      pvVar3 = *(void **)(lVar1 + lVar4 * 8);
      if (pvVar3 != (void *)0x0) {
        FUN_00021284(pvVar3);
        operator_delete(pvVar3);
        lVar1 = *(long *)(param_1 + 8);
        lVar2 = *(long *)(param_1 + 0x10);
      }
      lVar4 = lVar4 + 1;
    } while (lVar4 < (int)((ulong)(lVar2 - lVar1) >> 3));
  }
  FUN_00020a8c((long *)(param_1 + 8));
  return param_1;
}



void FUN_00023850(long *param_1,undefined8 *param_2)

{
  undefined8 *puVar1;
  long lVar2;
  long lVar3;
  long lVar4;
  undefined8 uVar5;
  
  lVar2 = *param_1;
  lVar4 = param_1[1];
  if (lVar4 == lVar2) {
    lVar3 = param_2[1];
  }
  else {
    lVar3 = param_2[1];
    do {
      puVar1 = (undefined8 *)(lVar4 + -8);
      uVar5 = *(undefined8 *)(lVar4 + -0x10);
      lVar4 = lVar4 + -0x10;
      *(undefined8 *)(lVar3 + -8) = *puVar1;
      *(undefined8 *)(lVar3 + -0x10) = uVar5;
      lVar3 = param_2[1] + -0x10;
      param_2[1] = lVar3;
    } while (lVar2 != lVar4);
    lVar2 = *param_1;
  }
  *param_1 = lVar3;
  param_2[1] = lVar2;
  lVar2 = param_1[1];
  param_1[1] = param_2[2];
  param_2[2] = lVar2;
  lVar2 = param_1[2];
  param_1[2] = param_2[3];
  param_2[3] = lVar2;
  *param_2 = param_2[1];
  return;
}



void FUN_000238c4(undefined8 param_1,undefined8 param_2,long param_3,ulong **param_4)

{
  ulong *puVar1;
  ulong uVar2;
  ulong uVar3;
  ulong uVar4;
  ulong uVar5;
  ulong **unaff_x19;
  long unaff_x20;
  ulong *puVar6;
  ulong *puVar7;
  undefined auVar8 [16];
  
  auVar8 = FUN_00023c70();
  *(undefined8 *)(auVar8._0_8_ + 0x18) = 0;
  *(ulong ***)(auVar8._0_8_ + 0x20) = param_4;
  if (auVar8._8_8_ != 0) {
    puVar7 = (ulong *)(unaff_x20 * 0x10);
    if (puVar7 < param_4[2] || (long)puVar7 - (long)param_4[2] == 0) {
      puVar1 = param_4[1];
      goto LAB_000239a8;
    }
    puVar6 = *param_4;
    uVar2 = puVar6[2];
    uVar4 = *puVar6;
    if ((uVar2 != 0) && (uVar5 = puVar6[3], puVar7 <= (ulong *)(uVar4 - uVar5))) {
      puVar1 = (ulong *)(uVar2 + uVar5);
      puVar6[3] = uVar5 + (long)puVar7;
      if (uVar5 + (long)puVar7 == uVar4) {
        puVar6[2] = 0;
        puVar6[3] = 0;
      }
      goto LAB_000239a8;
    }
    uVar2 = 0;
    if (uVar4 != 0) {
      uVar2 = (uVar4 + ((ulong)puVar7 | 0xf)) / uVar4;
    }
    puVar1 = (ulong *)_mmap(0,uVar2 * uVar4,3,&DAT_00001002,0xffffffff,0);
    if (puVar1 != (ulong *)0xffffffffffffffff) {
      *puVar1 = puVar6[1];
      puVar1[1] = uVar2;
      puVar6[1] = (ulong)puVar1;
      puVar6[4] = puVar6[4] + uVar2;
      if (puVar1 != (ulong *)0x0) {
        uVar3 = *puVar6;
        uVar4 = (long)puVar7 + (uVar3 - uVar3 * uVar2) + 0x10;
        uVar5 = 0;
        if (uVar3 != 0) {
          uVar5 = uVar4 / uVar3;
        }
        uVar4 = uVar4 - uVar5 * uVar3;
        puVar7 = (ulong *)0x0;
        if (uVar4 != 0) {
          puVar7 = (ulong *)((long)puVar1 + uVar3 * (uVar2 - 1));
        }
        puVar6[2] = (ulong)puVar7;
        puVar6[3] = uVar4;
        puVar1 = puVar1 + 2;
        goto LAB_000239a8;
      }
    }
  }
  puVar1 = (ulong *)0x0;
LAB_000239a8:
  *unaff_x19 = puVar1;
  unaff_x19[1] = puVar1 + param_3 * 2;
  unaff_x19[2] = puVar1 + param_3 * 2;
  unaff_x19[3] = puVar1 + unaff_x20 * 2;
  return;
}



void FUN_000239ec(long param_1)

{
  if (*(int *)(param_1 + 0x38) != 2) {
    FUN_00023c10();
    FUN_00020368();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023a20(long param_1)

{
  if (*(int *)(param_1 + 0x24) != 2) {
    FUN_00023c90();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023a4c(long param_1)

{
  if (*(int *)(param_1 + 0x334) != 2) {
    FUN_00023c10();
    FUN_00020368();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023a80(long param_1)

{
  if (*(int *)(param_1 + 0x70) != 2) {
    FUN_00023c20();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023aac(long param_1)

{
  if (*(int *)(param_1 + 0x30) != 2) {
    FUN_00023c20();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023ad8(long param_1)

{
  if (*(int *)(param_1 + 0xc0) != 2) {
    FUN_00023c10();
    FUN_00020368();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023b0c(long param_1)

{
  if (*(int *)(param_1 + 0x50) != 2) {
    FUN_00023c10();
    FUN_00020368();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023b40(long param_1)

{
  if (*(int *)(param_1 + 0x34) != 2) {
    FUN_00023c10();
    FUN_00020368();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023b74(long param_1)

{
  if (*(int *)(param_1 + 0x90) != 2) {
    FUN_00023c20();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023ba0(long param_1)

{
  if (*(int *)(param_1 + 0x570) != 2) {
    FUN_00023c10();
    FUN_00020368();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023bd4(long param_1)

{
  if (*(int *)(param_1 + 0x24) != 2) {
    FUN_00023c90();
  }
  FUN_00023c00(param_1);
  return;
}



void FUN_00023c00(void)

{
  return;
}



void FUN_00023c08(void)

{
  _Unwind_Exception *unaff_x19;
  
  __Unwind_Resume(unaff_x19);
  return;
}



undefined  [16] FUN_00023c10(void)

{
  undefined (*unaff_x19) [12];
  undefined auVar1 [16];
  
  auVar1._12_4_ = 0;
  auVar1._0_12_ = *unaff_x19;
  return auVar1;
}



void FUN_00023c20(void)

{
  undefined8 *unaff_x19;
  
  FUN_00020368(*unaff_x19,*(undefined4 *)(unaff_x19 + 1),unaff_x19 + 3,8);
  return;
}



void FUN_00023c34(void)

{
  return;
}



int FUN_00023c44(char *param_1,void *param_2)

{
  int iVar1;
  
  iVar1 = _sysctlbyname(param_1,param_2,(size_t *)&stack0x00000010,(void *)0x0,0);
  return iVar1;
}



void FUN_00023c54(void)

{
  return;
}



void FUN_00023c68(void)

{
  std::__1::basic_string<>::~basic_string((basic_string<> *)&stack0x00000000);
  return;
}



void FUN_00023c70(void)

{
  return;
}



void FUN_00023c7c(void)

{
  return;
}



void FUN_00023c90(void)

{
  undefined8 *unaff_x19;
  
  FUN_00020368(*unaff_x19,*(undefined4 *)(unaff_x19 + 1),unaff_x19 + 3,0xc);
  return;
}



kern_return_t FUN_00023ca4(vm_map_t param_1,vm_address_t *param_2,vm_size_t *param_3)

{
  kern_return_t kVar1;
  
  kVar1 = _vm_region_recurse_64
                    (param_1,param_2,param_3,(natural_t *)&stack0x00000094,
                     (vm_region_recurse_info_t)&stack0x00000040,
                     (mach_msg_type_number_t *)&stack0x0000003c);
  return kVar1;
}



void FUN_00023cb4(void)

{
  _CFReadStreamRead();
  return;
}



void FUN_00023cc4(void)

{
  _CFRelease();
  return;
}



void FUN_00023ccc(void)

{
  _Unwind_Exception *unaff_x20;
  
  __Unwind_Resume(unaff_x20);
  return;
}



void FUN_00023cd4(undefined8 param_1,undefined8 param_2)

{
  FUN_0002013c(param_1,param_2,0);
  return;
}



void FUN_00023cdc(void)

{
  return;
}



void FUN_00023cf0(void)

{
  return;
}



void FUN_00023d04(void)

{
  _CFRelease();
  return;
}



undefined8 FUN_00023d0c(void **param_1,void *param_2,void *param_3)

{
  void **ppvVar1;
  void *pvVar2;
  
  ppvVar1 = (void **)_malloc(0x18);
  if (ppvVar1 != (void **)0x0) {
    pvVar2 = _malloc((long)param_3 * 0x18);
    *ppvVar1 = pvVar2;
    if (pvVar2 != (void *)0x0) {
      _memcpy(pvVar2,param_2,(long)param_3 * 0x18);
      pvVar2 = *param_1;
      ppvVar1[1] = param_3;
      ppvVar1[2] = pvVar2;
      *param_1 = ppvVar1;
      return 0;
    }
    _free(ppvVar1);
  }
  return 0xffffffff;
}



void FUN_00023d94(undefined8 param_1,long param_2)

{
  int iVar1;
  char cVar2;
  int *piVar3;
  int *piVar4;
  ulong uVar5;
  int *piVar6;
  int *piVar7;
  int *piVar8;
  uint uVar9;
  uint uVar10;
  int *piVar11;
  int *piVar12;
  int *piVar13;
  undefined auStack_80 [32];
  
  iVar1 = _dladdr(param_2,auStack_80);
  if ((iVar1 != 0) && (uVar10 = *(uint *)(param_2 + 0x10), uVar10 != 0)) {
    piVar13 = (int *)(param_2 + 0x20);
    piVar3 = (int *)0x0;
    piVar6 = (int *)0x0;
    piVar8 = piVar13;
    piVar11 = (int *)0x0;
    uVar9 = uVar10;
    do {
      iVar1 = *piVar8;
      piVar4 = piVar3;
      piVar7 = piVar8;
      piVar12 = piVar11;
      if ((((iVar1 != 2) && (piVar4 = piVar8, piVar7 = piVar6, iVar1 != 0xb)) &&
          (piVar4 = piVar3, iVar1 == 0x19)) &&
         (iVar1 = _strcmp((char *)(piVar8 + 2),"__LINKEDIT"), piVar12 = piVar8, iVar1 != 0)) {
        piVar12 = piVar11;
      }
      piVar8 = (int *)((long)piVar8 + (ulong)(uint)piVar8[1]);
      uVar9 = uVar9 - 1;
      piVar3 = piVar4;
      piVar6 = piVar7;
      piVar11 = piVar12;
    } while (uVar9 != 0);
    if (((piVar4 != (int *)0x0) && (piVar7 != (int *)0x0)) &&
       ((piVar12 != (int *)0x0 && ((piVar4[0xf] != 0 && (uVar10 != 0)))))) {
      uVar9 = 0;
      do {
        if (*piVar13 == 0x19) {
          iVar1 = _strcmp((char *)(piVar13 + 2),"__DATA");
          if (((iVar1 == 0) || (iVar1 = _strcmp((char *)(piVar13 + 2),"__DATA_CONST"), iVar1 == 0))
             && (piVar13[0x10] != 0)) {
            uVar5 = 0;
            piVar8 = piVar13 + 0x12;
            do {
              cVar2 = *(char *)(piVar8 + 0x10);
              if (cVar2 == '\a') {
                FUN_000241c0();
                cVar2 = *(char *)(piVar8 + 0x10);
              }
              if (cVar2 == '\x06') {
                FUN_000241c0();
              }
              uVar5 = uVar5 + 1;
              piVar8 = piVar8 + 0x14;
            } while (uVar5 < (uint)piVar13[0x10]);
            uVar10 = *(uint *)(param_2 + 0x10);
          }
        }
        uVar9 = uVar9 + 1;
        piVar13 = (int *)((long)piVar13 + (ulong)(uint)piVar13[1]);
      } while (uVar9 < uVar10);
    }
  }
  FUN_000241a4();
  return;
}



undefined8 FUN_00023f44(undefined8 param_1,undefined8 param_2)

{
  int iVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  int iVar5;
  
  uVar2 = FUN_00023d0c(&DAT_0002e758,param_1,param_2);
  if (-1 < (int)uVar2) {
    if (*(long *)(DAT_0002e758 + 0x10) == 0) {
      __dyld_register_func_for_add_image(FUN_00023fe0);
    }
    else {
      iVar1 = __dyld_image_count();
      if (iVar1 != 0) {
        iVar5 = 0;
        do {
          uVar3 = __dyld_get_image_header(iVar5);
          uVar4 = __dyld_get_image_vmaddr_slide(iVar5);
          FUN_00023fe0(uVar3,uVar4);
          iVar5 = iVar5 + 1;
        } while (iVar1 != iVar5);
      }
    }
  }
  return uVar2;
}



void FUN_00023fe0(undefined8 param_1,undefined8 param_2)

{
  FUN_00023d94(DAT_0002e758,param_1,param_2);
  return;
}



void FUN_00023ff4(long *param_1,long param_2,long param_3,long param_4,long param_5,long param_6)

{
  ulong uVar1;
  char *pcVar2;
  uint uVar3;
  uint uVar4;
  bool bVar5;
  int iVar6;
  kern_return_t kVar7;
  ulong uVar8;
  long *plVar9;
  long lVar10;
  ulong uVar11;
  long lVar12;
  ulong uVar13;
  ulong uVar14;
  ulong uVar15;
  long *plVar16;
  ulong uVar17;
  
  uVar13 = *(ulong *)(param_2 + 0x28);
  if (7 < uVar13) {
    uVar14 = 0;
    uVar3 = *(uint *)(param_2 + 0x44);
    uVar1 = *(long *)(param_2 + 0x20) + param_3;
    do {
      uVar4 = *(uint *)(param_6 + (ulong)uVar3 * 4 + uVar14 * 4);
      if ((uVar4 != 0x80000000 && uVar4 != 0xc0000000) && uVar4 != 0x40000000) {
        pcVar2 = (char *)(param_5 + (ulong)*(uint *)(param_4 + (ulong)uVar4 * 0x10));
        if (*pcVar2 == '\0') {
          bVar5 = false;
        }
        else {
          bVar5 = pcVar2[1] != '\0';
        }
        if (param_1 != (long *)0x0) {
          plVar16 = param_1;
          do {
            uVar11 = plVar16[1];
            if (uVar11 != 0) {
              uVar8 = 1;
              uVar17 = 0;
              do {
                uVar15 = uVar8;
                if (bVar5) {
                  lVar12 = *plVar16;
                  iVar6 = _strcmp(pcVar2 + 1,*(char **)(lVar12 + uVar17 * 0x18));
                  if (iVar6 == 0) {
                    plVar9 = *(long **)(lVar12 + uVar17 * 0x18 + 0x10);
                    if ((plVar9 != (long *)0x0) &&
                       (lVar10 = *(long *)(uVar1 + uVar14 * 8),
                       lVar10 != *(long *)(lVar12 + uVar17 * 0x18 + 8))) {
                      *plVar9 = lVar10;
                    }
                    uVar11 = -(DAT_00028d48 << 0x20) >> 0x20;
                    uVar8 = uVar1 & uVar11;
                    kVar7 = _vm_protect(*(vm_map_t *)PTR__mach_task_self__00028040,uVar8,
                                        ((uVar13 + uVar1) - uVar8) +
                                        ((DAT_00028d48 << 0x20) + -0x100000000 >> 0x20) & uVar11,0,
                                        0x13);
                    if (kVar7 == 0) {
                      *(undefined8 *)(uVar1 + uVar14 * 8) =
                           *(undefined8 *)(*plVar16 + uVar17 * 0x18 + 8);
                    }
                    goto LAB_00024074;
                  }
                }
                uVar8 = (ulong)((int)uVar15 + 1);
                uVar17 = uVar15;
              } while (uVar15 < uVar11);
            }
            plVar16 = (long *)plVar16[2];
          } while (plVar16 != (long *)0x0);
        }
      }
LAB_00024074:
      uVar14 = (ulong)((int)uVar14 + 1);
      uVar13 = *(ulong *)(param_2 + 0x28);
    } while (uVar14 < uVar13 >> 3);
  }
  FUN_000241a4();
  return;
}



void FUN_000241a4(void)

{
  return;
}



void FUN_000241c0(void)

{
  FUN_00023ff4();
  return;
}



void _CFDataAppendBytes(void)

{
                    // WARNING: Could not recover jumptable at 0x000241e4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFDataAppendBytes_00028060)();
  return;
}



void _CFDataCreateMutable(void)

{
                    // WARNING: Could not recover jumptable at 0x000241f0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFDataCreateMutable_00028068)();
  return;
}



void _CFDictionaryGetValue(void)

{
                    // WARNING: Could not recover jumptable at 0x000241fc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFDictionaryGetValue_00028070)();
  return;
}



void _CFPropertyListCreateWithData(void)

{
                    // WARNING: Could not recover jumptable at 0x00024208. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFPropertyListCreateWithData_00028078)();
  return;
}



void _CFReadStreamClose(void)

{
                    // WARNING: Could not recover jumptable at 0x00024214. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFReadStreamClose_00028080)();
  return;
}



void _CFReadStreamCreateWithFile(void)

{
                    // WARNING: Could not recover jumptable at 0x00024220. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFReadStreamCreateWithFile_00028088)();
  return;
}



void _CFReadStreamOpen(void)

{
                    // WARNING: Could not recover jumptable at 0x0002422c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFReadStreamOpen_00028090)();
  return;
}



void _CFReadStreamRead(void)

{
                    // WARNING: Could not recover jumptable at 0x00024238. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFReadStreamRead_00028098)();
  return;
}



void _CFRelease(void)

{
                    // WARNING: Could not recover jumptable at 0x00024244. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFRelease_000280a0)();
  return;
}



void _CFStringGetBytes(void)

{
                    // WARNING: Could not recover jumptable at 0x00024250. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFStringGetBytes_000280a8)();
  return;
}



void _CFStringGetLength(void)

{
                    // WARNING: Could not recover jumptable at 0x0002425c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFStringGetLength_000280b0)();
  return;
}



void _CFStringGetMaximumSizeForEncoding(void)

{
                    // WARNING: Could not recover jumptable at 0x00024268. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFStringGetMaximumSizeForEncoding_000280b8)();
  return;
}



void _CFURLCreateWithFileSystemPath(void)

{
                    // WARNING: Could not recover jumptable at 0x00024274. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFURLCreateWithFileSystemPath_000280c0)();
  return;
}



void _CFUUIDCreate(void)

{
                    // WARNING: Could not recover jumptable at 0x00024280. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFUUIDCreate_000280c8)();
  return;
}



void _CFUUIDCreateString(void)

{
                    // WARNING: Could not recover jumptable at 0x0002428c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__CFUUIDCreateString_000280d0)();
  return;
}



void _NSSearchPathForDirectoriesInDomains(void)

{
                    // WARNING: Could not recover jumptable at 0x00024298. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__NSSearchPathForDirectoriesInDomains_000280d8)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

NXArchInfo * _NXGetLocalArchInfo(void)

{
  NXArchInfo *pNVar1;
  
                    // WARNING: Could not recover jumptable at 0x000242a4. Too many branches
                    // WARNING: Treating indirect jump as call
  pNVar1 = (NXArchInfo *)(*(code *)PTR__NXGetLocalArchInfo_000280e0)();
  return pNVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void __Block_object_assign(void *param_1,void *param_2,int param_3)

{
                    // WARNING: Could not recover jumptable at 0x000242b0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___Block_object_assign_000280e8)(param_1,param_2,param_3);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void __Block_object_dispose(void *param_1,int param_2)

{
                    // WARNING: Could not recover jumptable at 0x000242bc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___Block_object_dispose_000280f0)(param_1,param_2);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void __Unwind_Resume(_Unwind_Exception *exception_object)

{
                    // WARNING: Could not recover jumptable at 0x000242c8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___Unwind_Resume_000280f8)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::at(unsigned long) const

void std::__1::basic_string<>::at(ulong param_1)

{
                    // WARNING: Could not recover jumptable at 0x000242d4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_at_00028100)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::__vector_base_common<true>::__throw_length_error() const

void std::__1::__vector_base_common<true>::__throw_length_error(void)

{
                    // WARNING: Could not recover jumptable at 0x000242e0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___throw_length_error_00028108)();
  return;
}



// std::logic_error::logic_error(char const*)

void __thiscall std::logic_error::logic_error(logic_error *this,char *param_1)

{
                    // WARNING: Could not recover jumptable at 0x000242ec. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_logic_error_00028110)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::__init(char const*, unsigned long)

void std::__1::basic_string<>::__init(char *param_1,ulong param_2)

{
                    // WARNING: Could not recover jumptable at 0x000242f8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___init_00028118)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::append(char const*)

void std::__1::basic_string<>::append(char *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00024304. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_append_00028120)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::append(char const*, unsigned long)

void std::__1::basic_string<>::append(char *param_1,ulong param_2)

{
                    // WARNING: Could not recover jumptable at 0x00024310. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_append_00028128)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::append(unsigned long, char)

void std::__1::basic_string<>::append(ulong param_1,char param_2)

{
                    // WARNING: Could not recover jumptable at 0x0002431c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_append_00028130)(param_1,param_2);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::assign(char const*)

void std::__1::basic_string<>::assign(char *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00024328. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_assign_00028138)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::basic_string(std::__1::basic_string<char, std::__1::char_traits<char>,
// std::__1::allocator<char> > const&)

void std::__1::basic_string<>::basic_string(basic_string *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00024334. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_basic_string_00028140)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::basic_string(std::__1::basic_string<char, std::__1::char_traits<char>,
// std::__1::allocator<char> > const&, unsigned long, unsigned long, std::__1::allocator<char>
// const&)

void std::__1::basic_string<>::basic_string
               (basic_string *param_1,ulong param_2,ulong param_3,allocator *param_4)

{
                    // WARNING: Could not recover jumptable at 0x00024340. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_basic_string_00028148)();
  return;
}



// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::~basic_string()

void __thiscall std::__1::basic_string<>::~basic_string(basic_string<> *this)

{
                    // WARNING: Could not recover jumptable at 0x0002434c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__basic_string_00028150)();
  return;
}



// std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char>
// >::TEMPNAMEPLACEHOLDERVALUE(std::__1::basic_string<char, std::__1::char_traits<char>,
// std::__1::allocator<char> > const&)

void __thiscall std::__1::basic_string<>::operator=(basic_string<> *this,basic_string *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00024358. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_operator__00028158)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::terminate()

void std::terminate(void)

{
                    // WARNING: Could not recover jumptable at 0x00024364. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_terminate_00028160)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// operator delete[](void*)

void operator_delete__(void *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00024370. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_operator_delete___00028168)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// operator delete(void*)

void operator_delete(void *param_1)

{
                    // WARNING: Could not recover jumptable at 0x0002437c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR_operator_delete_00028170)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// operator new[](unsigned long)

void * operator_new__(ulong param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024388. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR_operator_new___00028178)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// operator new(unsigned long)

void * operator_new(ulong param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024394. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR_operator_new_00028180)();
  return pvVar1;
}



void ___cxa_allocate_exception(void)

{
                    // WARNING: Could not recover jumptable at 0x000243a0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____cxa_allocate_exception_00028188)();
  return;
}



void ___cxa_atexit(void)

{
                    // WARNING: Could not recover jumptable at 0x000243ac. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____cxa_atexit_00028190)();
  return;
}



void ___cxa_begin_catch(void)

{
                    // WARNING: Could not recover jumptable at 0x000243b8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____cxa_begin_catch_00028198)();
  return;
}



void ___cxa_free_exception(void)

{
                    // WARNING: Could not recover jumptable at 0x000243c4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____cxa_free_exception_000281a0)();
  return;
}



void ___cxa_throw(void)

{
                    // WARNING: Could not recover jumptable at 0x000243d0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____cxa_throw_000281a8)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int * ___error(void)

{
  int *piVar1;
  
                    // WARNING: Could not recover jumptable at 0x000243dc. Too many branches
                    // WARNING: Treating indirect jump as call
  piVar1 = (int *)(*(code *)PTR____error_000281b0)();
  return piVar1;
}



void ___memcpy_chk(void)

{
                    // WARNING: Could not recover jumptable at 0x000243e8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____memcpy_chk_000281b8)();
  return;
}



void ___sprintf_chk(void)

{
                    // WARNING: Could not recover jumptable at 0x000243f4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____sprintf_chk_000281c0)();
  return;
}



void ___stack_chk_fail(void)

{
                    // WARNING: Could not recover jumptable at 0x00024400. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____stack_chk_fail_000281c8)();
  return;
}



void ___strcpy_chk(void)

{
                    // WARNING: Could not recover jumptable at 0x0002440c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____strcpy_chk_000281d0)();
  return;
}



void ___strncpy_chk(void)

{
                    // WARNING: Could not recover jumptable at 0x00024418. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR____strncpy_chk_000281d8)();
  return;
}



void __dyld_get_image_header(void)

{
                    // WARNING: Could not recover jumptable at 0x00024424. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___dyld_get_image_header_000281e0)();
  return;
}



void __dyld_get_image_name(void)

{
                    // WARNING: Could not recover jumptable at 0x00024430. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___dyld_get_image_name_000281e8)();
  return;
}



void __dyld_get_image_vmaddr_slide(void)

{
                    // WARNING: Could not recover jumptable at 0x0002443c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___dyld_get_image_vmaddr_slide_000281f0)();
  return;
}



void __dyld_image_count(void)

{
                    // WARNING: Could not recover jumptable at 0x00024448. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___dyld_image_count_000281f8)();
  return;
}



void __dyld_register_func_for_add_image(void)

{
                    // WARNING: Could not recover jumptable at 0x00024454. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___dyld_register_func_for_add_image_00028200)();
  return;
}



void __dyld_register_func_for_remove_image(void)

{
                    // WARNING: Could not recover jumptable at 0x00024460. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR___dyld_register_func_for_remove_image_00028208)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _abort(void)

{
                    // WARNING: Could not recover jumptable at 0x0002446c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__abort_00028210)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _accept(int param_1,sockaddr *param_2,socklen_t *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024478. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__accept_00028218)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _atexit(void *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024484. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__atexit_00028220)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _atoi(char *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024490. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__atoi_00028228)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _bind(int param_1,sockaddr *param_2,socklen_t param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002449c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__bind_00028230)(param_1,param_2,param_3);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _bzero(void *param_1,size_t param_2)

{
                    // WARNING: Could not recover jumptable at 0x000244a8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__bzero_00028238)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _calloc(size_t param_1,size_t param_2)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x000244b4. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__calloc_00028240)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _close(int param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000244c0. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__close_00028248)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _connect(int param_1,sockaddr *param_2,socklen_t param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000244cc. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__connect_00028250)(param_1,param_2,param_3);
  return iVar1;
}



void _dispatch_async(void)

{
                    // WARNING: Could not recover jumptable at 0x000244d8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dispatch_async_00028258)();
  return;
}



void _dladdr(void)

{
                    // WARNING: Could not recover jumptable at 0x000244e4. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__dladdr_00028260)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _fcntl(int param_1,int param_2,...)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000244f0. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__fcntl_00028268)(param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _free(void *param_1)

{
                    // WARNING: Could not recover jumptable at 0x000244fc. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__free_00028270)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _freeaddrinfo(addrinfo *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00024508. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__freeaddrinfo_00028278)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _fstat(int param_1,stat *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024514. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__fstat_00028280)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ftruncate(int param_1,off_t param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024520. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__ftruncate_00028288)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _getaddrinfo(char *param_1,char *param_2,addrinfo *param_3,addrinfo **param_4)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002452c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getaddrinfo_00028290)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _getpagesize(void)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024538. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getpagesize_00028298)();
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _getpeername(int param_1,sockaddr *param_2,socklen_t *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024544. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getpeername_000282a0)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

pid_t _getpid(void)

{
  pid_t pVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024550. Too many branches
                    // WARNING: Treating indirect jump as call
  pVar1 = (*(code *)PTR__getpid_000282a8)();
  return pVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _getrusage(int param_1,rusage *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002455c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getrusage_000282b0)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _getsockname(int param_1,sockaddr *param_2,socklen_t *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024568. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getsockname_000282b8)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _getsockopt(int param_1,int param_2,int param_3,void *param_4,socklen_t *param_5)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024574. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__getsockopt_000282c0)(param_1,param_2,param_3);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _gettimeofday(timeval *param_1,void *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024580. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__gettimeofday_000282c8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * _inet_ntop(int param_1,void *param_2,char *param_3,socklen_t param_4)

{
  char *pcVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002458c. Too many branches
                    // WARNING: Treating indirect jump as call
  pcVar1 = (char *)(*(code *)PTR__inet_ntop_000282d0)(param_1,param_2,param_3,param_4);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _inet_pton(int param_1,char *param_2,void *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024598. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__inet_pton_000282d8)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _ioctl(int param_1,ulong param_2,...)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245a4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__ioctl_000282e0)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _kevent64(int kq,kevent64_s *changelist,int nchanges,kevent64_s *eventlist,int nevents,
             uint flags,timespec *timeout)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245b0. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__kevent64_000282e8)(kq,changelist,nchanges,eventlist,nevents,flags);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _kqueue(void)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245bc. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__kqueue_000282f0)();
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _listen(int param_1,int param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245c8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__listen_000282f8)(param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

off_t _lseek(int param_1,off_t param_2,int param_3)

{
  off_t oVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245d4. Too many branches
                    // WARNING: Treating indirect jump as call
  oVar1 = (*(code *)PTR__lseek_00028300)(param_1,param_2,param_3);
  return oVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

uint64_t _mach_absolute_time(void)

{
  uint64_t uVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245e0. Too many branches
                    // WARNING: Treating indirect jump as call
  uVar1 = (*(code *)PTR__mach_absolute_time_00028308)();
  return uVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

mach_port_t _mach_thread_self(void)

{
  mach_port_t mVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245ec. Too many branches
                    // WARNING: Treating indirect jump as call
  mVar1 = (*(code *)PTR__mach_thread_self_00028310)();
  return mVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t _mach_timebase_info(mach_timebase_info_t info)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x000245f8. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__mach_timebase_info_00028318)((int)info);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _malloc(size_t param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024604. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__malloc_00028320)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _memchr(void *param_1,int param_2,size_t param_3)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024610. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__memchr_00028328)(param_1,param_2);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _memcmp(void *param_1,void *param_2,size_t param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002461c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__memcmp_00028330)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _memcpy(void *param_1,void *param_2,size_t param_3)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024628. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__memcpy_00028338)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _memmove(void *param_1,void *param_2,size_t param_3)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024634. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__memmove_00028340)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _memset(void *param_1,int param_2,size_t param_3)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024640. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__memset_00028348)(param_1,param_2);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _mkdir(char *param_1,mode_t param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002464c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__mkdir_00028350)((int)param_1,param_2);
  return iVar1;
}



void _mmap(void)

{
                    // WARNING: Could not recover jumptable at 0x00024658. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__mmap_00028358)();
  return;
}



void _munmap(void)

{
                    // WARNING: Could not recover jumptable at 0x00024664. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__munmap_00028360)();
  return;
}



void _objc_autoreleasePoolPop(void)

{
                    // WARNING: Could not recover jumptable at 0x00024670. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_autoreleasePoolPop_00028368)();
  return;
}



void _objc_autoreleasePoolPush(void)

{
                    // WARNING: Could not recover jumptable at 0x0002467c. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_autoreleasePoolPush_00028370)();
  return;
}



void _objc_msgSend(void)

{
                    // WARNING: Could not recover jumptable at 0x00024688. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_msgSend_00028378)();
  return;
}



void _objc_release(void)

{
                    // WARNING: Could not recover jumptable at 0x00024694. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_release_00028380)();
  return;
}



void _objc_retain(void)

{
                    // WARNING: Could not recover jumptable at 0x000246a0. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retain_00028388)();
  return;
}



void _objc_retainAutorelease(void)

{
                    // WARNING: Could not recover jumptable at 0x000246ac. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutorelease_00028390)();
  return;
}



void _objc_retainAutoreleasedReturnValue(void)

{
                    // WARNING: Could not recover jumptable at 0x000246b8. Too many branches
                    // WARNING: Treating indirect jump as call
  (*(code *)PTR__objc_retainAutoreleasedReturnValue_00028398)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _open(char *param_1,int param_2,...)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000246c4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__open_000283a0)((int)param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t _pid_for_task(mach_port_name_t t,int *x)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x000246d0. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__pid_for_task_000283a8)(t);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pipe(int param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000246dc. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pipe_000283b0)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _pread(int param_1,void *param_2,size_t param_3,off_t param_4)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x000246e8. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__pread_000283b8)(param_1);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_attr_init(pthread_attr_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000246f4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_attr_init_000283c0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_attr_setdetachstate(pthread_attr_t *param_1,int param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024700. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_attr_setdetachstate_000283c8)((int)param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_cond_broadcast(pthread_cond_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002470c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_broadcast_000283d0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_cond_destroy(pthread_cond_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024718. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_destroy_000283d8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_cond_init(pthread_cond_t *param_1,pthread_condattr_t *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024724. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_init_000283e0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_cond_signal(pthread_cond_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024730. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_signal_000283e8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_cond_timedwait_relative_np
              (pthread_cond_t *param_1,pthread_mutex_t *param_2,timespec *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002473c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_timedwait_relative_np_000283f0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_cond_wait(pthread_cond_t *param_1,pthread_mutex_t *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024748. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_cond_wait_000283f8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_condattr_destroy(pthread_condattr_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024754. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_condattr_destroy_00028400)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_condattr_init(pthread_condattr_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024760. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_condattr_init_00028408)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_create(pthread_t *param_1,pthread_attr_t *param_2,void **param_3,void *param_4)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002476c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_create_00028410)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _pthread_get_stackaddr_np(pthread_t param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024778. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__pthread_get_stackaddr_np_00028418)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t _pthread_get_stacksize_np(pthread_t param_1)

{
  size_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024784. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__pthread_get_stacksize_np_00028420)();
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_getname_np(pthread_t param_1,char *param_2,size_t param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024790. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_getname_np_00028428)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _pthread_getspecific(pthread_key_t param_1)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002479c. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__pthread_getspecific_00028430)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_key_create(pthread_key_t *param_1,void *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247a8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_key_create_00028438)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_key_delete(pthread_key_t param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247b4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_key_delete_00028440)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

mach_port_t _pthread_mach_thread_np(pthread_t param_1)

{
  mach_port_t mVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247c0. Too many branches
                    // WARNING: Treating indirect jump as call
  mVar1 = (*(code *)PTR__pthread_mach_thread_np_00028448)((int)param_1);
  return mVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_destroy(pthread_mutex_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247cc. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_destroy_00028450)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_init(pthread_mutex_t *param_1,pthread_mutexattr_t *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247d8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_init_00028458)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_lock(pthread_mutex_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247e4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_lock_00028460)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_trylock(pthread_mutex_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247f0. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_trylock_00028468)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutex_unlock(pthread_mutex_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000247fc. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutex_unlock_00028470)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutexattr_init(pthread_mutexattr_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024808. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutexattr_init_00028478)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_mutexattr_settype(pthread_mutexattr_t *param_1,int param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024814. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_mutexattr_settype_00028480)((int)param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlock_destroy(pthread_rwlock_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024820. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlock_destroy_00028488)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlock_init(pthread_rwlock_t *param_1,pthread_rwlockattr_t *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002482c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlock_init_00028490)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlock_rdlock(pthread_rwlock_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024838. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlock_rdlock_00028498)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlock_tryrdlock(pthread_rwlock_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024844. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlock_tryrdlock_000284a0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlock_trywrlock(pthread_rwlock_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024850. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlock_trywrlock_000284a8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlock_unlock(pthread_rwlock_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002485c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlock_unlock_000284b0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlock_wrlock(pthread_rwlock_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024868. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlock_wrlock_000284b8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_rwlockattr_init(pthread_rwlockattr_t *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024874. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_rwlockattr_init_000284c0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

pthread_t _pthread_self(void)

{
  pthread_t p_Var1;
  
                    // WARNING: Could not recover jumptable at 0x00024880. Too many branches
                    // WARNING: Treating indirect jump as call
  p_Var1 = (pthread_t)(*(code *)PTR__pthread_self_000284c8)();
  return p_Var1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_setname_np(char *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002488c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_setname_np_000284d0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_setschedparam(pthread_t param_1,int param_2,sched_param *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024898. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_setschedparam_000284d8)((int)param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _pthread_setspecific(pthread_key_t param_1,void *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248a4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__pthread_setspecific_000284e0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _raise(int param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248b0. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__raise_000284e8)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _read(int param_1,void *param_2,size_t param_3)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248bc. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__read_000284f0)(param_1);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * _realloc(void *param_1,size_t param_2)

{
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248c8. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = (void *)(*(code *)PTR__realloc_000284f8)();
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _recv(int param_1,void *param_2,size_t param_3,int param_4)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248d4. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__recv_00028500)(param_1,param_2,param_3,param_4);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _recvfrom(int param_1,void *param_2,size_t param_3,int param_4,sockaddr *param_5,
                 socklen_t *param_6)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248e0. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__recvfrom_00028508)(param_1,param_2,param_3,param_4);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _rename(char *param_1,char *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248ec. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__rename_00028510)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _rmdir(char *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000248f8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__rmdir_00028518)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sched_get_priority_max(int param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024904. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sched_get_priority_max_00028520)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sched_get_priority_min(int param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024910. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sched_get_priority_min_00028528)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _send(int param_1,void *param_2,size_t param_3,int param_4)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002491c. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__send_00028530)(param_1,param_2,param_3,param_4);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _sendto(int param_1,void *param_2,size_t param_3,int param_4,sockaddr *param_5,
               socklen_t param_6)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024928. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__sendto_00028538)(param_1,param_2,param_3,param_4,param_5,param_6);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _setsockopt(int param_1,int param_2,int param_3,void *param_4,socklen_t param_5)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024934. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__setsockopt_00028540)(param_1,param_2,param_3,param_4,param_5);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sigaction(int param_1,sigaction *param_2,sigaction *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024940. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sigaction_00028548)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sigaltstack(stack_t *param_1,stack_t *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002494c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sigaltstack_00028550)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _snprintf(char *param_1,size_t param_2,char *param_3,...)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024958. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__snprintf_00028558)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _socket(int param_1,int param_2,int param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024964. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__socket_00028560)(param_1,param_2,param_3);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _stat(char *param_1,stat *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024970. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__stat_00028568)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * _strchr(char *param_1,int param_2)

{
  char *pcVar1;
  
                    // WARNING: Could not recover jumptable at 0x0002497c. Too many branches
                    // WARNING: Treating indirect jump as call
  pcVar1 = (char *)(*(code *)PTR__strchr_00028570)(param_1,param_2);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _strcmp(char *param_1,char *param_2)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024988. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__strcmp_00028578)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t _strlcpy(char *param_1,char *param_2,size_t param_3)

{
  size_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024994. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__strlcpy_00028580)();
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t _strlen(char *param_1)

{
  size_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249a0. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__strlen_00028588)();
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * _strncpy(char *param_1,char *param_2,size_t param_3)

{
  char *pcVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249ac. Too many branches
                    // WARNING: Treating indirect jump as call
  pcVar1 = (char *)(*(code *)PTR__strncpy_00028590)();
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * _strrchr(char *param_1,int param_2)

{
  char *pcVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249b8. Too many branches
                    // WARNING: Treating indirect jump as call
  pcVar1 = (char *)(*(code *)PTR__strrchr_00028598)(param_1,param_2);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * _strstr(char *param_1,char *param_2)

{
  char *pcVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249c4. Too many branches
                    // WARNING: Treating indirect jump as call
  pcVar1 = (char *)(*(code *)PTR__strstr_000285a0)();
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long _sysconf(int param_1)

{
  long lVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249d0. Too many branches
                    // WARNING: Treating indirect jump as call
  lVar1 = (*(code *)PTR__sysconf_000285a8)(param_1);
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sysctl(int *param_1,u_int param_2,void *param_3,size_t *param_4,void *param_5,size_t param_6)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249dc. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sysctl_000285b0)((int)param_1,param_2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sysctlbyname(char *param_1,void *param_2,size_t *param_3,void *param_4,size_t param_5)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249e8. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sysctlbyname_000285b8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _sysctlnametomib(char *param_1,int *param_2,size_t *param_3)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000249f4. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__sysctlnametomib_000285c0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t
_task_info(task_name_t target_task,task_flavor_t flavor,task_info_t task_info_out,
          mach_msg_type_number_t *task_info_outCnt)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a00. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__task_info_000285c8)(target_task,flavor);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t
_task_threads(task_t target_task,thread_act_array_t *act_list,mach_msg_type_number_t *act_listCnt)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a0c. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__task_threads_000285d0)(target_task);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t
_thread_get_state(thread_act_t target_act,thread_state_flavor_t flavor,thread_state_t old_state,
                 mach_msg_type_number_t *old_stateCnt)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a18. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__thread_get_state_000285d8)(target_act,flavor);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t
_thread_info(thread_act_t target_act,thread_flavor_t flavor,thread_info_t thread_info_out,
            mach_msg_type_number_t *thread_info_outCnt)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a24. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__thread_info_000285e0)(target_act,flavor);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

time_t _time(time_t *param_1)

{
  time_t tVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a30. Too many branches
                    // WARNING: Treating indirect jump as call
  tVar1 = (*(code *)PTR__time_000285e8)();
  return tVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _uname(utsname *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a3c. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__uname_000285f0)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _unlink(char *param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a48. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__unlink_000285f8)((int)param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int _usleep(useconds_t param_1)

{
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a54. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = (*(code *)PTR__usleep_00028600)(param_1);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t _vm_deallocate(vm_map_t target_task,vm_address_t address,vm_size_t size)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a60. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__vm_deallocate_00028608)(target_task);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t
_vm_protect(vm_map_t target_task,vm_address_t address,vm_size_t size,boolean_t set_maximum,
           vm_prot_t new_protection)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a6c. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__vm_protect_00028610)(target_task,address,size,set_maximum,new_protection);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t
_vm_read(vm_map_t target_task,vm_address_t address,vm_size_t size,vm_offset_t *data,
        mach_msg_type_number_t *dataCnt)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a78. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__vm_read_00028618)(target_task);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

kern_return_t
_vm_region_recurse_64
          (vm_map_t target_task,vm_address_t *address,vm_size_t *size,natural_t *nesting_depth,
          vm_region_recurse_info_t info,mach_msg_type_number_t *infoCnt)

{
  kern_return_t kVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a84. Too many branches
                    // WARNING: Treating indirect jump as call
  kVar1 = (*(code *)PTR__vm_region_recurse_64_00028620)(target_task);
  return kVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t _write(int param_1,void *param_2,size_t param_3)

{
  ssize_t sVar1;
  
                    // WARNING: Could not recover jumptable at 0x00024a90. Too many branches
                    // WARNING: Treating indirect jump as call
  sVar1 = (*(code *)PTR__write_00028628)(param_1);
  return sVar1;
}


