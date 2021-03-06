// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/github/xudaojie/javase/protobuf/Person.proto

package io.github.xudaojie.javase.protobuf;

public final class Person {
  private Person() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PacketOrBuilder extends
      // @@protoc_insertion_point(interface_extends:io.github.xudaojie.javase.protobuf.Packet)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 magic_number = 1;</code>
     * @return The magicNumber.
     */
    int getMagicNumber();

    /**
     * <code>int32 version = 2;</code>
     * @return The version.
     */
    int getVersion();

    /**
     * <code>bytes body = 4;</code>
     * @return The body.
     */
    com.google.protobuf.ByteString getBody();

    public io.github.xudaojie.javase.protobuf.Person.Packet.MagicNumberPresentCase getMagicNumberPresentCase();

    public io.github.xudaojie.javase.protobuf.Person.Packet.VersionPresentCase getVersionPresentCase();
  }
  /**
   * Protobuf type {@code io.github.xudaojie.javase.protobuf.Packet}
   */
  public static final class Packet extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:io.github.xudaojie.javase.protobuf.Packet)
      PacketOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Packet.newBuilder() to construct.
    private Packet(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Packet() {
      body_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Packet();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Packet(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              magicNumberPresentCase_ = 1;
              magicNumberPresent_ = input.readInt32();
              break;
            }
            case 16: {
              versionPresentCase_ = 2;
              versionPresent_ = input.readInt32();
              break;
            }
            case 34: {

              body_ = input.readBytes();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.github.xudaojie.javase.protobuf.Person.internal_static_io_github_xudaojie_javase_protobuf_Packet_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.github.xudaojie.javase.protobuf.Person.internal_static_io_github_xudaojie_javase_protobuf_Packet_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.github.xudaojie.javase.protobuf.Person.Packet.class, io.github.xudaojie.javase.protobuf.Person.Packet.Builder.class);
    }

    private int magicNumberPresentCase_ = 0;
    private java.lang.Object magicNumberPresent_;
    public enum MagicNumberPresentCase
        implements com.google.protobuf.Internal.EnumLite,
            com.google.protobuf.AbstractMessage.InternalOneOfEnum {
      MAGIC_NUMBER(1),
      MAGICNUMBERPRESENT_NOT_SET(0);
      private final int value;
      private MagicNumberPresentCase(int value) {
        this.value = value;
      }
      /**
       * @param value The number of the enum to look for.
       * @return The enum associated with the given number.
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static MagicNumberPresentCase valueOf(int value) {
        return forNumber(value);
      }

      public static MagicNumberPresentCase forNumber(int value) {
        switch (value) {
          case 1: return MAGIC_NUMBER;
          case 0: return MAGICNUMBERPRESENT_NOT_SET;
          default: return null;
        }
      }
      public int getNumber() {
        return this.value;
      }
    };

    public MagicNumberPresentCase
    getMagicNumberPresentCase() {
      return MagicNumberPresentCase.forNumber(
          magicNumberPresentCase_);
    }

    private int versionPresentCase_ = 0;
    private java.lang.Object versionPresent_;
    public enum VersionPresentCase
        implements com.google.protobuf.Internal.EnumLite,
            com.google.protobuf.AbstractMessage.InternalOneOfEnum {
      VERSION(2),
      VERSIONPRESENT_NOT_SET(0);
      private final int value;
      private VersionPresentCase(int value) {
        this.value = value;
      }
      /**
       * @param value The number of the enum to look for.
       * @return The enum associated with the given number.
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static VersionPresentCase valueOf(int value) {
        return forNumber(value);
      }

      public static VersionPresentCase forNumber(int value) {
        switch (value) {
          case 2: return VERSION;
          case 0: return VERSIONPRESENT_NOT_SET;
          default: return null;
        }
      }
      public int getNumber() {
        return this.value;
      }
    };

    public VersionPresentCase
    getVersionPresentCase() {
      return VersionPresentCase.forNumber(
          versionPresentCase_);
    }

    public static final int MAGIC_NUMBER_FIELD_NUMBER = 1;
    /**
     * <code>int32 magic_number = 1;</code>
     * @return The magicNumber.
     */
    @java.lang.Override
    public int getMagicNumber() {
      if (magicNumberPresentCase_ == 1) {
        return (java.lang.Integer) magicNumberPresent_;
      }
      return 0;
    }

    public static final int VERSION_FIELD_NUMBER = 2;
    /**
     * <code>int32 version = 2;</code>
     * @return The version.
     */
    @java.lang.Override
    public int getVersion() {
      if (versionPresentCase_ == 2) {
        return (java.lang.Integer) versionPresent_;
      }
      return 0;
    }

    public static final int BODY_FIELD_NUMBER = 4;
    private com.google.protobuf.ByteString body_;
    /**
     * <code>bytes body = 4;</code>
     * @return The body.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getBody() {
      return body_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (magicNumberPresentCase_ == 1) {
        output.writeInt32(
            1, (int)((java.lang.Integer) magicNumberPresent_));
      }
      if (versionPresentCase_ == 2) {
        output.writeInt32(
            2, (int)((java.lang.Integer) versionPresent_));
      }
      if (!body_.isEmpty()) {
        output.writeBytes(4, body_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (magicNumberPresentCase_ == 1) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(
              1, (int)((java.lang.Integer) magicNumberPresent_));
      }
      if (versionPresentCase_ == 2) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(
              2, (int)((java.lang.Integer) versionPresent_));
      }
      if (!body_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, body_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof io.github.xudaojie.javase.protobuf.Person.Packet)) {
        return super.equals(obj);
      }
      io.github.xudaojie.javase.protobuf.Person.Packet other = (io.github.xudaojie.javase.protobuf.Person.Packet) obj;

      if (!getBody()
          .equals(other.getBody())) return false;
      if (!getMagicNumberPresentCase().equals(other.getMagicNumberPresentCase())) return false;
      switch (magicNumberPresentCase_) {
        case 1:
          if (getMagicNumber()
              != other.getMagicNumber()) return false;
          break;
        case 0:
        default:
      }
      if (!getVersionPresentCase().equals(other.getVersionPresentCase())) return false;
      switch (versionPresentCase_) {
        case 2:
          if (getVersion()
              != other.getVersion()) return false;
          break;
        case 0:
        default:
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + BODY_FIELD_NUMBER;
      hash = (53 * hash) + getBody().hashCode();
      switch (magicNumberPresentCase_) {
        case 1:
          hash = (37 * hash) + MAGIC_NUMBER_FIELD_NUMBER;
          hash = (53 * hash) + getMagicNumber();
          break;
        case 0:
        default:
      }
      switch (versionPresentCase_) {
        case 2:
          hash = (37 * hash) + VERSION_FIELD_NUMBER;
          hash = (53 * hash) + getVersion();
          break;
        case 0:
        default:
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.github.xudaojie.javase.protobuf.Person.Packet parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(io.github.xudaojie.javase.protobuf.Person.Packet prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code io.github.xudaojie.javase.protobuf.Packet}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:io.github.xudaojie.javase.protobuf.Packet)
        io.github.xudaojie.javase.protobuf.Person.PacketOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return io.github.xudaojie.javase.protobuf.Person.internal_static_io_github_xudaojie_javase_protobuf_Packet_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return io.github.xudaojie.javase.protobuf.Person.internal_static_io_github_xudaojie_javase_protobuf_Packet_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                io.github.xudaojie.javase.protobuf.Person.Packet.class, io.github.xudaojie.javase.protobuf.Person.Packet.Builder.class);
      }

      // Construct using io.github.xudaojie.javase.protobuf.Person.Packet.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        body_ = com.google.protobuf.ByteString.EMPTY;

        magicNumberPresentCase_ = 0;
        magicNumberPresent_ = null;
        versionPresentCase_ = 0;
        versionPresent_ = null;
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return io.github.xudaojie.javase.protobuf.Person.internal_static_io_github_xudaojie_javase_protobuf_Packet_descriptor;
      }

      @java.lang.Override
      public io.github.xudaojie.javase.protobuf.Person.Packet getDefaultInstanceForType() {
        return io.github.xudaojie.javase.protobuf.Person.Packet.getDefaultInstance();
      }

      @java.lang.Override
      public io.github.xudaojie.javase.protobuf.Person.Packet build() {
        io.github.xudaojie.javase.protobuf.Person.Packet result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public io.github.xudaojie.javase.protobuf.Person.Packet buildPartial() {
        io.github.xudaojie.javase.protobuf.Person.Packet result = new io.github.xudaojie.javase.protobuf.Person.Packet(this);
        if (magicNumberPresentCase_ == 1) {
          result.magicNumberPresent_ = magicNumberPresent_;
        }
        if (versionPresentCase_ == 2) {
          result.versionPresent_ = versionPresent_;
        }
        result.body_ = body_;
        result.magicNumberPresentCase_ = magicNumberPresentCase_;
        result.versionPresentCase_ = versionPresentCase_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof io.github.xudaojie.javase.protobuf.Person.Packet) {
          return mergeFrom((io.github.xudaojie.javase.protobuf.Person.Packet)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(io.github.xudaojie.javase.protobuf.Person.Packet other) {
        if (other == io.github.xudaojie.javase.protobuf.Person.Packet.getDefaultInstance()) return this;
        if (other.getBody() != com.google.protobuf.ByteString.EMPTY) {
          setBody(other.getBody());
        }
        switch (other.getMagicNumberPresentCase()) {
          case MAGIC_NUMBER: {
            setMagicNumber(other.getMagicNumber());
            break;
          }
          case MAGICNUMBERPRESENT_NOT_SET: {
            break;
          }
        }
        switch (other.getVersionPresentCase()) {
          case VERSION: {
            setVersion(other.getVersion());
            break;
          }
          case VERSIONPRESENT_NOT_SET: {
            break;
          }
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        io.github.xudaojie.javase.protobuf.Person.Packet parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (io.github.xudaojie.javase.protobuf.Person.Packet) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int magicNumberPresentCase_ = 0;
      private java.lang.Object magicNumberPresent_;
      public MagicNumberPresentCase
          getMagicNumberPresentCase() {
        return MagicNumberPresentCase.forNumber(
            magicNumberPresentCase_);
      }

      public Builder clearMagicNumberPresent() {
        magicNumberPresentCase_ = 0;
        magicNumberPresent_ = null;
        onChanged();
        return this;
      }

      private int versionPresentCase_ = 0;
      private java.lang.Object versionPresent_;
      public VersionPresentCase
          getVersionPresentCase() {
        return VersionPresentCase.forNumber(
            versionPresentCase_);
      }

      public Builder clearVersionPresent() {
        versionPresentCase_ = 0;
        versionPresent_ = null;
        onChanged();
        return this;
      }


      /**
       * <code>int32 magic_number = 1;</code>
       * @return The magicNumber.
       */
      public int getMagicNumber() {
        if (magicNumberPresentCase_ == 1) {
          return (java.lang.Integer) magicNumberPresent_;
        }
        return 0;
      }
      /**
       * <code>int32 magic_number = 1;</code>
       * @param value The magicNumber to set.
       * @return This builder for chaining.
       */
      public Builder setMagicNumber(int value) {
        magicNumberPresentCase_ = 1;
        magicNumberPresent_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 magic_number = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMagicNumber() {
        if (magicNumberPresentCase_ == 1) {
          magicNumberPresentCase_ = 0;
          magicNumberPresent_ = null;
          onChanged();
        }
        return this;
      }

      /**
       * <code>int32 version = 2;</code>
       * @return The version.
       */
      public int getVersion() {
        if (versionPresentCase_ == 2) {
          return (java.lang.Integer) versionPresent_;
        }
        return 0;
      }
      /**
       * <code>int32 version = 2;</code>
       * @param value The version to set.
       * @return This builder for chaining.
       */
      public Builder setVersion(int value) {
        versionPresentCase_ = 2;
        versionPresent_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 version = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearVersion() {
        if (versionPresentCase_ == 2) {
          versionPresentCase_ = 0;
          versionPresent_ = null;
          onChanged();
        }
        return this;
      }

      private com.google.protobuf.ByteString body_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes body = 4;</code>
       * @return The body.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getBody() {
        return body_;
      }
      /**
       * <code>bytes body = 4;</code>
       * @param value The body to set.
       * @return This builder for chaining.
       */
      public Builder setBody(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        body_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes body = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearBody() {
        
        body_ = getDefaultInstance().getBody();
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:io.github.xudaojie.javase.protobuf.Packet)
    }

    // @@protoc_insertion_point(class_scope:io.github.xudaojie.javase.protobuf.Packet)
    private static final io.github.xudaojie.javase.protobuf.Person.Packet DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new io.github.xudaojie.javase.protobuf.Person.Packet();
    }

    public static io.github.xudaojie.javase.protobuf.Person.Packet getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Packet>
        PARSER = new com.google.protobuf.AbstractParser<Packet>() {
      @java.lang.Override
      public Packet parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Packet(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Packet> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Packet> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public io.github.xudaojie.javase.protobuf.Person.Packet getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_github_xudaojie_javase_protobuf_Packet_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_github_xudaojie_javase_protobuf_Packet_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n/io/github/xudaojie/javase/protobuf/Per" +
      "son.proto\022\"io.github.xudaojie.javase.pro" +
      "tobuf\"l\n\006Packet\022\026\n\014magic_number\030\001 \001(\005H\000\022" +
      "\021\n\007version\030\002 \001(\005H\001\022\014\n\004body\030\004 \001(\014B\026\n\024magi" +
      "c_number_presentB\021\n\017version_presentB$\n\"i" +
      "o.github.xudaojie.javase.protobufb\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_io_github_xudaojie_javase_protobuf_Packet_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_github_xudaojie_javase_protobuf_Packet_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_github_xudaojie_javase_protobuf_Packet_descriptor,
        new java.lang.String[] { "MagicNumber", "Version", "Body", "MagicNumberPresent", "VersionPresent", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
