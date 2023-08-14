package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
final class zzlf<T> implements zzln<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzml.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkq zzm;
    private final zzmb<?, ?> zzn;
    private final zzjk<?> zzo;
    private final zzlh zzp;
    private final zzkx zzq;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.measurement.zzlc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.google.android.gms.internal.measurement.zzlh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.measurement.zzkx} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.measurement.zzjk, com.google.android.gms.internal.measurement.zzjk<?>] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v8, types: [int] */
    /* JADX WARNING: type inference failed for: r3v11, types: [com.google.android.gms.internal.measurement.zzkq] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.measurement.zzmb<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzlf(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.measurement.zzlc r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.measurement.zzlh r17, com.google.android.gms.internal.measurement.zzkq r18, com.google.android.gms.internal.measurement.zzmb<?, ?> r19, com.google.android.gms.internal.measurement.zzjk<?> r20, com.google.android.gms.internal.measurement.zzkx r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            r3 = r11
            r0.zzi = r3
            r3 = 0
            if (r2 == 0) goto L_0x0020
            boolean r4 = r2.zzc(r10)
            if (r4 == 0) goto L_0x0020
            r3 = 1
        L_0x0020:
            r0.zzh = r3
            r3 = r13
            r0.zzj = r3
            r3 = r14
            r0.zzk = r3
            r3 = r15
            r0.zzl = r3
            r3 = r16
            r0.zzp = r3
            r3 = r17
            r0.zzm = r3
            r3 = r18
            r0.zzn = r3
            r0.zzo = r2
            r0.zzg = r1
            r1 = r20
            r0.zzq = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.measurement.zzlc, boolean, boolean, int[], int, int, com.google.android.gms.internal.measurement.zzlh, com.google.android.gms.internal.measurement.zzkq, com.google.android.gms.internal.measurement.zzmb, com.google.android.gms.internal.measurement.zzjk, com.google.android.gms.internal.measurement.zzkx, byte[]):void");
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzC(T t, long j) {
        return ((Long) zzml.zzf(t, j)).longValue();
    }

    private final zzkb zzD(int i) {
        int i2 = i / 3;
        return (zzkb) this.zzd[i2 + i2 + 1];
    }

    private final zzln zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzln zzln = (zzln) this.zzd[i3];
        if (zzln != null) {
            return zzln;
        }
        zzln zzb2 = zzlk.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzH(T t, T t2, int i) {
        long zzB = (long) (zzB(i) & 1048575);
        if (zzM(t2, i)) {
            Object zzf2 = zzml.zzf(t, zzB);
            Object zzf3 = zzml.zzf(t2, zzB);
            if (zzf2 != null && zzf3 != null) {
                zzml.zzs(t, zzB, zzkf.zzg(zzf2, zzf3));
                zzJ(t, i);
            } else if (zzf3 != null) {
                zzml.zzs(t, zzB, zzf3);
                zzJ(t, i);
            }
        }
    }

    private final void zzI(T t, T t2, int i) {
        int zzB = zzB(i);
        int i2 = this.zzc[i];
        long j = (long) (zzB & 1048575);
        if (zzP(t2, i2, i)) {
            Object zzf2 = zzP(t, i2, i) ? zzml.zzf(t, j) : null;
            Object zzf3 = zzml.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzml.zzs(t, j, zzkf.zzg(zzf2, zzf3));
                zzK(t, i2, i);
            } else if (zzf3 != null) {
                zzml.zzs(t, j, zzf3);
                zzK(t, i2, i);
            }
        }
    }

    private final void zzJ(T t, int i) {
        int zzy = zzy(i);
        long j = (long) (1048575 & zzy);
        if (j != 1048575) {
            zzml.zzq(t, j, (1 << (zzy >>> 20)) | zzml.zzc(t, j));
        }
    }

    private final void zzK(T t, int i, int i2) {
        zzml.zzq(t, (long) (zzy(i2) & 1048575), i);
    }

    private final boolean zzL(T t, T t2, int i) {
        return zzM(t, i) == zzM(t2, i);
    }

    private final boolean zzM(T t, int i) {
        int zzy = zzy(i);
        long j = (long) (zzy & 1048575);
        if (j != 1048575) {
            return (zzml.zzc(t, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i);
        long j2 = (long) (zzB & 1048575);
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzml.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzml.zzb(t, j2)) != 0;
            case 2:
                return zzml.zzd(t, j2) != 0;
            case 3:
                return zzml.zzd(t, j2) != 0;
            case 4:
                return zzml.zzc(t, j2) != 0;
            case 5:
                return zzml.zzd(t, j2) != 0;
            case 6:
                return zzml.zzc(t, j2) != 0;
            case 7:
                return zzml.zzw(t, j2);
            case 8:
                Object zzf2 = zzml.zzf(t, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzix) {
                    return !zzix.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzml.zzf(t, j2) != null;
            case 10:
                return !zzix.zzb.equals(zzml.zzf(t, j2));
            case 11:
                return zzml.zzc(t, j2) != 0;
            case 12:
                return zzml.zzc(t, j2) != 0;
            case 13:
                return zzml.zzc(t, j2) != 0;
            case 14:
                return zzml.zzd(t, j2) != 0;
            case 15:
                return zzml.zzc(t, j2) != 0;
            case 16:
                return zzml.zzd(t, j2) != 0;
            case 17:
                return zzml.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzN(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzM(t, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzO(Object obj, int i, zzln zzln) {
        return zzln.zzj(zzml.zzf(obj, (long) (i & 1048575)));
    }

    private final boolean zzP(T t, int i, int i2) {
        return zzml.zzc(t, (long) (zzy(i2) & 1048575)) == i;
    }

    private static <T> boolean zzQ(T t, long j) {
        return ((Boolean) zzml.zzf(t, j)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044e, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029d, code lost:
        r12 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzR(T r17, com.google.android.gms.internal.measurement.zzjf r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045f
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0455
            int r10 = r0.zzB(r7)
            int[] r11 = r0.zzc
            r11 = r11[r7]
            int r12 = zzA(r10)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x003d
            int[] r13 = r0.zzc
            int r15 = r7 + 2
            r13 = r13[r15]
            r15 = r13 & r5
            if (r15 == r9) goto L_0x0038
            long r8 = (long) r15
            int r8 = r4.getInt(r1, r8)
            r9 = r15
        L_0x0038:
            int r13 = r13 >>> 20
            int r13 = r14 << r13
            goto L_0x003e
        L_0x003d:
            r13 = 0
        L_0x003e:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r12) {
                case 0: goto L_0x0442;
                case 1: goto L_0x0435;
                case 2: goto L_0x0428;
                case 3: goto L_0x041b;
                case 4: goto L_0x040e;
                case 5: goto L_0x0401;
                case 6: goto L_0x03f4;
                case 7: goto L_0x03e7;
                case 8: goto L_0x03d9;
                case 9: goto L_0x03c7;
                case 10: goto L_0x03b7;
                case 11: goto L_0x03a9;
                case 12: goto L_0x039b;
                case 13: goto L_0x038d;
                case 14: goto L_0x037f;
                case 15: goto L_0x0371;
                case 16: goto L_0x0363;
                case 17: goto L_0x0351;
                case 18: goto L_0x0341;
                case 19: goto L_0x0331;
                case 20: goto L_0x0321;
                case 21: goto L_0x0311;
                case 22: goto L_0x0301;
                case 23: goto L_0x02f1;
                case 24: goto L_0x02e1;
                case 25: goto L_0x02d1;
                case 26: goto L_0x02c2;
                case 27: goto L_0x02af;
                case 28: goto L_0x02a0;
                case 29: goto L_0x028f;
                case 30: goto L_0x0280;
                case 31: goto L_0x0271;
                case 32: goto L_0x0262;
                case 33: goto L_0x0253;
                case 34: goto L_0x0244;
                case 35: goto L_0x0235;
                case 36: goto L_0x0226;
                case 37: goto L_0x0217;
                case 38: goto L_0x0208;
                case 39: goto L_0x01f9;
                case 40: goto L_0x01ea;
                case 41: goto L_0x01db;
                case 42: goto L_0x01cc;
                case 43: goto L_0x01bd;
                case 44: goto L_0x01ae;
                case 45: goto L_0x019f;
                case 46: goto L_0x0190;
                case 47: goto L_0x0181;
                case 48: goto L_0x0172;
                case 49: goto L_0x015f;
                case 50: goto L_0x0156;
                case 51: goto L_0x0147;
                case 52: goto L_0x0138;
                case 53: goto L_0x0129;
                case 54: goto L_0x011a;
                case 55: goto L_0x010b;
                case 56: goto L_0x00fc;
                case 57: goto L_0x00ed;
                case 58: goto L_0x00de;
                case 59: goto L_0x00cf;
                case 60: goto L_0x00bc;
                case 61: goto L_0x00ac;
                case 62: goto L_0x009e;
                case 63: goto L_0x0090;
                case 64: goto L_0x0082;
                case 65: goto L_0x0074;
                case 66: goto L_0x0066;
                case 67: goto L_0x0058;
                case 68: goto L_0x0046;
                default: goto L_0x0043;
            }
        L_0x0043:
            r12 = 0
            goto L_0x044e
        L_0x0046:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzq(r11, r5, r6)
            goto L_0x0043
        L_0x0058:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzC(r1, r5)
            r2.zzC(r11, r5)
            goto L_0x0043
        L_0x0066:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzr(r1, r5)
            r2.zzA(r11, r5)
            goto L_0x0043
        L_0x0074:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzC(r1, r5)
            r2.zzy(r11, r5)
            goto L_0x0043
        L_0x0082:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzr(r1, r5)
            r2.zzw(r11, r5)
            goto L_0x0043
        L_0x0090:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzr(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x0043
        L_0x009e:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzr(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x0043
        L_0x00ac:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzix r5 = (com.google.android.gms.internal.measurement.zzix) r5
            r2.zzd(r11, r5)
            goto L_0x0043
        L_0x00bc:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzv(r11, r5, r6)
            goto L_0x0043
        L_0x00cf:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r11, r5, r2)
            goto L_0x0043
        L_0x00de:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            boolean r5 = zzQ(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x0043
        L_0x00ed:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzr(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x0043
        L_0x00fc:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzC(r1, r5)
            r2.zzm(r11, r5)
            goto L_0x0043
        L_0x010b:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzr(r1, r5)
            r2.zzr(r11, r5)
            goto L_0x0043
        L_0x011a:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzC(r1, r5)
            r2.zzJ(r11, r5)
            goto L_0x0043
        L_0x0129:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzC(r1, r5)
            r2.zzt(r11, r5)
            goto L_0x0043
        L_0x0138:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            float r5 = zzo(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x0043
        L_0x0147:
            boolean r10 = r0.zzP(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            double r5 = zzn(r1, r5)
            r2.zzf(r11, r5)
            goto L_0x0043
        L_0x0156:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzS(r2, r11, r5, r7)
            goto L_0x0043
        L_0x015f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlp.zzQ(r10, r5, r2, r6)
            goto L_0x0043
        L_0x0172:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzX(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0181:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzW(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0190:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzV(r10, r5, r2, r14)
            goto L_0x0043
        L_0x019f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzU(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ae:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzM(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01bd:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzZ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01cc:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzJ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01db:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzN(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ea:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzO(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01f9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzR(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0208:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzaa(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0217:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzS(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0226:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzP(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0235:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzL(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0244:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.measurement.zzlp.zzX(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0253:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzW(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0262:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzV(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0271:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzU(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0280:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzM(r10, r5, r2, r11)
            goto L_0x029d
        L_0x028f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzZ(r10, r5, r2, r11)
        L_0x029d:
            r12 = r11
            goto L_0x044e
        L_0x02a0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzK(r10, r5, r2)
            goto L_0x0043
        L_0x02af:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlp.zzT(r10, r5, r2, r6)
            goto L_0x0043
        L_0x02c2:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzY(r10, r5, r2)
            goto L_0x0043
        L_0x02d1:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.android.gms.internal.measurement.zzlp.zzJ(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02e1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzN(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02f1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzO(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0301:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzR(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0311:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzaa(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0321:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzS(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0331:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzP(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0341:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzL(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0351:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzq(r11, r5, r6)
            goto L_0x044e
        L_0x0363:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzC(r11, r5)
            goto L_0x044e
        L_0x0371:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzA(r11, r5)
            goto L_0x044e
        L_0x037f:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzy(r11, r5)
            goto L_0x044e
        L_0x038d:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzw(r11, r5)
            goto L_0x044e
        L_0x039b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x044e
        L_0x03a9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x044e
        L_0x03b7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzix r5 = (com.google.android.gms.internal.measurement.zzix) r5
            r2.zzd(r11, r5)
            goto L_0x044e
        L_0x03c7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzv(r11, r5, r6)
            goto L_0x044e
        L_0x03d9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r11, r5, r2)
            goto L_0x044e
        L_0x03e7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            boolean r5 = com.google.android.gms.internal.measurement.zzml.zzw(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x044e
        L_0x03f4:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x044e
        L_0x0401:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzm(r11, r5)
            goto L_0x044e
        L_0x040e:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzr(r11, r5)
            goto L_0x044e
        L_0x041b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzJ(r11, r5)
            goto L_0x044e
        L_0x0428:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzt(r11, r5)
            goto L_0x044e
        L_0x0435:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            float r5 = com.google.android.gms.internal.measurement.zzml.zzb(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x044e
        L_0x0442:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            double r5 = com.google.android.gms.internal.measurement.zzml.zza(r1, r5)
            r2.zzf(r11, r5)
        L_0x044e:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0455:
            com.google.android.gms.internal.measurement.zzmb<?, ?> r3 = r0.zzn
            java.lang.Object r1 = r3.zzc(r1)
            r3.zzi(r1, r2)
            return
        L_0x045f:
            com.google.android.gms.internal.measurement.zzjk<?> r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzR(java.lang.Object, com.google.android.gms.internal.measurement.zzjf):void");
    }

    private final <K, V> void zzS(zzjf zzjf, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzkv zzkv = (zzkv) zzF(i2);
            throw null;
        }
    }

    private static final void zzT(int i, Object obj, zzjf zzjf) throws IOException {
        if (obj instanceof String) {
            zzjf.zzF(i, (String) obj);
        } else {
            zzjf.zzd(i, (zzix) obj);
        }
    }

    static zzmc zzd(Object obj) {
        zzjx zzjx = (zzjx) obj;
        zzmc zzmc = zzjx.zzc;
        if (zzmc != zzmc.zzc()) {
            return zzmc;
        }
        zzmc zze2 = zzmc.zze();
        zzjx.zzc = zze2;
        return zze2;
    }

    static <T> zzlf<T> zzk(Class<T> cls, zzkz zzkz, zzlh zzlh, zzkq zzkq, zzmb<?, ?> zzmb, zzjk<?> zzjk, zzkx zzkx) {
        if (zzkz instanceof zzlm) {
            return zzl((zzlm) zzkz, zzlh, zzkq, zzmb, zzjk, zzkx);
        }
        zzly zzly = (zzly) zzkz;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0379  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzlf<T> zzl(com.google.android.gms.internal.measurement.zzlm r34, com.google.android.gms.internal.measurement.zzlh r35, com.google.android.gms.internal.measurement.zzkq r36, com.google.android.gms.internal.measurement.zzmb<?, ?> r37, com.google.android.gms.internal.measurement.zzjk<?> r38, com.google.android.gms.internal.measurement.zzkx r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r1
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r1
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.measurement.zzlc r18 = r34.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0194:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a6
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0194
        L_0x01a6:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ae
        L_0x01ac:
            r2 = r24
        L_0x01ae:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01db
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d5
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bc
        L_0x01d5:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r3
            r3 = r24
        L_0x01df:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x0296
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0223
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzG(r1, r12)
            r17[r3] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r3 = r3 + 1
            r8 = r17[r3]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzG(r1, r8)
            r17[r3] = r8
        L_0x0284:
            r3 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r8 = r1
            r0 = r7
            r29 = r11
            r25 = 1
            r7 = r3
            r3 = 0
            goto L_0x0391
        L_0x0296:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzG(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030e
            r12 = 17
            if (r5 != r12) goto L_0x02ae
            goto L_0x030e
        L_0x02ae:
            r12 = 27
            if (r5 == r12) goto L_0x02fe
            r12 = 49
            if (r5 != r12) goto L_0x02b7
            goto L_0x02fe
        L_0x02b7:
            r12 = 12
            if (r5 == r12) goto L_0x02ee
            r12 = 30
            if (r5 == r12) goto L_0x02ee
            r12 = 44
            if (r5 != r12) goto L_0x02c4
            goto L_0x02ee
        L_0x02c4:
            r12 = 50
            if (r5 != r12) goto L_0x02e4
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e7
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e4:
            r25 = 1
            goto L_0x031b
        L_0x02e7:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031c
        L_0x02ee:
            if (r10 != 0) goto L_0x02e4
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030b
        L_0x02fe:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030b:
            r12 = r27
            goto L_0x031c
        L_0x030e:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031b:
            r12 = r7
        L_0x031c:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x0379
            r8 = 17
            if (r5 > r8) goto L_0x0379
            int r8 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0355
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033f:
            int r27 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0351
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r26
            r3 = r3 | r8
            int r26 = r26 + 13
            r8 = r27
            goto L_0x033f
        L_0x0351:
            int r8 = r8 << r26
            r3 = r3 | r8
            goto L_0x0357
        L_0x0355:
            r27 = r8
        L_0x0357:
            int r8 = r6 + r6
            int r26 = r3 / 32
            int r8 = r8 + r26
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0368
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x0370
        L_0x0368:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzG(r1, r11)
            r17[r8] = r11
        L_0x0370:
            r8 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r0 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0379:
            r30 = r0
            r8 = r1
            r0 = r27
            r27 = r3
            r3 = 0
        L_0x0381:
            r1 = 18
            if (r5 < r1) goto L_0x038f
            r1 = 49
            if (r5 > r1) goto L_0x038f
            int r1 = r23 + 1
            r13[r23] = r7
            r23 = r1
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r1 = r9 + 1
            r31[r9] = r4
            int r4 = r1 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r7
            r31[r1] = r2
            int r9 = r4 + 1
            int r1 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r8
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.measurement.zzlf r0 = new com.google.android.gms.internal.measurement.zzlf
            r4 = r0
            com.google.android.gms.internal.measurement.zzlc r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzl(com.google.android.gms.internal.measurement.zzlm, com.google.android.gms.internal.measurement.zzlh, com.google.android.gms.internal.measurement.zzkq, com.google.android.gms.internal.measurement.zzmb, com.google.android.gms.internal.measurement.zzjk, com.google.android.gms.internal.measurement.zzkx):com.google.android.gms.internal.measurement.zzlf");
    }

    private static <T> double zzn(T t, long j) {
        return ((Double) zzml.zzf(t, j)).doubleValue();
    }

    private static <T> float zzo(T t, long j) {
        return ((Float) zzml.zzf(t, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0302, code lost:
        r8 = r8 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0469, code lost:
        r8 = r8 + (r9 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04b3, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04de, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04df, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0506, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0513, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0521, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0525, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 0
            r6 = r1
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x000a:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x0529
            int r7 = r14.zzB(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzA(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0035
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r1
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0036
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0036
        L_0x0035:
            r10 = r2
        L_0x0036:
            r7 = r7 & r1
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f4;
                case 3: goto L_0x04e1;
                case 4: goto L_0x04cc;
                case 5: goto L_0x04c1;
                case 6: goto L_0x04b6;
                case 7: goto L_0x04a9;
                case 8: goto L_0x047f;
                case 9: goto L_0x046d;
                case 10: goto L_0x0451;
                case 11: goto L_0x043d;
                case 12: goto L_0x0429;
                case 13: goto L_0x041d;
                case 14: goto L_0x0411;
                case 15: goto L_0x03f8;
                case 16: goto L_0x03e0;
                case 17: goto L_0x03cd;
                case 18: goto L_0x03c0;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03aa;
                case 21: goto L_0x039f;
                case 22: goto L_0x0394;
                case 23: goto L_0x0389;
                case 24: goto L_0x037e;
                case 25: goto L_0x0373;
                case 26: goto L_0x0368;
                case 27: goto L_0x0359;
                case 28: goto L_0x034d;
                case 29: goto L_0x0341;
                case 30: goto L_0x0335;
                case 31: goto L_0x0329;
                case 32: goto L_0x031d;
                case 33: goto L_0x0311;
                case 34: goto L_0x0305;
                case 35: goto L_0x02ee;
                case 36: goto L_0x02d9;
                case 37: goto L_0x02c4;
                case 38: goto L_0x02af;
                case 39: goto L_0x029a;
                case 40: goto L_0x0285;
                case 41: goto L_0x026f;
                case 42: goto L_0x0259;
                case 43: goto L_0x0243;
                case 44: goto L_0x022d;
                case 45: goto L_0x0217;
                case 46: goto L_0x0201;
                case 47: goto L_0x01eb;
                case 48: goto L_0x01d5;
                case 49: goto L_0x01c5;
                case 50: goto L_0x01b8;
                case 51: goto L_0x01aa;
                case 52: goto L_0x019c;
                case 53: goto L_0x0186;
                case 54: goto L_0x0170;
                case 55: goto L_0x015a;
                case 56: goto L_0x014c;
                case 57: goto L_0x013e;
                case 58: goto L_0x0130;
                case 59: goto L_0x0102;
                case 60: goto L_0x00ee;
                case 61: goto L_0x00d2;
                case 62: goto L_0x00bc;
                case 63: goto L_0x00a6;
                case 64: goto L_0x0098;
                case 65: goto L_0x008a;
                case 66: goto L_0x006f;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0525
        L_0x003f:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzlc r7 = (com.google.android.gms.internal.measurement.zzlc) r7
            com.google.android.gms.internal.measurement.zzln r9 = r14.zzE(r3)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzu(r8, r7, r9)
            goto L_0x03ca
        L_0x0055:
            boolean r9 = r14.zzP(r15, r8, r3)
            if (r9 == 0) goto L_0x0525
            long r9 = zzC(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.measurement.zzje.zzB(r9)
            goto L_0x04de
        L_0x006f:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzr(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x04de
        L_0x008a:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0521
        L_0x0098:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0513
        L_0x00a6:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzr(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzv(r7)
            goto L_0x04de
        L_0x00bc:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzr(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x04de
        L_0x00d2:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzix r7 = (com.google.android.gms.internal.measurement.zzix) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0469
        L_0x00ee:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzln r9 = r14.zzE(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x0102:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.measurement.zzix
            if (r9 == 0) goto L_0x0122
            com.google.android.gms.internal.measurement.zzix r7 = (com.google.android.gms.internal.measurement.zzix) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0469
        L_0x0122:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzy(r7)
            goto L_0x04de
        L_0x0130:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x04b3
        L_0x013e:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0513
        L_0x014c:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0521
        L_0x015a:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzr(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzv(r7)
            goto L_0x04de
        L_0x0170:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzC(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            int r8 = com.google.android.gms.internal.measurement.zzje.zzB(r9)
            goto L_0x0506
        L_0x0186:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzC(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            int r8 = com.google.android.gms.internal.measurement.zzje.zzB(r9)
            goto L_0x0506
        L_0x019c:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0513
        L_0x01aa:
            boolean r7 = r14.zzP(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0521
        L_0x01b8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzF(r3)
            com.google.android.gms.internal.measurement.zzkx.zza(r8, r7, r9)
            goto L_0x0525
        L_0x01c5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzln r9 = r14.zzE(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzj(r8, r7, r9)
            goto L_0x03ca
        L_0x01d5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzt(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x01eb:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x0201:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x0217:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x022d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zze(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x0243:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzw(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x0259:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzb(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x026f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x0285:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x029a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzl(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x02af:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzy(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x02c4:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzn(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x02d9:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0302
        L_0x02ee:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzje.zzz(r8)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
        L_0x0302:
            int r8 = r8 + r9
            goto L_0x04de
        L_0x0305:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzs(r8, r7, r2)
            goto L_0x03ca
        L_0x0311:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzq(r8, r7, r2)
            goto L_0x03ca
        L_0x031d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzh(r8, r7, r2)
            goto L_0x03ca
        L_0x0329:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x0335:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzd(r8, r7, r2)
            goto L_0x03ca
        L_0x0341:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzv(r8, r7, r2)
            goto L_0x03ca
        L_0x034d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzc(r8, r7)
            goto L_0x03ca
        L_0x0359:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzln r9 = r14.zzE(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzp(r8, r7, r9)
            goto L_0x03ca
        L_0x0368:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzu(r8, r7)
            goto L_0x03ca
        L_0x0373:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zza(r8, r7, r2)
            goto L_0x03ca
        L_0x037e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x0389:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzh(r8, r7, r2)
            goto L_0x03ca
        L_0x0394:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzk(r8, r7, r2)
            goto L_0x03ca
        L_0x039f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzx(r8, r7, r2)
            goto L_0x03ca
        L_0x03aa:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzm(r8, r7, r2)
            goto L_0x03ca
        L_0x03b5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x03c0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzh(r8, r7, r2)
        L_0x03ca:
            int r4 = r4 + r7
            goto L_0x0525
        L_0x03cd:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzlc r7 = (com.google.android.gms.internal.measurement.zzlc) r7
            com.google.android.gms.internal.measurement.zzln r9 = r14.zzE(r3)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzu(r8, r7, r9)
            goto L_0x03ca
        L_0x03e0:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.measurement.zzje.zzB(r9)
            goto L_0x04de
        L_0x03f8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x04de
        L_0x0411:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0521
        L_0x041d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0513
        L_0x0429:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzv(r7)
            goto L_0x04de
        L_0x043d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x04de
        L_0x0451:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzix r7 = (com.google.android.gms.internal.measurement.zzix) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
        L_0x0469:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04df
        L_0x046d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzln r9 = r14.zzE(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlp.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x047f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.measurement.zzix
            if (r9 == 0) goto L_0x049c
            com.google.android.gms.internal.measurement.zzix r7 = (com.google.android.gms.internal.measurement.zzix) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0469
        L_0x049c:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzy(r7)
            goto L_0x04de
        L_0x04a9:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
        L_0x04b3:
            int r7 = r7 + r11
            goto L_0x03ca
        L_0x04b6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0513
        L_0x04c1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            goto L_0x0521
        L_0x04cc:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzje.zzA(r8)
            int r7 = com.google.android.gms.internal.measurement.zzje.zzv(r7)
        L_0x04de:
            int r8 = r8 + r7
        L_0x04df:
            int r4 = r4 + r8
            goto L_0x0525
        L_0x04e1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            int r8 = com.google.android.gms.internal.measurement.zzje.zzB(r9)
            goto L_0x0506
        L_0x04f4:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
            int r8 = com.google.android.gms.internal.measurement.zzje.zzB(r9)
        L_0x0506:
            int r7 = r7 + r8
            goto L_0x03ca
        L_0x0509:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
        L_0x0513:
            int r7 = r7 + 4
            goto L_0x03ca
        L_0x0517:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzje.zzA(r7)
        L_0x0521:
            int r7 = r7 + 8
            goto L_0x03ca
        L_0x0525:
            int r3 = r3 + 3
            goto L_0x000a
        L_0x0529:
            com.google.android.gms.internal.measurement.zzmb<?, ?> r0 = r14.zzn
            java.lang.Object r1 = r0.zzc(r15)
            int r0 = r0.zza(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzh
            if (r0 != 0) goto L_0x0539
            return r4
        L_0x0539:
            com.google.android.gms.internal.measurement.zzjk<?> r0 = r14.zzo
            r0.zza(r15)
            r15 = 0
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzp(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzB(r2)
            int r5 = zzA(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzjp r4 = com.google.android.gms.internal.measurement.zzjp.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzjp r4 = com.google.android.gms.internal.measurement.zzjp.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlc r4 = (com.google.android.gms.internal.measurement.zzlc) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzP(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzC(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzix
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.lang.Object r5 = r11.zzF(r2)
            com.google.android.gms.internal.measurement.zzkx.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlc r4 = (com.google.android.gms.internal.measurement.zzlc) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzM(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.measurement.zzml.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzix
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzml.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzml.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.measurement.zzmb<?, ?> r0 = r11.zzn
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzq(java.lang.Object):int");
    }

    private static <T> int zzr(T t, long j) {
        return ((Integer) zzml.zzf(t, j)).intValue();
    }

    private final <K, V> int zzs(T t, byte[] bArr, int i, int i2, int i3, long j, zzik zzik) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i3);
        Object object = unsafe.getObject(t, j);
        if (!((zzkw) object).zze()) {
            zzkw zzb2 = zzkw.zza().zzb();
            zzkx.zzb(zzb2, object);
            unsafe.putObject(t, j, zzb2);
        }
        zzkv zzkv = (zzkv) zzF;
        throw null;
    }

    private final int zzt(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzik zzik) throws IOException {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzik zzik2 = zzik;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(Double.longBitsToDouble(zzil.zzn(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(Float.intBitsToFloat(zzil.zzb(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzil.zzm(bArr2, i9, zzik2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzik2.zzb));
                    unsafe.putInt(t2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzil.zzj(bArr2, i9, zzik2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzik2.zza));
                    unsafe.putInt(t2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzil.zzn(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzil.zzb(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzil.zzm(bArr2, i9, zzik2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzik2.zzb != 0));
                    unsafe.putInt(t2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzil.zzj(bArr2, i9, zzik2);
                    int i14 = zzik2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzmq.zzf(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zzj3, i14, zzkf.zzb));
                        zzj3 += i14;
                    } else {
                        throw zzkh.zzc();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd2 = zzil.zzd(zzE(i13), bArr2, i9, i2, zzik2);
                    Object object = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzik2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzkf.zzg(object, zzik2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzd2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzil.zza(bArr2, i9, zzik2);
                    unsafe.putObject(t2, j2, zzik2.zzc);
                    unsafe.putInt(t2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzil.zzj(bArr2, i9, zzik2);
                    int i15 = zzik2.zza;
                    zzkb zzD = zzD(i13);
                    if (zzD == null || zzD.zza(i15)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i15));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        zzd(t).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzil.zzj(bArr2, i9, zzik2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzja.zzb(zzik2.zza)));
                    unsafe.putInt(t2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzil.zzm(bArr2, i9, zzik2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzja.zzc(zzik2.zzb)));
                    unsafe.putInt(t2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc2 = zzil.zzc(zzE(i13), bArr, i, i2, (i10 & -8) | 4, zzik);
                    Object object2 = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzik2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzkf.zzg(object2, zzik2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzc2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a9, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02c1, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02f4, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0317, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f9, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fd, code lost:
        r1 = r20;
        r8 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0186, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r8 = r19;
        r1 = r20;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020a, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x020d, code lost:
        r2 = r4;
        r28 = r10;
        r19 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzu(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzik r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r7 = r8
            r1 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x0341
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.measurement.zzil.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzx(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzw(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r10) goto L_0x004d
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = r10
            r19 = r16
            goto L_0x031a
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzA(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x0216
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            if (r10 == r7) goto L_0x008f
            r23 = r1
            r20 = r2
            if (r7 == r13) goto L_0x0080
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0082
        L_0x0080:
            r7 = r19
        L_0x0082:
            if (r10 == r13) goto L_0x0089
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x0089:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0095
        L_0x008f:
            r23 = r1
            r20 = r2
            r10 = r19
        L_0x0095:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01f5;
                case 1: goto L_0x01df;
                case 2: goto L_0x01c2;
                case 3: goto L_0x01c2;
                case 4: goto L_0x01b0;
                case 5: goto L_0x0195;
                case 6: goto L_0x0173;
                case 7: goto L_0x0156;
                case 8: goto L_0x0136;
                case 9: goto L_0x0104;
                case 10: goto L_0x00e9;
                case 11: goto L_0x01b0;
                case 12: goto L_0x00d9;
                case 13: goto L_0x0173;
                case 14: goto L_0x0195;
                case 15: goto L_0x00c5;
                case 16: goto L_0x00a1;
                default: goto L_0x0099;
            }
        L_0x0099:
            r19 = r13
            r13 = r20
            r20 = r33
            goto L_0x020d
        L_0x00a1:
            if (r3 != 0) goto L_0x00bf
            int r17 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.measurement.zzja.zzc(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x00fd
        L_0x00bf:
            r13 = r20
            r20 = r33
            goto L_0x0131
        L_0x00c5:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0131
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzja.zzb(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x00f9
        L_0x00d9:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0131
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x00f9
        L_0x00e9:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0131
            int r0 = com.google.android.gms.internal.measurement.zzil.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
        L_0x00f9:
            r6 = r6 | r21
            r9 = r10
            r2 = r13
        L_0x00fd:
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x025e
        L_0x0104:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x012f
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.measurement.zzil.zzd(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0125
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x0125:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkf.zzg(r1, r3)
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x012f:
            r2 = r34
        L_0x0131:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x020d
        L_0x0136:
            r2 = r34
            r19 = r13
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x020d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x014c
            int r0 = com.google.android.gms.internal.measurement.zzil.zzg(r12, r4, r11)
            goto L_0x0150
        L_0x014c:
            int r0 = com.google.android.gms.internal.measurement.zzil.zzh(r12, r4, r11)
        L_0x0150:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x0156:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r5 = r16
        L_0x016f:
            com.google.android.gms.internal.measurement.zzml.zzm(r14, r8, r5)
            goto L_0x0186
        L_0x0173:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x020d
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x0186:
            r6 = r6 | r21
            r9 = r10
            r8 = r19
            r1 = r20
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0019
        L_0x0195:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x020d
            long r22 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x020a
        L_0x01b0:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x020a
        L_0x01c2:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r17 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x025a
        L_0x01df:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x020d
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzml.zzp(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x020a
        L_0x01f5:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x020d
            long r0 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzml.zzo(r14, r8, r0)
            int r0 = r4 + 8
        L_0x020a:
            r6 = r6 | r21
            goto L_0x0258
        L_0x020d:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x031a
        L_0x0216:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x0270
            r1 = 2
            if (r3 != r1) goto L_0x0263
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzke r0 = (com.google.android.gms.internal.measurement.zzke) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0244
            int r1 = r0.size()
            if (r1 != 0) goto L_0x023c
            r1 = 10
            goto L_0x023d
        L_0x023c:
            int r1 = r1 + r1
        L_0x023d:
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzd(r1)
            r10.putObject(r14, r8, r0)
        L_0x0244:
            r5 = r0
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzil.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0258:
            r9 = r10
            r2 = r13
        L_0x025a:
            r8 = r19
            r1 = r20
        L_0x025e:
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x0263:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02f7
        L_0x0270:
            r1 = 49
            if (r0 > r1) goto L_0x02c3
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = r19
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02c1
        L_0x02ab:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            goto L_0x033a
        L_0x02c1:
            r2 = r0
            goto L_0x02f8
        L_0x02c3:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02fd
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x02f7
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02c1
            goto L_0x02ab
        L_0x02f7:
            r2 = r15
        L_0x02f8:
            r6 = r24
            r7 = r25
            goto L_0x031a
        L_0x02fd:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02c1
            goto L_0x02ab
        L_0x031a:
            com.google.android.gms.internal.measurement.zzmc r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzil.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
        L_0x033a:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0341:
            r24 = r6
            r1 = r8
            r28 = r9
            if (r7 == r1) goto L_0x0352
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0352:
            r1 = r34
            if (r0 != r1) goto L_0x0357
            return r0
        L_0x0357:
            com.google.android.gms.internal.measurement.zzkh r0 = com.google.android.gms.internal.measurement.zzkh.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzik):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzv(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzik r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzke r12 = (com.google.android.gms.internal.measurement.zzke) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.measurement.zzke r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.measurement.zzln r1 = r15.zzE(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzil.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzja.zzc(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzja.zzc(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzja.zzc(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzja.zzb(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzja.zzb(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzja.zzb(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.measurement.zzil.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzil.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.measurement.zzjx r1 = (com.google.android.gms.internal.measurement.zzjx) r1
            com.google.android.gms.internal.measurement.zzmc r3 = r1.zzc
            com.google.android.gms.internal.measurement.zzmc r4 = com.google.android.gms.internal.measurement.zzmc.zzc()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.measurement.zzkb r4 = r15.zzD(r8)
            com.google.android.gms.internal.measurement.zzmb<?, ?> r5 = r0.zzn
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzlp.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.measurement.zzmc r3 = (com.google.android.gms.internal.measurement.zzmc) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.measurement.zzix r4 = com.google.android.gms.internal.measurement.zzix.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.measurement.zzix r6 = com.google.android.gms.internal.measurement.zzix.zzl(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.measurement.zzix r4 = com.google.android.gms.internal.measurement.zzix.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.measurement.zzix r6 = com.google.android.gms.internal.measurement.zzix.zzl(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.measurement.zzln r1 = r15.zzE(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.measurement.zzil.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkf.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkf.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzmq.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkf.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzmq.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkf.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzc()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzc()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.measurement.zzim r12 = (com.google.android.gms.internal.measurement.zzim) r12
            int r2 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            r5 = r13
            goto L_0x0275
        L_0x0274:
            r5 = r1
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzim r12 = (com.google.android.gms.internal.measurement.zzim) r12
            int r4 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = r13
            goto L_0x0294
        L_0x0293:
            r6 = r1
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r17, r18)
            r12.zzg(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r4)
            r12.zzg(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.measurement.zzil.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.measurement.zzil.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.measurement.zzjq r12 = (com.google.android.gms.internal.measurement.zzjq) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjq r12 = (com.google.android.gms.internal.measurement.zzjq) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.measurement.zzjg r12 = (com.google.android.gms.internal.measurement.zzjg) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjg r12 = (com.google.android.gms.internal.measurement.zzjg) r12
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzil.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzik):int");
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zza(T t) {
        return this.zzi ? zzq(t) : zzp(t);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzB(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzA(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzQ(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzo(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzml.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzml.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzml.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzmb<?, ?> r0 = r8.zzn
            java.lang.Object r0 = r0.zzc(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.measurement.zzjk<?> r0 = r8.zzo
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0330, code lost:
        if (r0 != r15) goto L_0x0332;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x034c, code lost:
        r7 = r33;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x037a, code lost:
        if (r0 != r15) goto L_0x0332;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x039c, code lost:
        if (r0 != r15) goto L_0x0332;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f6, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x022d, code lost:
        r5 = r6 | r23;
        r6 = r31;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0267, code lost:
        r5 = r6 | r23;
        r6 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x026b, code lost:
        r3 = r8;
        r1 = r11;
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0287, code lost:
        r7 = r33;
        r18 = r8;
        r26 = r10;
        r8 = r11;
        r25 = r19;
        r27 = r6;
        r6 = r31;
        r31 = r20;
        r20 = r27;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zzik r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            r17 = 0
            if (r0 >= r13) goto L_0x040d
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.google.android.gms.internal.measurement.zzil.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002e
        L_0x002d:
            r4 = r0
        L_0x002e:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r2) goto L_0x003b
            int r3 = r3 / r8
            int r2 = r15.zzx(r0, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzw(r0)
        L_0x003f:
            r3 = -1
            if (r2 != r3) goto L_0x0051
            r31 = r0
            r2 = r1
            r25 = r3
            r8 = r4
            r20 = r5
            r26 = r10
            r7 = r11
            r18 = r16
            goto L_0x039f
        L_0x0051:
            int[] r3 = r15.zzc
            int r20 = r2 + 1
            r3 = r3[r20]
            int r8 = zzA(r3)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r3 & r18
            r22 = r3
            r21 = r4
            long r3 = (long) r0
            r0 = 17
            if (r8 > r0) goto L_0x029a
            int[] r0 = r15.zzc
            int r23 = r2 + 2
            r0 = r0[r23]
            int r23 = r0 >>> 20
            r11 = 1
            int r23 = r11 << r23
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r11
            if (r0 == r6) goto L_0x0089
            if (r6 == r11) goto L_0x0082
            long r11 = (long) r6
            r10.putInt(r14, r11, r5)
        L_0x0082:
            long r5 = (long) r0
            int r5 = r10.getInt(r14, r5)
            r11 = r0
            goto L_0x008a
        L_0x0089:
            r11 = r6
        L_0x008a:
            r6 = r5
            r0 = 5
            switch(r8) {
                case 0: goto L_0x024d;
                case 1: goto L_0x0233;
                case 2: goto L_0x0210;
                case 3: goto L_0x0210;
                case 4: goto L_0x01f9;
                case 5: goto L_0x01d8;
                case 6: goto L_0x01c2;
                case 7: goto L_0x01a2;
                case 8: goto L_0x0180;
                case 9: goto L_0x0152;
                case 10: goto L_0x013b;
                case 11: goto L_0x01f9;
                case 12: goto L_0x0103;
                case 13: goto L_0x01c2;
                case 14: goto L_0x01d8;
                case 15: goto L_0x00e9;
                case 16: goto L_0x00bb;
                default: goto L_0x008f;
            }
        L_0x008f:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r0 = 3
            r19 = -1
            r2 = r1
            if (r7 != r0) goto L_0x0287
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r8)
            int r1 = r20 << 3
            r5 = r1 | 4
            r1 = r30
            r12 = r3
            r3 = r32
            r4 = r5
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzil.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x0271
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x027e
        L_0x00bb:
            if (r7 != 0) goto L_0x00de
            r12 = r30
            int r7 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r1, r9)
            long r0 = r9.zzb
            long r24 = com.google.android.gms.internal.measurement.zzja.zzc(r0)
            r8 = r20
            r0 = r10
            r1 = r29
            r5 = r2
            r19 = -1
            r2 = r3
            r31 = r11
            r11 = r21
            r8 = r5
            r4 = r24
            r0.putLong(r1, r2, r4)
            goto L_0x022d
        L_0x00de:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            goto L_0x01f6
        L_0x00e9:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            if (r7 != 0) goto L_0x01f6
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzja.zzb(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x0267
        L_0x0103:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            if (r7 != 0) goto L_0x01f6
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.measurement.zzkb r2 = r15.zzD(r8)
            if (r2 == 0) goto L_0x0136
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0121
            goto L_0x0136
        L_0x0121:
            com.google.android.gms.internal.measurement.zzmc r2 = zzd(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            r3 = r8
            r1 = r11
            r2 = r20
            r6 = r31
            goto L_0x02e9
        L_0x0136:
            r10.putInt(r14, r3, r1)
            goto L_0x0267
        L_0x013b:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r0 = 2
            r19 = -1
            if (r7 != r0) goto L_0x01f6
            int r0 = com.google.android.gms.internal.measurement.zzil.zza(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0267
        L_0x0152:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r0 = 2
            r19 = -1
            if (r7 != r0) goto L_0x01f6
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r8)
            int r0 = com.google.android.gms.internal.measurement.zzil.zzd(r0, r12, r1, r13, r9)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x0171
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0267
        L_0x0171:
            java.lang.Object r1 = r10.getObject(r14, r3)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkf.zzg(r1, r2)
            r10.putObject(r14, r3, r1)
            goto L_0x0267
        L_0x0180:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r0 = 2
            r19 = -1
            if (r7 != r0) goto L_0x01f6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r22 & r0
            if (r0 != 0) goto L_0x0197
            int r0 = com.google.android.gms.internal.measurement.zzil.zzg(r12, r1, r9)
            goto L_0x019b
        L_0x0197:
            int r0 = com.google.android.gms.internal.measurement.zzil.zzh(r12, r1, r9)
        L_0x019b:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0267
        L_0x01a2:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            if (r7 != 0) goto L_0x01f6
            int r0 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r1, r9)
            long r1 = r9.zzb
            r21 = 0
            int r1 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r1 == 0) goto L_0x01bb
            r1 = 1
            goto L_0x01bd
        L_0x01bb:
            r1 = r16
        L_0x01bd:
            com.google.android.gms.internal.measurement.zzml.zzm(r14, r3, r1)
            goto L_0x0267
        L_0x01c2:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            if (r7 != r0) goto L_0x01f6
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r1)
            r10.putInt(r14, r3, r0)
            int r0 = r1 + 4
            goto L_0x0267
        L_0x01d8:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r0 = 1
            r19 = -1
            if (r7 != r0) goto L_0x01f6
            long r21 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r1)
            r0 = r10
            r7 = r1
            r1 = r29
            r2 = r3
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0267
        L_0x01f6:
            r2 = r1
            goto L_0x0287
        L_0x01f9:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            r2 = r1
            if (r7 != 0) goto L_0x0287
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r2, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x0267
        L_0x0210:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            r2 = r1
            if (r7 != 0) goto L_0x0287
            int r7 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r2, r9)
            long r1 = r9.zzb
            r0 = r10
            r21 = r1
            r1 = r29
            r2 = r3
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x022d:
            r5 = r6 | r23
            r6 = r31
            r0 = r7
            goto L_0x026b
        L_0x0233:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            r2 = r1
            if (r7 != r0) goto L_0x0287
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzml.zzp(r14, r3, r0)
            int r0 = r2 + 4
            goto L_0x0267
        L_0x024d:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r21
            r0 = 1
            r19 = -1
            r2 = r1
            if (r7 != r0) goto L_0x0287
            long r0 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzml.zzo(r14, r3, r0)
            int r0 = r2 + 8
        L_0x0267:
            r5 = r6 | r23
            r6 = r31
        L_0x026b:
            r3 = r8
            r1 = r11
            r2 = r20
            goto L_0x02e9
        L_0x0271:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkf.zzg(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x027e:
            r5 = r6 | r23
            r12 = r30
            r6 = r31
            r13 = r32
            goto L_0x026b
        L_0x0287:
            r7 = r33
            r18 = r8
            r26 = r10
            r8 = r11
            r25 = r19
            r27 = r6
            r6 = r31
            r31 = r20
            r20 = r27
            goto L_0x039f
        L_0x029a:
            r12 = r3
            r3 = r8
            r4 = r20
            r11 = r21
            r19 = -1
            r8 = r2
            r2 = r1
            r0 = 27
            if (r3 != r0) goto L_0x02fe
            r0 = 2
            if (r7 != r0) goto L_0x02ed
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.measurement.zzke r0 = (com.google.android.gms.internal.measurement.zzke) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02c8
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02c0
            r1 = 10
            goto L_0x02c1
        L_0x02c0:
            int r1 = r1 + r1
        L_0x02c1:
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzd(r1)
            r10.putObject(r14, r12, r0)
        L_0x02c8:
            r7 = r0
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r8)
            r1 = r11
            r3 = r2
            r2 = r30
            r12 = r4
            r4 = r32
            r20 = r5
            r5 = r7
            r21 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzil.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r32
            r3 = r8
            r2 = r12
            r5 = r20
            r6 = r21
            r12 = r30
        L_0x02e9:
            r11 = r33
            goto L_0x001a
        L_0x02ed:
            r20 = r5
            r21 = r6
            r15 = r2
            r31 = r4
            r18 = r8
            r26 = r10
            r22 = r11
            r25 = r19
            goto L_0x037d
        L_0x02fe:
            r20 = r5
            r21 = r6
            r5 = r2
            r6 = r4
            r0 = 49
            if (r3 > r0) goto L_0x0350
            r4 = r22
            long r1 = (long) r4
            r0 = r28
            r22 = r1
            r1 = r29
            r2 = r30
            r24 = r3
            r3 = r5
            r4 = r32
            r15 = r5
            r5 = r11
            r31 = r6
            r18 = r8
            r25 = r19
            r19 = r24
            r26 = r10
            r9 = r22
            r22 = r11
            r11 = r19
            r14 = r34
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x034c
        L_0x0332:
            r15 = r28
            r14 = r29
            r12 = r30
            r2 = r31
            r13 = r32
            r11 = r33
            r9 = r34
            r3 = r18
            r5 = r20
            r6 = r21
            r1 = r22
            r10 = r26
            goto L_0x001a
        L_0x034c:
            r7 = r33
            r2 = r0
            goto L_0x0380
        L_0x0350:
            r15 = r5
            r31 = r6
            r18 = r8
            r26 = r10
            r25 = r19
            r4 = r22
            r19 = r3
            r22 = r11
            r0 = 50
            r9 = r19
            if (r9 != r0) goto L_0x0385
            r0 = 2
            if (r7 != r0) goto L_0x037d
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r18
            r6 = r12
            r8 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x034c
            goto L_0x0332
        L_0x037d:
            r7 = r33
            r2 = r15
        L_0x0380:
            r6 = r21
            r8 = r22
            goto L_0x039f
        L_0x0385:
            r0 = r28
            r1 = r29
            r2 = r30
            r8 = r4
            r3 = r15
            r4 = r32
            r5 = r22
            r6 = r31
            r10 = r12
            r12 = r18
            r13 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x034c
            goto L_0x0332
        L_0x039f:
            if (r8 != r7) goto L_0x03ad
            if (r7 == 0) goto L_0x03ad
            r9 = r28
            r12 = r29
            r0 = r2
            r1 = r8
            r5 = r20
            goto L_0x0416
        L_0x03ad:
            r9 = r28
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x03e6
            r10 = r34
            com.google.android.gms.internal.measurement.zzjj r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzjj r1 = com.google.android.gms.internal.measurement.zzjj.zza()
            if (r0 == r1) goto L_0x03e1
            com.google.android.gms.internal.measurement.zzlc r0 = r9.zzg
            com.google.android.gms.internal.measurement.zzjj r1 = r10.zzd
            r11 = r31
            com.google.android.gms.internal.measurement.zzjv r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x03db
            com.google.android.gms.internal.measurement.zzmc r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzil.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x03fb
        L_0x03db:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.measurement.zzju r0 = (com.google.android.gms.internal.measurement.zzju) r0
            throw r17
        L_0x03e1:
            r12 = r29
            r11 = r31
            goto L_0x03ec
        L_0x03e6:
            r12 = r29
            r11 = r31
            r10 = r34
        L_0x03ec:
            com.google.android.gms.internal.measurement.zzmc r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzil.zzi(r0, r1, r2, r3, r4, r5)
        L_0x03fb:
            r13 = r32
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r3 = r18
            r5 = r20
            r10 = r26
            r12 = r30
            r11 = r7
            goto L_0x001a
        L_0x040d:
            r20 = r5
            r21 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
        L_0x0416:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x0421
            long r3 = (long) r6
            r6 = r26
            r6.putInt(r12, r3, r5)
        L_0x0421:
            int r3 = r9.zzk
        L_0x0423:
            int r4 = r9.zzl
            if (r3 >= r4) goto L_0x044e
            int[] r4 = r9.zzj
            r4 = r4[r3]
            int[] r5 = r9.zzc
            r5 = r5[r4]
            int r5 = r9.zzB(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r5)
            if (r5 != 0) goto L_0x043c
            goto L_0x0442
        L_0x043c:
            com.google.android.gms.internal.measurement.zzkb r6 = r9.zzD(r4)
            if (r6 != 0) goto L_0x0445
        L_0x0442:
            int r3 = r3 + 1
            goto L_0x0423
        L_0x0445:
            com.google.android.gms.internal.measurement.zzkw r5 = (com.google.android.gms.internal.measurement.zzkw) r5
            java.lang.Object r0 = r9.zzF(r4)
            com.google.android.gms.internal.measurement.zzkv r0 = (com.google.android.gms.internal.measurement.zzkv) r0
            throw r17
        L_0x044e:
            if (r7 != 0) goto L_0x045a
            r2 = r32
            if (r0 != r2) goto L_0x0455
            goto L_0x0460
        L_0x0455:
            com.google.android.gms.internal.measurement.zzkh r0 = com.google.android.gms.internal.measurement.zzkh.zze()
            throw r0
        L_0x045a:
            r2 = r32
            if (r0 > r2) goto L_0x0461
            if (r1 != r7) goto L_0x0461
        L_0x0460:
            return r0
        L_0x0461:
            com.google.android.gms.internal.measurement.zzkh r0 = com.google.android.gms.internal.measurement.zzkh.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzik):int");
    }

    public final T zze() {
        return ((zzjx) this.zzg).zzl(4, (Object) null, (Object) null);
    }

    public final void zzf(T t) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long zzB = (long) (zzB(this.zzj[i2]) & 1048575);
            Object zzf2 = zzml.zzf(t, zzB);
            if (zzf2 != null) {
                ((zzkw) zzf2).zzc();
                zzml.zzs(t, zzB, zzf2);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(t, (long) this.zzj[i]);
            i++;
        }
        this.zzn.zzg(t);
        if (this.zzh) {
            this.zzo.zzb(t);
        }
    }

    public final void zzh(T t, byte[] bArr, int i, int i2, zzik zzik) throws IOException {
        if (this.zzi) {
            zzu(t, bArr, i, i2, zzik);
        } else {
            zzc(t, bArr, i, i2, 0, zzik);
        }
    }

    public final boolean zzi(T t, T t2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (zzB & 1048575);
            switch (zzA(zzB)) {
                case 0:
                    if (zzL(t, t2, i) && Double.doubleToLongBits(zzml.zza(t, j)) == Double.doubleToLongBits(zzml.zza(t2, j))) {
                        continue;
                    }
                case 1:
                    if (zzL(t, t2, i) && Float.floatToIntBits(zzml.zzb(t, j)) == Float.floatToIntBits(zzml.zzb(t2, j))) {
                        continue;
                    }
                case 2:
                    if (zzL(t, t2, i) && zzml.zzd(t, j) == zzml.zzd(t2, j)) {
                        continue;
                    }
                case 3:
                    if (zzL(t, t2, i) && zzml.zzd(t, j) == zzml.zzd(t2, j)) {
                        continue;
                    }
                case 4:
                    if (zzL(t, t2, i) && zzml.zzc(t, j) == zzml.zzc(t2, j)) {
                        continue;
                    }
                case 5:
                    if (zzL(t, t2, i) && zzml.zzd(t, j) == zzml.zzd(t2, j)) {
                        continue;
                    }
                case 6:
                    if (zzL(t, t2, i) && zzml.zzc(t, j) == zzml.zzc(t2, j)) {
                        continue;
                    }
                case 7:
                    if (zzL(t, t2, i) && zzml.zzw(t, j) == zzml.zzw(t2, j)) {
                        continue;
                    }
                case 8:
                    if (zzL(t, t2, i) && zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        continue;
                    }
                case 9:
                    if (zzL(t, t2, i) && zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        continue;
                    }
                case 10:
                    if (zzL(t, t2, i) && zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        continue;
                    }
                case 11:
                    if (zzL(t, t2, i) && zzml.zzc(t, j) == zzml.zzc(t2, j)) {
                        continue;
                    }
                case 12:
                    if (zzL(t, t2, i) && zzml.zzc(t, j) == zzml.zzc(t2, j)) {
                        continue;
                    }
                case 13:
                    if (zzL(t, t2, i) && zzml.zzc(t, j) == zzml.zzc(t2, j)) {
                        continue;
                    }
                case 14:
                    if (zzL(t, t2, i) && zzml.zzd(t, j) == zzml.zzd(t2, j)) {
                        continue;
                    }
                case 15:
                    if (zzL(t, t2, i) && zzml.zzc(t, j) == zzml.zzc(t2, j)) {
                        continue;
                    }
                case 16:
                    if (zzL(t, t2, i) && zzml.zzd(t, j) == zzml.zzd(t2, j)) {
                        continue;
                    }
                case 17:
                    if (zzL(t, t2, i) && zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j));
                    break;
                case 50:
                    z = zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzy = (long) (zzy(i) & 1048575);
                    if (zzml.zzc(t, zzy) == zzml.zzc(t2, zzy) && zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzc(t).equals(this.zzn.zzc(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(t);
        this.zzo.zza(t2);
        throw null;
    }

    public final boolean zzj(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzB) != 0 && !zzN(t, i6, i2, i, i10)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzP(t2, i7, i6) && !zzO(t2, zzB, zzE(i6))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzkw) zzml.zzf(t2, (long) (zzB & 1048575))).isEmpty()) {
                            zzkv zzkv = (zzkv) zzF(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzml.zzf(t2, (long) (zzB & 1048575));
                if (!list.isEmpty()) {
                    zzln zzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzE.zzj(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzN(t, i6, i2, i, i10) && !zzO(t2, zzB, zzE(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(t2);
        throw null;
    }

    public final void zzm(T t, zzjf zzjf) throws IOException {
        if (!this.zzi) {
            zzR(t, zzjf);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzf(i2, zzml.zza(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzo(i2, zzml.zzb(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzt(i2, zzml.zzd(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzJ(i2, zzml.zzd(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzr(i2, zzml.zzc(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzm(i2, zzml.zzd(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzk(i2, zzml.zzc(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzb(i2, zzml.zzw(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzT(i2, zzml.zzf(t, (long) (zzB & 1048575)), zzjf);
                            break;
                        }
                    case 9:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzv(i2, zzml.zzf(t, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 10:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzd(i2, (zzix) zzml.zzf(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzH(i2, zzml.zzc(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzi(i2, zzml.zzc(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzw(i2, zzml.zzc(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzy(i2, zzml.zzd(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzA(i2, zzml.zzc(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzC(i2, zzml.zzd(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzM(t, i)) {
                            break;
                        } else {
                            zzjf.zzq(i2, zzml.zzf(t, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 18:
                        zzlp.zzL(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 19:
                        zzlp.zzP(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 20:
                        zzlp.zzS(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 21:
                        zzlp.zzaa(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 22:
                        zzlp.zzR(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 23:
                        zzlp.zzO(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 24:
                        zzlp.zzN(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 25:
                        zzlp.zzJ(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 26:
                        zzlp.zzY(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf);
                        break;
                    case 27:
                        zzlp.zzT(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, zzE(i));
                        break;
                    case 28:
                        zzlp.zzK(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf);
                        break;
                    case 29:
                        zzlp.zzZ(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 30:
                        zzlp.zzM(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 31:
                        zzlp.zzU(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 32:
                        zzlp.zzV(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 33:
                        zzlp.zzW(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 34:
                        zzlp.zzX(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 35:
                        zzlp.zzL(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 36:
                        zzlp.zzP(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 37:
                        zzlp.zzS(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 38:
                        zzlp.zzaa(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 39:
                        zzlp.zzR(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 40:
                        zzlp.zzO(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 41:
                        zzlp.zzN(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 42:
                        zzlp.zzJ(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 43:
                        zzlp.zzZ(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 44:
                        zzlp.zzM(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 45:
                        zzlp.zzU(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 46:
                        zzlp.zzV(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 47:
                        zzlp.zzW(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 48:
                        zzlp.zzX(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 49:
                        zzlp.zzQ(this.zzc[i], (List) zzml.zzf(t, (long) (zzB & 1048575)), zzjf, zzE(i));
                        break;
                    case 50:
                        zzS(zzjf, i2, zzml.zzf(t, (long) (zzB & 1048575)), i);
                        break;
                    case 51:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzf(i2, zzn(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzo(i2, zzo(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzt(i2, zzC(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzJ(i2, zzC(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzr(i2, zzr(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzm(i2, zzC(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzk(i2, zzr(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzb(i2, zzQ(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzT(i2, zzml.zzf(t, (long) (zzB & 1048575)), zzjf);
                            break;
                        }
                    case 60:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzv(i2, zzml.zzf(t, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 61:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzd(i2, (zzix) zzml.zzf(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzH(i2, zzr(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzi(i2, zzr(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzw(i2, zzr(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzy(i2, zzC(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzA(i2, zzr(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzC(i2, zzC(t, (long) (zzB & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzP(t, i2, i)) {
                            break;
                        } else {
                            zzjf.zzq(i2, zzml.zzf(t, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                }
            }
            zzmb<?, ?> zzmb = this.zzn;
            zzmb.zzi(zzmb.zzc(t), zzjf);
        } else {
            this.zzo.zza(t);
            throw null;
        }
    }

    public final void zzg(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (1048575 & zzB);
            int i2 = this.zzc[i];
            switch (zzA(zzB)) {
                case 0:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzo(t, j, zzml.zza(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 1:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzp(t, j, zzml.zzb(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 2:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 3:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 4:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 5:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 6:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 7:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzm(t, j, zzml.zzw(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 8:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 9:
                    zzH(t, t2, i);
                    break;
                case 10:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 11:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 12:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 13:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 14:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 15:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 16:
                    if (!zzM(t2, i)) {
                        break;
                    } else {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    }
                case 17:
                    zzH(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(t, t2, j);
                    break;
                case 50:
                    zzlp.zzI(this.zzq, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzP(t2, i2, i)) {
                        break;
                    } else {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzK(t, i2, i);
                        break;
                    }
                case 60:
                    zzI(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzP(t2, i2, i)) {
                        break;
                    } else {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzK(t, i2, i);
                        break;
                    }
                case 68:
                    zzI(t, t2, i);
                    break;
            }
        }
        zzlp.zzF(this.zzn, t, t2);
        if (this.zzh) {
            zzlp.zzE(this.zzo, t, t2);
        }
    }
}
